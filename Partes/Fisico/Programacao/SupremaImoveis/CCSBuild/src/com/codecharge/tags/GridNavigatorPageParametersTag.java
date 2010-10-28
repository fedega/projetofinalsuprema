//GNPageParametersTag class @0-F07CAC5A
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class GridNavigatorPageParametersTag extends BodyTagSupport {

    private Iterator it = null;
	private HashMap map = null;

    public int doStartTag() throws JspTagException {
      Object parent = pageContext.getAttribute("parent");

	  Page page = ((Grid)parent).getPageModel();

	  Vector excepts = new Vector ();
	  excepts.add(((Grid)parent).getName()+"PageSize");

	  map = page.getHttpGetParameters().getPreserveParameters(excepts);

	  if (map.isEmpty()) {
		return SKIP_BODY;
	  }

	  it = map.keySet().iterator();

	  if (!it.hasNext()) {
		return SKIP_BODY;
	  } else {
		String name = "" + it.next();
		pageContext.setAttribute("~~~Name", name);
		pageContext.setAttribute("~~~Value", map.get(name));
		return EVAL_BODY_TAG;
	  }
    }

    public int doAfterBody() throws JspTagException {

        BodyContent body = getBodyContent();
        try {
          body.writeOut(getPreviousOut());
        } catch ( java.io.IOException ex) {
          throw new JspTagException("unexpected IO error");
        }

        body.clearBody();

	  if (!it.hasNext()) {
		return SKIP_BODY;
	  } else {
		String name = "" + it.next();
		pageContext.setAttribute("~~~Name", name);
		pageContext.setAttribute("~~~Value", map.get(name));
		return EVAL_BODY_TAG;
	  }

    }


}
//End GNPageParametersTag class

