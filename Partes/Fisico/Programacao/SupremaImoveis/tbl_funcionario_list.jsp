<%--JSP Page Init @1-442276BC--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_funcionario_listServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-2C5586B3--%>
<%@include file="tbl_funcionario_listHandlers.jsp"%>
<%
    if (!tbl_funcionario_listModel.isVisible()) return;
    if (tbl_funcionario_listParent != null) {
        if (!tbl_funcionario_listParent.getChild(tbl_funcionario_listModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_funcionario_listModel);
    pageContext.setAttribute("page", tbl_funcionario_listModel);
    tbl_funcionario_listModel.fireOnInitializeViewEvent(new Event());
    tbl_funcionario_listModel.fireBeforeShowEvent(new Event());
    if (!tbl_funcionario_listModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-67313AC3--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Funcionario</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_funcionarioSearch'>
<form id="tbl_funcionarioSearch" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Buscar Tbl Funcionario </strong></td> 
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
            <td class="th"><label for="tbl_funcionarioSearchs_Nome">Nome</label></td> 
            <td><input type="text" name="<ccs:control name='s_Nome' property='name'/>" value="<ccs:control name='s_Nome'/>" maxlength="40" size="40" id="tbl_funcionarioSearchs_Nome"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioSearchs_Nome_U">Nome U</label></td> 
            <td><input type="text" name="<ccs:control name='s_Nome_U' property='name'/>" value="<ccs:control name='s_Nome_U'/>" maxlength="20" size="20" id="tbl_funcionarioSearchs_Nome_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_funcionarioSearchs_Endereco">Endereco</label></td> 
            <td><input type="text" name="<ccs:control name='s_Endereco' property='name'/>" value="<ccs:control name='s_Endereco'/>" maxlength="40" size="40" id="tbl_funcionarioSearchs_Endereco"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input name="<ccs:control name='Button_DoSearch' property='name'/>" type="submit" value="Buscar" alt="Buscar" id="tbl_funcionarioSearchButton_DoSearch" class="Button"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_funcionario'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table cellspacing="0" cellpadding="0" border="0" class="Header">
        <tr>
          <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
          <td class="th"><strong>List of Tbl Funcionario</strong></td> 
          <td class="HeaderRight"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
        </tr>
 
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Cod_Funcionario">Cod Funcionario</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome' column='Nome'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Nome">Nome</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cidade' column='Cod_Cidade'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Cod_Cidade">Cod Cidade</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Estado' column='tbl_funcionario.Cod_Estado'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Cod_Estado">Cod Estado</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Orgao' column='Cod_Orgao'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Cod_Orgao">Cod Orgao</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome_U' column='Nome_U'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Nome_U">Nome U</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Endereco' column='Endereco'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Endereco">Endereco</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Fixo' column='Tel_Fixo'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Tel_Fixo">Tel Fixo</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Cel' column='Tel_Cel'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Tel_Cel">Tel Cel</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_CPF' column='CPF'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_CPF">CPF</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data_Nasc' column='Data_Nasc'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Data_Nasc">Data Nasc</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_CRECI' column='CRECI'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_CRECI">CRECI</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nivel_Controle' column='Nivel_Controle'><a href="<ccs:sorter_href/>" id="tbl_funcionarioSorter_Nivel_Controle">Nivel Controle</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="text-align:right;"><a href="<ccs:control name='Cod_Funcionario' property='href'/>" id="tbl_funcionarioCod_Funcionario_<ccs:attribute owner = 'tbl_funcionario' name = 'rowNumber' />"><ccs:control name='Cod_Funcionario'/></a>&nbsp;</td> 
          <td><ccs:control name='Nome'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Cidade'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Estado'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Orgao'/>&nbsp;</td> 
          <td><ccs:control name='Nome_U'/>&nbsp;</td> 
          <td><ccs:control name='Endereco'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Tel_Fixo'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Tel_Cel'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='CPF'/>&nbsp;</td> 
          <td><ccs:control name='Data_Nasc'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='CRECI'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Nivel_Controle'/>&nbsp;</td> 
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="13">Sem registros</td> 
        </tr>
 </ccs:norecords>
        <tr class="Footer">
          <td colspan="13"><a href="<ccs:control name='tbl_funcionario_Insert' property='href'/>" id="tbl_funcionariotbl_funcionario_Insert">Add New</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-CA2493F5--%>
<%tbl_funcionario_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-25526D0B--%>
<%tbl_funcionario_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

