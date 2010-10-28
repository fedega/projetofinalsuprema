//Calendar component @0-CDC3C053
/*
 * $Revision: 1.3 $
 * $Date: 2005/05/04 05:39:17 $ 
 */
package com.codecharge.components;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Vector;

import com.codecharge.components.calendar.CalendarItem;
import com.codecharge.events.CalendarListener;
import com.codecharge.events.ComponentListener;
import com.codecharge.events.DataObjectEvent;
import com.codecharge.events.DataObjectListener;
import com.codecharge.events.Event;
import com.codecharge.util.Permission;
import com.codecharge.util.StringUtils;
import com.codecharge.util.ModelAttribute;

public class Calendar extends Component {
    
    public final static String CALENDAR_MAIN_SECTION = "Main";
    public final static String CALENDAR_MONTH_SECTION = "Month";
    public final static String CALENDAR_WEEK_SECTION = "Week";
    public final static String CALENDAR_WEEKDAYS_SECTION = "WeekDays";
    public final static String CALENDAR_DAY_SECTION = "Day";
    public final static String CALENDAR_EVENT_SECTION = "Event";
    public final static String CALENDAR_EMPTY_DAY_SECTION = "EmptyDay";

    /**
     * Indicates that Calendar must show a quarter
     */
    public final static int CALENDAR_MONTHS_QUARTER = -3;

    /**
     * Indicates that Calendar must show a year
     */
    public final static int CALENDAR_MONTHS_YEAR = 12;

    /**
     * Indicates that Calendar must show three months
     */
    public final static int CALENDAR_MONTHS_THREE = 3;

    /**
     * Indicates that Calendar must show a month
     */
    public final static int CALENDAR_MONTHS_ONE = 1;
    
    /**
     * Static array to get the starting month number in the quarter by current month number.
     */
    public final static int[][] QUATER_START_MONTH_BY_MONTH = 
            new int[][] {
                {0,1,2},{0,1,2},{0,1,2}, 
                {3,4,5},{3,4,5},{3,4,5}, 
                {6,7,8},{6,7,8},{6,7,8}, 
                {9,10,11},{9,10,11},{9,10,11}
            };

    public final static int WEEK_DAY_FORMAT_FULL = 1;
    public final static int WEEK_DAY_FORMAT_SHORT = 2;
    public final static int WEEK_DAY_FORMAT_NARROW = 3;
    
    /**
     * This list contains list of control names that should be bound to some special value.
     * NOTE: if sourceType will be set or changed after initialization this collection
     * will not be changed.
     */
    private ArrayList specialControlNames = new ArrayList();
    
    /**
     * This map keeps information about control belonging to specific part of calendar.
     * This map is used for internal framework purposes.
     */
    private HashMap sectionControls = new HashMap(); 
    
    private HashMap controlSection = new HashMap();
    
    /**
     * Hierarchy of Calendar data.
     */
    private CalendarItem data;

    /**
     * Map that contains all output parameters if stored procedure is used as
     * DataSource. this field is used with JSP only.
     */
    private HashMap outParams;

    /**
     * Number of months shown
     */
    private int months;

    /**
     * Field name that points to the event's date. This field is required if
     * datasource is defined and allows to link calendar days with events.
     */
    private String dateField;

    /**
     * Represent DB format for dateField if date was kept in DB as non-Data
     * (e.g. as String)
     */
    private String dateFieldDbFormatPattern;

    /**
     * Field name that points to the events' time. If null the calendar will get
     * event's time from dateField field.
     */
    private String timeField;

    /**
     * Represent DB format for timeField if time was kept in DB as non-Data
     * (e.g. as String)
     */
    private String timeFieldDbFormatPattern;

    /**
     * Number of months per line for year & quarter calendars. If monthsInRows ==
     * 0 all months will be shown in one line.
     */
    private int monthsInRow;

    /**
     * Map that contains styles to represent days of months, weeks and so on.
     */
    private Map visualStyles;

    /**
     * Style for showing the names of weekdays. Possible values are defined by
     * constants Calendar.WEEK_DAY_FORMAT_XXXX
     */
    private int weekDayFormat;

    /**
     * Date of begining calendar. It points to first day of first shown month.
     */
    private Date startDate;
    
