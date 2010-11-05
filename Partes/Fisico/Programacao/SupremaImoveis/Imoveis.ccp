<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" connection="Conexao" needGeneration="0">
	<Components>
		<FlashChart id="2" secured="False" dataSeriesIn="Columns" chartType="3d_columns" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart1" PathID="FlashChart1" schemaName="Autumn" layout="11" connection="Conexao" dataSource="tbl_imovel" gridCaptionField="-1" width="400" height="300" displayTitle="True" title="Ganhos" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="degrees" autoRotate="yes" template="&lt;root&gt;
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
		&lt;chart line_thick=&quot;2&quot; enabled=&quot;yes&quot; type=&quot;3d_columns&quot; series=&quot;columns&quot;&gt;
			&lt;inscriptions visible=&quot;yes&quot;/&gt;
			&lt;animation type=&quot;none&quot;/&gt;
			&lt;markers size=&quot;8&quot; type=&quot;0&quot;/&gt;
			&lt;hints border=&quot;yes&quot; enabled=&quot;yes&quot;/&gt;
		&lt;/chart&gt;
		&lt;legend sqr_size=&quot;12&quot; sqr_borders=&quot;yes&quot; border_thick=&quot;0&quot; position=&quot;left-center&quot; layout=&quot;vertical&quot; visible=&quot;yes&quot;/&gt;
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;yes&quot; text=&quot;Ganhos&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;Cod_Funcionario&quot; name=&quot;Cod_Funcionario&quot;/&gt;&lt;column field=&quot;Cod_Cidade&quot; name=&quot;Cod_Cidade&quot;/&gt;&lt;column field=&quot;Cod_Estado&quot; name=&quot;Cod_Estado&quot;/&gt;&lt;column field=&quot;Nivel_Controle&quot; name=&quot;Nivel_Controle&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{Cod_Funcionario}&quot; col2=&quot;{Cod_Cidade}&quot; col3=&quot;{Cod_Estado}&quot; col4=&quot;{Nivel_Controle}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
">
			<Components/>
			<Events/>
			<Attributes/>
			<DataSeries>
				<Field id="53" fieldName="Cod_Funcionario" alias="Cod_Funcionario"/>
				<Field id="54" fieldName="Cod_Cidade" alias="Cod_Cidade"/>
				<Field id="55" fieldName="Cod_Estado" alias="Cod_Estado"/>
				<Field id="56" fieldName="Nivel_Controle" alias="Nivel_Controle"/>
			</DataSeries>
			<TableParameters/>
			<JoinTables/>
			<JoinLinks/>
			<Fields/>
			<AllFields>
				<Field id="35" fieldName="Cod_Funcionario"/>
				<Field id="37" fieldName="Nome"/>
				<Field id="38" fieldName="Cod_Cidade"/>
				<Field id="40" fieldName="Cod_Estado"/>
				<Field id="42" fieldName="Cod_Orgao"/>
				<Field id="43" fieldName="Nome_U"/>
				<Field id="44" fieldName="Senha_U"/>
				<Field id="45" fieldName="Endereco"/>
				<Field id="46" fieldName="Tel_Fixo"/>
				<Field id="47" fieldName="Tel_Cel"/>
				<Field id="48" fieldName="CPF"/>
				<Field id="49" fieldName="Data_Nasc"/>
				<Field id="50" fieldName="CRECI"/>
				<Field id="51" fieldName="Nivel_Controle"/>
			</AllFields>
			<SelectedFields>
				<Field id="36" tableName="tbl_funcionario" fieldName="Cod_Funcionario" isExpression="False"/>
				<Field id="39" tableName="tbl_funcionario" fieldName="Cod_Cidade" isExpression="False"/>
				<Field id="41" tableName="tbl_funcionario" fieldName="Cod_Estado" isExpression="False"/>
				<Field id="52" tableName="tbl_funcionario" fieldName="Nivel_Controle" isExpression="False"/>
			</SelectedFields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Features/>
		</FlashChart>
	</Components>
	<CodeFiles>
		<CodeFile id="FlashChart12" language="JSP" name="ImoveisFlashChart1.xml" path="\" forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
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
