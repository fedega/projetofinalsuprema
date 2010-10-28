//EditableGrid component @0-748E5A38
package com.codecharge.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.ResourceBundle;
import java.text.MessageFormat;

import com.codecharge.Names;
import com.codecharge.db.Field;
import com.codecharge.events.DataObjectEvent;
import com.codecharge.events.EditableGridDataObjectListener;
import com.codecharge.events.EditableGridListener;
import com.codecharge.events.Event;
import com.codecharge.util.CCLogger;
import com.codecharge.util.CCSURL;
import com.codecharge.util.Permission;
import com.codecharge.util.PreserveParameterType;
import com.codecharge.util.SessionStorage;
import com.codecharge.util.StringUtils;
import com.codecharge.validation.ControlErrorTypes;
import com.codecharge.validation.ErrorCollection;

public class EditableGrid extends Grid implements IRecord {

    protected int mode;
    protected ArrayList primaryKeys = new ArrayList();
    protected ArrayList cachedColumns = new ArrayList();
    protected ArrayList rowControls = new ArrayList();
    protected ArrayList staticControls = new ArrayList();
    protected boolean allowRead = true;
    protected boolean allowUpdate = true;
    protected boolean allowDelete = true;
    protected boolean allowInsert = true;
    protected String returnPage;
    protected int numberEmptyRows;
    protected PreserveParameterType preserveType;
    protected int rowsFromRequest;

    protected String deleteControlName;

    public EditableGrid(String name) {
        super(name);
    }

    public void setMode(int mode) {this.mode = mode;}
    public int getMode() {return mode;}

    public void setReturnPage(String page) {returnPage = page;}
    public String getReturnPage() {return returnPage;}

    public void setDeleteControlName(String deleteControlName) {this.deleteControlName = deleteControlName;}
    public String getDeleteControlName() {
    	if  ( deleteControlName == null) 
    		deleteControlName = "";
	return deleteControlName;
    }

    /** Specify the number of rows for the new records. */
    public void setNumberEmptyRows(int numberEmptyRows) {this.numberEmptyRows = numberEmptyRows;}
    public int getNumberEmptyRows() {return numberEmptyRows;}

    public PreserveParameterType getPreserveType() {return preserveType;}
    public void setPreserveType( PreserveParameterType type ) {preserveType = type;}

    public boolean currentRowHasErrors() {
        return ( childRow != null && childRow.get(Names.CCS_ROW_ERROR_KEY) != null && ((com.codecharge.validation.ErrorCollection) childRow.get(Names.CCS_ROW_ERROR_KEY)).hasErrors() );
    }

    /** Returns the current row. */
    public HashMap getEmptyRow() {
        HashMap emptyRow = new HashMap();

        //Iterator it = getChildren().iterator();
        Iterator it = getRowControls().iterator();
        currentRow++;

        while ( it.hasNext() ){

            //Model m = (Model) it.next();
            Model m = getChild((String)it.next());

            if ( m instanceof List ) {
                List l = (List) ((List) m).clone();
                l.setValues(null);
                l.setHtmlName(m.getName() + "_" + currentRow);
                emptyRow.put(m.getName(),l);
            } else if ( m instanceof Control ) {
                Control c = (Control) ((Control) m).clone();

                if (!"CodeExpression".equals (c.getControlSourceType()) ) c.setValue(null);
                //c.setValue(null);

                c.setHtmlName(m.getName() + "_" + currentRow);
                emptyRow.put(m.getName(),c);
            } else if (m instanceof DatePicker) {
                DatePicker dp = (DatePicker) ((DatePicker)m).clone();
                dp.setHtmlName(dp.getControlName() + "_" + currentRow);
                emptyRow.put(dp.getName(), dp);
            } else if (m instanceof Button) {
                Button btn = (Button)((Button)m).clone();
                btn.setHtmlName(btn.getName() + "_" + currentRow );
                emptyRow.put(m.getName(), btn);
            } else {
                emptyRow.put(m.getName(),m);
            }
        }
        emptyRow.put(Names.CCS_ROW_IS_NEW_KEY,"true");
        childRow = emptyRow;
        return emptyRow;
    }

