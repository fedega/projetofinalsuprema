//CountHandler component @0-0D1EBBF8
/*
 * $Revision: 1.4 $
 * $Date: 2005/02/18 14:21:49 $
 */
package com.codecharge.components.report;

import com.codecharge.components.Report;
import com.codecharge.components.ReportLabel;

public class MinHandler extends FunctionHandler {
    
    private static final String MIN_VALUE_SUFFIX = ".Min.Value";
    
    //TODO: implement count all and non-null only rows
	public void execute(ReportLabel control, Number number) {
        if (control == null) {
            throw new IllegalArgumentException("Parameter control cannot be null."); 
        }
        Report report = (Report) control.getParent();
        MutableDouble minValue = Report.getMutableAttribute(report, control.getName()
                + MIN_VALUE_SUFFIX, true, 0);
        if (number != null) {
            minValue = Report.getMutableAttribute(report, control.getName()
                    + MIN_VALUE_SUFFIX, number.doubleValue());
            if (number.doubleValue() < minValue.doubleValue()) {
                minValue.setValue(number.doubleValue());
            } else if (control.getValue() != null) {
                if (((Number) control.getValue()).doubleValue() < minValue.doubleValue()) {
                    minValue.setValue(((Number) control.getValue()).doubleValue());
                }
            }
        }
        control.setFunctionValue(minValue);
        control.setCalculatedValue(control.getFunctionValue());
    }
}




//End CountHandler component

