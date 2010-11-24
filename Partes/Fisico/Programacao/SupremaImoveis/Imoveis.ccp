<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" connection="Conexao" needGeneration="0" pasteActions="pasteActions">
	<Components>
		<IncludePage id="41" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<FlashChart id="42" secured="False" dataSeriesIn="Columns" chartType="3d_columns" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart1" PathID="FlashChart1" schemaName="Classic" layout="11" connection="Conexao" dataSource="tbl_imovel" gridCaptionField="Data" isCaption="true" width="400" height="300" displayTitle="True" title="Carteira de Imoveis" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="degrees" autoRotate="yes" template="&lt;root&gt;
	&lt;schema name=&quot;Classic&quot;&gt;
		&lt;mask/&gt;
		&lt;colors/&gt;
	&lt;/schema&gt;
	&lt;separator decimal=&quot;,&quot; group=&quot;&quot;/&gt;
	&lt;background border=&quot;yes&quot;/&gt;
	&lt;chartarea border=&quot;yes&quot;&gt;
		&lt;grid line_style=&quot;medium&quot; visible=&quot;yes&quot;/&gt;
		&lt;vertical_axis visible=&quot;yes&quot;/&gt;
		&lt;horizontal_axis visible=&quot;yes&quot; rotation=&quot;degrees&quot; autoRotate=&quot;yes&quot;/&gt;
		&lt;chart line_thick=&quot;2&quot; enabled=&quot;yes&quot; type=&quot;3d_columns&quot; series=&quot;columns&quot;&gt;
			&lt;inscriptions visible=&quot;yes&quot;/&gt;
			&lt;animation type=&quot;none&quot;/&gt;
			&lt;markers size=&quot;8&quot; type=&quot;0&quot;/&gt;
			&lt;hints border=&quot;yes&quot; enabled=&quot;yes&quot;/&gt;
		&lt;/chart&gt;
		&lt;legend sqr_size=&quot;12&quot; sqr_borders=&quot;yes&quot; border_thick=&quot;0&quot; position=&quot;left-center&quot; layout=&quot;vertical&quot; visible=&quot;yes&quot;/&gt;
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;yes&quot; text=&quot;Carteira de Imoveis&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;Cod_Funcionario&quot; name=&quot;Cod_Funcionario&quot;/&gt;&lt;column field=&quot;Cod_Situacao&quot; name=&quot;Cod_Situacao&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{Cod_Funcionario}&quot; col2=&quot;{Cod_Situacao}&quot; name=&quot;{Data}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
" activeCollection="TableParameters">
			<Components/>
			<Events/>
			<Attributes/>
			<DataSeries>
				<Field id="141" fieldName="Cod_Funcionario" alias="Cod_Funcionario"/>
				<Field id="142" fieldName="Cod_Situacao" alias="Cod_Situacao"/>
			</DataSeries>
			<TableParameters>
				<TableParameter id="70" conditionType="Parameter" useIsNull="False" field="Cod_Situacao" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" parameterSource="tbl_situacao.Cod_Situacao" leftBrackets="0" rightBrackets="0"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="67" tableName="tbl_imovel" posLeft="10" posTop="10" posWidth="129" posHeight="180"/>
			</JoinTables>
			<JoinLinks/>
			<Fields/>
			<AllFields>
				<Field id="119" fieldName="Cod_Imovel"/>
				<Field id="120" fieldName="Cod_Cliente"/>
				<Field id="121" fieldName="Cod_Funcionario"/>
				<Field id="123" fieldName="Cod_Situacao"/>
				<Field id="125" fieldName="Cod_destinacao"/>
				<Field id="126" fieldName="Endereco"/>
				<Field id="127" fieldName="CEP"/>
				<Field id="128" fieldName="Bairro"/>
				<Field id="129" fieldName="Cod_Estado"/>
				<Field id="130" fieldName="Cod_Cidade"/>
				<Field id="131" fieldName="N_Quartos"/>
				<Field id="132" fieldName="N_Suites"/>
				<Field id="133" fieldName="N_Banheiros"/>
				<Field id="134" fieldName="N_Salas"/>
				<Field id="135" fieldName="N_Cozinhas"/>
				<Field id="136" fieldName="Dep_Empregada"/>
				<Field id="137" fieldName="Garagem"/>
				<Field id="138" fieldName="Mts_Quadrados"/>
				<Field id="139" fieldName="Data"/>
			</AllFields>
			<SelectedFields>
				<Field id="122" tableName="tbl_imovel" fieldName="Cod_Funcionario" isExpression="False"/>
				<Field id="124" tableName="tbl_imovel" fieldName="Cod_Situacao" isExpression="False"/>
				<Field id="140" tableName="tbl_imovel" fieldName="Data" isExpression="False"/>
			</SelectedFields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Features/>
		</FlashChart>
	</Components>
	<CodeFiles>
		<CodeFile id="FlashChart142" language="JSP" name="ImoveisFlashChart1.xml" path="\" forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="Model" language="JSP" name="Imoveis.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="Imoveis.jsp" path="." forShow="True" url="Imoveis.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="ImoveisHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
