//ImageLink component @0-511CDB88
package com.codecharge.components;

import com.codecharge.util.*;

public class ImageLink extends Link {

    public ImageLink(String name, String fieldSource, Page page) {
        super(name, fieldSource, page);
    }

    public ImageLink(String name, Page page) {
        super(name, page);
    }

    protected String toHtml( String value ) {
        value = StringUtils.toHtml( value );
        value = StringUtils.replace( value, "\r", "" );
        value = StringUtils.replace( value, "\n", StringUtils.getBRTag() );
        return value;
    }

}
//End ImageLink component

