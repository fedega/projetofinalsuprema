//AscOffTag class @0-6D8B8683
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show unactive asc orter.
  <pre><b>&lt;asc_off&gt;..&lt;/asc_off&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b><dd>{@link SorterTag sorter}
    <dt><b>Child elements:</b><dd>{@link SorterHrefTag sorter_href}
  </dl>
**/
public class AscOffTag extends TagSupport {

	public int doStartTag() {
		SorterTag sorter = (SorterTag)findAncestorWithClass(this, SorterTag.class);
		if (sorter.isAscending()) {
			return SKIP_BODY;
		} else {
			return EVAL_BODY_INCLUDE;
		}
	}
}
//End AscOffTag class

