//NorecordsTag class @0-F93EF6D7
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Defines block to be shown when Grid contains no records.
  <pre><b>&lt;norecords&gt;..&lt;/norecords&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link GridTag grid}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class NorecordsTag extends TagSupport {
    public int doStartTag() {
        Component parent = (Component)pageContext.getAttribute("parent");
        long rnumber;
        if (parent instanceof Grid) {
            rnumber = ((Grid)parent).getNumberOfRows();
        } else {
            rnumber = ((Directory)parent).getNumberOfCategories();
        }
        if (rnumber <= 0) {
            if (parent instanceof EditableGrid) {
                EditableGrid egrid = (EditableGrid)parent;
                if (egrid.isAllowInsert() && egrid.getNumberEmptyRows() > 0) return SKIP_BODY;
            }
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }
}
//End NorecordsTag class

