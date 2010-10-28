//CalendarAction class @0-4D0887ED
/*
 * $Revision: 1.3 $
 * $Date: 2005/05/04 05:41:11 $
 */
package com.codecharge.components.action;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.codecharge.Action;
import com.codecharge.components.CalendarNavigator;
import com.codecharge.components.Control;
import com.codecharge.components.Link;
import com.codecharge.components.Model;
import com.codecharge.components.calendar.CalendarComparator;
import com.codecharge.components.calendar.CalendarItem;
import com.codecharge.components.calendar.CalendarMonthItem;
import com.codecharge.components.calendar.CalendarNavigatorItem;
import com.codecharge.util.StringUtils;
import com.codecharge.util.ModelAttribute;
import com.codecharge.db.IRowProvider;


public class CalendarAction extends AbstractAction {
    boolean ldebug = false;        
    
    protected com.codecharge.components.Calendar model;
    protected java.util.Calendar calendar;
    
    private Comparator rowComparator;
    private HashMap dayItems = new HashMap();
    
    private CalendarItem calendarItem;
    private CalendarItem centerItem;

    private Object row;
    
    /**
     * This constructor is used to create CalendarAction instance in JSP pattern
     */
    public CalendarAction() {
        super();
    }
    
    /**
     * This constructor is used to create CalendarAction instance in ServletTemplates pattern
     */
    public CalendarAction(Action action) {
        super(action);
        this.rowComparator = new CalendarComparator();
        if (rowComparator instanceof CalendarComparator) {
            ((CalendarComparator) this.rowComparator).setDataBinder(this.dataBinder);
        }
    }

    public String perform(com.codecharge.components.Calendar model) {
        this.model = model;
        if (model.getName().equals(this.model.getPageModel().getParameter("ccsForm"))) {
            return getRedirectString();
        }
        action.setProperties(this.model, Action.GET);
        action.setProperties(this.model, Action.POST);
        action.setActivePermissions(this.model);
        this.calendar = java.util.Calendar.getInstance(model.getTimeZone(), model.getPageModel().getLocale());
        if (rowComparator instanceof CalendarComparator) {
            ((CalendarComparator) this.rowComparator).setCCSLocale(model.getPageModel().getCCSLocale());
            ((CalendarComparator) this.rowComparator).setDateFieldName(model.getDateField());
            ((CalendarComparator) this.rowComparator).setTimeFieldName(model.getTimeField());
            ((CalendarComparator) this.rowComparator).setDateFieldDbFormatPattern(model.getDateFieldDbFormatPattern());
            ((CalendarComparator) this.rowComparator).setTimeFieldDbFormatPattern(model.getTimeFieldDbFormatPattern());
            ((CalendarComparator) this.rowComparator).setCalendar(java.util.Calendar.getInstance(model.getTimeZone(), model.getPageModel().getLocale()));
        }
        this.rowProvider.setRowComparator(this.rowComparator);
        read();
        return null;
    }
    
    protected String getRedirectString() {
        StringBuffer preservedParameters = new StringBuffer();
        HashMap parameters = new HashMap();
        Vector getExclude = new Vector();
        getExclude.add("ccsForm");
        parameters.putAll(this.model.getPageModel().getHttpPostParams().getPreserveParameters(getExclude));
        parameters.putAll(this.model.getPageModel().getHttpGetParams().getPreserveParameters(getExclude));
        Iterator params = parameters.values().iterator();
        boolean first = true;
        while(params.hasNext()) {
            if (!first) {
                preservedParameters.append("&");
            } else {
                first = false;
            }
            preservedParameters.append(((String)params.next()));
        }
        return this.model.getPageModel().getActionPageName() + ".do" 
                + (preservedParameters.length() == 0 ? "" : "?"+preservedParameters);
    }

    protected void bindRow(com.codecharge.components.Calendar model, Object row) {
    }

    public void bind(com.codecharge.components.Calendar model, Object rows) {
        this.model = model;
        if (this.rowComparator != null && rows instanceof Object[]) {
            Arrays.sort((Object[]) rows, this.rowComparator);
        }
        rowProvider.setRows(rows);
        bind();
    }
    
