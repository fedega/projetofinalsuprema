//ReportLabel class @0-5A847435
/*
 * Created on 12.05.2004
 * $Revision: 1.20 $
 * $Date: 2005/02/18 14:15:52 $
 */
package com.codecharge.components;

import java.text.Format;
import java.text.ParseException;
import java.util.Date;

import com.codecharge.components.report.FunctionHandler;
import com.codecharge.components.report.DefaultHandler;
import com.codecharge.components.report.SumHandler;
import com.codecharge.components.report.MutableDouble;
import com.codecharge.components.report.MutableSingle;
import com.codecharge.util.NumericFormat;
import com.codecharge.util.StringUtils;


public class ReportLabel extends Label {

    protected String emptyText;
    protected boolean hideDuplicates;
    protected String resetAt;
    protected String computeAt;
    protected double total;
    protected double count;
    
    protected FunctionHandler function;
    protected FunctionHandler computeAtFunction;
    
    /**
     * store value to be available in functions
     * this property can be MutableDouble or MutableSingle
     */
    protected Object functionValue;
    /**
     * store value to be available in computeAt functions
     * this property can be MutableDouble or MutableSingle
     */
    protected Object computeAtFunctionValue;
	/**
	 * @param name
	 * @param fieldSource
	 * @param page
	 */
	public ReportLabel(String name, String fieldSource, Page page) {
		super(name, fieldSource, page);
	}

	/**
	 * @param name
	 * @param page
	 */
	public ReportLabel(String name, Page page) {
		super(name, page);
	}

    
	/**
	 * @return computeAt group
	 */
	public String getComputeAt() {
		return computeAt;
	}

	/**
	 * @return count
	 */
	public double getCount() {
		return count;
	}

	/**
	 * @return string to substitute for empty values
	 */
	public String getEmptyText() {
		return emptyText;
	}

	/**
	 * @return function handler
	 */
	public FunctionHandler getFunction() {
		return function;
	}

	/**
	 * @return true if duplicates should be hidden
	 */
	public boolean isHideDuplicates() {
		return hideDuplicates;
	}

	/**
	 * @return resetAt group
	 */
	public String getResetAt() {
		return resetAt;
	}

	/**
	 * @return total value
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param string
	 */
	public void setComputeAt(String string) {
		computeAt = string;
        if (! StringUtils.isEmpty(string)) {
            ReportLabel rl = (ReportLabel) this.clone();
            rl.setName(rl.getName());
            rl.setComputeAt(null);
            rl.setResetAt(null);
            rl.setComputeAtFunction(null);
            ((Report) parent).getGroup(string).addComputeAtReportLabel(rl);
        }
	}

	/**
	 * @param d
	 */
	public void setCount(double d) {
		count = d;
	}

	/**
	 * @param string
	 */
	public void setEmptyText(String string) {
		emptyText = string;
	}

	/**
	 * @param handler
	 */
	public void setFunction(FunctionHandler handler) {
		function = handler;
        if (handler != null) {
            setValue(handler.getInitialValue());
            setFunctionValue(handler.getInitialValue());
        }
        if (! StringUtils.isEmpty(resetAt) && parent != null) {
            ((Report) parent).getGroup(resetAt).getResetAtReportLabel(this.name).setFunction(handler);
        }
	}

	/**
	 * @param b
	 */
	public void setHideDuplicates(boolean b) {
		hideDuplicates = b;
	}

	/**
	 * @param string
	 */
	public void setResetAt(String string) {
		resetAt = string;
        if (parent != null && ! StringUtils.isEmpty(string)) {
            ReportLabel rl = (ReportLabel) this.clone();
            rl.setResetAt(null);
            /*if (this.function instanceof DefaultHandler) {
                rl.setFunction(new SumHandler());
            }*/
            ((Report) parent).getGroup(string).addResetAtReportLabel(rl);
        }
	}
    
    public void initValue() {
        if (! StringUtils.isEmpty(resetAt) && parent != null) {
            Object val = ((Report) parent).getGroup(resetAt).getResetAtReportLabel(this.name).getValue();
            Object val1 = ((Report) parent).getGroup(resetAt).getResetAtReportLabel(this.name).getFunctionValue();
            if (val1 == null && function != null) {
                val1 = function.getInitialValue();
            }
            setFunctionValue(val1);
            setValue(val1);
        }
    }

	/**
	 * @param d
	 */
	public void setTotal(double d) {
		total = d;
	}
    
    public void incrementCount() {
        count++;
    }
    
    public void addToCount(double num) {
        count += num;
    }

    public void addToTotal(double num) {
        total += num;
    }

