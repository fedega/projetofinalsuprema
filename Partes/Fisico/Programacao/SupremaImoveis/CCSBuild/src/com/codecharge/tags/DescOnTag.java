//DescOnTag class @0-53B10F5B
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show active desc sorter.
  <pre><b>&lt;desc_on&gt;..&lt;/desc_on&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b><dd>{@link SorterTag sorter}
    <dt><b>Child elements:</b><dd>(No child elements)
  </dl>
**/
public class DescOnTag extends TagSupport {
	
	public int doStartTag() {
		SorterTag sorter = (SorterTag)findAncestorWithClass(this, SorterTag.class);
		if (sorter.isDescending()) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}
}
//End DescOnTag class

