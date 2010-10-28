//LinkParameter class @0-9767832B
package com.codecharge.util;

import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Date;

import com.codecharge.components.ControlType;
import com.codecharge.components.Link;
import com.codecharge.components.Page;
import com.codecharge.db.ParameterSource;

public class LinkParameter implements Cloneable {

    protected String name;
    protected ArrayList values = new ArrayList();
    protected String sourceName;
    protected ParameterSource sourceType;
    protected String formatPattern;
    protected CCLogger log;
    protected ControlType type;
    
    protected Link linkModel;
    
    public LinkParameter(String name, String sourceName, ParameterSource sourceType) {
        this(name, sourceName, sourceType, null, ControlType.TEXT);
    }
    public LinkParameter(String name, String sourceName, ParameterSource sourceType, 
            String formatPattern, ControlType type) {
        this.log = CCLogger.getInstance();
        this.name = name;
        this.sourceName = sourceName;
        this.sourceType = sourceType;
        this.formatPattern = formatPattern;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    
    public String getValue() {
        String val = null;
        if ( values.size() == 0 ) {
            val = "";
        } else {
            if (type != null) {
                Format fmt = this.linkModel.getPage().getCCSLocale().getFormat(type, formatPattern);
                val = values.get(0)==null ? "" : fmt.format(values.get(0));
            } else {
                val = values.get(0)==null ? "" : values.get(0).toString();
            }
        }
        return val;
    }
    
    public void setValue(Object value) {
        if (value instanceof Enumeration) {
            setValue((Enumeration) value);
        } else if (value instanceof Collection) {
            setValue((Collection) value);
        } else {
            clearValues();
            addValue(value);
        }
    }
    public void setValue(long value) { setValue(new Long(value)); }
    public void setValue(double value) { setValue(new Double(value)); }
    public void setValue(boolean value) { setValue(new Boolean(value)); }
    
    /** for backward compatibility*/
    public void setValue(Enumeration values) { setValues(values); }
    /** for backward compatibility*/
    public void setValue(Collection values) { setValues(values); }
    /** for backward compatibility*/
    public void setValue(Object[] values) { setValues(values); }
    /** for backward compatibility*/
    public void setValue(long[] value) { setValues(values); }
    /** for backward compatibility*/
    public void setValue(double[] value) { setValues(values); }
    /** for backward compatibility*/
    public void setValue(boolean[] value) { setValues(values); }
    
    public void addValue(Object value) { 
        if (value!=null) this.values.add(value); 
    }
    public void addValue(long value) { addValue(new Long(value)); }
    public void addValue(double value) { addValue(new Double(value)); }
    public void addValue(boolean value) { addValue(new Boolean(value)); }
    
    public void addValues(Object[] values) { 
        if (values==null) return;
        for (int i = 0; i < values.length; i++ ) { addValue(values[i]); } 
    }
    public void addValues(long[] values) { 
        if (values==null) return;
        for (int i = 0; i < values.length; i++ ) { addValue(new Long(values[i])); } 
    }
    public void addValues(double[] values) { 
        if (values==null) return;
        for (int i = 0; i < values.length; i++ ) { addValue(new Double(values[i])); } 
    }
    public void addValues(boolean[] values) { 
        if (values==null) return;
        for (int i = 0; i < values.length; i++ ) { addValue(new Boolean(values[i])); } 
    }
    public void addValues(Enumeration values) { 
        if (values==null) return;
        while (values.hasMoreElements()) { addValue(values.nextElement()); } 
    }
    public void addValues(Collection values) { 
        if (values==null) return;
        for (Iterator it = values.iterator(); it.hasNext(); ) { addValue(it.next()); } 
    }
    
    public void setValues(Enumeration values) {
        clearValues();
        addValues(values);
    }
    
    public void setValues(Collection values) {
        clearValues();
        addValues(values);
    }
    
    public void setValues(Object[] values) {
        clearValues();
        addValues(values);
    }
    
    public void setValues(long[] value) {
        clearValues();
        addValues(values);
    }
    
    public void setValues(double[] value) {
        clearValues();
        addValues(values);
    }
    
    public void setValues(boolean[] value) {
        clearValues();
        addValues(values);
    }

    public void clearValues() { values.clear(); }

    public String getSourceName() {
        return sourceName;
    }
    
    public void setSourceName( String sourceName ) {
        this.sourceName = sourceName;
    }
    
    public ParameterSource getSourceType() {
        return sourceType;
    }
    
    public void setSourceType( ParameterSource sourceType ) {
        this.sourceType = sourceType;
    }
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
            ((LinkParameter) obj).values = new ArrayList();
        } catch (CloneNotSupportedException cnse_ignore) {}
        return obj;
    }
    
    public String toString() {
        return toString (false);
    }

    public String toString(boolean isEnc) {
        StringBuffer sb = new StringBuffer();
        int valuesSize = values.size();
        Page page = this.linkModel.getPage();
        for (int i = 0; i < valuesSize; i++ ) {
            Object val = values.get(i);
            if (val!=null) {
                String value = null;
                if (val instanceof Date) {
                    value = page.getCCSLocale().getDateFormat().format((Date) val);
                } else if (val instanceof Integer) {
                    value = page.getCCSLocale().getLongFormat().format((Integer) val);
                } else if (val instanceof Long) {
                    value = page.getCCSLocale().getLongFormat().format((Long) val);
                } else if (val instanceof Number) {
                    value = page.getCCSLocale().getDoubleFormat().format((Number) val);
                } else {
                    value = val.toString();
                }
                if (type != null && ! (type == ControlType.TEXT || type == ControlType.MEMO) && !(val instanceof String)) {
                    value = this.linkModel.getPage().getCCSLocale().getFormat(type, formatPattern).format(val);
                }
                sb.append(name+"=");
                try {
                    //sb.append(java.net.URLEncoder.encode(value, this.linkModel.getPage().getCharacterEncoding()));
                    sb.append(com.codecharge.util.StringUtils.encodeURL(value,this.linkModel.getPage().getCharacterEncoding()));
                } catch (UnsupportedEncodingException uee) {
                    log.error("", uee);
                }
                if (i<valuesSize-1) {
                    if (isEnc) {
                        sb.append(CCSURL.AMP);
                    } else {
                        sb.append("&");
                    }
                }             }
        }
        if (valuesSize==0) sb.append(name+"=");
        return sb.toString();
    }
    public Link getLinkModel() {
        return linkModel;
    }
    public void setLinkModel(Link linkModel) {
        this.linkModel = linkModel;
    }
    public String getFormatPattern() {
        return formatPattern;
    }
    public void setFormatPattern(String formatPattern) {
        this.formatPattern = formatPattern;
    }
    public ControlType getType() {
        return type;
    }
    public void setType(ControlType type) {
        this.type = type;
    }
}


//End LinkParameter class

