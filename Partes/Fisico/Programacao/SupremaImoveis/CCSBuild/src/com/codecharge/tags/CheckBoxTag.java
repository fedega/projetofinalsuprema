//CheckBoxTag class @0-7FAC0F6F
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
/**
  Calculates values of CheckBox attributes in CheckBoxList component.
  <pre><b>&lt;checkbox property=".."&gt;..&lt;/checkbox&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setProperty property}
    <dt><b>Parent elements:</b> <dd>{@link CheckBoxListTag checkboxlist}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class CheckBoxTag extends TagSupport {

    protected String property;

    /** Which attribute to calculate: name - name, value - value, check - checked, desc - description of the button. **/
    public void setProperty(String prop) {this.property = prop;}
    /** Which attribute to calculate: name - name, value - value, check - checked, desc - description of the button. **/
    public String getProperty() {return property;}

    public int doStartTag() {
        String value = "";
        CheckBoxListTag cbtag = (CheckBoxListTag)findAncestorWithClass(this, CheckBoxListTag.class);
        
        boolean isXHTMLUsed = new Boolean(StringUtils.getSiteProperty("isXHTMLUsed")).booleanValue();

        if ("value".equals(property)) {
            value = cbtag.getElement()[List.BOUND_COLUMN];
        } else if ("check".equals(property)) {
            if ("True".equals(cbtag.getElement()[List.SELECTED])) {
                if (isXHTMLUsed) {
                    value = "checked";
                } else {
                    value = "CHECKED";
                }
            }
        } else if ("desc".equals(property)) {
            value = cbtag.getElement()[List.TEXT_COLUMN];
        } else if ("name".equals(property)) {
            CheckBoxList cblist = (CheckBoxList)((Component)pageContext.getAttribute("parent")).getChild(cbtag.getName());
            value = cblist.getHtmlName();
        }

        try {
          pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;
    }

}
//End CheckBoxTag class

