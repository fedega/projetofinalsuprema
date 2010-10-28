//PanelTag class @0-1CA3BC21
/* Created on Jul 2, 2004 */
package com.codecharge.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.Component;
import com.codecharge.components.Panel;
import com.codecharge.util.CCLogger;



public class PanelTag extends TagSupport {
    private String name;
    public int doStartTag() throws JspException {
        Component parent = (Component)pageContext.getAttribute("parent");
        if (parent == null) {
            CCLogger.getInstance().warn("PanelTag "+name+": parent is null.");
            return EVAL_BODY_INCLUDE;
        }
        Panel model = parent.getPanel(name);


//----------------------------------
		if (model.isUpdatePanel()) {
			try {
				pageContext.getOut().print("<div id = \""+model.getPanelId()+"\">");
			} catch(Exception exception) {
				//throw new Error("IO problems");
			}

			Object oFiler = ""+pageContext.getRequest().getAttribute(com.codecharge.Names.CCS_UPDATE_PANEL_FILTER);
			if (oFiler != null && !"".equals(""+oFiler) && model.getPanelId().equals(""+oFiler) ) {
        		try {
    	      		pageContext.getOut().print("<!--Panel["+model.getPanelId()+"][begin]-->");
				} catch(Exception exception) {
					//throw new Error("IO problems");
				}
			}
		}
//----------------------------------


        if (model == null) { // Never happens
            return EVAL_BODY_INCLUDE;
        }
        model.fireBeforeShowEvent();
        if (model.isVisible()) {
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }


//----------------------------------
    public int doEndTag() throws JspException {
		Component parent = (Component)pageContext.getAttribute("parent");
        if (parent == null) {
            CCLogger.getInstance().warn("PanelTag "+name+": parent is null.");
            return EVAL_BODY_INCLUDE;
        }


        Panel model = parent.getPanel(name);
		if (model.isUpdatePanel()) {

			try {
				pageContext.getOut().print("</div>");
			} catch(Exception exception) {
				//throw new Error("IO problems");
			}

			Object oFiler = ""+pageContext.getRequest().getAttribute(com.codecharge.Names.CCS_UPDATE_PANEL_FILTER);
			if (oFiler != null && !"".equals(""+oFiler) && model.getPanelId().equals(""+oFiler)) {
				try {
					pageContext.getOut().print("<!--Panel["+model.getPanelId()+"][end]-->");
				} catch(Exception exception) {
					//throw new Error("IO problems");
				}
			}
		}


		return EVAL_BODY_INCLUDE;
	}
//----------------------------------


    public void setName(String name) {
        this.name = name;
    }
}

//End PanelTag class

