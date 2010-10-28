//CacheEvent class @0-0F39E3F2
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.cache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CacheEvent {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PageSettings pageSettings;
    private int cacheOperation;
    
    public CacheEvent(HttpServletRequest request, HttpServletResponse response, PageSettings pageSettings) {
        this.request = request;
        this.response = response;
        this.pageSettings = pageSettings;
    }
    
    public PageSettings getPageSettings() {
        return pageSettings;
    }
    public HttpServletRequest getRequest() {
        return request;
    }
    public HttpServletResponse getResponse() {
        return response;
    }
    public int getCacheOperation() {
        return cacheOperation;
    }
    public void setCacheOperation(int cacheOperation) {
        if (! (cacheOperation == ICache.OPERATION_CLEAR || cacheOperation == ICache.OPERATION_DISABLE
                ||  cacheOperation == ICache.OPERATION_GET ||  cacheOperation == ICache.OPERATION_PUT)) {
            throw new IllegalArgumentException("Parameter 'cacheOperation' can be OPERATION_CLEAR," +
                    " OPERATION_DISABLE, OPERATION_GET, OPERATION_PUT only.");
        }
        this.cacheOperation = cacheOperation;
    }
}


//End CacheEvent class

