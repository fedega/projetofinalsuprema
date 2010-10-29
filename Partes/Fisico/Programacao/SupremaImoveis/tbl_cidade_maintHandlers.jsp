<%--== Handlers ==--%> <%--tbl_cidade_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-917E21D4
    public class tbl_cidade_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_cidade Record Handler Head @2-0498A084
    public class tbl_cidade_mainttbl_cidadeRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_cidade Record Handler Head

//tbl_cidade afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_cidade afterInitialize Method Head

//tbl_cidade afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_cidade afterInitialize Method Tail

//tbl_cidade OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_cidade OnSetDataSource Method Head

//tbl_cidade OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_cidade OnSetDataSource Method Tail

//tbl_cidade BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_cidade BeforeShow Method Head

//tbl_cidade BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeShow Method Tail

//tbl_cidade OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_cidade OnValidate Method Head

//tbl_cidade OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_cidade OnValidate Method Tail

//tbl_cidade BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_cidade BeforeSelect Method Head

//tbl_cidade BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeSelect Method Tail

//tbl_cidade BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_cidade BeforeBuildSelect Method Head

//tbl_cidade BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeBuildSelect Method Tail

//tbl_cidade BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_cidade BeforeExecuteSelect Method Head

//tbl_cidade BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeExecuteSelect Method Tail

//tbl_cidade AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_cidade AfterExecuteSelect Method Head

//tbl_cidade AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_cidade AfterExecuteSelect Method Tail

//tbl_cidade BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_cidade BeforeInsert Method Head

//tbl_cidade BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeInsert Method Tail

//tbl_cidade BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_cidade BeforeBuildInsert Method Head

//tbl_cidade BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeBuildInsert Method Tail

//tbl_cidade BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_cidade BeforeExecuteInsert Method Head

//tbl_cidade BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeExecuteInsert Method Tail

//tbl_cidade AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_cidade AfterExecuteInsert Method Head

//tbl_cidade AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_cidade AfterExecuteInsert Method Tail

//tbl_cidade AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_cidade AfterInsert Method Head

//tbl_cidade AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_cidade AfterInsert Method Tail

//tbl_cidade BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_cidade BeforeUpdate Method Head

//tbl_cidade BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeUpdate Method Tail

//tbl_cidade BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_cidade BeforeBuildUpdate Method Head

//tbl_cidade BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeBuildUpdate Method Tail

//tbl_cidade BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_cidade BeforeExecuteUpdate Method Head

//tbl_cidade BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeExecuteUpdate Method Tail

//tbl_cidade AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_cidade AfterExecuteUpdate Method Head

//tbl_cidade AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cidade AfterExecuteUpdate Method Tail

//tbl_cidade AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_cidade AfterUpdate Method Head

//tbl_cidade AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cidade AfterUpdate Method Tail

//tbl_cidade BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_cidade BeforeDelete Method Head

//tbl_cidade BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeDelete Method Tail

//tbl_cidade BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_cidade BeforeBuildDelete Method Head

//tbl_cidade BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeBuildDelete Method Tail

//tbl_cidade BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_cidade BeforeExecuteDelete Method Head

//tbl_cidade BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_cidade BeforeExecuteDelete Method Tail

//tbl_cidade AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_cidade AfterExecuteDelete Method Head

//tbl_cidade AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_cidade AfterExecuteDelete Method Tail

//tbl_cidade AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_cidade AfterDelete Method Head

//tbl_cidade AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_cidade AfterDelete Method Tail

//tbl_cidade Record Handler Tail @2-FCB6E20C
    }
//End tbl_cidade Record Handler Tail

