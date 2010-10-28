//LocaleChooser class @0-5BBB4C16
package com.codecharge.util;

import com.codecharge.Names;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.*;

public class LocaleChooser {

    public static CCSLocale getCCSLocale(HttpServletRequest request) {
        CCLogger log = CCLogger.getInstance();
        String localeName = getCurrentLocaleName(request);
        log.debug("LocaleChooser.getCCSLocale => localeName: "+localeName);
        if (StringUtils.isEmpty(localeName)) {
            localeName = StringUtils.getSiteProperty("defaultLocale");
            log.debug("LocaleChooser.getCCSLocale => use default localeName: "+localeName);
        }
        Map supportedLocales = (Map) ContextStorage.getInstance().getAttribute(Names.LOCALES_POOL);
        CCSLocale ccsLocale = null;
        if (supportedLocales != null) {
            ccsLocale = (CCSLocale) supportedLocales.get(localeName);
            if (ccsLocale == null) {
                ccsLocale = (CCSLocale) supportedLocales.get(localeName.substring(0,2));
                if (ccsLocale == null) {
                    log.debug("LocaleChooser.getCCSLocale => use default site locale");
                    ccsLocale = (CCSLocale) supportedLocales.get(StringUtils.getSiteProperty("defaultLocale"));
                }
            }
        } else {
            throw new IllegalStateException("Supported locales are not defined.");
        }
        return ccsLocale;
    }

