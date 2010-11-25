<%--== Handlers ==--%> <%--ListaSituacao Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-BCDD564C
    public class ListaSituacaoServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-336F91B0
    public class tbl_situacaoNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-DB685F98
    Page ListaSituacaoModel = (Page)request.getAttribute("ListaSituacao_page");
    Page ListaSituacaoParent = (Page)request.getAttribute("ListaSituacaoParent");
    if (ListaSituacaoModel == null) {
        PageController ListaSituacaoCntr = new PageController(request, response, application, "/ListaSituacao.xml" );
        ListaSituacaoModel = ListaSituacaoCntr.getPage();
        ListaSituacaoModel.setRelativePath("./");
        //if (ListaSituacaoParent != null) {
            //if (!ListaSituacaoParent.getChild(ListaSituacaoModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaSituacaoModel.getChild("tbl_situacao")).getChild("Navigator")).addControlListener(new tbl_situacaoNavigatorNavigatorHandler());
        ListaSituacaoCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaSituacaoModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaSituacaoModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaSituacaoParent == null) {
            ListaSituacaoModel.setCookies();
            if (ListaSituacaoModel.redirect()) return;
        } else {
            ListaSituacaoModel.redirect();
        }
    }
//End Processing

%>
