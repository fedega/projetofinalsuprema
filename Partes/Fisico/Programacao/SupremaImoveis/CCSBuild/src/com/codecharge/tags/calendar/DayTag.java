//DayTag class @0-B1C8C46F
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;

public class DayTag extends BodyTagSupport {

    private Calendar calendar;
    
    public int doStartTag() {

        this.calendar = (Calendar) pageContext.getAttribute("parent");
        if (this.calendar.getCurrentItem().getType() == CalendarItem.DAY 
                || this.calendar.getCurrentItem().getType() == CalendarItem.EVENT) {
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }
}

//End DayTag class

