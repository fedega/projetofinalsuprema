//Navigable class @0-5CC07D29
/*
 * $Revision: 1.3 $
 * $Date: 2004/11/05 15:36:03 $
 */
package com.codecharge.components;


public interface Navigable {
    /**
     * Returns component name
     * @return component name
     */
    public String getName();
    public int getPageSize();
    public long getNumberOfRows();
    public Navigator getNavigator(String name) throws NoSuchComponentException;
    /**
     * Get current page number.
     * 
     * @return page number
     */
    public int getPageNumber();
    public int getTotalPages();

    public boolean isNavigatorVisible();
}


//End Navigable class

