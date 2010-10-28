//EditableGridProcessor class: head @0-00A6A166
/*
 * $Revision: 1.4 $
 * $Date: 2005/01/11 09:22:00 $
 */
package com.codecharge;

import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.codecharge.components.Component;
import com.codecharge.components.Button;
import com.codecharge.components.CachedColumn;
import com.codecharge.components.Panel;
import com.codecharge.components.Control;
import com.codecharge.components.DatePicker;
import com.codecharge.components.EditableGrid;
import com.codecharge.components.Link;
import com.codecharge.components.List;
import com.codecharge.components.Model;
import com.codecharge.components.NoSuchComponentException;
import com.codecharge.components.Page;
import com.codecharge.components.Sorter;
import com.codecharge.components.VerifiableControl;
import com.codecharge.db.Command;
import com.codecharge.db.DbRow;
import com.codecharge.db.JDBCConnection;
import com.codecharge.db.JDBCConnectionFactory;
import com.codecharge.db.ParameterSource;
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
import com.codecharge.util.LinkParameter;
import com.codecharge.util.StringUtils;
import com.codecharge.util.Utils;
import com.codecharge.util.CCSURL;
import com.codecharge.util.ModelAttribute;
import com.codecharge.validation.ErrorCollection;

public class EditableGridProcessor extends AbstractProcessor {

    private CCLogger logger = CCLogger.getInstance();
    //private Format defaultBooleanFormat;
    //private Format defaultDateFormat;
    private EditableGrid model;
    //protected EditableGrid model;
    private Enumeration records;
    /** Whether there were errors. */
    private boolean valid = true;

    public EditableGridProcessor(Element elm, Model model, Page page) {
        super(elm, model, page);
        this.model = (EditableGrid) model;
    }

    public void process() {
        setProperties(model, PageController.GET);
        setProperties(model, PageController.POST);
        setActivePermissions(model);
        if (!model.isAllowDelete()) {
            try {
                Control delCntrl = model.getControl(model.getDeleteControlName());
                delCntrl.setVisible(false);

                Model panelModel = model.getChild(model.getDeleteControlName() + "_Panel");
                if (panelModel!=null) {
                    if (panelModel instanceof Panel) ((Panel)panelModel).setVisible(false);
                }
            } catch (NoSuchComponentException ignore) {
            }
        }
        model.processRows();
        int k;
        String formName = page.getHttpGetParams().getParameter("ccsForm");
        if (formName != null && (k = formName.lastIndexOf(":Edit")) != -1) {
            formName = formName.substring(0, k);
        }
        if (model.getName().equals(formName)) {
            logger.debug("Process EditableGrid '" + model.getName() + "' ccForm="
                    + page.getHttpGetParams().getParameter("ccsForm"));
            NodeList buttons = elm.getElementsByTagName("Button");
            boolean clicked = false;
            for (int i = 0; i < buttons.getLength(); i++) {
                Element b = (Element) buttons.item(i);
                //if (page.getHttpPostParams().getParameter(b.getAttribute("name")) != null) {
                if (model.getButton(b.getAttribute("name")).isPressed() ) {
                    processEditableGridButton(b, model);
                    clicked = true;
                    break; // because it is impossible to click two buttons
                }
            }
            if (clicked == false) { // No clicks -- process default buttons if
                                    // any
                for (int i = 0; i < buttons.getLength(); i++) {
                    Element b = (Element) buttons.item(i);
                    if ("True".equals(b.getAttribute("defaultButton"))) {
                        processEditableGridButton(b, model);
                        break; // the first default button is considered to be
                               // clicked
                    }
                }
            }
        }
        if (page.getRedirect() == null) {
            NodeList lists = elm.getChildNodes();
            for (int i = 0; i < lists.getLength(); i++) {
                if (lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element list = (Element) lists.item(i);
                    if (list.getTagName().equals("Row")) {
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
                        new ListProcessor(list, (List) model
                                .getChild(list.getAttribute("name")), page).process();
                    }
                }
            }
            select();
        }
        if (!valid)
            page.setRedirect(null);
    }

