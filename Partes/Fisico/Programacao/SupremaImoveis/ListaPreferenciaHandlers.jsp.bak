<%--== Handlers ==--%> <%--ListaPreferencia Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-8BF8CB52
    public class ListaPreferenciaServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @20-DCE810F6
    public class tbl_preferenciaNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @20-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @20-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @20-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-9D3920A8
    Page ListaPreferenciaModel = (Page)request.getAttribute("ListaPreferencia_page");
    Page ListaPreferenciaParent = (Page)request.getAttribute("ListaPreferenciaParent");
    if (ListaPreferenciaModel == null) {
        PageController ListaPreferenciaCntr = new PageController(request, response, application, "/ListaPreferencia.xml" );
        ListaPreferenciaModel = ListaPreferenciaCntr.getPage();
        ListaPreferenciaModel.setRelativePath("./");
        //if (ListaPreferenciaParent != null) {
            //if (!ListaPreferenciaParent.getChild(ListaPreferenciaModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaPreferenciaModel.getChild("tbl_preferencia")).getChild("Navigator")).addControlListener(new tbl_preferenciaNavigatorNavigatorHandler());
        ListaPreferenciaCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaPreferenciaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaPreferenciaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaPreferenciaParent == null) {
            ListaPreferenciaModel.setCookies();
            if (ListaPreferenciaModel.redirect()) return;
        } else {
            ListaPreferenciaModel.redirect();
        }
    }
//End Processing

%>
