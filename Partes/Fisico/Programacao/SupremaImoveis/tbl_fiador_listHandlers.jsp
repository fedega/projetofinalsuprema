<%--== Handlers ==--%> <%--tbl_fiador_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-E6DE301B
    public class tbl_fiador_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @61-86BB0749
    public class tbl_fiadorNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @61-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @62-FEC18537
        Long TotalPages_62_1 = null;
        TotalPages_62_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_62_2 = null;
        exprParam2_62_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_62_1 != null && exprParam2_62_2 != null && TotalPages_62_1.compareTo(exprParam2_62_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @61-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @61-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-32A95A15
    Page tbl_fiador_listModel = (Page)request.getAttribute("tbl_fiador_list_page");
    Page tbl_fiador_listParent = (Page)request.getAttribute("tbl_fiador_listParent");
    if (tbl_fiador_listModel == null) {
        PageController tbl_fiador_listCntr = new PageController(request, response, application, "/tbl_fiador_list.xml" );
        tbl_fiador_listModel = tbl_fiador_listCntr.getPage();
        tbl_fiador_listModel.setRelativePath("./");
        //if (tbl_fiador_listParent != null) {
            //if (!tbl_fiador_listParent.getChild(tbl_fiador_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_fiador_listModel.getChild("tbl_fiador")).getChild("Navigator")).addControlListener(new tbl_fiadorNavigatorNavigatorHandler());
        tbl_fiador_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_fiador_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_fiador_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_fiador_listParent == null) {
            tbl_fiador_listModel.setCookies();
            if (tbl_fiador_listModel.redirect()) return;
        } else {
            tbl_fiador_listModel.redirect();
        }
    }
//End Processing

%>
