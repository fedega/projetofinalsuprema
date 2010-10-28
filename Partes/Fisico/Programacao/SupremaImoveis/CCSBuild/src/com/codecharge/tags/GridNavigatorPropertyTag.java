//GNPropertyTag class @0-DCD40749
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class GridNavigatorPropertyTag extends TagSupport {

    private String name;
    public void setName(String name) {this.name = name;}

    public int doStartTag() {

        if (name == null) return SKIP_BODY;

		Navigator navigator = (Navigator)pageContext.getAttribute("navigator");
		String value = "";

		if ("FormName".equals(name)) {
			value = navigator.getParent().getName();
		} else if ("Name".equals(name)) {
			value = "" + pageContext.getAttribute("~~~Name");
		}  else if ("Value".equals(name)) {
			value = "" + pageContext.getAttribute("~~~Value");
			value = value.substring(value.indexOf("=")+1);
		} else if ("PageSize_Options".equals(name)) {
			Iterator it1 = navigator.getPageSizes().iterator();
			String s = "";
			while(it1.hasNext()) {
				String a = "" + it1.next();
				s = s + "<option value=\""+a+"\">"+a+"</option>";
			}
			boolean isXHTMLUsed;
	 	        isXHTMLUsed = new Boolean(StringUtils.getSiteProperty("isXHTMLUsed")).booleanValue();
			if (isXHTMLUsed) value = s.toUpperCase(); else value = s;
		}

        try {
			pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;
    }

}
//End GNPropertyTag class

