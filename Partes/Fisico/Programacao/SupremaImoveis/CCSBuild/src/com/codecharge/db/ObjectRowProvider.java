//ObjectRowProvider class @0-E88B9348
/*
 * $Revision: 1.3 $
 * $Date: 2005/04/27 11:51:46 $
 */
package com.codecharge.db;

import java.util.Comparator;

public class ObjectRowProvider implements IRowProvider {
    
    Object[] rows;
    DbRow outDbParameters;
    int counter;
    private Comparator rowComparator;
    
    /**
     * @see com.codecharge.db.IRowProvider#setRows(Object rows)
     */
    public void setRows(Object rows) {
        if (rows instanceof Object[]) {
            this.rows = (Object[]) rows;
        }
        this.counter = 0;
    }

    /**
     * @see com.codecharge.db.IRowProvider#nextRow()
     */
    public Object nextRow() {
        if (rows == null) {
            return null;
        }
        return rows[counter++];
    }

    /**
     * @see com.codecharge.db.IRowProvider#hasNextRow()
     */
    public boolean hasNextRow() {
        if (rows == null) {
            return false;
        }
        return (counter < this.rows.length);
    }

    public void setOutDbParameters(DbRow outDbParameters) {
        this.outDbParameters = outDbParameters;
    }

    public DbRow getOutDbParameters() {
        return this.outDbParameters;
    }

    public Comparator getRowComparator() {
        return this.rowComparator;
    }

    public void setRowComparator(Comparator comparator) {
        this.rowComparator = comparator;
    }
}


//End ObjectRowProvider class

