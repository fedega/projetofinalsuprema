//AbstractProcessor class: head @0-AC769046
/* 
 * $Revision: 1.6 $
 * $Date: 2005/01/04 07:58:13 $
 */
package com.codecharge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.servlet.http.Cookie;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.codecharge.components.CachedColumn;
import com.codecharge.components.CheckBox;
import com.codecharge.components.Component;
import com.codecharge.components.Control;
import com.codecharge.components.ControlType;
import com.codecharge.components.EditableGrid;
import com.codecharge.components.FileUpload;
import com.codecharge.components.Grid;
import com.codecharge.components.IRecord;
import com.codecharge.components.Link;
import com.codecharge.components.Model;
import com.codecharge.components.Page;
import com.codecharge.components.Record;
import com.codecharge.components.Report;
import com.codecharge.components.ReportLabel;
import com.codecharge.components.VerifiableControl;
import com.codecharge.db.Command;
import com.codecharge.db.SPCommand;
import com.codecharge.db.DbRow;
import com.codecharge.db.FieldOperation;
import com.codecharge.db.IDataBinder;
import com.codecharge.db.JDBCConnection;
import com.codecharge.db.JDBCConnectionFactory;
import com.codecharge.db.OracleSPCommand;
import com.codecharge.db.ParameterSource;
import com.codecharge.db.RawCommand;
import com.codecharge.db.SPParameter;
import com.codecharge.db.SqlCommand;
import com.codecharge.db.SqlParameter;
import com.codecharge.db.SqlParameters;
import com.codecharge.db.WhereBuilder;
import com.codecharge.util.Authenticator;
import com.codecharge.util.AuthenticatorFactory;
import com.codecharge.util.CCLogger;
import com.codecharge.util.ContextStorage;
import com.codecharge.util.Permission;
import com.codecharge.util.SessionStorage;
import com.codecharge.util.StringUtils;
import com.codecharge.util.Utils;
import com.codecharge.util.LinkParameter;
import com.codecharge.util.ModelAttribute;
import com.codecharge.validation.ControlErrorTypes;
import com.codecharge.validation.ErrorCollection;

public abstract class AbstractProcessor implements IDataBinder {

  protected Element elm;
  protected Model model;
  protected Page page;
  private CCLogger logger = CCLogger.getInstance();
  protected Format defaultBooleanFormat;
  protected Format defaultDateFormat;

  protected DbRow outDbParameters = new DbRow();

  public AbstractProcessor(Element elm, Model model, Page page) {
    this.elm = elm; 
    this.model = model; 
    this.page = page;
    if (this.model instanceof Component) {
        ((Component) this.model).setPageModel(page);
    }
  }

  public abstract void process();
  //protected abstract void select();
  //protected abstract void bind();


    private void setParameter(SqlParameter param, Component model, HashMap row) throws ParseException {
      ParameterSource source = param.getSourceType();
      if (source == ParameterSource.CONTROL) {
        if (row == null) {
          param.setValue( ((Control)model.getChild(param.getSourceName())).getValue() );
        } else {
          param.setValue( ((Control)row.get(param.getSourceName())).getValue() );
        }
      } else if (source == ParameterSource.URL) {
            //param.setValue(page.getHttpGetParams().getParameter(param.getSourceName()));
            param.setValues (page.getHttpGetParams().getParameterValues(param.getSourceName()) );
      } else if (source == ParameterSource.FORM) {
            //param.setValue(page.getHttpPostParams().getParameter(param.getSourceName()));
            param.setValues (page.getHttpPostParams().getParameterValues(param.getSourceName()) );
      } else if (source == ParameterSource.SESSION) {
            param.setValue(SessionStorage.getInstance(page.getRequest()).getAttribute(param.getSourceName()));
      } else if (source == ParameterSource.APPLICATION) {
            param.setValue(ContextStorage.getInstance().getAttribute(param.getSourceName()));
      } else if (source == ParameterSource.COOKIE) {
            Cookie[] cookies = page.getRequest().getCookies();
            if (cookies != null) {
                for (int i =0; i<cookies.length; i++) {
                    if (param.getSourceName().equals(cookies[i].getName())) {
                        param.setValue(cookies[i].getValue());
                        break;
                    }
                }
            }
      } else if (source == ParameterSource.CACHED) {
          if (model instanceof EditableGrid) {
              Collection cols = (Collection)row.get(Names.CCS_CACHED_COLUMNS);
              for (Iterator i = cols.iterator(); i.hasNext(); ) {
                CachedColumn col = (CachedColumn)i.next();
                if (col.getField().equals(param.getSourceName())) {
                  param.setValue(col.getValue());
                  break;
                }
              }
          }
      } else if (source == ParameterSource.CALENDARSPECIALVALUE) {
         if ("DateRange".equals (param.getSourceName() ) ) {
            param.setValues( new Object[] {((com.codecharge.components.Calendar)model).getCorrectedStartDate(), ((com.codecharge.components.Calendar)model).getCorrectedEndDate()} );
         } else if ( "StartDate".equals (param.getSourceName() )  ) {
            param.setObjectValue( ((com.codecharge.components.Calendar)model).getCorrectedStartDate()  );
         } else if ( "EndDate".equals (param.getSourceName() )  ) {
            param.setObjectValue( ((com.codecharge.components.Calendar)model).getCorrectedEndDate() );
         }
      }

    }
    /** Create new SqlParameter object from information of WhereParameter element of XML Model. **/
    private SqlParameter getWhereParameter(Element p) {
      SqlParameter param = new SqlParameter(page.getCCSLocale());
      param.setName(p.getAttribute("name"));
      param.setOperation(FieldOperation.getFieldOperation(p.getAttribute("operation")));
      param.setUseIsNull(new Boolean(p.getAttribute("useIsNull")).booleanValue());
      param.setField(p.getAttribute("field"));
      param.setType(ControlType.getControlType(p.getAttribute("type")));
      if (param.getType() == ControlType.MEMO) param.setType(ControlType.TEXT);
      param.setSourceType(ParameterSource.getParameterSource(p.getAttribute("sourceType")));
      param.setSourceName(p.getAttribute("sourceName"));
      param.setFormatPattern(p.getAttribute("format"));
      param.setDbFormatPattern(p.getAttribute("dbFormat"));
      return param;
    }
    protected Collection getWhereParameters(Collection paramsList, Component model) {
      ArrayList params = new ArrayList();
      if (paramsList == null) return params;
      for (Iterator i=paramsList.iterator(); i.hasNext(); ) {
        Element elm = (Element)i.next();
        SqlParameter parameter = getWhereParameter(elm);
        try {
          setParameter(parameter, model, null);
        } catch (ParseException pe) {
          logger.error("Unable to set "+parameter.getName()+" parameter value");
        }
        params.add(parameter);
      }
      return params;
    }
    protected Collection getWhereParameters(Collection paramsList, Component model, HashMap row) {
      ArrayList params = new ArrayList();
      if (paramsList == null) return params;
      for (Iterator i=paramsList.iterator(); i.hasNext(); ) {
        Element elm = (Element)i.next();
        SqlParameter parameter = getWhereParameter(elm);
        try {
          setParameter(parameter, model, row);
        } catch (ParseException pe) {
          logger.error("Unable to set "+parameter.getName()+" parameter value");
        }
        params.add(parameter);
      }
      return params;
    }


