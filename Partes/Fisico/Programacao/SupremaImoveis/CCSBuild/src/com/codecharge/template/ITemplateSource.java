//ITemplateSource class @0-F058B84A
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template;

import java.io.Reader;
import java.util.Locale;

import javax.servlet.ServletContext;


public interface ITemplateSource {
    Reader getReader(String templateName);
    void setServletContext(ServletContext context);
    void setEncoding(String encoding);
    void setLocale(Locale locale);
}

//End ITemplateSource class

