//ReportAction class @0-32E36EFC
/*
 * $Revision: 1.13 $
 * $Date: 2005/05/04 05:41:41 $
 */
package com.codecharge.components.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.codecharge.Action;
import com.codecharge.components.Control;
import com.codecharge.components.Link;
import com.codecharge.components.Model;
import com.codecharge.components.Report;
import com.codecharge.components.ReportLabel;
import com.codecharge.components.report.DefaultHandler;
import com.codecharge.components.report.ReportGroup;
import com.codecharge.util.StringUtils;
import com.codecharge.util.ModelAttribute;


public class ReportAction extends AbstractAction {
    
    protected Report model;
    protected double lineNumber;
    private List headerSections;
    private List footerSections;
    private String groupToClose;
    
    
    private boolean rowBound;
    private HashMap groupsRow = new HashMap();
    
    public ReportAction() {
        super();
    }
    
    public ReportAction(Action action) {
        super(action);
    }

    public String perform(com.codecharge.components.Report model) {
        this.model = model;
        action.setProperties(this.model, Action.GET);
        action.setActivePermissions(this.model);
        read();
        return null;
    }

    protected void bindReportRow(Report model, Object row, Object firstRow, Collection controlNames, boolean addRow) {
        if (addRow) {
            model.addRowInstance(row);
        }

        Collection controls = model.getChildren();
        if (controls != null) {
            boolean isGroupMode = false;
            for (Iterator itControls = controlNames.iterator(); itControls.hasNext();) {
                String controlName = null;
                Object obj = itControls.next(); 
                if (obj instanceof String) {
                    controlName = (String) obj;
                    isGroupMode = true;
                } else { // com.codecharge.component.Model
                    controlName = ((Model) obj).getName();
                }
                Model m = model.getChild(controlName);
                if (m instanceof Control) {


                    {//Name Space Splitter (start)
                        Iterator rAttrs = m.getAttributeKeys().iterator();
                        while (rAttrs.hasNext()) {
                            String rAttrName = (String)rAttrs.next();
                            ModelAttribute brAttr = bindRowAttribute ( (ModelAttribute)m.getAttribute( rAttrName ), row, dataBinder);
                            m.setAttribute(brAttr.getName(), brAttr);
                        }
                    }//Name Space Splitter (end)

                    Control control = (Control) m;
                    boolean debug = false;
                    if (!StringUtils.isEmpty(control.getFieldSource()) 
                            && !("SpecialValue".equals(control.getControlSourceType()))) {
                        if (isGroupMode) {
                            if (m instanceof ReportLabel) {
                                ReportLabel rl = model.getReportLabel(controlName);
                                //calculate group controls without function only!!!
                                if (rl.getFunction() == null) {// || rl.getFunction() instanceof DefaultHandler) {
                                    rl.calculate(dataBinder.getFieldValue(firstRow, rowProvider.getOutDbParameters(), rl));
                                } else if (rl.getFunction() instanceof DefaultHandler) {
                                    Object value = dataBinder.getFieldValue(firstRow, rowProvider.getOutDbParameters(), rl);
                                    rl.setValue(value);
                                    rl.setFunctionValue(value);
                                } else {
                                    Object oldValue = rl.getFunctionValue();
                                    rl.initValue();
                                    if (rl.getFunctionValue() == null) {
                                        rl.setValue(oldValue);
                                        rl.setFunctionValue(oldValue);
                                    }
                                }
                            } else {
                                Control c = model.getControl(controlName);
                                dataBinder.setControlValueFromDb(c, dataBinder.getFieldValue(firstRow, rowProvider.getOutDbParameters(), control));
                                if (c instanceof Link) {
                                    setLinkProperties(firstRow, rowProvider.getOutDbParameters(), (Link) c);
                                }
                            }
                        } else {
                            if (m instanceof ReportLabel) {
                                ReportLabel rl = model.getReportLabel(controlName);
                                //calculate detail controls and group controls with function
                                if (model.isDetailControl(controlName)) {
                                    rl.calculate(dataBinder.getFieldValue(row, rowProvider.getOutDbParameters(), rl));
                                } else if (rl.getFunction() instanceof DefaultHandler) {
                                    rl.calculate(dataBinder.getFieldValue(row, rowProvider.getOutDbParameters(), rl), false);
                                } else if (rl.getFunction() != null) {
                                    rl.calculate(dataBinder.getFieldValue(row, rowProvider.getOutDbParameters(), rl));
                                }
                            } else {
                                if (model.isDetailControl(controlName)) {
                                    Control c = model.getControl(controlName);
                                    dataBinder.setControlValueFromDb(c, dataBinder.getFieldValue(row, rowProvider.getOutDbParameters(), control));
                                    if (c instanceof Link) {
                                        setLinkProperties(row, rowProvider.getOutDbParameters(), (Link) c);
                                    }
                                }
                            }
                        }
                    } else if (m instanceof ReportLabel) {
                        ReportLabel rl = model.getReportLabel(controlName);
                        if (rl.getFunction() != null && ! isGroupMode) {
                            rl.calculate(null);
                        }
                    } else if (m instanceof Link) {
                        if (isGroupMode) {
                            setLinkProperties(firstRow, rowProvider.getOutDbParameters(), (Link) m);
                        } else {
                            if (model.isDetailControl(controlName)) {
                                setLinkProperties(row, rowProvider.getOutDbParameters(), (Link) m);
                            }
                        }
                    }
                }
            } // end of iteration of controls
        }
    }

