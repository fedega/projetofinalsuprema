//ReportProcessor class: head @0-05DAE685
/*
 * $Revision: 1.4 $
 * $Date: 2005/01/11 09:28:08 $
 */
package com.codecharge;

import java.text.Format;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.codecharge.components.Model;
import com.codecharge.components.Page;
import com.codecharge.components.Report;
import com.codecharge.components.action.ReportAction;
import com.codecharge.db.Command;
import com.codecharge.db.DbRowRowProvider;
import com.codecharge.db.IRowProvider;
import com.codecharge.db.JDBCConnection;
import com.codecharge.db.JDBCConnectionFactory;
import com.codecharge.db.RawCommand;
import com.codecharge.db.SPCommand;
import com.codecharge.db.SPCommandFactory;
import com.codecharge.db.SPParameter;
import com.codecharge.db.SqlCommand;
import com.codecharge.db.SqlParameter;
import com.codecharge.db.SqlParameters;
import com.codecharge.db.WhereBuilder;
import com.codecharge.events.DataObjectEvent;
import com.codecharge.util.CCLogger;
import com.codecharge.util.ContextStorage;
import com.codecharge.util.StringUtils;

public class ReportProcessor extends AbstractProcessor {

    private CCLogger logger = CCLogger.getInstance();
    private Report model;
    private Enumeration records;

    public ReportProcessor(Element elm, Model model, Page page) {
        super(elm, model, page);
        this.model = (Report) model;
    }

    public void process() {
        if (page.getRedirectString() != null) {
            return;
        }

        setActivePermissions(model);
        if (!model.isVisible()) {
            return;
        }

        logger.debug("Process Report '" + model.getName());
        setProperties(model, PageController.GET);

        NodeList lists = elm.getChildNodes();
        processReportControls(lists);
/*        for (int i = 0; i < lists.getLength(); i++) {
            if (lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element list = (Element) lists.item(i);
                // Support difference between static and iterated controls?
                if (list.getTagName().equals("Detail") || list.getTagName().equals("Section") || list.getTagName().equals("Group") ) {
                    NodeList rowLists = list.getChildNodes();
                    for (int ri = 0; ri < rowLists.getLength(); ri++) {
                        if (rowLists.item(ri).getNodeType() == Node.ELEMENT_NODE) {
                            Element rlist = (Element) rowLists.item(ri);
                            if (rlist.getTagName().equals("ListBox")
                                    || rlist.getTagName().equals("RadioButton")
                                    || rlist.getTagName().equals("CheckBoxList")) {
                                ListProcessor listProc = new ListProcessor(rlist, model
                                        .getChild(rlist.getAttribute("name")), page);
                                listProc.process();
                            }
                        }
                    }
                } else if (list.getTagName().equals("ListBox")
                        || list.getTagName().equals("RadioButton")
                        || list.getTagName().equals("CheckBoxList")) {
                    ListProcessor listProc = new ListProcessor(list, model.getChild(list
                            .getAttribute("name")), page);
                    listProc.process();
                }
            }
        }
*/
        select();
    }


    private void processReportControls (NodeList lists) {

        for (int i = 0; i < lists.getLength(); i++) {
            if (lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element list = (Element) lists.item(i);
                // Support difference between static and iterated controls?
                if (list.getTagName().equals("Detail") || list.getTagName().equals("Section") || list.getTagName().equals("Group") ) {
                    NodeList rowLists = list.getChildNodes();
                    processReportControls(rowLists);
                } else if (list.getTagName().equals("ListBox")
                        || list.getTagName().equals("RadioButton")
                        || list.getTagName().equals("CheckBoxList")) {
                    ListProcessor listProc = new ListProcessor(list, model.getChild(list.getAttribute("name")), page);
                    listProc.process();
                }
            }
        }

    }


