//DatePickerValueTag class @0-0E521D5C
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Defines block that can be hidden from CCS events.
  <pre><b>&lt;datepicker name=".."&gt;
      &lt;dpvalue property='..'/&gt;
    &lt;/datepicker&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setProperty property}
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}
    <dt><b>Child elements:</b> <dd>{@link DatePickerValueTag dpvalue}
  </dl>
**/
public class DatePickerValueTag extends TagSupport {

  private String property;

  public void setProperty(String property) {
    this.property = property;
  }

  public int doStartTag() {
    String value = "";
    DatePickerTag parent = (DatePickerTag)findAncestorWithClass(this, DatePickerTag.class);
    DatePicker ctrl = parent.getModel();
    if ("Name".equals(property)) {
      value = ctrl.getParent().getName() + "_" + ctrl.getName();
    } else if ("FormName".equals(property)) {
      value = ctrl.getParent().getName();
    } else if ("DateControl".equals(property)) {
      value = ctrl.getHtmlName();
    }
    try {
      pageContext.getOut().print(value);
    } catch(Exception exception) {
      throw new Error("IO problems");
    }
    return SKIP_BODY;
	}
}
//End DatePickerValueTag class

