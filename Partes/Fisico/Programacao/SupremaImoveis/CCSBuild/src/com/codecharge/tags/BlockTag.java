//BlockTag class @0-ED648E5F
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.Event;


/**
  Defines block that can be hidden from CCS events.
  <pre><b>&lt;block name=".."&gt;..&lt;/block&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>any tag with jsp content
    <dt><b>Child elements:</b> <dd>any tag
  </dl>
**/
public class BlockTag extends TagSupport {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public int doStartTag() {
        Page page = (Page)pageContext.getAttribute("page");
        Block block = page.getBlock(page.getCurrentPath()+"/"+name);
        Component parent = (Component)pageContext.getAttribute("parent");
        Model ctrl = parent.getChild(name);
        page.setCurrentBlock(name);



        if (ctrl != null) {

            if ( (ctrl instanceof Control) && (!ctrl.isBeforeShow()) ) {
               ((Control)ctrl).fireBeforeShowEvent(new Event());
            }

            if (!ctrl.isVisible()) {
                return SKIP_BODY;
            } else {
                if (block.isVisible()) {
                    return EVAL_BODY_INCLUDE;
                } else {
                    return SKIP_BODY;
                }
            }
        } else {
            if (block.isVisible()) {
                return EVAL_BODY_INCLUDE;
            } else {
                return SKIP_BODY;
            }
        }
    }

    public int doEndTag() {
        ((Page)pageContext.getAttribute("page")).gotoParentBlock();
        return EVAL_PAGE;
    }

}
//End BlockTag class

