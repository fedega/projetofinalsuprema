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

<%--JSP Page Content @1-702A6F5B--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Imovel</title>
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
<ccs:record name='tbl_imovelSearch'>
<form id="tbl_imovelSearch" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Buscar Imovel </strong></td> 
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
            <td class="th"><label for="tbl_imovelSearchs_Endereco">Endereco</label></td> 
            <td><input id="tbl_imovelSearchs_Endereco" maxlength="40" size="40" value="<ccs:control name='s_Endereco'/>" name="<ccs:control name='s_Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelSearchs_Bairro">Bairro</label></td> 
            <td><input id="tbl_imovelSearchs_Bairro" maxlength="20" value="<ccs:control name='s_Bairro'/>" name="<ccs:control name='s_Bairro' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_DoSearch'><input class="Button" id="tbl_imovelSearchButton_DoSearch" type="submit" alt="Buscar" value="Buscar" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td>
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
      <table class="Header" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
          <td class="th"><strong>Lista de Imóveis</strong></td> 
          <td class="HeaderRight"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td>
        </tr>
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Imovel' column='Cod_Imovel'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Imovel">Codigo do Imovel</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cliente' column='Cod_Cliente'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Cliente">Cliente</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Funcionario">Funcionario</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Situacao' column='Cod_Situacao'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Situacao">Situacao</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_destinacao' column='Cod_destinacao'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_destinacao">Destinacao</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Endereco' column='Endereco'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Endereco">Endereco</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_CEP' column='CEP'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_CEP">CEP</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Bairro' column='Bairro'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Bairro">Bairro</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Estado' column='Cod_Estado'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Estado">Estado</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cidade' column='Cod_Cidade'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Cod_Cidade">Cidade</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Quartos' column='N_Quartos'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Quartos">N° de Quartos</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Suites' column='N_Suites'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Suites">N° de Suites</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Banheiros' column='N_Banheiros'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Banheiros">N° de Banheiros</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Salas' column='N_Salas'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Salas">N° de Salas</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_N_Cozinhas' column='N_Cozinhas'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_N_Cozinhas">N° de Cozinhas</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Dep_Empregada' column='Dep_Empregada'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Dep_Empregada">Dep. de Empregada</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Garagem' column='Garagem'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Garagem">Garagem</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Mts_Quadrados' column='Mts_Quadrados'><a href="<ccs:sorter_href/>" id="tbl_imovelSorter_Mts_Quadrados">Metros²</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Imovel' property='href'/>" id="tbl_imovelCod_Imovel_<ccs:attribute owner = 'tbl_imovel' name = 'rowNumber' />"><ccs:control name='Cod_Imovel'/></a>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Cliente'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Funcionario'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Situacao'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_destinacao'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Endereco'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='CEP'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Bairro'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Estado'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Cidade'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Quartos'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Suites'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Banheiros'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='N_Salas'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:variable name='N_Cozinhas'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:variable name='Dep_Empregada'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:variable name='Garagem'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:variable name='Mts_Quadrados'/>&nbsp;</td>
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="18">Sem registros</td>
        </tr>
        </ccs:norecords>
        <tr class="Footer">
          <td colspan="18"><a href="<ccs:variable name='tbl_imovel_Insert_Src'/>" id="tbl_imoveltbl_imovel_Insert">Novo Registro</a>&nbsp; 
            <!-- BEGIN Navigator Navigator -->
            <!-- BEGIN First_On --><a href="<ccs:page_href/>">|&lt;</a> <!-- END First_On -->
            <!-- BEGIN Prev_On --><a href="<ccs:page_href/>">&lt;&lt;</a> <!-- END Prev_On -->&nbsp;<ccs:page_number/> de&nbsp;<ccs:total_pages/>&nbsp; 
            <!-- BEGIN Next_On --><a href="<ccs:page_href/>">&gt;&gt;</a> <!-- END Next_On -->
            <!-- BEGIN Last_On --><a href="<ccs:page_href/>">&gt;|</a> <!-- END Last_On --><!-- END Navigator Navigator -->&nbsp;</td>
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

<%--JSP Page BeforeOutput @1-0429EF05--%>
<%ListaImovelModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-EB5F11FB--%>
<%ListaImovelModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

