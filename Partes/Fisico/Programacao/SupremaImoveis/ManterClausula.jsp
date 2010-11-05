<%--JSP Page Init @1-8BC9FEDE--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterClausulaServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-269C2CE5--%>
<%@include file="ManterClausulaHandlers.jsp"%>
<%
    if (!ManterClausulaModel.isVisible()) return;
    if (ManterClausulaParent != null) {
        if (!ManterClausulaParent.getChild(ManterClausulaModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterClausulaModel);
    pageContext.setAttribute("page", ManterClausulaModel);
    ManterClausulaModel.fireOnInitializeViewEvent(new Event());
    ManterClausulaModel.fireBeforeShowEvent(new Event());
    if (!ManterClausulaModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-DFAC8CC0--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Clausula</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css"><script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_clausula'>
<form id="tbl_clausula" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Cláusula </strong></td> 
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
            <td class="th"><label for="tbl_clausulaTipo">Tipo</label></td> 
            <td><input id="tbl_clausulaTipo" maxlength="10" size="10" value="<ccs:control name='Tipo'/>" name="<ccs:control name='Tipo' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clausulaDescricao">Descricao</label></td> 
            <td><input id="tbl_clausulaDescricao" maxlength="250" size="50" value="<ccs:control name='Descricao'/>" name="<ccs:control name='Descricao' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clausulaCod_Contrato">Cod Contrato</label></td> 
            <td><input id="tbl_clausulaCod_Contrato" maxlength="10" size="10" value="<ccs:control name='Cod_Contrato'/>" name="<ccs:control name='Cod_Contrato' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_clausulaButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_clausulaButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_clausulaButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-E7BE1114--%>
<%ManterClausulaModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-08C8EFEA--%>
<%ManterClausulaModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

