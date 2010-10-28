<%--== Handlers ==--%> <%--tbl_fiador_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-E580A91B
    public class tbl_fiador_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_fiador Record Handler Head @2-13EE565F
    public class tbl_fiador_mainttbl_fiadorRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_fiador Record Handler Head

//tbl_fiador afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_fiador afterInitialize Method Head

//tbl_fiador afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_fiador afterInitialize Method Tail

//tbl_fiador OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_fiador OnSetDataSource Method Head

//tbl_fiador OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_fiador OnSetDataSource Method Tail

//tbl_fiador BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_fiador BeforeShow Method Head

//tbl_fiador BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeShow Method Tail

//tbl_fiador OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_fiador OnValidate Method Head

//tbl_fiador OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_fiador OnValidate Method Tail

//tbl_fiador BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_fiador BeforeSelect Method Head

//tbl_fiador BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeSelect Method Tail

//tbl_fiador BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_fiador BeforeBuildSelect Method Head

//tbl_fiador BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeBuildSelect Method Tail

//tbl_fiador BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_fiador BeforeExecuteSelect Method Head

//tbl_fiador BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeExecuteSelect Method Tail

//tbl_fiador AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_fiador AfterExecuteSelect Method Head

//tbl_fiador AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_fiador AfterExecuteSelect Method Tail

//tbl_fiador BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_fiador BeforeInsert Method Head

//tbl_fiador BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeInsert Method Tail

//tbl_fiador BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_fiador BeforeBuildInsert Method Head

//tbl_fiador BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeBuildInsert Method Tail

//tbl_fiador BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_fiador BeforeExecuteInsert Method Head

//tbl_fiador BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeExecuteInsert Method Tail

//tbl_fiador AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_fiador AfterExecuteInsert Method Head

//tbl_fiador AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_fiador AfterExecuteInsert Method Tail

//tbl_fiador AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_fiador AfterInsert Method Head

//tbl_fiador AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_fiador AfterInsert Method Tail

//tbl_fiador BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_fiador BeforeUpdate Method Head

//tbl_fiador BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeUpdate Method Tail

//tbl_fiador BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_fiador BeforeBuildUpdate Method Head

//tbl_fiador BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeBuildUpdate Method Tail

//tbl_fiador BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_fiador BeforeExecuteUpdate Method Head

//tbl_fiador BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeExecuteUpdate Method Tail

//tbl_fiador AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_fiador AfterExecuteUpdate Method Head

//tbl_fiador AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_fiador AfterExecuteUpdate Method Tail

//tbl_fiador AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_fiador AfterUpdate Method Head

//tbl_fiador AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_fiador AfterUpdate Method Tail

//tbl_fiador BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_fiador BeforeDelete Method Head

//tbl_fiador BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeDelete Method Tail

//tbl_fiador BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_fiador BeforeBuildDelete Method Head

//tbl_fiador BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeBuildDelete Method Tail

//tbl_fiador BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_fiador BeforeExecuteDelete Method Head

//tbl_fiador BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_fiador BeforeExecuteDelete Method Tail

//tbl_fiador AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_fiador AfterExecuteDelete Method Head

//tbl_fiador AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_fiador AfterExecuteDelete Method Tail

//tbl_fiador AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_fiador AfterDelete Method Head

//tbl_fiador AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_fiador AfterDelete Method Tail

//tbl_fiador Record Handler Tail @2-FCB6E20C
    }
//End tbl_fiador Record Handler Tail

//Nome TextBox Handler Head @11-8EC31C7E
    public class tbl_fiadorNomeTextBoxHandler implements ValidationListener {
//End Nome TextBox Handler Head

//Nome BeforeShow Method Head @11-46046458
        public void beforeShow(Event e) {
//End Nome BeforeShow Method Head

//Nome BeforeShow Method Tail @11-FCB6E20C
        }
//End Nome BeforeShow Method Tail

//Nome OnValidate Method Head @11-5F430F8E
        public void onValidate(Event e) {
//End Nome OnValidate Method Head

//Nome Required Validation @11-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nome Required Validation

//Nome OnValidate Method Tail @11-FCB6E20C
        }
//End Nome OnValidate Method Tail

//Nome TextBox Handler Tail @11-FCB6E20C
    }
//End Nome TextBox Handler Tail

//Data_Nasc TextBox Handler Head @12-0C5DC8AD
    public class tbl_fiadorData_NascTextBoxHandler implements ValidationListener {
//End Data_Nasc TextBox Handler Head

//Data_Nasc BeforeShow Method Head @12-46046458
        public void beforeShow(Event e) {
//End Data_Nasc BeforeShow Method Head

//Data_Nasc BeforeShow Method Tail @12-FCB6E20C
        }
//End Data_Nasc BeforeShow Method Tail

//Data_Nasc OnValidate Method Head @12-5F430F8E
        public void onValidate(Event e) {
//End Data_Nasc OnValidate Method Head

//Data_Nasc Required Validation @12-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Data_Nasc Required Validation

//Data_Nasc OnValidate Method Tail @12-FCB6E20C
        }
//End Data_Nasc OnValidate Method Tail

//Data_Nasc TextBox Handler Tail @12-FCB6E20C
    }
//End Data_Nasc TextBox Handler Tail

