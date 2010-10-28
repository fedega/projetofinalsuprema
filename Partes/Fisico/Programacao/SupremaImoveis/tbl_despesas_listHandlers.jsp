<%--== Handlers ==--%> <%--tbl_despesas_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-AC70D827
    public class tbl_despesas_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @29-033571B8
    public class tbl_despesasNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @29-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @30-0E71110D
        Long TotalPages_30_1 = null;
        TotalPages_30_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_30_2 = null;
        exprParam2_30_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_30_1 != null && exprParam2_30_2 != null && TotalPages_30_1.compareTo(exprParam2_30_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @29-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @29-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-3C75E68C
    Page tbl_despesas_listModel = (Page)request.getAttribute("tbl_despesas_list_page");
    Page tbl_despesas_listParent = (Page)request.getAttribute("tbl_despesas_listParent");
    if (tbl_despesas_listModel == null) {
        PageController tbl_despesas_listCntr = new PageController(request, response, application, "/tbl_despesas_list.xml" );
        tbl_despesas_listModel = tbl_despesas_listCntr.getPage();
        tbl_despesas_listModel.setRelativePath("./");
        //if (tbl_despesas_listParent != null) {
            //if (!tbl_despesas_listParent.getChild(tbl_despesas_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_despesas_listModel.getChild("tbl_despesas")).getChild("Navigator")).addControlListener(new tbl_despesasNavigatorNavigatorHandler());
        tbl_despesas_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_despesas_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_despesas_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_despesas_listParent == null) {
            tbl_despesas_listModel.setCookies();
            if (tbl_despesas_listModel.redirect()) return;
        } else {
            tbl_despesas_listModel.redirect();
        }
    }
//End Processing

%>
