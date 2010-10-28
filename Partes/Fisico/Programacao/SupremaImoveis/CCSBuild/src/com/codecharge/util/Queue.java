//Queue class @0-115E3B30
package com.codecharge.util;

public class Queue {
  private int pointer;
  private Object[] array;
  
  public int length;
  
  public Queue() {}
  
  public Queue( Object[] array ) {
    this.pointer = 0;
    setArray( array );
  }
  
  public Object[] getArray() {
    return this.array;
  }
  
  public void setArray( Object[] array ) {
    this.array = array;
    if ( this.array != null )
      this.length = this.array.length;
  }
  
  public Object peek() {
    if ( array != null && pointer < array.length )
      return array[pointer];
    else
      return null;
  }
  
  public Object get() {
    Object obj = peek();
    if ( array != null && pointer < array.length ) {
      pointer++;
      length = array.length - pointer;
    }  
    return obj;
  }

  public int size() {
    return length;
  }
}
//End Queue class

