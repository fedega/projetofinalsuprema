<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="True" allowUpdate="True" allowDelete="True" validateData="True" preserveParameters="GET" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" connection="Conexao" name="tbl_visita" dataSource="tbl_visita" errorSummator="Error" wizardCaption="Adicionar/Editar Tbl Visita " wizardFormMethod="post" returnPage="tbl_visita_list.ccp" PathID="tbl_visita" pasteActions="pasteActions">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Insert" operation="Insert" wizardCaption="Add" parentName="tbl_visita" PathID="tbl_visitaButton_Insert">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="4" urlType="Relative" enableValidation="True" isDefault="False" name="Button_Update" operation="Update" wizardCaption="Atualizar" parentName="tbl_visita" PathID="tbl_visitaButton_Update">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<Button id="5" urlType="Relative" enableValidation="False" isDefault="False" name="Button_Delete" operation="Delete" wizardCaption="Delete" parentName="tbl_visita" PathID="tbl_visitaButton_Delete">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Date" name="Data" fieldSource="Data" required="False" caption="Data" wizardCaption="Data" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" parentName="tbl_visita" PathID="tbl_visitaData">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<DatePicker id="8" name="DatePicker_Data" control="Data" wizardSatellite="True" wizardControl="Data" wizardDatePickerType="Image" parentName="tbl_visita" wizardPicture="Styles/Padrao/Images/DatePicker.gif" style="Styles/Padrao/Style.css" PathID="tbl_visitaDatePicker_Data">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</DatePicker>
				<TextBox id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Date" name="Hora" fieldSource="Hora" required="False" caption="Hora" wizardCaption="Hora" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" parentName="tbl_visita" PathID="tbl_visitaHora">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="11" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Imovel" fieldSource="Cod_Imovel" required="False" caption="Cod Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_visita" PathID="tbl_visitaCod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Cod_Funcionario" fieldSource="Cod_Funcionario" required="False" caption="Cod Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_visita" PathID="tbl_visitaCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="16" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="Cliente" fieldSource="Cliente" required="False" caption="{res:Text1}" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_visita" PathID="tbl_visitaCliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="17" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="Contato" fieldSource="Contato" required="False" caption="{res:Text1}" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_visita" PathID="tbl_visitaContato">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="6" conditionType="Parameter" useIsNull="False" field="Cod_Visita" parameterSource="Cod_Visita" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
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
		<IncludePage id="14" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="15" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ManterVisita.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ManterVisita.jsp" path="." forShow="True" url="ManterVisita.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ManterVisitaHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="13" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
