//DirectoryListener @0-31467819
package com.codecharge.events;

/**
  GridListener interface defines event handlers for Grid component.
**/
public interface DirectoryListener extends ComponentListener {

    /**
      This event is raised when Directory category is about to show.
      Use this event to change category values.
    **/
    public void beforeShowCategory( Event e );

    /**
      This event is raised when Directory subcategory is about to show.
      Use this event to change subcategory values.
    **/
    public void beforeShowSubcategory( Event e );

}
//End DirectoryListener

