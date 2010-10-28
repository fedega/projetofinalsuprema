<%--JSP Page Init @1-E4D10090--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_cliente_listServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-1FF72B6C--%>
<%@include file="tbl_cliente_listHandlers.jsp"%>
<%
    if (!tbl_cliente_listModel.isVisible()) return;
    if (tbl_cliente_listParent != null) {
        if (!tbl_cliente_listParent.getChild(tbl_cliente_listModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_cliente_listModel);
    pageContext.setAttribute("page", tbl_cliente_listModel);
    tbl_cliente_listModel.fireOnInitializeViewEvent(new Event());
    tbl_cliente_listModel.fireBeforeShowEvent(new Event());
    if (!tbl_cliente_listModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-1E250296--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Cliente</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_clienteSearch'>
<form id="tbl_clienteSearch" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Buscar Tbl Cliente </strong></td> 
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
            <td class="th"><label for="tbl_clienteSearchs_Nome">Nome</label></td> 
            <td><input type="text" name="<ccs:control name='s_Nome' property='name'/>" value="<ccs:control name='s_Nome'/>" maxlength="40" size="40" id="tbl_clienteSearchs_Nome"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Nome_U">Nome U</label></td> 
            <td><input type="text" name="<ccs:control name='s_Nome_U' property='name'/>" value="<ccs:control name='s_Nome_U'/>" maxlength="16" size="16" id="tbl_clienteSearchs_Nome_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Senha_U">Senha U</label></td> 
            <td><input type="text" name="<ccs:control name='s_Senha_U' property='name'/>" value="<ccs:control name='s_Senha_U'/>" maxlength="40" size="40" id="tbl_clienteSearchs_Senha_U"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Nacionalidade">Nacionalidade</label></td> 
            <td><input type="text" name="<ccs:control name='s_Nacionalidade' property='name'/>" value="<ccs:control name='s_Nacionalidade'/>" maxlength="30" size="30" id="tbl_clienteSearchs_Nacionalidade"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Endereco">Endereco</label></td> 
            <td><input type="text" name="<ccs:control name='s_Endereco' property='name'/>" value="<ccs:control name='s_Endereco'/>" maxlength="200" size="50" id="tbl_clienteSearchs_Endereco"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input name="<ccs:control name='Button_DoSearch' property='name'/>" type="submit" value="Buscar" alt="Buscar" id="tbl_clienteSearchButton_DoSearch" class="Button"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_cliente'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table cellspacing="0" cellpadding="0" border="0" class="Header">
        <tr>
          <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
          <td class="th"><strong>List of Tbl Cliente</strong></td> 
          <td class="HeaderRight"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
        </tr>
 
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cliente' column='Cod_Cliente'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Cliente">Cod Cliente</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome' column='Nome'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Nome">Nome</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data_Nasc' column='Data_Nasc'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Data_Nasc">Data Nasc</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome_U' column='Nome_U'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Nome_U">Nome U</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Senha_U' column='Senha_U'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Senha_U">Senha U</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nacionalidade' column='Nacionalidade'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Nacionalidade">Nacionalidade</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Endereco' column='Endereco'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Endereco">Endereco</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Fixo' column='Tel_Fixo'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tel_Fixo">Tel Fixo</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Cel' column='Tel_Cel'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tel_Cel">Tel Cel</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Comercial' column='Tel_Comercial'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tel_Comercial">Tel Comercial</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Estado' column='Cod_Estado'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Estado">Cod Estado</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cidade' column='Cod_Cidade'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Cidade">Cod Cidade</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Funcionario">Cod Funcionario</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Orgao_Emissor' column='Orgao_Emissor'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Orgao_Emissor">Orgao Emissor</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tipo_Cliente' column='Tipo_Cliente'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tipo_Cliente">Tipo Cliente</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="text-align:right;"><a href="<ccs:control name='Cod_Cliente' property='href'/>" id="tbl_clienteCod_Cliente_<ccs:attribute owner = 'tbl_cliente' name = 'rowNumber' />"><ccs:control name='Cod_Cliente'/></a>&nbsp;</td> 
          <td><ccs:control name='Nome'/>&nbsp;</td> 
          <td><ccs:control name='Data_Nasc'/>&nbsp;</td> 
          <td><ccs:control name='Nome_U'/>&nbsp;</td> 
          <td><ccs:control name='Senha_U'/>&nbsp;</td> 
          <td><ccs:control name='Nacionalidade'/>&nbsp;</td> 
          <td><ccs:control name='Endereco'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Tel_Fixo'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Tel_Cel'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Tel_Comercial'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Estado'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Cidade'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Funcionario'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Orgao_Emissor'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Tipo_Cliente'/>&nbsp;</td> 
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="15">Sem registros</td> 
        </tr>
 </ccs:norecords>
        <tr class="Footer">
          <td colspan="15"><a href="<ccs:control name='tbl_cliente_Insert' property='href'/>" id="tbl_clientetbl_cliente_Insert">Add New</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-934B154E--%>
<%tbl_cliente_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-7C3DEBB0--%>
<%tbl_cliente_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