    /** Create new SqlParameter object from information of SqlParameter element of XML Model. **/
    private SqlParameter getSqlParameter(Element p) {
      SqlParameter param = new SqlParameter(page.getCCSLocale());
      param.setName(p.getAttribute("name"));
      param.setType(ControlType.getControlType(p.getAttribute("type")));
      param.setSourceType(ParameterSource.getParameterSource(p.getAttribute("sourceType")));
      param.setSourceName(p.getAttribute("sourceName"));
      param.setFormatPattern(p.getAttribute("format"));
      param.setDbFormatPattern(p.getAttribute("dbFormat"));
      param.setField(p.getAttribute("fieldSource"));
      if ("True".equals (p.getAttribute("omitIfEmpty"))) {
        param.setOmitIfEmpty(true);
      } else {
        param.setOmitIfEmpty(false);
      }
      return param;
    }

    protected Collection getSqlParameters(Collection paramsList, Component model) {
      ArrayList params = new ArrayList();
      if (paramsList == null) return params;
      for (Iterator i=paramsList.iterator(); i.hasNext(); ) {
        Element elm = (Element)i.next();
        SqlParameter parameter = getSqlParameter(elm);
        try {
          setParameter(parameter, model, null);
        } catch (ParseException pe) {
          logger.error("Unable to set "+parameter.getName()+" parameter value");
        }
        params.add(parameter);
      }
      return params;
    }