    /** indicate that component is processed (parameter ccsForm equals name of component). */
    public boolean isProcessed() {
        return processed;
    }

    /** Indicate that shown row is empty row
     * @return boolean true if row is empty row; otherwise - false; 
     */
    public boolean isShowEmptyRow() {
        return (childRow != null && childRow.get(Names.CCS_ROW_IS_NEW_KEY) != null);
    }

    /** Indicate that current row is insert row
     * @return boolean true if row is insert row; otherwise - false 
     */
    public boolean isInsertRow() {
        return (childRow != null && 
                childRow.get(Names.CCS_ROW_IS_NEW_KEY) != null && 
                childRow.get(Names.CCS_ROW_IS_DELETE_KEY) == null && 
                childRow.get(Names.CCS_ROW_IS_NOT_APPLY_KEY) == null);
    }

    /** Indicate that current row is update row
     * @return boolean true if row is insert row; otherwise - false 
     */
    public boolean isUpdateRow() {
        return (childRow != null && 
                childRow.get(Names.CCS_ROW_IS_NEW_KEY) == null && 
                childRow.get(Names.CCS_ROW_IS_DELETE_KEY) == null && 
                childRow.get(Names.CCS_ROW_IS_NOT_APPLY_KEY) == null
                );
    }
    
    /**
     * Returns ErrorCollection for current row.
     * @return com.codecharge.validation.ErrorCollection object
     */
    protected ErrorCollection getRowErrors() {
        ErrorCollection rowErrors = null;
        if (childRow != null) {
            rowErrors = (ErrorCollection) childRow.get(Names.CCS_ROW_ERROR_KEY);
            if ( rowErrors == null ) {
                rowErrors = new ErrorCollection();
                childRow.put(Names.CCS_ROW_ERROR_KEY, rowErrors);
            }
        }
        return rowErrors;
    }

    /**
     * Add error message to error collection of current row
     * @param errMessage error message
     */
    public void addRowError(String errMessage) {
        if (childRow != null && ! StringUtils.isEmpty(errMessage)) {
            getRowErrors().addError(errMessage);
        }
    }

    /** Whether current row has errors. 
     *  @return true - if current row has errors; false otherwise
     */
    public boolean hasRowErrors() {
        if (childRow != null) {
            return getRowErrors().hasErrors();
        }
        return false;
    }

    /** Whether read is allowed for this EditableGrid at this moment. You can change this value with setAllowRead. */
    public boolean isAllowRead() {
        return allowRead;
    }
    /** Set whether read operation is allowed for this EditableGrid. Helpful to disallow read operation from events. */
    public void setAllowRead( boolean allowRead ) {
        this.allowRead = allowRead;
    }

    /** Whether insert operation is allowed for this EditableGrid at this moment. You can change this value with setAllowInsert. */
    public boolean isAllowInsert() {
        return allowInsert;
    }
    /** Set whether insert operation is allowed for this EditableGrid. Helpful to disallow insert operation from events. */
    public void setAllowInsert( boolean allowInsert ) {
        this.allowInsert = allowInsert;
    }

    /** Whether update operation is allowed for this EditableGrid at this moment. You can change this value with setAllowUpdate. */
    public boolean isAllowUpdate() {
        return allowUpdate;
    }
    /** Set whether update operation is allowed for this EditableGrid. Helpful to disallow update operation from events. */
    public void setAllowUpdate( boolean allowUpdate ) {
        this.allowUpdate = allowUpdate;
    }

    /** Whether delete operation is allowed for this EditableGrid at this moment. You can change this value with setAllowDelete. */
    public boolean isAllowDelete() {
        return allowDelete;
    }
    /** Set whether delete operation is allowed for this EditableGrid. Helpful to disallow delete operation from events. */
    public void setAllowDelete( boolean allowDelete ) {
        this.allowDelete = allowDelete;
    }

