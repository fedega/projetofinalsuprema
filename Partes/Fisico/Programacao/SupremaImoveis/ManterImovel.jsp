<%--JSP Page Init @1-A9AC3E3E--%>
<%@page import="com.codecharge.*,com.codecharge.components.*,com.codecharge.util.*,com.codecharge.events.*,com.codecharge.db.*,com.codecharge.validation.*,java.util.*,java.io.*,com.codecharge.util.cache.CacheEvent,com.codecharge.util.cache.ICache,com.codecharge.template.*"%>
<%if ((new ManterImovelServiceChecker()).check(request, response, getServletContext())) return;%>
<%@page contentType="text/html; charset=windows-1252"%>
<%@taglib uri="/ccstags" prefix="ccs"%>
<%--End JSP Page Init--%>

<%--Page Body @1-F64785B8--%>
<%@include file="ManterImovelHandlers.jsp"%>
<%
    if (!ManterImovelModel.isVisible()) return;
    if (ManterImovelParent != null) {
        if (!ManterImovelParent.getChild(ManterImovelModel.getName()).isVisible()) return;
    }
    pageContext.setAttribute("parent", ManterImovelModel);
    pageContext.setAttribute("page", ManterImovelModel);
    ManterImovelModel.fireOnInitializeViewEvent(new Event());
    ManterImovelModel.fireBeforeShowEvent(new Event());
    if (!ManterImovelModel.isVisible()) return;
%>
<%--End Page Body--%>

<%--JSP Page Content @1-5851F4DA--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Imovel</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<ccs:record name='tbl_imovel'>
<form id="tbl_imovel" method="post" name="<ccs:form_name/>" action="<ccs:form_action/>">
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
        <table class="Header" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="HeaderLeft"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td> 
            <td class="th"><strong>Adicionar/Editar Imóvel </strong></td> 
            <td class="HeaderRight"><img border="0" alt="" src="Styles/Padrao/Images/Spacer.gif"></td>
          </tr>
        </table>
 
        <table class="Record" cellspacing="0" cellpadding="0">
          <ccs:error_block>
          <tr class="Error">
            <td colspan="2"><ccs:error_text/></td>
          </tr>
          </ccs:error_block>
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Cliente">Cliente</label></td> 
            <td><input id="tbl_imovelCod_Cliente" value="<ccs:control name='Cod_Cliente'/>" maxlength="10" size="10" name="<ccs:control name='Cod_Cliente' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Funcionario">Funcionario</label></td> 
            <td><input id="tbl_imovelCod_Funcionario" value="<ccs:control name='Cod_Funcionario'/>" maxlength="10" size="10" name="<ccs:control name='Cod_Funcionario' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Situacao">Situacao</label></td> 
            <td><input id="tbl_imovelCod_Situacao" value="<ccs:control name='Cod_Situacao'/>" maxlength="10" size="10" name="<ccs:control name='Cod_Situacao' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_destinacao">Destinacao</label></td> 
            <td><input id="tbl_imovelCod_destinacao" value="<ccs:control name='Cod_destinacao'/>" maxlength="10" size="10" name="<ccs:control name='Cod_destinacao' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelEndereco">Endereco</label></td> 
            <td><input id="tbl_imovelEndereco" value="<ccs:control name='Endereco'/>" maxlength="40" size="40" name="<ccs:control name='Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCEP">CEP</label></td> 
            <td><input id="tbl_imovelCEP" value="<ccs:control name='CEP'/>" maxlength="10" size="10" name="<ccs:control name='CEP' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelBairro">Bairro</label></td> 
            <td><input id="tbl_imovelBairro" value="<ccs:control name='Bairro'/>" maxlength="20" name="<ccs:control name='Bairro' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Estado">Estado</label></td> 
            <td><input id="tbl_imovelCod_Estado" value="<ccs:control name='Cod_Estado'/>" maxlength="10" size="10" name="<ccs:control name='Cod_Estado' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Cidade">Cidade</label></td> 
            <td><input id="tbl_imovelCod_Cidade" value="<ccs:control name='Cod_Cidade'/>" maxlength="10" size="10" name="<ccs:control name='Cod_Cidade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Quartos">N° Quartos</label></td> 
            <td><input id="tbl_imovelN_Quartos" value="<ccs:control name='N_Quartos'/>" maxlength="10" size="10" name="<ccs:control name='N_Quartos' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Suites">N° Suites</label></td> 
            <td><input id="tbl_imovelN_Suites" value="<ccs:control name='N_Suites'/>" maxlength="10" size="10" name="<ccs:control name='N_Suites' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Banheiros">N° Banheiros</label></td> 
            <td><input id="tbl_imovelN_Banheiros" value="<ccs:control name='N_Banheiros'/>" maxlength="10" size="10" name="<ccs:control name='N_Banheiros' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Salas">N° Salas</label></td> 
            <td><input id="tbl_imovelN_Salas" value="<ccs:control name='N_Salas'/>" maxlength="10" size="10" name="<ccs:control name='N_Salas' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Cozinhas">N° Cozinhas</label></td> 
            <td><input id="tbl_imovelN_Cozinhas" value="<ccs:control name='N_Cozinhas'/>" maxlength="10" size="10" name="<ccs:control name='N_Cozinhas' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelDep_Empregada">Dependencia de&nbsp;Empregada</label></td> 
            <td><input id="tbl_imovelDep_Empregada" value="1" type="checkbox" name="<ccs:control name='Dep_Empregada' property='name'/>" <ccs:control name='Dep_Empregada'/>></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelGaragem">Garagem</label></td> 
            <td><input id="tbl_imovelGaragem" value="1" type="checkbox" name="<ccs:control name='Garagem' property='name'/>" <ccs:control name='Garagem'/>></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelMts_Quadrados">Metros Quadrados</label></td> 
            <td><input id="tbl_imovelMts_Quadrados" value="<ccs:control name='Mts_Quadrados'/>" maxlength="10" size="10" name="<ccs:control name='Mts_Quadrados' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td colspan="2" align="right">
              <ccs:button name='Button_Insert'><input id="tbl_imovelButton_Insert" class="Button" value="Adicionar" alt="Add" type="submit" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input id="tbl_imovelButton_Update" class="Button" value="Atualizar" alt="Atualizar" type="submit" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input id="tbl_imovelButton_Delete" class="Button" value="Apagar" alt="Delete" type="submit" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</ccs:record><br>
</body>
</html>
<%--End JSP Page Content--%>

<%--JSP Page BeforeOutput @1-C3933CA5--%>
<%ManterImovelModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-2CE5C25B--%>
<%ManterImovelModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