    protected Collection getSqlParameters(Collection paramsList, Component model, HashMap row) {
      ArrayList params = new ArrayList();
      if (paramsList == null) return params;
      for (Iterator i=paramsList.iterator(); i.hasNext(); ) {
        Element elm = (Element)i.next();
        SqlParameter parameter = getSqlParameter(elm);
        try {
          //parameter.setValue(((Control)row.get(parameter.getSourceName())).getObjectValue());
          setParameter(parameter, model, row);
        } catch (ParseException pe) {
          logger.error("Unable to set "+parameter.getName()+" parameter value");
        }
        params.add(parameter);
      }
      return params;
    }
    private int getSpType(String type) {
      if (type == null) {
        return java.sql.Types.OTHER;
      } else if (type.equals("BigInt")) {
        return java.sql.Types.BIGINT;
      } else if (type.equals("Bit")) {
        return java.sql.Types.BIT;
      } else if (type.equals("Char")) {
        return java.sql.Types.CHAR;
      } else if (type.equals("Date")) {
        return java.sql.Types.DATE;
      } else if (type.equals("DateTime")) {
        return java.sql.Types.TIMESTAMP;
      } else if (type.equals("Decimal")) {
        return java.sql.Types.DECIMAL;
      } else if (type.equals("Double")) {
        return java.sql.Types.DOUBLE;
      } else if (type.equals("Int")) {
        return java.sql.Types.INTEGER;
      } else if (type.equals("NChar")) {
        return java.sql.Types.VARCHAR;
      } else if (type.equals("NText")) {
        return java.sql.Types.VARCHAR;
      } else if (type.equals("Numeric")) {
        return java.sql.Types.NUMERIC;
      } else if (type.equals("NVarChar")) {
        return java.sql.Types.VARCHAR;
      } else if (type.equals("Real")) {
        return java.sql.Types.FLOAT;
      } else if (type.equals("SmallDateTime")) {
        return java.sql.Types.TIMESTAMP;
      } else if (type.equals("SmallInt")) {
        return java.sql.Types.SMALLINT;
      } else if (type.equals("TinyInt")) {
        return java.sql.Types.TINYINT;
      } else if (type.equals("Text")) {
        return java.sql.Types.VARCHAR;
      } else if (type.equals("Time")) {
        return java.sql.Types.TIME;
      } else if (type.equals("VarChar")) {
        return java.sql.Types.VARCHAR;
      } else if (type.equals("OracleCursor")) {
        return OracleSPCommand.ORACLE_CURSOR;
      } else {
        return java.sql.Types.OTHER;
      }
    }
    /** Create new SPParameter object from information of SPParameter element of XML Model. **/
    protected SPParameter getSpParameter(Element p) {
      SPParameter param = new SPParameter();
      param.setName(p.getAttribute("name"));
      param.setSourceType(ParameterSource.getParameterSource(p.getAttribute("sourceType")));
      param.setSourceName(p.getAttribute("sourceName"));
      param.setFormatPattern(p.getAttribute("format"));
      param.setDbFormatPattern(p.getAttribute("dbFormat"));
      param.setType(getSpType(p.getAttribute("type")));
      String dir = p.getAttribute("direction");
      if (dir.equalsIgnoreCase("input")) {
        param.setDirection(SPParameter.INPUT_PARAMETER);
      } else if (dir.equalsIgnoreCase("output")) {
        param.setDirection(SPParameter.OUTPUT_PARAMETER);
      } else if (dir.equalsIgnoreCase("returnvalue")) {
        param.setDirection(SPParameter.OUTPUT_PARAMETER);
      } else if (dir.equalsIgnoreCase("inputoutput")) {
        param.setDirection(SPParameter.INPUT_OUTPUT_PARAMETER);
      }
      try {
        param.setDataSize(Integer.parseInt(p.getAttribute("dataSize")));
      } catch (NumberFormatException nfe) {
        param.setDataSize(0);
      }
      try {
        param.setScale(Integer.parseInt(p.getAttribute("scale")));
      } catch (NumberFormatException nfe) {
        param.setScale(0);
      }
      return param;
    }
    protected Collection getSpParameters(Collection paramsList, Component model) {
      ArrayList params = new ArrayList();
      if (paramsList == null) return params;
      for (Iterator i=paramsList.iterator(); i.hasNext(); ) {
        Element elm = (Element)i.next();
        SPParameter parameter = getSpParameter(elm);
        try {
          setParameter(parameter, model, null);
        } catch (ParseException pe) {
          logger.error("Unable to set "+parameter.getName()+" parameter value");
        }
        params.add(parameter);
      }
      return params;
    }
    protected Collection getSpParameters(Collection paramsList, Component model, HashMap row) {
      ArrayList params = new ArrayList();
      if (paramsList == null) return params;
      for (Iterator i=paramsList.iterator(); i.hasNext(); ) {
        Element elm = (Element)i.next();
        SPParameter parameter = getSpParameter(elm);
        try {
          setParameter(parameter, model, row);
        } catch (ParseException pe) {
          logger.error("Unable to set "+parameter.getName()+" parameter value");
        }
        params.add(parameter);
      }
      return params;
    }
    /** Process parenthesis part of the where expression reqursively. **/
    private void bracket(Element elm, Vector clause) {
      NodeList elms = elm.getChildNodes();
      //NodeList elms = elm.getElementsByTagName("*");
      for (int i=0; i<elms.getLength(); i++) {
        Node node = elms.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element part = (Element)node;
          //Element part = (Element)elms.item(i);
          if (part.getTagName().equals("Bracket")) {
            clause.add("(");
            bracket(part, clause);
            clause.add(")");
          } else {
            if (part.getTagName().equals("Parameter")) {
              clause.add(part.getAttribute("name"));
            } else if (part.getTagName().equals("Operation")) {
              clause.add(part.getAttribute("operator").toUpperCase());
            } else if (part.getTagName().equals("Expression")) {
              clause.add(part.getAttribute("expression"));
            }
          }
        }
      }
    }
    /** Construct array of where clause where each element is bracket, operand or operator. **/
    protected String[] getWhereClause(Element elm) {
      if (elm == null) return new String[] {};
      Vector clause = new Vector();
      Element elmClause = (Element)elm.getElementsByTagName("WhereClause").item(0);
      bracket(elmClause, clause);
      return (String[])clause.toArray(new String[clause.size()]);
    }

  /** Find First Child Element of the given Element with the specified TagName. **/
  protected Element getFirstChildElementByName(Element elm, String name){
    NodeList children = elm.getChildNodes();
    for (int i=0; i<children.getLength(); i++) {
      Node n = children.item(i);
      if (n.getNodeType() == Node.ELEMENT_NODE) {
        if (n.getNodeName().equals(name)) {
          return (Element)n;
        }
      }
    }
    return null;
  }
  /** Find all Children Elements of the given Element with the specified TagName. **/
  protected Collection getChildrenElementsByName(Element elm, String name) {
    ArrayList list = new ArrayList();
    NodeList children = elm.getChildNodes();
    for (int i=0; i<children.getLength(); i++) {
      Node n = children.item(i);
      if (n.getNodeType() == Node.ELEMENT_NODE) {
        if (n.getNodeName().equals(name)) {
          list.add(n);
        }
      }
    }
    return list;
  }






    private void setActivePermissions( IRecord model ) {

        if ( model.isRestricted() ) {
            Authenticator auth = AuthenticatorFactory.getAuthenticator( page.getRequest() );
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

        Authenticator auth = AuthenticatorFactory.getAuthenticator( page.getRequest() ); 
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


    /**
     *  Call OnValidate control handlers.
     *  @param model Record form model to be validated
     *  @return true if validation is succesfull, false otherwise
     */
    protected boolean validate( Element elm, Component model ) {
        logger.debug("PageController.validate() started");
        boolean controlError = false;
        boolean isValid = true;
        if (model instanceof Record) ((Record)model).fireOnValidateEvent();
        else if (model instanceof EditableGrid) {
            ((EditableGrid)model).fireOnValidateEvent();
            ((EditableGrid)model).checkUnique();
        }
        if (model instanceof EditableGrid) {
          model.initializeRows();
          while(model.hasNextRow()) {
            HashMap row = model.nextRow();
            HashMap errorCollections = new HashMap();
            if (row.get(Names.CCS_ROW_IS_NOT_APPLY_KEY) == null && row.get(Names.CCS_ROW_IS_DELETE_KEY) == null) {
              ((EditableGrid)model).fireOnValidateRowEvent();
              for (Iterator controls = model.getChildren().iterator(); controls.hasNext();) {

                Object control = row.get(((Model)controls.next()).getName());
                if (control instanceof VerifiableControl ) {
                  ((VerifiableControl)control).validate();//fireOnValidateEvent();
                  if (((Control)control).hasErrors()) {
                    controlError = true;

	            VerifiableControl vc = (VerifiableControl)control;
	            if (vc.getErrorControlName() != null && vc.getErrorControlName().length() > 0 ) {
	                ErrorCollection ec = (ErrorCollection) errorCollections.get(vc.getErrorControlName());
	                if (ec == null) {
	                    ec = new ErrorCollection();
	                    errorCollections.put(vc.getErrorControlName(),ec);
	                }
		
	                ec.addErrors(Utils.list(vc.getErrors()));
	            } else {
	                ((EditableGrid)model).addRowError(((VerifiableControl)control).getErrorsAsString());
	            }
	
                    isValid = false;
                  }
                }
              }
            }

            Iterator it = errorCollections.keySet().iterator();
            while (it.hasNext()) {
              String ecKey = (String)it.next();
              ErrorCollection ec = (ErrorCollection)errorCollections.get(ecKey);
              Control errorControl = model.getControl(ecKey);
              errorControl.setFormattedValue(errorControl.getFormattedValue() + ec.getErrorsAsString());
            }
          }

          if ( model.getChildren() != null ) {
            Iterator controls = model.getChildren().iterator();
            while ( controls.hasNext() ) {
              Model control = (Model) controls.next();
              if ( control instanceof com.codecharge.components.Captcha ) {
                ((com.codecharge.components.Captcha) control).fireOnValidateEvent();
              }
            }
	  }
          model.nullChildRow();
        } else {
            HashMap errorCollections = new HashMap();
            if ( model.getChildren() != null ) {
                Iterator controls = model.getChildren().iterator();
                ResourceBundle res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"));
                while ( controls.hasNext() ) {
                    Model control = (Model) controls.next();
                    if ( control instanceof VerifiableControl ) {
                        VerifiableControl vc = (VerifiableControl)control;
                        //vc.fireOnValidateEvent();
                        isValid = vc.validate() && isValid;
                        //vc.validate();
                        if (model instanceof Record && vc.isUnique()) {
                            if (checkUnique(elm, (Record)model, vc) > 0) {
                                MessageFormat msgfmt = new MessageFormat(res.getString("CCS_UniqueValue"));
                                vc.addError(msgfmt.format(new String[] {((Control)control).getCaption()}));
                            }
                        }
                        if (((Control)control).hasErrors()) {
                            controlError = true;
                            if (vc.getErrorControlName() != null && vc.getErrorControlName().length() > 0 ) {
                                ErrorCollection ec = (ErrorCollection) errorCollections.get(vc.getErrorControlName());
                                if (ec == null) {
                                    ec = new ErrorCollection();
                                    errorCollections.put(vc.getErrorControlName(),ec);
                                }
                                ec.addErrors(Utils.list(vc.getErrors()));
                            } else {
                                model.addError(vc.getErrorsAsString());
                            }
                       
                        }
                    } else if ( control instanceof com.codecharge.components.Captcha ) {
                    	((com.codecharge.components.Captcha) control).fireOnValidateEvent();
                    }
                }
            }
            Iterator it = errorCollections.keySet().iterator();
            while (it.hasNext()) {
                String ecKey = (String)it.next();
                ErrorCollection ec = (ErrorCollection)errorCollections.get(ecKey);
                Control errorControl = model.getControl(ecKey);
                errorControl.setFormattedValue(errorControl.getFormattedValue() + ec.getErrorsAsString());
            }

        
        }

        logger.debug("PageController.validate() finished with returnValue="+( ! (model.hasErrors() || controlError) ));
        logger.debug("model has errors:"+model.getErrorsAsString());
        return ( ! (model.hasErrors() || controlError) && isValid );
    }

    protected void setProperties(Component model, int mode ) {
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
        if ( mode == PageController.GET ) {
            if (model instanceof Report) {
                ((Report) model).setViewMode(page.getHttpGetParameter("ViewMode",""));
            }
            while (getParams.hasMoreElements()) {
                String pname = (String) getParams.nextElement();
                if (pname.startsWith(fname) && pname.length() > fname.length()) {
                    String cname = pname.substring(fname.length());
                    setBeanProperty(model, cname, pname);
                }
            }
        }
        Collection children = model.getChildren();

        if ( model.isProcessed() && mode == PageController.POST ) {
        String formState = page.getHttpPostParams().getParameter( "FormState" );
        if ( ! StringUtils.isEmpty(formState) ) {
            model.setFormState(formState);
        }

        //set controls collection
        ArrayList rows = model.getChildRows();
        int checknrows = 0;
        if (model instanceof EditableGrid) {
          checknrows = (int)((EditableGrid)model).getNumberOfRows();
          checknrows += ((EditableGrid)model).getNumberEmptyRows();
        }
        // TODO: For Grid we don't need setControlValue
        for ( int i = 0; i < checknrows; i++ ) {
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
                if ( mode == PageController.POST ) {
                    paramValues = page.getHttpPostParams().getParameterValues( pname );
                } else {
                    paramValues = page.getHttpGetParams().getParameterValues( pname );
                }
                if ( paramValues != null ) {
                    if ( m instanceof Control ) {
                        c = (Control) ((Control) m).clone();
                    }
                    if ( c != null ) {
                        isEmpty = false;
                        c.setHtmlName(pname);
                        try {
                            c.setValuesFromRequest( paramValues );
                        } catch ( java.text.ParseException pe ) {
                            if ( ! c.hasErrorByType(
                                    ControlErrorTypes.getErrorType( ControlErrorTypes.FORMAT_ERROR ) ) ) {
                  ResourceBundle res = ResourceBundle.getBundle("MessagesBundle");
                  MessageFormat fmtErrFmt = new MessageFormat(res.getString("CCS_IncorrectFormat"));
                  MessageFormat fmtErrVal = new MessageFormat(res.getString("CCS_IncorrectValue"));
                  String errMsg = null;
                  if (c.getType() == ControlType.BOOLEAN || c.getType() == ControlType.DATE) {
                    errMsg = fmtErrFmt.format(new String[] {c.getCaption(), c.getFormatPattern()});
                  } else {
                    errMsg = fmtErrVal.format(new String[] {c.getCaption()});
                  }
                                c.addError( ControlErrorTypes.getErrorType( ControlErrorTypes.FORMAT_ERROR ),
                                        errMsg);
                            }
                        } // end catch
                        row.put( c.getName(), c );
                    } // end if ( c!=null )
                } else {
                  if (m instanceof CheckBox && !m.getName().equals(((EditableGrid)model).getDeleteControlName())) {
                    isEmpty = false;
                    c = (Control) ((Control) m).clone();
                    c.setHtmlName(pname);
                    row.put( c.getName(), c );
                  }
                }// end parameter != null
            } // end while by components
            if ( ! isEmpty ) {
                if ( isNew ) {
                    model.addChildRow( row );
                }
            } else {
                if (i > ((EditableGrid)model).getNumberOfRows()) break;
            }
        } // end for
        }

        //set controls in model
        if (model instanceof Record || model instanceof Page) {
          Iterator components = children.iterator();
          while ( components.hasNext() ) {
              Model m = (Model) components.next();
              setControlValue(m, m.getName(), mode, model);
          } // end while by components
        }
    }
    private Method getSetMethod(Model model, String prop)
            throws NoSuchMethodException {
        String methodName = "set" +
                prop.substring(0,1).toUpperCase() +
                prop.substring(1);
        return model.getClass().getMethod( methodName, new Class[] {String.class} );
    }
    protected void setBeanProperty(Component model, String property, String parameter) {
        try {
            Method m = getSetMethod(model, property);
            //m.invoke(model, new String[] {page.getHttpGetParams().getParameter(parameter)});
            m.invoke(model, new Object[] {page.getHttpGetParams().getParameter(parameter)});
        } catch (NoSuchMethodException nsme) {
            // No method, no problem
        } catch (IllegalAccessException iae) {
            logger.error("Action::setProperties: Illegal Access", iae);
        } catch (InvocationTargetException ite) {
            logger.log(ite.getMessage(), ite);
        }
    }

    protected void setControlValue(Model c, String pname, int mode, Component component ) {
        //logger.debug("PageController.setControlValue: process parameter " + pname);
        if (c instanceof Control) {
            try {
                if ( mode == PageController.POST ) {
                    //logger.debug("PageController.setControlValue: set from POST " + page.getHttpPostParams().getParameter( pname ));
                    ((Control)c).setValuesFromRequest( page.getHttpPostParams().getParameterValues( pname ) );
                } else {
                    //logger.debug("PageController.setControlValue: set from GET " + page.getHttpGetParams().getParameter( pname ));
                    ((Control)c).setValuesFromRequest( page.getHttpGetParams().getParameterValues( pname ) );
                }
            } catch ( java.text.ParseException pe ) {
                if ( ! ((Control) c).hasErrorByType( ControlErrorTypes.getErrorType( ControlErrorTypes.FORMAT_ERROR ) ) ) {
                  ResourceBundle res = ResourceBundle.getBundle("MessagesBundle");
                  MessageFormat fmtErrFmt = new MessageFormat(res.getString("CCS_IncorrectFormat"));
                  MessageFormat fmtErrVal = new MessageFormat(res.getString("CCS_IncorrectValue"));
                  String errMsg = null;
                  if (((Control)c).getType() == ControlType.BOOLEAN || ((Control)c).getType() == ControlType.DATE) {
                    errMsg = fmtErrFmt.format(new String[] {((Control)c).getCaption(), ((Control)c).getFormatPattern()});
                  } else {
                    errMsg = fmtErrVal.format(new String[] {((Control)c).getCaption()});
                  }
                  ((Control) c).addError( ControlErrorTypes.getErrorType( ControlErrorTypes.FORMAT_ERROR ),
                          errMsg);
                  if ( component instanceof Grid ) {
                    component.addError( errMsg );
                  }
                }
            }
        }
    }
    private void setControlValue(Control ctrl, Object value) {
        if (ctrl instanceof ReportLabel) {
            ReportLabel rl = (ReportLabel)ctrl;
            if (StringUtils.isEmpty(rl.getComputeAt())) {
                rl.calculate(value);
            } else {
                rl.setValue(value);
            }
        } else {
            ctrl.setValue(value);
        }
    }
    public void setControlValueFromDb (Control ctrl, Object value) {
    if (ctrl == null) return;
        Format defaultFormat = null;
        ControlType type = ctrl.getType();
        if (type == ControlType.TEXT || type == ControlType.MEMO) {
            if (value != null) {
                setControlValue(ctrl, value.toString());
            }
            return;
        } else if (type == ControlType.DATE) {
            if (value == null) return;
            if (value instanceof Date) {
                setControlValue(ctrl, value);
                return;
            }
            defaultFormat = defaultDateFormat;

        } else if (type == ControlType.INTEGER || type == ControlType.FLOAT) {
            if (value instanceof Number) {
                setControlValue(ctrl, value);
                return;
            }

        } else if (type == ControlType.BOOLEAN) {

            Format fmt = page.getCCSLocale().getFormat(type, ctrl.getDbFormatPattern());
            Object bValue = null;
            try {
                if (value != null) bValue = fmt.parseObject(value.toString());
                    else bValue = fmt.parseObject(null);
                if (bValue instanceof Boolean) {
                    setControlValue(ctrl, bValue);
                    return;
                }
            } catch (ParseException pe) {
                setControlValue(ctrl, value);
                logger.error("ERROR:", pe);
            }

            defaultFormat = defaultBooleanFormat;
        }

        String formatPattern = ctrl.getDbFormatPattern();
        Format fmt = null;
        if (StringUtils.isEmpty(formatPattern)) {
            fmt = defaultFormat;
        } else {
            fmt = page.getCCSLocale().getFormat(type, formatPattern);
        }
        if (fmt != null) {
            try {
                if (value == null) {
                    setControlValue(ctrl, fmt.parseObject(null));
                } else {
                    setControlValue(ctrl, fmt.parseObject(value.toString()));
                }
            } catch (ParseException pe) {
                setControlValue(ctrl, value);
            }
        } else {
            setControlValue(ctrl, value);
        }
    }

    public Object getFieldValue(Object row, DbRow outDbParameters, String sourceType, String sourceName) {
        if (row != null && ("DataSource".equalsIgnoreCase(sourceType) 
                    || "Database".equalsIgnoreCase(sourceType))) {
            return ((DbRow) row).get(sourceName);
        } else if (outDbParameters != null && "DBParameter".equalsIgnoreCase(sourceType)) {
            return outDbParameters.get(sourceName);
        }
        return null;
    }
    
    public Object getFieldValue(Object row, DbRow outDbParameters, Control control) {
        Object value = getFieldValue(row, outDbParameters, control.getControlSourceType(), control.getFieldSource());
        Format defaultFormat = null;
        ControlType type = control.getType();

        if ( !com.codecharge.components.ControlType.TEXT.equals(control.getType()) && value instanceof String && StringUtils.isEmpty((String)value) ) { 
            return null;
        }

        if (type == ControlType.TEXT || type == ControlType.MEMO) {
            if (value != null) {
                return value.toString();
            }
            return null;
        } else if (type == ControlType.DATE) {
            if (value == null) return null;
            if (value instanceof Date) {
                return value;
            }
            defaultFormat = defaultDateFormat;
        } else if (type == ControlType.INTEGER || type == ControlType.FLOAT) {
            if (value instanceof Number) {
                return value;
            }
        } else if (type == ControlType.BOOLEAN) {
            if (value instanceof Boolean) {
                return value;
            }
            defaultFormat = defaultBooleanFormat;
        } 
        String formatPattern = control.getDbFormatPattern();
        Format fmt = null;
        if (StringUtils.isEmpty(formatPattern)) {
            fmt = defaultFormat;
        } else {
            fmt = control.getPage().getCCSLocale().getFormat(type, formatPattern);
        }
        if (fmt != null) {
            try {
                if (value == null) {
                    return fmt.parseObject(null);
                } else {
                    return fmt.parseObject(value.toString());
                }
            } catch (ParseException pe) {
                return value;
            }
        } else {
            return value;
        }
        
    }

    public Object getFieldValue(Object row, String fieldName) {
        return ((DbRow) row).get(fieldName);
    }

    protected int checkUnique(Element elm, Record model, VerifiableControl cntrl) {
      Element selectNode = getFirstChildElementByName(elm, "Select");
        if (selectNode == null) return 0;
        Element whereNode = getFirstChildElementByName(selectNode, "Where");
        Collection whereParameters = null;
        if (whereNode != null) whereParameters = getChildrenElementsByName(whereNode, "WhereParameter");
        Collection sqlParameters = getChildrenElementsByName(selectNode, "SqlParameter");
        String connectionName = elm.getAttribute("connection");
        String query = selectNode.getAttribute("query");
        String queryType = selectNode.getAttribute("type");
        int result = 0;

        JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection(connectionName);
        ds.setLocale(Locale.getDefault()); // TODO: not default
        Format defaultBooleanFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "BooleanFormat" );
        Format defaultDateFormat = (Format) ContextStorage.getInstance().getAttribute( connectionName + "DateFormat" );

        Collection sqlParamsCollection = getSqlParameters(sqlParameters, model);
        Collection whereParamsCollection = getWhereParameters(whereParameters, model);

        if ( queryType.equals("call") ) {
          logger.info("Unique value validation is not supported for Procedures");
          return 0;
        } else {
            Command cmd = null;
            if ( queryType.equals("raw") ) {
                cmd = new RawCommand(ds);
                cmd.setNeedQuotes(true);
            } else if (queryType.equals("custom")) {
                cmd = new RawCommand(ds);
                //cmd.setNeedQuotes(true);
            } else if (queryType.equals("sql")) {
                cmd = new SqlCommand(ds);
            } else {
                return 0;
            }

            SqlParameters parameters = new SqlParameters(sqlParamsCollection, whereParamsCollection);
            StringBuffer sql = new StringBuffer( query );
            StringBuffer where = new StringBuffer();
            if ( queryType.equals("sql") ) {
                Iterator sParams = sqlParamsCollection.iterator();
                sql = new StringBuffer( replaceParameters( query, sParams ) );
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildWhere(getWhereClause(whereNode), parameters );
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addParameter((SqlParameter)it.next()));
            } else {
                WhereBuilder wb = new WhereBuilder();
                String sWhere = wb.buildRawWhere(getWhereClause(whereNode), parameters, ds );
                if ( ! StringUtils.isEmpty( sWhere ) ) {
                    where = new StringBuffer( sWhere );
                }
                for(Iterator it = sqlParamsCollection.iterator(); it.hasNext(); cmd.addRawParameter((SqlParameter)it.next()));
            }
            boolean allParams = true;
            SqlParameter p = new SqlParameter(page.getCCSLocale());
            p.setName(cntrl.getFieldSource());
            p.setType(cntrl.getType());
            p.setFormatPattern(cntrl.getFormatPattern());
            p.setDbFormatPattern(cntrl.getDbFormatPattern());
            p.setOperation(FieldOperation.EQUAL);
            try{p.setValue(cntrl.getObjectValue());} catch(ParseException ignore) {}
            cmd.addParameter(p);
            for(Iterator it = whereParamsCollection.iterator(); it.hasNext();) {
                SqlParameter param = (SqlParameter)it.next();
                if(param.isApply()) {
                    cmd.addParameter(param);
                }
            }
            if ( where.length() > 0 ) {
                where.insert(0, cntrl.getFieldSource()+"={"+cntrl.getFieldSource()+"} AND NOT(").append(")");
            } else {
                where.append(cntrl.getFieldSource()+"={"+cntrl.getFieldSource()+"}");
            }
                cmd.setWhere(where);
                if ( StringUtils.isEmpty( query ) ) {
                    ds.closeConnection();
                    return 0;
                }
                cmd.setCountSql( sql.toString() );
                logger.debug( cmd.toString() );
                result = cmd.nrecords();
            if ( ds.hasErrors() ) {
                model.addErrors( ds.getErrors() );
            }
        }
        ds.closeConnection();
        return result;
    }
    protected String replaceParameters( String convertSql, Iterator params ) {
        if ( convertSql == null ) return "";
        if ( params == null ) {
          return convertSql;
        }

        while ( params.hasNext() ) {
            SqlParameter param = (SqlParameter) params.next();
            String name = param.getName();
            if ( name != null && name.length() > 0 ) {
                int pos = convertSql.indexOf( "%{" + name + "}%" );
                if ( pos > -1 ) {
                  convertSql = StringUtils.replace( convertSql, "%{" + name + "}%", "?" );
                  param.setOperation( FieldOperation.CONTAINS );
                }
                pos = convertSql.indexOf( "%{" + name + "}" );
                if ( pos > -1 ) {
                  convertSql = StringUtils.replace( convertSql, "%{" + name + "}", "?" );
                  param.setOperation( FieldOperation.BEGINS_WITH );
                }
                pos = convertSql.indexOf( "{" + name + "}%" );
                if ( pos > -1 ) {
                  convertSql = StringUtils.replace( convertSql, "{" + name + "}%", "?" );
                  param.setOperation( FieldOperation.ENDS_WITH );
                }
                pos = convertSql.indexOf( "{" + name + "}" );
                if ( pos > -1 ) {
                  convertSql = StringUtils.replace( convertSql, "{" + name + "}", "?" );
                }
            }
        }
        convertSql = StringUtils.replace( convertSql, "'?'", "?" );
        return convertSql;
    }
    /** Find FileUpload model in Record. @return Upload model or null if no Upload was found. */
    private ArrayList getUploads(Object parent, Element parentElement) {

        ArrayList fUploads = null;
        NodeList list = parentElement.getChildNodes();
        for (int i=0; i<list.getLength(); i++) {
          if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
            Element elm = (Element)list.item(i);
            if (elm.getTagName().equals("FileUpload")) {
              if (fUploads == null) fUploads = new ArrayList();
              fUploads.add( getComponentFromParent(parent, elm.getAttribute("name")) );
            }
          }
        }
        return fUploads;
    }

    private Model getComponentFromParent (Object parent, String name) {
        if (parent == null) return null;

        if (parent instanceof Component) {
            return (Model) ((Component) parent).getChild(name);
        } else if (parent instanceof HashMap) {
            return (Model) ((HashMap)parent).get(name);
        }

        return null;
    }


    protected void processFile(Element elm, Object model) {
      ArrayList uploads = getUploads(model, elm);

      if (uploads != null) {
        Iterator it = uploads.iterator();
        while (it.hasNext()) {
          FileUpload upload = (FileUpload) it.next();
          if (upload != null) {
              upload.moveProcessedFile();
          }
        }
      }

    }

    protected void deleteFile(Element elm, Object model) {

      ArrayList uploads = getUploads(model, elm);

      if (uploads != null) {
        Iterator it = uploads.iterator();
        while (it.hasNext()) {
            FileUpload upload = (FileUpload) it.next();
            if (upload != null) {
                upload.deleteFile();
            }
        }
      }
    }

    protected Object getControlValue(DbRow row, DbRow outDbParameters, String sourceType, String sourceName) {
        if (StringUtils.isEmpty (sourceName)) return null;

        if (row != null && ("DataSource".equalsIgnoreCase(sourceType) || "Database".equalsIgnoreCase(sourceType))) {
            return row.get(sourceName);
        } else if (outDbParameters != null && "DBParameter".equalsIgnoreCase(sourceType)) {
            return outDbParameters.get(sourceName);
        }
        return null;
    }

    protected void setLinkParameterDBValue(DbRow row, DbRow outDbParameters, LinkParameter param) {
        ParameterSource type = param.getSourceType();
        if (type == ParameterSource.DATAFIELD) {
            Object dsVal = getControlValue(row, outDbParameters, "DataSource", param.getSourceName());
            if (dsVal == null) {
                param.setValue("");
            } else {
                param.setValue(dsVal.toString());
            }
        } else if (type == ParameterSource.DBPARAMETER) {
            Object dsVal = getControlValue(row, outDbParameters, "DBParameter", param.getSourceName());
            if (dsVal == null) {
                param.setValue("");
            } else {
                param.setValue(dsVal.toString());
            }
         }
    }

    protected void setLinkProperties(DbRow row, DbRow outDbParameters, Link link) {
        if ("Database".equals(link.getHrefType()) || "DBParameter".equals(link.getHrefType())) {
            Object href = getControlValue(row, this.outDbParameters, link.getHrefType(), link.getHrefSource());
            if (href == null) {
                link.setHrefSourceValue("");
            } else {
                link.setHrefSourceValue(href);
            }
        } else {
            link.setHrefSourceValue(link.getHrefSource());
        }
        for (Iterator i = link.getParameters().iterator(); i.hasNext();) {
            setLinkParameterDBValue(row, this.outDbParameters, (LinkParameter)i.next());
        }
    }

    protected void setActiveResultSet(Element selectNode, SPCommand cmd) {
        String resultSetType = selectNode.getAttribute("resultSetType");
        String activeResultSet = selectNode.getAttribute("activeResultSet");
        if (! StringUtils.isEmpty(activeResultSet)) {
            if ("parameter".equalsIgnoreCase(resultSetType)) {
                cmd.setActiveResultSetName(activeResultSet);
            } else if ("resultset".equalsIgnoreCase(resultSetType)) {
                try {
                    cmd.setActiveResultSetNumber(Integer.parseInt(activeResultSet));
                } catch (NumberFormatException nfe_ignore) {}
            }
        }

    }

    protected String applyConvertRules (String url, String rule) {
        if ( "SSL".equals (rule) ) {
            String SSLUrlContext = (String) ContextStorage.getInstance().getAttribute("securedUrl");
            String requestURI = page.getRequest().getRequestURI();
            String SSLUrl = SSLUrlContext+"/"+url;

            return SSLUrl;
        } else if ( "Absolute".equals(rule) ) {
            return url;
        }
        return url;
    }


