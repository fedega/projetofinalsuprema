<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_cidadeSearch" returnPage="ListaCidade.ccp" wizardCaption="Buscar Tbl Cidade " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_cidadeSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" PathID="tbl_cidadeSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Dynamic" fieldSourceType="DBColumn" dataType="Text" name="s_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" PathID="tbl_cidadeSearchs_Nome" features="(assigned)">
					<Components/>
					<Events/>
					<Attributes/>
					<Features>
						<HideShow id="25" enabled="True" name="HideShow1" category="Ajax" featureNameChanged="No" ccsIdsOnly="False" show="tbl_cidadeSearch.onload;">
							<Components/>
							<Events/>
							<ControlPoints>
								<ControlPoint id="26" name="tbl_cidadeSearch.onload" relProperty="show">
									<Items>
										<ControlPointItem id="27" name="tbl_cidade_list" ccpId="1" type="Page" isFeature="False"/>
										<ControlPointItem id="28" name="tbl_cidadeSearch" ccpId="2" type="Record" isFeature="False" PathID="tbl_cidadeSearch"/>
									</Items>
								</ControlPoint>
							</ControlPoints>
							<TableParameters/>
							<SPParameters/>
							<SQLParameters/>
							<JoinTables/>
							<JoinLinks/>
							<Fields/>
							<Features/>
						</HideShow>
					</Features>
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
		<Grid id="6" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_cidade" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Cidade " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_cidade, tbl_estado" activeCollection="TableParameters">
			<Components>
				<Link id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_cidade_Insert" hrefSource="ManterCidade.ccp" removeParameters="Cod_Cidade" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" PathID="tbl_cidadetbl_cidade_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="10" visible="True" name="Sorter_Cod_Cidade" column="Cod_Cidade" wizardCaption="Cod Cidade" wizardSortingType="SimpleDir" wizardControl="Cod_Cidade" wizardAddNbsp="False" PathID="tbl_cidadeSorter_Cod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="11" visible="True" name="Sorter_Nome" column="Nome" wizardCaption="Nome" wizardSortingType="SimpleDir" wizardControl="Nome" wizardAddNbsp="False" PathID="tbl_cidadeSorter_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="12" visible="True" name="Sorter_Cod_Estado" column="Cod_Estado" wizardCaption="Cod Estado" wizardSortingType="SimpleDir" wizardControl="Cod_Estado" wizardAddNbsp="False" PathID="tbl_cidadeSorter_Cod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="14" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Cidade" fieldSource="Cod_Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterCidade.ccp" PathID="tbl_cidadeCod_Cidade">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="15" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Cidade" source="Cod_Cidade"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="17" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome" fieldSource="tbl_cidade_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" PathID="tbl_cidadeNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="19" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Estado" fieldSource="UF" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" PathID="tbl_cidadeCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="20" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="21" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="9" conditionType="Parameter" useIsNull="False" field="tbl_cidade.Nome" parameterSource="s_Nome" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
				<TableParameter id="32" conditionType="Parameter" useIsNull="False" field="tbl_cidade.Cod_Estado" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" parameterSource="tbl_estado.Cod_Estado"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="7" tableName="tbl_cidade" posWidth="95" posHeight="104" posLeft="10" posRight="-1" posTop="10"/>
				<JoinTable id="29" tableName="tbl_estado" posLeft="126" posTop="10" posWidth="95" posHeight="104"/>
			</JoinTables>
			<JoinLinks>
				<JoinTable2 id="30" tableLeft="tbl_cidade" tableRight="tbl_estado" fieldLeft="tbl_cidade.Cod_Estado" fieldRight="tbl_estado.Cod_Estado" joinType="inner" conditionType="Equal"/>
			</JoinLinks>
			<Fields>
				<Field id="13" tableName="tbl_cidade" fieldName="Cod_Cidade"/>
				<Field id="16" tableName="tbl_cidade" fieldName="tbl_cidade.Nome" alias="tbl_cidade_Nome"/>
				<Field id="18" tableName="tbl_cidade" fieldName="tbl_cidade.Cod_Estado" alias="tbl_cidade_Cod_Estado"/>
				<Field id="31" tableName="tbl_estado" fieldName="tbl_estado.*"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="23" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="24" name="Footer" PathID="Footer" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaCidade.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ListaCidade.jsp" path="." forShow="True" url="ListaCidade.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ListaCidadeHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="22" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
