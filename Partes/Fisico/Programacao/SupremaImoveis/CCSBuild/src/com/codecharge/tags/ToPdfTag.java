//ToPdfTag class @0-25FBF69D
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
import java.io.*;

public class ToPdfTag extends BodyTagSupport {

    String parameterName;
    String converterClassName;
    String option1;
    String option2;
    String option3;
    String option4;
    String option5;

    public void setParameterName(String name) {
        this.parameterName = name;
    }

    public void setConverterClassName(String className) {
        this.converterClassName = className;
    }
    
    public void setOption1(String option) {
        this.option1 = option;
    }
    
    public void setOption2(String option) {
        this.option2 = option;
    }
    
    public void setOption3(String option) {
        this.option3 = option;
    }
    
    public void setOption4(String option) {
        this.option4 = option;
    }
    
    public void setOption5(String option) {
        this.option5 = option;
    }
    
    public int doStartTag() throws JspException {
        if (pageContext.getRequest().getParameter(this.parameterName) != null) {

            
            pageContext.getResponse().setContentType("application/pdf");
            try {
                java.io.OutputStream outb = pageContext.getResponse().getOutputStream();
                pageContext.setAttribute(this.getClass().getName()+".OutputStream", outb);
            } catch ( java.io.IOException ex) {
                throw new JspException("unexpected IO error");
            }
        }
        return EVAL_BODY_TAG;
    }

    public int doAfterBody() throws JspException {
        BodyContent body = getBodyContent();
        try {
            if (pageContext.getRequest().getParameter(this.parameterName) != null) {
                Page page = (Page) pageContext.getAttribute("page");
                page.setContent(body.getString());

                Class converter = Class.forName(converterClassName);
                page.setContent(((IContentConverter) converter.newInstance()).convert(page.getContentAsByteArray(),
                        new String[] {this.option1,
                        this.option2,
                        this.option3,
                        this.option4,
                        this.option5}
                        ));
                
                OutputStream outb = (OutputStream) pageContext.getAttribute(this.getClass().getName()+".OutputStream");
                outb.write(page.getContentAsByteArray());
                outb.close();
            } else {
                body.writeOut(getPreviousOut());
            }
        } catch ( java.io.IOException ex) {
            throw new JspException("unexpected IO error", ex);
        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    private File saveToFile(File file, byte[] content) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        out.write(content);
        out.close();
        return file;
    }

    
}
//End ToPdfTag class

