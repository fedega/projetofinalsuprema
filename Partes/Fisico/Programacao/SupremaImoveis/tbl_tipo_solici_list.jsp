<%--JSP Page Init @1-16EFE2F9--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_tipo_solici_listServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-3CCEDC20--%>
<%@include file="tbl_tipo_solici_listHandlers.jsp"%>
<%
    if (!tbl_tipo_solici_listModel.isVisible()) return;
    if (tbl_tipo_solici_listParent != null) {
        if (!tbl_tipo_solici_listParent.getChild(tbl_tipo_solici_listModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_tipo_solici_listModel);
    pageContext.setAttribute("page", tbl_tipo_solici_listModel);
    tbl_tipo_solici_listModel.fireOnInitializeViewEvent(new Event());
    tbl_tipo_solici_listModel.fireBeforeShowEvent(new Event());
    if (!tbl_tipo_solici_listModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-3AEF1E48--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Tipo Solicitacao</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_tipo_solicitacaoSearch'>
<form id="tbl_tipo_solicitacaoSearch" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Buscar Tbl Tipo Solicitacao </strong></td> 
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
            <td class="th"><label for="tbl_tipo_solicitacaoSearchs_Descricao">Descricao</label></td> 
            <td><input type="text" name="<ccs:control name='s_Descricao' property='name'/>" value="<ccs:control name='s_Descricao'/>" maxlength="20" size="20" id="tbl_tipo_solicitacaoSearchs_Descricao"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input name="<ccs:control name='Button_DoSearch' property='name'/>" type="submit" value="Buscar" alt="Buscar" id="tbl_tipo_solicitacaoSearchButton_DoSearch" class="Button"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_tipo_solicitacao'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table cellspacing="0" cellpadding="0" border="0" class="Header">
        <tr>
          <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
          <td class="th"><strong>List of Tbl Tipo Solicitacao</strong></td> 
          <td class="HeaderRight"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
        </tr>
 
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Solicitacao' column='Cod_Solicitacao'><a href="<ccs:sorter_href/>" id="tbl_tipo_solicitacaoSorter_Cod_Solicitacao">Cod Solicitacao</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Descricao' column='Descricao'><a href="<ccs:sorter_href/>" id="tbl_tipo_solicitacaoSorter_Descricao">Descricao</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="text-align:right;"><a href="<ccs:control name='Cod_Solicitacao' property='href'/>" id="tbl_tipo_solicitacaoCod_Solicitacao_<ccs:attribute owner = 'tbl_tipo_solicitacao' name = 'rowNumber' />"><ccs:control name='Cod_Solicitacao'/></a>&nbsp;</td> 
          <td><ccs:control name='Descricao'/>&nbsp;</td> 
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="2">Sem registros</td> 
        </tr>
 </ccs:norecords>
        <tr class="Footer">
          <td colspan="2"><a href="<ccs:control name='tbl_tipo_solicitacao_Insert' property='href'/>" id="tbl_tipo_solicitacaotbl_tipo_solicitacao_Insert">Add New</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-047B2747--%>
<%tbl_tipo_solici_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-EB0DD9B9--%>
<%tbl_tipo_solici_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

