//IDataRender @0-2DAA4DE2

package com.codecharge.features;

public interface IDataRender {
    
    public String render ();
    //public void setData(HashMap data);
    public void setData (IDataProvider data);
    public void setData (Object data);

}


//End IDataRender

