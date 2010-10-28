//FieldOperation class @0-6DCA78A5
package com.codecharge.db;

import java.util.Vector;
import java.util.Iterator;

final public class FieldOperation {

    static public FieldOperation IS_NULL                = 
            new FieldOperation("FieldOperation.IS_NULL", " IS NULL ", null, null, null, false);
    static public FieldOperation NOT_NULL               = 
            new FieldOperation("FieldOperation.NOT_NULL", " IS NOT NULL ", null, null, null, false);
            
    static public FieldOperation EQUAL                  = 
            new FieldOperation("FieldOperation.EQUAL", " = ", null, null, null, true, FieldOperation.IS_NULL );
    static public FieldOperation NOT_EQUAL              = 
            new FieldOperation("FieldOperation.NOT_EQUAL", " <> ", null, null, null, true, FieldOperation.NOT_NULL);
    static public FieldOperation LESS_THAN              = 
            new FieldOperation("FieldOperation.LESS_THEN", " < ", null, null, null, true, FieldOperation.IS_NULL);
    static public FieldOperation LESS_THAN_OR_EQUAL     = 
            new FieldOperation("FieldOperation.LESS_THEN_OR_EQUAL", " <= ", null, null, null, true, FieldOperation.IS_NULL);
    static public FieldOperation GREATER_THAN           = 
            new FieldOperation("FieldOperation.GREATER_THEN", " > ", null, null, null, true, FieldOperation.IS_NULL);
    static public FieldOperation GREATER_THAN_OR_EQUAL  = 
            new FieldOperation("FieldOperation.GREATER_THEN_OR_EQUAL", " >= ", null, null, null, true, FieldOperation.IS_NULL);
    static public FieldOperation BEGINS_WITH            = 
            new FieldOperation("FieldOperation.BEGINS_WITH", " like ", "", "", "%", true, FieldOperation.IS_NULL);
    static public FieldOperation NOT_BEGINS_WITH        = 
            new FieldOperation("FieldOperation.NOT_BEGINS_WITH", " not like ", "", "", "%", true, FieldOperation.NOT_NULL);
    static public FieldOperation ENDS_WITH              = 
            new FieldOperation("FieldOperation.ENDS_WITH", " like ", "", "%", "", true, FieldOperation.IS_NULL);
    static public FieldOperation NOT_ENDS_WITH          = 
            new FieldOperation("FieldOperation.NOT_ENDS_WITH", " not like ", "", "%", "", true, FieldOperation.NOT_NULL);
    static public FieldOperation CONTAINS               = 
            new FieldOperation("FieldOperation.CONTAINS", " like ", "", "%", "%", true, FieldOperation.IS_NULL);
    static public FieldOperation NOT_CONTAINS           = 
            new FieldOperation("FieldOperation.NOT_CONTAINS", " not like ", "", "%", "%", true, FieldOperation.NOT_NULL);
    
    static public FieldOperation IN                     = 
            new FieldOperation("FieldOperation.IN", " IN ", "", "(", ")", true, FieldOperation.IS_NULL);
    static public FieldOperation BETWEEN                = 
            new FieldOperation("FieldOperation.BETWEEN", " BETWEEN ", null , null, null, true, FieldOperation.IS_NULL);
    static public FieldOperation NOT_IN                 = 
            new FieldOperation("FieldOperation.NOT_IN", " NOT IN ", "", "(", ")", true, FieldOperation.IS_NULL);
    static public FieldOperation NOT_BETWEEN            = 
            new FieldOperation("FieldOperation.NOT_BETWEEN", " NOT BETWEEN ", null , null, null, true, FieldOperation.IS_NULL);

    static private int counter;

    private int type;
    private String name;
    private String operationStart;
    private String operationEnd;
    private String prefix;
    private String suffix;
    private boolean withParam;
    private FieldOperation nullRelation;

    private FieldOperation( String name, String operStart, String operEnd, String prefix, 
            String suffix, boolean withParam, FieldOperation nullRelation ) {
        this.type = counter++;
        this.name = name;
        operationStart = operStart;
        operationEnd = operEnd;
        this.prefix = prefix;
        this.suffix = suffix;
        this.withParam = withParam;
        this.nullRelation = nullRelation;
    }

