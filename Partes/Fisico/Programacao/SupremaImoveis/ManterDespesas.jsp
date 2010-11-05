<%--JSP Page Init @1-D8481054--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterDespesasServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-D19D71D3--%>
<%@include file="ManterDespesasHandlers.jsp"%>
<%
    if (!ManterDespesasModel.isVisible()) return;
    if (ManterDespesasParent != null) {
        if (!ManterDespesasParent.getChild(ManterDespesasModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterDespesasModel);
    pageContext.setAttribute("page", ManterDespesasModel);
    ManterDespesasModel.fireOnInitializeViewEvent(new Event());
    ManterDespesasModel.fireBeforeShowEvent(new Event());
    if (!ManterDespesasModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-5130655F--%>
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
<ccs:record name='tbl_despesas'>
<form id="tbl_despesas" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Despesas </strong></td> 
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
            <td class="th"><label for="tbl_despesasData">Data</label></td> 
            <td><input id="tbl_despesasData" maxlength="20" value="<ccs:control name='Data'/>" name="<ccs:control name='Data' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_despesasValor">Valor</label></td> 
            <td><input id="tbl_despesasValor" maxlength="10" size="10" value="<ccs:control name='Valor'/>" name="<ccs:control name='Valor' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_despesasTipo_Despesas">Tipo Despesas</label></td> 
            <td><input id="tbl_despesasTipo_Despesas" maxlength="10" size="10" value="<ccs:control name='Tipo_Despesas'/>" name="<ccs:control name='Tipo_Despesas' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_despesasCod_Aluguel">Imovel</label></td> 
            <td><input id="tbl_despesasCod_Aluguel" maxlength="10" size="10" value="<ccs:control name='Cod_Aluguel'/>" name="<ccs:control name='Cod_Aluguel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_despesastbl_situacao_Cod_Situacao">Situacao</label></td> 
            <td><input id="tbl_despesastbl_situacao_Cod_Situacao" maxlength="10" size="10" value="<ccs:control name='tbl_situacao_Cod_Situacao'/>" name="<ccs:control name='tbl_situacao_Cod_Situacao' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_despesasButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_despesasButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_despesasButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
<jsp:include page="/Footer.jsp" flush="true"/> 
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-C830A6B1--%>
<%ManterDespesasModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-2746584F--%>
<%ManterDespesasModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