    protected void processEditableGridButton(Element elm, EditableGrid grid) {
        String operation = elm.getAttribute("operation").toLowerCase();
        Button button = (Button) grid.getChild(elm.getAttribute("name"));
        boolean needsValidation = new Boolean(elm.getAttribute("doValidate")).booleanValue();
	grid.addExcludeParams(button.getExcludeParams());
        button.fireOnClickEvent();
        if (operation.equals("submit")) {
            logger.debug("process submit");
            if (needsValidation) {
                if (validate(elm, grid)) {
                    submit((Element) elm.getParentNode(), grid);
                } else {
                    page.setRedirect(null);
                    return;
                }
            } else {
                submit((Element) elm.getParentNode(), grid);
            }
        }
        if (valid == false) { // Database error
            page.setRedirect(null);
            return;
        }
        page.setRedirect(elm.getAttribute("returnPage"));
        if (StringUtils.isEmpty(page.getRedirect())) {
            page.setRedirect(grid.getReturnPage());
        }
        if (StringUtils.isEmpty(page.getRedirect())) {
            String reqUri = page.getRequest().getRequestURI();
            int pos = reqUri.lastIndexOf("/");
            if (pos > -1) {
                page.setRedirect(reqUri.substring(pos + 1));
            } else {
                page.setRedirect(reqUri);
            }
        }

        grid.addExcludeParam("ccsForm");
        grid.addExcludeParam(elm.getAttribute("name"));


        
        CCSURL url = new CCSURL ();
        url.setUrl (page.getRedirect());
        url.addParameters( grid.getPreserveParameters() );



//System.out.println("~~~~~~~~USING [URL IN EG]1["+ url.toRedirectString() +"]");
//System.out.println("~~~~~~~~USING [URL IN EG]2["+ page.getRedirect() + (StringUtils.isEmpty( grid.getPreserveParameters()) ? "" : (page.getRedirect().indexOf("?") > -1 ? "&" : "?") + grid.getPreserveParameters() ) +"]");

        page.setRedirect ( url.toRedirectString() );

/*        int pos = page.getRedirect().indexOf("?");

        page.setRedirect( page.getRedirect()
                + (StringUtils.isEmpty(
                        grid.getPreserveParameters()) ? "" : (pos > -1 ? "&" : "?") + grid.getPreserveParameters() ) );
*/

    }

