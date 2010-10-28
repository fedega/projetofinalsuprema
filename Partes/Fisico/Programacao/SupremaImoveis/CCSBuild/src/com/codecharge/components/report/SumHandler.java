//SumHandler component @0-730E1EDC
/*
 * $Revision: 1.10 $
 * $Date: 2005/02/18 14:22:00 $
 */
package com.codecharge.components.report;

import com.codecharge.components.ControlType;
import com.codecharge.components.ReportLabel;


public class SumHandler extends FunctionHandler {

	public void execute(ReportLabel control, Number number) {
        if (control == null) {
        	throw new IllegalArgumentException("Control cannot be null");
        }
        if (number == null) {
            return;
        }
        
        if (control.getFunctionValue() instanceof MutableDouble) {
            ((MutableDouble) control.getFunctionValue()).add(number.doubleValue());
        } else if (control.getFunctionValue() instanceof MutableSingle) {
            ((MutableSingle) control.getFunctionValue()).add(number.floatValue());
        } else {
            if (control.getType() == ControlType.FLOAT) {
                control.setFunctionValue(new MutableDouble(number.doubleValue()));
            } else {
                control.setFunctionValue(new MutableSingle(number.floatValue()));
            }
        }
        control.setCalculatedValue(control.getFunctionValue());

	}

}



//End SumHandler component

