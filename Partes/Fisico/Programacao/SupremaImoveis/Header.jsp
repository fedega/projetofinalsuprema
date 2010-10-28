<%--JSP Page Init @1-9C61F306--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new HeaderServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-C6A8CD9C--%>
<%@include file="HeaderHandlers.jsp"%>
<%
    if (!HeaderModel.isVisible()) return;
    if (HeaderParent != null) {
        if (!HeaderParent.getChild(HeaderModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", HeaderModel);
    pageContext.setAttribute("page", HeaderModel);
    HeaderModel.fireOnInitializeViewEvent(new Event());
    HeaderModel.fireBeforeShowEvent(new Event());
    if (!HeaderModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-B4896FCD--%>
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
<table class="simpleMenu">
  <tr>
    <td><a href="<ccs:control name='tbl_aluguel_list' property='href'/>" id="Headertbl_aluguel_list">Tbl Aluguel</a></td>
    <td><a href="<ccs:control name='tbl_cidade_list' property='href'/>" id="Headertbl_cidade_list">Tbl Cidade</a></td>
    <td><a href="<ccs:control name='tbl_clausula_list' property='href'/>" id="Headertbl_clausula_list">Tbl Clausula</a></td>
    <td><a href="<ccs:control name='tbl_cliente_list' property='href'/>" id="Headertbl_cliente_list">Tbl Cliente</a></td>
    <td><a href="<ccs:control name='tbl_contrato_list' property='href'/>" id="Headertbl_contrato_list">Tbl Contrato</a></td>
    <td><a href="<ccs:control name='tbl_despesas_list' property='href'/>" id="Headertbl_despesas_list">Tbl Despesas</a></td>
    <td><a href="<ccs:control name='tbl_destinacao_list' property='href'/>" id="Headertbl_destinacao_list">Tbl Destinacao</a></td>
    <td><a href="<ccs:control name='tbl_documentaca_list' property='href'/>" id="Headertbl_documentaca_list">Tbl Documentacao</a></td>
    <td><a href="<ccs:control name='tbl_estado_list' property='href'/>" id="Headertbl_estado_list">Tbl Estado</a></td>
    <td><a href="<ccs:control name='tbl_fiador_list' property='href'/>" id="Headertbl_fiador_list">Tbl Fiador</a></td>
    <td><a href="<ccs:control name='tbl_funcionario_list' property='href'/>" id="Headertbl_funcionario_list">Tbl Funcionario</a></td>
    <td><a href="<ccs:control name='tbl_imovel_list' property='href'/>" id="Headertbl_imovel_list">Tbl Imovel</a></td>
    <td><a href="<ccs:control name='tbl_orgaoemisso_list' property='href'/>" id="Headertbl_orgaoemisso_list">Tbl Orgaoemissor</a></td>
    <td><a href="<ccs:control name='tbl_preferencia_list' property='href'/>" id="Headertbl_preferencia_list">Tbl Preferencia</a></td>
    <td><a href="<ccs:control name='tbl_situacao_list' property='href'/>" id="Headertbl_situacao_list">Tbl Situacao</a></td>
    <td><a href="<ccs:control name='tbl_solicitacoe_list' property='href'/>" id="Headertbl_solicitacoe_list">Tbl Solicitacoes</a></td>
    <td><a href="<ccs:control name='tbl_tipo_causul_list' property='href'/>" id="Headertbl_tipo_causul_list">Tbl Tipo Causula</a></td>
    <td><a href="<ccs:control name='tbl_tipo_client_list' property='href'/>" id="Headertbl_tipo_client_list">Tbl Tipo Cliente</a></td>
    <td><a href="<ccs:control name='tbl_tipo_despes_list' property='href'/>" id="Headertbl_tipo_despes_list">Tbl Tipo Despesas</a></td>
    <td><a href="<ccs:control name='tbl_tipo_doc_list' property='href'/>" id="Headertbl_tipo_doc_list">Tbl Tipo Doc</a></td>
    <td><a href="<ccs:control name='tbl_tipo_solici_list' property='href'/>" id="Headertbl_tipo_solici_list">Tbl Tipo Solicitacao</a></td>
    <td><a href="<ccs:control name='tbl_venda_list' property='href'/>" id="Headertbl_venda_list">Tbl Venda</a></td>
    <td><a href="<ccs:control name='tbl_visita_list' property='href'/>" id="Headertbl_visita_list">Tbl Visita</a></td>
  </tr>
</table>

<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-A0A34D6D--%>
<%HeaderModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-4FD5B393--%>
<%HeaderModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

