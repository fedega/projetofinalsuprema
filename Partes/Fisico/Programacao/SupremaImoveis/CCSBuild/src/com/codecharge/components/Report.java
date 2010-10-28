//Report class @0-132CCA11
/*
 * $Revision: 1.33 $ 
 * $Date: 2005/05/26 14:09:47 $
 */
package com.codecharge.components;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.codecharge.components.report.MutableDouble;
import com.codecharge.components.report.ReportGroup;
import com.codecharge.components.report.ReportRow;
import com.codecharge.events.DataObjectEvent;
import com.codecharge.events.DataObjectListener;
import com.codecharge.events.Event;
import com.codecharge.events.ReportListener;
import com.codecharge.events.SectionListener;
import com.codecharge.util.StringUtils;
import com.codecharge.util.ModelAttribute;

/**
 * Represented CodeCharge Studio Report component.
 * The Report can be in one two states:
 *  - constructing model 
 *  - populating model with data
 * The behaviors of many methods depend on report mode.
 */
public class Report extends Component implements Sortable, Navigable {

    /**
     * Constant meant that Report should be shown in web mode: one page per request with navigation
     */
    final static public int VIEW_MODE_WEB = 1;
    /**
     * Constant meant that Report should be shown in print mode: all pages without navigation
     */
    final static public int VIEW_MODE_PRINT = 2;

    /**
     * Contains groups in order of being added to report. This list doesn't contain special groups
     * such as Page and Report.
     */
    private java.util.List groupsOrder;

    /**
     * Map of all Report groups including Page and Report.
     */
    private Map groups = new HashMap();
    
    
    /**
     * The meaning of these variables depends on Report's mode.
     * If Report model creating this member contains last added group, this group will be used to 
     * add detailRow structure.
     * If Report is being filled by data this member contains the group where the detail row will be added
     */
    private ReportGroup activeGroup;
    
    /**
     * The root of Report groups hierarchy. Has value only if Report is being filled.
     */
    private ReportGroup data;
    
    /**
     * Structure of Report detail row.
     */
    private ReportRow detailControls = new ReportRow(null);
    
    /**
     * Current detail row. NULL before filling Report
     */
    private ReportRow currentRow;
    
    /**
     * Counter for Report detail rows. 
     */
    private int rowNumber;
    
    /**
     * Counter for Report lines. Is used to split Report on the pages
     */
    private double lineNumber;
    
    /**
     * Current page number
     */
    private int pageNumber;
    
    /**
     * Page number that was set from request to show specified page
     */
    private int webPageNumber;
    
    /**
     * Number of records that was obtained from DB
     */
    private long amountOfRows;

    /**
     * Number of Report pages
     */
    private int totalPages;
    
    /**
     * Actual size in lines of Report page
     */
    private int pageSize;
    
    /**
     * Maximal allowed page size
     */
    private int pageSizeLimit;
    
    /**
     * Page size in Web view mode
     */
    private int webPageSize;
    
    /**
     * Indicate whether print mode is allowed
     */
    private boolean enablePrintMode;
    
    /**
     * Page size in Print view mode
     */
    private int printPageSize;
    
    /**
     * Name of active sorter
     */
    private String sort;
    /**
     * Direction of sorting
     */
    private String dir;
    
    /**
     * current view mode
     */
    private int viewMode;
    
    /**
     * Map of Report sections
     */
    private HashMap sections;

    /**
     * Indicates that new page was created when adding a report row or report group.
     */
    private boolean newPageOpened;
    
	private boolean footIsDo = false;
	private boolean lastFootIsDo  = false;
	private String htmlTemplateType;
    /**
     * Creates Report with given name.
     * @param name - Report name
     */
    public Report(String name) {
        super(name);
        groupsOrder = new ArrayList();
        ReportGroup report = createGroup("Report");
        groups.put("Report", report);
        activeGroup = report.getGroup("Page");
        groups.put("Page", activeGroup);
        activeGroup.setReport(this);
        report.setReport(this);
        groupsOrder = new ArrayList();
        lineNumber = 0;
        pageNumber = 0;
        webPageNumber = 1;
        sections = new HashMap();
        enablePrintMode = false;
    }

    /**
     * Creates ReportGroup with given name and without source field.
     * @param name name of group
     * @return ReportGroup instance that was created. Never returns NULL.
     */
    public ReportGroup createGroup(String name) {
        return createGroup(name, null);
    }
    
    /**
     * Creates ReportGroup with given name and source field.
     * @param name
     * @param sourceName
     * @return ReportGroup instance that was created. Never returns NULL.
     */
    public ReportGroup createGroup(String name, String sourceName) {
        ReportGroup group = new ReportGroup(name, sourceName, activeGroup);
        groups.put(name, group);
        group.setReport(this);
        if (activeGroup != null) {
            activeGroup.addGroup(group);
        }
        activeGroup = group;
        if (!StringUtils.isEmpty(sourceName))
            groupsOrder.add(name);
        return group;
    }

