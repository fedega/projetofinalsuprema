<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_visitaSearch" returnPage="tbl_visita_list.ccp" wizardCaption="Buscar Tbl Visita " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_visitaSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_visitaSearch" PathID="tbl_visitaSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="s_Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_visitaSearch" PathID="tbl_visitaSearchs_Cod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Date" name="s_Data" wizardCaption="Data" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" parentName="tbl_visitaSearch" PathID="tbl_visitaSearchs_Data">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<DatePicker id="6" name="DatePicker_s_Data" control="s_Data" wizardSatellite="True" wizardControl="s_Data" wizardDatePickerType="Image" parentName="tbl_visitaSearch" wizardPicture="Styles/Padrao/Images/DatePicker.gif" style="Styles/Padrao/Style.css" PathID="tbl_visitaSearchDatePicker_s_Data">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</DatePicker>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Date" name="s_Hora" wizardCaption="Hora" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" parentName="tbl_visitaSearch" PathID="tbl_visitaSearchs_Hora">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<DatePicker id="8" name="DatePicker_s_Hora" control="s_Hora" wizardSatellite="True" wizardControl="s_Hora" wizardDatePickerType="Image" parentName="tbl_visitaSearch" wizardPicture="Styles/Padrao/Images/DatePicker.gif" style="Styles/Padrao/Style.css" PathID="tbl_visitaSearchDatePicker_s_Hora">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</DatePicker>
			</Components>
			<Events/>
			<TableParameters/>
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
		<Grid id="10" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_visita" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Visita " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_visita">
			<Components>
				<Link id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_visita_Insert" hrefSource="tbl_visita_maint.ccp" removeParameters="Cod_Visita" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_visita" PathID="tbl_visitatbl_visita_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="16" visible="True" name="Sorter_Cod_Visita" column="Cod_Visita" wizardCaption="Cod Visita" wizardSortingType="SimpleDir" wizardControl="Cod_Visita" wizardAddNbsp="False" PathID="tbl_visitaSorter_Cod_Visita">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="17" visible="True" name="Sorter_Data" column="Data" wizardCaption="Data" wizardSortingType="SimpleDir" wizardControl="Data" wizardAddNbsp="False" PathID="tbl_visitaSorter_Data">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="18" visible="True" name="Sorter_Hora" column="Hora" wizardCaption="Hora" wizardSortingType="SimpleDir" wizardControl="Hora" wizardAddNbsp="False" PathID="tbl_visitaSorter_Hora">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="19" visible="True" name="Sorter_Cod_Imovel" column="Cod_Imovel" wizardCaption="Cod Imovel" wizardSortingType="SimpleDir" wizardControl="Cod_Imovel" wizardAddNbsp="False" PathID="tbl_visitaSorter_Cod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="20" visible="True" name="Sorter_Cod_Funcionario" column="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSortingType="SimpleDir" wizardControl="Cod_Funcionario" wizardAddNbsp="False" PathID="tbl_visitaSorter_Cod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="22" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Visita" fieldSource="Cod_Visita" wizardCaption="Cod Visita" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="tbl_visita_maint.ccp" parentName="tbl_visita" rowNumber="1" PathID="tbl_visitaCod_Visita">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="23" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Visita" source="Cod_Visita"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="25" fieldSourceType="DBColumn" dataType="Date" html="False" name="Data" fieldSource="Data" wizardCaption="Data" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_visita" rowNumber="1" PathID="tbl_visitaData">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="27" fieldSourceType="DBColumn" dataType="Date" html="False" name="Hora" fieldSource="Hora" wizardCaption="Hora" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_visita" rowNumber="1" PathID="tbl_visitaHora">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="29" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Imovel" fieldSource="Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_visita" rowNumber="1" PathID="tbl_visitaCod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="31" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Funcionario" fieldSource="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_visita" rowNumber="1" PathID="tbl_visitaCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="32" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="33" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="13" conditionType="Parameter" useIsNull="False" field="Cod_Imovel" parameterSource="s_Cod_Imovel" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
				<TableParameter id="14" conditionType="Parameter" useIsNull="False" field="Data" parameterSource="s_Data" dataType="Date" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="2"/>
				<TableParameter id="15" conditionType="Parameter" useIsNull="False" field="Hora" parameterSource="s_Hora" dataType="Date" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="3"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="11" tableName="tbl_visita" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="21" tableName="tbl_visita" fieldName="Cod_Visita"/>
				<Field id="24" tableName="tbl_visita" fieldName="Data"/>
				<Field id="26" tableName="tbl_visita" fieldName="Hora"/>
				<Field id="28" tableName="tbl_visita" fieldName="Cod_Imovel"/>
				<Field id="30" tableName="tbl_visita" fieldName="Cod_Funcionario"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="35" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="36" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="tbl_visita_list.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="tbl_visita_list.jsp" path="." forShow="True" url="tbl_visita_list.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="tbl_visita_listHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="34" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
