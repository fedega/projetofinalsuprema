//DbRowRowProvider class @0-DCC18213
/*
 * $Revision: 1.1 $
 * $Date: 2004/12/21 14:01:11 $
 */
package com.codecharge.db;

import java.util.Enumeration;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import com.codecharge.util.Utils;


public class DbRowRowProvider implements IRowProvider {

    private Enumeration dbRows;
    private DbRow outDbParameters;
    private boolean isNoRows;
    private boolean useOutDbParameters = true;
    private Comparator rowComparator;
    
    /**
     * @see com.codecharge.db.IRowProvider#setRows(java.lang.Object)
     */
    public void setRows(Object rows) {
        if (rows != null && ! (rows instanceof Enumeration)) {
            throw new IllegalArgumentException("Parameter 'rows' must be an Enumeration type.");
        }
        this.dbRows = (Enumeration) rows;
        if (this.rowComparator != null && this.dbRows != null) {
            ArrayList list = Utils.list(this.dbRows);
            Collections.sort(list, this.rowComparator);
            this.dbRows = Collections.enumeration(list);
        }
        if (this.dbRows == null || ! this.dbRows.hasMoreElements()) {
            this.isNoRows = true;
        }
    }

    /**
     * @see com.codecharge.db.IRowProvider#nextRow()
     */
    public Object nextRow() {
        Object nextOut = null;
        if (this.useOutDbParameters) {
            nextOut = this.outDbParameters;
            this.useOutDbParameters = false;
        }
        return (this.isNoRows ? nextOut : this.dbRows.nextElement());
    }

    /**
     * @see com.codecharge.db.IRowProvider#hasNextRow()
     */
    public boolean hasNextRow() {
        boolean isNextOut = false;
        if (this.useOutDbParameters) {
            isNextOut = (this.outDbParameters != null);
        }
        return (this.isNoRows ? isNextOut : this.dbRows.hasMoreElements());
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

//End DbRowRowProvider class

