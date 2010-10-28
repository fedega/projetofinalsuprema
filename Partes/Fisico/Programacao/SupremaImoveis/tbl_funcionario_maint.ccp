<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_funcionario" dataSource="tbl_funcionario" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Funcionario " wizardFormMethod="post" returnPage="tbl_funcionario_list.ccp" PathID="tbl_funcionario">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_funcionario" PathID="tbl_funcionarioButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_funcionario" PathID="tbl_funcionarioButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_funcionario" PathID="tbl_funcionarioButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nome" fieldSource="Nome" required="True" caption="Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Cidade" fieldSource="Cod_Cidade" required="False" caption="Cod Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioCod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Estado" fieldSource="Cod_Estado" required="False" caption="Cod Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Orgao" fieldSource="Cod_Orgao" required="False" caption="Cod Orgao" wizardCaption="Cod Orgao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioCod_Orgao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="11" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nome_U" fieldSource="Nome_U" required="True" caption="Nome U" wizardCaption="Nome U" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioNome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Senha_U" fieldSource="Senha_U" required="True" caption="Senha U" wizardCaption="Senha U" wizardSize="20" wizardMaxLength="20" wizardIsPassword="True" parentName="tbl_funcionario" PathID="tbl_funcionarioSenha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="13" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Endereco" fieldSource="Endereco" required="False" caption="Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="14" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Fixo" fieldSource="Tel_Fixo" required="False" caption="Tel Fixo" wizardCaption="Tel Fixo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioTel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="15" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Cel" fieldSource="Tel_Cel" required="False" caption="Tel Cel" wizardCaption="Tel Cel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioTel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="16" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="CPF" fieldSource="CPF" required="False" caption="CPF" wizardCaption="CPF" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioCPF">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="17" visible="Yes" fieldSourceType="DBColumn" dataType="Date" name="Data_Nasc" fieldSource="Data_Nasc" required="False" caption="Data Nasc" wizardCaption="Data Nasc" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioData_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<DatePicker id="18" name="DatePicker_Data_Nasc" control="Data_Nasc" wizardSatellite="True" wizardControl="Data_Nasc" wizardDatePickerType="Image" parentName="tbl_funcionario" wizardPicture="Styles/Padrao/Images/DatePicker.gif" style="Styles/Padrao/Style.css" PathID="tbl_funcionarioDatePicker_Data_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</DatePicker>
				<TextBox id="19" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="CRECI" fieldSource="CRECI" required="False" caption="CRECI" wizardCaption="CRECI" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioCRECI">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="20" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Nivel_Controle" fieldSource="Nivel_Controle" required="True" caption="Nivel Controle" wizardCaption="Nivel Controle" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_funcionario" PathID="tbl_funcionarioNivel_Controle">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Funcionario" parameterSource="Cod_Funcionario" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<IncludePage id="22" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="23" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="tbl_funcionario_maint.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="tbl_funcionario_maint.jsp" path="." forShow="True" url="tbl_funcionario_maint.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="tbl_funcionario_maintHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="21" groupID="2"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
