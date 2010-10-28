//NoEventsTag class @0-8FAB3E98
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.calendar.CalendarItem;

public class NoEventsTag extends TagSupport {

    public int doStartTag() {

        return SKIP_BODY;
    }

}

//End NoEventsTag class