    public boolean hasReadPermission( int groupId ) {
        if ( permissions == null ) {
            return true;
        } else {
            return permissions.checkPermissions( groupId, Permission.ALLOW_READ );
        }
    }

    public boolean hasInsertPermission( int groupId ) {
        if ( permissions == null ) {
            return true;
        } else {
            return permissions.checkPermissions( groupId, Permission.ALLOW_INSERT );
        }
    }

    public boolean hasUpdatePermission( int groupId ) {
        if ( permissions == null ) {
            return true;
        } else {
            return permissions.checkPermissions( groupId, Permission.ALLOW_UPDATE );
        }
    }

    public boolean hasDeletePermission( int groupId ) {
        if ( permissions == null ) {
            return true;
        } else {
            return permissions.checkPermissions( groupId, Permission.ALLOW_DELETE );
        }
    }

    public void addRowControl(String model) {
        if ( model != null ) {
            rowControls.add(model);
        }
    }

    public Collection getRowControls() {
        return rowControls;
    }

    public void addStaticControl(String model) {
        if ( model != null ) {
            staticControls.add(model);
        }
    }

    public Collection getStaticControls() {
        return staticControls;
    }

    public String getPreserveParameters() {
        String[] p = new String[excludeParams.size()];
        for ( int i = 0; i < excludeParams.size(); i++ ) {
            p[i] = (String) excludeParams.get(i);
        }
        StringBuffer result = new StringBuffer();
        if ( preserveType == PreserveParameterType.GET || preserveType == PreserveParameterType.ALL ) {
            result.append( pageModel.getHttpGetParams().toString( p ) );
        }
        if ( preserveType == PreserveParameterType.POST || preserveType == PreserveParameterType.ALL ) {
            result.append( pageModel.getHttpPostParams().toString( p ) );
        }
        return result.toString();
    }

    public String getFormScript() {

        String type = "";

        if ("true".equalsIgnoreCase( StringUtils.getSiteProperty("isXHTMLUsed") ) || "true".equalsIgnoreCase( StringUtils.getSiteProperty("isSection508") )) {
        	type = "type=\"text/javascript\"";
        }

        StringBuffer sb = new StringBuffer("\n<script language=\"JavaScript\" "+type+">\n<!--\nvar "+getName()+"Elements;\n");
        sb.append("var "+getName()+"EmptyRows = "+getNumberEmptyRows()+";\n");
        int total = 0;
        int number = 0;
        for (int i = 0; i < rowControls.size(); i++) {
            if (getChild((String) rowControls.get(i)) instanceof VerifiableControl) {
//System.out.println(""+ rowControls.get(i) + " ! " + allowDelete + " ! " + ((String) rowControls.get(i)).startsWith(getDeleteControlName()) );
                if (((String) rowControls.get(i)).startsWith(getDeleteControlName())  && getDeleteControlName() != "" ) {
                } else {
                    sb.append("var "+getName()+((String) rowControls.get(i))+"ID = "+(number++)+";\n");
                }
            }
        }

        int jsRowControlsSize = rowControls.size();
        if (jsRowControlsSize > 0 && !allowDelete) jsRowControlsSize--;

        sb.append("var "+getName()+"DeleteControl = "+jsRowControlsSize+";\n");
        sb.append("\nfunction init"+getName()+"Elements() {\n");
        sb.append("  var ED = document.forms[\""+getName()+"\"];\n");
        sb.append("  "+getName()+"Elements = new Array (\n");
        int numElements = isProcessed() ? rowsFromRequest : getChildRows().size();

        int jsRowCount = numElements;
        if (allowInsert) {
            jsRowCount = jsRowCount + getNumberEmptyRows();
        }

        while (total < jsRowCount ) {
            if (total>0) sb.append(",\n");
            total++;
            sb.append("    new Array(");
            
            boolean isFirst = true;            

            for ( int k = 0; k < rowControls.size(); k++ ) {
                if ( (getChild((String) rowControls.get(k)) instanceof VerifiableControl) && (!(((String) rowControls.get(k)).startsWith(getDeleteControlName()) )  || getDeleteControlName() == "") ) {
                    if ( isFirst ) {
                        isFirst = false;
                    } else {
                        sb.append(", "); 
                    }
                    sb.append("ED."+((String) rowControls.get(k))+"_").append(total);
                }
            }
            if (allowDelete) {
            	sb.append(", ").append("ED."+deleteControlName+"_").append(total);
            }
            sb.append(")");
        }

        sb.append(");\n}\n");
        sb.append("//-->\n</script>\n");
        return sb.toString();
    }

