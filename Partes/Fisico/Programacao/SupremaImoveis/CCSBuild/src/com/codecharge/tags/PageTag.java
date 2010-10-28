//PageTag class @0-D2E3637C
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.util.*;

public class PageTag extends TagSupport {
    private String propertyName;
    public void setProperty(String propertyName) {
        this.propertyName = propertyName;
    }
    
    public int doStartTag() throws JspTagException {
        Page page = (Page) pageContext.getAttribute("page");
        try {
            pageContext.getOut().print(encode((String) page.getAttribute(propertyName), page));
        } catch(Exception e) {
            throw new JspTagException("unexpected IO problems");
        }
        return SKIP_BODY;
    }

    private String encode(String value, Page page) {
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        String val = StringUtils.replace(SessionStorage.getInstance(page.getRequest()).encodeURL(value), " ", "%20");
        int pos = val.indexOf(";");
        if (pos > -1) {
            if (pos == 0) {
                return "";
            }
            val = val.substring(0, pos);
        }
        return val;
    }
    
}
//End PageTag class

