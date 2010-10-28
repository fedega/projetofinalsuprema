<%--== Handlers ==--%> <%--tbl_documentaca_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-46BC23F8
    public class tbl_documentaca_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_documentacao Record Handler Head @2-C2B5D936
    public class tbl_documentaca_mainttbl_documentacaoRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_documentacao Record Handler Head

//tbl_documentacao afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_documentacao afterInitialize Method Head

//tbl_documentacao afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_documentacao afterInitialize Method Tail

//tbl_documentacao OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_documentacao OnSetDataSource Method Head

//tbl_documentacao OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_documentacao OnSetDataSource Method Tail

//tbl_documentacao BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_documentacao BeforeShow Method Head

//tbl_documentacao BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeShow Method Tail

//tbl_documentacao OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_documentacao OnValidate Method Head

//tbl_documentacao OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_documentacao OnValidate Method Tail

//tbl_documentacao BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_documentacao BeforeSelect Method Head

//tbl_documentacao BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeSelect Method Tail

//tbl_documentacao BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_documentacao BeforeBuildSelect Method Head

//tbl_documentacao BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeBuildSelect Method Tail

//tbl_documentacao BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_documentacao BeforeExecuteSelect Method Head

//tbl_documentacao BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeExecuteSelect Method Tail

//tbl_documentacao AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_documentacao AfterExecuteSelect Method Head

//tbl_documentacao AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_documentacao AfterExecuteSelect Method Tail

//tbl_documentacao BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_documentacao BeforeInsert Method Head

//tbl_documentacao BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeInsert Method Tail

//tbl_documentacao BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_documentacao BeforeBuildInsert Method Head

//tbl_documentacao BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeBuildInsert Method Tail

//tbl_documentacao BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_documentacao BeforeExecuteInsert Method Head

//tbl_documentacao BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeExecuteInsert Method Tail

//tbl_documentacao AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_documentacao AfterExecuteInsert Method Head

//tbl_documentacao AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_documentacao AfterExecuteInsert Method Tail

//tbl_documentacao AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_documentacao AfterInsert Method Head

//tbl_documentacao AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_documentacao AfterInsert Method Tail

//tbl_documentacao BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_documentacao BeforeUpdate Method Head

//tbl_documentacao BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeUpdate Method Tail

//tbl_documentacao BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_documentacao BeforeBuildUpdate Method Head

//tbl_documentacao BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeBuildUpdate Method Tail

//tbl_documentacao BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_documentacao BeforeExecuteUpdate Method Head

//tbl_documentacao BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeExecuteUpdate Method Tail

//tbl_documentacao AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_documentacao AfterExecuteUpdate Method Head

//tbl_documentacao AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_documentacao AfterExecuteUpdate Method Tail

//tbl_documentacao AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_documentacao AfterUpdate Method Head

//tbl_documentacao AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_documentacao AfterUpdate Method Tail

//tbl_documentacao BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_documentacao BeforeDelete Method Head

//tbl_documentacao BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeDelete Method Tail

//tbl_documentacao BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_documentacao BeforeBuildDelete Method Head

//tbl_documentacao BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeBuildDelete Method Tail

//tbl_documentacao BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_documentacao BeforeExecuteDelete Method Head

//tbl_documentacao BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_documentacao BeforeExecuteDelete Method Tail

//tbl_documentacao AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_documentacao AfterExecuteDelete Method Head

//tbl_documentacao AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_documentacao AfterExecuteDelete Method Tail

//tbl_documentacao AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_documentacao AfterDelete Method Head

//tbl_documentacao AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_documentacao AfterDelete Method Tail

//tbl_documentacao Record Handler Tail @2-FCB6E20C
    }
//End tbl_documentacao Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-CF9FFCC7
    Page tbl_documentaca_maintModel = (Page)request.getAttribute("tbl_documentaca_maint_page");
    Page tbl_documentaca_maintParent = (Page)request.getAttribute("tbl_documentaca_maintParent");
    if (tbl_documentaca_maintModel == null) {
        PageController tbl_documentaca_maintCntr = new PageController(request, response, application, "/tbl_documentaca_maint.xml" );
        tbl_documentaca_maintModel = tbl_documentaca_maintCntr.getPage();
        tbl_documentaca_maintModel.setRelativePath("./");
        //if (tbl_documentaca_maintParent != null) {
            //if (!tbl_documentaca_maintParent.getChild(tbl_documentaca_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_documentaca_maintModel.getChild("tbl_documentacao")).addRecordListener(new tbl_documentaca_mainttbl_documentacaoRecordHandler());
        tbl_documentaca_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_documentaca_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_documentaca_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_documentaca_maintParent == null) {
            tbl_documentaca_maintModel.setCookies();
            if (tbl_documentaca_maintModel.redirect()) return;
        } else {
            tbl_documentaca_maintModel.redirect();
        }
    }
//End Processing

%>
