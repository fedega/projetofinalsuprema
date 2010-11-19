<%--JSP Page Init @1-EA7F8BC1--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new SuporteServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-44C979D0--%>
<%@include file="SuporteHandlers.jsp"%>
<%
    if (!SuporteModel.isVisible()) return;
    if (SuporteParent != null) {
        if (!SuporteParent.getChild(SuporteModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", SuporteModel);
    pageContext.setAttribute("page", SuporteModel);
    SuporteModel.fireOnInitializeViewEvent(new Event());
    SuporteModel.fireBeforeShowEvent(new Event());
    if (!SuporteModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-1AFF5B8C--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Suporte</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-CE0F0269
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Include User Scripts @1-C694825E
</script>
<script language="JavaScript" src="js/menu/WCH.js" type="text/javascript"></script>
<script language="JavaScript" src="js/menu/ADxMenu.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="Styles/adx.css">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Menu.css">
<script language="JavaScript" type="text/javascript">
//End Include User Scripts

//bind_events @1-F1738049
function bind_events() {
    addEventHandler("Menu1Container", "load", load_ADxMenu);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<form method="post">
  <h1 align="center"><font size="7" face="Times New Roman"><em>SUPREMA IMOVEIS</em></font></h1>
  <p></p>
  <hr>
  <ccs:menu name="Menu1">
  <div class="MenuStyle" id="Menu1Container">
    <ul class="adxm <ccs:attribute owner = 'Menu1' name = 'MenuType' /> level1">
      <ccs:menu_iterator>
      <ccs:menu_block name="OpenLevel" >
      <ul class="level<ccs:attribute owner = 'Menu1' name = 'Item_Level' />">
        </ccs:menu_block>
        <li><a href="<ccs:control name='ItemLink' property='href'/>" class="<ccs:attribute owner = 'Menu1' name = 'Submenu' />" target="<ccs:attribute owner = 'Menu1' name = 'Target' />" title="<ccs:attribute owner = 'Menu1' name = 'Title' />"><ccs:control name='ItemLink'/></a> 
        <ccs:menu_block name="CloseItem" ></li>
 </ccs:menu_block>
        <ccs:menu_block name="CloseLevel" >
      </ul>
 </li>
 </ccs:menu_block></ccs:menu_iterator>
    </ul>
 
  </div>
 </ccs:menu>
  <p></p>
</form>
<p></p>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-BE8C3D07--%>
<%SuporteModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-51FAC3F9--%>
<%SuporteModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

