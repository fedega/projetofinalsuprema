<%--== Handlers ==--%> <%--ManterFuncionario Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-FB98F011
    public class ManterFuncionarioServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_funcionario Record Handler Head @2-5F002EFF
    public class ManterFuncionariotbl_funcionarioRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_funcionario Record Handler Head

//tbl_funcionario afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_funcionario afterInitialize Method Head

//tbl_funcionario afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_funcionario afterInitialize Method Tail

//tbl_funcionario OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_funcionario OnSetDataSource Method Head

//tbl_funcionario OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_funcionario OnSetDataSource Method Tail

//tbl_funcionario BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_funcionario BeforeShow Method Head

//tbl_funcionario BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeShow Method Tail

//tbl_funcionario OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_funcionario OnValidate Method Head

//tbl_funcionario OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_funcionario OnValidate Method Tail

//tbl_funcionario BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_funcionario BeforeSelect Method Head

//tbl_funcionario BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeSelect Method Tail

//tbl_funcionario BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_funcionario BeforeBuildSelect Method Head

//tbl_funcionario BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeBuildSelect Method Tail

//tbl_funcionario BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_funcionario BeforeExecuteSelect Method Head

//tbl_funcionario BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeExecuteSelect Method Tail

//tbl_funcionario AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_funcionario AfterExecuteSelect Method Head

//tbl_funcionario AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_funcionario AfterExecuteSelect Method Tail

//tbl_funcionario BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_funcionario BeforeInsert Method Head

//tbl_funcionario BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeInsert Method Tail

//tbl_funcionario BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_funcionario BeforeBuildInsert Method Head

//tbl_funcionario BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeBuildInsert Method Tail

//tbl_funcionario BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_funcionario BeforeExecuteInsert Method Head

//tbl_funcionario BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeExecuteInsert Method Tail

//tbl_funcionario AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_funcionario AfterExecuteInsert Method Head

//tbl_funcionario AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_funcionario AfterExecuteInsert Method Tail

//tbl_funcionario AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_funcionario AfterInsert Method Head

//tbl_funcionario AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_funcionario AfterInsert Method Tail

//tbl_funcionario BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_funcionario BeforeUpdate Method Head

//tbl_funcionario BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeUpdate Method Tail

//tbl_funcionario BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_funcionario BeforeBuildUpdate Method Head

//tbl_funcionario BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeBuildUpdate Method Tail

//tbl_funcionario BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_funcionario BeforeExecuteUpdate Method Head

//tbl_funcionario BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeExecuteUpdate Method Tail

//tbl_funcionario AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_funcionario AfterExecuteUpdate Method Head

//tbl_funcionario AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_funcionario AfterExecuteUpdate Method Tail

//tbl_funcionario AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_funcionario AfterUpdate Method Head

//tbl_funcionario AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_funcionario AfterUpdate Method Tail

//tbl_funcionario BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_funcionario BeforeDelete Method Head

//tbl_funcionario BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeDelete Method Tail

//tbl_funcionario BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_funcionario BeforeBuildDelete Method Head

//tbl_funcionario BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeBuildDelete Method Tail

//tbl_funcionario BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_funcionario BeforeExecuteDelete Method Head

//tbl_funcionario BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_funcionario BeforeExecuteDelete Method Tail

//tbl_funcionario AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_funcionario AfterExecuteDelete Method Head

//tbl_funcionario AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_funcionario AfterExecuteDelete Method Tail

//tbl_funcionario AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_funcionario AfterDelete Method Head

//tbl_funcionario AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_funcionario AfterDelete Method Tail

//tbl_funcionario Record Handler Tail @2-FCB6E20C
    }
//End tbl_funcionario Record Handler Tail

