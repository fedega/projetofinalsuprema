//WeekdaysTag class @0-4891E989
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;
import com.codecharge.components.calendar.CalendarMonthItem;

public class WeekdaysTag extends BodyTagSupport {

    /** Parent **/
    private Calendar calendar;
    private CalendarItem[] weekdays;
    private int dayCounter;
    private int firstWeekday;
    private int weekDaysCorrect;

    public int doStartTag() {

        calendar = (Calendar) pageContext.getAttribute("parent");
        if (this.calendar.getCurrentItem().getType() == CalendarItem.MONTH) {
            weekdays = ((CalendarMonthItem) this.calendar.getCurrentItem()).getWeekdays();
            firstWeekday = calendar.getPageModel().getCCSLocale().getFirstWeekday();
            if (firstWeekday != 0) weekDaysCorrect = -1; else weekDaysCorrect = 0;
	    dayCounter = firstWeekday + weekDaysCorrect;
            pageContext.setAttribute("weekday", weekdays[dayCounter]);
            pageContext.setAttribute("calenderStyle", calendar.getStyle("Weekdays", dayCounter+1, (CalendarItem) pageContext.getAttribute("currentMonth")));
            pageContext.setAttribute("weekdaySeparator", new Boolean (true));

            dayCounter++;
        return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
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
        if (weekdays != null) {
            if (dayCounter < weekdays.length) {
                pageContext.setAttribute("weekday", weekdays[dayCounter]);
                pageContext.setAttribute("calenderStyle", calendar.getStyle("Weekdays", dayCounter+1, (CalendarItem) pageContext.getAttribute("currentMonth")));
                dayCounter++;
                if (dayCounter < firstWeekday + 7) {
                    pageContext.setAttribute("weekdaySeparator", new Boolean (true));
                }
            } else {
                return SKIP_BODY;
            }
        } else {
            return SKIP_BODY;
        }
        return EVAL_BODY_AGAIN;
    }

    public int doEndTag() {
        pageContext.removeAttribute("weekday");
        pageContext.removeAttribute("calenderStyle");
        pageContext.removeAttribute("weekdaySeparator");
        return EVAL_PAGE;
    }
}

//End WeekdaysTag class

