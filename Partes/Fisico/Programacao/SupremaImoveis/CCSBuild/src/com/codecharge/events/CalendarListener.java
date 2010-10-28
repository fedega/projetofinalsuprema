//CalendarListener @0-E15CB88E
/*
 * $Revision: 1.1 $
 * $Date: 2005/04/27 11:51:46 $
 */
package com.codecharge.events;

/**
  CalendarListener interface defines event handlers for CCS calendar.
**/
public interface CalendarListener extends ComponentListener {

    /**
     * This event is raised before months will be shown.
     */
    void beforeShowMonth(Event e);
  
    /**
     * This event is raised before week will be shown.
     */
    void beforeShowWeek(Event e);
    
    /**
     * This event is raised before day will be shown.
     */
    void beforeShowDay(Event e);

    /**
     * This event is raised before event will be shown.
     */
    void beforeShowEvent(Event e);
}


//End CalendarListener

