<%--JSP Page Init @1-FD70460A--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterCidadeServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-005D9AEC--%>
<%@include file="ManterCidadeHandlers.jsp"%>
<%
    if (!ManterCidadeModel.isVisible()) return;
    if (ManterCidadeParent != null) {
        if (!ManterCidadeParent.getChild(ManterCidadeModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterCidadeModel);
    pageContext.setAttribute("page", ManterCidadeModel);
    ManterCidadeModel.fireOnInitializeViewEvent(new Event());
    ManterCidadeModel.fireBeforeShowEvent(new Event());
    if (!ManterCidadeModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-A8792FCB--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Cidade</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css"><script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_cidade'>
<form id="tbl_cidade" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Cidade </strong></td> 
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
            <td class="th"><label for="tbl_cidadeNome">Nome</label></td> 
            <td><input id="tbl_cidadeNome" maxlength="40" size="40" value="<ccs:control name='Nome'/>" name="<ccs:control name='Nome' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_cidadeCod_Estado">Estado</label></td> 
            <td><select name="<ccs:control name='Cod_Estado' property='name'/>" id="tbl_cidadeCod_Estado">
  <option value="">Selecionar valor</option>
  <ccs:control name='Cod_Estado' property='options'/>
</select>
</td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_cidadeButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_cidadeButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_cidadeButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-FCA7CE35--%>
<%ManterCidadeModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-13D130CB--%>
<%ManterCidadeModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