    /**
     * Returns group with given name. The behavior of this method depends on Report mode.
     * In constructing model Report mode the method returns group from map groups that defines 
     * group structure.
     * In populating model with data Report mode the method returns the group that is used to fill with data.
     * @param name
     * @return
     */
    public ReportGroup getGroup(String name) {
        ReportGroup group = null;
        if (data == null) {
            group = (ReportGroup) groups.get(name);
        } else {
            if ("Report".equals(name)) {
                group = data;
            } else {
                group = data.getGroup(name);
            }
        }
        if (group == null) {
            MessageFormat fmt = new MessageFormat(res.getString("Report.NoSuchGroup"));
            throw new NoSuchComponentException(fmt.format(new String[]{getName(), name}));
        }
        return group;
    }

    /**
     * Returns true if Report contains the group with given name
     * @param name Name of tested group
     * @return true if Report contains the group with given name
     */
    public boolean hasGroup(String name) {
        return groups.containsKey(name);
    }

    /**
     * Returns Report view mode.
     * If print view mode is disabled Report.SHOW_MODE_WEB will always be returned.
     */
    public int getViewMode() {
        if (isEnablePrintMode()) {
            return viewMode;
        } else {
            return Report.VIEW_MODE_WEB;
        }
    }

    /**
     * Set Report view mode.
     * 
     * @param mode
     *            The requested Report view mode. It can be specified using
     *            constants Report.VIEW_MODE_WEB and Report.VIEW_MODE_PRINT.
     */
    public void setViewMode(int mode) {
        if (mode == Report.VIEW_MODE_PRINT && isEnablePrintMode()) {
            viewMode = Report.VIEW_MODE_PRINT;
            pageSize = printPageSize;
            return;
        }
        viewMode = Report.VIEW_MODE_WEB;
        pageSize = webPageSize;
    }

    /**
     * Set Report view mode.
     * 
     * @param mode
     *            The requested Report view mode as string. The "print" value
     *            will turn-on the print view mode, otherwise the web view mode
     *            will be set. If parameter mode is null/empty, the method does nothing.
     */
    public void setViewMode(String mode) {
        if (StringUtils.isEmpty(mode)) {
            return;
        }
        int reportMode = Report.VIEW_MODE_WEB;
        if ("print".equalsIgnoreCase(mode)) {
            reportMode = Report.VIEW_MODE_PRINT;
        }
        setViewMode(reportMode);
    }

    /**
     * Returns List of groups to iterate.
     * @return
     */
    public java.util.List getGroups() {
        return Collections.unmodifiableList(groupsOrder);
    }

    /**
     * Adds the given Model to Report detail controls collection.
     * @see com.codecharge.components.Component#add(com.codecharge.components.Model)
     */
    public void add(Model model) {
        addDetailControl(model);
    }

    public void freezeStructure() {
        getGroup("Report").freezeStructure();
        groups.put("Report", getGroup("Report"));
        groups.put("Page", getGroup("Report").getGroup("Page"));
        for (Iterator it = groupsOrder.iterator(); it.hasNext(); ) {
            String groupName = (String) it.next();
            groups.put(groupName, getGroup("Report").getGroup(groupName));
        }
    }
    
    /**
     * Adds the given Model to Report detail controls collection.
     * When this method is used it freezes the group structure and new groups cannott be added.
     */
    public void addDetailControl(Model model) {
        if (model == null)
            throw new IllegalArgumentException("Parameter control can't be null."); //TODO:
                                                                                    // messageBundle
        if (data == null) {
            data = ((ReportGroup) groups.get("Report")).createInstance(null);
        }
        getGroup("Report").freezeStructure();
        detailControls.addControl(model);
        super.add(model);
        if (model instanceof ReportLabel) {
            ReportLabel rl = (ReportLabel) model;
            if (!StringUtils.isEmpty(rl.getResetAt())) {
                ReportLabel rl1 = (ReportLabel) rl.clone();
                //rl1.setParent(null);
                rl1.setResetAt(null);
                getGroup(rl.getResetAt()).addResetAtReportLabel(rl1);
            }
            if (!StringUtils.isEmpty(rl.getComputeAt())) {
                ReportLabel rl1 = (ReportLabel) rl.clone();
                //rl1.setParent(null);
                rl1.setResetAt(null);
                rl1.setComputeAt(null);
                rl1.setComputeAtFunction(null);
                rl1.setFunction(null);
                getGroup(rl.getComputeAt()).addComputeAtReportLabel(rl1);
            }
        }
        model.setParent(this);
    }

