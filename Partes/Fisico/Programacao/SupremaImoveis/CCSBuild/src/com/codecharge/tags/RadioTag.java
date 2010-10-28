//RadioTag class @0-7674A91C
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
/**
  Calculates values of RadioButton attributes.
  <pre><b>&lt;radio property=".."&gt;..&lt;/radio&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setProperty property}
    <dt><b>Parent elements:</b> <dd>{@link RadioButtonTag radiobutton}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class RadioTag extends TagSupport {

    protected String property;

    /** Which attribute to calculate: value - value, check - checked, desc - description of the button. **/
    public void setProperty(String prop) {this.property = prop;}
    /** Which attribute to calculate: value - value, check - checked, desc - description of the button. **/
    public String getProperty() {return property;}

    public int doStartTag() {
        String value = "";
        RadioButtonTag button = (RadioButtonTag)findAncestorWithClass(this, RadioButtonTag.class);
        if ("value".equals(property)) {
            value = button.getElement()[List.BOUND_COLUMN];
        } else if ("check".equals(property)) {
            if ("True".equals(button.getElement()[List.SELECTED])) {
                value = "CHECKED";
            }
        } else if ("desc".equals(property)) {
            value = button.getElement()[List.TEXT_COLUMN];
        }
        try {
          pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;
    }

}
//End RadioTag class

