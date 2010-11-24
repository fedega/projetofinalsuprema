<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_solicitacoes" dataSource="tbl_solicitacoes" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Solicitacoes " wizardFormMethod="post" returnPage="ListaSolicitacoes.ccp" PathID="tbl_solicitacoes">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_solicitacoes" PathID="tbl_solicitacoesButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_solicitacoes" PathID="tbl_solicitacoesButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_solicitacoes" PathID="tbl_solicitacoesButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Descricao" fieldSource="Descricao" required="False" caption="Descricao" wizardCaption="Descricao" wizardSize="50" wizardMaxLength="250" wizardIsPassword="False" parentName="tbl_solicitacoes" PathID="tbl_solicitacoesDescricao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Funcionario" fieldSource="Cod_Funcionario" required="False" caption="Cod Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_solicitacoes" PathID="tbl_solicitacoesCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tipo_Solicitacao" fieldSource="Tipo_Solicitacao" required="False" caption="Tipo Solicitacao" wizardCaption="Tipo Solicitacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_solicitacoes" PathID="tbl_solicitacoesTipo_Solicitacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Situacao" fieldSource="Cod_Situacao" required="False" caption="Cod Situacao" wizardCaption="Cod Situacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_solicitacoes" PathID="tbl_solicitacoesCod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Solicitacoes" parameterSource="Cod_Solicitacoes" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<IncludePage id="12" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="13" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ManterSolicitacoes.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ManterSolicitacoes.jsp" path="." forShow="True" url="ManterSolicitacoes.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ManterSolicitacoesHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="11" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
