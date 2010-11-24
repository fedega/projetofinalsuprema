<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0" connection="Conexao">
	<Components>
		<IncludePage id="2" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<FlashChart id="3" secured="False" dataSeriesIn="Columns" chartType="3d_pie" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart1" PathID="FlashChart1" connection="Conexao" schemaName="Autumn" layout="11" dataSource="tbl_transconcluidas" gridCaptionField="-1" width="400" height="300" displayTitle="True" title="Vendas" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="vertical" autoRotate="no" template="&lt;root&gt;
	&lt;schema name=&quot;Autumn&quot;&gt;
		&lt;mask/&gt;
		&lt;colors/&gt;
	&lt;/schema&gt;
	&lt;separator decimal=&quot;,&quot; group=&quot;&quot;/&gt;
	&lt;background border=&quot;yes&quot;/&gt;
	&lt;chartarea border=&quot;yes&quot;&gt;
		&lt;grid line_style=&quot;medium&quot; visible=&quot;yes&quot;/&gt;
		&lt;vertical_axis visible=&quot;yes&quot;/&gt;
		&lt;horizontal_axis visible=&quot;yes&quot; rotation=&quot;vertical&quot; autoRotate=&quot;no&quot;/&gt;
		&lt;chart line_thick=&quot;2&quot; enabled=&quot;yes&quot; type=&quot;3d_pie&quot; series=&quot;columns&quot;&gt;
			&lt;inscriptions visible=&quot;yes&quot;/&gt;
			&lt;animation type=&quot;none&quot;/&gt;
			&lt;markers size=&quot;8&quot; type=&quot;0&quot;/&gt;
			&lt;hints border=&quot;yes&quot; enabled=&quot;yes&quot;/&gt;
		&lt;/chart&gt;
		&lt;legend sqr_size=&quot;12&quot; sqr_borders=&quot;yes&quot; border_thick=&quot;0&quot; position=&quot;left-center&quot; layout=&quot;vertical&quot; visible=&quot;yes&quot;/&gt;
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;yes&quot; text=&quot;Vendas&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;ConcluidasVendas&quot; name=&quot;Concluidas&quot;/&gt;&lt;column field=&quot;EmAndamentoVendas&quot; name=&quot;Em Andamento&quot;/&gt;&lt;column field=&quot;CanceladasVendas&quot; name=&quot;Canceladas&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{ConcluidasVendas}&quot; col2=&quot;{EmAndamentoVendas}&quot; col3=&quot;{CanceladasVendas}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
">
			<Components/>
			<Events/>
			<Attributes/>
			<DataSeries>
				<Field id="28" fieldName="ConcluidasVendas" alias="Concluidas"/>
				<Field id="29" fieldName="EmAndamentoVendas" alias="Em Andamento"/>
				<Field id="30" fieldName="CanceladasVendas" alias="Canceladas"/>
			</DataSeries>
			<TableParameters/>
			<JoinTables/>
			<JoinLinks/>
			<Fields/>
			<AllFields>
				<Field id="19" fieldName="ConcluidasVendas"/>
				<Field id="21" fieldName="EmAndamentoVendas"/>
				<Field id="23" fieldName="CanceladasVendas"/>
				<Field id="25" fieldName="ConcluidasAluguel"/>
				<Field id="26" fieldName="EmAndamentoAluguel"/>
				<Field id="27" fieldName="CanceladasAluguel"/>
			</AllFields>
			<SelectedFields>
				<Field id="20" tableName="tbl_transconcluidas" fieldName="ConcluidasVendas" isExpression="False"/>
				<Field id="22" tableName="tbl_transconcluidas" fieldName="EmAndamentoVendas" isExpression="False"/>
				<Field id="24" tableName="tbl_transconcluidas" fieldName="CanceladasVendas" isExpression="False"/>
			</SelectedFields>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Features/>
		</FlashChart>
		<FlashChart id="31" secured="False" dataSeriesIn="Columns" chartType="pie" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart2" PathID="FlashChart2" schemaName="Autumn" layout="11" connection="Conexao" dataSource="tbl_transconcluidas" gridCaptionField="-1" width="400" height="300" displayTitle="True" title="Alugueis" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="degrees" autoRotate="yes" template="&lt;root&gt;
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
		&lt;chart line_thick=&quot;2&quot; enabled=&quot;yes&quot; type=&quot;pie&quot; series=&quot;columns&quot;&gt;
			&lt;inscriptions visible=&quot;yes&quot;/&gt;
			&lt;animation type=&quot;none&quot;/&gt;
			&lt;markers size=&quot;8&quot; type=&quot;0&quot;/&gt;
			&lt;hints border=&quot;yes&quot; enabled=&quot;yes&quot;/&gt;
		&lt;/chart&gt;
		&lt;legend sqr_size=&quot;12&quot; sqr_borders=&quot;yes&quot; border_thick=&quot;0&quot; position=&quot;left-center&quot; layout=&quot;vertical&quot; visible=&quot;yes&quot;/&gt;
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;yes&quot; text=&quot;Alugueis&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;ConcluidasAluguel&quot; name=&quot;Concluidos&quot;/&gt;&lt;column field=&quot;EmAndamentoAluguel&quot; name=&quot;Em Andamento&quot;/&gt;&lt;column field=&quot;CanceladasAluguel&quot; name=&quot;Cancelados&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{ConcluidasAluguel}&quot; col2=&quot;{EmAndamentoAluguel}&quot; col3=&quot;{CanceladasAluguel}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
">
<Components/>
<Events/>
<Attributes/>
<DataSeries>
<Field id="65" fieldName="ConcluidasAluguel" alias="Concluidos"/>
<Field id="66" fieldName="EmAndamentoAluguel" alias="Em Andamento"/>
<Field id="67" fieldName="CanceladasAluguel" alias="Cancelados"/>
</DataSeries>
<TableParameters/>
<JoinTables/>
<JoinLinks/>
<Fields/>
<AllFields>
<Field id="56" fieldName="ConcluidasVendas"/>
<Field id="57" fieldName="EmAndamentoVendas"/>
<Field id="58" fieldName="CanceladasVendas"/>
<Field id="59" fieldName="ConcluidasAluguel"/>
<Field id="61" fieldName="EmAndamentoAluguel"/>
<Field id="63" fieldName="CanceladasAluguel"/>
</AllFields>
<SelectedFields>
<Field id="60" tableName="tbl_transconcluidas" fieldName="ConcluidasAluguel" isExpression="False"/>
<Field id="62" tableName="tbl_transconcluidas" fieldName="EmAndamentoAluguel" isExpression="False"/>
<Field id="64" tableName="tbl_transconcluidas" fieldName="CanceladasAluguel" isExpression="False"/>
</SelectedFields>
<SPParameters/>
<SQLParameters/>
<SecurityGroups/>
<Features/>
</FlashChart>
</Components>
	<CodeFiles>
		<CodeFile id="FlashChart13" language="JSP" name="TransConcluidasFlashChart1.xml" path="\" forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="FlashChart231" language="JSP" name="TransConcluidasFlashChart2.xml" path="\" forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="Model" language="JSP" name="TransConcluidas.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="TransConcluidas.jsp" path="." forShow="True" url="TransConcluidas.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="TransConcluidasHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