    public void bind() {
        Date startMonth = model.getStartDate();
        Date endMonth = model.getEndDate();
        CalendarItem data = new CalendarItem(startMonth, CalendarItem.DATA);
        CalendarItem yearModel = new CalendarItem(model.getBaseDate(), CalendarItem.CALENDAR);
        this.calendarItem = yearModel;
        data.add(yearModel);
        this.model.setData(data);
        this.model.setCurrentItem(yearModel);
        Date currentDate = startMonth;
        yearModel.setNextDate(getNextDate(this.calendar, com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION));
        yearModel.setPreviousDate(getPrevDate(this.calendar, com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION));
        createItemControls(yearModel, com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION);
        bindControls(yearModel, com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION, null);

        Date processingMonth = startMonth;
        Date tmpDate = startMonth;

        int monthInRow = this.model.getMonthsInRow();
        int monthCount = Math.abs (this.model.getMonths());

        while (processingMonth.compareTo(endMonth) < 0) {

            int maxWeekCount = 0;
            int thisRowMonthCount = Math.min(monthInRow, monthCount);

            for (int i = 0; i < thisRowMonthCount; i++) {
                this.calendar.setTime(tmpDate);
                int currentWeekCount = this.calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
                if (currentWeekCount > maxWeekCount) maxWeekCount = currentWeekCount;
                this.calendar.add(Calendar.MONTH, 1);
                tmpDate = this.calendar.getTime();
            }

            for (int i = 0; i < thisRowMonthCount; i++) {
                this.calendar.setTime(processingMonth);
                int currentYear = this.calendar.get(Calendar.YEAR);
                bindMonth(this.calendar.get(Calendar.YEAR), 
                        this.calendar.get(Calendar.MONTH), yearModel, maxWeekCount);
                this.calendar.add(Calendar.MONTH, 1);
                processingMonth = this.calendar.getTime();
                monthCount--;
            }
        }
        handleNavigators();
    }
    
