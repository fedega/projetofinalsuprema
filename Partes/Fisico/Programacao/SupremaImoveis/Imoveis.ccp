<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="True" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" connection="Conexao" needGeneration="0" pasteActions="pasteActions">
	<Components>
		<FlashChart id="2" secured="False" dataSeriesIn="Columns" chartType="3d_columns" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart1" PathID="FlashChart1" schemaName="Autumn" layout="11" connection="Conexao" dataSource="tbl_funcionario" gridCaptionField="Data_Nasc" isCaption="true" width="400" height="300" displayTitle="False" title="Carteira De Imoveis" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="degrees" autoRotate="yes" template="&lt;root&gt;
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
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;no&quot; text=&quot;&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;Cod_Orgao&quot; name=&quot;Cod_Orgao&quot;/&gt;&lt;column field=&quot;Nivel_Controle&quot; name=&quot;Nivel_Controle&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{Cod_Orgao}&quot; col2=&quot;{Nivel_Controle}&quot; name=&quot;{Data_Nasc}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
">
			<Components/>
			<Events/>
			<Attributes/>
			<DataSeries>
				<Field id="97" fieldName="Cod_Orgao" alias="Cod_Orgao"/>
<Field id="98" fieldName="Nivel_Controle" alias="Nivel_Controle"/>
</DataSeries>
			<TableParameters/>
			<JoinTables/>
			<JoinLinks/>
			<Fields/>
			<AllFields>
				<Field id="80" fieldName="Cod_Funcionario"/>
<Field id="81" fieldName="Nome"/>
<Field id="82" fieldName="Cod_Cidade"/>
<Field id="83" fieldName="Cod_Estado"/>
<Field id="84" fieldName="Cod_Orgao"/>
<Field id="86" fieldName="Nome_U"/>
<Field id="87" fieldName="Senha_U"/>
<Field id="88" fieldName="Endereco"/>
<Field id="89" fieldName="Tel_Fixo"/>
<Field id="90" fieldName="Tel_Cel"/>
<Field id="91" fieldName="CPF"/>
<Field id="92" fieldName="Data_Nasc"/>
<Field id="93" fieldName="CRECI"/>
<Field id="94" fieldName="Nivel_Controle"/>
</AllFields>
			<SelectedFields>
				<Field id="85" tableName="tbl_funcionario" fieldName="Cod_Orgao" isExpression="False"/>
<Field id="95" tableName="tbl_funcionario" fieldName="Nivel_Controle" isExpression="False"/>
<Field id="96" tableName="tbl_funcionario" fieldName="Data_Nasc" isExpression="False"/>
</SelectedFields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Features/>
		</FlashChart>
		<IncludePage id="41" name="Header" PathID="Header" parentType="Page" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
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
