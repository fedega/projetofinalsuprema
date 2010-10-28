<%--== Handlers ==--%> <%--tbl_cliente_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-25C36B2A
    public class tbl_cliente_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_cliente Record Handler Head @2-15FB2623
    public class tbl_cliente_mainttbl_clienteRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_cliente Record Handler Head

//tbl_cliente afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_cliente afterInitialize Method Head

//tbl_cliente afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_cliente afterInitialize Method Tail

//tbl_cliente OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_cliente OnSetDataSource Method Head

//tbl_cliente OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_cliente OnSetDataSource Method Tail

//tbl_cliente BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_cliente BeforeShow Method Head

//tbl_cliente BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeShow Method Tail

//tbl_cliente OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_cliente OnValidate Method Head

//tbl_cliente OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_cliente OnValidate Method Tail

//tbl_cliente BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_cliente BeforeSelect Method Head

//tbl_cliente BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeSelect Method Tail

//tbl_cliente BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_cliente BeforeBuildSelect Method Head

//tbl_cliente BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeBuildSelect Method Tail

//tbl_cliente BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_cliente BeforeExecuteSelect Method Head

//tbl_cliente BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeExecuteSelect Method Tail

//tbl_cliente AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_cliente AfterExecuteSelect Method Head

//tbl_cliente AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_cliente AfterExecuteSelect Method Tail

//tbl_cliente BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_cliente BeforeInsert Method Head

//tbl_cliente BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeInsert Method Tail

//tbl_cliente BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_cliente BeforeBuildInsert Method Head

//tbl_cliente BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeBuildInsert Method Tail

//tbl_cliente BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_cliente BeforeExecuteInsert Method Head

//tbl_cliente BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeExecuteInsert Method Tail

//tbl_cliente AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_cliente AfterExecuteInsert Method Head

//tbl_cliente AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_cliente AfterExecuteInsert Method Tail

//tbl_cliente AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_cliente AfterInsert Method Head

//tbl_cliente AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_cliente AfterInsert Method Tail

//tbl_cliente BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_cliente BeforeUpdate Method Head

//tbl_cliente BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeUpdate Method Tail

//tbl_cliente BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_cliente BeforeBuildUpdate Method Head

//tbl_cliente BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeBuildUpdate Method Tail

//tbl_cliente BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_cliente BeforeExecuteUpdate Method Head

//tbl_cliente BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeExecuteUpdate Method Tail

//tbl_cliente AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_cliente AfterExecuteUpdate Method Head

//tbl_cliente AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cliente AfterExecuteUpdate Method Tail

//tbl_cliente AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_cliente AfterUpdate Method Head

//tbl_cliente AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_cliente AfterUpdate Method Tail

//tbl_cliente BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_cliente BeforeDelete Method Head

//tbl_cliente BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeDelete Method Tail

//tbl_cliente BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_cliente BeforeBuildDelete Method Head

//tbl_cliente BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeBuildDelete Method Tail

//tbl_cliente BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_cliente BeforeExecuteDelete Method Head

//tbl_cliente BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_cliente BeforeExecuteDelete Method Tail

//tbl_cliente AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_cliente AfterExecuteDelete Method Head

//tbl_cliente AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_cliente AfterExecuteDelete Method Tail

//tbl_cliente AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_cliente AfterDelete Method Head

//tbl_cliente AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_cliente AfterDelete Method Tail

//tbl_cliente Record Handler Tail @2-FCB6E20C
    }
//End tbl_cliente Record Handler Tail

