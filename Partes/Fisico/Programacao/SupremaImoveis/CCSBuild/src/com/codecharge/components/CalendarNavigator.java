//CalendarNavigator class @0-E841D222
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.components;

import java.util.Date;
import java.util.Vector;

import com.codecharge.components.calendar.CalendarNavigatorItem;
import com.codecharge.events.ControlListener;
import com.codecharge.events.Event;


public class CalendarNavigator extends Model {
    
    final static public int ITEM = 1;
    final static public int YEAR = 2;

    private int yearsRange;
    
    private Date prevYear;
    private Date nextYear;
    private Date prevDate;
    private Date nextDate;
    private int year;
    private int month;
    
    private int itemCounter = -1;
    private CalendarNavigatorItem[] items;
    
    private int yearCounter = -1;
    private CalendarNavigatorItem[] years;
    
    public CalendarNavigator(String name) {
        super(name);
    }
    public int getYearsRange() {
        return yearsRange;
    }
    public void setYearsRange(int yearsRange) {
        this.yearsRange = yearsRange;
    }
    public Date getCurrentProcessingDate() {
        if (! (parent instanceof Calendar)) {
            throw new IllegalStateException();
        }
        return ((Calendar) parent).getCurrentItem().getDate();
    }
    public Date getNextDate() {
        return nextDate;
    }
    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }
    public Date getNextYear() {
        return nextYear;
    }
    public void setNextYear(Date nextYear) {
        this.nextYear = nextYear;
    }
    public Date getPrevDate() {
        return prevDate;
    }
    public void setPrevDate(Date prevDate) {
        this.prevDate = prevDate;
    }
    public Date getPrevYear() {
        return prevYear;
    }
    public void setPrevYear(Date prevYear) {
        this.prevYear = prevYear;
    }
    public CalendarNavigatorItem[] getItems() {
        return items;
    }
    public void setItems(CalendarNavigatorItem[] items) {
        this.items = items;
    }
    public void iteratorInit() {
        this.itemCounter = -1;
    }
    public void iteratorInit(int type) {
        switch(type) {
            case CalendarNavigator.ITEM:
                iteratorInit();
                break;
            case CalendarNavigator.YEAR:
                this.yearCounter = -1;
                break;
            default:
                throw new IllegalArgumentException("Type is incorrect: "+type);
        }
    }
    public boolean hasNextItem() {
        return items != null && itemCounter < items.length - 1; 
    }
    public boolean hasNextItem(int type) {
        switch(type) {
            case CalendarNavigator.ITEM:
                return hasNextItem(); 
            case CalendarNavigator.YEAR:
                return years != null && yearCounter < years.length - 1; 
            default:
                throw new IllegalArgumentException("Type is incorrect: "+type);
        }
    }
    public CalendarNavigatorItem nextItem() {
        itemCounter++;
        return currentItem();
    }
    public CalendarNavigatorItem nextItem(int type) {
        switch(type) {
            case CalendarNavigator.ITEM:
                return nextItem(); 
            case CalendarNavigator.YEAR:
                yearCounter++;
                return currentItem(type);
            default:
                throw new IllegalArgumentException("Type is incorrect: "+type);
        }
    }
    public CalendarNavigatorItem currentItem() {
    if (itemCounter == -1) itemCounter++;
        return items[itemCounter];
    }

    public CalendarNavigatorItem currentItem(int type) {
        switch(type) {
            case CalendarNavigator.ITEM:
                return currentItem(); 
            case CalendarNavigator.YEAR:
                return years[yearCounter];
            default:
                throw new IllegalArgumentException("Type is incorrect: "+type);
        }
    }
    
    public synchronized void addControlListener(ControlListener l) {
        listeners.addElement(l);
    }

    public synchronized void removeControlListener(ControlListener l) {
        listeners.removeElement(l);
    }

    public void fireBeforeShowEvent(Event e) {
        Vector v;
        this.setAttributes(this);
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((ControlListener) v.elementAt(i)).beforeShow(e);
        }
    }
    
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public CalendarNavigatorItem[] getYears() {
        return years;
    }
    public void setYears(CalendarNavigatorItem[] years) {
        this.years = years;
    }
}

//End CalendarNavigator class

