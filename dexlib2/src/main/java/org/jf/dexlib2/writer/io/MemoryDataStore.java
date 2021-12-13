package org.jf.dexlib2.writer.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class MemoryDataStore implements DexDataStore, Closeable {
    private byte[] buf;
    private int length = 0;

    public MemoryDataStore() {
        this(1024 * 1024);
    }

    public MemoryDataStore(int initialCapacity) {
        buf = new byte[initialCapacity];
    }

    public byte[] getBufferData() {
        return buf;
    }

    public int getSize() {
        return length;
    }

    @Override
    public OutputStream outputAt(final int offset) {
        return new OutputStream() {
            private int position = offset;

            @Override
            public void write(int b) throws IOException {
                growBufferIfNeeded(position);
                buf[position++] = (byte) b;
                if (position > length)
                    length = position;
            }

            @Override
            public void write(byte[] b) throws IOException {
                growBufferIfNeeded(position + b.length);
                System.arraycopy(b, 0, buf, position, b.length);
                position += b.length;
                if (position > length)
                    length = position;
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                growBufferIfNeeded(position + len);
                System.arraycopy(b, off, buf, position, len);
                position += len;
                if (position > length)
                    length = position;
            }
        };
    }

    private void growBufferIfNeeded(int index) {
        if (index < buf.length) {
            return;
        }
        buf = Arrays.copyOf(buf, (int) ((index + 1) * 1.2));
    }

    @Override
    public InputStream readAt(final int offset) {
        return new InputStream() {
            private int position = offset;

            @Override
            public int read() throws IOException {
                if (position >= length) {
                    return -1;
                }
                return buf[position++];
            }

            @Override
            public int read(byte[] b) throws IOException {
                int readLength = Math.min(b.length, length - position);
                if (readLength <= 0) {
                    if (position >= length) {
                        return -1;
                    }
                    return 0;
                }
                System.arraycopy(buf, position, b, 0, readLength);
                position += readLength;
                return readLength;
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                int readLength = Math.min(len, length - position);
                if (readLength <= 0) {
                    if (position >= length) {
                        return -1;
                    }
                    return 0;
                }
                System.arraycopy(buf, position, b, 0, readLength);
                position += readLength;
                return readLength;
            }

            @Override
            public long skip(long n) throws IOException {
                int skipLength = (int) Math.min(n, length - position);
                position += skipLength;
                return skipLength;
            }

            @Override
            public int available() throws IOException {
                return length - position;
            }
        };
    }

    @Override
    public void close() throws IOException {
        // no-op
    }
}
