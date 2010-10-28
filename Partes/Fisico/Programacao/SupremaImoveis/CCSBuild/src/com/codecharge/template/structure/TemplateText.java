//TemplateText class @0-777474AF
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template.structure;



public class TemplateText implements ITemplateItem {

    protected String path;
    protected StringBuffer body = new StringBuffer();
    protected ITemplateItem target;

    public StringBuffer getBody() {
        return body;
    }

    public void setBody(StringBuffer body) {
        this.body.setLength(0);
        addToBody(body);
    }

    public void addToBody(StringBuffer body) {
        if (body != null) {
            this.body.append(body);
        }
    }
    
    public void addToBody(String body) {
        if (body != null) {
            this.body.append(body);
        }
    }
    public String toString() {
        return body.toString();
    }
    
    public StringBuffer parse() {
        return getBody();
    }
    
    public boolean isParsed() {
        return true;
    }
    public void setParsed(boolean parsed) {
        //do hothing
    }
    
    public void setAccumulate(boolean accumulate) {
        //do hothing
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setTargetItem(ITemplateItem target) {
        this.target = target;
    }
}

//End TemplateText class

