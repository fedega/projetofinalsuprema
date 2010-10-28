//Navigator component @0-E47B6539
package com.codecharge.components;

import java.util.Vector;
import com.codecharge.events.*;
import com.codecharge.util.*;

public class Navigator extends Model {

    public static final int NO_PAGES = -1;
    public static final int SIMPLE = 0;
    public static final int CENTERED = 1;
    public static final int MOVING = 2;
    public static final int MANUAL = 3;

    protected Page page; // Page on which this control lives
    protected int numberOfPages;
    protected int navigatorType;

	protected Vector pageSizes = null;

	public Vector getPageSizes() {
		return pageSizes;
	}
	public void setPageSizes(Vector pageSizes) {
		this.pageSizes = pageSizes;
	}

	public void setPageSizes(String s) {
		setPageSizes(new Vector(StringUtils.splitToList(s , ';', 'a')));
	}

    public Navigator(String name, Navigable parent, Page page) {
       super(name);
       setParent((Component) parent);
       setPage(page);
       navigatorType = Navigator.NO_PAGES;
       addExcludeParam("ccsForm");
       if (parent != null) addExcludeParam(parent.getName()+"Page");
    }

    /** Get page of this Sorter. This method allows to get Page - root of the controls tree consisting of components and different controls.
       @return page - root of the controls tree */
    public Page getPage() { return page; }
    /** Set page of this Sorter. Called automatically by ModelParser and not used by programmer.
      @param page root of the control tree */
    public void setPage( Page page ) { this.page = page; }

    public int getNumberOfPages() { return numberOfPages; }
    public void setNumberOfPages( int numberOfPages ) { 
        this.numberOfPages = numberOfPages; 
    }

    public int getNavigatorType() { return navigatorType; }
    public void setNavigatorType( int navigatorType ) { 
        this.navigatorType = navigatorType; 
    }

    public synchronized void addControlListener (ControlListener listener) {
        listeners.addElement(listener);
    }

    public synchronized void removeControlListener (ControlListener listener) {
        listeners.removeElement(listener);
    }

    public void fireBeforeShowEvent(Event e) {
        Vector l;
        this.setAttributes(this);
        e.setSource(this);

		if (((Navigable)getParent()).getTotalPages() < 2) {
			setVisible(false);
		}

        synchronized(this) {l = (Vector)listeners.clone();}
        for (int i=0; i<l.size(); i++) {
            ((ControlListener)l.elementAt(i)).beforeShow(e);
        }
    }
}


//End Navigator component

