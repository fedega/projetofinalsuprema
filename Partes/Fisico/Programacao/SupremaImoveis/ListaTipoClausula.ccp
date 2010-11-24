<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_tipo_causulaSearch" returnPage="ListaTipoClausula.ccp" wizardCaption="Buscar Tbl Tipo Causula " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_tipo_causulaSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_tipo_causulaSearch" PathID="tbl_tipo_causulaSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Tipo" wizardCaption="Tipo" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_tipo_causulaSearch" PathID="tbl_tipo_causulaSearchs_Tipo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
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
		<Grid id="6" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_tipo_causula" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Tipo Causula " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_tipo_causula">
			<Components>
				<Link id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_tipo_causula_Insert" hrefSource="ManterTipoClausula.ccp" removeParameters="Cod_Tipo" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_tipo_causula" PathID="tbl_tipo_causulatbl_tipo_causula_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="10" visible="True" name="Sorter_Cod_Tipo" column="Cod_Tipo" wizardCaption="Cod Tipo" wizardSortingType="SimpleDir" wizardControl="Cod_Tipo" wizardAddNbsp="False" PathID="tbl_tipo_causulaSorter_Cod_Tipo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="11" visible="True" name="Sorter_Tipo" column="Tipo" wizardCaption="Tipo" wizardSortingType="SimpleDir" wizardControl="Tipo" wizardAddNbsp="False" PathID="tbl_tipo_causulaSorter_Tipo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="13" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Tipo" fieldSource="Cod_Tipo" wizardCaption="Cod Tipo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterTipoClausula.ccp" parentName="tbl_tipo_causula" rowNumber="1" PathID="tbl_tipo_causulaCod_Tipo">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="14" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Tipo" source="Cod_Tipo"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="16" fieldSourceType="DBColumn" dataType="Text" html="False" name="Tipo" fieldSource="Tipo" wizardCaption="Tipo" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_tipo_causula" rowNumber="1" PathID="tbl_tipo_causulaTipo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="17" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="18" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="9" conditionType="Parameter" useIsNull="False" field="Tipo" parameterSource="s_Tipo" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="7" tableName="tbl_tipo_causula" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="12" tableName="tbl_tipo_causula" fieldName="Cod_Tipo"/>
				<Field id="15" tableName="tbl_tipo_causula" fieldName="Tipo"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="20" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="21" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaTipoClausula.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ListaTipoClausula.jsp" path="." forShow="True" url="ListaTipoClausula.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ListaTipoClausulaHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="19" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
