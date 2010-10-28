<%--== Handlers ==--%> <%--tbl_solicitacoe_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-EBF78A44
    public class tbl_solicitacoe_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Processing @1-96D347F9
    Page tbl_solicitacoe_listModel = (Page)request.getAttribute("tbl_solicitacoe_list_page");
    Page tbl_solicitacoe_listParent = (Page)request.getAttribute("tbl_solicitacoe_listParent");
    if (tbl_solicitacoe_listModel == null) {
        PageController tbl_solicitacoe_listCntr = new PageController(request, response, application, "/tbl_solicitacoe_list.xml" );
        tbl_solicitacoe_listModel = tbl_solicitacoe_listCntr.getPage();
        tbl_solicitacoe_listModel.setRelativePath("./");
        //if (tbl_solicitacoe_listParent != null) {
            //if (!tbl_solicitacoe_listParent.getChild(tbl_solicitacoe_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_solicitacoe_listModel.getChild("tbl_solicitacoes")).getChild("Navigator")).addControlListener(new tbl_solicitacoesNavigatorNavigatorHandler());
        tbl_solicitacoe_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_solicitacoe_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_solicitacoe_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_solicitacoe_listParent == null) {
            tbl_solicitacoe_listModel.setCookies();
            if (tbl_solicitacoe_listModel.redirect()) return;
        } else {
            tbl_solicitacoe_listModel.redirect();
        }
    }
//End Processing

%>
