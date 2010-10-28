//ReportRow component @0-0365B658
/*
 * $Revision: 1.15 $
 * $Date: 2004/12/02 07:42:21 $
 */
package com.codecharge.components.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.codecharge.components.Control;
import com.codecharge.components.Model;
import com.codecharge.components.NoSuchComponentException;
import com.codecharge.events.BindEvent;
import com.codecharge.events.Event;
import com.codecharge.events.SectionListener;
import com.codecharge.util.StringUtils;


public class ReportRow implements Cloneable {
    private ReportGroup parent;
    private ArrayList listeners = new ArrayList();

    private HashMap controls = new HashMap();
    
    private boolean visible = true;
    private boolean visibleOnCurrentPage = true;
    private double height;
    
    public ReportRow(ReportGroup group) {
        parent = group;
        height = 1;
    }
    
    public Model getControl(String name) {
        Model control = null;
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("ReportRow.getControl(name): name mustn't be empty");
        }
        control = (Model) controls.get(name); 
        if (control == null) {
            if (parent != null) {
                control = parent.getControl(name);
                if (control == null) {
                    throw new NoSuchComponentException("ReportRow.getControl('"+name+"'): control named '"+name+"' not found in the report");
                }
            }
        }
        return control;
    }
    
    public void addControl(Model control) {
        if (control != null) {
            controls.put(control.getName(), control);
        }   
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("    Row:");
        for (Iterator it = controls.keySet().iterator(); it.hasNext(); ) {
            String name = (String) it.next();
            sb.append("  "+name);
            Object obj = controls.get(name);
            if (obj instanceof Control) {
                sb.append("("+(((Control) obj).getValue())+":"+obj.getClass().getName()+")");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
    
    public ReportRow createInstance(ReportGroup parent) {
        Object obj = null; 
        boolean debug = false;            
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException cnse_ignore) {}
        ReportRow row = (ReportRow) obj;
        row.controls = new HashMap();
        row.parent = parent;
        for (Iterator it = this.controls.keySet().iterator(); it.hasNext(); ) {
            String name = (String) it.next();
            Model m = (Model) controls.get(name);
            if (m instanceof Control) {
                Control ctrl = (Control) m;
                Control cloneCtrl = (Control) ctrl.clone();
                row.controls.put(ctrl.getName(), cloneCtrl);
            } else {
                //TODO: clone models
                row.controls.put(m.getName(), m);
            }
        }
        return row;
    }
    
    public Iterator getControlNames() {
        return controls.keySet().iterator();
    }
    
    public synchronized void addListener(SectionListener l) {
        listeners.add(l);
    }

    public synchronized void removeListener(SectionListener l) {
        listeners.remove(l);
    }

    public void fireOnInitializeEvent(Object dataRow) {
        ArrayList v;
        BindEvent e = new BindEvent();
        e.setSource(parent.getReport());
        e.setRow(dataRow);
        synchronized(this) {v = (ArrayList)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).onInitialize(e);
        }
    } 

    public void fireOnCalculateEvent(Object dataRow) {
        ArrayList v;
        BindEvent e = new BindEvent();
        e.setSource(parent.getReport());
        e.setRow(dataRow);
        synchronized(this) {v = (ArrayList)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).onCalculate(e);
        }
    } 

    public void fireBeforeShowEvent() {
        ArrayList v;

        Event e = new Event();
        e.setSource(parent.getReport());
        synchronized(this) {v = (ArrayList)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((SectionListener)v.get(i)).beforeShow(e);
        }
    } 

    /**
     * @return parent group
     */
    public ReportGroup getParentGroup() {
        return parent;
    }

    /**
     * @return true if visible.
     */
    public boolean isVisible() {
        return visible && visibleOnCurrentPage;
    }
    /**
     * @param visible The visible to set.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    /**
     * @return true if visible on current page.
     */
    public boolean isVisibleOnPage() {
        return visibleOnCurrentPage;
    }
    /**
     * @param visibleOnCurrentPage The visibleOnCurrentPage to set.
     */
    public void setVisibleOnPage(boolean visibleOnCurrentPage) {
        this.visibleOnCurrentPage = visibleOnCurrentPage;
    }

    //TODO: remove from release
    public String toHash() {
        return "@" + Integer.toHexString(hashCode());
    }

    public boolean hasControl(String name) {
         return controls.containsKey(name);
    }
    
    public void deleteControl(String name) {
        controls.remove(name);
    }
    
    public double getHeight() {
        return (isVisible() ? this.height : 0);
    }
    
    public void setHeight(double height) {
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }
   
}

//End ReportRow component

