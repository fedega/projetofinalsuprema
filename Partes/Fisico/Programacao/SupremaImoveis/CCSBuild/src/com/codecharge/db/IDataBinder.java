//IDataBinder class @0-C16CC472
/*
 * $Revision: 1.1 $
 * $Date: 2004/12/21 09:17:06 $
 */
package com.codecharge.db;

import com.codecharge.components.Control;


public interface IDataBinder {
    Object getFieldValue(Object row, String fieldName);
    Object getFieldValue(Object row, DbRow outDbParameters, Control control);
    Object getFieldValue(Object row, DbRow outDbParameters, String sourceType, String sourceName);
    void setControlValueFromDb(Control ctrl, Object value);
}

//End IDataBinder class

