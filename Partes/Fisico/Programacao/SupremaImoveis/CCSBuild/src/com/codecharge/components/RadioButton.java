//RadioButton component @0-2B80EA70
package com.codecharge.components;

import java.util.Enumeration;
import java.util.Hashtable;
import com.codecharge.Template;
import com.codecharge.util.*;

public class RadioButton extends List {

    public RadioButton(String name, String fieldSource, Page page) {
        super(name, fieldSource, page);
    }

    public RadioButton(String name, Page page) {
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

    public void show(Template tmpl) {
      show( tmpl, null );
    }

    public void show(Template tmpl, String pathToBlock ) {
        boolean isXHTMLUsed;
        String blockToParse = null;
        if ( pathToBlock == null ) {
            blockToParse = "RadioButton "+getName();
        } else {
            blockToParse = pathToBlock + "RadioButton "+getName();
        }
        String fv = getFormattedValue();
        Enumeration enumeration = options.elements();
        tmpl.setVar(blockToParse);

        Control val = null;
        if ( type == ControlType.FLOAT ) {
            val = new Control("f", page);
            val.setFormat( format );
            val.setType( type );
            val.setDefaultValue( defaultValue );
        }
        isXHTMLUsed = new Boolean(StringUtils.getSiteProperty("isXHTMLUsed")).booleanValue();
        while ( enumeration.hasMoreElements() ) {
            Hashtable row = (Hashtable) enumeration.nextElement();
            String value = row.get(boundColumn).toString();
            String caption = row.get(textColumn).toString();

            tmpl.setVar( blockToParse+"/@Value", StringUtils.toHtml( value ) );
            if ( type != ControlType.FLOAT ) {
                if ( value.equals( fv ) )
                    if (isXHTMLUsed) {
                        tmpl.setVar( blockToParse + "/@Check", "checked=\"checked\"" );
                    } else {
                        tmpl.setVar( blockToParse + "/@Check", "CHECKED" );
                    }                
                else
                    tmpl.setVar( blockToParse + "/@Check", "" );
            } else {
                try {
                    val.setValueFromRequest( value );
                } catch ( Exception ignore ) {}
                if ( val.getFormattedValue() != null && val.getFormattedValue().equals( fv ) ) {
                    if (isXHTMLUsed) {
                        tmpl.setVar( blockToParse + "/@Check", "checked=\"checked\"" );
                    } else {
                        tmpl.setVar( blockToParse + "/@Check", "CHECKED" );
                    }                
                } else {
                    tmpl.setVar( blockToParse + "/@Check", "" );
                }
            }
            tmpl.setVar( blockToParse + "/@Description", toHtml( caption ) );
            tmpl.setVar( blockToParse + "/@"+getName()+"_Name", getHtmlName());
            tmpl.parse( blockToParse, true );
        }
    }
}
//End RadioButton component

