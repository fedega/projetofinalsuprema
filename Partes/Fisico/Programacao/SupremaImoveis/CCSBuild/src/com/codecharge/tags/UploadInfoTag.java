//UploadInfoTag class @0-E9879B8A
package com.codecharge.tags;

import com.codecharge.components.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
/**
  Defines Info block for Upload component.
  <pre><b>&lt;upload_info &gt;..&lt;/upload_info&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>No attributes.
    <dt><b>Parent elements:</b> <dd>{@link UploadTag upload}
    <dt><b>Child elements:</b> <dd>{@link UploadPropertyTag upload_property}
  </dl>
*/
public class UploadInfoTag extends TagSupport {

   public int doStartTag() {
        UploadTag parent = (UploadTag)findAncestorWithClass(this, UploadTag.class);
        FileUpload model = parent.getModel();
        if (model.isUploaded()) {
          return EVAL_BODY_INCLUDE;
        } else {
          return SKIP_BODY;
        }
   }
}
//End UploadInfoTag class

