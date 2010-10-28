//DescOffTag class @0-3660FF1A
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
  Block to show unactive desc sorter.
  <pre><b>&lt;desc_off&gt;..&lt;/desc_off&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b><dd>{@link SorterTag sorter}
    <dt><b>Child elements:</b><dd>{@link SorterHrefTag sorter_href}
  </dl>
**/
public class DescOffTag extends TagSupport {
	
  public int doStartTag() {
    SorterTag sorter = (SorterTag)findAncestorWithClass(this, SorterTag.class);
    if (sorter.isDescending()) {
      return SKIP_BODY;
    } else {
      return EVAL_BODY_INCLUDE;
    }
  }
}
//End DescOffTag class

