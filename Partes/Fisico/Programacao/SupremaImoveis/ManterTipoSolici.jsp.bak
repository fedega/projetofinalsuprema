<%--JSP Page Init @1-E555346E--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterTipoSoliciServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-16CACA21--%>
<%@include file="ManterTipoSoliciHandlers.jsp"%>
<%
    if (!ManterTipoSoliciModel.isVisible()) return;
    if (ManterTipoSoliciParent != null) {
        if (!ManterTipoSoliciParent.getChild(ManterTipoSoliciModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterTipoSoliciModel);
    pageContext.setAttribute("page", ManterTipoSoliciModel);
    ManterTipoSoliciModel.fireOnInitializeViewEvent(new Event());
    ManterTipoSoliciModel.fireBeforeShowEvent(new Event());
    if (!ManterTipoSoliciModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-431F5385--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Tipo Solicitacao</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css"><script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-CE0F0269
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//tbl_tipo_solicitacaoButton_Delete_OnClick @5-53EA953F
function tbl_tipo_solicitacaoButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_tipo_solicitacaoButton_Delete_OnClick

//bind_events @1-7E30BA89
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_tipo_solicitacaoButton_Delete", "click", tbl_tipo_solicitacaoButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_tipo_solicitacao'>
<form id="tbl_tipo_solicitacao" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Tipo Solicitacao </strong></td> 
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
            <td class="th"><label for="tbl_tipo_solicitacaoDescricao">Descricao</label></td> 
            <td><input id="tbl_tipo_solicitacaoDescricao" maxlength="20" value="<ccs:control name='Descricao'/>" name="<ccs:control name='Descricao' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_tipo_solicitacaoButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_tipo_solicitacaoButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_tipo_solicitacaoButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-5891860D--%>
<%ManterTipoSoliciModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-B7E778F3--%>
<%ManterTipoSoliciModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

