//TemplateNamedItem class @0-F83017EE
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template.structure;



abstract public class TemplateNamedItem extends TemplateText implements ITemplateNamedItem {

    protected String name;
    protected boolean visible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name + ": " + this.body;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}

//End TemplateNamedItem class

