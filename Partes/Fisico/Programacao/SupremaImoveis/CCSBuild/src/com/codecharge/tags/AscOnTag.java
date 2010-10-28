//AscOnTag class @0-7873860E
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show active asc orter.
  <pre><b>&lt;asc_on&gt;..&lt;/asc_on&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b><dd>{@link SorterTag sorter}
    <dt><b>Child elements:</b><dd>(No child elements)
  </dl>
**/
public class AscOnTag extends TagSupport {
	
	public int doStartTag() {
		SorterTag sorter = (SorterTag)findAncestorWithClass(this, SorterTag.class);
		if (sorter.isAscending()) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}
}
//End AscOnTag class

