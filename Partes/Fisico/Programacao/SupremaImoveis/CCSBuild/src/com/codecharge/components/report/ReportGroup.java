//ReportGroup class @0-E197F3DE
/*
 * $Revision: 1.27 $
 * $Date: 2004/12/03 15:02:22 $
 */
package com.codecharge.components.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.codecharge.components.Model;
import com.codecharge.components.NoSuchComponentException;
import com.codecharge.components.Report;
import com.codecharge.components.ReportLabel;
import com.codecharge.events.BindEvent;
import com.codecharge.events.Event;
import com.codecharge.events.SectionListener;
import com.codecharge.util.StringUtils;

public class ReportGroup implements Cloneable, ReportIterator {
    
    final static public int GROUP = 0;
    final static public int GROUP_HEADER = 1;
    final static public int GROUP_FOOTER = 2;
    final static public int GROUP_ROW = 3;
    
    final static private int GROUP_TYPE_REPORT = 10;
    final static private int GROUP_TYPE_PAGE = 11;
    final static private int GROUP_TYPE_REGULAR = 12;
    
    final static private String COMPUTE_AT_SUFFIX = "_~cAt";
    final static private String RESET_AT_SUFFIX = "_~rAt";
    final static private int COMPUTE_AT_SUFFIX_LENGTH = COMPUTE_AT_SUFFIX.length() + 8; //8 is a length of hex hashcode 
    final static private int RESET_AT_SUFFIX_LENGTH = RESET_AT_SUFFIX.length() + 8;
    
    final static private int GARBLE_MODE_COMPUTE = 20;
    final static private int GARBLE_MODE_RESET = 21;
    
    private String groupId; //hex String of group hash code.
    
    private String name;
    private ReportGroup parent;
    private ReportRow controls;
    private String sourceColumnName;
    private String sortOrder;
    
    private ReportGroup activeGroup; 
    private int itemCounter;
    
    private boolean freezeStructure;
    private ReportGroup root;
    private HashMap groups = new HashMap();
    private ArrayList headerListeners = new ArrayList();
    private ArrayList footerListeners = new ArrayList();
    private Report report;
    
    private ReportRow resetAtControls = new ReportRow(null);
    private ReportRow computeAtControls = new ReportRow(null);
    
    private int groupType;
    
    boolean headerVisibleOnPage = true;
    boolean footerVisibleOnPage = true;
    boolean headerVisible;
    boolean footerVisible;
    
    private double headerHeight = 1;
    private double footerHeight = 1;
    
    private List headerControlNames = new ArrayList();
    private List footerControlNames = new ArrayList();

    //is used from ReportGroups.addGroup
    ReportGroup previousGroup;
    
    /**
     * computeAtCollection is a HashMap of ArrayLists that keep references to all 
     * detail controls whose values depend on the control of this group.
     * The name of the control is the key in this HashMap.
     */
    private HashMap computeAtCollections = new HashMap();
    private HashMap computeAtHash = new HashMap();
    
    /**
     * resetAtCollection is a HashMap of ArrayLists that keep references to all 
     * controls whose values depend on the control of this group.
     * The name of the control is the key in this HashMap.
     */
    private HashMap resetAtCollections = new HashMap();
    
    /** for determining the group state for each event that was called. property <code>state</code>
     *  can be used only from events
     */
    private int state;
    
  /**
   * Represents ...
   */
      private ReportIterator items; 

    public ReportGroup(String name) {
        this(name, null, null);
    }
    
    public ReportGroup(String name, String sourceColumnName) {
        this(name, sourceColumnName, null);
    }
    
    public ReportGroup(String name, String sourceColumnName, ReportGroup parent) {
        this.groupId = Integer.toHexString(this.hashCode());
        while (this.groupId.length() < 8) {
            this.groupId += "0"; 
        }
        this.name = name;
        this.parent = parent;
        this.sourceColumnName = sourceColumnName;
        groupType = ReportGroup.GROUP_TYPE_REGULAR;
        if ("Report".equals(name)) {
            this.root = this;
            groupType = ReportGroup.GROUP_TYPE_REPORT;
        }
        if (parent != null) {
            if (groupType == ReportGroup.GROUP_TYPE_REPORT) {
                root = parent;
            } else {
                root = parent.getRootGroup();
            }
        }
        if (root != null) {
            root.groups.put(name, this);
        }
        controls = new ReportRow(null);
        if (groupType == ReportGroup.GROUP_TYPE_REPORT) {
            addGroup(new ReportGroup("Page", null, this, ReportGroup.GROUP_TYPE_PAGE));
        }
    }
    
