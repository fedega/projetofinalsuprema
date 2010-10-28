//PageController class: head @0-9C1364AE
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.events.*;

import java.util.*;
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.xml.parsers.*;
import javax.servlet.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class PageController {

    public static final int GET = 1;
    public static final int POST = 2;

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext application;
    private CCLogger logger = CCLogger.getInstance();
    private Page page;
    private String pagePath;
    private Document doc;

    public PageController(HttpServletRequest request, HttpServletResponse response, ServletContext application, String modelName )
           throws ParserConfigurationException, SAXException
    {
      this(request, response, application, modelName, null);
    }
    public PageController(HttpServletRequest request, HttpServletResponse response, ServletContext application, String modelName, String encoding )
           throws ParserConfigurationException, SAXException
    {
        this.request = request;
        this.response = response;
        this.application = application;


        ControllerEvent controllerEvent = new ControllerEvent( application, request, response );
        String handlerClassName = ContextStorage.getInstance().getAttributeAsString( "controllerHandlerClassName" );

        if ( StringUtils.isEmpty( handlerClassName ) ) {
          handlerClassName = "com.codecharge.util.DefaultControllerHandler";
        }
        try {
            Class handler = Class.forName( handlerClassName );
            ControllerListener cl = (ControllerListener) handler.newInstance();
            cl.controllerInitializing( controllerEvent );
        } catch ( java.lang.ClassNotFoundException cnfe ) {
            logger.error( "Class '" + handlerClassName + "' not found" );
            throw new SAXException( cnfe.getMessage() );
        } catch ( java.lang.InstantiationException ie ) {
            logger.error( "Unable to create instance '" + handlerClassName );
            throw new SAXException( ie.getMessage() );
        } catch ( java.lang.IllegalAccessException iae ) {
            logger.error( "IllegalAccessException occurred while creating instance '" + handlerClassName  );
            throw new SAXException( iae.getMessage() );
        }

        pagePath = this.request.getServletPath();
        logger.debug("Process page "+pagePath);
        if ( modelName == null ) {
            int pos = pagePath.lastIndexOf( ".jsp" );
            if ( pos > -1 ) {
                modelName = pagePath.substring( 0, pos ) + ".xml";
            }
        }
        if (! StringUtils.isEmpty(StringUtils.getSiteProperty("modelFolder"))) {
            modelName = getModelFolder() + modelName;
        }

        ModelParser parser = new ModelParser(modelName, application);
        doc = parser.getDOM();
        page = parser.getPage();
        page.setCCSLocale((CCSLocale)SessionStorage.getInstance(request).getAttribute(Names.CCS_LOCALE_KEY));
        if (encoding!=null) page.setCharacterEncoding(encoding); //TODO: concurrent changes of locale object in Session
        page.setResponse( response );
        page.setRequest( request );

    //boolean useI18nFeatures = new Boolean(StringUtils.getSiteProperty("useI18nFeatures")).booleanValue();
    //if (useI18nFeatures) {
    //  this.response.setCharacterEncoding(page.getCharacterEncoding());
    //} else if (!StringUtils.isEmpty (encoding) ) {
    //  this.response.setCharacterEncoding(StringUtils.getSiteProperty(encoding));
    //}


        Page parent = (Page)request.getAttribute(page.getName()+"Parent");
        if (parent == null) {
          request.setAttribute("page", page);
          page.setIncluded(false);
        } else {
          request.setAttribute(page.getName()+"_page", page);
          page.setIncluded(true);
        }

        Authenticator auth = AuthenticatorFactory.getAuthenticator( request );
        auth.setRequest( request );
        auth.setResponse( response );
    }

    private String getModelFolder() {
        String modelFolder = StringUtils.replace(StringUtils.getSiteProperty("modelFolder"), "/", "\\");
        if (! StringUtils.isEmpty(modelFolder)) {
            while (modelFolder.length() > 1 
                    && modelFolder.substring(modelFolder.length()-1, modelFolder.length()) == "\\") {
                modelFolder = modelFolder.substring(modelFolder.length()-1);
            }
            while (modelFolder.length() > 1 && modelFolder.substring(0, 1) == "\\") {
                modelFolder = modelFolder.substring(1);
            }
            return modelFolder;
        }
        return "";
    }

    public Page getPage() {return page;}

    /** Process Page.
       @return true if redirect is called and we need to end execution of page
    **/
    public boolean process() {
        page.fireBeforeInitializeEvent();
        logger.debug("PageController.process() started");
        if (!request.isSecure() && page.isOnlySslAccess()) {
            try {
                PrintWriter out = response.getWriter();
                ResourceBundle res = ResourceBundle.getBundle("MessagesBundle");
                out.println(res.getString("SSLError"));
                out.flush();
                out.close();
            } catch (Exception e) {
            }
            return true;
        }

        com.codecharge.util.Utils.checkAutoLoginCoockie(page);

        String authError = authorize(page);
        if ( authError != null ) {
            String uri = page.getRequest().getRequestURI();
			if (uri.toString().lastIndexOf(".jsp") == -1 ) {
            	String homePage = StringUtils.getSiteProperty("startPage");
            	uri += homePage + ".jsp";
            }			
            uri = uri.substring( uri.toString().lastIndexOf('/') + 1, uri.toString().lastIndexOf(".jsp") );
            if ( ! uri.equals(page.getName()) ) {
                page.setVisible(false);
                return false;
            }
            String loginPage = doc.getDocumentElement().getAttribute("accessDeniedPage");
            String convertRule = doc.getDocumentElement().getAttribute("convertRule");
            StringBuffer sb = new StringBuffer( SessionStorage.getInstance(request).encodeRedirectURL(loginPage) );
            if ( "absolute".equalsIgnoreCase( convertRule ) ) {
                sb.insert( 0, ( (String) ContextStorage.getInstance().getAttribute("serverUrl") ) + "/" );
            } else if ( "SSL".equalsIgnoreCase( convertRule ) ) {
                sb.insert( 0, ( (String) ContextStorage.getInstance().getAttribute("securedUrl") ) + "/" );
            }


            CCSURL url = new CCSURL ();
            url.setUrl(sb.toString());

            //url.addParameter("ret_link", response.encodeURL( getReturnURI( request )) );
            url.addTextParameter("ret_link", response.encodeURL( getReturnURI( request )) );

            //url.addParameter("type", authError);
            url.addTextParameter("type", authError);

            //sb.append( "?ret_link=" + response.encodeURL( getReturnURI( request  ) + "&type=" + authError ) );
            if (!page.isIncluded()) {
                //page.setRedirect(sb.toString());
                page.setRedirect( url.toRedirectString() );
                logger.debug("Redirect to "+page.getRedirect() + " due to Authorization error: " + authError);
                return true;
            }
            return false;
        }

        page.fireAfterInitializeEvent();
        new PageProcessor(doc.getDocumentElement(), page, page).process();
        return false;
    }
    protected String getReturnURI( HttpServletRequest req ) {
        String reqURI = req.getRequestURI();
        if ( ContextStorage.getInstance().getAttribute( "convertReturnLinkToAbsolute" ) != null ) {
            if ( StringUtils.isEmpty( reqURI ) || reqURI.startsWith( "/" ) ) {
                reqURI = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +
                        req.getContextPath() + "/" + reqURI.substring( req.getContextPath().length() + 1 );
            }
        }
        StringBuffer sreqURI = new StringBuffer( reqURI );
        if ( ! StringUtils.isEmpty( req.getQueryString() ) ) {
            sreqURI.append( "?" + req.getQueryString() );
        }
        return java.net.URLEncoder.encode(sreqURI.toString());
    }

    /** Authorize logged in user for the page.
    @return null if authorization is granted or error string */
  protected String authorize ( Page page ) {
      String errorCode = null;
      if ( page.isRestricted() ) {
          errorCode = "notLogged";
          boolean allowAccess = false;
          Authenticator auth = AuthenticatorFactory.getAuthenticator( request );
          if ( auth.getUserPrincipal() != null ) {
              errorCode = null;
              Permission p = page.getPermissions();
              if ( p != null && p.isUseGroup() ) {
                  String[] groups = p.getGroupsIdByPermission( Permission.ALLOW_ACCESS );
                  if ( groups != null && groups.length > 0 ) {
                      for ( int i = 0; i < groups.length; i++ ) {
                          if ( auth.isUserInRole( groups[i] ) ) {
                              allowAccess = true;
                              break;
                          }
                      }
                      if (! allowAccess) {
                                        errorCode = "illegalGroup";
                              }
                  } else {
                      errorCode = "groupIDNotSet";
                  }
              } else {
                  allowAccess = true;
              }
          }
      }
      return errorCode;
  }
}
//End PageController class: head

