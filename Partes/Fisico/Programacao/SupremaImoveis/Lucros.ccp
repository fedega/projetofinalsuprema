<Page id="1" templateExtension="html" relativePath="." fullRelativePath="." secured="False" urlType="Relative" isIncluded="False" SSLAccess="False" isService="False" cachingEnabled="False" cachingDuration="1 minutes" wizardTheme="None" wizardThemeVersion="3.0" needGeneration="0">
	<Components>
		<IncludePage id="2" name="Header" PathID="Header" page="Header.ccp">
			<Components/>
			<Events/>
			<Features/>
		</IncludePage>
		<Report id="3" secured="False" enablePrint="False" showMode="Web" sourceType="Table" returnValueType="Number" linesPerWebPage="40" linesPerPhysicalPage="50" name="Novo" pageSizeLimit="100" wizardCaption=" Novo " wizardLayoutType="Tabular">
			<Components>
				<Section id="4" visible="True" lines="0" name="Report_Header" wizardSectionType="ReportHeader">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Section>
				<Section id="5" visible="True" lines="1" name="Page_Header" wizardSectionType="PageHeader">
					<Components/>
					<Events/>
					<Attributes/>
					<Features/>
				</Section>
				<Section id="6" visible="True" lines="1" name="Detail">
					<Components>
						<ReportLabel id="13" fieldSourceType="DBColumn" dataType="Text" html="False" hideDuplicates="False" resetAt="Report" name="Label1" wizardCaption="Label1" wizardIsPassword="False" wizardUseTemplateBlock="False" wizardAddNbsp="False" PathID="NovoDetailLabel1">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</ReportLabel>
						<ReportLabel id="14" fieldSourceType="DBColumn" dataType="Text" html="False" hideDuplicates="False" resetAt="Report" name="Label2" wizardCaption="Label2" wizardIsPassword="False" wizardUseTemplateBlock="False" wizardAddNbsp="False" PathID="NovoDetailLabel2">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</ReportLabel>
						<ReportLabel id="15" fieldSourceType="DBColumn" dataType="Text" html="False" hideDuplicates="False" resetAt="Report" name="Label3" wizardCaption="Label3" wizardIsPassword="False" wizardUseTemplateBlock="False" wizardAddNbsp="False" PathID="NovoDetailLabel3">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</ReportLabel>
						<ReportLabel id="16" fieldSourceType="DBColumn" dataType="Text" html="False" hideDuplicates="False" resetAt="Report" name="Label4" wizardCaption="Label4" wizardIsPassword="False" wizardUseTemplateBlock="False" wizardAddNbsp="False" PathID="NovoDetailLabel4">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</ReportLabel>
					</Components>
					<Events/>
					<Attributes/>
					<Features/>
				</Section>
				<Section id="7" visible="True" lines="0" name="Report_Footer" wizardSectionType="ReportFooter">
					<Components>
						<Panel id="8" visible="True" name="NoRecords" wizardNoRecords="Sem registros">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</Panel>
					</Components>
					<Events/>
					<Attributes/>
					<Features/>
				</Section>
				<Section id="9" visible="True" lines="1" name="Page_Footer" wizardSectionType="PageFooter" pageBreakAfter="True">
					<Components>
						<ReportLabel id="10" fieldSourceType="SpecialValue" dataType="Date" html="False" hideDuplicates="False" resetAt="Report" name="Report_CurrentDate" fieldSource="CurrentDate" wizardUseTemplateBlock="False" wizardAddNbsp="False" wizardInsertToDateTD="True" PathID="NovoPage_FooterReport_CurrentDate">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</ReportLabel>
						<ReportLabel id="11" fieldSourceType="SpecialValue" dataType="Integer" html="False" hideDuplicates="False" resetAt="Report" name="Report_CurrentPage" fieldSource="PageNumber" wizardUseTemplateBlock="False" wizardAddNbsp="False" wizardAlign="right" wizardPrefix="Pagina " PathID="NovoPage_FooterReport_CurrentPage">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</ReportLabel>
						<ReportLabel id="12" fieldSourceType="SpecialValue" dataType="Integer" html="False" hideDuplicates="False" resetAt="Report" name="Report_TotalPages" fieldSource="TotalPages" wizardUseTemplateBlock="False" wizardAddNbsp="False" wizardAlign="right" wizardPrefix=" de " PathID="NovoPage_FooterReport_TotalPages">
							<Components/>
							<Events/>
							<Attributes/>
							<Features/>
						</ReportLabel>
					</Components>
					<Events/>
					<Attributes/>
					<Features/>
				</Section>
			</Components>
			<Events/>
			<TableParameters/>
			<JoinTables/>
			<JoinLinks/>
			<Fields/>
			<SPParameters/>
			<SQLParameters/>
			<ReportGroups/>
			<SecurityGroups/>
			<Attributes/>
			<Features/>
		</Report>
	</Components>
	<CodeFiles>
		<CodeFile id="Model" language="JSP" name="Lucros.xml" path="." forShow="False" comment="&lt;!--" commentEnd="--&gt;" codePage="windows-1252"/>
<CodeFile id="JSP" language="JSP" name="Lucros.jsp" path="." forShow="True" url="Lucros.jsp" comment="&lt;%--" commentEnd="--%&gt;" codePage="windows-1252"/>
<CodeFile id="Handlers" language="JSP" name="LucrosHandlers.jsp" path="." forShow="False" comment="//" codePage="windows-1252"/>
</CodeFiles>
	<SecurityGroups/>
	<CachingParameters/>
	<Attributes/>
	<Features/>
	<Events/>
</Page>
