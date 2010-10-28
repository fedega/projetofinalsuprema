//CalendarNavigatorRepeaterTag class @0-76072AB0
package com.codecharge.tags.calendar;

import com.codecharge.components.*;
import com.codecharge.components.calendar.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class CalendarNavigatorRepeaterTag extends BodyTagSupport {

    private CalendarNavigator navigator;
    private int type;
    public void setName(String name) {
        this.type = CalendarNavigator.ITEM;
        if ("Years".equalsIgnoreCase(name)) {
            this.type = CalendarNavigator.YEAR;
        }
    }
    public int getType() {
        return this.type;
    }

    public int doStartTag() throws JspTagException {
        Object nav = pageContext.getAttribute("navigator");
        if (nav != null) {
            if (nav instanceof CalendarNavigator) navigator = (CalendarNavigator) nav;
        } else {
            throw new JspTagException("CalendarNavigatorRepeater tag: wrong context, repeater should be a child of a Calendar tag");
        }

        navigator.iteratorInit(this.type);
        if (navigator.hasNextItem(this.type)) {
            if (this.type == CalendarNavigator.YEAR) {
                pageContext.setAttribute("yearsHeader", "");
            } else {
                pageContext.setAttribute("itemsHeader", "");
            }
            pageContext.setAttribute("cn_item", navigator.nextItem(this.type));
            return EVAL_BODY_TAG;
        }
        return SKIP_BODY;
    }

    public int doAfterBody() throws JspTagException {
        BodyContent body = getBodyContent();
        try {
            // write evaluation on the output Writer
            body.writeOut(getPreviousOut());
        } catch ( java.io.IOException ex) {
            throw new JspTagException("unexpected IO error");
        }
        // clear up so the next time we get here we are afresh.
        body.clearBody();

        if (navigator.hasNextItem(this.type)) {
            pageContext.setAttribute("cn_item", navigator.nextItem(this.type));
            return EVAL_BODY_TAG;
        }
        return SKIP_BODY;
    }

    public int doEndTag() {
        pageContext.removeAttribute("cn_item");
        return EVAL_PAGE;
    }
}
//End CalendarNavigatorRepeaterTag class

