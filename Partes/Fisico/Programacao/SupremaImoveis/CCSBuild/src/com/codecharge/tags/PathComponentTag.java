//PathComponentTag class @0-621890D0
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;

/**
  Defines block to be shown after every record, but not after the last one.
  <pre><b>&lt;path_component&gt;..&lt;/path_component&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link com.codecharge.tags.PathTag path}
    <dt><b>Child elements:</b> <dd>{@link com.codecharge.tags.ControlTag control}
  </dl>
**/
public class PathComponentTag extends BodyTagSupport {

  public int doStartTag() throws JspTagException {
      Path path = (Path)pageContext.getAttribute("parent");
      // TODO: check for null value
      if (path.hasNextRow()) {
        path.nextRow();
        if (path.hasNextRow()) {
          path.fireBeforeShowCategoryEvent(new Event());
          return EVAL_BODY_TAG;
        } else {
          return SKIP_BODY;
        }
      } else {
        return SKIP_BODY;
      }
	}

  public int doAfterBody() throws JspTagException {
      BodyContent body = getBodyContent();
      try {
        // write evaluation on the output Writer
        body.writeOut(getPreviousOut());
      } catch ( java.io.IOException ex) {
        throw new JspTagException("unexpected IO error");
      }

      // clear up so the next time we get here we are afresh.
      body.clearBody();

      Path path = (Path)pageContext.getAttribute("parent");
      if (path.hasNextRow()) {
        path.nextRow();
        if (path.hasNextRow()) {
          path.fireBeforeShowCategoryEvent(new Event());
          return EVAL_BODY_TAG;
        } else {
          return SKIP_BODY;
        }
      } else {
        return SKIP_BODY;
      }
  }
}
//End PathComponentTag class

