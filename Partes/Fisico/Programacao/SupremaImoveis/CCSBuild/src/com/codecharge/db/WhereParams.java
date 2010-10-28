//WhereParams @0-40099B95
package com.codecharge.db;

import com.codecharge.util.*;
import com.codecharge.components.*;
import java.text.*;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;

public class WhereParams {

  public static String and ( boolean brackets, String left, String right ) {
    String result = null;
    if ( StringUtils.isEmpty( left ) ) {
      if ( ! StringUtils.isEmpty( right ) ) {
        result = right;
      }
    }
    else {
      if ( StringUtils.isEmpty( right )) {
        result = left;
      }
      else {
        result = left + " and " + right;
        if ( brackets ) result = " (" + result + ") ";
      }
    }
    return result;
  }

  public static String or ( boolean brackets, String left, String right ) {
    String result = null;
    if ( StringUtils.isEmpty( left ) ) {
      if ( ! StringUtils.isEmpty( right )) {
        result = right;
      }
    }
    else {
      if ( StringUtils.isEmpty( right ) ) {
        result = left;
      }
      else {
        result = left + " or " + right;
        if ( brackets ) result = " (" + result + ") ";
      }
    }
    return result;
  }

  public static String operation( Field field, DS dataObject ) {
    String result = null;
    if ( field == null || field.getObjectValue() == null ) return "";
    String value = field.getObjectValue().toString();
    if ( ! StringUtils.isEmpty( value ) ) {
      String val = null;
      if ( field instanceof TextField ) { 
        value = StringUtils.replace( value, "'", "''" );
        val = "'" + value + "'";
      }
      else {
          val = value;
      }
      FieldOperation oper = field.getOperation();
      if ( oper.isComplex() ) {
          result = field.getField() + oper.getOperationStart() + value + oper.getOperationEnd();
      }
      else {
          result = field.getField() + oper.getOperationStart() + val;
      }
    }
    return result;
  }

    public static String operation( String fieldName, FieldOperation oper, 
            Parameter value, Format format, JDBCConnection dataObject ) {
        String result = null;
        if ( value != null && value.getObjectValue() != null ) {
            boolean enclose = false;
            String val = dataObject.format( value, format );
            if ( val != null && val.length() > 0 )
                result = fieldName + " " + oper.getOperation( val, enclose );
        }
        return result;
    }

    public static String rawOperation( String fieldName, FieldOperation oper, Parameter value, 
                                                                    Format format, JDBCConnection conn ) {

        String result = null;
        if ( value != null && value.getObjectValue() != null ) {
            int parameterType = -1;
            ControlType type = null;
            if ( value instanceof Control) {
                type = ((Control) value).getType();
            } else if (value instanceof CachedColumn) {
                type = ((CachedColumn) value).getType();
            } else if ( value instanceof SqlParameter ) {
                type = ((SqlParameter) value).getType();
            }
            if ( value instanceof TextField || type == ControlType.TEXT || type == ControlType.MEMO ) {
                parameterType = JDBCConnection.TEXT;
            } else if ( value instanceof LongField || type == ControlType.INTEGER ) {
                parameterType = JDBCConnection.INTEGER;
            } else if ( value instanceof DoubleField || type == ControlType.FLOAT ) {
                parameterType = JDBCConnection.FLOAT;
            } else if ( value instanceof SingleField || type == ControlType.SINGLE ) {
                parameterType = JDBCConnection.FLOAT;
            } else if ( value instanceof BooleanField || type == ControlType.BOOLEAN ) {
                parameterType = JDBCConnection.BOOLEAN;
            } else if ( value instanceof DateField || type == ControlType.DATE ) {
                parameterType = JDBCConnection.DATE;
            }


            if (oper == FieldOperation.IN     || oper == FieldOperation.BETWEEN || 
                oper == FieldOperation.NOT_IN || oper == FieldOperation.NOT_BETWEEN) {
                
                Object vals = value.getObjectValue();
                Vector v = null;
                
                if (vals instanceof Collection){
                    Iterator it = ((Collection)vals).iterator();
                    while (it.hasNext()) {
                        if (v == null) v = new Vector();

                        Object ov = it.next();
                        value.setObjectValue( ov );//Needed for formatting every value
                        v.add ( conn.format( value, format ) );//

                    }
                    value.setObjectValue( vals );//Neede for sersetting previouse value
                } else if (vals instanceof Object[]) {
                    for (int i = 0; i <((Object[])vals).length; i++) {
                        if (v == null) v = new Vector();

                        value.setObjectValue( ((Object[])vals)[i] );//Needed for formatting every value
                        v.add ( conn.format( value, format ) );//

                    }
                    value.setObjectValue( vals );//Neede for sersetting previouse value
                }
                
                result = fieldName + " " + oper.getRawOperation( v, conn, parameterType );

            } else {
                Object oVal = value.getObjectValue();
                if (oVal instanceof Collection) {
                    Iterator it = ((Collection)oVal).iterator();
                    if (it.hasNext()) {
                        oVal = it.next();
                    }
                } else if (oVal instanceof Object[]) {
                    if ( ((Object[])oVal).length > 0 ) {
                        oVal = ((Object[])oVal)[0];
                    }
                }
                value.setObjectValue( oVal );
                
                String val = conn.format( value, format );
                if ( val != null && val.length() > 0 )
                    result = fieldName + " " + oper.getRawOperation( val, conn, parameterType );
            }

            //String val = conn.format( value, format );
            //if ( val != null && val.length() > 0 )
            //    result = fieldName + " " + oper.getRawOperation( val, conn, parameterType );


        }
        return result;
    }

}


//End WhereParams

