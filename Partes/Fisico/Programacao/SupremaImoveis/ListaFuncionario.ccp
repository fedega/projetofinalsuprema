<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_funcionarioSearch" returnPage="ListaFuncionario.ccp" wizardCaption="Buscar Tbl Funcionario " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_funcionarioSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_funcionarioSearch" PathID="tbl_funcionarioSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_funcionarioSearch" PathID="tbl_funcionarioSearchs_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nome_U" wizardCaption="Nome U" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" parentName="tbl_funcionarioSearch" PathID="tbl_funcionarioSearchs_Nome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="6" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_funcionarioSearch" PathID="tbl_funcionarioSearchs_Endereco">
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
		<Grid id="8" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_funcionario" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Funcionario " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_funcionario, tbl_estado, tbl_cidade, tbl_orgaoemissor" activeCollection="TableParameters">
			<Components>
				<Link id="10" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_funcionario_Insert" hrefSource="ManterFuncionario.ccp" removeParameters="Cod_Funcionario" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_funcionario" PathID="tbl_funcionariotbl_funcionario_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="14" visible="True" name="Sorter_Cod_Funcionario" column="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSortingType="SimpleDir" wizardControl="Cod_Funcionario" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Cod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="15" visible="True" name="Sorter_Nome" column="Nome" wizardCaption="Nome" wizardSortingType="SimpleDir" wizardControl="Nome" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="16" visible="True" name="Sorter_Cod_Cidade" column="Cod_Cidade" wizardCaption="Cod Cidade" wizardSortingType="SimpleDir" wizardControl="Cod_Cidade" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Cod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="17" visible="True" name="Sorter_Cod_Estado" column="tbl_funcionario.Cod_Estado" wizardCaption="Cod Estado" wizardSortingType="SimpleDir" wizardControl="Cod_Estado" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Cod_Estado" connection="Conexao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="18" visible="True" name="Sorter_Cod_Orgao" column="Cod_Orgao" wizardCaption="Cod Orgao" wizardSortingType="SimpleDir" wizardControl="Cod_Orgao" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Cod_Orgao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="19" visible="True" name="Sorter_Nome_U" column="Nome_U" wizardCaption="Nome U" wizardSortingType="SimpleDir" wizardControl="Nome_U" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Nome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="20" visible="True" name="Sorter_Endereco" column="Endereco" wizardCaption="Endereco" wizardSortingType="SimpleDir" wizardControl="Endereco" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Endereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="21" visible="True" name="Sorter_Tel_Fixo" column="Tel_Fixo" wizardCaption="Tel Fixo" wizardSortingType="SimpleDir" wizardControl="Tel_Fixo" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Tel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="22" visible="True" name="Sorter_Tel_Cel" column="Tel_Cel" wizardCaption="Tel Cel" wizardSortingType="SimpleDir" wizardControl="Tel_Cel" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Tel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="23" visible="True" name="Sorter_CPF" column="CPF" wizardCaption="CPF" wizardSortingType="SimpleDir" wizardControl="CPF" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_CPF">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="24" visible="True" name="Sorter_Data_Nasc" column="Data_Nasc" wizardCaption="Data Nasc" wizardSortingType="SimpleDir" wizardControl="Data_Nasc" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Data_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="25" visible="True" name="Sorter_CRECI" column="CRECI" wizardCaption="CRECI" wizardSortingType="SimpleDir" wizardControl="CRECI" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_CRECI">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="26" visible="True" name="Sorter_Nivel_Controle" column="Nivel_Controle" wizardCaption="Nivel Controle" wizardSortingType="SimpleDir" wizardControl="Nivel_Controle" wizardAddNbsp="False" PathID="tbl_funcionarioSorter_Nivel_Controle">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="28" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Funcionario" fieldSource="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterFuncionario.ccp" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioCod_Funcionario">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="29" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Funcionario" source="Cod_Funcionario"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="31" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome" fieldSource="tbl_funcionario.Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="33" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioCod_Cidade" fieldSource="tbl_cidade.Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="35" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Estado" fieldSource="UF" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="37" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Orgao" fieldSource="Sigla" wizardCaption="Cod Orgao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioCod_Orgao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="39" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome_U" fieldSource="Nome_U" wizardCaption="Nome U" wizardSize="20" wizardMaxLength="20" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioNome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="41" fieldSourceType="DBColumn" dataType="Text" html="False" name="Endereco" fieldSource="Endereco" wizardCaption="Endereco" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="43" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Fixo" fieldSource="Tel_Fixo" wizardCaption="Tel Fixo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioTel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="45" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Cel" fieldSource="Tel_Cel" wizardCaption="Tel Cel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioTel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="47" fieldSourceType="DBColumn" dataType="Integer" html="False" name="CPF" fieldSource="CPF" wizardCaption="CPF" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioCPF">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="49" fieldSourceType="DBColumn" dataType="Date" html="False" name="Data_Nasc" fieldSource="Data_Nasc" wizardCaption="Data Nasc" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioData_Nasc" format="dd/mm/yyyy" DBFormat="yyyy-mm-dd HH:nn:ss">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="51" fieldSourceType="DBColumn" dataType="Integer" html="False" name="CRECI" fieldSource="CRECI" wizardCaption="CRECI" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioCRECI">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="53" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Nivel_Controle" fieldSource="Nivel_Controle" wizardCaption="Nivel Controle" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_funcionario" rowNumber="1" PathID="tbl_funcionarioNivel_Controle">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="54" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="55" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="11" conditionType="Parameter" useIsNull="False" field="tbl_funcionario.Nome" parameterSource="s_Nome" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1" leftBrackets="0" rightBrackets="0"/>
				<TableParameter id="12" conditionType="Parameter" useIsNull="False" field="tbl_funcionario.Nome_U" parameterSource="s_Nome_U" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="2" leftBrackets="0" rightBrackets="0"/>
				<TableParameter id="13" conditionType="Parameter" useIsNull="False" field="tbl_funcionario.Endereco" parameterSource="s_Endereco" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="3" leftBrackets="0" rightBrackets="0"/>
				<TableParameter id="73" conditionType="Parameter" useIsNull="False" field="tbl_funcionario.Cod_Cidade" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" parameterSource="tbl_cidade.Cod_Cidade"/>
				<TableParameter id="74" conditionType="Parameter" useIsNull="False" field="tbl_funcionario.Cod_Estado" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" parameterSource="tbl_estado.Cod_Estado"/>
				<TableParameter id="75" conditionType="Parameter" useIsNull="False" field="tbl_funcionario.Cod_Orgao" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" parameterSource="tbl_orgaoemissor.Cod_Orgao"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="9" tableName="tbl_funcionario" posWidth="129" posHeight="180" posLeft="10" posRight="-1" posTop="10"/>
				<JoinTable id="66" tableName="tbl_estado" posLeft="160" posTop="10" posWidth="95" posHeight="104"/>
				<JoinTable id="68" tableName="tbl_cidade" posLeft="276" posTop="10" posWidth="95" posHeight="104"/>
				<JoinTable id="71" tableName="tbl_orgaoemissor" posLeft="392" posTop="10" posWidth="95" posHeight="104"/>
			</JoinTables>
			<JoinLinks>
				<JoinTable2 id="67" tableLeft="tbl_funcionario" tableRight="tbl_estado" fieldLeft="tbl_funcionario.Cod_Estado" fieldRight="tbl_estado.Cod_Estado" joinType="inner" conditionType="Equal"/>
				<JoinTable2 id="69" tableLeft="tbl_funcionario" tableRight="tbl_cidade" fieldLeft="tbl_funcionario.Cod_Cidade" fieldRight="tbl_cidade.Cod_Cidade" joinType="inner" conditionType="Equal"/>
				<JoinTable2 id="70" tableLeft="tbl_cidade" tableRight="tbl_estado" fieldLeft="tbl_cidade.Cod_Estado" fieldRight="tbl_estado.Cod_Estado" joinType="inner" conditionType="Equal"/>
				<JoinTable2 id="72" tableLeft="tbl_funcionario" tableRight="tbl_orgaoemissor" fieldLeft="tbl_funcionario.Cod_Orgao" fieldRight="tbl_orgaoemissor.Cod_Orgao" joinType="inner" conditionType="Equal"/>
			</JoinLinks>
			<Fields>
				<Field id="65" fieldName="*"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="57" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="58" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaFuncionario.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ListaFuncionario.jsp" path="." forShow="True" url="ListaFuncionario.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ListaFuncionarioHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="56" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
