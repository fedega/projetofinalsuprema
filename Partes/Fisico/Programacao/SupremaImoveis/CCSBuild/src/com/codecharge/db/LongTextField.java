//LongTextField class @0-75B8A018
/*
 * $Revision: 1.3 $
 * $Date: 2004/12/21 14:02:03 $
 */
package com.codecharge.db;

import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.text.ParseException;
import java.util.Collection;

import com.codecharge.util.StringUtils;

public class LongTextField extends Field implements Cloneable {
    //private String value;
    private String encoding;
    private byte[] content;

    public LongTextField() {
    }

    public LongTextField(String name) {
        super(name, null);
    }

    public LongTextField(String name, String field) {
        super(name, field);
    }

    public LongTextField(String name, String field, Object value) {
        super(name, field);
        setValue(value);
    }

    public void applyDefaultValue() {
        value = null;
    }

    public Object getObjectValue() {
        return value;
    }

    public void setObjectValue(Object value) {
        this.value = (String) value;
    }

    public String getValue() {
        if (value instanceof Collection) {
            return (String)((Collection)value).toArray()[0];
        } else { 
            return (String)value;
        }
        //return value;
    }

    public void setValue(Object value) {
        if (value instanceof Object[]) {
            setValues ( (Object[])value );
        } else {
            setValue(value, null, null);
        }
    }

    /** Set parameter value, ignoring Format parameter.
     @param value new parameter value in form of Object
     @param ignore format used to convert value to Double type
     @see #setValue(Object)
     */
    public void setValue(Object value, Format ignore) {
        if (value instanceof Object[]) {
            try {
                setValues ( (Object[])value, format );
            } catch (ParseException pe1) { }
        }  else {
            setValue(value, null, null);
        }
    }

    /**
     * Set parameter value, ignoring Format parameter.
     * 
     * @param value
     *            new parameter value in form of Object
     * @param ignore
     *            format used to convert value to Double type
     * @see #setValue(Object)
     */
    public void setValue(Object value, String encoding, Format ignore) {
        if (value == null) {
            this.value = null;
            this.content = null;
            return;
        } else if (value instanceof String) {
            if (StringUtils.isEmpty((String) value)) {
                this.value = null;
            } else {
                this.value = (String) value;
            }
        } else {
            this.value = value.toString();
        }
        this.encoding = encoding;
        this.content = getByteArray(encoding);
    }

    public Object clone() {
        return super.clone();
    }
    
    public byte[] getBytes() {
        return content;
    }
    
    public long getLength() {
        return content.length;
    }
    
    private byte[] getByteArray(String encoding) {
        if (StringUtils.isEmpty(encoding)) {
            //return (value == null ? null : value.getBytes());
            return (value == null ? null : getValue().getBytes());
        } else {
            try {
                //return (value == null ? null : value.getBytes(encoding));
                return (value == null ? null : getValue().getBytes(encoding));
            } catch (UnsupportedEncodingException uee) {

                throw new RuntimeException(uee.getMessage());



            }
        }
    }
}

//End LongTextField class

