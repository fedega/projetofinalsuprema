//CacheTag class @0-18B031E2
package com.codecharge.tags;

import com.codecharge.Action;
import com.codecharge.View;
import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class CacheTag extends BodyTagSupport {

    private String name;
    
    public void setName(String name) {
        this.name = name;
    }

    public int doStartTag() throws JspTagException {
        String cached = Action.getCachedPage(this.name, pageContext.getRequest(), pageContext.getResponse());
        if (cached != null) {
            try {
                pageContext.getOut().print(cached);
            } catch (Exception e) {
                throw new Error("IO problems");
            }
            return SKIP_BODY;
        }
        return EVAL_BODY_TAG;
    }

    public int doAfterBody() throws JspTagException {
        BodyContent body = getBodyContent();
        try {
          Page page = (Page) pageContext.getAttribute("page");
          View.cachePage(this.name, body.getString(), page.getCharacterEncoding(), 
                  pageContext.getRequest(), pageContext.getResponse());
          // write evaluation on the output Writer
          body.writeOut(getPreviousOut());
        } catch ( java.io.IOException ex) {
          throw new JspTagException("unexpected IO error");
        }
        return SKIP_BODY;
    }
}
//End CacheTag class

