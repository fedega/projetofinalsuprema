<%--== Handlers ==--%> <%--tbl_orgaoemisso_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-1F7DCD4B
    public class tbl_orgaoemisso_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_orgaoemissor Record Handler Head @2-E04742A5
    public class tbl_orgaoemisso_mainttbl_orgaoemissorRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_orgaoemissor Record Handler Head

//tbl_orgaoemissor afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_orgaoemissor afterInitialize Method Head

//tbl_orgaoemissor afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor afterInitialize Method Tail

//tbl_orgaoemissor OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_orgaoemissor OnSetDataSource Method Head

//tbl_orgaoemissor OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor OnSetDataSource Method Tail

//tbl_orgaoemissor BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_orgaoemissor BeforeShow Method Head

//tbl_orgaoemissor BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeShow Method Tail

//tbl_orgaoemissor OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_orgaoemissor OnValidate Method Head

//tbl_orgaoemissor OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor OnValidate Method Tail

//tbl_orgaoemissor BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_orgaoemissor BeforeSelect Method Head

//tbl_orgaoemissor BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeSelect Method Tail

//tbl_orgaoemissor BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeBuildSelect Method Head

//tbl_orgaoemissor BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeBuildSelect Method Tail

//tbl_orgaoemissor BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeExecuteSelect Method Head

//tbl_orgaoemissor BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeExecuteSelect Method Tail

//tbl_orgaoemissor AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_orgaoemissor AfterExecuteSelect Method Head

//tbl_orgaoemissor AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor AfterExecuteSelect Method Tail

//tbl_orgaoemissor BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_orgaoemissor BeforeInsert Method Head

//tbl_orgaoemissor BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeInsert Method Tail

//tbl_orgaoemissor BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeBuildInsert Method Head

//tbl_orgaoemissor BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeBuildInsert Method Tail

//tbl_orgaoemissor BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeExecuteInsert Method Head

//tbl_orgaoemissor BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeExecuteInsert Method Tail

//tbl_orgaoemissor AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_orgaoemissor AfterExecuteInsert Method Head

//tbl_orgaoemissor AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor AfterExecuteInsert Method Tail

//tbl_orgaoemissor AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_orgaoemissor AfterInsert Method Head

//tbl_orgaoemissor AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor AfterInsert Method Tail

//tbl_orgaoemissor BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_orgaoemissor BeforeUpdate Method Head

//tbl_orgaoemissor BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeUpdate Method Tail

//tbl_orgaoemissor BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeBuildUpdate Method Head

//tbl_orgaoemissor BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeBuildUpdate Method Tail

//tbl_orgaoemissor BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeExecuteUpdate Method Head

//tbl_orgaoemissor BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeExecuteUpdate Method Tail

//tbl_orgaoemissor AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_orgaoemissor AfterExecuteUpdate Method Head

//tbl_orgaoemissor AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor AfterExecuteUpdate Method Tail

//tbl_orgaoemissor AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_orgaoemissor AfterUpdate Method Head

//tbl_orgaoemissor AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor AfterUpdate Method Tail

//tbl_orgaoemissor BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_orgaoemissor BeforeDelete Method Head

//tbl_orgaoemissor BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeDelete Method Tail

//tbl_orgaoemissor BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeBuildDelete Method Head

//tbl_orgaoemissor BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeBuildDelete Method Tail

//tbl_orgaoemissor BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_orgaoemissor BeforeExecuteDelete Method Head

//tbl_orgaoemissor BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor BeforeExecuteDelete Method Tail

//tbl_orgaoemissor AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_orgaoemissor AfterExecuteDelete Method Head

//tbl_orgaoemissor AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor AfterExecuteDelete Method Tail

//tbl_orgaoemissor AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_orgaoemissor AfterDelete Method Head

//tbl_orgaoemissor AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_orgaoemissor AfterDelete Method Tail

//tbl_orgaoemissor Record Handler Tail @2-FCB6E20C
    }
//End tbl_orgaoemissor Record Handler Tail

//Sigla TextBox Handler Head @7-699611C8
    public class tbl_orgaoemissorSiglaTextBoxHandler implements ValidationListener {
//End Sigla TextBox Handler Head

//Sigla BeforeShow Method Head @7-46046458
        public void beforeShow(Event e) {
//End Sigla BeforeShow Method Head

//Sigla BeforeShow Method Tail @7-FCB6E20C
        }
//End Sigla BeforeShow Method Tail

//Sigla OnValidate Method Head @7-5F430F8E
        public void onValidate(Event e) {
//End Sigla OnValidate Method Head

//Sigla Required Validation @7-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Sigla Required Validation

//Sigla OnValidate Method Tail @7-FCB6E20C
        }
//End Sigla OnValidate Method Tail

//Sigla TextBox Handler Tail @7-FCB6E20C
    }
//End Sigla TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-096D30D3
    Page tbl_orgaoemisso_maintModel = (Page)request.getAttribute("tbl_orgaoemisso_maint_page");
    Page tbl_orgaoemisso_maintParent = (Page)request.getAttribute("tbl_orgaoemisso_maintParent");
    if (tbl_orgaoemisso_maintModel == null) {
        PageController tbl_orgaoemisso_maintCntr = new PageController(request, response, application, "/tbl_orgaoemisso_maint.xml" );
        tbl_orgaoemisso_maintModel = tbl_orgaoemisso_maintCntr.getPage();
        tbl_orgaoemisso_maintModel.setRelativePath("./");
        //if (tbl_orgaoemisso_maintParent != null) {
            //if (!tbl_orgaoemisso_maintParent.getChild(tbl_orgaoemisso_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_orgaoemisso_maintModel.getChild("tbl_orgaoemissor")).addRecordListener(new tbl_orgaoemisso_mainttbl_orgaoemissorRecordHandler());
        ((TextBox)((Record)tbl_orgaoemisso_maintModel.getChild("tbl_orgaoemissor")).getChild("Sigla")).addValidationListener(new tbl_orgaoemissorSiglaTextBoxHandler());
        tbl_orgaoemisso_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_orgaoemisso_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_orgaoemisso_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_orgaoemisso_maintParent == null) {
            tbl_orgaoemisso_maintModel.setCookies();
            if (tbl_orgaoemisso_maintModel.redirect()) return;
        } else {
            tbl_orgaoemisso_maintModel.redirect();
        }
    }
//End Processing

%>