    private void bindMonth(int year, int month, CalendarItem yearModel, int maxWeekCount) {
        Calendar startDateCal = Calendar.getInstance(this.calendar.getTimeZone(), this.model.getPageModel().getLocale());
        startDateCal.set(year, month, 1, 0, 0, 0);

        int weekToAdd = maxWeekCount - startDateCal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        int numberOfDays = startDateCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        CalendarMonthItem monthModel = new CalendarMonthItem(startDateCal.getTime());
        if (year == this.model.getYear() && month == this.model.getMonth()) {
            this.centerItem = monthModel;
        }
        this.model.setCurrentItem(monthModel);
        monthModel.setNextDate(getNextDate(startDateCal, com.codecharge.components.Calendar.CALENDAR_MONTH_SECTION));
        monthModel.setPreviousDate(getPrevDate(startDateCal, com.codecharge.components.Calendar.CALENDAR_MONTH_SECTION));
        createItemControls(monthModel, com.codecharge.components.Calendar.CALENDAR_MONTH_SECTION);
        monthModel.addAllModels(yearModel);
        bindControls(monthModel, com.codecharge.components.Calendar.CALENDAR_MONTH_SECTION, null);
        yearModel.add(monthModel);
        int dayOfWeek = startDateCal.get(Calendar.DAY_OF_WEEK);
        int firstWeekday = model.getPageModel().getCCSLocale().getFirstWeekday() + 1;
        
        Calendar endDateCal = Calendar.getInstance(this.calendar.getTimeZone(), this.model.getPageModel().getLocale());
        endDateCal.set(year, month, numberOfDays, 23, 59, 59);
        
        startDateCal.add(Calendar.DATE, getStartDateOffset(dayOfWeek, firstWeekday));
        dayOfWeek = endDateCal.get(Calendar.DAY_OF_WEEK);
        endDateCal.add(Calendar.DATE, getEndDateOffset(dayOfWeek, firstWeekday));

        if (!model.getShowEventCaption()) endDateCal.add(Calendar.DATE, weekToAdd*7);

        Date startDate = startDateCal.getTime();
        Date endDate = endDateCal.getTime();
        Date processingDate = startDateCal.getTime();
        Long key = new Long(startDateCal.get(Calendar.YEAR) * 10000 
                + startDateCal.get(Calendar.MONTH) * 100 + startDateCal.get(Calendar.DAY_OF_MONTH));
        while (processingDate.compareTo(endDate) <= 0) {
            CalendarItem item = (CalendarItem) this.dayItems.get(key);
            if (item == null) {
                item = new CalendarItem(processingDate, CalendarItem.DAY);
                this.dayItems.put(key, item);
                item.setNextDate(getNextDate(startDateCal, com.codecharge.components.Calendar.CALENDAR_DAY_SECTION));
                item.setPreviousDate(getPrevDate(startDateCal, com.codecharge.components.Calendar.CALENDAR_DAY_SECTION));
                createItemControls(item, com.codecharge.components.Calendar.CALENDAR_DAY_SECTION);
                createItemControls(item, com.codecharge.components.Calendar.CALENDAR_EMPTY_DAY_SECTION);
                createItemControls(item, com.codecharge.components.Calendar.CALENDAR_WEEK_SECTION);
                item.addAllModels(monthModel);
                
                //Skip previous records
                Calendar cal = Calendar.getInstance(this.calendar.getTimeZone(), this.model.getPageModel().getLocale());
                cal.setTime(processingDate);
                int processingYear = cal.get(Calendar.YEAR);
                int processingMonth = cal.get(Calendar.MONTH);
                int processingDay = cal.get(Calendar.DAY_OF_MONTH);
                int processingKey = processingYear * 10000 + processingMonth * 100 + processingDay;
                CalendarComparator calComp = (CalendarComparator) this.rowProvider.getRowComparator();
                if (rowProvider.hasNextRow()) {
                    if (row == null) {
                        row = rowProvider.nextRow();
                        //model.nextAttrRow();
                    }
                    row = skipNullDates(row);
                    Object dateFieldValue = dataBinder.getFieldValue(row, model.getDateField());
                    if (dateFieldValue != null) {
                        cal.setTime(calComp.getDateObject(row, model.getDateField(), model.getDateFieldDbFormatPattern()));
                        int dateFieldYear = cal.get(Calendar.YEAR);
                        int dateFieldMonth = cal.get(Calendar.MONTH);
                        int dateFieldDay = cal.get(Calendar.DAY_OF_MONTH);
                        int dateFieldKey = dateFieldYear * 10000 + dateFieldMonth * 100 + dateFieldDay;
                        while (processingKey > dateFieldKey) {
                            if (rowProvider.hasNextRow()) {
                                row = rowProvider.nextRow();
                                //model.nextAttrRow();
                            } else {
                                break;
                            }
                            row = skipNullDates(row);
                            dateFieldValue = dataBinder.getFieldValue(row, model.getDateField());
                            if (dateFieldValue == null) {
                                break;
                            }
                            cal.setTime(calComp.getDateObject(row, model.getDateField(), model.getDateFieldDbFormatPattern()));
                            dateFieldYear = cal.get(Calendar.YEAR);
                            dateFieldMonth = cal.get(Calendar.MONTH);
                            dateFieldDay = cal.get(Calendar.DAY_OF_MONTH);
                            dateFieldKey = dateFieldYear * 10000 + dateFieldMonth * 100 + dateFieldDay;
                        }
                    }
                }
                
                this.model.setCurrentItem(item);
                bindControls(item, com.codecharge.components.Calendar.CALENDAR_DAY_SECTION, null);
                bindControls(item, com.codecharge.components.Calendar.CALENDAR_WEEK_SECTION, null);
                
                if (row != null) {
                    cal.setTime(processingDate);
                    int dayYear = cal.get(Calendar.YEAR);
                    int dayMonth = cal.get(Calendar.MONTH);
                    int dayDate = cal.get(Calendar.DAY_OF_MONTH);
                    row = skipNullDates(row);
                    Date event_Date = calComp.getDateObject(row, model.getDateField(), model.getDateFieldDbFormatPattern());
                    if (event_Date != null) {
                        cal.setTime(event_Date);
                        int eventYear = cal.get(Calendar.YEAR);
                        int eventMonth = cal.get(Calendar.MONTH);
                        int eventDate = cal.get(Calendar.DAY_OF_MONTH);
                        while (dayDate == eventDate && dayMonth == eventMonth && dayYear == eventYear) {
                            //bind events
                            CalendarItem event = new CalendarItem(event_Date, CalendarItem.EVENT);
                            event.setDate(item.getDate());
                            event.setPreviousDate(item.getPreviousDate());
                            event.setNextDate(item.getNextDate());
                            createItemControls(event, com.codecharge.components.Calendar.CALENDAR_EVENT_SECTION);
                            event.addAllModels(item);
                            item.add(event);
                            bindControls(event, com.codecharge.components.Calendar.CALENDAR_EVENT_SECTION, row);

                            HashMap aRow = new HashMap ();
                            /*Iterator rAttrs = model.getRowAttributeKeys().iterator();
                            while ( rAttrs.hasNext() ) {
                                String aName = (String) rAttrs.next();
                                ModelAttribute ma = model.getRowAttribute(aName);
                                if ("DataField".equals ( ma.getSourceType() ) ) {
                                    ModelAttribute ma1 = ma.cloneAttribute();
                                    Object value = dataBinder.getFieldValue(row, ma.getSourceName() );
                                    ma1.setValue ( value );
                                    aRow.put(ma1.getName(), ma1);
                                }
                            }*/

//-----------------------------ATTRIBUTES-----------------------------
    {
        Iterator rAttrs = model.getAttributeKeys().iterator();
        while (rAttrs.hasNext()) {
            String rAttrName = (String)rAttrs.next();
            //ModelAttribute brAttr = bindRowAttribute ( (ModelAttribute)model.getAttribute( rAttrName ), row );
            ModelAttribute brAttr = ((ModelAttribute)model.getAttribute( rAttrName )).cloneAttribute();
            if ("DataField".equals ( brAttr.getSourceType() ) ) {
                Object value = dataBinder.getFieldValue(row, brAttr.getSourceName() );
                brAttr.setValue ( value );
                aRow.put(brAttr.getName(), brAttr);
            }
        }
    }
//-----------------------------/ATTRIBUTES----------------------------
                            model.addAttributesRow(""+event.hashCode() , aRow);


                            if (rowProvider.hasNextRow()) {
                                row= rowProvider.nextRow();
                                //model.nextAttrRow();
                                row = skipNullDates(row);
                                event_Date = calComp.getDateObject(row, model.getDateField(), model.getDateFieldDbFormatPattern());
                                if (event_Date == null) {
                                    break;
                                }
                                cal.setTime(event_Date);
                                eventYear = cal.get(Calendar.YEAR);
                                eventMonth = cal.get(Calendar.MONTH);
                                eventDate = cal.get(Calendar.DAY_OF_MONTH);
                            } else {
                                eventDate = -1;
                            }
                        }
                    }
                }
            }
            
            monthModel.add(item);
            startDateCal.add(Calendar.DATE, 1);
            key = new Long(startDateCal.get(Calendar.YEAR) * 10000 
                    + startDateCal.get(Calendar.MONTH) * 100 + startDateCal.get(Calendar.DAY_OF_MONTH));
            processingDate = startDateCal.getTime();
        }
        // process weekdays controls
        monthModel.iteratorInit();
        boolean first = true;
        while (monthModel.hasNextItem()) {
            CalendarItem day = monthModel.nextItem();
            CalendarItem weekday = new CalendarItem(day.getDate());
            startDateCal.setTime(day.getDate());
            dayOfWeek = startDateCal.get(Calendar.DAY_OF_WEEK);
            if (! first && dayOfWeek == firstWeekday) {
                break;
            }

            createItemControls(weekday, com.codecharge.components.Calendar.CALENDAR_WEEKDAYS_SECTION);
            bindControls(weekday, com.codecharge.components.Calendar.CALENDAR_WEEKDAYS_SECTION, null);
            monthModel.addWeekdayItem(weekday);
            if (first) {
                first = false;
            }
        }
        monthModel.iteratorInit();
        //return monthModel;
    }
    
