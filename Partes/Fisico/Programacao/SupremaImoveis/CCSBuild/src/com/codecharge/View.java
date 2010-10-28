//View class @0-53A8141F
/*
 * $Revision: 1.19 $
 * $Date: 2005/05/04 05:42:26 $
 */
package com.codecharge;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codecharge.components.Button;
import com.codecharge.components.Calendar;
import com.codecharge.components.CalendarNavigator;
import com.codecharge.components.CheckBoxList;
import com.codecharge.components.Component;
import com.codecharge.components.Control;
import com.codecharge.components.DatePicker;
import com.codecharge.components.Directory;
import com.codecharge.components.EditableGrid;
import com.codecharge.components.FileUpload;
import com.codecharge.components.Grid;
import com.codecharge.components.FlashChart;
import com.codecharge.components.Captcha;
import com.codecharge.components.ImageLink;
import com.codecharge.components.Link;
import com.codecharge.components.ListBox;
import com.codecharge.components.Model;
import com.codecharge.components.Navigable;
import com.codecharge.components.Navigator;
import com.codecharge.components.Page;
import com.codecharge.components.Panel;
import com.codecharge.components.Path;
import com.codecharge.components.RadioButton;
import com.codecharge.components.Record;
import com.codecharge.components.Report;
import com.codecharge.components.Sortable;
import com.codecharge.components.Sorter;
import com.codecharge.components.Variable;
import com.codecharge.components.VerifiableControl;
import com.codecharge.components.calendar.CalendarItem;
import com.codecharge.components.calendar.CalendarMonthItem;
import com.codecharge.components.calendar.CalendarNavigatorItem;
import com.codecharge.components.report.ReportGroup;
import com.codecharge.components.report.ReportRow;
import com.codecharge.db.ParameterSource;
import com.codecharge.events.Event;
import com.codecharge.template.ITemplateParser;
import com.codecharge.template.ITemplateSource;
import com.codecharge.util.CCLogger;
import com.codecharge.util.CCSURL;
import com.codecharge.util.ContextStorage;
import com.codecharge.util.LinkParameter;
import com.codecharge.util.PreserveParameterType;
import com.codecharge.util.SessionStorage;
import com.codecharge.util.StringUtils;
import com.codecharge.util.Utils;
import com.codecharge.util.cache.CacheEvent;
import com.codecharge.util.cache.ICache;
import com.codecharge.util.cache.PageSettings;
import com.codecharge.util.ModelAttribute;
import com.codecharge.validation.ErrorCollection;

public abstract class View {

  protected HttpServletRequest req;
  protected HttpServletResponse resp;
  protected String tmplPath;
  protected ITemplate tmpl;
  protected ServletContext context;
  protected Page page;
  protected CCLogger logger;
  protected View view;
  protected HashMap parsedControls = new HashMap();

  private SimpleDateFormat profFormat = new SimpleDateFormat("dd HH:mm:ss.S"); 
  
  public View() {
    logger = CCLogger.getInstance();
  }

  public String getTemplatePath() {
    return tmplPath;
  }
  public void setTemplatePath(String tmplPath) {
    this.tmplPath = tmplPath;
  }

  public String show( HttpServletRequest req, HttpServletResponse resp, ServletContext context ) {
      return null;
  }

  public Object getContent(HttpServletRequest req, HttpServletResponse resp, ServletContext context) {
      return show(req, resp, context);
  }

  public HttpServletResponse getResponse() {
    return resp;
  }

  public HttpServletRequest getRequest() {
    return req;
  }

  public ITemplate getTemplate() {
    return tmpl;
  }

  public void setTemplate( Template tmpl ) {
    this.tmpl = tmpl;
  }

  public void loadTemplate() {
    tmpl = new Template( context );
    if (tmpl instanceof com.codecharge.Template) {
        ((com.codecharge.Template)tmpl).setPage(page);
    }
    logger.info("view => loadTemplate: Looking for "+tmplPath+" template..."); 
    InputStream tmpl_stream = null;
    tmplPath = getActualTemplateName(tmplPath);
    try {
      if ( ContextStorage.getInstance().getAttribute( "usedUnpackedWarFile" ) == null ) {
        tmpl_stream = context.getResourceAsStream(tmplPath);
      } else {
        tmpl_stream = new java.io.FileInputStream( context.getRealPath( tmplPath ));
      }
    } catch ( FileNotFoundException fnfe ) {
      logger.error("view => loadTemplate: Unable to load the template"); 
    }
    if (tmpl_stream == null) {
      logger.error("view => loadTemplate: Unable to load the template"); 
    }
    if (tmpl instanceof com.codecharge.Template) {
        ((com.codecharge.Template)tmpl).loadTemplate(tmpl_stream, "main", true);
    }
  }

  public void loadTemplate( String name ) {
    tmpl = new Template( context );
    logger.info("view => loadTemplate: Looking for "+name+" template..."); 
    InputStream tmpl_stream = null;
    name = getActualTemplateName(name);
    try {
       if ( ContextStorage.getInstance().getAttribute( "usedUnpackedWarFile" ) == null ) {
         tmpl_stream = context.getResourceAsStream( name );
       } else {
         tmpl_stream = new java.io.FileInputStream( context.getRealPath( name ));
       }
    } catch ( FileNotFoundException fnfe ) {
      logger.error("view => loadTemplate: Unable to load the template"); 
    }
    if (tmpl_stream == null) {
      logger.error("view => loadTemplate: Unable to load the template"); 
    }
    if (tmpl instanceof com.codecharge.Template) {
        ((com.codecharge.Template)tmpl).loadTemplate(tmpl_stream, "main", true);
    }
  }

  private String getTemplateFolder() {
      String templateFolder = StringUtils.replace(StringUtils.getSiteProperty("templateFolder"), "/", "\\");
      if (! StringUtils.isEmpty(templateFolder)) {
          while (templateFolder.length() > 1 && templateFolder.substring(templateFolder.length()-1, templateFolder.length()) == "\\") {
              templateFolder = templateFolder.substring(templateFolder.length()-1);
          }
          while (templateFolder.length() > 1 && templateFolder.substring(0, 1) == "\\") {
              templateFolder = templateFolder.substring(1);
          }
          return "\\" + templateFolder;
      }
      return "";
  }

  /*
   * This function works with com.codecharge.Template and never works with com.codecharge.Itemplate
   */
  protected String getActualTemplateName(String name) {
      if (StringUtils.isEmpty(name)) return name;
      String result = name;
      if (tmpl != null && ((com.codecharge.Template)tmpl).isUseLocalizatedTemplate()) {
        String encoding = page.getCharacterEncoding();
        if (encoding != null && encoding.length() != 0) {
            try {
                byte[] tmp = "test".getBytes(encoding); 
            } catch (java.io.UnsupportedEncodingException uee) {
                encoding = null;
            }
        } else {
            encoding = null;
        }
        Locale locale = page.getLocale();
        String language = (StringUtils.isEmpty(locale.getLanguage()) ? "" : "_"+locale.getLanguage()); 
        String country = (StringUtils.isEmpty(locale.getCountry()) ? "" : "_"+locale.getCountry()); 
        String variant = (StringUtils.isEmpty(locale.getVariant()) ? "" : "_"+locale.getVariant());
        encoding = (StringUtils.isEmpty(encoding) ? "" : "_"+encoding);

        String[] suffixes = new String[5];
        suffixes[0] = name;
        int pos = name.lastIndexOf(".");
        String ext = "";
        if (pos>-1) {
            ext = name.substring(pos); 
            name = name.substring(0, pos);
        }
        suffixes[1] = name + language + ext;
        suffixes[2] = name + language + country + ext;
        suffixes[3] = name + language + country + encoding + ext;
        suffixes[4] = name + language + country + variant + encoding + ext;
        int i = suffixes.length;
        InputStream tmpl_stream = null;
        Object useWarFile = ContextStorage.getInstance().getAttribute("usedUnpackedWarFile");
        for (i = suffixes.length - 1; i > -1; i--) {
            try {
                if (useWarFile == null) {
                  tmpl_stream = context.getResourceAsStream( suffixes[i] );
                } else {
                  tmpl_stream = new java.io.FileInputStream( context.getRealPath( suffixes[i] ));
                }
            } catch (FileNotFoundException fnfe) {
                continue;
            }
            if (tmpl_stream != null) {
                result = suffixes[i];
                tmpl_stream = null;
                break;
            }
        }
      }
      return result;
  }

  public String getFileContent( String name ) throws java.io.IOException {
    String fileName = "/" + name;
    StringBuffer lines = new StringBuffer();
    logger.info("view => getFileContent: Looking for '/"+name+"' file...");
    InputStream fileStream = null;
    try {
      if ( ContextStorage.getInstance().getAttribute( "usedUnpackedWarFile" ) == null ) {
        fileStream = context.getResourceAsStream(name);
      } else {
        fileStream = new java.io.FileInputStream( context.getRealPath( name ));
      }
    } catch ( FileNotFoundException fnfe ) {
      logger.error("view => loadTemplate: Unable to load the template"); 
    }
    if ( fileStream == null) {
      logger.error("view => getFileContent: Unable to load the file '/" + name + "'"); 
      throw new java.io.IOException( this.getClass().getName() + ".getFileContent(): File '/" + name + "' not found"); 
    }
    else {
      java.io.BufferedReader bf = new java.io.BufferedReader(
              new java.io.InputStreamReader( fileStream));
      while (bf.ready()) {
        String line = bf.readLine();
        if ( line != null ) { lines.append( line + "\n"); }
      }
      bf.close();
    }
    return lines.toString();
  }

  public String getHttpContent ( String url )
          throws java.net.MalformedURLException, java.io.IOException {

    String nextLine;
    StringBuffer webPage;

    java.net.URL siteURL = new java.net.URL ( url );
    java.net.URLConnection siteConn = siteURL.openConnection();
    java.io.BufferedReader in = new java.io.BufferedReader (
            new java.io.InputStreamReader( siteConn.getInputStream() ) );

    webPage = new StringBuffer();
    while ( ( nextLine = in.readLine() ) != null ) { webPage.append(nextLine); }
    in.close();

    return webPage.toString();
  }

    public void show(Model model) {
        if (model instanceof FileUpload) {
            show((FileUpload) model);       
        } else if (model instanceof Captcha) {
            show((Captcha) model);
        } else if (model instanceof Button) {
            show((Button) model);       
        } else if (model instanceof ImageLink) {
            show((ImageLink) model);        
        } else if (model instanceof Link) {
            show((Link) model);     
        } else if (model instanceof CheckBoxList) {
            show((CheckBoxList) model);     
        } else if (model instanceof ListBox) {
            show((ListBox) model);      
        } else if (model instanceof RadioButton) {
            show((RadioButton) model);      
        } else if (model instanceof DatePicker) {
            show((DatePicker) model);       
        } else if (model instanceof Control) {
            show((Control) model);      
        } else if (model instanceof Navigator) {
            show((Navigator) model);
        } else if (model instanceof CalendarNavigator) {
            show((CalendarNavigator) model);
        } else if (model instanceof Sorter) {
            show((Sorter) model);
        } else if (model instanceof Panel) {
            show((Panel) model);
        }
    }
    
    public void show(String subBlockName, Model model) {
        if (model instanceof FileUpload) {
            show(subBlockName, (FileUpload) model);     
        } else if (model instanceof Captcha) {
            show((Captcha) model);
        } else if (model instanceof Button) {
            show(subBlockName, (Button) model);     
        } else if (model instanceof ImageLink) {
            show(subBlockName, (ImageLink) model);      
        } else if (model instanceof Link) {
            show(subBlockName, (Link) model);       
        } else if (model instanceof CheckBoxList) {
            show(subBlockName, (CheckBoxList) model);       
        } else if (model instanceof ListBox) {
            show(subBlockName, (ListBox) model);        
        } else if (model instanceof RadioButton) {
            show(subBlockName, (RadioButton) model);        
        } else if (model instanceof DatePicker) {
            show(subBlockName, (DatePicker) model);     
        } else if (model instanceof Control) {
            show(subBlockName, (Control) model);        
        } else if (model instanceof Navigator) {
            show((Navigator) model);
        } else if (model instanceof CalendarNavigator) {
            show((CalendarNavigator) model);
        } else if (model instanceof Sorter) {
            show((Sorter) model);
        } else if (model instanceof Panel) {
            show(subBlockName, (Panel) model);
        }
    }

  public void show(Control model) {
    if (model instanceof FileUpload) {
        show(null, (FileUpload) model);
    } else {
        show(null, model);
    }
  }

  public void show(ListBox model) {
    show(null, model);
  }

  public void show(Link model) {
    show(null, model);
  }

  public void show(ImageLink model) {
    show(null, model);
  }

  public void show(RadioButton model) {
    show(null, model);
  }

  public void show(CheckBoxList model) {
    show(null, model);
  }

  public void show(FileUpload model) {
    show(null, model);
  }
  
  public void show(String subBlockName, FileUpload model) {
    if ( subBlockName == null ) subBlockName = "";
    String blockToParse = "FileUpload "+model.getName();
    if ( model.isVisible() ) {

        model.fireBeforeShowEvent(new Event());
    }
    String pathTo = page.getCurrentPath()+subBlockName;
    tmpl.setTag(pathTo, blockToParse);
    if ( model.isVisible() ) {
        StringBuffer fileName = new StringBuffer(model.getHtmlName());
        fileName.insert(model.getName().length(),"_File");
        tmpl.setTag(pathTo, blockToParse + "/@ControlName", model.getHtmlName());
        tmpl.setTag(pathTo, blockToParse + "/@State", model.getState());
        if (model.isUploaded()) {
            tmpl.setTag(pathTo, blockToParse + "/Info/@FileName", model.getFileName());
            tmpl.setTag(pathTo, blockToParse + "/Info/@FileSize", String.valueOf(model.getSize()));
            tmpl.render(pathTo, blockToParse + "/Info", false);

            if (model.isRequired()) {
                tmpl.setTag(pathTo, blockToParse + "/DeleteControl");
                tmpl.setTag(pathTo, blockToParse + "/Upload/@FileControl", fileName.toString());
                tmpl.render(pathTo, blockToParse + "/Upload", false);
            } else {
                tmpl.setTag(pathTo, blockToParse + "/Upload");
                StringBuffer delName = new StringBuffer(model.getHtmlName());
                delName.insert(model.getName().length(),"_Delete");
                tmpl.setTag(pathTo, blockToParse + "/DeleteControl/@DeleteControl", delName.toString());
                if (model.getDelete()) {
                    tmpl.setTag(pathTo, blockToParse + "/DeleteControl/@DeleteChecked", "CHECKED");
                } else {
                    tmpl.setTag(pathTo, blockToParse + "/DeleteControl/@DeleteChecked", "");
                }
                tmpl.render(pathTo, blockToParse + "/DeleteControl", false);
            }
        } else {
            tmpl.setTag(pathTo, blockToParse + "/Info");
            tmpl.setTag(pathTo, blockToParse + "/DeleteControl");
            tmpl.setTag(pathTo, blockToParse + "/Upload/@FileControl", fileName.toString());
            tmpl.render(pathTo, blockToParse + "/Upload", false);
        }
        tmpl.render(pathTo, blockToParse, false);
    }
  }