    private ReportGroup(String name, String sourceColumnName, ReportGroup parent, int groupType) {
        this.name = name;
        this.parent = parent;
        this.sourceColumnName = sourceColumnName;
        this.groupType = groupType;
        if (parent != null) {
            root = parent.getRootGroup();
        }
        this.groupId = Integer.toHexString(this.hashCode());
        while (this.groupId.length() < 8) {
            this.groupId += "0"; 
        }
        controls = new ReportRow(null);
    }
    
    private ReportGroup() {}
    
    public boolean isOpen() {
        return (items==null?true:items.isOpen());
    }
    
    public boolean isClosed() {
        return (items==null?true:items.isClosed());
    }
    
    public ReportGroup getActiveGroup() {
        return activeGroup;
    }
    
    public String getName() {
        return name;
    }
    
    public ReportGroup getRootGroup() {
        return root;
    }

    public ReportGroup getParentGroup() {
        return parent;
    }

    public void freezeStructure() {
        this.freezeStructure = true;
    }
    
    public boolean isStructureFrosen() {
        return this.freezeStructure;
    }
    
    public Model getControl(String name) {
        Model control = null;
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException(
                    "ReportGroup.getControl(name): name cannot be empty.");
        }
        control = controls.getControl(name);
        if (control == null && parent instanceof ReportGroup) control = parent.getControl(name);
        if (control == null) {
            throw new NoSuchComponentException("ReportGroup.getControl("+name+
                    "): control named '"+name+"' not found in report"+(report==null?"":": "+report.getName()));
        }
        return control;
    }
    
    public ReportGroup getGroup(String name) {
        return (ReportGroup) root.groups.get(name);
    }
    
    public void addControl(Model control) {
        addControl(control, ReportGroup.GROUP_HEADER);
    }

    public void addControl(Model control, int mode) {
        if (control != null) {
            controls.addControl(control);
            switch (mode) {
                case ReportGroup.GROUP_HEADER:
                    headerControlNames.add(control.getName());
                    break;
                case ReportGroup.GROUP_FOOTER:
                    footerControlNames.add(control.getName());
                    break;
            }
        }
    }

    public void addGroup(ReportGroup item) {
        if (root==null && this.freezeStructure || root != null && root.freezeStructure)
            throw new  IllegalArgumentException("You cannot add a new group because group structure is frozen");
        if (items == null) {
            items = new ReportGroups(this);
        } else if (!(items instanceof ReportGroups)) {
            throw new IllegalArgumentException("Only ReportGroup is allowed here");
        }
        ((ReportGroups) items).addGroup(item);
        //groups.put(item.name, item);
        root.groups.put(item.name, item);
        item.parent = this;
    }

    public void addGroupInstance(ReportGroup item) {
        if (items == null) {
            items = new ReportGroups(this);
        } else if (!(items instanceof ReportGroups)) {
            throw new IllegalArgumentException("Only ReportGroup is allowed here");
        }
        ((ReportGroups) items).addGroup(item);
        item.parent = this;
        root.groups.put(item.name, item);
    }

    public void addRow(ReportRow item) {
        if (items == null) {
            items = new ReportRows();
        } else if (!(items instanceof ReportRows)) {
            throw new IllegalArgumentException("Only ReportRow is allowed here");
        }
        ((ReportRows) items).addRow((ReportRow) item);
        root.activeGroup = this;
    }

    public void initIterator() {
        items.initIterator();
    }
    
    /**
     * Returns true if group contains one more ReportRow; false - otherwise
     * @return boolean true if group contains one more ReportRow; false - otherwise
     */
    public boolean hasNextRow() {
        return (items == null ? false : items.hasNextRow());
    }
    
    /**
     * Returns the next data row in iteration 
     * @return ReportRow the next data row in iteration
     * @exception java.util.NoSuchElementException - group has no more rows.
     */
    public ReportRow nextRow() throws java.util.NoSuchElementException {
        ReportRow row = null;
        if (hasNextRow()) {
            row = items.nextRow();
            if (items instanceof ReportGroups) {
                if (root != null) root.groups.put(((ReportGroups) items).getCurrentGroup().getName(), ((ReportGroups) items).getCurrentGroup());
            } else {
                root.activeGroup = this;
            }
            if (this.groupType == ReportGroup.GROUP_TYPE_PAGE && this.isOpen()) {
                report.incrementPageNumber();
            }
        } else {
            throw new NoSuchElementException();
        }
        return row;
    }

    public int groupsNumber() {
        return items.groupsNumber();
    }
    
  /**
   * @return number of lines 
   */
    public double linesNumber() {        
        double size = getHeaderHeight() + getFooterHeight();
        if (items instanceof ReportGroups) {
            size += ((ReportGroups) items).linesNumber();
        } else if (items instanceof ReportRows) {
            size += ((ReportRows) items).linesNumber();
        }
        return size;
    } 

    public int itemsNumber() {        
        int size = 0;
        if (items instanceof ReportIterator) {
            size += items.itemsNumber();
        }
        return size;
    } 

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("  ReportGroup name: "+name+" sourceColumnName: "+sourceColumnName+" size: "+linesNumber()+" hash: "+this.hashCode()+"\n");
        if (controls==null) sb.append("    controls is null\n"); 
        else sb.append("    "+controls.toString());
        if (items instanceof ReportGroups) {
            for (int i = 0; i < items.groupsNumber(); i++) {
                sb.append(((ReportGroups) items).getGroup(i).toString());
            }
        } else if (items instanceof ReportRows) {
            for (int i = 0; i < items.itemsNumber(); i++) {
                sb.append(((ReportRows) items).getRow(i).toString());
            }
        }
        return sb.toString();
    }
    
    public static void shareControls(ReportGroup src, ReportGroup dest) {
        while (dest.groupType != ReportGroup.GROUP_TYPE_PAGE) {
            dest.groupId = src.groupId;
            dest.controls = src.controls;
            dest.resetAtControls = src.resetAtControls;
            //dest.resetAtCollections = src.resetAtCollections;
            dest.computeAtControls = src.computeAtControls;
            dest.computeAtCollections = src.computeAtCollections;
            src = src.getParentGroup();
            dest = dest.getParentGroup();
        }
    }
    
    public ReportGroup createInstance(ReportGroup parentGroup) {
        ReportGroup obj = null; 
        try {
            obj = (ReportGroup) super.clone();
        } catch (CloneNotSupportedException cnse_ignore) {
            cnse_ignore.printStackTrace(System.out); //TODO: ignore?
        }
        obj.controls = (ReportRow) controls.createInstance(null);
        obj.parent = parentGroup;
        obj.groupId = groupId;
        if (groupType == ReportGroup.GROUP_TYPE_REPORT) {
            obj.root = obj;
            obj.parent = null;
        } else {
            if (parentGroup != null) {
                obj.parent = parentGroup;
                obj.root = parentGroup.getRootGroup();
            }
        }
        if (root != null) {
            root.groups.put(obj.name, obj);
        }
        if (items instanceof ReportGroups) {
            obj.items = new ReportGroups(obj);
            for (Iterator it = ((ReportGroups)items).iterator(); it.hasNext(); ) {
                Object grp1 = it.next();
                ReportGroup item = (ReportGroup) ((ReportGroup) grp1).createInstance(obj);
                ((ReportGroups) obj.items).addGroup(item);
                break;
            }
        } else if (items instanceof ReportRows) {
            obj.items = new ReportRows();
            obj.root.activeGroup = obj;
        } else if (items == null) {
            obj.items = new ReportRows();
            obj.root.activeGroup = obj;
        }
        if (this.groupType == ReportGroup.GROUP_TYPE_PAGE) {
            report.incrementPageNumber();
            obj.resetAtCollections = cloneResetAtCollection();
        }
        return obj;
    }

    private HashMap cloneResetAtCollection() {
        HashMap result = new HashMap();
        for (Iterator it = resetAtCollections.keySet().iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            ArrayList list = (ArrayList) resetAtCollections.get(key);
            ArrayList newList = new ArrayList();
            for (Iterator it1 = list.iterator(); it1.hasNext(); ) {
                ReportLabel rl = (ReportLabel) it1.next();
                ReportLabel rl1 = (ReportLabel) rl.clone();
                newList.add(rl1);
            }
            result.put(key, newList);
        }
        return result;
    }
    
    public synchronized void addHeaderListener(SectionListener l) {
        headerListeners.add(l);
    }

    public synchronized void removeHeaderListener(SectionListener l) {
        headerListeners.remove(l);
    }

    public synchronized void addFooterListener(SectionListener l) {
        footerListeners.add(l);
    }

    public synchronized void removeFooterListener(SectionListener l) {
        footerListeners.remove(l);
    }

    public void fireOnInitializeHeaderEvent(Object dataRow) {
        state = ReportGroup.GROUP_HEADER; 
        ArrayList v;
        BindEvent e = new BindEvent();
        e.setSource(this);
        e.setRow(dataRow);
        synchronized(this) {v = (ArrayList)headerListeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).onInitialize(e);
        }

        state = ReportGroup.GROUP; 
    } 

    public void fireOnInitializeFooterEvent(Object dataRow) {
        state = ReportGroup.GROUP_FOOTER; 
        ArrayList v;
        BindEvent e = new BindEvent();
        e.setSource(this);
        e.setRow(dataRow);
        synchronized(this) {v = (ArrayList)footerListeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).onInitialize(e);
        }
        state = ReportGroup.GROUP; 
    } 

    public void fireOnCalculateHeaderEvent(Object dataRow) {
        state = ReportGroup.GROUP_HEADER; 
        ArrayList v;
        BindEvent e = new BindEvent();
        e.setSource(this);
        e.setRow(dataRow);
        synchronized(this) {v = (ArrayList)headerListeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).onCalculate(e);
        }
        state = ReportGroup.GROUP; 
    } 

    public void fireOnCalculateFooterEvent(Object dataRow) {
        state = ReportGroup.GROUP_FOOTER; 
        ArrayList v;
        BindEvent e = new BindEvent();
        e.setSource(this);
        e.setRow(dataRow);
        synchronized(this) {v = (ArrayList)footerListeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).onCalculate(e);
        }
        state = ReportGroup.GROUP; 
    } 

    public void fireBeforeShowHeaderEvent() {
        state = ReportGroup.GROUP_HEADER; 
        // at first call own event
        ArrayList v;
        Event e = new Event();
        e.setSource(report);
        synchronized(this) {v = (ArrayList)headerListeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).beforeShow(e);
        }
        state = ReportGroup.GROUP; 
    } 

    public void fireBeforeShowFooterEvent() {
        state = ReportGroup.GROUP_FOOTER;
        ArrayList v;
        Event e = new Event();
        e.setSource(report);
        synchronized(this) {v = (ArrayList)footerListeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).beforeShow(e);
        }
        state = ReportGroup.GROUP; 
    } 

    /**
     * @return report object
     */
    public Report getReport() {
        return report;
    }

    /**
     * @param report
     */
    public void setReport(Report report) {
        this.report = report;
    }

    /**
     * @return state
     */
    public int getState() {
        return state;
    }

    /**
     * @return column name
     */
    public String getSourceColumnName() {
        return sourceColumnName;
    }

    public ReportLabel getResetAtReportLabel(String name) {
        Model ctrl = resetAtControls.getControl(garbleName(name, ReportGroup.GARBLE_MODE_RESET));
        if (ctrl instanceof ReportLabel) {
            return (ReportLabel) ctrl;
        }
        return null;
    }

    public void addResetAtReportLabel(ReportLabel ctrl) {
        ctrl.setName(garbleName(ctrl.getName(), ReportGroup.GARBLE_MODE_RESET));
        resetAtControls.addControl(ctrl);
    }

    public ReportLabel getComputeAtReportLabel(String name) {
        Model ctrl = computeAtControls.getControl(garbleName(name, ReportGroup.GARBLE_MODE_COMPUTE));
        if (ctrl instanceof ReportLabel) {
            return (ReportLabel) ctrl;
        } else {
            throw new NoSuchComponentException("ReportLabel '"+name+"' not found in group '"+this.name+"'");
        }
    }

    public void addComputeAtReportLabel(ReportLabel ctrl) {
        ctrl.setName(garbleName(ctrl.getName(), ReportGroup.GARBLE_MODE_COMPUTE));
        computeAtControls.addControl(ctrl);
        
    }
    
    public void openAll(Object row) {
        ReportGroup group = open(row);

        // then call descendant event 
        // to open descendant groups automatically
        if (group.items instanceof ReportGroups) {
            ((ReportGroups) group.items).lastGroup().openAll(row);
        }
    }

    public ReportGroup open(Object row) {
        ReportGroup group = this;
        if (! group.headerVisible && this.groupType != ReportGroup.GROUP_TYPE_PAGE) {
            group.setHeaderVisibleOnPage(false);
        }
        initializeComputeAtControls();
        initializeResetAtControls(previousGroup);
        initializeResetAtControls(this);
        return group;

    }

    private void initializeComputeAtControls() {
        for (Iterator it = this.computeAtControls.getControlNames(); it.hasNext(); ) {
            String cAtName = (String) it.next();
            String ctrlName = cAtName.substring(0, cAtName.length() - ReportGroup.COMPUTE_AT_SUFFIX_LENGTH - 1);
            ((ReportLabel) this.computeAtControls.getControl(cAtName)).setValue(null);
            ((ReportLabel) this.computeAtControls.getControl(cAtName)).setFunctionValue(null);
            report.removeAttributesByPrefix(ctrlName+".");
            report.removeAttributesByPrefix(cAtName+".");
            report.removeAttributesByPrefix(garbleName(ctrlName, ReportGroup.GARBLE_MODE_COMPUTE)+".");
        }
        this.computeAtCollections = new HashMap();
    }
    
    private void initializeResetAtControls(ReportGroup group) {
        if (group == null) {
            return;
        }
        for (Iterator it = resetAtControls.getControlNames(); it.hasNext(); ) {
            String rAtName = (String) it.next();
            String ctrlName = rAtName.substring(0, rAtName.length() - ReportGroup.RESET_AT_SUFFIX_LENGTH - 1);
            ((ReportLabel) resetAtControls.getControl(rAtName)).setValue(null);
            ((ReportLabel) resetAtControls.getControl(rAtName)).setFunctionValue(null);
            
            Collection controls = group.getResetAtCollection(ctrlName);
            if (controls != null) {
                for (Iterator it1 = controls.iterator(); it1.hasNext();) {
                    ReportLabel rl = ((ReportLabel) it1.next());
                    if (! this.controls.hasControl(rl.getName())) {
                        if (rl.getFunction() != null) {
                            rl.setFunctionValue(rl.getFunction().getInitialValue());
                            rl.setValue(rl.getFunction().getInitialValue());
                        } else {
                            rl.setFunctionValue(null);
                            rl.setValue(null);
                        }
                    }
                }
            }
            report.removeAttributesByPrefix(ctrlName+".");
            report.removeAttributesByPrefix(rAtName+".");
            report.removeAttributesByPrefix(garbleName(ctrlName, ReportGroup.GARBLE_MODE_RESET)+".");
        }
        group.resetAtCollections = new HashMap();
    }

    public void closeAll(Object row) {
        // at first call descendant event
        // to close descendant groups automatically 
        ReportGroup group = this;
        if (! group.footerVisible) group.setFooterVisibleOnPage(false);
        if (group.items instanceof ReportGroups) {
            ((ReportGroups) group.items).lastGroup().closeAll(row);
            //group = report.getGroup(this.name);
        }
        close(row);
    }

    
    public ReportGroup close(Object row) {
        ReportGroup group = report.getGroup(this.name);
        if (! group.footerVisible && this.groupType != ReportGroup.GROUP_TYPE_PAGE) group.setFooterVisibleOnPage(false);
        
        for (Iterator it = group.controls.getControlNames(); it.hasNext(); ) {
            String ctrlName = (String) it.next();
            Model m = group.controls.getControl(ctrlName);
            if (m instanceof ReportLabel) {
                ReportLabel rl = ((ReportLabel) m);
                if (!StringUtils.isEmpty(rl.getComputeAt())) {
                    report.getGroup(rl.getComputeAt()).addToComputeAtCollection(ctrlName, rl);
                }
                if (!StringUtils.isEmpty(rl.getResetAt())) {
                    report.getGroup(rl.getResetAt()).removeFromResetAtCollection(ctrlName, rl);
                }
            }
        }        

        for (Iterator it = group.computeAtControls.getControlNames(); it.hasNext(); ) {
            String cAtName = (String) it.next();
            String ctrlName = cAtName.substring(0, cAtName.length() - ReportGroup.COMPUTE_AT_SUFFIX_LENGTH - 1);
            Model m = group.computeAtControls.getControl(cAtName);
            if (m instanceof ReportLabel) {
                Collection controls = group.getComputeAtCollection(ctrlName);
                if (controls != null) {
                    Object value = ((ReportLabel) m).getValue();
                    for (Iterator it1 = controls.iterator(); it1.hasNext();) {
                        ReportLabel rl = ((ReportLabel) it1.next());
                        rl.computeAtFunction(value);
                    }
                }
            }
        }
        for (Iterator it = group.computeAtControls.getControlNames(); it.hasNext(); ) {
            String ctrlName = (String) it.next();
            ((ReportLabel) group.computeAtControls.getControl(ctrlName)).setValue(null);
            group.computeAtCollections.put(ctrlName, new ArrayList());
        }    
        return group;
    }

    
    public double getCorrectionValue() {
        if (this.groupType == ReportGroup.GROUP_TYPE_PAGE) {
            return (-1 * getHeaderHeight());
        }
        return 0;
    }
    
    public Collection getComputeAtCollection(String name) {
        return (Collection) computeAtCollections.get(name);
    }

    public void addToComputeAtCollection(String name, ReportLabel control) {
        ArrayList coll = (ArrayList) computeAtCollections.get(name);
        HashMap hash = (HashMap) computeAtHash.get(name);
        if (coll == null) {
            coll = new ArrayList();
            hash = new HashMap();
            computeAtCollections.put(name, coll);
            computeAtHash.put(name, hash);
        }
        if (! hash.containsKey(new Long(control.hashCode()))) {
            coll.add(control);
            hash.put(new Long(control.hashCode()), control);
        }
    }

    public Collection getResetAtCollection(String name) {
        return (Collection) resetAtCollections.get(name);
    }

    public void addToResetAtCollection(String name, ReportLabel control) {
        ArrayList coll = (ArrayList) resetAtCollections.get(name);
        if (coll == null) {
            coll = new ArrayList();
            resetAtCollections.put(name, coll);
        }
        if (! coll.contains(control)) {
            coll.add(control);
        }
    }

    public void removeFromResetAtCollection(String name, ReportLabel control) {
        ArrayList coll = (ArrayList) resetAtCollections.get(name);
        if (coll != null) {
            coll.remove(control);
        }
    }

    /**
     * @return the height of footer
     */
    public double getFooterHeight() {
        return (isFooterVisible() ? this.footerHeight : 0);
    }

    public void setFooterHeight(double height) {
        this.footerHeight = height;
    }

    /**
     * @return the height of header
     */
    public double getHeaderHeight() {
        return (isHeaderVisible() ? this.headerHeight : 0);
    }

    public void setHeaderHeight(double height) {
        this.headerHeight = height;
    }

    public int getPagesNumber() {
        int number = 0;
        if (groupType == ReportGroup.GROUP_TYPE_REPORT) {
            if (items instanceof ReportGroups) {
                number = items.groupsNumber();
            }
        } else {
            if (root != null) {
                if (root.groupType == ReportGroup.GROUP_TYPE_REPORT) {
                    if (items instanceof ReportGroups) {
                        number = items.groupsNumber();
                    }
                }
            }
        }
        return number;
    }

    /**
     * @return Returns the footerVisibleOnCurrentPage.
     */
    public boolean isFooterVisibleOnPage() {
        if (groupType == ReportGroup.GROUP_TYPE_PAGE) {
            return true;
        } else {
            return this.footerVisibleOnPage;
        }
    }

    /**
     * @return Returns the headerVisibleOnCurrentPage.
     */
    public boolean isHeaderVisibleOnPage() {
        if (groupType == ReportGroup.GROUP_TYPE_PAGE) {
            return true;
        } else {
            return this.headerVisibleOnPage;
        }
    }

    /**
     * @param footerVisibleOnPage The footerVisibleOnPage to set.
     */
    public void setFooterVisibleOnPage(boolean footerVisibleOnPage) {
        this.footerVisibleOnPage = footerVisibleOnPage;// & this.footerVisible;
    }

    /**
     * @param headerVisibleOnPage The headerVisibleOnPage to set.
     */
    public void setHeaderVisibleOnPage(boolean headerVisibleOnPage) {
        this.headerVisibleOnPage = headerVisibleOnPage;// & this.headerVisible;
    }

    public boolean isFooterVisible() {
        return this.footerVisible & this.isFooterVisibleOnPage();
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public void setFooterVisible(boolean footerVisible) {
        this.footerVisible = footerVisible;
    }

    public boolean isHeaderVisible() {
        return this.headerVisible & this.isHeaderVisibleOnPage();
    }

    public void setHeaderVisible(boolean headerVisible) {
        this.headerVisible = headerVisible;
    }

    public void hideGroupsOnPage(int mode, boolean visibleOnPage) {
        ReportGroup currentGroup = report.getActiveGroup();
        while (this != currentGroup) {
            switch (mode) {
                case ReportGroup.GROUP:
                case ReportGroup.GROUP_ROW:
                    currentGroup.headerVisibleOnPage = false;
                    currentGroup.footerVisibleOnPage = false;
                    break;
                case ReportGroup.GROUP_HEADER:
                    currentGroup.headerVisibleOnPage = false;
                    break;
                case ReportGroup.GROUP_FOOTER:
                    currentGroup.footerVisibleOnPage = false;
                    break;
                default:
                    throw new IllegalArgumentException("Parameter 'mode' must be one of following: ReportGroup.GROUP, ReportGroup.GROUP_HEADER, ReportGroup.GROUP_FOOTER, ReportGroup.GROUP_ROW.");
            }
            currentGroup = currentGroup.getParentGroup();
        }
        switch (mode) {
            case ReportGroup.GROUP:
            case ReportGroup.GROUP_ROW:
                this.setHeaderVisibleOnPage(visibleOnPage);
                this.setFooterVisibleOnPage(visibleOnPage);
                break;
            case ReportGroup.GROUP_HEADER:
                this.setHeaderVisibleOnPage(visibleOnPage);
                break;
            case ReportGroup.GROUP_FOOTER:
                this.setFooterVisibleOnPage(visibleOnPage);
                break;
            default:
                throw new IllegalArgumentException("Parameter 'mode' must be one of following: ReportGroup.GROUP, ReportGroup.GROUP_HEADER, ReportGroup.GROUP_FOOTER, ReportGroup.GROUP_ROW.");
        }
    }

    public void showGroupsOnPage(int mode, boolean visibleOnPage) {
        ReportGroup currentGroup = report.getActiveGroup();
        while (this != currentGroup) {
            switch (mode) {
                case ReportGroup.GROUP:
                case ReportGroup.GROUP_ROW:
                    currentGroup.headerVisibleOnPage = true;
                    currentGroup.footerVisibleOnPage = true;
                    break;
                case ReportGroup.GROUP_HEADER:
                    currentGroup.headerVisibleOnPage = true;
                    break;
                case ReportGroup.GROUP_FOOTER:
                    currentGroup.footerVisibleOnPage = true;
                    break;
                default:
                    throw new IllegalArgumentException("Parameter 'mode' must be one of the following: ReportGroup.GROUP, ReportGroup.GROUP_HEADER, ReportGroup.GROUP_FOOTER, ReportGroup.GROUP_ROW.");
            }
            currentGroup = currentGroup.getParentGroup();
        }
        switch (mode) {
            case ReportGroup.GROUP:
            case ReportGroup.GROUP_ROW:
                this.setHeaderVisibleOnPage(visibleOnPage);
                this.setFooterVisibleOnPage(visibleOnPage);
                break;
            case ReportGroup.GROUP_HEADER:
                this.setHeaderVisibleOnPage(visibleOnPage);
                break;
            case ReportGroup.GROUP_FOOTER:
                this.setFooterVisibleOnPage(visibleOnPage);
                break;
            default:
                throw new IllegalArgumentException("Parameter 'mode' must be one of the following: ReportGroup.GROUP, ReportGroup.GROUP_HEADER, ReportGroup.GROUP_FOOTER, ReportGroup.GROUP_ROW.");
        }
    }

    public void setActivePage(int number) {
        if (report.getViewMode() == Report.VIEW_MODE_WEB
                && this.groupType == ReportGroup.GROUP_TYPE_REPORT
                && this.items instanceof ReportGroups) {
            ((ReportGroups) items).setActiveGroupNumber(number);
        }
    }
    
    //TODO: remove from release
    public String toHash() {
        return "@" + Integer.toHexString(hashCode());
    }

    public List getFooterControlNames() {
        return Collections.unmodifiableList(footerControlNames);
    }
    public List getHeaderControlNames() {
        return Collections.unmodifiableList(headerControlNames);
    }
    
    private String garbleName(String name, int mode) {
        if (mode == ReportGroup.GARBLE_MODE_COMPUTE) {
            name += ReportGroup.COMPUTE_AT_SUFFIX + "." + this.groupId;
        } else if (mode == ReportGroup.GARBLE_MODE_RESET) {
            name += ReportGroup.RESET_AT_SUFFIX + "." + this.groupId;
        }
        return name;
    }
}



//End ReportGroup class

