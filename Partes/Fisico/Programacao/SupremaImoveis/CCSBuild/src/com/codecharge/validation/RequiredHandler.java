//RequiredHandler class @0-C3873EF8
package com.codecharge.validation;

import com.codecharge.util.StringUtils;

public class RequiredHandler extends ValidateHandler {

    private String message;
  
    public RequiredHandler() {
    }

    public RequiredHandler( String message ) {
        this.message = message;
    }

    public void validate( Verifiable control ) {
        if ( control != null && ( control.getValue() == null || 
                "".equals(control.getValue().toString()) ) ) {
            if (! StringUtils.isEmpty(message)) {
                control.addError( ControlErrorTypes.getErrorType( ControlErrorTypes.REQUIRED_ERROR ), message );
            } else {
                control.addError( ControlErrorTypes.getErrorType( ControlErrorTypes.REQUIRED_ERROR ), 
                        getMessage(control, "CCS_RequiredField", new String[] {control.getCaption()}));
            }
        }
        super.validate( control );
  }
}
//End RequiredHandler class

