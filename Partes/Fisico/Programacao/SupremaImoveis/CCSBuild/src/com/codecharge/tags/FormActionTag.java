//FormActionTag class @0-ABB599B9
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Calculate action attribute of the form HTML element.
  <pre><b>&lt;form_action/&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class FormActionTag extends TagSupport {

  public int doEndTag() {
    Component form = (Component)pageContext.getAttribute("parent");
    Page page = (Page)pageContext.getAttribute("page");
    try {
      pageContext.getOut().print(form.getFormAction());
    } catch (java.io.IOException e) {
      throw new Error("IO Problems");
    } catch (NullPointerException e) {
      throw new Error("form_action tag should be within the record or grid tag.");
    }
    return EVAL_PAGE;
  }
}
//End FormActionTag class

