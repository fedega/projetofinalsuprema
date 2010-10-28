//ControllerListener @0-8DF0C407
package com.codecharge.events;

public interface ControllerListener {

    public void appInitializing( AppEvent e );
    public void appInitialized( AppEvent e );
    public void appDestroyed( AppEvent e );

    public void controllerInitializing( ControllerEvent e );

}
//End ControllerListener

