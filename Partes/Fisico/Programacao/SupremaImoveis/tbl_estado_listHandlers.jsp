<%--== Handlers ==--%> <%--tbl_estado_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-48A04362
    public class tbl_estado_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @22-9E4FDF71
    public class tbl_estadoNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @22-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @23-71423FF7
        Long TotalPages_23_1 = null;
        TotalPages_23_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_23_2 = null;
        exprParam2_23_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_23_1 != null && exprParam2_23_2 != null && TotalPages_23_1.compareTo(exprParam2_23_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @22-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @22-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-C6447425
    Page tbl_estado_listModel = (Page)request.getAttribute("tbl_estado_list_page");
    Page tbl_estado_listParent = (Page)request.getAttribute("tbl_estado_listParent");
    if (tbl_estado_listModel == null) {
        PageController tbl_estado_listCntr = new PageController(request, response, application, "/tbl_estado_list.xml" );
        tbl_estado_listModel = tbl_estado_listCntr.getPage();
        tbl_estado_listModel.setRelativePath("./");
        //if (tbl_estado_listParent != null) {
            //if (!tbl_estado_listParent.getChild(tbl_estado_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_estado_listModel.getChild("tbl_estado")).getChild("Navigator")).addControlListener(new tbl_estadoNavigatorNavigatorHandler());
        tbl_estado_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_estado_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_estado_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_estado_listParent == null) {
            tbl_estado_listModel.setCookies();
            if (tbl_estado_listModel.redirect()) return;
        } else {
            tbl_estado_listModel.redirect();
        }
    }
//End Processing

%>
