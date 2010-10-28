//PathListener @0-C63DD365
package com.codecharge.events;

/**
  GridListener interface defines event handlers for Grid component.
**/
public interface PathListener extends ComponentListener {

    /**
      This event is raised when Path category is about to show.
      Use this event to change category values.
    **/
    public void beforeShowCategory( Event e );

}
//End PathListener

