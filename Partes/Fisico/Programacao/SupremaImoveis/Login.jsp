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

<%--JSP Page Content @1-C170CA6F--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='Login'>
<form id="Login" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Entrar</strong></td> 
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
            <td class="th"><label for="Loginlogin">Entrar</label></td> 
            <td><input type="text" name="<ccs:control name='login' property='name'/>" value="<ccs:control name='login'/>" maxlength="100" size="20" id="Loginlogin"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="Loginpassword">Senha</label></td> 
            <td><input type="password" name="<ccs:control name='password' property='name'/>" value="<ccs:control name='password'/>" maxlength="100" size="20" id="Loginpassword"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_DoLogin'><input name="<ccs:control name='Button_DoLogin' property='name'/>" type="submit" value="Entrar" alt="Entrar" id="LoginButton_DoLogin" class="Button"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record><jsp:include page="/Footer.jsp" flush="true"/>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-02F51B26--%>
<%LoginModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-ED83E5D8--%>
<%LoginModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

