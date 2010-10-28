//ITemplate class @0-26DB5605
/*
 * $Revision: 1.2 $
 * $Date: 2005/04/29 08:26:08 $
 */
package com.codecharge;

import java.util.Locale;

import javax.servlet.ServletContext;

import com.codecharge.template.ITemplateParser;
import com.codecharge.template.ITemplateSource;


public interface ITemplate {
    final static public int BLOCK = 0;
    final static public int VARIABLE = 1;

    final static public int IF_DOESNT_EXIST_DO_NOTHING = 1;
    final static public int IF_DOESNT_EXIST_IS_ERROR = 0;
    
    void setServletContext(ServletContext context);
    void setTemplateSource(ITemplateSource src);
    void setTemplateParser(ITemplateParser parser);
    void setEncoding(String encoding);
    void setLocale(Locale locale);
    
    void load(String templateName);
    
    void setVar(String name, String value, int mode);
    void setTag(String pathTo, String varName, String value, int mode);
    void setVar(String name);
    void setTag(String pathTo, String varName);
    void setVar(String name, String value);
    void setTag(String pathTo, String varName, String value);
    void setVar(String name, int mode);
    void setTag(String pathTo, String varName, int mode);
    String renderBlock(String pathTo, String blockName, boolean accumulate,
            String target, int mode);
    String renderBlock(String blockName, boolean accumulate, String target, int mode);
    String parseAndPrint(String blockName, boolean accumulate, String target, int mode);
    String parse(String blockName, boolean accumulate, String target, int mode);
    String parse(String blockName, boolean accumulate, String target);
    String parse(String blockName, boolean accumulate);
    String parse(String blockName);
    String parse(String blockName, boolean accumulate, int mode);
    String parse(String blockName, int mode);
    String render(String blockName, boolean accumulate, String target, int mode);
    String render(String pathTo, String blockName, boolean accumulate, String target, int mode);
    String render(String blockName, boolean accumulate, String target);
    String render(String blockName, boolean accumulate);
    String render(String pathTo, String blockName, boolean accumulate);
    String render(String blockName);
    String render(String pathTo, String blockName);
    String render(String pathTo, String blockName, boolean accumulate, int mode);
    String render(String blockName, boolean accumulate, int mode);
    String render(String blockName, int mode);

    String parseAndPrintForUpdatePanel(String blockName, boolean accumulate);

    boolean isExists(String path, int type);
    String getVar(String name);
    void hideBlock(String blockName);
    String pParse(String blockName, boolean accumulate);
    String parseTo(String blockName, boolean accumulate, String target);
}


//End ITemplate class

