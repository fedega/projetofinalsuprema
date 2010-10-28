<%--== Handlers ==--%> <%--tbl_funcionario_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-92C21571
    public class tbl_funcionario_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @54-3B9CEF5E
    public class tbl_funcionarioNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @54-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @55-E75F5267
        Long TotalPages_55_1 = null;
        TotalPages_55_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_55_2 = null;
        exprParam2_55_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_55_1 != null && exprParam2_55_2 != null && TotalPages_55_1.compareTo(exprParam2_55_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @54-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @54-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-9131C435
    Page tbl_funcionario_listModel = (Page)request.getAttribute("tbl_funcionario_list_page");
    Page tbl_funcionario_listParent = (Page)request.getAttribute("tbl_funcionario_listParent");
    if (tbl_funcionario_listModel == null) {
        PageController tbl_funcionario_listCntr = new PageController(request, response, application, "/tbl_funcionario_list.xml" );
        tbl_funcionario_listModel = tbl_funcionario_listCntr.getPage();
        tbl_funcionario_listModel.setRelativePath("./");
        //if (tbl_funcionario_listParent != null) {
            //if (!tbl_funcionario_listParent.getChild(tbl_funcionario_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_funcionario_listModel.getChild("tbl_funcionario")).getChild("Navigator")).addControlListener(new tbl_funcionarioNavigatorNavigatorHandler());
        tbl_funcionario_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_funcionario_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_funcionario_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_funcionario_listParent == null) {
            tbl_funcionario_listModel.setCookies();
            if (tbl_funcionario_listModel.redirect()) return;
        } else {
            tbl_funcionario_listModel.redirect();
        }
    }
//End Processing

%>
