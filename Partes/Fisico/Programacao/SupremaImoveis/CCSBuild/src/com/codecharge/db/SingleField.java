//SingleField class @0-17E9C853
package com.codecharge.db;

import java.text.*;
import java.util.Collection;
import com.codecharge.util.*;

public class SingleField extends Field implements Cloneable {
    //private Float value;

    public SingleField() {}
    
    public SingleField( String name ) {
        super(name, null);
    }

    public SingleField( String name, String field ) {
        super(name,field);
    }
    
    public SingleField( String name, String field, Object value ) {
        super(name,field);
        setValue(value);
    }
    
    public SingleField( String name, String field, float value ) {
        super(name,field);
        setValue(value);
    }
    
    public void applyDefaultValue() {
        value = null;
    }
    
    public Object getObjectValue() {
        return value;
    }

    public Float getValue() {
        if (value instanceof Collection) {
            return (Float)((Collection)value).toArray()[0];
        } else { 
            return (Float)value;
        }
        //return value;
    }

    public double doubleValue() {
        return getValue().doubleValue();
        //return value.doubleValue();
    }

    public void setObjectValue( Object value ) {
        this.value = new Float(((Number) value).floatValue());
    }

    public void setValue( Float value ) {
        this.value = value;
    }

    public void setValue( float value ) {
        this.value = new Float(value);
    }

    public void setValue( Object value ) {
        if ( value == null || value instanceof Float ) {
            this.value = (Float) value;
        } else if ( value instanceof Number ) {
            this.value = new Float( value.toString() );
        } else if ( value instanceof String ) {
            if ( "".equals( value ) ) {
                value = null;
            } else {
                this.value = new Float( value.toString() );
            }    
        } else if (value instanceof Object[]) {
            setValues ( (Object[])value );
        }
    }

    /** Set parameter value, converting Object value with given Format to Double type.
      @param value new parameter value in form of Object
      @param format format used to convert value to Double type
     */
    public void setValue( Object value, Format format ) throws ParseException {
        if ( value == null || value instanceof Float) {
            this.value = (Float) value;
        } else if ( value instanceof String ) {
            if ( StringUtils.isEmpty( (String) value ) ) {
                this.value = null;
            } else {
                if ( format == null ) {
                    this.value = new Float( (String) value );
                } else {
                    this.value = ((NumericFormat) format).parseFloat( (String) value );
                }
            }
        } else if ( value instanceof Number ) {
            this.value = new Float( ((Number) value).floatValue() );
        } else if (value instanceof Object[]) {
            setValues ( (Object[])value, format );
        } else {
            this.value = null;
        }
    }

    public Object clone() {
        return super.clone();
    }

}
//End SingleField class

