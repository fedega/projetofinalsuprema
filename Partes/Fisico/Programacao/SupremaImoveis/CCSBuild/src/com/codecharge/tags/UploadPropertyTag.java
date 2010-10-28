//UploadPropertyTag class @0-A9278B6F
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
/**
  Output property of Upload component.
  <pre><b>&lt;upload_property name=".."/&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link UploadTag upload}, {@link UploadInfoTag upload_info}, {@link UploadPromptTag upload_prompt}, {@link UploadDeleteTag upload_delete}
    <dt><b>Child elements:</b> <dd>No children elements.
  </dl>
*/
public class UploadPropertyTag extends TagSupport {

    private String property;
    /** Property name. **/
    public void setName(String name) {this.property = name;}
    /** Property name. **/
    public String getName() {return property;}

    public int doStartTag() {
        UploadTag parent = (UploadTag)findAncestorWithClass(this, UploadTag.class);
        FileUpload model = parent.getModel();
        String value = "";
        if ("name".equals(property)) {
            value = model.getHtmlName();
        } else if ("state".equals(property)) {
            value = model.getState();
        } else if ("filesize".equals(property)) {
            value = String.valueOf(model.getSize());
        } else if ("filecontrol".equals(property)) {
          if (model.getParent() instanceof EditableGrid) {
            StringBuffer n = new StringBuffer(model.getHtmlName());
            int k = model.getHtmlName().lastIndexOf("_");
            n.insert(k, "_File");
            value = n.toString();
          } else {
            value = model.getHtmlName() + "_File";
          }
        } else if ("filename".equals(property)) {
            value = model.getFileName();
        } else if ("deletename".equals(property)) {
          if (model.getParent() instanceof EditableGrid) {
            StringBuffer n = new StringBuffer(model.getHtmlName());
            int k = model.getHtmlName().lastIndexOf("_");
            n.insert(k, "_Delete");
            value = n.toString();
          } else {
            value = model.getHtmlName() + "_Delete";
          }
        } else if ("delchecked".equals(property) && model.getDelete()) {
            value = "CHECKED";
        }
        try {
          pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;
    }
}
//End UploadPropertyTag class

