<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_documentacao" dataSource="tbl_documentacao" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Documentacao " wizardFormMethod="post" returnPage="tbl_documentaca_list.ccp" PathID="tbl_documentacao">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" PathID="tbl_documentacaoButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" PathID="tbl_documentacaoButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" PathID="tbl_documentacaoButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tipo_Doc" fieldSource="Tipo_Doc" required="False" caption="Tipo Doc" wizardCaption="Tipo Doc" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" PathID="tbl_documentacaoTipo_Doc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Cliente" fieldSource="Cod_Cliente" required="False" caption="Cod Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" PathID="tbl_documentacaoCod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Fiador" fieldSource="Cod_Fiador" required="False" caption="Cod Fiador" wizardCaption="Cod Fiador" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" PathID="tbl_documentacaoCod_Fiador">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<FileUpload id="14" fieldSourceType="DBColumn" allowedFileMasks="*" fileSizeLimit="100000" dataType="Text" tempFileFolder="%TEMP" name="FileUpload1" PathID="tbl_documentacaoFileUpload1" fieldSource="Anexo">
<Components/>
<Events/>
<Attributes/>
<Features/>
</FileUpload>
</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Doc" parameterSource="Cod_Doc" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<IncludePage id="12" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="13" name="Footer" PathID="Footer" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="tbl_documentaca_maint.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="tbl_documentaca_maint.jsp" path="." forShow="True" url="tbl_documentaca_maint.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="tbl_documentaca_maintHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="11" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
