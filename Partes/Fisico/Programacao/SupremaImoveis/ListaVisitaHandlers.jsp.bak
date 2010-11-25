<%--== Handlers ==--%> <%--ListaVisita Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-9B13FC30
    public class ListaVisitaServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @32-07F8A0AA
    public class tbl_visitaNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @32-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @32-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @32-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-24F170EC
    Page ListaVisitaModel = (Page)request.getAttribute("ListaVisita_page");
    Page ListaVisitaParent = (Page)request.getAttribute("ListaVisitaParent");
    if (ListaVisitaModel == null) {
        PageController ListaVisitaCntr = new PageController(request, response, application, "/ListaVisita.xml" );
        ListaVisitaModel = ListaVisitaCntr.getPage();
        ListaVisitaModel.setRelativePath("./");
        //if (ListaVisitaParent != null) {
            //if (!ListaVisitaParent.getChild(ListaVisitaModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaVisitaModel.getChild("tbl_visita")).getChild("Navigator")).addControlListener(new tbl_visitaNavigatorNavigatorHandler());
        ListaVisitaCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaVisitaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaVisitaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaVisitaParent == null) {
            ListaVisitaModel.setCookies();
            if (ListaVisitaModel.redirect()) return;
        } else {
            ListaVisitaModel.redirect();
        }
    }
//End Processing

%>
