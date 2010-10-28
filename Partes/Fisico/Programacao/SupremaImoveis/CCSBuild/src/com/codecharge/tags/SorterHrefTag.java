//SorterHrefTag class @0-CFE76157
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.util.*;

/**
  Calculates Sorter href and inserts it as href attribute of anchor HTML element.
  <pre><b>&lt;sorter_href&gt;..&lt;/sorter_href&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link SorterTag sorter}, {@link AscOffTag asc_off}, {@link DescOffTag desc_off}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class SorterHrefTag extends TagSupport {

  public int doEndTag() {
    SorterTag sorter = (SorterTag)findAncestorWithClass(this, SorterTag.class);
    Sortable grid = (Sortable) pageContext.getAttribute("parent");
    Page page = (Page)pageContext.getAttribute("page");

    CCSURL url = page.getHttpGetParams().toCCSURL(grid.getSorter(sorter.getName()).getExcludeParams());

    //StringBuffer value = new StringBuffer();
    if (page.isIncluded()) {
      //value.append( page.getRequest().getRequestURI() );
        url.setUrl(page.getRequest().getRequestURI());
    } else {
      //value.append(page.getName()).append(".jsp");
      url.setUrl(page.getName()+".jsp");
    }

    
    //value.append("?").append(grid.getName());

    url.setParameter(grid.getName()+"Order",sorter.getName());
    

    //value.append("Order=").append(sorter.getName());
    //value.append("&").append(grid.getName()).append("Dir=");
    Tag parent = getParent();
    String dir = "";
    if (parent instanceof SorterTag) {
      if (sorter.isAscending() && !sorter.isDescending()) {
        //value.append("DESC");
        dir="DESC";
      } else {
        //value.append("ASC");
        dir="ASC";
      }
    } else if (parent instanceof AscOffTag) {
      //value.append("ASC");
      dir="ASC";
    } else if (parent instanceof DescOffTag) {
      //value.append("DESC");
      dir="DESC";
    }

    url.setParameter(grid.getName()+"Dir",dir);

    //CCSURL url = page.getHttpGetParams().toCCSURL(grid.getSorter(sorter.getName()).getExcludeParams());

    //String query = page.getHttpGetParams().toString(grid.getSorter(sorter.getName()).getExcludeParams());

    //if (query.length() > 0) value.append("&").append(query);
    try {
      //pageContext.getOut().print(value.toString());
      pageContext.getOut().print(url.toString());
    } catch (Exception e) {
      throw new Error("IO Problems");
    }
    return EVAL_PAGE;
  }
}
//End SorterHrefTag class

