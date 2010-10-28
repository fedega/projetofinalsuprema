//DirectoryProcessor class: head @0-F45BCECE
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.events.*;
import com.codecharge.db.*;
import com.codecharge.util.*;

import java.text.*;
import java.util.*;
import org.w3c.dom.*;

public class DirectoryProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  //private Format defaultBooleanFormat;
  //private Format defaultDateFormat;
  private Enumeration records;
  private Directory model;

  public DirectoryProcessor(Element elm, Model model, Page page) {
    super(elm,model,page);
    this.model = (Directory)model;
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
        if (list.getTagName().equals("ListBox") ||
            list.getTagName().equals("RadioButton") ||
            list.getTagName().equals("CheckBoxList"))
        {
          new ListProcessor(list, model.getChild(list.getAttribute("name")), page).process();
        }
      }
    }
    select();
  }

  protected void select() {
        if (page.getHttpPostParams().getParameter("ccsForm") != null) {
          return;
        }
        Element selectNode = getFirstChildElementByName(elm, "Select");
        Element whereNode = getFirstChildElementByName(selectNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null) whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(selectNode, "SqlParameter");
        Collection spParameters = getChildrenElementsByName(selectNode, "SPParameter");
        String connectionName = elm.getAttribute("connection");
        String query = selectNode.getAttribute("query");
        String queryType = selectNode.getAttribute("type");
        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection( connectionName);
        ds.setLocale(page.getCCSLocale().getLocale());

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model);
        Collection spParamsCollection = getSpParameters(spParameters, model);
        model.fireBeforeSelectEvent(new Event()); // TODO: shouldn't pass Event object there

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
            logger.debug( cmd.toString() );
            model.fireBeforeExecuteSelectEvent(doe); // TODO:
            records = cmd.getRows();
            this.outDbParameters = cmd.getOutputParameters();
            model.fireAfterExecuteSelectEvent(doe); // TODO:
        } else {
            Command cmd = null;
            if ( queryType.equals("raw") ) {
                cmd = new RawCommand(ds);
                cmd.setNeedQuotes(true);
                ((RawCommand)cmd).setOptimizeSQL(false);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
                ((RawCommand)cmd).setOptimizeSQL(false);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                ds.closeConnection();
                return;
            }

            StringBuffer sql = new StringBuffer( query );
            StringBuffer where = new StringBuffer();
            SqlParameters parameters = new SqlParameters(sqlParamsCollection, whereParamsCollection);
            DataObjectEvent doe = new DataObjectEvent(cmd);
            doe.setDataSource(parameters);
            model.fireBeforeBuildSelectEvent(doe); // TODO:
            if ( queryType.equals("sql") ) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer( replaceParameters( query, sParams ) );
                sParams = sqlParamsCollection.iterator();

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
                where.insert(0, embededWhere + " AND ");
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
            model.fireBeforeExecuteSelectEvent(doe); // TODO:
            records = cmd.getRows();
            logger.debug( cmd.toString() );
            model.fireAfterExecuteSelectEvent(doe); // TODO:
        }
        ds.closeConnection();
        bind();
  }

  protected void bind() {
    Iterator childRows = model.getChildRows().iterator();
    HashMap childRow = null;
    HashMap attrRow = null;
    int n = 1;
    int numberOfCategories = 0;
    int currentCategoryId = 0;
    long catId = 0; // previous id
    Vector state = new Vector();
    Vector cat = null;
    long subcatcount = 0;
    long subcatnum = model.getNumberOfSubCategories();
    model.setStateMachine(state); // Don't allow NPE at 'No Records' in CategoriesTag
    if (records == null) return;
    while (records.hasMoreElements()) {
      boolean isNew = false;
      DbRow row = (DbRow)records.nextElement();
      catId = ((Number) getControlValue(row, this.outDbParameters, "DataSource", model.getCategoryFieldName())).longValue();
      //catId = ((Number)row.get(model.getCategoryFieldName())).longValue();
      if (childRows.hasNext()) {
        childRow = (HashMap)childRows.next();
        if (childRow == null) {
          isNew = true;
          childRow = new HashMap();
          attrRow = new HashMap();
        }
      } else {
        isNew = true;
        childRow = new HashMap();
        attrRow = new HashMap();
      }
      if ( catId != currentCategoryId ) {
          cat = new Vector();
          state.add(cat);
          subcatcount = 0;
          numberOfCategories++;
          currentCategoryId = (int) catId;
          childRow.put(Directory.CATEGORY_KEY, "");
      }
      if (! StringUtils.isEmpty(getControlValue(row, this.outDbParameters, "DataSource", model.getSubCategoryFieldName()).toString())) {
      //if (!StringUtils.isEmpty(row.get(model.getSubCategoryFieldName()).toString())) {
        subcatcount++;
        if (subcatnum > 0) {
          if (subcatcount < subcatnum) {
            cat.add("SUBCAT");
          }
          if (subcatcount == subcatnum) {
            cat.add("LAST");
          }
          if (subcatcount == subcatnum + 1) {
            cat.add("MORE");
          }
        } else {
          cat.add("SUBCAT");
        }
        childRow.put(Directory.SUBCATEGORY_KEY, "");
      }
      if (isNew) {
        Iterator children = model.getChildren().iterator();
        while (children.hasNext()) {
          Model child = (Model)children.next();
          if (child instanceof Control) {
            Control ctrl = (Control)((Control)child).clone();
            Object value = getControlValue(row, this.outDbParameters, ctrl.getControlSourceType(), ctrl.getFieldSource());


            if ( !StringUtils.isEmpty ( ctrl.getFieldSource()) ) {
                setControlValueFromDb(ctrl, value); 
            }            

            ctrl.setHtmlName(ctrl.getName() + "_" + n);
            if (ctrl instanceof Link) {
                setLinkProperties(row, this.outDbParameters, (Link) ctrl);
            }
            childRow.put(ctrl.getName(), ctrl);
          } else if (child instanceof DatePicker) {
            DatePicker dp = (DatePicker)((DatePicker)child).clone();
            dp.setHtmlName(dp.getControlName() + "_" + n);
            childRow.put(dp.getName(), dp);
          }
        }


        Iterator rAttrs = model.getRowAttributeKeys().iterator();
        while (rAttrs.hasNext()) {
            String rAttrName = (String)rAttrs.next();
            ModelAttribute brAttr = bindRowAttribute ( model.getRowAttribute( rAttrName ), row );
            attrRow.put(brAttr.getName(), brAttr);
        }

        //model.addAttributesRow(attrRow);
        model.addChildRow(childRow);
      }
      n++;
    }
    model.setNumberOfCategories( numberOfCategories );
    model.setNumberOfRows(n-1);
    model.setStateMachine(state);
  }
}
//End DirectoryProcessor class: head

