//PageProcessor class: head @0-C317BF2A
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class PageProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  private Page model;

  public PageProcessor(Element elm, Model model, Page page) {
  	super(elm,model,page);
    this.model = (Page)model;
  }

  public void process() {
      NodeList components = elm.getChildNodes();
      for (int i = 0; i<components.getLength(); i++) {
        if (components.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element elm = (Element)components.item(i);
            if (elm.getTagName().equals("Grid")) {
              new GridProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("Record")) {
              new RecordProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("Directory")) {
              new DirectoryProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("Path")) {
              new PathProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("Report")) {
              new ReportProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("Calendar")) {
              new CalendarProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("EditableGrid")) {
              new EditableGridProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("Menu")) {
              new MenuProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("FlashChart")){
            	new FlashChartProcessor(elm,page.getChild(elm.getAttribute("name")), page).process();
            } else if (elm.getTagName().equals("ListBox") ||
                       elm.getTagName().equals("RadioButton") ||
                       elm.getTagName().equals("CheckBoxList")) {
              new ListProcessor(elm, page.getChild(elm.getAttribute("name")), page).process();
            }
        }
      }
      setProperties(page, PageController.POST);
      setProperties(page, PageController.GET);
  }
  protected void select() {}
  protected void bind() {}
}
//End PageProcessor class: head

