//PageOnTag class @0-6B4DF6A1
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Block to show not active page, that is link to that page.
  <pre><b>&lt;page_on&gt;..&lt;/page_on&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link PagesTag pages}
    <dt><b>Child elements:</b> <dd>{@link PageHrefTag page_href}, {@link PageNumberTag page_number}
  </dl>
**/
public class PageOnTag extends TagSupport {

  public int doStartTag() {
    PagesTag parent = (PagesTag)findAncestorWithClass(this, PagesTag.class);
    Navigable grid = (Navigable)pageContext.getAttribute("parent");
    if (grid.getPageNumber() != parent.getPage()) {
      return EVAL_BODY_INCLUDE;
    } else {
      return SKIP_BODY;
    }
  }
}
//End PageOnTag class