    protected void insertRow(Element elm, EditableGrid model, HashMap row) {
        Element insertNode = getFirstChildElementByName(elm, "Insert");
        if (insertNode == null)
            return;
        Collection sqlParameters = getChildrenElementsByName(insertNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(insertNode, "SPParameter");
        Collection pkFields = getChildrenElementsByName(elm, "pk");
        String connectionName = elm.getAttribute("connection");
        String query = insertNode.getAttribute("query");
        String queryType = insertNode.getAttribute("type");

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(page.getCCSLocale().getLocale());
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "BooleanFormat");
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "DateFormat");

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model, row);
        Collection spParamsCollection = getSpParameters(spParameters, model, row);
        StringBuffer sql;
        if (queryType.equals("call")) {
            SPCommand cmd = SPCommandFactory.getSPCommand(connectionName);
            cmd.setJdbcConnection(ds);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));
            model.fireBeforeBuildInsertEvent(doe);
            Iterator sParams = spParamsCollection.iterator();
            StringBuffer call = new StringBuffer(replaceParameters(query, sParams));

            Iterator it = spParamsCollection.iterator();
            while (it.hasNext()) {
                SPParameter sp = (SPParameter) it.next();
                cmd.addParameter(sp);
            }
            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }
            cmd.setSql(call.toString());
            model.fireBeforeExecuteInsertEvent(doe);
            cmd.executeUpdate();
            logger.debug(cmd.toString());
            model.fireAfterExecuteInsertEvent(doe);
        } else {
            Command cmd = null;
            if (queryType.equals("raw")) {
                cmd = new RawCommand(ds);
                cmd.setNeedQuotes(true);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
                //cmd.setNeedQuotes(true);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                ds.closeConnection();
                return;
            }
            sql = new StringBuffer(query);
            StringBuffer where = new StringBuffer();
            if (queryType.equals("sql")) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer(replaceParameters(query, sParams));
                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter) it.next()));
            } else {
                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addRawParameter((SqlParameter) it.next()));
            }

            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }

            //cmd.setSql( cutOmitParametersInsert(sql.toString(), sqlParamsCollection.iterator(), page, model) );
            cmd.setSql(sql.toString());
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(sqlParamsCollection, null));
            model.fireBeforeBuildInsertEvent(doe); // TODO: unable to change
                                                   // where parameters
            model.fireBeforeExecuteInsertEvent(doe); // TODO:
            if ( !StringUtils.isEmpty (cmd.getSql()) ) {
                //???
                cmd.setSql( cutOmitParametersInsert(cmd.getSql(), ((SqlParameters)doe.getDataSource()).getSqlParameters().iterator(), page, model) );
                cmd.executeUpdate();
            }
            logger.debug(cmd.toString());
            model.fireAfterExecuteInsertEvent(doe); // TODO:
        }
        ds.closeConnection();
        if (ds.hasErrors()) {
            ErrorCollection errors = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
            if (errors == null) {
                errors = new ErrorCollection();
                row.put(Names.CCS_ROW_ERROR_KEY, errors);
            }
            errors.addErrors(ds.getErrors());
            valid = false;
        } else {
            processFile(getRowElement(elm), row);
        }
    }
    protected void updateRow(Element elm, EditableGrid model, HashMap row) {
        Element updateNode = getFirstChildElementByName(elm, "Update");
        if (updateNode == null)
            return;
        Element whereNode = getFirstChildElementByName(updateNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null)
            whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(updateNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(updateNode, "SPParameter");
        Collection pkFields = getChildrenElementsByName(elm, "pk");
        String connectionName = elm.getAttribute("connection");
        String query = updateNode.getAttribute("query");
        String queryType = updateNode.getAttribute("type");

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(page.getCCSLocale().getLocale());
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "BooleanFormat");
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "DateFormat");

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model, row);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model, row);
        Collection spParamsCollection = getSpParameters(spParameters, model, row);
        StringBuffer sql;
        if (queryType.equals("call")) {
            SPCommand cmd = SPCommandFactory.getSPCommand(connectionName);
            cmd.setJdbcConnection(ds);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));
            model.fireBeforeBuildUpdateEvent(doe);
            Iterator sParams = spParamsCollection.iterator();
            StringBuffer call = new StringBuffer(replaceParameters(query, sParams));

            Iterator it = spParamsCollection.iterator();
            while (it.hasNext()) {
                SPParameter sp = (SPParameter) it.next();
                cmd.addParameter(sp);
            }
            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }
            cmd.setSql(call.toString());
            model.fireBeforeExecuteUpdateEvent(doe);
            cmd.executeUpdate();
            logger.debug(cmd.toString());
            model.fireAfterExecuteUpdateEvent(doe);
        } else {
            Command cmd = null;
            if (queryType.equals("raw")) {
                cmd = new RawCommand(ds);
                cmd.setNeedQuotes(true);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                ds.closeConnection();
                return;
            }
            sql = new StringBuffer(query);
            StringBuffer where = new StringBuffer();
            SqlParameters parameters = new SqlParameters(sqlParamsCollection,
                    whereParamsCollection);
            if (queryType.equals("sql")) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer(replaceParameters(query, sParams));
                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd
                        .addParameter((SqlParameter) it.next()));
            } else {
                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd
                        .addRawParameter((SqlParameter) it.next()));
            }

            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(parameters);
            model.fireBeforeBuildUpdateEvent(doe); // TODO: moved here because
                                                   // default values and
                                                   // expressions of where
                                                   // parameters are set in this
                                                   // event, but originally it
                                                   // was just before the
                                                   // BeforeExecute event.
            boolean allParams = true;
            if (queryType.equals("raw")) {
                where = new StringBuffer();
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildRawWhere(getWhereClause(whereNode), parameters, ds);
                if (!StringUtils.isEmpty(sWhere)) {
                    where = new StringBuffer(sWhere);
                }
                cmd.setWhere(where);
                for (Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
                    SqlParameter param = (SqlParameter) it.next();
                    if (param.isApply()) {
                        cmd.addParameter(param);
                    } else {
                        allParams = false;
                    }
                }
            }
            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }
            //cmd.setSql( cutOmitParametersUpdate(sql.toString(), sqlParamsCollection.iterator(), page, model) );
            cmd.setSql(sql.toString());
            if (!allParams) cmd.setCmdExecution(false);

            model.fireBeforeExecuteUpdateEvent(doe); // TODO:
            if (cmd.isCmdExecution()) {
                if ( !StringUtils.isEmpty (cmd.getSql()) ) {
                    cmd.setSql( cutOmitParametersUpdate(cmd.getSql(), ((SqlParameters)doe.getDataSource()).getSqlParameters().iterator(), page, model) );
                    cmd.executeUpdate();
                }
                logger.debug(cmd.toString());
                model.fireAfterExecuteUpdateEvent(doe); // TODO:
            } else if (! allParams) {
                try {
                    ErrorCollection errors = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
                    if (errors == null) {
                        errors = new ErrorCollection();
                        row.put(Names.CCS_ROW_ERROR_KEY, errors);
                    }
                    ResourceBundle res = ResourceBundle.getBundle("MessagesBundle");
                    errors.addError(res.getString("CCS_CustomOperationError_MissingParameters"));

                    valid = false;
                } catch (Exception e) {
                    logger.error("Message with key CCS_CustomOperationErrorMissingParameters is not found");
                }
            }
        }
        ds.closeConnection();
        if (ds.hasErrors()) {
            ErrorCollection errors = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
            if (errors == null) {
                errors = new ErrorCollection();
                row.put(Names.CCS_ROW_ERROR_KEY, errors);
            }
            errors.addErrors(ds.getErrors());
            valid = false;
        } else {
            processFile(getRowElement(elm), row);
        }
    }
    protected void deleteRow(Element elm, EditableGrid model, HashMap row) {
        Element deleteNode = getFirstChildElementByName(elm, "Delete");
        if (deleteNode == null)
            return;
        Element whereNode = getFirstChildElementByName(deleteNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null)
            whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(deleteNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(deleteNode, "SPParameter");
        Collection pkFields = getChildrenElementsByName(elm, "pk");
        String connectionName = elm.getAttribute("connection");
        String query = deleteNode.getAttribute("query");
        String queryType = deleteNode.getAttribute("type");

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(page.getCCSLocale().getLocale());
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "BooleanFormat");
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute(
                connectionName + "DateFormat");

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model, row);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model, row);
        Collection spParamsCollection = getSpParameters(spParameters, model, row);
        StringBuffer sql;

        if (queryType.equals("call")) {
            SPCommand cmd = SPCommandFactory.getSPCommand(connectionName);
            cmd.setJdbcConnection(ds);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));
            model.fireBeforeBuildDeleteEvent(doe);
            Iterator sParams = spParamsCollection.iterator();
            StringBuffer call = new StringBuffer(replaceParameters(query, sParams));

            Iterator it = spParamsCollection.iterator();
            while (it.hasNext()) {
                SPParameter sp = (SPParameter) it.next();
                cmd.addParameter(sp);
            }
            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }
            cmd.setSql(call.toString());
            model.fireBeforeExecuteDeleteEvent(doe);
            cmd.executeUpdate();
            logger.debug(cmd.toString());
            model.fireAfterExecuteDeleteEvent(doe);
        } else {
            Command cmd = null;
            if (queryType.equals("raw")) {
                cmd = new RawCommand(ds);
                cmd.setNeedQuotes(true);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
                //cmd.setNeedQuotes(true);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                ds.closeConnection();
                return;
            }
            sql = new StringBuffer(query);
            StringBuffer where = new StringBuffer();
            SqlParameters parameters = new SqlParameters(sqlParamsCollection,
                    whereParamsCollection);
            if (queryType.equals("sql")) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer(replaceParameters(query, sParams));
                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd
                        .addParameter((SqlParameter) it.next()));
            } else {
                for (Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd
                        .addRawParameter((SqlParameter) it.next()));
            }

            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(parameters);
            model.fireBeforeBuildDeleteEvent(doe); // TODO: unable to change
                                                   // where parameters

            boolean allParams = true;
            if (queryType.equals("raw")) {
                where = new StringBuffer();
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildRawWhere(getWhereClause(whereNode), parameters, ds);
                if (!StringUtils.isEmpty(sWhere)) {
                    where = new StringBuffer(sWhere);
                }
                cmd.setWhere(where);
                for (Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
                    SqlParameter param = (SqlParameter) it.next();
                    if (param.isApply()) {
                        cmd.addParameter(param);
                    } else {
                        allParams = false;
                    }
                }
            }
            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }
            cmd.setSql(sql.toString());
            if (!allParams)
                cmd.setCmdExecution(false);
            model.fireBeforeExecuteDeleteEvent(doe); // TODO:
            if (cmd.isCmdExecution()) {
                if ( !StringUtils.isEmpty (cmd.getSql()) ) cmd.executeUpdate();
                logger.debug(cmd.toString());
                model.fireAfterExecuteDeleteEvent(doe); // TODO:
            } else if (! allParams) {
                try {
                    ErrorCollection errors = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
                    if (errors == null) {
                        errors = new ErrorCollection();
                        row.put(Names.CCS_ROW_ERROR_KEY, errors);
                    }
                    ResourceBundle res = ResourceBundle.getBundle("MessagesBundle");
            errors.addError(res.getString("CCS_CustomOperationError_MissingParameters"));
                    valid = false;
                } catch (Exception e) {
                    logger
                            .error("Message with key CCS_CustomOperationError_MissingParameters is not found");
                }
            }
        }
        ds.closeConnection();
        if (ds.hasErrors()) {
            ErrorCollection errors = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
            if (errors == null) {
                errors = new ErrorCollection();
                row.put(Names.CCS_ROW_ERROR_KEY, errors);
            }
            errors.addErrors(ds.getErrors());
            valid = false;
        } else {
            deleteFile(getRowElement(elm), row);
        }
    }


    private Element getRowElement (Element eGrid) {
        NodeList list = eGrid.getChildNodes();
        for (int i=0; i<list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elm = (Element)list.item(i);
                if (elm.getTagName().equals("Row")) {
                    return elm;
                }
            }
        }
        return null;
    }



    /***************************************************************************
     * Process sumbit operation of EditableGrid. Namely mark primary keys, new
     * rows and deleted rows.
     **************************************************************************/
    protected void submit(Element elm, EditableGrid grid) {
        grid.initializeRows();
        ArrayList dsRows = new ArrayList();
        grid.fireBeforeSubmitEvent();
        while (grid.hasNextRow()) {
            HashMap row = (HashMap) grid.nextRow();
            if (row.get(Names.CCS_ROW_IS_NOT_APPLY_KEY) == null) {
                if (row.get(Names.CCS_ROW_IS_NEW_KEY) != null) {
                    if (grid.isAllowInsert())
                        insertRow(elm, grid, row);
                } else if (row.get(Names.CCS_ROW_IS_DELETE_KEY) != null) {
                    if (grid.isAllowDelete())
                        deleteRow(elm, grid, row);
                } else {
                    if (grid.isAllowUpdate())
                        updateRow(elm, grid, row);
                }
            }
        }
        grid.fireAfterSubmitEvent();
    }

    protected void select() {
        Element selectNode = getFirstChildElementByName(elm, "Select");
        if (selectNode == null)
            return;
        Element countNode = getFirstChildElementByName(selectNode, "CountSql");
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
        String countQuery = "";
        String countQueryType = "";
        if (countNode != null) {
            countQuery = countNode.getAttribute("query");
            countQueryType = countNode.getAttribute("type");
        }
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
        int size = 0;

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
            size = model.getFetchSize();
            int sizeLimit = model.getFetchSizeLimit();
            if (sizeLimit > 1 && sizeLimit < size)
                size = sizeLimit;
            cmd.setFetchSize(size);
            cmd.setStartPos((model.getPage() - 1) * size + 1);
            model.fireBeforeExecuteSelectEvent(doe);
            records = cmd.getRows();
            this.outDbParameters = cmd.getOutputParameters();
            if (cmd.isNext()) {
                model.setNumberOfRows(model.getPage() * size + 1);
            } else if (records != null && records.hasMoreElements()) {
                model.setNumberOfRows(1);
            } else if (! this.outDbParameters.isEmpty()) {
                model.setNumberOfRows(1);
            } else {
                model.setNumberOfRows(0);
            }
            logger.debug(cmd.toString());
            model.fireAfterExecuteSelectEvent(doe);
        } else {
            Command cmd = null;
            if (queryType.equals("raw")) {
                cmd = new RawCommand(ds);
                ((RawCommand) cmd).setOptimizeSQL(optimize);
                cmd.setNeedQuotes(true);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
                ((RawCommand) cmd).setOptimizeSQL(optimize);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                ds.closeConnection();
                return;
            }

            StringBuffer sql = new StringBuffer(query);
            StringBuffer countSql = new StringBuffer(countQuery);
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
                countSql = new StringBuffer(replaceParameters(countQuery, sParams));

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

            if (countSql.length() > 0) {
                cmd.setCountSql(countSql.toString());
            } else {
                model.setCountNeeded(false);
            }

            if (!StringUtils.isEmpty(model.getSort())) {
                cmd.setOrder(((Sorter) model.getChild(model.getSort())).getColumn(model
                        .getDir()));
            } else if (selectNode.getAttribute("orderBy") != null) {
                cmd.setOrder(selectNode.getAttribute("orderBy"));
            }

            if (StringUtils.isEmpty(query)) {
                ds.closeConnection();
                return;
            }
            cmd.setSql(sql.toString());
            size = model.getFetchSize();
            int sizeLimit = model.getFetchSizeLimit();
            if (sizeLimit > 1 && sizeLimit < size)
                size = sizeLimit;
            if ((size < 1 || size == Integer.MAX_VALUE) && cmd instanceof RawCommand) {
                ((RawCommand) cmd).setOptimizeSQL(false);
            }
            cmd.setFetchSize(size);
            cmd.setStartPos((model.getPage() - 1) * size + 1);
            model.fireBeforeExecuteSelectEvent(doe); // TODO:
            if (model.isCountNeeded()) {
                if (queryType.equals("sql")) {
                    model.setNumberOfRows(((SqlCommand) cmd).count());
                } else {
                    model.setNumberOfRows(((RawCommand) cmd).count());
                }
            }


            records = cmd.getRows();


            java.util.ArrayList recList = new java.util.ArrayList();
            if (records != null)  {
                recList = Utils.list(records);
                records = java.util.Collections.enumeration(recList); //TODO if record is big.
            }

            if (!model.isCountNeeded()) {
              if (cmd.isNext()) {
                model.setNumberOfRows(model.getPage() * size + 1);
              } else {
                model.setNumberOfRows(recList.size());
              }
            }

            logger.debug(cmd.toString());
            model.fireAfterExecuteSelectEvent(doe); // TODO:
        }
        ds.closeConnection();
        if (ds.hasErrors()) {
            model.addErrors(ds.getErrors());
        }
        int bound = bind();
        if (model.getNumberOfRows() == -1) {
            model.setNumberOfRows((model.getPage() - 1) * size + 1 + bound);
        }
    }

    protected int bind() {
        Iterator childRows = model.getChildRows().iterator();
        HashMap childRow = null;
        HashMap attrRow = null;

        int n = 0;
        if (records == null && this.outDbParameters.isEmpty()) return n;
        boolean bindOutDbParameters = ! this.outDbParameters.isEmpty();

        //HashMap toAdd = new HashMap();

        while ((records != null && records.hasMoreElements()) || bindOutDbParameters) {
            boolean isNew = false;
            DbRow row = null;
            if (records != null) {
                row = (DbRow) records.nextElement();
            }


            
            //setAttributes(model, row, n+1, toAdd);


            if (childRows.hasNext()) {
                childRow = (HashMap) childRows.next();
                if (childRow == null) {
                    isNew = true;
                    childRow = new HashMap();
                }
            } else {
                isNew = true;
                childRow = new HashMap();
                attrRow = new HashMap();
            }
            // repopulate non editable controls at the time of validation errors
            boolean rowHasErrors = (childRow.get(Names.CCS_ROW_ERROR_KEY) != null);
            if (isNew) {

                //Iterator children = model.getChildren().iterator();
                Iterator children = model.getRowControls().iterator();

                while (children.hasNext()) {
                    //Model child = (Model) children.next();
                    Model child = model.getChild((String)children.next());

                    if (child instanceof Control) {
                        Control ctrl = (Control) ((Control) child).clone();

//-----------------------------ATTRIBUTES-----------------------------
    {
        Iterator rAttrs = ctrl.getAttributeKeys().iterator();
        while (rAttrs.hasNext()) {
            String rAttrName = (String)rAttrs.next();
            ModelAttribute brAttr = bindRowAttribute ( (ModelAttribute)ctrl.getAttribute( rAttrName ), row );
            ctrl.setAttribute(brAttr.getName(), brAttr);
        }
    }                               
//-----------------------------/ATTRIBUTES----------------------------

                        ctrl.setHtmlName(ctrl.getName() + "_" + (n + 1));
                        if (ctrl instanceof Link) {
                            setLinkProperties(row, this.outDbParameters, (Link) ctrl);
                        }
                        if (ctrl.isStatic())
                            continue;
                        Object value = getControlValue(row, this.outDbParameters, ctrl.getControlSourceType(), ctrl.getFieldSource());

                        if ( !StringUtils.isEmpty ( ctrl.getFieldSource()) ) {
                            setControlValueFromDb(ctrl, value); 
                        } 
                        //setControlValueFromDb(ctrl, value);
                        childRow.put(ctrl.getName(), ctrl);
                    } else if (child instanceof DatePicker) {
                        DatePicker dp = (DatePicker) ((DatePicker) child).clone();
                        dp.setHtmlName(dp.getControlName() + "_" + (n + 1));
                        childRow.put(dp.getName(), dp);
                    } else if (child instanceof Button) {
                        Button btn = (Button)((Button)child).clone();
                        btn.setHtmlName(btn.getName() + "_" + (n + 1) );
                        childRow.put(child.getName(), btn);
                    }
                }

                /*Iterator rAttrs = model.getRowAttributeKeys().iterator();
                while (rAttrs.hasNext()) {
                    String rAttrName = (String)rAttrs.next();
                    ModelAttribute brAttr = bindRowAttribute ( model.getRowAttribute( rAttrName ), row );
                    attrRow.put(brAttr.getName(), brAttr);
                }*/

                ArrayList cached = (ArrayList) model.getCachedColumns().clone();
                ArrayList newlist = new ArrayList();
                for (int i = 0; i < cached.size(); i++) {
                    CachedColumn column = (CachedColumn) ((CachedColumn) cached.get(i)).clone();
                    String field = column.getAlias();
                    if (field == null)
                        field = column.getField();
                    column.setValue(row.get(field));
                    newlist.add(column);
                }
                childRow.put(Names.CCS_CACHED_COLUMNS, newlist);

//-----------------------------ATTRIBUTES-----------------------------
    {
        Iterator rAttrs = model.getAttributeKeys().iterator();
        while (rAttrs.hasNext()) {
            String rAttrName = (String)rAttrs.next();
            ModelAttribute brAttr = bindRowAttribute ( (ModelAttribute)model.getAttribute( rAttrName ), row );
            attrRow.put(brAttr.getName(), brAttr);
        }
    }
//-----------------------------/ATTRIBUTES----------------------------

                model.addChildRow(childRow);
                model.addAttributesRow(""+(n+1), attrRow );
                //model.addAttributesRow(attrRow);

            } else if (rowHasErrors) {
                Iterator children = model.getChildren().iterator();
                while (children.hasNext()) {
                    Model child = (Model) children.next();
                    if (child instanceof Control && !(child instanceof VerifiableControl)) {
                        Control ctrl = (Control) ((Control) child).clone();
                        ctrl.setHtmlName(ctrl.getName() + "_" + (n + 1));
                        if (ctrl instanceof Link) {
                            setLinkProperties(row, this.outDbParameters, (Link) ctrl);
                        }
                        if (ctrl.isStatic())
                            continue;
                        Object value = getControlValue(row, this.outDbParameters, ctrl.getControlSourceType(), ctrl.getFieldSource());

                        if ( !StringUtils.isEmpty ( ctrl.getFieldSource()) ) {
                            setControlValueFromDb(ctrl, value); 
                        }

                        childRow.put(ctrl.getName(), ctrl);
                    } else if (child instanceof DatePicker) {
                        DatePicker dp = (DatePicker) ((DatePicker) child).clone();
                        dp.setHtmlName(dp.getControlName() + "_" + (n + 1));
                        childRow.put(dp.getName(), dp);
                    }
                }
            }
            n++;
            bindOutDbParameters = false;
        }

        //model.setAttributes(toAdd);
        return n;
    }

    /*private ModelAttribute bindRowAttribute (ModelAttribute attr, DbRow row) {
        ModelAttribute cAttr = attr.clone();
            
        if ("DataField".equals ( attr.getSourceType() )) {
            cAttr.setValue (row.get( attr.getSourceName() ) );
        }
        return cAttr;
    }*/


    /*private void setAttributes(Component comp, DbRow row, int n, HashMap toAdd) {
        Iterator it = comp.getAttributeKeys().iterator();

        //HashMap toAdd = new HashMap();

        while (it.hasNext()) {
            String key = (String)it.next();
            Object attr = comp.getAttribute(key);
            if (attr instanceof ModelAttribute) {
                ModelAttribute mAttr = (ModelAttribute) attr;

                String name = mAttr.getName();
                String source = mAttr.getSourceName();
                String soureType = mAttr.getSourceType();

                if ("DataField".equals ( soureType )) {
                    //Object value = mAttr.getValue();
                    ModelAttribute mAttr2 = mAttr.clone();
                    mAttr2.setValue(row.get(source.toUpperCase()));
                    toAdd.put(name+"_"+n, mAttr2);
                }
            }
        }



    }*/

}

//End EditableGridProcessor class: head

