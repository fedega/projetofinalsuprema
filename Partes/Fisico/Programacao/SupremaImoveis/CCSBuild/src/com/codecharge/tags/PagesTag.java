//PagesTag class @0-62A151A7
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Show navigation pages in a loop.
  <pre><b>&lt;pages&gt;..&lt;/pages&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link NavigatorTag navigator}
    <dt><b>Child elements:</b> <dd>{@link PageOnTag page_on}, {@link PageOffTag page_off}
  </dl>
**/
public class PagesTag extends BodyTagSupport {

  private int start;
  private int end;
  private int page = 0;
  /** Page to show in this iteration. **/
  public int getPage() {return page;}

  public int doStartTag() {
    NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
    start = page = navigator.getPageLinksStart();
    end = navigator.getPageLinksEnd();
    if (start > end) return SKIP_BODY;
    return EVAL_BODY_TAG;
  }
  public int doAfterBody() throws JspTagException {
    BodyContent body = getBodyContent();
    try {
      body.writeOut(getPreviousOut());
    } catch ( java.io.IOException ex) {
      throw new JspTagException("unexpected IO error");
    }
    body.clearBody();
    if (page < end) {
      page++;
      return EVAL_BODY_TAG;
    } else {
      return SKIP_BODY;
    }
  }
}
//End PagesTag class

