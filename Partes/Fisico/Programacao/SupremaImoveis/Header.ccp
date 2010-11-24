<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="True" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Menu id="2" secured="False" sourceType="Table" returnValueType="Number" name="Menu1" menuType="Horizontal" menuSourceType="Static" PathID="HeaderMenu1">
			<Components>
				<Link id="3" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="ItemLink" PathID="HeaderMenu1ItemLink">
					<Components/>
					<Events/>
					<LinkParameters/>
					<Attributes/>
					<Features/>
				</Link>
			</Components>
			<Events/>
			<TableParameters/>
			<JoinTables/>
			<JoinLinks/>
			<Fields/>
			<SPParameters/>
			<SQLParameters/>
			<SecurityGroups/>
			<Attributes/>
			<MenuItems>
				<MenuItem id="4" name="MenuItem1" caption="Cadastrar" url="ManterCliente.ccp"/>
				<MenuItem id="5" name="MenuItem1Item1" parent="MenuItem1" caption="Cliente" url="ManterCliente.ccp"/>
				<MenuItem id="6" name="MenuItem1Item2" parent="MenuItem1" caption="Imóvel" url="ManterImovel.ccp"/>
				<MenuItem id="7" name="MenuItem1Item4" parent="MenuItem1" caption="Contrato" url="ManterContrato.ccp"/>
				<MenuItem id="8" name="MenuItem1Item4Item1" parent="MenuItem1Item4" caption="Contrato" url="ManterContrato.ccp"/>
				<MenuItem id="9" name="MenuItem1Item4Item2" parent="MenuItem1Item4" caption="Clausula" url="ManterClausula.ccp"/>
				<MenuItem id="10" name="MenuItem1Item5" parent="MenuItem1" caption="Fiador" url="ManterFiador.ccp"/>
				<MenuItem id="11" name="MenuItem1Item6" parent="MenuItem1" caption="Despesas" url="ManterDespesas.ccp"/>
				<MenuItem id="12" name="MenuItem2" caption="Consultar" url="ListaCliente.ccp"/>
				<MenuItem id="13" name="MenuItem2Item1" parent="MenuItem2" caption="Clientes" url="ListaCliente.ccp"/>
				<MenuItem id="14" name="MenuItem2Item2" parent="MenuItem2" caption="Imóveis" url="ListaImovel.ccp"/>
				<MenuItem id="15" name="MenuItem2Item3" parent="MenuItem2" caption="Contrato" url="ListaContrato.ccp"/>
				<MenuItem id="16" name="MenuItem2Item3Item1" parent="MenuItem2Item3" caption="Contrato" url="ListaContrato.ccp"/>
				<MenuItem id="17" name="MenuItem2Item3Item2" parent="MenuItem2Item3" caption="Clausulas" url="ListaClausula.ccp"/>
				<MenuItem id="18" name="MenuItem2Item4" parent="MenuItem2" caption="Fiadores" url="ListaFiador.ccp"/>
				<MenuItem id="19" name="MenuItem2Item5" parent="MenuItem2" caption="Despesas" url="ListaDespesas.ccp"/>
				<MenuItem id="20" name="MenuItem3" caption="Visitas" url="ManterVisita.ccp"/>
				<MenuItem id="21" name="MenuItem3Item1" parent="MenuItem3" caption="Agendar" url="ManterVisita.ccp"/>
				<MenuItem id="22" name="MenuItem3Item2" parent="MenuItem3" caption="Consultar" url="ListaVisita.ccp"/>
				<MenuItem id="23" name="MenuItem4" caption="Fechamento" url="ManterVenda.ccp"/>
				<MenuItem id="24" name="MenuItem4Item1" parent="MenuItem4" caption="Venda" url="ManterVenda.ccp"/>
				<MenuItem id="25" name="MenuItem4Item2" parent="MenuItem4" caption="Aluguel" url="ManterAluguel.ccp"/>
				<MenuItem id="26" name="MenuItem5" caption="Estatisticas" url="EstCarteira.ccp"/>
				<MenuItem id="27" name="MenuItem5Item1" parent="MenuItem5" caption="Carteira de Imoveis" url="EstCarteira.ccp"/>
				<MenuItem id="28" name="MenuItem5Item2" parent="MenuItem5" caption="Desempenho de Funcionarios" url="DesempenhoFuncionario.ccp"/>
				<MenuItem id="29" name="MenuItem5Item3" parent="MenuItem5" caption="Transações Concluidas" url="TransConcluidas.ccp"/>
				<MenuItem id="30" name="MenuItem5Item4" parent="MenuItem5" caption="Lucros" url="Lucros.ccp"/>
				<MenuItem id="31" name="MenuItem6" caption="Suporte" url="Suporte.ccp"/>
			</MenuItems>
			<Features/>
		</Menu>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="Header.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="Header.jsp" path="." forShow="True" url="Header.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="HeaderHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events>
		<Event name="BeforeShow" type="Server">
			<Actions>
				<Action actionName="Hide-Show Component" actionCategory="General" id="32" action="Hide" conditionType="Parameter" dataType="Text" condition="Equal" parameter1="Print" name1="ViewMode" sourceType1="URL" name2="&quot;Print&quot;" sourceType2="Expression"/>
			</Actions>
		</Event>
	</Events>
</Page>
