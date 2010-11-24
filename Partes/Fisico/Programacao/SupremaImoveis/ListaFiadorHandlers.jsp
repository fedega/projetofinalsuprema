<%--== Handlers ==--%> <%--ListaFiador Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-C2432FF1
    public class ListaFiadorServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @61-86BB0749
    public class tbl_fiadorNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @61-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @61-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @61-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-2A9B4E08
    Page ListaFiadorModel = (Page)request.getAttribute("ListaFiador_page");
    Page ListaFiadorParent = (Page)request.getAttribute("ListaFiadorParent");
    if (ListaFiadorModel == null) {
        PageController ListaFiadorCntr = new PageController(request, response, application, "/ListaFiador.xml" );
        ListaFiadorModel = ListaFiadorCntr.getPage();
        ListaFiadorModel.setRelativePath("./");
        //if (ListaFiadorParent != null) {
            //if (!ListaFiadorParent.getChild(ListaFiadorModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaFiadorModel.getChild("tbl_fiador")).getChild("Navigator")).addControlListener(new tbl_fiadorNavigatorNavigatorHandler());
        ListaFiadorCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaFiadorModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaFiadorModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaFiadorParent == null) {
            ListaFiadorModel.setCookies();
            if (ListaFiadorModel.redirect()) return;
        } else {
            ListaFiadorModel.redirect();
        }
    }
//End Processing

%>
