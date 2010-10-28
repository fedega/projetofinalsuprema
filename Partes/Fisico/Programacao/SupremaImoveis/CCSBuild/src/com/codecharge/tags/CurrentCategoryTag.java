//CurrentCategoryTag class @0-74B4BC04
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;

/**
  Defines block to be shown after every record, but not after the last one.
  <pre><b>&lt;current_category&gt;..&lt;/current_category&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link com.codecharge.tags.PathTag path}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class CurrentCategoryTag extends TagSupport {

	public int doStartTag() {
    Path path = (Path)pageContext.getAttribute("parent");
    if (path.currentRow() != null) {
      path.fireBeforeShowCategoryEvent(new Event());
      return EVAL_BODY_INCLUDE;
    } else {
      return SKIP_BODY;
    }
	}
}
//End CurrentCategoryTag class

