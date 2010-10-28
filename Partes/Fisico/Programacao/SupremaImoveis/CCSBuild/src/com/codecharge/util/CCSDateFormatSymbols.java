//CCSDateFormatSymbols @0-8FC4FFC9
package com.codecharge.util;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class CCSDateFormatSymbols extends DateFormatSymbols {
    private String[] narrowWeekdays;
    private Locale locale;

    public CCSDateFormatSymbols() {
        super();
    }

    public CCSDateFormatSymbols(Locale locale) {
        super(locale);
        this.locale = locale;
    }
    
    /**
     * Gets narrow weekday strings.
     */
    public String[] getNarrowWeekdays() {
        return narrowWeekdays;
    }

    /**
     * Sets narrow weekday strings.
     */
    public void setNarrowWeekdays(String[] newNarrowWeekdays) {
        narrowWeekdays = newNarrowWeekdays;
    }

    public Locale getLocale() {
        return locale;
    }
}

//End CCSDateFormatSymbols

