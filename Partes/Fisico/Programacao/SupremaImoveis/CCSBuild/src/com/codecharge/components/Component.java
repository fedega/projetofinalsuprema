//Component component @0-8982FBCA
/*
 * $Revision: 1.9 $
 * $Date: 2004/11/05 15:34:12 $
 */
package com.codecharge.components;

import java.text.MessageFormat;
import java.util.*;
import com.codecharge.util.Permission;
import com.codecharge.util.StringUtils;
import com.codecharge.util.ErrorFormatter;
import com.codecharge.util.ModelAttribute;
import com.codecharge.events.Event;
import com.codecharge.events.ComponentListener;
import com.codecharge.db.DbRow;
import com.codecharge.validation.ErrorCollection;
import com.codecharge.Names;



/**
  Component represents an element that is composed of other elements.
  Component has children HashMap so that you can iterate through children and get children by name.
  Page, Grid and Record are Components.
  @see Page
  @see Grid
  @see Record
  @see EditableGrid
  @see Directory
  @see Path
 **/
public class Component extends Model {

    /* Collection of children. */
    protected HashMap children = new HashMap();
    protected Vector parallelChildren = new Vector();
    protected ArrayList childRows = new ArrayList();
    protected HashMap childRow = null;
    protected Iterator itRows = null;
    /* Collection of errors. */
    protected Vector errors = new Vector();
    protected StringBuffer error;
    protected boolean restricted;
    protected Permission permissions;
    protected int fetchSize;
    protected Page pageModel;
    protected ResourceBundle res;

    protected DbRow outDbParameters;

    protected int currentRow;


    protected boolean processed;

    public boolean allowRead = true;

    public Component(String name) {
        super(name);
    }


    /**
     * Map of component attributes that can be set at runtime
     * Attributes are used in calculated fields.
     */


    public void setOutDbParameters (DbRow params) {
        this.outDbParameters = params;
    }

    public Object getOutDbParameter(String paramName) {
        if (this.outDbParameters == null) {
            return null;
        }
        return this.outDbParameters.get(paramName);
    }
    
    public Permission getPermissions() {
        return permissions;
    }
    public void setPermissions(Permission permissions) {
        this.permissions = permissions;
    }

    /**
     * Whether users must be logged in before accessing the form.
     * 
     * @return a boolean
     */
    public boolean isRestricted() {
        return restricted;
    }
    /** Specify whether users must be logged in before accessing the form. */
    public void setRestricted(boolean flag) {
        restricted = flag;
    }

    /**
     * Page to which the component belongs
     * 
     * @return Page to which the component belongs
     */
    public Page getPageModel() {
        return pageModel;
    }

    /**
     * Set Page to which the component belongs
     * 
     * @param model Page to which the component belongs
     * @exception IllegalArgumentException if given model is null
     */
    public void setPageModel(Page model) {
        if (model == null) {
            throw new IllegalArgumentException("Component '"+this.name+"' setPageModel: parameter 'model' can't be null.");
        }
        pageModel = model;
        res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"), pageModel.getCCSLocale().getLocale());
    }

    public int getCurrentRowNumber() {
        return currentRow;
    }
    public void setCurrentRowNumber(int num) {
        currentRow = num;
    }

    public int getPageSize() {
        return 0;
    }
    public void setPageSize(int size) {
        fetchSize = size;
    }
    public void setPageSize(String size) {
        try {
            fetchSize = Integer.parseInt(size);
        } catch (NumberFormatException nfe) {
            MessageFormat fmt = new MessageFormat(res.getString("PageSizeParameterIsIncorrect"));
            addError(fmt.format(new String[] {name} ));
            fetchSize = 0;
        }
    }

