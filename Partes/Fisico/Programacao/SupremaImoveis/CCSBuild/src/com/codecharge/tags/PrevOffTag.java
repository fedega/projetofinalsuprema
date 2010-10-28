//PrevOffTag class @0-AD74C468
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show not active link to the previous page or empty block at all.
  <pre><b>&lt;prev_off&gt;..&lt;/prev_off&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link NavigatorTag navigator}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class PrevOffTag extends TagSupport {
	public int doStartTag() {
		NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
		if (navigator.hasPrev()) {
			return SKIP_BODY;
		} else {
			return EVAL_BODY_INCLUDE;
		}
	}
}
//End PrevOffTag class

