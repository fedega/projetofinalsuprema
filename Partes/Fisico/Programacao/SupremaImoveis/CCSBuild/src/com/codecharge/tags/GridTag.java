//GridTag class @0-7B2BA8C7
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;

/**
  Defines Grid component.
  <pre><b>&lt;grid name=".."&gt;..&lt;/grid&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>(No parent elements)
    <dt><b>Child elements:</b> <dd>{@link SorterTag sorter}, {@link RepeaterTag repeater}, {@link NorecordsTag norecords}, {@link NavigatorTag navigator}
  </dl>
**/
public class GridTag extends TagSupport {

    /** Parent **/
    private Component parent;

    private boolean records;
    /** If Grid has records. **/
    public boolean hasRecords() {return records;}

    private String name;
    /** Grid name as defined in XML model. **/
    public void setName(String name) {this.name = name;}

    public int doStartTag() {
        parent = (Component)pageContext.getAttribute("parent");
        Page page = (Page)pageContext.getAttribute("page");
        Grid model  = (Grid)parent.getChild(name);
        if (model.hasErrors() && !(model instanceof EditableGrid)) {
          try{
            pageContext.getOut().println(model.getErrorsAsString());
          } catch (java.io.IOException ignore) {}
          return SKIP_BODY;
        }
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
//End GridTag class

