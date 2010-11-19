<%--JSP Page Init @1-201E9C7D--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new NewPage1ServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-CF0ED243--%>
<%@include file="NewPage1Handlers.jsp"%>
<%
    if (!NewPage1Model.isVisible()) return;
    if (NewPage1Parent != null) {
        if (!NewPage1Parent.getChild(NewPage1Model.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", NewPage1Model);
    pageContext.setAttribute("page", NewPage1Model);
    NewPage1Model.fireOnInitializeViewEvent(new Event());
    NewPage1Model.fireBeforeShowEvent(new Event());
    if (!NewPage1Model.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-8AB7774B--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>NewPage1</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<p>oi</p>
<p>&nbsp;</p>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-36ABC20D--%>
<%NewPage1Model.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-D9DD3CF3--%>
<%NewPage1Model.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

