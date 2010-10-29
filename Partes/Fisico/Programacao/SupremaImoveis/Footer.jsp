<%--JSP Page Init @1-D880EB1F--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new FooterServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-3E224F59--%>
<%@include file="FooterHandlers.jsp"%>
<%
    if (!FooterModel.isVisible()) return;
    if (FooterParent != null) {
        if (!FooterParent.getChild(FooterModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", FooterModel);
    pageContext.setAttribute("page", FooterModel);
    FooterModel.fireOnInitializeViewEvent(new Event());
    FooterModel.fireBeforeShowEvent(new Event());
    if (!FooterModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-168A667A--%>
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
<center><p>Prototipo de monografia ceubão - Suprema Imoveis</p><center>

<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-7CBF30AD--%>
<%FooterModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-93C9CE53--%>
<%FooterModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

