//Model component @0-C2DD8A87
package com.codecharge.components;

import com.codecharge.util.*;
import com.codecharge.util.multipart.*;
import java.util.*;
/*import java.util.Vector;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Collection;*/

/** Model is the base class for all component models and holds all components common properties.
 * CCS employ Model-View-Controller paradigm and Model is the place where all data from Controller is stored
 * and all needed data for View is taken.
 */
public class Model implements Cloneable {

    /** Event handlers collection. */
    protected Vector listeners = new Vector();
    /** Name. */
    protected String name;
    /** Value of control name attribute in HTML. */
    protected String htmlName;
    /** Parameters to exclude from request collection. */
    protected Vector excludeParams = new Vector();
    /** Prefix to form request parameter name with value. */
    protected String prefix;
    /** Visible. */
    protected boolean visible = true;
    /** Parent of this model. */
    protected Component parent;

    protected boolean beforeShow = false;

//-----------------------------------------------------------------------------------------
    protected HashMap attributes = new HashMap();
    protected HashMap rowAttributes = new HashMap();

//    protected int currentAttrRow = 0;
    protected HashMap attributesRows = null;

   
    //indicate that component is processed (parameter ccsForm euqals name of
    // component)


    ///**
    // * Gets the Component attribute by specified name 
    // * @param name Name of attribute
    // * /
    public ModelAttribute getRowAttribute (String name) {
        return (ModelAttribute)rowAttributes.get(name);
    }

    public void addAttributesRow(Object key,HashMap row) {
        if (attributesRows == null) attributesRows = new HashMap();
        attributesRows.put(key, row);
    }

    public Object getAttribute(String name) {
        Object attr = attributes.get(name);

        if (attr != null) {
            if (! (attr instanceof ModelAttribute) ) return attr;
            if ("DataField".equals ( ((ModelAttribute)attr).getSourceType() )) {

                Object key = getRowKey();
                if ( key!=null && attributesRows!=null ) {

                    Object value = null;
                    if (this instanceof Component) {
                        if (attributesRows!=null && attributesRows.get(key) != null)  {
                            value = "" + ((HashMap)attributesRows.get(key)).get(name);
                        }
                    }

                    if (value == null) value = "";
                    ((ModelAttribute)attr).setValue(""+value);
                }
            }
        }



        if (attr == null) {
            ModelAttribute attr1 = new ModelAttribute ();
            attr1.setName(name);
            attr1.setSourceType("Expression");
            attr1.setSourceName("");
            attr1.setId(0);
            attributes.put(name, attr1);
            attr=attr1;
        }

        return attr;
    }

    /*public void nextAttrRow() {
        currentAttrRow++;
    }*/

    public Collection getAttributeKeys() {
        return Collections.unmodifiableCollection(attributes.keySet());
    }
    public Collection getRowAttributeKeys() {
        return Collections.unmodifiableCollection(rowAttributes.keySet());
    }

    
    /**
     * Sets the Component attribute.
     * @param name Name of the attrubute
     * @param value Value of the attribute
     */
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public void setRowAttribute (String name, Object value) {
        rowAttributes.put(name, value);
    }

    public void setAttributes (HashMap map) {
        attributes.putAll (map);
    }



    /** ???UNDER QUESTION ???*/
    public void setAttributes (Object obj) {
        if (obj instanceof Model) {
            Model comp = (Model)obj;
            Iterator it = comp.getAttributeKeys().iterator();
            while (it.hasNext()) {
                String key = (String)it.next();
                Object attr = comp.getAttribute(key);
                if (attr instanceof ModelAttribute) {
                    ModelAttribute mAttr = (ModelAttribute) attr;

                    String name = mAttr.getName();
                    String source = mAttr.getSourceName();
                    String soureType = mAttr.getSourceType();

                    Object value = null;

                    Page cPageModel = null;
                    if (comp instanceof Page) {
                        cPageModel = (Page)comp;
                    } else if (comp instanceof Component) {
                        cPageModel = ((Component)comp).getPageModel();
                    } else if (comp instanceof Control) {
                        cPageModel = ((Control)comp).getPage();
                    } else if (comp instanceof Button) {
                        cPageModel = ((Button)comp).getPage() ;
                    } else if (comp instanceof Sorter) {
                        cPageModel = ((Sorter)comp).getPage();
                    } 

                    if ( "URL".equals(soureType) ) {
                        mAttr.setValue ( cPageModel.getHttpGetParameter(source) );
                    } else if ( "Form".equals(soureType) ) {
                        mAttr.setValue ( cPageModel.getHttpPostParams().getParameter(source) );
                    } else if ( "Session".equals(soureType) ) {
                        mAttr.setValue ( SessionStorage.getInstance(cPageModel.getRequest()).getAttribute(source) );
                    } else if ( "Application".equals(soureType) ) {
                        mAttr.setValue ( ContextStorage.getInstance().getAttribute(source) );
                    } else if ( "Cookie".equals(soureType) ) {


                        if (cPageModel.getRequest().getCookies() != null) {
                            mAttr.setValue ( StringUtils.getCookie(source, cPageModel.getRequest().getCookies()) );
                        }
                    }

                    if ( mAttr.getValue () == null ) mAttr.setValue("");

                }
            }
        }
    }



    
    /**
     * Removes attribute from Component
     * @param name
     * /
    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    /**
     * Removes all attributes if them names start with given prefix
     * @param prefix 
     */
    public void removeAttributesByPrefix(String prefix) {
        Set temp = null;
        synchronized (this) {
            temp = Collections.unmodifiableSet(((HashMap) attributes.clone()).keySet());
        }
        for (Iterator keys = temp.iterator(); keys.hasNext(); ) {
            String key = (String) keys.next();
            if (key.startsWith(prefix)) {
                attributes.remove(key);
            }
        }
    }


