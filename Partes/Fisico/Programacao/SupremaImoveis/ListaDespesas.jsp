<%--JSP Page Init @1-A4DC1EA5--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ListaDespesasServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-10E4A24D--%>
<%@include file="ListaDespesasHandlers.jsp"%>
<%
    if (!ListaDespesasModel.isVisible()) return;
    if (ListaDespesasParent != null) {
        if (!ListaDespesasParent.getChild(ListaDespesasModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ListaDespesasModel);
    pageContext.setAttribute("page", ListaDespesasModel);
    ListaDespesasModel.fireOnInitializeViewEvent(new Event());
    ListaDespesasModel.fireBeforeShowEvent(new Event());
    if (!ListaDespesasModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-879125E1--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Despesas</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css"><script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_despesasSearch'>
<form id="tbl_despesasSearch" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Buscar Despesas </strong></td> 
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
            <td class="th"><label for="tbl_despesasSearchs_Data">Data</label></td> 
            <td><input id="tbl_despesasSearchs_Data" maxlength="20" value="<ccs:control name='s_Data'/>" name="<ccs:control name='s_Data' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_DoSearch'><input class="Button" id="tbl_despesasSearchButton_DoSearch" type="submit" alt="Buscar" value="Buscar" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_despesas'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table class="Header" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
          <td class="th"><strong>Lista&nbsp;de&nbsp;Despesas</strong></td> 
          <td class="HeaderRight"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td>
        </tr>
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Despesas' column='Cod_Despesas'><a href="<ccs:sorter_href/>" id="tbl_despesasSorter_Cod_Despesas">Codigo da Despesas</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data' column='Data'><a href="<ccs:sorter_href/>" id="tbl_despesasSorter_Data">Data</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Valor' column='Valor'><a href="<ccs:sorter_href/>" id="tbl_despesasSorter_Valor">Valor</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tipo_Despesas' column='Tipo_Despesas'><a href="<ccs:sorter_href/>" id="tbl_despesasSorter_Tipo_Despesas">Tipo Despesas</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Aluguel' column='Cod_Aluguel'><a href="<ccs:sorter_href/>" id="tbl_despesasSorter_Cod_Aluguel">Imovel</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_tbl_situacao_Cod_Situacao' column='tbl_situacao_Cod_Situacao'><a href="<ccs:sorter_href/>" id="tbl_despesasSorter_tbl_situacao_Cod_Situacao">Situacao</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Despesas' property='href'/>" id="tbl_despesasCod_Despesas_<ccs:attribute owner = 'tbl_despesas' name = 'rowNumber' />"><ccs:control name='Cod_Despesas'/></a>&nbsp;</td> 
          <td><ccs:control name='Data'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Valor'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tipo_Despesas'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Aluguel'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='tbl_situacao_Cod_Situacao'/>&nbsp;</td>
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="6">Sem registros</td>
        </tr>
        </ccs:norecords>
        <tr class="Footer">
          <td colspan="6"><a href="<ccs:control name='tbl_despesas_Insert' property='href'/>" id="tbl_despesastbl_despesas_Insert">Nova Despesa</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-79ED5E8C--%>
<%ListaDespesasModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-969BA072--%>
<%ListaDespesasModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

