<%--JSP Page Init @1-F4C748F7--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_visita_listServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-16E5C070--%>
<%@include file="tbl_visita_listHandlers.jsp"%>
<%
    if (!tbl_visita_listModel.isVisible()) return;
    if (tbl_visita_listParent != null) {
        if (!tbl_visita_listParent.getChild(tbl_visita_listModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_visita_listModel);
    pageContext.setAttribute("page", tbl_visita_listModel);
    tbl_visita_listModel.fireOnInitializeViewEvent(new Event());
    tbl_visita_listModel.fireBeforeShowEvent(new Event());
    if (!tbl_visita_listModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-249196BF--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Visita</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-78CCF231
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" src="ClientI18N.jsp?file=DatePicker.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Date Picker Object Definitions @1-E703B556

var tbl_visitaSearch_DatePicker_s_Data = new Object(); 
tbl_visitaSearch_DatePicker_s_Data.format           = "ShortDate";
tbl_visitaSearch_DatePicker_s_Data.style            = "Styles/Padrao/Style.css";
tbl_visitaSearch_DatePicker_s_Data.relativePathPart = "";
tbl_visitaSearch_DatePicker_s_Data.themeVersion = "3.0";

var tbl_visitaSearch_DatePicker_s_Hora = new Object(); 
tbl_visitaSearch_DatePicker_s_Hora.format           = "ShortDate";
tbl_visitaSearch_DatePicker_s_Hora.style            = "Styles/Padrao/Style.css";
tbl_visitaSearch_DatePicker_s_Hora.relativePathPart = "";
tbl_visitaSearch_DatePicker_s_Hora.themeVersion = "3.0";

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
<form id="tbl_visitaSearch" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Buscar Tbl Visita </strong></td> 
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
            <td class="th"><label for="tbl_visitaSearchs_Cod_Imovel">Cod Imovel</label></td> 
            <td><input type="text" name="<ccs:control name='s_Cod_Imovel' property='name'/>" value="<ccs:control name='s_Cod_Imovel'/>" maxlength="10" size="10" id="tbl_visitaSearchs_Cod_Imovel"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaSearchs_Data">Data</label></td> 
            <td><input type="text" name="<ccs:control name='s_Data' property='name'/>" value="<ccs:control name='s_Data'/>" maxlength="100" size="10" id="tbl_visitaSearchs_Data">
              <ccs:datepicker name='DatePicker_s_Data'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_visitaSearchDatePicker_s_Data"><img src="Styles/Padrao/Images/DatePicker.gif" border="0" alt="Show Date Picker" id="tbl_visitaSearchDatePicker_s_Data_Image"></a></ccs:datepicker></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_visitaSearchs_Hora">Hora</label></td> 
            <td><input type="text" name="<ccs:control name='s_Hora' property='name'/>" value="<ccs:control name='s_Hora'/>" maxlength="100" size="10" id="tbl_visitaSearchs_Hora">
              <ccs:datepicker name='DatePicker_s_Hora'><a href="javascript:showDatePicker('<ccs:dpvalue property='Name'/>','<ccs:dpvalue property='FormName'/>','<ccs:dpvalue property='DateControl'/>');" id="tbl_visitaSearchDatePicker_s_Hora"><img src="Styles/Padrao/Images/DatePicker.gif" border="0" alt="Show Date Picker" id="tbl_visitaSearchDatePicker_s_Hora_Image"></a></ccs:datepicker></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input name="<ccs:control name='Button_DoSearch' property='name'/>" type="submit" value="Buscar" alt="Buscar" id="tbl_visitaSearchButton_DoSearch" class="Button"></ccs:button></td> 
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
      <table cellspacing="0" cellpadding="0" border="0" class="Header">
        <tr>
          <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
          <td class="th"><strong>List of Tbl Visita</strong></td> 
          <td class="HeaderRight"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
        </tr>
 
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Visita' column='Cod_Visita'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Cod_Visita">Cod Visita</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data' column='Data'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Data">Data</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Hora' column='Hora'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Hora">Hora</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Imovel' column='Cod_Imovel'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Cod_Imovel">Cod Imovel</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_visitaSorter_Cod_Funcionario">Cod Funcionario</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="text-align:right;"><a href="<ccs:control name='Cod_Visita' property='href'/>" id="tbl_visitaCod_Visita_<ccs:attribute owner = 'tbl_visita' name = 'rowNumber' />"><ccs:control name='Cod_Visita'/></a>&nbsp;</td> 
          <td><ccs:control name='Data'/>&nbsp;</td> 
          <td><ccs:control name='Hora'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Imovel'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Funcionario'/>&nbsp;</td> 
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="5">Sem registros</td> 
        </tr>
 </ccs:norecords>
        <tr class="Footer">
          <td colspan="5"><a href="<ccs:control name='tbl_visita_Insert' property='href'/>" id="tbl_visitatbl_visita_Insert">Add New</a>&nbsp; 
            <ccs:navigator name='Navigator' type='Simple' size='10'>
            <ccs:first_on><a href="<ccs:page_href/>">|&lt; </a> </ccs:first_on>
            <ccs:prev_on><a href="<ccs:page_href/>">&lt;&lt; </a> </ccs:prev_on>&nbsp;<ccs:page_number/> de&nbsp;<ccs:total_pages/>&nbsp; 
            <ccs:next_on><a href="<ccs:page_href/>">&gt;&gt; </a> </ccs:next_on>
            <ccs:last_on><a href="<ccs:page_href/>">&gt;| </a> </ccs:last_on></ccs:navigator>&nbsp;</td> 
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

<%--JSP Page BeforeOutput @1-F5D0FAF7--%>
<%tbl_visita_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-1AA60409--%>
<%tbl_visita_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

