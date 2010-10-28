//FlashChart Tag class @0-45554344
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;


public class FlashChartTag extends TagSupport {

    /** Parent **/
    private Component parent;
    private String name;

    public void setName(String name) {this.name = name;}

    public int doStartTag() {
        parent = (Component)pageContext.getAttribute("parent");
        //Page page = (Page)pageContext.getAttribute("page");

        FlashChart model = (FlashChart)parent.getChild(name);
	model.fireBeforeShowEvent(new Event());
		if (model == null) return SKIP_BODY;

	        if ( model.isVisible() ) {
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
//End FlashChart Tag class

