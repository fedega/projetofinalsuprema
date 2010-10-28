<%--== Handlers ==--%> <%--tbl_aluguel_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-FAD1F912
    public class tbl_aluguel_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_aluguel Record Handler Head @2-DCE217A8
    public class tbl_aluguel_mainttbl_aluguelRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_aluguel Record Handler Head

//tbl_aluguel afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_aluguel afterInitialize Method Head

//tbl_aluguel afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_aluguel afterInitialize Method Tail

//tbl_aluguel OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_aluguel OnSetDataSource Method Head

//tbl_aluguel OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_aluguel OnSetDataSource Method Tail

//tbl_aluguel BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_aluguel BeforeShow Method Head

//tbl_aluguel BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeShow Method Tail

//tbl_aluguel OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_aluguel OnValidate Method Head

//tbl_aluguel OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_aluguel OnValidate Method Tail

//tbl_aluguel BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_aluguel BeforeSelect Method Head

//tbl_aluguel BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeSelect Method Tail

//tbl_aluguel BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_aluguel BeforeBuildSelect Method Head

//tbl_aluguel BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeBuildSelect Method Tail

//tbl_aluguel BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_aluguel BeforeExecuteSelect Method Head

//tbl_aluguel BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeExecuteSelect Method Tail

//tbl_aluguel AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_aluguel AfterExecuteSelect Method Head

//tbl_aluguel AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_aluguel AfterExecuteSelect Method Tail

//tbl_aluguel BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_aluguel BeforeInsert Method Head

//tbl_aluguel BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeInsert Method Tail

//tbl_aluguel BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_aluguel BeforeBuildInsert Method Head

//tbl_aluguel BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeBuildInsert Method Tail

//tbl_aluguel BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_aluguel BeforeExecuteInsert Method Head

//tbl_aluguel BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeExecuteInsert Method Tail

//tbl_aluguel AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_aluguel AfterExecuteInsert Method Head

//tbl_aluguel AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_aluguel AfterExecuteInsert Method Tail

//tbl_aluguel AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_aluguel AfterInsert Method Head

//tbl_aluguel AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_aluguel AfterInsert Method Tail

//tbl_aluguel BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_aluguel BeforeUpdate Method Head

//tbl_aluguel BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeUpdate Method Tail

//tbl_aluguel BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_aluguel BeforeBuildUpdate Method Head

//tbl_aluguel BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeBuildUpdate Method Tail

//tbl_aluguel BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_aluguel BeforeExecuteUpdate Method Head

//tbl_aluguel BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeExecuteUpdate Method Tail

//tbl_aluguel AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_aluguel AfterExecuteUpdate Method Head

//tbl_aluguel AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_aluguel AfterExecuteUpdate Method Tail

//tbl_aluguel AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_aluguel AfterUpdate Method Head

//tbl_aluguel AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_aluguel AfterUpdate Method Tail

//tbl_aluguel BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_aluguel BeforeDelete Method Head

//tbl_aluguel BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeDelete Method Tail

//tbl_aluguel BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_aluguel BeforeBuildDelete Method Head

//tbl_aluguel BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeBuildDelete Method Tail

//tbl_aluguel BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_aluguel BeforeExecuteDelete Method Head

//tbl_aluguel BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_aluguel BeforeExecuteDelete Method Tail

//tbl_aluguel AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_aluguel AfterExecuteDelete Method Head

//tbl_aluguel AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_aluguel AfterExecuteDelete Method Tail

//tbl_aluguel AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_aluguel AfterDelete Method Head

//tbl_aluguel AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_aluguel AfterDelete Method Tail

//tbl_aluguel Record Handler Tail @2-FCB6E20C
    }
//End tbl_aluguel Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-511BB1C6
    Page tbl_aluguel_maintModel = (Page)request.getAttribute("tbl_aluguel_maint_page");
    Page tbl_aluguel_maintParent = (Page)request.getAttribute("tbl_aluguel_maintParent");
    if (tbl_aluguel_maintModel == null) {
        PageController tbl_aluguel_maintCntr = new PageController(request, response, application, "/tbl_aluguel_maint.xml" );
        tbl_aluguel_maintModel = tbl_aluguel_maintCntr.getPage();
        tbl_aluguel_maintModel.setRelativePath("./");
        //if (tbl_aluguel_maintParent != null) {
            //if (!tbl_aluguel_maintParent.getChild(tbl_aluguel_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_aluguel_maintModel.getChild("tbl_aluguel")).addRecordListener(new tbl_aluguel_mainttbl_aluguelRecordHandler());
        tbl_aluguel_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_aluguel_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_aluguel_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_aluguel_maintParent == null) {
            tbl_aluguel_maintModel.setCookies();
            if (tbl_aluguel_maintModel.redirect()) return;
        } else {
            tbl_aluguel_maintModel.redirect();
        }
    }
//End Processing

%>
