//BooleanField class @0-FE4C7776
package com.codecharge.db;

import java.text.*;
import java.util.Collection;

public class BooleanField extends Field implements Cloneable {
    //private Boolean value;
    
    public BooleanField() {}
    
    public BooleanField( String name ) {
        super(name, null);
    }

    public BooleanField( String name, String field ) {
        super(name,field);
    }
    
    public BooleanField( Boolean value ) {
        this.value = value;
    }
    
    public void applyDefaultValue() {
        value = null;
    }
    
    public Object getObjectValue() {
        return value;
    }

    public Boolean getValue() {
        if (value instanceof Collection) {
            return (Boolean)((Collection)value).toArray()[0];
        } else { 
            return (Boolean)value;
        }
        //return value;
    }

    public boolean booleanValue() {
        return getValue().booleanValue();
        //return value.booleanValue();
    }

    public void setValue( Boolean value ) {
        this.value = value;
    }

    public void setValue( boolean value ) {
        this.value = new Boolean(value);
    }

    public void setValue( Object value ) {
        if ( value == null || value instanceof Boolean ) {
            this.value = (Boolean) value;
        } else if (value instanceof String) {
            this.value = new Boolean((String) value);
        } else if (value instanceof Object[]) {
            setValues ((Object[])value);
        }
    }

    public void setObjectValue( Object value ) {
        setValue(value);
    }

    public void setValue( String value ) {
        if ( value == null) {
            this.value = null;
        } else if (value instanceof String) {
            this.value = new Boolean((String) value);
        }
    }

    /** Set parameter value, converting Object value to Boolean type with given Format.
      @param value new parameter value in form of Object
      @param format format used to convert value to the Boolean type
     */
    public void setValue( Object value, Format format ) throws ParseException {
        if ( value == null || value instanceof Boolean) {
            this.value = (Boolean) value;
        } else if ( value instanceof String ) {
            if ( format == null ) {
                this.value = new Boolean( (String) value );
            } else {
                this.value = (Boolean) format.parseObject( (String) value );
            }
        } else if ( value instanceof Boolean ) {
            this.value = (Boolean) value;
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
//End BooleanField class

