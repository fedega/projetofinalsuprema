<%--== Handlers ==--%> <%--tbl_venda_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-1761E158
    public class tbl_venda_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_venda Record Handler Head @2-46F4911A
    public class tbl_venda_mainttbl_vendaRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_venda Record Handler Head

//tbl_venda afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_venda afterInitialize Method Head

//tbl_venda afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_venda afterInitialize Method Tail

//tbl_venda OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_venda OnSetDataSource Method Head

//tbl_venda OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_venda OnSetDataSource Method Tail

//tbl_venda BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_venda BeforeShow Method Head

//tbl_venda BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeShow Method Tail

//tbl_venda OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_venda OnValidate Method Head

//tbl_venda OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_venda OnValidate Method Tail

//tbl_venda BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_venda BeforeSelect Method Head

//tbl_venda BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeSelect Method Tail

//tbl_venda BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_venda BeforeBuildSelect Method Head

//tbl_venda BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeBuildSelect Method Tail

//tbl_venda BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_venda BeforeExecuteSelect Method Head

//tbl_venda BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeExecuteSelect Method Tail

//tbl_venda AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_venda AfterExecuteSelect Method Head

//tbl_venda AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_venda AfterExecuteSelect Method Tail

//tbl_venda BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_venda BeforeInsert Method Head

//tbl_venda BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeInsert Method Tail

//tbl_venda BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_venda BeforeBuildInsert Method Head

//tbl_venda BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeBuildInsert Method Tail

//tbl_venda BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_venda BeforeExecuteInsert Method Head

//tbl_venda BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeExecuteInsert Method Tail

//tbl_venda AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_venda AfterExecuteInsert Method Head

//tbl_venda AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_venda AfterExecuteInsert Method Tail

//tbl_venda AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_venda AfterInsert Method Head

//tbl_venda AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_venda AfterInsert Method Tail

//tbl_venda BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_venda BeforeUpdate Method Head

//tbl_venda BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeUpdate Method Tail

//tbl_venda BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_venda BeforeBuildUpdate Method Head

//tbl_venda BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeBuildUpdate Method Tail

//tbl_venda BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_venda BeforeExecuteUpdate Method Head

//tbl_venda BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeExecuteUpdate Method Tail

//tbl_venda AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_venda AfterExecuteUpdate Method Head

//tbl_venda AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_venda AfterExecuteUpdate Method Tail

//tbl_venda AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_venda AfterUpdate Method Head

//tbl_venda AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_venda AfterUpdate Method Tail

//tbl_venda BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_venda BeforeDelete Method Head

//tbl_venda BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeDelete Method Tail

//tbl_venda BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_venda BeforeBuildDelete Method Head

//tbl_venda BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeBuildDelete Method Tail

//tbl_venda BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_venda BeforeExecuteDelete Method Head

//tbl_venda BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_venda BeforeExecuteDelete Method Tail

//tbl_venda AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_venda AfterExecuteDelete Method Head

//tbl_venda AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_venda AfterExecuteDelete Method Tail

//tbl_venda AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_venda AfterDelete Method Head

//tbl_venda AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_venda AfterDelete Method Tail

//tbl_venda Record Handler Tail @2-FCB6E20C
    }
//End tbl_venda Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-BD6987EE
    Page tbl_venda_maintModel = (Page)request.getAttribute("tbl_venda_maint_page");
    Page tbl_venda_maintParent = (Page)request.getAttribute("tbl_venda_maintParent");
    if (tbl_venda_maintModel == null) {
        PageController tbl_venda_maintCntr = new PageController(request, response, application, "/tbl_venda_maint.xml" );
        tbl_venda_maintModel = tbl_venda_maintCntr.getPage();
        tbl_venda_maintModel.setRelativePath("./");
        //if (tbl_venda_maintParent != null) {
            //if (!tbl_venda_maintParent.getChild(tbl_venda_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_venda_maintModel.getChild("tbl_venda")).addRecordListener(new tbl_venda_mainttbl_vendaRecordHandler());
        tbl_venda_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_venda_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_venda_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_venda_maintParent == null) {
            tbl_venda_maintModel.setCookies();
            if (tbl_venda_maintModel.redirect()) return;
        } else {
            tbl_venda_maintModel.redirect();
        }
    }
//End Processing

%>
