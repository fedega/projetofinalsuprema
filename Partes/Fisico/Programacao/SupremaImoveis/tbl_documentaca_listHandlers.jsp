<%--== Handlers ==--%> <%--tbl_documentaca_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-6654A779
    public class tbl_documentaca_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @23-1F2A0AE7
    public class tbl_documentacaoNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @23-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @24-4F0A077B
        Long TotalPages_24_1 = null;
        TotalPages_24_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_24_2 = null;
        exprParam2_24_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_24_1 != null && exprParam2_24_2 != null && TotalPages_24_1.compareTo(exprParam2_24_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @23-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @23-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-57DAAC1B
    Page tbl_documentaca_listModel = (Page)request.getAttribute("tbl_documentaca_list_page");
    Page tbl_documentaca_listParent = (Page)request.getAttribute("tbl_documentaca_listParent");
    if (tbl_documentaca_listModel == null) {
        PageController tbl_documentaca_listCntr = new PageController(request, response, application, "/tbl_documentaca_list.xml" );
        tbl_documentaca_listModel = tbl_documentaca_listCntr.getPage();
        tbl_documentaca_listModel.setRelativePath("./");
        //if (tbl_documentaca_listParent != null) {
            //if (!tbl_documentaca_listParent.getChild(tbl_documentaca_listModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_documentaca_listModel.getChild("tbl_documentacao")).getChild("Navigator")).addControlListener(new tbl_documentacaoNavigatorNavigatorHandler());
        tbl_documentaca_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_documentaca_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_documentaca_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_documentaca_listParent == null) {
            tbl_documentaca_listModel.setCookies();
            if (tbl_documentaca_listModel.redirect()) return;
        } else {
            tbl_documentaca_listModel.redirect();
        }
    }
//End Processing

%>
