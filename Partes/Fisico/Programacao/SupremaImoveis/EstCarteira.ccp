<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<IncludePage id="2" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<FlashChart id="3" secured="False" dataSeriesIn="Columns" chartType="3d_columns" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart1" PathID="FlashChart1" schemaName="Autumn" layout="11" connection="Conexao" dataSource="tbl_funcionario" gridCaptionField="-1" isCaption="true" width="400" height="300" displayTitle="True" title="Chart Title" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="degrees" autoRotate="yes" template="&lt;root&gt;
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
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;yes&quot; text=&quot;Chart Title&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;Cod_Funcionario&quot; name=&quot;Cod_Funcionario&quot;/&gt;&lt;column field=&quot;Cod_Cidade&quot; name=&quot;Cod_Cidade&quot;/&gt;&lt;column field=&quot;Cod_Estado&quot; name=&quot;Cod_Estado&quot;/&gt;&lt;column field=&quot;Cod_Orgao&quot; name=&quot;Cod_Orgao&quot;/&gt;&lt;column field=&quot;Tel_Fixo&quot; name=&quot;Tel_Fixo&quot;/&gt;&lt;column field=&quot;Nivel_Controle&quot; name=&quot;Nivel_Controle&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{Cod_Funcionario}&quot; col2=&quot;{Cod_Cidade}&quot; col3=&quot;{Cod_Estado}&quot; col4=&quot;{Cod_Orgao}&quot; col5=&quot;{Tel_Fixo}&quot; col6=&quot;{Nivel_Controle}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
">
			<Components/>
			<Events/>
			<Attributes/>
			<DataSeries>
				<Field id="4" fieldName="Cod_Funcionario" alias="Cod_Funcionario"/>
				<Field id="5" fieldName="Cod_Cidade" alias="Cod_Cidade"/>
				<Field id="6" fieldName="Cod_Estado" alias="Cod_Estado"/>
				<Field id="7" fieldName="Cod_Orgao" alias="Cod_Orgao"/>
				<Field id="8" fieldName="Tel_Fixo" alias="Tel_Fixo"/>
				<Field id="9" fieldName="Nivel_Controle" alias="Nivel_Controle"/>
			</DataSeries>
			<TableParameters/>
			<JoinTables/>
			<JoinLinks/>
			<Fields/>
			<AllFields>
				<Field id="10" fieldName="Cod_Funcionario"/>
				<Field id="11" fieldName="Nome"/>
				<Field id="12" fieldName="Cod_Cidade"/>
				<Field id="13" fieldName="Cod_Estado"/>
				<Field id="14" fieldName="Cod_Orgao"/>
				<Field id="15" fieldName="Nome_U"/>
				<Field id="16" fieldName="Senha_U"/>
				<Field id="17" fieldName="Endereco"/>
				<Field id="18" fieldName="Tel_Fixo"/>
				<Field id="19" fieldName="Tel_Cel"/>
				<Field id="20" fieldName="CPF"/>
				<Field id="21" fieldName="Data_Nasc"/>
				<Field id="22" fieldName="CRECI"/>
				<Field id="23" fieldName="Nivel_Controle"/>
			</AllFields>
			<SelectedFields>
				<Field id="24" tableName="tbl_funcionario" fieldName="Cod_Funcionario" isExpression="False"/>
				<Field id="25" tableName="tbl_funcionario" fieldName="Cod_Cidade" isExpression="False"/>
				<Field id="26" tableName="tbl_funcionario" fieldName="Cod_Estado" isExpression="False"/>
				<Field id="27" tableName="tbl_funcionario" fieldName="Cod_Orgao" isExpression="False"/>
				<Field id="28" tableName="tbl_funcionario" fieldName="Tel_Fixo" isExpression="False"/>
				<Field id="29" tableName="tbl_funcionario" fieldName="Nivel_Controle" isExpression="False"/>
			</SelectedFields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Features/>
		</FlashChart>
	</Components>
	<CodeFiles>
		<CodeFile id="FlashChart13" language="JSP" name="EstCarteiraFlashChart1.xml" path="\" forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="Model" language="JSP" name="EstCarteira.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="EstCarteira.jsp" path="." forShow="True" url="EstCarteira.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="EstCarteiraHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