//Nome TextBox Handler Head @7-F14F034A
    public class tbl_clienteNomeTextBoxHandler implements ValidationListener {
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

//Data_Nasc TextBox Handler Head @8-100E16FF
    public class tbl_clienteData_NascTextBoxHandler implements ValidationListener {
//End Data_Nasc TextBox Handler Head

//Data_Nasc BeforeShow Method Head @8-46046458
        public void beforeShow(Event e) {
//End Data_Nasc BeforeShow Method Head

//Data_Nasc BeforeShow Method Tail @8-FCB6E20C
        }
//End Data_Nasc BeforeShow Method Tail

//Data_Nasc OnValidate Method Head @8-5F430F8E
        public void onValidate(Event e) {
//End Data_Nasc OnValidate Method Head

//Data_Nasc Required Validation @8-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Data_Nasc Required Validation

//Data_Nasc OnValidate Method Tail @8-FCB6E20C
        }
//End Data_Nasc OnValidate Method Tail

//Data_Nasc TextBox Handler Tail @8-FCB6E20C
    }
//End Data_Nasc TextBox Handler Tail

//Nome_U TextBox Handler Head @10-221156F4
    public class tbl_clienteNome_UTextBoxHandler implements ValidationListener {
//End Nome_U TextBox Handler Head

//Nome_U BeforeShow Method Head @10-46046458
        public void beforeShow(Event e) {
//End Nome_U BeforeShow Method Head

//Nome_U BeforeShow Method Tail @10-FCB6E20C
        }
//End Nome_U BeforeShow Method Tail

//Nome_U OnValidate Method Head @10-5F430F8E
        public void onValidate(Event e) {
//End Nome_U OnValidate Method Head

//Nome_U Required Validation @10-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nome_U Required Validation

//Nome_U OnValidate Method Tail @10-FCB6E20C
        }
//End Nome_U OnValidate Method Tail

//Nome_U TextBox Handler Tail @10-FCB6E20C
    }
//End Nome_U TextBox Handler Tail

//Senha_U TextBox Handler Head @11-F18C552F
    public class tbl_clienteSenha_UTextBoxHandler implements ValidationListener {
//End Senha_U TextBox Handler Head

//Senha_U BeforeShow Method Head @11-46046458
        public void beforeShow(Event e) {
//End Senha_U BeforeShow Method Head

//Senha_U BeforeShow Method Tail @11-FCB6E20C
        }
//End Senha_U BeforeShow Method Tail

//Senha_U OnValidate Method Head @11-5F430F8E
        public void onValidate(Event e) {
//End Senha_U OnValidate Method Head

//Senha_U Required Validation @11-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Senha_U Required Validation

//Senha_U OnValidate Method Tail @11-FCB6E20C
        }
//End Senha_U OnValidate Method Tail

//Senha_U TextBox Handler Tail @11-FCB6E20C
    }
//End Senha_U TextBox Handler Tail

//Nacionalidade TextBox Handler Head @12-7500ECE6
    public class tbl_clienteNacionalidadeTextBoxHandler implements ValidationListener {
//End Nacionalidade TextBox Handler Head

//Nacionalidade BeforeShow Method Head @12-46046458
        public void beforeShow(Event e) {
//End Nacionalidade BeforeShow Method Head

//Nacionalidade BeforeShow Method Tail @12-FCB6E20C
        }
//End Nacionalidade BeforeShow Method Tail

//Nacionalidade OnValidate Method Head @12-5F430F8E
        public void onValidate(Event e) {
//End Nacionalidade OnValidate Method Head

//Nacionalidade Required Validation @12-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Nacionalidade Required Validation

//Nacionalidade OnValidate Method Tail @12-FCB6E20C
        }
//End Nacionalidade OnValidate Method Tail

//Nacionalidade TextBox Handler Tail @12-FCB6E20C
    }
//End Nacionalidade TextBox Handler Tail

//Endereco TextBox Handler Head @13-AAEA9368
    public class tbl_clienteEnderecoTextBoxHandler implements ValidationListener {
//End Endereco TextBox Handler Head

//Endereco BeforeShow Method Head @13-46046458
        public void beforeShow(Event e) {
//End Endereco BeforeShow Method Head

//Endereco BeforeShow Method Tail @13-FCB6E20C
        }
//End Endereco BeforeShow Method Tail

//Endereco OnValidate Method Head @13-5F430F8E
        public void onValidate(Event e) {
//End Endereco OnValidate Method Head

//Endereco Required Validation @13-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Endereco Required Validation

//Endereco OnValidate Method Tail @13-FCB6E20C
        }
//End Endereco OnValidate Method Tail

//Endereco TextBox Handler Tail @13-FCB6E20C
    }
//End Endereco TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-EF906A70
    Page tbl_cliente_maintModel = (Page)request.getAttribute("tbl_cliente_maint_page");
    Page tbl_cliente_maintParent = (Page)request.getAttribute("tbl_cliente_maintParent");
    if (tbl_cliente_maintModel == null) {
        PageController tbl_cliente_maintCntr = new PageController(request, response, application, "/tbl_cliente_maint.xml" );
        tbl_cliente_maintModel = tbl_cliente_maintCntr.getPage();
        tbl_cliente_maintModel.setRelativePath("./");
        //if (tbl_cliente_maintParent != null) {
            //if (!tbl_cliente_maintParent.getChild(tbl_cliente_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_cliente_maintModel.getChild("tbl_cliente")).addRecordListener(new tbl_cliente_mainttbl_clienteRecordHandler());
        ((TextBox)((Record)tbl_cliente_maintModel.getChild("tbl_cliente")).getChild("Nome")).addValidationListener(new tbl_clienteNomeTextBoxHandler());
        ((TextBox)((Record)tbl_cliente_maintModel.getChild("tbl_cliente")).getChild("Data_Nasc")).addValidationListener(new tbl_clienteData_NascTextBoxHandler());
        ((TextBox)((Record)tbl_cliente_maintModel.getChild("tbl_cliente")).getChild("Nome_U")).addValidationListener(new tbl_clienteNome_UTextBoxHandler());
        ((TextBox)((Record)tbl_cliente_maintModel.getChild("tbl_cliente")).getChild("Senha_U")).addValidationListener(new tbl_clienteSenha_UTextBoxHandler());
        ((TextBox)((Record)tbl_cliente_maintModel.getChild("tbl_cliente")).getChild("Nacionalidade")).addValidationListener(new tbl_clienteNacionalidadeTextBoxHandler());
        ((TextBox)((Record)tbl_cliente_maintModel.getChild("tbl_cliente")).getChild("Endereco")).addValidationListener(new tbl_clienteEnderecoTextBoxHandler());
        tbl_cliente_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_cliente_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_cliente_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_cliente_maintParent == null) {
            tbl_cliente_maintModel.setCookies();
            if (tbl_cliente_maintModel.redirect()) return;
        } else {
            tbl_cliente_maintModel.redirect();
        }
    }
//End Processing

%>