    private Object skipNullDates(Object row) {
        CalendarComparator calComp = (CalendarComparator) this.rowProvider.getRowComparator();
        Date result = calComp.getDateObject(row, model.getDateField(), model.getDateFieldDbFormatPattern());
        while (result == null) {
            if (! rowProvider.hasNextRow()) {
                break;
            }
            row= rowProvider.nextRow();
            result = calComp.getDateObject(row, model.getDateField(), model.getDateFieldDbFormatPattern());
        }
        return row;
    }

    private void bindControls(CalendarItem item, String sectionName, Object row) {
        for (Iterator it = this.model.getSectionControlNames(sectionName).iterator(); it.hasNext(); ) {
            String modelName = (String) it.next();
            Model m = item.getModel(modelName);
            if (m instanceof Control) {
                Control c = (Control) m;

                if ("CalendarSpecialValue".equals(c.getControlSourceType())) {
                    if ("CurrentProcessingDate".equals(c.getFieldSource())) {
                        dataBinder.setControlValueFromDb(c, item.getDate());
                    } else if ("NextProcessingDate".equals(c.getFieldSource())) {
                        dataBinder.setControlValueFromDb(c, item.getNextDate());
                    } else if ("PrevProcessingDate".equals(c.getFieldSource())) {
                        dataBinder.setControlValueFromDb(c, item.getPreviousDate());
                    }
                } else {
                    dataBinder.setControlValueFromDb(c, dataBinder.getFieldValue(row, rowProvider.getOutDbParameters(), c));
                }
                if (c instanceof Link) {
                    setLinkProperties(row, rowProvider.getOutDbParameters(), (Link) c);
                }

            }
        }
    }
    