    /**
     * Adds the given model to specified Report group
     * @param groupName Name of group to add the model to
     * @param model Model to add
     * @exception IllegalArgumentException if Report doesn't contain such group or parameter model is null
     */
    public void addGroupControl(String groupName, Model model) {
        addGroupControl(groupName, model, ReportGroup.GROUP_HEADER);
    }
    public void addGroupControl(String groupName, Model model, int mode) {
        if (model == null)
            throw new IllegalArgumentException("Parameter model can't be null."); //TODO:
                                                                                    // messageBundle
        if (!StringUtils.isEmpty(groupName)) {
            ReportGroup group = getGroup(groupName);
            if (group != null) {
                group.addControl(model, mode);
                super.add(model);
                model.setParent(this);
                if (model instanceof ReportLabel) {
                    ReportLabel rl = (ReportLabel) model;
                    if (!StringUtils.isEmpty(rl.getResetAt())) {
                        ReportLabel rl1 = (ReportLabel) rl.clone();
                        //rl1.setParent(null);
                        rl1.setResetAt(null);
                        getGroup(rl.getResetAt()).addResetAtReportLabel(rl1);
                    }
                    if (!StringUtils.isEmpty(rl.getComputeAt())) {
                        ReportLabel rl1 = (ReportLabel) rl.clone();
                        //rl1.setParent(null);
                        rl1.setResetAt(null);
                        rl1.setComputeAt(null);
                        rl1.setComputeAtFunction(null);
                        rl1.setFunction(null);
                        getGroup(rl.getComputeAt()).addComputeAtReportLabel(rl1);
                    }
                }
            } else {
                throw new IllegalArgumentException(
                        "addGroupControl: The report doesn't contain group '" + groupName + "'");
            }
        }
    }

    /**
     * Returns string representation of the Report.
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("Report name: " + name + "\n");
        if (data == null) {
            sb.append(getGroup("Report").toString());
        } else {
            sb.append(data.toString());
        }
        return sb.toString();
    }

    /**
     * Adds new instance of detail row to the Report.
     * This method is used in the populating model with data Report mode.
     * After adding row instance the added row becomes an active row and all its controls can be accessed with
     * report.getControl("controlname") functions.
     * @exception IllegalStateException if report structure is not frozen. 
     */
    public boolean addRowInstance(Object row) {
        if (! getGroup("Report").isStructureFrosen()) {
            throw new IllegalStateException("You can't add row instance. Reason: report structure is not defined properly."); //TODO i18n
        }
        if (data == null) {
            data = ((ReportGroup) groups.get("Report")).createInstance(null);
        }
        ReportGroup oldActiveGroup = activeGroup;
        currentRow = detailControls.createInstance(data.getActiveGroup());
        activeGroup = data.getActiveGroup();
        activeGroup.addRow(currentRow);
        return true;
    }

    /**
     * Adds new instance of detail row to the Report.
     * It is assumed that this method will be used for internal framework purposes only.
     * This method is used to split report on pages.
     * 
     */
    public void addInternalRowInstance() {
        if (data == null) {
            data = ((ReportGroup) groups.get("Report")).createInstance(null);
        }
        currentRow = detailControls.createInstance(data.getActiveGroup());
        activeGroup = data.getActiveGroup();
        activeGroup.addRow(currentRow);
    }

    /**
     * Adds new instance of group with given name to the Report.
     * This method creates hierarchy of groups from specified group and adds it to the Report.
     * If parameter groupName is null or is empty the method does nothing.
     * @param groupName Name of group of which the instance must be added.
     * @exception IllegalStateException if report structure is not frozen. 
     */
    public void addGroupInstance(String groupName) {
        if (! getGroup("Report").isStructureFrosen()) {
            throw new IllegalStateException("You can't add group instance. Reason: report structure is not defined properly."); //TODO i18n
        }
        if (StringUtils.isEmpty(groupName)) {
            return;
        }
        if (data == null) {
            data = ((ReportGroup) groups.get("Report")).createInstance(null);
        }
        ReportGroup group = ((ReportGroup) groups.get(groupName));
        ReportGroup parent = data.getGroup(group.getParentGroup().getName());
        ReportGroup newGroup = group.createInstance(parent);
        parent.addGroupInstance(newGroup);
        activeGroup = data.getActiveGroup();
    }

    /**
     * Returns null.
     * This method can be used with Report component. 
     * Use getCurrentRow method instead.
     * @see com.codecharge.components.Component#currentRow()
     */
    public HashMap currentRow() {
        return null;
    }

    /**
     * Returns null.
     * This method can be used with Report component. 
     * Use nextReportRow method instead.
     * @see com.codecharge.components.Component#nextRow()
     */
    public HashMap nextRow() {
        return null;
    }

    /**
     * Initialize the Report component to show.
     */
    public void initIterator() {
        if (data != null) {
            data.initIterator();
            rowNumber = 0;
            lineNumber = 0;
            pageNumber = 0;
            if (pageSize > 0 && pageSize < Integer.MAX_VALUE) {
                totalPages = data.groupsNumber();
            } else {
                totalPages = 1;
            }
            currentRow = null;
            
            if (getViewMode() == Report.VIEW_MODE_WEB) {
                //show only one page
                int currentPage = this.webPageNumber;
                if (currentPage < 1) {
                    currentPage = 1;
                }
                if (currentPage > this.totalPages) {
                    currentPage = this.totalPages;
                }
                pageNumber = currentPage - 1;
                data.setActivePage(currentPage);
            }
            
        }
    }

