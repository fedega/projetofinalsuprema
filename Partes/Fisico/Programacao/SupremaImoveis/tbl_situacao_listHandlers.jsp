<%--== Handlers ==--%> <%--tbl_situacao_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-82053954
    public class tbl_situacao_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-336F91B0
    public class tbl_situacaoNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-74A9C25F
    Page tbl_situacao_listModel = (Page)request.getAttribute("tbl_situacao_list_page");
    Page tbl_situacao_listParent = (Page)request.getAttribute("tbl_situacao_listParent");
    if (tbl_situacao_listModel == null) {
        PageController tbl_situacao_listCntr = new PageController(request, response, application, "/tbl_situacao_list.xml" );
        tbl_situacao_listModel = tbl_situacao_listCntr.getPage();
        tbl_situacao_listModel.setRelativePath("./");
        //if (tbl_situacao_listParent != null) {
            //if (!tbl_situacao_listParent.getChild(tbl_situacao_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_situacao_listModel.getChild("tbl_situacao")).getChild("Navigator")).addControlListener(new tbl_situacaoNavigatorNavigatorHandler());
        tbl_situacao_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_situacao_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_situacao_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_situacao_listParent == null) {
            tbl_situacao_listModel.setCookies();
            if (tbl_situacao_listModel.redirect()) return;
        } else {
            tbl_situacao_listModel.redirect();
        }
    }
//End Processing

%>
