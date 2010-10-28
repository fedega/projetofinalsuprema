//ISection class @0-102DD658
/*
 * $Revision: 1.2 $
 * $Date: 2004/11/05 15:35:33 $
 */
package com.codecharge.components;

import com.codecharge.events.SectionListener;


public interface ISection {
    public boolean isVisible();
    public void setVisible(boolean visible);
    public void addListener(SectionListener l);
    public void removeListener(SectionListener l);
    public void setHeight(double height);
    public double getHeight();
}

//End ISection class

