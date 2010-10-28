//ComponentListener component @0-5C2853F9
package com.codecharge.events;

/**
  ComponentListener interface defines event handlers for CCS component.
**/
public interface ComponentListener {

    /**
     * This event is raised when CCS component is initialized
     * and page model is ready.
     */
    void afterInitialize(Event e);
  
    /**
      This event is raised when CCS component is about to show.
      Use this event to hide or change CCS component title etc.
      @see com.codecharge.components.Model#setVisible
    **/
    void beforeShow(Event e);
    
    void beforeSelect(Event e);
}

//End ComponentListener component