    /**
     * Today's date.
     * Can be reassigned if necessary.
     */
    private Date currentDate;
    
    /**
     * Date that is processed now to be used in events.
     */
    private Date currentProcessingDate;
    
    /**
     * Ending date of the calendar. It points to the first day of the next month after the last month shown.
     */
    private Date endDate;
    
    private Date baseDate;
    
    /**
     * Array (size = 2) that specifies years/months to be shown. If array data is present the month and year fields are
     * ignored. The first element represents year, the second one - the month number.
     */
    private int[] date;
    
    /**
     * Month number to be shown. If not defined the current month is used.
     */
    private int month;
    
    /**
     * Year to be shown. If not defined the current year is used.
     */
    private int year;
    
    /**
     * Calendar time zone
     */
    private TimeZone timeZone;
    
    /**
     * Indicates if days or other months should be shown
     */
    private boolean showOtherMonthsDays;


     /**
      * Indicate if event caption should be shown
      */
    private boolean showEventCaption;

    
    private java.util.Calendar calendar;

    private CalendarItem currentItem;

    private ArrayList weekdays;
    
    /**
     * Indicates calendar mode. If true - calendar is in view mode.
     */
    private boolean showMode;
    
    private CalendarItem currentYear;
    private CalendarItem currentMonth;
    private CalendarItem currentDay;

    private String currentStyle;


    private HashMap groupAttributes = new HashMap();


    public HashMap getGroupAttributes (String groupName) {
        HashMap res = (HashMap) groupAttributes.get(groupName);
        if (res == null) {
            res = new HashMap();
            groupAttributes.put(groupName, res);
        }
        return res;
    }

    public void addGroupAttribute(String groupName, ModelAttribute attr) {
        HashMap res = (HashMap) groupAttributes.get(groupName);
        if (res == null) {
            res = new HashMap();
            groupAttributes.put(groupName, res);
        }
        res.put(attr.getName(), attr);
    }

    public HashMap getAllAttributesGroups () {
        return groupAttributes;
    }


    public void setCurrentStyle (String style) {
        this.currentStyle = style;
    }

    public String getCurrentStyle () {
        return currentStyle;
    }

   
    public Calendar(String name) {
        super(name);
        this.currentDate = new Date();
        this.weekDayFormat = Calendar.WEEK_DAY_FORMAT_NARROW;
        this.date = new int[2];
        this.date[0] = -1;
        this.date[1] = -1;
        this.visualStyles = new HashMap();
        error = new StringBuffer();
        this.addExcludeParam("ccsForm");
        this.weekdays = new ArrayList();
    }

    public boolean hasReadPermission(int groupId) {
        if (permissions == null) {
            return true;
        } else {
            return permissions.checkPermissions(groupId, Permission.ALLOW_READ);
        }
    }

    /** Add element to the Children collection.
     * @param m element to add
     */
    public void add(Model m) {
        super.add(m);
        if (m instanceof Control) {
            specialControlNames.add(((Control) m).getName());
        }
    }

    public void initializeRows() {
        if (data == null) {
            throw new IllegalStateException();
        }
        data.iteratorInit();
        currentItem = null;
        currentYear = null;
        currentMonth = null;
        currentDay = null;
        showMode = true; 
    }

    //public CalendarItem getCalendarYear() {
    //    return this.currentYear;
    //}
    
    public String getDateField() {
        return dateField;
    }
    public void setDateField(String dateField) {
        this.dateField = dateField;
    }
    
    /**
     * Indicates if next calendar item is available.
     * This method can be used in view mode only.
     */
    public boolean hasNextItem() {
        if (data != null && currentItem == null) {
            currentItem = data.nextItem();
            currentYear = currentItem;
        } else if (data == null) {
            return false;
        }
        if (currentItem == currentYear) {
            return currentItem.hasNextItem();
        } else if (currentItem == currentMonth) {
            if (! currentMonth.hasNextItem()) {
                currentItem = currentYear;
                return hasNextItem();
            }
        } else if (currentItem == currentDay) {
            if (! currentDay.hasNextItem()) {
                currentItem = currentMonth;
                return hasNextItem();
            }
        } else { //events
            if (currentDay == null) {
                return false;
            }
            if (! currentDay.hasNextItem()) {
                currentItem = currentMonth;
                return hasNextItem();
            }
        }
        return true;
    }
    
