<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_cidade" dataSource="tbl_cidade" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Cidade " wizardFormMethod="post" returnPage="tbl_cidade_list.ccp" PathID="tbl_cidade" activeCollection="TableParameters">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" PathID="tbl_cidadeButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" PathID="tbl_cidadeButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" PathID="tbl_cidadeButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nome" fieldSource="Nome" required="True" caption="Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" PathID="tbl_cidadeNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<ListBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Estado" fieldSource="Cod_Estado" required="True" caption="Cod Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" PathID="tbl_cidadeCod_Estado" sourceType="Table" connection="Conexao" dataSource="tbl_estado" boundColumn="Cod_Estado" textColumn="UF">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
					<TableParameters/>
					<SPParameters/>
					<SQLParameters/>
					<JoinTables/>
					<JoinLinks/>
					<Fields/>
				</ListBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Cidade" parameterSource="Cod_Cidade" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1" leftBrackets="0" rightBrackets="0"/>
				<TableParameter id="15" conditionType="Parameter" useIsNull="False" field="Cod_Estado" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" parameterSource="tbl_estado.Cod_Estado" leftBrackets="0" rightBrackets="0"/>
			</TableParameters>
			<SPParameters/>
			<SQLParameters/>
			<JoinTables>
				<JoinTable id="12" tableName="tbl_cidade" posLeft="10" posTop="10" posWidth="95" posHeight="104"/>
			</JoinTables>
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
		<IncludePage id="10" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="11" name="Footer" PathID="Footer" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ManterCidade.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ManterCidade.jsp" path="." forShow="True" url="ManterCidade.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ManterCidadeHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="9" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
