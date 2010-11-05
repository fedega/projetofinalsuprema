<%--== Handlers ==--%> <%--ListaCliente Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-4B1EACDE
    public class ListaClienteServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @64-B9043718
    public class tbl_clienteNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @64-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @65-C089BDBB
        Long TotalPages_65_1 = null;
        TotalPages_65_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_65_2 = null;
        exprParam2_65_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_65_1 != null && exprParam2_65_2 != null && TotalPages_65_1.compareTo(exprParam2_65_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @64-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @64-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-5CA754FD
    Page ListaClienteModel = (Page)request.getAttribute("ListaCliente_page");
    Page ListaClienteParent = (Page)request.getAttribute("ListaClienteParent");
    if (ListaClienteModel == null) {
        PageController ListaClienteCntr = new PageController(request, response, application, "/ListaCliente.xml" );
        ListaClienteModel = ListaClienteCntr.getPage();
        ListaClienteModel.setRelativePath("./");
        //if (ListaClienteParent != null) {
            //if (!ListaClienteParent.getChild(ListaClienteModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaClienteModel.getChild("tbl_cliente")).getChild("Navigator")).addControlListener(new tbl_clienteNavigatorNavigatorHandler());
        ListaClienteCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaClienteModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaClienteModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaClienteParent == null) {
            ListaClienteModel.setCookies();
            if (ListaClienteModel.redirect()) return;
        } else {
            ListaClienteModel.redirect();
        }
    }
//End Processing

%>
