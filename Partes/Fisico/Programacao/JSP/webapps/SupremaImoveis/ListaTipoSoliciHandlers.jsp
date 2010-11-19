<%--== Handlers ==--%> <%--ListaTipoSolici Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-06899D6E
    public class ListaTipoSoliciServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @17-B9F45211
    public class tbl_tipo_solicitacaoNavigatorNavigatorHandler implements ControlListener {
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

//Processing @1-E21E5D06
    Page ListaTipoSoliciModel = (Page)request.getAttribute("ListaTipoSolici_page");
    Page ListaTipoSoliciParent = (Page)request.getAttribute("ListaTipoSoliciParent");
    if (ListaTipoSoliciModel == null) {
        PageController ListaTipoSoliciCntr = new PageController(request, response, application, "/ListaTipoSolici.xml" );
        ListaTipoSoliciModel = ListaTipoSoliciCntr.getPage();
        ListaTipoSoliciModel.setRelativePath("./");
        //if (ListaTipoSoliciParent != null) {
            //if (!ListaTipoSoliciParent.getChild(ListaTipoSoliciModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)ListaTipoSoliciModel.getChild("tbl_tipo_solicitacao")).getChild("Navigator")).addControlListener(new tbl_tipo_solicitacaoNavigatorNavigatorHandler());
        ListaTipoSoliciCntr.process();
%>
        <% request.setAttribute("HeaderParent", ListaTipoSoliciModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ListaTipoSoliciModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ListaTipoSoliciParent == null) {
            ListaTipoSoliciModel.setCookies();
            if (ListaTipoSoliciModel.redirect()) return;
        } else {
            ListaTipoSoliciModel.redirect();
        }
    }
//End Processing

%>
