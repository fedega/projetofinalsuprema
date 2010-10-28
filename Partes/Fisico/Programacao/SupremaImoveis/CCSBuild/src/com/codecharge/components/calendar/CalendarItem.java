//CalendarItem class @0-FBB113B1
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
 * This class represents one of calendar items.
 * All objects (years, months, days, events) in calendar components are CalendarItem.
 * All CalendarItems form hierarchy structure.
 */
public class CalendarItem {
    
    final public static int DATA = 1;
    final public static int CALENDAR = 2;
    final public static int MONTH = 3;
    final public static int DAY = 4;
    final public static int EVENT = 5;
    
    protected List items;
    protected Date date;
    protected Date nextDate;
    protected Date previousDate;
    protected int type;
    protected int counter;
    protected HashMap controls;
    
    public CalendarItem(Date date) {
        this(date, CalendarItem.DAY);
    }
    public CalendarItem(Date date, int type) {
        setDate(date);
        this.counter = -1;
        this.items = new ArrayList();
        this.controls = new HashMap();
        this.type = type;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Argument 'date' cannot be null.");
        }
        this.date = date;
    }
    
    public Model addModel(Model m) {
        this.controls.put(m.getName(), m);
        return m;
    }
    
    public void addAllModels(CalendarItem item) {
        this.controls.putAll(item.controls);
    }
    
    public Model getModel(String name) {
        return (Model) this.controls.get(name);
    }
    
    public CalendarItem add(CalendarItem item) {
        this.items.add(item);
        counter++;
        return item;
    }
    
    public CalendarItem remove(CalendarItem item) {
        this.items.remove(item);
        counter--;
        return item;
    }

    public void iteratorInit() {
        counter = 0;
        for (int i = 0; i < items.size(); i++) {
            ((CalendarItem) items.get(i)).iteratorInit();
        }
    }
    
    public boolean hasNextItem() {
        return ((counter > 0) && (counter < items.size()) || (counter == 0 && items.size() > 0));
    }
    
    public CalendarItem currentItem() {
        if (counter < 0) {
            throw new IllegalStateException();
        }
        return (CalendarItem) items.get(counter);
    }
    
    public CalendarItem nextItem() {
        if (! hasNextItem()) {
            throw new NoSuchElementException();
        }

        //(if currentItem().getType() == EVENT) 

        CalendarItem result = currentItem(); 
        counter++;
        return result;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof CalendarItem)) {
            return false;
        }
        return this.date.equals(((CalendarItem) obj).date);
    }
    public int hashCode() {
        return this.date.hashCode();
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("\ntype: ");
        switch (type) {
            case CalendarItem.DATA:
                sb.append("CalendarItem.DATA");
                break;
            case CalendarItem.CALENDAR:
                sb.append("CalendarItem.CALENDAR");
                break;
            case CalendarItem.MONTH:
                sb.append("CalendarItem.MONTH");
                break;
            case CalendarItem.DAY:
                sb.append("CalendarItem.DAY");
                break;
            case CalendarItem.EVENT:
                sb.append("CalendarItem.EVENT");
                break;
        }
        sb.append(" date: "+date+" prevDate: "+previousDate+" nextDate: "+nextDate+" items.size(): "+items.size());
        if (type == CalendarItem.MONTH && items.size() > 0) {
            sb.append(" begin: "+((CalendarItem) items.get(0)).getDate()+" end: "+((CalendarItem) items.get(items.size()-1)).getDate());
        }
        return sb.toString();
    }
    public Date getNextDate() {
        return nextDate;
    }
    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }
    public Date getPreviousDate() {
        return previousDate;
    }
    public void setPreviousDate(Date previousDate) {
        this.previousDate = previousDate;
    }
    public int getType() {
        return type;
    }
}

//End CalendarItem class

