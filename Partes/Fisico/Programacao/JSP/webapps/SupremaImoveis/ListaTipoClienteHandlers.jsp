<%--== Handlers ==--%> <%--ListaTipoCliente Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-25B9B519
    public class ListaTipoClienteServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-861A052C
    public class tbl_tipo_clienteNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @17-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @18-8C873DE1
        Long TotalPages_18_1 = null;
        TotalPages_18_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_18_2 = null;
        exprParam2_18_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_18_1 != null && exprParam2_18_2 != null && TotalPages_18_1.compareTo(exprParam2_18_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @17-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @17-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-5873D42C
    Page ListaTipoClienteModel = (Page)request.getAttribute("ListaTipoCliente_page");
    Page ListaTipoClienteParent = (Page)request.getAttribute("ListaTipoClienteParent");
    if (ListaTipoClienteModel == null) {
        PageController ListaTipoClienteCntr = new PageController(request, response, application, "/ListaTipoCliente.xml" );
        ListaTipoClienteModel = ListaTipoClienteCntr.getPage();
        ListaTipoClienteModel.setRelativePath("./");
        //if (ListaTipoClienteParent != null) {
            //if (!ListaTipoClienteParent.getChild(ListaTipoClienteModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaTipoClienteModel.getChild("tbl_tipo_cliente")).getChild("Navigator")).addControlListener(new tbl_tipo_clienteNavigatorNavigatorHandler());
        ListaTipoClienteCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaTipoClienteModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaTipoClienteModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaTipoClienteParent == null) {
            ListaTipoClienteModel.setCookies();
            if (ListaTipoClienteModel.redirect()) return;
        } else {
            ListaTipoClienteModel.redirect();
        }
    }
//End Processing

%>
