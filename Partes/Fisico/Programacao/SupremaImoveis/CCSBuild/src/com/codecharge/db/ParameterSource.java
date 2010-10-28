//ParameterSource class @0-6ABA5D9D
/*
 * $Revision: 1.4 $
 * $Date: 2005/05/04 05:43:23 $
 */
package com.codecharge.db;

import com.codecharge.util.CCLogger;

final public class ParameterSource {

    static public ParameterSource CONTROL = new ParameterSource("CONTROL", "ctrl");
    static public ParameterSource EXPRESSION   = new ParameterSource("EXPRESSION", "expr");
    static public ParameterSource URL    = new ParameterSource("URL", "url");
    static public ParameterSource FORM = new ParameterSource("FORM", "post");
    static public ParameterSource SESSION    = new ParameterSource("SESSION", "ses");
    static public ParameterSource APPLICATION    = new ParameterSource("APPLICATION", "app");
    static public ParameterSource COOKIE    = new ParameterSource("COOKIE", "cook");
    static public ParameterSource DATAFIELD    = new ParameterSource("DATAFIELD", "");
    static public ParameterSource CONST    = new ParameterSource("CONST", "");
    static public ParameterSource CACHED   = new ParameterSource("DataSourceColumn", "");
    static public ParameterSource DBPARAMETER   = new ParameterSource("DBParameter", "");
    static public ParameterSource CALENDARSPECIALVALUE   = new ParameterSource("CalendarSpecialValue", "");
    static public ParameterSource REPORTSPECIALVALUE   = new ParameterSource("SpecialValue", "");

    static private int counter;

    private int type;
    private String name;
    private String prefix;

    private ParameterSource() {
        this.type = counter++;
    }

    private ParameterSource( String name, String prefix ) {
        this.type = counter++;
        this.name = name;
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String toString() {
        if ( name == null )
            return String.valueOf( type );
        else
            return name;
    }

    public static ParameterSource getParameterSource( String type ) {
        if ( "CONTROL".equalsIgnoreCase(type) ) return ParameterSource.CONTROL;
        if ( "EXPRESSION".equalsIgnoreCase(type) ) return ParameterSource.EXPRESSION;
        if ( "URL".equalsIgnoreCase(type) ) return ParameterSource.URL;
        if ( "FORM".equalsIgnoreCase(type) ) return ParameterSource.FORM;
        if ( "SESSION".equalsIgnoreCase(type) ) return ParameterSource.SESSION;
        if ( "APPLICATION".equalsIgnoreCase(type) ) return ParameterSource.APPLICATION;
        if ( "COOKIE".equalsIgnoreCase(type) ) return ParameterSource.COOKIE;
        if ( "DATAFIELD".equalsIgnoreCase(type) ) return ParameterSource.DATAFIELD;
        if ( "CONST".equalsIgnoreCase(type) ) return ParameterSource.CONST;
        if ( "DataSourceColumn".equalsIgnoreCase(type) ) return ParameterSource.CACHED;
        if ( "DBParameter".equalsIgnoreCase(type) ) return ParameterSource.DBPARAMETER;
        if ( "CalendarSpecialValue".equalsIgnoreCase(type) ) return ParameterSource.CALENDARSPECIALVALUE;
        if ( "SpecialValue".equalsIgnoreCase(type) ) return ParameterSource.REPORTSPECIALVALUE;
        CCLogger.getInstance().error("ParameterSource '"+type+"' doesn't exist.");
        return null;
    }
} //End of ParameterSource class



//End ParameterSource class

