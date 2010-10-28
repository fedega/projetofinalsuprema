<%--== Handlers ==--%> <%--tbl_visita_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-018F2FAA
    public class tbl_visita_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @32-07F8A0AA
    public class tbl_visitaNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @32-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @33-DADF677C
        Long TotalPages_33_1 = null;
        TotalPages_33_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_33_2 = null;
        exprParam2_33_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_33_1 != null && exprParam2_33_2 != null && TotalPages_33_1.compareTo(exprParam2_33_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @32-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @32-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-4550E8BD
    Page tbl_visita_listModel = (Page)request.getAttribute("tbl_visita_list_page");
    Page tbl_visita_listParent = (Page)request.getAttribute("tbl_visita_listParent");
    if (tbl_visita_listModel == null) {
        PageController tbl_visita_listCntr = new PageController(request, response, application, "/tbl_visita_list.xml" );
        tbl_visita_listModel = tbl_visita_listCntr.getPage();
        tbl_visita_listModel.setRelativePath("./");
        //if (tbl_visita_listParent != null) {
            //if (!tbl_visita_listParent.getChild(tbl_visita_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_visita_listModel.getChild("tbl_visita")).getChild("Navigator")).addControlListener(new tbl_visitaNavigatorNavigatorHandler());
        tbl_visita_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_visita_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_visita_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_visita_listParent == null) {
            tbl_visita_listModel.setCookies();
            if (tbl_visita_listModel.redirect()) return;
        } else {
            tbl_visita_listModel.redirect();
        }
    }
//End Processing

%>
