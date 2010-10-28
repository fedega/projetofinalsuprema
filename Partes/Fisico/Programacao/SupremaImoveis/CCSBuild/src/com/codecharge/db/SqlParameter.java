//SqlParameter class @0-59ECDECB
package com.codecharge.db;

import com.codecharge.components.*;
import com.codecharge.util.*;
import java.text.*;
import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;

/**
 * Represents SQL query parameter. This class is used in JSP pattern to store parameter information
 * and for construction of dynamic Where.
 * @see com.codecharge.db.WhereBuilder WhereBuilder
 */
public class SqlParameter implements Parameter {

    protected String name;
    protected String field;
    /** Type of the parameter value. */
    protected ControlType type;
    private FieldOperation operation;
    private ParameterSource sourceType;
    private String sourceName;
    private Format format;
    private Format dbFormat;
    private String formatPattern;
    private String dbFormatPattern;
    private CCSLocale ccsLocale;
    /** Parameter default value. */
    protected Object defaultValue;
    /** Parameter value. */
    //protected Object value;
    protected Vector values;
    private boolean apply;
    private boolean expression;
    private boolean applyToSql;
    private boolean useIsNull;
    private boolean omitIfEmpty;


    protected int isEmpty = 0;


//-------define emptiness for OmitIfEmpty---------
    public boolean isEmpty() {
        return isEmpty == 1;
    }

    public void setEmpty(boolean empty) {
        if (empty) isEmpty = 1;
        else isEmpty = -1; 
    }
    public int getEmpty() {
        return isEmpty;
    }
    


    public void setOmitIfEmpty(boolean omitIfEmpty){
        this.omitIfEmpty = omitIfEmpty;
    }

    public boolean isOmitIfEmpty() {
        return omitIfEmpty;
    }

    /** Create new SqlParameter. */
    public SqlParameter() {
        this.apply = true;
        this.expression = false;
        this.ccsLocale = new CCSLocale();
    }

    /** Create new SqlParameter with given Locale. */
    public SqlParameter(CCSLocale ccsLocale) {
        this.apply = true;
        this.expression = false;
        if ( ccsLocale == null ) {
            ccsLocale = new CCSLocale();
        }
        this.ccsLocale = ccsLocale;
    }

    /** Create new SqlParameter with given name, value and Locale. */
    public SqlParameter(String name, Object value, CCSLocale ccsLocale) {
      this.apply = true;
      this.expression = false;
      if ( ccsLocale == null ) {
          ccsLocale = new CCSLocale();
      }
      this.name = name;
      try {setValue(value);} catch (ParseException pe) {value=null;}
    }

    /** Get parameter name. */
    public String getName() { return name; }
    /** Set parameter name. */
    public void setName( String name ) { this.name = name; }

    /** Get parameter field. */
    public String getField() { return field; }
    /** Get parameter field. */
    public void setField( String field ) { this.field = field; }

    /** Get parameter type.*/
    public ControlType getType() { return type; }
    /** Set parameter type. */
    public void setType( ControlType type ) { this.type = type; }

    /** Get operation used to construct where clause. */
    public FieldOperation getOperation() { return operation; }
    /** Set operation used to construct where clause. */
    public void setOperation( FieldOperation operation ) { this.operation = operation; }

    /** Get type of the source this parameter gets its value. */
    public ParameterSource getSourceType() { return sourceType; }
    /** Set type of the source this parameter gets its value. */
    public void setSourceType( ParameterSource sourceType ) { this.sourceType = sourceType; }

    /** Get the name by which parameter gets its value from source. */
    public String getSourceName() { return sourceName; }
    /** Set the name by which parameter gets its value from source. */
    public void setSourceName( String sourceName ) { this.sourceName = sourceName; }

    /** Whether this parameter represents an SQL expression to be inserted into SQL as is. */
    public boolean isExpression() { return expression; }
    /** Indicate that this parameter represents an SQL expression to be inserted into SQL as is. */
    public void setExpression( boolean expression ) { this.expression = expression; }

    /** @deprecated Replaced by {@link #getFormatPattern}. */
    public Format getFormat() { return format; }
    /** @deprecated Replaced by {@link #setFormatPattern}. */
    public void setFormat( Format format ) { this.format = format; }
    /** @deprecated Replaced by {@link #setFormatPattern}. */
    public void setFormat( Format format, String formatPattern ) {
      this.format = format;
      this.formatPattern = formatPattern;
    }

    /** @deprecated Replaced by {@link #getDbFormatPattern}. */
    public Format getDbFormat() { return dbFormat; }
    /** @deprecated Replaced by {@link #setDbFormatPattern}. */
    public void setDbFormat( Format dbFormat ) { this.dbFormat = dbFormat; }

