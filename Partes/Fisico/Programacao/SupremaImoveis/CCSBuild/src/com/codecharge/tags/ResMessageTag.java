//ResMessageTag class @0-640828EA
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.util.*;
import com.codecharge.components.Page;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.text.MessageFormat;

/**
  Defines control values and attributes.
  <pre><b>&lt;resMessage key=".." bundle=".."/&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setKey key}, {@link #setBundle bundle}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class ResMessageTag extends TagSupport {

    private String key;
    /**  The key to use when retrieving the display message format from the ResourceBundle. **/
    public void setKey(String key) {this.key = key;}

    private String arg0;
    public void setArg0(String arg) {this.arg0 = arg;}

    private String arg1;
    public void setArg1(String arg) {this.arg1 = arg;}

    private String arg2;
    public void setArg2(String arg) {this.arg2 = arg;}

    private String arg3;
    public void setArg3(String arg) {this.arg3 = arg;}

    private String arg4;
    public void setArg4(String arg) {this.arg4 = arg;}


    private String bundle;
    /** The name of the ResourceBundle in which the key can be found. **/
    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public int doStartTag() {
        Page page = (Page)pageContext.getAttribute("page");

        String value = page.getResourceString(this.key);
        String[] args = getArgs();
        if (args != null) {
            value = MessageFormat.format(value,(Object[]) args);
        }
        try {
            pageContext.getOut().print(value);
        } catch(Exception exception) {
            throw new Error("IO problems");
        }
        return SKIP_BODY;
    }

    private String[] getArgs() {
        ArrayList args = new ArrayList();
        if (arg0 != null) args.add(arg0);
        if (arg1 != null) args.add(arg1);
        if (arg2 != null) args.add(arg2);
        if (arg3 != null) args.add(arg3);
        if (arg4 != null) args.add(arg4);
        String[] result = null;
        if (args.size() > 0) {
            result = new String[args.size()];
            result = (String[]) args.toArray(result);
        }
        return result;
    }

    private String getBundleName() {
        if (StringUtils.isEmpty(bundle)) {
            this.bundle = StringUtils.getSiteProperty("messagesBundle");
        }
        if (StringUtils.isEmpty(bundle)) {
            this.bundle = "MessagesBundle";
        }
        return this.bundle;
    }
}
//End ResMessageTag class

