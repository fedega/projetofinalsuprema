//ICache class @0-DF33F0AB
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.cache;


public interface ICache {
    
    int OPERATION_GET = 1;
    int OPERATION_PUT = 2;
    int OPERATION_DISABLE = 3;
    int OPERATION_CLEAR = 4;
    
    void init();
    void finalize();
    
    String getCacheKey(String page, javax.servlet.ServletRequest req);
    String getPageKey(String page);

    /**
     * Returns the cached object by given key if it exists or null 
     * if object was not found in cache.
     * @param key
     */
    Object getObject(String key);
    
    /**
     * Saves the object to cache with the given key.
     * @param key
     * @param value
     */
    void putObject(String key, Object value, int duration);

    /**
     * Removes the cached object with the given key.
     * @param key
     */
    void removeObject(String key);
    
    //TODO: remove?
    //boolean isExists(String key);
    
    /**
     * Removes all cached object that started with the given key.
     * This method is used to remove from cache all object related to specified page.
     * @param pageKey
     */ 
    void clearStartedWith(String pageKey);

    /**
     * Removes all expired cached objects.
     */ 
    void clearExpired();

    /**
     * Removes all cached object.
     */
    void clear();


}


//End ICache class

