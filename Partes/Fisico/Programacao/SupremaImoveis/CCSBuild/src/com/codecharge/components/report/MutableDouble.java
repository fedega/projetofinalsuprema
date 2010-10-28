//MutableDouble component @0-76113B03
/*
 * $Revision: 1.5 $
 * $Date: 2005/02/18 14:18:50 $
 */
package com.codecharge.components.report;


public class MutableDouble extends Number implements Cloneable {

    double value;

    public MutableDouble() {
    }

    public MutableDouble(double number) {
        value = number;
    }

    public void setValue(double number) {
        value = number;
    }

	public double doubleValue() {
		return value;
	}

	public float floatValue() {
		return (float) value;
	}

	public int intValue() {
		return (int) value;
	}

	public long longValue() {
		return (long) value;
	}

    public void add(double num) {
        value += num;
    }
    
    public void multiply(double num) {
        value *= num;
    }
    
    public void subtract(double num) {
        value -= num;
    }
    
    public void divide(double num) {
        value /= num;
    }
    
    public String toString() {
        return String.valueOf(value);
    }
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
    public boolean equals(Object obj) {
        return ((obj instanceof MutableDouble) && ((MutableDouble) obj).value == this.value);
    }

    public int hashCode() {
        long bits = Double.doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }
}



//End MutableDouble component

