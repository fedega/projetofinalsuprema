<%--JSP Page Init @1-B4E8BAE2--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ListaTipoClienteServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-65FCBF74--%>
<%@include file="ListaTipoClienteHandlers.jsp"%>
<%
    if (!ListaTipoClienteModel.isVisible()) return;
    if (ListaTipoClienteParent != null) {
        if (!ListaTipoClienteParent.getChild(ListaTipoClienteModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ListaTipoClienteModel);
    pageContext.setAttribute("page", ListaTipoClienteModel);
    ListaTipoClienteModel.fireOnInitializeViewEvent(new Event());
    ListaTipoClienteModel.fireBeforeShowEvent(new Event());
    if (!ListaTipoClienteModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-EBA64A73--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tipo de Cliente</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-CE0F0269
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

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
<ccs:record name='tbl_tipo_clienteSearch'>
<form id="tbl_tipo_clienteSearch" method="post" name="<ccs:form_name/>" action="<ccs:form_action/>">
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
        <table class="Header" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
            <td class="th"><strong>Buscar Tipo de&nbsp;Cliente </strong></td> 
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
            <td class="th"><label for="tbl_tipo_clienteSearchs_Descricao">Descricao</label></td> 
            <td><input id="tbl_tipo_clienteSearchs_Descricao" value="<ccs:control name='s_Descricao'/>" maxlength="20" name="<ccs:control name='s_Descricao' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input id="tbl_tipo_clienteSearchButton_DoSearch" class="Button" value="Buscar" alt="Buscar" type="submit" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_tipo_cliente'>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table class="Header" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
          <td class="th"><strong>Lista de&nbsp;Tipo de&nbsp;Cliente</strong></td> 
          <td class="HeaderRight"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td>
        </tr>
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Tipo_Cliente' column='Cod_Tipo_Cliente'><a href="<ccs:sorter_href/>" id="tbl_tipo_clienteSorter_Cod_Tipo_Cliente">Cod Tipo Cliente</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Descricao' column='Descricao'><a href="<ccs:sorter_href/>" id="tbl_tipo_clienteSorter_Descricao">Descricao</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Tipo_Cliente' property='href'/>" id="tbl_tipo_clienteCod_Tipo_Cliente_<ccs:attribute owner = 'tbl_tipo_cliente' name = 'rowNumber' />"><ccs:control name='Cod_Tipo_Cliente'/></a>&nbsp;</td> 
          <td><ccs:control name='Descricao'/>&nbsp;</td>
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="2">Sem registros</td>
        </tr>
        </ccs:norecords>
        <tr class="Footer">
          <td colspan="2"><a href="<ccs:control name='tbl_tipo_cliente_Insert' property='href'/>" id="tbl_tipo_clientetbl_tipo_cliente_Insert">Novo Tipo</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-EF16E5BC--%>
<%ListaTipoClienteModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-00601B42--%>
<%ListaTipoClienteModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

