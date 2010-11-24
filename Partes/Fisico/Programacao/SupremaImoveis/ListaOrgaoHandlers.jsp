<%--== Handlers ==--%> <%--ListaOrgao Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-C44ED2AF
    public class ListaOrgaoServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator BeforeShow Method Tail @22-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @22-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-C1EC6070
    Page ListaOrgaoModel = (Page)request.getAttribute("ListaOrgao_page");
    Page ListaOrgaoParent = (Page)request.getAttribute("ListaOrgaoParent");
    if (ListaOrgaoModel == null) {
        PageController ListaOrgaoCntr = new PageController(request, response, application, "/ListaOrgao.xml" );
        ListaOrgaoModel = ListaOrgaoCntr.getPage();
        ListaOrgaoModel.setRelativePath("./");
        //if (ListaOrgaoParent != null) {
            //if (!ListaOrgaoParent.getChild(ListaOrgaoModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaOrgaoModel.getChild("tbl_orgaoemissor")).getChild("Navigator")).addControlListener(new tbl_orgaoemissorNavigatorNavigatorHandler());
        ListaOrgaoCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaOrgaoModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaOrgaoModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaOrgaoParent == null) {
            ListaOrgaoModel.setCookies();
            if (ListaOrgaoModel.redirect()) return;
        } else {
            ListaOrgaoModel.redirect();
        }
    }
//End Processing

%>
