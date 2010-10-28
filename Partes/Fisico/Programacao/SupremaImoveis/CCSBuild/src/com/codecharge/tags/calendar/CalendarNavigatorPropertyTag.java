//CalendarNavigatorPropertyTag class @0-0FCAB638
package com.codecharge.tags.calendar;

import com.codecharge.components.*;
import com.codecharge.components.calendar.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import java.util.Iterator;

public class CalendarNavigatorPropertyTag extends TagSupport {

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM");
    private static SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");

    private Calendar calendar;
    private CalendarNavigator navigator;
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    public int doStartTag() throws JspTagException {
        this.navigator = (CalendarNavigator) pageContext.getAttribute("navigator");
        this.calendar = (Calendar) pageContext.getAttribute("parent");

        String cn_context = (String) pageContext.getAttribute("cn_context");
        CalendarNavigatorItem item = (CalendarNavigatorItem) pageContext.getAttribute("cn_item");
	//main navigator section

        if ("URL".equalsIgnoreCase(this.name)) {
            print(getUrl(cn_context));
        } else if ("Action".equalsIgnoreCase(this.name)) {
            print(getAction());
        } else if ("MonthFullName".equalsIgnoreCase(this.name)) {
            if (cn_context == null) {
                print(this.calendar.getPageModel().getCCSLocale().getMonths()[this.calendar.getMonth()]);
            } else {
                print(this.navigator.currentItem().getName());
            }
        } else if ("MonthShortName".equalsIgnoreCase(this.name)) {
            if (cn_context == null) {
                print(this.calendar.getPageModel().getCCSLocale().getShortMonths()[this.calendar.getMonth()]);
            } else {
                print(this.navigator.currentItem().getShortName());
            }
        } else if ("Month".equalsIgnoreCase(this.name)) {
            if (cn_context == null) {
                print(this.calendar.getMonth()+"");
            } else {
    		    CalendarNavigatorRepeaterTag repeater = 
                        (CalendarNavigatorRepeaterTag)findAncestorWithClass(this, 
                        CalendarNavigatorRepeaterTag.class);
                print(this.navigator.currentItem(repeater.getType()).getMonth()+"");
            }
        } else if ("Year".equalsIgnoreCase(this.name)) {
            print(getYear(cn_context));
        } else if ("CalendarName".equalsIgnoreCase(this.name)) {
            print(this.navigator.getParent().getName());
        } else if ("Quarter".equalsIgnoreCase(this.name)) {
        	if (cn_context == null) {
			print(this.navigator.getItems()[this.navigator.getMonth()/3].getQuarter()+"");
        	} else {
            		print(this.navigator.currentItem().getQuarter()+"");
		}
	}
        return SKIP_BODY;
    }

    public int doEndTag() {
        return EVAL_PAGE;
    }

    private void print(String content) throws JspTagException {
        try {
            pageContext.getOut().print(content);
        } catch(Exception e) {
            throw new JspTagException("unexpected IO problems");
        }
    }
    
    private String getYear(String context) {
        if (context == null) {
            return String.valueOf(this.calendar.getYear());
        } else if ("Regular_Month".equals(context)
                || "Current_Month".equals(context)
                || "Regular_Quarter".equals(context)
                || "Current_Quarter".equals(context)
                ) {
            return String.valueOf(navigator.currentItem().getYear());
        } else if("Regular_Year".equals(context)
                || "Current_Year".equals(context)
                ) {
            return String.valueOf(navigator.currentItem(CalendarNavigator.YEAR).getYear());
        } else if ("Prev_Year".equals(context)) {
            return CalendarNavigatorPropertyTag.YEAR_FORMAT.format(navigator.getPrevYear());
        } else if ("Prev".equals(context)) {
            return CalendarNavigatorPropertyTag.YEAR_FORMAT.format(navigator.getPrevDate());
        } else if ("Next".equals(context)) {
            return CalendarNavigatorPropertyTag.YEAR_FORMAT.format(navigator.getNextDate());
        } else if ("Next_Year".equals(context)) {
            return CalendarNavigatorPropertyTag.YEAR_FORMAT.format(navigator.getNextYear());
        }
        return "";
    }
    
