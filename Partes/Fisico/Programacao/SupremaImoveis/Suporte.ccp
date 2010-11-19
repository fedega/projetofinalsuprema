<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="Padrao" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<Menu id="2" secured="False" sourceType="Table" returnValueType="Number" name="Menu1" menuType="Horizontal" menuSourceType="Static" PathID="Menu1">
			<Components>
				<Link id="3" visible="Yes" fieldSourceType="DBColumn" dataType="Text" html="False" hrefType="Page" urlType="Relative" preserveParameters="GET" name="ItemLink" PathID="Menu1ItemLink">
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
				<MenuItem id="4" name="MenuItem1" caption="Grafico Imoveis" url="Imoveis.ccp"/>
				<MenuItem id="5" name="MenuItem5" caption="Aluguel" url="ListaAluguel.ccp"/>
				<MenuItem id="6" name="MenuItem6" caption="Cidade" url="ListaCidade.ccp"/>
				<MenuItem id="7" name="MenuItem7" caption="Causula" url="ListaClausula.ccp"/>
				<MenuItem id="8" name="MenuItem7Item1" parent="MenuItem7" caption="Tipo de Clasula" url="ListaTipoClausula.ccp"/>
				<MenuItem id="9" name="MenuItem8" caption="Cliente" url="ListaCliente.ccp"/>
				<MenuItem id="10" name="MenuItem8Item1" parent="MenuItem8" caption="Tipo de Cliente" url="ListaTipoCliente.ccp"/>
				<MenuItem id="11" name="MenuItem9" caption="Contrato" url="ListaContrato.ccp"/>
				<MenuItem id="12" name="MenuItem10" caption="Despesas" url="ListaDespesas.ccp"/>
				<MenuItem id="13" name="MenuItem10Item1" parent="MenuItem10" caption="Tipo de Despesas" url="ListaTipoDesp.ccp"/>
				<MenuItem id="14" name="MenuItem11" caption="Destinacao" url="ListaDestinacao.ccp"/>
				<MenuItem id="15" name="MenuItem12" caption="Documentacao" url="ListaDocumentacao.ccp"/>
				<MenuItem id="16" name="MenuItem12Item1" parent="MenuItem12" caption="Tipo de Documentacao" url="ListaTipoDoc.ccp"/>
				<MenuItem id="17" name="MenuItem13" caption="Estado" url="ListaEstado.ccp"/>
				<MenuItem id="18" name="MenuItem14" caption="Fiador" url="ListaFiador.ccp"/>
				<MenuItem id="19" name="MenuItem15" caption="Funcionario" url="ListaFuncionario.ccp"/>
				<MenuItem id="20" name="MenuItem16" caption="Imovel" url="ListaImovel.ccp"/>
				<MenuItem id="21" name="MenuItem17" caption="Orgao" url="ListaOrgao.ccp"/>
				<MenuItem id="22" name="MenuItem18" caption="Preferencia" url="ListaPreferencia.ccp"/>
				<MenuItem id="23" name="MenuItem19" caption="Situacao" url="ListaSituacao.ccp"/>
				<MenuItem id="24" name="MenuItem20" caption="Solicitacoes" url="ListaSolicitacoes.ccp"/>
				<MenuItem id="25" name="MenuItem20Item1" parent="MenuItem20" caption="Tipo de Solicitacao" url="ListaTipoSolici.ccp"/>
				<MenuItem id="26" name="MenuItem21" caption="Venda" url="ListaVenda.ccp"/>
				<MenuItem id="27" name="MenuItem22" caption="Visita" url="ListaVisita.ccp"/>
			</MenuItems>
			<Features/>
		</Menu>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="Suporte.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
		<CodeFile id="JSP" language="JSP" name="Suporte.jsp" path="." forShow="True" url="Suporte.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
		<CodeFile id="Handlers" language="JSP" name="SuporteHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
	</CodeFiles>
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
