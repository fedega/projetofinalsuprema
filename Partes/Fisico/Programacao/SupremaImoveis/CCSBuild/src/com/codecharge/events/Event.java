//Event class @0-A46DC4AD
/*
 * $Revision: 1.8 $
 * $Date: 2004/11/08 07:15:48 $
 */
package com.codecharge.events;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import com.codecharge.components.*;
import com.codecharge.components.report.ReportGroup;
import com.codecharge.util.StringUtils;

public class Event {
    protected Object src;
    protected Page page;
    protected ResourceBundle res;

    public Event() {
    }
    public Event(Object src) {
        this.src = src;
        page = getPageModel();
        if (page != null) {
            res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"), page.getCCSLocale().getLocale());
        }
    }

    public Object getSource() {
        return src;
    }

    /**
     * Returns event source as List.
     * 
     * @return the event source as List if source is List
     * @exception NoSuchComponentException if source is not List
     */
    public List getList() {
        if (src instanceof List) {
            return (List) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"List"}));
        }
    }
    public RadioButton getRadioButton() {
        if (src instanceof RadioButton) {
            return (RadioButton) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"RadioButton"}));
        }
    }
    public ListBox getListBox() {
        if (src instanceof ListBox) {
            return (ListBox) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"ListBox"}));
        }
    }
    public Model getModel() {
        if (src instanceof Model) {
            return (Model) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"Model"}));
        }
    }
    public Button getButton() {
        if (src instanceof Button) {
            return (Button) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"Button"}));
        }
    }
    public Control getControl() {
        if (src instanceof Control) {
            return (Control) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"Control"}));
        }
    }
    public VerifiableControl getMutableControl() {
        if (src instanceof VerifiableControl) {
            return (VerifiableControl) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"MutableControl"}));
        }
    }
    public Sorter getSorter() {
        if (src instanceof Sorter) {
            return (Sorter) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"Sorter"}));
        }
    }
    public Navigator getNavigator() {
        if (src instanceof Navigator) {
            return (Navigator) src;
        } else {
            throw new IllegalStateException(getMessage("Event.NoSuchComponent", new String[]{"Navigator"}));
        }
    }

    public Component getComponent() {
        if (src instanceof Component) {
            return (Component) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof Component) {
            return (Component) ((Model) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Component"}));
        }
    }

    public Record getRecord() {
        if (src instanceof Record) {
            return (Record) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof Record) {
            return (Record) ((Model) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Record"}));
        }
    }

    public Grid getGrid() {
        if (src instanceof Grid) {
            return (Grid) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof Grid) {
            return (Grid) ((Model) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Grid"}));
        }
    }

    public Calendar getCalendar() {
        if (src instanceof Calendar) {
            return (Calendar) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof Calendar) {
            return (Calendar) ((Model) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Calendar"}));
        }
    }

    public EditableGrid getEditableGrid() {
        if (src instanceof EditableGrid) {
            return (EditableGrid) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof EditableGrid) {
            return (EditableGrid) ((Model) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"EditableGrid"}));
        }
    }

    public Directory getDirectory() {
        if (src instanceof Directory) {
            return (Directory) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof Directory) {
            return (Directory) ((Model) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Directory"}));
        }
    }

    public Path getPath() {
        if (src instanceof Path) {
            return (Path) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof Path) {
            return (Path) ((Model) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Path"}));
        }
    }

    public Panel getPanel() {
        if (src instanceof Panel) {
            return (Panel) src;
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Panel"}));
        }
    }

    public Report getReport() {
        if (src instanceof Report) {
            return (Report) src;
        } else if (src instanceof Model && ((Model) src).getParent() instanceof Report) {
            return (Report) ((Model) src).getParent();
        } else if (src instanceof ReportGroup) {
            return ((ReportGroup)src).getReport();
        } else if (src instanceof Panel && ((Panel)src).getParent() instanceof Report) {
            return (Report) ((Panel)src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Report"}));
        }
    }

    public void setSource(Object src) {
        this.src = src;
    }

    private Page getPageModel() {
        if (src instanceof Control) {
            return ((Control) src).getPage();
        } else if (src instanceof Page) {
            return (Page) src;
        } else if (src instanceof Sorter) {
            return ((Sorter) src).getPage();
        } else if (src instanceof Navigator) {
            return ((Navigator) src).getPage();
        } else if (src instanceof Component) {
            return ((Component) src).getPageModel();
        } else if (src instanceof Button) {
            return ((Button) src).getPage();
        } else if (src instanceof Panel) {
            return ((Panel)src).getPage();
        } else if (src instanceof ReportGroup) {
            return ((ReportGroup)src).getReport().getPageModel();
        } else {
            return null;
        }
    }

    public Page getPage() {
        if (page == null) {
            page = getPageModel();
            if (page == null) {
                throw new IllegalStateException("Event object is not initialised properly: page model is not available.");
            }
            res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"), page.getCCSLocale().getLocale());
        }
        return page;
    }

    public String getValue() {
        if (src instanceof Control) {
            return ((Control) src).getFormattedValue();
        } else {
            return null;
        }
    }
    public void setValue(String value) {
        if (src instanceof Control) {
            ((Control) src).setFormattedValue(value);
        }
    }

    public Component getParent() {
        if (src instanceof Control) {
            return ((Control) src).getParent();
        } else if (src instanceof Button) {
            return ((Button) src).getParent();
        } else {
            throw new IllegalStateException(getMessage("Event.ComponentIsUnreachable", new String[]{"Component"}));
        }
    }
    
    protected String getMessage(String key, String[] values) {
        String result = null;
        String resString = null;
        if (res != null) {
            //resString = res.getString(key);
            resString = page.getResourceString(key);
        } else {
            page = getPageModel();
            if (page == null) {
                throw new IllegalStateException("Event object was not initialized properly: page model is not available.");
            }
            res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"), page.getCCSLocale().getLocale());
        }
        MessageFormat fmt = new MessageFormat(resString);
        result = fmt.format(values);
        return result;
    }
}


//End Event class

