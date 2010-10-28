//ObjectDataBinder class @0-8911498B
/*
 * $Revision: 1.3 $
 * $Date: 2005/05/04 05:44:23 $
 */
package com.codecharge.db;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.codecharge.components.Control;
import com.codecharge.util.StringUtils;


public class ObjectDataBinder implements IDataBinder {

    private HashMap fieldsMethods = new HashMap();
    
    /**
     * @see com.codecharge.db.IDataBinder#getFieldValue(java.lang.String, java.lang.Object)
     */
    public Object getFieldValue(Object row, String fieldName) {
        Object result = null;
        if (row == null || StringUtils.isEmpty(fieldName)) {
            return null;
        }
        Method fieldMethod = (Method) fieldsMethods.get(fieldName);
        if (fieldMethod == null) {
            try {
                // TODO: name of Method
                fieldMethod = row.getClass().getMethod("get" + 
                        fieldName.substring(0, 1).toUpperCase() + (fieldName.length() > 1 ? fieldName.substring(1) : ""), new Class[0]);
                fieldsMethods.put(fieldName, fieldMethod);
            } catch (NoSuchMethodException nsme) {
                throw new NoSuchDataSourceFieldException("There is no field '" + fieldName
                        + "' in class " + row.getClass().getName());
            }
        }
        try {
            result = fieldMethod.invoke(row, new Object[0]);
        } catch (InvocationTargetException ite) {

                throw new RuntimeException(ite.getMessage());

        } catch (IllegalAccessException iae) {

                throw new RuntimeException(iae.getMessage());

        }
        return result;
    }

    /**
     * @see com.codecharge.db.IDataBinder#getFieldValue(com.codecharge.components.Control,
     *      java.lang.String, java.lang.Object)
     */
    public Object getFieldValue(Object row, DbRow outDbParameters, Control control) {
        return getFieldValue(row, control.getName());
    }

    public Object getFieldValue(Object row, DbRow outDbParameters, String sourceType, String sourceName) {
        return getFieldValue(row, sourceName);
    }

    public void setControlValueFromDb(Control ctrl, Object value) {
        if (ctrl != null) {
            ctrl.setValue(value);
        }
    }
}


//End ObjectDataBinder class

