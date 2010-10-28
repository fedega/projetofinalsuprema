//CacheFilter class @0-203CCFB6
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.filters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codecharge.Action;
import com.codecharge.Names;
import com.codecharge.util.StringUtils;
import com.codecharge.util.LocaleChooser;
import com.codecharge.util.StyleChooser;
import com.codecharge.util.cache.CacheEvent;
import com.codecharge.util.cache.CachingParameter;
import com.codecharge.util.cache.ICache;
import com.codecharge.util.cache.PageSettings;


public class CacheFilter implements Filter {

    private FilterConfig config;
    private ICache cache = null;
    
    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
            this.config = config;
            String cacheClassName = config.getInitParameter("cacheClassName");
            if (StringUtils.isEmpty(cacheClassName)) {
                cacheClassName = "com.codecharge.util.cache.DbCache";
            }
            try {
                Class cacheClass = Class.forName(cacheClassName);
                this.cache = (ICache) cacheClass.newInstance();
                config.getServletContext().setAttribute(Names.CACHE_INSTANCE, cache);
            } catch (ClassNotFoundException cnfe) {
            } catch (InstantiationException ie) {
            } catch (IllegalAccessException iae) {
            } finally {
            }
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        String pageName = ((HttpServletRequest) req).getServletPath();

        String cached = Action.getCachedPage(pageName, req, resp);
        String cacheKey = this.cache.getCacheKey(pageName, req);
        String encCacheKey = this.cache.getCacheKey(pageName+"~encoding~", req);
        if (cached != null) {
            String encoding = (String) this.cache.getObject(encCacheKey);
            try {
                byte[] test = "test".getBytes(encoding);
            } catch (UnsupportedEncodingException e) {
                encoding = "ISO-8859-1";
            }
            PrintWriter out = new PrintWriter(new OutputStreamWriter( resp.getOutputStream(), encoding));
            out.println(cached);
            out.close();
            return;
        }        
        
        ByteResponseWrapper wrappedResponse = new ByteResponseWrapper((HttpServletResponse) resp);
        chain.doFilter(req, wrappedResponse);
        
        byte[] content = wrappedResponse.getContentBytes();
        String encoding = wrappedResponse.getCharacterEncoding();
        
        PageSettings pageSettings = Action.getCachingSettings(pageName);
        boolean enabled = false;
        if (pageSettings != null) {
            CacheEvent cacheEvent = new CacheEvent(((HttpServletRequest) req), ((HttpServletResponse) resp), pageSettings);
            cacheEvent.setCacheOperation(ICache.OPERATION_PUT);
            pageSettings.fireOnCacheEvent(cacheEvent);
            enabled = Action.isCachingEnabled(pageSettings, req, resp, Action.getCacheInstance());
        }
        
        if (content == null) {
            content = new byte[0];
        }
        if (encoding == null) {
            encoding = "ISO-8859-1";
        }
        
        if (enabled) {
            if (pageSettings != null) {
                this.cache.putObject(cacheKey, new String(content, encoding), pageSettings.getDuration());
                this.cache.putObject(encCacheKey, encoding, pageSettings.getDuration());
            }
        } else {
            this.cache.clearStartedWith(cacheKey);
            this.cache.clearStartedWith(encCacheKey);
        }
        
        ServletOutputStream sos = resp.getOutputStream();
        sos.write(content);
    }

    /*private String getParametersKey(PageSettings pageSettings, String encoding, HttpServletRequest request) 
            throws IOException {
        StringBuffer sb = new StringBuffer();
        if (pageSettings != null) {
            Iterator params = pageSettings.getKeyParameters();
            boolean first = true;
            while (params.hasNext()) {
                CachingParameter param = (CachingParameter) params.next();
                if (!first) {
                    sb.append("&");
                }
                try {
                    String[] values = param.getValues();
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            if (! StringUtils.isEmpty(values[i])) {
                                if (i > 0) {
                                    sb.append("&");
                                }
                                sb.append(URLEncoder
                                        .encode(param.getName() + "=" + values[i], encoding));
                            }
                        }
                        if (first) {
                            first = false;
                        }
                    }
                } catch (UnsupportedEncodingException uee) {
                }
            }
        }
        //add fixed CCS parameters LocaleID & Style
        String localeParameter = LocaleChooser.getLocaleParameter(request);
        if (! StringUtils.isEmpty(localeParameter)) {
            sb.append("&" + localeParameter);
        }
        String ccsStyle = StyleChooser.getStyleParameter(request);
        if (! StringUtils.isEmpty(ccsStyle)) {
            sb.append("&" + ccsStyle);
        }
        return sb.toString();
    }*/
    
    private void toLog(FileOutputStream fos, String value) throws IOException {
        fos.write(value.getBytes());
    }
    
    /**
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub

    }
    
    private String getQueryString(HttpServletRequest req, PageSettings pageSettings) {
        return req.getQueryString();
    }
}


//End CacheFilter class

