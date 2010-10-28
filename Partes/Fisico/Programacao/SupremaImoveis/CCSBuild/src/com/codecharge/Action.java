//Action class @0-4970387E
/*
 * $Revision: 1.7 $
 * $Date: 2005/04/29 08:26:08 $
 */
package com.codecharge;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codecharge.components.Component;
import com.codecharge.components.Control;
import com.codecharge.components.ControlType;
import com.codecharge.components.EditableGrid;
import com.codecharge.components.Grid;
import com.codecharge.components.IRecord;
import com.codecharge.components.Model;
import com.codecharge.components.Page;
import com.codecharge.components.Record;
import com.codecharge.components.Report;
import com.codecharge.components.VerifiableControl;
import com.codecharge.db.ParameterSource;
import com.codecharge.util.Authenticator;
import com.codecharge.util.AuthenticatorFactory;
import com.codecharge.util.CCLogger;
import com.codecharge.util.CCSLocale;
import com.codecharge.util.LocaleChooser;
import com.codecharge.util.StyleChooser;
import com.codecharge.util.ContextStorage;
import com.codecharge.util.Permission;
import com.codecharge.util.StringUtils;
import com.codecharge.util.Utils;
import com.codecharge.util.cache.CacheConfigurator;
import com.codecharge.util.cache.CacheEvent;
import com.codecharge.util.cache.CachingParameter;
import com.codecharge.util.cache.ICache;
import com.codecharge.util.cache.PageSettings;
import com.codecharge.validation.ControlErrorTypes;

public abstract class Action {

    public static final int GET = 1;
    public static final int POST = 2;

    protected HttpServletRequest req;
    protected HttpServletResponse resp;
    protected ServletContext context;
    protected CCLogger logger;
    protected Page page;
    protected String pageName;
    protected ResourceBundle res;

    protected String redirect = null;
    
    public Action() {
        logger = CCLogger.getInstance();
    }

    public abstract String perform( HttpServletRequest req, HttpServletResponse resp, ServletContext context );

    public String getPageName() {
        return pageName;
    }

    public void setPageName( String pageName ) {
        this.pageName = pageName;
    }
    
    protected void isSecure() {
        if ( ! req.isSecure() ) {
            try {
                java.io.PrintWriter actionPw = new java.io.PrintWriter( 
                        new java.io.OutputStreamWriter( resp.getOutputStream() ));
                actionPw.println(res.getString("SSLError"));
                actionPw.flush();
                actionPw.close();
            } catch (java.io.IOException ioe) {
                ioe.printStackTrace(System.err);
            }
        }
    }
    
    protected String formPagePath( HttpServletRequest req ) {
        return req.getServerName() + ":" + req.getServerPort() + 
                req.getContextPath() + "/";
    }
    
    protected String getReturnURI( HttpServletRequest req ) {
        String reqURI = req.getRequestURI();
        if ( ContextStorage.getInstance().getAttribute( "convertReturnLinkToAbsolute" ) != null ) {
            if ( StringUtils.isEmpty( reqURI ) || reqURI.startsWith( "/" ) ) {
                reqURI = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + 
                        req.getContextPath() + "/" + reqURI.substring( req.getContextPath().length() + 1 );
            }
        }
        return reqURI;
    }
    
    protected void setBeanProperty(Component model, String property, String parameter) {
        try {
            Method m = getSetMethod(model, property);
            m.invoke(model, new Object[]  {page.getParameter(parameter)});
        } catch (NoSuchMethodException nsme) {
            // No method, no problem
            System.out.println(nsme.getMessage());        
        } catch (IllegalAccessException iae) {
            logger.error("Action::setBeanProperty: Illegal Access", iae); 
        } catch (InvocationTargetException ite) {
            logger.log(ite.getMessage(), ite);
        }
    }

