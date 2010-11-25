<%--JSP Page Init @1-9D6072EB--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ListaVisitaServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-A44E7C90--%>
<%@include file="ListaVisitaHandlers.jsp"%>
<%
    if (!ListaVisitaModel.isVisible()) return;
    if (ListaVisitaParent != null) {
        if (!ListaVisitaParent.getChild(ListaVisitaModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ListaVisitaModel);
    pageContext.setAttribute("page", ListaVisitaModel);
    ListaVisitaModel.fireOnInitializeViewEvent(new Event());
    ListaVisitaModel.fireBeforeShowEvent(new Event());
    if (!ListaVisitaModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-6979CC95--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Visita</title>
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

//Date Picker Object Definitions @1-1A8CD52B

var tbl_visitaSearch_DatePicker_s_Data = new Object(); 
tbl_visitaSearch_DatePicker_s_Data.format           = "dd/mm/yyyy";
tbl_visitaSearch_DatePicker_s_Data.style            = "Styles/Padrao/Style.css";
tbl_visitaSearch_DatePicker_s_Data.relativePathPart = "";
tbl_visitaSearch_DatePicker_s_Data.themeVersion = "3.0";

//End Date Picker Object Definitions

//bind_events @1-99F07CBB
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_visitaSearch'>
<form id="tbl_visitaSearch" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Buscar Visita </strong></td> 
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
            <td class="th"><label for="tbl_visitaSearchs_Cod_Imovel">Imovel</label></td> 
            <td><input id="tbl_visitaSearchs_Cod_Imovel" maxlength="10" size="10" value="<ccs:control name='s_Cod_Imovel'/>" name="<ccs:control name='s_Cod_Imovel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaSearchs_Data">Data</label></td> 
            <td><input id="tbl_visitaSearchs_Data" maxlength="100" size="10" value="<ccs:control name='s_Data'/>" name="<ccs:control name='s_Data' property='name'/>">
              <ccs:datepicker name='DatePicker_s_Data'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_visitaSearchDatePicker_s_Data"><img id="tbl_visitaSearchDatePicker_s_Data_Image" alt="Show Date Picker" src="Styles/Padrao/Images/DatePicker.gif" border="0"></a></ccs:datepicker></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaSearchs_Hora">Horario</label></td> 
            <td><input id="tbl_visitaSearchs_Hora" maxlength="100" size="10" value="<ccs:control name='s_Hora'/>" name="<ccs:control name='s_Hora' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_DoSearch'><input class="Button" id="tbl_visitaSearchButton_DoSearch" type="submit" alt="Buscar" value="Buscar" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_visita'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table class="Header" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
          <td class="th"><strong>Lista de&nbsp;Visitas</strong></td> 
          <td class="HeaderRight"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td>
        </tr>
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Visita' column='Cod_Visita'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Cod_Visita">Numero da Visita</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data' column='Data'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Data">Data</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Hora' column='Hora'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Hora">Hora</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Imovel' column='Cod_Imovel'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Cod_Imovel">Imovel</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Cod_Funcionario">Funcionario</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Visita' property='href'/>" id="tbl_visitaCod_Visita_<ccs:attribute owner = 'tbl_visita' name = 'rowNumber' />"><ccs:control name='Cod_Visita'/></a>&nbsp;</td> 
          <td><ccs:control name='Data'/>&nbsp;</td> 
          <td><ccs:control name='Hora'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Imovel'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Funcionario'/>&nbsp;</td>
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="5">Sem registros</td>
        </tr>
        </ccs:norecords>
        <tr class="Footer">
          <td colspan="5"><a href="<ccs:control name='tbl_visita_Insert' property='href'/>" id="tbl_visitatbl_visita_Insert">Marcar Visita </a>&nbsp; 
            <ccs:navigator name='Navigator' type='Simple' size='10'>
            <ccs:first_on><a href="<ccs:page_href/>">|&lt;</a> </ccs:first_on>
            <ccs:prev_on><a href="<ccs:page_href/>">&lt;&lt;</a> </ccs:prev_on>&nbsp;<ccs:page_number/> de&nbsp;<ccs:total_pages/>&nbsp; 
            <ccs:next_on><a href="<ccs:page_href/>">&gt;&gt;</a> </ccs:next_on>
            <ccs:last_on><a href="<ccs:page_href/>">&gt;|</a> </ccs:last_on></ccs:navigator>&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</ccs:grid><br>
<jsp:include page="/Footer.jsp" flush="true"/> 
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-D15F540E--%>
<%ListaVisitaModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-3E29AAF0--%>
<%ListaVisitaModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

