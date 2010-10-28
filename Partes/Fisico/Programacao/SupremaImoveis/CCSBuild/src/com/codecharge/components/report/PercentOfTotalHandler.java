//PercentOfTotalHandler component @0-1BF8501F
/*
 * $Revision: 1.3 $
 * $Date: 2004/07/13 07:26:20 $
 */
package com.codecharge.components.report;

import com.codecharge.components.ReportLabel;

public class PercentOfTotalHandler extends FunctionHandler {

	public void execute(ReportLabel control, Number number) {
        Object value = control.getValue();
        if (number == null) {
            return;
        }
        if (value instanceof MutableDouble) {
            ((MutableDouble) value).divide(number.doubleValue());
        } else if (value instanceof Number) {            
            control.setValue(((Number) value).doubleValue()/number.doubleValue());
        }
	}

}



//End PercentOfTotalHandler component

