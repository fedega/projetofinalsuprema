//CalendarNavigatorSectionTag class @0-6ACB3BC1
package com.codecharge.tags.calendar;

import com.codecharge.components.*;
import com.codecharge.components.calendar.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class CalendarNavigatorSectionTag extends TagSupport {

    private CalendarNavigator navigator;
    private Calendar calendar;
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    public int doStartTag() {
        this.navigator = (CalendarNavigator) pageContext.getAttribute("navigator");
        this.calendar = (Calendar) pageContext.getAttribute("parent");

        pageContext.setAttribute("cn_context", this.name);

        /*( "Prev_Year".equalsIgnoreCase(this.name) || "Prev".equalsIgnoreCase(this.name) || 
                "Next".equalsIgnoreCase(this.name) || "Next_Year".equalsIgnoreCase(this.name) )*/
        if ("Prev_Year".equalsIgnoreCase(this.name) || "Next_Year".equalsIgnoreCase(this.name) ||
                 (( "Prev".equalsIgnoreCase(this.name) || "Next".equalsIgnoreCase(this.name) ) && 
                    (this.calendar.getMonths()!=Calendar.CALENDAR_MONTHS_YEAR) )
                ) {
            return EVAL_BODY_INCLUDE;
        } else if ("Regular_Month".equalsIgnoreCase(this.name)
                || "Regular_Quarter".equalsIgnoreCase(this.name)
                || "Regular_Year".equalsIgnoreCase(this.name)
                ) {
            CalendarNavigatorRepeaterTag repeater = 
                    (CalendarNavigatorRepeaterTag)findAncestorWithClass(this, 
                    CalendarNavigatorRepeaterTag.class);
            if (! this.navigator.currentItem(repeater.getType()).isSelected()) {
                return EVAL_BODY_INCLUDE;
            }
        } else if ("Current_Month".equalsIgnoreCase(this.name)
                || "Current_Quarter".equalsIgnoreCase(this.name)
                || "Current_Year".equalsIgnoreCase(this.name)
                ) {
            CalendarNavigatorRepeaterTag repeater = 
                    (CalendarNavigatorRepeaterTag)findAncestorWithClass(this, 
                    CalendarNavigatorRepeaterTag.class);
            if (this.navigator.currentItem(repeater.getType()).isSelected()) {
                return EVAL_BODY_INCLUDE;
            }
        } else if ("ItemsHeader".equalsIgnoreCase(this.name)) {
            if (pageContext.getAttribute("itemsHeader") != null) {
                pageContext.removeAttribute("itemsHeader");
                return EVAL_BODY_INCLUDE;
            }
        } else if ("ItemsFooter".equalsIgnoreCase(this.name)) {
            CalendarNavigator navigator = null;
            Object nav = pageContext.getAttribute("navigator");
            if (nav != null) {
                if (nav instanceof CalendarNavigator) navigator = (CalendarNavigator) nav;
            }
            if (navigator != null) {
                if (! navigator.hasNextItem()) {
                    return EVAL_BODY_INCLUDE;
                }
            }
        } else if ("YearsHeader".equalsIgnoreCase(this.name)) {
            if (pageContext.getAttribute("yearsHeader") != null) {
                pageContext.removeAttribute("yearsHeader");
                return EVAL_BODY_INCLUDE;
            }
        } else if ("YearsFooter".equalsIgnoreCase(this.name)) {
            CalendarNavigator navigator = null;
            Object nav = pageContext.getAttribute("navigator");
            if (nav != null) {
                if (nav instanceof CalendarNavigator) navigator = (CalendarNavigator) nav;
            }
            if (navigator != null) {
                if (! navigator.hasNextItem(CalendarNavigator.YEAR)) {
                    return EVAL_BODY_INCLUDE;
                }
            }
        }
        return SKIP_BODY;
    }

    public int doEndTag() {
        pageContext.removeAttribute("cn_context");
        return EVAL_PAGE;
    }
}
//End CalendarNavigatorSectionTag class

