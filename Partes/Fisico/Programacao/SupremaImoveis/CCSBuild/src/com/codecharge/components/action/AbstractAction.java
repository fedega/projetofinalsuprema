//AbstractAction class @0-FDA98BE1
/*
 * $Revision: 1.2 $
 * $Date: 2005/05/26 14:04:12 $
 */
package com.codecharge.components.action;

import java.util.Iterator;

import com.codecharge.Action;
import com.codecharge.components.Calendar;
import com.codecharge.components.Link;
import com.codecharge.db.DbRow;
import com.codecharge.db.IDataBinder;
import com.codecharge.db.IRowProvider;
import com.codecharge.db.ObjectDataBinder;
import com.codecharge.db.ObjectRowProvider;
import com.codecharge.db.ParameterSource;
import com.codecharge.util.LinkParameter;
import com.codecharge.util.ModelAttribute;

public abstract class AbstractAction {

    protected Action action;
    protected IDataBinder dataBinder;
    protected IRowProvider rowProvider;
    
    public AbstractAction() {      
    }
    
    public AbstractAction(Action action) {
        this.action = action;
        this.dataBinder = new ObjectDataBinder();
        this.rowProvider = new ObjectRowProvider();
    }


    protected boolean read() {
        return true;
    }
    
    public IDataBinder getDataBinder() {
        return dataBinder;
    }
    public void setDataBinder(IDataBinder dataBinder) {
        this.dataBinder = dataBinder;
    }
    
    public IRowProvider getRowProvider() {
        return rowProvider;
    }
    public void setRowProvider(IRowProvider rowProvider) {
        this.rowProvider = rowProvider;
    }
    
    protected void setLinkProperties(Object row, DbRow outDbParameters, Link link) {
        if ("Database".equals(link.getHrefType()) || "DBParameter".equals(link.getHrefType())) {
            Object href = dataBinder.getFieldValue(row, outDbParameters, link.getHrefType(), link.getHrefSource());
            if (href == null) {
                link.setHrefSourceValue("");
            } else {
                link.setHrefSourceValue(href);
            }
        }
        for (Iterator itParams = link.getParameters().iterator(); itParams.hasNext();) {
            LinkParameter param = (LinkParameter) itParams.next();
            ParameterSource type = param.getSourceType();
            if (type == ParameterSource.DATAFIELD) {
                Object dsVal = dataBinder.getFieldValue(row, outDbParameters, "DataSource", param.getSourceName());
                if (dsVal == null) {
                    param.setValue("");
                } else {
                    param.setValue(dsVal);
                }
            } else if (type == ParameterSource.DBPARAMETER) {
                Object dsVal = dataBinder.getFieldValue(row, outDbParameters, "DBParameter", param.getSourceName());
                if (dsVal == null) {
                    param.setValue("");
                } else {
                    param.setValue(dsVal);
                }
            } else if (type == ParameterSource.CALENDARSPECIALVALUE) {
                if ("CurrentProcessingDate".equals(param.getSourceName())) {
                    param.setValue(((Calendar) link.getParent()).getCurrentItem().getDate());
                } else if ("NextProcessingDate".equals(param.getSourceName())) {
                    param.setValue(((Calendar) link.getParent()).getCurrentItem().getNextDate());
                } else if ("PrevProcessingDate".equals(param.getSourceName())) {
                    param.setValue(((Calendar) link.getParent()).getCurrentItem().getPreviousDate());
                }
            }
        }
    }
    
    boolean validate() {
        return true;
    }



    protected ModelAttribute bindRowAttribute (ModelAttribute attr, Object row, IDataBinder binder) {

        ModelAttribute cAttr = attr.cloneAttribute();
        if ("DataField".equals ( attr.getSourceType() )) {
            String source = attr.getSourceName();
            Object value = binder.getFieldValue(row, source);
            cAttr.setValue ( ""+value );
        }
        return cAttr;
    }


}


//End AbstractAction class

