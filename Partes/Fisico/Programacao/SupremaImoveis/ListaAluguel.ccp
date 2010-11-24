<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_aluguelSearch" returnPage="ListaAluguel.ccp" wizardCaption="Buscar Tbl Aluguel " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_aluguelSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_aluguelSearch" PathID="tbl_aluguelSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="s_Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_aluguelSearch" PathID="tbl_aluguelSearchs_Cod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="s_Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_aluguelSearch" PathID="tbl_aluguelSearchs_Cod_Cliente">
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
		<Grid id="7" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_aluguel" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Aluguel " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_aluguel">
			<Components>
				<Link id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_aluguel_Insert" hrefSource="ManterAluguel.ccp" removeParameters="Cod_Aluguel" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_aluguel" PathID="tbl_alugueltbl_aluguel_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="12" visible="True" name="Sorter_Cod_Aluguel" column="Cod_Aluguel" wizardCaption="Cod Aluguel" wizardSortingType="SimpleDir" wizardControl="Cod_Aluguel" wizardAddNbsp="False" PathID="tbl_aluguelSorter_Cod_Aluguel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="13" visible="True" name="Sorter_Data" column="Data" wizardCaption="Data" wizardSortingType="SimpleDir" wizardControl="Data" wizardAddNbsp="False" PathID="tbl_aluguelSorter_Data">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="14" visible="True" name="Sorter_Cod_Imovel" column="Cod_Imovel" wizardCaption="Cod Imovel" wizardSortingType="SimpleDir" wizardControl="Cod_Imovel" wizardAddNbsp="False" PathID="tbl_aluguelSorter_Cod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="15" visible="True" name="Sorter_Cod_Cliente" column="Cod_Cliente" wizardCaption="Cod Cliente" wizardSortingType="SimpleDir" wizardControl="Cod_Cliente" wizardAddNbsp="False" PathID="tbl_aluguelSorter_Cod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="16" visible="True" name="Sorter_Cod_Fiador" column="Cod_Fiador" wizardCaption="Cod Fiador" wizardSortingType="SimpleDir" wizardControl="Cod_Fiador" wizardAddNbsp="False" PathID="tbl_aluguelSorter_Cod_Fiador">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="17" visible="True" name="Sorter_Cod_Funcionario" column="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSortingType="SimpleDir" wizardControl="Cod_Funcionario" wizardAddNbsp="False" PathID="tbl_aluguelSorter_Cod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="19" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Aluguel" fieldSource="Cod_Aluguel" wizardCaption="Cod Aluguel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterAluguel.ccp" parentName="tbl_aluguel" rowNumber="1" PathID="tbl_aluguelCod_Aluguel">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="20" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Aluguel" source="Cod_Aluguel"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="22" fieldSourceType="DBColumn" dataType="Date" html="False" name="Data" fieldSource="Data" wizardCaption="Data" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_aluguel" rowNumber="1" PathID="tbl_aluguelData">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="24" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Imovel" fieldSource="Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_aluguel" rowNumber="1" PathID="tbl_aluguelCod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="26" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cliente" fieldSource="Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_aluguel" rowNumber="1" PathID="tbl_aluguelCod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="28" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Fiador" fieldSource="Cod_Fiador" wizardCaption="Cod Fiador" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_aluguel" rowNumber="1" PathID="tbl_aluguelCod_Fiador">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="30" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Funcionario" fieldSource="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_aluguel" rowNumber="1" PathID="tbl_aluguelCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="31" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="32" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="10" conditionType="Parameter" useIsNull="False" field="Cod_Imovel" parameterSource="s_Cod_Imovel" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
				<TableParameter id="11" conditionType="Parameter" useIsNull="False" field="Cod_Cliente" parameterSource="s_Cod_Cliente" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="2"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="8" tableName="tbl_aluguel" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="18" tableName="tbl_aluguel" fieldName="Cod_Aluguel"/>
				<Field id="21" tableName="tbl_aluguel" fieldName="Data"/>
				<Field id="23" tableName="tbl_aluguel" fieldName="Cod_Imovel"/>
				<Field id="25" tableName="tbl_aluguel" fieldName="Cod_Cliente"/>
				<Field id="27" tableName="tbl_aluguel" fieldName="Cod_Fiador"/>
				<Field id="29" tableName="tbl_aluguel" fieldName="Cod_Funcionario"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="34" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="35" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaAluguel.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ListaAluguel.jsp" path="." forShow="True" url="ListaAluguel.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ListaAluguelHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="33" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
