<%--== Handlers ==--%> <%--ListaTipoDesp Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-53BCC448
    public class ListaTipoDespServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-22BE9B3F
    public class tbl_tipo_despesasNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @17-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Navigator BeforeShow Method Tail @17-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @17-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-A191B7FF
    Page ListaTipoDespModel = (Page)request.getAttribute("ListaTipoDesp_page");
    Page ListaTipoDespParent = (Page)request.getAttribute("ListaTipoDespParent");
    if (ListaTipoDespModel == null) {
        PageController ListaTipoDespCntr = new PageController(request, response, application, "/ListaTipoDesp.xml" );
        ListaTipoDespModel = ListaTipoDespCntr.getPage();
        ListaTipoDespModel.setRelativePath("./");
        //if (ListaTipoDespParent != null) {
            //if (!ListaTipoDespParent.getChild(ListaTipoDespModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaTipoDespModel.getChild("tbl_tipo_despesas")).getChild("Navigator")).addControlListener(new tbl_tipo_despesasNavigatorNavigatorHandler());
        ListaTipoDespCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaTipoDespModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaTipoDespModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaTipoDespParent == null) {
            ListaTipoDespModel.setCookies();
            if (ListaTipoDespModel.redirect()) return;
        } else {
            ListaTipoDespModel.redirect();
        }
    }
//End Processing

%>
