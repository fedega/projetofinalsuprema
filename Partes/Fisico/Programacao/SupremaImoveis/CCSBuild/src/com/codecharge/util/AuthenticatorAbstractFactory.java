//AuthenticatorAbstractFactory class @0-2260C330
package com.codecharge.util;

import javax.servlet.http.HttpServletRequest;

abstract public class AuthenticatorAbstractFactory {

    public Authenticator getAuthenticator( HttpServletRequest request ) {
    	return CCSTableAuthenticator.getInstance(request);
    }

}

//End AuthenticatorAbstractFactory class

