//ControlTag class @0-AED60F8B
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;
import com.codecharge.components.calendar.*;
import com.codecharge.util.*;
import com.codecharge.events.*;
import com.codecharge.db.*;
import java.util.Hashtable;
import java.util.Iterator;

/**
  Defines control values and attributes.
  <pre><b>&lt;control name=".." property=".."&gt;..&lt;/control&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}, {@link #setProperty property}
    <dt><b>Parent elements:</b> <dd>{@link RecordTag record}, {@link RowTag row}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class ControlTag extends TagSupport {

    private String name;
    /** Control name as defined in XML model. **/
    public void setName(String name) {this.name = name;}

    private String property;
    /** Which attribute to calculate: <b>checked</b> for CheckBox, <b>href</b> for Link and ImageLink, <b>options</b> for ListBox. By default calculate control value. **/
    public void setProperty(String property) {this.property = property;}

    public int doStartTag() {
        String value = "";
        Component parent = (Component)pageContext.getAttribute("parent");
        Model model = parent.getChild(name);
        if (parent instanceof Calendar && pageContext.getAttribute("weekday") != null) {
            CalendarItem weekday = (CalendarItem) pageContext.getAttribute("weekday");
            model = weekday.getModel(name);
        }
        Control control = null;
        if ( model instanceof Control ) control = (Control)model;
        if ( model == null ) {
            CCLogger.getInstance().debug("Form: "+parent.getName()+" component '"+name+"' not found");
            return SKIP_BODY;
        }
        if (! model.isVisible()) { return SKIP_BODY; }
        if ( ! model.isBeforeShow() ) {
          if (control instanceof Control) {
            control.fireBeforeShowEvent(new Event());
          }
        }
        if (! model.isVisible()) { return SKIP_BODY; }
        if (property == null) {
            value = control.getFormattedValue();
        } else if (property.equals("href") && control instanceof Link) {
            Page page = (Page)pageContext.getAttribute("page");
            RepeaterTag repeater = (RepeaterTag)findAncestorWithClass(this, RepeaterTag.class);
            java.util.Map row;
            if (repeater == null) {
                if ( parent instanceof Record ) {
                    row = ((Record)parent).record;
                } else {
                    row = null;
                }
            } else {
              row = repeater.getRecord();
            }

            calcHref((Link)control, page, row);
            value = ((Link)control).getHref();

        } else if (property.equals("options") && control instanceof ListBox ) {
            value = ((ListBox)control).getOptionsString();
        } else if (property.equals("name")) {
            value = model.getHtmlName();
        } else {
            value = control.getFormattedValue();
        }
        try {
          pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;
    }
    /**
      An auxilary method to calculate href for link.
      This is mainly for Database href source type.
      And for compatability with servlets version, because in servlets this is accomplished through DataSource object.
      @param model Model of the Link
      @param page Page to get request, session and application objects.
      @param row Current row for links with database href source.
    **/
    protected void calcHref(Link model, Page page, java.util.Map row) {
      StringBuffer href = new StringBuffer();
      for (Iterator i = model.getParameters().iterator(); i.hasNext(); ) {
        LinkParameter param = (LinkParameter)i.next();
        ParameterSource type = param.getSourceType();
        if (type == ParameterSource.CONTROL) {
        } else if (type == ParameterSource.EXPRESSION) {
        } else if (type == ParameterSource.URL) {
          param.setValues( page.getHttpGetParams().getParameterValues(param.getSourceName()) );
        } else if (type == ParameterSource.FORM) {
          param.setValues( page.getHttpPostParams().getParameterValues(param.getSourceName()) );
        } else if (type == ParameterSource.SESSION) {
          param.setValue( SessionStorage.getInstance(page.getRequest()).getAttributeAsString(param.getSourceName()) );
        } else if (type == ParameterSource.APPLICATION) {
          param.setValue( ContextStorage.getInstance().getAttributeAsString(param.getSourceName()) );
        } else if (type == ParameterSource.COOKIE) {
          param.setValue( StringUtils.getCookie( param.getSourceName(), page.getRequest().getCookies()) );
        } else if (type == ParameterSource.DATAFIELD) {
          // For record only, because Grid and EditableGrid hold Controls in row.
          // And Link parameters are set at the time of binding.
          if (row instanceof DbRow) {
            param.setValue( row.get(param.getSourceName()).toString() );
          }
        } else if (type == ParameterSource.CONST) {
        }
      }
    }
}
//End ControlTag class

