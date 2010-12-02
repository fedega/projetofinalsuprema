<%--JSP Page Init @1-B006DC05--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new LocadorPagServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-770668C8--%>
<%@include file="LocadorPagHandlers.jsp"%>
<%
    if (!LocadorPagModel.isVisible()) return;
    if (LocadorPagParent != null) {
        if (!LocadorPagParent.getChild(LocadorPagModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", LocadorPagModel);
    pageContext.setAttribute("page", LocadorPagModel);
    LocadorPagModel.fireOnInitializeViewEvent(new Event());
    LocadorPagModel.fireBeforeShowEvent(new Event());
    if (!LocadorPagModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-458C472A--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>LocadorPag</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<ccs:grid name='AcompanhamentodePendencias'>
<h2>Acompanhamento de Pendencias</h2>
<table>
  <tr>
    <th scope="col">N°</th>
 
    <th scope="col">Tipo</th>
 
    <th scope="col">Valor</th>
 
    <th scope="col">Situação</th>
  </tr>
 
  <ccs:repeater><ccs:row>
  <tr>
    <td>&nbsp; 1</td> 
    <td>&nbsp;Aluguel</td> 
    <td>&nbsp;1.200,00</td> 
    <td>&nbsp;Em Andamento</td>
  </tr>
 </ccs:row></ccs:repeater>
  <ccs:norecords>
  <tr>
    <td colspan="4">Sem registros</td>
  </tr>
  </ccs:norecords>
</table>
</ccs:grid>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-035D9595--%>
<%LocadorPagModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-EC2B6B6B--%>
<%LocadorPagModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

