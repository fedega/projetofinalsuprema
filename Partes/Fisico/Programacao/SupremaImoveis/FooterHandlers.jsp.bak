<%--== Handlers ==--%> <%--Footer Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-603B0197
    public class FooterServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Processing @1-FE2581FB
    Page FooterModel = (Page)request.getAttribute("Footer_page");
    Page FooterParent = (Page)request.getAttribute("FooterParent");
    if (FooterModel == null) {
        PageController FooterCntr = new PageController(request, response, application, "/Footer.xml" );
        FooterModel = FooterCntr.getPage();
        //if (FooterParent != null) {
            //if (!FooterParent.getChild(FooterModel.getName()).isVisible()) return;
        //}
        FooterModel.setAttribute(Page.PAGE_ATTRIBUTE_PATH_TO_ROOT, (String)FooterParent.getRelativePath());
        FooterCntr.process();
%>
<%
        if (FooterParent == null) {
            FooterModel.setCookies();
            if (FooterModel.redirect()) return;
        } else {
            FooterModel.redirect();
        }
    }
//End Processing

%>
