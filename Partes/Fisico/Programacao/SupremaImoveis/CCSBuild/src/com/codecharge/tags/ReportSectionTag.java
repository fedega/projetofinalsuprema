//ReportSectionTag class @0-F9E71DCB
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags;

import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.Report;
import com.codecharge.components.report.ReportGroup;
import com.codecharge.util.CCLogger;

/**
  Defines report section that manages report headers, footers and details.
  <pre><b>&lt;section group=".." type=".."&gt;..&lt;/section&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setGroup group}, {@link #setType type}
    <dt><b>Parent elements:</b> <dd>{@link ReportRepeaterTag report_repeater}
    <dt><b>Child elements:</b> <dd>{@link ControlTag control}, {@link PanelTag panel}
  </dl>
**/
public class ReportSectionTag extends TagSupport {

    private String groupName; 
    private boolean isHeader = true;
    private boolean isStrictShow = false;

    public void setGroup(String group) {
        this.groupName = group;
        if ("Report".equals(group) || "Page".equals(group) ) 
            isStrictShow = true; 
            else isStrictShow = false;
    }
    
    public void setType(String type) {
        if ("Header".equals(type)) {
            this.isHeader = true;
        } else {
            this.isHeader = false;
        }
    }

    public int doStartTag() {

        Report report = null;
        boolean visible;
        try {
            report = (Report) pageContext.getAttribute("parent");
        } catch (ClassCastException e) {
        }
        ReportGroup group = report.getGroup(groupName);
        if (group == null) {
            CCLogger.getInstance().error(
                    "Group '" + groupName + "' was not found in Report model");
            return SKIP_BODY;
        }
        if (report.getNumberOfRows() == 0 && !isStrictShow) {
            return SKIP_BODY;
        }

        boolean isShowSection = false; 
        if (isHeader) {
            isShowSection = group.isOpen();
            if (isShowSection && group.isHeaderVisibleOnPage()) {
                group.fireBeforeShowHeaderEvent();
            }
            visible = group.isHeaderVisible();

            if ( "Page".equals(groupName) && group.itemsNumber() == 0 ) isShowSection  = true;

        } else {
            if (report.getPageNumber() == report.getTotalPages() && "Report".equals(groupName)) {
                report.getGroup("Report").setFooterVisibleOnPage(true);
            }
            isShowSection = group.isClosed();
            if (isShowSection && group.isFooterVisibleOnPage()) {
                group.fireBeforeShowFooterEvent();
            }
            visible = group.isFooterVisible();
            if (report.hasChild("PageBreak")
                    && "Page".equals(group.getName())
                    && ((report.getPageNumber() >= report.getTotalPages()
                    && report.getViewMode() == Report.VIEW_MODE_PRINT)
                    || report.getViewMode() == Report.VIEW_MODE_WEB)
                    ) {
                report.getChild("PageBreak").setVisible(false);
            }
        }

        if (visible && isShowSection) {
            return EVAL_BODY_INCLUDE;
        }

        /*if (visible) {
            if ((group.isOpen() && isHeader) || (group.isClosed() && !isHeader)) {
                return EVAL_BODY_INCLUDE;
            }
        }*/
        return SKIP_BODY;
    }
}

//End ReportSectionTag class

