//ErrorTextTag class @0-58103B92
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.validation.*;
import com.codecharge.Names;

/**
  Defines Record component.
  <pre><b>&lt;error_text&gt;..&lt;/error_text&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link ErrorBlockTag error_block}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class ErrorTextTag extends TagSupport {

  public int doEndTag() {
    Component model = (Component)pageContext.getAttribute("parent");
    RepeaterTag repeater = (RepeaterTag)findAncestorWithClass(this, RepeaterTag.class);
    if (repeater != null) {
      if (model instanceof EditableGrid) {
        ErrorCollection errors = (ErrorCollection)((EditableGrid)model).currentRow().get(Names.CCS_ROW_ERROR_KEY);
        try {
          pageContext.getOut().print(errors.getErrorsAsString());
        } catch (Exception e) {
          throw new Error("IO Problems");
        }
      }
    }
    try {
      pageContext.getOut().print(model.getErrorsAsString());
    } catch (Exception e) {
      throw new Error("IO Problems");
    }
    return EVAL_PAGE;
  }
}
//End ErrorTextTag class

