//TotalPagesTag class @0-47521B3E
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.Navigable;

/**
  Block to show total number of pages.
  <pre><b>&lt;total_pages&gt;..&lt;/total_pages&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link NavigatorTag pages}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class TotalPagesTag extends TagSupport {

    public int doStartTag() throws JspTagException {
        Navigable component = (Navigable) pageContext.getAttribute("parent");
        try {
            pageContext.getOut().print(String.valueOf(component.getTotalPages()));
        } catch (Exception e) {
            throw new Error("IO problems");
        }
        return SKIP_BODY;
    }
}

//End TotalPagesTag class

