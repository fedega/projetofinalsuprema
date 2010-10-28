<%--JSP Page Init @1-6AE0A617--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_funcionario_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-8B99F357--%>
<%@include file="tbl_funcionario_maintHandlers.jsp"%>
<%
    if (!tbl_funcionario_maintModel.isVisible()) return;
    if (tbl_funcionario_maintParent != null) {
        if (!tbl_funcionario_maintParent.getChild(tbl_funcionario_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_funcionario_maintModel);
    pageContext.setAttribute("page", tbl_funcionario_maintModel);
    tbl_funcionario_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_funcionario_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_funcionario_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-7679C3F8--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Funcionario</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-78CCF231
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" src="ClientI18N.jsp?file=DatePicker.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Date Picker Object Definitions @1-04D1B96D

var tbl_funcionario_DatePicker_Data_Nasc = new Object(); 
tbl_funcionario_DatePicker_Data_Nasc.format           = "ShortDate";
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
<form id="tbl_funcionario" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Funcionario </strong></td> 
            <td class="HeaderRight"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
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
            <td><input type="text" name="<ccs:control name='Nome' property='name'/>" value="<ccs:control name='Nome'/>" maxlength="40" size="40" id="tbl_funcionarioNome"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCod_Cidade">Cod Cidade</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cidade' property='name'/>" value="<ccs:control name='Cod_Cidade'/>" maxlength="10" size="10" id="tbl_funcionarioCod_Cidade"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCod_Estado">Cod Estado</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Estado' property='name'/>" value="<ccs:control name='Cod_Estado'/>" maxlength="10" size="10" id="tbl_funcionarioCod_Estado"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCod_Orgao">Cod Orgao</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Orgao' property='name'/>" value="<ccs:control name='Cod_Orgao'/>" maxlength="10" size="10" id="tbl_funcionarioCod_Orgao"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioNome_U">Nome U</label></td> 
            <td><input type="text" name="<ccs:control name='Nome_U' property='name'/>" value="<ccs:control name='Nome_U'/>" maxlength="20" size="20" id="tbl_funcionarioNome_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioSenha_U">Senha U</label></td> 
            <td><input type="password" name="<ccs:control name='Senha_U' property='name'/>" value="<ccs:control name='Senha_U'/>" maxlength="20" size="20" id="tbl_funcionarioSenha_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioEndereco">Endereco</label></td> 
            <td><input type="text" name="<ccs:control name='Endereco' property='name'/>" value="<ccs:control name='Endereco'/>" maxlength="40" size="40" id="tbl_funcionarioEndereco"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioTel_Fixo">Tel Fixo</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Fixo' property='name'/>" value="<ccs:control name='Tel_Fixo'/>" maxlength="10" size="10" id="tbl_funcionarioTel_Fixo"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioTel_Cel">Tel Cel</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Cel' property='name'/>" value="<ccs:control name='Tel_Cel'/>" maxlength="10" size="10" id="tbl_funcionarioTel_Cel"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCPF">CPF</label></td> 
            <td><input type="text" name="<ccs:control name='CPF' property='name'/>" value="<ccs:control name='CPF'/>" maxlength="10" size="10" id="tbl_funcionarioCPF"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioData_Nasc">Data Nasc</label></td> 
            <td><input type="text" name="<ccs:control name='Data_Nasc' property='name'/>" value="<ccs:control name='Data_Nasc'/>" maxlength="100" size="10" id="tbl_funcionarioData_Nasc">
              <ccs:datepicker name='DatePicker_Data_Nasc'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_funcionarioDatePicker_Data_Nasc"><img src="Styles/Padrao/Images/DatePicker.gif" border="0" alt="Show Date Picker" id="tbl_funcionarioDatePicker_Data_Nasc_Image"></a></ccs:datepicker></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioCRECI">CRECI</label></td> 
            <td><input type="text" name="<ccs:control name='CRECI' property='name'/>" value="<ccs:control name='CRECI'/>" maxlength="10" size="10" id="tbl_funcionarioCRECI"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioNivel_Controle">Nivel Controle</label></td> 
            <td><input type="text" name="<ccs:control name='Nivel_Controle' property='name'/>" value="<ccs:control name='Nivel_Controle'/>" maxlength="10" size="10" id="tbl_funcionarioNivel_Controle"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_funcionarioButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_funcionarioButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_funcionarioButton_Delete" class="Button"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-200E3543--%>
<%tbl_funcionario_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-CF78CBBD--%>
<%tbl_funcionario_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

