//DirectoryTag class @0-0D2EC364
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;

/**
  Defines Directory component.
  <pre><b>&lt;directory name=".."&gt;..&lt;/directory&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>(No parent elements)
    <dt><b>Child elements:</b> <dd>{@link SubcategoriesTag sorter}, {@link NorecordsTag norecords}, {@link SeparatorTag separator}
  </dl>
**/
public class DirectoryTag extends TagSupport {

    /** Parent **/
    private Component parent;

    //private boolean records;
    /** If Directory has records. **/
    //public boolean hasRecords() {return records;}

    private String name;
    /** Grid name as defined in XML model. **/
    public void setName(String name) {this.name = name;}

    public int doStartTag() {
        parent = (Component)pageContext.getAttribute("parent");
        Page page = (Page)pageContext.getAttribute("page");
        Directory model  = (Directory)parent.getChild(name);
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
//End DirectoryTag class

