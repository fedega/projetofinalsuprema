//ControlSourceType class @0-64487F9E
package com.codecharge.db;

final public class ControlSourceType {

    static public ControlSourceType DATA_SOURCE = new ControlSourceType("DATA_SOURCE");
    static public ControlSourceType CODE_EXPRESSION = new ControlSourceType("CODE_EXPRESSION");

    static private int counter;

    private int type;
    private String name;

    private ControlSourceType() {
        this.type = counter++;
    }

    private ControlSourceType( String name ) {
        this.type = counter++;
        this.name = name;
    }

    public String toString() {
        if ( name == null )
            return String.valueOf( type );
        else
            return name;
    }

    public static ControlSourceType getControlSourceType( String type ) {
        if ( "DATASOURCE".equalsIgnoreCase(type) ) return ControlSourceType.DATA_SOURCE;
        if ( "CODEEXPRESSION".equalsIgnoreCase(type) ) return ControlSourceType.CODE_EXPRESSION;
        return null;
    }
}
//End ControlSourceType class

