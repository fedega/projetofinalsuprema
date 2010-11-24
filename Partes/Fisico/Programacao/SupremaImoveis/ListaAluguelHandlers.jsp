<%--== Handlers ==--%> <%--ListaAluguel Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-3B41138D
    public class ListaAluguelServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @31-8A163573
    public class tbl_aluguelNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @31-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @31-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @31-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-063AADF6
    Page ListaAluguelModel = (Page)request.getAttribute("ListaAluguel_page");
    Page ListaAluguelParent = (Page)request.getAttribute("ListaAluguelParent");
    if (ListaAluguelModel == null) {
        PageController ListaAluguelCntr = new PageController(request, response, application, "/ListaAluguel.xml" );
        ListaAluguelModel = ListaAluguelCntr.getPage();
        ListaAluguelModel.setRelativePath("./");
        //if (ListaAluguelParent != null) {
            //if (!ListaAluguelParent.getChild(ListaAluguelModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaAluguelModel.getChild("tbl_aluguel")).getChild("Navigator")).addControlListener(new tbl_aluguelNavigatorNavigatorHandler());
        ListaAluguelCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaAluguelModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaAluguelModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaAluguelParent == null) {
            ListaAluguelModel.setCookies();
            if (ListaAluguelModel.redirect()) return;
        } else {
            ListaAluguelModel.redirect();
        }
    }
//End Processing

%>