    /**
     * Returns next calendar item if it is available.
     * This method can be used in view mode only.
     */
    public CalendarItem nextItem() {
        if (data == null) {
            throw new IllegalStateException();
        }
        if (currentItem == currentYear) {
            currentItem = currentItem.nextItem();
            currentMonth = currentItem;
        } else if (currentItem == currentMonth) {
            currentItem = currentItem.nextItem();
            currentDay = currentItem;
        } else if (currentItem == currentDay) {
            currentItem = currentItem.nextItem();
            //this.nextAttrRow();
        } else { //events
            currentItem = currentDay.nextItem();
            //this.nextAttrRow();
        }
        currentProcessingDate = currentItem.getDate();
        return currentItem;
    }
    
    public int getItemWeekday(CalendarItem item) {
        java.util.Calendar cal = java.util.Calendar.getInstance(getTimeZone(), pageModel.getLocale());
        cal.setTime(item.getDate());
        return cal.get(java.util.Calendar.DAY_OF_WEEK);
    }
    
    /**
     * Get number of months shown
     */
    public int getMonths() {
        return months;
    }
    /**
     * Set number of months shown
     */
    public void setMonths(int months) {
        this.months = months;
    }


    public boolean getShowEventCaption() {
        return this.showEventCaption;
    }

    public void setShowEventCaption(boolean showEventCaption) {
        this.showEventCaption = showEventCaption;
    }

    public int getMonthsInRow() {
        return Math.min(monthsInRow, Math.abs(this.months));
    }
    public void setMonthsInRow(int monthsInRow) {
        this.monthsInRow = monthsInRow;
    }
    
    public String getTimeField() {
        return timeField;
    }
    public void setTimeField(String timeField) {
        this.timeField = timeField;
    }
    
    public Map getVisualStyles() {
        return visualStyles;
    }
    public void setVisualStyles(Map visualStyles) {
        if (visualStyles == null) {
            this.visualStyles = new HashMap();
        } else {
            this.visualStyles = visualStyles;
        }
    }
    
    public String getVisualStyle(String name) {
        return (String) visualStyles.get(name);
    }
    
    public void setVisualStyle(String name, String value) {
        visualStyles.put(name, value);
    }
    
    public int getWeekDayFormat() {
        return weekDayFormat;
    }
    public void setWeekDayFormat(int weekDayFormat) {
        this.weekDayFormat = weekDayFormat;
    }
    public void setWeekDayFormat(String weekDayFormat) {
        if ("Full".equalsIgnoreCase(weekDayFormat)) {
            this.weekDayFormat = Calendar.WEEK_DAY_FORMAT_FULL;
        } else if ("Short".equalsIgnoreCase(weekDayFormat)) {
            this.weekDayFormat = Calendar.WEEK_DAY_FORMAT_SHORT;
        } else if ("Narrow".equalsIgnoreCase(weekDayFormat)) {
            this.weekDayFormat = Calendar.WEEK_DAY_FORMAT_NARROW;
        }
    }
    
    public String getDateFieldDbFormatPattern() {
        return dateFieldDbFormatPattern;
    }
    public void setDateFieldDbFormatPattern(String dateFieldDbFormatPattern) {
        this.dateFieldDbFormatPattern = dateFieldDbFormatPattern;
    }
    
    public String getTimeFieldDbFormatPattern() {
        return timeFieldDbFormatPattern;
    }
    public void setTimeFieldDbFormatPattern(String timeFieldDbFormatPattern) {
        this.timeFieldDbFormatPattern = timeFieldDbFormatPattern;
    }
    
    public Date getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    public Collection getSpecialControlNames() {
        return Collections.unmodifiableCollection(this.specialControlNames);
    }
    
