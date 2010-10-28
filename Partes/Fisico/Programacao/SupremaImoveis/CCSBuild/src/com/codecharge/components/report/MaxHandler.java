//CountHandler component @0-C0487DC0
/*
 * $Revision: 1.3 $
 * $Date: 2005/02/18 14:22:00 $
 */
package com.codecharge.components.report;

import com.codecharge.components.Report;
import com.codecharge.components.ReportLabel;

public class MaxHandler extends FunctionHandler {
    
    private static final String MAX_VALUE_SUFFIX = ".Max.Value";
    
	public void execute(ReportLabel control, Number number) {
        if (control == null) {
            throw new IllegalArgumentException("Parameter control cannot be null."); 
        }
        Report report = (Report) control.getParent();
        MutableDouble maxValue = Report.getMutableAttribute(report, control.getName()
                + MAX_VALUE_SUFFIX, true, 0);
        if (number != null) {
            maxValue = Report.getMutableAttribute(report, control.getName()
                    + MAX_VALUE_SUFFIX, number.doubleValue());
            if (number.doubleValue() > maxValue.doubleValue()) {
                maxValue.setValue(number.doubleValue());
            } else if (control.getValue() != null) {
                if (((Number) control.getValue()).doubleValue() > maxValue.doubleValue()) {
                    maxValue.setValue(((Number) control.getValue()).doubleValue());
                }
            }
        }
        control.setFunctionValue(maxValue);
        control.setCalculatedValue(control.getFunctionValue());
    }
}

//End CountHandler component

