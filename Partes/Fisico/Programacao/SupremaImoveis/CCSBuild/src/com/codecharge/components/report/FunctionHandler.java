//FunctionHandler component @0-17987C06
/*
 * $Revision: 1.4 $
 * $Date: 2004/07/13 07:25:52 $
 */
package com.codecharge.components.report;

import com.codecharge.components.ReportLabel;

/**
 * FunctionHandler provides way to perform calculation in ReportLabel
 */
abstract public class FunctionHandler {
    
    /**
     * Method returns the initial value for initialization 
     * {@link com.codecharge.components.ReportLabel ReportLabel} control.
     * This method is intended to be used for internal framework purposes
     * and it is called then handler is assigned to specific control.
     * Default implementation always returns null.
     */
    public Object getInitialValue() {
        return null;
    }

    /**
     * Method executes calculations that use the value of
     * {@link com.codecharge.components.ReportLabel ReportLabel} control and
     * given value. Operation's result is placed into the control's value.
     * @param control Control value is the first operation operand
     * and place for storing operation result.
     * @param number - second operation operand
     */
    abstract public void execute(ReportLabel control, Number number);
}



//End FunctionHandler component

