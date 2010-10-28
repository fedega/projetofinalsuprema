//FormNameTag class @0-1961397C
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Calculate name attribute of the form HTML element.
  <pre><b>&lt;form_name/&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class FormNameTag extends TagSupport {

  public int doEndTag() {
    Component c = (Component)pageContext.getAttribute("parent");
    try {
      pageContext.getOut().print(c.getName());
    } catch (Exception e) {
      throw new Error("IO Problems");
    }
    return EVAL_PAGE;
  }
}
//End FormNameTag class

