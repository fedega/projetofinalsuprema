<%--JSP Page Init @1-60806B23--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterContratoServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-E73D5D3B--%>
<%@include file="ManterContratoHandlers.jsp"%>
<%
    if (!ManterContratoModel.isVisible()) return;
    if (ManterContratoParent != null) {
        if (!ManterContratoParent.getChild(ManterContratoModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterContratoModel);
    pageContext.setAttribute("page", ManterContratoModel);
    ManterContratoModel.fireOnInitializeViewEvent(new Event());
    ManterContratoModel.fireBeforeShowEvent(new Event());
    if (!ManterContratoModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-CCE5A5FC--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Contrato</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css"><script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_contrato'>
<form id="tbl_contrato" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Contrato </strong></td> 
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
            <td class="th"><label for="tbl_contratoCod_Funcionario">Funcionario</label></td> 
            <td><input id="tbl_contratoCod_Funcionario" maxlength="10" size="10" value="<ccs:control name='Cod_Funcionario'/>" name="<ccs:control name='Cod_Funcionario' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_contratoCod_Cliente">Cliente</label></td> 
            <td><input id="tbl_contratoCod_Cliente" maxlength="10" size="10" value="<ccs:control name='Cod_Cliente'/>" name="<ccs:control name='Cod_Cliente' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_contratoCod_Imovel">Imovel</label></td> 
            <td><input id="tbl_contratoCod_Imovel" maxlength="10" size="10" value="<ccs:control name='Cod_Imovel'/>" name="<ccs:control name='Cod_Imovel' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_contratoCod_Fiador">Fiador</label></td> 
            <td><input id="tbl_contratoCod_Fiador" maxlength="10" size="10" value="<ccs:control name='Cod_Fiador'/>" name="<ccs:control name='Cod_Fiador' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_contratoButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_contratoButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_contratoButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-47E3AB97--%>
<%ManterContratoModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-A8955569--%>
<%ManterContratoModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

