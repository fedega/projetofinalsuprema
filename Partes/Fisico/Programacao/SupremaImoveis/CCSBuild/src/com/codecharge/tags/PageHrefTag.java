//PageHrefTag class @0-18A1EF63
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.util.*;

/**
  Calculates page href and inserts it as href attribute of anchor HTML element.
  <pre><b>&lt;page_href&gt;..&lt;/page_href&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link FirstOnTag first_on}, {@link PrevOnTag prev_on}, {@link NextOnTag next_on}, {@link LastOnTag last_on}, {@link PageOnTag page_on}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class PageHrefTag extends TagSupport {

  public int doEndTag() throws JspTagException {
    Navigable grid = (Navigable)pageContext.getAttribute("parent");
    Page page = (Page)pageContext.getAttribute("page");
    int lastPage = grid.getTotalPages();
    String reqUri = page.getRequest().getRequestURI();
    int pos = reqUri.lastIndexOf("/");
    if ( pos > -1 ) {
        reqUri = reqUri.substring(pos+1);
    }

    NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
    CCSURL url = page.getHttpGetParams().toCCSURL(grid.getNavigator(navigator.getName()).getExcludeParams());
    
    //StringBuffer value = new StringBuffer();
    if (!StringUtils.isEmpty(reqUri)) {
        url.setUrl( SessionStorage.getInstance( page.getRequest() ).encodeURL( reqUri ) );
        //value.append( SessionStorage.getInstance( page.getRequest() ).encodeURL( reqUri ));
    }

    
    //value.append("?").append(grid.getName()).append("Page=");
    String num = "";
    Tag parent = getParent();
    if (parent instanceof FirstOnTag) {
        //value.append("1");
        num="1";
    } else if (parent instanceof PrevOnTag) {
        //value.append(String.valueOf(grid.getPageNumber()-1));
        num=String.valueOf(grid.getPageNumber()-1);
    } else if (parent instanceof NextOnTag) {
        //value.append(String.valueOf(grid.getPageNumber()+1));
        num=String.valueOf(grid.getPageNumber()+1);
    } else if (parent instanceof LastOnTag) {
        //value.append(String.valueOf(lastPage));
        num=String.valueOf(lastPage);
    } else if (parent instanceof PageOnTag) {
        PagesTag pages = (PagesTag)findAncestorWithClass(this, PagesTag.class);
        //value.append(String.valueOf(pages.getPage()));
        num=String.valueOf(pages.getPage());
    }

    url.setParameter(grid.getName()+"Page",num);

    //NavigatorTag navigator = (NavigatorTag)findAncestorWithClass(this, NavigatorTag.class);
    //String query = page.getHttpGetParams().toString(grid.getNavigator(navigator.getName()).getExcludeParams());
    //if (query.length() > 0) value.append("&").append(query);
    try {
        //pageContext.getOut().print(value);
        pageContext.getOut().print(url.toString());

    } catch(Exception e) {
        throw new JspTagException("IO problems");
    }
    return SKIP_BODY;
  }
}
//End PageHrefTag class

