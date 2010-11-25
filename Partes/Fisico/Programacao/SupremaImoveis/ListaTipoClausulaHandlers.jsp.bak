<%--== Handlers ==--%> <%--ListaTipoClausula Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-DC76D674
    public class ListaTipoClausulaServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-0F76B408
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ((new HeaderServiceChecker()).check(request, response, context)) return true;
            if ((new FooterServiceChecker()).check(request, response, context)) return true;
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//Navigator Navigator Handler Head @17-89833F6F
    public class tbl_tipo_causulaNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @17-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @17-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @17-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-6F975E6C
    Page ListaTipoClausulaModel = (Page)request.getAttribute("ListaTipoClausula_page");
    Page ListaTipoClausulaParent = (Page)request.getAttribute("ListaTipoClausulaParent");
    if (ListaTipoClausulaModel == null) {
        PageController ListaTipoClausulaCntr = new PageController(request, response, application, "/ListaTipoClausula.xml" );
        ListaTipoClausulaModel = ListaTipoClausulaCntr.getPage();
        ListaTipoClausulaModel.setRelativePath("./");
        //if (ListaTipoClausulaParent != null) {
            //if (!ListaTipoClausulaParent.getChild(ListaTipoClausulaModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaTipoClausulaModel.getChild("tbl_tipo_causula")).getChild("Navigator")).addControlListener(new tbl_tipo_causulaNavigatorNavigatorHandler());
        ListaTipoClausulaCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaTipoClausulaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaTipoClausulaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaTipoClausulaParent == null) {
            ListaTipoClausulaModel.setCookies();
            if (ListaTipoClausulaModel.redirect()) return;
        } else {
            ListaTipoClausulaModel.redirect();
        }
    }
//End Processing

%>
