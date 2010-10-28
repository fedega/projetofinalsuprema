//IRowProvider class @0-0F5E81E3
/*
 * $Revision: 1.1 $
 * $Date: 2004/12/21 13:11:58 $
 */
package com.codecharge.db;

import java.util.Comparator;


public interface IRowProvider {
    void setRows(Object rows);
    void setOutDbParameters(DbRow outDbParameters);
    DbRow getOutDbParameters();
    Object nextRow();
    boolean hasNextRow();
    Comparator getRowComparator();
    void setRowComparator(Comparator comparator);
}

//End IRowProvider class

