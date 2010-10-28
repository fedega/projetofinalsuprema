<%--== Handlers ==--%> <%--tbl_despesas_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-CAA57B74
    public class tbl_despesas_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_despesas Record Handler Head @2-C7606191
    public class tbl_despesas_mainttbl_despesasRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_despesas Record Handler Head

//tbl_despesas afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_despesas afterInitialize Method Head

//tbl_despesas afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_despesas afterInitialize Method Tail

//tbl_despesas OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_despesas OnSetDataSource Method Head

//tbl_despesas OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_despesas OnSetDataSource Method Tail

//tbl_despesas BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_despesas BeforeShow Method Head

//tbl_despesas BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeShow Method Tail

//tbl_despesas OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_despesas OnValidate Method Head

//tbl_despesas OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_despesas OnValidate Method Tail

//tbl_despesas BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_despesas BeforeSelect Method Head

//tbl_despesas BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeSelect Method Tail

//tbl_despesas BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_despesas BeforeBuildSelect Method Head

//tbl_despesas BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeBuildSelect Method Tail

//tbl_despesas BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_despesas BeforeExecuteSelect Method Head

//tbl_despesas BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeExecuteSelect Method Tail

//tbl_despesas AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_despesas AfterExecuteSelect Method Head

//tbl_despesas AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_despesas AfterExecuteSelect Method Tail

//tbl_despesas BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_despesas BeforeInsert Method Head

//tbl_despesas BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeInsert Method Tail

//tbl_despesas BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_despesas BeforeBuildInsert Method Head

//tbl_despesas BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeBuildInsert Method Tail

//tbl_despesas BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_despesas BeforeExecuteInsert Method Head

//tbl_despesas BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeExecuteInsert Method Tail

//tbl_despesas AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_despesas AfterExecuteInsert Method Head

//tbl_despesas AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_despesas AfterExecuteInsert Method Tail

//tbl_despesas AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_despesas AfterInsert Method Head

//tbl_despesas AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_despesas AfterInsert Method Tail

//tbl_despesas BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_despesas BeforeUpdate Method Head

//tbl_despesas BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeUpdate Method Tail

//tbl_despesas BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_despesas BeforeBuildUpdate Method Head

//tbl_despesas BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeBuildUpdate Method Tail

//tbl_despesas BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_despesas BeforeExecuteUpdate Method Head

//tbl_despesas BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeExecuteUpdate Method Tail

//tbl_despesas AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_despesas AfterExecuteUpdate Method Head

//tbl_despesas AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_despesas AfterExecuteUpdate Method Tail

//tbl_despesas AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_despesas AfterUpdate Method Head

//tbl_despesas AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_despesas AfterUpdate Method Tail

//tbl_despesas BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_despesas BeforeDelete Method Head

//tbl_despesas BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeDelete Method Tail

//tbl_despesas BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_despesas BeforeBuildDelete Method Head

//tbl_despesas BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeBuildDelete Method Tail

//tbl_despesas BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_despesas BeforeExecuteDelete Method Head

//tbl_despesas BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_despesas BeforeExecuteDelete Method Tail

//tbl_despesas AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_despesas AfterExecuteDelete Method Head

//tbl_despesas AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_despesas AfterExecuteDelete Method Tail

//tbl_despesas AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_despesas AfterDelete Method Head

//tbl_despesas AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_despesas AfterDelete Method Tail

//tbl_despesas Record Handler Tail @2-FCB6E20C
    }
//End tbl_despesas Record Handler Tail

//Valor TextBox Handler Head @8-A933871E
    public class tbl_despesasValorTextBoxHandler implements ValidationListener {
//End Valor TextBox Handler Head

//Valor BeforeShow Method Head @8-46046458
        public void beforeShow(Event e) {
//End Valor BeforeShow Method Head

//Valor BeforeShow Method Tail @8-FCB6E20C
        }
//End Valor BeforeShow Method Tail

//Valor OnValidate Method Head @8-5F430F8E
        public void onValidate(Event e) {
//End Valor OnValidate Method Head

//Valor Required Validation @8-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Valor Required Validation

//Valor OnValidate Method Tail @8-FCB6E20C
        }
//End Valor OnValidate Method Tail

//Valor TextBox Handler Tail @8-FCB6E20C
    }
//End Valor TextBox Handler Tail

//Cod_Aluguel TextBox Handler Head @10-789AE15E
    public class tbl_despesasCod_AluguelTextBoxHandler implements ValidationListener {
//End Cod_Aluguel TextBox Handler Head

//Cod_Aluguel BeforeShow Method Head @10-46046458
        public void beforeShow(Event e) {
//End Cod_Aluguel BeforeShow Method Head

//Cod_Aluguel BeforeShow Method Tail @10-FCB6E20C
        }
//End Cod_Aluguel BeforeShow Method Tail

//Cod_Aluguel OnValidate Method Head @10-5F430F8E
        public void onValidate(Event e) {
//End Cod_Aluguel OnValidate Method Head

//Cod_Aluguel Required Validation @10-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Cod_Aluguel Required Validation

//Cod_Aluguel OnValidate Method Tail @10-FCB6E20C
        }
//End Cod_Aluguel OnValidate Method Tail

//Cod_Aluguel TextBox Handler Tail @10-FCB6E20C
    }
//End Cod_Aluguel TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-3F8146DC
    Page tbl_despesas_maintModel = (Page)request.getAttribute("tbl_despesas_maint_page");
    Page tbl_despesas_maintParent = (Page)request.getAttribute("tbl_despesas_maintParent");
    if (tbl_despesas_maintModel == null) {
        PageController tbl_despesas_maintCntr = new PageController(request, response, application, "/tbl_despesas_maint.xml" );
        tbl_despesas_maintModel = tbl_despesas_maintCntr.getPage();
        tbl_despesas_maintModel.setRelativePath("./");
        //if (tbl_despesas_maintParent != null) {
            //if (!tbl_despesas_maintParent.getChild(tbl_despesas_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_despesas_maintModel.getChild("tbl_despesas")).addRecordListener(new tbl_despesas_mainttbl_despesasRecordHandler());
        ((TextBox)((Record)tbl_despesas_maintModel.getChild("tbl_despesas")).getChild("Valor")).addValidationListener(new tbl_despesasValorTextBoxHandler());
        ((TextBox)((Record)tbl_despesas_maintModel.getChild("tbl_despesas")).getChild("Cod_Aluguel")).addValidationListener(new tbl_despesasCod_AluguelTextBoxHandler());
        tbl_despesas_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_despesas_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_despesas_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_despesas_maintParent == null) {
            tbl_despesas_maintModel.setCookies();
            if (tbl_despesas_maintModel.redirect()) return;
        } else {
            tbl_despesas_maintModel.redirect();
        }
    }
//End Processing

%>
