//IDataProvider @0-A7646B26

package com.codecharge.features;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public interface IDataProvider {

    public HashMap getAllDataAsHash ();


    public Object getData (String name);
    public Object getRowData (String name);
    public Object getData (String groupName, String name);
    public Object getRowData (String groupName, String name);

    public Map getAllData ();
    public Map getAllGroups ();
    public Collection getAllRows ();
    public Collection getAllGroupRows (); 

    public void nextRow();
}


//End IDataProvider

