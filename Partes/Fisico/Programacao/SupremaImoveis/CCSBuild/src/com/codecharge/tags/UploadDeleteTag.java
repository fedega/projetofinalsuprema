//UploadDeleteTag class @0-973C0F99
package com.codecharge.tags;

import com.codecharge.components.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
/**
  Defines Prompt block for Upload component.
  <pre><b>&lt;upload_delete &gt;..&lt;/upload_delete&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>No attributes.
    <dt><b>Parent elements:</b> <dd>{@link UploadTag upload}
    <dt><b>Child elements:</b> <dd>{@link UploadPropertyTag upload_property}
  </dl>
*/
public class UploadDeleteTag extends TagSupport {

   public int doStartTag() {
        UploadTag parent = (UploadTag)findAncestorWithClass(this, UploadTag.class);
        FileUpload model = parent.getModel();
        if (model.isUploaded() && !model.isRequired()) {
          return EVAL_BODY_INCLUDE;
        } else {
          return SKIP_BODY;
        }
   }
}
//End UploadDeleteTag class

