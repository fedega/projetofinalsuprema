<%--JSP Page Init @1-420592FF--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new LoginServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-A88C98B0--%>
<%@include file="LoginHandlers.jsp"%>
<%
    if (!LoginModel.isVisible()) return;
    if (LoginParent != null) {
        if (!LoginParent.getChild(LoginModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", LoginModel);
    pageContext.setAttribute("page", LoginModel);
    LoginModel.fireOnInitializeViewEvent(new Event());
    LoginModel.fireBeforeShowEvent(new Event());
    if (!LoginModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-DD9E926A--%>
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
<form id="Login" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Autenticação</strong></td> 
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
            <td class="th"><label for="Loginlogin">Usuario</label></td> 
            <td><input id="Loginlogin" maxlength="100" value="<ccs:control name='login'/>" name="<ccs:control name='login' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="Loginpassword">Senha</label></td> 
            <td><input id="Loginpassword" type="password" maxlength="100" value="<ccs:control name='password'/>" name="<ccs:control name='password' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_DoLogin'><input class="Button" id="LoginButton_DoLogin" type="submit" alt="Entrar" value="Entrar" name="<ccs:control name='Button_DoLogin' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-02F51B26--%>
<%LoginModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-ED83E5D8--%>
<%LoginModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

