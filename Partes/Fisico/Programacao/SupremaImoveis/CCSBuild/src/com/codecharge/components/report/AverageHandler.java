//AverageHandler class @0-9BE0D7B6
/*
 * $Revision: 1.4 $
 * $Date: 2005/02/18 14:22:00 $
 */
package com.codecharge.components.report;

import com.codecharge.components.Report;
import com.codecharge.components.ReportLabel;


public class AverageHandler extends FunctionHandler {

    private static final String AVERAGE_SUMMA_SUFFIX = ".Average.Summa";
    private static final String AVERAGE_COUNT_SUFFIX = ".Average.Count";

    /**
     * @see com.codecharge.components.report.FunctionHandler#execute(com.codecharge.components.ReportLabel, double)
     */
    public void execute(ReportLabel control, Number number) {
        if (control == null) {
            throw new IllegalArgumentException("Parameter control cannot be null."); //TODO:
                                                                                    // I18N
        }
        if (number == null) {
            return;
        }
        Report report = (Report) control.getParent();
        MutableDouble summa = Report.getMutableAttribute(report, control.getName()
                + AVERAGE_SUMMA_SUFFIX);
        MutableDouble count = Report.getMutableAttribute(report, control.getName()
                + AVERAGE_COUNT_SUFFIX);
        count.add(1);
        summa.add(number.doubleValue());
        control.setFunctionValue(summa.doubleValue() / count.doubleValue());
        control.setCalculatedValue(control.getFunctionValue());
    }

}


//End AverageHandler class

