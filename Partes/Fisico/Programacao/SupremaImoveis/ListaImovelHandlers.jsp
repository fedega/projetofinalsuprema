<%--== Handlers ==--%> <%--ListaImovel Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-0B08D223
    public class ListaImovelServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-77E0E55C
    Page ListaImovelModel = (Page)request.getAttribute("ListaImovel_page");
    Page ListaImovelParent = (Page)request.getAttribute("ListaImovelParent");
    if (ListaImovelModel == null) {
        PageController ListaImovelCntr = new PageController(request, response, application, "/ListaImovel.xml" );
        ListaImovelModel = ListaImovelCntr.getPage();
        ListaImovelModel.setRelativePath("./");
        //if (ListaImovelParent != null) {
            //if (!ListaImovelParent.getChild(ListaImovelModel.getName()).isVisible()) return;
        //}
        ListaImovelCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaImovelModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaImovelModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaImovelParent == null) {
            ListaImovelModel.setCookies();
            if (ListaImovelModel.redirect()) return;
        } else {
            ListaImovelModel.redirect();
        }
    }
//End Processing

%>
