//TemplateBlock class @0-6F56FBB1
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template.structure;



import java.util.HashMap;


public class TemplateBlock extends TemplateNamedItem {

    final private static String EMPTY_STRING = "";

    private ItemList children = new ItemList();
    private HashMap index = new HashMap();
    private int position;
    private boolean parsed;
    private boolean accumulate;

    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void addItem(ITemplateItem item) {
        this.children.add(item);
    }

    public ItemList getChildren() {
        return this.children;
    }

    public StringBuffer getStartTag() {
        boolean outTags = true;
        if (!"main".equalsIgnoreCase(this.getName())) {
            return new StringBuffer("<!-- BEGIN " + name + " -->");
        }
        return new StringBuffer(TemplateBlock.EMPTY_STRING);
    }

    public String getEndTag() {
        if (!"main".equalsIgnoreCase(this.getName())) {
            return new StringBuffer("<!-- END " + name + " -->").toString();
        }
        return TemplateBlock.EMPTY_STRING;
    }

    public String toString() {
        StringBuffer sb = getStartTag();
        for (java.util.Iterator it = children.iterator(); it.hasNext();) {
            sb.append(it.next().toString());
        }
        sb.append(getEndTag());
        return sb.toString();
    }

    public boolean isAccumulate() {
        return accumulate;
    }
    public void setAccumulate(boolean accumulate) {
        this.accumulate = accumulate;
    }
    
    public StringBuffer parse() {
        StringBuffer tempBody = new StringBuffer();
        for (int i = 0; i < this.children.size(); i++) {
            ITemplateItem item = this.children.get(i);
            if (item.isParsed()) {
                tempBody.append(item.getBody());
            } else {
                item.setAccumulate(false);
                tempBody.append(item.parse());
            }
            item.setParsed(false);
        }
        if (accumulate) {
            addParsedBody(tempBody);
        } else {
            setParsedBody(tempBody);
        }
        return tempBody;
    }
    
    private void setParsedBody(StringBuffer tempBody) {
        if (target != null) {
            target.setBody(tempBody);
        } else {
            this.body.setLength(0);
            this.body.append(tempBody);
        }
    }

    private void addParsedBody(StringBuffer tempBody) {
        if (target != null) {
            target.addToBody(tempBody);
        } else {
            this.body.append(tempBody);
        }
    }

    public boolean isParsed() {
        return parsed;
    }
    public void setParsed(boolean parsed) {
        this.parsed = parsed;
    }
}

//End TemplateBlock class

