<%--== Handlers ==--%> <%--ListaContrato Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-C1C4F4D1
    public class ListaContratoServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @30-3AD0257F
    public class tbl_contratoNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @30-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @31-4214C322
        Long TotalPages_31_1 = null;
        TotalPages_31_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_31_2 = null;
        exprParam2_31_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_31_1 != null && exprParam2_31_2 != null && TotalPages_31_1.compareTo(exprParam2_31_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @30-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @30-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-690EBC2E
    Page ListaContratoModel = (Page)request.getAttribute("ListaContrato_page");
    Page ListaContratoParent = (Page)request.getAttribute("ListaContratoParent");
    if (ListaContratoModel == null) {
        PageController ListaContratoCntr = new PageController(request, response, application, "/ListaContrato.xml" );
        ListaContratoModel = ListaContratoCntr.getPage();
        ListaContratoModel.setRelativePath("./");
        //if (ListaContratoParent != null) {
            //if (!ListaContratoParent.getChild(ListaContratoModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaContratoModel.getChild("tbl_contrato")).getChild("Navigator")).addControlListener(new tbl_contratoNavigatorNavigatorHandler());
        ListaContratoCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaContratoModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaContratoModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaContratoParent == null) {
            ListaContratoModel.setCookies();
            if (ListaContratoModel.redirect()) return;
        } else {
            ListaContratoModel.redirect();
        }
    }
//End Processing

%>
