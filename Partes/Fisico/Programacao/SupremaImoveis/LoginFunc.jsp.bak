<%--JSP Page Init @1-B2ED0075--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new LoginFuncServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-E70D39EA--%>
<%@include file="LoginFuncHandlers.jsp"%>
<%
    if (!LoginFuncModel.isVisible()) return;
    if (LoginFuncParent != null) {
        if (!LoginFuncParent.getChild(LoginFuncModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", LoginFuncModel);
    pageContext.setAttribute("page", LoginFuncModel);
    LoginFuncModel.fireOnInitializeViewEvent(new Event());
    LoginFuncModel.fireBeforeShowEvent(new Event());
    if (!LoginFuncModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-B473B6B2--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Login</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
&nbsp;
<ccs:record name='Login'>
<form id="Login" method="post" name="<ccs:form_name/>" action="<ccs:form_action/>">
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
        <table class="Header" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
            <td class="th"><strong>Entrar</strong></td> 
            <td class="HeaderRight"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td>
          </tr>
        </table>
 
        <table class="Record" cellspacing="0" cellpadding="0">
          <ccs:error_block>
          <tr class="Error">
            <td colspan="2"><ccs:error_text/></td>
          </tr>
          </ccs:error_block>
          <tr class="Controls">
            <td class="th"><label for="Loginlogin">Entrar</label></td> 
            <td><input id="Loginlogin" value="<ccs:control name='login'/>" maxlength="100" name="<ccs:control name='login' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="Loginpassword">Senha</label></td> 
            <td><input id="Loginpassword" value="<ccs:control name='password'/>" maxlength="100" type="password" name="<ccs:control name='password' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoLogin'><input id="LoginButton_DoLogin" class="Button" value="Entrar" alt="Entrar" type="submit" name="<ccs:control name='Button_DoLogin' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-08B281BA--%>
<%LoginFuncModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-E7C47F44--%>
<%LoginFuncModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

