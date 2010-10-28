//VariableTag class @0-E8D47F35
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import com.codecharge.util.ModelAttribute;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class AttributeTag extends TagSupport {

    private String name;
    private String owner;

    public void setName(String name) {this.name = name;}
    public void setOwner(String owner) {this.owner = owner;}

    public int doStartTag() {
        if (name == null || owner == null) return SKIP_BODY;

        Page page = (Page)pageContext.getAttribute("page");
        Object parent = pageContext.getAttribute("parent");

        Model model = null;

        if ("page".equals(owner)) {
            model = page;
        } else if ( owner.equals ( ((Model) parent).getName() ) ) {
            model = (Model)parent;
        } else {
            try {
                model = (Model)((Component) parent).getChild(owner);
            } catch (NoSuchComponentException e) {
                return SKIP_BODY;
            }
        }

        if ( ! model.isBeforeShow() ) {
          if (model instanceof Control) {
            ((Control)model).fireBeforeShowEvent(new Event());
          }
        }

 Object value = null;
        if (!(name.equalsIgnoreCase("pathtoroot"))){
        	ModelAttribute mattr = (ModelAttribute) model.getAttribute(name);
    
//        if ( mattr!=null && "DataField".equals (mattr.getSourceType()) ) {
//            System.out.println("DFATTR_["+mattr.getName()+"]["+mattr.getValue()+"]["+mattr.hashCode()+"]");
//        }

//System.out.println("In AttributeTag name ["+mattr.getName()+"] value ["+mattr.getValue()+"] hashCode ["+mattr.hashCode()+"]");
        	if (mattr == null) {
        		return SKIP_BODY;
        	}
        	String name = mattr.getName();
        	String source = mattr.getSourceName();
        	String soureType = mattr.getSourceType();
        	value =  mattr.getValue();
        	if (value == null) value = "";
        } else {
        	value = model.getAttribute("CCS_PathToRoot");
        	if (value == null) value = "";
        }        
		
		try {
            pageContext.getOut().print(value);
        } catch(Exception exception) {
            throw new Error("IO problems");
        }                             

        return SKIP_BODY;
    }
}


//End VariableTag class

