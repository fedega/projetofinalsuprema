<%--== Handlers ==--%> <%--tbl_aluguel_lista Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-00DB3565
    public class tbl_aluguel_listaServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Navigator Navigator Handler Head @31-8A163573
    public class tbl_aluguelNavigatorNavigatorHandler implements ControlListener {
//End Navigator Navigator Handler Head

//Navigator BeforeShow Method Head @31-46046458
        public void beforeShow(Event e) {
//End Navigator BeforeShow Method Head

//Event BeforeShow Action Hide-Show Component @32-96BAB553
        Long TotalPages_32_1 = null;
        TotalPages_32_1 = com.codecharge.util.Utils.convertToLong(e.getGrid().getTotalPages());
        Long exprParam2_32_2 = null;
        exprParam2_32_2 = com.codecharge.util.Utils.convertToLong(2);
        if (
                (TotalPages_32_1 != null && exprParam2_32_2 != null && TotalPages_32_1.compareTo(exprParam2_32_2) < 0)) {
            e.getModel().setVisible(false);
        }
//End Event BeforeShow Action Hide-Show Component

//Navigator BeforeShow Method Tail @31-FCB6E20C
        }
//End Navigator BeforeShow Method Tail

//Navigator Navigator Handler Tail @31-FCB6E20C
    }
//End Navigator Navigator Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-652E48E7
    Page tbl_aluguel_listaModel = (Page)request.getAttribute("tbl_aluguel_lista_page");
    Page tbl_aluguel_listaParent = (Page)request.getAttribute("tbl_aluguel_listaParent");
    if (tbl_aluguel_listaModel == null) {
        PageController tbl_aluguel_listaCntr = new PageController(request, response, application, "/tbl_aluguel_lista.xml" );
        tbl_aluguel_listaModel = tbl_aluguel_listaCntr.getPage();
        tbl_aluguel_listaModel.setRelativePath("./");
        //if (tbl_aluguel_listaParent != null) {
            //if (!tbl_aluguel_listaParent.getChild(tbl_aluguel_listaModel.getName()).isVisible()) return;
        //}
        ((Navigator)((Grid)tbl_aluguel_listaModel.getChild("tbl_aluguel")).getChild("Navigator")).addControlListener(new tbl_aluguelNavigatorNavigatorHandler());
        tbl_aluguel_listaCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_aluguel_listaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_aluguel_listaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_aluguel_listaParent == null) {
            tbl_aluguel_listaModel.setCookies();
            if (tbl_aluguel_listaModel.redirect()) return;
        } else {
            tbl_aluguel_listaModel.redirect();
        }
    }
//End Processing

%>
