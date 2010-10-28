//CCSLocale @0-C3273480
/*
 * $Revision: 1.4 $
 * $Date: 2005/04/29 08:27:21 $
 */
package com.codecharge.util;

import java.text.DateFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

import com.codecharge.components.ControlType;

public class CCSLocale {
    
    final static private String SHORT_DATE_FORMAT_PROPERTY = "shortDate";
    final static private String LONG_DATE_FORMAT_PROPERTY = "longDate";
    final static private String SHORT_TIME_FORMAT_PROPERTY = "shortTime";
    final static private String LONG_TIME_FORMAT_PROPERTY = "longTime";

    private Locale locale;
    private String localeName;

    private String[] amPmStrings;
    private int firstWeekday;
    private boolean overrideDateFormats;
    private boolean overrideNumberFormats;

    private Properties localeProperties;
    private boolean localePropertiesChanged;

    private CCSDateFormatSymbols dateFormatSymbols;
    private DecimalFormatSymbols decimalFormatSymbols;

    public CCSLocale() {
        this((Locale) null, (String) null);
    }

    public CCSLocale(Locale locale) {
        this(locale, null);
    }

    public CCSLocale(Locale locale, String characterEncoding) {
        if ( locale == null ) {
            locale = Locale.getDefault();
        }
        if ( StringUtils.isEmpty(characterEncoding) ) {
            characterEncoding = "ISO-8859-1";
        } else {
            try {
                byte[] tmp = "test".getBytes(characterEncoding); 
            } catch (java.io.UnsupportedEncodingException e) { characterEncoding="ISO-8859-1"; }
        }
        this.locale = locale;

        if (this.localeProperties == null) {
            this.localeProperties = new Properties();
        }
        this.localeName = locale.toString();
        setProperty("encoding", characterEncoding);
        setProperty("__dateFormatPattern", "GeneralDate");
        setProperty("booleanFormat", "True;False");
        setProperty("__longFormatPattern", "##");
        setProperty("__doubleFormatPattern", "#.##");
    }

    public CCSLocale(String localeName, Properties props) {
        if (StringUtils.isEmpty(localeName)) {
            throw new IllegalArgumentException("Parameter 'localeName' cannot be empty.");
        }
        if (props == null) {
            throw new IllegalArgumentException("Parameter 'props' cannot be null.");
        }
        this.localeName = localeName;
        this.localeProperties = new Properties(props);
       
        if (StringUtils.isEmpty(getProperty("booleanFormat"))) { 
            setProperty("booleanFormat", "True;False");
        }
        setProperty("__longFormatPattern", "##");
        setProperty("__doubleFormatPattern", "#.##");
        setProperty("__dateFormatPattern", StringUtils.getSiteProperty("defaultDateFormat"));
        
        this.locale = new Locale(getProperty("language"), getProperty("country"));
        
        String characterEncoding = getProperty("encoding");
        
        if ( StringUtils.isEmpty(characterEncoding) ) {
            characterEncoding = "ISO-8859-1";
        } else {
            try {
                byte[] tmp = "test".getBytes(characterEncoding); 
            } catch (java.io.UnsupportedEncodingException e) { 
                characterEncoding="ISO-8859-1"; 
            }
        }
        setProperty("encoding", characterEncoding);

        this.overrideDateFormats = new Boolean(getProperty("overrideDateFormats")).booleanValue();
		if ("true".equals(StringUtils.getSiteProperty("RebuildFormatSymbols"))) {
	            createDateFormatSymbols();
		}else if (overrideDateFormats){
               createDateFormatSymbols();
			}

        this.overrideNumberFormats = new Boolean(getProperty("overrideNumberFormats")).booleanValue();
        if (overrideNumberFormats) {
            createDecimalFormatSymbols();
        }
    }

    private void rebuildSymbols() {
        if (this.localePropertiesChanged) {
            createDecimalFormatSymbols();
            createDateFormatSymbols();
            this.localePropertiesChanged = false;
        }
    }
    
