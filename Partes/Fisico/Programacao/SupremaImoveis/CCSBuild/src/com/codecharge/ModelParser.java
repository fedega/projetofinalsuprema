//ModelParser class: head @0-69AF8BD7
/*
 * $Revision: 1.5 $
 * $Date: 2005/01/04 08:34:05 $
 */
package com.codecharge;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.codecharge.components.*;
import com.codecharge.components.report.AverageHandler;
import com.codecharge.components.report.CountHandler;
import com.codecharge.components.report.DefaultHandler;
import com.codecharge.components.report.MaxHandler;
import com.codecharge.components.report.MinHandler;
import com.codecharge.components.report.PercentOfTotalHandler;
import com.codecharge.components.report.ReportGroup;
import com.codecharge.components.report.SumHandler;
import com.codecharge.db.ParameterSource;
import com.codecharge.util.CCLogger;
import com.codecharge.util.ContextStorage;
import com.codecharge.util.LinkParameter;
import com.codecharge.util.Permission;
import com.codecharge.util.PreserveParameterType;
import com.codecharge.util.StringUtils;
import com.codecharge.util.cache.PageSettings;
import com.codecharge.util.cache.CachingParameter;
import com.codecharge.util.cache.CacheConfigurator;
import com.codecharge.util.multipart.DefaultFileFilter;
import com.codecharge.util.ModelAttribute;
import com.codecharge.validation.RegexpHandlersFactory;

public class ModelParser {
  private Document doc = null;
  private Component currentComponent;
  private Page page;
  private CCLogger logger = CCLogger.getInstance();
  public ModelParser(String modelName, ServletContext application) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        dbf.setValidating(false);
        try {
          db = dbf.newDocumentBuilder();
        } catch(ParserConfigurationException pce) {
          logger.error(pce.getMessage());
        }
        db.setErrorHandler(new ModelErrorHandler());

