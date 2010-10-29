<%--JSP Page Init @1-338DD1D6--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new tbl_imovel_maintServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-83D244EA--%>
<%@include file="tbl_imovel_maintHandlers.jsp"%>
<%
    if (!tbl_imovel_maintModel.isVisible()) return;
    if (tbl_imovel_maintParent != null) {
        if (!tbl_imovel_maintParent.getChild(tbl_imovel_maintModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", tbl_imovel_maintModel);
    pageContext.setAttribute("page", tbl_imovel_maintModel);
    tbl_imovel_maintModel.fireOnInitializeViewEvent(new Event());
    tbl_imovel_maintModel.fireBeforeShowEvent(new Event());
    if (!tbl_imovel_maintModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-D995FC2F--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<ccs:meta header="Content-Type"/>
<title>Tbl Imovel</title>
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//Include Common JSFunctions @1-CE0F0269
</script>
<script language="JavaScript" src="ClientI18N.jsp?file=Functions.js&amp;locale=<ccs:message key="CCS_LocaleID"/>" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">
//End Include Common JSFunctions

//tbl_imovelButton_Delete_OnClick @5-1AFBB6F1
function tbl_imovelButton_Delete_OnClick()
{
    disableValidation = true;
}
//End tbl_imovelButton_Delete_OnClick

//bind_events @1-2DA8D1BA
function bind_events() {
    if (functionExists("Header_bind_events")) Header_bind_events();
    if (functionExists("Footer_bind_events")) Footer_bind_events();
    addEventHandler("tbl_imovelButton_Delete", "click", tbl_imovelButton_Delete_OnClick);
}
//End bind_events

window.onload = bind_events; //Assign bind_events @1-19F7B649

//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/>
<ccs:record name='tbl_imovel'>
<form id="tbl_imovel" method="post" action="<ccs:form_action/>" name="<ccs:form_name/>">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table cellspacing="0" cellpadding="0" border="0" class="Header">
          <tr>
            <td class="HeaderLeft"><img border="0" src="Styles/Padrao/Images/Spacer.gif" alt=""></td> 
            <td class="th"><strong>Adicionar/Editar Tbl Imovel </strong></td> 
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
            <td class="th"><label for="tbl_imovelCod_Cliente">Cod Cliente</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cliente' property='name'/>" value="<ccs:control name='Cod_Cliente'/>" maxlength="10" size="10" id="tbl_imovelCod_Cliente"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Funcionario">Cod Funcionario</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Funcionario' property='name'/>" value="<ccs:control name='Cod_Funcionario'/>" maxlength="10" size="10" id="tbl_imovelCod_Funcionario"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Situacao">Cod Situacao</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Situacao' property='name'/>" value="<ccs:control name='Cod_Situacao'/>" maxlength="10" size="10" id="tbl_imovelCod_Situacao"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_destinacao">Cod Destinacao</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_destinacao' property='name'/>" value="<ccs:control name='Cod_destinacao'/>" maxlength="10" size="10" id="tbl_imovelCod_destinacao"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelEndereco">Endereco</label></td> 
            <td><input type="text" name="<ccs:control name='Endereco' property='name'/>" value="<ccs:control name='Endereco'/>" maxlength="40" size="40" id="tbl_imovelEndereco"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCEP">CEP</label></td> 
            <td><input type="text" name="<ccs:control name='CEP' property='name'/>" value="<ccs:control name='CEP'/>" maxlength="10" size="10" id="tbl_imovelCEP"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelBairro">Bairro</label></td> 
            <td><input type="text" name="<ccs:control name='Bairro' property='name'/>" value="<ccs:control name='Bairro'/>" maxlength="20" size="20" id="tbl_imovelBairro"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Estado">Cod Estado</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Estado' property='name'/>" value="<ccs:control name='Cod_Estado'/>" maxlength="10" size="10" id="tbl_imovelCod_Estado"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Cidade">Cod Cidade</label></td> 
            <td><input type="text" name="<ccs:control name='Cod_Cidade' property='name'/>" value="<ccs:control name='Cod_Cidade'/>" maxlength="10" size="10" id="tbl_imovelCod_Cidade"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Quartos">N Quartos</label></td> 
            <td><input type="text" name="<ccs:control name='N_Quartos' property='name'/>" value="<ccs:control name='N_Quartos'/>" maxlength="10" size="10" id="tbl_imovelN_Quartos"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Suites">N Suites</label></td> 
            <td><input type="text" name="<ccs:control name='N_Suites' property='name'/>" value="<ccs:control name='N_Suites'/>" maxlength="10" size="10" id="tbl_imovelN_Suites"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Banheiros">N Banheiros</label></td> 
            <td><input type="text" name="<ccs:control name='N_Banheiros' property='name'/>" value="<ccs:control name='N_Banheiros'/>" maxlength="10" size="10" id="tbl_imovelN_Banheiros"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Salas">N Salas</label></td> 
            <td><input type="text" name="<ccs:control name='N_Salas' property='name'/>" value="<ccs:control name='N_Salas'/>" maxlength="10" size="10" id="tbl_imovelN_Salas"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Cozinhas">N Cozinhas</label></td> 
            <td><input type="text" name="<ccs:control name='N_Cozinhas' property='name'/>" value="<ccs:control name='N_Cozinhas'/>" maxlength="10" size="10" id="tbl_imovelN_Cozinhas"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelDep_Empregada">Dep Empregada</label></td> 
            <td><input type="checkbox" name="<ccs:control name='Dep_Empregada' property='name'/>" value="1" <ccs:control name='Dep_Empregada'/> id="tbl_imovelDep_Empregada"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelGaragem">Garagem</label></td> 
            <td><input type="checkbox" name="<ccs:control name='Garagem' property='name'/>" value="1" <ccs:control name='Garagem'/> id="tbl_imovelGaragem"></td> 
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelMts_Quadrados">Mts Quadrados</label></td> 
            <td><input type="text" name="<ccs:control name='Mts_Quadrados' property='name'/>" value="<ccs:control name='Mts_Quadrados'/>" maxlength="10" size="10" id="tbl_imovelMts_Quadrados"></td> 
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input name="<ccs:control name='Button_Insert' property='name'/>" type="submit" value="Add" alt="Add" id="tbl_imovelButton_Insert" class="Button"></ccs:button>
              <ccs:button name='Button_Update'><input name="<ccs:control name='Button_Update' property='name'/>" type="submit" value="Atualizar" alt="Atualizar" id="tbl_imovelButton_Update" class="Button"></ccs:button>
              <ccs:button name='Button_Delete'><input name="<ccs:control name='Button_Delete' property='name'/>" type="submit" value="Delete" alt="Delete" id="tbl_imovelButton_Delete" class="Button"></ccs:button></td> 
          </tr>
 
        </table>
 </td> 
    </tr>
 
  </table>
</form>
</ccs:record><br>
<jsp:include page="/Footer.jsp" flush="true"/>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-06F9615B--%>
<%tbl_imovel_maintModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-E98F9FA5--%>
<%tbl_imovel_maintModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

