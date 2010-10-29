<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_documentacaoSearch" returnPage="tbl_documentaca_list.ccp" wizardCaption="Buscar Tbl Documentacao " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_documentacaoSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" PathID="tbl_documentacaoSearchButton_DoSearch" parentName="tbl_documentacaoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Memo" name="s_Anexo" wizardCaption="Anexo" wizardSize="50" wizardIsPassword="False" PathID="tbl_documentacaoSearchs_Anexo" parentName="tbl_documentacaoSearch">
<Components/>
					<Events/>
					<Attributes/>
					<Features/>
					<LinkParameters/>
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
		<Grid id="6" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_documentacao" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Documentacao " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_documentacao">
			<Components>
				<Link id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_documentacao_Insert" hrefSource="tbl_documentaca_maint.ccp" removeParameters="Cod_Doc" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" PathID="tbl_documentacaotbl_documentacao_Insert" parentName="tbl_documentacao">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="10" visible="True" name="Sorter_Cod_Doc" column="Cod_Doc" wizardCaption="Cod Doc" wizardSortingType="SimpleDir" wizardControl="Cod_Doc" wizardAddNbsp="False" PathID="tbl_documentacaoSorter_Cod_Doc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="11" visible="True" name="Sorter_Tipo_Doc" column="Tipo_Doc" wizardCaption="Tipo Doc" wizardSortingType="SimpleDir" wizardControl="Tipo_Doc" wizardAddNbsp="False" PathID="tbl_documentacaoSorter_Tipo_Doc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="12" visible="True" name="Sorter_Cod_Cliente" column="Cod_Cliente" wizardCaption="Cod Cliente" wizardSortingType="SimpleDir" wizardControl="Cod_Cliente" wizardAddNbsp="False" PathID="tbl_documentacaoSorter_Cod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="13" visible="True" name="Sorter_Cod_Fiador" column="Cod_Fiador" wizardCaption="Cod Fiador" wizardSortingType="SimpleDir" wizardControl="Cod_Fiador" wizardAddNbsp="False" PathID="tbl_documentacaoSorter_Cod_Fiador">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="15" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Doc" fieldSource="Cod_Doc" wizardCaption="Cod Doc" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="tbl_documentaca_maint.ccp" PathID="tbl_documentacaoCod_Doc" rowNumber="1" parentName="tbl_documentacao">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="16" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Doc" source="Cod_Doc"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="18" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tipo_Doc" fieldSource="Tipo_Doc" wizardCaption="Tipo Doc" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_documentacaoTipo_Doc" rowNumber="1" parentName="tbl_documentacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="20" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cliente" fieldSource="Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_documentacaoCod_Cliente" rowNumber="1" parentName="tbl_documentacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="22" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Fiador" fieldSource="Cod_Fiador" wizardCaption="Cod Fiador" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_documentacaoCod_Fiador" rowNumber="1" parentName="tbl_documentacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="23" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="24" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="9" conditionType="Parameter" useIsNull="False" field="Anexo" parameterSource="s_Anexo" dataType="Memo" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="7" tableName="tbl_documentacao" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="14" tableName="tbl_documentacao" fieldName="Cod_Doc"/>
				<Field id="17" tableName="tbl_documentacao" fieldName="Tipo_Doc"/>
				<Field id="19" tableName="tbl_documentacao" fieldName="Cod_Cliente"/>
				<Field id="21" tableName="tbl_documentacao" fieldName="Cod_Fiador"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="26" name="Header" PathID="Header" page="Header.ccp" parentType="Page">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="27" name="Footer" PathID="Footer" page="Footer.ccp" parentType="Page">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="tbl_documentaca_list.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="tbl_documentaca_list.jsp" path="." forShow="True" url="tbl_documentaca_list.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="tbl_documentaca_listHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="25" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
