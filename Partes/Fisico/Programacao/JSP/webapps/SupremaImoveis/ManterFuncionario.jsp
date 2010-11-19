<%--JSP Page Init @1-912A64BC--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterFuncionarioServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-156A5393--%>
<%@include file="ManterFuncionarioHandlers.jsp"%>
<%
    if (!ManterFuncionarioModel.isVisible()) return;
    if (ManterFuncionarioParent != null) {
        if (!ManterFuncionarioParent.getChild(ManterFuncionarioModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterFuncionarioModel);
    pageContext.setAttribute("page", ManterFuncionarioModel);
    ManterFuncionarioModel.fireOnInitializeViewEvent(new Event());
    ManterFuncionarioModel.fireBeforeShowEvent(new Event());
    if (!ManterFuncionarioModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-947CAD91--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Funcionario</title>
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

//Date Picker Object Definitions @1-ADC53557

var tbl_funcionario_DatePicker_Data_Nasc = new Object(); 
tbl_funcionario_DatePicker_Data_Nasc.format           = "dd/mm/yyyy";
tbl_funcionario_DatePicker_Data_Nasc.style            = "Styles/Padrao/Style.css";
tbl_funcionario_DatePicker_Data_Nasc.relativePathPart = "";
tbl_funcionario_DatePicker_Data_Nasc.themeVersion = "3.0";

//End Date Picker Object Definitions

//tbl_funcionarioButton_Delete_OnClick @5-AE880C0C
function tbl_funcionarioButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_funcionarioButton_Delete_OnClick

//bind_events @1-B23DF7E9
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_funcionarioButton_Delete", "click", tbl_funcionarioButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_funcionario'>
<form id="tbl_funcionario" method="post" name="<ccs:form_name/>" action="<ccs:form_action/>">
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
        <table class="Header" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
            <td class="th"><strong>Adicionar/Editar Funcionario </strong></td> 
            <td class="HeaderRight"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td>
          </tr>
        </table>
 
        <table class="Record" cellspacing="0" cellpadding="0">
          <ccs:error_block>
          <tr class="Error">
            <td colspan="2"><ccs:error_text/></td>
          </tr>
          </ccs:error_block>
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioNome">Nome</label></td> 
            <td><input id="tbl_funcionarioNome" value="<ccs:control name='Nome'/>" maxlength="40" size="40" name="<ccs:control name='Nome' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCod_Cidade">Cidade</label></td> 
            <td>
              <select id="tbl_funcionarioCod_Cidade" name="<ccs:control name='Cod_Cidade' property='name'/>">
                <option selected value="">Selecionar valor</option>
                <ccs:control name='Cod_Cidade' property='options'/>
              </select>
 </td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCod_Estado">Estado</label></td> 
            <td>
              <select id="tbl_funcionarioCod_Estado" name="<ccs:control name='Cod_Estado' property='name'/>">
                <option selected value="">Selecionar valor</option>
                <ccs:control name='Cod_Estado' property='options'/>
              </select>
 </td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCod_Orgao">Orgao Emissor</label></td> 
            <td>
              <select id="tbl_funcionarioCod_Orgao" name="<ccs:control name='Cod_Orgao' property='name'/>">
                <option selected value="">Selecionar valor</option>
                <ccs:control name='Cod_Orgao' property='options'/>
              </select>
 </td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioNome_U">Nome Usuario</label></td> 
            <td><input id="tbl_funcionarioNome_U" value="<ccs:control name='Nome_U'/>" maxlength="20" name="<ccs:control name='Nome_U' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioSenha_U">Senha</label></td> 
            <td><input id="tbl_funcionarioSenha_U" value="<ccs:control name='Senha_U'/>" maxlength="20" type="password" name="<ccs:control name='Senha_U' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioEndereco">Endereco</label></td> 
            <td><input id="tbl_funcionarioEndereco" value="<ccs:control name='Endereco'/>" maxlength="40" size="40" name="<ccs:control name='Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioTel_Fixo">Telefone Fixo</label></td> 
            <td><input id="tbl_funcionarioTel_Fixo" value="<ccs:control name='Tel_Fixo'/>" maxlength="10" size="10" name="<ccs:control name='Tel_Fixo' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioTel_Cel">Telefone Celular</label></td> 
            <td><input id="tbl_funcionarioTel_Cel" value="<ccs:control name='Tel_Cel'/>" maxlength="10" size="10" name="<ccs:control name='Tel_Cel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCPF">CPF</label></td> 
            <td><input id="tbl_funcionarioCPF" value="<ccs:control name='CPF'/>" maxlength="11" size="11" name="<ccs:control name='CPF' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioData_Nasc">Data Nascimento</label></td> 
            <td><input id="tbl_funcionarioData_Nasc" value="<ccs:control name='Data_Nasc'/>" maxlength="100" size="10" name="<ccs:control name='Data_Nasc' property='name'/>">
              <ccs:datepicker name='DatePicker_Data_Nasc'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_funcionarioDatePicker_Data_Nasc"><img id="tbl_funcionarioDatePicker_Data_Nasc_Image" border="0" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCRECI">CRECI</label></td> 
            <td><input id="tbl_funcionarioCRECI" value="<ccs:control name='CRECI'/>" maxlength="10" size="10" name="<ccs:control name='CRECI' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioNivel_Controle">Nivel Controle</label></td> 
            <td><input id="tbl_funcionarioNivel_Controle" value="<ccs:control name='Nivel_Controle'/>" maxlength="10" size="10" name="<ccs:control name='Nivel_Controle' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input id="tbl_funcionarioButton_Insert" class="Button" value="Add" alt="Add" type="submit" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input id="tbl_funcionarioButton_Update" class="Button" value="Atualizar" alt="Atualizar" type="submit" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input id="tbl_funcionarioButton_Delete" class="Button" value="Delete" alt="Delete" type="submit" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-328830F4--%>
<%ManterFuncionarioModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-DDFECE0A--%>
<%ManterFuncionarioModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

