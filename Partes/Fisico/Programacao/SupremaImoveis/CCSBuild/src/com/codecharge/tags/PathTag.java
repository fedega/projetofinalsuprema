//PathTag class @0-6E035A15
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;

/**
  Defines block to be shown after every record, but not after the last one.
  <pre><b>&lt;path name=".."&gt;..&lt;/path&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>(No parent elements)
    <dt><b>Child elements:</b> <dd>{@link com.codecharge.tags.PathComponentTag path_component}, {@link com.codecharge.tags.CurrentCategoryTag current_category}, {@link com.codecharge.tags.ControlTag control}
  </dl>
**/
public class PathTag extends TagSupport {

  private Component parent;

  private String name;
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int doStartTag() {
    parent = (Component)pageContext.getAttribute("parent");
    Page page = (Page)pageContext.getAttribute("page");
    Path model = (Path)parent.getChild(name);
    model.fireBeforeShowEvent(new Event());
    if ( model != null && model.isVisible() ) {
        pageContext.setAttribute("parent", model);
        return EVAL_BODY_INCLUDE;
    } else {
        return SKIP_BODY;
    }
	}
  public int doEndTag() {
    pageContext.setAttribute("parent", parent);
    return EVAL_PAGE;
  }
}
//End PathTag class

