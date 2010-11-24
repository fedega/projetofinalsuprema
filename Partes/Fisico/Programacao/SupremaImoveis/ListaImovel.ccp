<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0" pasteActions="pasteActions">
	<Components>
		<Grid id="2" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_imovel" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Imovel " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_imovel, tbl_cliente, tbl_destinacao, tbl_estado, tbl_cidade, tbl_funcionario, tbl_situacao" activeCollection="TableParameters">
			<Components>
				<Link id="14" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_imovel_Insert" hrefSource="ManterImovel.ccp" removeParameters="Cod_Imovel" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_imovel" PathID="tbl_imoveltbl_imovel_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="18" visible="True" name="Sorter_Cod_Imovel" column="Cod_Imovel" wizardCaption="Cod Imovel" wizardSortingType="SimpleDir" wizardControl="Cod_Imovel" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Imovel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="19" visible="True" name="Sorter_Nome" column="tbl_cliente.Nome" wizardCaption="Nome" wizardSortingType="SimpleDir" wizardControl="Nome" wizardAddNbsp="False" PathID="tbl_imovelSorter_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="20" visible="True" name="Sorter_Cod_Situacao" column="Cod_Situacao" wizardCaption="Cod Situacao" wizardSortingType="SimpleDir" wizardControl="Cod_Situacao" wizardAddNbsp="False" PathID="tbl_imovelSorter_Cod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="21" visible="True" name="Sorter_Destinacao" column="Destinacao" wizardCaption="Destinacao" wizardSortingType="SimpleDir" wizardControl="Destinacao" wizardAddNbsp="False" PathID="tbl_imovelSorter_Destinacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="22" visible="True" name="Sorter_Endereco" column="tbl_imovel.Endereco" wizardCaption="Endereco" wizardSortingType="SimpleDir" wizardControl="Endereco" wizardAddNbsp="False" PathID="tbl_imovelSorter_Endereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="23" visible="True" name="Sorter_Bairro" column="Bairro" wizardCaption="Bairro" wizardSortingType="SimpleDir" wizardControl="Bairro" wizardAddNbsp="False" PathID="tbl_imovelSorter_Bairro">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="24" visible="True" name="Sorter_CEP" column="CEP" wizardCaption="CEP" wizardSortingType="SimpleDir" wizardControl="CEP" wizardAddNbsp="False" PathID="tbl_imovelSorter_CEP">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="25" visible="True" name="Sorter_UF" column="UF" wizardCaption="UF" wizardSortingType="SimpleDir" wizardControl="UF" wizardAddNbsp="False" PathID="tbl_imovelSorter_UF">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="26" visible="True" name="Sorter_Nome1" column="tbl_cidade.Nome" wizardCaption="Nome" wizardSortingType="SimpleDir" wizardControl="Nome" wizardAddNbsp="False" PathID="tbl_imovelSorter_Nome1">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="27" visible="True" name="Sorter_Nome2" column="tbl_funcionario.Nome" wizardCaption="Nome" wizardSortingType="SimpleDir" wizardControl="Nome" wizardAddNbsp="False" PathID="tbl_imovelSorter_Nome2">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="28" visible="True" name="Sorter_N_Quartos" column="N_Quartos" wizardCaption="N Quartos" wizardSortingType="SimpleDir" wizardControl="N_Quartos" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Quartos">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="29" visible="True" name="Sorter_N_Suites" column="N_Suites" wizardCaption="N Suites" wizardSortingType="SimpleDir" wizardControl="N_Suites" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Suites">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="30" visible="True" name="Sorter_N_Banheiros" column="N_Banheiros" wizardCaption="N Banheiros" wizardSortingType="SimpleDir" wizardControl="N_Banheiros" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Banheiros">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="31" visible="True" name="Sorter_N_Salas" column="N_Salas" wizardCaption="N Salas" wizardSortingType="SimpleDir" wizardControl="N_Salas" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Salas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="32" visible="True" name="Sorter_N_Cozinhas" column="N_Cozinhas" wizardCaption="N Cozinhas" wizardSortingType="SimpleDir" wizardControl="N_Cozinhas" wizardAddNbsp="False" PathID="tbl_imovelSorter_N_Cozinhas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="33" visible="True" name="Sorter_Dep_Empregada" column="Dep_Empregada" wizardCaption="Dep Empregada" wizardSortingType="SimpleDir" wizardControl="Dep_Empregada" wizardAddNbsp="False" PathID="tbl_imovelSorter_Dep_Empregada">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="34" visible="True" name="Sorter_Garagem" column="Garagem" wizardCaption="Garagem" wizardSortingType="SimpleDir" wizardControl="Garagem" wizardAddNbsp="False" PathID="tbl_imovelSorter_Garagem">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="35" visible="True" name="Sorter_Mts_Quadrados" column="Mts_Quadrados" wizardCaption="Mts Quadrados" wizardSortingType="SimpleDir" wizardControl="Mts_Quadrados" wizardAddNbsp="False" PathID="tbl_imovelSorter_Mts_Quadrados">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="36" visible="True" name="Sorter_Data" column="Data" wizardCaption="Data" wizardSortingType="SimpleDir" wizardControl="Data" wizardAddNbsp="False" PathID="tbl_imovelSorter_Data">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="38" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Imovel" fieldSource="Cod_Imovel" wizardCaption="Cod Imovel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterImovel.ccp" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Imovel">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="39" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Imovel" source="Cod_Imovel"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="41" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome" fieldSource="tbl_cliente_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="43" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Situacao" fieldSource="Situacao" wizardCaption="Cod Situacao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCod_Situacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="45" fieldSourceType="DBColumn" dataType="Text" html="False" name="Destinacao" fieldSource="Destinacao" wizardCaption="Destinacao" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelDestinacao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="47" fieldSourceType="DBColumn" dataType="Text" html="False" name="Endereco" fieldSource="tbl_imovel_Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="49" fieldSourceType="DBColumn" dataType="Text" html="False" name="Bairro" fieldSource="Bairro" wizardCaption="Bairro" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelBairro">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="51" fieldSourceType="DBColumn" dataType="Integer" html="False" name="CEP" fieldSource="CEP" wizardCaption="CEP" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelCEP">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="53" fieldSourceType="DBColumn" dataType="Text" html="False" name="UF" fieldSource="UF" wizardCaption="UF" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelUF">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="55" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome1" fieldSource="tbl_cidade_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelNome1">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="57" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome2" fieldSource="tbl_funcionario_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelNome2">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="59" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Quartos" fieldSource="N_Quartos" wizardCaption="N Quartos" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Quartos">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="61" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Suites" fieldSource="N_Suites" wizardCaption="N Suites" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Suites">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="63" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Banheiros" fieldSource="N_Banheiros" wizardCaption="N Banheiros" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Banheiros">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="65" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Salas" fieldSource="N_Salas" wizardCaption="N Salas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Salas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="67" fieldSourceType="DBColumn" dataType="Integer" html="False" name="N_Cozinhas" fieldSource="N_Cozinhas" wizardCaption="N Cozinhas" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelN_Cozinhas">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="69" fieldSourceType="DBColumn" dataType="Boolean" html="False" name="Dep_Empregada" fieldSource="Dep_Empregada" wizardCaption="Dep Empregada" wizardSize="1" wizardMaxLength="1" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelDep_Empregada">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="71" fieldSourceType="DBColumn" dataType="Boolean" html="False" name="Garagem" fieldSource="Garagem" wizardCaption="Garagem" wizardSize="1" wizardMaxLength="1" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelGaragem">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="73" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Mts_Quadrados" fieldSource="Mts_Quadrados" wizardCaption="Mts Quadrados" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelMts_Quadrados">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="75" fieldSourceType="DBColumn" dataType="Date" html="False" name="Data" fieldSource="Data" wizardCaption="Data" wizardSize="8" wizardMaxLength="100" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_imovel" rowNumber="1" PathID="tbl_imovelData">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="76" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="77" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="15" conditionType="Parameter" useIsNull="False" field="tbl_imovel.Cod_Cliente" parameterSource="s_Cod_Cliente" dataType="Integer" logicOperator="And" searchConditionType="Equal" parameterType="URL" orderNumber="1"/>
				<TableParameter id="16" conditionType="Parameter" useIsNull="False" field="tbl_imovel.Endereco" parameterSource="s_Endereco" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
				<TableParameter id="17" conditionType="Parameter" useIsNull="False" field="tbl_imovel.Bairro" parameterSource="s_Bairro" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="2"/>
				<TableParameter id="87" conditionType="Parameter" useIsNull="False" field="tbl_situacao.Cod_Situacao" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" parameterSource="tbl_imovel.cod_situacao"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="3" tableName="tbl_imovel" posWidth="155" posHeight="180" posLeft="10" posRight="-1" posTop="10"/>
				<JoinTable id="4" tableName="tbl_cliente" posWidth="155" posHeight="180" posLeft="186" posRight="-1" posTop="10"/>
				<JoinTable id="6" tableName="tbl_destinacao" posWidth="129" posHeight="100" posLeft="362" posRight="-1" posTop="10"/>
				<JoinTable id="8" tableName="tbl_estado" posWidth="116" posHeight="120" posLeft="362" posRight="-1" posTop="120"/>
				<JoinTable id="10" tableName="tbl_cidade" posWidth="116" posHeight="120" posLeft="21" posRight="-1" posTop="200"/>
				<JoinTable id="12" tableName="tbl_funcionario" posWidth="155" posHeight="180" posLeft="158" posRight="-1" posTop="200"/>
				<JoinTable id="84" tableName="tbl_situacao" posLeft="499" posTop="110" posWidth="116" posHeight="100"/>
			</JoinTables>
			<JoinLinks>
				<JoinTable2 id="5" tableLeft="tbl_imovel" fieldLeft="tbl_imovel.Cod_Cliente" tableRight="tbl_cliente" fieldRight="tbl_cliente.Cod_Cliente" conditionType="Equal" joinType="left"/>
				<JoinTable2 id="7" tableLeft="tbl_imovel" fieldLeft="tbl_imovel.Cod_destinacao" tableRight="tbl_destinacao" fieldRight="tbl_destinacao.Cod_destinacao" conditionType="Equal" joinType="left"/>
				<JoinTable2 id="9" tableLeft="tbl_imovel" fieldLeft="tbl_imovel.Cod_Estado" tableRight="tbl_estado" fieldRight="tbl_estado.Cod_Estado" conditionType="Equal" joinType="left"/>
				<JoinTable2 id="11" tableLeft="tbl_imovel" fieldLeft="tbl_imovel.Cod_Cidade" tableRight="tbl_cidade" fieldRight="tbl_cidade.Cod_Cidade" conditionType="Equal" joinType="left"/>
				<JoinTable2 id="13" tableLeft="tbl_imovel" fieldLeft="tbl_imovel.Cod_Funcionario" tableRight="tbl_funcionario" fieldRight="tbl_funcionario.Cod_Funcionario" conditionType="Equal" joinType="left"/>
				<JoinTable2 id="85" tableLeft="tbl_imovel" tableRight="tbl_situacao" fieldLeft="tbl_imovel.Cod_Situacao" fieldRight="tbl_situacao.Cod_Situacao" joinType="inner" conditionType="Equal"/>
			</JoinLinks>
			<Fields>
				<Field id="37" tableName="tbl_imovel" fieldName="tbl_imovel.Cod_Imovel"/>
				<Field id="40" tableName="tbl_cliente" fieldName="tbl_cliente.Nome" alias="tbl_cliente_Nome"/>
				<Field id="42" tableName="tbl_imovel" fieldName="tbl_imovel.Cod_Situacao" alias="tbl_imovel_Cod_Situacao"/>
				<Field id="44" tableName="tbl_destinacao" fieldName="tbl_destinacao.Destinacao"/>
				<Field id="46" tableName="tbl_imovel" fieldName="tbl_imovel.Endereco" alias="tbl_imovel_Endereco"/>
				<Field id="48" tableName="tbl_imovel" fieldName="tbl_imovel.Bairro"/>
				<Field id="50" tableName="tbl_imovel" fieldName="tbl_imovel.CEP"/>
				<Field id="52" tableName="tbl_estado" fieldName="tbl_estado.UF"/>
				<Field id="54" tableName="tbl_cidade" fieldName="tbl_cidade.Nome" alias="tbl_cidade_Nome"/>
				<Field id="56" tableName="tbl_funcionario" fieldName="tbl_funcionario.Nome" alias="tbl_funcionario_Nome"/>
				<Field id="58" tableName="tbl_imovel" fieldName="tbl_imovel.N_Quartos"/>
				<Field id="60" tableName="tbl_imovel" fieldName="tbl_imovel.N_Suites"/>
				<Field id="62" tableName="tbl_imovel" fieldName="tbl_imovel.N_Banheiros"/>
				<Field id="64" tableName="tbl_imovel" fieldName="tbl_imovel.N_Salas"/>
				<Field id="66" tableName="tbl_imovel" fieldName="tbl_imovel.N_Cozinhas"/>
				<Field id="68" tableName="tbl_imovel" fieldName="tbl_imovel.Dep_Empregada"/>
				<Field id="70" tableName="tbl_imovel" fieldName="tbl_imovel.Garagem"/>
				<Field id="72" tableName="tbl_imovel" fieldName="tbl_imovel.Mts_Quadrados"/>
				<Field id="74" tableName="tbl_imovel" fieldName="tbl_imovel.Data"/>
				<Field id="86" tableName="tbl_situacao" fieldName="tbl_situacao.*"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<Record id="78" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_imovelSearch" returnPage="ListaImovel.ccp" wizardCaption="Buscar Tbl Imovel " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_imovelSearch">
			<Components>
				<Button id="79" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_imovelSearch" PathID="tbl_imovelSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="80" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_imovelSearch" PathID="tbl_imovelSearchs_Endereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="81" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Bairro" wizardCaption="Bairro" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" parentName="tbl_imovelSearch" PathID="tbl_imovelSearchs_Bairro">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="82" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" name="s_Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" parentName="tbl_imovelSearch" PathID="tbl_imovelSearchs_Cod_Cliente">
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
		<IncludePage id="83" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
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
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
