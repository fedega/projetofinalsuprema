<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_fiador" dataSource="tbl_fiador" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Fiador " wizardFormMethod="post" returnPage="tbl_fiador_list.ccp" PathID="tbl_fiador">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_fiador" PathID="tbl_fiadorButton_Insert" returnPage="ListaFiador.ccp">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_fiador" PathID="tbl_fiadorButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_fiador" PathID="tbl_fiadorButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Orgao" fieldSource="Cod_Orgao" required="False" caption="Cod Orgao" wizardCaption="Cod Orgao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorCod_Orgao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Estado" fieldSource="Cod_Estado" required="False" caption="Cod Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Cidade" fieldSource="Cod_Cidade" required="False" caption="Cod Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorCod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Cliente" fieldSource="Cod_Cliente" required="False" caption="Cod Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorCod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="11" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nome" fieldSource="Nome" required="True" caption="Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Date" name="Data_Nasc" fieldSource="Data_Nasc" required="True" caption="Data Nasc" wizardCaption="Data Nasc" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorData_Nasc" format="dd/mm/yyyy" DBFormat="yyyy-mm-dd HH:nn:ss">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<DatePicker id="13" name="DatePicker_Data_Nasc" control="Data_Nasc" wizardSatellite="True" wizardControl="Data_Nasc" wizardDatePickerType="Image" parentName="tbl_fiador" wizardPicture="Styles/Padrao/Images/DatePicker.gif" style="Styles/Padrao/Style.css" PathID="tbl_fiadorDatePicker_Data_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</DatePicker>
				<TextBox id="14" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nome_U" fieldSource="Nome_U" required="True" caption="Nome U" wizardCaption="Nome U" wizardSize="16" wizardMaxLength="16" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorNome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="15" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Senha_U" fieldSource="Senha_U" required="True" caption="Senha U" wizardCaption="Senha U" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorSenha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="16" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Nacionalidaade" fieldSource="Nacionalidaade" required="True" caption="Nacionalidaade" wizardCaption="Nacionalidaade" wizardSize="30" wizardMaxLength="30" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorNacionalidaade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="17" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Endereco" fieldSource="Endereco" required="True" caption="Endereco" wizardCaption="Endereco" wizardSize="50" wizardMaxLength="200" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="18" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Fixo" fieldSource="Tel_Fixo" required="False" caption="Tel Fixo" wizardCaption="Tel Fixo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorTel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="19" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Cel" fieldSource="Tel_Cel" required="False" caption="Tel Cel" wizardCaption="Tel Cel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorTel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="20" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Tel_Comercial" fieldSource="Tel_Comercial" required="False" caption="Tel Comercial" wizardCaption="Tel Comercial" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_fiador" PathID="tbl_fiadorTel_Comercial">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Fiador" parameterSource="Cod_Fiador" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<CodeFile id="Model" language="JSP" name="ManterFiador.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ManterFiador.jsp" path="." forShow="True" url="ManterFiador.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ManterFiadorHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="21" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
