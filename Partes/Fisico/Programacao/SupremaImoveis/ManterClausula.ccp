<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_clausula" dataSource="tbl_clausula" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Clausula " wizardFormMethod="post" returnPage="tbl_clausula_list.ccp" PathID="tbl_clausula">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_clausula" PathID="tbl_clausulaButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_clausula" PathID="tbl_clausulaButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_clausula" PathID="tbl_clausulaButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tipo" fieldSource="Tipo" required="True" caption="Tipo" wizardCaption="Tipo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_clausula" PathID="tbl_clausulaTipo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Descricao" fieldSource="Descricao" required="False" caption="Descricao" wizardCaption="Descricao" wizardSize="50" wizardMaxLength="250" wizardIsPassword="False" parentName="tbl_clausula" PathID="tbl_clausulaDescricao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Contrato" fieldSource="Cod_Contrato" required="False" caption="Cod Contrato" wizardCaption="Cod Contrato" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_clausula" PathID="tbl_clausulaCod_Contrato">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Clausula" parameterSource="Cod_Clausula" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<IncludePage id="11" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="12" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ManterClausula.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ManterClausula.jsp" path="." forShow="True" url="ManterClausula.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ManterClausulaHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="13" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
