<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_clausulaSearch" returnPage="ListaClausula.ccp" wizardCaption="Buscar Tbl Clausula " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_clausulaSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_clausulaSearch" PathID="tbl_clausulaSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Descricao" wizardCaption="Descricao" wizardSize="50" wizardMaxLength="250" wizardIsPassword="False" parentName="tbl_clausulaSearch" PathID="tbl_clausulaSearchs_Descricao">
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
		<Grid id="6" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_clausula" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Clausula " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_clausula">
			<Components>
				<Link id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_clausula_Insert" hrefSource="ManterClausula.ccp" removeParameters="Cod_Clausula" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_clausula" PathID="tbl_clausulatbl_clausula_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="10" visible="True" name="Sorter_Cod_Clausula" column="Cod_Clausula" wizardCaption="Cod Clausula" wizardSortingType="SimpleDir" wizardControl="Cod_Clausula" wizardAddNbsp="False" PathID="tbl_clausulaSorter_Cod_Clausula">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="11" visible="True" name="Sorter_Tipo" column="Tipo" wizardCaption="Tipo" wizardSortingType="SimpleDir" wizardControl="Tipo" wizardAddNbsp="False" PathID="tbl_clausulaSorter_Tipo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="12" visible="True" name="Sorter_Descricao" column="Descricao" wizardCaption="Descricao" wizardSortingType="SimpleDir" wizardControl="Descricao" wizardAddNbsp="False" PathID="tbl_clausulaSorter_Descricao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="13" visible="True" name="Sorter_Cod_Contrato" column="Cod_Contrato" wizardCaption="Cod Contrato" wizardSortingType="SimpleDir" wizardControl="Cod_Contrato" wizardAddNbsp="False" PathID="tbl_clausulaSorter_Cod_Contrato">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="15" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Clausula" fieldSource="Cod_Clausula" wizardCaption="Cod Clausula" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterClausula.ccp" parentName="tbl_clausula" rowNumber="1" PathID="tbl_clausulaCod_Clausula">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="16" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Clausula" source="Cod_Clausula"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="18" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tipo" fieldSource="Tipo" wizardCaption="Tipo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_clausula" rowNumber="1" PathID="tbl_clausulaTipo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="20" fieldSourceType="DBColumn" dataType="Text" html="False" name="Descricao" fieldSource="Descricao" wizardCaption="Descricao" wizardSize="50" wizardMaxLength="250" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_clausula" rowNumber="1" PathID="tbl_clausulaDescricao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="22" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Contrato" fieldSource="Cod_Contrato" wizardCaption="Cod Contrato" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_clausula" rowNumber="1" PathID="tbl_clausulaCod_Contrato">
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
				<TableParameter id="9" conditionType="Parameter" useIsNull="False" field="Descricao" parameterSource="s_Descricao" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="7" tableName="tbl_clausula" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="14" tableName="tbl_clausula" fieldName="Cod_Clausula"/>
				<Field id="17" tableName="tbl_clausula" fieldName="Tipo"/>
				<Field id="19" tableName="tbl_clausula" fieldName="Descricao"/>
				<Field id="21" tableName="tbl_clausula" fieldName="Cod_Contrato"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="26" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="27" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaClausula.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ListaClausula.jsp" path="." forShow="True" url="ListaClausula.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ListaClausulaHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="25" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
