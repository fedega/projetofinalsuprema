<%--== Handlers ==--%> <%--tbl_tipo_causul_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-91A805E6
    public class tbl_tipo_causul_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-89833F6F
    public class tbl_tipo_causulaNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-EE5D95ED
    Page tbl_tipo_causul_listModel = (Page)request.getAttribute("tbl_tipo_causul_list_page");
    Page tbl_tipo_causul_listParent = (Page)request.getAttribute("tbl_tipo_causul_listParent");
    if (tbl_tipo_causul_listModel == null) {
        PageController tbl_tipo_causul_listCntr = new PageController(request, response, application, "/tbl_tipo_causul_list.xml" );
        tbl_tipo_causul_listModel = tbl_tipo_causul_listCntr.getPage();
        tbl_tipo_causul_listModel.setRelativePath("./");
        //if (tbl_tipo_causul_listParent != null) {
            //if (!tbl_tipo_causul_listParent.getChild(tbl_tipo_causul_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_tipo_causul_listModel.getChild("tbl_tipo_causula")).getChild("Navigator")).addControlListener(new tbl_tipo_causulaNavigatorNavigatorHandler());
        tbl_tipo_causul_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_tipo_causul_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_tipo_causul_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_tipo_causul_listParent == null) {
            tbl_tipo_causul_listModel.setCookies();
            if (tbl_tipo_causul_listModel.redirect()) return;
        } else {
            tbl_tipo_causul_listModel.redirect();
        }
    }
//End Processing

%>
