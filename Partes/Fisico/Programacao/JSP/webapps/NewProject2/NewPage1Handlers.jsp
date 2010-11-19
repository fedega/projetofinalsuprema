<%--== Handlers ==--%> <%--NewPage1 Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-2EBBC1DD
    public class NewPage1ServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Processing @1-C0C602A3
    Page NewPage1Model = (Page)request.getAttribute("NewPage1_page");
    Page NewPage1Parent = (Page)request.getAttribute("NewPage1Parent");
    if (NewPage1Model == null) {
        PageController NewPage1Cntr = new PageController(request, response, application, "/NewPage1.xml" );
        NewPage1Model = NewPage1Cntr.getPage();
        NewPage1Model.setRelativePath("./");
        //if (NewPage1Parent != null) {
            //if (!NewPage1Parent.getChild(NewPage1Model.getName()).isVisible()) return;
        //}
        NewPage1Cntr.process();
%>
<%
        if (NewPage1Parent == null) {
            NewPage1Model.setCookies();
            if (NewPage1Model.redirect()) return;
        } else {
            NewPage1Model.redirect();
        }
    }
//End Processing

%>
