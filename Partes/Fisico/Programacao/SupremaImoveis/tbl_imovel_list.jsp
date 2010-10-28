<%--JSP Page Init @1-9A68A0C0--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_imovel_listServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-444D7DF1--%>
<%@include file="tbl_imovel_listHandlers.jsp"%>
<%
    if (!tbl_imovel_listModel.isVisible()) return;
    if (tbl_imovel_listParent != null) {
        if (!tbl_imovel_listParent.getChild(tbl_imovel_listModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_imovel_listModel);
    pageContext.setAttribute("page", tbl_imovel_listModel);
    tbl_imovel_listModel.fireOnInitializeViewEvent(new Event());
    tbl_imovel_listModel.fireBeforeShowEvent(new Event());
    if (!tbl_imovel_listModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-8DCDF334--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Imovel</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_imovelSearch'>
<form id="tbl_imovelSearch" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Buscar Tbl Imovel </strong></td> 
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
            <td class="th"><label for="tbl_imovelSearchs_Endereco">Endereco</label></td> 
            <td><input type="text" name="<ccs:control name='s_Endereco' property='name'/>" value="<ccs:control name='s_Endereco'/>" maxlength="40" size="40" id="tbl_imovelSearchs_Endereco"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelSearchs_Bairro">Bairro</label></td> 
            <td><input type="text" name="<ccs:control name='s_Bairro' property='name'/>" value="<ccs:control name='s_Bairro'/>" maxlength="20" size="20" id="tbl_imovelSearchs_Bairro"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input name="<ccs:control name='Button_DoSearch' property='name'/>" type="submit" value="Buscar" alt="Buscar" id="tbl_imovelSearchButton_DoSearch" class="Button"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_imovel'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table cellspacing="0" cellpadding="0" border="0" class="Header">
        <tr>
          <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
          <td class="th"><strong>List of Tbl Imovel</strong></td> 
          <td class="HeaderRight"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
        </tr>
 
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Imovel' column='Cod_Imovel'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Imovel">Cod Imovel</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cliente' column='Cod_Cliente'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Cliente">Cod Cliente</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Funcionario">Cod Funcionario</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Situacao' column='Cod_Situacao'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Situacao">Cod Situacao</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_destinacao' column='Cod_destinacao'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_destinacao">Cod Destinacao</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Endereco' column='Endereco'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Endereco">Endereco</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_CEP' column='CEP'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_CEP">CEP</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Bairro' column='Bairro'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Bairro">Bairro</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Estado' column='Cod_Estado'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Estado">Cod Estado</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cidade' column='Cod_Cidade'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Cidade">Cod Cidade</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Quartos' column='N_Quartos'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Quartos">N Quartos</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Suites' column='N_Suites'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Suites">N Suites</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Banheiros' column='N_Banheiros'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Banheiros">N Banheiros</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Salas' column='N_Salas'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Salas">N Salas</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Cozinhas' column='N_Cozinhas'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Cozinhas">N Cozinhas</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Dep_Empregada' column='Dep_Empregada'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Dep_Empregada">Dep Empregada</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Garagem' column='Garagem'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Garagem">Garagem</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Mts_Quadrados' column='Mts_Quadrados'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Mts_Quadrados">Mts Quadrados</a> 
          <ccs:asc_on><img border="0" src="Styles/Padrao/Images/Asc.gif" alt="Ascending"></ccs:asc_on>
          <ccs:desc_on><img border="0" src="Styles/Padrao/Images/Desc.gif" alt="Descending"></ccs:desc_on></ccs:sorter></th>
 
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="text-align:right;"><a href="<ccs:control name='Cod_Imovel' property='href'/>" id="tbl_imovelCod_Imovel_<ccs:attribute owner = 'tbl_imovel' name = 'rowNumber' />"><ccs:control name='Cod_Imovel'/></a>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Cliente'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Funcionario'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Situacao'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_destinacao'/>&nbsp;</td> 
          <td><ccs:control name='Endereco'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='CEP'/>&nbsp;</td> 
          <td><ccs:control name='Bairro'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Estado'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Cod_Cidade'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='N_Quartos'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='N_Suites'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='N_Banheiros'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='N_Salas'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='N_Cozinhas'/>&nbsp;</td> 
          <td><ccs:control name='Dep_Empregada'/>&nbsp;</td> 
          <td><ccs:control name='Garagem'/>&nbsp;</td> 
          <td style="text-align:right;"><ccs:control name='Mts_Quadrados'/>&nbsp;</td> 
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="18">Sem registros</td> 
        </tr>
 </ccs:norecords>
        <tr class="Footer">
          <td colspan="18"><a href="<ccs:control name='tbl_imovel_Insert' property='href'/>" id="tbl_imoveltbl_imovel_Insert">Add New</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-E44027C5--%>
<%tbl_imovel_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-0B36D93B--%>
<%tbl_imovel_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

