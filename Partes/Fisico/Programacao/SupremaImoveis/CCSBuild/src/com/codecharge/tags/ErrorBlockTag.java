//ErrorBlockTag class @0-9BA36AFD
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import com.codecharge.Names;
import com.codecharge.components.*;
import com.codecharge.validation.*;

/**
  Enable error reporting if record has errors.
  <pre><b>&lt;error_block&gt;..&lt;/error_block&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}
    <dt><b>Child elements:</b> <dd>{@link ErrorTextTag error_text}
  </dl>
**/
public class ErrorBlockTag extends TagSupport {
  public int doStartTag() {
    Component model = (Component)pageContext.getAttribute("parent");
    RepeaterTag repeater = (RepeaterTag)findAncestorWithClass(this, RepeaterTag.class);
    if (repeater != null) {
      // TODO: Check if this row has errors in Editable Grid
      if (model instanceof EditableGrid) {
        HashMap row = ((EditableGrid)model).currentRow();
        ErrorCollection errors = (ErrorCollection)row.get(Names.CCS_ROW_ERROR_KEY);
        if (errors != null && errors.hasErrors()) {
          return EVAL_BODY_INCLUDE;
        }
      }

      return SKIP_BODY;
    } else {
        if (model instanceof Record) {
            if ( model.hasErrors() || model.isProcessed() ) {
                return EVAL_BODY_INCLUDE;
            } else {
                return SKIP_BODY;
            }
        } else {
            if ( model.hasErrors()) {
                return EVAL_BODY_INCLUDE;
            } else {
                return SKIP_BODY;
            }
        }

    }
  }
}
//End ErrorBlockTag class

