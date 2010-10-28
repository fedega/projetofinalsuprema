//ReportGroups component @0-C238A2ED
package com.codecharge.components.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.codecharge.components.Report;

public class ReportGroups implements ReportIterator {

    protected ArrayList groups = new ArrayList();
    protected ReportGroup parent;

    private int rowCounter;
    private int groupCounter;
    private int activeGroupNumber;
    private ReportGroup currentGroup;
    private boolean open = true;
    private boolean close = true;
    
    public ReportGroups(ReportGroup parent) {
        this.parent = parent;
        activeGroupNumber = -1;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public boolean isClosed() {
        return close;
    }
    
    public void initIterator() {
        groupCounter = 0;
        rowCounter = 0;
        if (groups.size() > 0) {
            currentGroup = (ReportGroup) groups.get(groupCounter++);
        }
    }
    
    public boolean hasNextRow() {
        return (rowCounter < itemsNumber());
    }
    
    public ReportRow nextRow() {
        ReportRow row = null;
        if (hasNextRow()) {
            if (groups.size() > 0) {
                if (currentGroup == null) {
                    if (isShowActiveGroupOnly()) {
                        currentGroup = (ReportGroup) groups.get(activeGroupNumber);
                    } else {
                        currentGroup = (ReportGroup) groups.get(groupCounter++);
                    }
                } 
                if (rowCounter == 0) open = true;
                else open = false;
                if (rowCounter == itemsNumber()-1) close = true;
                else close = false;
                if (! currentGroup.hasNextRow() ) {
                    if (groupCounter < groups.size()) {
                        currentGroup = (ReportGroup) groups.get(groupCounter++); 
                    } else {
                        throw new NoSuchElementException();
                    }
                }
                row = currentGroup.nextRow();
                rowCounter++;
            }
        }
        return row;
    }
    
    
    public void addGroup(ReportGroup group) {
        group.previousGroup = lastGroup(); 
        groups.add(group);
    }
    
    public ReportGroup lastGroup() { 
        if (groups.size() == 0) {
            return null;
        }
        return (ReportGroup) groups.get(groups.size()-1);
    }
    
    public Iterator iterator() {
        return groups.iterator();
    }
    
    public Enumeration elements() {
        return Collections.enumeration(groups);
    }
    
    /**
     * Returns ReportGroup by index or null if index is higher than number of groups
     * @param index
     * @return
     * @exception IllegalArgumentException if index is less than zero
     */
    ReportGroup getGroup(int index) {
        ReportGroup group = null;
        if (index < 0) {
            throw new IllegalArgumentException("index cannot be less than zero");
        } else if (index < groups.size()) {
            group = (ReportGroup) groups.get(index);
        }
        return group;
    }
    
    ReportGroup getCurrentGroup() {
        return currentGroup;
    }
    
    public double linesNumber() {
        int size = 0;
        for (int i = 0; i < groups.size(); i++) {
            size += ((ReportGroup) groups.get(i)).linesNumber();
        }
        return size;
    }

    public int groupsNumber() {
        return groups.size();
    }

    public int itemsNumber() {
        int size = 0;
        if (isShowActiveGroupOnly()) {
            size += ((ReportGroup) groups.get(activeGroupNumber)).itemsNumber();
        } else {
            for (int i = 0; i < groups.size(); i++) {
                size += ((ReportGroup) groups.get(i)).itemsNumber();
            }
        }
        return size;
    }

    private boolean isShowActiveGroupOnly() {
        return (activeGroupNumber > -1 && parent.getReport().getViewMode() == Report.VIEW_MODE_WEB);
    }
    
    protected void nextPage() {
        ReportRow row = null;
        if (this.groups.size()-1 > this.groupCounter) {
            this.currentGroup = (ReportGroup) groups.get(this.groupCounter++);
            this.rowCounter = 0; //+= currentGroup.itemsNumber();
        }
    }
    
    protected void skipPage() {
        ReportRow row = null;
        if (this.currentGroup != null) {
            int groupItems = currentGroup.itemsNumber() - 1; 
            for (int i = 0; i < groupItems; i++) {
                nextRow();
            }
            this.currentGroup = (ReportGroup) groups.get(this.groupCounter++);
        }
    }
    
    public int getActiveGroupNumber() {
        return activeGroupNumber;
    }
    public void setActiveGroupNumber(int activeGroupNumber) {
        this.activeGroupNumber = activeGroupNumber-1;
        this.groupCounter = activeGroupNumber-1; 
        currentGroup = (ReportGroup) groups.get(activeGroupNumber-1);
    }
}



//End ReportGroups component