    protected void setControlValue(Model m, String pname, int mode, Component component ) {
        if (m instanceof Control) {
            Control c = (Control) m;
            try {
                if ( mode == Action.POST ) {

                    String pname1 = "";


                    if (m.getParent() instanceof EditableGrid) {
                        int n = ((EditableGrid)m.getParent()).getCurrentRowNumber();
                        pname1 = pname+"_"+n;
                    } else {
                        pname1 = pname;
                    }

                    c.setValuesFromRequest( page.getHttpPostParams().getParameterValues( pname1 ) );

                    //c.setValuesFromRequest( page.getHttpPostParams().getParameterValues( pname ) );

                    //System.out.println("AAAAAAAAAAA["+c.getName()+"]["+pname1+"]["+page.getHttpPostParams().getParameterValues( pname1 )+"]");
                    /*int n = -1;
                    if (m.getParent() instanceof EditableGrid) { n = ((EditableGrid)m.getParent()).getCurrentRowNumber(); }
                    String[] vals = null;
                    if (n>0) { 
                        vals = page.getHttpPostParams().getParameterValues( pname+"_"+n );
                    } else {
                        vals = page.getHttpPostParams().getParameterValues( pname );
                    }*/

                    //String[] vals = page.getHttpPostParams().getParameterValues( pname );
                    String[] vals = page.getHttpPostParams().getParameterValues( pname1 );

                    if (vals == null || vals.length <= 0) {
                        c.setEmpty(true);
                    } else {
                        c.setEmpty(false);

                    }

                } else {
                    c.setValuesFromRequest( page.getHttpGetParams().getParameterValues( pname ) );

                    /*int n = -1;
                    if (m.getParent() instanceof EditableGrid) {
                        n = ((EditableGrid)m.getParent()).getCurrentRowNumber();
                    }

                    String[] vals = null;

                    if (n>0) {
                        vals = page.getHttpPostParams().getParameterValues( pname+"_"+n );
                    } else {
                        vals = page.getHttpPostParams().getParameterValues( pname );
                    }*/

                    String[] vals = page.getHttpPostParams().getParameterValues( pname );

                    if (vals != null && vals.length > 0) {
                        c.setEmpty(false);
                    } else {
                        c.setEmpty(true);
                    }

                }
            } catch ( java.text.ParseException pe ) {
                if ( ! c.hasErrorByType( ControlErrorTypes.getErrorType( ControlErrorTypes.FORMAT_ERROR ) ) ) {
                    String errMsg = null;
                    if (c.getType() == ControlType.BOOLEAN || c.getType() == ControlType.DATE) {
                        MessageFormat fmt = new MessageFormat(res.getString("CCS_IncorrectFormat"));
                        if (StringUtils.isEmpty(c.getFormatPattern())) {
                            Format dfmt = null;
                            String pattern = "";
                            if (c.getType() == ControlType.DATE) {
                                dfmt = c.getPage().getCCSLocale().getDateFormat();
                            }
                            if (dfmt instanceof SimpleDateFormat) {
                                pattern = ((SimpleDateFormat) dfmt).toLocalizedPattern();
                            }
                            errMsg = fmt.format(new String[] {c.getCaption(), pattern});
                        } else {
                            errMsg = fmt.format(new String[] {c.getCaption(), c.getFormatPattern()});
                        }
                    } else {
                        MessageFormat fmt = new MessageFormat(res.getString("CCS_IncorrectValue"));
                        errMsg = fmt.format(new String[] {c.getCaption()});
                    }
                    c.addError(ControlErrorTypes.getErrorType(ControlErrorTypes.FORMAT_ERROR), errMsg);
                    if ( component instanceof Grid ) {
                        component.addError(errMsg);
                    }
                }
            }
        }    
    }

    /**
        Set component properties. These are control values as well as properties with set methods.
        @param model Component whose properties are about to be set.
        @param mode Which parameters to read. POST or GET.
        @see #POST
        @see #GET
    */
    public void setProperties(Component model, int mode) {
        setProperties(model, mode, false);
    }
    