    public void calculate(double number) {
        if ((StringUtils.isEmpty(fieldSource) && value == null) || (!StringUtils.isEmpty(fieldSource) && value != null)) {
            if (function != null) function.execute(this, new Double(number));
        }
        if (! StringUtils.isEmpty(resetAt)) {
            ((Report) parent).getGroup(resetAt).getResetAtReportLabel(this.name).calculate(number);
            addToResetAtCollection();
        }
    }

    private void addToResetAtCollection() {
        //reset header controls during opening new page.
        if (! ((Report) parent).isDetailControl(this.name)) {
            ((Report) parent).getGroup(resetAt).addToResetAtCollection(this.name, this);
        }
    }
    
    public void calculate(Object valueToCalc) {
        calculate(valueToCalc, true);
    }
    
    public void calculate(Object valueToCalc, boolean isSetValue) {
		if (function != null) {
            if (isSetValue) {
                initValue();
	    		if (valueToCalc instanceof Number) {
		    		function.execute(this, ((Number) valueToCalc));
                } else if (valueToCalc == null || (valueToCalc instanceof String && StringUtils.isEmpty((String) valueToCalc))) {
                    function.execute(this, null);
                } else {
                    function.execute(this, new Float(1));
                }
            }
            if (!StringUtils.isEmpty(computeAt)) {
                if (parent != null) {
                    ReportLabel rl = ((Report) parent).getGroup(computeAt).getComputeAtReportLabel(this.name);
                    if (rl.getFunction() == null) {
                        if (function instanceof DefaultHandler) {
                            rl.setFunction(new SumHandler());
                        } else {
                            rl.setFunction(function);
                        }
                    }
                    rl.setComputeAtFunction(null);
                    rl.calculate(valueToCalc);
                    ((Report) parent).getGroup(computeAt).addToComputeAtCollection(this.name, this);
                }
            }
            if (!StringUtils.isEmpty(resetAt)) {
                if (parent != null && this != ((Report) parent).getGroup(resetAt)
                        .getResetAtReportLabel(this.name)) {
                    ((Report) parent).getGroup(resetAt).getResetAtReportLabel(
                            this.name).setValue(value);
                    ((Report) parent).getGroup(resetAt).getResetAtReportLabel(
                            this.name).setFunctionValue(functionValue);
                }
                addToResetAtCollection();
            }
		}
		if (computeAtFunction == null) {
            handleEmptyText(valueToCalc);
            hideDuplicates();
		}
	}

    private void handleEmptyText(Object value) {
        if (getValue() == null || (getValue() instanceof String && ((String)getValue()).length() == 0)) {
            if (value == null || (value instanceof String && ((String)value).length() == 0)) {
                setValue(emptyText);
            } else {
                setValue(value);
            }
        }
    }
    
    private void hideDuplicates() {
        if (hideDuplicates) {
            Object prevValue = ((Report) getParent()).getAttribute(name);
            if (prevValue != null && prevValue.equals(getFormattedValue())) {
                setVisible(false);
            }
            ((Report) getParent()).setAttribute(name, getFormattedValue());
        }
    }
    
    public void setCalculatedValue(Object value) {
        if (value instanceof MutableDouble) {
            setCalculatedValue((MutableDouble)value);
        } else if (value instanceof MutableSingle) {
            setCalculatedValue((MutableSingle)value);
        } else {
            setValue(value);
        }
    }
    
    public void setCalculatedValue(MutableDouble value) {
        if (value != null) {
            setCalculatedValue(value.doubleValue());
        }
    }
    
    public void setCalculatedValue(MutableSingle value) {
        if (value != null) {
            setCalculatedValue(value.floatValue());
        }
    }
    
    public void setCalculatedValue(double value) {
        if(this.type == ControlType.INTEGER || this.type == ControlType.FLOAT || this.type == ControlType.SINGLE) {
            setValue(value);
        } else if (this.type == ControlType.TEXT || this.type == ControlType.MEMO) {
            NumericFormat fmt = null;
            if (!StringUtils.isEmpty(this.formatPattern)) {
                fmt = page.getCCSLocale().getNumericFormat(this.formatPattern);
            } else {
                fmt = page.getCCSLocale().getDoubleFormat();
            }
            setValue(fmt.format(value));
        }
    }

    public void computeAtFunction(Object valueToCalc) {
        if (computeAtFunction != null) {
            if (valueToCalc instanceof Number) {
                computeAtFunction.execute(this, ((Number) valueToCalc));
            } else if (valueToCalc == null || (valueToCalc instanceof String && StringUtils.isEmpty((String) valueToCalc))) {
                computeAtFunction.execute(this, null);
            } else {
                computeAtFunction.execute(this, new Float(0));
            }
            if (!StringUtils.isEmpty(resetAt)) {
                if (resetAt != null) {
                    ((Report) parent).getGroup(resetAt).getResetAtReportLabel(
                            this.name).setValue(value);
                }
            }
        } else {
            handleEmptyText(valueToCalc);
        }
        hideDuplicates();
    }