    private String getAction() {
        return encodeUrl(getFormAction()+"?ccsForm=" + calendar.getName() + getPreservedParameters());
    }
    
    private String getUrl(String context) {
        String pParams = getPreservedParameters();
        String formAction = getFormAction();
        
        if (context == null) {
            return encodeUrl(formAction+"?"+calendar.getName()+"Date="+calendar.getYear()
                    +"-"+monthToString(calendar.getMonth())+pParams);
        } else if ("Regular_Month".equals(context)
                || "Current_Month".equals(context)
                || "Regular_Quarter".equals(context)
                || "Current_Quarter".equals(context)
                ) {
            return encodeUrl(formAction+"?"+calendar.getName()+"Date="+navigator.currentItem().getYear()
                    +"-"+monthToString(navigator.currentItem().getMonth())+pParams);
        } else if("Regular_Year".equals(context)
                || "Current_Year".equals(context)
                ) {
            return encodeUrl(formAction+"?"+calendar.getName()+"Date="
                    //+navigator.currentItem(CalendarNavigator.YEAR).getYear()+pParams);
		    +navigator.currentItem(CalendarNavigator.YEAR).getYear()+"-"+monthToString(navigator.currentItem(CalendarNavigator.YEAR).getMonth())+pParams);
        } else if ("Prev_Year".equals(context)) {
            return encodeUrl(formAction+"?"+calendar.getName()+"Date="
                    +CalendarNavigatorPropertyTag.DATE_FORMAT.format(navigator.getPrevYear())+pParams);
        } else if ("Prev".equals(context)) {
            return encodeUrl(formAction+"?"+calendar.getName()+"Date="
                    +CalendarNavigatorPropertyTag.DATE_FORMAT.format(navigator.getPrevDate())+pParams);
        } else if ("Next".equals(context)) {
            return encodeUrl(formAction+"?"+calendar.getName()+"Date="
                    +CalendarNavigatorPropertyTag.DATE_FORMAT.format(navigator.getNextDate())+pParams);
        } else if ("Next_Year".equals(context)) {
            return encodeUrl(formAction+"?"+calendar.getName()+"Date="
                    +CalendarNavigatorPropertyTag.DATE_FORMAT.format(navigator.getNextYear())+pParams);
        }
        return "";
    }
    private String monthToString(int month) {
        if (month < 10) {
            return "0"+month;
        }
        return ""+month;
    }

    private String getPreservedParameters() {
        String pParams = (String) pageContext.getAttribute("navigator_stored_get");
        if (pParams == null) {
            StringBuffer preservedParameters = new StringBuffer();
            HashMap parameters = new HashMap();
            Vector getExclude = new Vector();
            getExclude.add("ccsForm");
            getExclude.add(calendar.getName()+"Date");
            getExclude.add(calendar.getName()+"Year");
            getExclude.add(calendar.getName()+"Month");
            parameters.putAll(calendar.getPageModel().getHttpGetParams().getPreserveParameters(getExclude));
            Iterator params = parameters.values().iterator();
            while(params.hasNext()) {
                preservedParameters.append("&"+((String)params.next()));
            }
            pParams = preservedParameters.toString();
            pageContext.setAttribute("navigator_stored_get", pParams);
        }
        return pParams;
    }    

    private String getFormAction() {
        String formAction = (String) pageContext.getAttribute("navigator_form_action");
        if (formAction == null) {
            formAction = calendar.getPageModel().getActionPageName() + ".jsp";
            pageContext.setAttribute("navigator_form_action", formAction);
        }
        return formAction;
    }    

    private String encodeUrl(String url) {
        return SessionStorage.getInstance(calendar.getPageModel().getRequest()).encodeURL(url);    
    }
}
//End CalendarNavigatorPropertyTag class

