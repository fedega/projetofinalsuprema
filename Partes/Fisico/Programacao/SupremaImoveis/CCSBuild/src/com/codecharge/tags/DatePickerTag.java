//DatePickerTag class @0-5CB91DC1
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
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}
    <dt><b>Child elements:</b> <dd>{@link DatePickerValueTag dpvalue}
  </dl>
**/
public class DatePickerTag extends TagSupport {

  private String name;
  private DatePicker model;

  public void setName(String name) {
    this.name = name;
  }

  public DatePicker getModel() { return model;}

  public int doStartTag() {
    Component parent = (Component)pageContext.getAttribute("parent");
    model = (DatePicker)parent.getChild(name);
    if (model != null) {
      if (model.isVisible()) {
        return EVAL_BODY_INCLUDE;
      }
    }
    return SKIP_BODY;
	}
}
//End DatePickerTag class