    /** Set Locale to be able to apply localized formats. */
    public void setCCSLocale(CCSLocale ccsLocale) {
        if ( ccsLocale == null ) {
            ccsLocale = new CCSLocale();
        }
        this.ccsLocale = ccsLocale;
    }

    /** Get pattern used to convert parameter value from source when it comes as string. */
    public String getFormatPattern() {
      return formatPattern;
    }

    /** Set pattern used to convert parameter value from source when it comes as string. */
    public void setFormatPattern( String formatPattern ) {
      this.formatPattern = formatPattern;
    }

    /** Get pattern used to convert parameter value to DataBase format as is expected in SQL query. */
    public String getDbFormatPattern() {
      return dbFormatPattern;
    }

    /** Set pattern used to convert parameter value to DataBase format as is expected in SQL query. */
    public void setDbFormatPattern( String dbFormatPattern ) {
      this.dbFormatPattern = dbFormatPattern;
    }

    /** Get parameter default value. */
    public Object getDefaultValue() {
        /*if (values != null && values.size()>0 ) 
            return values.get(0);
        else 
            return null;*/
        return defaultValue; 
    }

    /** Set parameter default value. Applies formatPattern if set. */
    public void setDefaultValue( Object val ) throws ParseException {
        if ( val == null ) {
            this.defaultValue = defaultValue;
        } else if ( val instanceof String ) {
                if ( type == ControlType.TEXT || type == ControlType.MEMO ) {
                    this.defaultValue = val;
                } else if ( StringUtils.isEmpty(formatPattern) ) {
                    Format fmt = ccsLocale.getFormat(type);
                    this.defaultValue = fmt.parseObject((String) val);
                    fmt = null;
                } else {
                    try {
                        Format fmt = ccsLocale.getFormat(type, formatPattern);
                        this.defaultValue = fmt.parseObject( (String) val );
                        fmt = null;
                    } catch ( ParseException pe ) {
                        throw new ParseException("Unable to parse '" + val + "' as " + type, 0 );  
                    }
                }
        } else if ( val instanceof Integer ) {
            this.defaultValue = new Long( (long) ((Integer) val).intValue() );
        } else if ( val instanceof Long ) {
            this.defaultValue = val;
        } else if ( val instanceof Double ) {
            this.defaultValue = val;
        } else if ( val instanceof Float ) {
            this.defaultValue = new Double( (double) ((Float) val).floatValue() );
        } else {
            this.defaultValue = null;
        }
    }
    /** Set parameter default value from int value. */
    public void setDefaultValue(int v) throws ParseException {setDefaultValue(new Integer(v));}
    /** Set parameter default value from double value. */
    public void setDefaultValue(double v) throws ParseException {setDefaultValue(new Double(v));}
    /** Set parameter default value from boolean value. */
    public void setDefaultValue(boolean v) throws ParseException {setDefaultValue(new Boolean(v));}

    /** Whether this parameter is used in the SQL query. Used in dynamic WHERE clause construction. */
    public boolean isApply() { return apply; }
    /** Set whether this parameter is used in the SQL query. Used in dynamic WHERE clause construction. */
    public void setApply( boolean flag ) { this.apply = flag; }

    /** @deprecated Replaced by {@link #isApply}. */
    public boolean isApplyToSql() { return applyToSql; }
    /** @deprecated Replaced by {@link #setApply}. */
    public void setApplyToSql( boolean flag ) { this.applyToSql = flag; }

    /** Get parameter value. Identical to {@link #getObjectValue}.
      @return parameter value or default value if value is null (but return null if useIsNull is set). */
    public Object getValue() {
        Object value;
        
        if (values != null && values.size() > 0)
            value = values.get(0);
        else 
            value = null;
        
        Object returnValue = value;
        if ( value == null ) {
            if (!useIsNull) returnValue = defaultValue;
        } else if ( value instanceof String ) {
          if ( StringUtils.isEmpty((String) value) ) {
            if (!useIsNull) returnValue = defaultValue;
          }
        }
        return returnValue;
    }

    /** Get parameter value. Identical to {@link #getValue}.
      @return parameter value or default value if value is null. */
    public Object getObjectValue() {
      return getValue();
    }

    /** Set parameter value from Object. Identical to {@link #setValue} except that it ignores ParseException. */
    public void setObjectValue(Object value) {
        try {
            setValue(value);
        } catch (ParseException pe) {
        }
    }

    /** Set parameter value to be equal to default value. */
    public void applyDefaultValue() {
        //this.value = this.defaultValue;
        Object value = this.defaultValue;
        
        if (values != null && values.size() > 0)
            values.set(0, value);
        else
            values = new Vector();
            values.add(0,value);
        
    }

