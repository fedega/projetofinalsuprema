//WeekdayTag class @0-A7062F0A
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.tagext.TagSupport;

public class WeekdayTag extends TagSupport {

    public int doStartTag() {

        try {
            pageContext.getOut().print(pageContext.getAttribute("weekday"));
        } catch (java.io.IOException e) {
            throw new Error("Unexpected IO Exception");
        }
        return SKIP_BODY;
    }

}

//End WeekdayTag class

