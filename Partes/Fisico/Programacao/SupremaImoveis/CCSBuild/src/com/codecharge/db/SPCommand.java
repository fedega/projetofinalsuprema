//SPCommand class @0-7BA7A45A
package com.codecharge.db;

import java.text.*;
import java.util.*;
import java.sql.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.components.*;

public class SPCommand extends Command {

    protected final static int RESULT_SET_NUMBER_ISNOTUSED = -1;
    protected final static String RESULT_SET_NAME_ISNOTUSED = null;
    
    protected int activeResultSetNumber;
    protected String activeResultSetName;
    
    protected ArrayList rowSets = new ArrayList();
    protected Enumeration activeRowSet;
    
    /**
     * List of output sp parameters.
     * It needs for JSP.
     */ 
    protected DbRow outParameters = new DbRow();

    public SPCommand() {
        activeResultSetNumber = 0;
        activeResultSetName = null;
    }
    
    public SPCommand( JDBCConnection conn ) {
        super( conn );
        activeResultSetNumber = 0;
        activeResultSetName = null;
        outParameters.setUseUpperCase(conn.isUseUpperCase());
    }

    public Enumeration getRowSet(int index) {
        return Collections.enumeration((Collection) this.rowSets.get(index));
    }
    
    public int getActiveResultSetNumber() {
        return this.activeResultSetNumber;
    }
    public void setActiveResultSetNumber(int number) {
        this.activeResultSetName = SPCommand.RESULT_SET_NAME_ISNOTUSED;
        this.activeResultSetNumber = number;
    }

    public String getActiveResultSetName() {
        return this.activeResultSetName;
    }
    public void setActiveResultSetName(String name) {
        this.activeResultSetNumber = SPCommand.RESULT_SET_NUMBER_ISNOTUSED;
        this.activeResultSetName = name;
    }
    
    public void addParameter( String paramName, Parameter param, int sqlType, int scale, int direction ) {
        Object value = null;
        if ( param != null ) {
            value = param.getObjectValue();
            if ( value instanceof Number && sqlType == java.sql.Types.INTEGER ) {
                value = new Integer(((Number) value).intValue());
            }
        }
        SPParameter sp = new SPParameter( value, sqlType, scale, direction );
        sp.setName(paramName);
        sp.setSourceName(paramName);
        parameters.add(sp);
        names.add(paramName);
    }

    private Format getParameterFormat(Parameter param) {
        if ( param instanceof Field ) {
            return ((Field) param).getFormat();
        } else if ( param instanceof Control ) {
            return ((Control) param).getDbFormat();
        } else if ( param instanceof SqlParameter ) {
            return ((SqlParameter) param).getDbFormat();
        }
        return null;
    }

    private ControlType getParameterType(Parameter param) {
        if ( param instanceof Field ) {
            return null;
        } else if ( param instanceof Control ) {
            return ((Control) param).getType();
        } else if ( param instanceof SqlParameter ) {
            return ((SqlParameter) param).getType();
        }
        return null;
    }
    
    public void addParameter( Parameter param, int sqlType, int scale, int direction ) {
        addParameter( "", param, sqlType, scale, direction );
    }
    public void addParameter( SPParameter param ) {
      if (param != null) {
        parameters.add(param);
        names.add(param.getName());
      }
    }
    
    public Collection getParameters() {
        return parameters;
    }
    
    public Parameter getParameter( String paramName ) {
        Parameter param = null;
        if ( ! StringUtils.isEmpty( paramName ) ) {
            for ( int i = 0; i < names.size(); i++ ) {
                if ( paramName.equals((String) names.get(i)) ) {
                    param = (Parameter) parameters.get(i);
                    break;
                }
            }
        }
        return param;
    }
    
    public Object getOutParameter( int index ) {
        if ( parameters == null || index < 1 || index > parameters.size() ) return null;
        
        Object value = null;
        SPParameter param = (SPParameter) parameters.get( index );
        if ( param.getDirection() != SPParameter.INPUT_PARAMETER ) {
            value = param.getValue();
        }
        return value;
    }
    
