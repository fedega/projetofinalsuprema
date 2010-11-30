<%--== Handlers ==--%> <%--ListaSolicitacoes Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-64B296E9
    public class ListaSolicitacoesServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @26-7EAE23E4
    public class tbl_solicitacoesNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @26-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @27-9BA4710A
        Long TotalPages_27_1 = null;
        TotalPages_27_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_27_2 = null;
        exprParam2_27_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_27_1 != null && exprParam2_27_2 != null && TotalPages_27_1.compareTo(exprParam2_27_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @26-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @26-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-D1C1F4F1
    Page ListaSolicitacoesModel = (Page)request.getAttribute("ListaSolicitacoes_page");
    Page ListaSolicitacoesParent = (Page)request.getAttribute("ListaSolicitacoesParent");
    if (ListaSolicitacoesModel == null) {
        PageController ListaSolicitacoesCntr = new PageController(request, response, application, "/ListaSolicitacoes.xml" );
        ListaSolicitacoesModel = ListaSolicitacoesCntr.getPage();
        ListaSolicitacoesModel.setRelativePath("./");
        //if (ListaSolicitacoesParent != null) {
            //if (!ListaSolicitacoesParent.getChild(ListaSolicitacoesModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaSolicitacoesModel.getChild("tbl_solicitacoes")).getChild("Navigator")).addControlListener(new tbl_solicitacoesNavigatorNavigatorHandler());
        ListaSolicitacoesCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaSolicitacoesModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaSolicitacoesModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaSolicitacoesParent == null) {
            ListaSolicitacoesModel.setCookies();
            if (ListaSolicitacoesModel.redirect()) return;
        } else {
            ListaSolicitacoesModel.redirect();
        }
    }
//End Processing

%>