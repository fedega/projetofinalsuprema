//NumericFormat class @0-5D7DC515
package com.codecharge.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.Format;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class NumericFormat extends Format {
  private String pZero;
  private String pNull;
  private DecimalFormat df;
  private String formatPattern;
  private Locale locale = Locale.getDefault();

  public NumericFormat(String pattern) {
    this( pattern, null );
  }

  public NumericFormat(String pattern, Locale locale) {
      this(pattern, locale, null, null, null);
  }
  
  public NumericFormat(String pattern, Locale locale, DecimalFormatSymbols fmtSymbols, String zeroFormat, String nullFormat) {
    int i;
    if ( locale != null ) {
        this.locale = locale;
    }
    NumberFormat nf = NumberFormat.getNumberInstance(this.locale);

    String[] patterns = {"","","","","",""};
    for (int p=0; p<6; p++) {
      if ((i=pattern.indexOf(';')) != -1) {
        patterns[p] = pattern.substring(0,i);
        pattern = pattern.substring(i+1);
      } else {
        patterns[p] = pattern;
        break;
      }
    }

    df = (DecimalFormat) nf;
    formatPattern = patterns[1].length()==0 ? patterns[0] : patterns[0] + ";" + patterns[1];
    df.applyPattern(formatPattern);

    DecimalFormatSymbols symbols = df.getDecimalFormatSymbols();
    if (fmtSymbols != null) {
      symbols.setDecimalSeparator(fmtSymbols.getDecimalSeparator());
      symbols.setGroupingSeparator(fmtSymbols.getGroupingSeparator());
    }
    if (patterns[4].length() != 0)
      symbols.setDecimalSeparator(patterns[4].charAt(0));
    if (patterns[5].length() != 0)
      symbols.setGroupingSeparator(patterns[5].charAt(0));

    df.setDecimalFormatSymbols(symbols);
    this.pZero = patterns[2];
    if (StringUtils.isEmpty(this.pZero) && zeroFormat != null) {
        this.pZero = zeroFormat;
    }
    this.pNull = patterns[3];
    if (StringUtils.isEmpty(this.pNull) && nullFormat != null) {
        this.pNull = nullFormat;
    }
  }

  public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
    if (obj == null) {
      if (pNull.length() != 0) {
        return (toAppendTo.append(pNull));
      } else {
        return toAppendTo.append("");
      }
    } else if (obj instanceof Number && ((Number)obj).doubleValue() == 0 && pZero.length() != 0) {
      return (toAppendTo.append(pZero));
    } else if (obj instanceof String) {
      return toAppendTo.append((String)obj);
    } else {
      return df.format(obj, toAppendTo, pos);
    }
  }
  
  public final String format(double n) {
    return format(new BigDecimal(n), new StringBuffer(), new FieldPosition(0)).toString();
  }
  
  public final String format(long n) {
    return format(new BigDecimal(n), new StringBuffer(), new FieldPosition(0)).toString();
  }

  public Object parseObject(String source, ParsePosition status) {
    if ( source == null ) {
      return null;
    }
    if (pNull.length() != 0 && source.equals(pNull)) {
      status.setIndex(source.length());
      return null;
    } else if (pZero.length() != 0 && source.equals(pZero)) {
      status.setIndex(source.length());
      return new BigDecimal(0);
    } else {
      return df.parseObject(source, status);
    }
  }

  public Object parseObject(String source) throws ParseException {
    ParsePosition p = new ParsePosition(0);
    Object value = parseObject(source, p);
    if (source != null && p.getIndex() < source.length()) {
      throw new ParseException("NumericFormat.parseObject(String) failed", p.getIndex());
    }
    return value;
  }

  public Long parseLong(String source) throws ParseException {
    Object number = parseObject(source);
    return new Long(((Number)number).longValue());
  }

  public Double parseDouble(String source) throws ParseException {
    Object number = parseObject(source);
    return new Double(((Number)number).doubleValue());
  }
   
  public Float parseFloat(String source) throws ParseException {
    Object number = parseObject(source);
    return new Float(((Number)number).floatValue());
  }
}

//End NumericFormat class

