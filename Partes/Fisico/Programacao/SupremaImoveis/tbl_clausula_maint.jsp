<%--JSP Page Init @1-CC6E9D97--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_clausula_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-2D16AD70--%>
<%@include file="tbl_clausula_maintHandlers.jsp"%>
<%
    if (!tbl_clausula_maintModel.isVisible()) return;
    if (tbl_clausula_maintParent != null) {
        if (!tbl_clausula_maintParent.getChild(tbl_clausula_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_clausula_maintModel);
    pageContext.setAttribute("page", tbl_clausula_maintModel);
    tbl_clausula_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_clausula_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_clausula_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-FFF6A98D--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Clausula</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_clausula'>
<form id="tbl_clausula" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Clausula </strong></td> 
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
            <td class="th"><label for="tbl_clausulaTipo">Tipo</label></td> 
            <td><input type="text" name="<ccs:control name='Tipo' property='name'/>" value="<ccs:control name='Tipo'/>" maxlength="10" size="10" id="tbl_clausulaTipo"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clausulaDescricao">Descricao</label></td> 
            <td><input type="text" name="<ccs:control name='Descricao' property='name'/>" value="<ccs:control name='Descricao'/>" maxlength="250" size="50" id="tbl_clausulaDescricao"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_clausulaCod_Contrato">Cod Contrato</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Contrato' property='name'/>" value="<ccs:control name='Cod_Contrato'/>" maxlength="10" size="10" id="tbl_clausulaCod_Contrato"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_clausulaButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_clausulaButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_clausulaButton_Delete" class="Button"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-4ADBC7E8--%>
<%tbl_clausula_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-A5AD3916--%>
<%tbl_clausula_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

