<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0" pasteActions="pasteActions">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_despesasSearch" returnPage="ListaDespesas.ccp" wizardCaption="Buscar Tbl Despesas " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_despesasSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" PathID="tbl_despesasSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Data" wizardCaption="Data" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" PathID="tbl_despesasSearchs_Data">
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
		<Grid id="6" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_despesas" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Despesas " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_despesas">
			<Components>
				<Link id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_despesas_Insert" hrefSource="ManterDespesas.ccp" removeParameters="Cod_Despesas" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" PathID="tbl_despesastbl_despesas_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="10" visible="True" name="Sorter_Cod_Despesas" column="Cod_Despesas" wizardCaption="Cod Despesas" wizardSortingType="SimpleDir" wizardControl="Cod_Despesas" wizardAddNbsp="False" PathID="tbl_despesasSorter_Cod_Despesas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="11" visible="True" name="Sorter_Data" column="Data" wizardCaption="Data" wizardSortingType="SimpleDir" wizardControl="Data" wizardAddNbsp="False" PathID="tbl_despesasSorter_Data">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="12" visible="True" name="Sorter_Valor" column="Valor" wizardCaption="Valor" wizardSortingType="SimpleDir" wizardControl="Valor" wizardAddNbsp="False" PathID="tbl_despesasSorter_Valor">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="13" visible="True" name="Sorter_Tipo_Despesas" column="Tipo_Despesas" wizardCaption="Tipo Despesas" wizardSortingType="SimpleDir" wizardControl="Tipo_Despesas" wizardAddNbsp="False" PathID="tbl_despesasSorter_Tipo_Despesas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="14" visible="True" name="Sorter_Cod_Aluguel" column="Cod_Aluguel" wizardCaption="Cod Aluguel" wizardSortingType="SimpleDir" wizardControl="Cod_Aluguel" wizardAddNbsp="False" PathID="tbl_despesasSorter_Cod_Aluguel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="15" visible="True" name="Sorter_tbl_situacao_Cod_Situacao" column="tbl_situacao_Cod_Situacao" wizardCaption="Tbl Situacao Cod Situacao" wizardSortingType="SimpleDir" wizardControl="tbl_situacao_Cod_Situacao" wizardAddNbsp="False" PathID="tbl_despesasSorter_tbl_situacao_Cod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="17" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Despesas" fieldSource="Cod_Despesas" wizardCaption="Cod Despesas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterDespesas.ccp" PathID="tbl_despesasCod_Despesas">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="18" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Despesas" source="Cod_Despesas"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="20" fieldSourceType="DBColumn" dataType="Text" html="False" name="Data" fieldSource="Data" wizardCaption="Data" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" wizardAddNbsp="True" PathID="tbl_despesasData">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="22" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Valor" fieldSource="Valor" wizardCaption="Valor" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_despesasValor">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="24" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tipo_Despesas" fieldSource="Tipo_Despesas" wizardCaption="Tipo Despesas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_despesasTipo_Despesas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="26" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Aluguel" fieldSource="Cod_Aluguel" wizardCaption="Cod Aluguel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_despesasCod_Aluguel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="28" fieldSourceType="DBColumn" dataType="Integer" html="False" name="tbl_situacao_Cod_Situacao" fieldSource="tbl_situacao_Cod_Situacao" wizardCaption="Tbl Situacao Cod Situacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_despesastbl_situacao_Cod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="29" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="30" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="9" conditionType="Parameter" useIsNull="False" field="Data" parameterSource="s_Data" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="7" tableName="tbl_despesas" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="16" tableName="tbl_despesas" fieldName="Cod_Despesas"/>
				<Field id="19" tableName="tbl_despesas" fieldName="Data"/>
				<Field id="21" tableName="tbl_despesas" fieldName="Valor"/>
				<Field id="23" tableName="tbl_despesas" fieldName="Tipo_Despesas"/>
				<Field id="25" tableName="tbl_despesas" fieldName="Cod_Aluguel"/>
				<Field id="27" tableName="tbl_despesas" fieldName="tbl_situacao_Cod_Situacao"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="32" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="33" name="Footer" PathID="Footer" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaDespesas.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ListaDespesas.jsp" path="." forShow="True" url="ListaDespesas.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ListaDespesasHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="31" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
