<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_cliente" dataSource="tbl_cliente" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Cliente " wizardFormMethod="post" returnPage="ListaCliente.ccp" PathID="tbl_cliente">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_cliente" PathID="tbl_clienteButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_cliente" PathID="tbl_clienteButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_cliente" PathID="tbl_clienteButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nome" fieldSource="Nome" required="True" caption="Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Date" name="Data_Nasc" fieldSource="Data_Nasc" required="True" caption="Data Nasc" wizardCaption="Data Nasc" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteData_Nasc" format="dd/mm/yyyy" DBFormat="yyyy-mm-dd HH:nn:ss">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<DatePicker id="9" name="DatePicker_Data_Nasc" control="Data_Nasc" wizardSatellite="True" wizardControl="Data_Nasc" wizardDatePickerType="Image" parentName="tbl_cliente" wizardPicture="Styles/Padrao/Images/DatePicker.gif" style="Styles/Padrao/Style.css" PathID="tbl_clienteDatePicker_Data_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</DatePicker>
				<TextBox id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nome_U" fieldSource="Nome_U" required="True" caption="Nome U" wizardCaption="Nome U" wizardSize="16" wizardMaxLength="16" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteNome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="11" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Senha_U" fieldSource="Senha_U" required="True" caption="Senha U" wizardCaption="Senha U" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteSenha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nacionalidade" fieldSource="Nacionalidade" required="True" caption="Nacionalidade" wizardCaption="Nacionalidade" wizardSize="30" wizardMaxLength="30" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteNacionalidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="13" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Endereco" fieldSource="Endereco" required="True" caption="Endereco" wizardCaption="Endereco" wizardSize="50" wizardMaxLength="200" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="14" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Fixo" fieldSource="Tel_Fixo" required="False" caption="Tel Fixo" wizardCaption="Tel Fixo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteTel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="15" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Cel" fieldSource="Tel_Cel" required="False" caption="Tel Cel" wizardCaption="Tel Cel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteTel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="16" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Comercial" fieldSource="Tel_Comercial" required="False" caption="Tel Comercial" wizardCaption="Tel Comercial" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteTel_Comercial">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="17" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Estado" fieldSource="Cod_Estado" required="False" caption="Cod Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="18" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Cidade" fieldSource="Cod_Cidade" required="False" caption="Cod Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteCod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="19" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Funcionario" fieldSource="Cod_Funcionario" required="False" caption="Cod Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="20" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Orgao_Emissor" fieldSource="Orgao_Emissor" required="False" caption="Orgao Emissor" wizardCaption="Orgao Emissor" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteOrgao_Emissor">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="21" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tipo_Cliente" fieldSource="Tipo_Cliente" required="False" caption="Tipo Cliente" wizardCaption="Tipo Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_cliente" PathID="tbl_clienteTipo_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Cliente" parameterSource="Cod_Cliente" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<IncludePage id="23" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="24" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ManterCliente.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ManterCliente.jsp" path="." forShow="True" url="ManterCliente.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ManterClienteHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="22" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