    private void createDecimalFormatSymbols() {
        this.decimalFormatSymbols = new DecimalFormatSymbols(this.locale);
        if (! StringUtils.isEmpty(getProperty("decimalSeparator"))) {
            this.decimalFormatSymbols.setDecimalSeparator(getProperty("decimalSeparator").charAt(0));
        }
        if (! StringUtils.isEmpty(getProperty("groupSeparator"))) {
            this.decimalFormatSymbols.setGroupingSeparator(getProperty("groupSeparator").charAt(0));
        }
    }

    private void createDateFormatSymbols() {
        boolean lDebug = false;
        if ("en".equals(this.localeName)) {
            lDebug = true;
        }
        this.dateFormatSymbols = new CCSDateFormatSymbols(this.locale);
        if (getProperty("monthNames") != null) {
            dateFormatSymbols.setMonths(getArray("monthNames", 13, false));
        }
        if (getProperty("monthShortNames") != null) {
            dateFormatSymbols.setShortMonths(getArray("monthShortNames", 13, false));
        }
        if (getProperty("weekdayNames") != null) {
            dateFormatSymbols.setWeekdays(getArray("weekdayNames", 8, true));
        }
        if (getProperty("weekdayShortNames") != null) {
            dateFormatSymbols.setShortWeekdays(getArray("weekdayShortNames", 8, true));
        }
        dateFormatSymbols.setNarrowWeekdays(getArray("weekdayNarrowNames", 8, true));
        if (getProperty("firstWeekDay") != null) {
            try {
                this.firstWeekday = Integer.parseInt(getProperty("firstWeekDay"));
            } catch (NumberFormatException nfe) {
                CCLogger.getInstance().error("Incorrect value for "+this.localeName+".firstWeekDay: '"+
                        getProperty("firstWeekDay")+"'. The value must be an integer.");
            }
        }
        setAmPmStrings();
    }

    public String[] getMonths() {
        rebuildSymbols();
        if (this.dateFormatSymbols != null) {
            return this.dateFormatSymbols.getMonths();
        }
        return null;
    }
    
    public String[] getShortMonths() {
        rebuildSymbols();
        if (this.dateFormatSymbols != null) {
            return this.dateFormatSymbols.getShortMonths();
        }
        return null;
    }
    
    public String[] getWeekdays() {
        rebuildSymbols();
        if (this.dateFormatSymbols == null) {
            return null;
        }
        return this.dateFormatSymbols.getWeekdays();
    }
    
    public String[] getShortWeekdays() {
        rebuildSymbols();
        if (this.dateFormatSymbols == null) {
            return null;
        }
        return this.dateFormatSymbols.getShortWeekdays();
    }
    
    /**
     * Gets narrow (one letter) weekday strings. For example: "S" for Sunday, "M" for Monday, etc.
     */
    public String[] getNarrowWeekdays() {
        rebuildSymbols();
        if (this.dateFormatSymbols == null) {
            return null;
        }
        return this.dateFormatSymbols.getNarrowWeekdays();
    }
    
    private String[] getArray(String propertyName, int length, boolean insertInBegin) {
        if (length < 1) {
            return new String[] {""};
        }
        java.util.List items = StringUtils.splitToList(getProperty(propertyName), ';', '\\');
        while (items.size() < length) {
            if (insertInBegin) {
                items.add(0, "");
            } else {
                items.add("");
            }
        }
        while (items.size() > length) {
            items.remove(items.size()-1);
        }
        String[] result = new String[items.size()];
        return (String[]) items.toArray(result);        
    }
    
    private void setAmPmStrings() {
        if (this.dateFormatSymbols != null) {
            amPmStrings = dateFormatSymbols.getAmPmStrings();
            if (getProperty("AMDesignator") != null) {
                amPmStrings[0] = getProperty("AMDesignator");
            }
            if (getProperty("PMDesignator") != null) {
                amPmStrings[1] = getProperty("PMDesignator");
            }
            dateFormatSymbols.setAmPmStrings(amPmStrings);
        }
    }

