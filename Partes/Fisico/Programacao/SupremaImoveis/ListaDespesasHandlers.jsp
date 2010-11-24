<%--== Handlers ==--%> <%--ListaDespesas Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-5CA98151
    public class ListaDespesasServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator BeforeShow Method Tail @29-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @29-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-E3992109
    Page ListaDespesasModel = (Page)request.getAttribute("ListaDespesas_page");
    Page ListaDespesasParent = (Page)request.getAttribute("ListaDespesasParent");
    if (ListaDespesasModel == null) {
        PageController ListaDespesasCntr = new PageController(request, response, application, "/ListaDespesas.xml" );
        ListaDespesasModel = ListaDespesasCntr.getPage();
        ListaDespesasModel.setRelativePath("./");
        //if (ListaDespesasParent != null) {
            //if (!ListaDespesasParent.getChild(ListaDespesasModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaDespesasModel.getChild("tbl_despesas")).getChild("Navigator")).addControlListener(new tbl_despesasNavigatorNavigatorHandler());
        ListaDespesasCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaDespesasModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaDespesasModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaDespesasParent == null) {
            ListaDespesasModel.setCookies();
            if (ListaDespesasModel.redirect()) return;
        } else {
            ListaDespesasModel.redirect();
        }
    }
//End Processing

%>
