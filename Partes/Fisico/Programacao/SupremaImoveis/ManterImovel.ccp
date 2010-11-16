<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_imovel" dataSource="tbl_imovel" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Imovel " wizardFormMethod="post" returnPage="tbl_imovel_list.ccp" PathID="tbl_imovel">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_imovel" PathID="tbl_imovelButton_Insert" returnPage="ListaImovel.ccp">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_imovel" PathID="tbl_imovelButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_imovel" PathID="tbl_imovelButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Cliente" fieldSource="Cod_Cliente" required="False" caption="Cod Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelCod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Funcionario" fieldSource="Cod_Funcionario" required="False" caption="Cod Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Situacao" fieldSource="Cod_Situacao" required="False" caption="Cod Situacao" wizardCaption="Cod Situacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelCod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_destinacao" fieldSource="Cod_destinacao" required="False" caption="Cod Destinacao" wizardCaption="Cod Destinacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelCod_destinacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="11" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Endereco" fieldSource="Endereco" required="False" caption="Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="CEP" fieldSource="CEP" required="False" caption="CEP" wizardCaption="CEP" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelCEP">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="13" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Bairro" fieldSource="Bairro" required="False" caption="Bairro" wizardCaption="Bairro" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelBairro">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="14" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Estado" fieldSource="Cod_Estado" required="False" caption="Cod Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="15" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Cidade" fieldSource="Cod_Cidade" required="False" caption="Cod Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelCod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="16" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="N_Quartos" fieldSource="N_Quartos" required="False" caption="N Quartos" wizardCaption="N Quartos" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelN_Quartos">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="17" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="N_Suites" fieldSource="N_Suites" required="False" caption="N Suites" wizardCaption="N Suites" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelN_Suites">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="18" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="N_Banheiros" fieldSource="N_Banheiros" required="False" caption="N Banheiros" wizardCaption="N Banheiros" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelN_Banheiros">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="19" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="N_Salas" fieldSource="N_Salas" required="False" caption="N Salas" wizardCaption="N Salas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelN_Salas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="20" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="N_Cozinhas" fieldSource="N_Cozinhas" required="False" caption="N Cozinhas" wizardCaption="N Cozinhas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelN_Cozinhas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<CheckBox id="21" visible="Yes" fieldSourceType="DBColumn" dataType="Boolean" name="Dep_Empregada" fieldSource="Dep_Empregada" required="False" caption="Dep Empregada" wizardCaption="Dep Empregada" wizardSize="1" wizardMaxLength="1" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelDep_Empregada">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</CheckBox>
				<CheckBox id="22" visible="Yes" fieldSourceType="DBColumn" dataType="Boolean" name="Garagem" fieldSource="Garagem" required="False" caption="Garagem" wizardCaption="Garagem" wizardSize="1" wizardMaxLength="1" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelGaragem">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</CheckBox>
				<TextBox id="23" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Mts_Quadrados" fieldSource="Mts_Quadrados" required="False" caption="Mts Quadrados" wizardCaption="Mts Quadrados" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovel" PathID="tbl_imovelMts_Quadrados">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Imovel" parameterSource="Cod_Imovel" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
			</TableParameters>
			<SPParameters/>
			<SQLParameters/>
			<JoinTables/>
			<JoinLinks/>
			<Fields/>
			<ISPParameters/>
			<ISQLParameters/>
			<IFormElements/>
			<USPParameters/>
			<USQLParameters/>
			<UConditions/>
			<UFormElements/>
			<DSPParameters/>
			<DSQLParameters/>
			<DConditions/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Record>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ManterImovel.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ManterImovel.jsp" path="." forShow="True" url="ManterImovel.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ManterImovelHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="24" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
