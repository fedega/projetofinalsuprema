//CalendarComparator class @0-3F761C8F
/*
 * $Revision: 1.1 $
 * $Date: 2005/05/04 05:42:01 $
 */
package com.codecharge.components.calendar;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.codecharge.db.IDataBinder;
import com.codecharge.util.StringUtils;
import com.codecharge.util.CCSLocale;


public class CalendarComparator implements Comparator {
    
    private String dateFieldName;
    private String dateFieldDbFormatPattern;
    private String timeFieldName;
    private String timeFieldDbFormatPattern;
    private IDataBinder dataBinder;
    private Calendar calendar;
    private CCSLocale ccsLocale;

    public void setCCSLocale(CCSLocale ccsLocale) {
        this.ccsLocale = ccsLocale;
    }

    public void setDateFieldName(String dateField) {
        dateFieldName = dateField;
    }

    public void setDateFieldDbFormatPattern(String pattern) {
        dateFieldDbFormatPattern = pattern;
    }

    public void setTimeFieldDbFormatPattern(String pattern) {
        timeFieldDbFormatPattern = pattern;
    }

    public void setTimeFieldName(String timeField) {
        timeFieldName = timeField;
    }

    public void setDataBinder(IDataBinder dataBinder) {
        this.dataBinder = dataBinder;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public int compare(Object o1, Object o2) {
        if (dataBinder == null) {
            throw new IllegalStateException("dataBinder is not initialized.");
        }
        if (StringUtils.isEmpty(dateFieldName)) {
            //throw new IllegalStateException("dataFieldName cannot be a null or an empty.");
            return 0;
        }
        Date date1 = getDateObject(o1, dateFieldName, dateFieldDbFormatPattern);
        Date date2 = getDateObject(o2, dateFieldName, dateFieldDbFormatPattern);
        Date time1 = getDateObject(o1, timeFieldName, timeFieldDbFormatPattern);
        Date time2 = getDateObject(o2, timeFieldName, timeFieldDbFormatPattern);

        
        int result = compareDate(date1, date2, false, ! StringUtils.isEmpty(timeFieldName));
        if (result == 0 && ! StringUtils.isEmpty(timeFieldName)) {
            result = compareDate(time1, time2, true, true);
        }
        return result;
    }

    public Date getDateObject(Object src, String fieldName, String formatPattern) {
        if (src == null || StringUtils.isEmpty(fieldName)) {
            return null;
        }
        Object obj = dataBinder.getFieldValue(src, fieldName);
        if (obj instanceof Date) {
            return (Date) obj;
        } else if (obj instanceof String) {
            Format format = this.ccsLocale.getDateFormat(formatPattern);
            try {
                return (Date) format.parseObject((String) obj);
            } catch (ParseException pe_ignore) {
            }
        }
        return null;
    }
    
    private int compareDate(Date date1, Date date2, boolean isTime, boolean isNormalize) {
        int result = 0;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");            
        if (date1 == null && date2 == null) {
            return 0;
        } else if (date1 == null && date2 != null) {
            return -1;
        } else if (date2 == null && date1 != null) {
            return 1;
        } else {
            if (isTime) {
                date1 = normalizeTime(date1);
                date2 = normalizeTime(date2);
            } else if (isNormalize) {
                date1 = normalizeDate(date1);
                date2 = normalizeDate(date2);
            }
            result = date1.compareTo(date2);
        }
        return result;
    }        
    
    private Date normalizeDate(Date date) {
        this.calendar.setTime(date);
        this.calendar.set(Calendar.HOUR, 0);
        this.calendar.set(Calendar.MINUTE, 0);
        this.calendar.set(Calendar.SECOND, 0);
        this.calendar.set(Calendar.MILLISECOND, 0);
        this.calendar.set(Calendar.AM_PM, Calendar.AM);
        return this.calendar.getTime();
    }

    private Date normalizeTime(Date date) {
        this.calendar.setTime(date);
        this.calendar.set(Calendar.YEAR, 0);
        this.calendar.set(Calendar.MONTH, 0);
        this.calendar.set(Calendar.DATE, 0);
        return this.calendar.getTime();
    }

}

//End CalendarComparator class

