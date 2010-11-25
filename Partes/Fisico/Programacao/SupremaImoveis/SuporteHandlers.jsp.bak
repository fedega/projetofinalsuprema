<%--== Handlers ==--%> <%--Suporte Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-AFA7E8FA
    public class SuporteServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Processing @1-54410C9C
    Page SuporteModel = (Page)request.getAttribute("Suporte_page");
    Page SuporteParent = (Page)request.getAttribute("SuporteParent");
    if (SuporteModel == null) {
        PageController SuporteCntr = new PageController(request, response, application, "/Suporte.xml" );
        SuporteModel = SuporteCntr.getPage();
        SuporteModel.setRelativePath("./");
        //if (SuporteParent != null) {
            //if (!SuporteParent.getChild(SuporteModel.getName()).isVisible()) return;
        //}
        SuporteCntr.process();
%>
<%
        if (SuporteParent == null) {
            SuporteModel.setCookies();
            if (SuporteModel.redirect()) return;
        } else {
            SuporteModel.redirect();
        }
    }
//End Processing

%>
