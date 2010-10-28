//BindEvent component @0-F3BDE0CF
/*
 * Created on 14.05.2004
 * $Revision: 1.2 $
 * $Date: 2004/06/30 08:05:28 $
 */
package com.codecharge.events;

import java.util.Hashtable;


public class BindEvent extends Event {

    Object row;
    
    
	/**
	 * @return the curren row
	 */
	public Object getRow() {
		return row;
	}

	/**
	 * @param object
	 */
	public void setRow(Object object) {
		row = object;
	}
    
    public Object getRowField(String fieldName) {
        Object value = null;
        if (row instanceof Hashtable) {
            value = ((Hashtable) row).get(fieldName);
        } else {
            // TODO: use reflection for field access
        }
        return value;
    }

}
//End BindEvent component