    /** Set parameter value. Applyes formatPattern if set.
      @throws ParseException if unable to parse parameter value from String. */
    public void setValue( Object val ) throws ParseException {

        if (val instanceof Collection) {
            setValues ((Collection)val);
            return;
        } else if (val instanceof Object[] ) {
            setValues ((Object[]) val);
            return;
        }
        
        Object value;
        
        if ( val == null ) {
            value = this.defaultValue;
        } else if ( val instanceof String ) {
            if ( StringUtils.isEmpty( (String) val ) ) {
                value = this.defaultValue;
            } else {
                if ( type == ControlType.TEXT || type == ControlType.MEMO ) {
                    value = val;
                } else if ( StringUtils.isEmpty(formatPattern) ) {
                    Format fmt = ccsLocale.getFormat(type);
                    value = fmt.parseObject((String) val);
                    fmt = null;
                } else {
                    try {
                        Format fmt = ccsLocale.getFormat(type, formatPattern);
                        value = fmt.parseObject( (String) val );
                        fmt = null;
                    } catch ( ParseException pe ) {
                        throw new ParseException("Unable to parse '" + val + "' as " + type, 0 );  
                    }
                }
            }
        } else if ( val instanceof Integer ) {
            value = new Long( (long) ((Integer) val).intValue() );
        } else if ( val instanceof Long ) {
            value = val;
        } else if ( val instanceof Double ) {
            value = val;
        } else if ( val instanceof Float ) {
            value = new Double( (double) ((Float) val).floatValue() );
        } else {
            value = val;
        }

        if (value != null) {
            if (values != null && values.size() > 0)
                values.set(0, value);
            else {
                values = new Vector();
                values.add(0, value);
            }
        }
        
    }
    /** Set parameter value from int value. */
    public void setValue(int v) throws ParseException {setValue(new Integer(v));}
    /** Set parameter value from double value. */
    public void setValue(double v) throws ParseException {setValue(new Double(v));}
    /** Set parameter value from boolean value. */
    public void setValue(boolean v) throws ParseException {setValue(new Boolean(v));}

    /**
     * Get part of the SQL query corresponding to this parameter.
     * To be used with {@link com.codecharge.db.SqlCommand SqlCommand}.
     * @return part of SQL expression in form [field] [operator] [value].
     * @see #getRawCondition
     */
    public String getSqlCondition() {
        String sqlCondition = null;
        if ( ! expression ) {
          if ( field != null && getValue() != null && operation != null ) {
              sqlCondition = field + operation.getOperation( getValue() );
          } else {
              apply = false;
          }
          if ( operation == FieldOperation.IS_NULL || operation == FieldOperation.NOT_NULL ) {
              apply = false;
          }
        } else {
          sqlCondition = field;
          apply = false;
        }
        return sqlCondition;
    }

    /** Get part of the SQL query corresponding to this parameter.
     * To be used with {@link com.codecharge.db.RawCommand RawCommand}.
     * @return part of SQL expression in form [field] [operator] [value].
     * @see #getSqlCondition
     */
    public String getRawCondition( JDBCConnection conn ) {
        String sqlCondition = null;
        int parameterType = JDBCConnection.TEXT;
        if ( type == ControlType.INTEGER ) {
            parameterType = JDBCConnection.INTEGER;
        } else if ( type == ControlType.FLOAT ) {
            parameterType = JDBCConnection.FLOAT;
        } else if ( type == ControlType.SINGLE ) {
            parameterType = JDBCConnection.SINGLE;
        } else if ( type == ControlType.DATE ) {
            parameterType = JDBCConnection.DATE;
        } else if ( type == ControlType.BOOLEAN ) {
            parameterType = JDBCConnection.BOOLEAN;
        }
        if ( ! expression ) {
            
          Object pVal;
          if (operation == FieldOperation.IN     || operation == FieldOperation.BETWEEN || 
              operation == FieldOperation.NOT_IN || operation == FieldOperation.NOT_BETWEEN) {
                pVal = getValues();
                if ( pVal != null && ((Vector)pVal).size()<=0 ) {
                    pVal = null; 
                }
          } else {
                pVal = getValue();
          }

//System.out.println("START WAY[2] [_"+ (field!=null) +"_][_"+ (pVal!=null) +"_][_"+ (operation!=null) +"_]");


          if ( field != null && pVal != null && operation != null ) {
//System.out.println("WAY[1]");
              //sqlCondition = field + operation.getRawOperation( conn.format( getValue(), getDbFormat() ), conn, parameterType );
              sqlCondition = field + operation.getRawOperation( prepareValuesForOperation (pVal, conn), conn, parameterType );
          } else if (field != null && pVal == null && operation != null && useIsNull) {
//System.out.println("WAY[2]");
              if (operation.getNullRelation() == FieldOperation.IS_NULL) {
                sqlCondition = field + " IS NULL";
              } else {
                sqlCondition = field + " IS NOT NULL";
              }
              apply = false;
          } else {
//System.out.println("WAY[3]");
              apply = false;
          }
          if ( operation == FieldOperation.IS_NULL || operation == FieldOperation.NOT_NULL ) {
              apply = false;
          }
        } else {
          sqlCondition = field;
          apply = false;
        }
        return sqlCondition;
    }


