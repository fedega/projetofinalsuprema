//CalendarSeparatorTag class @0-CEF3EC4F
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;
import com.codecharge.components.report.MutableSingle;

public class SeparatorTag extends TagSupport {

    private Calendar calendar;
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    
    public int doStartTag() {

        calendar = (Calendar) pageContext.getAttribute("parent");
        if ("MonthsRow".equalsIgnoreCase(this.name)) {
            if (pageContext.getAttribute("monthRowSeparator") != null) {
                getMonthCounter().setValue(0);
                pageContext.removeAttribute("monthRowSeparator");
                return EVAL_BODY_INCLUDE;
            }
        } else if ("Month".equalsIgnoreCase(this.name)) {
            CalendarItem month = (CalendarItem) pageContext.getAttribute("currentMonth");
            if (! month.hasNextItem() && 
                    (getTotalMonthCounter().intValue() != calendar.getMonths()) && 
                    (getMonthCounter().intValue() != calendar.getMonthsInRow()) ) {
                return EVAL_BODY_INCLUDE;
            }
        } else if ("Week".equalsIgnoreCase(this.name)) {
            if (pageContext.getAttribute("weekSeparator") != null) {
                pageContext.removeAttribute("weekSeparator");
                return EVAL_BODY_INCLUDE;
            }
        } else if ("Day".equalsIgnoreCase(this.name)) {
            if (pageContext.getAttribute("daySeparator") != null) {
                pageContext.removeAttribute("daySeparator");
                return EVAL_BODY_INCLUDE;
            }
        } else if ("Event".equalsIgnoreCase(this.name)) {
            if (pageContext.getAttribute("eventSeparator") != null) {
                pageContext.removeAttribute("eventSeparator");
                return EVAL_BODY_INCLUDE;
            }
        } else if ("WeekDay".equalsIgnoreCase(this.name)) {
            if (pageContext.getAttribute("weekdaySeparator") != null) {
                pageContext.removeAttribute("weekdaySeparator");
                return EVAL_BODY_INCLUDE;
            }
        }
        return SKIP_BODY;
    }

    private MutableSingle getMonthCounter() {
        MutableSingle monthCounter = (MutableSingle) pageContext.getAttribute("monthCounter");
        if (monthCounter == null) {
            monthCounter = new MutableSingle(0);
            pageContext.setAttribute("monthCounter", monthCounter);
        }
        return monthCounter;
    }


    private MutableSingle getTotalMonthCounter() {
        MutableSingle monthCounter = (MutableSingle) pageContext.getAttribute("totalMonthCounter");
        if (monthCounter == null) {
            monthCounter = new MutableSingle(0);
            pageContext.setAttribute("totalMonthCounter", monthCounter);
        }
        return monthCounter;
    }

}

//End CalendarSeparatorTag class

