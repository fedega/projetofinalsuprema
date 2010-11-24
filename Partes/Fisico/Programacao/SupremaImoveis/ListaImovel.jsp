<%--JSP Page Init @1-FADCBB99--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ListaImovelServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-41538093--%>
<%@include file="ListaImovelHandlers.jsp"%>
<%
    if (!ListaImovelModel.isVisible()) return;
    if (ListaImovelParent != null) {
        if (!ListaImovelParent.getChild(ListaImovelModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ListaImovelModel);
    pageContext.setAttribute("page", ListaImovelModel);
    ListaImovelModel.fireOnInitializeViewEvent(new Event());
    ListaImovelModel.fireBeforeShowEvent(new Event());
    if (!ListaImovelModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-98C8C3E5--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Consultar Imovel</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css" />
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-CE0F0269
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//bind_events @1-4A8114A8
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<p>&nbsp;<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_imovelSearch'>
<form id="tbl_imovelSearch" method="post" name="<ccs:form_name/>" action="<ccs:form_action/>">
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
        <table class="Header" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
            <td class="th"><strong>Buscar Imóvel </strong></td> 
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
            <td class="th"><label for="tbl_imovelSearchs_Endereco">Endereco</label></td> 
            <td><input id="tbl_imovelSearchs_Endereco" value="<ccs:control name='s_Endereco'/>" maxlength="40" size="40" name="<ccs:control name='s_Endereco' property='name'/>"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelSearchs_Bairro">Bairro</label></td> 
            <td><input id="tbl_imovelSearchs_Bairro" value="<ccs:control name='s_Bairro'/>" maxlength="20" name="<ccs:control name='s_Bairro' property='name'/>" size="20"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelSearchs_Cod_Cliente">Cliente</label></td> 
            <td><input id="tbl_imovelSearchs_Cod_Cliente" value="<ccs:control name='s_Cod_Cliente'/>" maxlength="10" size="10" name="<ccs:control name='s_Cod_Cliente' property='name'/>"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoSearch'><input id="tbl_imovelSearchButton_DoSearch" class="Button" value="Buscar" alt="Buscar" type="submit" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record></p>
<ccs:grid name='tbl_imovel'>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table class="Header" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
          <td class="th"><strong>Lista de&nbsp;Imóveis</strong></td> 
          <td class="HeaderRight"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
        </tr>
 
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Imovel' column='Cod_Imovel'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Imovel">N° Imovel</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome' column='tbl_cliente.Nome'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Nome">Cliente</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Situacao' column='Cod_Situacao'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Situacao">Situaçao</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Destinacao' column='Destinacao'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Destinacao">Destinaçao</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Endereco' column='tbl_imovel.Endereco'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Endereco">Endereço</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Bairro' column='Bairro'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Bairro">Bairro</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_CEP' column='CEP'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_CEP">CEP</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_UF' column='UF'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_UF">UF</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome1' column='tbl_cidade.Nome'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Nome1">Cidade</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome2' column='tbl_funcionario.Nome'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Nome2">Funcionario</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Quartos' column='N_Quartos'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Quartos">N Quartos</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Suites' column='N_Suites'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Suites">N Suites</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Banheiros' column='N_Banheiros'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Banheiros">N Banheiros</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Salas' column='N_Salas'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Salas">N Salas</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Cozinhas' column='N_Cozinhas'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Cozinhas">N Cozinhas</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Dep_Empregada' column='Dep_Empregada'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Dep_Empregada">Dep Empregada</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Garagem' column='Garagem'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Garagem">Garagem</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Mts_Quadrados' column='Mts_Quadrados'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Mts_Quadrados">Mts Quadrados</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data' column='Data'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Data">Data</a> 
          <ccs:asc_on><img border="0" alt="Ascending" src="Styles/Padrao/Images/Asc.gif"></ccs:asc_on>
          <ccs:desc_on><img border="0" alt="Descending" src="Styles/Padrao/Images/Desc.gif"></ccs:desc_on></ccs:sorter></th>
 
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Imovel' property='href'/>" id="tbl_imovelCod_Imovel_<ccs:attribute owner = 'tbl_imovel' name = 'rowNumber' />"><ccs:control name='Cod_Imovel'/></a>&nbsp;</td> 
          <td><ccs:control name='Nome'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Situacao'/>&nbsp;</td> 
          <td><ccs:control name='Destinacao'/>&nbsp;</td> 
          <td><ccs:control name='Endereco'/>&nbsp;</td> 
          <td><ccs:control name='Bairro'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='CEP'/>&nbsp;</td> 
          <td><ccs:control name='UF'/>&nbsp;</td> 
          <td><ccs:control name='Nome1'/>&nbsp;</td> 
          <td><ccs:control name='Nome2'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Quartos'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Suites'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Banheiros'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Salas'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Cozinhas'/>&nbsp;</td> 
          <td><ccs:control name='Dep_Empregada'/>&nbsp;</td> 
          <td><ccs:control name='Garagem'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Mts_Quadrados'/>&nbsp;</td> 
          <td><ccs:control name='Data'/>&nbsp;</td> 
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="19">Sem registros</td> 
        </tr>
 </ccs:norecords>
        <tr class="Footer">
          <td colspan="19"><a href="<ccs:control name='tbl_imovel_Insert' property='href'/>" id="tbl_imoveltbl_imovel_Insert">Novo Registro</a>&nbsp; 
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
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-0429EF05--%>
<%ListaImovelModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-EB5F11FB--%>
<%ListaImovelModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

