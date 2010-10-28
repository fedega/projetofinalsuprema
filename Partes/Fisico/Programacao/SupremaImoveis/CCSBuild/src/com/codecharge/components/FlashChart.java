//FlashChart component @0-769F87FF
package com.codecharge.components;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Date;
import java.util.Vector;
import java.util.Enumeration;

import com.codecharge.util.multipart.*;
import com.codecharge.util.*;
import com.codecharge.validation.*;
import com.codecharge.events.Event;
import com.codecharge.events.UploadListener;
import com.codecharge.events.FlashChartListener;

public class FlashChart extends Component {

		private int width = -1;
		private int height = -1;
		private String src = null;
		private String title = null;


    	public FlashChart(String name) {
        	super(name);
    	}

		public void setHeight(int height) {
			this.height = height;
		}
		public int getHeight() {
			return height;
		}

		public void setWidth(int width) {
			this.width = width;
		}
		public int getWidth() {
			return width;
		}

		public void setSrc(String src) {
			this.src = src;
		}
		public String getSrc() {
			return src;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		public String getTitle() {
			return title;
		}

		public void setQueryString(com.codecharge.components.Page page) {
		        String queryString = page.getRequest().getQueryString();
		        if (queryString != null && queryString != "" ) {
		    		queryString = "%26" + queryString.replaceAll("&", "%26").replaceAll("=", "%3D");
		    	} else {
		    		queryString  = "";
		    	}
		        this.setSrc(this.getSrc() + queryString);
		}

		public com.codecharge.components.Page getRootPage(com.codecharge.components.Page parentPage) {
		    	if(parentPage.isIncluded()) {
				parentPage = this.getRootPage((com.codecharge.components.Page)parentPage.getRequest().getAttribute(parentPage.getName() + "Parent"));
			} 
			return parentPage;
		}

	    public synchronized void addFlashChartListener( FlashChartListener l ) {
	        listeners.addElement(l);
	    }

	    public synchronized void removeFlashChartListener( FlashChartListener l ) {
	        listeners.removeElement(l);
	    }

	    public void fireBeforeShowEvent(Event e) {
	        Vector l;
	        this.setAttributes(this);
	        e.setSource(this);
	        synchronized (this) {
	            l = (Vector) listeners.clone();
	        }
	        for (int i = 0; i < l.size(); i++) {
	            ((FlashChartListener) l.elementAt(i)).beforeShow(e);
	        }
	        setBeforeShow(true);
	    }

	    public void fireAfterInitializeEvent() {
	    }

}

//End FlashChart component

