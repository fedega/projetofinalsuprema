<%--== Handlers ==--%> <%--tbl_cidade_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-A9846598
    public class tbl_cidade_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @20-7EA79F3D
    public class tbl_cidadeNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-CD389931
    Page tbl_cidade_listModel = (Page)request.getAttribute("tbl_cidade_list_page");
    Page tbl_cidade_listParent = (Page)request.getAttribute("tbl_cidade_listParent");
    if (tbl_cidade_listModel == null) {
        PageController tbl_cidade_listCntr = new PageController(request, response, application, "/tbl_cidade_list.xml" );
        tbl_cidade_listModel = tbl_cidade_listCntr.getPage();
        tbl_cidade_listModel.setRelativePath("./");
        //if (tbl_cidade_listParent != null) {
            //if (!tbl_cidade_listParent.getChild(tbl_cidade_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_cidade_listModel.getChild("tbl_cidade")).getChild("Navigator")).addControlListener(new tbl_cidadeNavigatorNavigatorHandler());
        tbl_cidade_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_cidade_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_cidade_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_cidade_listParent == null) {
            tbl_cidade_listModel.setCookies();
            if (tbl_cidade_listModel.redirect()) return;
        } else {
            tbl_cidade_listModel.redirect();
        }
    }
//End Processing

%>
