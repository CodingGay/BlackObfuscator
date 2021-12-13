package org.jf.baksmali;



import org.jf.baksmali.Adaptors.ClassDefinition;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.util.IndentingWriter;

import java.io.IOException;
import java.io.Writer;

public class Baksmali {

    @SuppressWarnings("InfiniteRecursion")
    public static void disassembleClass(StringBuilder stringBuilder, ClassDef classDef, BaksmaliOptions options) throws IOException {
        disassembleClass(new StringWriter(stringBuilder), classDef, options);
    }

    public static void disassembleClass(Writer writer, ClassDef classDef, BaksmaliOptions options) throws IOException {
        ClassDefinition classDefinition = new ClassDefinition(options, classDef);
        if (writer instanceof IndentingWriter)
            classDefinition.writeTo((IndentingWriter) writer);
        else
            classDefinition.writeTo(new IndentingWriter(writer));
    }

    private static class StringWriter extends Writer {
        final StringBuilder sb;

        private StringWriter(StringBuilder sb) {
            this.sb = sb;
        }

        @Override
        public void write(char[] buf, int off, int len) {
            sb.append(buf, off, len);
        }

        @Override
        public void flush() {

        }

        @Override
        public void close() {

        }
    }
}
