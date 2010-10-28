//ByteResponseWrapper class @0-2443852E
/*
 * $Revision: 1.4 $
 * $Date: 2004/12/21 14:06:59 $
 */
package com.codecharge.util.filters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


public class ByteResponseWrapper extends HttpServletResponseWrapper {

    protected ServletOutputStream stream = null;
    protected CharArrayWriter output = null;
    protected PrintWriter writer = null;
    protected HttpServletResponse response;
    protected boolean frozenContentType;
    /**
     * @param response
     */
    public ByteResponseWrapper(HttpServletResponse response) {
        super(response);
        this.response = response;
        this.output = new CharArrayWriter();
    }
    
    public ServletOutputStream getOutputStream() throws IOException {
        if (this.writer != null) {
            throw new IllegalStateException("getWriter() has already been called.");
        }
        if (this.stream == null) {
            this.stream = new ByteResponseStream();
        }
        return this.stream;
    }
    
    public PrintWriter getWriter() throws IOException {
        if (this.stream != null) {
            throw new IllegalStateException("getOutputStream() has already been called.");
        }
        if (this.writer == null) {
            return this.writer = new PrintWriter(this.output);
        }
        return this.writer;
    }
    
    public void close() throws IOException {
        if (this.writer != null) {
            this.writer.close();
        }
        if (this.stream != null) {
            this.stream.close();
        }
        output.close();
    }
    
    public byte[] getContentBytes() {
        if (this.writer != null) {
            //TODO: codepage???
            return this.output.toString().getBytes();
        }
        if (this.stream != null) {
            return ((ByteResponseStream) this.stream).getContentBytes();
        }
        return null;
    }
    
    
    public void setContentType(String type) {
        if (! this.frozenContentType) {
            this.response.setContentType(type);
        }
    }
    public void setFreezeContentType(boolean flag) {
        this.frozenContentType = flag;
    }
}



//End ByteResponseWrapper class

