//Sortable class @0-12E9FB5B
/*
 * $Revision: 1.1 $
 * $Date: 2004/07/15 07:30:59 $
 */
package com.codecharge.components;


public interface Sortable {
    /**
     * Returns component name
     * @return component name
     */
    public String getName();
    
    /**
     * Returns active sorter name
     * @return name of active sorter 
     */
    public String getSort();
    
    /**
     * Returns direction of sorting
     * @return direction of sorting 
     */
    public String getDir();
    public Sorter getSorter(String name) throws NoSuchComponentException;
}

//End Sortable class

