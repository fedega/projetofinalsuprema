<%--JSP Page Init @1-9C61F306--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new HeaderServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-C6A8CD9C--%>
<%@include file="HeaderHandlers.jsp"%>
<%
    if (!HeaderModel.isVisible()) return;
    if (HeaderParent != null) {
        if (!HeaderParent.getChild(HeaderModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", HeaderModel);
    pageContext.setAttribute("page", HeaderModel);
    HeaderModel.fireOnInitializeViewEvent(new Event());
    HeaderModel.fireBeforeShowEvent(new Event());
    if (!HeaderModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-18D6CDE8--%>
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<form method="post">
  &nbsp;
</form>

<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-A0A34D6D--%>
<%HeaderModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-4FD5B393--%>
<%HeaderModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

