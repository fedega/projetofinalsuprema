//CachingParameter class @0-B4680933
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.cache;

import com.codecharge.db.ParameterSource;


public class CachingParameter {
    
    final static public int TARGET_CACHING_KEY = 1;
    final static public int TARGET_DISABLE_CACHING = 2;
    final static public int TARGET_CLEAR_CACHE = 3;
    
    final static public String CACHING_KEY_PARAMS = "com.codecharge.util.cache.CachingParameter.CACHING_KEY_PARAMS";
    final static public String DISABLE_CACHING_PARAMS = "com.codecharge.util.cache.CachingParameter.DISABLE_CACHING_PARAMS";
    final static public String CLEAR_CACHE_PARAMS = "com.codecharge.util.cache.CachingParameter.CLEAR_CACHE_PARAMS";
    
    private String name;
    private ParameterSource sourceType;
    private int type;
    //private String[] values;
    
    public CachingParameter(String name) {
        this(name, ParameterSource.URL, CachingParameter.TARGET_CACHING_KEY);
    }
    
    public CachingParameter(String name, ParameterSource sourceType, int type) {
        this.name = name;
        setSourceType(sourceType);
        setType(type);
    }
    
    public CachingParameter(String name, String sourceType, String type) {
        this.name = name;
        setSourceType(ParameterSource.getParameterSource(sourceType));
        if ("Disable".equalsIgnoreCase(type)) {
            setType(CachingParameter.TARGET_DISABLE_CACHING);
        } else if ("Key".equalsIgnoreCase(type)) {
            setType(CachingParameter.TARGET_CACHING_KEY);
        } else if ("Clear".equalsIgnoreCase(type)) {
            setType(CachingParameter.TARGET_CLEAR_CACHE);
        }
    }
    
    public String getName() {
        return name;
    }
    public ParameterSource getSourceType() {
        return sourceType;
    }
    public void setSourceType(ParameterSource sourceType) {
        if (sourceType == ParameterSource.URL || sourceType == ParameterSource.FORM
                || sourceType == ParameterSource.SESSION || sourceType == ParameterSource.EXPRESSION) {
            this.sourceType = sourceType;
        } else {
            throw new IllegalArgumentException("Only types URL, FORM, SESSION, EXPRESSION are allowed here. ["+sourceType+"]");
        }
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    /*public String getValue() {
        if (values == null) { 
            return null;
        }
        return values[0];
    }
    public void setValue(String value) {
        this.values = new String[] {value};
    }
    public String[] getValues() {
        return values;
    }
    public void setValues(String[] values) {
        this.values = values;
    }
*/
    public String toString() {
        return super.toString()+"\n\tname: "+name+" sourceType: "+sourceType+" type: "+printTypeName();
    }
/*
    private String printValues() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            sb.append(", "+values[i]);
        }
        sb.replace(0, 1, "[");
        sb.append("]");
        return sb.toString();
    }*/
    private String printTypeName() {
        switch (this.type) {
            case TARGET_CACHING_KEY:
                return "TARGET_CACHING_KEY";
            case TARGET_DISABLE_CACHING:
                return "TARGET_DISABLE_CACHING";
            case TARGET_CLEAR_CACHE:
                return "TARGET_CLEAR_CACHE";
        }
        return "Unknown type";
    }
}


//End CachingParameter class

