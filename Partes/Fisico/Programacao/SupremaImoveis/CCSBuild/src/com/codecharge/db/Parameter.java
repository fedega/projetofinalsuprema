//Parameter interface @0-14B4238C
package com.codecharge.db;

/**
 * Represents parameter of the SQL query.
 **/
public interface Parameter {
    /** Obtain parameter value as Object. @return parameter value in form of Object. */
    public Object getObjectValue();
    /** Set this parameter value from Ojbect value. @param value new parameter value. */
    public void setObjectValue(Object value);
    /** Obtain format pattern used to convert parameter value to DataBase type. */
    public String getDbFormatPattern();
    /** @deprecated Use {@link #getDbFormatPattern} and {@link com.codecharge.util.CCSLocale CCSLocale} instead.*/
    public java.text.Format getDbFormat();
    /** @deprecated dbFormat made not writable. Use methods in classes implementing this interface to set db format. */
    public void setDbFormat(java.text.Format format);
    /** Force default value. Auxiliary method. */
    public void applyDefaultValue();

    public boolean isEmpty();
    public void setEmpty(boolean empty);
}
//End Parameter interface

