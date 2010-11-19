<%--JSP Page Init @1-71971C22--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new TransConcluidasServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-BBCBF8A7--%>
<%@include file="TransConcluidasHandlers.jsp"%>
<%
    if (!TransConcluidasModel.isVisible()) return;
    if (TransConcluidasParent != null) {
        if (!TransConcluidasParent.getChild(TransConcluidasModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", TransConcluidasModel);
    pageContext.setAttribute("page", TransConcluidasModel);
    TransConcluidasModel.fireOnInitializeViewEvent(new Event());
    TransConcluidasModel.fireBeforeShowEvent(new Event());
    if (!TransConcluidasModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-CDD3CCD2--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>TransConcluidas</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-CE0F0269
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//bind_events @1-4A8114A8
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<p><jsp:include page="/Header.jsp" flush="true"/></p>
<p>
<ccs:flash_chart name='FlashChart1'>
<object title="<ccs:flash_chart_property name="Title" />" tabindex="1" accesskey="q" height="<ccs:flash_chart_property name="Height" />" width="<ccs:flash_chart_property name="Width" />" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000">
  <param name="movie" value="<ccs:flash_chart_property name="Src" />" />
  <param name="quality" value="high" />
  <param name="wmode" value="transparent" />
  <param name="scale" value="exactfit" />
  <embed src="<ccs:flash_chart_property name="Src" />" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="<ccs:flash_chart_property name="Width" />" height="<ccs:flash_chart_property name="Height" />" scale="exactfit" wmode="transparent"></embed>
 
</object>
</ccs:flash_chart></p>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-19A5D725--%>
<%TransConcluidasModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-F6D329DB--%>
<%TransConcluidasModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

