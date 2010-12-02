<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<IncludePage id="2" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<FlashChart id="3" secured="False" dataSeriesIn="Columns" chartType="columns" sourceType="Table" defaultPageSize="25" returnValueType="Number" name="FlashChart1" PathID="FlashChart1" schemaName="Autumn" layout="11" connection="Conexao" gridCaptionField="-1" isCaption="true" width="400" height="300" displayTitle="True" title="Carteira De Imoveis" displayLegend="True" displayLabels="True" displayGridLines="True" directionType="degrees" autoRotate="yes" template="&lt;root&gt;
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
		&lt;chart line_thick=&quot;2&quot; enabled=&quot;yes&quot; type=&quot;columns&quot; series=&quot;columns&quot;&gt;
			&lt;inscriptions visible=&quot;yes&quot;/&gt;
			&lt;animation type=&quot;none&quot;/&gt;
			&lt;markers size=&quot;8&quot; type=&quot;0&quot;/&gt;
			&lt;hints border=&quot;yes&quot; enabled=&quot;yes&quot;/&gt;
		&lt;/chart&gt;
		&lt;legend sqr_size=&quot;12&quot; sqr_borders=&quot;yes&quot; border_thick=&quot;0&quot; position=&quot;left-center&quot; layout=&quot;vertical&quot; visible=&quot;yes&quot;/&gt;
		&lt;title position=&quot;top&quot; align=&quot;center&quot; border=&quot;no&quot; alpha=&quot;100&quot; visible=&quot;yes&quot; text=&quot;Carteira De Imoveis&quot;/&gt;
	&lt;/chartarea&gt;
	&lt;objects&gt;
	&lt;/objects&gt;
	&lt;data&gt;
		&lt;columns&gt;
			&lt;column field=&quot;EmAndamentoAlu&quot; name=&quot;Aluguel Em Andamento&quot;/&gt;&lt;column field=&quot;alugado&quot; name=&quot;Alugados&quot;/&gt;&lt;column field=&quot;DisponivelAlu&quot; name=&quot;Disponivel Para Alugar&quot;/&gt;&lt;column field=&quot;CanceladoAlu&quot; name=&quot;Aluguel Cancelado&quot;/&gt;&lt;column field=&quot;EmAndamentoVenda&quot; name=&quot;Venda Em Andamento&quot;/&gt;&lt;column field=&quot;Vendido&quot; name=&quot;Vendidos&quot;/&gt;&lt;column field=&quot;DisponivelVenda&quot; name=&quot;Disponivel Para Venda&quot;/&gt;&lt;column field=&quot;CanceladoVenda&quot; name=&quot;Venda Cancelada&quot;/&gt;&lt;/columns&gt;
		&lt;rows&gt;&lt;!-- BEGIN Row --&gt;&lt;row col1=&quot;{EmAndamentoAlu}&quot; col2=&quot;{alugado}&quot; col3=&quot;{DisponivelAlu}&quot; col4=&quot;{CanceladoAlu}&quot; col5=&quot;{EmAndamentoVenda}&quot; col6=&quot;{Vendido}&quot; col7=&quot;{DisponivelVenda}&quot; col8=&quot;{CanceladoVenda}&quot;/&gt;&lt;!-- END Row --&gt;&lt;/rows&gt;&lt;/data&gt;
&lt;/root&gt;
" dataSource="`estatistica carteira`">
			<Components/>
			<Events/>
			<Attributes/>
			<DataSeries>
				<Field id="149" fieldName="EmAndamentoAlu" alias="Aluguel Em Andamento"/>
				<Field id="150" fieldName="alugado" alias="Alugados"/>
				<Field id="151" fieldName="DisponivelAlu" alias="Disponivel Para Alugar"/>
				<Field id="152" fieldName="CanceladoAlu" alias="Aluguel Cancelado"/>
				<Field id="153" fieldName="EmAndamentoVenda" alias="Venda Em Andamento"/>
				<Field id="154" fieldName="Vendido" alias="Vendidos"/>
				<Field id="155" fieldName="DisponivelVenda" alias="Disponivel Para Venda"/>
				<Field id="156" fieldName="CanceladoVenda" alias="Venda Cancelada"/>
			</DataSeries>
			<TableParameters/>
			<JoinTables>
				<JoinTable id="36" tableName="`estatistica carteira`" posLeft="10" posTop="10" posWidth="160" posHeight="180"/>
			</JoinTables>
			<JoinLinks/>
			<Fields/>
			<AllFields>
				<Field id="133" fieldName="EmAndamentoAlu"/>
				<Field id="135" fieldName="alugado"/>
				<Field id="137" fieldName="DisponivelAlu"/>
				<Field id="139" fieldName="CanceladoAlu"/>
				<Field id="141" fieldName="EmAndamentoVenda"/>
				<Field id="143" fieldName="Vendido"/>
				<Field id="145" fieldName="DisponivelVenda"/>
				<Field id="147" fieldName="CanceladoVenda"/>
			</AllFields>
			<SelectedFields>
				<Field id="134" tableName="`estatistica carteira`" fieldName="EmAndamentoAlu" isExpression="False"/>
				<Field id="136" tableName="`estatistica carteira`" fieldName="alugado" isExpression="False"/>
				<Field id="138" tableName="`estatistica carteira`" fieldName="DisponivelAlu" isExpression="False"/>
				<Field id="140" tableName="`estatistica carteira`" fieldName="CanceladoAlu" isExpression="False"/>
				<Field id="142" tableName="`estatistica carteira`" fieldName="EmAndamentoVenda" isExpression="False"/>
				<Field id="144" tableName="`estatistica carteira`" fieldName="Vendido" isExpression="False"/>
				<Field id="146" tableName="`estatistica carteira`" fieldName="DisponivelVenda" isExpression="False"/>
				<Field id="148" tableName="`estatistica carteira`" fieldName="CanceladoVenda" isExpression="False"/>
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
