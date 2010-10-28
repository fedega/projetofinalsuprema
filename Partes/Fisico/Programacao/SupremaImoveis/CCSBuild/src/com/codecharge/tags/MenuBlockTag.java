//MenuBlock Tag class @0-1C7EF679
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.*;


public class MenuBlockTag extends BodyTagSupport {

    private Component parent;
    private String name;
    private int count = 0;

    public void setName(String name) {this.name = name;}

	private Menu model;

    public int doStartTag() {

		Object parent = pageContext.getAttribute("parent");
		model = (Menu)parent;

		if ( "OpenLevel".equals(name) ) {
			if (model.isOpenLevel()) {
				com.codecharge.util.ModelAttribute ma = 
				((com.codecharge.util.ModelAttribute)model.getAttribute("Item_Level"));
				ma.setValue(""+model.getLevel());
				return EVAL_BODY_INCLUDE;
			} else {
				return SKIP_BODY;
			}
		} else if ("CloseItem".equals(name)) {
			if (model.isCloseItem()) {
				return EVAL_BODY_INCLUDE;
			} else {
				return SKIP_BODY;
			}			
		} else if ("CloseLevel".equals(name)) {
			if (model.getCloseLevel() != 0) {
				return EVAL_BODY_TAG;
			} else {
				return SKIP_BODY;
			}
		}

		return SKIP_BODY;
	}

	public int doAfterBody() throws JspTagException {
		try {
			if (count < model.getCloseLevel() && "CloseLevel".equals(name)) {
				BodyContent body = getBodyContent();
				body.writeOut(getPreviousOut());
				body.clearBody();
				count++;
			    return EVAL_BODY_TAG;
			} else {
				count = 0;
				return SKIP_BODY;	
			}
		} catch ( java.io.IOException ex) {
			throw new JspTagException("unexpected IO error");
	    }
	}

}


//End MenuBlock Tag class

