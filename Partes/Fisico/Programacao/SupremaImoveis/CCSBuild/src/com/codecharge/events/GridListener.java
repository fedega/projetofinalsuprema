//GridListener @0-A187B761
package com.codecharge.events;

/**
  GridListener interface defines event handlers for Grid component.
**/
public interface GridListener extends ComponentListener {
    /**
      This event is raised when Grid row is about to show.
      Use this event to change row values.
    **/
    public void beforeShowRow( Event e );

}
//End GridListener

