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

@BaseCmd.Syntax(cmd = "d2j-black-obfuscator", syntax = "[options] <file0> [file1 ... fileN]", desc = "convert dex to jar")
public class BlackObfuscatorCmd extends BaseCmd {

    public static void main(String... args) {
        new BlackObfuscatorCmd().doMain(args);
    }

    @Opt(opt = "e", longOpt = "exception-file", description = "detail exception file, default is $current_dir/[file-name]-error.zip", argName = "file")
    private Path exceptionFile;
    @Opt(opt = "f", longOpt = "force", hasArg = false, description = "force overwrite")
    private boolean forceOverwrite = false;
    @Opt(opt = "n", longOpt = "not-handle-exception", hasArg = false, description = "not handle any exceptions thrown by dex2jar")
    private boolean notHandleException = false;
    @Opt(opt = "o", longOpt = "output", description = "output .jar file, default is $current_dir/[file-name]-dex2jar.jar", argName = "out-jar-file")
    private Path output;

    @Opt(opt = "r", longOpt = "reuse-reg", hasArg = false, description = "reuse register while generate java .class file")
    private boolean reuseReg = false;

    @Opt(opt = "s", hasArg = false, description = "same with --topological-sort/-ts")
    private boolean topologicalSort1 = false;

    @Opt(opt = "ts", longOpt = "topological-sort", hasArg = false, description = "sort block by topological, that will generate more readable code, default enabled")
    private boolean topologicalSort = false;

    @Opt(opt = "d", longOpt = "debug-info", hasArg = false, description = "translate debug info")
    private boolean debugInfo = false;

    @Opt(opt = "p", longOpt = "print-ir", hasArg = false, description = "print ir to System.out")
    private boolean printIR = false;

    @Opt(opt = "os", longOpt = "optmize-synchronized", hasArg = false, description = "optimize-synchronized")
    private boolean optmizeSynchronized = false;

    @Opt(longOpt = "skip-exceptions", hasArg = false, description = "skip-exceptions")
    private boolean skipExceptions = false;

    @Opt(opt = "nc", longOpt = "no-code", hasArg = false, description = "")
    private boolean noCode = false;

    public BlackObfuscatorCmd() {
    }

    @Override
    protected void doCommandLine() throws Exception {
        // todo
        try {
            // 1.dex2jar
            new Dex2jarCmd(new ObfuscatorConfiguration() {
                @Override
                protected int getObfDepth() {
                    return super.getObfDepth();
                }

                @Override
                protected boolean accept(String className, String methodName) {
                    return true;
                }
            }).doMain("-f", "inputDex");
            // 2.jar2dex
            new Jar2Dex().doMain("-f", "inputJar");
            // 3.fix dex
            DexLib2Utils.saveDex(new File("inputDex"),
                    new File("outputDex"));
            // 4.delete tmp file
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
