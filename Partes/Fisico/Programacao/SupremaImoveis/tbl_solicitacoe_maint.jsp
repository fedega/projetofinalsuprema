<%--JSP Page Init @1-5A3D6C2A--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_solicitacoe_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-F102576A--%>
<%@include file="tbl_solicitacoe_maintHandlers.jsp"%>
<%
    if (!tbl_solicitacoe_maintModel.isVisible()) return;
    if (tbl_solicitacoe_maintParent != null) {
        if (!tbl_solicitacoe_maintParent.getChild(tbl_solicitacoe_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_solicitacoe_maintModel);
    pageContext.setAttribute("page", tbl_solicitacoe_maintModel);
    tbl_solicitacoe_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_solicitacoe_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_solicitacoe_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-30EE098B--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Solicitacoes</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_solicitacoes'>
<form id="tbl_solicitacoes" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Solicitacoes </strong></td> 
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
            <td class="th"><label for="tbl_solicitacoesDescricao">Descricao</label></td> 
            <td><input type="text" name="<ccs:control name='Descricao' property='name'/>" value="<ccs:control name='Descricao'/>" maxlength="250" size="50" id="tbl_solicitacoesDescricao"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_solicitacoesCod_Funcionario">Cod Funcionario</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Funcionario' property='name'/>" value="<ccs:control name='Cod_Funcionario'/>" maxlength="10" size="10" id="tbl_solicitacoesCod_Funcionario"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_solicitacoesTipo_Solicitacao">Tipo Solicitacao</label></td> 
            <td><input type="text" name="<ccs:control name='Tipo_Solicitacao' property='name'/>" value="<ccs:control name='Tipo_Solicitacao'/>" maxlength="10" size="10" id="tbl_solicitacoesTipo_Solicitacao"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_solicitacoesCod_Situacao">Cod Situacao</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Situacao' property='name'/>" value="<ccs:control name='Cod_Situacao'/>" maxlength="10" size="10" id="tbl_solicitacoesCod_Situacao"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_solicitacoesButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_solicitacoesButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_solicitacoesButton_Delete" class="Button"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-4C9BCC96--%>
<%tbl_solicitacoe_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-A3ED3268--%>
<%tbl_solicitacoe_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

