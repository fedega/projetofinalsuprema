<%--== Handlers ==--%> <%--ListaImovel Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-0B08D223
    public class ListaImovelServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-238BAEF2
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ((new HeaderServiceChecker()).check(request, response, context)) return true;
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//Navigator Navigator Handler Head @76-A02BCBBC
    public class tbl_imovelNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @76-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @76-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @76-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-04024961
    Page ListaImovelModel = (Page)request.getAttribute("ListaImovel_page");
    Page ListaImovelParent = (Page)request.getAttribute("ListaImovelParent");
    if (ListaImovelModel == null) {
        PageController ListaImovelCntr = new PageController(request, response, application, "/ListaImovel.xml" );
        ListaImovelModel = ListaImovelCntr.getPage();
        ListaImovelModel.setRelativePath("./");
        //if (ListaImovelParent != null) {
            //if (!ListaImovelParent.getChild(ListaImovelModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaImovelModel.getChild("tbl_imovel")).getChild("Navigator")).addControlListener(new tbl_imovelNavigatorNavigatorHandler());
        ListaImovelCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaImovelModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
<%
        if (ListaImovelParent == null) {
            ListaImovelModel.setCookies();
            if (ListaImovelModel.redirect()) return;
        } else {
            ListaImovelModel.redirect();
        }
    }
//End Processing

%>