    public String getLocaleName() {
        return this.localeName;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getCharacterEncoding() {
        return getProperty("encoding");
    }

    public void setCharacterEncoding(String characterEncoding) {
        setProperty("encoding", characterEncoding);
    }

    public String getDateFormatPattern() {
        String fmtPattern = getProperty("__dateFormatPattern");
        if (StringUtils.isEmpty(fmtPattern.trim())) {
            fmtPattern = "GeneralDate";
        }
        return fmtPattern;
    }

    public void setDateFormatPattern(String dateFormatPattern) {
        if (StringUtils.isEmpty(dateFormatPattern.trim())) {
            dateFormatPattern = "GeneralDate";
        }
        setProperty("__dateFormatPattern", dateFormatPattern);
    }

    public String getBooleanFormatPattern() {
        return getProperty("booleanFormat");
    }

    public void setBooleanFormatPattern(String booleanFormatPattern) {
        if (StringUtils.isEmpty(booleanFormatPattern.trim())) {
            booleanFormatPattern = "True;False";
        }
        setProperty("booleanFormat", booleanFormatPattern);
    }

    public String getLongFormatPattern() {
        return getProperty("__longFormatPattern");
    }

    public void setLongFormatPattern(String longFormatPattern) {
        if (StringUtils.isEmpty(longFormatPattern.trim())) {
            longFormatPattern = "##";
        }
        setProperty("__longFormatPattern", longFormatPattern);
    }

    public String getDoubleFormatPattern() {
        return getProperty("__doubleFormatPattern");
    }

    public void setDoubleFormatPattern(String doubleFormatPattern) {
        if (StringUtils.isEmpty(doubleFormatPattern.trim())) {
            doubleFormatPattern = "#.##";
        }
        setProperty("__doubleFormatPattern", doubleFormatPattern);
    }

    public int getFirstWeekday() {
        return firstWeekday;
    }
    
    public DateFormat getDateFormat() {
        rebuildSymbols();
        DateFormat fmt = null;
        if ("GeneralDate".equalsIgnoreCase(getDateFormatPattern())) {
            fmt = getGeneralDateFormat();
        } else if ("LongDate".equalsIgnoreCase(getDateFormatPattern())) {
            fmt = getLongDateFormat();
        } else if ("ShortDate".equalsIgnoreCase(getDateFormatPattern())) {
            fmt = getShortDateFormat();
        } else if ("LongTime".equalsIgnoreCase(getDateFormatPattern())) {
            fmt = getLongTimeFormat();
        } else if ("ShortTime".equalsIgnoreCase(getDateFormatPattern())) {
            fmt = getShortTimeFormat();
        } else {
            if (dateFormatSymbols == null) {
                fmt = new SimpleDateFormat(getDateFormatPattern());
            } else {
                fmt = new SimpleDateFormat(getDateFormatPattern(), this.dateFormatSymbols);
            }
        }
        fmt.getCalendar().setFirstDayOfWeek(this.firstWeekday);
        return fmt;
    }

    public DateFormat getDateFormat(String formatPattern) {
        rebuildSymbols();
        DateFormat fmt = null;
        if (StringUtils.isEmpty(formatPattern)) {
            fmt = getDateFormat();
        } else if ("GeneralDate".equalsIgnoreCase(formatPattern)) {
            fmt = getGeneralDateFormat();
        } else if ("LongDate".equalsIgnoreCase(formatPattern)) {
            fmt = getLongDateFormat();
        } else if ("ShortDate".equalsIgnoreCase(formatPattern)) {
            fmt = getShortDateFormat();
        } else if ("LongTime".equalsIgnoreCase(formatPattern)) {
            fmt = getLongTimeFormat();
        } else if ("ShortTime".equalsIgnoreCase(formatPattern)) {
            fmt = getShortTimeFormat();
        } else if ("wi".equals(formatPattern)) {
            fmt = new NarrowWeekdayFormat(this.dateFormatSymbols);
        } else {
            if (dateFormatSymbols == null) {
                fmt = new SimpleDateFormat(formatPattern);
            } else {
                fmt = new SimpleDateFormat(formatPattern, this.dateFormatSymbols);
            }
        }
        fmt.getCalendar().setFirstDayOfWeek(this.firstWeekday);
        return fmt;
    }

    public DateFormat getGeneralDateFormat() {
        rebuildSymbols();
        DateFormat fmt = null;
        if (this.dateFormatSymbols == null) {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.SHORT_DATE_FORMAT_PROPERTY) + 
                   " " + getProperty(CCSLocale.LONG_TIME_FORMAT_PROPERTY));
        } else {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.SHORT_DATE_FORMAT_PROPERTY) + 
                   " " + getProperty(CCSLocale.LONG_TIME_FORMAT_PROPERTY), this.dateFormatSymbols);
        }
        fmt.getCalendar().setFirstDayOfWeek(this.firstWeekday);
        return fmt;
    }

    public DateFormat getShortDateFormat() {
        rebuildSymbols();
        DateFormat fmt = null;
        if (this.dateFormatSymbols == null) {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.SHORT_DATE_FORMAT_PROPERTY));
        } else {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.SHORT_DATE_FORMAT_PROPERTY), this.dateFormatSymbols);
        }
        fmt.getCalendar().setFirstDayOfWeek(this.firstWeekday);
        return fmt;
    }

    public DateFormat getLongDateFormat() {
        rebuildSymbols();
        DateFormat fmt = null;
        if (this.dateFormatSymbols == null) {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.LONG_DATE_FORMAT_PROPERTY));
        } else {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.LONG_DATE_FORMAT_PROPERTY), this.dateFormatSymbols);
        }
        fmt.getCalendar().setFirstDayOfWeek(this.firstWeekday);
        return fmt;
    }

    public DateFormat getShortTimeFormat() {
        rebuildSymbols();
        DateFormat fmt = null;
        if (this.dateFormatSymbols == null) {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.SHORT_TIME_FORMAT_PROPERTY));
        } else {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.SHORT_TIME_FORMAT_PROPERTY), this.dateFormatSymbols);
        }
        fmt.getCalendar().setFirstDayOfWeek(this.firstWeekday);
        return fmt;
    }

    public DateFormat getLongTimeFormat() {
        rebuildSymbols();
        DateFormat fmt = null;
        if (this.dateFormatSymbols == null) {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.LONG_TIME_FORMAT_PROPERTY));
        } else {
            fmt = new SimpleDateFormat(getProperty(CCSLocale.LONG_TIME_FORMAT_PROPERTY), this.dateFormatSymbols);
        }
        fmt.getCalendar().setFirstDayOfWeek(this.firstWeekday);
        return fmt;
    }

    public BooleanFormat getBooleanFormat() {
        BooleanFormat format = null;
        Enumeration tokens = StringUtils.split(getBooleanFormatPattern());
        String trueValue = tokens.hasMoreElements() ? (String) tokens.nextElement() : null;
        String falseValue = tokens.hasMoreElements() ? (String) tokens.nextElement() : null;
        String defaultValue = tokens.hasMoreElements() ? (String) tokens.nextElement() : null;
        format = new BooleanFormat( trueValue, falseValue, defaultValue, this.locale);
        return format;
    }

    public BooleanFormat getBooleanFormat(String formatPattern) {
        BooleanFormat format = null;
        if (StringUtils.isEmpty(formatPattern)) {
            format = getBooleanFormat();
        } else {
            Enumeration tokens = StringUtils.split(formatPattern);
            String trueValue = tokens.hasMoreElements() ? (String) tokens.nextElement() : null;
            String falseValue = tokens.hasMoreElements() ? (String) tokens.nextElement() : null;
            String defaultValue = tokens.hasMoreElements() ? (String) tokens.nextElement() : null;
            format = new BooleanFormat( trueValue, falseValue, defaultValue, this.locale);
        }
        return format;
    }

    public NumericFormat getLongFormat() {
        rebuildSymbols();
        return new NumericFormat(getLongFormatPattern(), this.locale, this.decimalFormatSymbols, 
                getProperty("zeroFormat"), getProperty("nullFormat"));
    }

    public NumericFormat getLongFormat(String formatPattern) {
        rebuildSymbols();
        NumericFormat format = null;
        if (StringUtils.isEmpty(formatPattern)) {
            format = getLongFormat();
        } else {
            format = new NumericFormat(formatPattern, this.locale, this.decimalFormatSymbols, null, null);
        }
        return format;
    }

    public NumericFormat getDoubleFormat() {
        rebuildSymbols();
        return new NumericFormat(getDoubleFormatPattern(), this.locale, this.decimalFormatSymbols, 
                getProperty("zeroFormat"), getProperty("nullFormat"));
    }

    public NumericFormat getDoubleFormat(String formatPattern) {
        rebuildSymbols();
        NumericFormat format = null;
        if (StringUtils.isEmpty(formatPattern)) {
            format = getDoubleFormat();
        } else {
            format = new NumericFormat(formatPattern, this.locale, this.decimalFormatSymbols, null, null);
        }
        return format;
    }

    public NumericFormat getNumericFormat(String formatPattern) {
        rebuildSymbols();
        return new NumericFormat(formatPattern, locale, decimalFormatSymbols, null, null);
    }

    public Format getFormat(ControlType type) {
        rebuildSymbols();
        return getFormat(type, null);
    }

    public Format getFormat(ControlType type, String formatPattern) {
        Format fmt = null;
        if ( ! StringUtils.isEmpty(formatPattern)) {
            if ( type == ControlType.INTEGER ) {
                fmt = getNumericFormat(formatPattern);
            } else if ( type == ControlType.SINGLE ) {
                fmt = getNumericFormat(formatPattern);
            } else if ( type == ControlType.FLOAT ) {
                fmt = getNumericFormat(formatPattern);
            } else if ( type == ControlType.DATE ) {
                fmt = getDateFormat(formatPattern);
            } else if ( type == ControlType.BOOLEAN ) {
                fmt = getBooleanFormat(formatPattern);
            }
        } else {
            if ( type == ControlType.INTEGER ) {
                fmt = getLongFormat();
            } else if ( type == ControlType.SINGLE ) {
                fmt = getDoubleFormat();
            } else if ( type == ControlType.FLOAT ) {
                fmt = getDoubleFormat();
            } else if ( type == ControlType.DATE ) {
                fmt = getDateFormat();
            } else if ( type == ControlType.BOOLEAN ) {
                fmt = getBooleanFormat();
            }
        }
        return fmt;
    }

    public Format getFormat(String type) {
        return getFormat((String) type, null);
    }

    public Format getFormat(String type, String formatPattern) {
        Format fmt = null;
        if ( ! StringUtils.isEmpty(formatPattern)) {
            if ( "Integer".equals(type) ) {
                fmt = getNumericFormat(formatPattern);
            } else if ( "Float".equals(type) ) {
                fmt = getNumericFormat(formatPattern);
            } else if ( "Single".equals(type) ) {
                fmt = getNumericFormat(formatPattern);
            } else if ( "Date".equals(type) ) {
                fmt = getDateFormat(formatPattern);
            } else if ( "Boolean".equals(type) ) {
                fmt = getBooleanFormat(formatPattern);
            }
        } else {
            if ( "Integer".equals(type) ) {
                fmt = getLongFormat();
            } else if ( "Float".equals(type) ) {
                fmt = getDoubleFormat();
            } else if ( "Single".equals(type) ) {
                fmt = getDoubleFormat();
            } else if ( "Date".equals(type) ) {
                fmt = getDateFormat();
            } else if ( "Boolean".equals(type) ) {
                fmt = getBooleanFormat();
            }
        }
        return fmt;
    }

    public String getProperty(String key) {
        return this.localeProperties.getProperty(this.localeName+"."+key);
    }

    public void setProperty(String key, String value) {
        this.localeProperties.setProperty(this.localeName+"."+key, value);
        this.localePropertiesChanged = true;        
    }

}



//End CCSLocale

