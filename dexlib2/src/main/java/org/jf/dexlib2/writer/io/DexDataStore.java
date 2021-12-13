package org.jf.dexlib2.writer.io;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface DexDataStore {

    OutputStream outputAt(int offset);


    InputStream readAt(int offset);

    void close() throws IOException;
}
