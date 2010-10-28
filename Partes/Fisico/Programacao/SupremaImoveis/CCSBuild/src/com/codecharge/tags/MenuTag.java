//Menu Tag class @0-40A455F6
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;


public class MenuTag extends TagSupport {

    private Component parent;
    private String name;

    public void setName(String name) {this.name = name;}

    public int doStartTag() {
        parent = (Component)pageContext.getAttribute("parent");

        Menu model = (Menu) parent.getChild(name);

	if (model == null) return SKIP_BODY;
        
	if ( model.isVisible() ) {
		
		com.codecharge.util.ModelAttribute ma = 
		((com.codecharge.util.ModelAttribute)model.getAttribute("MenuType"));
		ma.setValue(model.getMenuFormattedType());

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

//End Menu Tag class

