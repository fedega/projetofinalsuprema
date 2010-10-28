//ResourceVariable class @0-9F07C5F4
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template.structure;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;
import com.codecharge.util.StringUtils;
import com.codecharge.util.CCLogger;


public class ResourceVariable extends TemplateVariable {

    protected Locale locale;
    
    public ResourceVariable() {
    }

    public void setBody(String key) {
        this.body.setLength(0);
        addToBody(key);
    }

    public void addToBody(String key) {
        this.body.append(getString(key));
    }

    private String getString(String key) {
        try {
            ResourceBundle res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"), this.locale);
            return key == null ? "!key is null!" : res.getString(key);
        } catch (MissingResourceException e) {
            CCLogger.getInstance().error("", e);
        }
        return key;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

//End ResourceVariable class

