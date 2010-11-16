<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0" pasteActions="pasteActions">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_imovelSearch" returnPage="ListaImovel.ccp" wizardCaption="Buscar Tbl Imovel " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_imovelSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_imovelSearch" PathID="tbl_imovelSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_imovelSearch" PathID="tbl_imovelSearchs_Endereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Bairro" wizardCaption="Bairro" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" parentName="tbl_imovelSearch" PathID="tbl_imovelSearchs_Bairro">
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
		<Grid id="7" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_imovel" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Imovel " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_imovel">
			<Components>
				<Link id="9" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_imovel_Insert" hrefSource="ManterImovel.ccp" removeParameters="Cod_Imovel" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_imovel" PathID="tbl_imoveltbl_imovel_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="12" visible="True" name="Sorter_Cod_Imovel" column="Cod_Imovel" wizardCaption="Cod Imovel" wizardSortingType="SimpleDir" wizardControl="Cod_Imovel" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="13" visible="True" name="Sorter_Cod_Cliente" column="Cod_Cliente" wizardCaption="Cod Cliente" wizardSortingType="SimpleDir" wizardControl="Cod_Cliente" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="14" visible="True" name="Sorter_Cod_Funcionario" column="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSortingType="SimpleDir" wizardControl="Cod_Funcionario" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="15" visible="True" name="Sorter_Cod_Situacao" column="Cod_Situacao" wizardCaption="Cod Situacao" wizardSortingType="SimpleDir" wizardControl="Cod_Situacao" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="16" visible="True" name="Sorter_Cod_destinacao" column="Cod_destinacao" wizardCaption="Cod Destinacao" wizardSortingType="SimpleDir" wizardControl="Cod_destinacao" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_destinacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="17" visible="True" name="Sorter_Endereco" column="Endereco" wizardCaption="Endereco" wizardSortingType="SimpleDir" wizardControl="Endereco" wizardAddNbsp="False" PathID="tbl_imovelSorter_Endereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="18" visible="True" name="Sorter_CEP" column="CEP" wizardCaption="CEP" wizardSortingType="SimpleDir" wizardControl="CEP" wizardAddNbsp="False" PathID="tbl_imovelSorter_CEP">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="19" visible="True" name="Sorter_Bairro" column="Bairro" wizardCaption="Bairro" wizardSortingType="SimpleDir" wizardControl="Bairro" wizardAddNbsp="False" PathID="tbl_imovelSorter_Bairro">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="20" visible="True" name="Sorter_Cod_Estado" column="Cod_Estado" wizardCaption="Cod Estado" wizardSortingType="SimpleDir" wizardControl="Cod_Estado" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="21" visible="True" name="Sorter_Cod_Cidade" column="Cod_Cidade" wizardCaption="Cod Cidade" wizardSortingType="SimpleDir" wizardControl="Cod_Cidade" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="22" visible="True" name="Sorter_N_Quartos" column="N_Quartos" wizardCaption="N Quartos" wizardSortingType="SimpleDir" wizardControl="N_Quartos" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Quartos">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="23" visible="True" name="Sorter_N_Suites" column="N_Suites" wizardCaption="N Suites" wizardSortingType="SimpleDir" wizardControl="N_Suites" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Suites">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="24" visible="True" name="Sorter_N_Banheiros" column="N_Banheiros" wizardCaption="N Banheiros" wizardSortingType="SimpleDir" wizardControl="N_Banheiros" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Banheiros">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="25" visible="True" name="Sorter_N_Salas" column="N_Salas" wizardCaption="N Salas" wizardSortingType="SimpleDir" wizardControl="N_Salas" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Salas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="26" visible="True" name="Sorter_N_Cozinhas" column="N_Cozinhas" wizardCaption="N Cozinhas" wizardSortingType="SimpleDir" wizardControl="N_Cozinhas" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Cozinhas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="27" visible="True" name="Sorter_Dep_Empregada" column="Dep_Empregada" wizardCaption="Dep Empregada" wizardSortingType="SimpleDir" wizardControl="Dep_Empregada" wizardAddNbsp="False" PathID="tbl_imovelSorter_Dep_Empregada">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="28" visible="True" name="Sorter_Garagem" column="Garagem" wizardCaption="Garagem" wizardSortingType="SimpleDir" wizardControl="Garagem" wizardAddNbsp="False" PathID="tbl_imovelSorter_Garagem">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="29" visible="True" name="Sorter_Mts_Quadrados" column="Mts_Quadrados" wizardCaption="Mts Quadrados" wizardSortingType="SimpleDir" wizardControl="Mts_Quadrados" wizardAddNbsp="False" PathID="tbl_imovelSorter_Mts_Quadrados">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="31" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Imovel" fieldSource="Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterImovel.ccp" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Imovel">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="32" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Imovel" source="Cod_Imovel"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="34" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cliente" fieldSource="Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="36" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Funcionario" fieldSource="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="38" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Situacao" fieldSource="Cod_Situacao" wizardCaption="Cod Situacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="40" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_destinacao" fieldSource="Cod_destinacao" wizardCaption="Cod Destinacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_destinacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="42" fieldSourceType="DBColumn" dataType="Text" html="False" name="Endereco" fieldSource="Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="44" fieldSourceType="DBColumn" dataType="Integer" html="False" name="CEP" fieldSource="CEP" wizardCaption="CEP" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCEP">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="46" fieldSourceType="DBColumn" dataType="Text" html="False" name="Bairro" fieldSource="Bairro" wizardCaption="Bairro" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelBairro">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="48" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Estado" fieldSource="Cod_Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="50" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cidade" fieldSource="Cod_Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="52" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Quartos" fieldSource="N_Quartos" wizardCaption="N Quartos" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Quartos">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="54" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Suites" fieldSource="N_Suites" wizardCaption="N Suites" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Suites">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="56" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Banheiros" fieldSource="N_Banheiros" wizardCaption="N Banheiros" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Banheiros">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="58" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Salas" fieldSource="N_Salas" wizardCaption="N Salas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Salas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="60" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Cozinhas" fieldSource="N_Cozinhas" wizardCaption="N Cozinhas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Cozinhas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="62" fieldSourceType="DBColumn" dataType="Boolean" html="False" name="Dep_Empregada" fieldSource="Dep_Empregada" wizardCaption="Dep Empregada" wizardSize="1" wizardMaxLength="1" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelDep_Empregada">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="64" fieldSourceType="DBColumn" dataType="Boolean" html="False" name="Garagem" fieldSource="Garagem" wizardCaption="Garagem" wizardSize="1" wizardMaxLength="1" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelGaragem">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="66" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Mts_Quadrados" fieldSource="Mts_Quadrados" wizardCaption="Mts Quadrados" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelMts_Quadrados">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="67" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="68" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="10" conditionType="Parameter" useIsNull="False" field="Endereco" parameterSource="s_Endereco" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
				<TableParameter id="11" conditionType="Parameter" useIsNull="False" field="Bairro" parameterSource="s_Bairro" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="2"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="8" tableName="tbl_imovel" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="30" tableName="tbl_imovel" fieldName="Cod_Imovel"/>
				<Field id="33" tableName="tbl_imovel" fieldName="Cod_Cliente"/>
				<Field id="35" tableName="tbl_imovel" fieldName="Cod_Funcionario"/>
				<Field id="37" tableName="tbl_imovel" fieldName="Cod_Situacao"/>
				<Field id="39" tableName="tbl_imovel" fieldName="Cod_destinacao"/>
				<Field id="41" tableName="tbl_imovel" fieldName="Endereco"/>
				<Field id="43" tableName="tbl_imovel" fieldName="CEP"/>
				<Field id="45" tableName="tbl_imovel" fieldName="Bairro"/>
				<Field id="47" tableName="tbl_imovel" fieldName="Cod_Estado"/>
				<Field id="49" tableName="tbl_imovel" fieldName="Cod_Cidade"/>
				<Field id="51" tableName="tbl_imovel" fieldName="N_Quartos"/>
				<Field id="53" tableName="tbl_imovel" fieldName="N_Suites"/>
				<Field id="55" tableName="tbl_imovel" fieldName="N_Banheiros"/>
				<Field id="57" tableName="tbl_imovel" fieldName="N_Salas"/>
				<Field id="59" tableName="tbl_imovel" fieldName="N_Cozinhas"/>
				<Field id="61" tableName="tbl_imovel" fieldName="Dep_Empregada"/>
				<Field id="63" tableName="tbl_imovel" fieldName="Garagem"/>
				<Field id="65" tableName="tbl_imovel" fieldName="Mts_Quadrados"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="70" name="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaImovel.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ListaImovel.jsp" path="." forShow="True" url="ListaImovel.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ListaImovelHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="69" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
