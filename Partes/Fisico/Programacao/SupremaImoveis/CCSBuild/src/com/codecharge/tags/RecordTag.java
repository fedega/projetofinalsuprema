//RecordTag class @0-7BD7A314
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import java.util.*;
import com.codecharge.events.*;
import com.codecharge.db.*;
import com.codecharge.util.*;

/**
  Defines Record component.
  <pre><b>&lt;record name=".."&gt;..&lt;/record&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>(No parent elements)
    <dt><b>Child elements:</b> <dd>{@link FormActionTag form_action}, {@link ErrorBlockTag error}, {@link ControlTag control}, {@link ButtonTag button}, {@link RadioButtonTag radio_button}
  </dl>
**/
public class RecordTag extends TagSupport {

    /** Parent **/
    private Component parent;

    /** Inserting or Updating **/
    private boolean insertMode;
    /** Wether record is in Insert mode. **/
    public boolean isInsert() {return insertMode;}
    /** Wether record is in Update mode. **/
    public boolean isUpdate() {return !insertMode;}

    private String name;
    /** Record name as defined in XML model. **/
    public void setName(String name) {this.name = name;}

    /* Populate children Controls with data stored in 'record' field of Record.
    private void populateControls(Record model) {
      if ( model.record != null ) {
        Iterator i = model.getChildren().iterator();
        while (i.hasNext()) {
          Model m = (Model)i.next();
          if (m instanceof Control) {
            Control c = (Control)m;
            Object value = null;
            if (!StringUtils.isEmpty(c.getFieldSource())) {
              value = model.record.get(c.getFieldSource());
            }
            if (value != null) {
              c.setValueFromDb(value);
            }
          }
        }
      }
      insertMode = (model.getMode() == Record.INSERT_MODE);
    } */

    public int doStartTag() {
        parent = (Component)pageContext.getAttribute("parent");
        Page page = (Page)pageContext.getAttribute("page");
        Record model  = (Record)parent.getChild(name);
        if (model == null) return SKIP_BODY;
        model.fireBeforeShowEvent(new Event());
        if ( model.isVisible() ) {
            pageContext.setAttribute("parent", model);
            //populateControls(model);
            insertMode = (model.getMode() == Record.INSERT_MODE);
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }

    public int doEndTag() {
        pageContext.setAttribute("parent", parent);
        return EVAL_PAGE;
    }
}
//End RecordTag class

