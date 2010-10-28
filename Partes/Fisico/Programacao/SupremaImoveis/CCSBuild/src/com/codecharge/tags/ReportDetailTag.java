//ReportDetailTag class @0-03AE8894
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.codecharge.components.Report;
import com.codecharge.util.CCLogger;

public class ReportDetailTag extends BodyTagSupport {
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


        if (report.getCurrentRow() != null) {

            if (report.getCurrentRow().isVisibleOnPage()) {
                report.fireBeforeShowRowEvent();
            }

            if (report.getCurrentRow().isVisible()) {
            // if ReportRepeater turned NoRecords on then we have no records and
            // will skip Details Section

                if (report.hasChild("NoRecords") && report.getPanel("NoRecords").isVisible()) {
                    return SKIP_BODY;
                }
                if (report.hasChild("Separator")) {
                    report.getPanel("Separator").setVisible(false);
                    if (! report.getActiveGroup().isClosed()) {
                        report.getPanel("Separator").setVisible(true);
                    }
                } 
                return BodyTag.EVAL_BODY_TAG;

            } else {
                return BodyTag.SKIP_BODY;
            }


        } else {
            return BodyTag.SKIP_BODY;
        }

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
        // if (block closes) end iteration
        // else continue iteration
        if (report.getActiveGroup().isClosed()) {
            return SKIP_BODY;
        } else {
            report.nextReportRow();
            if (report.getCurrentRow().isVisibleOnPage()) {
                report.fireBeforeShowRowEvent();
            }
            if (report.getCurrentRow().isVisible()) {
                if (report.hasChild("Separator")) {
                    report.getPanel("Separator").setVisible(false);
                    if (!report.getActiveGroup().isClosed()) {
                        report.getPanel("Separator").setVisible(true);
                    }
                }
            }
            return BodyTag.EVAL_BODY_TAG;
        }
    }
}

//End ReportDetailTag class

