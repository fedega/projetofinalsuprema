//PageSettings class @0-645AB497
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class PageSettings {
    private boolean cacheEnabled;
    private int duration;
    private String name;
    private Map parameters = new HashMap();
    private Map keyParameters = new HashMap();
    private Map disableParameters = new HashMap();
    private Map clearParameters = new HashMap();
    private ICacheListener listener;
    
    public boolean isCacheEnabled() {
        return cacheEnabled;
    }
    public void setCacheEnabled(boolean cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public synchronized void addParameter(CachingParameter parameter) {
        if (parameter == null || parameter.getName() == null) {
            return;
        }
        parameters.put(parameter.getName(), parameter);
        switch (parameter.getType()) {
            case CachingParameter.TARGET_CACHING_KEY:
                keyParameters.put(parameter.getName(), parameter);
                break;
            case CachingParameter.TARGET_CLEAR_CACHE:
                clearParameters.put(parameter.getName(), parameter);
                break;
            case CachingParameter.TARGET_DISABLE_CACHING:
                disableParameters.put(parameter.getName(), parameter);
                break;
        }
    }
    
    public CachingParameter getParameter(String name) {
        return (CachingParameter) parameters.get(name);
    }
    
    /** 
     * Returns iterator for unmodifiable collection of page caching parameters.
     * Returns iterator for unmodifiable collection of page caching parameters.
     */
    public Iterator getParameters() {
        return Collections.unmodifiableCollection(parameters.values()).iterator();
    }
    
    public ICacheListener getCacheListener() {
        return listener;
    }
    public void setCacheListener(ICacheListener listener) {
        this.listener = listener;
    }
    
    public void fireOnCacheEvent(CacheEvent e) {
        if (this.listener != null) {
            this.listener.onCache(e);
        }
    }
    /** 
     * Returns iterator for unmodifiable collection of page caching 'clear' parameters.
     * @return iterator for unmodifiable collection of page caching 'clear' parameters
     */
    public Iterator getClearParameters() {
        return Collections.unmodifiableCollection(clearParameters.values()).iterator();
    }
    /** 
     * Returns iterator for unmodifiable collection of page caching 'disable' parameters.
     * @return iterator for unmodifiable collection of page caching 'disable' parameters
     */
    public Iterator getDisableParameters() {
        return Collections.unmodifiableCollection(disableParameters.values()).iterator();
    }
    /** 
     * Returns iterator for unmodifiable collection of page caching 'keyPart' parameters.
     * @return iterator for unmodifiable collection of page caching 'keyPart' parameters
     */
    public Iterator getKeyParameters() {
        return Collections.unmodifiableCollection(keyParameters.values()).iterator();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("\nname: "+name+" cacheEnabled: "+cacheEnabled+" duration: "+duration+"\n");
        sb.append("\nNumber of keyParameters: "+keyParameters.size()+" disableParameters: "+disableParameters.size()+" clearParameters: "+clearParameters.size()+" total: "+parameters.size()+"\n");
        if (! parameters.isEmpty()) {
            sb.append("Parameters:\n");
            for (Iterator it = parameters.keySet().iterator(); it.hasNext(); ) {
                sb.append(parameters.get(it.next().toString())+"\n");
            }
        }
        return sb.toString();
    }
}


//End PageSettings class

