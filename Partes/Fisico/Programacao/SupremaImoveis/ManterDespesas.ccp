<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_despesas" dataSource="tbl_despesas" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Despesas " wizardFormMethod="post" returnPage="tbl_despesas_list.ccp" PathID="tbl_despesas">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_despesas" PathID="tbl_despesasButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_despesas" PathID="tbl_despesasButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_despesas" PathID="tbl_despesasButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Data" fieldSource="Data" required="False" caption="Data" wizardCaption="Data" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" parentName="tbl_despesas" PathID="tbl_despesasData">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Valor" fieldSource="Valor" required="True" caption="Valor" wizardCaption="Valor" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_despesas" PathID="tbl_despesasValor">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tipo_Despesas" fieldSource="Tipo_Despesas" required="False" caption="Tipo Despesas" wizardCaption="Tipo Despesas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_despesas" PathID="tbl_despesasTipo_Despesas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Aluguel" fieldSource="Cod_Aluguel" required="True" caption="Cod Aluguel" wizardCaption="Cod Aluguel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_despesas" PathID="tbl_despesasCod_Aluguel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="11" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="tbl_situacao_Cod_Situacao" fieldSource="tbl_situacao_Cod_Situacao" required="False" caption="Tbl Situacao Cod Situacao" wizardCaption="Tbl Situacao Cod Situacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_despesas" PathID="tbl_despesastbl_situacao_Cod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Despesas" parameterSource="Cod_Despesas" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<IncludePage id="13" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="14" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ManterDespesas.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ManterDespesas.jsp" path="." forShow="True" url="ManterDespesas.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ManterDespesasHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="12" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
