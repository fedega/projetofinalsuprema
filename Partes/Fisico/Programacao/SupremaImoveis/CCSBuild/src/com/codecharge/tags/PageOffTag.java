//PageOffTag class @0-AE133770
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Block to show active page, that is current page.
  <pre><b>&lt;page_off&gt;..&lt;/page_off&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link PagesTag pages}
    <dt><b>Child elements:</b> <dd>{@link PageNumberTag page_number}
  </dl>
**/
public class PageOffTag extends TagSupport {

  public int doStartTag() {
    PagesTag parent = (PagesTag)findAncestorWithClass(this, PagesTag.class);
    Navigable grid = (Navigable)pageContext.getAttribute("parent");
    if (grid.getPageNumber() == parent.getPage()) {
      return EVAL_BODY_INCLUDE;
    } else {
      return SKIP_BODY;
    }
  }
}
//End PageOffTag class

