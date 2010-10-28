//NarrowWeekdayFormat class @0-ED1ECC1C
package com.codecharge.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;

public class NarrowWeekdayFormat extends DateFormat {
    
    private CCSDateFormatSymbols dateFormatSymbols;

    public NarrowWeekdayFormat(CCSDateFormatSymbols dateFormatSymbols) {
        this.dateFormatSymbols = dateFormatSymbols;
        if (dateFormatSymbols != null) {
            setCalendar(Calendar.getInstance(dateFormatSymbols.getLocale()));
        } else {
            setCalendar(Calendar.getInstance());
        }
    }

    public StringBuffer format(Date obj, StringBuffer toAppendTo, FieldPosition pos) {
        if (obj instanceof Date && dateFormatSymbols != null) {
            getCalendar().setTime((Date) obj);
            int dayOfWeek = getCalendar().get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek > 0 && dayOfWeek < 8) {
                toAppendTo.append(dateFormatSymbols.getNarrowWeekdays()[dayOfWeek]);
            }
        }
        return toAppendTo;
    }
  
    public Object parseObject(String source, ParsePosition status) {
        throw new UnsupportedOperationException();
    }

    public Object parseObject(String source) throws ParseException {
        throw new UnsupportedOperationException();
    }

    public Date parse(String source, ParsePosition status) {
        throw new UnsupportedOperationException();
    }
}

//End NarrowWeekdayFormat class

