//CheckBoxListTag class @0-9D71EA19
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
/**
  Defines CheckBoxList component.
  <pre><b>&lt;checkboxlist name=".."&gt;..&lt;/checkboxlist&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}, {@link RowTag row}
    <dt><b>Child elements:</b> <dd>{@link CheckBoxTag checkbox}
  </dl>
<h4>Example:</h4>
<pre>
  &lt;checkboxlist name="CheckBoxList1"&gt;
    &lt;input type="checkbox" value="&lt;checkbox property='value'/&gt;"
    name="&lt;checkbox property="name"/&gt;" &lt;checkbox property='check'/&gt;&gt;
    &lt;checkbox property='desc'/&gt;
  &lt;/checkbox&gt;
</pre>
*/
public class CheckBoxListTag extends BodyTagSupport {

    private String[] element;
    private Enumeration elements;

    private String name;
    /** CheckBoxList name as defined in XML model. **/
    public void setName(String name) {this.name = name;}
    /** CheckBoxList name as defined in XML model. **/
    public String getName() {return name;}
    /** Current CheckBox element. **/
    public String[] getElement() {return element;}

    private int number = 1;
    private ModelAttribute ma = null;

    public int doStartTag() {
        Component parent = (Component)pageContext.getAttribute("parent");
        CheckBoxList list = (CheckBoxList)parent.getChild(name);
        list.fireBeforeShowEvent(new Event());
        elements = list.getFormattedOptions();
        if (elements.hasMoreElements()) {
          ma = (ModelAttribute)list.getAttribute("optionNumber");
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
//End CheckBoxListTag class

