<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_clienteSearch" returnPage="ListaCliente.ccp" wizardCaption="Buscar Tbl Cliente " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_clienteSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_clienteSearch" PathID="tbl_clienteSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_clienteSearch" PathID="tbl_clienteSearchs_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nome_U" wizardCaption="Nome U" wizardSize="16" wizardMaxLength="16" wizardIsPassword="False" parentName="tbl_clienteSearch" PathID="tbl_clienteSearchs_Nome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="6" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Senha_U" wizardCaption="Senha U" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_clienteSearch" PathID="tbl_clienteSearchs_Senha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nacionalidade" wizardCaption="Nacionalidade" wizardSize="30" wizardMaxLength="30" wizardIsPassword="False" parentName="tbl_clienteSearch" PathID="tbl_clienteSearchs_Nacionalidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Endereco" wizardCaption="Endereco" wizardSize="50" wizardMaxLength="200" wizardIsPassword="False" parentName="tbl_clienteSearch" PathID="tbl_clienteSearchs_Endereco">
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
		<Grid id="10" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_cliente" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Cliente " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_cliente">
			<Components>
				<Link id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_cliente_Insert" hrefSource="ManterCliente.ccp" removeParameters="Cod_Cliente" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_cliente" PathID="tbl_clientetbl_cliente_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="18" visible="True" name="Sorter_Cod_Cliente" column="Cod_Cliente" wizardCaption="Cod Cliente" wizardSortingType="SimpleDir" wizardControl="Cod_Cliente" wizardAddNbsp="False" PathID="tbl_clienteSorter_Cod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="19" visible="True" name="Sorter_Nome" column="Nome" wizardCaption="Nome" wizardSortingType="SimpleDir" wizardControl="Nome" wizardAddNbsp="False" PathID="tbl_clienteSorter_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="20" visible="True" name="Sorter_Data_Nasc" column="Data_Nasc" wizardCaption="Data Nasc" wizardSortingType="SimpleDir" wizardControl="Data_Nasc" wizardAddNbsp="False" PathID="tbl_clienteSorter_Data_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="21" visible="True" name="Sorter_Nome_U" column="Nome_U" wizardCaption="Nome U" wizardSortingType="SimpleDir" wizardControl="Nome_U" wizardAddNbsp="False" PathID="tbl_clienteSorter_Nome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="22" visible="True" name="Sorter_Senha_U" column="Senha_U" wizardCaption="Senha U" wizardSortingType="SimpleDir" wizardControl="Senha_U" wizardAddNbsp="False" PathID="tbl_clienteSorter_Senha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="23" visible="True" name="Sorter_Nacionalidade" column="Nacionalidade" wizardCaption="Nacionalidade" wizardSortingType="SimpleDir" wizardControl="Nacionalidade" wizardAddNbsp="False" PathID="tbl_clienteSorter_Nacionalidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="24" visible="True" name="Sorter_Endereco" column="Endereco" wizardCaption="Endereco" wizardSortingType="SimpleDir" wizardControl="Endereco" wizardAddNbsp="False" PathID="tbl_clienteSorter_Endereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="25" visible="True" name="Sorter_Tel_Fixo" column="Tel_Fixo" wizardCaption="Tel Fixo" wizardSortingType="SimpleDir" wizardControl="Tel_Fixo" wizardAddNbsp="False" PathID="tbl_clienteSorter_Tel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="26" visible="True" name="Sorter_Tel_Cel" column="Tel_Cel" wizardCaption="Tel Cel" wizardSortingType="SimpleDir" wizardControl="Tel_Cel" wizardAddNbsp="False" PathID="tbl_clienteSorter_Tel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="27" visible="True" name="Sorter_Tel_Comercial" column="Tel_Comercial" wizardCaption="Tel Comercial" wizardSortingType="SimpleDir" wizardControl="Tel_Comercial" wizardAddNbsp="False" PathID="tbl_clienteSorter_Tel_Comercial">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="28" visible="True" name="Sorter_Cod_Estado" column="Cod_Estado" wizardCaption="Cod Estado" wizardSortingType="SimpleDir" wizardControl="Cod_Estado" wizardAddNbsp="False" PathID="tbl_clienteSorter_Cod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="29" visible="True" name="Sorter_Cod_Cidade" column="Cod_Cidade" wizardCaption="Cod Cidade" wizardSortingType="SimpleDir" wizardControl="Cod_Cidade" wizardAddNbsp="False" PathID="tbl_clienteSorter_Cod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="30" visible="True" name="Sorter_Cod_Funcionario" column="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSortingType="SimpleDir" wizardControl="Cod_Funcionario" wizardAddNbsp="False" PathID="tbl_clienteSorter_Cod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="31" visible="True" name="Sorter_Orgao_Emissor" column="Orgao_Emissor" wizardCaption="Orgao Emissor" wizardSortingType="SimpleDir" wizardControl="Orgao_Emissor" wizardAddNbsp="False" PathID="tbl_clienteSorter_Orgao_Emissor">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="32" visible="True" name="Sorter_Tipo_Cliente" column="Tipo_Cliente" wizardCaption="Tipo Cliente" wizardSortingType="SimpleDir" wizardControl="Tipo_Cliente" wizardAddNbsp="False" PathID="tbl_clienteSorter_Tipo_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="34" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Cliente" fieldSource="Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterCliente.ccp" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteCod_Cliente">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="35" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Cliente" source="Cod_Cliente"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="37" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome" fieldSource="Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="39" fieldSourceType="DBColumn" dataType="Date" html="False" name="Data_Nasc" fieldSource="Data_Nasc" wizardCaption="Data Nasc" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteData_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="41" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome_U" fieldSource="Nome_U" wizardCaption="Nome U" wizardSize="16" wizardMaxLength="16" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteNome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="43" fieldSourceType="DBColumn" dataType="Text" html="False" name="Senha_U" fieldSource="Senha_U" wizardCaption="Senha U" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteSenha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="45" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nacionalidade" fieldSource="Nacionalidade" wizardCaption="Nacionalidade" wizardSize="30" wizardMaxLength="30" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteNacionalidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="47" fieldSourceType="DBColumn" dataType="Text" html="False" name="Endereco" fieldSource="Endereco" wizardCaption="Endereco" wizardSize="50" wizardMaxLength="200" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="49" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Fixo" fieldSource="Tel_Fixo" wizardCaption="Tel Fixo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteTel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="51" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Cel" fieldSource="Tel_Cel" wizardCaption="Tel Cel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteTel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="53" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Comercial" fieldSource="Tel_Comercial" wizardCaption="Tel Comercial" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteTel_Comercial">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="55" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Estado" fieldSource="Cod_Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="57" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cidade" fieldSource="Cod_Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteCod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="59" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Funcionario" fieldSource="Cod_Funcionario" wizardCaption="Cod Funcionario" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteCod_Funcionario">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="61" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Orgao_Emissor" fieldSource="Orgao_Emissor" wizardCaption="Orgao Emissor" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteOrgao_Emissor">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="63" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tipo_Cliente" fieldSource="Tipo_Cliente" wizardCaption="Tipo Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_cliente" rowNumber="1" PathID="tbl_clienteTipo_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="64" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="65" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
							</Actions>
						</Event>
					</Events>
					<Attributes/>
					<Features/>
				</Navigator>
			</Components>
			<Events/>
			<TableParameters>
				<TableParameter id="13" conditionType="Parameter" useIsNull="False" field="Nome" parameterSource="s_Nome" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="1"/>
				<TableParameter id="14" conditionType="Parameter" useIsNull="False" field="Nome_U" parameterSource="s_Nome_U" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="2"/>
				<TableParameter id="15" conditionType="Parameter" useIsNull="False" field="Senha_U" parameterSource="s_Senha_U" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="3"/>
				<TableParameter id="16" conditionType="Parameter" useIsNull="False" field="Nacionalidade" parameterSource="s_Nacionalidade" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="4"/>
				<TableParameter id="17" conditionType="Parameter" useIsNull="False" field="Endereco" parameterSource="s_Endereco" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="5"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="11" tableName="tbl_cliente" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="33" tableName="tbl_cliente" fieldName="Cod_Cliente"/>
				<Field id="36" tableName="tbl_cliente" fieldName="Nome"/>
				<Field id="38" tableName="tbl_cliente" fieldName="Data_Nasc"/>
				<Field id="40" tableName="tbl_cliente" fieldName="Nome_U"/>
				<Field id="42" tableName="tbl_cliente" fieldName="Senha_U"/>
				<Field id="44" tableName="tbl_cliente" fieldName="Nacionalidade"/>
				<Field id="46" tableName="tbl_cliente" fieldName="Endereco"/>
				<Field id="48" tableName="tbl_cliente" fieldName="Tel_Fixo"/>
				<Field id="50" tableName="tbl_cliente" fieldName="Tel_Cel"/>
				<Field id="52" tableName="tbl_cliente" fieldName="Tel_Comercial"/>
				<Field id="54" tableName="tbl_cliente" fieldName="Cod_Estado"/>
				<Field id="56" tableName="tbl_cliente" fieldName="Cod_Cidade"/>
				<Field id="58" tableName="tbl_cliente" fieldName="Cod_Funcionario"/>
				<Field id="60" tableName="tbl_cliente" fieldName="Orgao_Emissor"/>
				<Field id="62" tableName="tbl_cliente" fieldName="Tipo_Cliente"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="67" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="68" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaCliente.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="ListaCliente.jsp" path="." forShow="True" url="ListaCliente.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="ListaClienteHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups>
		<Group id="66" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