    private FieldOperation( String name, String operStart, String operEnd, String prefix, 
            String suffix, boolean withParam ) {
        this.type = counter++;
        this.name = name;
        operationStart = operStart;
        operationEnd = operEnd;
        this.prefix = prefix;
        this.suffix = suffix;
        this.withParam = withParam;
        this.nullRelation = this;
    }

    public String toString() {
        String operation = ( operationStart == null ? "''" : "'" + 
                operationStart + "'" ) + ", " +
                ( operationEnd == null ? "''" : "'" + operationEnd + "'" );
        if ( name == null )
            return String.valueOf( type ) + " => " + operation;
        else
            return name + "(" + type + ") => " + operation;
    }


    public FieldOperation getNullRelation() {
        return nullRelation;
    }

    public String getPrefix() {
        return ( prefix == null ? "" : prefix );
    }
    
    public String getSuffix() {
        return (suffix == null ? "" : suffix);
    }
    
    public String getOperationStart() {
        return ( operationStart == null ? "" : operationStart );
    }

    public String getOperationEnd() {
        return ( operationEnd == null ? "" : operationEnd );
    }
    
    public boolean isComplex() {
        return ( operationEnd != null );
    }

    public String getOperation( String value, boolean enclose ) {
        String result = "";
        if ( value != null && value.length() > 0 ) {
            String val = null;
            if ( value.length() > 2 )
                val = value.substring(1, value.length()-1 );
            else 
                val = value;
            if ( enclose ) {
                //val = value;
            }
            if ( isComplex() ) {
                //result = getOperationStart() + val + getOperationEnd();
                result = getOperationStart() + ( withParam ? "?" : "" ) + getOperationEnd();
            }
            else {
                //result = getOperationStart() + value;
                result = getOperationStart() + ( withParam ? "?" : "" );
            }
        }
        return result;
    } // End of getOperation


    //-----------------------Parhaps this method is newer used.---------------------------------------TODO
    public String getRawOperation( String value, boolean enclose, String paramName ) {
        String result = "";
        if ( value != null && value.length() > 0 ) {
            String val = null;
            if ( value.length() > 2 )
                val = value.substring(1, value.length()-1 );
            else 
                val = value;

            if ( enclose ) {
                //val = value;
            }

            if ( isComplex() ) {
                result = getOperationStart() + ( withParam ? prefix + "{" + paramName + "}" + suffix : "" ) + getOperationEnd();
            }
            else {
                result = getOperationStart() + ( withParam ? prefix + "{" + paramName + "}" + suffix : "" );
            }
        }
        return result;
    } // End of getOperation
    //------------------------------------------------------------------------------------------------


    public String getRawOperation( String value, JDBCConnection conn, int parameterType ) {
        String result = "";

        if ( value != null && value.length() > 0 ) {
            if ( isComplex() ) {
                result = getOperationStart() + ( withParam ? conn.toSql( prefix + value + suffix, parameterType ) : "" ) + getOperationEnd();
            } else {
                result = getOperationStart() + ( withParam ? conn.toSql( value, parameterType ) : "" );
            }
        }
        return result;
    } // End of getOperation



    public String getRawOperation( Vector values, JDBCConnection conn, int parameterType ) {
        String result = null;

        Iterator it = values.iterator();

        if (this == FieldOperation.BETWEEN || this == FieldOperation.NOT_BETWEEN) {
            String v1 = null;
            String v2 = null;

            if (it.hasNext()) v1 = (String)it.next();
            if (it.hasNext()) v2 = (String)it.next();
            
            if ( v1 != null && v2 == null ) v2 = v1;
            if ( v1 != null && v2 != null ) {
                v1 = ( withParam ? conn.toSql( v1, parameterType ) : "" );
                v2 = ( withParam ? conn.toSql( v2, parameterType ) : "" );

                result = v1 + getSeparator() + v2;
            }
             
        } else {

            while (it.hasNext()) {
                String value = (String)it.next();

                String res;
                if ( value != null && value.length() > 0 ) {
                    res = ( withParam ? conn.toSql( value, parameterType ) : "" );

                    if (result == null) {
                        result = "" + res;
                    } else {
                        //result = result + ", " +res;
                        result = result + getSeparator() +res;
                    }

                }
            }

        }    

        if (result == null) return "";
        
        if ( isComplex() ) {
            result = getOperationStart() + prefix + result + suffix + getOperationEnd();
        } else {
            result = getOperationStart() + result;
        }

        return result;
    } // End of getOperation

    
    private String getSeparator() {
        if (this == FieldOperation.IN      || this == FieldOperation.NOT_IN) return ", ";
        if (this == FieldOperation.BETWEEN || this == FieldOperation.NOT_BETWEEN) return " and ";
        return "";
    }


