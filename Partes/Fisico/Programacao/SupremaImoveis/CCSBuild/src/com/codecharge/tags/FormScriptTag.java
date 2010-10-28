//FormScriptTag class @0-0BDFE168
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Calculate action attribute of the form HTML element.
  <pre><b>&lt;form_script/&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link GridTag grid}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class FormScriptTag extends TagSupport {

  public int doEndTag() {
    EditableGrid grid = (EditableGrid)pageContext.getAttribute("parent");
    Page page = (Page)pageContext.getAttribute("page");
    try {
      pageContext.getOut().print(grid.getFormScript());
    } catch (Exception e) {
      throw new Error("IO Problems");
    }
    return EVAL_PAGE;
  }
}
//End FormScriptTag class

