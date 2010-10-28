//SorterTag class @0-0C343167
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.Event;

/**
  Defines sorting element of the Grid component.
  <pre><b>&lt;sorter name=".."&gt;..&lt;/sorter&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link GridTag grid}
    <dt><b>Child elements:</b> <dd>{@link SorterHrefTag sorter_href}, {@link AscOnTag asc_on}, {@link AscOffTag asc_off}, {@link DescOnTag desc_on}, {@link DescOffTag desc_off}
  </dl>
**/
public class SorterTag extends TagSupport {

  private String name;
  /** Name of the Sorter as defined in XML model. **/
  public void setName(String name) {this.name = name;}
  /** Name of the Sorter as defined in XML model. **/
  public String getName() {return name;}

  private String column;
  /** Column to sort. **/
  public void setColumn(String column) {this.column = column;}
  /** Column to sort. **/
  public String getColumn() {return column;}

  private boolean asc;
  /** Sorted asc? **/
  public boolean isAscending() {return asc;}
  private boolean desc;
  /** Sorted desc? **/
  public boolean isDescending() {return desc;}

  public int doStartTag() {
    Sortable grid = (Sortable)pageContext.getAttribute("parent");
    String sort = grid.getSort();
    String dir = grid.getDir();
    if (sort == null) {
      asc = false; desc = false;
    } else if (sort.equals( name )){
      if ("desc".equalsIgnoreCase( dir )) {
        asc = false; desc = true;
      } else {
        asc = true; desc = false;
      }
    } else {
      asc = false; desc = false;
    }
    Sorter smodel = (Sorter)grid.getSorter(name);

    try {
        if (smodel != null) smodel.fireBeforeShowEvent(new Event());
    } catch(Exception e22) {
        e22.printStackTrace();
    }
    if (smodel != null && smodel.isVisible()) {
      return EVAL_BODY_INCLUDE;
    } else {
      return SKIP_BODY;
    }
  }
}
//End SorterTag class

