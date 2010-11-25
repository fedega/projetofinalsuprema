<%--JSP Page Init @1-431A3094--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterFiadorServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-20D4ACE4--%>
<%@include file="ManterFiadorHandlers.jsp"%>
<%
    if (!ManterFiadorModel.isVisible()) return;
    if (ManterFiadorParent != null) {
        if (!ManterFiadorParent.getChild(ManterFiadorModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterFiadorModel);
    pageContext.setAttribute("page", ManterFiadorModel);
    ManterFiadorModel.fireOnInitializeViewEvent(new Event());
    ManterFiadorModel.fireBeforeShowEvent(new Event());
    if (!ManterFiadorModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-ACCE16AF--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Fiador</title>
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

//Date Picker Object Definitions @1-7FD87C0E

var tbl_fiador_DatePicker_Data_Nasc = new Object(); 
tbl_fiador_DatePicker_Data_Nasc.format           = "dd/mm/yyyy";
tbl_fiador_DatePicker_Data_Nasc.style            = "Styles/Padrao/Style.css";
tbl_fiador_DatePicker_Data_Nasc.relativePathPart = "";
tbl_fiador_DatePicker_Data_Nasc.themeVersion = "3.0";

//End Date Picker Object Definitions

//tbl_fiadorButton_Delete_OnClick @5-BBCCD239
function tbl_fiadorButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_fiadorButton_Delete_OnClick

//bind_events @1-CB739709
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_fiadorButton_Delete", "click", tbl_fiadorButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_fiador'>
<form id="tbl_fiador" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Fiador </strong></td> 
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
            <td class="th"><label for="tbl_fiadorCod_Orgao">Orgao</label></td> 
            <td><input id="tbl_fiadorCod_Orgao" maxlength="10" size="10" value="<ccs:control name='Cod_Orgao'/>" name="<ccs:control name='Cod_Orgao' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorCod_Estado">Estado</label></td> 
            <td><input id="tbl_fiadorCod_Estado" maxlength="10" size="10" value="<ccs:control name='Cod_Estado'/>" name="<ccs:control name='Cod_Estado' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorCod_Cidade">Cidade</label></td> 
            <td><input id="tbl_fiadorCod_Cidade" maxlength="10" size="10" value="<ccs:control name='Cod_Cidade'/>" name="<ccs:control name='Cod_Cidade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorCod_Cliente">Cliente</label></td> 
            <td><input id="tbl_fiadorCod_Cliente" maxlength="10" size="10" value="<ccs:control name='Cod_Cliente'/>" name="<ccs:control name='Cod_Cliente' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorNome">Nome</label></td> 
            <td><input id="tbl_fiadorNome" maxlength="40" size="40" value="<ccs:control name='Nome'/>" name="<ccs:control name='Nome' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorData_Nasc">Data Nascimento</label></td> 
            <td><input id="tbl_fiadorData_Nasc" maxlength="100" size="10" value="<ccs:control name='Data_Nasc'/>" name="<ccs:control name='Data_Nasc' property='name'/>">
              <ccs:datepicker name='DatePicker_Data_Nasc'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_fiadorDatePicker_Data_Nasc"><img id="tbl_fiadorDatePicker_Data_Nasc_Image" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif" border="0"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorNome_U">Nome de Usuario</label></td> 
            <td><input id="tbl_fiadorNome_U" maxlength="16" size="16" value="<ccs:control name='Nome_U'/>" name="<ccs:control name='Nome_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorSenha_U">Senha</label></td> 
            <td><input id="tbl_fiadorSenha_U" maxlength="40" size="40" value="<ccs:control name='Senha_U'/>" name="<ccs:control name='Senha_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorNacionalidaade">Nacionalidade</label></td> 
            <td><input id="tbl_fiadorNacionalidaade" maxlength="30" size="30" value="<ccs:control name='Nacionalidaade'/>" name="<ccs:control name='Nacionalidaade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorEndereco">Endereco</label></td> 
            <td><input id="tbl_fiadorEndereco" maxlength="200" size="50" value="<ccs:control name='Endereco'/>" name="<ccs:control name='Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorTel_Fixo">Telefone Fixo</label></td> 
            <td><input id="tbl_fiadorTel_Fixo" maxlength="10" size="10" value="<ccs:control name='Tel_Fixo'/>" name="<ccs:control name='Tel_Fixo' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorTel_Cel">Telefone Celular</label></td> 
            <td><input id="tbl_fiadorTel_Cel" maxlength="10" size="10" value="<ccs:control name='Tel_Cel'/>" name="<ccs:control name='Tel_Cel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorTel_Comercial">Telefone Comercial</label></td> 
            <td><input id="tbl_fiadorTel_Comercial" maxlength="10" size="10" value="<ccs:control name='Tel_Comercial'/>" name="<ccs:control name='Tel_Comercial' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_fiadorButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_fiadorButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_fiadorButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-0B488B34--%>
<%ManterFiadorModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-E43E75CA--%>
<%ManterFiadorModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

