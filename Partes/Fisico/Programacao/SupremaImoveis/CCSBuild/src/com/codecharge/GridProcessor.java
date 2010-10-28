//GridProcessor class: head @0-F64ED698
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class GridProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  //private Format defaultBooleanFormat;
  //private Format defaultDateFormat;
  private Grid model;
  private Enumeration records;

  public GridProcessor(Element elm, Model model, Page page) {
    super(elm,model,page);
    this.model = (Grid)model;
  }

  public void process() {
    if (page.getRedirectString() != null) {
      return;
    }

    setActivePermissions( model );
    if ( ! model.isVisible() ) {
      return;
    }

    logger.debug("Process Grid '"+model.getName());
    setProperties( model, PageController.GET );

    NodeList lists = elm.getChildNodes();
    for (int i=0; i<lists.getLength(); i++) {
      if (lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
        Element list = (Element)lists.item(i);
        if  (list.getTagName().equals("Row")) {
          NodeList rowLists = list.getChildNodes();
          for (int ri=0; ri<rowLists.getLength(); ri++) {
            if (rowLists.item(ri).getNodeType() == Node.ELEMENT_NODE) {
              Element rlist = (Element)rowLists.item(ri);
              if (rlist.getTagName().equals("ListBox") ||
                  rlist.getTagName().equals("RadioButton") ||
                  rlist.getTagName().equals("CheckBoxList"))
              {
                 ListProcessor listProc = new ListProcessor(rlist, model.getChild(rlist.getAttribute("name")), page);
                 listProc.process();
              }
            }
          }
        } else if (list.getTagName().equals("ListBox") ||
            list.getTagName().equals("RadioButton") ||
            list.getTagName().equals("CheckBoxList"))
        {
          ListProcessor listProc = new ListProcessor(list, model.getChild(list.getAttribute("name")), page);
          listProc.process();
        }
      }
    }
    select();
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
      if ( ! model.isAllowRead() ) return;
      model.fireBeforeSelectEvent();
      if ( ! model.isAllowRead() ) return;
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
          model.fireBeforeBuildSelectEvent(doe);

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
          cmd.setFetchSize (model.getFetchSize() );
          cmd.setStartPos( (model.getPage() - 1) * model.getFetchSize() + 1 );
          model.fireBeforeExecuteSelectEvent( doe );
          records = cmd.getRows();
          this.outDbParameters = cmd.getOutputParameters();
          if (cmd.isNext()) {
              model.setNumberOfRows(model.getPage() * model.getFetchSize() + 1);
          } else if (records != null && records.hasMoreElements()) {
              model.setNumberOfRows(1);
          } else if (! this.outDbParameters.isEmpty()) {
              model.setNumberOfRows(1);
          } else {
              model.setNumberOfRows(0);
          }
          logger.debug( cmd.toString() );
          model.fireAfterExecuteSelectEvent(doe);
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
          model.fireBeforeBuildSelectEvent(doe); // TODO:
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

          if ( countSql.length() > 0 ) {
              cmd.setCountSql( countSql.toString() );
          } else {
              if ( StringUtils.isEmpty( cmd.getCountSql() ) ) model.setCountNeeded(false);
          }

          if ( ! StringUtils.isEmpty( model.getSort() ) ) {
              cmd.setOrder(((Sorter) model.getChild( model.getSort() )).getColumn( model.getDir() ));
          } else if ( selectNode.getAttribute("orderBy") != null ) {
              cmd.setOrder(selectNode.getAttribute("orderBy"));
          }

          cmd.setSql( sql.toString() );
          size = model.getFetchSize();
          int sizeLimit = model.getFetchSizeLimit();
          if (sizeLimit > 1 && sizeLimit < size) size = sizeLimit;
          if ((size < 1 || size == Integer.MAX_VALUE) && cmd instanceof RawCommand) {
            ((RawCommand)cmd).setOptimizeSQL(false);
          }
          cmd.setFetchSize(size);
          cmd.setStartPos((model.getPage() - 1) * size + 1);
          model.fireBeforeExecuteSelectEvent(doe); // TODO:
          if ( model.isCountNeeded() ) {
              if ( queryType.equals("sql") ) {
                  model.setNumberOfRows( ((SqlCommand) cmd).count() );
              } else {
                  model.setNumberOfRows( ((RawCommand) cmd).count() );
              }
              logger.debug( cmd.toString() );
          }

          records = cmd.getRows();

          java.util.ArrayList recList = new java.util.ArrayList();
          if (records != null)  {
            recList = Utils.list(records);
            records = java.util.Collections.enumeration(recList);
          }

          if (!model.isCountNeeded()) {
            if (cmd.isNext()) {
              model.setNumberOfRows(model.getPage() * size + 1);
            } else {
              model.setNumberOfRows(recList.size());
            }
          }

          logger.debug( cmd.toString() );
          model.fireAfterExecuteSelectEvent(doe); // TODO:
          if (ds.hasErrors()) {
            model.addErrors(ds.getErrors());
          }
      }
      ds.closeConnection();
      int bound = bind();
  }

  protected int bind() {
    Iterator childRows = model.getChildRows().iterator();
    HashMap childRow = null;
    HashMap attrRow = null;
    int n = 0;
    if (records == null && this.outDbParameters.isEmpty()) return n;
    boolean bindOutDbParameters = ! this.outDbParameters.isEmpty();
    while ((records != null && records.hasMoreElements()) || bindOutDbParameters) {
      boolean isNew = false;
      DbRow row = null;
      if ( records != null && records.hasMoreElements() ) {
        row = (DbRow) records.nextElement();
      }
      if (childRows.hasNext()) {
        childRow = (HashMap)childRows.next();
        if (childRow == null) {
          isNew = true;
          childRow = new HashMap();
        }
      } else {
        isNew = true;
        childRow = new HashMap();
        attrRow = new HashMap();
      }
      if (isNew) {
        Iterator children = model.getChildren().iterator();
        while (children.hasNext()) {
          Model child = (Model)children.next();
          if (child instanceof Control) {
            Control ctrl = (Control)((Control)child).clone();
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

            ctrl.setHtmlName(ctrl.getName() + "_" + (n+1));
            if (ctrl instanceof Link) {
                setLinkProperties(row, this.outDbParameters, (Link) ctrl);
            }
            if (ctrl.isStatic()) continue;
            
            Object value = getControlValue(row, this.outDbParameters, ctrl.getControlSourceType(), ctrl.getFieldSource());

            if ( !StringUtils.isEmpty ( ctrl.getFieldSource()) ) {
                setControlValueFromDb(ctrl, value); 
            }

            childRow.put(ctrl.getName(), ctrl);
          } else if (child instanceof DatePicker) {
            DatePicker dp = (DatePicker)((DatePicker)child).clone();
            dp.setHtmlName(dp.getControlName() + "_" + (n+1));
            childRow.put(dp.getName(), dp);
          } else if (child instanceof Button) {

            //-----------------------------ATTRIBUTES-----------------------------
            Button btn = (Button)child.clone();
            {
                Iterator rAttrs = btn.getAttributeKeys().iterator();
                while (rAttrs.hasNext()) {
                    String rAttrName = (String)rAttrs.next();
                    ModelAttribute brAttr = bindRowAttribute ( (ModelAttribute)btn.getAttribute( rAttrName ), row );
                    btn.setAttribute(brAttr.getName(), brAttr);
                }
            }
            childRow.put(btn.getName(), btn);
            //-----------------------------/ATTRIBUTES----------------------------            
          }
        }

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

        model.addAttributesRow(""+(n+1), attrRow );
        model.addChildRow(childRow);
      }
      n++;
      bindOutDbParameters = false;
    }
    return n;
  }
}
//End GridProcessor class: head

