<%--JSP Page Init @1-58983982--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_cliente_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-6CEDF9EC--%>
<%@include file="tbl_cliente_maintHandlers.jsp"%>
<%
    if (!tbl_cliente_maintModel.isVisible()) return;
    if (tbl_cliente_maintParent != null) {
        if (!tbl_cliente_maintParent.getChild(tbl_cliente_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_cliente_maintModel);
    pageContext.setAttribute("page", tbl_cliente_maintModel);
    tbl_cliente_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_cliente_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_cliente_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-064638FA--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Cliente</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-78CCF231
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" src="ClientI18N.jsp?file=DatePicker.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Date Picker Object Definitions @1-FA9AE41D

var tbl_cliente_DatePicker_Data_Nasc = new Object(); 
tbl_cliente_DatePicker_Data_Nasc.format           = "ShortDate";
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
<form id="tbl_cliente" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Cliente </strong></td> 
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
            <td class="th"><label for="tbl_clienteNome">Nome</label></td> 
            <td><input type="text" name="<ccs:control name='Nome' property='name'/>" value="<ccs:control name='Nome'/>" maxlength="40" size="40" id="tbl_clienteNome"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteData_Nasc">Data Nasc</label></td> 
            <td><input type="text" name="<ccs:control name='Data_Nasc' property='name'/>" value="<ccs:control name='Data_Nasc'/>" maxlength="100" size="10" id="tbl_clienteData_Nasc">
              <ccs:datepicker name='DatePicker_Data_Nasc'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_clienteDatePicker_Data_Nasc"><img src="Styles/Padrao/Images/DatePicker.gif" border="0" alt="Show Date Picker" id="tbl_clienteDatePicker_Data_Nasc_Image"></a></ccs:datepicker></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteNome_U">Nome U</label></td> 
            <td><input type="text" name="<ccs:control name='Nome_U' property='name'/>" value="<ccs:control name='Nome_U'/>" maxlength="16" size="16" id="tbl_clienteNome_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSenha_U">Senha U</label></td> 
            <td><input type="text" name="<ccs:control name='Senha_U' property='name'/>" value="<ccs:control name='Senha_U'/>" maxlength="40" size="40" id="tbl_clienteSenha_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteNacionalidade">Nacionalidade</label></td> 
            <td><input type="text" name="<ccs:control name='Nacionalidade' property='name'/>" value="<ccs:control name='Nacionalidade'/>" maxlength="30" size="30" id="tbl_clienteNacionalidade"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteEndereco">Endereco</label></td> 
            <td><input type="text" name="<ccs:control name='Endereco' property='name'/>" value="<ccs:control name='Endereco'/>" maxlength="200" size="50" id="tbl_clienteEndereco"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTel_Fixo">Tel Fixo</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Fixo' property='name'/>" value="<ccs:control name='Tel_Fixo'/>" maxlength="10" size="10" id="tbl_clienteTel_Fixo"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTel_Cel">Tel Cel</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Cel' property='name'/>" value="<ccs:control name='Tel_Cel'/>" maxlength="10" size="10" id="tbl_clienteTel_Cel"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTel_Comercial">Tel Comercial</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Comercial' property='name'/>" value="<ccs:control name='Tel_Comercial'/>" maxlength="10" size="10" id="tbl_clienteTel_Comercial"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteCod_Estado">Cod Estado</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Estado' property='name'/>" value="<ccs:control name='Cod_Estado'/>" maxlength="10" size="10" id="tbl_clienteCod_Estado"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteCod_Cidade">Cod Cidade</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cidade' property='name'/>" value="<ccs:control name='Cod_Cidade'/>" maxlength="10" size="10" id="tbl_clienteCod_Cidade"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteCod_Funcionario">Cod Funcionario</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Funcionario' property='name'/>" value="<ccs:control name='Cod_Funcionario'/>" maxlength="10" size="10" id="tbl_clienteCod_Funcionario"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteOrgao_Emissor">Orgao Emissor</label></td> 
            <td><input type="text" name="<ccs:control name='Orgao_Emissor' property='name'/>" value="<ccs:control name='Orgao_Emissor'/>" maxlength="10" size="10" id="tbl_clienteOrgao_Emissor"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteTipo_Cliente">Tipo Cliente</label></td> 
            <td><input type="text" name="<ccs:control name='Tipo_Cliente' property='name'/>" value="<ccs:control name='Tipo_Cliente'/>" maxlength="10" size="10" id="tbl_clienteTipo_Cliente"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_clienteButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_clienteButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_clienteButton_Delete" class="Button"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-7CE430C1--%>
<%tbl_cliente_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-9392CE3F--%>
<%tbl_cliente_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

