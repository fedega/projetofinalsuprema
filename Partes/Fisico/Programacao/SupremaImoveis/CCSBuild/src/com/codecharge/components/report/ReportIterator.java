//ReportIterator component @0-D19A2A52
/*
 * $Revision: 1.8 $
 * $Date: 2004/08/17 12:41:44 $
 */
package com.codecharge.components.report;

public interface ReportIterator {
    public void initIterator();
    public boolean hasNextRow();
    public ReportRow nextRow() throws java.util.NoSuchElementException;
    public int itemsNumber();
    public int groupsNumber();
    public double linesNumber();
    public boolean isOpen();
    public boolean isClosed();
}



//End ReportIterator component

