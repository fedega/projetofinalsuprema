<%--== Handlers ==--%> <%--tbl_preferencia_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-F2EB965E
    public class tbl_preferencia_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @20-DCE810F6
    public class tbl_preferenciaNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @20-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @21-E9899BA9
        Long TotalPages_21_1 = null;
        TotalPages_21_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_21_2 = null;
        exprParam2_21_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_21_1 != null && exprParam2_21_2 != null && TotalPages_21_1.compareTo(exprParam2_21_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @20-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @20-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-06D30711
    Page tbl_preferencia_listModel = (Page)request.getAttribute("tbl_preferencia_list_page");
    Page tbl_preferencia_listParent = (Page)request.getAttribute("tbl_preferencia_listParent");
    if (tbl_preferencia_listModel == null) {
        PageController tbl_preferencia_listCntr = new PageController(request, response, application, "/tbl_preferencia_list.xml" );
        tbl_preferencia_listModel = tbl_preferencia_listCntr.getPage();
        tbl_preferencia_listModel.setRelativePath("./");
        //if (tbl_preferencia_listParent != null) {
            //if (!tbl_preferencia_listParent.getChild(tbl_preferencia_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_preferencia_listModel.getChild("tbl_preferencia")).getChild("Navigator")).addControlListener(new tbl_preferenciaNavigatorNavigatorHandler());
        tbl_preferencia_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_preferencia_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_preferencia_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_preferencia_listParent == null) {
            tbl_preferencia_listModel.setCookies();
            if (tbl_preferencia_listModel.redirect()) return;
        } else {
            tbl_preferencia_listModel.redirect();
        }
    }
//End Processing

%>