    public String getOperation( Object value ) {
        String result = "";
        if ( value != null && value.toString().length() > 0 ) {
            if ( isComplex() ) {
                result = getOperationStart() + ( withParam ? "?" : "" ) + getOperationEnd();
            } else {
                result = getOperationStart() + ( withParam ? "?" : "" );
            }
        }
        return result;
    }

    public String getRawOperation( Object value, JDBCConnection conn, int parameterType ) {
        if (value instanceof Vector) return getRawOperation ((Vector)value, conn, parameterType);
        if (value instanceof String) return getRawOperation ((String)value, conn, parameterType);

        String result = "";
        if ( value != null && value.toString().length() > 0 ) {
            if ( isComplex() ) {
                result = getOperationStart() + ( withParam ? conn.toSql( prefix + value.toString() + suffix, parameterType ) : "" ) + getOperationEnd();
            } else {
                result = getOperationStart() + ( withParam ? conn.toSql( value.toString(), parameterType ) : "" );
            }
        }
        return result;
    }

    /*public Parameter getParameter( Parameter param ) {
        if ( ! (param instanceof TextParameter) ) return param;
        String value = (String) param.getObjectValue();
        if ( value != null ) {
            if ( isComplex() ) {
                //result = getOperationStart() + val + getOperationEnd();
                value = prefix + value + suffix;
            }
        }
        TextParameter result = new TextParameter();
        result.setValue(value);
        return result;
    } // End of getValue*/

    public static FieldOperation getFieldOperation( String operation ) {
        if ( "LESS_THAN".equalsIgnoreCase(operation) ) return FieldOperation.LESS_THAN;
        if ( "GREATER_THAN".equalsIgnoreCase(operation) ) return FieldOperation.GREATER_THAN;
        if ( "EQUAL".equalsIgnoreCase(operation) ) return FieldOperation.EQUAL;
        if ( "NOT_EQUAL".equalsIgnoreCase(operation) ) return FieldOperation.NOT_EQUAL;
        if ( "LESS_THAN_OR_EQUAL".equalsIgnoreCase(operation) ) return FieldOperation.LESS_THAN_OR_EQUAL;
        if ( "GREATER_THAN_OR_EQUAL".equalsIgnoreCase(operation) ) return FieldOperation.GREATER_THAN_OR_EQUAL;
        if ( "BEGINS_WITH".equalsIgnoreCase(operation) ) return FieldOperation.BEGINS_WITH;
        if ( "NOT_BEGINS_WITH".equalsIgnoreCase(operation) ) return FieldOperation.NOT_BEGINS_WITH;
        if ( "ENDS_WITH".equalsIgnoreCase(operation) ) return FieldOperation.ENDS_WITH;
        if ( "NOT_ENDS_WITH".equalsIgnoreCase(operation) ) return FieldOperation.NOT_ENDS_WITH;
        if ( "CONTAINS".equalsIgnoreCase(operation) ) return FieldOperation.CONTAINS;
        if ( "NOT_CONTAINS".equalsIgnoreCase(operation) ) return FieldOperation.NOT_CONTAINS;
        if ( "IS_NULL".equalsIgnoreCase(operation) ) return FieldOperation.IS_NULL;
        if ( "NOT_NULL".equalsIgnoreCase(operation) ) return FieldOperation.NOT_NULL;

        if ( "IN".equalsIgnoreCase(operation) ) return FieldOperation.IN;
        if ( "BETWEEN".equalsIgnoreCase(operation) ) return FieldOperation.BETWEEN;
        if ( "NOT_IN".equalsIgnoreCase(operation) ) return FieldOperation.NOT_IN;
        if ( "NOT_BETWEEN".equalsIgnoreCase(operation) ) return FieldOperation.NOT_BETWEEN;
        return null;
    }

}
//End FieldOperation class

