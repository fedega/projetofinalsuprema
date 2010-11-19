<%--== Handlers ==--%> <%--Header Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-0688AEF9
    public class HeaderServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-6DADF1A6
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-B5CA0992
    Page HeaderModel = (Page)request.getAttribute("Header_page");
    Page HeaderParent = (Page)request.getAttribute("HeaderParent");
    if (HeaderModel == null) {
        PageController HeaderCntr = new PageController(request, response, application, "/Header.xml" );
        HeaderModel = HeaderCntr.getPage();
        //if (HeaderParent != null) {
            //if (!HeaderParent.getChild(HeaderModel.getName()).isVisible()) return;
        //}
        HeaderModel.setAttribute(Page.PAGE_ATTRIBUTE_PATH_TO_ROOT, (String)HeaderParent.getRelativePath());
        HeaderCntr.process();
%>
<%
        if (HeaderParent == null) {
            HeaderModel.setCookies();
            if (HeaderModel.redirect()) return;
        } else {
            HeaderModel.redirect();
        }
    }
//End Processing

%>
