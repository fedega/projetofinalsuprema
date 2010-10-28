//PanelFilter class @0-AD39AA84
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


public class PanelFilter implements Filter {

    private FilterConfig config;
    //private ICache cache = null;
    
    public void init(FilterConfig config) throws ServletException {
            this.config = config;
/*
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
*/
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {


		//chain.doFilter(req, resp);


//System.out.println("=================Filter[begin]=================");


        ByteResponseWrapper wrappedResponse = new ByteResponseWrapper((HttpServletResponse) resp);
        chain.doFilter(req, wrappedResponse);

        byte[] content = wrappedResponse.getContentBytes();
        String encoding = wrappedResponse.getCharacterEncoding();

        if (content == null) {
            content = new byte[0];
        }
        if (encoding == null) {
            encoding = "ISO-8859-1";
        }

        ServletOutputStream sos = resp.getOutputStream();

		StringBuffer sb = new StringBuffer();
		


		for (int i = 0; i < content.length; i++) {
			//System.out.print((char)content[i]);
			sb.append((char)content[i]);
		}

		String panelName = ""+req.getAttribute(com.codecharge.Names.CCS_UPDATE_PANEL_FILTER);
		if (req.getAttribute(com.codecharge.Names.CCS_UPDATE_PANEL_FILTER) == null) {
			panelName = null;
		}

		String beginMarker = "<!--Panel["+panelName+"][begin]-->";
		String endMarker = "<!--Panel["+panelName+"][end]-->";

		int i = sb.indexOf(beginMarker);
		int j = sb.indexOf(endMarker);

		if (i >= 0 && j >=0) {
//System.out.println(sb.substring( i+beginMarker.length(), j ));
			String outResult = sb.substring( i+beginMarker.length(), j );
			//outResult = outResult.replaceAll("callbackControl=Panel1UpdatePanel1", "");
			//outResult = outResult.replaceAll("callbackControl=Panel1UpdatePanel1", "");

//System.out.println(outResult);

			sos.write(outResult.getBytes());
		} else {
			sos.write(content);
		}

		//sos.write("<!--begin-->".getBytes());
        //sos.write(content);
		//sos.write("<!--end-->".getBytes());



//System.out.println("=================Filter[end]=================");



/*

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

*/

    }

    public void destroy() {
        // TODO Auto-generated method stub
    }
    
}


//End PanelFilter class

