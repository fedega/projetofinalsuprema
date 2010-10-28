//RowTag class @0-AE7EC2F8
package com.codecharge.tags;

import com.codecharge.components.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

/**
  Defines row of the Grid.
  <pre><b>&lt;row name=".."&gt;..&lt;/row&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link RepeaterTag repeater}
    <dt><b>Child elements:</b> <dd>{@link ControlTag control}, {@link RadioButtonTag radiobutton}
  </dl>
**/
public class RowTag extends TagSupport {

    private Grid grid;

    private String name = "general";
    /**
      Row name to distinguish between rows with different formatting.
      Defaults to general. Set this to alt if you want CCS alt row.
    **/
    public void setName(String name) {this.name = name;}

    public int doStartTag() {
      RepeaterTag repeater = (RepeaterTag)findAncestorWithClass(this, RepeaterTag.class);
      repeater.addRowName(name);
      if (repeater.getRow().equals(name)) {
        return EVAL_BODY_INCLUDE;
      } else {
        return SKIP_BODY;
      }
    }
}
//End RowTag class

