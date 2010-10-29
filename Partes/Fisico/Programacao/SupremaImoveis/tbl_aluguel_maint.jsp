<%--JSP Page Init @1-ED6F0B1A--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_aluguel_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-B9AABD16--%>
<%@include file="tbl_aluguel_maintHandlers.jsp"%>
<%
    if (!tbl_aluguel_maintModel.isVisible()) return;
    if (tbl_aluguel_maintParent != null) {
        if (!tbl_aluguel_maintParent.getChild(tbl_aluguel_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_aluguel_maintModel);
    pageContext.setAttribute("page", tbl_aluguel_maintModel);
    tbl_aluguel_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_aluguel_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_aluguel_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-6AF02F07--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Aluguel</title>
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

//Date Picker Object Definitions @1-0B568B7E

var tbl_aluguel_DatePicker_Data = new Object(); 
tbl_aluguel_DatePicker_Data.format           = "dd/mm/yyyy";
tbl_aluguel_DatePicker_Data.style            = "Styles/Padrao/Style.css";
tbl_aluguel_DatePicker_Data.relativePathPart = "";
tbl_aluguel_DatePicker_Data.themeVersion = "3.0";

//End Date Picker Object Definitions

//tbl_aluguelButton_Delete_OnClick @5-0FBB1EC0
function tbl_aluguelButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_aluguelButton_Delete_OnClick

//bind_events @1-7C428A73
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_aluguelButton_Delete", "click", tbl_aluguelButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_aluguel'>
<form id="tbl_aluguel" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Aluguel </strong></td> 
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
            <td class="th"><label for="tbl_aluguelData">Data</label></td> 
            <td><input id="tbl_aluguelData" maxlength="100" size="10" value="<ccs:control name='Data'/>" name="<ccs:control name='Data' property='name'/>">
              <ccs:datepicker name='DatePicker_Data'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_aluguelDatePicker_Data"><img id="tbl_aluguelDatePicker_Data_Image" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif" border="0"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Imovel">Imovel</label></td> 
            <td><input id="tbl_aluguelCod_Imovel" maxlength="10" size="10" value="<ccs:control name='Cod_Imovel'/>" name="<ccs:control name='Cod_Imovel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Cliente">Cliente</label></td> 
            <td><input id="tbl_aluguelCod_Cliente" maxlength="10" size="10" value="<ccs:control name='Cod_Cliente'/>" name="<ccs:control name='Cod_Cliente' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Fiador">Fiador</label></td> 
            <td><input id="tbl_aluguelCod_Fiador" maxlength="10" size="10" value="<ccs:control name='Cod_Fiador'/>" name="<ccs:control name='Cod_Fiador' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Funcionario">Funcionario</label></td> 
            <td><input id="tbl_aluguelCod_Funcionario" maxlength="10" size="10" value="<ccs:control name='Cod_Funcionario'/>" name="<ccs:control name='Cod_Funcionario' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_aluguelButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_aluguelButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_aluguelButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-D9A1AD28--%>
<%tbl_aluguel_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-36D753D6--%>
<%tbl_aluguel_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

