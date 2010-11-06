<%--JSP Page Init @1-AD499744--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ImoveisServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-DF281FB7--%>
<%@include file="ImoveisHandlers.jsp"%>
<%
    if (!ImoveisModel.isVisible()) return;
    if (ImoveisParent != null) {
        if (!ImoveisParent.getChild(ImoveisModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ImoveisModel);
    pageContext.setAttribute("page", ImoveisModel);
    ImoveisModel.fireOnInitializeViewEvent(new Event());
    ImoveisModel.fireBeforeShowEvent(new Event());
    if (!ImoveisModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-29FD35DD--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Ganhos</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
&nbsp;&nbsp;&nbsp; 
<ccs:flash_chart name='FlashChart1'>
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="<ccs:flash_chart_property name="Width" />" height="<ccs:flash_chart_property name="Height" />" accesskey="q" tabindex="1" title="<ccs:flash_chart_property name="Title" />">
  <param name="movie" value="<ccs:flash_chart_property name="Src" />" />
  <param name="quality" value="high" />
  <param name="wmode" value="transparent" />
  <param name="scale" value="exactfit" />
  <embed src="<ccs:flash_chart_property name="Src" />" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="<ccs:flash_chart_property name="Width" />" height="<ccs:flash_chart_property name="Height" />" scale="exactfit" wmode="transparent"></embed>
 
</object>
</ccs:flash_chart>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-CA108F1C--%>
<%ImoveisModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-256671E2--%>
<%ImoveisModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