    public void bind(Object rows) {
        rowProvider.setRows(rows);
        bind();
    }
    
    public void bind() {
        List groups = model.getGroups();
        HashMap groupsFields = new HashMap();
        Object row = null;
        Object cachedRow = null;
        boolean doStep = false;
        int nrow = 0;
        lineNumber = 0;
        NullValue initValue = new NullValue();
        String rowGroupName = model.getActiveGroup().getName();
        if (rowProvider.hasNextRow()) {
            for (int i = 0; i < groups.size(); i++) {
                groupsFields.put(groups.get(i), initValue);
            }
            row = rowProvider.nextRow();
            // map contains group that sholud be closed
            HashMap groupToClose = new HashMap();
            do {
                cachedRow = row;
                if (nrow == 0) { 
                    openReport(row, groupsFields);
                }
                /* 
                 * variable 'addRow' guarantees that for one data row will be added only one report row
                 * during handling value of this variable will set to false to prevent adding extra report rows
                 */
                boolean addRow = true;
                /* if groupOpened is true it means that some group will opened during handling current data row */
                boolean groupOpened = false;
                /* if groupClosed is true it means that some group will closed during handling current data row */
                boolean groupClosed = false;

                String groupName = null;
                // headers
                for (int i = 0; i < groups.size(); i++) {
                    groupName = (String) groups.get(i);
                    if (! isEquals(groupsFields.get(groupName), 
                            dataBinder.getFieldValue(row, model.getGroup(groupName).getSourceColumnName()))) {
                        if (!groupOpened) {
                            model.addGroupInstance(groupName);
                            groupOpened = true;
                            ReportGroup grp = model.getActiveGroup();
                            while (groupName != grp.getName()) {
                                groupsRow.put(grp.getName(), row);
                                grp = grp.getParentGroup();
                            }
                            groupsRow.put(grp.getName(), row);
                        }
                        openGroup(groupName, row, addRow);
                        addRow = false;
                    } else if (groupOpened) {
                        bindRowToGroup(groupName, row, addRow);
                    }
                    groupsFields.put(groupName, dataBinder.getFieldValue(row, 
                                model.getGroup(groupName).getSourceColumnName()));
                }

                // rows
                addRow(rowGroupName, row, addRow);
                addRow = false;
                
                if (rowProvider.hasNextRow()) {
                    row = rowProvider.nextRow();
                    doStep = true;
                } else {
                    doStep = false;
                }
                
                // footers
                // initialise the map contains group that sholud be closed
                groupToClose.clear();
                boolean closeGroup = false;
                for (int i = 0; i < groups.size(); i++) {
                    groupName = (String) groups.get(i);
                    if (! closeGroup && ! isEquals(dataBinder.getFieldValue(row, model.getGroup(groupName).getSourceColumnName()), 
                            dataBinder.getFieldValue(cachedRow, model.getGroup(groupName).getSourceColumnName()))) {
                        closeGroup = true;
                    }
                    if (closeGroup) {
                        groupToClose.put(groupName, groupName);
                    }
                }

                for (int i = groups.size() - 1; i > -1; i--) {
                    groupName = (String) groups.get(i);
                    if (groupToClose.get(groupName) != null) {
                        closeGroup(groupName, cachedRow, addRow);
                        addRow = false;
                    }
                }

                nrow++;
            } while (doStep);
            closeReport(row);
        }
    }
    
