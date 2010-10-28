//CalendarTag class @0-E4CD800C
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags.calendar;

import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.Component;
import com.codecharge.components.Calendar;
import com.codecharge.components.calendar.CalendarItem;
import com.codecharge.events.Event;

import com.codecharge.util.StringUtils;
import com.codecharge.util.CCLogger;

/**
  Defines Report component.
  <pre><b>&lt;report name=".."&gt;..&lt;/report&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>(No parent elements)
    <dt><b>Child elements:</b> <dd>{@link ReportSectionTag section}
  </dl>
**/
public class CalendarTag extends TagSupport {

    /** Parent **/
    private Component parent;

    private String name;
    private String style;
    private String property;
    /** Report name as defined in XML model. **/
    public void setName(String name) {this.name = name;}
    public void setStyle(String style) {this.style = style;}
    public void setProperty(String property) {this.property = property;}

    public int doStartTag() {
        parent = (Component)pageContext.getAttribute("parent");
        Calendar calendar = null;
        if (parent instanceof Calendar) {
            calendar = (Calendar) parent;
        } else {
            calendar = (Calendar)parent.getChild(name);
        }
        if (calendar == null || ! calendar.isVisible()) {
            return SKIP_BODY;
        }

        if (! StringUtils.isEmpty(this.style)) {
            String dayStyle = null;
            if ("WeekDays".equalsIgnoreCase(this.style)) {
                dayStyle = (String) pageContext.getAttribute("calenderStyle");
            }
            if (StringUtils.isEmpty(dayStyle)) {
                //dayStyle = calendar.getStyle(this.style, 0, (CalendarItem) pageContext.getAttribute("currentMonth"));
                dayStyle = calendar.getCurrentStyle();
            }
            try {
                pageContext.getOut().print(dayStyle);
            } catch (java.io.IOException e) {
                CCLogger.getInstance().error("", e);
            }
            return SKIP_BODY;
        } else if (! StringUtils.isEmpty(this.property)) {
            if ("MonthsInRow".equalsIgnoreCase(this.property)) {
                try {
                    pageContext.getOut().print(calendar.getMonthsInRow());
                } catch (java.io.IOException e) {
                    CCLogger.getInstance().error("", e);
                }
                return SKIP_BODY;
            }
        } else {
            pageContext.removeAttribute("currentMonth");
            pageContext.removeAttribute("currentDay");
            pageContext.removeAttribute("daySeparator");
            pageContext.removeAttribute("eventSeparator");
            pageContext.removeAttribute("monthRowSeparator");
            pageContext.removeAttribute("weekDayCounter");
            pageContext.removeAttribute("monthDayCounter");
            pageContext.removeAttribute("monthCounter");
            pageContext.removeAttribute("totalMonthCounter");
            pageContext.removeAttribute("weekSeparator");
            pageContext.removeAttribute("weekdaySeparator");
               
            calendar.initializeRows();
            calendar.hasNextItem();
            calendar.fireBeforeShowEvent(new Event());
            if (calendar.isVisible()) {
                if (calendar.hasErrors()) {
                    try {
                        pageContext.getOut().print(calendar.getErrorsAsString());
                    } catch (java.io.IOException e) {
                        CCLogger.getInstance().error("", e);
                    }
                    return SKIP_BODY;
                }
                calendar.initializeRows();
                calendar.hasNextItem();
                pageContext.setAttribute("currentYear", calendar.getCurrentItem());
                pageContext.setAttribute("parent", calendar);
                return EVAL_BODY_INCLUDE;
            } else {
                return SKIP_BODY;
            }
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() {
        if (StringUtils.isEmpty(this.style) && StringUtils.isEmpty(this.property)) {
            pageContext.setAttribute("parent", parent);
            pageContext.removeAttribute("currentMonth");
            pageContext.removeAttribute("currentDay");
            pageContext.removeAttribute("daySeparator");
            pageContext.removeAttribute("eventSeparator");
            pageContext.removeAttribute("monthRowSeparator");
            pageContext.removeAttribute("weekDayCounter");
            pageContext.removeAttribute("monthDayCounter");
            pageContext.removeAttribute("monthCounter");
            pageContext.removeAttribute("totalMonthCounter");
            pageContext.removeAttribute("weekSeparator");
            pageContext.removeAttribute("weekdaySeparator");
            pageContext.removeAttribute("currentYear");
        }
        return EVAL_PAGE;
    }
}

//End CalendarTag class

