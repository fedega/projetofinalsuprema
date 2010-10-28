//ReportRows component @0-73BE335F
/*
 * $Revision: 1.12 $
 * $Date: 2004/11/23 10:03:25 $
 */
package com.codecharge.components.report;

import java.util.ArrayList;

public class ReportRows implements ReportIterator {
    ArrayList rows = new ArrayList();
    
    private int index;
    private boolean open = false;
    private boolean close = false;
    
    public void initIterator() {
        index = 0;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public boolean isClosed() {
        return close;
    }
    
    public boolean hasNextRow() {
        return (index < rows.size());
    }
    
    /**
     * Returns the next data row in iteration 
     * @return ReportRow the next data row in iteration
     * @exception java.util.NoSuchElementException - has no more rows.
     */
    public ReportRow nextRow() throws java.util.NoSuchElementException {
        if (index >= rows.size()) {
            throw new java.util.NoSuchElementException();
        }
        if (index == 0) open = true;
        else open = false;
        if (index == rows.size()-1) close = true;
        else close = false;
        ReportRow row = (ReportRow) rows.get(index++); 
        return row;
    }
    
    public void addRow(ReportRow row) { 
        rows.add(row);
    }

    public double linesNumber() {
        int count = 0;
        int rowsSize = rows.size();
        for (int i = 0; i < rowsSize; i++) {
            ReportRow row = (ReportRow) rows.get(i); 
            if (row.isVisible()) {
                count += row.getHeight();
            }
        }
        return count; 
    }

    public int itemsNumber() {
        return rows.size(); 
    }

    public int groupsNumber() {
        return 0;
    }

    ReportRow getRow(int index) {
        return (ReportRow) rows.get(index);
    }

}



//End ReportRows component

