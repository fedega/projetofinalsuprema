//ReportTag class @0-D8A99577
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags;

import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.Component;
import com.codecharge.components.Report;
import com.codecharge.events.Event;

/**
  Defines Report component.
  <pre><b>&lt;report name=".."&gt;..&lt;/report&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>(No parent elements)
    <dt><b>Child elements:</b> <dd>{@link ReportSectionTag section}
  </dl>
**/
public class ReportTag extends TagSupport {

    /** Parent **/
    private Component parent;

    private String name;
    /** Report name as defined in XML model. **/
    public void setName(String name) {this.name = name;}

    public int doStartTag() {
        parent = (Component)pageContext.getAttribute("parent");
        Report report  = (Report)parent.getChild(name);
        if (report == null) return SKIP_BODY;
        report.initIterator();
        report.fireBeforeShowEvent(new Event());
        if ( report.isVisible() ) {
            if (report.hasErrors()) {
              try {
                pageContext.getOut().print(report.getErrorsAsString());
              } catch (java.io.IOException e) {}
              return SKIP_BODY;
            }
            if (! report.hasNextRow()) {
                if (report.hasChild("NoRecords")) {
                    report.getPanel("NoRecords").setVisible(true);
                } 
            } else {
                if (report.hasChild("NoRecords")) {
                    report.getPanel("NoRecords").setVisible(false);
                } 
            }
            pageContext.setAttribute("parent", report);
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

//End ReportTag class

