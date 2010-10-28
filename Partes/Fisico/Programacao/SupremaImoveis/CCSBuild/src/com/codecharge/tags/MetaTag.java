//MetaTag class @0-B65BC380
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpServletRequest;
import com.codecharge.util.*;
import com.codecharge.Names;

public class MetaTag extends TagSupport {
    
    private String header;
    private String content;

    public void setHeader(String header) {
      this.header = header;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public int doStartTag() {
      if ("content-type".equalsIgnoreCase(header)) {
        if (content == null) {
          CCSLocale ccsLocale = ((CCSLocale) SessionStorage.getInstance((HttpServletRequest) pageContext.getRequest()).getAttribute(Names.CCS_LOCALE_KEY));
          //String enc = ccsLocale.getCharacterEncoding();
	  String enc = pageContext.getResponse().getCharacterEncoding();
          this.content = "text/html; charset="+enc;
        }
      }
      StringBuffer metaBody = new StringBuffer("<meta http-equiv=\""+this.header+"\" content=\""+this.content+"\">");
      try {
        pageContext.getOut().print(metaBody);
      } catch(Exception exception) {
        throw new Error("IO problems");
      }
      return SKIP_BODY;
    }
}

//End MetaTag class

