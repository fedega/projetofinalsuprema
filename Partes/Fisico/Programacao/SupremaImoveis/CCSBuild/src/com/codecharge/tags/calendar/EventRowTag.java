//EventRowTag class @0-040FE7A5
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;

public class EventRowTag extends BodyTagSupport {

    CalendarItem day;
    Calendar calendar;
    
    public int doStartTag() {

        calendar = (Calendar) pageContext.getAttribute("parent");
        if (calendar.getCurrentItem().getType() == CalendarItem.EVENT) {
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }
}

//End EventRowTag class

