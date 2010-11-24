<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Record id="2" sourceType="Table" urlType="Relative" secured="False" allowInsert="False" allowUpdate="False" allowDelete="False" validateData="True" preserveParameters="None" returnValueType="Number" returnValueTypeForDelete="Number" returnValueTypeForInsert="Number" returnValueTypeForUpdate="Number" name="tbl_fiadorSearch" returnPage="ListaFiador.ccp" wizardCaption="Buscar Tbl Fiador " wizardOrientation="Vertical" wizardFormMethod="post" PathID="tbl_fiadorSearch">
			<Components>
				<Button id="3" urlType="Relative" enableValidation="True" isDefault="False" name="Button_DoSearch" operation="Search" wizardCaption="Buscar" parentName="tbl_fiadorSearch" PathID="tbl_fiadorSearchButton_DoSearch">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Button>
				<TextBox id="4" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_fiadorSearch" PathID="tbl_fiadorSearchs_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="5" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nome_U" wizardCaption="Nome U" wizardSize="16" wizardMaxLength="16" wizardIsPassword="False" parentName="tbl_fiadorSearch" PathID="tbl_fiadorSearchs_Nome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="6" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Senha_U" wizardCaption="Senha U" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" parentName="tbl_fiadorSearch" PathID="tbl_fiadorSearchs_Senha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="7" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Nacionalidaade" wizardCaption="Nacionalidaade" wizardSize="30" wizardMaxLength="30" wizardIsPassword="False" parentName="tbl_fiadorSearch" PathID="tbl_fiadorSearchs_Nacionalidaade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</TextBox>
				<TextBox id="8" visible="Yes" fieldSourceType="DBColumn" dataType="Text" name="s_Endereco" wizardCaption="Endereco" wizardSize="50" wizardMaxLength="200" wizardIsPassword="False" parentName="tbl_fiadorSearch" PathID="tbl_fiadorSearchs_Endereco">
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
		<Grid id="10" secured="False" sourceType="Table" returnValueType="Number" defaultPageSize="20" name="tbl_fiador" connection="Conexao" pageSizeLimit="100" wizardCaption="List of Tbl Fiador " wizardGridType="Tabular" wizardAllowSorting="True" wizardSortingType="SimpleDir" wizardUsePageScroller="True" wizardAllowInsert="True" wizardAltRecord="False" wizardRecordSeparator="False" wizardAltRecordType="Controls" dataSource="tbl_fiador">
			<Components>
				<Link id="12" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="tbl_fiador_Insert" hrefSource="ManterFiador.ccp" removeParameters="Cod_Fiador" wizardThemeItem="NavigatorLink" wizardDefaultValue="Add New" parentName="tbl_fiador" PathID="tbl_fiadortbl_fiador_Insert">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
				<Sorter id="18" visible="True" name="Sorter_Cod_Fiador" column="Cod_Fiador" wizardCaption="Cod Fiador" wizardSortingType="SimpleDir" wizardControl="Cod_Fiador" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Cod_Fiador">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="19" visible="True" name="Sorter_Cod_Orgao" column="Cod_Orgao" wizardCaption="Cod Orgao" wizardSortingType="SimpleDir" wizardControl="Cod_Orgao" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Cod_Orgao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="20" visible="True" name="Sorter_Cod_Estado" column="Cod_Estado" wizardCaption="Cod Estado" wizardSortingType="SimpleDir" wizardControl="Cod_Estado" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Cod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="21" visible="True" name="Sorter_Cod_Cidade" column="Cod_Cidade" wizardCaption="Cod Cidade" wizardSortingType="SimpleDir" wizardControl="Cod_Cidade" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Cod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="22" visible="True" name="Sorter_Cod_Cliente" column="Cod_Cliente" wizardCaption="Cod Cliente" wizardSortingType="SimpleDir" wizardControl="Cod_Cliente" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Cod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="23" visible="True" name="Sorter_Nome" column="Nome" wizardCaption="Nome" wizardSortingType="SimpleDir" wizardControl="Nome" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Nome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="24" visible="True" name="Sorter_Data_Nasc" column="Data_Nasc" wizardCaption="Data Nasc" wizardSortingType="SimpleDir" wizardControl="Data_Nasc" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Data_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="25" visible="True" name="Sorter_Nome_U" column="Nome_U" wizardCaption="Nome U" wizardSortingType="SimpleDir" wizardControl="Nome_U" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Nome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="26" visible="True" name="Sorter_Senha_U" column="Senha_U" wizardCaption="Senha U" wizardSortingType="SimpleDir" wizardControl="Senha_U" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Senha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="27" visible="True" name="Sorter_Nacionalidaade" column="Nacionalidaade" wizardCaption="Nacionalidaade" wizardSortingType="SimpleDir" wizardControl="Nacionalidaade" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Nacionalidaade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="28" visible="True" name="Sorter_Endereco" column="Endereco" wizardCaption="Endereco" wizardSortingType="SimpleDir" wizardControl="Endereco" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Endereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="29" visible="True" name="Sorter_Tel_Fixo" column="Tel_Fixo" wizardCaption="Tel Fixo" wizardSortingType="SimpleDir" wizardControl="Tel_Fixo" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Tel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="30" visible="True" name="Sorter_Tel_Cel" column="Tel_Cel" wizardCaption="Tel Cel" wizardSortingType="SimpleDir" wizardControl="Tel_Cel" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Tel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Sorter id="31" visible="True" name="Sorter_Tel_Comercial" column="Tel_Comercial" wizardCaption="Tel Comercial" wizardSortingType="SimpleDir" wizardControl="Tel_Comercial" wizardAddNbsp="False" PathID="tbl_fiadorSorter_Tel_Comercial">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Sorter>
				<Link id="33" visible="Yes" fieldSourceType="DBColumn" dataType="Integer" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="Cod_Fiador" fieldSource="Cod_Fiador" wizardCaption="Cod Fiador" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" hrefSource="ManterFiador.ccp" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorCod_Fiador">
					<Components/>
					<Events/>
					<LinkParameters>
						<LinkParameter id="34" sourceType="DataField" format="yyyy-mm-dd" name="Cod_Fiador" source="Cod_Fiador"/>
					</LinkParameters>
					<Attributes/>
					<Features/>
				</Link>
				<Label id="36" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Orgao" fieldSource="Cod_Orgao" wizardCaption="Cod Orgao" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorCod_Orgao">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="38" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Estado" fieldSource="Cod_Estado" wizardCaption="Cod Estado" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorCod_Estado">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="40" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cidade" fieldSource="Cod_Cidade" wizardCaption="Cod Cidade" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorCod_Cidade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="42" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Cod_Cliente" fieldSource="Cod_Cliente" wizardCaption="Cod Cliente" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorCod_Cliente">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="44" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome" fieldSource="Nome" wizardCaption="Nome" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorNome">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="46" fieldSourceType="DBColumn" dataType="Date" html="False" name="Data_Nasc" fieldSource="Data_Nasc" wizardCaption="Data Nasc" wizardSize="10" wizardMaxLength="100" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorData_Nasc">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="48" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nome_U" fieldSource="Nome_U" wizardCaption="Nome U" wizardSize="16" wizardMaxLength="16" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorNome_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="50" fieldSourceType="DBColumn" dataType="Text" html="False" name="Senha_U" fieldSource="Senha_U" wizardCaption="Senha U" wizardSize="40" wizardMaxLength="40" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorSenha_U">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="52" fieldSourceType="DBColumn" dataType="Text" html="False" name="Nacionalidaade" fieldSource="Nacionalidaade" wizardCaption="Nacionalidaade" wizardSize="30" wizardMaxLength="30" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorNacionalidaade">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="54" fieldSourceType="DBColumn" dataType="Text" html="False" name="Endereco" fieldSource="Endereco" wizardCaption="Endereco" wizardSize="50" wizardMaxLength="200" wizardIsPassword="False" wizardAddNbsp="True" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorEndereco">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="56" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Fixo" fieldSource="Tel_Fixo" wizardCaption="Tel Fixo" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorTel_Fixo">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="58" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Cel" fieldSource="Tel_Cel" wizardCaption="Tel Cel" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorTel_Cel">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Label id="60" fieldSourceType="DBColumn" dataType="Integer" html="False" name="Tel_Comercial" fieldSource="Tel_Comercial" wizardCaption="Tel Comercial" wizardSize="10" wizardMaxLength="10" wizardIsPassword="False" wizardAddNbsp="True" wizardAlign="right" parentName="tbl_fiador" rowNumber="1" PathID="tbl_fiadorTel_Comercial">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Label>
				<Navigator id="61" size="10" type="Simple" pageSizes="1;5;10;25;50" name="Navigator" wizardFirst="True" wizardPrev="True" wizardFirstText="|&lt;" wizardPrevText="&lt;&lt;" wizardNextText="&gt;&gt;" wizardLastText="&gt;|" wizardNext="True" wizardLast="True" wizardPageNumbers="Simple" wizardSize="10" wizardTotalPages="True" wizardHideDisabled="True" wizardOfText="de" wizardImagesScheme="Padrao">
					<Components/>
					<Events>
						<Event name="BeforeShow" type="Server">
							<Actions>
								<Action actionName="Hide-Show Component" actionCategory="General" id="62" action="Hide" conditionType="Parameter" dataType="Integer" condition="LessThan" name1="TotalPages" sourceType1="SpecialValue" name2="2" sourceType2="Expression"/>
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
				<TableParameter id="16" conditionType="Parameter" useIsNull="False" field="Nacionalidaade" parameterSource="s_Nacionalidaade" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="4"/>
				<TableParameter id="17" conditionType="Parameter" useIsNull="False" field="Endereco" parameterSource="s_Endereco" dataType="Text" logicOperator="And" searchConditionType="Contains" parameterType="URL" orderNumber="5"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="11" tableName="tbl_fiador" posWidth="-1" posHeight="-1" posLeft="-1" posRight="-1"/>
			</JoinTables>
			<JoinLinks/>
			<Fields>
				<Field id="32" tableName="tbl_fiador" fieldName="Cod_Fiador"/>
				<Field id="35" tableName="tbl_fiador" fieldName="Cod_Orgao"/>
				<Field id="37" tableName="tbl_fiador" fieldName="Cod_Estado"/>
				<Field id="39" tableName="tbl_fiador" fieldName="Cod_Cidade"/>
				<Field id="41" tableName="tbl_fiador" fieldName="Cod_Cliente"/>
				<Field id="43" tableName="tbl_fiador" fieldName="Nome"/>
				<Field id="45" tableName="tbl_fiador" fieldName="Data_Nasc"/>
				<Field id="47" tableName="tbl_fiador" fieldName="Nome_U"/>
				<Field id="49" tableName="tbl_fiador" fieldName="Senha_U"/>
				<Field id="51" tableName="tbl_fiador" fieldName="Nacionalidaade"/>
				<Field id="53" tableName="tbl_fiador" fieldName="Endereco"/>
				<Field id="55" tableName="tbl_fiador" fieldName="Tel_Fixo"/>
				<Field id="57" tableName="tbl_fiador" fieldName="Tel_Cel"/>
				<Field id="59" tableName="tbl_fiador" fieldName="Tel_Comercial"/>
			</Fields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Grid>
		<IncludePage id="64" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<IncludePage id="65" name="Footer" PathID="Footer" parentType="Page" page="Footer.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="ListaFiador.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="ListaFiador.jsp" path="." forShow="True" url="ListaFiador.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ListaFiadorHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups>
		<Group id="63" groupID="1"/>
	</SecurityGroups>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
