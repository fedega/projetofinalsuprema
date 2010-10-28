//ErrorCollection class @0-7381A526
package com.codecharge.validation;

import java.util.*;
import com.codecharge.util.*;

public class ErrorCollection {
    
    /** Collection of errors. **/
    protected ArrayList errors = new ArrayList();

    /** Error formatter. Called by adding new error. */
    protected com.codecharge.util.Formatter addingFormatter;

    /** Line formatter. Called from getErrorsAsString */
    protected com.codecharge.util.Formatter showingFormatter;
    
    /** Whether Component has errors. **/
    public boolean hasErrors() {
        return ( errors.size() > 0 );
    }

    /** Get Collection of errors. **/
    public Collection getErrors() {
        return errors;
    }

    /** Add several errors to errors collection. **/
    public void addErrors( Collection errors ) {
        this.errors.addAll( errors );
    }

    /** Add Error to errors collection. **/
    public void addError( String error ) {
        String fError = error;
        if ( addingFormatter != null ) {
            fError = addingFormatter.formatLine(error);
        }
        if ( fError != null ) {
            errors.add( error );
        }
    }

    /** Get all errors represented as one string. **/
    public String getErrorsAsString() {
        StringBuffer sb = new StringBuffer();
        String fError = null;
        if ( showingFormatter == null ) {
            showingFormatter = ErrorFormatter.getInstance();
        }
        for ( int i = 0; i < errors.size(); i++ ) {
            fError = (String) errors.get( i );
            if (i < errors.size() - 1) {
                sb.append(showingFormatter.formatLine(fError));
            }
        }
        if ( fError != null ) {
            sb.append( fError );
        }
        return sb.toString();
    }

    public void setAddingFormatter( com.codecharge.util.Formatter formatter ) {
        addingFormatter = formatter;
    }
    
    public void setShowingFormatter( com.codecharge.util.Formatter formatter ) {
        showingFormatter = formatter;
    }
    
}
//End ErrorCollection class

