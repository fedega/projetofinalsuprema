//CalendarMonthItem class @0-921F998C
/*
 * $Revision: 1.2 $
 * $Date: 2005/04/29 08:26:30 $
 */
package com.codecharge.components.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import com.codecharge.components.Model;

/**
 * This class represents one calendar month.
 */
public class CalendarMonthItem extends CalendarItem {
    
    private ArrayList weekdays;
    private HashMap weekdayControls;
    
    public CalendarMonthItem(Date date) {
        super(date, CalendarItem.MONTH);
        weekdays = new ArrayList(7);
        weekdayControls = new HashMap(2, 0.95f);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CalendarMonthItem)) {
            return false;
        }
        return this.date.equals(((CalendarMonthItem) obj).date);
    }

    public void addWeekdayItem(CalendarItem weekday) {
        weekdays.add(weekday);
    }

    public CalendarItem[] getWeekdays() {
        return ((CalendarItem[]) weekdays.toArray(new CalendarItem[weekdays.size()]));
    }

    public Model getModel(String name) {
        return (Model) this.controls.get(name);
    }
    
    public Model addModelToWeekday(Model m) {
        this.weekdayControls.put(m.getName(), m);
        return m;
    }
    
    public void addAllModelsToWeekday(CalendarItem item) {
        this.weekdayControls.putAll(item.controls);
    }
    
    public Model getModelFromWeekday(String name) {
        return (Model) this.weekdayControls.get(name);
    }
    

}

//End CalendarMonthItem class