    private void handleNavigators() {
        CalendarNavigatorItem[] items = getNavigatorItems();
        this.calendar.setTime(model.getBaseDate());
        for (Iterator it = this.model.getSectionControlNames(com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION).iterator(); it.hasNext(); ) {
            String name = (String) it.next();
            Model m = this.calendarItem.getModel(name);
            if (m instanceof CalendarNavigator) {
                CalendarNavigator navigator = (CalendarNavigator) m;
                navigator.setYear(this.model.getYear());
                navigator.setMonth(this.model.getMonth());
                if (model.getMonths() > 0) { // non-quarter calendars
                    navigator.setPrevDate(this.centerItem.getPreviousDate());
                    navigator.setNextDate(this.centerItem.getNextDate());
                } else { // quarter calendar
                    Date temp = this.calendar.getTime();
                    this.calendar.setTime(this.model.getBaseDate());
                    this.calendar.set(Calendar.YEAR, this.model.getYear());
                    this.calendar.set(Calendar.MONTH, this.model.getMonth());
                    navigator.setPrevDate(getPrevDate(this.calendar, com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION));
                    navigator.setNextDate(getNextDate(this.calendar, com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION));
                    this.calendar.setTime(temp);
                }
                this.calendar.setTime(model.getBaseDate());
                this.calendar.add(Calendar.YEAR, -1);
                navigator.setPrevYear(this.calendar.getTime());
                this.calendar.add(Calendar.YEAR, 2);
                navigator.setNextYear(this.calendar.getTime());
                navigator.setItems(items);
                setNavigatorYears(navigator);
            }
        }
    }
    
    private CalendarNavigatorItem[] getNavigatorItems() {
        int numItems = 12 / this.model.getMonths();
        CalendarNavigatorItem[] result = null;
        if (numItems != 1) {
            String[] monthNames = this.model.getPageModel().getCCSLocale().getMonths();
            String[] monthShortNames = this.model.getPageModel().getCCSLocale().getShortMonths();
            switch (numItems) {
                case -4: //quater calendar
                    result = new CalendarNavigatorItem[Math.abs(numItems)];
                    result[0] = new CalendarNavigatorItem(this.model.getYear(), 1, 1, monthNames[0], monthShortNames[0]);
                    result[1] = new CalendarNavigatorItem(this.model.getYear(), 2, 4, monthNames[3], monthShortNames[3]);
                    result[2] = new CalendarNavigatorItem(this.model.getYear(), 3, 7, monthNames[6], monthShortNames[6]);
                    result[3] = new CalendarNavigatorItem(this.model.getYear(), 4, 10, monthNames[9], monthShortNames[9]);
                    result[this.model.getMonth()/3].setSelected(true);
                    break;
                default: //month calendar
                    result = new CalendarNavigatorItem[12];
                    for (int i = 0; i < 12; i++) {
                        result[i] = new CalendarNavigatorItem(this.model.getYear(), (i/3)+1, i+1, monthNames[i], monthShortNames[i]);
                        if (i == this.model.getMonth()) {
                            result[i].setSelected(true);
                        }
                    }
                    break;
            }
        }
        return result;
    }
    
