package org.jf.smali;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.writer.builder.DexBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class Smali {

    public static ClassDef assembleSmaliFile(File smaliFile, DexBuilder dexBuilder, SmaliOptions options)
            throws RecognitionException, IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(smaliFile);
            InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
            return assembleSmaliFile(reader, smaliFile.getPath(), dexBuilder, options);
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static ClassDef assembleSmaliFile(String src, DexBuilder dexBuilder, SmaliOptions options)
            throws RecognitionException {
        return assembleSmaliFile(new StringReader(src), null, dexBuilder, options);
    }

    public static ClassDef assembleSmaliFile(Reader reader, String fileName, DexBuilder dexBuilder, SmaliOptions options)
            throws RecognitionException {
        smaliFlexLexer lexer = new smaliFlexLexer(reader);
        lexer.setSourceName(fileName);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SmaliCatchParser parser = new SmaliCatchParser(tokens);
        parser.setVerboseErrors(options.verboseErrors);
        parser.setAllowOdex(options.allowOdexOpcodes);
        parser.setApiLevel(options.apiLevel);

        smaliParser.smali_file_return result = parser.smali_file();

        if (parser.getNumberOfSyntaxErrors() > 0 || lexer.getNumberOfSyntaxErrors() > 0) {
            RecognitionException exception = parser.getFirstException();
            if (exception == null)
                exception = lexer.getFirstException();
            if (exception != null)
                throw exception;
            return null;
        }
        CommonTree t = result.getTree();

        CommonTreeNodeStream treeStream = new CommonTreeNodeStream(t);
        treeStream.setTokenStream(tokens);

        SmaliCatchTreeWalker dexGen = new SmaliCatchTreeWalker(treeStream);
        dexGen.setApiLevel(options.apiLevel);

        dexGen.setVerboseErrors(options.verboseErrors);
        dexGen.setDexBuilder(dexBuilder);
        ClassDef classDef = dexGen.smali_file();

        if (dexGen.getNumberOfSyntaxErrors() > 0) {
            RecognitionException exception = dexGen.getFirstException();
            if (exception != null)
                throw exception;
            return null;
        }
        return classDef;
    }

}
