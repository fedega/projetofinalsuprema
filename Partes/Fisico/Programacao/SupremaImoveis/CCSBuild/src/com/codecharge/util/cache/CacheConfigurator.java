//CacheConfigurator class @0-1A11E01C
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.cache;

import java.util.HashMap;


public class CacheConfigurator {
    private static HashMap configs = new HashMap();
    
    public static PageSettings getPageSettings(String name) {
        return (PageSettings) configs.get(name);
    }
    
    public static synchronized void setPageSettings(String name, PageSettings settings) {
        if (name != null && settings != null) {
            configs.put(name, settings);
        }
    }
}


//End CacheConfigurator class