    public void addPrimaryKey( Field key ) {
        primaryKeys.add( key );
    }
    public Iterator getPrimaryKeys() { return primaryKeys.iterator(); }


    private String serializeCachedColumnsRow(HashMap row) {
        StringBuffer sb = new StringBuffer();
        if ( row != null ) {
            ArrayList cColumns = (ArrayList) row.get(Names.CCS_CACHED_COLUMNS);
            if (cColumns != null) {
                Iterator it = cColumns.iterator();
                while ( it.hasNext() ) {
                    CachedColumn c = (CachedColumn) it.next();
                    String columnValue = "";
                    if (c != null) {
                        columnValue = StringUtils.replace(c.getFormattedValue(),"\\","\\\\");
                        columnValue = StringUtils.replace(columnValue,";","\\;");
                    }
                    sb.append(columnValue);
                    if (it.hasNext()) {
                        sb.append(";");
                    }
                }
            }
            if (sb.length()>0) {
                sb.insert(0, ";");
            }
        }
        return sb.toString();
    }

    public String getFormEnctype() {
      for (Iterator i=getChildren().iterator(); i.hasNext(); ) {
        if (i.next() instanceof FileUpload) {
          return "multipart/form-data";
        }
      }
      return "application/x-www-form-urlencoded";
    }

    public String getFormAction() {
      StringBuffer value = new StringBuffer();
      //String query = pageModel.getHttpGetParams().toString(new String[] {"ccsForm"});

      CCSURL url = pageModel.getHttpGetParams().toCCSURL(new String[] {"ccsForm"});

      String reqURI = pageModel.getRequest().getRequestURI();
      String cPath = pageModel.getRequest().getContextPath();

      if ( reqURI.startsWith( cPath ) ) {
            reqURI = reqURI.substring( cPath.length() - 1 );
      }
      int pos = reqURI.lastIndexOf( '/' );
      if ( pos > -1 ) {
            reqURI = reqURI.substring( pos + 1 );
      }


      //value.append( SessionStorage.getInstance( pageModel.getRequest() ).encodeURL( reqURI ));
      url.setUrl(SessionStorage.getInstance( pageModel.getRequest() ).encodeURL( reqURI ));

      //value.append("?ccsForm=").append(getName());
      url.addParameter("ccsForm",getName());

      // if (mode == Record.UPDATE_MODE) value.append(":Edit"); EditableGrid doesn't have modes.
      //value.append(StringUtils.isEmpty(query)?"":"&"+query);

      //return value.toString();
      return url.toString();
    }

    public String getFormState() {
        StringBuffer sb = new StringBuffer();
        if ( isProcessed() ) {
           sb.append(rowsFromRequest).append(";");
        } else {
          sb.append(childRows.size()).append(";");
        }
        if (numberEmptyRows>0 && allowInsert) {
            sb.append(numberEmptyRows);
        } else {
            sb.append("0");
        }
        Iterator it = cachedColumns.iterator();
        if (amountOfRows==0) return sb.toString();
        else if (it.hasNext()) sb.append(";");
        while (it.hasNext()) {
            String columnName = ((CachedColumn) it.next()).getName();
            columnName = StringUtils.replace(columnName,"\\","\\\\");
            sb.append(StringUtils.replace(columnName,";","\\;"));
            if (it.hasNext()) {
                sb.append(";");
            }
        }
        it = childRows.iterator();
        while ( it.hasNext() ) {
            sb.append( serializeCachedColumnsRow((HashMap) it.next()) );
        }
        return StringUtils.toHtml(sb.toString());
    }