    /**
        Set component properties. These are control values as well as properties with set methods.
        @param model Component whose properties are about to be set.
        @param mode Which parameters to read. POST or GET.
        @param onlyNonEditCtrls Set values for non-editable controls only
        @see #POST
        @see #GET
    */
    public void setProperties(Component model, int mode, boolean onlyNonEditCtrls ) {
        Enumeration getParams = page.getHttpGetParams().getParameterNames();
        String ccsForm = page.getHttpGetParams().getParameter( "ccsForm" );
        String fname = model.getName();
        int k;
        // Remove :Edit part to get real form name
        if ( ccsForm != null && (k = ccsForm.lastIndexOf(':')) != -1 ) {
          ccsForm = ccsForm.substring(0, k);
        }
        if ( ! StringUtils.isEmpty(ccsForm) ) {
            model.setProcessed(fname.equals( ccsForm ));
        }

        //set components properties
        if ( mode == Action.GET ) {
            if (model instanceof Report) {
                ((Report) model).setViewMode(page.getParameter("ViewMode"));
            }
            while (getParams.hasMoreElements()) {
                String pname = (String) getParams.nextElement();
                if (pname.startsWith(fname)) {
                    String cname = pname.substring(fname.length());
                    setBeanProperty(model, cname, pname);
                } 
            }
        }
        Collection children = model.getChildren();


        //This binding working only for EG.
        if ( model.isProcessed() && mode == Action.POST ) {  //model.isProcessed() work only for FORMS! I.E. EG, Record.
            String formState = page.getHttpPostParams().getParameter( "FormState" );
            if ( ! StringUtils.isEmpty(formState) ) {
                model.setFormState(formState);
            }
    
            //set controls collection
            ArrayList rows = model.getChildRows();
            int pageSize = model.getPageSize();
            if ( model instanceof EditableGrid ) {
                pageSize = (int) ((EditableGrid) model).getNumberOfRows();
                pageSize += ((EditableGrid) model).getNumberEmptyRows();
            }
            MessageFormat fmtErrFmt = new MessageFormat(res.getString("CCS_IncorrectFormat"));
            MessageFormat fmtErrVal = new MessageFormat(res.getString("CCS_IncorrectValue"));
    
            for ( int i = 0; i < pageSize; i++ ) { //Works only for EG. I.E. pageSize > 0 only for EG.
                Iterator components = children.iterator();
                boolean isEmpty = true;
                boolean isNew = false;
                HashMap row = null;
                if ( i < rows.size() ) {
                    row = (HashMap) rows.get(i);
                }
                if ( row == null ) {
                    row = new HashMap();
                    isNew = true;
                }
                while ( components.hasNext() ) {
                    Model m = (Model) components.next();
                    String pname = m.getName() + "_" + String.valueOf(i+1);
                    Control c = null;
                    String[] paramValues = null;
                    if ( mode == Action.POST ) {
                        paramValues = page.getHttpPostParams().getParameterValues( pname );
                    } else {
                        paramValues = page.getHttpGetParams().getParameterValues( pname );
                    }

//System.out.println("zzzzzzzzzzzzz["+pname+"]["+paramValues+"]");

                    if ( paramValues != null ) {
                        if ( m instanceof Control ) {
                            c = (Control) ((Control) m).clone();
                        }
                        if ( c != null ) {
                            isEmpty = false;
                            try {
                                c.setHtmlName(pname);
                                c.setValuesFromRequest( paramValues );
                            } catch ( java.text.ParseException pe ) {
                                if ( ! c.hasErrorByType( 
                                        ControlErrorTypes.getErrorType( ControlErrorTypes.FORMAT_ERROR ) ) ) {
                                            
                                    String errMsg = null;
                                    if (c.getType() == ControlType.BOOLEAN || c.getType() == ControlType.DATE) {
                                        errMsg = fmtErrFmt.format(new String[] {c.getCaption(), c.getFormatPattern()});
                                    } else {
                                        errMsg = fmtErrVal.format(new String[] {c.getCaption()});
                                    }
                                    c.addError(ControlErrorTypes.getErrorType( ControlErrorTypes.FORMAT_ERROR ), errMsg);
                                }
                            } // end catch
                            row.put( c.getName(), c );
                        } // end if ( c!=null )
                    } // end parameter != null
                    else {
                        row.remove ( m.getName() );
                    } 
                } // end while by components
                if ( ! isEmpty ) {
                    if ( isNew ) {
                        model.addChildRow( row );
                    }
                }
//System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhh["+row+"]");
            } // end for
        }
        //set controls in model
        if (model instanceof EditableGrid) {
            Iterator components = ((EditableGrid) model).getStaticControls().iterator();
            while ( components.hasNext() ) {
                String name = (String) components.next();

                Model m = model.getChild(name);

                if (onlyNonEditCtrls) {
                    if (model.isProcessed()) {
                        if (m instanceof Control && !(m instanceof VerifiableControl)) {
                            setControlValue(m, m.getName(), mode, model);
                        }
                    } else {
                        setControlValue(m, m.getName(), mode, model);
                    }
                } else {
                    setControlValue(m, m.getName(), mode, model);
                }
            } // end while by components
        } else { //Here bind Record and all not forms components.
            Iterator components = children.iterator();
            while ( components.hasNext() ) {
                Model m = (Model) components.next();
                if (onlyNonEditCtrls) {
                    if (model.isProcessed()) {
                        if (m instanceof Control && !(m instanceof VerifiableControl)) {
                            setControlValue(m, m.getName(), mode, model);
                        }
                    } else {
                        setControlValue(m, m.getName(), mode, model);
                    }
                } else {
                    setControlValue(m, m.getName(), mode, model);
                }
            } // end while by components
        }

    }
    