//------------BEGIN METHODS FOR HANDLING OMIT PARAMETERS------------------------


    protected static String cutOmitParametersInsert (String sql, Iterator it, Page page, Model model) {
        boolean isEmpty = true;

        while (it.hasNext()) {
            SqlParameter p =  (SqlParameter) it.next();
            
            String n = "{"+p.getName()+"}";
            String sn = p.getField();
            Object v = getParameterValue2 (page, p, model);

            boolean lave = false;
            if (p.isOmitIfEmpty() && (v == null) && p.getEmpty() == 0) lave = true;
            if (p.getEmpty() != 0) lave = p.isEmpty();

            if ( lave ) {
                int i = strictIndexOf (sql, n, 0);
                sql = strictRemove (sql, n);
                sql = handleCommas(sql ,i);
                
                i = strictIndexOf (sql, sn, 0);
                sql = strictRemove (sql, sn);
                sql = handleCommas(sql ,i);
            } else {
                isEmpty = false;
            }

        }

        if (isEmpty) return "";
        
        return sql;
    }
    
    protected static String cutOmitParametersUpdate (String sql, Iterator it, Page page, Model model) {
        boolean isEmpty = true;

        
        while (it.hasNext()) {
            SqlParameter p =  (SqlParameter) it.next();
            
            String n = "{" + p.getName() + "}";
            String sn = p.getField();
            Object v = getParameterValue2 (page, p, model);

            boolean lave = false;
            if (p.isOmitIfEmpty() && (v == null) && p.getEmpty() == 0) lave = true;
            if (p.getEmpty() != 0) lave = p.isEmpty();
            
            if (/*p.isOmitIfEmpty() && (v == null)*/ lave) {

                StringBuffer sb = new StringBuffer (" "+sql+" ");

                String s = sn;

                int i = strictIndexOf (sb.toString(), s, 0);
                int j = i+s.length();

                while (((sb.charAt(j)   != ' ' && 
                         sb.charAt(j)   != ',' && 
                         sb.charAt(j)   != ')' ) ||
                        (sb.charAt(i-1) != ' ' &&
                         sb.charAt(i-1) != ',' &&
                         sb.charAt(i-1) != '(')) && i > 0 ) {

                    i = strictIndexOf (sb.toString(), s, j);
                    j = i+s.length(); 
                } 

                int i1 = i;
                s = n;

                i = sb.toString().indexOf(s);
                j = i+s.length();

                while (((sb.charAt(j)   != ' ' && 
                         sb.charAt(j)   != ',' && 
                         sb.charAt(j)   != ')' ) ||
                        (sb.charAt(i-1) != ' ' &&
                         sb.charAt(i-1) != ',' &&
                         sb.charAt(i-1) != '(')) && i > 0 ) {

                    i = strictIndexOf (sb.toString(), s, j);
                    j = i+s.length(); 
                } 

                int j1 = j;
                
                sql = sb.delete(i1,j1).toString();
                sql = handleCommas(sql ,i1);
            } else {
                isEmpty = false;
            }
        }

        if (isEmpty) return "";
        
        return sql;
    }

    private static Object getParameterValue2 (Page page, SqlParameter p, Model model) {

        if (ParameterSource.URL         ==  p.getSourceType()) return page.getHttpGetParams().getParameter(p.getName());
        if (ParameterSource.CONTROL     ==  p.getSourceType()) {
            int n = -1;
            if (model instanceof EditableGrid) {
                n = ((EditableGrid)model).getCurrentRowNumber();
            }

            if (n>0) {
                //return page.getRequest().getParameter(p.getSourceName()+"_"+n);
                return page.getHttpPostParameter(p.getSourceName()+"_"+n);
            } else {
                //return page.getRequest().getParameter(p.getSourceName());
                return page.getHttpPostParameter(p.getSourceName());
            }
        }
        if (ParameterSource.SESSION     ==  p.getSourceType()) return SessionStorage.getInstance(page.getRequest()).getAttribute(p.getName());
        if (ParameterSource.FORM        ==  p.getSourceType()) return page.getHttpPostParams().getParameter(p.getName());
        if (ParameterSource.APPLICATION ==  p.getSourceType()) return ContextStorage.getInstance().getAttribute(p.getName());
        if (ParameterSource.COOKIE      ==  p.getSourceType()) return StringUtils.getCookie(p.getName(), page.getRequest().getCookies());
        if (ParameterSource.EXPRESSION  ==  p.getSourceType()) return p.getValue();

        return null;
    }
    
    private static String handleCommas(String sql, int i) {
        StringBuffer bsql = new StringBuffer (sql);
        
        int j = bsql.toString().indexOf(",",i);
        int j1 = bsql.toString().indexOf(")",i);

        if ( (j1>0) && (j>j1) ) j = -1;
        
        if (j>0) {
            bsql = bsql.delete(i,j+1);
        } else {
            j = bsql.toString().lastIndexOf(",",i);
            j1 = bsql.toString().lastIndexOf("(",i);
            if ( (j1>0) && (j<j1) ) j = -1;

            if (j>0) {
                bsql = bsql.delete(j, i);
            }
        }
    
        return bsql.toString();
    }



    private static String strictRemove (String sql, String s) {
        StringBuffer sb = new StringBuffer (" "+sql+" ");
        
        int i = sb.toString().indexOf(s);
        int j = i+s.length();

        while (i > 0 &&
               ((sb.charAt(j)   != ' ' && 
                 sb.charAt(j)   != ',' && 
                 sb.charAt(j)   != ')' ) ||
                (sb.charAt(i-1) != ' ' &&
                 sb.charAt(i-1) != ',' &&
                 sb.charAt(i-1) != '(')) ) {

            i = sb.toString().indexOf(s, j);
            j = i+s.length(); 
        } 
        
        if (i>0) {
            sb.delete(i, j);
            sql = sb.toString();
        }

        sql = sql.substring(1,sql.length()-1);
        
        return sql;
    }


    private static int strictIndexOf (String sql, String s, int r) {
        StringBuffer sb = new StringBuffer (sql);
        
        int i = sb.toString().indexOf(s, r);
        int j = i+s.length();

        while (
                (
                    (
                        ((j+1>=sb.length()) || (sb.charAt(j) != ' ' && 
                        sb.charAt(j) != ',' && 
                        sb.charAt(j) != ')'))
                        
                    ) || (
                        ((i-1)<0 ||(sb.charAt(i-1) != ' ' &&
                        sb.charAt(i-1) != ',' &&
                        sb.charAt(i-1) != '('))
                    )
                ) && i > 0  
                ) {
            i = sb.toString().indexOf(s, j);
            j = i+s.length(); 
        } 
        
        return i;
    }



//------------END METHODS FOR HANDLING OMIT PARAMETERS--------------------------

    protected ModelAttribute bindRowAttribute (ModelAttribute attr, DbRow row) {
        ModelAttribute cAttr = attr.cloneAttribute();
        //ModelAttribute cAttr = attr;
            
        if ("DataField".equals ( attr.getSourceType() )) {
            String source = attr.getSourceName();
            Object value = row.get( source );
            cAttr.setValue ( ""+value );
        }
        return cAttr;
    }



}

//End AbstractProcessor class: head

