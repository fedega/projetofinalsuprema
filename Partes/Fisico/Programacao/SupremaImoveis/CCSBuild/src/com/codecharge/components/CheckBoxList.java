//CheckBoxList component @0-5D68C41A
package com.codecharge.components;

import com.codecharge.util.*;

public class CheckBoxList extends List {

    public CheckBoxList(String name, String fieldSource, Page page) {
        super(name, fieldSource, page);
    }

    public CheckBoxList(String name, Page page) {
        super(name, page);
    }

    public String toHtml( String value ) {
      if ( isHtmlEncode() ) {
         value = StringUtils.toHtml( value );
         value = StringUtils.replace( value, "\r", "" );
         value = StringUtils.replace( value, "\n", StringUtils.getBRTag() );
      }
      return value;
    }

}
//End CheckBoxList component

