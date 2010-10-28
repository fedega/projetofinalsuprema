//PageNumberTag class @0-D6BF6D02
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Block to show number of page.
  <pre><b>&lt;pages&gt;..&lt;/pages&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link PageOnTag page_on}, {@link PageOffTag page_off}, {@link NavigatorTag navigator}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class PageNumberTag extends TagSupport {

  public int doStartTag() throws JspTagException {
    String value;
    Tag parent = getParent();
    if (parent instanceof PageOnTag || parent instanceof PageOffTag) {
      PagesTag pages = (PagesTag)findAncestorWithClass(this, PagesTag.class);
      value = String.valueOf(pages.getPage());
    } else if (parent instanceof NavigatorTag) {
      value = String.valueOf(((NavigatorTag)parent).getPageNumber());
    } else {
      throw new JspTagException("page_number tag is in wrong context");
    }
    try {
      pageContext.getOut().print(value);
    } catch(Exception e) {
      throw new JspTagException("unexpected IO problems");
    }
    return SKIP_BODY;
  }
}
//End PageNumberTag class

