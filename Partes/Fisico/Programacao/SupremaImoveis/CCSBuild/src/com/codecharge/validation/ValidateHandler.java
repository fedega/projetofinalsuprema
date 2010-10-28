//ValidateHandler class @0-CCB31BED
package com.codecharge.validation;

import java.text.MessageFormat;

import com.codecharge.components.Control;

public class ValidateHandler {
    protected ValidateHandler nextHandler;

    public void validate( Verifiable control ) {
        if( nextHandler != null ) nextHandler.validate( control );
    }
  
    public void setNextHandler( ValidateHandler handler ) {
        nextHandler = handler;
    }

    public ValidateHandler getNextHandler() {
        return nextHandler;
    }

    protected String getMessage(Verifiable control, String messageKey, Object[] args) {
        String message = "";
        if (control instanceof Control) {
            Control c = (Control) control;

            //MessageFormat mFmt = new MessageFormat(c.getPage().getResourceString(messageKey), c.getPage().getLocale());
            MessageFormat mFmt = new MessageFormat( c.getPage().getResourceString(messageKey) );
            mFmt.setLocale( c.getPage().getLocale() );
            mFmt.applyPattern( c.getPage().getResourceString(messageKey) );

            StringBuffer result = new StringBuffer();
            mFmt.format(args, result, null);
            message = result.toString();
        }
        return message;
    }
}
//End ValidateHandler class