    public Enumeration getRows( int start, int rows ) {
        Enumeration result = null;
        CallableStatement cstmt = prepareCommand();
        ResultSet rs = null;
        if ( cstmt == null ) 
            return result;
        try {    
            result = getRowSet(cstmt, start, rows);
            this.activeRowSet = result;
            getSPParameters(cstmt);
        } catch (SQLException sqle) {
            catchException(sqle);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException sqle) { catchException( sqle ); }
            try {
                if (cstmt != null) cstmt.close();
            } catch (SQLException sqle) { catchException( sqle ); }
        }
        return result;
    }

    public Enumeration getRows() {
        Enumeration result = null;
        CallableStatement cstmt = prepareCommand();
        ResultSet rs = null;
        if ( cstmt == null ) 
            return result;
        try {    
            if ( fetchSize > 0 ) {
                result = getRowSet(cstmt, startPos, fetchSize);
            } else {
                result = getRowSet(cstmt, -1, -1);
            }
            this.activeRowSet = result;
            getSPParameters(cstmt);
        } catch (SQLException sqle) {
            catchException(sqle);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException sqle) { catchException(sqle); }
            try {
                if (cstmt != null) cstmt.close();
            } catch (SQLException sqle) { catchException(sqle); }
        }
        return result;
    }

    public DbRow getOneRow() {
        DbRow result = null;
        CallableStatement cstmt = prepareCommand();
        ResultSet rs = null;
        if ( cstmt == null ) 
            return result;
        try {
            Enumeration rows = getRowSet(cstmt, 0, 1);
            if (rows!= null && rows.hasMoreElements()) {
            //if (rows.hasMoreElements()) {
                result = (DbRow) rows.nextElement();
            }
            getSPParameters(cstmt);
        } catch (SQLException sqle) {
            catchException( sqle );
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException sqle) { catchException( sqle ); }
            try {
                if (cstmt != null) cstmt.close();
            } catch (SQLException sqle) { catchException( sqle ); }
        }
        return result;
    }

    protected Enumeration getRowSet(CallableStatement cstmt, int start, int rows) throws SQLException {
        boolean isResSet = cstmt.execute();
        if (isResSet) {
            int currentResultSet = 0;
            if (this.activeResultSetNumber == currentResultSet && start > -1) {
                addToRowSets(cstmt.getResultSet(), start, rows);
                this.next = conn.isNext();
            } else {
                addToRowSets(cstmt.getResultSet(), -1, -1);
            }
            currentResultSet++;
            while (true) {
                if (cstmt.getMoreResults()) { 
                    if (this.activeResultSetNumber == currentResultSet && start > -1) {
                        addToRowSets(cstmt.getResultSet(), start, rows);
                        this.next = conn.isNext();
                    } else {
                        addToRowSets(cstmt.getResultSet(), -1, -1);
                    }
                } else {
                    if (cstmt.getUpdateCount() == -1) {
                        break;
                    }
                }
                currentResultSet++;
            }
        }

        if (this.rowSets.isEmpty()) return null;

        return Collections.enumeration((Collection) this.rowSets.get(this.activeResultSetNumber));
    }
    
    protected ArrayList addToRowSets(ResultSet rs, int start, int rows) {
        ArrayList list = null;
        if (start > -1) {
            list = toList(conn.getRows(rs, start, rows));
        } else {
            list = toList(conn.getRows(rs));
        }
        this.rowSets.add(list);
        return list;
    }
    
    protected ArrayList toList(Enumeration en) {
        if (en != null) {
            return Utils.list(en);
        }
        return new ArrayList();
    }
    
    public int executeUpdate() {
        int result = 0;
        CallableStatement cstmt = prepareCommand();
        if ( cstmt == null ) 
            return result;
        try {    
            result = cstmt.executeUpdate(); // TODO: change to cstmt.execute   
            getSPParameters( cstmt );
        } catch ( SQLException sqle ) {
            catchException( sqle );
        } finally {
            try {
                if (cstmt != null) cstmt.close();
            } catch (SQLException sqle) { catchException( sqle ); }
        }
        return result;
    }
    
    protected void getSPParameters(CallableStatement cstmt) {
        if ( cstmt == null ) return;
        
        if ( ! (parameters == null || parameters.isEmpty()) ) {
            Iterator params = parameters.iterator();
            int countParams = 1;
            while ( params.hasNext() ) {
                SPParameter param = (SPParameter) params.next();
                if ( param != null ) {
                    switch ( param.getDirection() ) {
                        case SPParameter.OUTPUT_PARAMETER:
                        case SPParameter.INPUT_OUTPUT_PARAMETER:
                            try {    
                                Object value = cstmt.getObject(countParams);
                                if (value != null) {
                                    outParameters.put(param.getSourceName(), value);
                                }
                                param.setValue(value);
                                break;
                            } catch ( SQLException sqle ) {
                                conn.addError( "Exception in cstmt.getObject(" + countParams + ") :"+ sqle.getMessage() + StringUtils.getBRTag() );
                                return;
                            } catch (ParseException pe) {
                                conn.addError( "Exception in cstmt.getObject(" + countParams + ") :"+ pe.getMessage() + StringUtils.getBRTag() );
                            }
                    }
                }
                countParams++;
            }
        }
    }
    
    private CallableStatement prepareCommand() {
        CallableStatement cstmt = null;
        if (!(conn == null || StringUtils.isEmpty(sql))) {
            if ( (cstmt = conn.createCallableStatement( sql )) == null ) {
                return cstmt;
            }
            if ( ! (parameters == null || parameters.isEmpty()) ) {
                addInputParameters(cstmt);
                registerOutputParameters(cstmt);
            }
        }
        return cstmt;
    }

    protected void addInputParameters(CallableStatement cstmt) {
        Iterator params = this.parameters.iterator();
        int countParams = 1;
        while (params.hasNext()) {
            SPParameter param = (SPParameter) params.next();
            if (param != null) {
                handleParameter(param, countParams);
                try {
                    addInputParameter(cstmt, param, countParams);    
                } catch (SQLException sqle) {
                    catchException(sqle);
                    return;
                }
            }
            countParams++;
        }
    }

    protected void registerOutputParameters(CallableStatement cstmt) {
        Iterator params = this.parameters.iterator();
        int countParams = 1;
        while (params.hasNext()) {
            SPParameter param = (SPParameter) params.next();
            if (param != null) {
                handleParameter(param, countParams);
                try {
                    registerOutputParameter(cstmt, param, countParams);    
                } catch (SQLException sqle) {
                    catchException(sqle);
                    return;
                }
            }
            countParams++;
        }
    }
    
    protected void addInputParameter(CallableStatement cstmt, SPParameter param, int countParams) 
            throws SQLException {
        if (param.getValue() != null) {
            try {
                switch (param.getDirection()) {
                    case SPParameter.INPUT_PARAMETER:
                    case SPParameter.INPUT_OUTPUT_PARAMETER:
                        if (isScaleUsed(param.getSPType())) {
                            cstmt.setObject(countParams, param.getValue(), param.getSPType(), param.getScale());
                        } else {
                            cstmt.setObject(countParams, param.getValue(), param.getSPType());
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                conn.logger.error("", e);
                conn.logger.error("for parameter: "+param);
            } catch (SQLException e) {
                conn.logger.error("", e);
                conn.logger.error("for parameter: "+param);
            }
        } else {
            switch (param.getDirection()) {
                case SPParameter.INPUT_PARAMETER:
                    cstmt.setNull(countParams, param.getSPType());
                    break;
                case SPParameter.INPUT_OUTPUT_PARAMETER:
                    cstmt.setNull(countParams, param.getSPType());
                    break;
            }
        }
    }
    
    protected boolean isScaleUsed(int paramDataType) {
        switch (paramDataType) {
            case java.sql.Types.BIGINT: 
            case java.sql.Types.DECIMAL: 
            case java.sql.Types.DOUBLE :
            case java.sql.Types.FLOAT :
            case java.sql.Types.INTEGER: 
            case java.sql.Types.NUMERIC: 
            case java.sql.Types.REAL :
            case java.sql.Types.SMALLINT: 
            case java.sql.Types.TINYINT :
                return true;
        }
        return false;
    }
    
    protected void registerOutputParameter(CallableStatement cstmt, SPParameter param, int countParams) 
            throws SQLException {
        if (param.getValue() != null) {
            switch (param.getDirection()) {
                case SPParameter.OUTPUT_PARAMETER:
                    cstmt.registerOutParameter(countParams, param.getSPType());
                    break;
                case SPParameter.INPUT_OUTPUT_PARAMETER:
                    cstmt.registerOutParameter(countParams, param.getSPType());
                    break;
            }
        } else {
            switch (param.getDirection()) {
                case SPParameter.OUTPUT_PARAMETER:
                    cstmt.registerOutParameter(countParams, param.getSPType());
                    break;
                case SPParameter.INPUT_OUTPUT_PARAMETER:
                    cstmt.registerOutParameter(countParams, param.getSPType());
                    break;
            }
        }
    }
    
    protected void handleParameter(SPParameter param, int countParams) {
        //do hothing in common case
    }

    /** Auxiliary function for Check Unique values. For Procedures return 0. **/
    public int nrecords() {
      return 0;
    }

    public DbRow getOutputParameters() {
        return this.outParameters;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("SPCommand sql='"+sql+"'\n");
        sb.append("     startPos='"+startPos+"'\n");
        sb.append("    fetchSize='"+fetchSize+"'\n");
        sb.append("   connection='"+conn.getPoolName()+"'\n");
        sb.append("Parameters:");
        if ( parameters == null || parameters.isEmpty() ) {
            sb.append("none\n");
        } else {
            sb.append("\n");
            Iterator params = parameters.iterator();
            int countParam = 1;
            while ( params.hasNext() ) {
                sb.append( "param" );
                sb.append( countParam++ );
                SPParameter param = (SPParameter) params.next();
                if ( param == null ) {
                    sb.append( " : parameter is null\n" );
                } else {
                    Object value = param.getValue();
                    if ( value == null ) {
                        sb.append( " : value is null  type: " + 
                                getSqlTypeName( param.getSPType() ) + " scale: " + 
                                String.valueOf( param.getScale() ) + "\n" );
                    } else {
                        sb.append( " : " + value.toString() + 
                                " type: " + getSqlTypeName( param.getSPType() ) + 
                                " vtype: " + value.getClass().getName() + 
                                " scale: " + String.valueOf( param.getScale() ) + 
                                "\n" );
                    }
                }
            }
        }
        return sb.toString();
    }

}
//End SPCommand class

