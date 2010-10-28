//TemplateVariable class @0-986C6F40
package com.codecharge.util;

public class ModelAttribute {
    
    private int id;
    private String name;
    private String sourceType;
    private String sourceName;

    private String path;
    
    private Object value;


    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }
        
    public void setValue(Object value) {
        this.value = value;
    }
    public Object getValue() {
        return value;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    public String getSourceName() {
        return sourceName;
    }
    
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
    public String getSourceType() {
        return sourceType;
    }
    
    public String toString() {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }

    public String getText() {
        return toString();
    }

    public ModelAttribute cloneAttribute() {
        ModelAttribute res = new ModelAttribute();

        res.setPath(""+this.path);
        res.setValue(""+this.value);
        res.setId(0+this.id);
        res.setName(""+this.name);
        res.setSourceName(""+this.sourceName);
        res.setSourceType(""+this.sourceType);

        return res;

    }



}



//End TemplateVariable class

