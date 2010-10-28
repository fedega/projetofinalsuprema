<%--== Handlers ==--%> <%--tbl_orgaoemisso_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-14870305
    public class tbl_orgaoemisso_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @22-921D32E6
    public class tbl_orgaoemissorNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-19A8E383
    Page tbl_orgaoemisso_listModel = (Page)request.getAttribute("tbl_orgaoemisso_list_page");
    Page tbl_orgaoemisso_listParent = (Page)request.getAttribute("tbl_orgaoemisso_listParent");
    if (tbl_orgaoemisso_listModel == null) {
        PageController tbl_orgaoemisso_listCntr = new PageController(request, response, application, "/tbl_orgaoemisso_list.xml" );
        tbl_orgaoemisso_listModel = tbl_orgaoemisso_listCntr.getPage();
        tbl_orgaoemisso_listModel.setRelativePath("./");
        //if (tbl_orgaoemisso_listParent != null) {
            //if (!tbl_orgaoemisso_listParent.getChild(tbl_orgaoemisso_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_orgaoemisso_listModel.getChild("tbl_orgaoemissor")).getChild("Navigator")).addControlListener(new tbl_orgaoemissorNavigatorNavigatorHandler());
        tbl_orgaoemisso_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_orgaoemisso_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_orgaoemisso_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_orgaoemisso_listParent == null) {
            tbl_orgaoemisso_listModel.setCookies();
            if (tbl_orgaoemisso_listModel.redirect()) return;
        } else {
            tbl_orgaoemisso_listModel.redirect();
        }
    }
//End Processing

%>
