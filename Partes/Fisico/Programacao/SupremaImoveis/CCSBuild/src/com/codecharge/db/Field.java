//Field class @0-8AB36779
package com.codecharge.db;

import java.text.*;
import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;

abstract public class Field implements ReadOnlyField, Cloneable {
    protected String name;
    protected String field;
    //protected String errorValue;
    protected Format format;
    protected String dbFormatPattern;
    protected FieldOperation operation;

    protected boolean isEmpty = false;

    protected Object value;

    public Field(){}



//-------define emptiness for OmitIfEmpty---------
    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
    }
//------------------------------------------------



    public Field( String name ) {
        this(name, null);
    }

    public Field( String name, String field ) {
        this.name = name;
        this.field = field;
    }
    
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField( String field ) {
        this.field = field;
    }

    public Format getDbFormat() {
        return format;
    }

    public void setDbFormat( Format format ) {
        this.format = format;
    }

    public String getDbFormatPattern() {
        return dbFormatPattern;
    }

    public void setDbFormatPattern( String formatPattern ) {
        this.dbFormatPattern = formatPattern;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat( Format format ) {
        this.format = format;
    }

    public void setFormat( Format format, String ignore ) {
        this.format = format;
    }

    public FieldOperation getOperation() {
        return operation;
    }

    public void setOperation( FieldOperation operation ) {
        this.operation = operation;
    }

    //public String getErrorValue() {
    //    return errorValue;
    //}

    public String toString() {
        return "Field name: "+name+" field: "+field+" dbFormatPattern: "+dbFormatPattern;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException cnse_ignore) {}
        return obj;
    }


    public void setValues (Object[] value, Format format) throws ParseException {
        Vector v = null;
        for (int i = 0; i < value.length; i++) {
            if (v == null) v = new Vector();
                v.add(value[i]);
        }
        setCollectionValues(v, format);
    }

    protected void setCollectionValues (Collection value, Format format) throws ParseException {
        Vector v = null;
        Iterator it = value.iterator();
        while(it.hasNext()) {
            if (v == null) v = new Vector();
            Object val = it.next();
            if (val instanceof String) {
                if (format != null) {
                    v.add(format.parseObject ((String)val));
                } else {
                    v.add(val);
                }
            } else {
                    v.add(val);
            }
        }
        this.value = v;
    }

    public void setValues (Object[] value) {
        try {
            setValues(value, null);//Impossible. format is null.
        } catch (ParseException pe1) { }
    }

    abstract public Object getObjectValue();
    abstract public void setObjectValue(Object value);
    abstract public void applyDefaultValue();
}
//End Field class

