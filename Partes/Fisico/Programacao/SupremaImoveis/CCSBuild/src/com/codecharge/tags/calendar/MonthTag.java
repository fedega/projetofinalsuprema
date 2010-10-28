//MonthTag class @0-CB22AC2E
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;
import com.codecharge.components.report.MutableSingle;
import com.codecharge.events.Event;

public class MonthTag extends BodyTagSupport {

    private static int mCounter = 0;
    
    /** Parent **/
    private Calendar calendar;
    private CalendarItem year;
    private CalendarItem month;

    public int doStartTag() {
        mCounter = 0;
        calendar = (Calendar) pageContext.getAttribute("parent");
        if (calendar == null || ! calendar.getCurrentItem().hasNextItem()) return SKIP_BODY;
        if (calendar.getCurrentItem().getType() == CalendarItem.CALENDAR && calendar.getCurrentItem().hasNextItem()) {
            calendar.nextItem();
            getWeekDayCounter().setValue(0);
            pageContext.setAttribute("currentMonth", calendar.getCurrentItem());
            pageContext.setAttribute("currentMonthInRow", new Integer(0));
        }
        pageContext.removeAttribute("weekSeparator");
        return EVAL_BODY_INCLUDE;
    }

    public int doAfterBody() throws JspTagException {

        if (bodyContent != null) {
            try {

                bodyContent.writeOut(getPreviousOut());
                bodyContent.clearBody();
            } catch (java.io.IOException e) {
                throw new JspTagException("Unexpected IO Exception");
            }
        }
        if (calendar.hasNextItem()) {
            calendar.nextItem();
            if (calendar.getCurrentItem().getType()==CalendarItem.MONTH) {  pageContext.removeAttribute("currentDay"); }
            mCounter++;
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }
    
    private MutableSingle getWeekDayCounter() {
        MutableSingle dayCounter = (MutableSingle) pageContext.getAttribute("weekDayCounter");
        if (dayCounter == null) {
            dayCounter = new MutableSingle(0);
            pageContext.setAttribute("weekDayCounter", dayCounter);
        }
        return dayCounter;
    }
    
}

//End MonthTag class