    private Object prepareValuesForOperation (Object value, JDBCConnection conn) {
        Object res = null;

          if (operation == FieldOperation.IN     || operation == FieldOperation.BETWEEN || 
              operation == FieldOperation.NOT_IN || operation == FieldOperation.NOT_BETWEEN) {
            Vector vals = (Vector)value;
            if (vals != null) {
                Iterator it = vals.iterator();
                while (it.hasNext()) {
                    if (res == null) res = new Vector();
                    ((Vector) res).add ( conn.format( it.next(), getDbFormat() ) );
                }
            }
            return res;
        } else {
            return conn.format( value, getDbFormat() );
        }
    }


    /** Whether to use is null operation if parameter is null. */
    public boolean getUseIsNull() {return useIsNull;}
    /** Whether to use is null operation if parameter is null or remove parameter expression from SQL. */
    public void setUseIsNull(boolean f) {this.useIsNull = f;}


    /** Obtain String representation of this parameter. */
    public String toString() {
        Object value; 
        if (values != null && values.size() > 0)
            value = values.get(0);
        else 
            value = null;
        
        StringBuffer sb = new StringBuffer();
        sb.append(" SqlParameter: " + "name: " + (name==null?"is null":name) + " " +
                "field: " + (field==null?"is null":field) + " " +
                "type: " + type + "\n" +
                "\toperation: " + operation + " " +
                "sourceType: " + sourceType + " " +
                "sourceName: " + sourceName + "\n" +
                "\tdefaultValue: " + (defaultValue==null?"is null":defaultValue) + " " +
                "value: " + (value==null?"is null":value) + " " +
                "values: " + (value==null?"is null":(""+values + values.size()) ) + " " +
                "apply: " + apply + "\n");
        return sb.toString();
    }



//-------------ADDED FOR MULTIPLE WHERE SPPORT----------------

    public void setValues(Object[] values) throws ParseException {
      
        if (values == null) {
            setValues((Collection)null);
        } else {
            Vector v = null;
            for (int i = 0; i < values.length; i++) {
                if (v == null) v = new Vector();
                //v.add(values[i]);
                v.add( parseObject2 (values[i]) );

            }
            setValues (v);
        }
    }
    
    public void setValues(Collection values) throws ParseException {
        Vector v = null;
        if (values == null && this.defaultValue != null) {
            v = new Vector();
            v.add(0, this.defaultValue);
        } else {
            if (values == null) values = new Vector();
            Iterator it = values.iterator();
            while (it.hasNext()) {
                if (v == null) v = new Vector();
                //Object val = it.next();
                Object val = parseObject2 (it.next());
                v.add(val);
            }
        }
        this.values = v;
    }

    public void setValues(Vector values) throws ParseException {
        this.values = values; 
    }
    
    public Vector getValues() {
        return values;
    }



    public Object parseObject2 (Object val) throws ParseException {

//System.out.println("PARSING!!!");

        Object value;
        
        if ( val == null ) {
            value = this.defaultValue;
        } else if ( val instanceof String ) {
            if ( StringUtils.isEmpty( (String) val ) ) {
                value = this.defaultValue;
            } else {
                if ( type == ControlType.TEXT || type == ControlType.MEMO ) {
                    value = val;
                } else if ( StringUtils.isEmpty(formatPattern) ) {
                    try {
                        Format fmt = ccsLocale.getFormat(type);
                        value = fmt.parseObject((String) val);
                        fmt = null;
                    } catch ( ParseException pe ) {
                        throw new ParseException("Unable to parse '" + val + "' as " + type, 0 );  
                    }
                } else {
                    try {
                        Format fmt = ccsLocale.getFormat(type, formatPattern);
                        value = fmt.parseObject( (String) val );
                        fmt = null;
                    } catch ( ParseException pe ) {
                        throw new ParseException("Unable to parse '" + val + "' as " + type, 0 );  
                    }
                }
            }
        } else if ( val instanceof Integer ) {
            value = new Long( (long) ((Integer) val).intValue() );
        } else if ( val instanceof Long ) {
            value = val;
        } else if ( val instanceof Double ) {
            value = val;
        } else if ( val instanceof Float ) {
            value = new Double( (double) ((Float) val).floatValue() );
        } else {
            value = val;
        }

        return value;

    }
//------------------------------------------------------------


}



//End SqlParameter class

