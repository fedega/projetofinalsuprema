//ITemplateParser class @0-FCA6B754
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template;

import java.io.Reader;
import java.util.Map;
import java.util.Locale;


public interface ITemplateParser {
    Map parse(Reader reader);
    void setLocale(Locale locale);
}

//End ITemplateParser class

