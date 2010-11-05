<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_contratoSearch" returnPage="ListaContrato.ccp" wizardCaption="Buscar Tbl Contrato " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_contratoSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_contratoSearch" PathID="tbl_contratoSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="s_Cod_Contrato" wizardCaption="Cod Contrato" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_contratoSearch" PathID="tbl_contratoSearchs_Cod_Contrato">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="s_Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_contratoSearch" PathID="tbl_contratoSearchs_Cod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="6" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="s_Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_contratoSearch" PathID="tbl_contratoSearchs_Cod_Imovel">
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
		<Grid id="8" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_contrato" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Contrato " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_contrato">
			<Components>
				<Link id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_contrato_Insert" hrefSource="ManterContrato.ccp" removeParameters="Cod_Contrato" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_contrato" PathID="tbl_contratotbl_contrato_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="14" visible="True" name="Sorter_Cod_Contrato" column="Cod_Contrato" wizardCaption="Cod Contrato" wizardSortingType="SimpleDir" wizardControl="Cod_Contrato" wizardAddNbsp="False" PathID="tbl_contratoSorter_Cod_Contrato">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="15" visible="True" name="Sorter_Cod_Funcionario" column="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSortingType="SimpleDir" wizardControl="Cod_Funcionario" wizardAddNbsp="False" PathID="tbl_contratoSorter_Cod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="16" visible="True" name="Sorter_Cod_Cliente" column="Cod_Cliente" wizardCaption="Cod Cliente" wizardSortingType="SimpleDir" wizardControl="Cod_Cliente" wizardAddNbsp="False" PathID="tbl_contratoSorter_Cod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="17" visible="True" name="Sorter_Cod_Imovel" column="Cod_Imovel" wizardCaption="Cod Imovel" wizardSortingType="SimpleDir" wizardControl="Cod_Imovel" wizardAddNbsp="False" PathID="tbl_contratoSorter_Cod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="18" visible="True" name="Sorter_Cod_Fiador" column="Cod_Fiador" wizardCaption="Cod Fiador" wizardSortingType="SimpleDir" wizardControl="Cod_Fiador" wizardAddNbsp="False" PathID="tbl_contratoSorter_Cod_Fiador">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="20" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Contrato" fieldSource="Cod_Contrato" wizardCaption="Cod Contrato" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterContrato.ccp" parentName="tbl_contrato" rowNumber="1" PathID="tbl_contratoCod_Contrato">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="21" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Contrato" source="Cod_Contrato"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="23" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Funcionario" fieldSource="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_contrato" rowNumber="1" PathID="tbl_contratoCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="25" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cliente" fieldSource="Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_contrato" rowNumber="1" PathID="tbl_contratoCod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="27" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Imovel" fieldSource="Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_contrato" rowNumber="1" PathID="tbl_contratoCod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="29" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Fiador" fieldSource="Cod_Fiador" wizardCaption="Cod Fiador" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_contrato" rowNumber="1" PathID="tbl_contratoCod_Fiador">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="30" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="31" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="11" conditionType="Parameter" useIsNull="False" field="Cod_Contrato" parameterSource="s_Cod_Contrato" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
				<TableParameter id="12" conditionType="Parameter" useIsNull="False" field="Cod_Cliente" parameterSource="s_Cod_Cliente" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="2"/>
				<TableParameter id="13" conditionType="Parameter" useIsNull="False" field="Cod_Imovel" parameterSource="s_Cod_Imovel" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="3"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="9" tableName="tbl_contrato" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="19" tableName="tbl_contrato" fieldName="Cod_Contrato"/>
				<Field id="22" tableName="tbl_contrato" fieldName="Cod_Funcionario"/>
				<Field id="24" tableName="tbl_contrato" fieldName="Cod_Cliente"/>
				<Field id="26" tableName="tbl_contrato" fieldName="Cod_Imovel"/>
				<Field id="28" tableName="tbl_contrato" fieldName="Cod_Fiador"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="33" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="34" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaContrato.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ListaContrato.jsp" path="." forShow="True" url="ListaContrato.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ListaContratoHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="32" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
