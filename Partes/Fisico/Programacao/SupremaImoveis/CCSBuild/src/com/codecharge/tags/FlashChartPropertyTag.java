//FlashChartProperty Tag class @0-ADCF056F
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class FlashChartPropertyTag extends TagSupport {

    private String name;

    public void setName(String name) {this.name = name;}

    public int doStartTag() {

        if (name == null) return SKIP_BODY;

		String value = "";

		com.codecharge.components.FlashChart flashChart = 
				(com.codecharge.components.FlashChart)pageContext.getAttribute("parent");


			if ( "name".equalsIgnoreCase(name) ) {
				value = flashChart.getName();
			} else if ( "title".equalsIgnoreCase(name) ) {
				value = flashChart.getTitle();
			} else if ( "width".equalsIgnoreCase(name) ) {
				value = ""+flashChart.getWidth();
			} else if ( "height".equalsIgnoreCase(name) ) {
				value = ""+flashChart.getHeight();
			} else if ( "src".equalsIgnoreCase(name) ) {
				value = flashChart.getSrc();
			} 


        try {
          pageContext.getOut().print(value);
        } catch(Exception exception) {
          throw new Error("IO problems");
        }
        return SKIP_BODY;

    }
}
//End FlashChartProperty Tag class

