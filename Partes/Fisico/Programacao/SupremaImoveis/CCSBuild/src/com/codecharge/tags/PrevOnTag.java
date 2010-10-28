//PrevOnTag class @0-EEFA5CCE
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show link to the previous page.
  <pre><b>&lt;prev_on&gt;..&lt;/prev_on&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link NavigatorTag navigator}
    <dt><b>Child elements:</b> <dd>{@link PageHrefTag page_href}
  </dl>
**/
public class PrevOnTag extends TagSupport {
	public int doStartTag() {
		NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
		if (navigator.hasPrev()) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}
}
//End PrevOnTag class

