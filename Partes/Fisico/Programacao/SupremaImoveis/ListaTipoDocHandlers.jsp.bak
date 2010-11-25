<%--== Handlers ==--%> <%--ListaTipoDoc Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-7AA0A89A
    public class ListaTipoDocServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-8D5452A5
    public class tbl_tipo_docNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-E9C95B36
    Page ListaTipoDocModel = (Page)request.getAttribute("ListaTipoDoc_page");
    Page ListaTipoDocParent = (Page)request.getAttribute("ListaTipoDocParent");
    if (ListaTipoDocModel == null) {
        PageController ListaTipoDocCntr = new PageController(request, response, application, "/ListaTipoDoc.xml" );
        ListaTipoDocModel = ListaTipoDocCntr.getPage();
        ListaTipoDocModel.setRelativePath("./");
        //if (ListaTipoDocParent != null) {
            //if (!ListaTipoDocParent.getChild(ListaTipoDocModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaTipoDocModel.getChild("tbl_tipo_doc")).getChild("Navigator")).addControlListener(new tbl_tipo_docNavigatorNavigatorHandler());
        ListaTipoDocCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaTipoDocModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaTipoDocModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaTipoDocParent == null) {
            ListaTipoDocModel.setCookies();
            if (ListaTipoDocModel.redirect()) return;
        } else {
            ListaTipoDocModel.redirect();
        }
    }
//End Processing

%>
