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

<%--JSP Page Content @1-DE53DDD7--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Cliente</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css"><script language="JavaScript" type="text/javascript">
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
<ccs:record name='tbl_clienteSearch'>
<form id="tbl_clienteSearch" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Buscar Cliente </strong></td> 
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
            <td class="th"><label for="tbl_clienteSearchs_Nome">Nome</label></td> 
            <td><input id="tbl_clienteSearchs_Nome" maxlength="40" size="40" value="<ccs:control name='s_Nome'/>" name="<ccs:control name='s_Nome' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Nome_U">Nome de Usuario</label></td> 
            <td><input id="tbl_clienteSearchs_Nome_U" maxlength="16" size="16" value="<ccs:control name='s_Nome_U'/>" name="<ccs:control name='s_Nome_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Senha_U">Senha</label></td> 
            <td><input id="tbl_clienteSearchs_Senha_U" maxlength="40" size="40" value="<ccs:control name='s_Senha_U'/>" name="<ccs:control name='s_Senha_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Nacionalidade">Nacionalidade</label></td> 
            <td><input id="tbl_clienteSearchs_Nacionalidade" maxlength="30" size="30" value="<ccs:control name='s_Nacionalidade'/>" name="<ccs:control name='s_Nacionalidade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clienteSearchs_Endereco">Endereço</label></td> 
            <td><input id="tbl_clienteSearchs_Endereco" maxlength="200" size="50" value="<ccs:control name='s_Endereco'/>" name="<ccs:control name='s_Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_DoSearch'><input class="Button" id="tbl_clienteSearchButton_DoSearch" type="submit" alt="Buscar" value="Buscar" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td>
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
      <table class="Header" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
          <td class="th"><strong>Lista de Clientes</strong></td> 
          <td class="HeaderRight"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td>
        </tr>
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cliente' column='Cod_Cliente'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Cliente">Codigo Cliente</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome' column='Nome'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Nome">Nome</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data_Nasc' column='Data_Nasc'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Data_Nasc">Data de Nascimento</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome_U' column='Nome_U'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Nome_U">Nome de Usuario</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Senha_U' column='Senha_U'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Senha_U">Senha</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nacionalidade' column='Nacionalidade'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Nacionalidade">Nacionalidade</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Endereco' column='Endereco'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Endereco">Endereço</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Fixo' column='Tel_Fixo'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tel_Fixo">Telefone Fixo</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Cel' column='Tel_Cel'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tel_Cel">Telefone Celular</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Comercial' column='Tel_Comercial'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tel_Comercial">Telefone Comercial</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Estado' column='Cod_Estado'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Estado">Estado</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cidade' column='Cod_Cidade'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Cidade">Cidade</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Funcionario' column='Cod_Funcionario'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Cod_Funcionario">Funcionario</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Orgao_Emissor' column='Orgao_Emissor'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Orgao_Emissor">Orgao Emissor</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tipo_Cliente' column='Tipo_Cliente'><a href="<ccs:sorter_href/>" id="tbl_clienteSorter_Tipo_Cliente">Tipo Cliente</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Cliente' property='href'/>" id="tbl_clienteCod_Cliente_<ccs:attribute owner = 'tbl_cliente' name = 'rowNumber' />"><ccs:control name='Cod_Cliente'/></a>&nbsp;</td> 
          <td><ccs:control name='Nome'/>&nbsp;</td> 
          <td><ccs:control name='Data_Nasc'/>&nbsp;</td> 
          <td><ccs:control name='Nome_U'/>&nbsp;</td> 
          <td><ccs:control name='Senha_U'/>&nbsp;</td> 
          <td><ccs:control name='Nacionalidade'/>&nbsp;</td> 
          <td><ccs:control name='Endereco'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tel_Fixo'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tel_Cel'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tel_Comercial'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Estado'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Cidade'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Funcionario'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Orgao_Emissor'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tipo_Cliente'/>&nbsp;</td>
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="15">Sem registros</td>
        </tr>
        </ccs:norecords>
        <tr class="Footer">
          <td colspan="15"><a href="<ccs:control name='tbl_cliente_Insert' property='href'/>" id="tbl_clientetbl_cliente_Insert">Adicionar Novo</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-934B154E--%>
<%tbl_cliente_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-7C3DEBB0--%>
<%tbl_cliente_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

