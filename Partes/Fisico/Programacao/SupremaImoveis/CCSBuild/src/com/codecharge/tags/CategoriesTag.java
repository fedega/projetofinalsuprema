//CategoriesTag class @0-D915860F
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

/**
  Repeatedly outputs Directory categories.
  <pre><b>&lt;categories&gt;..&lt;/categories&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link DirectoryTag directory}
    <dt><b>Child elements:</b> <dd>{@link SubcategoriesTag categories}, {@link ControlTag control}
  </dl>

  This tag is a simple iterator which iterates over Directory categoris.
**/
public class CategoriesTag extends BodyTagSupport {
    private Directory dir;
    //private boolean last = false;
    //public boolean isLast() {return last;}
    private Iterator state;
    private Vector current;
    /** Get currently being processed category state. Used by children subcategories tags.
      @return currently being processed category state */
    public Vector getElement() {
      return current;
    }
    public Iterator getState() {
      return state;
    }

    public int doStartTag() throws JspTagException {
      Object parent = pageContext.getAttribute("parent");
      if (parent != null) {
        if (parent instanceof Directory) dir = (Directory)parent;
      } else {
        throw new JspTagException("Categories tag: wrong context");
      }
      dir.initializeRows();
      if (dir.getStateMachine() == null) return SKIP_BODY;
      state = dir.getStateMachine().iterator();
      if (state.hasNext()) {
      //if (dir.hasNextRow()) {
        current = (Vector)state.next();
        dir.nextRow();
        dir.fireBeforeShowCategoryEvent(new Event());
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

        if (state.hasNext()) {
          current = (Vector)state.next();
          dir.nextRow();
          dir.fireBeforeShowCategoryEvent(new Event());
          return EVAL_BODY_TAG;
        } else {
          return SKIP_BODY;
        }
        /*if (dir.getNumberOfCategories() == 1) return SKIP_BODY;
        if (dir.getNumberOfCategories() == dir.getCurrentCategoryNumber()) {
          last = !last;
          if (last) {
            dir.fireBeforeShowCategoryEvent(new Event());
            return EVAL_BODY_TAG;
          } else {
            return SKIP_BODY;
          }
        } else {
          dir.fireBeforeShowCategoryEvent(new Event());
          return EVAL_BODY_TAG;
        }*/
    }
}
//End CategoriesTag class

