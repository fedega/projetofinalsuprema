//ButtonTag class @0-E539D1E6
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.events.Event;

/**
  Block to show or hide button.
  <pre><b>&lt;button name=".." type=".." size=".."&gt;..&lt;/button&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class ButtonTag extends TagSupport {

  private String name;
  /** Button name as defined in XML model. **/
  public void setName(String name) {this.name = name;}

  public int doStartTag() {
    RecordTag record = (RecordTag)findAncestorWithClass(this, RecordTag.class);
    Component parent = (Component)pageContext.getAttribute("parent");
    boolean isRecord = ( parent instanceof Record );
    boolean isEditableGrid = (parent instanceof EditableGrid);
    Button button = (Button)parent.getChild(name);
    if ( button == null ) 
      return SKIP_BODY;
    button.fireBeforeShowEvent(new Event());
    String operation = button.getOperation();

    if ( isRecord && record.isInsert() && (operation.equalsIgnoreCase("Update") || operation.equalsIgnoreCase("Delete"))) {
      return SKIP_BODY;
    } else if ( isRecord && record.isUpdate() && operation.equalsIgnoreCase("Insert")) {
      return SKIP_BODY;
    } else if ( isRecord && operation.equalsIgnoreCase("Insert") &&  ! ((Record) parent).isAllowInsert() ) {
      return SKIP_BODY;
    } else if ( isRecord && operation.equalsIgnoreCase("Update") &&  ! ((Record) parent).isAllowUpdate() ) {
      return SKIP_BODY;
    } else if ( isRecord && operation.equalsIgnoreCase("Delete") &&  ! ((Record) parent).isAllowDelete() ) {
      return SKIP_BODY;
    } else if ( isEditableGrid && operation.equalsIgnoreCase("Submit") && !(((EditableGrid)parent).isAllowInsert() || ((EditableGrid)parent).isAllowUpdate() || ((EditableGrid)parent).isAllowDelete()) ) {
      return SKIP_BODY;
    } else if (button.isVisible()) {
      return EVAL_BODY_INCLUDE;
    } else {
      return SKIP_BODY;
    }
  }
}
//End ButtonTag class

