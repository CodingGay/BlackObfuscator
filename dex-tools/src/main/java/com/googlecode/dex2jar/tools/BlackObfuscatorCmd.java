/*
 * dex2jar - Tools to work with android .dex and java .class files
 * Copyright (c) 2009-2012 Panxiaobo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.dex2jar.tools;

import com.android.dex.util.FileUtils;
import com.googlecode.d2j.dex.Dex2jar;
import com.googlecode.d2j.reader.DexFileReader;
import com.googlecode.dex2jar.ir.ET;
import org.jf.DexLib2Utils;
import top.niunaijun.obfuscator.ObfuscatorConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@BaseCmd.Syntax(cmd = "d2j-black-obfuscator", syntax = "[options] <file0> [file1 ... fileN]", desc = "convert dex to jar")
public class BlackObfuscatorCmd extends BaseCmd {

    public static void main(String... args) {
        new BlackObfuscatorCmd().doMain(args);
    }

    @Opt(opt = "d", longOpt = "depth", description = "Obfuscator Depth")
    private int depth;

    @Opt(opt = "i", longOpt = "input", description = "Origin Dex File")
    private Path input;

    @Opt(opt = "o", longOpt = "output", description = "Target Dex Path")
    private Path output;

    @Opt(opt = "p", longOpt = "package", description = "Package Name,Simple Filter")
    private String pkg;

    @Opt(opt = "a", longOpt = "allow", description = "Allow List File Path")
    private Path allowList;

    /**
     * whileList
     */
    private final List<String> whileList = new ArrayList<>();

    /**
     * blackList
     */
    private final List<String> blackList = new ArrayList<>();

    public BlackObfuscatorCmd() {
    }

    @Override
    protected void doCommandLine() throws Exception {
        File tempJar = null;
        File splitDex = null;
        File obfDex = null;
        try {
            if (remainingArgs.length == 0) {
                usage();
                return;
            }
            if (input == null) {
                usage();
                return;
            }
            checkFilter();
            checkInput();

            input = input.toAbsolutePath();

            if (output == null) {
                output = Paths.get("./", "obf.dex");
            }

            output = output.toAbsolutePath();

            tempJar = Paths.get(output.getParent().toString(), System.currentTimeMillis() + "obf.jar").toFile();
            splitDex = Paths.get(output.getParent().toString(), System.currentTimeMillis() + "split.dex").toFile();
            obfDex = Paths.get(output.getParent().toString(), System.currentTimeMillis() + "obf.dex").toFile();

            File finalTempJar = tempJar;
            File finalSplitDex = splitDex;
            File finalObfDex = obfDex;
            Runtime.getRuntime().addShutdownHook(new Thread(() -> deleteFile(finalTempJar, finalSplitDex, finalObfDex)));

            long l = DexLib2Utils.splitDex(input.toFile(), splitDex, whileList, blackList);
            if (l <= 0) {
                System.out.println("No classes found");
                return;
            }

            new Dex2jarCmd(new ObfuscatorConfiguration() {
                @Override
                public int getObfDepth() {
                    return depth;
                }

            }).doMain("-f", splitDex.getPath(), "-o", tempJar.toString());
            new Jar2Dex().doMain("-f", "-o", obfDex.toString(), tempJar.toString());
            DexLib2Utils.mergerAndCoverDexFile(input.toFile(), obfDex, output.toFile());
            System.out.println("BlackObfuscator Out =====> " + output.toString());
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            deleteFile(tempJar, splitDex, obfDex);
        }
    }

    @Override
    protected String getVersionString() {
        return "BlackObfuscatorCmd-" + DexFileReader.class.getPackage().getImplementationVersion() + ", translator-"
                + Dex2jar.class.getPackage().getImplementationVersion() + ", ir-"
                + ET.class.getPackage().getImplementationVersion();
    }

    /**
     * check filter params
     *
     * @throws IOException input too many params
     */
    private void checkFilter() throws IOException {
        int level = 0;

        if (pkg != null) {
            whileList.add(pkg);
            level++;
        }

        if (allowList != null) {
            dealAllowList();
            level++;
        }

        if (level > 1) {
            throw new IOException("-p and -a Can't be at the same time");
        }
    }

    /**
     * check origin dex exists
     *
     * @throws IOException dex no exists
     */
    private void checkInput() throws IOException {
        if (!input.toFile().exists()) {
            throw new IOException("Origin Dex not exists");
        }
    }


    private void dealAllowList() {
        if (!allowList.toFile().exists()) {
            System.out.println("Allow Rule File Not Exists");
            return;
        }

        String allowRule = new String(FileUtils.readFile(allowList.toFile()));

        for (String rule : allowRule.split("\n")) {
            rule = rule.trim();
            if (rule.startsWith("#") || rule.isEmpty())
                continue;
            else if (rule.startsWith("!"))
                blackList.add(rule.replaceFirst("!", ""));
            else
                whileList.add(rule);
        }
    }

    private void deleteFile(File... files) {
        for (File file : files) {
            if (file != null) {
                file.delete();
            }
        }
    }
}
