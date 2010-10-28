//SubcategoriesTag class @0-23CB736D
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

/**
  Repeatedly outputs Directory subcategories.
  <pre><b>&lt;subcategories&gt;..&lt;/subcategories&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link CategoriesTag categories}
    <dt><b>Child elements:</b> <dd>{@link ControlTag control}, {@link SeparatorTag separator}
  </dl>

  This tag is a simple iterator which iterates over Directory subcategoris.
**/
public class SubcategoriesTag extends BodyTagSupport {
    private Directory dir;
    private Iterator state;
    private String current;
    public String getElement() {return current;}
    public Iterator getState() {return state;}

    public int doStartTag() throws JspTagException {
      Object parent = pageContext.getAttribute("parent");
      if (parent != null) {
        if (parent instanceof Directory) dir = (Directory)parent;
      } else {
        throw new JspTagException("Categories tag: wrong context");
      }
      CategoriesTag categories = (CategoriesTag)findAncestorWithClass(this, CategoriesTag.class);
      state = categories.getElement().iterator();
      if (state.hasNext()) {
        current = (String)state.next();
        dir.fireBeforeShowSubcategoryEvent(new Event());
        return EVAL_BODY_TAG;
      } else {
        return SKIP_BODY;
      }
    }

    public int doAfterBody() throws JspTagException {
        BodyContent body = getBodyContent();
        try {
          // write evaluation on the output Writer
          body.writeOut(getPreviousOut());
        } catch ( java.io.IOException ex) {
          throw new JspTagException("unexpected IO error");
        }
  
        // clear up so the next time we get here we are afresh.
        body.clearBody();

        if (state.hasNext() && "SUBCAT".equals(current)) {
          current = (String)state.next();
          dir.nextRow();
          dir.fireBeforeShowSubcategoryEvent(new Event());
          return EVAL_BODY_TAG;
        } else {
          return SKIP_BODY;
        }
    }
}
//End SubcategoriesTag class

