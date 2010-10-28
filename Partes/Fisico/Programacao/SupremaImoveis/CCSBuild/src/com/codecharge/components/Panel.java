//Panel class @0-2F16A168
/*
 * $Revision: 1.3 $
 * $Date: 2004/07/08 08:38:20 $
 */ 
package com.codecharge.components;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.codecharge.events.ControlListener;
import com.codecharge.events.Event;



public class Panel extends Model {

    protected ArrayList controlNames;
	protected boolean isUpdatePanel = false;
	protected String panelId;


	public boolean isUpdatePanel () {
		return isUpdatePanel;
	}
	public void setUpdatePanel(boolean a) {
		this.isUpdatePanel = a;
	}


	public String getPanelId() {
		return panelId;
	}
	public void setPanelId(String panelId) {
		this.panelId = panelId;
	}

    /**
     * @param name
     */
    public Panel(String name) {
        super(name);
        controlNames = new ArrayList();
    }

    public void add(String name) {
        controlNames.add(name);
    }

    public void add(Model m) {
        controlNames.add(m.getName());
    }
    public Page getPage() {
        if (parent != null) {
            if (parent instanceof Page) {
                return (Page)parent;
            } else {
                return parent.getPageModel();
            }
        }
        return null;
    }

    public Collection getChildrenNames() {
        return Collections.unmodifiableCollection(this.controlNames);
    }

    public Collection getChildren() {
        return getComponents();
    }
    
    public Collection getComponents() {
        ArrayList children = new ArrayList();
        for (int i = 0; i < controlNames.size(); i++) {
            Model m = parent.getChild((String) controlNames.get(i));
            if (m != null) {
                children.add(m);
            }
        }
        return children;
    }
    
    public Model getComponent(String name) {
        if (parent == null) {
            return null;
        }
        return parent.getChild(name);
    }
    
    /** Add Event handler. */
    public synchronized void addControlListener (ControlListener listener) {
        listeners.addElement(listener);
    }
    /** Remove Event handler. */
    public synchronized void removeControlListener (ControlListener listener) {
        listeners.removeElement(listener);
    }
    /** Call Event handler that works out BeforeShow event. */
    public void fireBeforeShowEvent() {
        Vector l;
        this.setAttributes(this);
        Event e = new Event(this);
        synchronized (this) {
            l = (Vector) listeners.clone();
        }
        for (int i = 0; i < l.size(); i++) {
            ((ControlListener) l.elementAt(i)).beforeShow(e);
        }
    }
}


//End Panel class

