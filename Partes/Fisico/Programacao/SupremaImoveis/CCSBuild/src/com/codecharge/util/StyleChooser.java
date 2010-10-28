//StyleChooser class @0-0313E79E
package com.codecharge.util;

import com.codecharge.Names;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.*;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;

public class StyleChooser {


    public static void setCssStyle(String style, HttpServletRequest request) {
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("SSEnableSession"))) {
            String paramName = StringUtils.getSiteProperty("SSSessionName");
            if (! StringUtils.isEmpty(paramName)) {
                ((SimpleSessionStorage) SessionStorage
                            .getInstance(request)).setAttribute(paramName, style);
            }
        }
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("SSEnableCookie"))) {
            String paramName = StringUtils.getSiteProperty("SSCookieName");
            if (! StringUtils.isEmpty(paramName)) {
                int maxAge = 0;
                try {
                    maxAge = Integer.parseInt(StringUtils.getSiteProperty("SSCookieExpired")) * 24 * 3600;
                } catch (NumberFormatException nfe_ignore) {}
                Cookie cookie = new Cookie(paramName, style);
                if (maxAge > 0) {
                    cookie.setMaxAge(maxAge);
                }
                ((SimpleSessionStorage) SessionStorage.getInstance(request))
                        .setAttribute(Names.CSS_STYLE_COOKIE, cookie);
            }
        }
    }

    public static String getCssStyle(HttpServletRequest request) {
        CCLogger log = CCLogger.getInstance();
        String value = null;
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("useDynamicStyles"))) {
            if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("SSEnableQueryString"))) {
                String paramName = StringUtils.getSiteProperty("SSQueryStringName");
                if (! StringUtils.isEmpty(paramName)) {
                    String qStr = request.getQueryString();
                    if (! StringUtils.isEmpty(qStr)) {
                        int pos = qStr.indexOf(paramName+"=");
                        int length = (paramName+"=").length();
                        if (pos != -1) {
                            int pos1 = qStr.indexOf("&", pos);
                            if (pos1 == -1) {
                                value = qStr.substring(pos + length);
                            } else {
                                value = qStr.substring(pos + length, pos1);
                            }
                        }
                    }
                }
            }
            if (StringUtils.isEmpty(value) && "true".equalsIgnoreCase(StringUtils.getSiteProperty("SSEnableSession"))) {
                String paramName = StringUtils.getSiteProperty("SSSessionName");
                if (! StringUtils.isEmpty(paramName)) {
                    value = ((SimpleSessionStorage) SessionStorage
                                .getInstance(request)).getAttributeAsString(paramName);
                }
            }
            if (StringUtils.isEmpty(value) && "true".equalsIgnoreCase(StringUtils.getSiteProperty("SSEnableCookie"))) {
                String paramName = StringUtils.getSiteProperty("SSCookieName");
                if (! StringUtils.isEmpty(paramName)) {
                    value = StringUtils.getCookie(paramName, request.getCookies());
                }
            }
            if (StringUtils.isEmpty(value) || ! isValidStyle(value)) {
                return StringUtils.getSiteProperty("defaultStyle");
            } else {
                try {
                    String stylePath = "/Styles/"+value.trim()+"/Style.css";
                    InputStream is = ContextStorage.getContext().getResourceAsStream("/Styles/"+value+"/Style.css");
                    if (is == null) {
                        log.debug("Style '"+stylePath+"' not found. Use default style.");
                        return StringUtils.getSiteProperty("defaultStyle");
                    }
                    is.close();
                } catch (IOException e) {
                    log.error("",e);
                }
            }
        } else {
            return StringUtils.getSiteProperty("defaultStyle");
        }
        return value;
    }

    public static String getStyleParameter(HttpServletRequest request) {
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("useDynamicStyles"))) {
            String paramName = "style";
            if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("SSEnableQueryString"))) {
                paramName = StringUtils.getSiteProperty("SSQueryStringName");
            }    
            String style = getCssStyle(request);
            return paramName + "=" + (style == null ? "" : style);
        }
        return "";
    }
    
    private static boolean isValidStyle(String style) {
        if (StringUtils.isEmpty(style)) {
            return false;
        }
        int len = style.length();
        for (int i = 1; i < len; i++) {
            char c = style.charAt(i);
            if (!(Character.isLetterOrDigit(c) || Character.isSpaceChar(c))) {
                return false;
            }
        }
        return true;
    }
}

//End StyleChooser class

