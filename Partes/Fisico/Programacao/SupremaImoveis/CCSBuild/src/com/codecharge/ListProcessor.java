//ListProcessor class: head @0-BEE12719
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class ListProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  private Format defaultBooleanFormat;
  private Format defaultDateFormat;
  private com.codecharge.components.List model;

  public ListProcessor(Element elm, Model model, Page page) {
  	super(elm,model,page);
    this.model = (com.codecharge.components.List)model;
  }

  public void process() {
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

        logger.debug( "Process List "+model.getName() );
        if ( StringUtils.isEmpty( connectionName ) ) return;

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(page.getCCSLocale().getLocale());
        defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "BooleanFormat" );
        defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "DateFormat" );

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, (Component)null);
        Collection whereParamsCollection = getWhereParameters(whereParameters, null);
        Collection spParamsCollection = getSpParameters(spParameters, (Component)null);

        if ( queryType.equals("call") ) {
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
                cmd.addParameter( (SPParameter) it.next() );
            }
            if ( StringUtils.isEmpty( call.toString() ) ) {
                ds.closeConnection();
                return;
            }
            cmd.setSql( call.toString() );
            model.fireBeforeExecuteSelectEvent(doe);
            logger.debug( cmd.toString() );
            model.setOptions( cmd.getRows(), ds );
            model.fireAfterExecuteSelectEvent(doe);

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
            model.fireBeforeBuildSelectEvent(doe);
            if ( queryType.equals("sql") ) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer( replaceParameters( query, sParams ) );

                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter)it.next()));

                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildWhere(getWhereClause(whereNode), parameters );
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

            cmd.setOrder(selectNode.getAttribute("orderBy"));

            if ( StringUtils.isEmpty( sql.toString() ) ) {
                ds.closeConnection();
                return;
            }
            cmd.setSql( sql.toString() );
            model.fireBeforeExecuteSelectEvent(doe);
            model.setOptions( cmd.getRows(), ds );
            logger.debug( cmd.toString() );
            model.fireAfterExecuteSelectEvent(doe);
        }
        ds.closeConnection();
  }
  protected void select() {}
  protected void bind() {}
}
//End ListProcessor class: head

