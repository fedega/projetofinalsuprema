<%--== Handlers ==--%> <%--ManterTipoClausula Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-5A31AF60
    public class ManterTipoClausulaServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_tipo_causula Record Handler Head @2-933F0571
    public class ManterTipoClausulatbl_tipo_causulaRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_tipo_causula Record Handler Head

//tbl_tipo_causula afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_tipo_causula afterInitialize Method Head

//tbl_tipo_causula afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula afterInitialize Method Tail

//tbl_tipo_causula OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_tipo_causula OnSetDataSource Method Head

//tbl_tipo_causula OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula OnSetDataSource Method Tail

//tbl_tipo_causula BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_tipo_causula BeforeShow Method Head

//tbl_tipo_causula BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeShow Method Tail

//tbl_tipo_causula OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_tipo_causula OnValidate Method Head

//tbl_tipo_causula OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula OnValidate Method Tail

//tbl_tipo_causula BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_tipo_causula BeforeSelect Method Head

//tbl_tipo_causula BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeSelect Method Tail

//tbl_tipo_causula BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_tipo_causula BeforeBuildSelect Method Head

//tbl_tipo_causula BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeBuildSelect Method Tail

//tbl_tipo_causula BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_causula BeforeExecuteSelect Method Head

//tbl_tipo_causula BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeExecuteSelect Method Tail

//tbl_tipo_causula AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_causula AfterExecuteSelect Method Head

//tbl_tipo_causula AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula AfterExecuteSelect Method Tail

//tbl_tipo_causula BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_tipo_causula BeforeInsert Method Head

//tbl_tipo_causula BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeInsert Method Tail

//tbl_tipo_causula BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_tipo_causula BeforeBuildInsert Method Head

//tbl_tipo_causula BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeBuildInsert Method Tail

//tbl_tipo_causula BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_causula BeforeExecuteInsert Method Head

//tbl_tipo_causula BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeExecuteInsert Method Tail

//tbl_tipo_causula AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_causula AfterExecuteInsert Method Head

//tbl_tipo_causula AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula AfterExecuteInsert Method Tail

//tbl_tipo_causula AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_tipo_causula AfterInsert Method Head

//tbl_tipo_causula AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula AfterInsert Method Tail

//tbl_tipo_causula BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_tipo_causula BeforeUpdate Method Head

//tbl_tipo_causula BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeUpdate Method Tail

//tbl_tipo_causula BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_tipo_causula BeforeBuildUpdate Method Head

//tbl_tipo_causula BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeBuildUpdate Method Tail

//tbl_tipo_causula BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_causula BeforeExecuteUpdate Method Head

//tbl_tipo_causula BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeExecuteUpdate Method Tail

//tbl_tipo_causula AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_causula AfterExecuteUpdate Method Head

//tbl_tipo_causula AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula AfterExecuteUpdate Method Tail

//tbl_tipo_causula AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_tipo_causula AfterUpdate Method Head

//tbl_tipo_causula AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula AfterUpdate Method Tail

//tbl_tipo_causula BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_tipo_causula BeforeDelete Method Head

//tbl_tipo_causula BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeDelete Method Tail

//tbl_tipo_causula BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_tipo_causula BeforeBuildDelete Method Head

//tbl_tipo_causula BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeBuildDelete Method Tail

//tbl_tipo_causula BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_causula BeforeExecuteDelete Method Head

//tbl_tipo_causula BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula BeforeExecuteDelete Method Tail

//tbl_tipo_causula AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_causula AfterExecuteDelete Method Head

//tbl_tipo_causula AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula AfterExecuteDelete Method Tail

//tbl_tipo_causula AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_tipo_causula AfterDelete Method Head

//tbl_tipo_causula AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_causula AfterDelete Method Tail

//tbl_tipo_causula Record Handler Tail @2-FCB6E20C
    }
//End tbl_tipo_causula Record Handler Tail

//Tipo TextBox Handler Head @7-3DBDE352
    public class tbl_tipo_causulaTipoTextBoxHandler implements ValidationListener {
//End Tipo TextBox Handler Head

//Tipo BeforeShow Method Head @7-46046458
        public void beforeShow(Event e) {
//End Tipo BeforeShow Method Head

//Tipo BeforeShow Method Tail @7-FCB6E20C
        }
//End Tipo BeforeShow Method Tail

//Tipo OnValidate Method Head @7-5F430F8E
        public void onValidate(Event e) {
//End Tipo OnValidate Method Head

//Tipo Required Validation @7-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Tipo Required Validation

//Tipo OnValidate Method Tail @7-FCB6E20C
        }
//End Tipo OnValidate Method Tail

//Tipo TextBox Handler Tail @7-FCB6E20C
    }
//End Tipo TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-55788B1D
    Page ManterTipoClausulaModel = (Page)request.getAttribute("ManterTipoClausula_page");
    Page ManterTipoClausulaParent = (Page)request.getAttribute("ManterTipoClausulaParent");
    if (ManterTipoClausulaModel == null) {
        PageController ManterTipoClausulaCntr = new PageController(request, response, application, "/ManterTipoClausula.xml" );
        ManterTipoClausulaModel = ManterTipoClausulaCntr.getPage();
        ManterTipoClausulaModel.setRelativePath("./");
        //if (ManterTipoClausulaParent != null) {
            //if (!ManterTipoClausulaParent.getChild(ManterTipoClausulaModel.getName()).isVisible()) return;
        //}
        ((Record)ManterTipoClausulaModel.getChild("tbl_tipo_causula")).addRecordListener(new ManterTipoClausulatbl_tipo_causulaRecordHandler());
        ((TextBox)((Record)ManterTipoClausulaModel.getChild("tbl_tipo_causula")).getChild("Tipo")).addValidationListener(new tbl_tipo_causulaTipoTextBoxHandler());
        ManterTipoClausulaCntr.process();
%>
        <% request.setAttribute("HeaderParent", ManterTipoClausulaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ManterTipoClausulaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ManterTipoClausulaParent == null) {
            ManterTipoClausulaModel.setCookies();
            if (ManterTipoClausulaModel.redirect()) return;
        } else {
            ManterTipoClausulaModel.redirect();
        }
    }
//End Processing

%>
