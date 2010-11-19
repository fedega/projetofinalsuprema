<%--JSP Page Init @1-E1008677--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ListaDocumentacaoServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-EF473C89--%>
<%@include file="ListaDocumentacaoHandlers.jsp"%>
<%
    if (!ListaDocumentacaoModel.isVisible()) return;
    if (ListaDocumentacaoParent != null) {
        if (!ListaDocumentacaoParent.getChild(ListaDocumentacaoModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ListaDocumentacaoModel);
    pageContext.setAttribute("page", ListaDocumentacaoModel);
    ListaDocumentacaoModel.fireOnInitializeViewEvent(new Event());
    ListaDocumentacaoModel.fireBeforeShowEvent(new Event());
    if (!ListaDocumentacaoModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-9C894046--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Documentacao</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
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
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_documentacaoSearch'>
<form id="tbl_documentacaoSearch" method="post" name="<ccs:form_name/>" action="<ccs:form_action/>">
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
        <table class="Header" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
            <td class="th"><strong>Buscar Documentacao </strong></td> 
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
            <td class="th"><label for="tbl_documentacaoSearchs_Anexo">Anexo</label></td> 
            <td><input id="tbl_documentacaoSearchs_Anexo" value="<ccs:control name='s_Anexo'/>" size="50" name="<ccs:control name='s_Anexo' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input id="tbl_documentacaoSearchButton_DoSearch" class="Button" value="Buscar" alt="Buscar" type="submit" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_documentacao'>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table class="Header" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
          <td class="th"><strong>Lista de&nbsp;Documentacao</strong></td> 
          <td class="HeaderRight"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td>
        </tr>
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Doc' column='Cod_Doc'><a href="<ccs:sorter_href/>" id="tbl_documentacaoSorter_Cod_Doc">N° do Documento</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tipo_Doc' column='Tipo_Doc'><a href="<ccs:sorter_href/>" id="tbl_documentacaoSorter_Tipo_Doc">Tipo do Documento</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cliente' column='Cod_Cliente'><a href="<ccs:sorter_href/>" id="tbl_documentacaoSorter_Cod_Cliente">Cliente</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">&nbsp;</th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Fiador' column='Cod_Fiador'><a href="<ccs:sorter_href/>" id="tbl_documentacaoSorter_Cod_Fiador">Fiador</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Doc' property='href'/>" id="tbl_documentacaoCod_Doc_<ccs:attribute owner = 'tbl_documentacao' name = 'rowNumber' />"><ccs:control name='Cod_Doc'/></a>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tipo_Doc'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Cliente'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right">&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Fiador'/>&nbsp;</td>
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="5">Sem registros</td>
        </tr>
        </ccs:norecords>
        <tr class="Footer">
          <td colspan="5"><a href="<ccs:control name='tbl_documentacao_Insert' property='href'/>" id="tbl_documentacaotbl_documentacao_Insert">Novo Registro</a>&nbsp; 
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
<jsp:include page="/Footer.jsp" flush="true"/> <br>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-FE6BBACC--%>
<%ListaDocumentacaoModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-111D4432--%>
<%ListaDocumentacaoModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