//Nome TextBox Handler Head @7-C02213C7
    public class tbl_funcionarioNomeTextBoxHandler implements ValidationListener {
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

//Nome_U TextBox Handler Head @11-B18B91FB
    public class tbl_funcionarioNome_UTextBoxHandler implements ValidationListener {
//End Nome_U TextBox Handler Head

//Nome_U BeforeShow Method Head @11-46046458
        public void beforeShow(Event e) {
//End Nome_U BeforeShow Method Head

//Nome_U BeforeShow Method Tail @11-FCB6E20C
        }
//End Nome_U BeforeShow Method Tail

//Nome_U OnValidate Method Head @11-5F430F8E
        public void onValidate(Event e) {
//End Nome_U OnValidate Method Head

//Nome_U Required Validation @11-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nome_U Required Validation

//Nome_U OnValidate Method Tail @11-FCB6E20C
        }
//End Nome_U OnValidate Method Tail

//Nome_U TextBox Handler Tail @11-FCB6E20C
    }
//End Nome_U TextBox Handler Tail

//Senha_U TextBox Handler Head @12-61A0D279
    public class tbl_funcionarioSenha_UTextBoxHandler implements ValidationListener {
//End Senha_U TextBox Handler Head

//Senha_U BeforeShow Method Head @12-46046458
        public void beforeShow(Event e) {
//End Senha_U BeforeShow Method Head

//Senha_U BeforeShow Method Tail @12-FCB6E20C
        }
//End Senha_U BeforeShow Method Tail

//Senha_U OnValidate Method Head @12-5F430F8E
        public void onValidate(Event e) {
//End Senha_U OnValidate Method Head

//Senha_U Required Validation @12-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Senha_U Required Validation

//Senha_U OnValidate Method Tail @12-FCB6E20C
        }
//End Senha_U OnValidate Method Tail

//Senha_U TextBox Handler Tail @12-FCB6E20C
    }
//End Senha_U TextBox Handler Tail

//Nivel_Controle TextBox Handler Head @20-D1957AB3
    public class tbl_funcionarioNivel_ControleTextBoxHandler implements ValidationListener {
//End Nivel_Controle TextBox Handler Head

//Nivel_Controle BeforeShow Method Head @20-46046458
        public void beforeShow(Event e) {
//End Nivel_Controle BeforeShow Method Head

//Nivel_Controle BeforeShow Method Tail @20-FCB6E20C
        }
//End Nivel_Controle BeforeShow Method Tail

//Nivel_Controle OnValidate Method Head @20-5F430F8E
        public void onValidate(Event e) {
//End Nivel_Controle OnValidate Method Head

//Nivel_Controle Required Validation @20-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nivel_Controle Required Validation

//Nivel_Controle OnValidate Method Tail @20-FCB6E20C
        }
//End Nivel_Controle OnValidate Method Tail

//Nivel_Controle TextBox Handler Tail @20-FCB6E20C
    }
//End Nivel_Controle TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-23F04D66
    Page ManterFuncionarioModel = (Page)request.getAttribute("ManterFuncionario_page");
    Page ManterFuncionarioParent = (Page)request.getAttribute("ManterFuncionarioParent");
    if (ManterFuncionarioModel == null) {
        PageController ManterFuncionarioCntr = new PageController(request, response, application, "/ManterFuncionario.xml" );
        ManterFuncionarioModel = ManterFuncionarioCntr.getPage();
        ManterFuncionarioModel.setRelativePath("./");
        //if (ManterFuncionarioParent != null) {
            //if (!ManterFuncionarioParent.getChild(ManterFuncionarioModel.getName()).isVisible()) return;
        //}
        ((Record)ManterFuncionarioModel.getChild("tbl_funcionario")).addRecordListener(new ManterFuncionariotbl_funcionarioRecordHandler());
        ((TextBox)((Record)ManterFuncionarioModel.getChild("tbl_funcionario")).getChild("Nome")).addValidationListener(new tbl_funcionarioNomeTextBoxHandler());
        ((TextBox)((Record)ManterFuncionarioModel.getChild("tbl_funcionario")).getChild("Nome_U")).addValidationListener(new tbl_funcionarioNome_UTextBoxHandler());
        ((TextBox)((Record)ManterFuncionarioModel.getChild("tbl_funcionario")).getChild("Senha_U")).addValidationListener(new tbl_funcionarioSenha_UTextBoxHandler());
        ((TextBox)((Record)ManterFuncionarioModel.getChild("tbl_funcionario")).getChild("Nivel_Controle")).addValidationListener(new tbl_funcionarioNivel_ControleTextBoxHandler());
        ManterFuncionarioCntr.process();
%>
        <% request.setAttribute("HeaderParent", ManterFuncionarioModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ManterFuncionarioModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ManterFuncionarioParent == null) {
            ManterFuncionarioModel.setCookies();
            if (ManterFuncionarioModel.redirect()) return;
        } else {
            ManterFuncionarioModel.redirect();
        }
    }
//End Processing

%>
