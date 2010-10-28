<%--== Handlers ==--%> <%--tbl_contrato_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-C597943F
    public class tbl_contrato_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @30-3AD0257F
    public class tbl_contratoNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @30-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @31-4214C322
        Long TotalPages_31_1 = null;
        TotalPages_31_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_31_2 = null;
        exprParam2_31_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_31_1 != null && exprParam2_31_2 != null && TotalPages_31_1.compareTo(exprParam2_31_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @30-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @30-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-33686E3F
    Page tbl_contrato_listModel = (Page)request.getAttribute("tbl_contrato_list_page");
    Page tbl_contrato_listParent = (Page)request.getAttribute("tbl_contrato_listParent");
    if (tbl_contrato_listModel == null) {
        PageController tbl_contrato_listCntr = new PageController(request, response, application, "/tbl_contrato_list.xml" );
        tbl_contrato_listModel = tbl_contrato_listCntr.getPage();
        tbl_contrato_listModel.setRelativePath("./");
        //if (tbl_contrato_listParent != null) {
            //if (!tbl_contrato_listParent.getChild(tbl_contrato_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_contrato_listModel.getChild("tbl_contrato")).getChild("Navigator")).addControlListener(new tbl_contratoNavigatorNavigatorHandler());
        tbl_contrato_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_contrato_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_contrato_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_contrato_listParent == null) {
            tbl_contrato_listModel.setCookies();
            if (tbl_contrato_listModel.redirect()) return;
        } else {
            tbl_contrato_listModel.redirect();
        }
    }
//End Processing

%>
