//Button component @0-F59C78BE
package com.codecharge.components;

import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import com.codecharge.events.*;
import com.codecharge.util.StringUtils;

/**
  Button reacts on user clicks and defines which operation (Insert, Update, Delete, Cancel, Login etc.) should be performed by Record.
**/
public class Button extends Model {

    final private static String EMPTY = "";
    
    protected String returnPage;
    protected Page page;
    private String operation;
    private HashMap assignedParameters;

    /** Create new Button object.
      @param name Name of the button.
      @param page Page to which the button belongs.
    **/
    public Button(String name, Page page) {
      super(name);
      this.page = page;
      //assignedParameters = new HashMap();
      //assignedParameters.put(this.name, Button.EMPTY);
      //assignedParameters.put(this.name+".x", Button.EMPTY);
      addExcludeParam(this.name);
      addExcludeParam(this.name+".x");
      addExcludeParam(this.name+".y");
    }

    /** Page to which the button belongs. **/
    public void setPage(Page page) {this.page = page;}
    /** Page to which the button belongs. **/
    public Page getPage() {return page;}

    /** Page to which redirect after successful button operation.
      @see Record#setReturnPage
    **/
    public void setReturnPage(String returnPage) {this.returnPage=returnPage;}
    /** Page to which redirect after successful button operation.
      @see Record#getReturnPage
    **/
    public String getReturnPage() {return returnPage;}

    /** Predefined operation used to identify special buttons like Insert, Update, Delete, Cancel. **/
    public void setOperation(String op) {this.operation = op;}
    /** Predefined operation used to identify special buttons like Insert, Update, Delete, Cancel. **/
    public String getOperation() {return operation;}

    public boolean isPressed() {
        /*
        boolean result = false;
        for (Iterator params = assignedParameters.keySet().iterator(); params.hasNext(); ) {
            String paramName = (String) params.next();
            String value = (String) assignedParameters.get(paramName);
            if (Button.EMPTY == value) {
                result = (page.getParameter(paramName) != null);
            } else {
                result = value.equals(page.getParameter(paramName));
            }
            if (result) break;
        }
        return result;
        */
        return (page.getParameter(this.name) != null || page.getParameter(this.name+".x") != null);
    }

    /**
     * Assign parameter to the button.
     *
     * @param name Name of expected request parameter. 
     * @param expectedValue Expected value of request parameter. If defined the button will be considered pressed if and only
     *              if value of request parameter equals <code>expectedValue</code>. If <code>expectedvalue</code> is null
     *              or is empty the button is considered pressed if request parameter is exist.
     */
    /*
    public void assignParameter(String name, String expectedValue) {
        if (! StringUtils.isEmpty(name)) {
            if (StringUtils.isEmpty(expectedValue)) expectedValue = Button.EMPTY;
            assignedParameters.put(name, expectedValue);
        }
    }
    */
    /** Add Button events handler to the list of listeners. **/
    public synchronized void addButtonListener(ButtonListener l) {
        listeners.addElement(l);
    }

    /** Remove Button events handler from the list of listeners. **/
    public synchronized void removeButtonListener(ButtonListener l) {
        listeners.removeElement(l);
    }

    public void fireOnClickEvent() {
        Vector v;
        Event e = new Event(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((ButtonListener)v.elementAt(i)).onClick(e);
        }
    }

    public void fireBeforeShowEvent(Event e) {
        Vector l;
        this.setAttributes(this);
        e.setSource(this);
        synchronized(this) {l = (Vector)listeners.clone();}
        for (int i=0; i<l.size(); i++) {
            ((ButtonListener)l.elementAt(i)).beforeShow(e);
        }
    }
}
//End Button component

