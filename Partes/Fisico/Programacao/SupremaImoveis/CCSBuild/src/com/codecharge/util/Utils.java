//Utils class @0-D6AABA71
/*
 * $Revision: 1.3 $
 * $Date: 2005/01/17 10:22:43 $
 */
package com.codecharge.util;

import java.io.File;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.ArrayList;
import java.util.Enumeration;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.codecharge.components.Page;
import com.codecharge.util.RC4Crypter;
import com.codecharge.util.CCSURL;
import javax.servlet.http.Cookie;

public class Utils {

    public static ArrayList list(Enumeration e) {
        ArrayList l = new ArrayList();
        while (e.hasMoreElements())
            l.add(e.nextElement());
        return l;
    }


    public static Long convertToLong( long value ) {
        return new Long(value);
    }

    public static Long convertToLong( double value ) {
        return new Long((long) value);
    }

    public static Long convertToLong( Object value ) {
        Long result = null;
        if ( value == null || value instanceof Long ) {
            result = (Long) value;
        } else {
            if ( value instanceof Number ) {
                result = new Long( ((Number) value).longValue() );
            } else if ( value instanceof String ) {
                if ( "".equals( value ) ) {
                    result = null;
                } else {
                    result = new Long( (String) value );
                }    
            }
        }
        return result;
    }

    public static Long convertToLong(Object value, Format format) throws java.text.ParseException {
        Long result = null;
        if ( value instanceof String ) {
            if ( StringUtils.isEmpty((String) value)) {
                result = null;
            } else {
                if ( format == null ) {
                    result = new Long((String) value);
                } else {
                    //TODO: check that given format is NumericFormat
                    result = ((NumericFormat) format).parseLong((String) value);
                }
            }
        } else if (value instanceof Number) {
            result = new Long(((Number) value).longValue());
        }
        return result;
    }

    public static Long convertToLong(double value, Format ignore) throws java.text.ParseException {
        return new Long((long) value);
    }

    public static Double convertToDouble( double value ) {
        return new Double(value);
    }

    public static Double convertToDouble( Object value ) {
        Double result = null;
        if ( value == null || value instanceof Double ) {
            result = (Double) value;
        } else {
            if ( value instanceof Number ) {
                result = new Double(((Number) value).doubleValue());
            } else if ( value instanceof String ) {
                if ( "".equals( value ) ) {
                    result = null;
                } else {
                    result = new Double( (String) value );
                }    
            }
        }
        return result;
    }

    public static Double convertToDouble(double value, Format ignore) throws java.text.ParseException {
        return new Double(value);
    }

    public static Double convertToDouble(Object value, Format format) throws java.text.ParseException {
        Double result = null;
        if ( value == null || value instanceof Double) {
            result = (Double) value;
        } else if ( value instanceof String ) {
            if ( ! StringUtils.isEmpty( (String) value ) ) {
                if ( format == null ) {
                    result = new Double( (String) value );
                } else {
                    //TODO: check that given format is NumericFormat
                    result = ((NumericFormat) format).parseDouble( (String) value );
                }
            }
        } else if ( value instanceof Number ) {
            result = new Double( ((Number) value).doubleValue() );
        }
        return result;
    }

    public static Float convertToFloat(double value) {
        return new Float((float) value);
    }

    public static Float convertToFloat(Object value) {
        Float result = null;
        if ( value == null || value instanceof Float ) {
            result = (Float) value;
        } else {
            if ( value instanceof Number ) {
                result = new Float(((Number) value).floatValue());
            } else if ( value instanceof String ) {
                if ( "".equals( value ) ) {
                    result = null;
                } else {
                    result = new Float( (String) value );
                }    
            }
        }
        return result;
    }

    public static Float convertToFloat(double value, Format ignore) throws java.text.ParseException {
        return new Float((float) value);
    }

    public static Float convertToFloat(Object value, Format format) throws java.text.ParseException {
        Float result = null;
        if ( value == null || value instanceof Float) {
            result = (Float) value;
        } else if ( value instanceof String ) {
            if ( ! StringUtils.isEmpty( (String) value ) ) {
                if ( format == null ) {
                    result = new Float( (String) value );
                } else {
                    //TODO: check that given format is NumericFormat
                    result = ((NumericFormat) format).parseFloat( (String) value );
                }
            }
        } else if ( value instanceof Number ) {
            result = new Float( ((Number) value).floatValue() );
        }
        return result;
    }

