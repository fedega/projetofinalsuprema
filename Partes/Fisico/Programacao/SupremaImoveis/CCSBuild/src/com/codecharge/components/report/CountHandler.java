//CountHandler component @0-9949D078
/*
 * $Revision: 1.7 $
 * $Date: 2005/02/18 14:17:58 $
 */
package com.codecharge.components.report;

import com.codecharge.components.ControlType;
import com.codecharge.components.ReportLabel;
import com.codecharge.util.StringUtils;

public class CountHandler extends FunctionHandler {
    public Object getInitialValue() {
        return new Integer(0);
    }
    
    //TODO: implement count all and non-null only rows
	public void execute(ReportLabel control, Number number) {
        if (control == null) {
            throw new IllegalArgumentException("Parameter control cannot be null."); //TODO: I18N
        }
        if (number == null && ! StringUtils.isEmpty(control.getFieldSource())) {
            if (control.getFunctionValue() == null) {
                control.setFunctionValue(0);
            }
            control.setCalculatedValue(control.getFunctionValue());
            return;
        }
        if (control.getFunctionValue() instanceof MutableDouble) {
            ((MutableDouble) control.getFunctionValue()).add(1);
        } else if (control.getFunctionValue() instanceof MutableSingle) {
            ((MutableSingle) control.getFunctionValue()).add(1);
        } else {
            if (control.getType() == ControlType.FLOAT) {
                control.setFunctionValue(new MutableDouble(1));
            } else {
                control.setFunctionValue(new MutableSingle(1));
            }
        }
        control.setCalculatedValue(control.getFunctionValue());
    }

}

//End CountHandler component