//Nome TextBox Handler Head @7-4BDE73ED
    public class tbl_cidadeNomeTextBoxHandler implements ValidationListener {
//End Nome TextBox Handler Head

//Nome BeforeShow Method Head @7-46046458
        public void beforeShow(Event e) {
//End Nome BeforeShow Method Head

//Nome BeforeShow Method Tail @7-FCB6E20C
        }
//End Nome BeforeShow Method Tail

//Nome OnValidate Method Head @7-5F430F8E
        public void onValidate(Event e) {
//End Nome OnValidate Method Head

//Nome Required Validation @7-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nome Required Validation

//Nome OnValidate Method Tail @7-FCB6E20C
        }
//End Nome OnValidate Method Tail

//Nome TextBox Handler Tail @7-FCB6E20C
    }
//End Nome TextBox Handler Tail

//Cod_Estado ListBox Handler Head @8-2034AB19
    public class tbl_cidadeCod_EstadoListBoxHandler implements ValidationListener, ListDataObjectListener {
//End Cod_Estado ListBox Handler Head

//Cod_Estado BeforeShow Method Head @8-46046458
        public void beforeShow(Event e) {
//End Cod_Estado BeforeShow Method Head

//Cod_Estado BeforeShow Method Tail @8-FCB6E20C
        }
//End Cod_Estado BeforeShow Method Tail

//Cod_Estado OnValidate Method Head @8-5F430F8E
        public void onValidate(Event e) {
//End Cod_Estado OnValidate Method Head

//Cod_Estado Required Validation @8-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Cod_Estado Required Validation

//Cod_Estado OnValidate Method Tail @8-FCB6E20C
        }
//End Cod_Estado OnValidate Method Tail

//Cod_Estado BeforeBuildSelect Method Head @8-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End Cod_Estado BeforeBuildSelect Method Head

//Cod_Estado BeforeBuildSelect Method Tail @8-FCB6E20C
        }
//End Cod_Estado BeforeBuildSelect Method Tail

//Cod_Estado BeforeExecuteSelect Method Head @8-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End Cod_Estado BeforeExecuteSelect Method Head

//Cod_Estado BeforeExecuteSelect Method Tail @8-FCB6E20C
        }
//End Cod_Estado BeforeExecuteSelect Method Tail

//Cod_Estado AfterExecuteSelect Method Head @8-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End Cod_Estado AfterExecuteSelect Method Head

//Cod_Estado AfterExecuteSelect Method Tail @8-FCB6E20C
        }
//End Cod_Estado AfterExecuteSelect Method Tail

//Cod_Estado ListBox Handler Tail @8-FCB6E20C
    }
//End Cod_Estado ListBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-5915254C
    Page tbl_cidade_maintModel = (Page)request.getAttribute("tbl_cidade_maint_page");
    Page tbl_cidade_maintParent = (Page)request.getAttribute("tbl_cidade_maintParent");
    if (tbl_cidade_maintModel == null) {
        PageController tbl_cidade_maintCntr = new PageController(request, response, application, "/tbl_cidade_maint.xml" );
        tbl_cidade_maintModel = tbl_cidade_maintCntr.getPage();
        tbl_cidade_maintModel.setRelativePath("./");
        //if (tbl_cidade_maintParent != null) {
            //if (!tbl_cidade_maintParent.getChild(tbl_cidade_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_cidade_maintModel.getChild("tbl_cidade")).addRecordListener(new tbl_cidade_mainttbl_cidadeRecordHandler());
        ((TextBox)((Record)tbl_cidade_maintModel.getChild("tbl_cidade")).getChild("Nome")).addValidationListener(new tbl_cidadeNomeTextBoxHandler());
        ((ListBox)((Record)tbl_cidade_maintModel.getChild("tbl_cidade")).getChild("Cod_Estado")).addValidationListener(new tbl_cidadeCod_EstadoListBoxHandler());
        tbl_cidade_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_cidade_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_cidade_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_cidade_maintParent == null) {
            tbl_cidade_maintModel.setCookies();
            if (tbl_cidade_maintModel.redirect()) return;
        } else {
            tbl_cidade_maintModel.redirect();
        }
    }
//End Processing

%>
