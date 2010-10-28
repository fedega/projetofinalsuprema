//SortDirection class @0-9E2F3DB6
package com.codecharge.db;

final public class SortDirection {

    static public SortDirection ASC  = new SortDirection("ASC ");
    static public SortDirection DESC = new SortDirection("DESC");

    static private int counter;

    private int type;
    private String name;

    private SortDirection() {
        this.type = counter++;
    }

    private SortDirection( String name ) {
        this.type = counter++;
        this.name = name;
    }

    public String toString() {
        if ( name == null )
            return String.valueOf( type );
        else
            return name;
    }

}
//End SortDirection class

