//TemplateTag class @0-73A0296F
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
import com.codecharge.util.StringUtils;

public class TemplateTag extends BodyTagSupport {

    private Calendar calendar;
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    private static final String NOT_NULL = "1";

    public int doStartTag() {

        this.calendar = (Calendar) pageContext.getAttribute("parent");

        CalendarItem month = (CalendarItem) pageContext.getAttribute("currentMonth");
        boolean isEmptyDay = false;
        if (this.calendar.getCurrentItem().getType() == CalendarItem.DAY) {
            isEmptyDay = ! isShowDay(this.calendar.getCurrentItem());
        } else {
            isEmptyDay = ! isShowDay((CalendarItem) pageContext.getAttribute("currentDay"));
        }


        if ("DayHeader".equalsIgnoreCase(this.name)) {
            if (this.calendar.getCurrentItem().getType() == CalendarItem.DAY) {
                if (! isEmptyDay) {
                    this.calendar.fireBeforeShowDayEvent(new Event());
                    pageContext.setAttribute("currentDay", this.calendar.getCurrentItem());
                    getWeekDayCounter().add(1);
                    getMonthDayCounter().add(1);
                    this.calendar.getCurrentItem().iteratorInit();
                    if (this.calendar.getCurrentItem().hasNextItem()) {
                        this.calendar.nextItem();  //handle day events
                    }
                    return EVAL_BODY_INCLUDE;
                }
            }
        } else if ("DayFooter".equalsIgnoreCase(this.name)) {
            CalendarItem item = (CalendarItem) pageContext.getAttribute("currentDay");
            if (! isEmptyDay && ! (item == null || item.hasNextItem())) {
                calendar.setCurrentItem(item);
                if (getWeekDayCounter().intValue() != 7) pageContext.setAttribute("daySeparator", TemplateTag.NOT_NULL);
                return EVAL_BODY_INCLUDE;
            }
        } else if ("WeekHeader".equalsIgnoreCase(this.name)) {
            if (getWeekDayCounter().intValue() == 0 && this.calendar.getCurrentItem().getType() != CalendarItem.MONTH) {
                this.calendar.fireBeforeShowWeekEvent(new Event());
                return EVAL_BODY_INCLUDE;
            }
        } else if ("WeekFooter".equalsIgnoreCase(this.name)) {
            CalendarItem item = (CalendarItem) pageContext.getAttribute("currentDay");
            if (this.calendar.getCurrentItem().getType() == CalendarItem.DAY
                    || (item !=null && !item.hasNextItem() && this.calendar.getCurrentItem().getType() == CalendarItem.EVENT)
                    ) {
                if (getWeekDayCounter().intValue() == 7) { // !!!: hardcode! support gregorian calendar only
                    getWeekDayCounter().setValue(0);
                    if (month.hasNextItem()) {
                        pageContext.setAttribute("weekSeparator", TemplateTag.NOT_NULL);
                    }
                    return EVAL_BODY_INCLUDE;
                }
            }
        } else if ("MonthHeader".equalsIgnoreCase(this.name)) {
            if (this.calendar.getCurrentItem().getType() == CalendarItem.MONTH) {
                pageContext.setAttribute("currentMonth", this.calendar.getCurrentItem());
                this.calendar.fireBeforeShowMonthEvent(new Event());
                getWeekDayCounter().setValue(0);
                getMonthDayCounter().setValue(0);
                getMonthCounter().add(1);
                getTotalMonthCounter().add(1);
                return EVAL_BODY_INCLUDE;
            }
        } else if ("MonthWeekDaysFooter".equalsIgnoreCase(this.name)) {
            if (this.calendar.getCurrentItem().getType() == CalendarItem.MONTH) {
                return EVAL_BODY_INCLUDE;
            }
        } else if ("MonthFooter".equalsIgnoreCase(this.name)) {
            if (! month.hasNextItem()) {
                if (getMonthCounter().intValue() == calendar.getMonthsInRow()) {
                    CalendarItem year = (CalendarItem) pageContext.getAttribute("currentYear");
                    if (year != null && year.hasNextItem()) {
                        pageContext.setAttribute("monthRowSeparator", TemplateTag.NOT_NULL);
                    }
                }
                return EVAL_BODY_INCLUDE;
            }
        } else if ("EventRow".equalsIgnoreCase(this.name)) {

            if (isShowDay((CalendarItem) pageContext.getAttribute("currentDay")) 
                    && this.calendar.getCurrentItem().getType() == CalendarItem.EVENT) {

                if (((CalendarItem) pageContext.getAttribute("currentDay")).hasNextItem()) {
                    pageContext.setAttribute("eventSeparator", TemplateTag.NOT_NULL);
                }
                this.calendar.fireBeforeShowEventEvent(new Event());
                return EVAL_BODY_INCLUDE;
            }
        } else if ("NoEvents".equalsIgnoreCase(this.name)) {
            if (isShowDay(this.calendar.getCurrentItem()) 
                    && this.calendar.getCurrentItem().getType() == CalendarItem.DAY 
                    && ! this.calendar.getCurrentItem().hasNextItem()) {
                return EVAL_BODY_INCLUDE;
            }
        } else if ("EmptyDay".equalsIgnoreCase(this.name)) {
            if (isEmptyDay && this.calendar.getCurrentItem().getType() == CalendarItem.DAY) {
                this.calendar.fireBeforeShowDayEvent(new Event());
                pageContext.setAttribute("currentDay", this.calendar.getCurrentItem());
                getWeekDayCounter().add(1);
                getMonthDayCounter().add(1);
                return EVAL_BODY_INCLUDE;
            }
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
    
    private MutableSingle getMonthDayCounter() {
        MutableSingle dayCounter = (MutableSingle) pageContext.getAttribute("monthDayCounter");
        if (dayCounter == null) {
            dayCounter = new MutableSingle(0);
            pageContext.setAttribute("monthDayCounter", dayCounter);
        }
        return dayCounter;
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

    private boolean isShowDay(CalendarItem day) {
        if (day == null) {
            return false;
        }
        boolean result = true;
        java.util.Calendar cal = java.util.Calendar.getInstance(calendar.getTimeZone()
                , calendar.getPageModel().getLocale());
        CalendarItem month = (CalendarItem) pageContext.getAttribute("currentMonth");
        cal.setTime(month.getDate());
        int monthToShow = cal.get(java.util.Calendar.MONTH);
        int yearToShow = cal.get(java.util.Calendar.YEAR);
        cal.setTime(day.getDate());
        if (day.getType() == CalendarItem.DAY 
                && monthToShow != cal.get(java.util.Calendar.MONTH) 
                    && ! this.calendar.isShowOtherMonthsDays()) {
            result = false;
        }
        return result;
    }
}

//End TemplateTag class

