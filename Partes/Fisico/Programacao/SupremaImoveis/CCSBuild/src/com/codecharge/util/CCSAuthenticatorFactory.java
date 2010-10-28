//CCSAuthenticatorFactory class @0-E4BCF74E
package com.codecharge.util;

import javax.servlet.http.HttpServletRequest;

public class CCSAuthenticatorFactory extends AuthenticatorAbstractFactory {

    public Authenticator getAuthenticator( HttpServletRequest request ) {
        String securityType = ContextStorage.getInstance().getAttributeAsString( "authenticator.securityType" );
        Authenticator auth = null;
        if ( "container".equalsIgnoreCase( securityType ) ) {
            auth = HttpAuthenticator.getInstance( request );
        } else if ( "ccs".equalsIgnoreCase( securityType ) ) {
            auth = CCSTableAuthenticator.getInstance( request );
        }
        return auth;
    }

}

//End CCSAuthenticatorFactory class

