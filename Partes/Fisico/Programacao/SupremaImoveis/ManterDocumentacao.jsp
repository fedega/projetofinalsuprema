<%--JSP Page Init @1-99DAA8B6--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterDocumentacaoServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-F47ECEA5--%>
<%@include file="ManterDocumentacaoHandlers.jsp"%>
<%
    if (!ManterDocumentacaoModel.isVisible()) return;
    if (ManterDocumentacaoParent != null) {
        if (!ManterDocumentacaoParent.getChild(ManterDocumentacaoModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterDocumentacaoModel);
    pageContext.setAttribute("page", ManterDocumentacaoModel);
    ManterDocumentacaoModel.fireOnInitializeViewEvent(new Event());
    ManterDocumentacaoModel.fireBeforeShowEvent(new Event());
    if (!ManterDocumentacaoModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-4349F7D5--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Documentacao</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css" /><script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-CE0F0269
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//tbl_documentacaoButton_Delete_OnClick @5-D3FDA819
function tbl_documentacaoButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_documentacaoButton_Delete_OnClick

//bind_events @1-BFDACE8D
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_documentacaoButton_Delete", "click", tbl_documentacaoButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_documentacao'>
<form id="tbl_documentacao" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post" enctype="<ccs:form_enctype/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Documentacao </strong></td> 
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
            <td class="th"><label for="tbl_documentacaoAnexo">Anexo</label></td> 
            <td>
              <ccs:upload name='FileUpload1'><input id="tbl_documentacaoFileUpload1ControlName" type="hidden" value="<ccs:upload_property name='state'/>" name="<ccs:upload_property name='name'/>">
              <ccs:upload_info>&nbsp;<ccs:upload_property name='filename'/>&nbsp;<ccs:upload_property name='filesize'/>&nbsp;bytes.</ccs:upload_info>
              <ccs:upload_prompt><label for="tbl_documentacaoFileUpload1FileControl" style="display: none;">File upload</label><input id="tbl_documentacaoFileUpload1FileControl" type="file" name="<ccs:upload_property name='filecontrol'/>"></ccs:upload_prompt>
              <ccs:upload_delete><label for="tbl_documentacaoFileUpload1DeleteControl">Delete</label><input id="tbl_documentacaoFileUpload1DeleteControl" type="checkbox" name="<ccs:upload_property name='deletename'/>" <ccs:upload_property name='delchecked'/>></ccs:upload_delete></ccs:upload></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_documentacaoTipo_Doc">Tipo de Documento</label></td> 
            <td><input id="tbl_documentacaoTipo_Doc" maxlength="10" size="10" value="<ccs:control name='Tipo_Doc'/>" name="<ccs:control name='Tipo_Doc' property='name'/>"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_documentacaoCod_Cliente">Cliente</label></td> 
            <td><input id="tbl_documentacaoCod_Cliente" maxlength="10" size="10" value="<ccs:control name='Cod_Cliente'/>" name="<ccs:control name='Cod_Cliente' property='name'/>"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_documentacaoCod_Fiador">Fiador</label></td> 
            <td><input id="tbl_documentacaoCod_Fiador" maxlength="10" size="10" value="<ccs:control name='Cod_Fiador'/>" name="<ccs:control name='Cod_Fiador' property='name'/>"></td> 
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_documentacaoButton_Insert" type="submit" alt="Add" value="Add" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_documentacaoButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_documentacaoButton_Delete" type="submit" alt="Delete" value="Delete" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-CF0D8090--%>
<%ManterDocumentacaoModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-207B7E6E--%>
<%ManterDocumentacaoModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