    private void setNavigatorYears(CalendarNavigator navigator) {
        CalendarNavigatorItem[] result = new CalendarNavigatorItem[navigator.getYearsRange() * 2 + 1];
        int curYear = this.model.getYear() - navigator.getYearsRange();
        String[] monthNames = this.model.getPageModel().getCCSLocale().getMonths();
        String[] monthShortNames = this.model.getPageModel().getCCSLocale().getShortMonths();
        for (int i = 0; i < result.length; i++) {
            String year = String.valueOf(curYear);
            result[i] = new CalendarNavigatorItem(curYear, (this.model.getMonth()%3), this.model.getMonth()+1
                    , monthNames[this.model.getMonth()], monthShortNames[this.model.getMonth()]);
            if (curYear == this.model.getYear()) {
                result[i].setSelected(true);
            }
            curYear++;
        }
        navigator.setYears(result);
    }
    
    private Date getNextDate(Calendar cal, String sectionName) {
        Date result = null;
        if (StringUtils.isEmpty(sectionName)) {
            throw new IllegalArgumentException("Parameter 'sectionName' cannot be null or empty.");
        }
        if (com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION.equals(sectionName)) {
            switch (this.model.getMonths()) {
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_YEAR:
                    cal.add(Calendar.YEAR, 1);
                    result = cal.getTime(); 
                    cal.add(Calendar.YEAR, -1);
                    break;
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_QUARTER:
                    Date temp = cal.getTime();
                    cal.add(Calendar.MONTH, 3);
                    cal.set(Calendar.MONTH, com.codecharge.components.Calendar.QUATER_START_MONTH_BY_MONTH[cal.get(Calendar.MONTH)][0]);
                    result = cal.getTime(); 
                    cal.setTime(temp);
                    break;
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_THREE:
                    cal.add(Calendar.MONTH, 3);
                    result = cal.getTime(); 
                    cal.add(Calendar.MONTH, -3);
                    break;
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_ONE:
                    cal.add(Calendar.MONTH, 1);
                    result = cal.getTime(); 
                    cal.add(Calendar.MONTH, -1);
                    break;
                default:
                    throw new IllegalStateException("Calendar.getMonths() is incorrect.");
            }
        } else if (com.codecharge.components.Calendar.CALENDAR_MONTH_SECTION.equals(sectionName)) {
            cal.add(Calendar.MONTH, 1);
            result = cal.getTime(); 
            cal.add(Calendar.MONTH, -1);
        } else if (com.codecharge.components.Calendar.CALENDAR_WEEK_SECTION.equals(sectionName) || 
                com.codecharge.components.Calendar.CALENDAR_DAY_SECTION.equals(sectionName)) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            result = cal.getTime(); 
            cal.add(Calendar.DAY_OF_MONTH, -1);
        } else {
            throw new IllegalArgumentException("Incorrect value for parameter 'sectionName': '"+sectionName+"'.");
        }
        return result;
    }
    
    private Date getPrevDate(Calendar cal, String sectionName) {
        Date result = null;
        if (StringUtils.isEmpty(sectionName)) {
            throw new IllegalArgumentException("Parameter 'sectionName' cannot be null or empty.");
        }
        if (com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION.equals(sectionName)) {
            switch (this.model.getMonths()) {
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_YEAR:
                    cal.add(Calendar.YEAR, -1);
                    result = cal.getTime(); 
                    cal.add(Calendar.YEAR, 1);
                    break;
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_QUARTER:
                    Date temp = cal.getTime();
                    cal.add(Calendar.MONTH, -3);
                    cal.set(Calendar.MONTH, com.codecharge.components.Calendar.QUATER_START_MONTH_BY_MONTH[cal.get(Calendar.MONTH)][0]);
                    result = cal.getTime(); 
                    cal.setTime(temp);
                    break;
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_THREE:
                    cal.add(Calendar.MONTH, -3);
                    result = cal.getTime(); 
                    cal.add(Calendar.MONTH, 3);
                    break;
                case com.codecharge.components.Calendar.CALENDAR_MONTHS_ONE:
                    cal.add(Calendar.MONTH, -1);
                    result = cal.getTime(); 
                    cal.add(Calendar.MONTH, 1);
                    break;
                default:
                    throw new IllegalStateException("Calendar.getMonths() is incorrect.");
            }
        } else if (com.codecharge.components.Calendar.CALENDAR_MONTH_SECTION.equals(sectionName)) {
            cal.add(Calendar.MONTH, -1);
            result = cal.getTime(); 
            cal.add(Calendar.MONTH, 1);
        } else if (com.codecharge.components.Calendar.CALENDAR_WEEK_SECTION.equals(sectionName) || 
                com.codecharge.components.Calendar.CALENDAR_DAY_SECTION.equals(sectionName)) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            result = cal.getTime(); 
            cal.add(Calendar.DAY_OF_MONTH, 1);
        } else {
            throw new IllegalArgumentException("Incorrect value for parameter 'sectionName': '"+sectionName+"'.");
        }
        return result;
    }
    
    private void createItemControls(CalendarItem item, String sectionName) {
        for (Iterator controls = this.model.getSectionControlNames(sectionName).iterator(); controls.hasNext(); ) {
            String controlName = (String) controls.next();
            Model m = (Model) ((Model) this.model.getChild(controlName)).clone();
            if (m != null) {
                item.addModel(m);
            }
        }
    }
    
    private int getStartDateOffset(int dayOfWeek, int firstWeekday) {
        int result = firstWeekday - dayOfWeek;
        if (result > 0) {
            result -= 7; // days per week (for gregorian calendar) (begining from 0)
        }
        return result;
    }
    
    private int getEndDateOffset(int dayOfWeek, int firstWeekday) {
        int endWeekday = firstWeekday - 1;
        if (endWeekday < 0) {
            endWeekday += 7; //days per week
        }
        int result = endWeekday - dayOfWeek;
        if (result < 0) {
            result += 7; // days per week (for gregorian calendar) (begining from 0)
        }
        return result;
    }
    
    public void setModel(com.codecharge.components.Calendar model) {
        this.model = model;
        this.calendar = java.util.Calendar.getInstance(model.getTimeZone(), model.getPageModel().getLocale());
        if (rowComparator instanceof CalendarComparator) {
            ((CalendarComparator) this.rowComparator).setCCSLocale(model.getPageModel().getCCSLocale());
            ((CalendarComparator) this.rowComparator).setDateFieldName(model.getDateField());
            ((CalendarComparator) this.rowComparator).setTimeFieldName(model.getTimeField());
            ((CalendarComparator) this.rowComparator).setDateFieldDbFormatPattern(model.getDateFieldDbFormatPattern());
            ((CalendarComparator) this.rowComparator).setTimeFieldDbFormatPattern(model.getTimeFieldDbFormatPattern());
            ((CalendarComparator) this.rowComparator).setCalendar(java.util.Calendar.getInstance(model.getTimeZone(), model.getPageModel().getLocale()));
        }
    }
    
    public void setRowComparator(Comparator rowComparator) {
        this.rowComparator = rowComparator;
        if (rowComparator instanceof CalendarComparator && model != null) {
            ((CalendarComparator) this.rowComparator).setCCSLocale(model.getPageModel().getCCSLocale());
            ((CalendarComparator) this.rowComparator).setDateFieldName(model.getDateField());
            ((CalendarComparator) this.rowComparator).setDateFieldDbFormatPattern(model.getDateFieldDbFormatPattern());
            ((CalendarComparator) this.rowComparator).setTimeFieldDbFormatPattern(model.getTimeFieldDbFormatPattern());
            ((CalendarComparator) this.rowComparator).setTimeFieldName(model.getTimeField());
            ((CalendarComparator) this.rowComparator).setCalendar(java.util.Calendar.getInstance(model.getTimeZone(), model.getPageModel().getLocale()));
        }
    }

    public void setRowProvider(IRowProvider rowProvider) {
        this.rowProvider = rowProvider;
        if (this.rowProvider.getRowComparator() instanceof CalendarComparator && model != null) {
            ((CalendarComparator) this.rowComparator).setCCSLocale(model.getPageModel().getCCSLocale());
            ((CalendarComparator) this.rowProvider.getRowComparator()).setDateFieldName(model.getDateField());
            ((CalendarComparator) this.rowProvider.getRowComparator()).setTimeFieldName(model.getTimeField());
            ((CalendarComparator) this.rowComparator).setDateFieldDbFormatPattern(model.getDateFieldDbFormatPattern());
            ((CalendarComparator) this.rowComparator).setTimeFieldDbFormatPattern(model.getTimeFieldDbFormatPattern());
            ((CalendarComparator) this.rowProvider.getRowComparator()).setCalendar(java.util.Calendar.getInstance(model.getTimeZone(), model.getPageModel().getLocale()));
        }
    }
}





//End CalendarAction class