	public Object formControlValue(double value) {
        Object result = null;
        if ( type == ControlType.INTEGER ) {
            result = new MutableDouble((long) value);
        } else if ( type == ControlType.FLOAT ) {
            result = new MutableDouble(value);
        } else if ( type == ControlType.DATE ) {
            result = new Date( (long) value );
        } else {
            result = String.valueOf( value );
        }
        return result;
	}

	public Object formControlValue(long value) {
        Object result = null;
        if ( type == ControlType.INTEGER ) {
            result = new MutableDouble(value);
        } else if ( type == ControlType.FLOAT ) {
            result = new MutableDouble(value);
        } else if ( type == ControlType.DATE ) {
            result = new Date( value );
        } else {
            result = String.valueOf( value );
        }
        return result;
	}

	public Object formControlValue(String value, String fmtPattern)
		      throws ParseException {
		Object result = super.formControlValue(value, fmtPattern);
        if (type == ControlType.FLOAT) {
            if (result != null) result = new MutableDouble(((Number) result).doubleValue()); 
        } else if (type == ControlType.INTEGER) {
            if (result != null) result = new MutableDouble(((Number) result).longValue()); 
        }
        return result;
	}

    /** Auxiliary function to convert control value from Object to type corresponding with CCS control type. */
    private Object formControlValue( Object value ) {
        Object result = null;
        if ( value == null ) {
            result = value;
        } else if ( type == ControlType.INTEGER && (value instanceof Number) ) {
            result = new MutableDouble( ((Number) value).longValue() );
        } else if ( type == ControlType.FLOAT && (value instanceof Number) ) {
            result = new MutableDouble( ((Number) value).doubleValue() );
        } else {
            result = value;
        }
        return result;
    }


    /** Retrieves the value of the control. This is the Object value of the control, when format was not applied yet.
      @return not formatted control value */
    public Object getValue() {
        if (this.function != null) {
            return getFunctionValue();
        }
        return value;
    }

	/**
	 * @return function for computeAt
	 */
	public FunctionHandler getComputeAtFunction() {
		return computeAtFunction;
	}

	/**
	 * @param handler
	 */
	public void setComputeAtFunction(FunctionHandler handler) {
		computeAtFunction = handler;
	}

    public Object getComputeAtFunctionValue() {
        return computeAtFunctionValue;
    }
    public void setComputeAtFunctionValue(Object computeAtFunctionValue) {
        if (computeAtFunctionValue instanceof MutableDouble ||
                computeAtFunctionValue instanceof MutableSingle ||
                computeAtFunctionValue == null) {
            this.computeAtFunctionValue = computeAtFunctionValue;
        } else {
            throw new IllegalArgumentException("wrong Type: "+functionValue.getClass().getName());
        }
    }
    public Object getFunctionValue() {
        return functionValue;
    }
    public void setFunctionValue(Object functionValue) {
        if (functionValue instanceof MutableDouble) {
            this.functionValue = new MutableDouble(((Number)functionValue).doubleValue());
        } else  if (functionValue instanceof MutableSingle) {
            this.functionValue = new MutableSingle(((Number)functionValue).floatValue());
        } else  if (functionValue instanceof Number) {
            if (type == ControlType.SINGLE) { 
                this.functionValue = new MutableSingle(((Number)functionValue).floatValue());
            } else {
                this.functionValue = new MutableDouble(((Number)functionValue).doubleValue());
            }
        } else  if (functionValue == null) {
            this.functionValue = functionValue;
        } else {
            throw new IllegalArgumentException("wrong Type: "+functionValue.getClass().getName());
        }
    }

    public void setFunctionValue(double functionValue) {
        if (this.type == ControlType.FLOAT) {
            this.functionValue = new MutableDouble(functionValue);
        } else {
            this.functionValue = new MutableSingle((float) functionValue);
        }
    }

    /**
     * Get the value formatted according to the control format.
     * 
     * @return formatted control value
     */
    public String getFormattedValue() {
        if (preformatted) {
            return super.getFormattedValue();
        } else {
            if (this.function == null) {
                return super.getFormattedValue();
            }
            String result = "";
            Format fmt = null;
            if (functionValue instanceof MutableSingle) {
                fmt = page.getCCSLocale().getFormat(ControlType.FLOAT, formatPattern);
            } else if (functionValue instanceof MutableDouble) {
                fmt = page.getCCSLocale().getFormat(ControlType.FLOAT, formatPattern);
            }
            if (fmt != null) {
                result = fmt.format(functionValue);
            }
            result = toHtml(result);
            return result;
        }
    }

}







//End ReportLabel class