    public static Date convertToDate( long value ) {
        return new Date(value);
    }

    public static Date convertToDate( double value ) {
        return new Date((long) value);
    }

    public static Date convertToDate( Object value ) throws java.text.ParseException {
        Date result = null;
        if ( value == null || value instanceof Date ) {
            result = (Date) value;
        } else {
            if ( value instanceof Number ) {
                result = new Date(((Number) value).longValue());
            } else if ( value instanceof String ) {
                if ( "".equals( value ) ) {
                    result = null;
                } else {
                    result = (Date) DateFormat.getDateTimeInstance().parse( (String) value );
                }    
            }
        }
        return result;
    }

    public static Date convertToDate(Object value, Format format) throws java.text.ParseException {
        Date result = null;
        if (value == null || value instanceof Date) {
            result = (Date) value;
        } else if (value instanceof String) {
            if (! StringUtils.isEmpty((String) value)) {
                if ( format == null ) {
                    result = (new SimpleDateFormat()).parse((String) value);
                } else {
                    result = (Date) format.parseObject((String) value);
                }
            }
        } else if (value instanceof Number) {
            result = new Date(((Number) value).longValue());
        }
        return result;
    }

    public static String convertToString( long value ) {
        return String.valueOf(value);
    }

    public static String convertToString( double value ) {
        return String.valueOf(value);
    }

    public static String convertToString( boolean value ) {
        return String.valueOf(value);
    }

    public static String convertToString( Object value ) {
        String result = null;
        if ( value == null || value instanceof String ) {
            result = (String) value;
        } else {
            result = value.toString();
        }
        return result;
    }

    public static String convertToString(Object value, Format format) {
        String result = null;
        if ( value == null || value instanceof String ) {
            result = (String) value;
        } else {
            if (format == null) {
                result = value.toString();
            } else {
                result = format.format(value);
            }
        }
        return result;
    }

    public static Boolean convertToBoolean( boolean value ) {
        return new Boolean(value);
    }

    public static Boolean convertToBoolean( Object value ) {
        Boolean result = null;
        if ( value == null || value instanceof Boolean ) {
            result = (Boolean) value;
        } else if (value instanceof String) {
            result = new Boolean((String) value);
        }
        return result;
    }

    public static Boolean convertToBoolean(Object value, Format format) throws java.text.ParseException {
        Boolean result = null;
        if (value instanceof String) {
            if ( format == null ) {
                result = new Boolean((String) value);
            } else {
                result = (Boolean) format.parseObject((String) value);
            }
        } else if (value instanceof Boolean) {
            result = (Boolean) value;
        }
        return result;
    }

