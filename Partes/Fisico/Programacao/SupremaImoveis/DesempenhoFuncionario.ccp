<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" connection="Conexao" pasteActions="pasteActions" needGeneration="0">
	<Components>
		<IncludePage id="2" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<FlashChart id="3" secured="False" dataSeriesIn="Columns" chartType="round_columns_horizontal" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart1" PathID="FlashChart1" connection="Conexao" dataSource="tbl_funcionario, view_desempenho_aluguel, view_desempenho_venda" activeCollection="TableParameters" schemaName="Autumn" layout="11" gridCaptionField="Nome" width="400" height="300" displayTitle="True" title="Desempenho De Funcionarios" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="degrees" autoRotate="yes" template="&lt;root&gt;
	&lt;schema name=&quot;Autumn&quot;&gt;
		&lt;mask/&gt;
		&lt;colors/&gt;
	&lt;/schema&gt;
	&lt;separator decimal=&quot;,&quot; group=&quot;&quot;/&gt;
	&lt;background border=&quot;yes&quot;/&gt;
	&lt;chartarea border=&quot;yes&quot;&gt;
		&lt;grid line_style=&quot;medium&quot; visible=&quot;yes&quot;/&gt;
		&lt;vertical_axis visible=&quot;yes&quot;/&gt;
		&lt;horizontal_axis visible=&quot;yes&quot; rotation=&quot;degrees&quot; autoRotate=&quot;yes&quot;/&gt;
		&lt;chart line_thick=&quot;2&quot; enabled=&quot;yes&quot; type=&quot;round_columns_horizontal&quot; series=&quot;columns&quot;&gt;
			&lt;inscriptions visible=&quot;yes&quot;/&gt;
			&lt;animation type=&quot;none&quot;/&gt;
			&lt;markers size=&quot;8&quot; type=&quot;0&quot;/&gt;
			&lt;hints border=&quot;yes&quot; enabled=&quot;yes&quot;/&gt;
		&lt;/chart&gt;
		&lt;legend sqr_size=&quot;12&quot; sqr_borders=&quot;yes&quot; border_thick=&quot;0&quot; position=&quot;left-center&quot; layout=&quot;vertical&quot; visible=&quot;yes&quot;/&gt;
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;yes&quot; text=&quot;Desempenho De Funcionarios&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;Alugados&quot; name=&quot;Alugados&quot;/&gt;&lt;column field=&quot;Vendidos&quot; name=&quot;Vendidos&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{Alugados}&quot; col2=&quot;{Vendidos}&quot; name=&quot;{Nome}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
" isCaption="true">
			<Components/>
			<Events/>
			<Attributes/>
			<DataSeries>
				<Field id="121" fieldName="Alugados" alias="Alugados"/>
				<Field id="122" fieldName="Vendidos" alias="Vendidos"/>
			</DataSeries>
			<TableParameters>
				<TableParameter id="12" conditionType="Parameter" useIsNull="False" field="tbl_funcionario.Cod_Funcionario" dataType="Integer" searchConditionType="Equal" parameterType="URL" logicOperator="And" leftBrackets="0" rightBrackets="0" parameterSource="view_desemprenho_aluguel.View_cod2"/>
			</TableParameters>
			<JoinTables>
				<JoinTable id="10" tableName="tbl_funcionario" posLeft="372" posTop="10" posWidth="155" posHeight="180"/>
				<JoinTable id="38" tableName="view_desempenho_aluguel" posLeft="21" posTop="10" posWidth="116" posHeight="100"/>
				<JoinTable id="39" tableName="view_desempenho_venda" posLeft="173" posTop="113" posWidth="116" posHeight="100"/>
			</JoinTables>
			<JoinLinks>
				<JoinTable2 id="45" tableLeft="view_desempenho_aluguel" tableRight="tbl_funcionario" fieldLeft="view_desempenho_aluguel.View_cod2" fieldRight="tbl_funcionario.Cod_Funcionario" joinType="inner" conditionType="Equal"/>
				<JoinTable2 id="47" tableLeft="view_desempenho_venda" tableRight="view_desempenho_aluguel" fieldLeft="view_desempenho_venda.View_cod" fieldRight="view_desempenho_aluguel.View_cod2" joinType="inner" conditionType="Equal"/>
				<JoinTable2 id="51" tableLeft="view_desempenho_aluguel" tableRight="tbl_funcionario" fieldLeft="view_desempenho_aluguel.View_cod2" fieldRight="tbl_funcionario.Cod_Funcionario" joinType="inner" conditionType="Equal"/>
				<JoinTable2 id="52" tableLeft="view_desempenho_venda" tableRight="view_desempenho_aluguel" fieldLeft="view_desempenho_venda.View_cod" fieldRight="view_desempenho_aluguel.View_cod2" joinType="inner" conditionType="Equal"/>
				<JoinTable2 id="53" tableLeft="view_desempenho_venda" tableRight="tbl_funcionario" fieldLeft="view_desempenho_venda.View_cod" fieldRight="tbl_funcionario.Cod_Funcionario" joinType="inner" conditionType="Equal"/>
			</JoinLinks>
			<Fields>
				<Field id="50" fieldName="*"/>
			</Fields>
			<AllFields>
				<Field id="100" fieldName="Cod_Funcionario"/>
				<Field id="101" fieldName="Nome"/>
				<Field id="102" fieldName="Cod_Cidade"/>
				<Field id="103" fieldName="Cod_Estado"/>
				<Field id="104" fieldName="Cod_Orgao"/>
				<Field id="105" fieldName="Nome_U"/>
				<Field id="106" fieldName="Senha_U"/>
				<Field id="107" fieldName="Endereco"/>
				<Field id="108" fieldName="Tel_Fixo"/>
				<Field id="109" fieldName="Tel_Cel"/>
				<Field id="110" fieldName="CPF"/>
				<Field id="111" fieldName="Data_Nasc"/>
				<Field id="112" fieldName="CRECI"/>
				<Field id="113" fieldName="Nivel_Controle"/>
				<Field id="114" fieldName="View_cod2"/>
				<Field id="115" fieldName="Alugados"/>
				<Field id="117" fieldName="View_cod"/>
				<Field id="118" fieldName="Vendidos"/>
			</AllFields>
			<SelectedFields>
				<Field id="116" tableName="view_desempenho_aluguel" fieldName="Alugados" isExpression="False"/>
				<Field id="119" tableName="view_desempenho_venda" fieldName="Vendidos" isExpression="False"/>
				<Field id="120" tableName="tbl_funcionario" fieldName="Nome" isExpression="False"/>
			</SelectedFields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Features/>
		</FlashChart>
	</Components>
	<CodeFiles>
		<CodeFile id="FlashChart13" language="JSP" name="DesempenhoFuncionarioFlashChart1.xml" path="\" forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="Model" language="JSP" name="DesempenhoFuncionario.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="DesempenhoFuncionario.jsp" path="." forShow="True" url="DesempenhoFuncionario.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="DesempenhoFuncionarioHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
