//CaptchaProperty Tag class @0-CDF228BF
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class CaptchaPropertyTag extends TagSupport {

    private String name;

    public void setName(String name) {this.name = name;}

    private String property;
    public void setProperty(String property) {this.property = property;}


    public int doStartTag() {

        if (name == null) return SKIP_BODY;

		String value = "";

		com.codecharge.components.Captcha captcha = 
				(com.codecharge.components.Captcha)pageContext.getAttribute("parent");

			if ( "name".equalsIgnoreCase(property) ) {
				value = captcha.getName();
			};

			if ( "name".equalsIgnoreCase(name) ) {
				value = captcha.getName();
			} else if ( "width".equalsIgnoreCase(name) ) {
				value = ""+captcha.getImageWidth();
			} else if ( "height".equalsIgnoreCase(name) ) {
				value = ""+captcha.getImageHeight();
			} 


        try {
          pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;

    }
}
//End CaptchaProperty Tag class