    private void cloneAttributes() {
        HashMap attributes1 = new HashMap();
        attributes1.putAll (attributes);
        attributes = attributes1;
    }
//-----------------------------------------------------------------------------------------


    /** Create new model with name. */
    public Model (String name) {
        this.name = name;
        this.htmlName = name;
    }

    /** Set model name. */
    public void setName (String name) {this.name = name;}
    /** Get model name. */
    public String getName () {return name;}

    /** Set value of the HTML input name attribute. */
    public void setHtmlName (String htmlName) {this.htmlName = htmlName;}
    /** Get value of the HTML input name attribute. */
    public String getHtmlName () {return htmlName;}

    public void setBeforeShow( boolean flag ) {
        this.beforeShow = flag;
    }

    public boolean isBeforeShow() {
        return beforeShow;
    }

    /** Get the parent component that contains this control or component.
       @return parent component */
    public Component getParent() { return parent; }
    /** Set parent component. */
    public void setParent( Component parent ) { this.parent = parent; }

    /** Add collection of string that indicate parameters that should be removed from request query. */
    public void addExcludeParams(Collection excludeParams) {
        this.excludeParams.addAll(excludeParams);
    }

    /** Add parameter that should be removed from request query. */
    public void addExcludeParam(String param) {
        excludeParams.add(param);
    }

    /** Get collection of string that indicate parameters that should be removed from request query. */
    public Vector getExcludeParams() {
        return excludeParams;
    }

    /** Set prefix to retrieve model value. */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /** @deprecated Replaced by {@link #getQuery(QueryString)}. */
    public String getQuery(String query) {
        String result = "";
        if (query == null) return result;
        StringTokenizer st = new StringTokenizer(query, "&");
        while (st.hasMoreTokens()) {
            String elm = st.nextToken();
            Iterator i = excludeParams.iterator();
            boolean drop = false;
            while (i.hasNext()) {
                String p = (String)i.next();
                if (prefix == null) {
                    if (elm.startsWith(p)) drop = true;
                } else {
                    if (elm.startsWith(prefix+p)) drop = true;
                }
            }
            if (!drop) result += "&" + elm;
        }
        return result;
    }
    /** Get Query string with excludParams excluded. */
    public String getQuery( QueryString query ) {
        String result = "";
        if (query == null) return result;
        if ( excludeParams.size() == 0 ) 
            result = query.toString();
        else {
            String prefixPar = (prefix==null) ? "" : prefix;
            String[] p = new String[excludeParams.size()];
            for ( int i = 0; i < excludeParams.size(); i++ ) {
                p[i] = prefix + ( (String) excludeParams.get(i) );
            }
            result = query.toString( p );
        }
        return result;
    }
    
    /** Get Query string with excludParams excluded. */
    public String getQuery( RequestParameters query ) {
        /*String result = "";
        if (query == null) return result;
        if ( excludeParams.size() == 0 ) 
            result = query.toString();
        else {
            String prefixPar = (prefix==null) ? "" : prefix;
            String[] p = new String[excludeParams.size()];
            for ( int i = 0; i < excludeParams.size(); i++ ) {
                p[i] = prefix + ( (String) excludeParams.get(i) );
            }
            result = query.toString( p );
        }
        return result;*/
        return query.toString(excludeParams);
    }
    
    /** Whether this control should be shown.
      @return visibility state, false means hidden */
    public boolean isVisible() {
        return visible;
    }

    /** Specify whether this control or component should be shown.
       @param visible visibility boolean state, false means hidden */
    public void setVisible( boolean visible ) {
        this.visible = visible;
    }

    /** Get Event handlers collection. */
    public Iterator getListeners() {return listeners.iterator();}
    
    /** Copy model. */
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
            ((Model)obj).beforeShow = false;
            ((Model)obj).cloneAttributes();
        } catch (CloneNotSupportedException cnse) {
            CCLogger.getInstance().error("", cnse);
        }
        return obj;
    }

    public Object getRowKey () {
        return null;
    }
    
}

//End Model component