    private boolean isEquals(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return true;
        } else if (o1 == null || o2 == null) {
            return false;
        }
        return o1.equals(o2);
    }

    private void openReport(Object row, HashMap groupsFields) {
        List groups = model.getGroups();
        model.getGroup("Report").fireOnInitializeHeaderEvent(row);
        model.getGroup("Report").open(row);
        boolean addRow = false;
        bindReportRow(model, row, row, model.getGroup("Report").getHeaderControlNames(), addRow);
        model.getGroup("Report").fireOnCalculateHeaderEvent(row);
        if (model.getGroup("Report").isHeaderVisible()) {
            lineNumber += model.getGroup("Report").getHeaderHeight();
        }
        openPage(row);
        groupsRow.put("Report", row);
        groupsRow.put("Page", row);
            
    }
    
    private void openPage(Object row) {
        model.getGroup("Page").fireOnInitializeHeaderEvent(row);
        if (model.getGroup("Page").isHeaderVisible()) {
            lineNumber += model.getGroup("Page").getHeaderHeight(); 
        }
        bindReportRow(model, row, row, model.getGroup("Page").getHeaderControlNames(), false);
        model.getGroup("Page").fireOnCalculateHeaderEvent(row);
    }
    
    private void closePage(String groupName, int mode, Object row) {
        model.getGroup("Page").fireOnInitializeFooterEvent(row);
        bindReportRow(model, row, groupsRow.get("Page"), model.getGroup("Page").getFooterControlNames(), false);
        if (model.getGroup("Page").isFooterVisibleOnPage()) {
            model.getGroup("Page").fireOnCalculateFooterEvent(row);
        }
        createNewPage(groupName, mode, row);
        lineNumber = 0;
        model.incrementPageNumber();
    }

    private void openGroup(String groupName, Object row, boolean addRow) {
        model.getGroup(groupName).open(row);
        rowBound = false;

        model.getGroup(groupName).fireOnInitializeHeaderEvent(row);
        
        if (lineNumber + model.getGroup(groupName).getHeaderHeight() > getTopMargin()) {
            closePage(groupName, ReportGroup.GROUP_HEADER, row);
            openPage(row);
            groupsRow.put("Page", row);
            model.getGroup("Page").open(row);
            addRow = true;
        }
        if (model.getGroup(groupName).isHeaderVisible()) {
            lineNumber += model.getGroup(groupName).getHeaderHeight();
        }
        
        bindReportRow(model, row, row, model.getGroup(groupName).getHeaderControlNames(), addRow);
        if (model.getGroup(groupName).isHeaderVisibleOnPage()) {
            model.getGroup(groupName).fireOnCalculateHeaderEvent(row);
        }
        this.groupToClose = groupName;
    }
    
    private void bindRowToGroup(String groupName, Object row, boolean addRow) {
        model.getGroup(groupName).open(row);
        rowBound = false;

        model.getGroup(groupName).fireOnInitializeHeaderEvent(row);
        
        if (lineNumber + model.getGroup(groupName).getHeaderHeight() > getTopMargin()) {
            closePage(groupName, ReportGroup.GROUP_HEADER, row);
            openPage(row);
            groupsRow.put("Page", row);
            model.getGroup("Page").open(row);
            addRow = true;
        }
        if (model.getGroup(groupName).isHeaderVisible()) {
            lineNumber += model.getGroup(groupName).getHeaderHeight();
        }
        
        bindReportRow(model, row, row, model.getGroup(groupName).getHeaderControlNames(), addRow);
        if (model.getGroup(groupName).isHeaderVisibleOnPage()) {
            model.getGroup(groupName).fireOnCalculateHeaderEvent(row);
        }
    }
    
    private void closeGroup(String groupName, Object row, boolean addRow) {
        HashMap firstRows = new HashMap(groupsRow);
        model.getGroup(groupName).fireOnInitializeFooterEvent(row);
        if (lineNumber + model.getGroup(groupName).getFooterHeight() > getTopMargin()) {
            closePage(groupName, ReportGroup.GROUP_FOOTER, row);
            openPage(row);
            groupsRow.put("Page", row);
            //model.getGroup("Page").open(row);
            addRow = false;
        }
        
        if (model.getGroup(groupName).isFooterVisible()) {
            lineNumber += model.getGroup(groupName).getFooterHeight();
        }
        
        bindReportRow(model, row, firstRows.get(groupName), model.getGroup(groupName).getFooterControlNames(), addRow);
        model.getGroup(groupName).close(row);
        if (model.getGroup(groupName).isFooterVisibleOnPage()) {
            model.getGroup(groupName).fireOnCalculateFooterEvent(row);
        }
        this.groupToClose = model.getGroup(groupName).getParentGroup().getName();
    }
    
    private void addRow(String groupName, Object row, boolean addRow) {
        model.fireOnInitializeRowEvent(row);
        if (model.getDetailRow().getHeight() > 0) {
            if (model.getDetailRow().isVisible()
                    && lineNumber + model.getDetailRow().getHeight() > getTopMargin()) {
                closePage(groupName, ReportGroup.GROUP_ROW, row);
                openPage(row);
                groupsRow.put("Page", row);
                addRow = false;
            }
        }

        bindReportRow(model, row, row, model.getChildren(), addRow);
        rowBound = true;
        if (model.getDetailRow().isVisible()) {
            model.getCurrentRow().setVisibleOnPage(true);
            lineNumber += model.getDetailRow().getHeight();
        }
        if (model.getDetailRow().isVisible()) {
            model.fireOnCalculateRowEvent(row);
        }
    }

    private void closeReport(Object row) {
        ReportGroup currentGroup = model.getActiveGroup();
        if (this.groupToClose != null) {
            currentGroup = model.getGroup(this.groupToClose);
        }
        while (!"Page".equals(currentGroup.getName())) {
            if (lineNumber + model.getGroup(currentGroup.getName()).getFooterHeight() > getTopMargin()){
                closePage(currentGroup.getName(), ReportGroup.GROUP_FOOTER, row);
                openPage(row);
            }
            
            if (model.getGroup(currentGroup.getName()).isFooterVisible()) {
                lineNumber += model.getGroup(currentGroup.getName()).getFooterHeight();
            }
            bindReportRow(model, row, groupsRow.get(currentGroup.getName()), model.getGroup(currentGroup.getName()).getFooterControlNames(), false);
            model.getGroup(currentGroup.getName()).close(row);
            
            if (model.getGroup(currentGroup.getName()).isFooterVisibleOnPage()) {
                model.getGroup(currentGroup.getName()).fireOnCalculateFooterEvent(row);
            }
            currentGroup = currentGroup.getParentGroup();
        }
        //now currentGroup is Page
        //close Page
        model.getGroup("Page").fireOnInitializeFooterEvent(row);
        bindReportRow(model, row, groupsRow.get("Page"), currentGroup.getFooterControlNames(), false);
        currentGroup.close(row);
        model.getGroup("Report").fireOnInitializeFooterEvent(row);
        if (lineNumber + model.getGroup("Report").getFooterHeight() > getTopMargin()) {
            if (model.getGroup("Page").isFooterVisibleOnPage()) {
                model.getGroup("Page").fireOnCalculateFooterEvent(row);
            }
            model.addGroupInstance("Page");
            model.addInternalRowInstance();
            model.getCurrentRow().setVisibleOnPage(false);
            lineNumber = 0;
            model.incrementPageNumber();
            openPage(row);
            model.getGroup("Page").open(row);
            model.getGroup("Page").fireOnInitializeHeaderEvent(row);
            bindReportRow(model, row, groupsRow.get("Page"), model.getGroup("Page").getHeaderControlNames(), false);
            model.getGroup("Page").hideGroupsOnPage(ReportGroup.GROUP_HEADER, true);
            model.getGroup("Page").showGroupsOnPage(ReportGroup.GROUP_FOOTER, true);

            currentGroup = model.getActiveGroup();
            while (!"Page".equals(currentGroup.getName())) {
                currentGroup.setFooterVisibleOnPage(false);
                currentGroup = currentGroup.getParentGroup();
            }
            
            model.getGroup("Page").fireOnInitializeFooterEvent(row);
            bindReportRow(model, row, groupsRow.get("Page"), model.getGroup("Page").getFooterControlNames(), false);
            model.getGroup("Page").close(row);
        }
        
        //close Report
        bindReportRow(model, row, groupsRow.get("Report"), model.getGroup("Report").getFooterControlNames(), false);
        model.getGroup("Report").setFooterVisibleOnPage(true);
        model.getGroup("Report").fireOnCalculateFooterEvent(row);
        model.getGroup("Report").close(row);
        //fire Page event
        if (model.getGroup("Page").isFooterVisibleOnPage()) {
            model.getGroup("Page").fireOnCalculateFooterEvent(row);
        }
    }

    private void createNewPage(String groupName, int mode, Object row) {
        ReportGroup group = model.getGroup(groupName);
        ReportGroup oldActiveGroup = model.getActiveGroup();
        switch (mode) {
            case ReportGroup.GROUP_ROW :
                if (group.itemsNumber() == 0) {
                    model.addInternalRowInstance();
                    rowBound = false;
                }
                if (! rowBound) {
                    model.getCurrentRow().setVisibleOnPage(false);
                }
                
                group.hideGroupsOnPage(ReportGroup.GROUP_HEADER, group.isHeaderVisible());
                model.getGroup("Page").hideGroupsOnPage(ReportGroup.GROUP_FOOTER, true);
                model.getGroup("Page").close(row);
                model.addGroupInstance("Page");
                model.addInternalRowInstance();
                model.getGroup("Page").open(row);
                model.getGroup("Page").hideGroupsOnPage(ReportGroup.GROUP_HEADER, true);
                ReportGroup.shareControls(oldActiveGroup, model.getActiveGroup());
                break;
            case ReportGroup.GROUP_HEADER :
                if (!"Page".equals(groupName)) {
                    if (group.itemsNumber() == 0) {
                        model.addInternalRowInstance();
                        rowBound = false;
                    }
                    if (! rowBound) {
                        model.getCurrentRow().setVisibleOnPage(false);
                    }
                    group.hideGroupsOnPage(ReportGroup.GROUP_HEADER, false);
                    group.setHeaderVisibleOnPage(false);
                    model.getGroup("Page").hideGroupsOnPage(ReportGroup.GROUP_FOOTER, true);
                    model.getGroup("Page").close(row);
                    model.addGroupInstance("Page");
                    
                    model.addInternalRowInstance();
                    model.getCurrentRow().setVisibleOnPage(false);
                    
                    model.getGroup("Page").open(row);
                    group = model.getGroup(groupName);
                    model.getGroup("Page").hideGroupsOnPage(ReportGroup.GROUP_HEADER, true);
                    model.getGroup(groupName).showGroupsOnPage(ReportGroup.GROUP_HEADER, true);
                    ReportGroup.shareControls(oldActiveGroup, model.getActiveGroup());
                    group.setHeaderVisibleOnPage(true);
                }
                break;
            case ReportGroup.GROUP_FOOTER :
                if (!"Page".equals(groupName)) {
                    model.getGroup("Page").hideGroupsOnPage(ReportGroup.GROUP_FOOTER, true);
                    group.showGroupsOnPage(ReportGroup.GROUP_FOOTER, false);
                    model.getGroup("Page").close(row);
                    model.addGroupInstance("Page");
                    group = model.getGroup(groupName);
                    
                    if (group.itemsNumber() == 0) {
                        model.addInternalRowInstance();
                        rowBound = false;
                    }
                    if (! rowBound) {
                        model.getCurrentRow().setVisibleOnPage(false);
                    }
                    
                    model.getGroup("Page").open(row);
                    ReportGroup.shareControls(oldActiveGroup, model.getActiveGroup());
                    model.getGroup("Page").hideGroupsOnPage(ReportGroup.GROUP_HEADER, true);
                    model.getGroup("Page").showGroupsOnPage(ReportGroup.GROUP_FOOTER, true);
                    group.hideGroupsOnPage(ReportGroup.GROUP_FOOTER, true);
                    group.setFooterVisibleOnPage(true);
                }
                break;
        }
    }
    
    
    private double getTopMargin() {
        double topMargin = 0;
        if (model.getPageSize() > 0) {
            topMargin = model.getPageSize() - model.getGroup("Page").getFooterHeight();
        } else {
            topMargin = Double.MAX_VALUE;
        }
        return topMargin;
    }
    
    private class NullValue {
        public NullValue() {};
        
        public boolean equals(Object o) {
            if (o instanceof NullValue) {
                return true;
            }
            return false;
        }
        
        public int hashCode() {
            return 0;
        }
    }
    
    public void setModel(Report model) {
        this.model = model;
    }
}




//End ReportAction class

