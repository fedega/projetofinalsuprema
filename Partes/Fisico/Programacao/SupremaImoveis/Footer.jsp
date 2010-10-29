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

<%--JSP Page Content @1-437F2DC1--%>

<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-6F24C0B3
</script>
<script language="JavaScript" src="<ccs:page property='CCS_PathToRoot'/>ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//Include User Scripts @1-A07D7F07
</script>
<script language="JavaScript" src="<ccs:page property='CCS_PathToRoot'/>js/menu/WCH.js" type="text/javascript"></script>
<script language="JavaScript" src="<ccs:page property='CCS_PathToRoot'/>js/menu/ADxMenu.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<ccs:page property='CCS_PathToRoot'/>Styles/adx.css">
<link rel="stylesheet" type="text/css" href="<ccs:page property='CCS_PathToRoot'/>Styles/Padrao/Menu.css">
<script language="JavaScript" type="text/javascript">
//End Include User Scripts

//bind_events @1-141E55C8
function Footer_bind_events() {
    addEventHandler("FooterMenu1Container", "load", load_ADxMenu);
}
//End bind_events

//End CCS script
</script>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<center>
<p>
<ccs:menu name="Menu1">
<div class="MenuStyle" id="FooterMenu1Container">
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
</ccs:menu>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
<p>Prototipo de monografia ceubão - Suprema Imoveis</p>
<center>
</center>
</center>

<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-7CBF30AD--%>
<%FooterModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-93C9CE53--%>
<%FooterModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