    protected void select() {
        Element selectNode = getFirstChildElementByName(elm, "Select");
        if (selectNode == null)
            return;
        Element whereNode = getFirstChildElementByName(selectNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null)
            whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(selectNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(selectNode, "SPParameter");
        String connectionName = elm.getAttribute("connection");
        String query = selectNode.getAttribute("query");
        String queryType = selectNode.getAttribute("type");
        boolean optimize = new Boolean(selectNode.getAttribute("optimize")).booleanValue();
        if (!model.isAllowRead())
            return;
        model.fireBeforeSelectEvent();
        if (!model.isAllowRead())
            return;
        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(page.getCCSLocale().getLocale());
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "BooleanFormat");
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "DateFormat");

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model);
        Collection spParamsCollection = getSpParameters(spParameters, model);

        if (queryType.equals("call")) {
            SPCommand cmd = SPCommandFactory.getSPCommand(connectionName);
            cmd.setJdbcConnection(ds);
            setActiveResultSet(selectNode, cmd);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));
            model.fireBeforeBuildSelectEvent(doe);

            Iterator sParams = spParamsCollection.iterator();
            StringBuffer sql = new StringBuffer(replaceParameters(query, sParams));

            Iterator it = spParamsCollection.iterator();
            while (it.hasNext()) {
                cmd.addParameter((SPParameter) it.next());
            }
            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }
            cmd.setSql(sql.toString());
            model.fireBeforeExecuteSelectEvent(doe);
            records = cmd.getRows();
            this.outDbParameters = cmd.getOutputParameters();
            //if (records.hasMoreElements()) model.setNumberOfRows(1);
            logger.debug(cmd.toString());
            model.fireAfterExecuteSelectEvent(doe);
        } else {
            Command cmd = null;
            if (queryType.equals("raw")) {
                cmd = new RawCommand(ds);
                ((RawCommand)cmd).setOptimizeSQL(false);
                cmd.setNeedQuotes(true);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
                ((RawCommand)cmd).setOptimizeSQL(false);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                ds.closeConnection();
                return;
            }

            StringBuffer sql = new StringBuffer(query);
            StringBuffer where = new StringBuffer();
            SqlParameters parameters = new SqlParameters(sqlParamsCollection,
                    whereParamsCollection);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(parameters);
            model.fireBeforeBuildSelectEvent(doe); // TODO:
            if (queryType.equals("sql")) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer(replaceParameters(query, sParams));
                sParams = sqlParamsCollection.iterator();

                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd
                        .addParameter((SqlParameter) it.next()));

                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildWhere(getWhereClause(whereNode), parameters);
                if (!StringUtils.isEmpty(sWhere)) {
                    where = new StringBuffer(sWhere);
                }
            } else {
                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext();) {
                    SqlParameter param = (SqlParameter) it.next();
                    if (param.isApply()) {
                        cmd.addParameter(param);
                    }
                }
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildRawWhere(getWhereClause(whereNode), parameters, ds);
                if (!StringUtils.isEmpty(sWhere)) {
                    where = new StringBuffer(sWhere);
                }
            }
            for (Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
                SqlParameter param = (SqlParameter) it.next();
                if (param.isApply()) {
                    cmd.addParameter(param);
                }
            }
            String embededWhere = selectNode.getAttribute("where");
            if (!StringUtils.isEmpty(embededWhere)) {
                if (where.length() > 0) {
                    where.insert(0, embededWhere + " AND (").append(")");
                } else {
                    where.append(embededWhere);
                }
            }
            if (where.length() > 0) {
                if (StringUtils.isEmpty(cmd.getWhere())) {
                    cmd.setWhere(where);
                } else {
                    cmd.setWhere(where + " AND (" + cmd.getWhere() + ")");
                }
            }

            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }

            String orderBy = null;

            Iterator it = model.getGroups().iterator();
            while (it.hasNext()) {
                com.codecharge.components.report.ReportGroup group = model.getGroup ((String)it.next());

                if (orderBy == null) { 
                    orderBy = group.getSourceColumnName() + " " + group.getSortOrder();
                } else {
                    orderBy = orderBy + ", " + group.getSourceColumnName() + " " + group.getSortOrder();
                }
            }

            String defaultOrder = selectNode.getAttribute("orderBy");
            if (defaultOrder == null) defaultOrder = "";
            if (orderBy == null) orderBy = "";

            if (model.getSort() != null) {
                if (!"".equals (orderBy)) {
                    orderBy += ", ";
                }
                orderBy += model.getSorter(model.getSort()).getColumn(model.getDir());
            } else {
                if (!"".equals (orderBy) && !StringUtils.isEmpty(defaultOrder)) {
                    orderBy += ", ";
                }
                orderBy += defaultOrder;
            }


            cmd.setOrder(orderBy);

            cmd.setSql(sql.toString());
            model.fireBeforeExecuteSelectEvent(doe); // TODO:
            records = cmd.getRows();
            logger.debug(cmd.toString());
            model.fireAfterExecuteSelectEvent(doe); // TODO:
        }
        ds.closeConnection();
        if (ds.hasErrors()) {
            model.addErrors(ds.getErrors());
        }
        bind();
    }

    protected void bind() {




        ReportAction action = new ReportAction();
        action.setModel(model);

        action.setDataBinder(this);

        IRowProvider rowProvider = new DbRowRowProvider();
        rowProvider.setRows(records);
        rowProvider.setOutDbParameters(this.outDbParameters);


        if ( (records == null || !records.hasMoreElements() ) && (this.outDbParameters == null || this.outDbParameters.isEmpty() ) ) {
            model.setNumberOfRows(0); 
        } else {
            model.setNumberOfRows(1);
        }

        if (records != null && records.hasMoreElements()) {
            action.setRowProvider(rowProvider);
            action.bind();
        }

    }
}

//End ReportProcessor class: head

