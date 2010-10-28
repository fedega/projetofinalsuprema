<%--JSP Page Init @1-7A4F3125--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_documentaca_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-84FFD81C--%>
<%@include file="tbl_documentaca_maintHandlers.jsp"%>
<%
    if (!tbl_documentaca_maintModel.isVisible()) return;
    if (tbl_documentaca_maintParent != null) {
        if (!tbl_documentaca_maintParent.getChild(tbl_documentaca_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_documentaca_maintModel);
    pageContext.setAttribute("page", tbl_documentaca_maintModel);
    tbl_documentaca_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_documentaca_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_documentaca_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-F5525377--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Documentacao</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_documentacao'>
<form id="tbl_documentacao" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Documentacao </strong></td> 
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
            <td class="th"><label for="tbl_documentacaoAnexo">Anexo</label></td> 
            <td><textarea name="<ccs:control name='Anexo' property='name'/>" cols="50" rows="3" id="tbl_documentacaoAnexo"><ccs:control name='Anexo'/></textarea></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_documentacaoTipo_Doc">Tipo Doc</label></td> 
            <td><input type="text" name="<ccs:control name='Tipo_Doc' property='name'/>" value="<ccs:control name='Tipo_Doc'/>" maxlength="10" size="10" id="tbl_documentacaoTipo_Doc"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_documentacaoCod_Cliente">Cod Cliente</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cliente' property='name'/>" value="<ccs:control name='Cod_Cliente'/>" maxlength="10" size="10" id="tbl_documentacaoCod_Cliente"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_documentacaoCod_Fiador">Cod Fiador</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Fiador' property='name'/>" value="<ccs:control name='Cod_Fiador'/>" maxlength="10" size="10" id="tbl_documentacaoCod_Fiador"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_documentacaoButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_documentacaoButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_documentacaoButton_Delete" class="Button"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-208F3351--%>
<%tbl_documentaca_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-CFF9CDAF--%>
<%tbl_documentaca_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

