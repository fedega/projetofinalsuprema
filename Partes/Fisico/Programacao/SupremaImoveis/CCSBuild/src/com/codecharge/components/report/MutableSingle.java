//MutableSingle component @0-16B11407
/*
 * Created on 13.05.2004
 */
package com.codecharge.components.report;


public class MutableSingle extends Number implements Cloneable {

    float value;

    public MutableSingle() {
    }

    public MutableSingle(float number) {
        value = number;
    }

    public void setValue(float number) {
        value = number;
    }

	public float floatValue() {
		return value;
	}

	public double doubleValue() {
		return (double) value;
	}

	public int intValue() {
		return (int) value;
	}

	public long longValue() {
		return (long) value;
	}

    public void add(float num) {
        value += num;
    }
    
    public void multiply(float num) {
        value *= num;
    }
    
    public void subtract(float num) {
        value -= num;
    }
    
    public void divide(float num) {
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
        long bits = Float.floatToIntBits(value);
        return (int) (bits ^ (bits >>> 32));
    }
}



//End MutableSingle component

