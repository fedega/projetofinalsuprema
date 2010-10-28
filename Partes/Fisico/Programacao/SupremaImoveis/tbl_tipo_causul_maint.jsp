<%--JSP Page Init @1-276E3460--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_tipo_causul_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-BF51C864--%>
<%@include file="tbl_tipo_causul_maintHandlers.jsp"%>
<%
    if (!tbl_tipo_causul_maintModel.isVisible()) return;
    if (tbl_tipo_causul_maintParent != null) {
        if (!tbl_tipo_causul_maintParent.getChild(tbl_tipo_causul_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_tipo_causul_maintModel);
    pageContext.setAttribute("page", tbl_tipo_causul_maintModel);
    tbl_tipo_causul_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_tipo_causul_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_tipo_causul_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-1F97F762--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Tipo Causula</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_tipo_causula'>
<form id="tbl_tipo_causula" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Tipo Causula </strong></td> 
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
            <td class="th"><label for="tbl_tipo_causulaTipo">Tipo</label></td> 
            <td><input type="text" name="<ccs:control name='Tipo' property='name'/>" value="<ccs:control name='Tipo'/>" maxlength="40" size="40" id="tbl_tipo_causulaTipo"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_tipo_causulaButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_tipo_causulaButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_tipo_causulaButton_Delete" class="Button"></ccs:button></td> 
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

<%--JSP Page BeforeOutput @1-1FABA276--%>
<%tbl_tipo_causul_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-F0DD5C88--%>
<%tbl_tipo_causul_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