    public void setFormState(String formState) {

        if (StringUtils.isEmpty(formState)) return;

        Enumeration items = StringUtils.split(formState);
        if (items.hasMoreElements()) {
            String item = (String) items.nextElement();
            try {
                amountOfRows = Integer.parseInt(item);
            } catch (NumberFormatException nfe) {
                amountOfRows = 0;
            }
        }
        if (items.hasMoreElements()) {
            String item = (String) items.nextElement();
            try {
                numberEmptyRows = Integer.parseInt(item);
            } catch (NumberFormatException nfe) {
                numberEmptyRows = 0;
            }
        }
        for (int i = 0; i < cachedColumns.size(); i++ ) {
            if (items.hasMoreElements()) {
                String item = (String) items.nextElement();
                if (! item.equals((String) ((CachedColumn)cachedColumns.get(i)).getName() )) {
                    //TODO: error - data corrupted
                    CCLogger.getInstance().error("EditableGrid '"+name+"': FormState is corrupted.");
                }
            } else {
                CCLogger.getInstance().error("EditableGrid '"+name+"': FormState is corrupted.");
            }
        }
        int itemCount = 0;
        int curRow = -1;
        ArrayList columns = null;
        ArrayList keys = null;
        while (items.hasMoreElements()) {
            if (itemCount == 0) {
                columns = new ArrayList();
            }
            for (int i = 0; i < cachedColumns.size(); i++ ) {
                if (items.hasMoreElements()) {
                    String item = (String) items.nextElement();
                    CachedColumn column = (CachedColumn) ((CachedColumn) cachedColumns.get(i)).clone();
                    column.setValue(item);
                    columns.add(column);
                }
            }
            curRow++;
            HashMap row = null;
            if ( curRow < childRows.size() ) {
                row = (HashMap) childRows.get(curRow);
            } else {
                row = getEmptyRow();
            }
            if (curRow < amountOfRows) {
                row.remove(Names.CCS_ROW_IS_NEW_KEY);
            } else {
                row.remove(deleteControlName);
            }
            row.put(Names.CCS_CACHED_COLUMNS, columns);
            if (primaryKeys.size()>0) {
                keys = new ArrayList();
                for (int i = 0; i < columns.size(); i++ ) {
                    for (int j = 0; j < primaryKeys.size(); j++ ) {
                        CachedColumn column = (CachedColumn) columns.get(i);
                        Field key = (Field) ((Field) primaryKeys.get(j)).clone();
                        if ( column.getName().equals(key.getName())) {
                            key.setObjectValue(column.getValue());
                            keys.add(key);
                        }
                    }
                }
                row.put(Names.CCS_PK_KEY, keys);
            }

            if ( curRow >= childRows.size() ) {
                childRows.add(row);
            }
        }
        rowsFromRequest = childRows.size();
        if (rowsFromRequest<amountOfRows) {
            for (int i = rowsFromRequest; i < amountOfRows; i++ ) {
                HashMap row = getEmptyRow();
                row.remove(Names.CCS_ROW_IS_NEW_KEY);
                childRows.add(row);
            }
        }
        for (int i = 0; i < numberEmptyRows; i++) {
            HashMap row = getEmptyRow();
            row.remove(deleteControlName);
            childRows.add(row);
        }
    }

