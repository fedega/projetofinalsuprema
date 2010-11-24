<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_orgaoemissorSearch" returnPage="ListaOrgao.ccp" wizardCaption="Buscar Tbl Orgaoemissor " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_orgaoemissorSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_orgaoemissorSearch" PathID="tbl_orgaoemissorSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Sigla" wizardCaption="Sigla" wizardSize="5" wizardMaxLength="5" wizardIsPassword="False" parentName="tbl_orgaoemissorSearch" PathID="tbl_orgaoemissorSearchs_Sigla">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Descricao" wizardCaption="Descricao" wizardSize="50" wizardMaxLength="60" wizardIsPassword="False" parentName="tbl_orgaoemissorSearch" PathID="tbl_orgaoemissorSearchs_Descricao">
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
		<Grid id="7" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_orgaoemissor" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Orgaoemissor " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_orgaoemissor">
			<Components>
				<Link id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_orgaoemissor_Insert" hrefSource="ManterOrgao.ccp" removeParameters="Cod_Orgao" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_orgaoemissor" PathID="tbl_orgaoemissortbl_orgaoemissor_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="12" visible="True" name="Sorter_Cod_Orgao" column="Cod_Orgao" wizardCaption="Cod Orgao" wizardSortingType="SimpleDir" wizardControl="Cod_Orgao" wizardAddNbsp="False" PathID="tbl_orgaoemissorSorter_Cod_Orgao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="13" visible="True" name="Sorter_Sigla" column="Sigla" wizardCaption="Sigla" wizardSortingType="SimpleDir" wizardControl="Sigla" wizardAddNbsp="False" PathID="tbl_orgaoemissorSorter_Sigla">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="14" visible="True" name="Sorter_Descricao" column="Descricao" wizardCaption="Descricao" wizardSortingType="SimpleDir" wizardControl="Descricao" wizardAddNbsp="False" PathID="tbl_orgaoemissorSorter_Descricao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="16" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Orgao" fieldSource="Cod_Orgao" wizardCaption="Cod Orgao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterOrgao.ccp" parentName="tbl_orgaoemissor" rowNumber="1" PathID="tbl_orgaoemissorCod_Orgao">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="17" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Orgao" source="Cod_Orgao"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="19" fieldSourceType="DBColumn" dataType="Text" html="False" name="Sigla" fieldSource="Sigla" wizardCaption="Sigla" wizardSize="5" wizardMaxLength="5" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_orgaoemissor" rowNumber="1" PathID="tbl_orgaoemissorSigla">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="21" fieldSourceType="DBColumn" dataType="Text" html="False" name="Descricao" fieldSource="Descricao" wizardCaption="Descricao" wizardSize="50" wizardMaxLength="60" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_orgaoemissor" rowNumber="1" PathID="tbl_orgaoemissorDescricao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="22" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="23" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="10" conditionType="Parameter" useIsNull="False" field="Sigla" parameterSource="s_Sigla" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
				<TableParameter id="11" conditionType="Parameter" useIsNull="False" field="Descricao" parameterSource="s_Descricao" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="2"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="8" tableName="tbl_orgaoemissor" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="15" tableName="tbl_orgaoemissor" fieldName="Cod_Orgao"/>
				<Field id="18" tableName="tbl_orgaoemissor" fieldName="Sigla"/>
				<Field id="20" tableName="tbl_orgaoemissor" fieldName="Descricao"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="25" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="26" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaOrgao.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ListaOrgao.jsp" path="." forShow="True" url="ListaOrgao.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ListaOrgaoHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="27" groupID="2"/>
		<Group id="28" groupID="3"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
