//ByteResponseStream class @0-5E74FF87
/*
 * $Revision: 1.3 $
 * $Date: 2004/12/08 16:49:57 $
 */
package com.codecharge.util.filters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;


public class ByteResponseStream extends ServletOutputStream {

    protected ByteArrayOutputStream baos;
    protected boolean closed;
    protected byte[] contentBytes;
    /**
     * 
     */
    public ByteResponseStream() throws IOException {
        super();
        this.baos = new ByteArrayOutputStream();
    }
    
    /**
     * @see java.io.OutputStream#write(int)
     */
    public void write(int b) throws IOException {
        if (closed) {
            throw new IOException("Unable to write to a closed stream.");
        }
        baos.write(b);
    }

    public void write(byte[] b) throws IOException {
        if (closed) {
            throw new IOException("Unable to write to a closed stream.");
        }
        baos.write(b, 0, b.length);
    }

    public void close() throws IOException {
        if (closed) {
            throw new IOException("Output stream has already closed.");
        }
        baos.close();
        contentBytes = baos.toByteArray();
        closed = true;
    }
    
    public byte[] getContentBytes() {
        return contentBytes;
    }
}


//End ByteResponseStream class

