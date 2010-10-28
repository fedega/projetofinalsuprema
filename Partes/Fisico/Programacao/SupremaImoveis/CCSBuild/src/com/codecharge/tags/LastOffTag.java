//LastOffTag class @0-1755738F
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show not active link to the last page or empty block at all.
  <pre><b>&lt;last_off&gt;..&lt;/first_on&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link NavigatorTag navigator}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class LastOffTag extends TagSupport {
	public int doStartTag() {
		NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
		if (navigator.hasNext()) {
			return SKIP_BODY;
		} else {
			return EVAL_BODY_INCLUDE;
		}
	}
}
//End LastOffTag class