    public static void printMessage(String message, javax.servlet.http.HttpServletResponse response) {
        try {
            java.io.PrintWriter actionPw = new java.io.PrintWriter( 
                    new java.io.OutputStreamWriter( response.getOutputStream() ));
            actionPw.println(message);
            actionPw.flush();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }

    public static void printFatalError(String message, javax.servlet.http.HttpServletResponse response) {
        try {
            java.io.PrintWriter actionPw = new java.io.PrintWriter( 
                    new java.io.OutputStreamWriter( response.getOutputStream() ));
            actionPw.println(message);
            actionPw.flush();
            actionPw.close();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }

    public static String getUserId(Page page) {
        String userId = null;
        Authenticator auth = page.getAuthenticator();
        if (auth != null) {
            userId = auth.getUserId();
        }
        return userId;
    }

    public static String getUserLogin(Page page) {
        String userName = null;
        Authenticator auth = page.getAuthenticator();
        if (auth != null) {
            userName = auth.getUserName();
        }
        return userName;
    }

    public static String getUserGroup(Page page) {
        String groupId = null;
        Authenticator auth = page.getAuthenticator();
        if (auth != null) {
            groupId = auth.getGroupId();
        }
        return groupId;
    }
    
    public static void clearFolder(String path, long maxAge) {
        if (StringUtils.isEmpty(path)) return;
        AgeFileFilter aff = new AgeFileFilter(Math.abs(maxAge));
        File current = new File(path);
        if (current.isDirectory() && current.canWrite()) {
            File[] flist = current.listFiles(aff);
            for (int i = 0; i < flist.length; i++ ) {
                if ( ! flist[i].delete() ) {
                    CCLogger.getInstance().debug("Unable to delete file "+flist[i].getName());
                }
            }
        }
    }



//End Utils class

//Crypting methods @0-8976E2B8
    //public static String rc4Encrypt (String data, String key) {
    public static String encryptString (String data, String key) {
        RC4Crypter ist = new RC4Crypter();
        return ist.encrypt(key, data);
    }
    //public static String rc4Decrypt (String data, String key) {
    public static String decryptString (String data, String key) {
        RC4Crypter ist = new RC4Crypter();
        return ist.decrypt(key, data);
    }

//End Crypting methods

//Autologin methods @0-95DB7F0D

    public static void setAutoLoginCookies (Page page, String name, String password) {
        if ("True".equals ( StringUtils.getSiteProperty("ALEnabled") )) {
            int exp = 0;
            try {
                exp = Integer.parseInt( StringUtils.getSiteProperty("ALCookieExpired") );
            } catch (NumberFormatException nfe) {}

            RC4Crypter crypter = new RC4Crypter();
            String key = StringUtils.getSiteProperty("ALEncryptionKey");
            String encData = crypter.encrypt (key, crypter.encrypt(key, name) + ":" + crypter.encrypt(key, password) + ":" + (new Date().getTime() + exp*60*60*24*1000) );

            Cookie c1 = new Cookie ( StringUtils.getSiteProperty("ALLoginCookieName"), encData );
            c1.setMaxAge(60*60*24*exp);

            page.getResponse().addCookie( c1 );
            //page.addCookie( c1 );
            
        } else {
            clearAutoLoginCookies (page);
        }
    }

    public static void clearAutoLoginCookies (Page page) {
        if (!page.isIncluded()) {
            Cookie c1 = new Cookie ( StringUtils.getSiteProperty("ALLoginCookieName"), "" );
            c1.setMaxAge(0);
            page.getResponse().addCookie( c1 );
        }
    }

    public static void checkAutoLoginCoockie (Page page) {
        if ("True".equals ( StringUtils.getSiteProperty("ALEnabled") )) {

            String name = "";
            String pass = "";
            long expData = 0;

            String key = StringUtils.getSiteProperty("ALEncryptionKey");
            String d = page.getCookie( StringUtils.getSiteProperty("ALLoginCookieName") );
            if (!StringUtils.isEmpty(d)) {


                try{
                    RC4Crypter crypter = new RC4Crypter();

                    String d1 = null;
                    try {
                        d1 = crypter.decrypt(key, d);
                    } catch (Exception e211) {
                        clearAutoLoginCookies(page);
                        return;
                    }

                    int d2 = d1.indexOf(":");

                    if (d2 < 0) {
                        clearAutoLoginCookies(page);
                        return;
                    }

                    int d3 = d1.indexOf(":", d2+1);
                
                    String d4 = d1.substring(0, d2);
                    String d5 = d1.substring(d2+1, d3);
                    String d6 = d1.substring(d3+1, d1.length());

                    name = crypter.decrypt(key, d4);
                    pass = crypter.decrypt(key, d5);
                    expData = Long.parseLong(d6);


                } catch (Exception e356) {
                    clearAutoLoginCookies(page);
                    return;
                }
            }


            if ( page.getAuthenticator()==null || page.getAuthenticator().getUserPrincipal()==null ) {
                    com.codecharge.util.Authenticator auth = com.codecharge.util.AuthenticatorFactory.getAuthenticator( page.getRequest() );
                    auth.setRequest( page.getRequest() );
                    auth.setResponse( page.getResponse() );
                    auth.invalidate();
                    if ( auth.authenticate( name, pass ) ) {
                        //if ( "True".equals ( StringUtils.getSiteProperty("ALSlidingExpriration") )) {
                        //    com.codecharge.util.Utils.setAutoLoginCookies( page, name, pass );
                        //}
                        shiftExp(page, name, pass, expData);

                        if (!StringUtils.isEmpty ( page.getHttpGetParameters().getParameter("ccsForm") ) ) {
                            CCSURL url = page.getHttpGetParameters().toCCSURL(new String [] {"ccsForm"});
                            url.setUrl(page.getRequest().getRequestURI());
                            page.setRedirect(url.toString());
                        }
                    } else {
                        clearAutoLoginCookies(page);
                    }
            } else {
                //if ( "True".equals ( StringUtils.getSiteProperty("ALSlidingExpriration") )) {
                //    com.codecharge.util.Utils.setAutoLoginCookies( page, name, pass );
                //}
                shiftExp(page, name, pass, expData);
            }
        } else {
            clearAutoLoginCookies(page);
        }
    }


    public static void shiftExp(Page page, String name, String pass, long cookieData) {
        if ( "True".equals ( StringUtils.getSiteProperty("ALSlidingExpriration") )) {

            long currentData = new Date().getTime();

            int exp = 0;
            try {
                exp = Integer.parseInt( StringUtils.getSiteProperty("ALCookieExpired") );
            } catch (NumberFormatException nfe) {}
            
            if (cookieData - (exp*60*60*24*1000 / 2) > currentData) {
                com.codecharge.util.Utils.setAutoLoginCookies( page, name, pass );
            }

        }
    }


//End Autologin methods

//Methods to encryp password. @0-460BB3D4
    public static String encryptPassword (String pass) {
        return "";
    }
    public static String encryptPassword (Object pass) {
        return encryptPassword(""+pass);
    }


    public static String MD5Old(String str) {//NOTE : This is dm5 algoritm + bytes to HEX converter. Result is HEX string.
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

    public static String MD5(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");

            if (md != null) {
                byte[] d = md.digest(str.getBytes());

	        StringBuffer sb = new StringBuffer (); 
                for (int i = 0 ; i < d.length; i++) { 
            	    String ss = Integer.toHexString(0x000000ff & d[i]); 
            	    if (ss.length()<2) ss = "0"+ss;
            	    sb.append(ss);
                }
                return sb.toString();
            }
        } catch (NoSuchAlgorithmException ignore) {
        }

	return "";
    }

//End Methods to encryp password.

//function controllerInitializing @0-30A1BE77
    public static void controllerInitializing(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        CCLogger logger = CCLogger.getInstance();
        com.codecharge.events.ControllerEvent controllerEvent = 
                new com.codecharge.events.ControllerEvent( ContextStorage.getContext(), request, response );
        String handlerClassName = ContextStorage.getInstance().getAttributeAsString( "controllerHandlerClassName" );
        if ( StringUtils.isEmpty( handlerClassName ) ) {
          handlerClassName = "com.codecharge.util.DefaultControllerHandler";
        }
        try {
            Class handler = Class.forName( handlerClassName );
            com.codecharge.events.ControllerListener cl = (com.codecharge.events.ControllerListener) handler.newInstance();
            cl.controllerInitializing( controllerEvent );
        } catch ( java.lang.ClassNotFoundException cnfe ) {
            logger.error( "Utils.controllerInitializing: Class '" + handlerClassName + "' is not found" );
            SessionStorage.setSessionStorageClassName( "com.codecharge.util.SimpleSessionStorage" );
            ((SimpleSessionStorage) SessionStorage.getInstance( request )).setResponse( response );
        } catch ( java.lang.InstantiationException ie ) {
            logger.error( "Utils.controllerInitializing: Unable to create instance '" + handlerClassName );
            SessionStorage.setSessionStorageClassName( "com.codecharge.util.SimpleSessionStorage" );
            ((SimpleSessionStorage) SessionStorage.getInstance( request )).setResponse( response );
        } catch ( java.lang.IllegalAccessException iae ) {
            logger.error( "Utils.controllerInitializing: IllegalAccessException occurred while creating instance '" + handlerClassName  );
            SessionStorage.setSessionStorageClassName( "com.codecharge.util.SimpleSessionStorage" );
            ((SimpleSessionStorage) SessionStorage.getInstance( request )).setResponse( response );
        }
    }

    public static boolean isGreaterThan9999Year(Date date, Locale locale) {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault(), locale);
        cal.setTime(date);
        if (9999 < cal.get(Calendar.YEAR)) {
            return true;
        }
        return false;
    }

    public static String getPageFolderPath(javax.servlet.ServletRequest request) {
        
        String result = "";
        if (request instanceof javax.servlet.http.HttpServletRequest) {
            result = ((javax.servlet.http.HttpServletRequest) request).getRequestURI();
            int pos = result.lastIndexOf("/");
            if ( pos > -1 ) {
                result = result.substring(0, pos);
            }
        }
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + result;
    }

//End function controllerInitializing

//Utils class: tail @0-FCB6E20C
}


//End Utils class: tail

