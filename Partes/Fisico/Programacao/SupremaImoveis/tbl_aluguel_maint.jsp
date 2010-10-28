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

<%--JSP Page Content @1-C896E32C--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Aluguel</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-78CCF231
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" src="ClientI18N.jsp?file=DatePicker.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Date Picker Object Definitions @1-43ADB28C

var tbl_aluguel_DatePicker_Data = new Object(); 
tbl_aluguel_DatePicker_Data.format           = "ShortDate";
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
<form id="tbl_aluguel" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Aluguel </strong></td> 
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
            <td class="th"><label for="tbl_aluguelData">Data</label></td> 
            <td><input type="text" name="<ccs:control name='Data' property='name'/>" value="<ccs:control name='Data'/>" maxlength="100" size="10" id="tbl_aluguelData">
              <ccs:datepicker name='DatePicker_Data'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_aluguelDatePicker_Data"><img src="Styles/Padrao/Images/DatePicker.gif" border="0" alt="Show Date Picker" id="tbl_aluguelDatePicker_Data_Image"></a></ccs:datepicker></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Imovel">Cod Imovel</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Imovel' property='name'/>" value="<ccs:control name='Cod_Imovel'/>" maxlength="10" size="10" id="tbl_aluguelCod_Imovel"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Cliente">Cod Cliente</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cliente' property='name'/>" value="<ccs:control name='Cod_Cliente'/>" maxlength="10" size="10" id="tbl_aluguelCod_Cliente"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Fiador">Cod Fiador</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Fiador' property='name'/>" value="<ccs:control name='Cod_Fiador'/>" maxlength="10" size="10" id="tbl_aluguelCod_Fiador"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelCod_Funcionario">Cod Funcionario</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Funcionario' property='name'/>" value="<ccs:control name='Cod_Funcionario'/>" maxlength="10" size="10" id="tbl_aluguelCod_Funcionario"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_aluguelButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_aluguelButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_aluguelButton_Delete" class="Button"></ccs:button></td> 
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