  public void show(String subBlockName, Control model) {
    if ( subBlockName == null ) subBlockName = "";
    if ( model.isVisible() ) {
//setAttributes(model);
        model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
    }
    if ( model.isVisible() ) {
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name", model.getHtmlName());
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName(), model.getFormattedValue());
    } else {
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name");
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName());
        String controlType = model.getClass().getName();
        controlType = controlType.substring( controlType.lastIndexOf(".")+1 );
        tmpl.setTag(page.getCurrentPath()+subBlockName, controlType + " " + model.getName());
    }
  }

    protected void setLinkParameters(Link model) {
        StringBuffer href = new StringBuffer();
        Page page = model.getPage();
        for (Iterator i = model.getParameters().iterator(); i.hasNext(); ) {
            LinkParameter param = (LinkParameter)i.next();
            ParameterSource type = param.getSourceType();
            if (type == ParameterSource.URL) {
                param.setValue( page.getHttpGetParameters().getParameterValues(param.getSourceName()));
            } else if (type == ParameterSource.FORM) {
                param.setValue( page.getHttpPostParameters().getParameterValues(param.getSourceName()));
            } else if (type == ParameterSource.SESSION) {
                param.setValue( SessionStorage.getInstance(page.getRequest()).getAttribute(param.getSourceName()));
            } else if (type == ParameterSource.APPLICATION) {
                param.setValue( ContextStorage.getInstance().getAttribute(param.getSourceName()));
            } else if (type == ParameterSource.COOKIE) {
                param.setValue( page.getCookie( param.getSourceName()));
            }
        }
    }

    public void show(String subBlockName, Link model) {
        if ( subBlockName == null ) subBlockName = "";
        if ( model.isVisible() ) {
            setLinkParameters(model);
//setAttributes(model);
            model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        }
        if ( model.isVisible() ) {
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name", model.getHtmlName());
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName(), model.getFormattedValue() );
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName() + "_Src", SessionStorage.getInstance( page.getRequest() ).encodeURL( model.getHref() ) );
        } else {
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name");
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName());
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName() + "_Src", SessionStorage.getInstance( page.getRequest() ).encodeURL( model.getHref() ) );
            tmpl.setTag(page.getCurrentPath()+subBlockName, "Link " + model.getName());
        }
    }

  public void show(String subBlockName, ImageLink model) {
    if ( subBlockName == null ) subBlockName = "";
    if ( model.isVisible() ) {
        setLinkParameters(model);
//setAttributes(model);
        model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
    }
    if ( model.isVisible() ) {
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name", model.getHtmlName());
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName() + "_Src", model.getFormattedValue() );
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName(), SessionStorage.getInstance( page.getRequest() ).encodeURL( model.getHref() ) );
    } else {
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name");
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName() + "_Src", model.getFormattedValue() );
        tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName(), SessionStorage.getInstance( page.getRequest() ).encodeURL( model.getHref() ) );
        tmpl.setTag(page.getCurrentPath()+subBlockName, "ImageLink " + model.getName());
    }
  }

    public void show(String subBlockName, ListBox model) {
        if ( subBlockName == null ) subBlockName = "";
        if ( model.isVisible() ) {
//setAttributes(model);
            model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        }
        if ( model.isVisible() ) {
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name", model.getHtmlName());
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Options", model.getOptionsString() );
        } else {
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Name");
            tmpl.setTag(page.getCurrentPath()+subBlockName, "@"+model.getName()+"_Options", model.getOptionsString() );
            tmpl.setTag(page.getCurrentPath()+subBlockName, "ListBox " + model.getName());
        }
    }

    public void show(String subBlockName, RadioButton model) {
        boolean isXHTMLUsed;
        if ( subBlockName == null ) subBlockName = "";
        String pathTo = page.getCurrentPath() + subBlockName;
        String blockToParse = "RadioButton "+model.getName();
        tmpl.setTag(pathTo, "RadioButton "+model.getName());
        if ( model.isVisible() ) {
//setAttributes(model);
            model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        }
        if ( model.isVisible() ) {
            Enumeration enumeration = model.getFormattedOptions();

            int number = 1;
            ModelAttribute ma = (ModelAttribute)model.getAttribute("optionNumber");

            isXHTMLUsed = new Boolean(StringUtils.getSiteProperty("isXHTMLUsed")).booleanValue();
            while ( enumeration.hasMoreElements() ) {
                String[] option = (String[]) enumeration.nextElement();

                if (ma != null) ma.setValue(""+(number++));
                setAttributesToTemplate(model);

                if (option[com.codecharge.components.List.SELECTED] != null) {
                    if (isXHTMLUsed) {
                        tmpl.setTag( pathTo, blockToParse + "/@Check", "checked=\"checked\"" );
                    } else {
                        tmpl.setTag( pathTo, blockToParse + "/@Check", "CHECKED" );
                    }
                } else {
                    tmpl.setTag( pathTo, blockToParse + "/@Check" );
                }
                tmpl.setTag( pathTo, blockToParse +"/@Value", 
                        option[com.codecharge.components.List.BOUND_COLUMN] );
                tmpl.setTag( pathTo, blockToParse +"/@Description", 
                        option[com.codecharge.components.List.TEXT_COLUMN] );
                tmpl.setTag( pathTo, blockToParse +"/@"+model.getName()+"_Name", 
                        model.getHtmlName());
                tmpl.render( pathTo, blockToParse, true );
            }
        }
    }

    public void show(String subBlockName, CheckBoxList model) {
        boolean isXHTMLUsed;
        if ( subBlockName == null ) subBlockName = "";
        String pathTo = page.getCurrentPath() + subBlockName;
        String blockToParse = "CheckBoxList "+model.getName();
        tmpl.setTag(pathTo, "CheckBoxList "+model.getName());
        if ( model.isVisible() ) {
//setAttributes(model);
            model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        }
        if ( model.isVisible() ) {
            Enumeration enumeration = model.getFormattedOptions();

            int number = 1;
            ModelAttribute ma = (ModelAttribute)model.getAttribute("optionNumber");

            isXHTMLUsed = new Boolean(StringUtils.getSiteProperty("isXHTMLUsed")).booleanValue();
            while ( enumeration.hasMoreElements() ) {
                String[] option = (String[]) enumeration.nextElement();

                if (ma != null) ma.setValue(""+(number++));
                setAttributesToTemplate(model);

                if (option[com.codecharge.components.List.SELECTED] != null) {
                    if (isXHTMLUsed) {
                        tmpl.setTag( pathTo, blockToParse + "/@Check", "checked=\"checked\"" );
                    } else {
                        tmpl.setTag( pathTo, blockToParse + "/@Check", "CHECKED" );
                    }
                } else {
                    tmpl.setTag( pathTo, blockToParse + "/@Check" );
                }
                tmpl.setTag( pathTo, blockToParse +"/@Value", 
                        option[com.codecharge.components.List.BOUND_COLUMN] );
                tmpl.setTag( pathTo, blockToParse +"/@Description", 
                        option[com.codecharge.components.List.TEXT_COLUMN] );
                tmpl.setTag( pathTo, blockToParse +"/@"+model.getName()+"_Name", 
                        model.getHtmlName());
                tmpl.render( pathTo, blockToParse, true );
            }
        }
    }

    public void show(Button model) {
        show(null,model);
    }

    public void show(String subBlockName, Button model) {
        if ( subBlockName == null ) subBlockName = "";
        String pathTo = page.getCurrentPath() + subBlockName;
        String blockToParse = "Button "+model.getName();
        Component parent = model.getParent();
        if (parent instanceof Record) {
            Record r = (Record) parent;
            if (r.isEditMode()) {
                if ("Insert".equals(model.getOperation())) {
                    model.setVisible(false);
                }
            } else {
                if ("Update".equals(model.getOperation()) || "Delete".equals(model.getOperation())) {
                    model.setVisible(false);
                }
            }
        }
        if ( model.isVisible() ) {
//setAttributes(model);
            model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        }
        if ( model.isVisible() ) {
            tmpl.setTag( pathTo, blockToParse + "/@Button_Name", model.getHtmlName() );
            tmpl.render( pathTo, blockToParse, false, Template.IF_DOESNT_EXIST_DO_NOTHING );
        } else {
            tmpl.setTag( pathTo, blockToParse );
        }
    }

    public void show(DatePicker model) {
        show(null,model);
    }

    public void show(String subBlockName, DatePicker model) {
        if ( subBlockName == null ) subBlockName = "";
        String pathTo = page.getCurrentPath() + subBlockName;
        String blockToParse = "DatePicker "+model.getName();
        if ( model.isVisible() ) {
            tmpl.setTag( pathTo, blockToParse + "/@DateControl", model.getParent().getControl(model.getControlName()).getHtmlName() );
            tmpl.setTag( pathTo, blockToParse + "/@FormName", model.getParent().getName() );
            tmpl.setTag( pathTo, blockToParse + "/@Name", model.getParent().getName() + "_" + model.getName() );
            tmpl.render( pathTo, blockToParse, false, Template.IF_DOESNT_EXIST_DO_NOTHING );
        } else {
            tmpl.setTag( pathTo, blockToParse );
        }
    }

    /**
        Show Navigator.
        @param model Model of the Navigator we want to show.
        @param type Type of the Navigator SIMPLE, CENTERED, MOVING.
           SIMPLE shows [c] of [t]
           CENTERED shows [c-1] [c] [c+1] of [t]
           MOVING shows [c-2] [c-1] [c] of [t]
    */
    public void show(Navigator model, int type) {
        String blockToParse = page.getCurrentPath() + "/Navigator " + model.getName();
        Navigable navComponent = (Navigable) model.getParent();
        if (! navComponent.isNavigatorVisible()) {
            model.setVisible(false);
        }
        if (model.isVisible()) {
//setAttributes(model);
            model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        }
        tmpl.setVar(blockToParse);
        if (model.isVisible()) {
            
            String query = model.getQuery(page.getHttpGetParams());
            HttpServletResponse resp = page.getResponse();
            String navName = navComponent.getName();
            query = StringUtils.isEmpty(query) ? "" : "&" + query;
            int pageSize = navComponent.getPageSize();
            int curPage = navComponent.getPageNumber();
            if ( curPage < 1 ) curPage = 1;
            int lastPage = 1;
            if (pageSize > 0) {
                lastPage = navComponent.getTotalPages();
            }
            if ( curPage > lastPage ) curPage = lastPage;

            //-----------------------Navigator_page_form-----------------------
			tmpl.setVar(blockToParse+"/@FormName", navComponent.getName(), Template.IF_DOESNT_EXIST_DO_NOTHING);
			boolean isXHTMLUsed;
 	        isXHTMLUsed = new Boolean(StringUtils.getSiteProperty("isXHTMLUsed")).booleanValue();

			String s = "";
			if (model.getPageSizes() != null) {
				Iterator it1 = model.getPageSizes().iterator();
				while(it1.hasNext()) {
					String a = "" + it1.next();
					s = s + "<option value=\""+a+"\">"+a+"</option>";
				}
			}
			if (isXHTMLUsed) s = s.toUpperCase();
			tmpl.setVar(blockToParse+"/@PageSize_Options", s, Template.IF_DOESNT_EXIST_DO_NOTHING);
			
	  		Vector excepts = new Vector ();
	  		excepts.add(navComponent.getName()+"PageSize");

	  		HashMap map = model.getPage().getHttpGetParameters().getPreserveParameters(excepts);

	  		if (!map.isEmpty()) {
				Iterator it = map.keySet().iterator();

			  	while(it.hasNext()) {
					String name = "" + it.next();
					tmpl.setTag( blockToParse+"/Page_Parameter", blockToParse+"/Page_Parameter/@Name", name);
					String value = ""+map.get(name);
					tmpl.setTag( blockToParse+"/Page_Parameter", blockToParse+"/Page_Parameter/@Value", value.substring(value.indexOf("=")+1) );
					tmpl.render( blockToParse+"/Page_Parameter", blockToParse+"/Page_Parameter", true, Template.IF_DOESNT_EXIST_DO_NOTHING );
			  	}

	  		}else{
		            tmpl.setVar( blockToParse+"/Page_Parameter");
			}

            //-----------------------/Navigator_page_form-----------------------


            if (curPage == 1) {
                tmpl.parse(blockToParse+"/First_Off", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.parse(blockToParse+"/Prev_Off", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.setVar(blockToParse+"/First_On");
                tmpl.setVar(blockToParse+"/Prev_On");
            } else {
                tmpl.setVar(blockToParse+"/First_Off");
                tmpl.setVar(blockToParse+"/Prev_Off");
                tmpl.setVar(blockToParse+"/First_On/@First_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?" + navName + "Page=1" + query), Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.parse(blockToParse+"/First_On", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.setVar(blockToParse+"/Prev_On/@Prev_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?" + navName + "Page=" + (curPage-1) + query), Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.parse(blockToParse+"/Prev_On", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
            }

            int start, end;
            switch (type) {
                case Navigator.SIMPLE:
                    start = 1; 
                    end = 0;
                    break;
                case Navigator.CENTERED:
                    start = curPage - model.getNumberOfPages()/2; 
                    end = start + model.getNumberOfPages() - 1;
                    if (start < 1) {
                        start = 1; 
                        end = model.getNumberOfPages() > lastPage ? lastPage : model.getNumberOfPages();
                    }
                    if (end > lastPage) {
                        end = lastPage; 
                        start = lastPage - model.getNumberOfPages() + 1 < 1 ? 1 : lastPage - model.getNumberOfPages() +1;
                    }
                    break;
                case Navigator.MOVING:
                    start = ((curPage-1)/pageSize)*pageSize + 1; 
                    end = start + pageSize -1;
                    if (end > lastPage) end = lastPage;
                    break;
                default:
                    start = 1; 
                    end = 0;
            }
            tmpl.setVar(blockToParse+"/Pages");
            for (int i = start; i <= end ; i++) {
                if (i == curPage) {
                    tmpl.setVar(blockToParse+"/Pages/Page_Off/@Page_Number", String.valueOf(i), Template.IF_DOESNT_EXIST_DO_NOTHING);
                    tmpl.parse(blockToParse+"/Pages/Page_Off", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                    tmpl.setVar(blockToParse+"/Pages/Page_On", "", Template.IF_DOESNT_EXIST_DO_NOTHING);
                } else {
                    tmpl.setVar(blockToParse+"/Pages/Page_On/@Page_Number", String.valueOf(i), Template.IF_DOESNT_EXIST_DO_NOTHING);
                    tmpl.setVar(blockToParse+"/Pages/Page_On/@Page_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?" + navName + "Page=" + i + query), Template.IF_DOESNT_EXIST_DO_NOTHING);
                    tmpl.parse(blockToParse+"/Pages/Page_On", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                    tmpl.setVar(blockToParse+"/Pages/Page_Off", "", Template.IF_DOESNT_EXIST_DO_NOTHING);
                }
                tmpl.parse(blockToParse+"/Pages", true, Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
    
            tmpl.setVar(blockToParse+"/@Page_Number", String.valueOf(curPage), Template.IF_DOESNT_EXIST_DO_NOTHING);
            tmpl.setVar(blockToParse+"/@Total_Pages", String.valueOf(lastPage), Template.IF_DOESNT_EXIST_DO_NOTHING);
    
            if (curPage == lastPage) {
                tmpl.setVar(blockToParse+"/Last_On");
                tmpl.setVar(blockToParse+"/Next_On");
                tmpl.parse(blockToParse+"/Last_Off", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.parse(blockToParse+"/Next_Off", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
            } else {
                tmpl.setVar(blockToParse+"/Last_Off");
                tmpl.setVar(blockToParse+"/Next_Off");
                tmpl.setVar(blockToParse+"/Last_On/@Last_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?" + navName + "Page=" + lastPage + query), Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.parse(blockToParse+"/Last_On", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.setVar(blockToParse+"/Next_On/@Next_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?" + navName + "Page=" + (curPage+1) + query), Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.parse(blockToParse+"/Next_On", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
            tmpl.parse(blockToParse, true);
        }
    }

    public void show(Navigator model) {
        show(model, model.getNavigatorType());
    }
        
    public void show(Sorter model) {
        String blockToParse = page.getCurrentPath() + "/Sorter " + model.getName();
        if (model.isVisible()) {
//setAttributes(model);
            model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        }
        if (model.isVisible()) {
            String query = model.getQuery(page.getHttpGetParams());
            HttpServletResponse resp = page.getResponse();
            query = StringUtils.isEmpty(query) ? "" : "&" + query;
            Sortable sortComponent = (Sortable) model.getParent();
            String sortName = sortComponent.getName();
            String order;
            String ascOn = blockToParse+"/Asc_On";
            String dscOn = blockToParse+"/Desc_On";
            String ascOff = blockToParse+"/Asc_Off";
            String dscOff = blockToParse+"/Desc_Off";
            String sort = sortComponent.getSort();
            String dir = sortComponent.getDir();
            if (sort != null && sort.equals(model.getName())) {
                if (dir == null || dir.equalsIgnoreCase("asc")) {
                    tmpl.parse(ascOn, false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                    tmpl.setVar(ascOff);
                    tmpl.setVar(dscOn);
                    tmpl.setVar(dscOff+"/@Desc_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?"+sortName+"Order="+model.getName()+"&"+sortName+"Dir=DESC"+query), 1);
                    tmpl.parse(dscOff, false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                } else if (dir.equalsIgnoreCase("desc")) {
                    tmpl.setVar(ascOn);
                    tmpl.setVar(dscOff);
                    tmpl.parse(dscOn, false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                    tmpl.setVar(ascOff+"/@Asc_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?"+sortName+"Order="+model.getName()+"&"+sortName+"Dir=ASC"+query), 1);
                    tmpl.parse(ascOff, false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                }
            } else {
                tmpl.setVar(ascOn);
                tmpl.setVar(dscOn);
                tmpl.setVar(ascOff+"/@Asc_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?"+sortName+"Order="+model.getName()+"&"+sortName+"Dir=ASC"+query), 1);
                tmpl.parse(ascOff, false, Template.IF_DOESNT_EXIST_DO_NOTHING);
                tmpl.setVar(dscOff+"/@Desc_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?"+sortName+"Order="+model.getName()+"&"+sortName+"Dir=DESC"+query), 1);
                tmpl.parse(dscOff, false, Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
            if (sort == null) {
                order = "ASC";
            } else if (sort.equals(model.getName()) && dir.equalsIgnoreCase("ASC")) {
                order = "DESC";
            } else {
                order = "ASC";
            }
            tmpl.setVar(blockToParse+"/@Sort_URL", SessionStorage.getInstance( page.getRequest() ).encodeURL(page.getActionPageName()+".do?"+sortName+"Order="+model.getName()+"&"+sortName+"Dir="+order+query), Template.IF_DOESNT_EXIST_DO_NOTHING);
            tmpl.parse(blockToParse, false);
        } else {
            tmpl.setVar(blockToParse);
        }
    }

    public void show(Record model) {
    view.show(null, model);
  }
  
    public void show(String subBlockName, Record model) {
      int addedBlocks = 1;
      if (! StringUtils.isEmpty(subBlockName)) {
          addedBlocks = setCurrentBlock(subBlockName) + 1;
      }
          page.setCurrentBlock("Record "+model.getName());
          parsedControls = new HashMap();
          if ( ! model.isVisible() ) {
              tmpl.setVar( page.getCurrentPath() );
              gotoParentBlock(addedBlocks);
              return;
          }
          for ( Iterator it = model.getChildren().iterator(); it.hasNext(); ) {
              com.codecharge.components.Model m = (com.codecharge.components.Model) it.next();
              if ( !(m instanceof com.codecharge.components.VerifiableControl) 
                      && m instanceof com.codecharge.components.Control 
                      && ((com.codecharge.components.Control) m).hasErrors() ) {
                  model.addErrors(Utils.list(((com.codecharge.components.Control) m).getErrors()));
              } else if ( m instanceof com.codecharge.components.VerifiableControl 
                      && ((com.codecharge.components.VerifiableControl) m).hasErrors() 
                      && ((com.codecharge.components.VerifiableControl) m).getErrorControlName() == null) {
                  model.addErrors(Utils.list(((com.codecharge.components.Control) m).getErrors()));
              }
          }
          if ( model.isProcessed() || model.hasErrors() ) {
              tmpl.setVar( page.getCurrentPath() + "/Error/@Error", model.getErrorsAsString(), Template.IF_DOESNT_EXIST_DO_NOTHING );
              tmpl.render( page.getCurrentPath() + "/Error", false, Template.IF_DOESNT_EXIST_DO_NOTHING );
          } else {
              tmpl.setVar( page.getCurrentPath() + "/Error" );
          }
          if (model.hasNextRow()) model.nextRow();
//setAttributes(model);
          model.fireBeforeShowEvent( new Event() );
setAttributesToTemplate(model);
          if ( ! model.isVisible() ) {
              tmpl.setVar( page.getCurrentPath() );
              gotoParentBlock(addedBlocks);
              return;
          }

          HashMap errorCollections = new HashMap();
          for (Iterator controls = model.getChildren().iterator(); controls.hasNext(); ) {
              com.codecharge.components.Model m = (com.codecharge.components.Model) controls.next();
              if (m instanceof com.codecharge.components.VerifiableControl) {
                  com.codecharge.components.VerifiableControl v = (com.codecharge.components.VerifiableControl) m;
                  if (v.hasErrors() && ! StringUtils.isEmpty(v.getErrorControlName())) {
                      ErrorCollection ec = (ErrorCollection) errorCollections.get(v.getErrorControlName());
                      if (ec == null) {
                          ec = new ErrorCollection();
                          errorCollections.put(v.getErrorControlName(), ec);
                      }
                      ec.addErrors(Utils.list(v.getErrors()));
                  }
              }
          }

          //process errorCollections
          for (Iterator it = errorCollections.keySet().iterator(); it.hasNext(); ) {
              String key = (String) it.next();
              ErrorCollection ec = (ErrorCollection) errorCollections.get(key);
              String errVal = model.getControl(key).getFormattedValue();
              model.getControl(key).setFormattedValue(errVal + ec.getErrorsAsString());
          }
            
          for (Iterator controls = model.getChildren().iterator(); controls.hasNext(); ) {
        Model m = (com.codecharge.components.Model) controls.next();
        if (parsedControls.get(m.getName()) == null) {
                view.show(m);
        }
          }

            
          CCSURL url = new CCSURL();
          url.setUrl(page.getActionPageName() + ".do");


          //StringBuffer formAction = new StringBuffer( page.getActionPageName() + ".do?ccsForm=" + model.getName() ); 
            
          String formName = model.getName();
          if (model.isEditMode()) {
              //formAction.append(":Edit");
              formName = formName + ":Edit";
          }

          url.addParameter("ccsForm", formName);

          HashMap parameters = new HashMap();
          if ((model.getPreserveType()==PreserveParameterType.POST || model.getPreserveType()==PreserveParameterType.ALL) && page.getHttpGetParameter("ccsForm")==null) {
              parameters.putAll(page.getHttpPostParams().getPreserveParameters( model.getExcludeParams() ));
          }
          Vector getExclude = new Vector();
          getExclude.add("ccsForm");
          parameters.putAll(page.getHttpGetParams().getPreserveParameters(getExclude));
          Iterator params = parameters.values().iterator();
          while(params.hasNext()) {
              Object ooo = params.next();
              //formAction.append("&"+((String)params.next()));
              //formAction.append("&"+((String)ooo));
              url.addParameters((String)ooo);
          }


//System.out.println("!!!_1" + formAction.toString());
//System.out.println("!!!_2" + url.toString());

          //tmpl.setVar( page.getCurrentPath() + "/@Action", SessionStorage.getInstance( page.getRequest() ).encodeURL(formAction.toString()) );
          tmpl.setVar( page.getCurrentPath() + "/@Action", SessionStorage.getInstance( page.getRequest() ).encodeURL(url.toString()) );
          tmpl.setVar( page.getCurrentPath() + "/@HTMLFormName", model.getName() );
          tmpl.setVar( page.getCurrentPath() + "/@HTMLFormEnctype", model.getFormEnctype() );
          if ( model.isVisible() ) {
              tmpl.render( page.getCurrentPath(), false );
          } else {
              tmpl.setVar( page.getCurrentPath() );
          }
        gotoParentBlock(addedBlocks);
    }


    public void show(com.codecharge.components.Menu model) {
    	show(null, model);
    }
    
    public void show(String subBlockName, com.codecharge.components.Menu model) {

        int addedBlocks = 1;
        if (! StringUtils.isEmpty(subBlockName)) {
            addedBlocks = setCurrentBlock(subBlockName) + 1;
        }

	String blockToParse = page.getCurrentPath() + "/Menu " + model.getName();

        page.setCurrentBlock("Menu " + model.getName());


        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }

    	if (page.isIncluded()) {
    		tmpl.setTag( "main", "main/@page:pathToRoot", (String)page.getAttribute(Page.PAGE_ATTRIBUTE_PATH_TO_ROOT));
    	}

	tmpl.setTag( blockToParse, blockToParse+"/@"+model.getName()+":MenuType", "" + model.getMenuFormattedType() );

	com.codecharge.components.Link itemLink = null;
	for ( Iterator it = model.getChildren().iterator(); it.hasNext(); ) {
	       	com.codecharge.components.Model m = (com.codecharge.components.Model) it.next();
        	if (m instanceof com.codecharge.components.Link) {
        		itemLink = (com.codecharge.components.Link)m;
        		break;
        	}
        }

	while(model.hasNexItem()) {
		model.nextItem();

		if (!model.isOpenLevel()) {
			tmpl.setVar( blockToParse+"/Item/OpenLevel");
		} else {
			tmpl.setTag( blockToParse+"/Item/OpenLevel", blockToParse+"/Item/OpenLevel/@"+model.getName()+":Item_Level", "" + model.getLevel() );
		}

		itemLink.setHrefSourceValue(model.getActiveItemUrl());
		tmpl.setTag( blockToParse+"/Item", blockToParse+"/Item/@ItemLink_Src", SessionStorage.getInstance( page.getRequest() ).encodeURL( itemLink.getHref() ));
		tmpl.setTag( blockToParse+"/Item", blockToParse+"/Item/@ItemLink", StringUtils.toHtml(model.getActiveItemCaption()) );
		tmpl.setTag( blockToParse+"/Item", blockToParse+"/Item/@"+model.getName()+":Target", model.getTarget() );
		tmpl.setTag( blockToParse+"/Item", blockToParse+"/Item/@"+model.getName()+":Title", model.getTitle() );

		if (!model.isCloseItem()) {
			tmpl.setVar( blockToParse+"/Item/CloseItem");
			tmpl.setTag( blockToParse+"/Item", blockToParse+"/Item/@"+model.getName()+":Submenu", "submenu" );
		} else {
			tmpl.setTag( blockToParse+"/Item", blockToParse+"/Item/@"+model.getName()+":Submenu", "" );
		}

		boolean accumulate = false;					
		if (model.getCloseLevel() == 0 ) {
			tmpl.setVar( blockToParse+"/Item/CloseLevel");
		} else {
			for (int i = 0 ; i < model.getCloseLevel(); i++) {
				tmpl.parse(blockToParse+"/Item/CloseLevel", accumulate, Template.IF_DOESNT_EXIST_DO_NOTHING);
				accumulate = true;
			}
		}
		tmpl.render( blockToParse+"/Item", blockToParse+"/Item", true, Template.IF_DOESNT_EXIST_DO_NOTHING );
  	}

        gotoParentBlock(addedBlocks);
  	}



    public void show(com.codecharge.components.FlashChart model) {
    	show(null, model);
    }

    public void show(String subBlockName,com.codecharge.components.FlashChart model) {

		//System.out.println("FFFFFFFFFFFFFFF1["+page.getCurrentPath()+"]");

        int addedBlocks = 1;
        if (! StringUtils.isEmpty(subBlockName)) {
            addedBlocks = setCurrentBlock(subBlockName) + 1;
        }

        page.setCurrentBlock("FlashChart " + model.getName());

        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }
        model.fireBeforeShowEvent( new Event() );
        setAttributesToTemplate(model);
		//System.out.println("FFFFFFFFFFFFFFF2["+page.getCurrentPath()+"]");

		//page.getCurrentPath();
		//tmpl.setTag("main/Row", "@age_id", ""+record.get("AGE_ID") );
		//tmpl.render("main/Row", "main/Row", true, Template.IF_DOESNT_EXIST_IS_ERROR);

		tmpl.setTag(page.getCurrentPath(), "@Title", model.getTitle() );
		tmpl.setTag(page.getCurrentPath(), "@Width", ""+model.getWidth() );
		tmpl.setTag(page.getCurrentPath(), "@Height", ""+model.getHeight() );
		tmpl.setTag(page.getCurrentPath(), "@Src", model.getSrc() );


		tmpl.render(page.getCurrentPath(), page.getCurrentPath(), true, Template.IF_DOESNT_EXIST_IS_ERROR);

        gotoParentBlock(addedBlocks);
  	}


    public void show(com.codecharge.components.Captcha model) {
        int addedBlocks = 1;
        resp.addHeader( "X-UA-Compatible", "IE=7" );

        page.setCurrentBlock("Captcha " + model.getName());

        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }
        model.fireBeforeShowEvent( new Event() );
        setAttributesToTemplate(model);

        tmpl.setTag(page.getCurrentPath(), "@"+model.getName()+"_Name", model.getHtmlName());
        tmpl.setTag(page.getCurrentPath(), "@"+model.getName(), "");
        tmpl.setTag(page.getCurrentPath(), "@Width", ""+model.getImageWidth() );
		tmpl.setTag(page.getCurrentPath(), "@Height", ""+model.getImageHeight() );

		tmpl.render(page.getCurrentPath(), page.getCurrentPath(), true, Template.IF_DOESNT_EXIST_IS_ERROR);

        gotoParentBlock(addedBlocks);
    }  

    
    public void show(Grid model, Collection staticControls, Collection rowControls, 
            Collection altRowControls, boolean hasAltRow, boolean hasSeparator) {
    show(null, model, staticControls, rowControls, altRowControls, hasAltRow, hasSeparator);
  }
  
    public void show(String subBlockName, Grid model, Collection staticControls, Collection rowControls, 
            Collection altRowControls, boolean hasAltRow, boolean hasSeparator) {
        int addedBlocks = 1;
        if (! StringUtils.isEmpty(subBlockName)) {
            addedBlocks = setCurrentBlock(subBlockName) + 1;
        }
        page.setCurrentBlock("Grid " + model.getName());
        parsedControls = new HashMap();
        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }

//setAttributes(model);
        model.fireBeforeShowEvent( new Event() );
setAttributesToTemplate(model);


        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }
        if ( model.hasErrors() ) {
            tmpl.setVar( page.getCurrentPath(), "Form: "+model.getName() + StringUtils.getBRTag() + 
                    "Errors:" + StringUtils.getBRTag() + model.getErrorsAsString() );
            gotoParentBlock(addedBlocks);
            return;
        }

        if ( model.isEmpty() ) {
            tmpl.render(page.getCurrentPath()+"/NoRecords", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
            tmpl.setVar(page.getCurrentPath()+"/Row");
            tmpl.setVar(page.getCurrentPath()+"/AltRow");
        } else {
            tmpl.setVar(page.getCurrentPath()+"/NoRecords");
        }

        boolean alt = false;
        model.initializeRows();
        while ( model.hasNextRow() || model.isForceIteration()) {

            if (model.hasNextRow()) { 
                HashMap row = model.nextRow();
            } else {
                model.setCurrentRowNumber ( model.getCurrentRowNumber() + 1);
            }
            model.setForceIteration(false);

            parsedControls = new HashMap();

//setRowAttributes(model);

            ModelAttribute ma = ((com.codecharge.util.ModelAttribute)model.getAttribute( "rowNumber" ));
            if (ma != null) ma.setValue( ""+(model.getCurrentRowNumber()) );

            model.fireBeforeShowRowEvent( new Event() );
setAttributesToTemplate(model);

            if ( (hasAltRow && ! alt) || !hasAltRow ) {
                showControls(model, rowControls, "/Row");
                tmpl.render(page.getCurrentPath()+"/Row", true, page.getCurrentPath()+"/Row", Template.IF_DOESNT_EXIST_DO_NOTHING);
            } else if (hasAltRow && alt) {  
                showControls(model, altRowControls, "/AltRow");
                tmpl.render(page.getCurrentPath()+"/AltRow", true, page.getCurrentPath()+"/Row", Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
            alt = !alt;
            if ( hasSeparator && model.hasNextRow() ) {
                tmpl.render(page.getCurrentPath()+"/Separator", true, page.getCurrentPath()+"/Row", Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
        }
        model.nullChildRow();
        parsedControls = new HashMap();
        showControls(model, staticControls);

        if ( model.isVisible() ) {
            tmpl.setVar(page.getCurrentPath()+"/AltRow");
            tmpl.setVar(page.getCurrentPath()+"/Separator");
            tmpl.render(page.getCurrentPath(), false);
        } else {
            tmpl.setVar(page.getCurrentPath() );
        }
        gotoParentBlock(addedBlocks);
    }

    public void show(Path model, Collection staticControls, Collection pathControls, Collection currentControls) {
    view.show(null, model, staticControls, pathControls, currentControls);
  }
  
    public void show(String subBlockName, Path model, Collection staticControls, Collection pathControls, Collection currentControls) {
    int addedBlocks = 1;
    if (! StringUtils.isEmpty(subBlockName)) {
      addedBlocks = setCurrentBlock(subBlockName) + 1;
    }
    parsedControls = new HashMap();
        if (staticControls==null) staticControls = new ArrayList();
        if (pathControls==null) pathControls = new ArrayList();
        if (currentControls==null) currentControls = new ArrayList();

        page.setCurrentBlock("Path " + model.getName());
        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }
//setAttributes(model);
        model.fireBeforeShowEvent( new Event() );
setAttributesToTemplate(model);

        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }
        if ( model.hasErrors() ) {
            tmpl.setVar( page.getCurrentPath(), "Form: Path_directory_categories" + StringUtils.getBRTag() + 
                    "Errors:" + StringUtils.getBRTag() + model.getErrorsAsString() );
            gotoParentBlock(addedBlocks);
            return;
        }
        showControls(model, staticControls);

        tmpl.setVar(page.getCurrentPath()+"/PathComponent");

        model.initializeRows();
        tmpl.setVar(page.getCurrentPath()+"/CurrentCategory");
        while ( model.hasNextRow() ) {
            HashMap row = model.nextRow();

            model.fireBeforeShowCategoryEvent( new Event() );

            if ( model.hasNextRow() ) {
                showControls(model, pathControls);
                tmpl.render(page.getCurrentPath()+"/PathComponent", true, page.getCurrentPath()+"/PathComponent", Template.IF_DOESNT_EXIST_DO_NOTHING);
            } else {
                showControls(model, currentControls);
                tmpl.render(page.getCurrentPath()+"/CurrentCategory", Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
        }
        tmpl.render(page.getCurrentPath(), Template.IF_DOESNT_EXIST_DO_NOTHING);
    gotoParentBlock(addedBlocks);
    }
    
    public void show(Directory model, Collection staticControls, Collection categoryControls, 
            Collection subcategoryControls, Collection subcattailControls, 
            boolean hasCatSeparator, boolean hasSubCatSeparator) {
      view.show(null, model, staticControls, categoryControls, subcategoryControls, subcattailControls, 
              hasCatSeparator, hasSubCatSeparator);
  }
  
    public void show(String subBlockName, Directory model, Collection staticControls, Collection categoryControls, 
            Collection subcategoryControls, Collection subcattailControls, 
            boolean hasCatSeparator, boolean hasSubCatSeparator) {
    int addedBlocks = 1;
    if (! StringUtils.isEmpty(subBlockName)) {
      addedBlocks = setCurrentBlock(subBlockName) + 1;
    }
        page.setCurrentBlock("Directory " + model.getName());
    parsedControls = new HashMap();
        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
        gotoParentBlock(addedBlocks);
            return;
        }

        model.fireBeforeShowEvent( new Event() );
setAttributesToTemplate(model);

        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
        gotoParentBlock(addedBlocks);
            return;
        }
        if ( model.hasErrors() ) {
            tmpl.setVar( page.getCurrentPath(), "Form: "+model.getName() + StringUtils.getBRTag() + 
                    "Errors:" + StringUtils.getBRTag() + model.getErrorsAsString() );
        gotoParentBlock(addedBlocks);
            return;
        }
        if ( model.isEmpty() ) {
            tmpl.render(page.getCurrentPath()+"/NoCategories", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
            tmpl.setVar(page.getCurrentPath()+"/Category");
            tmpl.setVar(page.getCurrentPath()+"/CategorySeparator");
            tmpl.setVar(page.getCurrentPath()+"/ColumnSeparator");
        gotoParentBlock(addedBlocks);
            return;
        } else {
            tmpl.setVar(page.getCurrentPath()+"/NoCategories");
        }

        view.showControls(model, staticControls);

        model.initializeRows();
        tmpl.setVar(page.getCurrentPath()+"/Category");
        tmpl.setVar(page.getCurrentPath()+"/CategorySeparator");
        while ( model.hasNextRow() ) {
            HashMap row = model.nextRow();
            tmpl.setVar(page.getCurrentPath()+"/ColumnSeparator");
            tmpl.setVar(page.getCurrentPath()+"/Category/SubcategoriesTail");
            if ( model.isShowCategory() ) {
                if (hasSubCatSeparator) {
                    tmpl.setVar(page.getCurrentPath()+"/Category/SubcategorySeparator");
                }
                if ( model.getCurrentCategoryNumber() > 1 ) {
                    tmpl.render(page.getCurrentPath()+"/Category", true, page.getCurrentPath()+"/Category", Template.IF_DOESNT_EXIST_DO_NOTHING);
                }
                if (hasSubCatSeparator) {
                    tmpl.setVar(page.getCurrentPath()+"/CategorySeparator");
                }
                tmpl.setVar(page.getCurrentPath()+"/Category/Subcategory");
    
                if ( hasCatSeparator && model.getCategoryNumberInColumn() > 1 ) {
                    tmpl.render(page.getCurrentPath()+"/CategorySeparator", true, page.getCurrentPath()+"/Category", Template.IF_DOESNT_EXIST_DO_NOTHING);
                } else {
                    if ( model.isNewColumn() && model.getCurrentCategoryNumber() > 1 ) {
                        tmpl.render(page.getCurrentPath()+"/ColumnSeparator", true, page.getCurrentPath()+"/Category", Template.IF_DOESNT_EXIST_DO_NOTHING);
                        tmpl.setVar(page.getCurrentPath()+"/NoCategories");
                    }
                }
                model.fireBeforeShowCategoryEvent( new Event() );
                view.showControls(model, categoryControls, "/Category");
            }
            
            if (model.isShowSubCategory()) {
                page.setCurrentBlock("Category");
                if (hasSubCatSeparator) {
                    if ( model.getCurrentSubCategoryNumber() > 1 ) {
                        tmpl.render(page.getCurrentPath()+"/SubcategorySeparator", true, page.getCurrentPath()+"/Subcategory", Template.IF_DOESNT_EXIST_DO_NOTHING);
                    } else {
                        tmpl.setVar(page.getCurrentPath()+"/SubcategorySeparator");
                    }
                }
                tmpl.setVar(page.getCurrentPath()+"/SubcategoriesTail");
                model.fireBeforeShowSubcategoryEvent( new Event() );
                view.showControls(model, subcategoryControls, "/Subcategory");
                tmpl.render(page.getCurrentPath()+"/Subcategory", true, page.getCurrentPath()+"/Subcategory", Template.IF_DOESNT_EXIST_DO_NOTHING);
                if ( model.isShowSubCategoryTail() ) {
                    if (hasSubCatSeparator) {
                        if ( model.getCurrentSubCategoryNumber() > 1 ) {
                            tmpl.render(page.getCurrentPath()+"/SubcategorySeparator", true, page.getCurrentPath()+"/Subcategory", Template.IF_DOESNT_EXIST_DO_NOTHING);
                        } else {
                            tmpl.setVar(page.getCurrentPath()+"/SubcategorySeparator");
                        }
                    }
                    view.showControls(model, subcattailControls, "/SubcategoriesTail");
                    tmpl.render(page.getCurrentPath()+"/SubcategoriesTail", true, page.getCurrentPath()+"/Subcategory", Template.IF_DOESNT_EXIST_DO_NOTHING);
                }
        page.gotoParentBlock();
            } else {
                tmpl.setVar(page.getCurrentPath()+"/Subcategory");
                tmpl.setVar(page.getCurrentPath()+"/SubcategorySeparator");
            }
        }
        tmpl.setVar(page.getCurrentPath()+"/Category/SubcategoriesTail");
        tmpl.setVar(page.getCurrentPath()+"/Category/SubcategorySeparator");
        tmpl.render(page.getCurrentPath()+"/Category", true, page.getCurrentPath()+"/Category", Template.IF_DOESNT_EXIST_DO_NOTHING);
    gotoParentBlock(addedBlocks);
    }
    
    public void show(EditableGrid model, Collection staticControls, Collection rowControls, 
            boolean hasSeparator, boolean hasClientScript) {
      view.show(null, model, staticControls, rowControls, hasSeparator, hasClientScript);
  }
  
    public void show(String subBlockName, EditableGrid model, Collection staticControls, Collection rowControls, 
            boolean hasSeparator, boolean hasClientScript) {
    int addedBlocks = 1;
    if (! StringUtils.isEmpty(subBlockName)) {
      addedBlocks = setCurrentBlock(subBlockName) + 1;
    }
    parsedControls = new HashMap();
        if (staticControls==null) staticControls = new ArrayList();
        if (rowControls==null) rowControls = new ArrayList();

        page.setCurrentBlock("EditableGrid " + model.getName());
        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
      gotoParentBlock(addedBlocks);
            return;
        }


//setAttributes(model);
        model.fireBeforeShowEvent( new Event() );
setAttributesToTemplate(model);

        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            gotoParentBlock(addedBlocks);
            return;
        }

        if (hasClientScript) {
            tmpl.setVar(page.getCurrentPath()+"/@FormScript", model.getFormScript());
        }

        for ( Iterator it = staticControls.iterator(); it.hasNext(); ) {
            com.codecharge.components.Model m = model.getChild((String) it.next());
            if ( m instanceof Control && ((Control) m).hasErrors() ) {
                model.addError(((Control) m).getErrorsAsString());
            } else if ( m instanceof VerifiableControl && ((VerifiableControl) m).hasErrors() && ((VerifiableControl) m).getErrorControlName() == null) {
                model.addError(((Control) m).getErrorsAsString());
            }
        }

        if ( model.hasErrors() ) {
            tmpl.setVar( page.getCurrentPath() + "/Error/@Error", model.getErrorsAsString(), Template.IF_DOESNT_EXIST_DO_NOTHING );
            tmpl.render( page.getCurrentPath() + "/Error", false, Template.IF_DOESNT_EXIST_DO_NOTHING );
        } else {
            tmpl.setVar( page.getCurrentPath() + "/Error" );
        }
        tmpl.setVar(page.getCurrentPath()+"/Row");
        if ( model.isEmpty() && (model.getNumberEmptyRows() == 0 || ! model.isAllowInsert())) {
            tmpl.render(page.getCurrentPath()+"/NoRecords", false, Template.IF_DOESNT_EXIST_DO_NOTHING);
        } else {
            tmpl.setVar(page.getCurrentPath()+"/NoRecords");
        }

        model.initializeRows();
        while ( model.hasNextRow() ) {
            HashMap row = model.nextRow();
      parsedControls = new HashMap();
            if (hasSeparator) {
                if ( row != null && model.getCurrentRowNumber() > 1 ) {
                    tmpl.render(page.getCurrentPath()+"/Separator", true, page.getCurrentPath()+"/Row", Template.IF_DOESNT_EXIST_DO_NOTHING);
                } else {
                    tmpl.setVar(page.getCurrentPath()+"/Separator");
                }
            }
    
            ErrorCollection rowErrors = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
            HashMap errorCollections = new HashMap();
            if (rowErrors==null) {
                rowErrors = new ErrorCollection();
                row.put(Names.CCS_ROW_ERROR_KEY, rowErrors);
            }
            for ( Iterator it = model.getRowControls().iterator(); it.hasNext(); ) {
                Model m = model.getChild((String) it.next());
                 if ( m instanceof VerifiableControl && ((VerifiableControl) m).hasErrors() 
                         && ((VerifiableControl) m).getErrorControlName() != null) {
                    ErrorCollection ec = (ErrorCollection) errorCollections.get(((VerifiableControl) m).getErrorControlName());
                    if (ec == null) {
                        ec = new ErrorCollection();
                        errorCollections.put(((VerifiableControl) m).getErrorControlName(), ec);
                    }
                    ec.addErrors(Utils.list(((VerifiableControl) m).getErrors()));
                    //String errVal = model.getControl(((VerifiableControl) m).getErrorControlName()).getFormattedValue();
                    //model.getControl(((VerifiableControl) m).getErrorControlName()).setFormattedValue(
                    //        errVal + ((VerifiableControl) m).getErrorsAsString());
                } else if ( m instanceof Control && ((Control) m).hasErrors() ) {
                    rowErrors.addErrors(Utils.list(((Control) m).getErrors()));
                }
            }

          //process errorCollections
          for (Iterator it = errorCollections.keySet().iterator(); it.hasNext(); ) {
              String key = (String) it.next();
              ErrorCollection ec = (ErrorCollection) errorCollections.get(key);
              String errVal = model.getControl(key).getFormattedValue();
              model.getControl(key).setFormattedValue(errVal + ec.getErrorsAsString());
          }
            
            if ( row != null && row.get(Names.CCS_ROW_ERROR_KEY) != null && ((ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY)).hasErrors() ) {
                tmpl.setVar(page.getCurrentPath()+"/Row/RowError");
                tmpl.setVar(page.getCurrentPath()+"/Row/RowError/@Error", ((ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY)).getErrorsAsString() );
                tmpl.render(page.getCurrentPath()+"/Row/RowError", Template.IF_DOESNT_EXIST_DO_NOTHING);
            } else {
                tmpl.setVar(page.getCurrentPath()+"/Row/RowError");
            }
    
            model.hideDeleteControl();
    
setRowAttributes(model);

            ModelAttribute ma = ((com.codecharge.util.ModelAttribute)model.getAttribute( "rowNumber" ));
            if (ma != null) ma.setValue( ""+(model.getCurrentRowNumber()) );

            model.fireBeforeShowRowEvent( new Event() );
setAttributesToTemplate(model);
    
            view.showControls(model, rowControls, "/Row", true, model.getCurrentRowNumber());
    
            tmpl.render(page.getCurrentPath()+"/Row", true, page.getCurrentPath()+"/Row", Template.IF_DOESNT_EXIST_DO_NOTHING);

        }


        model.nullChildRow();

        if ( model.isAllowInsert() ) {
            int numEmptyRow = 0;

            while ( (! model.isProcessed()) && (numEmptyRow < model.getNumberEmptyRows()) ) {
                HashMap row = model.getEmptyRow();
        parsedControls = new HashMap();

                if (hasSeparator) {
                    if ( numEmptyRow < model.getNumberEmptyRows() ) {
                        tmpl.render(page.getCurrentPath()+"/Separator", true, page.getCurrentPath()+"/Row", Template.IF_DOESNT_EXIST_DO_NOTHING);
                    } else {
                        tmpl.setVar(page.getCurrentPath()+"/Separator");
                    }
                }
                numEmptyRow++;

                ErrorCollection rowErrors = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
                if (rowErrors==null) {
                    rowErrors = new ErrorCollection();
                    row.put(Names.CCS_ROW_ERROR_KEY, rowErrors);
                }
                for ( Iterator it = model.getRowControls().iterator(); it.hasNext(); ) {
                    Model m = model.getChild((String) it.next());
                    if ( m instanceof Control && ((Control) m).hasErrors() ) {
                        rowErrors.addError(((Control) m).getErrorsAsString());
                    } else if ( m instanceof VerifiableControl && ((VerifiableControl) m).hasErrors() && ((VerifiableControl) m).getErrorControlName() == null) {
                        rowErrors.addError(((Control) m).getErrorsAsString());
                    }
                }

                if ( model.hasRowErrors() ) {
                    tmpl.setVar(page.getCurrentPath()+"/Row/RowError");
                    tmpl.setVar(page.getCurrentPath()+"/Row/RowError/@Error", ((ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY)).getErrorsAsString() );
                    tmpl.render(page.getCurrentPath()+"/Row/RowError", Template.IF_DOESNT_EXIST_DO_NOTHING);
                } else {
                    tmpl.setVar(page.getCurrentPath()+"/Row/RowError");
                }

                model.hideDeleteControl();
                        
                ModelAttribute ma = ((com.codecharge.util.ModelAttribute)model.getAttribute( "rowNumber" ));
                if (ma != null) ma.setValue( ""+(model.getCurrentRowNumber()) );

                model.fireBeforeShowRowEvent( new Event() );

                view.showControls(model, rowControls, "/Row", true, model.getCurrentRowNumber());

                tmpl.render(page.getCurrentPath()+"/Row", true, page.getCurrentPath()+"/Row", Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
        }

        parsedControls = new HashMap();
        view.showControls(model, staticControls);



        //StringBuffer formAction = new StringBuffer( page.getActionPageName() + ".do?ccsForm=" + model.getName() );
        CCSURL url = new CCSURL ();
        url.setUrl(page.getActionPageName() + ".do");

        url.addParameter("ccsForm", model.getName() );

        HashMap parameters = new HashMap();
        if ((model.getPreserveType()==PreserveParameterType.POST || model.getPreserveType()==PreserveParameterType.ALL) && page.getHttpGetParameter("ccsForm")==null) {
            parameters.putAll(page.getHttpPostParams().getPreserveParameters( model.getExcludeParams() ));
        }
        Vector getExclude = new Vector();
        getExclude.add("ccsForm");
        parameters.putAll(page.getHttpGetParams().getPreserveParameters(getExclude));
        Iterator params = parameters.values().iterator();
        while(params.hasNext()) {
            url.addParameters( (String)params.next() );
            //formAction.append("&"+((String)params.next()));
        }



        tmpl.setVar(page.getCurrentPath()+"/Separator");
        tmpl.setVar(page.getCurrentPath()+"/@FormState", model.getFormState());

        //tmpl.setVar( page.getCurrentPath() + "/@Action", SessionStorage.getInstance( page.getRequest() ).encodeURL(formAction.toString()) );
        tmpl.setVar( page.getCurrentPath() + "/@Action", SessionStorage.getInstance( page.getRequest() ).encodeURL(url.toString()) );

        tmpl.setVar( page.getCurrentPath() + "/@HTMLFormName", model.getName() );
        tmpl.setVar( page.getCurrentPath() + "/@HTMLFormEnctype", model.getFormEnctype() );
        //tmpl.setVar( page.getCurrentPath() + "/@HTMLFormProperties", "method=\"POST\"" + 
        //        " action=\"" + SessionStorage.getInstance( page.getRequest() ).encodeURL( formAction.toString() )+ 
        //        "\" name=\""+ model.getName() + "\"");
        tmpl.setVar( page.getCurrentPath() + "/@HTMLFormProperties", "method=\"POST\"" + 
                " action=\"" + SessionStorage.getInstance( page.getRequest() ).encodeURL( url.toString() )+ 
                "\" name=\""+ model.getName() + "\"");
        if ( model.isVisible() ) {
            tmpl.render(page.getCurrentPath(), false);
        } else {
            tmpl.setVar(page.getCurrentPath() );
        }
    gotoParentBlock(addedBlocks);
    }   
    
    public void showControls(Component model, Collection controls) {
        showControls(model, controls, null, false, 0);
    }
    
    public void showControls(Component model, Collection controls, String subBlockName) {
        showControls(model, controls, subBlockName, false, 0);
    }
    
    public void showControls(Component model, Collection controls, String subBlockName,
            boolean changeHtmlName, int index) {
        if (controls == null) {
            return;
        }
        for (Iterator it = controls.iterator(); it.hasNext();) {
            Model m = model.getChild((String) it.next());
            if (m == null) {
                continue;
            }
            if (parsedControls.get(m.getName()) == null) {
                if (m instanceof Navigator) {
                    view.show(m);
                } else if (m instanceof Sorter) {
                    view.show(m);
                } else if (m instanceof Captcha) {
                    view.show(m);
                } else if (m instanceof Panel) {
                    view.show(subBlockName, (Panel) m, changeHtmlName, index);
                } else if (!(m instanceof Component)) {
                    if (changeHtmlName) {
                        m.setHtmlName(m.getName() + "_" + index);
                    }
                    view.show(subBlockName, m);
                }
            }
        }
    }
    
    public void showControls(CalendarItem item, Collection controls, String subBlockName,
            boolean changeHtmlName, int index) {
        if (controls == null) {
            return;
        }
        for (Iterator it = controls.iterator(); it.hasNext();) {
            Model m = item.getModel((String) it.next());
            if (m == null) {
                continue;
            }
            if (parsedControls.get(m.getName()) == null) {
                if (m instanceof Navigator) {
                    view.show(m);
                } else if (m instanceof Sorter) {
                    view.show(m);
                } else if (m instanceof Panel) {
                    view.show(subBlockName, (Panel) m, changeHtmlName, index);
                } else if (!(m instanceof Component)) {
                    if (changeHtmlName) {
                        m.setHtmlName(m.getName() + "_" + index);
                    }
                    view.show(subBlockName, m);
                }
            }
        }
    }
    
    public void init( HttpServletRequest req, HttpServletResponse resp, ServletContext context, Page page ) {
        this.req = req;
        this.resp = resp;
        this.context = context;
        this.view = this;
        //this.resp.setContentType("text/html; charset=" + page.getCCSLocale().getCharacterEncoding() );
        this.resp.setContentType(page.getContentType());
        //TODO: add the possibility to change name of template in fireOnInitializeViewEvent 
        page.fireOnInitializeViewEvent(new Event());
        String templateEncoding = (String) req.getAttribute(Names.TEMPLATE_ENCODING);
        String templateClassName = StringUtils.getSiteProperty(Names.TEMPLATE_CLASS_NAME_KEY, "com.codecharge.Template");
        this.tmplPath = getTemplateFolder() + this.tmplPath;
        if ("com.codecharge.Template".equals(templateClassName)) {
            loadTemplate();
            getTemplate().setEncoding(templateEncoding);
            page.setTemplate(getTemplate());
        } else {
            Object bean = null;
            try {
                bean = Class.forName(templateClassName).newInstance();
            } catch (IllegalAccessException e) {
                logger.error("",e);
            } catch (InstantiationException e) {
                logger.error("",e);
            } catch (ClassNotFoundException e) {
                logger.error("",e);
            }
            this.tmpl = (ITemplate) bean;
            this.tmpl.setServletContext(this.context);
            this.tmpl.setTemplateSource((ITemplateSource) context.getAttribute(Names.TEMPLATE_SOURCE_CLASS_NAME_KEY));

            String templateParserClassName = (String) context.getAttribute(Names.TEMPLATE_PARSER_CLASS_NAME_KEY);
            Object templateParser = null;
            try {
				templateParser = Class.forName(templateParserClassName).newInstance();
			} catch (InstantiationException e) {
				logger.error("",e);
			} catch (IllegalAccessException e) {
				logger.error("",e);
			} catch (ClassNotFoundException e) {
				logger.error("",e);
			}
            this.tmpl.setTemplateParser((ITemplateParser) templateParser);
            //this.tmpl.setTemplateParser((ITemplateParser) context.getAttribute(Names.TEMPLATE_PARSER_CLASS_NAME_KEY));
            this.tmpl.setEncoding(templateEncoding);
            this.tmpl.setLocale(page.getLocale());
            page.setTemplate(this.tmpl);
            this.tmpl.load(this.tmplPath);

//this.tmpl.setPage(page);

            setTemplateVariables(page);
        }
//setAttributes(page);
        page.fireBeforeShowEvent(new Event());
setAttributesToTemplate(page);
    }

    public void setTemplateVariables(Page page) {
        HashMap vars = page.getVariables();
        Iterator it = vars.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Variable val = (Variable) vars.get(key);
            if (key.startsWith("/")) key = key.substring(1,key.length());
            if (key.endsWith("/*")) key = key.substring(0,key.length()-2);
            this.tmpl.setVar(key, val.getValue(),2);
            key = key.substring(key.lastIndexOf("/")+1,key.length());
            this.tmpl.setVar(key, val.getValue(),com.codecharge.template.CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING);
        }
    }

    public void setPageAttributes(Page page) {
        for (Iterator it = page.getAttributeKeys().iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            this.tmpl.setTag("main", "@"+key, encode( /*(String)*/ "" + page.getAttribute(key), page));
        }
    }

    private String encode(String value, Page page) {
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        String val = StringUtils.replace(SessionStorage.getInstance(page.getRequest()).encodeURL(value), " ", "%20");
        int pos = val.indexOf(";");
        if (pos > -1) {
            if (pos == 0) {
                return "";
            }
            val = val.substring(0, pos);
        }
        return val;
    }
    
    public void show(Panel model) {
        view.show(null, model, false, 0);
    }

    public void show(String blockName, Panel model) {
        view.show(blockName, model, false, 0);
    }

    public void show(String blockName, Panel model, boolean changeHtmlName, int index) {
        if (blockName == null) {
            blockName = "";
        }
        int addedBlocks = setCurrentBlock(blockName) + 1;
        page.setCurrentBlock("Panel " + model.getName());
        parsedControls.put(model.getName(), model.getName());
        model.fireBeforeShowEvent();
        if (!model.isVisible()) {
            tmpl.setVar(page.getCurrentPath());
            gotoParentBlock(addedBlocks);
            return;
        }



        showControls(model.getParent(), model.getChildrenNames(), null, changeHtmlName, index);
        if (model.isVisible()) {


			if (model.isUpdatePanel()) {
				String prefix = "<div id = \""+model.getPanelId()+"\">";
				String suffix = "</div>";

				Object oFiler = ""+page.getRequest().getAttribute(com.codecharge.Names.CCS_UPDATE_PANEL_FILTER);
				if (oFiler != null && !"".equals(""+oFiler) && model.getPanelId().equals(""+oFiler) ) {
					prefix = prefix + "<!--Panel["+model.getPanelId()+"][begin]-->";
					suffix = "<!--Panel["+model.getPanelId()+"][end]-->" + suffix;
				}

				//  Fix for features with pathToRoot attributes
				if (page.isIncluded()) {
		    		tmpl.setTag( "main", "main/@page:pathToRoot", (String)page.getAttribute(Page.PAGE_ATTRIBUTE_PATH_TO_ROOT));
		    	}
				
				//	temporary HACK, because old version was not working for update panels 
				tmpl.setVar(page.getCurrentPath(),prefix + tmpl.parseAndPrintForUpdatePanel(page.getCurrentPath(), false) + suffix);

				//old version
				//tmpl.setVar(page.getCurrentPath(),prefix + tmpl.render(page.getCurrentPath(), false)+suffix);


			} else {
				tmpl.render(page.getCurrentPath(), false);
			}

            //tmpl.render(page.getCurrentPath(), false);
        } else {
            tmpl.setVar(page.getCurrentPath());
        }


        gotoParentBlock(addedBlocks);
    }
  
    public void show(Report model, Map sectionControls, boolean hasSeparator) {
        page.setCurrentBlock("Report " + model.getName());
        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            page.gotoParentBlock();
            return;
        }
        model.initializeRows();
        //setAttributes(model);
        model.fireBeforeShowEvent( new Event() );
setAttributesToTemplate(model);

        if ( ! model.isVisible() ) {
            tmpl.setVar( page.getCurrentPath() );
            page.gotoParentBlock();
            return;
        }
        if ( model.hasErrors() ) {
            tmpl.setVar( page.getCurrentPath(), "Form: "+model.getName()  + StringUtils.getBRTag() + 
                    "Errors:" + StringUtils.getBRTag() + model.getErrorsAsString() );
            page.gotoParentBlock();
            return;
        }

        List reportGroups = model.getGroups();
        List reportGroupsReverse = new ArrayList(reportGroups);
        int reportGroupsSize = reportGroups.size();
        Collections.reverse(reportGroupsReverse); 

        model.initializeRows();
        
        String toAppendBlock = null;
        String usedBlock = null;
        if (usedBlock == null 
                && model.getPageNumber() == 1 
                && model.getGroup("Report").isHeaderVisible() 
                && tmpl.isExists(page.getCurrentPath()+"/Section Report_Header", ITemplate.BLOCK)) {
            usedBlock = page.getCurrentPath()+"/Section Report_Header";
        } 
        if (usedBlock == null
                && model.getGroup("Page").isHeaderVisible()
                && tmpl.isExists(page.getCurrentPath()+"/Section Page_Header", ITemplate.BLOCK)) {
            usedBlock = page.getCurrentPath()+"/Section Page_Header";
        } 
        for (int i = reportGroupsSize - 1; i >= 0; i--) {
            String groupName = (String) reportGroups.get(i);
            if (usedBlock == null 
                    && model.getGroup(groupName).isHeaderVisible()
                    && tmpl.isExists(page.getCurrentPath()+"/Section "+groupName+"_Header", ITemplate.BLOCK)) {
                usedBlock = page.getCurrentPath()+"/Section "+groupName+"_Header";
            } 
            tmpl.setVar(page.getCurrentPath()+"/Section "+groupName+"_Header");
        }
        
        if (usedBlock == null
                && model.getDetailRow().isVisible()
                && tmpl.isExists(page.getCurrentPath()+"/Section Detail", ITemplate.BLOCK)) {
            usedBlock = page.getCurrentPath()+"/Section Detail";
        }
        
        for (int i = reportGroupsSize - 1; i >= 0; i--) {
            String groupName = (String) reportGroups.get(i);
            /*if (toAppendBlock == null 
                    && model.getGroup(groupName).isFooterVisible()
                    && tmpl.isExists(page.getCurrentPath()+"/Section "+groupName+"_Footer", ITemplate.BLOCK)) {
                toAppendBlock = page.getCurrentPath()+"/Section "+groupName+"_Footer";
            }*/ 
            tmpl.setVar(page.getCurrentPath()+"/Section "+groupName+"_Footer");
        }
        if (usedBlock == null 
                && model.getGroup("Page").isFooterVisible()
                && tmpl.isExists(page.getCurrentPath()+"/Section Page_Footer", ITemplate.BLOCK)) {
            usedBlock = page.getCurrentPath()+"/Section Page_Footer";
            tmpl.setVar(page.getCurrentPath()+"/Section Page_Footer");
        } 
        if (usedBlock == null 
                && model.getGroup("Report").isFooterVisible()
                && tmpl.isExists(page.getCurrentPath()+"/Section Report_Footer", ITemplate.BLOCK)) {
            usedBlock = page.getCurrentPath()+"/Section Report_Footer";
            tmpl.setVar(page.getCurrentPath()+"/Section Report_Footer");
        } 
        
        toAppendBlock = page.getCurrentPath()+"/Result";
        tmpl.setVar(page.getCurrentPath()+"/Section Detail");


        if (! model.hasNextRow()) {

            if (model.hasChild("NoRecords")) {
                model.getPanel("NoRecords").setVisible(true);
            }
            if (model.hasChild("Navigator")) {
                showSection(page, model, "Report_Header", (Collection) sectionControls
                        .get("Report_HeaderControls"), model.getGroup("Report"), ReportGroup.GROUP_HEADER, 
                        toAppendBlock);
                
                showSection(page, model, "Page_Header", (Collection) sectionControls
                        .get("Page_HeaderControls"), model.getGroup("Page"), ReportGroup.GROUP_HEADER, 
                        toAppendBlock);

                showSection(page, model, "Report_Footer", (Collection) sectionControls.get("Report_FooterControls"), model.getGroup("Report"), ReportGroup.GROUP_FOOTER, 
                        toAppendBlock);
                
                showSection(page, model, "Page_Footer", (Collection) sectionControls
                        .get("Page_FooterControls"), model.getGroup("Page"), ReportGroup.GROUP_FOOTER, 
                        toAppendBlock);
            }
        } else {
            if (model.hasChild("NoRecords")) {
                model.getPanel("NoRecords").setVisible(false);
            } 
            int rn = 0;
            while (model.hasNextRow()) {
                parsedControls = new HashMap();
                ReportRow row = model.nextReportRow();
                rn++;
                if (model.getPageNumber() > 1) {
                    model.getGroup("Report").setHeaderVisibleOnPage(false);
                }
                if (model.getPageNumber() < model.getTotalPages()) {
                    model.getGroup("Report").setFooterVisibleOnPage(false);
                } else {
                    model.getGroup("Report").setFooterVisibleOnPage(true);
                }
                if (model.hasChild("Separator")) {
                    if (model.getGroup("Page").isClosed()) {
                        model.getPanel("Separator").setVisible(false);
                    } else {
                        model.getPanel("Separator").setVisible(true);
                    }
                }
                
                //Parse headers
                showSection(page, model, "Report_Header", (Collection) sectionControls
                        .get("Report_HeaderControls"), model.getGroup("Report"), ReportGroup.GROUP_HEADER, 
                        toAppendBlock);
                
                showSection(page, model, "Page_Header", (Collection) sectionControls
                        .get("Page_HeaderControls"), model.getGroup("Page"), ReportGroup.GROUP_HEADER, 
                        toAppendBlock);
                
                for (int i = 0; i < reportGroupsSize; i++) {
                    String groupName = (String) reportGroups.get(i);
                    String sectionName = groupName + "_Header";
                    showSection(page, model, sectionName, (Collection) sectionControls
                            .get(sectionName + "Controls"), model.getGroup(groupName), ReportGroup.GROUP_HEADER, 
                            toAppendBlock);
                }

                showDetailSection(page, model, (Collection) sectionControls.get("DetailControls"),
                        toAppendBlock);

                //Parse footers
                for (int i = reportGroupsSize - 1; i > -1; i--) {
                    String groupName = (String) reportGroups.get(i);
                    String sectionName = groupName + "_Footer";
                    showSection(page, model, sectionName, (Collection) sectionControls
                            .get(sectionName + "Controls"), model.getGroup(groupName), ReportGroup.GROUP_FOOTER, 
                            toAppendBlock);
                }
                showSection(page, model, "Report_Footer", (Collection) sectionControls.get("Report_FooterControls"), model.getGroup("Report"), ReportGroup.GROUP_FOOTER, 
                        toAppendBlock);
                
                showSection(page, model, "Page_Footer", (Collection) sectionControls
                        .get("Page_FooterControls"), model.getGroup("Page"), ReportGroup.GROUP_FOOTER, 
                        toAppendBlock);
            }
        }
        model.nullChildRow();

        if ( model.isVisible() ) {
            tmpl.setVar(usedBlock, tmpl.getVar(toAppendBlock));
            tmpl.render(page.getCurrentPath(), false);
        } else {
            tmpl.setVar(page.getCurrentPath() );
        }
        page.gotoParentBlock();
    }
    
    private void showSection(Page page, Report report, String sectionName
            , Collection sectionControls, ReportGroup group, int mode, String addToPath) {
        String sectionBlockName = "Section " + sectionName;
        page.setCurrentBlock(sectionBlockName);
        boolean visible = false;
        boolean isShowSection = false; 
        if (mode == ReportGroup.GROUP_FOOTER) {
            isShowSection = group.isClosed();
            if (isShowSection && group.isFooterVisibleOnPage()) {
setRowAttributes(report);
                group.fireBeforeShowFooterEvent();
            }
            visible = group.isFooterVisible();
            if (report.hasChild("PageBreak")
                    && "Page".equals(group.getName())
                    && ((report.getPageNumber() >= report.getTotalPages()
                    && report.getViewMode() == Report.VIEW_MODE_PRINT)
                    || report.getViewMode() == Report.VIEW_MODE_WEB)
                    ) {
                report.getChild("PageBreak").setVisible(false);
            }
        } else if (mode == ReportGroup.GROUP_HEADER) {
            isShowSection = group.isOpen();
            if (isShowSection && group.isHeaderVisibleOnPage()) {
setRowAttributes(report);
                group.fireBeforeShowHeaderEvent();
            }
            visible = group.isHeaderVisible();
        }

        tmpl.setVar(page.getCurrentPath());
        if (visible && isShowSection) {
            showControls(report, sectionControls, "");
            String body = tmpl.render(page.getCurrentPath(), true, addToPath, Template.IF_DOESNT_EXIST_DO_NOTHING);
        }
        page.gotoParentBlock();
    }

    private void showDetailSection(Page page, Report report, Collection sectionControls, String addToPath) {
        String sectionBlockName = "Section Detail"; 
        page.setCurrentBlock(sectionBlockName);
        if (report.getCurrentRow().isVisibleOnPage()) {
            boolean visible = true;
setRowAttributes(report);
            report.fireBeforeShowRowEvent();
            if (! report.getCurrentRow().isVisible()) {
                visible = false;
            }
            if (visible) {
                if (report.hasChild("Separator")) {
                    report.getPanel("Separator").setVisible(false);
                    if (! report.getActiveGroup().isClosed()) {
                        report.getPanel("Separator").setVisible(true);
                    }
                } 
                showControls(report, sectionControls);
                String body = tmpl.render(page.getCurrentPath(), true, addToPath, Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
        } else {
            tmpl.setVar(page.getCurrentPath());
        }
        page.gotoParentBlock();
    }
    
    public void show(Calendar model) {
        show(null, model);
    }
    public void show(String subBlockName, Calendar model) {
        int addedBlocks = 1;
        if (! StringUtils.isEmpty(subBlockName)) {
            addedBlocks = setCurrentBlock(subBlockName) + 1;
        }
        page.setCurrentBlock("Calendar " + model.getName());
        model.initializeRows();
        parsedControls = new HashMap();
        if (model.hasNextItem()) {
            model.setCurrentItem(model.nextItem());
        }
//setAttributes(model);
        model.fireBeforeShowEvent(new Event());
setAttributesToTemplate(model);
        if (! model.isVisible()) {
            tmpl.setVar(page.getCurrentPath());
            page.gotoParentBlock();
            return;
        }
        if (model.hasErrors()) {
            tmpl.setVar( page.getCurrentPath(), "Form: "+model.getName() + StringUtils.getBRTag() + 
                    "Errors:" + StringUtils.getBRTag() + model.getErrorsAsString() );
            page.gotoParentBlock();
            return;
        }
        model.initializeRows();
        tmpl.setTag(page.getCurrentPath(), "@MonthsInRow", ""+model.getMonthsInRow());
        tmpl.setVar(page.getCurrentPath()+"/MonthsRowSeparator");
        tmpl.setVar(page.getCurrentPath()+"/MonthSeparator"); //
        while (model.hasNextItem()) {
            //show years
            showCalendarYear(model, model.getCurrentItem());
        }
        tmpl.parse(page.getCurrentPath(), false);
        gotoParentBlock(addedBlocks);
    }
    
    public void showCalendarYear(Calendar model, CalendarItem year) {
        
        showControls(year, model.getSectionControlNames(com.codecharge.components.Calendar.CALENDAR_MAIN_SECTION), "", false, 0);
        
        int counter = 0;
        while (year.hasNextItem()) {
            //show months
            if (counter == model.getMonthsInRow() && year.hasNextItem()) {
                tmpl.setVar(page.getCurrentPath()+"/MonthSeparator");
                tmpl.parse(page.getCurrentPath()+"/MonthsRowSeparator", true, page.getCurrentPath()+"/Month", Template.IF_DOESNT_EXIST_DO_NOTHING);
                counter = 0;
            } else {
                if (counter > 0) {
                    tmpl.parse(page.getCurrentPath()+"/MonthSeparator", true, page.getCurrentPath()+"/Month", Template.IF_DOESNT_EXIST_DO_NOTHING);
                }
                tmpl.setVar(page.getCurrentPath()+"/MonthSeparator");
                tmpl.setVar(page.getCurrentPath()+"/MonthsRowSeparator");
            }


            CalendarItem ni = null;
            try {
                ni = year.nextItem();
                while (CalendarItem.MONTH != ni.getType()) {
                    ni = year.nextItem();
                }
            } catch (java.util.NoSuchElementException e) {
                return;
            }

                                                                  
            showCalendarMonth(model, (CalendarMonthItem) ni);
            counter++;
        }
        
    }
    
    public void showCalendarMonth(Calendar model, CalendarMonthItem month) {
        model.setCurrentItem(month);
//setRowAttributes(report);
        model.fireBeforeShowMonthEvent(new Event());
        page.setCurrentBlock("Month");
        
        java.util.Calendar cal = java.util.Calendar.getInstance(model.getTimeZone(), model.getPageModel().getLocale());
        cal.setTime(model.getBaseDate());
        
        tmpl.setVar(page.getCurrentPath()+"/Week");
        tmpl.setVar(page.getCurrentPath()+"/WeekDays");
        tmpl.setVar(page.getCurrentPath()+"/WeekDaySeparator");
        
        showWeekDays(model, month, cal);

        showControls(month, model.getSectionControlNames(
                    com.codecharge.components.Calendar.CALENDAR_MONTH_SECTION), "", false, 0);
        
        tmpl.setVar(page.getCurrentPath()+"/Week/Day");
        tmpl.setVar(page.getCurrentPath()+"/Week/DaySeparator");
        tmpl.setVar(page.getCurrentPath()+"/Week/EmptyDay");
        tmpl.setVar(page.getCurrentPath()+"/WeekSeparator");
        
        showWeeksAndDays(model, month, cal);
        
        page.gotoParentBlock();
    }

    private void showWeekDays(Calendar model, CalendarMonthItem month, java.util.Calendar cal) {
        CalendarItem[] weekdays = month.getWeekdays();
        for (int i = 0; i < weekdays.length; i++) {
            cal.setTime(weekdays[i].getDate());
            tmpl.setVar(page.getCurrentPath()+"/WeekDays/@Style", model.getStyle("WeekDays",
                        cal.get(java.util.Calendar.DAY_OF_WEEK),month));
            if (i > 0 && i < weekdays.length ) {
                tmpl.parse(page.getCurrentPath()+"/WeekDaySeparator", true, 
                        page.getCurrentPath()+"/WeekDays", Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
            showControls(weekdays[i], model.getSectionControlNames(
                        com.codecharge.components.Calendar.CALENDAR_WEEKDAYS_SECTION), "/WeekDays", false, 0);
            tmpl.parse(page.getCurrentPath()+"/WeekDays", true);
        }
    }

    private void showWeeksAndDays(Calendar model, CalendarMonthItem month, java.util.Calendar cal) {
        cal.setTime(month.getDate());
        int monthToShow = cal.get(java.util.Calendar.MONTH);
        cal.setTime(model.getBaseDate());
        int firstWeekday = model.getPageModel().getCCSLocale().getFirstWeekday() + 1;
        boolean start = true;
        CalendarItem day = null;
        while (month.hasNextItem()) {
            day = month.nextItem();
            day.iteratorInit();
            model.setCurrentItem(day);
            tmpl.setVar(page.getCurrentPath()+"/Week/DaySeparator");
            tmpl.setVar(page.getCurrentPath()+"/Week/EmptyDay");
            tmpl.setVar(page.getCurrentPath()+"/WeekSeparator");
            if (tmpl.isExists(page.getCurrentPath()+"/Week", ITemplate.BLOCK)) {
                start = switchWeek(model, day, firstWeekday, start);
                
                if (tmpl.isExists(page.getCurrentPath()+"/Week/Day", ITemplate.BLOCK)) {
//setRowAttributes(report);
                    model.fireBeforeShowDayEvent(new Event());
                    cal.setTime(day.getDate());
                    if ((firstWeekday != model.getItemWeekday(day))) {
                        tmpl.parse(page.getCurrentPath()+"/Week/DaySeparator", true, 
                                page.getCurrentPath()+"/Week/Day", Template.IF_DOESNT_EXIST_DO_NOTHING);
                    } else {
                        tmpl.setVar(page.getCurrentPath()+"/Week/DaySeparator");
                    }
                    if (monthToShow != cal.get(java.util.Calendar.MONTH) && ! model.isShowOtherMonthsDays()) {
                        showEmptyDay(model, day);
                    } else {
                        showDay(model, day);
                    }
                }
            }
        }
        
        //if (day != null) {
        //    showControls(day, model.getSectionControlNames(
        //                com.codecharge.components.Calendar.CALENDAR_WEEK_SECTION), "/Week", false, 0);
        //}
        closeWeek(false); //do not show week separator
        //tmpl.parse(page.getCurrentPath()+"/Week", true, page.getCurrentPath()+"/Week", Template.IF_DOESNT_EXIST_DO_NOTHING);
        tmpl.parse(page.getCurrentPath(), true, page.getCurrentPath(), Template.IF_DOESNT_EXIST_DO_NOTHING);
    }

    private void showDay(Calendar model, CalendarItem day) {
        tmpl.setTag(page.getCurrentPath()+"/Week/Day", "@Style", model.getCurrentStyle());
        showControls(day, model.getSectionControlNames(
                    com.codecharge.components.Calendar.CALENDAR_DAY_SECTION), "/Week/Day", false, 0);
        showEvents(model, day);                        
        tmpl.parse(page.getCurrentPath()+"/Week/Day", true, 
                page.getCurrentPath()+"/Week/Day", Template.IF_DOESNT_EXIST_DO_NOTHING);
        tmpl.setVar(page.getCurrentPath()+"/Week/EmptyDay");
    }

    private void showEvents(Calendar model, CalendarItem day) {
        tmpl.setVar(page.getCurrentPath()+"/Week/Day/EventRow");
        tmpl.setVar(page.getCurrentPath()+"/Week/Day/EventSeparator");
        tmpl.setVar(page.getCurrentPath()+"/Week/Day/NoEvents");
        if (tmpl.isExists(page.getCurrentPath()+"/Week/Day/EventRow", ITemplate.BLOCK)) {
            if (! day.hasNextItem()) {
                showNoEvents(model, day);
            } else {
                showEvent(model, day);
            }
        }
    }

    private void showNoEvents(Calendar model, CalendarItem day) {
        tmpl.setVar(page.getCurrentPath()+"/Week/Day/EventRow");
        tmpl.setVar(page.getCurrentPath()+"/Week/Day/EventSeparator");
        if (tmpl.isExists(page.getCurrentPath()+"/Week/Day/NoEvents", ITemplate.BLOCK)) {
            showControls(day, model.getSectionControlNames(com.codecharge.components.Calendar.CALENDAR_DAY_SECTION),
                    "/Week/Day/NoEvents", false, 0);
            tmpl.parse(page.getCurrentPath()+"/Week/Day/NoEvents", false, null, Template.IF_DOESNT_EXIST_DO_NOTHING);
        }
    }

    private void showEvent(Calendar model, CalendarItem day) {
        tmpl.setVar(page.getCurrentPath()+"/Week/Day/NoEvents");
        while (day.hasNextItem()) {
            CalendarItem event = day.nextItem();
            model.setCurrentItem(event);
//model.nextAttrRow();
setRowAttributes(model);
            model.fireBeforeShowEventEvent(new Event());

            showControls(event, model.getSectionControlNames(com.codecharge.components.Calendar.CALENDAR_EVENT_SECTION),
                    "/Week/Day/EventRow", false, 0);
            tmpl.parse(page.getCurrentPath()+"/Week/Day/EventRow", true, null, Template.IF_DOESNT_EXIST_DO_NOTHING);
            if (day.hasNextItem() && tmpl.isExists(page.getCurrentPath()+"/Week/Day/EventRow", ITemplate.BLOCK)) {
                showControls(event, model.getSectionControlNames(com.codecharge.components.Calendar.CALENDAR_EVENT_SECTION),
                        "/Week/Day/EventSeparator", false, 0);
                tmpl.parse(page.getCurrentPath()+"/Week/Day/EventSeparator", true, 
                page.getCurrentPath()+"/Week/Day/EventRow", Template.IF_DOESNT_EXIST_DO_NOTHING);
            }
        }
    }

    private void showEmptyDay(Calendar model, CalendarItem day) {
        showControls(day, model.getSectionControlNames(
                    com.codecharge.components.Calendar.CALENDAR_EMPTY_DAY_SECTION), "/Week/EmptyDay", false, 0);
        tmpl.setTag(page.getCurrentPath()+"/Week/EmptyDay", "@Style", model.getCurrentStyle());
        tmpl.parse(page.getCurrentPath()+"/Week/EmptyDay", true, page.getCurrentPath()+"/Week/Day", 
                Template.IF_DOESNT_EXIST_DO_NOTHING);
    }
    
    private boolean switchWeek(Calendar model, CalendarItem day, int firstWeekday, boolean start) {
        if (firstWeekday == model.getItemWeekday(day)) {
            if (start) {
                start = false;
            } else {
                closeWeek(true); // show week separator
            }
            model.fireBeforeShowWeekEvent(new Event());
            if (day != null) {
                showControls(day, model.getSectionControlNames(
                            com.codecharge.components.Calendar.CALENDAR_WEEK_SECTION), "/Week", false, 0);
            }
        }
        tmpl.setVar(page.getCurrentPath()+"/WeekSeparator");
        return start;
    }

    private void closeWeek(boolean isShowWeekSeparator) {
        tmpl.setVar(page.getCurrentPath()+"/Week/DaySeparator");
        tmpl.setVar(page.getCurrentPath()+"/Week/EmptyDay");
        tmpl.parse(page.getCurrentPath()+"/Week", true, page.getCurrentPath()+"/Week", 
                Template.IF_DOESNT_EXIST_DO_NOTHING);
        if (isShowWeekSeparator) {
            tmpl.parse(page.getCurrentPath()+"/WeekSeparator", true, page.getCurrentPath()+"/Week", 
                    Template.IF_DOESNT_EXIST_DO_NOTHING);
        }
        tmpl.setVar(page.getCurrentPath()+"/Week/Day");
    }

    private boolean isWeekend(int dayOfWeek) {
        if (dayOfWeek == java.util.Calendar.SUNDAY || dayOfWeek == java.util.Calendar.SATURDAY) {
            return true;
        }
        return false;
    }
    
    private String[] getWeekdays(Calendar model) {
        String[] weekdays = null;
        switch (model.getWeekDayFormat()) {
            case Calendar.WEEK_DAY_FORMAT_FULL:
                weekdays = model.getPageModel().getCCSLocale().getWeekdays();
                break;
            case Calendar.WEEK_DAY_FORMAT_SHORT:
                weekdays = model.getPageModel().getCCSLocale().getShortWeekdays();
                break;
            case Calendar.WEEK_DAY_FORMAT_NARROW:
                weekdays = model.getPageModel().getCCSLocale().getNarrowWeekdays();
                break;
        }
        return weekdays;
    }                   
    public void show(CalendarNavigator model) {
        show(null, model);
    }
    public void show(String subBlockName, CalendarNavigator model) {

        int addedBlocks = 1;
        if (! StringUtils.isEmpty(subBlockName)) {
            addedBlocks = setCurrentBlock(subBlockName) + 1;
        }
        page.setCurrentBlock("CalendarNavigator "+model.getName());
        
//setAttributes(model);
        model.fireBeforeShowEvent(new Event());
        tmpl.setVar(page.getCurrentPath());
        
        if (model.isVisible()) {
            String calendarName = ((Calendar) model.getParent()).getName();
            tmpl.setTag(page.getCurrentPath(), "@CalendarName", calendarName);

            StringBuffer preservedParameters = new StringBuffer();
            HashMap parameters = new HashMap();
            Vector getExclude = new Vector();
            getExclude.add("ccsForm");
            getExclude.add(calendarName+"Date");
            getExclude.add(calendarName+"Year");
            getExclude.add(calendarName+"Month");
            parameters.putAll(page.getHttpGetParams().getPreserveParameters(getExclude));
            Iterator params = parameters.values().iterator();
            while(params.hasNext()) {
                preservedParameters.append("&"+((String)params.next()));
            }
            String formAction = page.getActionPageName() + ".do";
            
            tmpl.setVar(page.getCurrentPath() + "/@Action", SessionStorage.getInstance(
                    page.getRequest()).encodeURL(formAction+"?ccsForm=" + model.getParent().getName() + 
                    preservedParameters.toString()));
            tmpl.setVar(page.getCurrentPath()+"/@Year", model.getYear()+"");
            
            CalendarNavigatorItem[] items = model.getYears();
            if (items != null && tmpl.isExists(page.getCurrentPath()+"/Years", ITemplate.BLOCK)) {
                //showCalendarNavigatorSubBlock(calendarName, "Years", "Year", items, false, preservedParameters);
                
                for (int i = 0; i < items.length; i++) {
                    tmpl.setTag(page.getCurrentPath()+"/Years", "@URL", 
                            SessionStorage.getInstance(page.getRequest()).encodeURL(formAction+"?"+calendarName+"Date="+items[i].getYear()+"-"+monthToString(items[i].getMonth())+preservedParameters));
                    tmpl.setTag(page.getCurrentPath()+"/Years", "@Quarter", items[i].getQuarter()+"");
                    tmpl.setTag(page.getCurrentPath()+"/Years", "@Month", items[i].getMonth()+"");
                    tmpl.setTag(page.getCurrentPath()+"/Years", "@MonthFullName", items[i].getName());
                    tmpl.setTag(page.getCurrentPath()+"/Years", "@MonthShortName", items[i].getShortName());
                    tmpl.setTag(page.getCurrentPath()+"/Years", "@Year", items[i].getYear()+"");
                    tmpl.setVar(page.getCurrentPath()+"/Years/Current_Year");
                    if (items[i].isSelected()) {
                        tmpl.parse(page.getCurrentPath()+"/Years/Current_Year", true, page.getCurrentPath()+"/Years/Regular_Year", ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                    } else {
                        tmpl.parse(page.getCurrentPath()+"/Years/Regular_Year", true, null, ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                    }
                }
                tmpl.setVar(page.getCurrentPath()+"/Years/Current_Year");
                tmpl.parse(page.getCurrentPath()+"/Years", false, null, ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                
            }

            items = model.getItems();
            if (items != null && tmpl.isExists(page.getCurrentPath()+"/Quarters", ITemplate.BLOCK)) {
                //showCalendarNavigatorSubBlock(calendarName, "Quarters", "Quarter", items, true, preservedParameters);
                
                for (int i = 0; i < items.length; i++) {
                    tmpl.setTag(page.getCurrentPath()+"/Quarters", "@URL", 
                            SessionStorage.getInstance(page.getRequest()).encodeURL(formAction+"?"+calendarName
                            +"Date="+items[i].getYear()+"-"+monthToString(items[i].getMonth())+ preservedParameters));
                    tmpl.setTag(page.getCurrentPath()+"/Quarters", "@Quarter", items[i].getQuarter()+"");
                    tmpl.setTag(page.getCurrentPath()+"/Quarters", "@Month", items[i].getMonth()+"");
                    tmpl.setTag(page.getCurrentPath()+"/Quarters", "@MonthFullName", items[i].getName());
                    tmpl.setTag(page.getCurrentPath()+"/Quarters", "@MonthShortName", items[i].getShortName());
                    tmpl.setTag(page.getCurrentPath()+"/Quarters", "@Year", items[i].getYear()+"");
                    if (items[i].isSelected()) {
                        tmpl.parse(page.getCurrentPath()+"/Quarters/Current_Quarter", true, page.getCurrentPath()+"/Quarters/Regular_Quarter", ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                    } else {
                        tmpl.setVar(page.getCurrentPath()+"/Quarters/Current_Quarter");
                        tmpl.parse(page.getCurrentPath()+"/Quarters/Regular_Quarter", true, null, ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                    }
                }
                tmpl.parse(page.getCurrentPath()+"/Quarters", false, null, ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                
            } else if (items != null && tmpl.isExists(page.getCurrentPath()+"/Months", ITemplate.BLOCK)) {
                //showCalendarNavigatorSubBlock(calendarName, "Months", "Month", items, true, preservedParameters);
                
                for (int i = 0; i < items.length; i++) {
                    tmpl.setTag(page.getCurrentPath()+"/Months", "@URL", 
                            SessionStorage.getInstance(page.getRequest()).encodeURL(formAction+"?"+calendarName
                            +"Date="+items[i].getYear()+"-"+monthToString(items[i].getMonth())+ preservedParameters));
                    tmpl.setTag(page.getCurrentPath()+"/Months", "@Quarter", items[i].getQuarter()+"");
                    tmpl.setTag(page.getCurrentPath()+"/Months", "@Month", items[i].getMonth()+"");
                    tmpl.setTag(page.getCurrentPath()+"/Months", "@MonthFullName", items[i].getName());
                    tmpl.setTag(page.getCurrentPath()+"/Months", "@MonthShortName", items[i].getShortName());
                    tmpl.setTag(page.getCurrentPath()+"/Months", "@Year", items[i].getYear()+"");
                    if (items[i].isSelected()) {
                        tmpl.parse(page.getCurrentPath()+"/Months/Current_Month", true, page.getCurrentPath()+"/Months/Regular_Month", ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                    } else {
                        tmpl.setVar(page.getCurrentPath()+"/Months/Current_Month");
                        tmpl.parse(page.getCurrentPath()+"/Months/Regular_Month", true, null, ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                    }
                }
                tmpl.parse(page.getCurrentPath()+"/Months", false, null, ITemplate.IF_DOESNT_EXIST_DO_NOTHING);
                
            } else {
                String[] monthNames = ((Calendar) model.getParent()).getPageModel().getCCSLocale().getMonths();
                String[] monthShortNames = ((Calendar) model.getParent()).getPageModel().getCCSLocale().getShortMonths();
                tmpl.setTag(page.getCurrentPath(), "@Month", (model.getMonth()+1)+"");
                tmpl.setTag(page.getCurrentPath(), "@MonthShortName", monthShortNames[model.getMonth()]);
                tmpl.setTag(page.getCurrentPath(), "@MonthFullName", monthNames[model.getMonth()]);
                tmpl.setTag(page.getCurrentPath(), "@Quarter", (model.getMonth()/3+1)+"");
                tmpl.setTag(page.getCurrentPath(), "@Year", model.getYear()+"");
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            SimpleDateFormat sdf_year = new SimpleDateFormat("yyyy");

            String url = SessionStorage.getInstance(page.getRequest()).encodeURL(formAction+"?"
                    +calendarName+"Date="+sdf.format(model.getPrevYear())+preservedParameters);
            tmpl.setVar(page.getCurrentPath()+"/Prev_Year/@URL", url);
            tmpl.setVar(page.getCurrentPath()+"/Prev_Year/@Year", (model.getYear()-1)+"");


            if (((Calendar) model.getParent()).getMonths()==Calendar.CALENDAR_MONTHS_YEAR) {
                tmpl.hideBlock(page.getCurrentPath()+"/Prev");
                tmpl.hideBlock(page.getCurrentPath()+"/Next");
                tmpl.hideBlock(page.getCurrentPath()+"/Months");
                tmpl.hideBlock(page.getCurrentPath()+"/Quarters");
            } else {
                url = SessionStorage.getInstance(page.getRequest()).encodeURL(formAction+"?"
                        +calendarName+"Date="+sdf.format(model.getPrevDate())+preservedParameters);
                tmpl.setVar(page.getCurrentPath()+"/Prev/@URL", url);
                tmpl.setVar(page.getCurrentPath()+"/Prev/@Year", sdf_year.format(model.getPrevDate()));
                url = SessionStorage.getInstance(page.getRequest()).encodeURL(formAction+"?"
                        +calendarName+"Date="+sdf.format(model.getNextDate())+preservedParameters);
                tmpl.setVar(page.getCurrentPath()+"/Next/@URL", url);
                tmpl.setVar(page.getCurrentPath()+"/Next/@Year", sdf_year.format(model.getNextDate()));
            }

            url = SessionStorage.getInstance(page.getRequest()).encodeURL(formAction+"?"
                    +calendarName+"Date="+sdf.format(model.getNextYear())+preservedParameters);
            tmpl.setVar(page.getCurrentPath()+"/Next_Year/@URL", url);
            tmpl.setVar(page.getCurrentPath()+"/Next_Year/@Year", (model.getYear()+1)+"");
            tmpl.parse(page.getCurrentPath(), false);
        }
        gotoParentBlock(addedBlocks);
    }
    
    private String monthToString(int month) {
        if (month < 10) {
            return "0"+month;
        }
        return ""+month;
    }
    
    /**
     *  Returns number of added blocks.
     *  @param path relative path from current position. If path contains only '/' - does nothing
     *  @return number of added block
     */
    private int setCurrentBlock(String path) {
        if (StringUtils.isEmpty(path)) return 0;
        if (StringUtils.isEmpty(path.replace('/', ' ').trim())) return 0;
        int numBlocks = 0;
        StringTokenizer st = new StringTokenizer(path, "/");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (! StringUtils.isEmpty(token)) {
                page.setCurrentBlock(token);
                numBlocks++;
            }
        }
        return numBlocks;
    }

    private void gotoParentBlock(int addedBlocks) {
      for (int i = 0; i < addedBlocks; i++) {
          page.gotoParentBlock();
      }
    }

    public void cachePage(String pageName, Object content) {
        String pageContent = "";
        if (content instanceof String) {
            pageContent = (String) content;
        } else if (content instanceof byte[]) {
            try {
                pageContent = new String((byte[]) content, this.page.getCharacterEncoding());
            } catch (java.io.UnsupportedEncodingException e) {
                pageContent = new String((byte[]) content);
            }
        } else {
            throw new RuntimeException("Unable to cache page content.");
        }
        View.cachePage(pageName, pageContent, this.page.getCharacterEncoding(), this.req, this.resp);
    }
    
    public static void cachePage(String pageKey, String content, String encoding, ServletRequest req, ServletResponse resp) {
        PageSettings pageSettings = Action.getCachingSettings(pageKey);
        if (pageSettings == null) {
            return;
        }
        
        CacheEvent cacheEvent = new CacheEvent(((HttpServletRequest) req), ((HttpServletResponse) resp), pageSettings);
        cacheEvent.setCacheOperation(ICache.OPERATION_PUT);
        pageSettings.fireOnCacheEvent(cacheEvent);
        ICache cache = Action.getCacheInstance();
        boolean enabled = Action.isCachingEnabled(pageSettings, req, resp, cache);
        
        String cacheKey = cache.getCacheKey(pageKey, req);
        String encCacheKey = cache.getCacheKey(pageKey+"~encoding~", req);
        
        if (content == null) {
            content = "";
        }
        if (encoding == null) {
            encoding = "ISO-8859-1";
        }
        
        if (enabled) {
            if (pageSettings != null) {
                cache.putObject(cacheKey, content, pageSettings.getDuration());
                cache.putObject(encCacheKey, encoding, pageSettings.getDuration());
            }
        } else {
            cache.clearStartedWith(cacheKey);
            cache.clearStartedWith(encCacheKey);
        }
    }

    public void setRowAttributes (Object obj) {
        if (obj instanceof Component) {
            Component comp = (Component)obj;
            Iterator it = comp.getRowAttributeKeys().iterator();
            while (it.hasNext()) {
                String key = (String)it.next();                     
                Object attr = comp.getAttribute(key);

                if (attr instanceof ModelAttribute) {
                    ModelAttribute mAttr = (ModelAttribute) attr;
                    String name = mAttr.getName();
                    String source = mAttr.getSourceName();
                    String soureType = mAttr.getSourceType();

                    Object value = mAttr.getValue();
                    String varName = "@" + comp.getName()+":"+name;
                    tmpl.setTag(page.getCurrentPath(), varName, ""+value);

                }
            }
        }

    }


    public void setAttributes (Object obj) {
        if (obj instanceof Model) {
            Model comp = (Model)obj;
            Iterator it = comp.getAttributeKeys().iterator();
            while (it.hasNext()) {
                String key = (String)it.next();
                Object attr = comp.getAttribute(key);
                if (attr instanceof ModelAttribute) {
                    ModelAttribute mAttr = (ModelAttribute) attr;

                    String name = mAttr.getName();
                    String source = mAttr.getSourceName();
                    String soureType = mAttr.getSourceType();

                    Object value = null;

                    if ( "URL".equals(soureType) ) {
                        value = page.getHttpGetParameter(source);
                    } else if ( "Form".equals(soureType) ) {
                        value = page.getHttpPostParams().getParameter(source);
                    } else if ( "Session".equals(soureType) ) {
                        value = SessionStorage.getInstance(page.getRequest()).getAttribute(source);
                    } else if ( "Application".equals(soureType) ) {
                        value = ContextStorage.getInstance().getAttribute(source);
                    } else if ( "Cookie".equals(soureType) ) {
                        value = StringUtils.getCookie(source, page.getRequest().getCookies());
                    } else { //DataField Expression
                        value = mAttr.getValue();
                    }

                    if (value == null) value = "";

                    String varName = "@" + comp.getName()+":"+name;
                    tmpl.setTag(page.getCurrentPath(), varName, ""+value);
                }
            }
        }
    }





    public void setAttributesToTemplate (Object obj) {
        if (obj instanceof Model) {
            Model comp = (Model)obj;
            Iterator it = comp.getAttributeKeys().iterator();
            while (it.hasNext()) {
                String key = (String)it.next();
                Object attr = comp.getAttribute(key);
                if (attr instanceof ModelAttribute) {
                    ModelAttribute mAttr = (ModelAttribute) attr;

                    String name = mAttr.getName();
                    String source = mAttr.getSourceName();
                    String soureType = mAttr.getSourceType();

                    Object value = null;
                    value = mAttr.getValue();

                    if (value == null) value = "";


                    String varName = null;
                    if (obj instanceof Page) {
                        varName = "@page:"+name;                        
                    } else {
                        varName = "@" + comp.getName()+":"+name;
                    }



//                    if ( "DataField".equals(soureType) /*|| "Expression".equals(soureType)*/ ) {
//System.out.println("LLLLLLLLLLLL2["+page.getCurrentPath()+"]["+varName+"]["+value+"]");
//                    }

//System.out.println("In View Attributes name ["+name+"] value ["+value+"] current path ["+page.getCurrentPath()+"] varName ["+varName+"].");


                   tmpl.setTag(page.getCurrentPath(), varName, ""+value);

                    //}

                }
            }
        }
    }



    
}









//End View class

