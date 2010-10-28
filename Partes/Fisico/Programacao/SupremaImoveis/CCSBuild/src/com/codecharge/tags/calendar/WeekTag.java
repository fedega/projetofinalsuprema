//WeekTag class @0-E947C9B4
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;

public class WeekTag extends BodyTagSupport {

    private final static String EMPTY = "";

    private Calendar calendar;
    private CalendarItem month;
    
    public int doStartTag() {

        calendar = (Calendar) pageContext.getAttribute("parent");
        if (this.calendar.getCurrentItem().getType() == CalendarItem.DAY 
                || this.calendar.getCurrentItem().getType() == CalendarItem.EVENT) {
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }
}

//End WeekTag class