    public static String getLocaleParameter(HttpServletRequest request) {
        String paramName = "locale";
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableQueryString"))) {
            paramName = StringUtils.getSiteProperty("queryStringName");
        }
        CCSLocale ccsLocale = getCCSLocale(request);
        return paramName + "=" + (ccsLocale == null ? "" : ccsLocale.getLocaleName());
    }
    
    private static String getCurrentLocaleName(HttpServletRequest request) {
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableQueryString"))) {
            String paramName = StringUtils.getSiteProperty("queryStringName");
            if (! StringUtils.isEmpty(paramName)) {
                String qStr = request.getQueryString();
                if (! StringUtils.isEmpty(qStr)) {
                    String value = null;
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
                    if (! StringUtils.isEmpty(value)) {
                        value = clarifyLocaleName(value);
                        return normalizeLanguage(value);
                    }
                }
            }
        }
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableSession"))) {
            String paramName = StringUtils.getSiteProperty("sessionName");
            if (! StringUtils.isEmpty(paramName)) {
                String value = ((SimpleSessionStorage) SessionStorage
                            .getInstance(request)).getAttributeAsString(paramName);
                if (! StringUtils.isEmpty(value)) {
                    value = clarifyLocaleName(value);
                    return normalizeLanguage(value);
                }
            }
        }
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableSession"))) {
            String paramName = StringUtils.getSiteProperty("languageSessionName");
            if (! StringUtils.isEmpty(paramName)) {
                String value = ((SimpleSessionStorage) SessionStorage
                            .getInstance(request)).getAttributeAsString(paramName);
                if (! StringUtils.isEmpty(value)) {
                    value = clarifyLocaleName(value);
                    return normalizeLanguage(value);
                }
            }
        }
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableCookie"))) {
            String paramName = StringUtils.getSiteProperty("cookieName");
            if (! StringUtils.isEmpty(paramName)) {
                String value = StringUtils.getCookie(paramName, request.getCookies());
                if (! StringUtils.isEmpty(value)) {
                    value = clarifyLocaleName(value);
                    return normalizeLanguage(value);
                }
            }
        }
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableHTTPHeader"))) {
            String paramName = StringUtils.getSiteProperty("httpHeaderName");
            if (! StringUtils.isEmpty(paramName)) {
                String value = getHeaderLocaleName(request.getHeader(paramName));
                if (! StringUtils.isEmpty(value)) {
                    value = clarifyLocaleName(value);
                    return normalizeLanguage(value);
                }
            }
        }
        return null;
    }

    private static String getHeaderLocaleName(String content) {
        String[] languages = getAcceptedLanguages(content);
        if (languages == null || languages.length == 0) { 
            return null;
        }
        Map supportedLocales = (Map) ContextStorage.getInstance().getAttribute(Names.LOCALES_POOL);
        for (int i = 0; i < languages.length; i++) {
            String lang = normalizeLanguage(languages[i]);
            if (lang != null) {
                if (supportedLocales.get(lang) != null) {
                    return lang;
                }
            }
        }
        return null;
    }
    
    private static String[] getAcceptedLanguages(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        String header = content.trim();
        float maxPriority = 0;
        String[] languages = StringUtils.splitToArray(content, ',', '\\');
        for (int i = 0; i < languages.length; i++) {
            languages[i] = languages[i].trim();
        }
        TreeMap acceptedLanguages = new TreeMap();
        for (int i = 0; i < languages.length; i++) {
            int pos = languages[i].indexOf(";");
            float priority = 1;
            String language = languages[i];
            if (pos > -1) {
                if (pos < languages[i].length() - 1) {
                    try {
                        priority = Float.parseFloat(language.substring(pos+1));
                    } catch (NumberFormatException nfe) {
                        //skip language if it has incorrect quality
                        continue;
                    }
                }
                language = language.substring(0, pos);
            }
            Float langPriority = new Float(priority);
            ArrayList langs = (ArrayList) acceptedLanguages.get(langPriority);
            if (langs == null) {
                langs = new ArrayList();
                acceptedLanguages.put(langPriority, langs);
            }
            langs.add(language);
        }
        ArrayList resultList = new ArrayList();
        for (Iterator keys = acceptedLanguages.keySet().iterator(); keys.hasNext(); ) {
            ArrayList langs = (ArrayList) acceptedLanguages.get(keys.next());
            int langsSize = langs.size();
            for (int i = 0; i < langsSize; i++) {
                resultList.add(langs.get(i));
            }
        }
        String[] result = new String[resultList.size()];
        result = (String[]) resultList.toArray(result);
        return result;
    }

    private static String clarifyLocaleName(String localeName) {
        if (localeName.indexOf("-") == -1) {
            Properties localesInfo = (Properties) ContextStorage.getInstance().getAttribute(Names.LOCALES_INFO);
            String country = localesInfo.getProperty(localeName+".country");
            String fullLocaleName = localeName + (StringUtils.isEmpty(country)? "" : "_"+country);
            Map supportedLocales = (Map) ContextStorage.getInstance().getAttribute(Names.LOCALES_POOL);
            CCSLocale ccsLocale = null;
            if (supportedLocales != null) {
                ccsLocale = (CCSLocale) supportedLocales.get(fullLocaleName);
                if (ccsLocale != null) {
                    return fullLocaleName;
                }
            }
        }
        return localeName;
    }
    
    /*
     * Converts string like "en-us" to "en_US"
     */
    private static String normalizeLanguage(String language) {
        if (language == null) {
            return null;
        }
        int pos = language.indexOf("-");
        if (pos == -1) {
            pos = language.indexOf("_");
        }
        if (pos == -1) {
            return language.toLowerCase();
        } else if (pos == 0) {
            return null;
        } else if (pos == language.length() - 1) {
            return language.substring(0, pos).toLowerCase();
        }
        return language.substring(0, pos).toLowerCase()+"_"+language.substring(pos+1).toUpperCase();
    }



    public static void setLocaleName(String localeName, HttpServletRequest request) {
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableSession"))) {
            String paramName = StringUtils.getSiteProperty("sessionName");
            if (! StringUtils.isEmpty(paramName)) {
                ((SimpleSessionStorage) SessionStorage
                            .getInstance(request)).setAttribute(paramName, localeName);
            }
            paramName = StringUtils.getSiteProperty("languageSessionName");
            if (! StringUtils.isEmpty(paramName)) {
                if (localeName.length() > 2) {
                    ((SimpleSessionStorage) SessionStorage
                                .getInstance(request)).setAttribute(paramName, localeName.substring(0,2));
                } else {
                    ((SimpleSessionStorage) SessionStorage
                                .getInstance(request)).setAttribute(paramName, localeName);
                }
            }
        }
        if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("enableCookie"))) {
            String paramName = StringUtils.getSiteProperty("cookieName");
            if (! StringUtils.isEmpty(paramName)) {
                int maxAge = 0;
                try {
                    maxAge = Integer.parseInt(StringUtils.getSiteProperty("cookieExpired")) * 24 * 3600;
                } catch (NumberFormatException nfe_ignore) {}
                Cookie lang = new Cookie(paramName, localeName);
                if (maxAge > 0) {
                    lang.setMaxAge(maxAge);
                }
                ((SimpleSessionStorage) SessionStorage.getInstance(request))
                        .setAttribute(Names.LOCALE_COOKIE, lang);
            }
        }
    }





}


//End LocaleChooser class

