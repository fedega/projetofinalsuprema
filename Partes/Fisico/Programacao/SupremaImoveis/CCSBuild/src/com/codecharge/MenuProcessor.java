//MenuProcessor class: head @0-4271C737
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class MenuProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  private Menu model;
  private Enumeration records;

  public MenuProcessor(Element elm, Model model, Page page) {
    super(elm,model,page);
    this.model = (Menu)model;
  }


  public void process() {
    if (page.getRedirectString() != null) {
      return;
    }

    setActivePermissions( model );
    if ( ! model.isVisible() ) {
      return;
    }

    logger.debug("Process Menu "+model.getName());
    setProperties( model, PageController.GET );

    if ("DataSource".equals(elm.getAttribute("menuSourceType")))
		select();
    model.buildTree();

  }

  protected void select() {
      Element selectNode = getFirstChildElementByName(elm, "Select");
      if (selectNode == null) return;
      Element countNode = getFirstChildElementByName(selectNode, "CountSql");
      Element whereNode = getFirstChildElementByName(selectNode, "Where");
      Collection whereParameters = null;
      if (whereNode != null) whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
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

      //model.fireBeforeSelectEvent();

      JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection( connectionName);
      ds.setLocale(page.getCCSLocale().getLocale());
      defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "BooleanFormat" );
      defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "DateFormat" );

      Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
      Collection whereParamsCollection = getWhereParameters(whereParameters, model);
      Collection spParamsCollection = getSpParameters(spParameters, model);
      int size = 0;

      if ( queryType.equals("call") ) {
          SPCommand cmd = SPCommandFactory.getSPCommand( connectionName );
          cmd.setJdbcConnection( ds );
          setActiveResultSet(selectNode, cmd);
          DataObjectEvent doe = new DataObjectEvent(cmd);
          doe.setDataSource(new SqlParameters(spParamsCollection, null));
          //model.fireBeforeBuildSelectEvent(doe);

          Iterator sParams = spParamsCollection.iterator();
          StringBuffer sql = new StringBuffer( replaceParameters( query, sParams ) );

          Iterator it = spParamsCollection.iterator();
          while ( it.hasNext() ) {
            cmd.addParameter( (SPParameter) it.next() );
          }
          if ( StringUtils.isEmpty( query ) ) {
              ds.closeConnection();
              return;
          }
          cmd.setSql( sql.toString() );
          //cmd.setFetchSize (model.getFetchSize() );
          //cmd.setStartPos( (model.getPage() - 1) * model.getFetchSize() + 1 );
          //model.fireBeforeExecuteSelectEvent( doe );
          records = cmd.getRows();
          this.outDbParameters = cmd.getOutputParameters();
          logger.debug( cmd.toString() );
          //model.fireAfterExecuteSelectEvent(doe);
      } else {
          Command cmd = null;
          if ( queryType.equals("raw") ) {
              cmd = new RawCommand(ds);
              ((RawCommand)cmd).setOptimizeSQL(optimize);
              cmd.setNeedQuotes(true);
          } else if (queryType.equals("custom")) {
              cmd = new RawCommand(ds);
              ((RawCommand)cmd).setOptimizeSQL(optimize);
          } else if (queryType.equals("sql")) {
              cmd = new SqlCommand(ds);
          } else {
              ds.closeConnection();
              return;
          }

          StringBuffer sql = new StringBuffer( query );
          StringBuffer countSql = new StringBuffer(countQuery);
          StringBuffer where = new StringBuffer();
          SqlParameters parameters = new SqlParameters(sqlParamsCollection, whereParamsCollection);
          DataObjectEvent doe = new DataObjectEvent(cmd);
          doe.setDataSource(parameters);
          //model.fireBeforeBuildSelectEvent(doe); // TODO:
          if ( queryType.equals("sql") ) {
              Iterator sParams = sqlParamsCollection.iterator();
              sql = new StringBuffer( replaceParameters( query, sParams ) );
              sParams = sqlParamsCollection.iterator();
              countSql = new StringBuffer( replaceParameters( countQuery, sParams ) );

              for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter)it.next()));

              WhereBuilder wb = new WhereBuilder();
              String sWhere = wb.buildWhere(getWhereClause(whereNode), parameters);
              if ( ! StringUtils.isEmpty( sWhere ) ) {
                  where = new StringBuffer( sWhere );
              }
          } else {
              for ( Iterator it = sqlParamsCollection.iterator(); it.hasNext(); ) {
                  SqlParameter param = (SqlParameter)it.next();
                  if ( param.isApply() ) {
                      cmd.addParameter(param);
                  }
              }
              WhereBuilder wb = new WhereBuilder();
              String sWhere = wb.buildRawWhere(getWhereClause(whereNode), parameters, ds );
              if ( ! StringUtils.isEmpty( sWhere ) ) {
                  where = new StringBuffer( sWhere );
              }
          }
          for(Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
              SqlParameter param = (SqlParameter)it.next();
              if(param.isApply()) {
                  cmd.addParameter(param);
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

          if ( StringUtils.isEmpty( query ) ) {
              ds.closeConnection();
              return;
          }

          if ( selectNode.getAttribute("orderBy") != null ) {
              cmd.setOrder(selectNode.getAttribute("orderBy"));
          }


          cmd.setSql( sql.toString() );
          //model.fireBeforeExecuteSelectEvent(doe); // TODO:
          logger.debug( cmd.toString() );

          records = cmd.getRows();

          java.util.ArrayList recList = new java.util.ArrayList();
          if (records != null)  {
            recList = Utils.list(records);
            records = java.util.Collections.enumeration(recList);
          }

          logger.debug( cmd.toString() );
          //model.fireAfterExecuteSelectEvent(doe); // TODO:
          if (ds.hasErrors()) {
            model.addErrors(ds.getErrors());
          }
      }
      ds.closeConnection();
      int bound = bind();
  }

  protected int bind() {
    int n = 0;
    if (records == null) return n;
    
    com.codecharge.components.Link item_link = null;
    NodeList lists = this.elm.getChildNodes();
    for (int i=0; i<lists.getLength(); i++) {
      if (lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
        
    	  Element list = (Element)lists.item(i);
    	  System.out.println(list.getTagName());
    	  if  (list.getTagName().equals("Link")) {
        	item_link = (com.codecharge.components.Link) model.getChild(list.getAttribute("name"));
        	break;
        }
      }
    }
    
    String idField = this.elm.getAttribute("idField");
    String parentIdField = this.elm.getAttribute("parentIdField");
    
    
    while (records != null && records.hasMoreElements()) {
      DbRow row = null;
      if ( records != null && records.hasMoreElements() ) {
        row = (DbRow) records.nextElement();
      }

      Object row_idField = getControlValue(row, null, "DataSource", idField);
      Object row_parentIdField = ("".equals(parentIdField.toString())? "" : getControlValue(row, null, "DataSource", parentIdField));
      Object row_caption = getControlValue(row, null, "DataSource", item_link.getFieldSource());
      Object row_url = null;
      Object row_target = null;
      Object row_title = null;
      
      if ("Database".equals(item_link.getHrefType()))
    	 row_url = getControlValue(row, null, "DataSource", item_link.getHrefSource());
      else 
    	  row_url = item_link.getHrefSource();
      
      ModelAttribute ma = (com.codecharge.util.ModelAttribute) this.model.getAttribute("Title");
      if ("DataField".equals(ma.getSourceType())) 
    	  row_title  = getControlValue(row, null, "DataSource", ma.getSourceName()); 
      else 
    	  row_title  = ma.getSourceName();
      
      ma = (com.codecharge.util.ModelAttribute) this.model.getAttribute("Target");
      if ("DataField".equals(ma.getSourceType())) 
    	  row_target  = getControlValue(row, null, "DataSource", ma.getSourceName()); 
      else 
    	  row_target  = ma.getSourceName();
      
      model.addMenuItem("" + row_idField, "" + (null == row_parentIdField ? "" : row_parentIdField),
    		  	"" + (null == row_caption ? "" : row_caption), "" + (null == row_url ? "" : row_url),
    		  	"" + (null == row_target ? "" : row_target), "" + "" + (null == row_title ? "" : row_title));
      n++;
    }
    return n;
  }


}

//End MenuProcessor class: head

