//UploadTag class @0-FF730DA6
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
/**
  Defines Upload component tag.
  <pre><b>&lt;upload name=".."&gt;..&lt;/upload&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}, {@link GridTag grid}
    <dt><b>Child elements:</b> <dd>{@link UploadInfoTag upload_info}, {@link UploadPromptTag upload_prompt}, {@link UploadDeleteTag upload_delete}
  </dl>
<h4>Example:</h4>
<pre>
        &lt;ccs:upload name='FileUpload1'&gt;&lt;input type="hidden" value="&lt;ccs:upload_property name='state'/&gt;" name="&lt;ccs:upload_property name='name'/&gt;"&gt;
        &lt;ccs:upload_info&gt;&nbsp;&lt;ccs:upload_property name='filename'/&gt;&nbsp;&lt;ccs:upload_property name='filesize'/&gt;&nbsp;bytes. &lt;/ccs:info&gt;
        &lt;ccs:upload_prompt&gt;&lt;input type="file" name="&lt;ccs:upload_property name='filecontrol'/&gt;"&gt;&lt;/ccs:upload_prompt&gt;
        &lt;ccs:upload_delete&gt;Delete &lt;input type="checkbox" name="&lt;ccs:upload_property name='deletename'/&gt;" &lt;ccs:upload_property name='delchecked'/&gt;&gt;&lt;/ccs:upload_delete&gt;&lt;/ccs:upload&gt;&nbsp;&lt;/td&gt; 
</pre>
*/
public class UploadTag extends TagSupport {

    private FileUpload model;
    /** Give Upload model for children tags. **/
    public FileUpload getModel() {return model;}

    private String name;
    /** Upload component name as defined in XML model. **/
    public void setName(String name) {this.name = name;}
    /** Upload component name as defined in XML model. **/
    public String getName() {return name;}

    public int doStartTag() {
        Component parent = (Component)pageContext.getAttribute("parent");
        model = (FileUpload)parent.getChild(name);
        model.fireBeforeShowEvent(new Event());
        return EVAL_BODY_INCLUDE;
    }
}
//End UploadTag class

