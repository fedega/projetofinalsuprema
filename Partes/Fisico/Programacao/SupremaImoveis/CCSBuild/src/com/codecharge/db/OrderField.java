//OrderField class @0-E4F79673
package com.codecharge.db;

public class OrderField {
    protected String field;
    protected SortDirection sortDirection;
    
    public OrderField() {
    }
    
    public OrderField( String field, SortDirection sortDirection ) {
        this.field = field;
        this.sortDirection = sortDirection;
    }
    
    public String getField() {
        return field;
    }

    public void setField( String field ) {
        this.field = field;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }
    
    public void setSortDirection( SortDirection sortDirection ) {
        this.sortDirection = sortDirection;
    }
}
//End OrderField class