//Nome_U TextBox Handler Head @14-1433D77A
    public class tbl_fiadorNome_UTextBoxHandler implements ValidationListener {
//End Nome_U TextBox Handler Head

//Nome_U BeforeShow Method Head @14-46046458
        public void beforeShow(Event e) {
//End Nome_U BeforeShow Method Head

//Nome_U BeforeShow Method Tail @14-FCB6E20C
        }
//End Nome_U BeforeShow Method Tail

//Nome_U OnValidate Method Head @14-5F430F8E
        public void onValidate(Event e) {
//End Nome_U OnValidate Method Head

//Nome_U Required Validation @14-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nome_U Required Validation

//Nome_U OnValidate Method Tail @14-FCB6E20C
        }
//End Nome_U OnValidate Method Tail

//Nome_U TextBox Handler Tail @14-FCB6E20C
    }
//End Nome_U TextBox Handler Tail

//Senha_U TextBox Handler Head @15-FBBAD989
    public class tbl_fiadorSenha_UTextBoxHandler implements ValidationListener {
//End Senha_U TextBox Handler Head

//Senha_U BeforeShow Method Head @15-46046458
        public void beforeShow(Event e) {
//End Senha_U BeforeShow Method Head

//Senha_U BeforeShow Method Tail @15-FCB6E20C
        }
//End Senha_U BeforeShow Method Tail

//Senha_U OnValidate Method Head @15-5F430F8E
        public void onValidate(Event e) {
//End Senha_U OnValidate Method Head

//Senha_U Required Validation @15-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Senha_U Required Validation

//Senha_U OnValidate Method Tail @15-FCB6E20C
        }
//End Senha_U OnValidate Method Tail

//Senha_U TextBox Handler Tail @15-FCB6E20C
    }
//End Senha_U TextBox Handler Tail

//Nacionalidaade TextBox Handler Head @16-E26FE72E
    public class tbl_fiadorNacionalidaadeTextBoxHandler implements ValidationListener {
//End Nacionalidaade TextBox Handler Head

//Nacionalidaade BeforeShow Method Head @16-46046458
        public void beforeShow(Event e) {
//End Nacionalidaade BeforeShow Method Head

//Nacionalidaade BeforeShow Method Tail @16-FCB6E20C
        }
//End Nacionalidaade BeforeShow Method Tail

//Nacionalidaade OnValidate Method Head @16-5F430F8E
        public void onValidate(Event e) {
//End Nacionalidaade OnValidate Method Head

//Nacionalidaade Required Validation @16-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nacionalidaade Required Validation

//Nacionalidaade OnValidate Method Tail @16-FCB6E20C
        }
//End Nacionalidaade OnValidate Method Tail

//Nacionalidaade TextBox Handler Tail @16-FCB6E20C
    }
//End Nacionalidaade TextBox Handler Tail

//Endereco TextBox Handler Head @17-9555A339
    public class tbl_fiadorEnderecoTextBoxHandler implements ValidationListener {
//End Endereco TextBox Handler Head

//Endereco BeforeShow Method Head @17-46046458
        public void beforeShow(Event e) {
//End Endereco BeforeShow Method Head

//Endereco BeforeShow Method Tail @17-FCB6E20C
        }
//End Endereco BeforeShow Method Tail

//Endereco OnValidate Method Head @17-5F430F8E
        public void onValidate(Event e) {
//End Endereco OnValidate Method Head

//Endereco Required Validation @17-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Endereco Required Validation

//Endereco OnValidate Method Tail @17-FCB6E20C
        }
//End Endereco OnValidate Method Tail

//Endereco TextBox Handler Tail @17-FCB6E20C
    }
//End Endereco TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-D73728AC
    Page tbl_fiador_maintModel = (Page)request.getAttribute("tbl_fiador_maint_page");
    Page tbl_fiador_maintParent = (Page)request.getAttribute("tbl_fiador_maintParent");
    if (tbl_fiador_maintModel == null) {
        PageController tbl_fiador_maintCntr = new PageController(request, response, application, "/tbl_fiador_maint.xml" );
        tbl_fiador_maintModel = tbl_fiador_maintCntr.getPage();
        tbl_fiador_maintModel.setRelativePath("./");
        //if (tbl_fiador_maintParent != null) {
            //if (!tbl_fiador_maintParent.getChild(tbl_fiador_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_fiador_maintModel.getChild("tbl_fiador")).addRecordListener(new tbl_fiador_mainttbl_fiadorRecordHandler());
        ((TextBox)((Record)tbl_fiador_maintModel.getChild("tbl_fiador")).getChild("Nome")).addValidationListener(new tbl_fiadorNomeTextBoxHandler());
        ((TextBox)((Record)tbl_fiador_maintModel.getChild("tbl_fiador")).getChild("Data_Nasc")).addValidationListener(new tbl_fiadorData_NascTextBoxHandler());
        ((TextBox)((Record)tbl_fiador_maintModel.getChild("tbl_fiador")).getChild("Nome_U")).addValidationListener(new tbl_fiadorNome_UTextBoxHandler());
        ((TextBox)((Record)tbl_fiador_maintModel.getChild("tbl_fiador")).getChild("Senha_U")).addValidationListener(new tbl_fiadorSenha_UTextBoxHandler());
        ((TextBox)((Record)tbl_fiador_maintModel.getChild("tbl_fiador")).getChild("Nacionalidaade")).addValidationListener(new tbl_fiadorNacionalidaadeTextBoxHandler());
        ((TextBox)((Record)tbl_fiador_maintModel.getChild("tbl_fiador")).getChild("Endereco")).addValidationListener(new tbl_fiadorEnderecoTextBoxHandler());
        tbl_fiador_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_fiador_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_fiador_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_fiador_maintParent == null) {
            tbl_fiador_maintModel.setCookies();
            if (tbl_fiador_maintModel.redirect()) return;
        } else {
            tbl_fiador_maintModel.redirect();
        }
    }
//End Processing

%>
