//RecordProcessor class: head @0-E319AF71
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.DataObjectEvent;

import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class RecordProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  //private Format defaultBooleanFormat;
  //private Format defaultDateFormat;
  private DbRow row;
  private Record model;

  public RecordProcessor(Element elm, Model model, Page page) {
    super(elm, model, page);
    this.model = (Record)model;
  }

  public void process() {
    if (page.getRedirectString() != null) return;
    setActivePermissions( model );
    if ( ! ( model.isVisible() || model.isAllowInsert() || model.isAllowUpdate() || model.isAllowDelete() ) ) {
        return;
    }
    logger.debug("Process record '"+model.getName()+"' ccsForm="+page.getHttpGetParams().getParameter("ccsForm"));
    setProperties( model, PageController.GET );
    int k;
    String formName = page.getHttpGetParams().getParameter("ccsForm");
    model.setMode(Record.INSERT_MODE);
    model.setProcessed(false);
    boolean inEditMode = false;
    if (formName != null && (k = formName.lastIndexOf(":Edit")) != -1) {
        formName = formName.substring(0, k);
        inEditMode = true;
    }
    if ( model.getName().equals(formName) ) {
        if (inEditMode) model.setMode(Record.UPDATE_MODE);
        setProperties( model, PageController.POST );
        Vector buttonsList = new Vector();
        NodeList buttons = elm.getElementsByTagName("Button");
        for (int i=0; i<buttons.getLength(); i++) {
          Element b = (Element)buttons.item(i);
          boolean inserted = false;
          for (int j=0; j<buttonsList.size(); j++) {
            int border = Integer.parseInt(b.getAttribute("order"));
            int corder = Integer.parseInt(((Element)buttonsList.elementAt(j)).getAttribute("order"));
            if (border < corder) {
              buttonsList.insertElementAt(b, j);
              inserted = true;
              break;
            }
          }
          if (!inserted) buttonsList.add(b);
        }
        for (int n = 0; n < buttonsList.size(); n++) {
            Element b = (Element)buttonsList.elementAt(n);
            String operation = b.getAttribute("operation").toLowerCase();
            if (page.getHttpPostParams().getParameter(b.getAttribute("name")) != null ||
                page.getHttpPostParams().getParameter(b.getAttribute("name") + ".x") != null)
            {
                boolean buttonProcessError = false;
                if (model.getMode() == Record.UPDATE_MODE && !operation.equals("insert")) {
                    buttonProcessError = !processButton(b, elm, model);
                } else if (model.getMode() == Record.INSERT_MODE &&
                        (!operation.equals("delete") || !operation.equals("update"))) {
                    buttonProcessError = !processButton(b, elm, model);
                }

                if (model.hasErrors() || buttonProcessError) {
                //if (model.hasErrors()) {
                  model.setProcessed(true);
                  processList();
                  select(); 
                  return;
                } else {
                  return;
                }
            }
        }
        for (int n = 0; n < buttonsList.size(); n++) {
            Element b = (Element)buttonsList.elementAt(n);
            String operation = b.getAttribute("operation").toLowerCase();
            if (Boolean.getBoolean(b.getAttribute("defaultButton")) || buttonsList.size() == 1) {
                if (model.getMode() == Record.UPDATE_MODE && !operation.equals("insert")) {
                    boolean buttonProcessError = !processButton(b, elm, model);
                    if (model.hasErrors() || buttonProcessError) {
                      model.setProcessed(true);
                      processList();
                      select(); return;
                    } else {
                      return;
                    }
                } else if (model.getMode() == Record.INSERT_MODE && (!operation.equals("delete") || !operation.equals("update"))) {
                    boolean buttonProcessError = !processButton(b, elm, model);
                    if (model.hasErrors() || buttonProcessError) {
                      model.setProcessed(true);
                      processList();
                      select(); return;
                    } else {
                      return;
                    }
                }
            }
        }
    }
    processList();
    select();
    return;
  }
    protected void processList() {
      NodeList lists = elm.getChildNodes();
      for (int i=0; i<lists.getLength(); i++) {
        if (lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element list = (Element)lists.item(i);
          if (list.getTagName().equals("ListBox") || list.getTagName().equals("RadioButton") || list.getTagName().equals("CheckBoxList"))
          {
            ListProcessor listProc = new ListProcessor(list, model.getChild(list.getAttribute("name")), page);
            listProc.process();
          }
        }
      }
    }
    /** Process Button.
      @param b Button element to process
      @param record Record element, parent of this button
     */
    protected boolean processButton(Element b, Element record, Record rmodel) {
        String operation = b.getAttribute("operation").toLowerCase();
        //String convertRule = record.getAttribute("convertRule");
        Button button = (Button)rmodel.getChild(b.getAttribute("name"));
        boolean needsValidation = new Boolean(b.getAttribute("doValidate")).booleanValue();
        rmodel.addExcludeParams(button.getExcludeParams());
        String[] p = new String[rmodel.getExcludeParams().size()+1];
        p[0] = button.getName();
        for ( int i = 0; i < rmodel.getExcludeParams().size(); i++ ) {
            p[i+1] = (String) rmodel.getExcludeParams().get(i);
        }
        String searchParams = "";
        button.fireOnClickEvent();

        if (StringUtils.isEmpty(page.getRedirect())) {
            page.setRedirect(applyConvertRules( button.getReturnPage(), b.getAttribute("convertRule") ));
        }

        if (StringUtils.isEmpty(page.getRedirect())) {
            page.setRedirect(applyConvertRules( rmodel.getReturnPage(), record.getAttribute("convertRule") ));
        }

        if ( StringUtils.isEmpty(page.getRedirect()) ) {
            String reqUri = page.getRequest().getRequestURI();
            int pos = reqUri.lastIndexOf("/");
            if ( pos > -1 ) {
                page.setRedirect(reqUri.substring(pos+1));
            } else {
                page.setRedirect(reqUri);
            }
        }

        boolean isValid = true;

        if ("update".equals(operation)) {
            logger.debug("process update");
            if ( needsValidation ) {
                isValid = validate( record, rmodel );
                if ( isValid ) update();
            } else {
                update();
            }
        } else if ("delete".equals(operation)) {
            logger.debug("process delete");
            if ( needsValidation ) {
                isValid = validate( record, rmodel );
                if ( isValid ) delete();
            } else {
                delete();
            }
        } else if ("insert".equals(operation)) {
            logger.debug("process insert");
            if ( needsValidation ) {
                isValid = validate( record, rmodel );
                if ( isValid ) insert();
            } else {
                insert();
            }
        } else if ("search".equals(operation)) {
            logger.debug("process search");
            if ( needsValidation ) {
                isValid = validate( record, rmodel );
                if ( isValid ) {search(rmodel); searchParams = page.getHttpPostParams().toString( p );}
            } else {
                 search(rmodel); searchParams = page.getHttpPostParams().toString( p );
            }
        } else {
            logger.debug("process "+button.getName());
            if (needsValidation) {
            isValid = validate(record, rmodel);
        }
            // if validate fails it adds error to form and next if will come true
        }
        //if ( rmodel.hasErrors() ) {
    
        isValid = isValid && !model.hasErrors();

        if ( !isValid ) {
            page.setRedirect(null);
            //return;
        } else {

            rmodel.addExcludeParam("ccsForm"); // TODO: remove it, because it's already handled elsewhere?
            if ( !StringUtils.isEmpty(page.getRedirect()) ) {

                /*int pos = page.getRedirect().indexOf("?");
                String preserve = rmodel.getPreserveParameters();
                if (StringUtils.isEmpty(preserve)) {
                  preserve = (pos > -1 ? "&" : "?") + searchParams;
                } else {
                  preserve = (pos > -1 ? "&" : "?") + preserve;
                  if (!StringUtils.isEmpty(searchParams)) {
                    preserve = preserve + "&" + searchParams;
                  }
                }
                */

                CCSURL url = new CCSURL ();
                url.setUrl( page.getRedirect() );
                url.addParameters( rmodel.getPreserveParameters() );
                url.addParameters( searchParams );

                //page.setRedirect( page.getRedirect() + preserve );
                page.setRedirect( url.toRedirectString() );

            }
            logger.debug("process button onClick event");


        }
        return isValid;
    }

    protected void search(Record rmodel) {
        for (Iterator i = rmodel.getChildren().iterator(); i.hasNext(); ) {
          Model m = (Model)i.next();
          if (m instanceof VerifiableControl) rmodel.addExcludeParam(m.getName());
        }
    }
    protected void select() {
        Element selectNode = getFirstChildElementByName(elm, "Select");
        if (selectNode == null) return;
        Element whereNode = getFirstChildElementByName(selectNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null) whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(selectNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(selectNode, "SPParameter");
        String connectionName = elm.getAttribute("connection");
        String query = selectNode.getAttribute("query");
        String queryType = selectNode.getAttribute("type");
        if ( ! model.isAllowRead() ) return;
        model.fireBeforeSelectEvent();
        if ( ! model.isAllowRead() ) return;

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(page.getCCSLocale().getLocale());
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "BooleanFormat" );
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "DateFormat" );

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model);
        Collection spParamsCollection = getSpParameters(spParameters, model);

        if ( queryType.equals("call") ) {
            model.setMode( Record.UPDATE_MODE );
            SPCommand cmd = SPCommandFactory.getSPCommand( connectionName );
            cmd.setJdbcConnection( ds );
            setActiveResultSet(selectNode, cmd);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));
            model.fireBeforeBuildSelectEvent(doe);
            Iterator sParams = spParamsCollection.iterator();
            StringBuffer call = new StringBuffer( replaceParameters( query, sParams ) );

            Iterator it = spParamsCollection.iterator();
            while ( it.hasNext() ) {
               SPParameter sp = (SPParameter) it.next();
               cmd.addParameter( sp );
            }
            if ( StringUtils.isEmpty( query ) ) {
                ds.closeConnection();
                return;
            }
            cmd.setSql( call.toString() );
            model.fireBeforeExecuteSelectEvent(doe);
            model.record = cmd.getOneRow();
            logger.debug( cmd.toString() );
            model.setOutDbParameters(cmd.getOutputParameters());
            this.outDbParameters = cmd.getOutputParameters();
            model.fireAfterExecuteSelectEvent(doe);
            if ( model.record == null ) {
                model.setMode( Record.INSERT_MODE );
            }

        } else {
            Command cmd = null;
            if ( queryType.equals("raw") ) {
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
            model.setMode( Record.UPDATE_MODE );

            SqlParameters parameters = new SqlParameters(sqlParamsCollection, whereParamsCollection);
            StringBuffer sql = new StringBuffer( query );
            StringBuffer where = new StringBuffer();
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(parameters);
            model.fireBeforeBuildSelectEvent(doe); // TODO:
            if ( queryType.equals("sql") ) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer( replaceParameters( query, sParams ) );
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildWhere(getWhereClause(whereNode), parameters );
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter)it.next()));
            } else {
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildRawWhere(getWhereClause(whereNode), parameters, ds );
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addRawParameter((SqlParameter)it.next()));
            }
            boolean allParams = true;
            for(Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
                SqlParameter param = (SqlParameter)it.next();
                if(param.isApply()) {
                    cmd.addParameter(param);
                } else {
                    if (!param.getUseIsNull()) allParams = false;
                }
            }
            String embededWhere = selectNode.getAttribute("where");
            if (!StringUtils.isEmpty(embededWhere)) {
              if ( where.length() > 0 ) {
                where.insert(0, embededWhere + " AND (").append(")");
              } else {
                where.append(embededWhere);
              }
            }
            if ( where.length() > 0 ) {
              if (StringUtils.isEmpty(cmd.getWhere())) {
                cmd.setWhere(where);
              } else {
                cmd.setWhere(where + " AND (" + cmd.getWhere() + ")");
              }
            }
            if ( allParams ) {
                //cmd.setWhere(where);

                if ( StringUtils.isEmpty( query ) ) {
                    ds.closeConnection();
                    return;
                }
                if ( selectNode.getAttribute("orderBy") != null ) {
                  cmd.setOrder(selectNode.getAttribute("orderBy"));
                }
                cmd.setSql( sql.toString() );
                model.fireBeforeExecuteSelectEvent(doe); // TODO:
                model.record = cmd.getOneRow(); // TODO: Do not store row in model.record
                logger.debug( cmd.toString() );
                model.fireAfterExecuteSelectEvent(doe); // TODO:
                if ( model.record == null ) {
                    model.setMode( Record.INSERT_MODE );
                }
            } else {
                model.setMode( Record.INSERT_MODE );
            }
            if ( ds.hasErrors() ) {
                model.addErrors( ds.getErrors() );
            }
        }
        this.row = model.record;
        ds.closeConnection();
        bind();
  }
  protected void bind() {
    //if (row != null) {
    if ( (row != null) || (this.outDbParameters != null && !this.outDbParameters.isEmpty()) ) {
        Iterator i = model.getChildren().iterator();
        while (i.hasNext()) {
            Model m = (Model)i.next();
            if ((model.isProcessed() && !(m instanceof VerifiableControl) && m instanceof Control) ||
            (!model.isProcessed() && m instanceof Control)) {
                Control c = (Control)m;
                Object value = null;
                if (!StringUtils.isEmpty(c.getFieldSource())) {
                    value = getControlValue(row, this.outDbParameters, c.getControlSourceType(), c.getFieldSource());
                }
                if (c instanceof Link) { 
                    setLinkProperties(row, this.outDbParameters, (Link) c); 
                }

                if ( !StringUtils.isEmpty ( c.getFieldSource()) ) {
                    setControlValueFromDb(c, value); 
                }

                {
                    Iterator rAttrs = c.getAttributeKeys().iterator();
                    while (rAttrs.hasNext()) {
                        String rAttrName = (String)rAttrs.next();
                        ModelAttribute brAttr = bindRowAttribute ( (ModelAttribute)c.getAttribute( rAttrName ), row );
                        c.setAttribute(brAttr.getName(), brAttr);
                    }
                }

            }
        }

        {
            Iterator rAttrs = model.getAttributeKeys().iterator();
            while (rAttrs.hasNext()) {
                String rAttrName = (String)rAttrs.next();
                ModelAttribute brAttr = bindRowAttribute ( (ModelAttribute)model.getAttribute( rAttrName ), row );
                model.setAttribute(brAttr.getName(), brAttr);
            }
        }


    }
//-----------------------------------------------------------------------------------------------------------------
        /*
      } else {
        Iterator i = model.getChildren().iterator();
        while (i.hasNext()) {
          Model m = (Model)i.next();
          if (m instanceof Link) {
            Link link = (Link)m;
            if ("Database".equals(link.getHrefType())) {
              link.setHrefSourceValue("");
            }
          }
        }
      }
        */
  }


    protected void insert() {
        Element insertNode = getFirstChildElementByName(elm, "Insert");
        if (insertNode == null) return;
        Collection sqlParameters = getChildrenElementsByName(insertNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(insertNode, "SPParameter");
        model.setAllowInsert(new Boolean(elm.getAttribute("allowInsert")).booleanValue());
        String connectionName = elm.getAttribute("connection");
        String query = insertNode.getAttribute("query");
        String queryType = insertNode.getAttribute("type");

        model.fireBeforeInsertEvent(); // TODO:
        if ( ! model.isAllowInsert() ) return;

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(Locale.getDefault()); // TODO: not default
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "BooleanFormat" );
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "DateFormat" );

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
        Collection spParamsCollection = getSpParameters(spParameters, model);

        if ( queryType.equals("call") ) {
            SPCommand cmd = SPCommandFactory.getSPCommand( connectionName );
            cmd.setJdbcConnection( ds );
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));
            Iterator sParams = spParamsCollection.iterator();
            StringBuffer call = new StringBuffer( replaceParameters( query, sParams ) );

            Iterator it = spParamsCollection.iterator();
            while ( it.hasNext() ) {
                cmd.addParameter( (SPParameter) it.next() );
            }
            if ( StringUtils.isEmpty( query ) ) {
                ds.closeConnection();
                return;
            }
            cmd.setSql( call.toString() );
            logger.debug( cmd.toString() );
            model.fireBeforeBuildInsertEvent(doe); // TODO:
            model.fireBeforeExecuteInsertEvent(doe); // TODO:
            cmd.executeUpdate();
            model.fireAfterExecuteInsertEvent(doe); // TODO:
        } else {
            Command cmd = null;
            if ( queryType.equals("raw") ) {
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
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(sqlParamsCollection, null));
            StringBuffer sql = new StringBuffer( query );
            if ( queryType.equals("sql") ) {
                sql = new StringBuffer( replaceParameters( query, sqlParamsCollection.iterator() ) );
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter)it.next()));
            } else {
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addRawParameter((SqlParameter)it.next()));
            }
            if ( StringUtils.isEmpty( query ) ) {
                ds.closeConnection();
                return;
            }

            //cmd.setSql( cutOmitParametersInsert(sql.toString(), sqlParamsCollection.iterator(), page, model ) );
            cmd.setSql( sql.toString() );
            model.fireBeforeBuildInsertEvent(doe); // TODO:
            model.fireBeforeExecuteInsertEvent(doe); // TODO:
            if ( !StringUtils.isEmpty (cmd.getSql()) ) {
                cmd.setSql( cutOmitParametersInsert(cmd.getSql(), ((SqlParameters)doe.getDataSource()).getSqlParameters().iterator(), page, model) );
                cmd.executeUpdate();
            }
            logger.debug( cmd.toString() );
            model.fireAfterExecuteInsertEvent(doe); // TODO:
        }
        ds.closeConnection();
        if ( ds.hasErrors() ) {
            model.addErrors( ds.getErrors() );
        }
        if (!model.hasErrors()) {
            processFile(elm, model);
        }
        model.fireAfterInsertEvent(); // TODO:
    }



    protected void update() {
        Element updateNode = getFirstChildElementByName(elm, "Update");
        if (updateNode == null) return;
        Element whereNode = getFirstChildElementByName(updateNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null) whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(updateNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(updateNode, "SPParameter");
        model.setAllowUpdate(new Boolean(elm.getAttribute("allowUpdate")).booleanValue());
        String connectionName = elm.getAttribute("connection");
        String query = updateNode.getAttribute("query");
        String queryType = updateNode.getAttribute("type");

        model.fireBeforeUpdateEvent();
        if ( ! model.isAllowUpdate() ) return;

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(Locale.getDefault()); // TODO: not default
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "BooleanFormat" );
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "DateFormat" );

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model);
        Collection spParamsCollection = getSpParameters(spParameters, model);

        if ( queryType.equals("call") ) { // Update based on Stored Procedure call
            SPCommand cmd = SPCommandFactory.getSPCommand(connectionName);
            cmd.setJdbcConnection( ds );
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));
            Iterator sParams = spParamsCollection.iterator();
            StringBuffer call = new StringBuffer( replaceParameters( query, sParams ) );

            Iterator it = spParamsCollection.iterator();
            while ( it.hasNext() ) {
              cmd.addParameter( (SPParameter) it.next() );
            }
            if ( StringUtils.isEmpty( query ) ) {
                ds.closeConnection();
                return;
            }
            cmd.setSql( call.toString() );
            model.fireBeforeBuildUpdateEvent(doe); // TODO:
            model.fireBeforeExecuteUpdateEvent(doe); // TODO:
            cmd.executeUpdate();
            logger.debug( cmd.toString() );
            model.fireAfterExecuteUpdateEvent(doe); // TODO:
        } else {
            Command cmd = null;
            if ( queryType.equals("raw") ) {
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
            SqlParameters parameters = new SqlParameters(sqlParamsCollection, whereParamsCollection);
            StringBuffer sql = new StringBuffer( query );
            StringBuffer where = new StringBuffer();
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(parameters);
            model.fireBeforeBuildUpdateEvent(doe); // TODO: moved here because default values and expressions of where parameters are set in this event, but originally it was just before the BeforeExecute event.
            if ( queryType.equals("sql") ) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer( replaceParameters( query, sParams ) );
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildWhere(getWhereClause(whereNode), parameters);
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter)it.next()));
            } else {
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildRawWhere(getWhereClause(whereNode), parameters, ds );
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addRawParameter((SqlParameter)it.next()));
            }

            boolean allParams = true;
            for(Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
                SqlParameter param = (SqlParameter)it.next();
                if(param.isApply()) {
                    cmd.addParameter(param);
                } else {
                    allParams = false;
                }
            }
            cmd.setWhere(where);
            if ( StringUtils.isEmpty( query ) ) {
                ds.closeConnection();
                return;
            }
            //cmd.setSql( cutOmitParametersUpdate(sql.toString(), sqlParamsCollection.iterator(), page, model ) );
            cmd.setSql( sql.toString() );
            if (!allParams) cmd.setCmdExecution(false);
            model.fireBeforeExecuteUpdateEvent(doe); // TODO:
            if (cmd.isCmdExecution()) {
              if ( !StringUtils.isEmpty (cmd.getSql()) ) {
                    cmd.setSql( cutOmitParametersUpdate(cmd.getSql(), ((SqlParameters)doe.getDataSource()).getSqlParameters().iterator(), page, model) );
                    cmd.executeUpdate();
              }
              logger.debug( cmd.toString() );
              model.fireAfterExecuteUpdateEvent(doe); // TODO:
            } else {
              try {
                ResourceBundle res = ResourceBundle.getBundle("MessagesBundle");
                model.addError(res.getString("CCS_CustomOperationError_MissingParameters"));
              } catch (Exception e) {
                logger.error("Message with key CustomOperationError_MissingParameters was not found");
              }
            }
        }
        ds.closeConnection();
        if ( ds.hasErrors() ) {
            model.addErrors( ds.getErrors() );
        }
        if (!model.hasErrors()) {
            processFile(elm, model);
        }
        model.fireAfterUpdateEvent();
    }
    protected void delete() {
        StringBuffer sql;
        Element deleteNode = getFirstChildElementByName(elm, "Delete");
        if (deleteNode == null) return;
        Element whereNode = getFirstChildElementByName(deleteNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null) whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(deleteNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(deleteNode, "SPParameter");
        model.setAllowDelete(new Boolean(elm.getAttribute("allowDelete")).booleanValue());
        String connectionName = elm.getAttribute("connection");
        String query = deleteNode.getAttribute("query");
        String queryType = deleteNode.getAttribute("type");

        model.fireBeforeDeleteEvent(); // TODO:
        if ( ! model.isAllowDelete() ) return;

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(Locale.getDefault()); // TODO: not default
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "BooleanFormat" );
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "DateFormat" );

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model);
        Collection spParamsCollection = getSpParameters(spParameters, model);

        if ( queryType.equals("call") ) {
            SPCommand cmd = SPCommandFactory.getSPCommand( connectionName );
            cmd.setJdbcConnection( ds );

            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(new SqlParameters(spParamsCollection, null));

            Iterator sParams = spParamsCollection.iterator();
            sql = new StringBuffer( replaceParameters( query, sParams ) );

            Iterator it = spParamsCollection.iterator();
            while ( it.hasNext() ) {
              cmd.addParameter( (SPParameter) it.next() );
            }
            if ( StringUtils.isEmpty( query ) ) {
                ds.closeConnection();
                return;
            }
            cmd.setSql( sql.toString() );
            logger.debug( cmd.toString() );
            model.fireBeforeBuildDeleteEvent(doe); // TODO:
            model.fireBeforeExecuteDeleteEvent(doe); // TODO:
            cmd.executeUpdate();
            model.fireAfterExecuteDeleteEvent(doe); // TODO:
        } else {
            Command cmd = null;
            if ( queryType.equals("raw") ) {
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
            SqlParameters parameters = new SqlParameters(sqlParamsCollection, whereParamsCollection);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(parameters);
            sql = new StringBuffer( query );
            StringBuffer where = new StringBuffer();
            model.fireBeforeBuildDeleteEvent(doe); // TODO: moved here because default values and expressions of where parameters are set in this event, but originally it was just before the BeforeExecute event.
            if ( queryType.equals("sql") ) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer( replaceParameters( query, sParams ) );

                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter)it.next()));
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildWhere( getWhereClause(whereNode), parameters );
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
            } else {
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addRawParameter((SqlParameter)it.next()));
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildRawWhere( getWhereClause(whereNode), parameters, ds );
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
            }
            boolean allParams = true;
            for(Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
                SqlParameter param = (SqlParameter)it.next();
                if ( param.isApply() ) {
                    cmd.addParameter(param);
                } else {
                   allParams = false;
                }
            }
            cmd.setWhere(where);
            if ( StringUtils.isEmpty( query ) ) {
                ds.closeConnection();
                return;
            }
            cmd.setSql( sql.toString() );
            if (!allParams) cmd.setCmdExecution(false);
            model.fireBeforeExecuteDeleteEvent(doe); // TODO:
            if (cmd.isCmdExecution()) {
              if ( !StringUtils.isEmpty (cmd.getSql()) ) cmd.executeUpdate();
              logger.debug( cmd.toString() );
              model.fireAfterExecuteDeleteEvent(doe); // TODO:
            } else {
              try {
                ResourceBundle res = ResourceBundle.getBundle("MessagesBundle");
                model.addError(res.getString("CCS_CustomOperationError_MissingParameters"));
              } catch (Exception e) {
                logger.error("Message with key CustomOperationError_MissingParameters was not found.");
              }
            }
        }
        ds.closeConnection();
        if ( ds.hasErrors() ) {
            model.addErrors( ds.getErrors() );
        }
        if (!model.hasErrors()) {
            deleteFile(elm, model);
        }
        model.fireAfterDeleteEvent(); // TODO:
    }
}
//End RecordProcessor class: head

