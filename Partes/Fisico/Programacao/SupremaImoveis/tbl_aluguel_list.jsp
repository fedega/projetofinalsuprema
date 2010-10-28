<%--JSP Page Init @1-C32CA92D--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_aluguel_listServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-928936DF--%>
<%@include file="tbl_aluguel_listHandlers.jsp"%>
<%
    if (!tbl_aluguel_listModel.isVisible()) return;
    if (tbl_aluguel_listParent != null) {
        if (!tbl_aluguel_listParent.getChild(tbl_aluguel_listModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_aluguel_listModel);
    pageContext.setAttribute("page", tbl_aluguel_listModel);
    tbl_aluguel_listModel.fireOnInitializeViewEvent(new Event());
    tbl_aluguel_listModel.fireBeforeShowEvent(new Event());
    if (!tbl_aluguel_listModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-8906B063--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Aluguel</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_aluguelSearch'>
<form id="tbl_aluguelSearch" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Buscar Tbl Aluguel </strong></td> 
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
            <td class="th"><label for="tbl_aluguelSearchs_Cod_Imovel">Cod Imovel</label></td> 
            <td><input type="text" name="<ccs:control name='s_Cod_Imovel' property='name'/>" value="<ccs:control name='s_Cod_Imovel'/>" maxlength="10" size="10" id="tbl_aluguelSearchs_Cod_Imovel"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_aluguelSearchs_Cod_Cliente">Cod Cliente</label></td> 
            <td><input type="text" name="<ccs:control name='s_Cod_Cliente' property='name'/>" value="<ccs:control name='s_Cod_Cliente'/>" maxlength="10" size="10" id="tbl_aluguelSearchs_Cod_Cliente"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input name="<ccs:control name='Button_DoSearch' property='name'/>" type="submit" value="Buscar" alt="Buscar" id="tbl_aluguelSearchButton_DoSearch" class="Button"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_aluguel'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table cellspacing="0" cellpadding="0" border="0" class="Header">
        <tr>
          <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
          <td class="th"><strong>List of Tbl Aluguel</strong></td> 
          <td class="HeaderRight"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
        </tr>
 
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Aluguel' column='Cod_Aluguel'><a href="<ccs:sorter_href/>" id="tbl_aluguelSorter_Cod_Aluguel">Cod Aluguel</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data' column='Data'><a href="<ccs:sorter_href/>" id="tbl_aluguelSorter_Data">Data</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Imovel' column='Cod_Imovel'><a href="<ccs:sorter_href/>" id="tbl_aluguelSorter_Cod_Imovel">Cod Imovel</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cliente' column='Cod_Cliente'><a href="<ccs:sorter_href/>" id="tbl_aluguelSorter_Cod_Cliente">Cod Cliente</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Fiador' column='Cod_Fiador'><a href="<ccs:sorter_href/>" id="tbl_aluguelSorter_Cod_Fiador">Cod Fiador</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_aluguelSorter_Cod_Funcionario">Cod Funcionario</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="text-align:right;"><a href="<ccs:control name='Cod_Aluguel' property='href'/>" id="tbl_aluguelCod_Aluguel_<ccs:attribute owner = 'tbl_aluguel' name = 'rowNumber' />"><ccs:control name='Cod_Aluguel'/></a>&nbsp;</td> 
          <td><ccs:control name='Data'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Imovel'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Cliente'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Fiador'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Funcionario'/>&nbsp;</td> 
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="6">Sem registros</td> 
        </tr>
 </ccs:norecords>
        <tr class="Footer">
          <td colspan="6"><a href="<ccs:control name='tbl_aluguel_Insert' property='href'/>" id="tbl_alugueltbl_aluguel_Insert">Add New</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-DC639769--%>
<%tbl_aluguel_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-33156997--%>
<%tbl_aluguel_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

