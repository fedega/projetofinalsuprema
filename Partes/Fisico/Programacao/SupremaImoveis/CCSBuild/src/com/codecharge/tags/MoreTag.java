//MoreTag class @0-C01905B5
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Block with link in Directory shown when there are more subcategories to show.
  <pre><b>&lt;more&gt;..&lt;/more&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(None)
    <dt><b>Parent elements:</b> <dd>{@link DirectoryTag directory}
    <dt><b>Child elements:</b> <dd>(@link ControlTag control)
  </dl>
**/
public class MoreTag extends TagSupport {

  public int doStartTag() {
      SubcategoriesTag subcategories = (SubcategoriesTag)findAncestorWithClass(this, SubcategoriesTag.class);
      String elm = subcategories.getElement();
      if (elm.equals("LAST")) {
        java.util.Iterator state = subcategories.getState();
        if (state.hasNext()) {
          return EVAL_BODY_INCLUDE;
        } else {
          return SKIP_BODY;
        }
      }
      return SKIP_BODY;
	}
}
//End MoreTag class

