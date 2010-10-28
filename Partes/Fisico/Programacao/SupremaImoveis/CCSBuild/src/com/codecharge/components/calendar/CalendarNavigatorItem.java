//CalendarNavigatorItem class @0-2DD656C4
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.components.calendar;

import com.codecharge.util.StringUtils;


public class CalendarNavigatorItem {
    private int year;
    private int month;
    private int quarter;
    private String name;
    private String shortName;
    private boolean selected;
    
    public CalendarNavigatorItem(int year, int quarter, int month, String name, String shortName) {
        this.month = month;
        this.year = year;
        this.quarter = quarter;
        if (StringUtils.isEmpty(name)) {
            this.name = String.valueOf(month);
        } else {
            this.name = name;
        }
        if (StringUtils.isEmpty(shortName)) {
            this.shortName = String.valueOf(month);
        } else {
            this.shortName = shortName;
        }
        this.selected = false;
    }
    
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public String getName() {
        return name;
    }
    public int getMonth() {
        return month;
    }
    public String getShortName() {
        return shortName;
    }
    public int getYear() {
        return year;
    }
    public int getQuarter() {
        return quarter;
    }
    public void setQuarter(int quater) {
        this.quarter = quater;
    }
}

//End CalendarNavigatorItem class

