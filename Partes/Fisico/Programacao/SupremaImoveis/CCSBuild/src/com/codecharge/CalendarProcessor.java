//CalendarProcessor class: head @0-14374116
/*
 * $Revision: 1.4 $
 * $Date: 2005/01/11 09:28:08 $
 */
package com.codecharge;

import java.text.Format;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.codecharge.components.Model;
import com.codecharge.components.Page;
import com.codecharge.components.Calendar;
import com.codecharge.components.action.CalendarAction;
import com.codecharge.components.calendar.CalendarComparator;
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
import com.codecharge.util.Utils;
import com.codecharge.util.CCSURL;


public class CalendarProcessor extends AbstractProcessor {

    private CCLogger logger = CCLogger.getInstance();
    private Calendar model;
    private Enumeration records;

    public CalendarProcessor(Element elm, Model model, Page page) {
        super(elm, model, page);
        this.model = (Calendar) model;
    }

    protected String getRedirectString() {
        StringBuffer preservedParameters = new StringBuffer();
        HashMap parameters = new HashMap();
        Vector getExclude = new Vector();
        getExclude.add("ccsForm");

        parameters.putAll(this.model.getPageModel().getHttpPostParams().getPreserveParameters(getExclude));
        parameters.putAll(this.model.getPageModel().getHttpGetParams().getPreserveParameters(getExclude));

        /*Iterator params = parameters.values().iterator();
        boolean first = true;
        while(params.hasNext()) {
            if (!first) {
                preservedParameters.append("&");
            } else {
                first = false;
            }
            preservedParameters.append(((String)params.next()));
        }*/

        CCSURL url = new CCSURL ();
        url.addParameters(parameters);
        url.setUrl (this.model.getPageModel().getActionPageName() + ".jsp");

        //return this.model.getPageModel().getActionPageName() + ".jsp" + (preservedParameters.length() == 0 ? "" : "?"+preservedParameters);

        return url.toRedirectString();
    }
    
    public void process() {
        if (page.getRedirectString() != null) {
            return;
        }
        if (model.getName().equals(model.getPageModel().getParameter("ccsForm"))) {
            page.setRedirectString(getRedirectString());
            return;
        }

        setActivePermissions(model);
        model.setVisible(model.isAllowRead() && model.isVisible());
        //if (!model.isVisible()) {
        //    return;
        //}

        logger.debug("Process Calendar '" + model.getName());
        setProperties(model, PageController.GET);

        NodeList lists = elm.getChildNodes();
        for (int i = 0; i < lists.getLength(); i++) {
            if (lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element list = (Element) lists.item(i);
                // Support difference between static and iterated controls?
                if (list.getTagName().equals("Event") 
                        || list.getTagName().equals("Day") 
                        || list.getTagName().equals("Month")
                        || list.getTagName().equals("Main")
                        || list.getTagName().equals("Week")
                        ) {
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
        select();
    }

    protected void select() {
        Element selectNode = getFirstChildElementByName(elm, "Select");
        if (selectNode != null) {
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
                //((RawCommand)cmd).setOptimizeSQL(optimize);
                cmd.setNeedQuotes(true);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
                //((RawCommand)cmd).setOptimizeSQL(optimize);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                ds.closeConnection();
                return;
            }
            ((RawCommand)cmd).setOptimizeSQL(false);

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

            String orderBy = selectNode.getAttribute("orderBy");
            if (orderBy == null) {
                orderBy = "";
            }
            cmd.setOrder(orderBy);

            cmd.setSql(sql.toString());
            model.fireBeforeExecuteSelectEvent(doe); // TODO:
            records = cmd.getRows();
            logger.debug(cmd.toString());
            model.fireAfterExecuteSelectEvent(doe); // TODO:
            if (records != null) {
                ArrayList list = Utils.list(records);
                records = Collections.enumeration(list);
            }
        }
        ds.closeConnection();
        if (ds.hasErrors()) {
            model.addErrors(ds.getErrors());
        }
        }
        bind();
    }

    protected void bind() {
        CalendarAction action = new CalendarAction();
        action.setModel(model);
        CalendarComparator comparator = new CalendarComparator();
        comparator.setDataBinder(this);
        action.setRowComparator(comparator);

        IRowProvider rowProvider = new DbRowRowProvider();
        rowProvider.setRowComparator(comparator);
        rowProvider.setRows(records);
        rowProvider.setOutDbParameters(this.outDbParameters);
        
        action.setDataBinder(this);
        action.setRowProvider(rowProvider);
        action.bind();
    }
}

//End CalendarProcessor class: head

