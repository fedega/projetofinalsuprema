<%--== Handlers ==--%> <%--ManterEstado Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-C5E9C8B6
    public class ManterEstadoServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_estado Record Handler Head @2-AAC01A4F
    public class ManterEstadotbl_estadoRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_estado Record Handler Head

//tbl_estado afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_estado afterInitialize Method Head

//tbl_estado afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_estado afterInitialize Method Tail

//tbl_estado OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_estado OnSetDataSource Method Head

//tbl_estado OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_estado OnSetDataSource Method Tail

//tbl_estado BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_estado BeforeShow Method Head

//tbl_estado BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeShow Method Tail

//tbl_estado OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_estado OnValidate Method Head

//tbl_estado OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_estado OnValidate Method Tail

//tbl_estado BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_estado BeforeSelect Method Head

//tbl_estado BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeSelect Method Tail

//tbl_estado BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_estado BeforeBuildSelect Method Head

//tbl_estado BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeBuildSelect Method Tail

//tbl_estado BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_estado BeforeExecuteSelect Method Head

//tbl_estado BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeExecuteSelect Method Tail

//tbl_estado AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_estado AfterExecuteSelect Method Head

//tbl_estado AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_estado AfterExecuteSelect Method Tail

//tbl_estado BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_estado BeforeInsert Method Head

//tbl_estado BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeInsert Method Tail

//tbl_estado BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_estado BeforeBuildInsert Method Head

//tbl_estado BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeBuildInsert Method Tail

//tbl_estado BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_estado BeforeExecuteInsert Method Head

//tbl_estado BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeExecuteInsert Method Tail

//tbl_estado AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_estado AfterExecuteInsert Method Head

//tbl_estado AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_estado AfterExecuteInsert Method Tail

//tbl_estado AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_estado AfterInsert Method Head

//tbl_estado AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_estado AfterInsert Method Tail

//tbl_estado BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_estado BeforeUpdate Method Head

//tbl_estado BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeUpdate Method Tail

//tbl_estado BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_estado BeforeBuildUpdate Method Head

//tbl_estado BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeBuildUpdate Method Tail

//tbl_estado BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_estado BeforeExecuteUpdate Method Head

//tbl_estado BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeExecuteUpdate Method Tail

//tbl_estado AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_estado AfterExecuteUpdate Method Head

//tbl_estado AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_estado AfterExecuteUpdate Method Tail

//tbl_estado AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_estado AfterUpdate Method Head

//tbl_estado AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_estado AfterUpdate Method Tail

//tbl_estado BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_estado BeforeDelete Method Head

//tbl_estado BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeDelete Method Tail

//tbl_estado BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_estado BeforeBuildDelete Method Head

//tbl_estado BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeBuildDelete Method Tail

//tbl_estado BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_estado BeforeExecuteDelete Method Head

//tbl_estado BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_estado BeforeExecuteDelete Method Tail

//tbl_estado AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_estado AfterExecuteDelete Method Head

//tbl_estado AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_estado AfterExecuteDelete Method Tail

//tbl_estado AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_estado AfterDelete Method Head

//tbl_estado AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_estado AfterDelete Method Tail

//tbl_estado Record Handler Tail @2-FCB6E20C
    }
//End tbl_estado Record Handler Tail

//UF TextBox Handler Head @7-8200E3B6
    public class tbl_estadoUFTextBoxHandler implements ValidationListener {
//End UF TextBox Handler Head

//UF BeforeShow Method Head @7-46046458
        public void beforeShow(Event e) {
//End UF BeforeShow Method Head

//UF BeforeShow Method Tail @7-FCB6E20C
        }
//End UF BeforeShow Method Tail

//UF OnValidate Method Head @7-5F430F8E
        public void onValidate(Event e) {
//End UF OnValidate Method Head

//UF Required Validation @7-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End UF Required Validation

//UF OnValidate Method Tail @7-FCB6E20C
        }
//End UF OnValidate Method Tail

//UF TextBox Handler Tail @7-FCB6E20C
    }
//End UF TextBox Handler Tail

//Nome TextBox Handler Head @8-CF73A7AD
    public class tbl_estadoNomeTextBoxHandler implements ValidationListener {
//End Nome TextBox Handler Head

//Nome BeforeShow Method Head @8-46046458
        public void beforeShow(Event e) {
//End Nome BeforeShow Method Head

//Nome BeforeShow Method Tail @8-FCB6E20C
        }
//End Nome BeforeShow Method Tail

//Nome OnValidate Method Head @8-5F430F8E
        public void onValidate(Event e) {
//End Nome OnValidate Method Head

//Nome Required Validation @8-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nome Required Validation

//Nome OnValidate Method Tail @8-FCB6E20C
        }
//End Nome OnValidate Method Tail

//Nome TextBox Handler Tail @8-FCB6E20C
    }
//End Nome TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-41F02488
    Page ManterEstadoModel = (Page)request.getAttribute("ManterEstado_page");
    Page ManterEstadoParent = (Page)request.getAttribute("ManterEstadoParent");
    if (ManterEstadoModel == null) {
        PageController ManterEstadoCntr = new PageController(request, response, application, "/ManterEstado.xml" );
        ManterEstadoModel = ManterEstadoCntr.getPage();
        ManterEstadoModel.setRelativePath("./");
        //if (ManterEstadoParent != null) {
            //if (!ManterEstadoParent.getChild(ManterEstadoModel.getName()).isVisible()) return;
        //}
        ((Record)ManterEstadoModel.getChild("tbl_estado")).addRecordListener(new ManterEstadotbl_estadoRecordHandler());
        ((TextBox)((Record)ManterEstadoModel.getChild("tbl_estado")).getChild("UF")).addValidationListener(new tbl_estadoUFTextBoxHandler());
        ((TextBox)((Record)ManterEstadoModel.getChild("tbl_estado")).getChild("Nome")).addValidationListener(new tbl_estadoNomeTextBoxHandler());
        ManterEstadoCntr.process();
%>
        <% request.setAttribute("HeaderParent", ManterEstadoModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ManterEstadoModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ManterEstadoParent == null) {
            ManterEstadoModel.setCookies();
            if (ManterEstadoModel.redirect()) return;
        } else {
            ManterEstadoModel.redirect();
        }
    }
//End Processing

%>
