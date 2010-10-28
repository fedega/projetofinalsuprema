//ButtonListener @0-D26690B0
package com.codecharge.events;

/**
  ButtonListener Interface defines event handlers methods for Button control.
**/
public interface ButtonListener {
    /**
      This event is raised when button has been clicked.
      Record operations occur after this event.
      Use this event to program custom button actions.
      @see com.codecharge.components.Page#setRedirect(String)
      @see com.codecharge.components.Page#getRedirect()
    **/
    public void onClick(Event e);
    /**
      This event is raised when button is about to show.
      Use this event to remove button from resulting html.
      @see com.codecharge.components.Model#setVisible(boolean)
    **/
    public void beforeShow(Event e);
}
//End ButtonListener

