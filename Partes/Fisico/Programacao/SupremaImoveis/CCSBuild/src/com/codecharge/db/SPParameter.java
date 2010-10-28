//SPParameter class @0-DB983585
package com.codecharge.db;

import java.sql.Types;
import java.util.Collections;
import java.util.Collection;
import java.util.Vector;
import com.codecharge.components.ControlType;
import com.codecharge.util.CCSLocale;

/**
 * Represents Stored Procedure parameter.
 */
public class SPParameter extends SqlParameter {

    final static public int INPUT_PARAMETER = 1;
    final static public int OUTPUT_PARAMETER = 2;
    final static public int INPUT_OUTPUT_PARAMETER = 3;

    private int typeSP;
    private int scale;
    private int direction;
    private int dataSize;
    //private Object value;

    /** Create new SPParameter. */
    public SPParameter(){}

    /** Create new SPParameter with given Locale. */
    public SPParameter(CCSLocale locale) {
        super(locale);
    }

    /** Create new SPParameter with given value, type, scale, direction and Locale. */
    public SPParameter( Object value, int type, int scale, int direction, CCSLocale locale ) {
        super(locale);
        //this.value = value;
        if (value != null) {
            if (values != null && values.size() > 0)
                values.set(0, value);
            else {
                values = new Vector();
                values.add(0, value);
            }
        }

        this.typeSP = type;
        this.scale = scale;
        this.direction = direction;
    }

    /** Create new SPParameter with given value, type, scale and direction. */
    public SPParameter( Object value, int type, int scale, int direction ) {
        //this.value = value;
        if (value != null) {
            if (values != null && values.size() > 0)
                values.set(0, value);
            else {
                values = new Vector();
                values.add(0, value);
            }
        }

        this.typeSP = type;
        this.scale = scale;
        this.direction = direction;
    }

    /** Set parameter value. If value is null returns default value. Performs conversion to paremeter type. */
    public Object getValue() {

        Object value = null;
        if (this.values != null && this.values.size() > 0) {
            value = values.get(0);
        }


        Object returnValue = value;

        if ( value == null ) {
            returnValue = defaultValue;
        } else if ( value != null && (value instanceof String) ) {
          if ( com.codecharge.util.StringUtils.isEmpty( (String) value ) ) {
            returnValue = defaultValue;
          }
        } else if (typeSP == OracleSPCommand.ORACLE_CURSOR) {
            if (value == null) {
                return null;
            } else {
//System.out.println("VALUE["+value+"]CLASS["+value.getClass()+"]");
                if (!(value instanceof Collection)) {
                    Vector v = new Vector();
                    v.add(value);
                    return Collections.enumeration((Collection) v);
                }
                return Collections.enumeration((Collection) value);
            }
        }

        if ( returnValue != null ) {
          if ( ( typeSP == Types.INTEGER ) ) {
            if ( returnValue instanceof Number ) {
              value = new Integer( ((Number) returnValue).intValue() );
            } else if ( returnValue instanceof java.util.Date ) {
              value = new Integer( (int) ((java.util.Date) returnValue).getTime() );
            }
          } else if ( typeSP == Types.SMALLINT ) {
            if ( returnValue instanceof Number ) {
              value = new Short( ((Number) returnValue).shortValue() );
            } else if ( returnValue instanceof java.util.Date ) {
              value = new Short( (short) ((java.util.Date) returnValue).getTime() );
            }
          } else if ( typeSP == Types.TINYINT ) {
            if ( returnValue instanceof Number ) {
              value = new Byte( ((Number) returnValue).byteValue() );
            } else if ( returnValue instanceof java.util.Date ) {
              value = new Byte( (byte) ((java.util.Date) returnValue).getTime() );
            }
          } else if ( typeSP == Types.NUMERIC || typeSP == Types.DECIMAL ) {
            if ( returnValue instanceof Double ) {
              value = new java.math.BigDecimal(returnValue.toString());
            } else if ( returnValue instanceof java.math.BigDecimal ) {
              value = returnValue;
            } else if ( returnValue instanceof Number ) {
              value = new java.math.BigDecimal(returnValue.toString());
            } else if ( returnValue instanceof java.util.Date ) {
              value = new java.math.BigDecimal( new Double(((java.util.Date) returnValue).getTime()).toString() );
            } else if ( returnValue instanceof String ) {
              try {
                value = new java.math.BigDecimal( (String) returnValue );
              } catch ( NumberFormatException nfe ) { }
            }
          } else if ( typeSP == Types.BIGINT ) {
            if ( returnValue instanceof Number ) {
              value = new Long( (long) ((Number) returnValue).longValue() );
            } else if ( returnValue instanceof java.util.Date ) {
              value = new Long( (long) ((java.util.Date) returnValue).getTime() );
            } else if ( returnValue instanceof String ) {
              try {
                value = new Long( (String) returnValue );
              } catch ( NumberFormatException nfe ) { }
            }
          } else if ( typeSP == Types.DOUBLE ) {
            if ( returnValue instanceof Number ) {
              value = new Double( ((Number) returnValue).doubleValue() );
            } else if ( returnValue instanceof java.util.Date ) {
              value = new Double( (double) ((java.util.Date) returnValue).getTime() );
            } else if ( returnValue instanceof String ) {
              try {
                value = new Double( (String) returnValue );
              } catch ( NumberFormatException nfe ) { }
            }
          } else if ( typeSP == Types.FLOAT ) {
            if ( returnValue instanceof Number ) {
              value = new Float( ((Number) returnValue).floatValue() );
            } else if ( returnValue instanceof java.util.Date ) {
              value = new Float( (float) ((java.util.Date) returnValue).getTime() );
            } else if ( returnValue instanceof String ) {
              try {
                value = new Float( (String) returnValue );
              } catch ( NumberFormatException nfe ) { }
            }
          } else if ( (typeSP == Types.CHAR || typeSP == Types.VARCHAR || typeSP == Types.LONGVARCHAR) && !(returnValue instanceof String) ) {
            returnValue = returnValue.toString();
          } else if ( typeSP == Types.DATE ) {
            if ( returnValue instanceof java.util.Date ) {
              value = new java.sql.Date( ((java.util.Date) returnValue).getTime() );
            }
          } else if ( typeSP == Types.TIME ) {
            if ( returnValue instanceof java.util.Date ) {
              value = new java.sql.Time( ((java.util.Date) returnValue).getTime() );
            }
          } else if ( typeSP == Types.TIMESTAMP ) {
            if ( returnValue instanceof java.util.Date ) {
              value = new java.sql.Timestamp( ((java.util.Date) returnValue).getTime() );
            }
          }
        }

        if (value != null) {
            if (values != null && values.size() > 0)
                values.set(0, value);
            else {
                values = new Vector();
                values.add(0, value);
            }
        }

        return returnValue;
    }

