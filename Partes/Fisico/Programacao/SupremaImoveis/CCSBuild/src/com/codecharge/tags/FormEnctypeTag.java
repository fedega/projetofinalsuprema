//FormEnctypeTag class @0-C03E27A8
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
   Set form enctype dynamically.
*/
public class FormEnctypeTag extends TagSupport {

  public int doEndTag() {
    Component c = (Component)pageContext.getAttribute("parent");
    try {
      if (c instanceof IRecord) {
        pageContext.getOut().print(((IRecord)c).getFormEnctype());
      }
    } catch (Exception e) {
      throw new Error("IO Problems");
    }
    return EVAL_PAGE;
  }
}
//End FormEnctypeTag class

