//CacheAdapter class @0-C04AFF16
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.cache;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import com.codecharge.Action;
import com.codecharge.db.ParameterSource;
import com.codecharge.util.CCLogger;
import com.codecharge.util.StringUtils;
import com.codecharge.util.LocaleChooser;
import com.codecharge.util.StyleChooser;
import com.codecharge.util.Utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

abstract public class CacheAdapter implements ICache {

    protected static final CCLogger logger = CCLogger.getInstance();
    
    /*
     * ICache implemented methods
     */
    abstract public void init();

    public void finalize() {
        //do nothing
    }
    
    protected String getParametersKey(PageSettings pageSettings, String encoding, HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        logger.debug("Cache Page Settings: "+pageSettings);
        if (pageSettings != null) {
            Iterator params = pageSettings.getKeyParameters();
            while (params.hasNext()) {
                CachingParameter param = (CachingParameter) params.next();
                logger.debug("Process parameter: "+param);
                try {
                    String[] values = Action.getCachingParameterValues(param, request);
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            if (! StringUtils.isEmpty(values[i])) {
                                sb.append("&" + URLEncoder.encode(param.getName()) 
                                        + "=" + com.codecharge.util.StringUtils.encodeURL(values[i], encoding) );
                                        //URLEncoder.encode(values[i], encoding)
                            }
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
        if (sb.charAt(0) == '&') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public String getCacheKey(String pageName, ServletRequest req) {
        String parametersKey = getParametersKey(Action.getCachingSettings(pageName), "ISO-8859-1", (HttpServletRequest) req);
        logger.debug("getCacheKey => cacheKey: "+(pageName + (StringUtils.isEmpty(parametersKey) ? "" : "?" + parametersKey)));
        String keyMd5 = toMD5(pageName) + "." + toMD5(parametersKey);
        logger.debug("getCacheKey => cacheKeyMD5: "+keyMd5);
        return keyMd5;
    }
    
    public String getPageKey(String pageName) {
        return toMD5(pageName);
    }

    /*
     * ICache implemented methods
     */
    abstract public Object getObject(String key);
    
    /*
     * ICache implemented methods
     */
    abstract public void putObject(String key, Object value, int duration);
    
    /*
     * ICache implemented methods
     */
    abstract public void removeObject(String key);
    
    /*
     * ICache implemented methods
     */
    abstract public void clear();
    /*
     * ICache implemented methods
     */
    abstract public void clearStartedWith(String keyPart);
    
    /*
     * ICache implemented methods
     */
    abstract public void clearExpired();
    
    /*
     * End of ICache implemented methods
     */

    private String handleKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        int pos = key.indexOf('?');
        if (pos == -1) {
            return toMD5(key);
        } else {
            String newKey = toMD5(key.substring(0,pos));
            if (key.length() > pos + 1) {
                return newKey + "." + toMD5(key.substring(pos+1));
            }
            return newKey;
        }
    }
    
    private String toMD5(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignore) {
        }
        if (md != null) {
            byte[] d = md.digest(str.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < d.length; i++) {
                String hexStr = Integer.toHexString((d[i] + 128));
                sb.append((hexStr.length() == 1 ? "0" + hexStr : hexStr));
            }
            return sb.toString();
        }
        if (str.length() > 32) {
            return str.substring(0, 32);
        }
        return str;
    }
    
}


//End CacheAdapter class

