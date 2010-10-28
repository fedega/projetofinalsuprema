//FileTemplateSource class @0-CA31DE3E
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.ServletContext;

import com.codecharge.util.CCLogger;
import com.codecharge.util.ContextStorage;
import com.codecharge.util.StringUtils;


public class FileTemplateSource implements ITemplateSource {

    protected ServletContext servletContext;
    protected CCLogger logger = CCLogger.getInstance();
    protected boolean useLocalizatedTemplate;
    protected String encoding;
    protected Locale locale;
    
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    /**
     * @see com.codecharge.template.ITemplateSource#getBufferedReader(java.lang.String)
     */
    public Reader getReader(String templateName) {
        logger.debug("FileTemplateSource.getReader: Looking for '"+templateName+"' template...");
        Reader br = null;
        InputStream is = null;
        templateName = getActualTemplateName(templateName);
        try {
            if ("false".equals( (String) ContextStorage.getInstance().getAttribute( "usedUnpackedWarFile" ) ) ) {
            //if (ContextStorage.getInstance().getAttribute("usedUnpackedWarFile") == null) {
                is = servletContext.getResourceAsStream(templateName);
                if (is == null) {
                    throw new RuntimeException(
                            "Unable to load template: servletContext.getResourceAsStream("
                            + templateName + ") returns null.");
                }
            } else {
                is = new FileInputStream(servletContext.getRealPath(templateName));
            }
            if (StringUtils.isEmpty(this.encoding)) {
                br = new InputStreamReader(is);
            } else {
                br = new InputStreamReader(is, this.encoding);
            }
        } catch (FileNotFoundException fnfe) {


            throw new RuntimeException("Unable to load template." + fnfe.getMessage());



        } catch (UnsupportedEncodingException e) {
            if (is != null) {
                br = new InputStreamReader(is);
            }
        }
        if (br == null) {
            throw new RuntimeException("Unable to load template. Unrecognized error.");
        }
        StringBuffer sb = new StringBuffer();
        BufferedReader bufr = new BufferedReader(br);
        try {
            String line = bufr.readLine();
            while (line != null) {
                sb.append(line+"\n");
                line = bufr.readLine();
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Unable to load template. Unrecognized error.");
        }
        try {
            bufr.close();
        } catch (IOException ioe) {}
        try {
            br.close();
        } catch (IOException ioe) {}
        return new StringReader(sb.toString());
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        String useLT = StringUtils.getSiteProperty("useLocalizatedTemplate", "false");
        if (! StringUtils.isEmpty(useLT)) {
            this.useLocalizatedTemplate = new Boolean(useLT).booleanValue();
        }
    }

    protected String getActualTemplateName(String name) {
        String result = name;
        if (useLocalizatedTemplate && !StringUtils.isEmpty(name)) {
            String[] fileNames = getPossibleFileNames(name);
            for (int i = fileNames.length - 1; i > -1; i--) {
                if (isExists(fileNames[i])) {
                    result = fileNames[i];
                    break;
                }
            }
        }
        return result;
    }
    
    private boolean isExists(String fileName) {
        boolean result = false;
        InputStream tmpl_stream = null;
        try {
            if (servletContext.getAttribute("usedUnpackedWarFile") == null) {
                tmpl_stream = servletContext.getResourceAsStream(fileName);
            } else {
                tmpl_stream = new java.io.FileInputStream(servletContext.getRealPath(fileName));
            }
            if (tmpl_stream != null) {
                result = true;
                tmpl_stream.close();
            }
        } catch (IOException ioe_ignore) {
        } 
        tmpl_stream = null;
        return result;
    }
    
    private String getEncodingNamePart(String encoding) {
        String result = encoding;
        if (encoding != null && encoding.length() != 0) {
            try {
                byte[] tmp = "test".getBytes(encoding);
            } catch (java.io.UnsupportedEncodingException uee) {
                result = null;
            }
        } else {
            result = null;
        }
        return getNamePart(result);
    }
    
    private String[] getPossibleFileNames(String name) {
        String language = getNamePart(locale.getLanguage());
        String country = getNamePart(locale.getCountry());
        String variant = getNamePart(locale.getVariant());
        encoding = getEncodingNamePart(encoding);

        String[] fileNames = new String[5];
        fileNames[0] = name;
        int pos = name.lastIndexOf(".");
        String ext = "";
        if (pos > -1) {
            ext = name.substring(pos);
            name = name.substring(0, pos);
        }
        fileNames[1] = name + language + ext;
        fileNames[2] = name + language + country + ext;
        fileNames[3] = name + language + country + encoding + ext;
        fileNames[4] = name + language + country + variant + encoding + ext;
        return fileNames;
    }
    
    private String getNamePart(String value) {
        return (StringUtils.isEmpty(value) ? "" : "_" + value);
    }

}

//End FileTemplateSource class

