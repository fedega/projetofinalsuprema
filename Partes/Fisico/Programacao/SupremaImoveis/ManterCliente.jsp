<%--JSP Page Init @1-41DEBAFC--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterClienteServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-375C7E0A--%>
<%@include file="ManterClienteHandlers.jsp"%>
<%
    if (!ManterClienteModel.isVisible()) return;
    if (ManterClienteParent != null) {
        if (!ManterClienteParent.getChild(ManterClienteModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterClienteModel);
    pageContext.setAttribute("page", ManterClienteModel);
    ManterClienteModel.fireOnInitializeViewEvent(new Event());
    ManterClienteModel.fireBeforeShowEvent(new Event());
    if (!ManterClienteModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-D7F42F53--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Cliente</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-78CCF231
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" src="ClientI18N.jsp?file=DatePicker.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Date Picker Object Definitions @1-BE72D663

var tbl_cliente_DatePicker_Data_Nasc = new Object(); 
tbl_cliente_DatePicker_Data_Nasc.format           = "dd/mm/yyyy";
tbl_cliente_DatePicker_Data_Nasc.style            = "Styles/Padrao/Style.css";
tbl_cliente_DatePicker_Data_Nasc.relativePathPart = "";
tbl_cliente_DatePicker_Data_Nasc.themeVersion = "3.0";

//End Date Picker Object Definitions

//tbl_clienteButton_Delete_OnClick @5-8B78AD52
function tbl_clienteButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_clienteButton_Delete_OnClick

//bind_events @1-CAF60F6E
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_clienteButton_Delete", "click", tbl_clienteButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_cliente'>
<form id="tbl_cliente" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Cliente </strong></td> 
            <td class="HeaderRight"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td>
          </tr>
        </table>
 
        <table class="Record" cellspacing="0" cellpadding="0">
          <ccs:error_block>
          <tr class="Error">
            <td colspan="2"><ccs:error_text/></td>
          </tr>
          </ccs:error_block>
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteNome">Nome</label></td> 
            <td><input id="tbl_clienteNome" maxlength="40" size="40" value="<ccs:control name='Nome'/>" name="<ccs:control name='Nome' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteData_Nasc">Data de&nbsp;Nascimento</label></td> 
            <td><input id="tbl_clienteData_Nasc" maxlength="100" size="10" value="<ccs:control name='Data_Nasc'/>" name="<ccs:control name='Data_Nasc' property='name'/>">
              <ccs:datepicker name='DatePicker_Data_Nasc'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_clienteDatePicker_Data_Nasc"><img id="tbl_clienteDatePicker_Data_Nasc_Image" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif" border="0"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteNome_U">Nome de Usuario</label></td> 
            <td><input id="tbl_clienteNome_U" maxlength="16" size="16" value="<ccs:control name='Nome_U'/>" name="<ccs:control name='Nome_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSenha_U">Senha</label></td> 
            <td><input id="tbl_clienteSenha_U" maxlength="40" size="40" value="<ccs:control name='Senha_U'/>" name="<ccs:control name='Senha_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteNacionalidade">Nacionalidade</label></td> 
            <td><input id="tbl_clienteNacionalidade" maxlength="30" size="30" value="<ccs:control name='Nacionalidade'/>" name="<ccs:control name='Nacionalidade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteEndereco">Endereço</label></td> 
            <td><input id="tbl_clienteEndereco" maxlength="200" size="50" value="<ccs:control name='Endereco'/>" name="<ccs:control name='Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTel_Fixo">Telefone Fixo</label></td> 
            <td><input id="tbl_clienteTel_Fixo" maxlength="10" size="10" value="<ccs:control name='Tel_Fixo'/>" name="<ccs:control name='Tel_Fixo' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTel_Cel">Telefone Celuar</label></td> 
            <td><input id="tbl_clienteTel_Cel" maxlength="10" size="10" value="<ccs:control name='Tel_Cel'/>" name="<ccs:control name='Tel_Cel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTel_Comercial">Telefone Comercial</label></td> 
            <td><input id="tbl_clienteTel_Comercial" maxlength="10" size="10" value="<ccs:control name='Tel_Comercial'/>" name="<ccs:control name='Tel_Comercial' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteCod_Estado">Estado</label></td> 
            <td><input id="tbl_clienteCod_Estado" maxlength="10" size="10" value="<ccs:control name='Cod_Estado'/>" name="<ccs:control name='Cod_Estado' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteCod_Cidade">Cidade</label></td> 
            <td><input id="tbl_clienteCod_Cidade" maxlength="10" size="10" value="<ccs:control name='Cod_Cidade'/>" name="<ccs:control name='Cod_Cidade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteCod_Funcionario">Funcionario</label></td> 
            <td><input id="tbl_clienteCod_Funcionario" maxlength="10" size="10" value="<ccs:control name='Cod_Funcionario'/>" name="<ccs:control name='Cod_Funcionario' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteOrgao_Emissor">Orgao Emissor</label></td> 
            <td><input id="tbl_clienteOrgao_Emissor" maxlength="10" size="10" value="<ccs:control name='Orgao_Emissor'/>" name="<ccs:control name='Orgao_Emissor' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTipo_Cliente">Tipo Cliente</label></td> 
            <td><input id="tbl_clienteTipo_Cliente" maxlength="10" size="10" value="<ccs:control name='Tipo_Cliente'/>" name="<ccs:control name='Tipo_Cliente' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_clienteButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_clienteButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_clienteButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
<jsp:include page="/Footer.jsp" flush="true"/> 
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-A547CDDE--%>
<%ManterClienteModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-4A313320--%>
<%ManterClienteModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

