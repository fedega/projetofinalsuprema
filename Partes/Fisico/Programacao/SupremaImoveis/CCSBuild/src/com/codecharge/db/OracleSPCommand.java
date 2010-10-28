//OracleSPCommand class @0-414F6AFC
package com.codecharge.db;

import java.text.*;
import java.util.*;
import java.sql.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.components.*;

public class OracleSPCommand extends SPCommand {

    public static final int ORACLE_CURSOR = -10;
    public static final String NUM_CURSOR_PARAM_KEY = "CCS_numCursorParam";

    public OracleSPCommand() {
        activeResultSetNumber = -1; // activeResultSetNumber is not used for Oracle
        activeResultSetName = null;
    }
    
    public OracleSPCommand(JDBCConnection conn) {
        super(conn);
        activeResultSetNumber = -1; // activeResultSetNumber is not used for Oracle
        activeResultSetName = null;
    }

    protected Enumeration getRowSet(CallableStatement cstmt, int start, int rows) throws SQLException {
        cstmt.execute();
        bindResultSets(cstmt, start, rows);
        return this.activeRowSet;
    }
    
    
    protected void handleParameter(SPParameter param, int countParams) {
        if (param.getSPType() == OracleSPCommand.ORACLE_CURSOR && getNumCursorParam(param.getName()) == 0) {
            setAttribute(OracleSPCommand.NUM_CURSOR_PARAM_KEY+"_"+param.getName(), new Integer(countParams));
            if (getNumCursorParam(null) == 0) {
                setAttribute(OracleSPCommand.NUM_CURSOR_PARAM_KEY, new Integer(countParams));
            }
        }
    }

    private boolean isActiveResultSetParameter(SPParameter param) {
        if ( StringUtils.isEmpty(getActiveResultSetName()) ) {
            setActiveResultSetName(param.getName());
        }

        if (! StringUtils.isEmpty(getActiveResultSetName()) && getActiveResultSetName().equals(param.getName())) {
            return true;
        }
        return false;
    }
    
    private int getNumCursorParam(String paramName) {
        int result = 0;
        Object resultObj = getAttribute(OracleSPCommand.NUM_CURSOR_PARAM_KEY+(paramName == null ? "" : "_"+paramName));
        if (resultObj instanceof String) {
            try {
                result = Integer.parseInt((String) resultObj);
            } catch (NumberFormatException nfe) {
                CCLogger.getInstance().warn("", nfe);
            }
            return result;
        } else if (resultObj instanceof Number) {
            result = ((Number) resultObj).intValue();
        }
        return result;
    }

    private void bindResultSets(CallableStatement cstmt, int start, int rows) {
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
                            if (param.getSPType() == OracleSPCommand.ORACLE_CURSOR) {
                                ArrayList list = null;
                                ResultSet rs = null;
                                if (! isActiveResultSetParameter(param)) {
                                    rs = (ResultSet) cstmt.getObject(countParams);
                                    list = addToRowSets(rs, -1, -1);
                                } else {
                                    rs = (ResultSet) cstmt.getObject(countParams);
                                    if (rs != null) {
                                        if (start > -1) {
                                            this.activeRowSet = this.conn.getRows(rs, start, rows);
                                        } else {
                                            this.activeRowSet = this.conn.getRows(rs);
                                        }
                                        list = toList(this.activeRowSet);
                                        this.activeRowSet = Collections.enumeration(list);
                                    }
                                    this.rowSets.add(list);
                                    this.next = conn.isNext();
                                }
                                outParameters.put(param.getSourceName(), list);
                                param.setValue(list);
                            } else {
                                Object value = cstmt.getObject(countParams);
                                if (value != null) {
                                    outParameters.put(param.getSourceName(), value);
                                }
                                param.setValue(value);
                                break;
                            }
                        } catch ( SQLException sqle ) {
                            conn.addError( "Exception in bindResultSets => cstmt.getObject(" + countParams + ") :"+ sqle.getMessage() + StringUtils.getBRTag() );
                        } catch (ParseException pe) {
                            conn.addError( "Exception in bindResultSets => cstmt.getObject(" + countParams + ") :"+ pe.getMessage() + StringUtils.getBRTag() );
                        }
                    }
                }
                countParams++;
            }
        }
    }
    
    protected void getSPParameters(CallableStatement cstmt) {
        //nothing to do here
        return;
    }
    
}
//End OracleSPCommand class