    /**
     * indicate that component is processed (parameter ccsForm euqals name of
     * component)
     * 
     * @return a boolean
     */
    public boolean isProcessed() {
        return false;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    /** Add element to the Children collection.
     * @param m element to add
     */
    public void add(Model m) {
        children.put(m.getName(), m);
        parallelChildren.add(m);
        m.setParent(this);
    }

    /** Initialize inner iterator by childRows */
    public void initializeRows() {
        itRows = childRows.iterator();
        currentRow = 0;
    }

    /**
     * Returns true if the iteration has more elements
     * 
     * @return true if the iteration has more elements
     */
    public boolean hasNextRow() {
        if (itRows == null) {
            initializeRows();
        }
        return itRows.hasNext();
    }

    /**
     * Returns the next row. If row isn't available returns empty HashMap; never
     * null
     * 
     * @return a HashMap of all the row controls
     */
    public HashMap nextRow() {
        if (itRows != null) {
            childRow = (HashMap) itRows.next();
        } else {
            childRow = new HashMap();
        }
        currentRow++;
        //currentAttrRow++;
        //nextAttrRow();
        return childRow;
    }

    /**
     * Returns the current row.
     * 
     * @return a HashMap of all the row controls
     */
    public HashMap currentRow() {
        return childRow;
    }

    public void nullChildRow() {
        childRow = null;
    }

    /**
     * Find Child in children collection by name.
     * 
     * @param name Child name
     * @return the Child of the given name or null if no such Child exists
     */
    public Model getChild(String name) {
        Model m = null;
        if (childRow != null) {
            m = (Model) childRow.get(name);
        }
        if (m == null) {
            m = (Model) children.get(name);
        }
        if (m == null) {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "child", name} ));
        }
        return m;
    }

    /**
     * Return all children as collection.
     * 
     * @return a collection of all the children
     */
    public Collection getChildren() {
        //return children.values();
        return parallelChildren;
    }

    /**
     * Find Control in children collection by name.
     * 
     * @param name
     *            the Control name
     * @return the Control of the given name or null if no such Control exists
     */
    public Control getControl(String name) {
        Model m = getChild(name);
        Control c = null;
        if (m instanceof Control) {
            c = (Control) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "control", name} ));
        }
        return c;
    }

    /**
     * Find MutableControl in children collection by name.
     * 
     * @param name
     *            the MutableControl name
     * @return the MutableControl of the given name or null if no such
     *         MutableControl exists
     */
    public VerifiableControl getMutableControl(String name) {
        Model m = getChild(name);
        VerifiableControl c = null;
        if (m instanceof VerifiableControl) {
            c = (VerifiableControl) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "control", name} ));
        }
        return c;
    }

    /**
     * Find FileUpload in children collection by name.
     * 
     * @param name
     *            the FileUpload name
     * @return the FileUpload of the given name or null if no such FileUpload
     *         exists
     */
    public FileUpload getFileUpload(String name) {
        Model m = getChild(name);
        FileUpload c = null;
        if (m instanceof FileUpload) {
            c = (FileUpload) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "file upload control", name} ));
        }
        return c;
    }

    /**
     * Find FileUpload in children collection by name.
     * 
     * @param name
     *            the FileUpload name
     * @return the FileUpload of the given name or null if no such FileUpload
     *         exists
     */
    public Button getButton(String name) {
        Model m = getChild(name);
        Button c = null;
        if (m instanceof Button) {
            c = (Button) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "button", name} ));
        }
        return c;
    }

    /**
     * Find List in children collection by name.
     * 
     * @param name
     *            the List name
     * @return the List of the given name or null if no such List exists
     */
    public List getList(String name) {
        Model m = getChild(name);
        List c = null;
        if (m instanceof List) {
            c = (List) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "list control", name} ));
        }
        return c;
    }

    /**
     * Find ListBox in children collection by name.
     * 
     * @param name
     *            the ListBox name
     * @return the ListBox of the given name or null if no such ListBox exists
     */
    public ListBox getListBox(String name) {
        Model m = getChild(name);
        ListBox c = null;
        if (m instanceof ListBox) {
            c = (ListBox) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "listbox", name} ));
        }
        return c;
    }

    /**
     * Find RadioButton in children collection by name.
     * 
     * @param name
     *            the RadioButton name
     * @return the RadioButton of the given name or null if no such RadioButton
     *         exists
     */
    public RadioButton getRadioButton(String name) {
        Model m = getChild(name);
        RadioButton c = null;
        if (m instanceof RadioButton) {
            c = (RadioButton) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "radiobutton", name} ));
        }
        return c;
    }

    /**
     * Find CheckBoxList in children collection by name.
     * 
     * @param name
     *            the CheckBoxList name
     * @return the CheckBoxList of the given name or null if no such
     *         CheckBoxList exists
     */
    public CheckBoxList getCheckBoxList(String name) {
        Model m = getChild(name);
        CheckBoxList c = null;
        if (m instanceof CheckBoxList) {
            c = (CheckBoxList) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "checkbox list", name} ));
        }
        return c;
    }

    /**
     * Find getLink in children collection by name.
     * 
     * @param name
     *            the getLink name
     * @return the getLink of the given name or null if no such getLink exists
     */
    public Link getLink(String name) {
        Model m = getChild(name);
        Link c = null;
        if (m instanceof Link) {
            c = (Link) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "link", name} ));
        }
        return c;
    }

    /**
     * Find ImageLink in children collection by name.
     * 
     * @param name
     *            the ImageLink name
     * @return the ImageLink of the given name or null if no such ImageLink
     *         exists
     */
    public ImageLink getImageLink(String name) {
        Model m = getChild(name);
        ImageLink c = null;
        if (m instanceof ImageLink) {
            c = (ImageLink) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "imageLink", name} ));
        }
        return c;
    }

    /**
     * Find DatePicker in children collection by name.
     * 
     * @param name
     *            the DatePicker name
     * @return the DatePicker of the given name or null if no such DatePicker
     *         exists
     */
    public DatePicker getDatePicker(String name) {
        Model m = getChild(name);
        DatePicker c = null;
        if (m instanceof DatePicker) {
            c = (DatePicker) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "date picker", name} ));
        }
        return c;
    }

    /**
     * Find Panel in children collection by name.
     * 
     * @param name
     *            the Panel name
     * @return the Panel of the given name; never returns null
     * @exception NoSuchComponentException
     *                if no such Panel exists
     */
    public Panel getPanel(String name) {
        Model m = getChild(name);
        Panel p = null;
        if (m instanceof Panel) {
            p = (Panel) m;
        } else {
            //MessageFormat fmt = new MessageFormat(res.getString("NoSuchComponent"));
            MessageFormat fmt = new MessageFormat(pageModel.getResourceString("NoSuchComponent"));
            throw new NoSuchComponentException(fmt.format(new String[] {getName(), "panel", name} ));
        }
        return p;
    }

    public boolean checkAccess(int groupId, int permission) {
        if (this.permissions == null)
            return true;
        return this.permissions.checkPermissions(groupId, permission);
    }

    /**
     * Whether Component has errors.
     * 
     * @return true - if Component has errors; false otherwise
     */
    public boolean hasErrors() {
        return (errors.size() > 0);
    }


    public boolean hasErrorsInRow () {
        Iterator it = childRows.iterator();
        while (it.hasNext()) {
            HashMap row = (HashMap)it.next();
            if (row.get(Names.CCS_ROW_ERROR_KEY) != null) {
                ErrorCollection errCollection = (ErrorCollection) row.get(Names.CCS_ROW_ERROR_KEY);
                if (errCollection.hasErrors()) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Get Collection of errors.
     * 
     * @return the collection of errors
     */
    public Vector getErrors() {
        return errors;
    }

    /**
     * Get all errors represented as one string.
     * 
     * @return a String that represents all the errors.
     */
    public String getErrorsAsString() {
        StringBuffer sb = new StringBuffer();
        if (errors.size() > 0) {
            ErrorFormatter fmt = ErrorFormatter.getInstance();
            for (int i = 0; i < errors.size() - 1; i++) {
                sb.append(fmt.formatLine((String) errors.get(i)));
            }
            sb.append(errors.get(errors.size() - 1));
        }
        return sb.toString();
    }

    /**
     * Add error message to errors collection.
     * 
     * @param error
     *            the error message
     */
    public void addError(String error) {
        errors.add(error);
    }

    /** Add several errors to errors collection.
     * @param errors collection of errors
     */
    public void addErrors(Collection errors) {
        this.errors.addAll(errors);
    }

    public void addChildRow(HashMap row) {
        if (row == null) {
            return;
        }
        childRows.add(row);
    }

    public ArrayList getChildRows() {
        return (ArrayList) childRows.clone();
    }

    public String getFormAction() {
        return "";
    }

    public String getFormState() {
        return "";
    }

    public void setFormState(String formState) {
        return;
    }

    public boolean isAllowRead() {
        return allowRead;
    }

    public void setAllowRead(boolean flag) {
        allowRead = flag;
    }
    
    public boolean hasChild(String name) {
        Model m = null;
        if (childRow != null) {
            m = (Model) childRow.get(name);
        }
        if (m == null) {
            m = (Model) children.get(name);
        }
        if (m == null) {
            return false;
        }
        return true;
    }
                
    public void fireAfterInitializeEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((ComponentListener) v.elementAt(i)).afterInitialize(e);
        }
    }
    
    public void fireBeforeShowEvent(Event e) {
        Vector v;
        this.setAttributes(this);
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((ComponentListener) v.elementAt(i)).beforeShow(e);
        }
    }
    
}


//End Component component

