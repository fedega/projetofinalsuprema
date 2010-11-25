<%--JSP Page Init @1-CE10F74C--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterVisitaServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-84647641--%>
<%@include file="ManterVisitaHandlers.jsp"%>
<%
    if (!ManterVisitaModel.isVisible()) return;
    if (ManterVisitaParent != null) {
        if (!ManterVisitaParent.getChild(ManterVisitaModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterVisitaModel);
    pageContext.setAttribute("page", ManterVisitaModel);
    ManterVisitaModel.fireOnInitializeViewEvent(new Event());
    ManterVisitaModel.fireBeforeShowEvent(new Event());
    if (!ManterVisitaModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-95183C1A--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Atendar Visita</title>
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

//Date Picker Object Definitions @1-AE21A20C

var tbl_visita_DatePicker_Data = new Object(); 
tbl_visita_DatePicker_Data.format           = "ShortDate";
tbl_visita_DatePicker_Data.style            = "Styles/Padrao/Style.css";
tbl_visita_DatePicker_Data.relativePathPart = "";
tbl_visita_DatePicker_Data.themeVersion = "3.0";

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
<form id="tbl_visita" method="post" name="<ccs:form_name/>" action="<ccs:form_action/>">
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
        <table class="Header" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
            <td class="th"><strong>Adicionar/Editar Visita </strong></td> 
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
            <td class="th"><label for="tbl_visitaCod_Funcionario">Cliente</label></td> 
            <td><input id="tbl_visitaCliente" value="<ccs:control name='Cliente'/>" maxlength="10" size="10" name="<ccs:control name='Cliente' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th">Contato</td> 
            <td><input id="tbl_visitaContato" value="<ccs:control name='Contato'/>" maxlength="10" size="10" name="<ccs:control name='Contato' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaData">Data</label></td> 
            <td><input id="tbl_visitaData" value="<ccs:control name='Data'/>" maxlength="100" size="10" name="<ccs:control name='Data' property='name'/>">
              <ccs:datepicker name='DatePicker_Data'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_visitaDatePicker_Data"><img id="tbl_visitaDatePicker_Data_Image" border="0" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaHora">Hora</label></td> 
            <td><input id="tbl_visitaHora" value="<ccs:control name='Hora'/>" maxlength="100" size="10" name="<ccs:control name='Hora' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaCod_Imovel">Imovel</label></td> 
            <td><input id="tbl_visitaCod_Imovel" value="<ccs:control name='Cod_Imovel'/>" maxlength="10" size="10" name="<ccs:control name='Cod_Imovel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaCod_Funcionario">Funcionario</label></td> 
            <td><input id="tbl_visitaCod_Funcionario" value="<ccs:control name='Cod_Funcionario'/>" maxlength="10" size="10" name="<ccs:control name='Cod_Funcionario' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input id="tbl_visitaButton_Insert" class="Button" value="Adicionar" alt="Add" type="submit" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input id="tbl_visitaButton_Update" class="Button" value="Atualizar" alt="Atualizar" type="submit" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input id="tbl_visitaButton_Delete" class="Button" value="Remover" alt="Delete" type="submit" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-16E587AE--%>
<%ManterVisitaModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-F9937950--%>
<%ManterVisitaModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