        try {
            if ("false".equals( (String) ContextStorage.getInstance().getAttribute( "usedUnpackedWarFile" ) ) ) {
            //if ( ContextStorage.getInstance().getAttribute( "usedUnpackedWarFile" ) == null ) {
              java.io.InputStream smodel = application.getResourceAsStream( modelName );
              doc = db.parse( smodel );
              smodel.close();
            } else {
              java.io.FileInputStream smodel = new java.io.FileInputStream(application.getRealPath( modelName ));
              doc = db.parse( smodel );
              smodel.close();
            }
        } catch(SAXException saxe) {
          logger.error("Unable to parse model XML "+saxe.getMessage());
        } catch(IOException ioe) {
          logger.error(ioe.getMessage());
        }
  }
  public Document getDOM() {
    return doc;
  }
  public Page getPage() {
    getPageModel(doc.getDocumentElement());
    return page;
  }
    /** Create control model from its XML element. **/
    protected Model getControlModel(Element elm) {
      String tagName = elm.getTagName();
      String name = elm.getAttribute("name");


      ResourceBundle res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"));
      if (tagName.equals("Button")) {
        Button model = new Button(name, page);

        fillControlAttributes(model, elm);

        model.setReturnPage(elm.getAttribute("returnPage"));
        model.setOperation(elm.getAttribute("operation"));
        model.setParent(currentComponent);
        // convertRule
        NodeList exclude = elm.getElementsByTagName("ExcludeParameter");
        for (int i=0; i<exclude.getLength(); i++) {
          model.addExcludeParam(((Element)exclude.item(i)).getAttribute("name"));
        }
        return model;
      } else if (tagName.equals("Menu")) {

		Menu model = new Menu(name);
		model.setParent(currentComponent);

		model.setMenuType(elm.getAttribute("menu_type"));
                model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
		NodeList children = elm.getChildNodes();
		for (int i=0; i<children.getLength(); i++) {
			if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element)children.item(i);
				if ( "MenuItem".equals (e.getTagName()) ) {
					if ("Static".equals(elm.getAttribute("menuSourceType"))) {
						String caption = (String)e.getAttribute("caption");
						if ( 0 == caption.indexOf("{res:")) {
							caption = page.getResourceString(caption.substring(5, caption.length() - 1));
						}
						String title = (String)e.getAttribute("title");
						if ( 0 == title.indexOf("{res:")) {
							title = page.getResourceString(title.substring(5, title.length() - 1));
						}

						model.addMenuItem( e.getAttribute("name"), e.getAttribute("parent"), caption, e.getAttribute("url"), e.getAttribute("target"), title );
					}
				} else if ("Attribute".equals(e.getTagName())) {
					ModelAttribute ma = paresAttribute (e);
					if (ma != null) {
			                	model.setAttribute (ma.getName(), ma);
			                }
				} if (e.getTagName().equals("Security")) {
	        			setGroupPermissions(model, e);
				} else {
					Model ctrlModel = getControlModel(e);
					if (ctrlModel != null) {
						model.add(ctrlModel);
					}
				}
			}
		}

        return model;

	  } else if (tagName.equals("FlashChart")) {

		FlashChart model = new FlashChart(name);
		model.setParent(currentComponent);

		String title = (String)elm.getAttribute("title");
		if ( 0 == title.indexOf("{res:")) {
			title = page.getResourceString(title.substring(5, title.length() - 1));
		}
		model.setTitle(title);
		model.setSrc(elm.getAttribute("src"));
		model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
		model.setPageModel(page);		
		try { model.setWidth(Integer.parseInt(elm.getAttribute("width"))); } catch(NumberFormatException nfe) {model.setWidth(1);}
		try { model.setHeight(Integer.parseInt(elm.getAttribute("height"))); } catch(NumberFormatException nfe) {model.setHeight(1);}
        NodeList children = elm.getChildNodes();
        for (int i=0; i<children.getLength(); i++) {
	        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
	        	Element e = (Element)children.item(i);
	        	if (e.getTagName().equals("Security")) {
	        		setGroupPermissions(model, e);
	        	} 
	        }
        }
        return model;

	  } else if (tagName.equals("Captcha")) {

			Captcha model = new Captcha(name);
			model.setParent(currentComponent);

			if (elm.getAttribute("caseSensitive").equalsIgnoreCase("true")) 
				model.setCaseSensitive(true);
			else
				model.setCaseSensitive(false);
			model.setSessionVariableName(elm.getAttribute("sessionVariableName"));
					
			model.setPageModel(page);		

			try { model.setImageWidth(Integer.parseInt(elm.getAttribute("width"))); } catch(NumberFormatException nfe) {model.setImageWidth(1);}
			try { model.setImageHeight(Integer.parseInt(elm.getAttribute("height"))); } catch(NumberFormatException nfe) {model.setImageHeight(1);}

	        return model;

	  } else if (tagName.equals("TextBox")) {
        String fieldSource = elm.getAttribute("controlSource");
        TextBox model = new TextBox(name, fieldSource, page);
        //model.setPage(page);

        fillControlAttributes(model, elm);

        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setCaption(elm.getAttribute("caption"));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setErrorControlName(elm.getAttribute("errorControl"));
        model.setUnique(new Boolean(elm.getAttribute("unique")).booleanValue());
        if ( ! StringUtils.isEmpty(elm.getAttribute("verificationRule")) ) {
          MessageFormat msgfmt = new MessageFormat(res.getString("CCS_MaskValidation"));
          model.addValidateHandler(RegexpHandlersFactory.getHandler(elm.getAttribute("verificationRule"), msgfmt.format(new String[] {model.getCaption()})));
        }
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("TextArea")) {
        String fieldSource = elm.getAttribute("controlSource");
        TextArea model = new TextArea(name, fieldSource, page);

        fillControlAttributes(model, elm);

        //model.setPage(page);
        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setCaption(elm.getAttribute("caption"));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setErrorControlName(elm.getAttribute("errorControl"));
        model.setUnique(new Boolean(elm.getAttribute("unique")).booleanValue());
        if ( ! StringUtils.isEmpty(elm.getAttribute("verificationRule")) ) {
          MessageFormat msgfmt = new MessageFormat(res.getString("CCS_MaskValidation"));
          model.addValidateHandler(RegexpHandlersFactory.getHandler(elm.getAttribute("verificationRule"), msgfmt.format(new String[] {model.getCaption()})));
        }
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("Hidden")) {
        String fieldSource = elm.getAttribute("controlSource");
        Hidden model = new Hidden(name, fieldSource, page);

        fillControlAttributes(model, elm);

        //model.setPage(page);
        model.setCaption(elm.getAttribute("caption"));
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setErrorControlName(elm.getAttribute("errorControl"));
        model.setUnique(new Boolean(elm.getAttribute("unique")).booleanValue());
        if ( ! StringUtils.isEmpty(elm.getAttribute("verificationRule")) ) {
          MessageFormat msgfmt = new MessageFormat(res.getString("CCS_MaskValidation"));
          model.addValidateHandler(RegexpHandlersFactory.getHandler(elm.getAttribute("verificationRule"), msgfmt.format(new String[] {model.getCaption()})));
        }
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("Label")) {
        String fieldSource = elm.getAttribute("controlSource");
        Label model = new Label(name, fieldSource, page);

        fillControlAttributes(model, elm);

        //model.setPage(page);
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("ReportLabel")) {
        String fieldSource = elm.getAttribute("controlSource");
        String function = elm.getAttribute("function");
        ReportLabel model = new ReportLabel(name, fieldSource, page);

        fillControlAttributes(model, elm);

        model.setParent(currentComponent);
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setResetAt(elm.getAttribute("resetAt"));
        String percentOf = elm.getAttribute("percentOf");
        if (! StringUtils.isEmpty(percentOf)) {
            model.setComputeAt(percentOf);
            model.setComputeAtFunction(new PercentOfTotalHandler());
        }
        model.setEmptyText(elm.getAttribute("emptyValue"));
        if ("Sum".equals(function)) {
            model.setFunction(new SumHandler());
        } else if ("Count".equals(function)) {
            model.setFunction(new CountHandler());
        } else if ("Min".equals(function)) {
            model.setFunction(new MinHandler());
        } else if ("Max".equals(function)) {
            model.setFunction(new MaxHandler());
        } else if ("Avg".equals(function)) {
            model.setFunction(new AverageHandler());
        } else if ("".equals(function) && ! StringUtils.isEmpty(percentOf)) {
            model.setFunction(new DefaultHandler());
        }
        model.setHideDuplicates(new Boolean(elm.getAttribute("hideDuplicates")).booleanValue());
        return model;
      } else if (tagName.equals("Link")) {
        String fieldSource = elm.getAttribute("controlSource");
        Link model = new Link(name, fieldSource, page);

        fillControlAttributes(model, elm);

        //model.setPage(page);
        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setHrefType(elm.getAttribute("hrefType"));
        model.setHrefSource(elm.getAttribute("hrefSource"));
        if (!"Database".equals(model.getHrefType())) model.setHrefSourceValue(elm.getAttribute("hrefSource"));
        model.setPreserveType(PreserveParameterType.getPreserveParameterType(elm.getAttribute("preserveParams")));
        model.setConvertRule(elm.getAttribute("convertRule"));
        model.setParent(currentComponent);
        NodeList exclude = elm.getElementsByTagName("ExcludeParameter");
        for (int i=0; i<exclude.getLength(); i++) {
          model.addExcludeParam(((Element)exclude.item(i)).getAttribute("name"));
        }
        NodeList params = elm.getElementsByTagName("LinkParameter");
        for (int i=0; i<params.getLength(); i++) {
          Element p = (Element)params.item(i);
          String pname = p.getAttribute("name");
          String source = p.getAttribute("sourceName");
          ParameterSource type = ParameterSource.getParameterSource(p.getAttribute("sourceType"));
          ControlType parType = null;
          if (! StringUtils.isEmpty(elm.getAttribute("dataType"))) {
            parType = ControlType.getControlType(p.getAttribute("dataType"));
          }
          model.addParameter(new LinkParameter(pname, source, type, p.getAttribute("format"), parType));
        }
        return model;
      } else if (tagName.equals("Sorter")) {
        Sorter model = new Sorter(name, (Sortable)currentComponent, page);
        model.setColumn(elm.getAttribute("ascColumn"));
        String desc = elm.getAttribute("descColumn");
        if (!StringUtils.isEmpty(desc)) model.setReverseColumn(desc);
        model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        return model;
      } else if (tagName.equals("Navigator")) {
          if (currentComponent instanceof Navigable) {
            Navigator model = new Navigator(name, (Navigable)currentComponent, page);

			model.setPageSizes(elm.getAttribute("pageSizes"));

            return model;
          } else if (currentComponent instanceof Calendar) {
              CalendarNavigator nav = new CalendarNavigator(name);
              nav.setYearsRange(getIntAttribute(elm.getAttribute("yearsRange"), 7));
              return nav;
          }
          return null;
      } else if (tagName.equals("Image")) {
        String fieldSource = elm.getAttribute("controlSource");
        Image model = new Image(name, fieldSource, page);

        fillControlAttributes(model, elm);

        //model.setPage(page);
        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("ImageLink")) {
        String fieldSource = elm.getAttribute("controlSource");
        ImageLink model = new ImageLink(name, fieldSource, page);

        fillControlAttributes(model, elm);

        //model.setPage(page);
        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setHtmlEncode(! new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setFormatPattern(elm.getAttribute("format"));
        model.setDbFormatPattern(elm.getAttribute("dbFormat"));
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setHrefType(elm.getAttribute("hrefType"));
        model.setHrefSource(elm.getAttribute("hrefSource"));
        model.setHrefSourceValue(elm.getAttribute("hrefSource"));
        model.setPreserveType(PreserveParameterType.getPreserveParameterType(elm.getAttribute("preserveParams")));
        model.setConvertRule(elm.getAttribute("convertRule"));
        model.setParent(currentComponent);
        NodeList exclude = elm.getElementsByTagName("ExcludeParameter");
        for (int i=0; i<exclude.getLength(); i++) {
          model.addExcludeParam(((Element)exclude.item(i)).getAttribute("name"));
        }
        NodeList params = elm.getElementsByTagName("LinkParameter");
        for (int i=0; i<params.getLength(); i++) {
          Element p = (Element)params.item(i);
          String pname = p.getAttribute("name");
          String source = p.getAttribute("sourceName");
          ParameterSource type = ParameterSource.getParameterSource(p.getAttribute("sourceType"));
          ControlType parType = null;
          if (! StringUtils.isEmpty(elm.getAttribute("dataType"))) {
            parType = ControlType.getControlType(p.getAttribute("dataType"));
          }
          model.addParameter(new LinkParameter(pname, source, type, p.getAttribute("format"), parType));
        }
        return model;
      } else if (tagName.equals("Panel")) {
        Panel model = new Panel(name);
        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) && !"Dynamic".equals (elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());

		if ( !StringUtils.isEmpty(elm.getAttribute("isUpdate")) && "True".equals (elm.getAttribute("isUpdate")) ) 
			model.setUpdatePanel(true);
			else 
			model.setUpdatePanel(false);
		if ( !StringUtils.isEmpty(elm.getAttribute("panelId")) ) 
			model.setPanelId(elm.getAttribute("panelId"));
		
		NodeList nl = elm.getElementsByTagName("Child");
        for (int i = 0 ; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Element.ELEMENT_NODE) {
				model.add( ((Element) nl.item(i)).getAttribute("name") );
            }
        }
		
		
        return model;
      } else if (tagName.equals("CheckBox")) {
        String fieldSource = elm.getAttribute("controlSource");
        CheckBox model = new CheckBox(name, fieldSource, page);

        fillControlAttributes(model, elm);

        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        //model.setPage(page);
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("ListBox")) {
        String fieldSource = elm.getAttribute("controlSource");
        ListBox model = new ListBox(name, fieldSource, page);

        fillControlAttributes(model, elm);

        if ( !StringUtils.isEmpty(elm.getAttribute("visible")) ) model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
        model.setCaption(elm.getAttribute("caption"));
        model.setErrorControlName(elm.getAttribute("errorControl"));
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        if ( ! StringUtils.isEmpty(elm.getAttribute("boundColumn")) ) {
            model.setBoundColumn(elm.getAttribute("boundColumn"));
        }
        if ( ! StringUtils.isEmpty(elm.getAttribute("textColumn")) ) {
            model.setTextColumn(elm.getAttribute("textColumn"));
        }
        model.setListOfValues(elm.getAttribute("listOfValues"));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setUnique(new Boolean(elm.getAttribute("unique")).booleanValue());
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("RadioButton")) {
        String fieldSource = elm.getAttribute("controlSource");
        RadioButton model = new RadioButton(name, fieldSource, page);

        fillControlAttributes(model, elm);

        model.setCaption(elm.getAttribute("caption"));
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        if ( ! StringUtils.isEmpty(elm.getAttribute("boundColumn")) ) {
            model.setBoundColumn(elm.getAttribute("boundColumn"));
        }
        if ( ! StringUtils.isEmpty(elm.getAttribute("textColumn")) ) {
            model.setTextColumn(elm.getAttribute("textColumn"));
        }
        model.setListOfValues(elm.getAttribute("listOfValues"));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setUnique(new Boolean(elm.getAttribute("unique")).booleanValue());
        model.setHtmlEncode(!new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("CheckBoxList")) {
        String fieldSource = elm.getAttribute("controlSource");
        CheckBoxList model = new CheckBoxList(name, fieldSource, page);

        fillControlAttributes(model, elm);

        model.setCaption(elm.getAttribute("caption"));
        model.setType(ControlType.getControlType(elm.getAttribute("dataType")));
        if ( ! StringUtils.isEmpty(elm.getAttribute("boundColumn")) ) {
            model.setBoundColumn(elm.getAttribute("boundColumn"));
        }
        if ( ! StringUtils.isEmpty(elm.getAttribute("textColumn")) ) {
            model.setTextColumn(elm.getAttribute("textColumn"));
        }
        model.setListOfValues(elm.getAttribute("listOfValues"));
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setUnique(new Boolean(elm.getAttribute("unique")).booleanValue());
        model.setHtmlEncode(!new Boolean(elm.getAttribute("isHtml")).booleanValue());
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("FileUpload")) {
        String fieldSource = elm.getAttribute("controlSource");
        FileUpload model = new FileUpload(name, fieldSource, page);

        model.setType(ControlType.TEXT);
        String tempFolder = elm.getAttribute("tempFolder");

        if ( tempFolder.endsWith("%") && tempFolder.startsWith("%") ) {
            tempFolder = tempFolder.substring(0,tempFolder.length()-1);
        }

        if (tempFolder.equals("%TEMP")) {
            tempFolder = System.getProperty("java.io.tmpdir");
        } else if (tempFolder.startsWith("%")) {
            tempFolder = System.getProperty(tempFolder.substring(1));
        }
        model.setControlSourceType(elm.getAttribute("controlSourceType"));
        model.setTempFolder(tempFolder);
        model.setProcessedFolder(elm.getAttribute("procFolder"));
        DefaultFileFilter filter = new DefaultFileFilter(elm.getAttribute("allow"), elm.getAttribute("disallow"));
        model.setFileFilter(filter);
        model.setSizeLimit(new Long(elm.getAttribute("sizeLimit")).longValue());
        model.setRequired(new Boolean(elm.getAttribute("required")).booleanValue());
        model.setParent(currentComponent);
        return model;
      } else if (tagName.equals("DatePicker")) {
        DatePicker model = new DatePicker(name, page);

        //fillControlAttributes(model, elm);

        String cntrlName = elm.getAttribute("control");
        model.setControlName(cntrlName);
        model.setStyleName(elm.getAttribute("style"));
        model.setParent(currentComponent);
        model.setVisible(true);
        return model;
      } else if (tagName.equals("Include")) {
        Model model = new Model(name);
        return model;
      } // other elements are ignored
      return null;
    }
    /** Create Record model from its XML element. **/
    protected Record getRecordModel(Element elm) {
      Record model = new Record(elm.getAttribute("name"));
      currentComponent = model;
      model.setPageModel(page);
      model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
      model.setReturnPage(elm.getAttribute("returnPage"));
      //NodeList exclude = elm.getElementsByTagName("ExcludeParameter");
      //for (int i=0; i<exclude.getLength(); i++) {
      //  model.addExcludeParam(((Element)exclude.item(i)).getAttribute("name"));
      //}
      model.setPreserveType(PreserveParameterType.getPreserveParameterType(elm.getAttribute("preserveParams")));
      model.setAllowInsert(new Boolean(elm.getAttribute("allowInsert")).booleanValue());
      model.setAllowUpdate(new Boolean(elm.getAttribute("allowUpdate")).booleanValue());
      model.setAllowDelete(new Boolean(elm.getAttribute("allowDelete")).booleanValue());
      model.setAllowRead(new Boolean(elm.getAttribute("allowRead")).booleanValue());
      model.setVisible(new Boolean(elm.getAttribute("visible")).booleanValue());
      NodeList children = elm.getChildNodes();
      for (int i=0; i<children.getLength(); i++) {
        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element e = (Element)children.item(i);
          if (e.getTagName().equals("Security")) {
            setGroupPermissions(model, e);
          } else if (e.getTagName().equals("ExcludeParameter")) {
            model.addExcludeParam(e.getAttribute("name"));
          } else if (e.getTagName().equals("Attribute") ) {
            ModelAttribute ma = paresAttribute (e);
            if (ma != null) {
                //model.setAttribute (model.getName()+":"+ma.getName(), ma);
                model.setAttribute (ma.getName(), ma);
            }
          } else {
            Model ctrlModel = getControlModel(e);
            if (ctrlModel != null) model.add(ctrlModel);
          }
        }
      }
      return model;
    }
    /** Create Grid model from its XML element. **/
    protected Grid getGridModel(Element elm) {
      Grid model = new Grid(elm.getAttribute("name"));
      currentComponent = model;
      model.setPageModel(page);
      model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
      model.setAllowRead(new Boolean(elm.getAttribute("allowRead")).booleanValue());
      model.setCountNeeded(new Boolean(elm.getAttribute("useCount")).booleanValue());
      try { model.setFetchSizeLimit(Integer.parseInt(elm.getAttribute("fetchSizeLimit"))); }
      catch(NumberFormatException nfe) {model.setFetchSizeLimit(-1);}
      try { model.setFetchSize(Integer.parseInt(elm.getAttribute("fetchSize"))); }
      catch(NumberFormatException nfe) {model.setFetchSize(-1);}
      // set other Grid properties
      NodeList children = elm.getChildNodes();
      for (int i=0; i<children.getLength(); i++) {
        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element e = (Element)children.item(i);
          if (e.getTagName().equals("Row")) {
            NodeList rowChildren = e.getChildNodes();
            for (int ci=0; ci<rowChildren.getLength(); ci++) {
              if (rowChildren.item(ci).getNodeType() == Node.ELEMENT_NODE) {
                Element ce = (Element)rowChildren.item(ci);
                if ("Attribute".equals (ce.getTagName()) ) {
                    ModelAttribute ma = paresAttribute (ce);
                    if (ma != null) {
                        ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                        //model.setAttribute (ma.getName(), ma);
                        //model.setRowAttribute (model.getName()+":"+ma.getName(), ma);
                        //model.setRowAttribute (ma.getName(), ma);
                        model.setAttribute (ma.getName(), ma);
                    }
                } else {
                    Model ctrlModel = getControlModel(ce);
                    if (ctrlModel != null) model.add(ctrlModel);
                }
              }
            }
          } else if (e.getTagName().equals("Security")) {
            setGroupPermissions(model, e);
          } else if (e.getTagName().equals("Attribute")) {
            ModelAttribute ma = paresAttribute (e);
            if (ma != null) {
                ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                //model.setAttribute (ma.getName(), ma);
                //model.setAttribute (model.getName()+":"+ma.getName(), ma);
                model.setAttribute (ma.getName(), ma);
            }
          } else {
            Model ctrlModel = getControlModel(e);
            if (ctrlModel != null) {
              if (ctrlModel instanceof Control) ((Control)ctrlModel).setStatic(true);
              model.add(ctrlModel);
            }
          }
        }
      }
      return model;
    }

    /** Create Calendar model from its XML element. **/
    protected Calendar getCalendarModel(Element elm) {
        Calendar model = new Calendar(elm.getAttribute("name"));
        currentComponent = model;
        model.setPageModel(page);
        model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
        model.setAllowRead(new Boolean(elm.getAttribute("allowRead")).booleanValue());
        model.setShowEventCaption (new Boolean(elm.getAttribute("showEventCaption")).booleanValue());

        //model.setStrictShowEmptyWeek ( new Boolean(elm.getAttribute("strinctShowEmptyWeeks")).booleanValue() );

        if ("QUARTER".equalsIgnoreCase(elm.getAttribute("months"))) {
            model.setMonths(Calendar.CALENDAR_MONTHS_QUARTER);
        } else {
            model.setMonths(getIntAttribute(elm.getAttribute("months"), 1));
        }
        model.setShowOtherMonthsDays(new Boolean(elm.getAttribute("showOtherMonthsDays")).booleanValue());
        model.setMonthsInRow(getIntAttribute(elm.getAttribute("monthsInRow"), 4));
        model.setDateField(elm.getAttribute("dateField"));
        model.setDateFieldDbFormatPattern(elm.getAttribute("dateFieldDBFormat"));
        model.setTimeField(elm.getAttribute("timeField"));
        model.setTimeFieldDbFormatPattern(elm.getAttribute("timeFieldDBFormat"));
        model.setWeekDayFormat(elm.getAttribute("weekdaysFormat"));
      
        NodeList children = elm.getChildNodes();
        for (int i=0; i<children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)children.item(i);

                if (e.getTagName().equals("VisualStyles")) {
                    setVisualStyles(e);
                } else if (e.getTagName().equals("Event")) {
                    parseCalendarSection(e);
                } else if (e.getTagName().equals("Week")) {
                    parseCalendarSection(e);
                } else if (e.getTagName().equals("WeekDays")) {
                    parseCalendarSection(e);
                } else if (e.getTagName().equals("Day")) {
                    parseCalendarSection(e);
                } else if (e.getTagName().equals("EmptyDay")) {
                    parseCalendarSection(e);
                } else if (e.getTagName().equals("Month")) {
                    parseCalendarSection(e);
                } else if (e.getTagName().equals("Main")) {
                    parseCalendarSection(e);
                } else if (e.getTagName().equals("Security")) {
                    setGroupPermissions(model, e);
                } else if (e.getTagName().equals("Attribute")) {
                    ModelAttribute ma = paresAttribute (e);
                    if (ma != null) {
                        //model.setAttribute (model.getName()+":"+ma.getName(), ma);
                        model.setAttribute (ma.getName(), ma);
                    }
                } else {
                    Model ctrlModel = getControlModel(e);
                    if (ctrlModel != null) model.add(ctrlModel);
                }
            }
        }


        return model;
    }

    private void setVisualStyles(Element elm) {
        Calendar cal = (Calendar) currentComponent;
        NodeList children = elm.getChildNodes();
        for (int i=0; i<children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)children.item(i);
                if (e.getTagName().equals("VisualStyle")) {
                    cal.setVisualStyle(e.getAttribute("name"), e.getAttribute("value"));
                }
            }
        }
    }
    
    private void parseCalendarSection(Element elm) {
        Calendar cal = (Calendar) currentComponent;
        NodeList children = elm.getChildNodes();
        for (int i=0; i<children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)children.item(i);
                if ("Attribute".equals (e.getTagName()) ) {
                    ModelAttribute ma = paresAttribute (e);
                    if (ma != null) {
                        ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                        //model.setAttribute (ma.getName(), ma);
                        ////cal.setRowAttribute (cal.getName()+":"+ma.getName(), ma);
                        //cal.setRowAttribute (ma.getName(), ma);
                        
                        String sourceType = ma.getSourceType();

                        if ("URL".equals (sourceType)       || "Form".equals (sourceType) || 
                            "Session".equals (sourceType)   || "Application".equals (sourceType) || 
                            "Cookie".equals (sourceType)) {
                            //cal.setAttribute (cal.getName()+":"+ma.getName(), ma);
                            cal.setAttribute (ma.getName(), ma);
                        } else if ( "DataField".equals (sourceType) ) {
                            //cal.addGroupAttribute(elm.getTagName(), ma);
                            //cal.setRowAttribute (cal.getName()+":"+ma.getName(), ma);
                            cal.setRowAttribute (ma.getName(), ma);
                        }
                    }
                } else {
                    Model ctrlModel = getControlModel(e);
                    if (ctrlModel != null) {
                        cal.add(ctrlModel);
                        cal.addControlToSection(ctrlModel.getName(), elm.getTagName());
                    }
                }


            }
        }
    }
    
    /** Create Report model from its XML element. **/
    protected Report getReportModel(Element elm) {
      Report model = new Report(elm.getAttribute("name"));
      this.sections = new ArrayList();
      currentComponent = model;
      model.setPageModel(page);
      model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
      model.setAllowRead(new Boolean(elm.getAttribute("allowRead")).booleanValue());
      model.setHtmlTemplateType(elm.getAttribute("htmlTemplateType"));
      model.setEnablePrintMode(new Boolean(elm.getAttribute("enablePrintMode")).booleanValue());
      model.setViewMode(elm.getAttribute("viewMode"));
      try { model.setWebPageSize(Integer.parseInt(elm.getAttribute("recordsPerWebPage"))); }
      catch(NumberFormatException nfe) {model.setWebPageSize(0);}
      try { model.setPrintPageSize(Integer.parseInt(elm.getAttribute("recordsPerPhysicalPage"))); }
      catch(NumberFormatException nfe) {model.setPrintPageSize(0);}
      NodeList children = elm.getChildNodes();
      for (int i=0; i<children.getLength(); i++) {
        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element e = (Element)children.item(i);

          if (e.getTagName().equals("Group")) {
            parseGroupModel(e);
          } else if (e.getTagName().equals("Section")) {
            saveGroupSection(e);
          } else if (e.getTagName().equals("Detail")) {
            parseGroupModel(e);
          } else if (e.getTagName().equals("Security")) {
            setGroupPermissions(model, e);
          } else if (e.getTagName().equals("Attribute")) {
                ModelAttribute ma = paresAttribute (e);
                if (ma != null) {
                    ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                    //model.setAttribute (ma.getName(), ma);
                    String sourceType = ma.getSourceType();
                    if ("URL".equals (sourceType)       || "Form".equals (sourceType) || 
                        "Session".equals (sourceType)   || "Application".equals (sourceType) || 
                        "Cookie".equals (sourceType)) {
                            //model.setAttribute (model.getName()+":"+ma.getName(), ma);
                            model.setAttribute (ma.getName(), ma);
                    } else if ( "DataField".equals (sourceType) ) {
                            //model.setRowAttribute (model.getName()+":"+ma.getName(), ma);
                            model.setRowAttribute (ma.getName(), ma);
                    }
                }
          } else {
            Model ctrlModel = getControlModel(e);
            if (ctrlModel != null) model.add(ctrlModel);
          }
        }
      }
      if (! this.sections.isEmpty()) {
          for (Iterator it = this.sections.iterator(); it.hasNext(); ) {
              parseGroupSection((Element) it.next());
          }
      }
      model.freezeStructure();
      return model;
    }
    
        
    protected void parseGroupModel(Element elm) {
      Report reportModel = (Report)currentComponent;
      String group = elm.getAttribute("name");
      String field = elm.getAttribute("field");
      String sortOrder = elm.getAttribute("sortOrder");
      boolean headerVisible = new Boolean(elm.getAttribute("headerVisible")).booleanValue();
      boolean footerVisible = new Boolean(elm.getAttribute("footerVisible")).booleanValue();
      double headerHeight = 1.0;
      double footerHeight = 1.0;
      try {headerHeight = new Double(elm.getAttribute("headerHeight")).doubleValue();} catch (NumberFormatException e) {}
      try {footerHeight = new Double(elm.getAttribute("footerHeight")).doubleValue();} catch (NumberFormatException e) {}
      boolean reportGroup = false;
      boolean pageGroup = false;
      boolean detailGroup = false;
      boolean header = false;
      boolean footer = false;
      ReportGroup g = null;
      if ("".equals(group)) {
        double dHeight = 1.0;
        try {dHeight = new Double(elm.getAttribute("height")).doubleValue();} catch (NumberFormatException e) {}
        boolean dVisible = new Boolean(elm.getAttribute("visible")).booleanValue();
        detailGroup = true;
        reportModel.getSection("Detail").setVisible(dVisible);
        reportModel.getSection("Detail").setHeight(dHeight);
        saveGroupSection(elm);
        return;
        // TODO: set height
      } else if ("Report".equals(group)) {
        reportGroup = true;
        g = reportModel.getGroup("Report");
      } else if ("Page".equals(group)) {
        pageGroup = true;
        g = reportModel.getGroup("Page");
      } else {
        g = reportModel.createGroup(group, field);
        g.setSortOrder(sortOrder);
      }
      g.setHeaderVisible(headerVisible);
      g.setFooterVisible(footerVisible);
      g.setHeaderHeight(headerHeight);
      g.setFooterHeight(footerHeight);

      if (!detailGroup) {

        NodeList children = elm.getChildNodes();
        for (int i=0; i<children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                saveGroupSection((Element)children.item(i));
            }
        }
      }

    }

    private ArrayList sections = new ArrayList();
    protected void saveGroupSection(Element elm) {
        sections.add(elm);
    }
    
    protected void parseGroupSection(Element elm) {
        Report reportModel = (Report) currentComponent;
        String name = elm.getAttribute("name");
        String group = null;
        int sectionType = -1;
        boolean isDetail = false;
        boolean isHeader = false;
        if (name.endsWith("_Header")) {
            sectionType = ReportGroup.GROUP_HEADER;
            group = StringUtils.replace(name, "_Header", "");
        } else if (name.endsWith("_Footer")) {
            sectionType = ReportGroup.GROUP_FOOTER;
            group = StringUtils.replace(name, "_Footer", "");
        } else {
            isDetail = true;
        }
        NodeList children = elm.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) children.item(i);
                if ("Attribute".equals ( e.getTagName() ) ) {
                    ModelAttribute ma = paresAttribute (e);
                    if (ma != null) {
                        ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                        //model.setAttribute (ma.getName(), ma);
                        String sourceType = ma.getSourceType();
                        if ("URL".equals (sourceType)       || "Form".equals (sourceType) || 
                            "Session".equals (sourceType)   || "Application".equals (sourceType) || 
                            "Cookie".equals (sourceType)) {
                                //reportModel.setAttribute (reportModel.getName()+":"+ma.getName(), ma);
                                reportModel.setAttribute (ma.getName(), ma);
                        } else if ( "DataField".equals (sourceType) ) {
                                //reportModel.setRowAttribute (reportModel.getName()+":"+ma.getName(), ma);
                                reportModel.setRowAttribute (ma.getName(), ma);
                        }
                    }
                } else {
                    Model ctrlModel = getControlModel(e);
                    if (ctrlModel != null) {
                        if (isDetail) {
                            reportModel.addDetailControl(ctrlModel);
                        } else {
                            reportModel.addGroupControl(group, ctrlModel, sectionType);
                        }
                    }
                }
            }
        }
    }

    /** Create EditableGrid model from its XML element. **/
    protected EditableGrid getEditableGridModel(Element elm) {
      EditableGrid model = new EditableGrid(elm.getAttribute("name"));

      //parseAttributes(model, elm);

      currentComponent = model;
      model.setPageModel(page);
      model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
      try { model.setFetchSizeLimit(Integer.parseInt(elm.getAttribute("fetchSizeLimit"))); }
      catch(NumberFormatException nfe) {model.setFetchSizeLimit(-1);}
      try { model.setFetchSize(Integer.parseInt(elm.getAttribute("fetchSize"))); }
      catch(NumberFormatException nfe) {model.setFetchSize(-1);}
      model.setReturnPage(elm.getAttribute("returnPage"));
      model.setDeleteControlName(elm.getAttribute("deleteControl"));
      try {model.setNumberEmptyRows(Integer.parseInt(elm.getAttribute("emptyRows")));}
      catch(NumberFormatException nfe) {model.setNumberEmptyRows(1);}
      model.setPreserveType(PreserveParameterType.getPreserveParameterType(elm.getAttribute("preserveParams")));
      model.setAllowInsert(new Boolean(elm.getAttribute("allowInsert")).booleanValue());
      model.setAllowUpdate(new Boolean(elm.getAttribute("allowUpdate")).booleanValue());
      model.setAllowDelete(new Boolean(elm.getAttribute("allowDelete")).booleanValue());
      model.setAllowRead(new Boolean(elm.getAttribute("allowRead")).booleanValue());
      model.setCountNeeded(new Boolean(elm.getAttribute("useCount")).booleanValue());
      // set other EditableGrid properties
      NodeList children = elm.getChildNodes();
      for (int i=0; i<children.getLength(); i++) {
        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element e = (Element)children.item(i);
          if (e.getTagName().equals("Row")) {
            NodeList rowChildren = e.getChildNodes();
            for (int ci=0; ci<rowChildren.getLength(); ci++) {
              if (rowChildren.item(ci).getNodeType() == Node.ELEMENT_NODE) {
                Element ce = (Element)rowChildren.item(ci);
                if ("Attribute".equals (ce.getTagName()) ) {
                    ModelAttribute ma = paresAttribute (ce);
                    if (ma != null) {
                        ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                        //model.setAttribute (ma.getName(), ma);

                        //model.setRowAttribute (model.getName()+":"+ma.getName(), ma);
                        model.setRowAttribute (ma.getName(), ma);
                    }
                } else {
                    Model ctrlModel = getControlModel(ce);
                    if (ctrlModel != null) {
                        model.addRowControl(ctrlModel.getName());
                        model.add(ctrlModel);
                    }
                }
              }
            }

            
          } else if (e.getTagName().equals("Security")) {
            setGroupPermissions(model, e);
          } else if (e.getTagName().equals("cached")) {
            String alias = e.getAttribute("alias");
            if (alias.length() <= 0) alias = null;
            model.addCachedColumn(e.getAttribute("field"), alias, ControlType.getControlType(e.getAttribute("type")));
          } else if (e.getTagName().equals("ExcludeParameter")) {
            model.addExcludeParam(e.getAttribute("name"));
          } else if (e.getTagName().equals("Attribute")) {
            ModelAttribute ma = paresAttribute (e);
            if (ma != null) {
                ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                //model.setAttribute (ma.getName(), ma);

                //model.setAttribute (model.getName()+":"+ma.getName(), ma);
                model.setAttribute (ma.getName(), ma);
            }

          } else {
            Model ctrlModel = getControlModel(e);
            if (ctrlModel != null) {
              if (ctrlModel instanceof Control) ((Control)ctrlModel).setStatic(true);
              model.add(ctrlModel);
            }
          }
        }
      }
      return model;
    }
    /** Create Directory model from its XML element. **/
    protected Directory getDirectoryModel(Element elm) {
      Directory model = new Directory(elm.getAttribute("name"));
      currentComponent = model;
      model.setPageModel(page);
      model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
      // set other Directory properties
      try { model.setNumberOfColumns(Long.parseLong(elm.getAttribute("columns"))); }
      catch(NumberFormatException nfe) {model.setNumberOfColumns(1);}
      try { model.setNumberOfSubCategories(Long.parseLong(elm.getAttribute("categories"))); }
      catch(NumberFormatException nfe) {model.setNumberOfSubCategories(0);}
      model.setCategoryFieldName(elm.getAttribute("category"));
      model.setSubCategoryFieldName(elm.getAttribute("subcategory"));
      NodeList children = elm.getChildNodes();
      for (int i=0; i<children.getLength(); i++) {
        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element e = (Element)children.item(i);
          if (e.getTagName().equals("Security")) {
            setGroupPermissions(model, e);
          } else if (e.getTagName().equals("Attribute")) {
                ModelAttribute ma = paresAttribute (e);
                if (ma != null) {
                    ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                    //model.setAttribute (ma.getName(), ma);
                    String sourceType = ma.getSourceType();
                    if ("URL".equals (sourceType)       || "Form".equals (sourceType) || 
                        "Session".equals (sourceType)   || "Application".equals (sourceType) || 
                        "Cookie".equals (sourceType)) {
                            //model.setAttribute (model.getName()+":"+ma.getName(), ma);
                            model.setAttribute (ma.getName(), ma);
                    } else if ( "DataField".equals (sourceType) ) {
                            //model.setRowAttribute (model.getName()+":"+ma.getName(), ma);
                            model.setRowAttribute (ma.getName(), ma);
                    }
                }
                
          } else {
            Model ctrlModel = getControlModel(e);
            if (ctrlModel != null) model.add(ctrlModel);
          }
        }
      }
      return model;
    }
    /** Create Path model from its XML element. **/
    protected Path getPathModel(Element elm) {
      Path model = new Path(elm.getAttribute("name"));
      currentComponent = model;
      model.setPageModel(page);
      model.setRestricted(new Boolean(elm.getAttribute("restricted")).booleanValue());
      model.setCategoryIdField(elm.getAttribute("categoryId"));
      model.setParentIdField(elm.getAttribute("parentId"));
      NodeList children = elm.getChildNodes();
      for (int i=0; i<children.getLength(); i++) {
        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element e = (Element)children.item(i);
          if (e.getTagName().equals("Security")) {
            setGroupPermissions(model, e);
          } else if (e.getTagName().equals("Attribute")) {
                ModelAttribute ma = paresAttribute (e);
                if (ma != null) {
                    ////model.setAttribute (model.getName()+":"+ma.getName(), ma);
                    //model.setAttribute (ma.getName(), ma);
                    String sourceType = ma.getSourceType();
                    if ("URL".equals (sourceType)       || "Form".equals (sourceType) || 
                        "Session".equals (sourceType)   || "Application".equals (sourceType) || 
                        "Cookie".equals (sourceType)) {
                            //model.setAttribute (model.getName()+":"+ma.getName(), ma);
                            model.setAttribute (ma.getName(), ma);
                    } else if ( "DataField".equals (sourceType) ) {
                            //model.setRowAttribute (model.getName()+":"+ma.getName(), ma);
                            model.setRowAttribute (ma.getName(), ma);
                    }
                }
                
          } else {
            Model ctrlModel = getControlModel(e);
            if (ctrlModel != null) model.add(ctrlModel);
          }
        }
      }
      return model;
    }
    /** Create Page model from its XML model. **/
    protected void getPageModel(Element pelm) {
      Page model = new Page(pelm.getAttribute("name"));
      model.setRestricted(new Boolean(pelm.getAttribute("restricted")).booleanValue());
      //model.setAccessDeniedPage(pelm.getAttribute("accessDeniedPage"));
      model.setOnlySslAccess(new Boolean(pelm.getAttribute("onlySslAccess")).booleanValue());

      boolean cachingEnabled = new Boolean(pelm.getAttribute("cachingEnabled")).booleanValue();
      String pageName = pelm.getAttribute("cachingPageName");
      PageSettings cacheSettings = null;
      if (cachingEnabled && CacheConfigurator.getPageSettings(pageName) == null) {
          int duration = getIntAttribute(pelm.getAttribute("cachingDuration"), 120);
          cacheSettings = new PageSettings();
          cacheSettings.setCacheEnabled(true);
          cacheSettings.setName(pageName);
          cacheSettings.setDuration(duration);
          CacheConfigurator.setPageSettings(cacheSettings.getName(), cacheSettings);
      }
      //model.setConvertRule(pelm.getAttribute("convertRule"));
      page = model;
      currentComponent = model;
      NodeList components = pelm.getChildNodes();
      for (int i = 0; i<components.getLength(); i++) {
        if (components.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element elm = (Element)components.item(i);
            if (elm.getTagName().equals("Grid")) {
              model.add(getGridModel(elm));
            } else if (elm.getTagName().equals("Record")) {
              model.add(getRecordModel(elm));
            } else if (elm.getTagName().equals("Report")) {
              model.add(getReportModel(elm));
            } else if (elm.getTagName().equals("Calendar")) {
              model.add(getCalendarModel(elm));
            } else if (elm.getTagName().equals("EditableGrid")) {
              model.add(getEditableGridModel(elm));
            } else if (elm.getTagName().equals("Directory")) {
              model.add(getDirectoryModel(elm));
            } else if (elm.getTagName().equals("Path")) {
              model.add(getPathModel(elm));
            } else if (elm.getTagName().equals("Security")) {
              setGroupPermissions(model, elm);
            } else if (elm.getTagName().equals("Attribute")) {
                ModelAttribute ma = paresAttribute (elm);
                if (ma != null) {
                    model.setAttribute (ma.getName(), ma);
                }
            } else if (elm.getTagName().equals("CachingParameters")) {
              addCachingParameters(cacheSettings, elm);
            } else {
              Model ctrlModel = getControlModel(elm);
              if (ctrlModel != null) model.add(ctrlModel);
            }
        }
      }
    }

    private void addCachingParameters(PageSettings cacheSettings, Element elm) {
        if (cacheSettings == null) {
            return;
        }
        NodeList params = elm.getChildNodes();
        for (int i = 0; i<params.getLength(); i++) {
            if (params.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element param = (Element) params.item(i);
                cacheSettings.addParameter(new CachingParameter(param.getAttribute("name"), 
                        param.getAttribute("sourceType"), param.getAttribute("action")));
            }
        }
    }
    
    private void setGroupPermissions(Component model, Element elm) {
      NodeList groups = elm.getChildNodes();
      Permission p = new Permission();
      for (int i=0; i<groups.getLength(); i++) {
        if (groups.item(i).getNodeType() == Node.ELEMENT_NODE) {
          Element g = (Element)groups.item(i);
          if (g.getTagName().equals("Group")) {
            boolean allowInsert = new Boolean(g.getAttribute( "allowInsert" )).booleanValue();
            boolean allowUpdate = new Boolean(g.getAttribute( "allowUpdate" )).booleanValue();
            boolean allowDelete = new Boolean(g.getAttribute( "allowDelete" )).booleanValue();
            boolean allowRead = false;

            if ( model instanceof Page ) {
                allowRead = true;
            } else {
                allowRead = new Boolean(g.getAttribute( "allowRead" )).booleanValue();
            }
            int permission = Permission.ALLOW_NOTHING;
            if ( allowInsert ) {
                permission += Permission.ALLOW_INSERT;
            }
            if ( allowUpdate ) {
                permission += Permission.ALLOW_UPDATE;
            }
            if ( allowDelete ) {
                permission += Permission.ALLOW_DELETE;
            }
            if ( allowRead ) {
                permission += Permission.ALLOW_READ;
            }
            try {
                int id = new Integer(g.getAttribute("id")).intValue();
                p.addGroup( id, permission );
            } catch ( NumberFormatException nfe ) {
                p.addGroup( g.getAttribute("id"), permission );
            }
          }
        }
      }
      model.setPermissions(p);
    }

    private int getIntAttribute(String attributeValue, int defaultValue) {
        int result = defaultValue;   
        try {
            result = Integer.parseInt(attributeValue);
        } catch (NumberFormatException nfe) {
        }
        return result;
    }


    private void fillControlAttributes (Model model, Element e) {
        NodeList nl = e.getElementsByTagName("Attribute");
        for (int i = 0 ; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Element.ELEMENT_NODE) {
                ModelAttribute ma = paresAttribute ( (Element)nl.item(i) );
                model.setAttribute(ma.getName(), ma);
            }
        }
    }

    private ModelAttribute paresAttribute (Element attr) {
        String name = attr.getAttribute("name");
        String sourceType = attr.getAttribute("sourceType");
        String source = attr.getAttribute("source");
        String id = attr.getAttribute("id");

        ModelAttribute mattr = new ModelAttribute();
        mattr.setId( Integer.parseInt(id) );
        mattr.setName(name);
        mattr.setSourceName(source);
        mattr.setSourceType(sourceType);
        mattr.setValue(source);

        return mattr;
    }

    /*
    private void parseAttributes (Component model, Element attrs) {
        NodeList nl = attrs.getElementsByTagName("Attribute");
        for (int i = 0 ; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Element.ELEMENT_NODE) {
                String name = ((Element)nl.item(i)).getAttribute("name");
                String sourceType = ((Element)nl.item(i)).getAttribute("sourceType");
                String source = ((Element)nl.item(i)).getAttribute("source");
                String id = ((Element)nl.item(i)).getAttribute("id");

                ModelAttribute mattr = new ModelAttribute();
                mattr.setId( Integer.parseInt(id) );
                mattr.setName(name);
                mattr.setSourceName(source);
                mattr.setSourceType(sourceType);

                model.setAttribute(name, mattr);
            }
                
        }
        
    }
    */

}

//End ModelParser class: head

