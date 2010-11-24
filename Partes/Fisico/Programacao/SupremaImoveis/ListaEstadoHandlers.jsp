<%--== Handlers ==--%> <%--ListaEstado Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-C8EA8753
    public class ListaEstadoServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @22-9E4FDF71
    public class tbl_estadoNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @22-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @22-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @22-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-85B73167
    Page ListaEstadoModel = (Page)request.getAttribute("ListaEstado_page");
    Page ListaEstadoParent = (Page)request.getAttribute("ListaEstadoParent");
    if (ListaEstadoModel == null) {
        PageController ListaEstadoCntr = new PageController(request, response, application, "/ListaEstado.xml" );
        ListaEstadoModel = ListaEstadoCntr.getPage();
        ListaEstadoModel.setRelativePath("./");
        //if (ListaEstadoParent != null) {
            //if (!ListaEstadoParent.getChild(ListaEstadoModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaEstadoModel.getChild("tbl_estado")).getChild("Navigator")).addControlListener(new tbl_estadoNavigatorNavigatorHandler());
        ListaEstadoCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaEstadoModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaEstadoModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaEstadoParent == null) {
            ListaEstadoModel.setCookies();
            if (ListaEstadoModel.redirect()) return;
        } else {
            ListaEstadoModel.redirect();
        }
    }
//End Processing

%>