    public Date getCurrentProcessingDate() {
        return currentProcessingDate;
    }
    public void setCurrentProcessingDate(Date currentProcessingDate) {
        this.currentProcessingDate = currentProcessingDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getCorrectedStartDate() {
        Date d = new Date ( getStartDate().getTime() );


        if ( (!getShowEventCaption()) || isShowOtherMonthsDays() ) {

            java.util.Calendar c = java.util.Calendar.getInstance(this.getTimeZone(), this.getPageModel().getLocale()   );
            c.setTime(d);
            int dw = c.get( java.util.Calendar.DAY_OF_WEEK );
            c.add( java.util.Calendar.DAY_OF_YEAR, -1*(dw-1) );

            c.set(java.util.Calendar.SECOND, 0);
            c.set(java.util.Calendar.MINUTE, 0);
            c.set(java.util.Calendar.HOUR_OF_DAY, 0);

            d=c.getTime();
        }

        return d;
    }
    public Date getCorrectedEndDate() {
        Date d = new Date ( getEndDate().getTime() );

        if ( (!getShowEventCaption()) || isShowOtherMonthsDays() ) {

            java.util.Calendar c = java.util.Calendar.getInstance(this.getTimeZone(), this.getPageModel().getLocale()  );
            c.setTime(d);
            c.add(c.DAY_OF_YEAR, -1);

            int count = Math.abs(month);
            int inRow = monthsInRow;
                        
            int rCount = (count % inRow);
            if (rCount == 0) rCount = inRow;
        
            int wCount = 0;
            int dm = c.get(java.util.Calendar.DAY_OF_MONTH);

            for (int i = 0; i < rCount; i++) {
                wCount = Math.max(wCount, c.getActualMaximum(java.util.Calendar.WEEK_OF_MONTH) );
                c.add(java.util.Calendar.MONTH,-1);
            }

            c.add(java.util.Calendar.MONTH, rCount);
            c.set(java.util.Calendar.DAY_OF_MONTH, dm);
        
            int actAdd = wCount - c.getActualMaximum(java.util.Calendar.WEEK_OF_MONTH);

            if ( isShowOtherMonthsDays() && getShowEventCaption() ) {} else {
                c.add(c.WEEK_OF_YEAR, actAdd);
            }
        
            int a = c.getActualMaximum(java.util.Calendar.DAY_OF_WEEK);
            a = a - c.get(java.util.Calendar.DAY_OF_WEEK);

        
            c.add(java.util.Calendar.DAY_OF_YEAR, a);
       
        
            c.set(java.util.Calendar.SECOND, 59);
            c.set(java.util.Calendar.MINUTE, 59);
            c.set(java.util.Calendar.HOUR_OF_DAY, 23);
        
        
            d=c.getTime();
        }

        return d;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
    
    public int[] getDate() {
        return date;
    }

    private boolean dateIsSet = false;
    public void setDate(String date) {
        if (! StringUtils.isEmpty(date)) {
            Format fmtDate = this.pageModel.getCCSLocale().getDateFormat("yyyy-MM");
            Format numYear = this.pageModel.getCCSLocale().getLongFormat("0000");
            Format numMonth = this.pageModel.getCCSLocale().getLongFormat("00");
            if (fmtDate != null) {
                Date dDate = this.currentDate;
                if (dDate == null) {
                    dDate = new Date();
                }
                this.calendar.setTime(dDate);
                int day = this.calendar.get(java.util.Calendar.DATE);
                try {
                    dDate = (Date) fmtDate.parseObject(date);
                } catch (ParseException pe_ignore) {
                    // use today date
                } catch (ClassCastException cce_ignore) {
                    // use today date
                }
                String checkDate = fmtDate.format(dDate);
                boolean yearIsValid = false;
                boolean monthIsValid = false;
                int parsedYear = -1;
                int parsedMonth = -1;
                if (! date.equals(checkDate)) {
                    int pos = date.indexOf("-");
                    if (pos == 4 ) {
                        try {
                            parsedYear = Integer.parseInt(date.substring(0, 4));
                            yearIsValid = true;
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    if (date.length() > pos) {
                        try {
                            parsedMonth = Integer.parseInt(date.substring(pos+1));
                            if (0 < parsedMonth && parsedMonth < 13) {
                                monthIsValid = true;
                            }
                        } catch (NumberFormatException nfe) {
                        }
                    }
                } else {
                    yearIsValid = true;
                    monthIsValid = true;
                }
                if (yearIsValid && monthIsValid) {
                    this.calendar.setTime(dDate);
                } else if (yearIsValid) {
                    this.calendar.set(java.util.Calendar.YEAR, parsedYear);
                } else if (monthIsValid) {
                    this.calendar.set(java.util.Calendar.MONTH, parsedMonth-1);
                } else {
                    this.calendar.setTime(this.currentDate);
                }
                this.date[0] = this.calendar.get(java.util.Calendar.YEAR);
                this.date[1] = this.calendar.get(java.util.Calendar.MONTH);
                this.year = this.date[0];
                this.month = this.date[1];
                dateIsSet = true;
                finishInitialization();
            } else {
                throw new IllegalStateException("Unable to get date format. Application is not initialized properly"); // TODO: i18n
            }
        }
    }
    
    public void setDate(int year, int month, int day) {
        setDateInternal(year, month, day);
        finishInitialization();
    }
    
    private void setDateInternal(int year, int month, int day) {
        this.calendar.set(year, month-1, day);
        this.currentDate = this.calendar.getTime();
        this.year = this.calendar.get(java.util.Calendar.YEAR);
        this.month = this.calendar.get(java.util.Calendar.MONTH);
        this.date[0] = this.year;
        this.date[1] = this.month;
    }
    
    public int getMonth() {
        return month;
    }
    
    public void setMonth(String month) {
        if (! this.dateIsSet) {
        if (! StringUtils.isEmpty(month)) {
            int parsedMonth = -1;
            try {
                parsedMonth = Integer.parseInt(month);
                if (0 > parsedMonth && parsedMonth > 13) {
                    parsedMonth = -1;
                }
            } catch (NumberFormatException nfe) {
            }
            Date dDate = this.currentDate;
            if (dDate == null) {
                dDate = new Date();
            }
            this.calendar.setTime(dDate);
            if (this.year == -1) {
                this.year = this.calendar.get(java.util.Calendar.YEAR);
            }
            this.date[0] = this.year;
            int day = this.calendar.get(java.util.Calendar.DATE);
            if (parsedMonth > 0 && parsedMonth < 13) {
                this.month = parsedMonth-1;
            } else {
                this.month = this.calendar.get(java.util.Calendar.MONTH);
            }
            this.date[1] = this.month;
            finishInitialization();
        }
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(String year) {
        if (! this.dateIsSet) {
        if (! StringUtils.isEmpty(year) && this.date != null) {
            int parsedYear = -1;
            Format numYear = this.pageModel.getCCSLocale().getLongFormat("0000");
            try {
                Number nYear = (Number) numYear.parseObject(year);
                if (nYear != null) {
                    parsedYear = nYear.intValue();
                }
            } catch (ParseException pe) {
            }
            Date dDate = this.currentDate;
            if (dDate == null) {
                dDate = new Date();
            }
            this.calendar.setTime(dDate);
            if (this.month == -1) {
                this.month = this.calendar.get(java.util.Calendar.MONTH);
            }
            this.date[1] = this.month;
            int day = this.calendar.get(java.util.Calendar.DATE);
            if (parsedYear > -1) {
                this.year = parsedYear;
            } else {
                this.year = this.calendar.get(java.util.Calendar.YEAR);
            }
            this.date[0] = this.year;
            finishInitialization();
        }
        }
    }
    private void finishInitialization() {
        if (this.timeZone == null) {
            this.timeZone = TimeZone.getDefault();
        }
        this.calendar = java.util.Calendar.getInstance(this.timeZone, pageModel.getLocale());
        if (this.currentDate == null) {
            this.currentDate = new Date();
            this.calendar.setTime(this.currentDate);
            if (this.year == 0) {
                this.year = this.calendar.get(java.util.Calendar.YEAR);
            }
            if (this.month == 0) {
                this.month = this.calendar.get(java.util.Calendar.MONTH);
            }
            int day = this.calendar.get(java.util.Calendar.DATE);
            setDateInternal(this.year, this.month, day);
        }
        this.calendar.setTime(this.currentDate);
        if (months >= 0) {
            this.baseDate = calcBaseDate();
            int startMonth = getStartMonth(baseDate);
            int startYear = getStartYear(baseDate);
            if (startMonth == -1) {
                this.calendar.setTime(this.currentDate);
                this.month = this.calendar.get(java.util.Calendar.MONTH);
                this.year = this.calendar.get(java.util.Calendar.YEAR);
                this.calendar.set(this.year, this.month, 1);
                this.baseDate = this.calendar.getTime();
                startMonth = getStartMonth(baseDate);
                startYear = getStartYear(baseDate);
            }
            this.calendar.set(startYear, startMonth, 1);
            this.startDate = this.calendar.getTime();
            int endMonth = startMonth + this.months; // point to the first non-shown month
            int endYear = startYear;
            if (endMonth > 12) {
                endMonth -= 12;
                endYear++;
            }
            this.calendar.set(endYear, endMonth, 1);
            this.endDate = this.calendar.getTime();
        } else {
            this.baseDate = calcBaseDate();
            int startMonth = getStartMonth(baseDate);
            int startYear = getStartYear(baseDate);
            if (startMonth == -1) {
                this.baseDate = this.currentDate;
                startMonth = getStartMonth(baseDate);
                startYear = getStartYear(baseDate);
            }
            this.calendar.set(startYear, startMonth, 1);
            this.startDate = this.calendar.getTime();
            int endMonth = startMonth - this.months; // point to the first non-shown month
            int endYear = startYear;
            if (endMonth > 12) {
                endMonth -= 12;
                endYear++;
            }
            this.calendar.set(endYear, endMonth, 1);
            this.endDate = this.calendar.getTime();
        }
    }
    
    /** 
     * Calculates base calendar date based on the properties: date, year, month.
     * @return
     */
    private Date calcBaseDate() {
        if (this.date[0] != -1) {
            this.calendar.set(this.date[0], this.date[1], 1);
            return this.calendar.getTime();
        }
        this.calendar.setTime(this.currentDate);
        if (this.month == 0) {
            this.month = this.calendar.get(java.util.Calendar.MONTH);
        }
        if (this.year == 0) {
            this.year = this.calendar.get(java.util.Calendar.YEAR);
        }
        this.calendar.set(this.year, this.month, 1);
        return this.calendar.getTime();
    }
    
    /**
     * Calculates the starting month based on
     * @return
     */
    private int getStartMonth(Date baseDate) {
        this.calendar.setTime(baseDate);
        switch (this.months) {
            case Calendar.CALENDAR_MONTHS_QUARTER:
                return Calendar.QUATER_START_MONTH_BY_MONTH[this.calendar.get(java.util.Calendar.MONTH)][0];
            case 12:
                return 0; // first month for year calendar
            case 3:
                int start = this.month - 1;
                if (start < 1) start += 12;
                return start;
            case 1: 
                return this.month;
        }
        return -1;
    }
    
    private int getStartYear(Date baseDate) {
        this.calendar.setTime(baseDate);
        switch (this.months) {
            case 3:
                int start = this.month - 1;
                if (start < 1) 
                    return (this.year - 1);
        }
        return this.year;
    }
    
    public void addControlToSection(String controlName, String sectionName) {
        ArrayList controls = (ArrayList) this.sectionControls.get(sectionName);
        if (controls == null) {
            controls = new ArrayList();
            this.sectionControls.put(sectionName, controls);
        }
        controls.add(controlName);
        controlSection.put(controlName, sectionName);
    }
    
    public Collection getSectionControlNames(String sectionName) {
        ArrayList controls = (ArrayList) this.sectionControls.get(sectionName);
        if (controls == null) {
            controls = new ArrayList();
        }
        return controls;
    }
    
    public String getSectionName(String controlName) {
        return (String) controlSection.get(controlName);
    }
    
    /**
     * Returns style string for given calendar section.
     * 
     * @param sectionName - name of section for that style should be returned. The allowed values are: Month, Weekdays, Day
     * @param dayOfWeek - day of week to get style for weekdays. This parameter is used only if sectionName="WeekDays"
     */
    public String getStyle(String sectionName, int dayOfWeek, CalendarItem month) {
        String result = "";
        if (currentItem == null || StringUtils.isEmpty(sectionName)) {
            return result;
        }
        java.util.Calendar cal = java.util.Calendar.getInstance(getTimeZone(), getPageModel().getLocale());
        cal.setTime(month.getDate());
        int monthToShow = cal.get(java.util.Calendar.MONTH);
        int yearToShow = cal.get(java.util.Calendar.YEAR);

        cal.setTime(getCurrentDate());
        int currentMonth = cal.get(java.util.Calendar.MONTH);
        int currentDay = cal.get(java.util.Calendar.DAY_OF_MONTH);
        int currentDayWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int currentYear = cal.get(java.util.Calendar.YEAR);
        cal.setTime(getBaseDate());
        int baseMonth = cal.get(java.util.Calendar.MONTH);
        int baseYear = cal.get(java.util.Calendar.YEAR);
        if ("WeekDays".equalsIgnoreCase(sectionName)) {
            if (isWeekend(dayOfWeek)) {
                result = getVisualStyle("WeekendName");
            } else {
                result = getVisualStyle("WeekdayName");
            }
        } else if ("Day".equalsIgnoreCase(sectionName)) {
            cal.setTime(currentItem.getDate());
            if (monthToShow == cal.get(java.util.Calendar.MONTH) && baseYear == cal.get(java.util.Calendar.YEAR)) {
                if (isTodayNumber(currentYear, currentMonth, currentDay, currentItem.getDate(), cal) 
                        && isWeekend(cal.get(java.util.Calendar.DAY_OF_WEEK))) {
                    result = getVisualStyle("WeekendToday");
                } else if (isTodayNumber(currentYear, currentMonth, currentDay, currentItem.getDate(), cal)) {
                    result = getVisualStyle("Today");
                } else if (isWeekend(cal.get(java.util.Calendar.DAY_OF_WEEK))) {
                    result = getVisualStyle("Weekend");
                } else {
                    result = getVisualStyle("Day");
                }
            } else {
                if (isTodayNumber(currentYear, currentMonth, currentDay, currentItem.getDate(), cal) 
                        && isWeekend(cal.get(java.util.Calendar.DAY_OF_WEEK))) {
                    result = getVisualStyle("OtherMonthWeekendToday");
                } else if (isTodayNumber(currentYear, currentMonth, currentDay, currentItem.getDate(), cal)) {
                    result = getVisualStyle("OtherMonthToday");
                } else if (isWeekend(cal.get(java.util.Calendar.DAY_OF_WEEK))) {
                    result = getVisualStyle("OtherMonthWeekend");
                } else {
                    result = getVisualStyle("OtherMonthDay");
                }
            }
        } else if ("EmptyDay".equalsIgnoreCase(sectionName)) {
            cal.setTime(currentItem.getDate());
            if (isWeekend(cal.get(java.util.Calendar.DAY_OF_WEEK))) {
                result = getVisualStyle("OtherMonthWeekend");
            } else {
                result = getVisualStyle("OtherMonthDay");
            }
        }
        return result;
    }
    
    private boolean isWeekend (int dayOfWeek) {
        if (dayOfWeek == java.util.Calendar.SUNDAY || dayOfWeek == java.util.Calendar.SATURDAY) {
            return true;
        }
        return false;
    }
    
    private boolean isTodayNumber(int currentYear, int currentMonth, int curDay, Date date, java.util.Calendar cal) {
        cal.setTime(date);
        return (cal.get(java.util.Calendar.DATE) == curDay
                && cal.get(java.util.Calendar.MONTH) == currentMonth
                && cal.get(java.util.Calendar.YEAR) == currentYear
                );
    }
    
    public String[] getWeekdays() {
        String[] weekdays = null;
        switch (getWeekDayFormat()) {
            case Calendar.WEEK_DAY_FORMAT_FULL:
                weekdays = getPageModel().getCCSLocale().getWeekdays();
                break;
            case Calendar.WEEK_DAY_FORMAT_SHORT:
                weekdays = getPageModel().getCCSLocale().getShortWeekdays();
                break;
            case Calendar.WEEK_DAY_FORMAT_NARROW:
                weekdays = getPageModel().getCCSLocale().getNarrowWeekdays();
                break;
        }
        return weekdays;
    }
    
    public CalendarNavigator getNavigator(String name) {
        Model m = getChild(name);
        if (m instanceof CalendarNavigator) {
            return (CalendarNavigator) m;
        }
        //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
        MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
        throw new NoSuchComponentException(fmt.format(new String[] {getName(), "Navigator", name} ));
    }

    public void addWeekday(CalendarItem weekday) {
        if (weekday != null) {
            
        }
    }
    
    public synchronized void addCalendarListener(CalendarListener l) {
        listeners.addElement(l);
    }

    public synchronized void removeCalendarListener(CalendarListener l) {
        listeners.removeElement(l);
    }

    /**
     * Overridden method is needed to finish Calendar initialization:
     *  - to calculate start and end dates
     * 
     * @see com.codecharge.components.Component#fireAfterInitializeEvent()
     */
    public void fireAfterInitializeEvent() {
        finishInitialization();
        Vector v;
        Event e = new Event(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((ComponentListener) v.elementAt(i)).afterInitialize(e);
        }
    }
    
    public void fireBeforeShowEvent(Event e) {
        Vector v;
        this.setAttributes(this);
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((CalendarListener) v.elementAt(i)).beforeShow(e);
        }
    }
    
    public void fireBeforeShowMonthEvent(Event e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((CalendarListener) v.elementAt(i)).beforeShowMonth(e);
        }
    }
    
    public void fireBeforeShowWeekEvent(Event e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((CalendarListener) v.elementAt(i)).beforeShowWeek(e);
        }
    }
    
    public void fireBeforeShowDayEvent(Event e) {

        if ( isShowDay (currentDay) ) {
            currentStyle = getStyle("Day", 0, currentMonth);
        } else {
            currentStyle = getStyle("EmptyDay", 0, currentMonth);
        }


        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((CalendarListener) v.elementAt(i)).beforeShowDay(e);
        }
    }
    
    public void fireBeforeShowEventEvent(Event e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((CalendarListener) v.elementAt(i)).beforeShowEvent(e);
        }
    }

    public void fireBeforeSelectEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((CalendarListener) v.elementAt(i)).beforeSelect(e);
        }
    }

    //  DataSource Events
    public void fireBeforeBuildSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((DataObjectListener) v.elementAt(i)).beforeBuildSelect(e);
        }
    }
    public void fireBeforeExecuteSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((DataObjectListener) v.elementAt(i)).beforeExecuteSelect(e);
        }
    }
    public void fireAfterExecuteSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        for (int i = 0; i < v.size(); i++) {
            ((DataObjectListener) v.elementAt(i)).afterExecuteSelect(e);
        }
    }
    public void setData(CalendarItem data) {
        this.data = data;
    }
    public boolean isShowOtherMonthsDays() {
        return showOtherMonthsDays;
    }
    public void setShowOtherMonthsDays(boolean showOtherMonthsDays) {
        this.showOtherMonthsDays = showOtherMonthsDays;
    }
    public Date getBaseDate() {
        return baseDate;
    }
    public CalendarItem getCurrentItem() {
        return currentItem;
    }
    public void setCurrentItem(CalendarItem currentItem) {


        if (currentItem.getType() == CalendarItem.MONTH) {
            currentMonth = currentItem;
        } else if (currentItem.getType() == CalendarItem.DAY) {
            currentDay = currentItem;
            currentProcessingDate = currentItem.getDate();
        } 


        this.currentItem = currentItem;
    }

    /**
     * Find Child in children collection by name.
     * 
     * @param name Child name
     * @return the Child of the given name or NoSuchComponentException if no such Child exists
     */
    public Model getChild(String name) {
        Model m = null;
        if (showMode && currentItem != null) {
            m = currentItem.getModel(name);
        }
        if (childRow != null) {
            m = (Model) childRow.get(name);
        }
        if (m == null) {
            m = (Model) children.get(name);
        }
        if (m == null) {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "child", name} ));
        }
        return m;
    }




    public Object getRowKey () {
        if (currentItem==null) return null;
        return ""+currentItem.hashCode();
    }



//-------------------------------------------------------------------------------------
    private boolean isShowDay(CalendarItem day) {
        if (day == null) {
            return false;
        }
        boolean result = true;
        java.util.Calendar cal = java.util.Calendar.getInstance(getTimeZone(), getPageModel().getLocale());
        CalendarItem month = currentMonth;
        cal.setTime(month.getDate());
        int monthToShow = cal.get(java.util.Calendar.MONTH);
        int yearToShow = cal.get(java.util.Calendar.YEAR);
        cal.setTime(day.getDate());
        if (day.getType() == CalendarItem.DAY && monthToShow != cal.get(java.util.Calendar.MONTH) && ! isShowOtherMonthsDays()) {
            result = false;
        }
        return result;
    }
//-------------------------------------------------------------------------------------



}



//End Calendar component