    /**
     * @see com.codecharge.components.Component#hasNextRow()
     */
    public boolean hasNextRow() {
        boolean result = false;
        if (data != null) {
            result = data.hasNextRow();
        }
        return result;
    }

    /**
     * @see com.codecharge.components.Component#initializeRows()
     */
    public void initializeRows() {
        initIterator();
    }

    /**
     * Returns the next Report row.
     */
    public ReportRow nextReportRow() {
        if (data != null) {
            currentRow = data.nextRow();
            if (currentRow.isVisibleOnPage()) {
                rowNumber++;
            }
            //this.nextAttrRow();
            return currentRow;
        } else {
            return null;
        }
    }

    /**
     * Returns the ReportLabel component with specified name.
     * @param name Name of the ReportLabel component
     * @exception com.codecharge.components.NoSuchComponentException if the Report doesn't contains the ReportLabel with given name.
     */
    public ReportLabel getReportLabel(String name) {
        Model m = getChild(name);
        ReportLabel rl = null;
        if (m instanceof ReportLabel) {
            rl = (ReportLabel) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "ReportLabel", name} ));
        }
        return rl;
    }

    /**
     * @see com.codecharge.components.Component#getChild(java.lang.String)
     */
    public Model getChild(String name) {
        Model m = null;
        if (currentRow != null) {
            m = currentRow.getControl(name);
        } else {
            m = detailControls.getControl(name);
            if (m == null) {
                m = activeGroup.getControl(name);
            }
        }
        if (m == null) {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "child", name} ));
        }
        return m;
    }

    /**
     * Returns the number of the Report lines or zero if the Report is not populated with data.
     */
    public double size() {
        if (data != null) {
            return data.linesNumber();
        }
        return 0;
    }

    /**
     * Returns the number of the ReportRows that is contained in the Report or zero if the Report is not populated with data.
     */
    public int itemsNumber() {
        if (data != null) {
            return data.itemsNumber();
        }
        return 0;
    }

    /**
     * Adds ReportListener to listener collection.
     * @param l ReportListener to be added
     */
    public synchronized void addReportListener(ReportListener l) {
        listeners.addElement(l);
    }

    /**
     * Removes ReportListener from listener collection.
     * @param l ReportListener to be removed
     */
    public synchronized void removeReportListener(ReportListener l) {
        listeners.removeElement(l);
    }

    /**
     * Adds ReportListener to listener collection.
     * @param l ReportListener to be added
     */
    public synchronized void addDetailListener(SectionListener l) {
        detailControls.addListener(l);
    }

    /**
     * Removes ReportListener from listener collection.
     * @param l ReportListener to be removed
     */
    public synchronized void removeDetailListener(SectionListener l) {
        detailControls.removeListener(l);
    }

    /**
     * Fires onInitialize event for detail row.
     * @param dataRow Object that holds the datasource data
     */
    public void fireOnInitializeRowEvent(Object dataRow) {
        if (currentRow != null) {
            currentRow.fireOnInitializeEvent(dataRow);
        }
    }

    /**
     * Fires onCalculate event for detail row.
     * @param dataRow Object that holds the datasource data
     */
    public void fireOnCalculateRowEvent(Object dataRow) {
        if (currentRow != null) {
            currentRow.fireOnCalculateEvent(dataRow);
        }
    }

    /**
     * Fires beforeShow event for detail row.
     */
    public void fireBeforeShowRowEvent() {
        if (currentRow != null) {
            currentRow.fireBeforeShowEvent();
        }
    }

    /**
     * Fires onCalculate event for Header section of the specified group.
     * @param dataRow Object that holds the datasource data
     */
    public void fireOnCalculateGroupHeaderEvent(String groupName, Object dataRow) {
        if (getGroup(groupName) != null) {
            getGroup(groupName).fireOnCalculateHeaderEvent(dataRow);
        }
    }

    /**
     * Fires beforeShow event for Header section of the specified group.
     */
    public void fireBeforeShowGroupHeaderEvent(String groupName) {
        if (getGroup(groupName) != null) {
            getGroup(groupName).fireBeforeShowHeaderEvent();
        }
    }

    /**
     * Fires onCalculate event for Footer section of the specified group.
     * @param dataRow Object that holds the datasource data
     */
    public void fireOnCalculateGroupFooterEvent(String groupName, Object dataRow) {
        if (getGroup(groupName) != null) {
            getGroup(groupName).fireOnCalculateFooterEvent(dataRow);
        }
    }

    /**
     * Fires beforeShow event for Header section of the specified group.
     */
    public void fireBeforeShowGroupFooterEvent(String groupName) {
        if (getGroup(groupName) != null) {
            getGroup(groupName).fireBeforeShowFooterEvent();
        }
    }
    
    /**
     * Fires beforeShow report event
     * @param e Event object
     */
    public void fireBeforeShowEvent(Event e) {
        Vector v;
        this.setAttributes(this);
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((ReportListener) v.elementAt(i)).beforeShow(e);
        }
    }

    /**
     * Fires beforeSelect report event
     */
    public void fireBeforeSelectEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((ReportListener) v.elementAt(i)).beforeSelect(e);
        }
    }

    /**
     * Fires beforeBuildSelect report event
     */
    public void fireBeforeBuildSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((DataObjectListener) v.elementAt(i)).beforeBuildSelect(e);
        }
    }

    /**
     * Fires beforeExecuteSelect report event
     */
    public void fireBeforeExecuteSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((DataObjectListener) v.elementAt(i)).beforeExecuteSelect(e);
        }
    }
    
    /**
     * Fires afterExecuteSelect report event
     */
    public void fireAfterExecuteSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((DataObjectListener) v.elementAt(i)).afterExecuteSelect(e);
        }
    }

    /**
     * Returns the current report row number.
     * Starting with one.
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * Returns number of the report pages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Returns the height of Report page in print view mode
     */
    public int getPrintPageSize() {
        return printPageSize;
    }

    /**
     * Returns the height of Report page in web view mode
     */
    public int getWebPageSize() {
        return webPageSize;
    }

    /**
     * Sets the height of Report page in print view mode
     * @param i height of Report page in print view mode
     */
    public void setPrintPageSize(int i) {
        if (i < 0) {
            i = 0;
        }
        printPageSize = i;
        if (getViewMode() == Report.VIEW_MODE_PRINT) {
            pageSize = printPageSize;
        }
    }

    /**
     * Sets the height of Report page in web view mode
     * @param i height of Report page in web view mode
     */
    public void setWebPageSize(int i) {
        if (i < 0) {
            i = 0;
        }
        webPageSize = i;
        if (getViewMode() == Report.VIEW_MODE_WEB) {
            pageSize = webPageSize;
        }
    }

    /**
     * Returns the last group in group hierarchy that is used to add/get detail rows.
     */
    public ReportGroup getActiveGroup() {
        if (data != null) {
            activeGroup = data.getActiveGroup();
        }
        return activeGroup;
    }

    public double getLineNumber() {
        return lineNumber;
    }

    /**
     * Returns the actual recordsPerPage.
     * The returned value depend on the actual view mode.
     */
    public int getPageSize() {
        return pageSize;
    }
    
    /**
     * Get current Report page number.
     */
    public int getPageNumber() {
        return pageNumber>0?pageNumber:1;
    }

    /**
     * Increment Report page number.
     */
    public void incrementPageNumber() {
        pageNumber++;
    }
    
    /**
     * Set current Report page number.
     * 
     * @return page number
     */
    /*public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }*/
    
    /**
     * Set grid page number to show. This method sets grid page number from
     * String, handy to set this value from request parameter.
     * 
     * @param page
     *            Integer in form of String
     */
    public void setPage(String page) {
        try {
            this.pageNumber = Integer.parseInt(page);
        } catch (NumberFormatException nfe) {
            this.pageNumber = 1;
        }
        this.webPageNumber = this.pageNumber;
    }

    /**
     * Set Grid page number to show. This method sets grid page number from int,
     * handy to set this value from events as result of arithmetic.
     * 
     * @param page
     *            page number
     */
    public void setPage(int page) {
        this.pageNumber = page;
        if (this.pageNumber < 1) {
            this.pageNumber = 1;
        }
    }

    private double getMinPageSize() {
        double minPageSize = 0;
        if (getGroup("Page").isHeaderVisible()) {
            minPageSize += getGroup("Page").getHeaderHeight();
        }
        if (getGroup("Page").isFooterVisible()) {
            minPageSize += getGroup("Page").getFooterHeight();
        }
        double maxSectionHeight = 0;
        if (getGroup("Report").isHeaderVisible()) {
            maxSectionHeight = getGroup("Report").getHeaderHeight();
        }
        if (getGroup("Report").isFooterVisible() && maxSectionHeight < getGroup("Report").getFooterHeight()) {
            maxSectionHeight = getGroup("Report").getFooterHeight();
        }
        java.util.List groupsList = getGroups();
        if (groupsList != null) {
            for (Iterator names = groupsList.iterator(); names.hasNext(); ) {
                String groupName = (String) names.next();
                if (getGroup(groupName).isHeaderVisible() && maxSectionHeight < getGroup(groupName).getHeaderHeight()) {
                    maxSectionHeight = getGroup(groupName).getHeaderHeight();
                }
                if (getGroup(groupName).isFooterVisible() && maxSectionHeight < getGroup(groupName).getFooterHeight()) {
                    maxSectionHeight = getGroup(groupName).getFooterHeight();
                }
            }
        }
        if (getDetailRow().isVisible() && maxSectionHeight < getDetailRow().getHeight()) {
            maxSectionHeight = getDetailRow().getHeight();
        }
        return minPageSize + maxSectionHeight;
    }
    
    public void setPageSize(int recordsPerPage) {
        if (getViewMode() == Report.VIEW_MODE_WEB) {
            if (recordsPerPage == 0) {
                this.pageSize = Integer.MAX_VALUE;
            } else {
                this.pageSize = (int) (recordsPerPage < getMinPageSize() ? getMinPageSize() : recordsPerPage);
            }
        }
    }

    public void setPageSize(String recordsPerPage) {
        if (getViewMode() == Report.VIEW_MODE_WEB) {
            try {
                Format format = getPageModel().getCCSLocale().getDoubleFormat();
                Number pSize = (Number) format.parseObject(recordsPerPage);
                if (pSize.intValue() == 0) {
                    this.pageSize = Integer.MAX_VALUE;
                } else if (pSize.intValue() > 0) {
                    this.pageSize = (int) (pSize.intValue() < getMinPageSize() ? getMinPageSize() : pSize.intValue());
                }
            } catch (NumberFormatException nfe_ignore) {
            } catch (ParseException pe_ignore) {}
        }
    }

    public boolean isNavigatorVisible() {
        return ! (getViewMode() == Report.VIEW_MODE_PRINT);
    }
    
    /**
     * Return current Report detail row. 
     */
    public ReportRow getCurrentRow() {
        return currentRow;
    }
    
    /**
     * Provides compatibility with Grid component
     * @return number of rows that was received from datasource
     * @deprecated use getNumberOfRows() instead
     */
    public long getAmountOfRows() {
        return getNumberOfRows();
    }
    
    /**
     * Provides compatibility with Grid component
     * @param amountOfRows Number of rows that was received from datasource
     * @deprecated use setNumberOfRows(...) instead
     */
    public void setAmountOfRows(long amountOfRows) {
        setNumberOfRows( amountOfRows );
    }

    /**
     * Provides compatibility with Grid component
     * @param amountOfRows Number of rows that was received from datasource
     */
    public void setNumberOfRows(long amountOfRows) {
        this.amountOfRows = amountOfRows;
    }

    /**
     * Returns true if the specified control belongs to Detail row (Detail section);
     * otherwise - false
     * @param name Name of control
     */
    public boolean isDetailControl(String name) {
        return detailControls.hasControl(name);
    }

    /**
     * Returns attribute by given name. If attribute doesn't exist it will be created.
     * Attributes returned by this method are used within calculation functions.
     * @param report Report component contains attribute.
     * @param attributeName String name of attribute
     * @return MutableDouble value of attribute. Never returns null.
     */
    static public MutableDouble getMutableAttribute(Report report, String attributeName) {
        return Report.getMutableAttribute(report, attributeName, 0);
    }

    /**
     * Returns attribute by given name. If attribute doesn't exist it will be created.
     * Attributes returned by this method are used within calculation functions.
     * Attrubutes returned by this method is used inside calculation functions.
     * @param attributeName String name of attribute
     * @param allowNull boolean indicate if it is acceptable to return null if attribute doesn't exist
     * @return MutableDouble value of attribute. Never returns null.
     */
    static public MutableDouble getMutableAttribute(Report report, String attributeName, double initValue) {
        return getMutableAttribute(report, attributeName, false, initValue);
    }
    
    /**
     * Returns attribute by given name. If attribute doesn't exist it will be created.
     * Attrubutes returned by this method is used inside calculation functions.
     * @param report Report component containing attribute.
     * @param attributeName String name of attribute
     * @param allowNull boolean indicate if it is acceptable to return null if attribute doesn't exist
     * @param initValue initial value to created MutableDouble object. Will be applied if allowNull is false.
     * @return MutableDouble value of attribute or null.
     */
    static public MutableDouble getMutableAttribute(Report report, String attributeName, boolean allowNull, double initValue) {
        //attributeName = "md:" + attributeName;
        MutableDouble attr = null;
        Object o = report.getAttribute(attributeName);


        if ( o instanceof ModelAttribute ) {
            //attr = (MutableDouble) report.getAttribute(attributeName);
            if (attr == null && ! allowNull) {
                attr = new MutableDouble();
                attr.setValue(initValue);
                report.setAttribute(attributeName, attr);
            }
        } else if ( o instanceof MutableDouble ) {
            attr = (MutableDouble)o;
        } else {
            attr = null;
        }
        //attr = (MutableDouble) report.getAttribute(attributeName);
        //if (attr == null && ! allowNull) {
        //    attr = new MutableDouble();
        //    attr.setValue(initValue);
        //    report.setAttribute(attributeName, attr);
        //}

        return attr;
    }

    /**
     * Set report sorting.
     * 
     * @param sort
     *            sorter column
     */
    public void setSort(String sort) {
        this.sort = sort;
    }
    /**
     * Set report sorting. This method is used to set report's sort order from request
     * parameters.
     * 
     * @param sort
     *            sorter column
     */
    public void setOrder(String sort) {
        this.sort = sort;
    }
    /** Get report sorting. */
    public String getSort() {
        return sort;
    }

    /**
     * Set report sorting direction.
     * 
     * @param dir
     *            report sorting direction "ASC" or "DESC"
     */
    public void setDir(String dir) {
        this.dir = dir;
    }
    /**
     * Get report sorting direction.
     * 
     * @return report sorting direction "ASC or "DESC"
     */
    public String getDir() {
        return dir;
    }

    /**
     * Find Sorter in children collection by name.
     * 
     * @param name
     *            the Sorter name
     * @return the Sorter of the given name; never returns null
     * @exception NoSuchComponentException
     *                if no such Sorter exists
     */
    public Sorter getSorter(String name) {
        Model m = getChild(name);
        Sorter c = null;
        if (m instanceof Sorter) {
            c = (Sorter) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[]{getName(), "Sorter",
                    name}));
        }
        return c;
    }
    
    /**
     * Find Navigator in children collection by name.
     * 
     * @param name
     *            the Navigator name
     * @return the Navigator of the given name; never returns null
     * @exception NoSuchComponentException
     *                if no such Navigator exists
     */
    public Navigator getNavigator(String name) {
        Model m = getChild(name);
        Navigator c = null;
        if (m instanceof Navigator) {
            c = (Navigator) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[]{getName(), "Navigator",  name}));
        }
        return c;
    }

    /**
     * @see com.codecharge.components.Navigable#getNumberOfRows()
     */
    public long getNumberOfRows() {
        return amountOfRows;
    }
    
    /**
     * Returns the given StringBuffer with added order by clause. Order be clause is added
     * based on active sorter.
     * @param appendTo
     * @param sortAscColumns
     * @param sortDescColumns
     */
    public StringBuffer appendToOrderBy(StringBuffer appendTo, Map sortAscColumns,
            Map sortDescColumns) {
        return appendToOrderBy(appendTo, sortAscColumns, sortDescColumns, null);
    }
    //TODO may be to move it to ReportAction???
    public StringBuffer appendToOrderBy(StringBuffer appendTo, Map sortAscColumns,
            Map sortDescColumns, String defaultOrder) {
        if (!StringUtils.isEmpty(getSort())) {
            if ("desc".equalsIgnoreCase(getDir())) {
                if (sortDescColumns.get(getSort()) != null && "desc".equalsIgnoreCase(getDir())) {
                    if (appendTo.length() > 0) {
                        appendTo.append(", ");
                    }
                    appendTo.append((String) sortDescColumns.get(getSort()) + " ");
                } else {
                    if (appendTo.length() > 0) {
                        appendTo.append(", ");
                    }
                    appendTo.append((String) sortAscColumns.get(getSort()) + " DESC ");
                }
            } else {
                if (appendTo.length() > 0) {
                    appendTo.append(", ");
                }
                appendTo.append((String) sortAscColumns.get(getSort()) + " ");
            }
        } else if (! StringUtils.isEmpty(defaultOrder)){
            if (appendTo.length() > 0) {
                appendTo.append(", ");
            }
            appendTo.append(defaultOrder);
        }
        return appendTo;
    }
    
    /**
     * Returns true if print view mode is enabled for report component; otherwise - false
     */
    public boolean isEnablePrintMode() {
        return enablePrintMode;
    }
    
    /**
     * Sets enablePrintMode value
     * @param enablePrintMode true if print view mode is allowed; otherwise - false
     */
    public void setEnablePrintMode(boolean enablePrintMode) {
        this.enablePrintMode = enablePrintMode;
    }
    
    /**
     * Returns int value of page size limit if viewMode is Report.VIEW_MODE_WEB;
     * otherwise returns zero. Zero means that all records should be displayed.
     * PageSizeLimit is applied to web mode only.
     */
    public double getPageSizeLimit() {
        if (getViewMode() == Report.VIEW_MODE_WEB) {
            return pageSizeLimit;
        } else {
            return 0;
        }
    }
    
    /**
     * Sets maximal allowed size of the Report page in the web view mode
     * @param pageSizeLimit Maximal allowed size of the Report page in the web view mode
     */
    public void setPageSizeLimit(int pageSizeLimit) {
        this.pageSizeLimit = pageSizeLimit;
    }
    
    /**
     * Return section with given name. 
     * @param name Name of the Report section
     */
    public ISection getSection(String name) {
        Section section = (Section) sections.get(name);
        if (section == null) {
            section = new Section(name);
            sections.put(name, section);
        }
        return section;
    }
    
    /**
     * Returns the Report detail row. The behavior of this method depends on
     * Report mode. In the constructing model mode it returns element of report
     * structure that contains detail controls. In the populating mode it
     * returns current row.
     */
    public ReportRow getDetailRow() {
        if (currentRow != null) {
            return currentRow;
        } else {
            return detailControls;
        }
    }
    
    /**
     * Class Section emulates accessing the API of Report sections.
     */
    private class Section implements ISection {
        
        private final String ROW_NAME = "Row";
        
        /**
         * Name of section
         */
        private String name;
        
        /**
         * Name of corresponding group
         */
        private String groupName;
        
        /**
         * Section type
         * @see ReportGroup.GROUP_HEADER, ReportGroup.GROUP_FOOTER, ReportGroup.GROUP_ROW
         * 
         */
        private int sectionType;
        
        public Section(String name) {
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("Section name can't be empty or null");
            }
            this.name = name;
            if (name.endsWith("_Header")) {
                sectionType = ReportGroup.GROUP_HEADER;
                groupName = name.substring(0,name.length()-7);
            } else if (name.endsWith("_Footer")) {
                sectionType = ReportGroup.GROUP_FOOTER;
                groupName = name.substring(0,name.length()-7);
            } else if (name.equals("Detail")) {
                sectionType = ReportGroup.GROUP_ROW;
                groupName = this.ROW_NAME;
            } else {
                throw new IllegalArgumentException("Section name '"+name+"' is invalid. Section name can be 'Detail' or ends with '_Header' or '_Footer'");
            }
        }
        
        /**
         * @see com.codecharge.components.ISection#isVisible()
         */
        public boolean isVisible() {
            boolean visible = true;
            switch (this.sectionType) {
                case ReportGroup.GROUP_ROW:
                    visible = getDetailRow().isVisible();
                    break;
                case ReportGroup.GROUP_HEADER:
                    visible = getGroup(groupName).isHeaderVisible();
                    break;
                case ReportGroup.GROUP_FOOTER:
                    visible = getGroup(groupName).isFooterVisible();
                    break;
            }
            return visible;
        }
        
        /**
         * @see com.codecharge.components.ISection#setVisible(boolean)
         */
        public void setVisible(boolean visible) {
            switch (this.sectionType) {
                case ReportGroup.GROUP_ROW:
                    getDetailRow().setVisible(visible);
                    break;
                case ReportGroup.GROUP_HEADER:
                    getGroup(groupName).setHeaderVisible(visible);
                    break;
                case ReportGroup.GROUP_FOOTER:
                    getGroup(groupName).setFooterVisible(visible);
                    break;
            }
        }

        /**
         * 
         * @see com.codecharge.components.ISection#addListener(com.codecharge.events.SectionListener)
         */
        public void addListener(SectionListener l) {
            switch (this.sectionType) {
                case ReportGroup.GROUP_ROW:
                    getDetailRow().addListener(l);
                    break;
                case ReportGroup.GROUP_HEADER:
                    getGroup(groupName).addHeaderListener(l);
                    break;
                case ReportGroup.GROUP_FOOTER:
                    getGroup(groupName).addFooterListener(l);
                    break;
            }
        }

        /**
         * 
         * @see com.codecharge.components.ISection#removeListener(com.codecharge.events.SectionListener)
         */
        public void removeListener(SectionListener l) {
            switch (this.sectionType) {
                case ReportGroup.GROUP_ROW:
                    getDetailRow().removeListener(l);
                    break;
                case ReportGroup.GROUP_HEADER:
                    getGroup(groupName).removeHeaderListener(l);
                    break;
                case ReportGroup.GROUP_FOOTER:
                    getGroup(groupName).removeFooterListener(l);
                    break;
            }
        }
        
        /**
         * 
         * @see com.codecharge.components.ISection#getHeight()
         */
        public double getHeight() {
            double height = 0;
            switch (this.sectionType) {
                case ReportGroup.GROUP_ROW:
                    height = getDetailRow().getHeight();
                    break;
                case ReportGroup.GROUP_HEADER:
                    height = getGroup(groupName).getHeaderHeight();
                    break;
                case ReportGroup.GROUP_FOOTER:
                    height = getGroup(groupName).getFooterHeight();
                    break;
            }
            return height;
        }
        
        /**
         * 
         * @see com.codecharge.components.ISection#setHeight(double)
         */
        public void setHeight(double height) {
            switch (this.sectionType) {
                case ReportGroup.GROUP_ROW:
                    getDetailRow().setHeight(height);
                    break;
                case ReportGroup.GROUP_HEADER:
                    getGroup(groupName).setHeaderHeight(height);
                    break;
                case ReportGroup.GROUP_FOOTER:
                    getGroup(groupName).setFooterHeight(height);
                    break;
            }
        }

    }

    public boolean isNewPageOpened() {
        return newPageOpened;
    }

	public boolean pageFootIsDo() {
		return footIsDo;
	}

	public void setFootIsDo(boolean foot) {
		this.footIsDo = foot;
	}
	public void setLastFootIsDo(boolean foot){
		this.lastFootIsDo = foot;
	}

	public boolean isLastFootIsDo(){
		return this.lastFootIsDo;
	}

	public void setHtmlTemplateType(String tmplType) {
		this.htmlTemplateType = tmplType;
	}
	public String getHtmlTemplateType() {
		return this.htmlTemplateType;
	}
}




//End Report class

