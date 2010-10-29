<%--JSP Page Init @1-8B5EDB31--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_visita_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-EFDEAFDF--%>
<%@include file="tbl_visita_maintHandlers.jsp"%>
<%
    if (!tbl_visita_maintModel.isVisible()) return;
    if (tbl_visita_maintParent != null) {
        if (!tbl_visita_maintParent.getChild(tbl_visita_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_visita_maintModel);
    pageContext.setAttribute("page", tbl_visita_maintModel);
    tbl_visita_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_visita_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_visita_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-C04E7DB6--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Visita</title>
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

//Date Picker Object Definitions @1-B29C9375

var tbl_visita_DatePicker_Data = new Object(); 
tbl_visita_DatePicker_Data.format           = "ShortDate";
tbl_visita_DatePicker_Data.style            = "Styles/Padrao/Style.css";
tbl_visita_DatePicker_Data.relativePathPart = "";
tbl_visita_DatePicker_Data.themeVersion = "3.0";

var tbl_visita_DatePicker_Hora = new Object(); 
tbl_visita_DatePicker_Hora.format           = "ShortDate";
tbl_visita_DatePicker_Hora.style            = "Styles/Padrao/Style.css";
tbl_visita_DatePicker_Hora.relativePathPart = "";
tbl_visita_DatePicker_Hora.themeVersion = "3.0";

//End Date Picker Object Definitions

//tbl_visitaButton_Delete_OnClick @5-BA96335E
function tbl_visitaButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_visitaButton_Delete_OnClick

//bind_events @1-35B380A0
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_visitaButton_Delete", "click", tbl_visitaButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_visita'>
<form id="tbl_visita" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Visita </strong></td> 
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
            <td class="th"><label for="tbl_visitaData">Data</label></td> 
            <td><input id="tbl_visitaData" maxlength="100" size="10" value="<ccs:control name='Data'/>" name="<ccs:control name='Data' property='name'/>">
              <ccs:datepicker name='DatePicker_Data'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_visitaDatePicker_Data"><img id="tbl_visitaDatePicker_Data_Image" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif" border="0"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaHora">Hora</label></td> 
            <td><input id="tbl_visitaHora" maxlength="100" size="10" value="<ccs:control name='Hora'/>" name="<ccs:control name='Hora' property='name'/>">
              <ccs:datepicker name='DatePicker_Hora'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_visitaDatePicker_Hora"><img id="tbl_visitaDatePicker_Hora_Image" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif" border="0"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaCod_Imovel">Imovel</label></td> 
            <td><input id="tbl_visitaCod_Imovel" maxlength="10" size="10" value="<ccs:control name='Cod_Imovel'/>" name="<ccs:control name='Cod_Imovel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaCod_Funcionario">Funcionario</label></td> 
            <td><input id="tbl_visitaCod_Funcionario" maxlength="10" size="10" value="<ccs:control name='Cod_Funcionario'/>" name="<ccs:control name='Cod_Funcionario' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_visitaButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_visitaButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_visitaButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-CE3FA006--%>
<%tbl_visita_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-21495EF8--%>
<%tbl_visita_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