    public void processRows() {
        //mark deleted rows
        for ( int i = 0; i < childRows.size(); i++ ) {
            boolean isDeleted = true;
            Model delCtrl = (Model) ((HashMap) childRows.get(i)).get(deleteControlName);
            if ( delCtrl == null ) {
                isDeleted = false;
            } else {
                if ( delCtrl instanceof CheckBox) {
                    String value = ((CheckBox)delCtrl).getFormattedValue();
                    if (StringUtils.isEmpty(value)) isDeleted = false;
                } else if ( delCtrl instanceof Control ) {
                    Object value = ((Control) delCtrl).getValue();
                    if ( value == null || ( (value instanceof String) && (StringUtils.isEmpty((String) value)) ) ) {
                        isDeleted = false;
                    }
                }
            }
            if ( isDeleted ) {
                ((HashMap) childRows.get(i)).put(Names.CCS_ROW_IS_DELETE_KEY,"true");
            }
        }

        //check insert rows
        if ( allowInsert ) {
        if ( getNumberEmptyRows() > 0 ) {
            int offset = (int) amountOfRows;
            if ( offset >= 0 ) {
                for ( int i = offset; i < childRows.size(); i++ ) {
                    HashMap row = (HashMap) childRows.get(i);
                    if ( row.get(Names.CCS_ROW_IS_DELETE_KEY) == null ) {
                        Iterator controls = row.keySet().iterator();
                        boolean isEmpty = true;
                        while ( controls.hasNext() ) {
                            Control control = null;
                            String name = (String) controls.next();
                            Object obj = row.get(name);
                            if ( obj instanceof Control ) {
                                control = (com.codecharge.components.Control) obj;
                                if (
                                      !(
                                       control.getValue() == null ||
                                       (
                                        (control.getType() == ControlType.TEXT || control.getType() == ControlType.MEMO)
                                        &&
                                        (control.getValue() instanceof String)
                                        &&
                                        StringUtils.isEmpty((String) control.getValue())
                                       )
                                      )
                                      ||
                                      control.hasErrors()
                                    
                                   ) {
                                    isEmpty = false;
                                }
                            }
                        }
                        if ( isEmpty) {
                            ((HashMap) childRows.get(i)).put(Names.CCS_ROW_IS_NOT_APPLY_KEY,"true");
                        }
                    }
                }
            }
        }
        }
    }

    public void checkUnique() {
        Iterator controls = getChildren().iterator();
        while ( controls.hasNext() ) {
            Model m = (Model) controls.next();
            if ( m instanceof VerifiableControl ) {
                VerifiableControl vc = (VerifiableControl) m;
                if ( vc.isUnique() ) {
                    String name = vc.getName();
                    for ( int j = 0; j < childRows.size(); j++ ) {
                        HashMap etlRow = (HashMap) childRows.get(j);
                        if ( etlRow.get(Names.CCS_ROW_IS_NOT_APPLY_KEY) != null ||
                                etlRow.get(Names.CCS_ROW_IS_DELETE_KEY) != null ) {
                            continue;
                        }
                        VerifiableControl etl = (VerifiableControl) etlRow.get(name);
                        if ( etl.hasErrorByType( ControlErrorTypes.getErrorType( ControlErrorTypes.UNIQUE_ERROR ) ) ) {
                            continue;
                        }
                        for ( int i = j+1; i < childRows.size(); i++ ) {
                            HashMap compRow = (HashMap) childRows.get(i);
                            if ( compRow.get(Names.CCS_ROW_IS_NOT_APPLY_KEY) != null ||
                                    compRow.get(Names.CCS_ROW_IS_DELETE_KEY) != null ) {
                                continue;
                            }
                            VerifiableControl comp = (VerifiableControl) compRow.get(name);
                            if ( etl.equals( comp ) ) {
                                ResourceBundle res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"));
                                MessageFormat msgfmt = new MessageFormat(res.getString("CCS_UniqueValue"));
                                String errorMessage = msgfmt.format(new String[] {comp.getName()});
                                comp.addError(ControlErrorTypes.getErrorType(ControlErrorTypes.UNIQUE_ERROR), errorMessage);

                                //comp.addError(ControlErrorTypes.getErrorType(ControlErrorTypes.UNIQUE_ERROR), "Must be Unique");
                            }
                        }
                    }
                } // end if unique
            } // end if VerifiableConrtol
        } // end while by controls
    }

