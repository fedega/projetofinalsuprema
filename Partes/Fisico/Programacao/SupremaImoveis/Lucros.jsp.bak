<%--JSP Page Init @1-18C77692--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new LucrosServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-98E56208--%>
<%@include file="LucrosHandlers.jsp"%>
<%
    if (!LucrosModel.isVisible()) return;
    if (LucrosParent != null) {
        if (!LucrosParent.getChild(LucrosModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", LucrosModel);
    pageContext.setAttribute("page", LucrosModel);
    LucrosModel.fireOnInitializeViewEvent(new Event());
    LucrosModel.fireBeforeShowEvent(new Event());
    if (!LucrosModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-E3DEEE82--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Lucros</title>
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
<p>&nbsp; 
<ccs:report name='Novo'>
<h2>Novo </h2>
<p>
<table>
  <ccs:report_repeater><ccs:section group='Report' type='Header'></ccs:section>
  <ccs:section group='Page' type='Header'>
  <tr>
    <th scope="col">Label1</th>
 
    <th scope="col">Label2</th>
 
    <th scope="col">Label3</th>
 
    <th scope="col">Label4</th>
  </tr>
 </ccs:section>
  <ccs:section group='Page' type='Footer'>
  <tr>
    <td><ccs:control name='Report_CurrentDate'/></td> 
    <td style="TEXT-ALIGN: right" colspan="3">Pagina <ccs:control name='Report_CurrentPage'/> de <ccs:control name='Report_TotalPages'/></td>
  </tr>
 </ccs:section>
  <ccs:report_detail>
  <tr>
    <td><ccs:control name='Label1'/> </td> 
    <td><ccs:control name='Label2'/> </td> 
    <td><ccs:control name='Label3'/> </td> 
    <td><ccs:control name='Label4'/> </td>
  </tr>
 </ccs:report_detail>
  <ccs:section group='Report' type='Footer'>
  <ccs:panel name='NoRecords'>
  <tr>
    <td colspan="4">Sem registros</td>
  </tr>
 </ccs:panel></ccs:section></ccs:report_repeater>
</table>
&nbsp;</p>
</ccs:report></p>
<p><br>
&nbsp;</p>
<p><br>
&nbsp;</p>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-6B07C0A6--%>
<%LucrosModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-84713E58--%>
<%LucrosModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

