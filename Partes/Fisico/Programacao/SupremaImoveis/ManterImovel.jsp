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

<%--JSP Page Content @1-1C247D69--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<ccs:meta header="Content-Type"/>
<title>Tbl Imovel</title>
<meta name="GENERATOR" content="CodeCharge Studio 4.3.00.7676">
<link rel="stylesheet" type="text/css" href="Styles/Padrao/Style_doctype.css">
<script language="JavaScript" type="text/javascript">
//Begin CCS script
//End CCS script
</script>
</head>
<body>
<jsp:include page="/Header.jsp" flush="true"/> 
<ccs:record name='tbl_imovel'>
<form id="tbl_imovel" name="<ccs:form_name/>" action="<ccs:form_action/>" method="post">
  <table cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td valign="top">
        <table class="Header" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td class="HeaderLeft"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td> 
            <td class="th"><strong>Adicionar/Editar Imovel </strong></td> 
            <td class="HeaderRight"><img alt="" src="Styles/Padrao/Images/Spacer.gif" border="0"></td>
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
            <td><input id="tbl_imovelCod_Cliente" maxlength="10" size="10" value="<ccs:control name='Cod_Cliente'/>" name="<ccs:control name='Cod_Cliente' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Funcionario">Funcionario</label></td> 
            <td><input id="tbl_imovelCod_Funcionario" maxlength="10" size="10" value="<ccs:control name='Cod_Funcionario'/>" name="<ccs:control name='Cod_Funcionario' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Situacao">Situacao</label></td> 
            <td><input id="tbl_imovelCod_Situacao" maxlength="10" size="10" value="<ccs:control name='Cod_Situacao'/>" name="<ccs:control name='Cod_Situacao' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_destinacao">Destinacao</label></td> 
            <td><input id="tbl_imovelCod_destinacao" maxlength="10" size="10" value="<ccs:control name='Cod_destinacao'/>" name="<ccs:control name='Cod_destinacao' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelEndereco">Endereco</label></td> 
            <td><input id="tbl_imovelEndereco" maxlength="40" size="40" value="<ccs:control name='Endereco'/>" name="<ccs:control name='Endereco' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCEP">CEP</label></td> 
            <td><input id="tbl_imovelCEP" maxlength="10" size="10" value="<ccs:control name='CEP'/>" name="<ccs:control name='CEP' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelBairro">Bairro</label></td> 
            <td><input id="tbl_imovelBairro" maxlength="20" value="<ccs:control name='Bairro'/>" name="<ccs:control name='Bairro' property='name'/>" size="20"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Estado">Estado</label></td> 
            <td><input id="tbl_imovelCod_Estado" maxlength="10" size="10" value="<ccs:control name='Cod_Estado'/>" name="<ccs:control name='Cod_Estado' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelCod_Cidade">Cidade</label></td> 
            <td><input id="tbl_imovelCod_Cidade" maxlength="10" size="10" value="<ccs:control name='Cod_Cidade'/>" name="<ccs:control name='Cod_Cidade' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Quartos">N° Quartos</label></td> 
            <td><input id="tbl_imovelN_Quartos" maxlength="10" size="10" value="<ccs:control name='N_Quartos'/>" name="<ccs:control name='N_Quartos' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Suites">N° Suites</label></td> 
            <td><input id="tbl_imovelN_Suites" maxlength="10" size="10" value="<ccs:control name='N_Suites'/>" name="<ccs:control name='N_Suites' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Banheiros">N° Banheiros</label></td> 
            <td><input id="tbl_imovelN_Banheiros" maxlength="10" size="10" value="<ccs:control name='N_Banheiros'/>" name="<ccs:control name='N_Banheiros' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Salas">N° Salas</label></td> 
            <td><input id="tbl_imovelN_Salas" maxlength="10" size="10" value="<ccs:control name='N_Salas'/>" name="<ccs:control name='N_Salas' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelN_Cozinhas">N° Cozinhas</label></td> 
            <td><input id="tbl_imovelN_Cozinhas" maxlength="10" size="10" value="<ccs:control name='N_Cozinhas'/>" name="<ccs:control name='N_Cozinhas' property='name'/>"></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelDep_Empregada">Dep. de&nbsp;Empregada</label></td> 
            <td><input id="tbl_imovelDep_Empregada" type="checkbox" value="1" name="<ccs:control name='Dep_Empregada' property='name'/>" <ccs:control name='Dep_Empregada'/>></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelGaragem">Garagem</label></td> 
            <td><input id="tbl_imovelGaragem" type="checkbox" value="1" name="<ccs:control name='Garagem' property='name'/>" <ccs:control name='Garagem'/>></td>
          </tr>
 
          <tr class="Controls">
            <td class="th"><label for="tbl_imovelMts_Quadrados">Metros Quadrados</label></td> 
            <td><input id="tbl_imovelMts_Quadrados" maxlength="10" size="10" value="<ccs:control name='Mts_Quadrados'/>" name="<ccs:control name='Mts_Quadrados' property='name'/>"></td>
          </tr>
 
          <tr class="Bottom">
            <td align="right" colspan="2">
              <ccs:button name='Button_Insert'><input class="Button" id="tbl_imovelButton_Insert" type="submit" alt="Add" value="Adicionar" name="<ccs:control name='Button_Insert' property='name'/>"></ccs:button>
              <ccs:button name='Button_Update'><input class="Button" id="tbl_imovelButton_Update" type="submit" alt="Atualizar" value="Atualizar" name="<ccs:control name='Button_Update' property='name'/>"></ccs:button>
              <ccs:button name='Button_Delete'><input class="Button" id="tbl_imovelButton_Delete" type="submit" alt="Delete" value="Remover" name="<ccs:control name='Button_Delete' property='name'/>"></ccs:button></td>
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

<%--JSP Page BeforeOutput @1-C3933CA5--%>
<%ManterImovelModel.fireBeforeOutputEvent();%>
<%--End JSP Page BeforeOutput--%>

<%--JSP Page Unload @1-2CE5C25B--%>
<%ManterImovelModel.fireBeforeUnloadEvent();%>
<%--End JSP Page Unload--%>

