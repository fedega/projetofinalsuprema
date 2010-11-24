<%--== Handlers ==--%> <%--ListaVenda Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-D6F854AA
    public class ListaVendaServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-C8A5CEE3
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ((new FooterServiceChecker()).check(request, response, context)) return true;
            if ((new HeaderServiceChecker()).check(request, response, context)) return true;
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//Navigator Navigator Handler Head @23-97118E8F
    public class tbl_vendaNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @23-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @23-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @23-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-33687835
    Page ListaVendaModel = (Page)request.getAttribute("ListaVenda_page");
    Page ListaVendaParent = (Page)request.getAttribute("ListaVendaParent");
    if (ListaVendaModel == null) {
        PageController ListaVendaCntr = new PageController(request, response, application, "/ListaVenda.xml" );
        ListaVendaModel = ListaVendaCntr.getPage();
        ListaVendaModel.setRelativePath("./");
        //if (ListaVendaParent != null) {
            //if (!ListaVendaParent.getChild(ListaVendaModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaVendaModel.getChild("tbl_venda")).getChild("Navigator")).addControlListener(new tbl_vendaNavigatorNavigatorHandler());
        ListaVendaCntr.process();
%>
        <% request.setAttribute("FooterParent", ListaVendaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
        <% request.setAttribute("HeaderParent", ListaVendaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
<%
        if (ListaVendaParent == null) {
            ListaVendaModel.setCookies();
            if (ListaVendaModel.redirect()) return;
        } else {
            ListaVendaModel.redirect();
        }
    }
//End Processing

%>
