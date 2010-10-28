<%--== Handlers ==--%> <%--tbl_destinacao_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-39681532
    public class tbl_destinacao_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-52A75151
    public class tbl_destinacaoNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-8375944F
    Page tbl_destinacao_listModel = (Page)request.getAttribute("tbl_destinacao_list_page");
    Page tbl_destinacao_listParent = (Page)request.getAttribute("tbl_destinacao_listParent");
    if (tbl_destinacao_listModel == null) {
        PageController tbl_destinacao_listCntr = new PageController(request, response, application, "/tbl_destinacao_list.xml" );
        tbl_destinacao_listModel = tbl_destinacao_listCntr.getPage();
        tbl_destinacao_listModel.setRelativePath("./");
        //if (tbl_destinacao_listParent != null) {
            //if (!tbl_destinacao_listParent.getChild(tbl_destinacao_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_destinacao_listModel.getChild("tbl_destinacao")).getChild("Navigator")).addControlListener(new tbl_destinacaoNavigatorNavigatorHandler());
        tbl_destinacao_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_destinacao_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_destinacao_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_destinacao_listParent == null) {
            tbl_destinacao_listModel.setCookies();
            if (tbl_destinacao_listModel.redirect()) return;
        } else {
            tbl_destinacao_listModel.redirect();
        }
    }
//End Processing

%>
