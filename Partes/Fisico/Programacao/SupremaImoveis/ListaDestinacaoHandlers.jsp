<%--== Handlers ==--%> <%--ListaDestinacao Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-64359E5C
    public class ListaDestinacaoServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-52A75151
    public class tbl_destinacaoNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @17-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @18-8C873DE1
        Long TotalPages_18_1 = null;
        TotalPages_18_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_18_2 = null;
        exprParam2_18_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_18_1 != null && exprParam2_18_2 != null && TotalPages_18_1.compareTo(exprParam2_18_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @17-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @17-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-BB05AE90
    Page ListaDestinacaoModel = (Page)request.getAttribute("ListaDestinacao_page");
    Page ListaDestinacaoParent = (Page)request.getAttribute("ListaDestinacaoParent");
    if (ListaDestinacaoModel == null) {
        PageController ListaDestinacaoCntr = new PageController(request, response, application, "/ListaDestinacao.xml" );
        ListaDestinacaoModel = ListaDestinacaoCntr.getPage();
        ListaDestinacaoModel.setRelativePath("./");
        //if (ListaDestinacaoParent != null) {
            //if (!ListaDestinacaoParent.getChild(ListaDestinacaoModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaDestinacaoModel.getChild("tbl_destinacao")).getChild("Navigator")).addControlListener(new tbl_destinacaoNavigatorNavigatorHandler());
        ListaDestinacaoCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaDestinacaoModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaDestinacaoModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaDestinacaoParent == null) {
            ListaDestinacaoModel.setCookies();
            if (ListaDestinacaoModel.redirect()) return;
        } else {
            ListaDestinacaoModel.redirect();
        }
    }
//End Processing

%>
