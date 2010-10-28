//FirstOffTag class @0-1318A9B9
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show not active link to the first page or empty block at all.
  <pre><b>&lt;first_off&gt;..&lt;/first_off&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link NavigatorTag navigator}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class FirstOffTag extends TagSupport {
	public int doStartTag() {
		NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
		if (navigator.hasPrev()) {
			return SKIP_BODY;
		} else {
			return EVAL_BODY_INCLUDE;
		}
	}
}
//End FirstOffTag class

