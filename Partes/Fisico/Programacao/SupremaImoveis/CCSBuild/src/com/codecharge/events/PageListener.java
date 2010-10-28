//PageListener @0-75EB0C58
/*
 * $Revision: 1.3 $
 * $Date: 2005/01/17 08:51:52 $
 */
package com.codecharge.events;

import com.codecharge.util.cache.ICacheListener;

public interface PageListener extends ICacheListener{
    public void beforeInitialize(Event e);
    public void afterInitialize(Event e);
    public void beforeShow(Event e);
    public void onInitializeView(Event e);
    public void beforeOutput(Event e);
    public void beforeUnload(Event e);
}


//End PageListener

