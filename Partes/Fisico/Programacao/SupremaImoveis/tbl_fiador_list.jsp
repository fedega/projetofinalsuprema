<%--JSP Page Init @1-2562C900--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_fiador_listServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-DDD11A75--%>
<%@include file="tbl_fiador_listHandlers.jsp"%>
<%
    if (!tbl_fiador_listModel.isVisible()) return;
    if (tbl_fiador_listParent != null) {
        if (!tbl_fiador_listParent.getChild(tbl_fiador_listModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_fiador_listModel);
    pageContext.setAttribute("page", tbl_fiador_listModel);
    tbl_fiador_listModel.fireOnInitializeViewEvent(new Event());
    tbl_fiador_listModel.fireBeforeShowEvent(new Event());
    if (!tbl_fiador_listModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-B8570E96--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Fiador</title>
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
<ccs:record name='tbl_fiadorSearch'>
<form id="tbl_fiadorSearch" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Buscar Fiador </strong></td> 
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
            <td class="th"><label for="tbl_fiadorSearchs_Nome">Nome</label></td> 
            <td><input id="tbl_fiadorSearchs_Nome" maxlength="40" size="40" value="<ccs:control name='s_Nome'/>" name="<ccs:control name='s_Nome' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorSearchs_Nome_U">Nome Usuario</label></td> 
            <td><input id="tbl_fiadorSearchs_Nome_U" maxlength="16" size="16" value="<ccs:control name='s_Nome_U'/>" name="<ccs:control name='s_Nome_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorSearchs_Senha_U">Senha Usuario</label></td> 
            <td><input id="tbl_fiadorSearchs_Senha_U" maxlength="40" size="40" value="<ccs:control name='s_Senha_U'/>" name="<ccs:control name='s_Senha_U' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorSearchs_Nacionalidaade">Nacionalidade</label></td> 
            <td><input id="tbl_fiadorSearchs_Nacionalidaade" maxlength="30" size="30" value="<ccs:control name='s_Nacionalidaade'/>" name="<ccs:control name='s_Nacionalidaade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_fiadorSearchs_Endereco">Endereço</label></td> 
            <td><input id="tbl_fiadorSearchs_Endereco" maxlength="200" size="50" value="<ccs:control name='s_Endereco'/>" name="<ccs:control name='s_Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_DoSearch'><input class="Button" id="tbl_fiadorSearchButton_DoSearch" type="submit" alt="Buscar" value="Buscar" name="<ccs:control name='Button_DoSearch' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
<ccs:grid name='tbl_fiador'>
<table cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top">
      <table class="Header" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
          <td class="th"><strong>Lista de Fiador</strong></td> 
          <td class="HeaderRight"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td>
        </tr>
      </table>
 
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Fiador' column='Cod_Fiador'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Cod_Fiador">Codigo Fiador</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Orgao' column='Cod_Orgao'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Cod_Orgao">Orgao Expedidor</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Estado' column='Cod_Estado'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Cod_Estado">Estado</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cidade' column='Cod_Cidade'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Cod_Cidade">Cidade</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Cod_Cliente' column='Cod_Cliente'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Cod_Cliente">Cliente</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome' column='Nome'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Nome">Nome</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Data_Nasc' column='Data_Nasc'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Data_Nasc">Data Nascimento</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nome_U' column='Nome_U'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Nome_U">Nome de Usuario</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Senha_U' column='Senha_U'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Senha_U">Senha U</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Nacionalidaade' column='Nacionalidaade'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Nacionalidaade">Nacionalidade</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Endereco' column='Endereco'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Endereco">Endereco</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Fixo' column='Tel_Fixo'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Tel_Fixo">Telefone Fixo</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Cel' column='Tel_Cel'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Tel_Cel">Telefone Celular</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
 
          <th scope="col">
          <ccs:sorter name='Sorter_Tel_Comercial' column='Tel_Comercial'><a href="<ccs:sorter_href/>" id="tbl_fiadorSorter_Tel_Comercial">Telefone Comercial</a> 
          <ccs:asc_on><img alt="Ascending" src="Styles/Padrao/Images/Asc.gif" border="0"></ccs:asc_on>
          <ccs:desc_on><img alt="Descending" src="Styles/Padrao/Images/Desc.gif" border="0"></ccs:desc_on></ccs:sorter></th>
        </tr>
 
        <ccs:repeater><ccs:row>
        <tr class="Row">
          <td style="TEXT-ALIGN: right"><a href="<ccs:control name='Cod_Fiador' property='href'/>" id="tbl_fiadorCod_Fiador_<ccs:attribute owner = 'tbl_fiador' name = 'rowNumber' />"><ccs:control name='Cod_Fiador'/></a>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Orgao'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Estado'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Cidade'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Cod_Cliente'/>&nbsp;</td> 
          <td><ccs:control name='Nome'/>&nbsp;</td> 
          <td><ccs:control name='Data_Nasc'/>&nbsp;</td> 
          <td><ccs:control name='Nome_U'/>&nbsp;</td> 
          <td><ccs:control name='Senha_U'/>&nbsp;</td> 
          <td><ccs:control name='Nacionalidaade'/>&nbsp;</td> 
          <td><ccs:control name='Endereco'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tel_Fixo'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tel_Cel'/>&nbsp;</td> 
          <td style="TEXT-ALIGN: right"><ccs:control name='Tel_Comercial'/>&nbsp;</td>
        </tr>
 </ccs:row></ccs:repeater>
        <ccs:norecords>
        <tr class="NoRecords">
          <td colspan="14">Sem registros</td>
        </tr>
        </ccs:norecords>
        <tr class="Footer">
          <td colspan="14"><a href="<ccs:control name='tbl_fiador_Insert' property='href'/>" id="tbl_fiadortbl_fiador_Insert">Novo Registro</a>&nbsp; 
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

<%--JSP Page BeforeOutput @1-0A7CD8D1--%>
<%tbl_fiador_listModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-E50A262F--%>
<%tbl_fiador_listModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

