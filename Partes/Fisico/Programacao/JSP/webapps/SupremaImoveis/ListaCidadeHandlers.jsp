<%--== Handlers ==--%> <%--ListaCidade Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-75AA5760
    public class ListaCidadeServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-F17B1FBF
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ((new HeaderServiceChecker()).check(request, response, context)) return true;
            if ((new FooterServiceChecker()).check(request, response, context)) return true;
            if ( "HideShow1".equals ( attr ) ) {
                return true;
            }
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

//Processing @1-ACC8FD1C
    Page ListaCidadeModel = (Page)request.getAttribute("ListaCidade_page");
    Page ListaCidadeParent = (Page)request.getAttribute("ListaCidadeParent");
    if (ListaCidadeModel == null) {
        PageController ListaCidadeCntr = new PageController(request, response, application, "/ListaCidade.xml" );
        ListaCidadeModel = ListaCidadeCntr.getPage();
        ListaCidadeModel.setRelativePath("./");
        //if (ListaCidadeParent != null) {
            //if (!ListaCidadeParent.getChild(ListaCidadeModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaCidadeModel.getChild("tbl_cidade")).getChild("Navigator")).addControlListener(new tbl_cidadeNavigatorNavigatorHandler());
        ListaCidadeCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaCidadeModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaCidadeModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaCidadeParent == null) {
            ListaCidadeModel.setCookies();
            if (ListaCidadeModel.redirect()) return;
        } else {
            ListaCidadeModel.redirect();
        }
    }
//End Processing

%>
