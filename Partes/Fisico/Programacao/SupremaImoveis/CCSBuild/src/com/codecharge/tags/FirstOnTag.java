//FirstOnTag class @0-450BC6BA
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show link to the first page.
  <pre><b>&lt;first_on&gt;..&lt;/first_on&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link NavigatorTag navigator}
    <dt><b>Child elements:</b> <dd>{@link PageHrefTag page_href}
  </dl>
**/
public class FirstOnTag extends TagSupport {
	public int doStartTag() {
		NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
		if (navigator.hasPrev()) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}
}
//End FirstOnTag class

