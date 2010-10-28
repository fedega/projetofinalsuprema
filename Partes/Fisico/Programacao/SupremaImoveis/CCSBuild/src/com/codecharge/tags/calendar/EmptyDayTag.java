//EmptyDayTag class @0-E5E508B4
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;

public class EmptyDayTag extends BodyTagSupport {

    public int doStartTag() {
        return SKIP_BODY;
    }

}

//End EmptyDayTag class

