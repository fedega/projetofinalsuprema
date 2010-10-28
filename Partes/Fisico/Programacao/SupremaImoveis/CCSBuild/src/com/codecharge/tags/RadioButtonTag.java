//RadioButtonTag class @0-D60428C5
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
/**
  Defines RadioButton control.
  <pre><b>&lt;radiobutton name=".."&gt;..&lt;/radiobutton&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}, {@link RowTag row}
    <dt><b>Child elements:</b> <dd>{@link RadioTag radio}
  </dl>
<h4>Example:</h4>
<pre>
  &lt;radiobutton name="Radio1"&gt;
    &lt;input type="radio" value="&lt;radio property='value'/&gt;" name="Radio1" &lt;radio property='check'/&gt;&gt;
    &lt;radio property="desc"/&gt;
  &lt;/radiobutton&gt;
</pre>
*/
public class RadioButtonTag extends BodyTagSupport {

    private String[] element;
    private Enumeration elements;

    private String name;
    /** RadioButton name as defined in XML model. **/
    public void setName(String name) {this.name = name;}
    /** RadioButton name as defined in XML model. **/
    public String getName() {return name;}
    /** Current RadioButton element. **/
    public String[] getElement() {return element;}

    private int number = 1;
    private ModelAttribute ma = null;

    public int doStartTag() {
        Component parent = (Component)pageContext.getAttribute("parent");
        RadioButton radio = (RadioButton)parent.getChild(name);
        radio.fireBeforeShowEvent(new Event());
        elements = radio.getFormattedOptions();
        if (elements.hasMoreElements()) {
          ma = (ModelAttribute)radio.getAttribute("optionNumber");
          if (ma != null) ma.setValue(""+(number++));
          element = (String[])elements.nextElement();
          return EVAL_BODY_TAG;
        } else {
          return SKIP_BODY;
        }
    }

    public int doAfterBody() throws JspTagException {
        BodyContent body = getBodyContent();
        try {
          body.writeOut(getPreviousOut());
        } catch ( java.io.IOException ex) {
          throw new JspTagException("unexpected IO error");
        }
        body.clearBody();
        if (elements.hasMoreElements()) {
          if (ma != null) ma.setValue(""+(number++));
          element = (String[])elements.nextElement();
          return EVAL_BODY_TAG;
        } else {
          return SKIP_BODY;
        }
    }
}
//End RadioButtonTag class