    private Method getSetMethod(Model model, String prop)
            throws NoSuchMethodException {
        String methodName = "set"
            + prop.substring(0,1).toUpperCase()
            + prop.substring(1);
        return model.getClass().getMethod(methodName, new Class[] {String.class});
    }

    /** Check if the logged user has sufficient rights **/
    protected boolean authorized (String[] groups) {
       if (req.getSession().getAttribute("") != null) {
           if (groups.length > 0) {
               String group = req.getSession().getAttribute("").toString();
               if (group != null) {
                  for (int i=0; i<groups.length; i++) {
                      if (group.equals(groups[i])) return true;
                  }
               }
           } else {
               return true;
           }
       }
       return false;
    }

    protected boolean authorized (int[] groups) {
       if (req.getSession().getAttribute("") != null) {
           if (groups.length > 0) {
               String group = req.getSession().getAttribute("").toString();
               int groupId = Integer.MIN_VALUE;
               try {
                    groupId = Integer.parseInt( group );
               } catch ( NumberFormatException nfe ) {
                    return false;
               }
               boolean levelInclusion = false;
               String siteLevelInclusion = null;
               Properties siteProps = (Properties) ContextStorage.getInstance()
                    .getAttribute( Names.SITE_PROPERTIES_KEY );
               if ( siteProps != null ) 
                    siteLevelInclusion = (String) siteProps.get( "levelInclusion" );
               levelInclusion = Boolean.valueOf( siteLevelInclusion ).booleanValue();
               for (int i=0; i<groups.length; i++) {
                    if ( levelInclusion ) {
                        if (groupId >= groups[i] ) return true;
                    } else {
                        if (groupId == groups[i] ) return true;
                    }    
               }
           } else {
               return true;
           }
       }
       return false;
    }

    protected boolean authorized( Page page ) {
        return (authorizedWithCode(page)==null);
    }
    
