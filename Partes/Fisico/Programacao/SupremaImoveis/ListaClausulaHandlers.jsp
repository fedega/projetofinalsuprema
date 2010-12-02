<%--== Handlers ==--%> <%--ListaClausula Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-D918267E
    public class ListaClausulaServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @23-DFF775B2
    public class tbl_clausulaNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-159BDB44
    Page ListaClausulaModel = (Page)request.getAttribute("ListaClausula_page");
    Page ListaClausulaParent = (Page)request.getAttribute("ListaClausulaParent");
    if (ListaClausulaModel == null) {
        PageController ListaClausulaCntr = new PageController(request, response, application, "/ListaClausula.xml" );
        ListaClausulaModel = ListaClausulaCntr.getPage();
        ListaClausulaModel.setRelativePath("./");
        //if (ListaClausulaParent != null) {
            //if (!ListaClausulaParent.getChild(ListaClausulaModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaClausulaModel.getChild("tbl_clausula")).getChild("Navigator")).addControlListener(new tbl_clausulaNavigatorNavigatorHandler());
        ListaClausulaCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaClausulaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaClausulaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaClausulaParent == null) {
            ListaClausulaModel.setCookies();
            if (ListaClausulaModel.redirect()) return;
        } else {
            ListaClausulaModel.redirect();
        }
    }
//End Processing

%>
