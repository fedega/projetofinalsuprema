//ITemplateItem class @0-264D51F0
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template.structure;



public interface ITemplateItem {
    public String getPath();
    public void setPath(String path);

    public StringBuffer getBody();
    public void setBody(StringBuffer body);
    public void addToBody(StringBuffer body);

    StringBuffer parse();
    public boolean isParsed();
    public void setParsed(boolean parsed);
    void setAccumulate(boolean accumulate);
    void setTargetItem(ITemplateItem target);
}

//End ITemplateItem class

