<%--== Handlers ==--%> <%--tbl_situacao_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-03872E13
    public class tbl_situacao_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_situacao Record Handler Head @2-89625A15
    public class tbl_situacao_mainttbl_situacaoRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_situacao Record Handler Head

//tbl_situacao afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_situacao afterInitialize Method Head

//tbl_situacao afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_situacao afterInitialize Method Tail

//tbl_situacao OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_situacao OnSetDataSource Method Head

//tbl_situacao OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_situacao OnSetDataSource Method Tail

//tbl_situacao BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_situacao BeforeShow Method Head

//tbl_situacao BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeShow Method Tail

//tbl_situacao OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_situacao OnValidate Method Head

//tbl_situacao OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_situacao OnValidate Method Tail

//tbl_situacao BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_situacao BeforeSelect Method Head

//tbl_situacao BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeSelect Method Tail

//tbl_situacao BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_situacao BeforeBuildSelect Method Head

//tbl_situacao BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeBuildSelect Method Tail

//tbl_situacao BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_situacao BeforeExecuteSelect Method Head

//tbl_situacao BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeExecuteSelect Method Tail

//tbl_situacao AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_situacao AfterExecuteSelect Method Head

//tbl_situacao AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_situacao AfterExecuteSelect Method Tail

//tbl_situacao BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_situacao BeforeInsert Method Head

//tbl_situacao BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeInsert Method Tail

//tbl_situacao BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_situacao BeforeBuildInsert Method Head

//tbl_situacao BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeBuildInsert Method Tail

//tbl_situacao BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_situacao BeforeExecuteInsert Method Head

//tbl_situacao BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeExecuteInsert Method Tail

//tbl_situacao AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_situacao AfterExecuteInsert Method Head

//tbl_situacao AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_situacao AfterExecuteInsert Method Tail

//tbl_situacao AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_situacao AfterInsert Method Head

//tbl_situacao AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_situacao AfterInsert Method Tail

//tbl_situacao BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_situacao BeforeUpdate Method Head

//tbl_situacao BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeUpdate Method Tail

//tbl_situacao BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_situacao BeforeBuildUpdate Method Head

//tbl_situacao BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeBuildUpdate Method Tail

//tbl_situacao BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_situacao BeforeExecuteUpdate Method Head

//tbl_situacao BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeExecuteUpdate Method Tail

//tbl_situacao AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_situacao AfterExecuteUpdate Method Head

//tbl_situacao AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_situacao AfterExecuteUpdate Method Tail

//tbl_situacao AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_situacao AfterUpdate Method Head

//tbl_situacao AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_situacao AfterUpdate Method Tail

//tbl_situacao BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_situacao BeforeDelete Method Head

//tbl_situacao BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeDelete Method Tail

//tbl_situacao BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_situacao BeforeBuildDelete Method Head

//tbl_situacao BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeBuildDelete Method Tail

//tbl_situacao BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_situacao BeforeExecuteDelete Method Head

//tbl_situacao BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_situacao BeforeExecuteDelete Method Tail

//tbl_situacao AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_situacao AfterExecuteDelete Method Head

//tbl_situacao AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_situacao AfterExecuteDelete Method Tail

//tbl_situacao AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_situacao AfterDelete Method Head

//tbl_situacao AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_situacao AfterDelete Method Tail

//tbl_situacao Record Handler Tail @2-FCB6E20C
    }
//End tbl_situacao Record Handler Tail

//Situacao TextBox Handler Head @7-E661F6B0
    public class tbl_situacaoSituacaoTextBoxHandler implements ValidationListener {
//End Situacao TextBox Handler Head

//Situacao BeforeShow Method Head @7-46046458
        public void beforeShow(Event e) {
//End Situacao BeforeShow Method Head

//Situacao BeforeShow Method Tail @7-FCB6E20C
        }
//End Situacao BeforeShow Method Tail

//Situacao OnValidate Method Head @7-5F430F8E
        public void onValidate(Event e) {
//End Situacao OnValidate Method Head

//Situacao Required Validation @7-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Situacao Required Validation

//Situacao OnValidate Method Tail @7-FCB6E20C
        }
//End Situacao OnValidate Method Tail

//Situacao TextBox Handler Tail @7-FCB6E20C
    }
//End Situacao TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-A1D9ADD9
    Page tbl_situacao_maintModel = (Page)request.getAttribute("tbl_situacao_maint_page");
    Page tbl_situacao_maintParent = (Page)request.getAttribute("tbl_situacao_maintParent");
    if (tbl_situacao_maintModel == null) {
        PageController tbl_situacao_maintCntr = new PageController(request, response, application, "/tbl_situacao_maint.xml" );
        tbl_situacao_maintModel = tbl_situacao_maintCntr.getPage();
        tbl_situacao_maintModel.setRelativePath("./");
        //if (tbl_situacao_maintParent != null) {
            //if (!tbl_situacao_maintParent.getChild(tbl_situacao_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_situacao_maintModel.getChild("tbl_situacao")).addRecordListener(new tbl_situacao_mainttbl_situacaoRecordHandler());
        ((TextBox)((Record)tbl_situacao_maintModel.getChild("tbl_situacao")).getChild("Situacao")).addValidationListener(new tbl_situacaoSituacaoTextBoxHandler());
        tbl_situacao_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_situacao_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_situacao_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_situacao_maintParent == null) {
            tbl_situacao_maintModel.setCookies();
            if (tbl_situacao_maintModel.redirect()) return;
        } else {
            tbl_situacao_maintModel.redirect();
        }
    }
//End Processing

%>
