//MenuIteratorTag class @0-4710722F

package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class MenuIteratorTag extends BodyTagSupport {

	private Menu model;

    public int doStartTag() throws JspTagException {
		Object parent = pageContext.getAttribute("parent");
		model = (Menu)parent;
		model.initRender();
		if (!model.hasNexItem()) {
			return SKIP_BODY;
		} else {
			model.nextItem();

			com.codecharge.util.ModelAttribute ma = 
				((com.codecharge.util.ModelAttribute)model.getAttribute("Submenu"));
			if (model.isCloseItem()) {
				ma.setValue("");
			} else {
				ma.setValue("submenu");
			}			

			Link link = (Link) model.getChild("ItemLink");
			link.setValue(StringUtils.toHtml(model.getActiveItemCaption()));
			link.setHrefSourceValue(model.getActiveItemUrl());

			ma = ((com.codecharge.util.ModelAttribute)model.getAttribute("Target"));
			ma.setValue(model.getTarget());

			ma = ((com.codecharge.util.ModelAttribute)model.getAttribute("Title"));
			ma.setValue(model.getTitle());

			return EVAL_BODY_TAG;
		}
    }

    public int doAfterBody() throws JspTagException {

		BodyContent body = getBodyContent();
        try {
          body.writeOut(getPreviousOut());
        } catch ( java.io.IOException ex) {
          throw new JspTagException("unexpected IO error");
        }

        body.clearBody();


		if (!model.hasNexItem()) {
			return SKIP_BODY;
		} else {
			model.nextItem();

			com.codecharge.util.ModelAttribute ma = 
				((com.codecharge.util.ModelAttribute)model.getAttribute("Submenu"));
			if (model.isCloseItem()) {
				ma.setValue("");
			} else {
				ma.setValue("submenu");
			}			

			Link link = (Link) model.getChild("ItemLink");
			link.setValue(model.getActiveItemCaption());
			link.setHrefSourceValue(model.getActiveItemUrl());

			ma = ((com.codecharge.util.ModelAttribute)model.getAttribute("Target"));
			ma.setValue(model.getTarget());

			ma = ((com.codecharge.util.ModelAttribute)model.getAttribute("Title"));
			ma.setValue(model.getTitle());

			return EVAL_BODY_TAG;
		}
    }


}


//End MenuIteratorTag class

