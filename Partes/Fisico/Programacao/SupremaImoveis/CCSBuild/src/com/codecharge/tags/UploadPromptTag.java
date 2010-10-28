//UploadPromptTag class @0-40103382
package com.codecharge.tags;

import com.codecharge.components.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
/**
  Defines Prompt block for Upload component.
  <pre><b>&lt;upload_prompt &gt;..&lt;/upload_prompt&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>No attributes.
    <dt><b>Parent elements:</b> <dd>{@link UploadTag upload}
    <dt><b>Child elements:</b> <dd>{@link UploadPropertyTag upload_property}
  </dl>
*/
public class UploadPromptTag extends TagSupport {

   public int doStartTag() {
        UploadTag parent = (UploadTag)findAncestorWithClass(this, UploadTag.class);
        FileUpload model = parent.getModel();
        if (model.isUploaded() && !model.isRequired()) {
          return SKIP_BODY;
        } else {
          return EVAL_BODY_INCLUDE;
        }
   }
}
//End UploadPromptTag class

