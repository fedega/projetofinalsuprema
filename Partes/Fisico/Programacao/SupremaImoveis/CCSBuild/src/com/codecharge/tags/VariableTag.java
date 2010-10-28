//VariableTag class @0-5063914D
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
/**
  Shoving variable from page variables.
  <pre><b>&lt;upload_property name=".."/&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link UploadTag upload}, {@link UploadInfoTag upload_info}, {@link UploadPromptTag upload_prompt}, {@link UploadDeleteTag upload_delete}
    <dt><b>Child elements:</b> <dd>No children elements.
  </dl>
*/
public class VariableTag extends TagSupport {

    private String name;
    /** VAriable name. **/
    public void setName(String name) {this.name = name;}

    public int doStartTag() {

        if (name == null) return SKIP_BODY;

        Page page = (Page)pageContext.getAttribute("page");
        String value = page.getVariable(/*"@"+*/name).getValue();
        if (value == null) value = "";
        try {
          pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;
    }
}
//End VariableTag class