    public void addCachedColumn(String name, String alias, ControlType type) {
        cachedColumns.add(new CachedColumn(name,alias,type,pageModel.getCCSLocale()));
    }
    public void addCachedColumn(String name, ControlType type) {
        addCachedColumn(name, name, type);
    }

    public ArrayList getCachedColumns() {
      return cachedColumns;
    }

    public Object getCachedColumnValue(String name) {
        Object columnValue = null;
        CachedColumn column = getCachedColumn(name);
        if (column != null) {
            columnValue = column.getValue();
        }
        return columnValue;
    }

    public CachedColumn getCachedColumn(String name) {
        CachedColumn result = null;
        ArrayList cols = (ArrayList)currentRow().get(Names.CCS_CACHED_COLUMNS);
        if (cols == null) cols = cachedColumns;
        if (name != null) {
            for (int i=0; i < cols.size(); i++) {
                CachedColumn column = (CachedColumn) cols.get(i);
                if (name.equals(column.getName())) {
                    result = column;
                }
            }
        }
        return result;
    }

    public void hideDeleteControl() {
        if (!StringUtils.isEmpty(deleteControlName)) {
            if (isShowEmptyRow() || ! isAllowDelete()) {
                try {
                    getChild(deleteControlName).setVisible(false);
                    Model panelModel = getChild(getDeleteControlName() + "_Panel");
                    if (panelModel!=null) {
                        if (panelModel instanceof Panel) ((Panel)panelModel).setVisible(false);
                    }
                } catch (NoSuchComponentException ex21) {}

            }
        }
    }

    public synchronized void addEditableGridListener(EditableGridListener l) {
        listeners.addElement(l);
    }
    public synchronized void removeEditableGridListener(EditableGridListener l) {
        listeners.removeElement(l);
    }

    public void fireBeforeSelectEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridListener)v.elementAt(i)).beforeSelect(e);
        }
    }

    public void fireBeforeShowEvent( Event e ) {
        Vector v;
        this.setAttributes(this);
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridListener)v.elementAt(i)).beforeShow(e);
        }
    }

    public void fireBeforeShowRowEvent( Event e ) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridListener)v.elementAt(i)).beforeShowRow(e);
        }
    }

    public void fireOnValidateEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridListener)v.elementAt(i)).onValidate(e);
        }
    }

    public void fireOnValidateRowEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridListener)v.elementAt(i)).onValidateRow(e);
        }
    }

    public void fireBeforeSubmitEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridListener)v.elementAt(i)).beforeSubmit(e);
        }
    }

    public void fireAfterSubmitEvent() {
        Vector v;
        Event e = new Event(this); // TODO: no such class
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridListener)v.elementAt(i)).afterSubmit(e);
        }
    }

//  DataSource Events
    public void fireBeforeBuildSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeBuildSelect(e);
        }
    }
    public void fireBeforeExecuteSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeExecuteSelect(e);
        }
    }
    public void fireAfterExecuteSelectEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).afterExecuteSelect(e);
        }
    }
//  DataSource Events
    public void fireBeforeBuildInsertEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeBuildInsert(e);
        }
    }
    public void fireBeforeExecuteInsertEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeExecuteInsert(e);
        }
    }
    public void fireAfterExecuteInsertEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).afterExecuteInsert(e);
        }
    }
//  DataSource Events
    public void fireBeforeBuildUpdateEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeBuildUpdate(e);
        }
    }
    public void fireBeforeExecuteUpdateEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeExecuteUpdate(e);
        }
    }
    public void fireAfterExecuteUpdateEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).afterExecuteUpdate(e);
        }
    }
//  DataSource Events
    public void fireBeforeBuildDeleteEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeBuildDelete(e);
        }
    }
    public void fireBeforeExecuteDeleteEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).beforeExecuteDelete(e);
        }
    }
    public void fireAfterExecuteDeleteEvent(DataObjectEvent e) {
        Vector v;
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((EditableGridDataObjectListener)v.elementAt(i)).afterExecuteDelete(e);
        }
    }

}


//End EditableGrid component