    public void setValue( Object value )  throws java.text.ParseException {
        type = getSPParameterCCSType( typeSP );
        super.setValue( value );
    }
    public void setDefaultValue( Object value )  throws java.text.ParseException {
        type = getSPParameterCCSType( typeSP );
        super.setDefaultValue( value );
    }

    /** Get parameter type.
     * @see java.sql.Types Sql Types
     */
    public int getSPType() { return typeSP; }

    /** Set parameter type.
     * @see java.sql.Types Sql Types
     */
    public void setType( int type ) { this.typeSP = type; }

    /** Get parameter scale. */
    public int getScale() { return scale; }

    /** Set parameter scale. */
    public void setScale( int scale ) { this.scale = scale; }

    /** Get parameter direction.
      @see #INPUT_PARAMETER
      @see #OUTPUT_PARAMETER
      @see #INPUT_OUTPUT_PARAMETER
     */
    public int getDirection() { return direction; }

    /** Set parameter direction.
      @see #INPUT_PARAMETER
      @see #OUTPUT_PARAMETER
      @see #INPUT_OUTPUT_PARAMETER
     */
    public void setDirection( int direction ) { this.direction = direction; }

    /** Get parameter data size. */
    public int getDataSize() { return dataSize; }

    /** Set parameter data size. */
    public void setDataSize( int dataSize ) { this.dataSize = dataSize; }

    /** Obtain string representation of this parameter. */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" SPParameter: " + "name: " + (getName()==null?"is null":getName()) + " " +
                "field: " + (getField()==null?"is null":getField()) + " " +
                "type: " + typeSP + "\n" +
                ( getValue() == null ? "" : "value type: " + values.getClass().getName() + "\n" ) +
                "dataSize: " + dataSize + "\n" +
                "direction: " + direction + "\n" +
                "scale: " + scale + "\n" +
                "sourceType: " + getSourceType() + " " +
                "sourceName: " + getSourceName() + "\n" +
                "\tdefaultValue: " + (defaultValue==null?"is null":defaultValue) + " " +
                "value: " + (values==null?"is null":(""+values)) + " " +
                "apply: " + isApply() + "\n");
        return sb.toString();
    }

    /** Convert SP type to Control type. */
    private ControlType getSPParameterCCSType( int type ) {
        switch ( type ) {
            case java.sql.Types.BIGINT:
                return ControlType.FLOAT;
            case java.sql.Types.BIT:
                return ControlType.BOOLEAN;
            case java.sql.Types.CHAR:
                return ControlType.TEXT;
            case java.sql.Types.DATE:
                return ControlType.DATE;
            case java.sql.Types.DECIMAL:
                return ControlType.SINGLE;
            case java.sql.Types.FLOAT:
                return ControlType.SINGLE;
            case java.sql.Types.INTEGER:
                return ControlType.INTEGER;
            case java.sql.Types.LONGVARCHAR:
                return ControlType.TEXT;
            case java.sql.Types.NUMERIC:
                return ControlType.SINGLE;
            case java.sql.Types.REAL:
                return ControlType.FLOAT;
            case java.sql.Types.SMALLINT:
                return ControlType.INTEGER;
            case java.sql.Types.TIME:
                return ControlType.FLOAT;
            case java.sql.Types.TIMESTAMP:
                return ControlType.DATE;
            case java.sql.Types.TINYINT:
                return ControlType.INTEGER;
            case java.sql.Types.VARCHAR:
                return ControlType.TEXT;
        }
        return ControlType.TEXT;
    }
}

//End SPParameter class

