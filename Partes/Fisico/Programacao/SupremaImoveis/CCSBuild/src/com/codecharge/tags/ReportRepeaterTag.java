//ReportRepeaterTag class @0-E3CECE34
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Report;
import com.codecharge.util.CCLogger;

public class ReportRepeaterTag extends BodyTagSupport {
    private String blockName;
    private Object row;
    private Report report = null;
    
    public String getBlockName() {
        return blockName;
    }
    
    protected void setBlockName(String name) {
        this.blockName = name;
    }
    
    public int doStartTag() {
        try {
            report = (Report) pageContext.getAttribute("parent");
        } catch (ClassCastException e) {
        }
        if (report == null) {
            CCLogger.getInstance().error("Report model was not found in pageContext");
            return SKIP_BODY;
        }
        if (report.hasNextRow()) {
            report.nextReportRow();
            if (report.hasChild("NoRecords")) {
                report.getPanel("NoRecords").setVisible(false);
            }
            
            if (report.getPageNumber() > 1) {
                report.getGroup("Report").setHeaderVisibleOnPage(false);
            }
            if (report.getPageNumber() < report.getTotalPages()) {
                report.getGroup("Report").setFooterVisibleOnPage(false);
            }
        }
        // Always parse at least once to show Report header/footer
        // or 'No Records'
        return EVAL_BODY_TAG;
    }
    
    public int doAfterBody() throws JspTagException {
        if (bodyContent != null) {
            try {
                bodyContent.writeOut(getPreviousOut());
                bodyContent.clearBody();
            } catch (java.io.IOException e) {
                throw new JspTagException("Unexpected IO Exception");
            }
        }
        if (report.hasNextRow()) {
            report.nextReportRow();
            return EVAL_BODY_TAG;
        } else {
            return SKIP_BODY;
        }
    }
}

//End ReportRepeaterTag class

