//CCSURL class @0-C3B607C7
package com.codecharge.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CCSURL {
    
    public static final String AMP = "&amp;";
    public static final String ANCHOR_SEPARATOR = "#";
    public static final String PARAM_SEPARATOR = "?";
    
    private HashMap params = null;
    private String url = null;
    private String anchor = null;
    

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }
    public String getAnchor() {
        return anchor;
    }
    
    private void parseUrl (String url) {
        url = pasrsAnchor(url);
        int pos = url.indexOf("?");
        if (pos < 0) {
            this.url = url;
        } else {
            String url1 = url.substring(0, pos);
            this.url = url1;
            String params = url.substring(pos+1, url.length());
            parseParamseters (params);
        }
    }
    
    private void parseParamseters (String params) {
        int pos = 0;
        while (pos >= 0) {
            pos = params.indexOf("&");
            String param = null;
            if (pos > 0) {
                param = params.substring(0,pos);
                params = params.substring( pos+1, params.length() );
            } else {
                param = params;
            }
            
            parseParameter(param);
        }
    }
    
    private String pasrsAnchor (String url) {
        int pos = url.indexOf("#");
        if (pos > 0) {
            String anch = url.substring(pos+1, url.length());
            setAnchor(anch);
            return url.substring( 0, pos );
        } 
        return url;
    }
    
    private void parseParameter (String param) {
        if (param == null || "".equals(param) ) return;
        
        int pos = param.indexOf("=");
        if (pos < 0) return;
        String name = param.substring(0,pos);
        
        if ("".equals( name )) return;
        
        if (name.startsWith("amp;")) {
            name = name.substring("amp;".length(), name.length() );
        }
        
        String val = param.substring(pos+1, param.length());
        addParameter(name, val);
    }
    
    public void setUrl(String url) {
        if (url == null) {
            this.url = null;
            return;
        }
        parseUrl(url);
    }
    
    
    public String getUrl() {
        return url;
    }
    
    private void addLinkParameter (String key, LinkParameter val) {
        String param = val.toString();
        parseParamseters(param);
    }

    public void addTextParameter (String key, Object val) {

        if (params == null) params = new HashMap();

        Object param = params.get(key);
        if (param == null) params.put(key, val);
        else {
            if (param instanceof ArrayList) {
                ((ArrayList)param).add(val);
            } else {
                ArrayList paramList = new ArrayList();
                paramList.add(param);
                paramList.add(val);
                params.put(key, paramList);
            }
        }
    }

    public void addParameter (String key, Object val) {
        
        if (val == null) val = "";
        
        if (val instanceof LinkParameter) {
            addLinkParameter (key, (LinkParameter)val);
            return;
        } else if (val instanceof String && ((String)val).indexOf("=")>0 ) {
            parseParamseters(""+val);
            return;         
        } 

        addTextParameter (key, val);
    }

    public void setParameter (String key, Object val) {
        Object p = getParameter(key);
        if (p!=null) removeParameter(key);
        addParameter(key, val);
    }
    
    public void removeParameter (String key) {
        if (params != null) params.remove(key);
    }
    
    public Object getParameter(String key) {
        if (params == null) return null;
        return params.get(key);
    }
    
    public String toRedirectString() {
        return toString (false);
    }
    
    public String toString() {

        if ( new Boolean(StringUtils.getSiteProperty("isXHTMLUsed")).booleanValue() || new Boolean(StringUtils.getSiteProperty("useAmp")).booleanValue() ) {
            return toString (true);
        } 

        return toString (false);
    }
    
    private String toString (boolean encode) {
        StringBuffer result = new StringBuffer();
        if (url != null) result.append(url);
        
        isfirst = true; 
        if (params != null) {
            Iterator it = params.keySet().iterator();
            while (it.hasNext()) {
                Object key = it.next();
                Object val = params.get(key);

                if (val == null) val = ""; 

                if (key!=null && !"".equals(key)) {
                    if (val instanceof ArrayList) {
                        ArrayList vals = (ArrayList)val;
                        Iterator it1 = vals.iterator();
                        while (it1.hasNext()) {
                            Object val1 = it1.next();
                            if (val1 == null) val1 = "";
                            result.append(buildToken (key, val1, encode));
                        }
                    } else { 
                        result.append(buildToken (key, val, encode) );
                    }
                    
                }
    
            }
        }
        
        if ( anchor!=null && !"".equals(anchor) ) {
            String anchSep;
            if (encode) {
                anchSep = ANCHOR_SEPARATOR;
            } else {
                anchSep = "#";
            }
            result.append(anchSep).append(anchor);
        }
        
        return result.toString();
    }
    
    boolean isfirst = true; 
    private String buildToken (Object key, Object val, boolean encode) {

       
        String amp;
        String paramSep;
        
        if (encode) {
            amp = AMP;
            //amp = "&";
            paramSep = PARAM_SEPARATOR;
        } else {
            amp = "&";
            paramSep = "?";
        }
        
        String pair = key + "=" + val;

        if (isfirst) {
            pair = paramSep + pair;
            isfirst = false;
        } else {
            pair = amp + pair;
        }
        return pair;
    }

    public HashMap getParameters () {
        return params;
    }
    
    public void addParameters (Map map) {
        if (map == null) return;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object val = map.get(key);
            addParameter(""+key, val);
        }
    }

    public void addParameters (String params) {
        parseParamseters(params);
    }
    

}




//End CCSURL class