    protected String authorizedWithCode(Page page) {
        String errorCode = null;
        if ( page.isRestricted() ) {
            errorCode = "notLogged";
            boolean allowAccess = false;
            Authenticator auth = AuthenticatorFactory.getAuthenticator( req );
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

    /**
     *  Set allow properties in model 
     *  @param model Component model (that is Record or EditableGrid)
     *         whose allow properties should be set.
     **/
    private void setActivePermissions( IRecord model ) {

        if ( model.isRestricted() ) {
            Authenticator auth = AuthenticatorFactory.getAuthenticator( req );
            if ( auth.getUserPrincipal() != null ) {
                Permission p = model.getPermissions();
                if ( p != null && p.isUseGroup() ) {
                    model.setAllowRead(isAllowPermission(p, auth, model.isAllowRead(), Permission.ALLOW_ACCESS));
                    model.setAllowInsert(isAllowPermission(p, auth, model.isAllowInsert(), Permission.ALLOW_INSERT));
                    model.setAllowUpdate(isAllowPermission(p, auth, model.isAllowUpdate(), Permission.ALLOW_UPDATE));
                    model.setAllowDelete(isAllowPermission(p, auth, model.isAllowDelete(), Permission.ALLOW_DELETE));
                }
            } else {
                model.setAllowRead( false );
                model.setAllowInsert( false );
                model.setAllowUpdate( false );
                model.setAllowDelete( false );
            }
            model.setVisible(model.isAllowRead() || model.isAllowInsert() || 
                    model.isAllowUpdate() || model.isAllowDelete());
        }

    }

    private boolean isAllowPermission(Permission p, Authenticator auth, boolean permissionValue, int permissionType) {
        boolean allowPermission = false;
        String[] groups = p.getGroupsIdByPermission( permissionType );
        if ( groups != null && groups.length > 0 ) {
            for ( int i = 0; i < groups.length; i++ ) {
                if ( auth.isUserInRole( groups[i] ) ) {
                    allowPermission = true;
                    break;
                }
            }
        }         
        return (allowPermission & permissionValue);           
    }

    public void setActivePermissions( Record model ) {
        setActivePermissions((IRecord) model);
    }
        
    public void setActivePermissions( EditableGrid model ) {
        setActivePermissions((IRecord) model);
    }

    /**
     *  Set allow properties in model 
     *  @param model Component model (that is Grid, Path, Directory or Page)
     *         whose allow properties should be set.
     **/
    public void setActivePermissions( Component model ) {

        Authenticator auth = AuthenticatorFactory.getAuthenticator( req );
        if ( model.isRestricted() ) {
            model.setVisible( false );
            if ( auth.getUserPrincipal() != null ) {
                Permission p = model.getPermissions();
                if ( p != null && p.isUseGroup() ) {
                    String[] groups = p.getGroupsIdByPermission( Permission.ALLOW_ACCESS );
                    if ( groups != null && groups.length > 0 ) {
                        for ( int i = 0; i < groups.length; i++ ) {
                            if ( auth.isUserInRole( groups[i] ) ) {
                                model.setVisible( true );
                                break;
                            }
                        }
                    }                    
                }
            }
        }
    }

    public Control bindControlValue(Component model, HashMap hashRow, String controlName, Object value) {
        Control c = (Control) hashRow.get(controlName);
        if ( c == null ) { 
            c = (Control) model.getControl(controlName).clone();
            c.setValue(value);
            hashRow.put( c.getName(), c );
        }
        return c;
    }
    
    public static PageSettings getCachingSettings(String pageName) {
        PageSettings pageSettings = CacheConfigurator.getPageSettings(pageName);
        if (pageSettings == null || !pageSettings.isCacheEnabled()) {
            return null;
        }
        return pageSettings;
    }
/*   
    public static void setCachingParameters(String pageName, ServletRequest req) {
        CCLogger.getInstance().debug("Action.setCachingParameters is started. PageName: "+pageName);
        PageSettings pageSettings = Action.getCachingSettings(pageName);
        if (pageSettings == null) {
            CCLogger.getInstance().debug("Action.setCachingParameters => pageSettings not found.");
            return;
        }
        Iterator params = pageSettings.getParameters();
        while (params.hasNext()) {
            CachingParameter param = (CachingParameter) params.next();
            CCLogger.getInstance().debug("Action.setCachingParameters process parameter: "+param.getName());
            if (param.getSourceType() == ParameterSource.URL) {
                param.setValues(req.getParameterValues(param.getName()));
            } else if (param.getSourceType() == ParameterSource.FORM) {
                param.setValues(req.getParameterValues(param.getName()));
            } else if (param.getSourceType() == ParameterSource.SESSION) {
                param.setValue(Utils.convertToString(((HttpServletRequest) req).getSession().getAttribute(param.getName())));
            }
            CCLogger.getInstance().debug(param.toString());
        }
        CCLogger.getInstance().debug("Action.setCachingParameters is finished.");
    }    
*/    
    private static Map getMap(String key, ServletRequest req) {
        Map result = (Map) req.getAttribute(key);
        if (result == null) {
            result = new HashMap();
            req.setAttribute(key, result);
        }
        return result;
    } 
    
    public static Map getCachingParameters(int parametersType, ServletRequest req) {
        Map params = null;
        switch (parametersType) {
            case CachingParameter.TARGET_CACHING_KEY:
                params = getMap(CachingParameter.CACHING_KEY_PARAMS, req);
            case CachingParameter.TARGET_DISABLE_CACHING:
                params = getMap(CachingParameter.DISABLE_CACHING_PARAMS, req);
            case CachingParameter.TARGET_CLEAR_CACHE:
                params = getMap(CachingParameter.CLEAR_CACHE_PARAMS, req);
        }
        return params;
    }
    
    public static boolean isCachingEnabled(PageSettings pageSettings, ServletRequest req, ServletResponse resp, ICache cache) {
        CacheEvent cacheEvent = new CacheEvent(((HttpServletRequest) req), ((HttpServletResponse) resp), pageSettings);
        cacheEvent.setCacheOperation(ICache.OPERATION_GET);
        pageSettings.fireOnCacheEvent(cacheEvent);
        
        if (isCacheClear(pageSettings, req)) {
            cache.clearStartedWith(pageSettings.getName());
        }

        if (! pageSettings.isCacheEnabled() || isCacheDisable(pageSettings, req)) {
            return false;
        }
        return true;
    }

    private static boolean isCacheClear(PageSettings pageSettings, ServletRequest req) {
        Iterator params = pageSettings.getClearParameters();
        return isParametersSet(params, req);
    }
    
    private static boolean isCacheDisable(PageSettings pageSettings, ServletRequest req) {
        Iterator params = pageSettings.getDisableParameters();
        return isParametersSet(params, req);
    }

    private static boolean isParametersSet(Iterator params, ServletRequest req) {
        if (params == null || ! params.hasNext()) {
            return false;
        }
        while (params.hasNext()) {
            CachingParameter param = (CachingParameter) params.next();
            String[] values = Action.getCachingParameterValues(param, (HttpServletRequest) req);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    if (! StringUtils.isEmpty(values[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static String[] getCachingParameterValues(CachingParameter param, HttpServletRequest req) {
        CCLogger.getInstance().debug("Action.setCachingParameters process parameter: "+param.getName());
        Map paramsValues = Action.getCachingParameters(param.getType(), req);
        String[] values = (String[]) paramsValues.get(param.getName());
        if (values == null) {
            if (param.getSourceType() == ParameterSource.URL) {
                values = req.getParameterValues(param.getName());
            } else if (param.getSourceType() == ParameterSource.FORM) {
                values = req.getParameterValues(param.getName());
            } else if (param.getSourceType() == ParameterSource.SESSION) {
                values = new String[]{Utils.convertToString(req.getSession().getAttribute(param.getName()))};
            }
            if (values != null) {
                paramsValues.put(param.getName(), values);
            }
        }
        return values;
    }

    /*public static String getParametersKey(PageSettings pageSettings, String encoding, HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        if (pageSettings != null) {
            Iterator params = pageSettings.getKeyParameters();
            boolean first = true;
            while (params.hasNext()) {
                CachingParameter param = (CachingParameter) params.next();
                if (!first) {
                    sb.append("&");
                }
                try {
                    String[] values = param.getValues();
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            if (! StringUtils.isEmpty(values[i])) {
                                if (i > 0) {
                                    sb.append("&");
                                }
                                sb.append(URLEncoder
                                        .encode(param.getName() + "=" + values[i], encoding));
                            }
                        }
                        if (first) {
                            first = false;
                        }
                    }
                } catch (UnsupportedEncodingException uee) {
                }
            }
        }
        //add fixed CCS parameters LocaleID & Style
        String localeParameter = LocaleChooser.getLocaleParameter(request);
        if (! StringUtils.isEmpty(localeParameter)) {
            sb.append("&" + localeParameter);
        }
        String ccsStyle = StyleChooser.getStyleParameter(request);
        if (! StringUtils.isEmpty(ccsStyle)) {
            sb.append("&" + ccsStyle);
        }
        return sb.toString();
    }*/
    
    public static ICache getCacheInstance() {
        return (ICache) ContextStorage.getContext().getAttribute(Names.CACHE_INSTANCE);
    }
    
    public static String getCachedPage(String pageName, ServletRequest req, ServletResponse resp) {
        ICache cache = getCacheInstance();
        CCLogger.getInstance().debug("Action.getCachedPage starts. PageName: "+pageName);
        PageSettings pageSettings = Action.getCachingSettings(pageName);
        boolean enableCaching = true;
        boolean useCache = true;
        if (pageSettings == null) {
            useCache = false;
        }
        System.out.println("useCache: "+useCache);
        if (useCache) {
            //setCachingParameters(pageName, req);
            if (! Action.isCachingEnabled(pageSettings, req, resp, getCacheInstance())) {
                enableCaching = false;
                useCache = false;
            }
        }

        if (useCache) {
            Object cachedObject = cache.getObject(cache.getCacheKey(pageName, req));
            if (cachedObject != null) {
                return cachedObject.toString();
            }
        }        
        
        return null;
    }
/*
    public static String getCacheKey(String pageName, ServletRequest req) {
        String parametersKey = getParametersKey(Action.getCachingSettings(pageName), "ISO-8859-1", (HttpServletRequest) req);
        return pageName + (StringUtils.isEmpty(parametersKey) ? "" : "?" + parametersKey);
    }
*/    
    public String getCachedPage(String pageName) {
        return Action.getCachedPage(pageName, this.req, this.resp);
    }
    
    public static final int ALLOW_NOTHING = 0;
    public static final int ALLOW_READ = 1;
    public static final int ALLOW_UPDATE = 2;
    public static final int ALLOW_CREATE = 4;
    public static final int ALLOW_INSERT = 4;
    public static final int ALLOW_DELETE = 8;
    public static final int ALLOW_FULL = ALLOW_READ+ALLOW_UPDATE+ALLOW_CREATE+ALLOW_DELETE;
}




//End Action class

