<%--== Handlers ==--%> <%--tbl_imovel_list Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-0710DC7E
    public class tbl_imovel_listServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Processing @1-4DF2E33C
    Page tbl_imovel_listModel = (Page)request.getAttribute("tbl_imovel_list_page");
    Page tbl_imovel_listParent = (Page)request.getAttribute("tbl_imovel_listParent");
    if (tbl_imovel_listModel == null) {
        PageController tbl_imovel_listCntr = new PageController(request, response, application, "/tbl_imovel_list.xml" );
        tbl_imovel_listModel = tbl_imovel_listCntr.getPage();
        tbl_imovel_listModel.setRelativePath("./");
        //if (tbl_imovel_listParent != null) {
            //if (!tbl_imovel_listParent.getChild(tbl_imovel_listModel.getName()).isVisible()) return;
        //}
        tbl_imovel_listCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_imovel_listModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_imovel_listModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_imovel_listParent == null) {
            tbl_imovel_listModel.setCookies();
            if (tbl_imovel_listModel.redirect()) return;
        } else {
            tbl_imovel_listModel.redirect();
        }
    }
//End Processing

%>
