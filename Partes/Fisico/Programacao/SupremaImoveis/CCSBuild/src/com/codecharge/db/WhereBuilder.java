//WhereBuilder class @0-659D949A
package com.codecharge.db;

import java.util.*;
import com.codecharge.*;
import com.codecharge.util.*;

public class WhereBuilder {
  
    private com.codecharge.util.Queue params;
    private String[] whereTokens;
    final static private String[] servTokens = new String[] { ")", "(", "AND", "OR" };
    final static private String[] skipTokens = new String[] { ")", "AND", "OR" };
  
    public static boolean isServToken ( String token ) {
        boolean isServToken = false;
        for ( int i = 0; i < servTokens.length; i++ ) {
            if ( servTokens[i].equalsIgnoreCase( token ) ) {
                isServToken = true;
                break;
            }  
        }
        return isServToken;
    }

    private boolean isSkipToken ( String token ) {
        boolean isSkipToken = false;
        for ( int i = 0; i < skipTokens.length; i++ ) {
            if ( skipTokens[i].equalsIgnoreCase( token ) ) {
                isSkipToken = true;
                break;
            }  
        }
        return isSkipToken;
    }
  
    public String buildWhere( String[] wTokens
                            , SqlParameters parameters ) { 
        if ( wTokens == null ) return null;
        if ( wTokens.length == 0 ) return null;
        whereTokens = new String[wTokens.length];    
        System.arraycopy( wTokens, 0, whereTokens, 0, wTokens.length );
        for( int i = 0; i < whereTokens.length; i++ ) {  
            if( ! isServToken( whereTokens[i] ) ) {
                SqlParameter sp = (SqlParameter) parameters.getWhereParameter( whereTokens[i] );
                if ( sp != null ) {
                    whereTokens[i] = sp.getSqlCondition();
                } else {
                    //whereTokens[i] = null;
                }
            }
        }
        params = new com.codecharge.util.Queue( whereTokens );
        String where = getWhere();
        if ( where == null ) where = "";
        return where;
    }

    public String buildRawWhere( String[] wTokens, SqlParameters parameters, JDBCConnection conn ) {
        if ( wTokens == null ) return null;
        if ( wTokens.length == 0 ) return null;
        whereTokens = new String[wTokens.length];    
        System.arraycopy( wTokens, 0, whereTokens, 0, wTokens.length );
        for( int i = 0; i < whereTokens.length; i++ ) {  
            if( ! isServToken( whereTokens[i] ) ) {
                SqlParameter sp = (SqlParameter) parameters.getWhereParameter( whereTokens[i] );
                if ( sp != null ) {
                    whereTokens[i] = sp.getRawCondition( conn );
                } else {    
                    //whereTokens[i] = null;
                }
            }
        }
        params = new com.codecharge.util.Queue( whereTokens );
        String where = getWhere();
        if ( where == null ) where = "";
        return where;
    }

    /** Reduce operations with null operands or save part of the expression in result StringBuffer.
        and null and = and
        and null or = or
        or null and = or
        or null or = or
        empty null and = empty
        empty null or = empty
        and null empty = empty
        or null empty = empty
        (null and null) = (empty null and null) = (empty null) = null
        (null or null) = null
    */
    private String reduceOperation(String op1, String opd, String op2, StringBuffer expr) {
      if (opd == null) {
        if (op1 == null || op2 == null) {
          return null;
        } else if ("AND".equals(op1) && "AND".equals(op2)) {
          return "AND";
        } else {
          return "OR";
        }
      } else {
        if (op1 != null) {
          expr.append(op1).append(" ");
        }
        expr.append(opd).append(" ");
        return op2;
      }
    }
    private String getWhere() {
        StringBuffer result = new StringBuffer();
        String operator1 = null;
        String operator2 = null;
        String operand = null;
        while (params.length >= 1) {
          operand = (String)params.get();
          if ("(".equals(operand)) {
            operand = getWhere();
            if (operand != null) {
              operand = "(" + operand + ")";
            }
          }
          operator2 = (String)params.get();
          if (")".equals(operator2)) {
            operator2 = null;
            reduceOperation(operator1, operand, operator2, result);
            return result.length()>0 ? result.toString() : null;
          }
          operator1 = reduceOperation(operator1, operand, operator2, result);
        }
        return result.toString();
    }
}

//End WhereBuilder class

