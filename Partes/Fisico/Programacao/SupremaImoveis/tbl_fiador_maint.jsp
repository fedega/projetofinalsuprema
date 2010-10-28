<%--JSP Page Init @1-A856190F--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_fiador_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-629AAFB6--%>
<%@include file="tbl_fiador_maintHandlers.jsp"%>
<%
    if (!tbl_fiador_maintModel.isVisible()) return;
    if (tbl_fiador_maintParent != null) {
        if (!tbl_fiador_maintParent.getChild(tbl_fiador_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_fiador_maintModel);
    pageContext.setAttribute("page", tbl_fiador_maintModel);
    tbl_fiador_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_fiador_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_fiador_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-DE461BA6--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Fiador</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-78CCF231
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" src="ClientI18N.jsp?file=DatePicker.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Date Picker Object Definitions @1-15DB8D37

var tbl_fiador_DatePicker_Data_Nasc = new Object(); 
tbl_fiador_DatePicker_Data_Nasc.format           = "ShortDate";
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
<form id="tbl_fiador" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Fiador </strong></td> 
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
            <td class="th"><label for="tbl_fiadorCod_Orgao">Cod Orgao</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Orgao' property='name'/>" value="<ccs:control name='Cod_Orgao'/>" maxlength="10" size="10" id="tbl_fiadorCod_Orgao"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorCod_Estado">Cod Estado</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Estado' property='name'/>" value="<ccs:control name='Cod_Estado'/>" maxlength="10" size="10" id="tbl_fiadorCod_Estado"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorCod_Cidade">Cod Cidade</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cidade' property='name'/>" value="<ccs:control name='Cod_Cidade'/>" maxlength="10" size="10" id="tbl_fiadorCod_Cidade"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorCod_Cliente">Cod Cliente</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cliente' property='name'/>" value="<ccs:control name='Cod_Cliente'/>" maxlength="10" size="10" id="tbl_fiadorCod_Cliente"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorNome">Nome</label></td> 
            <td><input type="text" name="<ccs:control name='Nome' property='name'/>" value="<ccs:control name='Nome'/>" maxlength="40" size="40" id="tbl_fiadorNome"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorData_Nasc">Data Nasc</label></td> 
            <td><input type="text" name="<ccs:control name='Data_Nasc' property='name'/>" value="<ccs:control name='Data_Nasc'/>" maxlength="100" size="10" id="tbl_fiadorData_Nasc">
              <ccs:datepicker name='DatePicker_Data_Nasc'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_fiadorDatePicker_Data_Nasc"><img src="Styles/Padrao/Images/DatePicker.gif" border="0" alt="Show Date Picker" id="tbl_fiadorDatePicker_Data_Nasc_Image"></a></ccs:datepicker></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorNome_U">Nome U</label></td> 
            <td><input type="text" name="<ccs:control name='Nome_U' property='name'/>" value="<ccs:control name='Nome_U'/>" maxlength="16" size="16" id="tbl_fiadorNome_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorSenha_U">Senha U</label></td> 
            <td><input type="text" name="<ccs:control name='Senha_U' property='name'/>" value="<ccs:control name='Senha_U'/>" maxlength="40" size="40" id="tbl_fiadorSenha_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorNacionalidaade">Nacionalidaade</label></td> 
            <td><input type="text" name="<ccs:control name='Nacionalidaade' property='name'/>" value="<ccs:control name='Nacionalidaade'/>" maxlength="30" size="30" id="tbl_fiadorNacionalidaade"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorEndereco">Endereco</label></td> 
            <td><input type="text" name="<ccs:control name='Endereco' property='name'/>" value="<ccs:control name='Endereco'/>" maxlength="200" size="50" id="tbl_fiadorEndereco"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorTel_Fixo">Tel Fixo</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Fixo' property='name'/>" value="<ccs:control name='Tel_Fixo'/>" maxlength="10" size="10" id="tbl_fiadorTel_Fixo"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorTel_Cel">Tel Cel</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Cel' property='name'/>" value="<ccs:control name='Tel_Cel'/>" maxlength="10" size="10" id="tbl_fiadorTel_Cel"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorTel_Comercial">Tel Comercial</label></td> 
            <td><input type="text" name="<ccs:control name='Tel_Comercial' property='name'/>" value="<ccs:control name='Tel_Comercial'/>" maxlength="10" size="10" id="tbl_fiadorTel_Comercial"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_fiadorButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_fiadorButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_fiadorButton_Delete" class="Button"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-1CCD89D9--%>
<%tbl_fiador_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-F3BB7727--%>
<%tbl_fiador_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

