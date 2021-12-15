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

import com.googlecode.d2j.dex.Dex2jar;
import com.googlecode.d2j.reader.BaseDexFileReader;
import com.googlecode.d2j.reader.DexFileReader;
import com.googlecode.d2j.reader.MultiDexFileReader;
import com.googlecode.dex2jar.ir.ET;
import org.jf.DexLib2Utils;
import top.niunaijun.obfuscator.ObfuscatorConfiguration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@BaseCmd.Syntax(cmd = "d2j-black-obfuscator", syntax = "[options] <file0> [file1 ... fileN]", desc = "convert dex to jar")
public class BlackObfuscatorCmd extends BaseCmd {

    public static void main(String... args) {
        new BlackObfuscatorCmd().doMain(args);
    }

    @Opt(opt = "d", longOpt = "depth", description = "混淆深度")
    private int depth;

    @Opt(opt = "i", longOpt = "input", description = "源Dex地址")
    private Path input;

    @Opt(opt = "o", longOpt = "output", description = "混淆生成的Dex保存的位置")
    private Path output;

    @Opt(opt = "p", longOpt = "package", description = "要处理的包名,简单过滤")
    private String pkg;

//    todo
//    @Opt(opt = "a",longOpt = "allow",description = "要处理的类以及方法的txt文件")
//    private Path allowList;
//
//    @Opt(opt = "d",longOpt = "disallow",description = "不处理的类以及方法的txt文件")
//    private Path disallowList;

    public BlackObfuscatorCmd() {
    }

    @Override
    protected void doCommandLine() throws Exception {

        try {
            input = input.toAbsolutePath();

            if (output == null) {
                output = Paths.get("./", "obf.dex");
            }

            output = output.toAbsolutePath();

            Path tempJar = Paths.get(output.getParent().toString(), System.currentTimeMillis() + "obf.jar");
            Path tempDex = Paths.get(output.getParent().toString(), System.currentTimeMillis() + "obf.dex");


            // 先分离用户的白名单
//            DexLib2Utils.splitDex(in, out, whileList);
            // 处理分离出来的dex，accept直接true即可
            // 处理完后，混淆dex与原始dex合并。
//            DexLib2Utils.mergerAndCoverDexFile(原始dex, 混淆后的dex, 输出)

//             1.dex2jar
            new Dex2jarCmd(new ObfuscatorConfiguration() {
                @Override
                protected int getObfDepth() {
                    return depth;
                }

                @Override
                protected boolean accept(String className, String methodName) {
                    return className.startsWith(pkg);
                }

            }).doMain("-f", input.toString(), "-o", tempJar.toString());

//             2.jar2dex
            new Jar2Dex().doMain("-f", "-o", tempDex.toString(), tempJar.toString());
//             3.fix dex
            DexLib2Utils.saveDex(new File(tempDex.toString()),
                    new File(output.toString()));

//             4.delete tmp file
            tempJar.toFile().delete();
            tempDex.toFile().delete();

        } catch (Throwable t) {
            t.printStackTrace();
            // todo
        }
    }

    @Override
    protected String getVersionString() {
        return "BlackObfuscatorCmd-" + DexFileReader.class.getPackage().getImplementationVersion() + ", translator-"
                + Dex2jar.class.getPackage().getImplementationVersion() + ", ir-"
                + ET.class.getPackage().getImplementationVersion();
    }
}
