//DefaultControllerHandler class @0-A45B37F8
package com.codecharge.util;

import com.codecharge.events.*;
import com.codecharge.Names;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.*;

public class DefaultControllerHandler implements ControllerListener {

    public void appInitializing(AppEvent e) {
        ContextStorage.setContextStorageClassName( "com.codecharge.util.SimpleContextStorage" );
        ((SimpleContextStorage) ContextStorage.getInstance()).setServletContext( e.getServletConfig().getServletContext() );
    }

    public void appInitialized(AppEvent e) {
        createLocales(e);
    }
    
    public void appDestroyed(AppEvent e) {}

    public void controllerInitializing(ControllerEvent e) {
        SessionStorage.setSessionStorageClassName( "com.codecharge.util.SimpleSessionStorage" );
        ((SimpleSessionStorage) SessionStorage.getInstance( e.getHttpServletRequest() )).setResponse( e.getHttpServletResponse() );

          String defaultDateFormat = (String) ContextStorage.getInstance().getAttribute( "defaultDateFormat" );
          String defaultBooleanFormat = (String) ContextStorage.getInstance().getAttribute( "defaultBooleanFormat" );
          String encoding = (String) ContextStorage.getInstance().getAttribute( "encoding" );
          String currentStyle = StyleChooser.getCssStyle(e.getHttpServletRequest());
          //saveCssStyle(currentStyle, e.getHttpServletRequest());
          StyleChooser.setCssStyle(currentStyle, e.getHttpServletRequest());
          e.getHttpServletRequest().setAttribute(Names.CSS_STYLE_KEY, currentStyle);

          // set currentLocale
          String language = (String) ContextStorage.getInstance().getAttribute( "language" );
          Locale locale = null;
          if ( StringUtils.isEmpty( language ) ) {
            locale = Locale.getDefault();
          } else {
            HashMap langs = (HashMap) ContextStorage.getInstance().getAttribute(Names.LANGUAGES_KEY);
            if (langs != null) {
                locale = (Locale) langs.get(language);
            }
          }
          if ( locale == null ) {
            locale = Locale.getDefault();
          }

          CCSLocale ccsLocale = null;
          boolean useI18nFeatures = new Boolean(StringUtils.getSiteProperty("useI18nFeatures")).booleanValue();
          if (useI18nFeatures) {
              ccsLocale = LocaleChooser.getCCSLocale(e.getHttpServletRequest());
          } else {
              Map supportedLocales = (Map) ContextStorage.getInstance().getAttribute(Names.LOCALES_POOL);
              if (supportedLocales != null) {
                ccsLocale = (CCSLocale) supportedLocales.get(StringUtils.getSiteProperty("defaultLocale"));
              }
          }
          if (ccsLocale == null) {
              ccsLocale = new CCSLocale(locale, encoding);
              if (! StringUtils.isEmpty(defaultDateFormat) ) {
                ccsLocale.setDateFormatPattern(defaultDateFormat);
              }
              if (! useI18nFeatures && ! StringUtils.isEmpty(defaultBooleanFormat) ) {
                ccsLocale.setBooleanFormatPattern(defaultBooleanFormat);
              }
          }
          if (useI18nFeatures || 
                  SessionStorage.getInstance(e.getHttpServletRequest()).getAttribute(Names.CCS_LOCALE_KEY) == null) {
              SessionStorage.getInstance(e.getHttpServletRequest()).setAttribute(Names.CCS_LOCALE_KEY, ccsLocale);
          }
          if (useI18nFeatures) {
              //saveLocaleName(ccsLocale.getLocaleName().replace('_', '-'), e.getHttpServletRequest());
             LocaleChooser.setLocaleName(ccsLocale.getLocaleName().replace('_', '-'), e.getHttpServletRequest());
          }
    }

    protected Map createLocales(AppEvent e) {
        Properties localesInfo = (Properties) ContextStorage.getInstance().getAttribute(Names.LOCALES_INFO);
        HashMap ccsLocales = new HashMap();
        if ( localesInfo != null ) {
            Iterator keys__1 = localesInfo.keySet().iterator();
            while (keys__1.hasNext()) {
                String key = (String) keys__1.next();

                if (key.endsWith(".localeSign")) {
                    String localeName = key.substring(0, key.indexOf("."));
                    CCSLocale ccsLocale = new CCSLocale(localeName, localesInfo);
                    ccsLocales.put(localeName, ccsLocale);
                }
            }
        }
        ContextStorage.getInstance().setAttribute(Names.LOCALES_POOL, ccsLocales);
        return ccsLocales;
    }

/*    private void saveLocaleName(String localeName, HttpServletRequest request) {
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
    }*/



    /*private void saveCssStyle(String style, HttpServletRequest request) {
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
    }*/
}


//End DefaultControllerHandler class

