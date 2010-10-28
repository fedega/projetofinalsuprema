//Menu component @0-27F5FB61


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
import java.util.Iterator;
import java.util.Enumeration;

import com.codecharge.util.multipart.*;
import com.codecharge.util.*;
import com.codecharge.validation.*;
import com.codecharge.events.Event;
import com.codecharge.events.MenuListener;

public class Menu extends Component {

	private String menuType;
	private Vector que;
	private Iterator queIt;
  	private Vector itemsCollection = new Vector(); 
	private MenuItem root;

	public Menu (String name) {
		super(name);
	}

	public String getActiveItemName() {
		return activeItem.getName();
	}
	public String getActiveItemCaption() {
		return activeItem.getCaption();
	}
	public String getActiveItemUrl() {
		return activeItem.getUrl();
	}
	public String getTarget() {
		return activeItem.getTarget();
	}

	public String getTitle() {
		return activeItem.getTitle();
	}

	private MenuItem activeItem;

	public boolean isOpenLevel () {
		return activeItem.isOpenLevel();
	}
	public boolean isCloseItem () {
		return activeItem.isCloseItem();
	}
	public int getCloseLevel () {
		return activeItem.getCloseLevel();
	}
	public int getLevel() {
		return activeItem.getLevel();
	}

	public boolean hasNexItem () {
		return queIt.hasNext();
	}
	public void nextItem () {
		activeItem = (MenuItem) queIt.next();
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuType() {
		return menuType;
	}
	public String getMenuFormattedType() {
		if ("VerticalTree".equals(menuType)) return "menu_vlr_tree";
		if ("Vertical".equals(menuType)) return "menu_vlr";
		if ("VerticalRight".equals(menuType)) return "menu_vrl";
		if ("Horizontal".equals(menuType)) return "menu_htb";
		return menuType;
	}

	public void initRender() {
		que = new Vector();
		fillQue(root, 1);
		
		setCloseLevelTree();
		queIt = que.iterator();
	}

	private void setCloseLevelTree() {
		if (que.size() == 0)
			return;
		MenuItem currentItem;
		MenuItem nextItem;
		for (int i = 0; i < que.size()-1; i++) {
			currentItem = (MenuItem) que.elementAt(i);
			nextItem = (MenuItem) que.elementAt(i+1);
			if (currentItem.getLevel() > nextItem.getLevel()) {
				currentItem.setCloseLevel(currentItem.getLevel() - nextItem.getLevel());
			}
		}
		currentItem = (MenuItem) que.elementAt(que.size()-1);
		currentItem.setCloseLevel(currentItem.getLevel()-1);
	}

	private void fillQue (MenuItem m, int lvl) {
		Iterator it = m.getChildren().iterator();
		while (it.hasNext()) {
			MenuItem c = (MenuItem) it.next();
			que.add(c);
			c.setLevel(lvl);
			if (c.getChildren().isEmpty()) {
				c.setCloseItem(true);
			} else {
				int zzz = que.size()-1;
				fillQue(c, lvl+1);
				((MenuItem)que.get(zzz+1)).setOpenLevel(true);
				//((MenuItem)que.get(que.size()-1)).setCloseLevel(true);
			}
		}
	}

	public void addMenuItem (String name, String parent, String caption, String url, String target, String title) {
		itemsCollection.add(new MenuItem (name, parent, caption, url, target, title) );
	}

	public void buildTree () {
		MenuItem root = new MenuItem("","","","","","");
		buildTree(root);
		this.root = root;
	}

	public void buildTree (MenuItem parent) {
		Vector res = new Vector();
		int i = 0;
		while(i < itemsCollection.size()) {
			String s = ((MenuItem)itemsCollection.get(i)).getParentName();
			if ( parent.getName().equals ( s ) ) {
				MenuItem mi = (MenuItem) itemsCollection.get(i);
				itemsCollection.remove(i);
				res.add(mi);
			} else {
				i++;
			}
		}
		
		parent.setChildren(res);
		
		Iterator it = res.iterator();
		while (it.hasNext()) {
			buildTree ((MenuItem)it.next());
		}
		
	}
	
	
	public String toString() {
		return ""+itemsCollection+"!"+root;
	}

	class MenuItem {
		private String name; 
		private String caption;
		private String parentName;
		private String url;
		private String target;
		private String title;

		private MenuItem parent;

		private Vector children; 
		
		private boolean openLevel = false;
		private boolean closeItem = false;

		private int closeLevel = 0;
		private int level = -1;


		public void setLevel(int level) {
			this.level = level;
		}
		public int getLevel() {
			return level;
		}
		
		public void setCloseItem(boolean closeItem) {
			this.closeItem = closeItem;
		}
		public void setCloseLevel(int closeLevel) {
			this.closeLevel = closeLevel;
		}
		public void setOpenLevel(boolean openLevel) {
			this.openLevel = openLevel;
		}
		
		public boolean isOpenLevel () {
			return openLevel;
		}
		public boolean isCloseItem () {
			return closeItem;
		}
		public int getCloseLevel () {
			return closeLevel;
		}

		public MenuItem(String name, String parent, String caption, String url2, String target, String title) {
			setCaption(caption);
			setName(name);
			setParentName(parent);
			setUrl(url2);
			setTarget(target);
			setTitle(title);
		}
		
		public void setCaption(String caption) {
			this.caption = caption;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public void setParentName(String parent) {
			this.parentName = parent;
		}

		
		public String getCaption() {
			return caption;
		}
	
		public String getName() {
			return name;
		}
		public String getParentName() {
			return parentName;
		}
		
		
		
		public void setParent(MenuItem parent) {
			this.parent = parent;
		}
		public MenuItem getParent() {
			return parent;
		}
		
		public void setChildren(Vector children) {
			this.children = children;
		}
		public Vector getChildren() {
			return children;
		}

		public void setUrl(String url) {
			this.url = url;
		}
		public String getUrl() {
			return url;
		}

		public void setTarget(String t) {
			this.target = t;
		}
		public String getTarget() {
			return target;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		public String getTitle() {
			return title;
		}


		public String toString() {
			return "["+name+":"+children+"]";
		}

	}




    public void fireBeforeShowEvent(Event e) {
        Vector v;
        this.setAttributes(this);
        e.setSource(this);
        synchronized(this) {v = (Vector)listeners.clone();}
        for (int i=0; i<v.size(); i++) {
            ((MenuListener)v.elementAt(i)).beforeShow(e);
        }
    }


    public synchronized void addMenuListener( MenuListener l ) {
        listeners.addElement(l);
    }


}


//End Menu component

