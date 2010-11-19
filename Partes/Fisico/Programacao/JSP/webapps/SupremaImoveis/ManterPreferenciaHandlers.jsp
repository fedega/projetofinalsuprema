<%--== Handlers ==--%> <%--ManterPreferencia Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-1F530B82
    public class ManterPreferenciaServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-0F76B408
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ((new HeaderServiceChecker()).check(request, response, context)) return true;
            if ((new FooterServiceChecker()).check(request, response, context)) return true;
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//tbl_preferencia Record Handler Head @2-48190A2D
    public class ManterPreferenciatbl_preferenciaRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_preferencia Record Handler Head

//tbl_preferencia afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_preferencia afterInitialize Method Head

//tbl_preferencia afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_preferencia afterInitialize Method Tail

//tbl_preferencia OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_preferencia OnSetDataSource Method Head

//tbl_preferencia OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_preferencia OnSetDataSource Method Tail

//tbl_preferencia BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_preferencia BeforeShow Method Head

//tbl_preferencia BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeShow Method Tail

//tbl_preferencia OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_preferencia OnValidate Method Head

//tbl_preferencia OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_preferencia OnValidate Method Tail

//tbl_preferencia BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_preferencia BeforeSelect Method Head

//tbl_preferencia BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeSelect Method Tail

//tbl_preferencia BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_preferencia BeforeBuildSelect Method Head

//tbl_preferencia BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeBuildSelect Method Tail

//tbl_preferencia BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_preferencia BeforeExecuteSelect Method Head

//tbl_preferencia BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeExecuteSelect Method Tail

//tbl_preferencia AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_preferencia AfterExecuteSelect Method Head

//tbl_preferencia AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_preferencia AfterExecuteSelect Method Tail

//tbl_preferencia BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_preferencia BeforeInsert Method Head

//tbl_preferencia BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeInsert Method Tail

//tbl_preferencia BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_preferencia BeforeBuildInsert Method Head

//tbl_preferencia BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeBuildInsert Method Tail

//tbl_preferencia BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_preferencia BeforeExecuteInsert Method Head

//tbl_preferencia BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeExecuteInsert Method Tail

//tbl_preferencia AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_preferencia AfterExecuteInsert Method Head

//tbl_preferencia AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_preferencia AfterExecuteInsert Method Tail

//tbl_preferencia AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_preferencia AfterInsert Method Head

//tbl_preferencia AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_preferencia AfterInsert Method Tail

//tbl_preferencia BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_preferencia BeforeUpdate Method Head

//tbl_preferencia BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeUpdate Method Tail

//tbl_preferencia BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_preferencia BeforeBuildUpdate Method Head

//tbl_preferencia BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeBuildUpdate Method Tail

//tbl_preferencia BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_preferencia BeforeExecuteUpdate Method Head

//tbl_preferencia BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeExecuteUpdate Method Tail

//tbl_preferencia AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_preferencia AfterExecuteUpdate Method Head

//tbl_preferencia AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_preferencia AfterExecuteUpdate Method Tail

//tbl_preferencia AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_preferencia AfterUpdate Method Head

//tbl_preferencia AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_preferencia AfterUpdate Method Tail

//tbl_preferencia BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_preferencia BeforeDelete Method Head

//tbl_preferencia BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeDelete Method Tail

//tbl_preferencia BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_preferencia BeforeBuildDelete Method Head

//tbl_preferencia BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeBuildDelete Method Tail

//tbl_preferencia BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_preferencia BeforeExecuteDelete Method Head

//tbl_preferencia BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_preferencia BeforeExecuteDelete Method Tail

//tbl_preferencia AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_preferencia AfterExecuteDelete Method Head

//tbl_preferencia AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_preferencia AfterExecuteDelete Method Tail

//tbl_preferencia AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_preferencia AfterDelete Method Head

//tbl_preferencia AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_preferencia AfterDelete Method Tail

//tbl_preferencia Record Handler Tail @2-FCB6E20C
    }
//End tbl_preferencia Record Handler Tail

//Cod_Cliente TextBox Handler Head @7-49D52E94
    public class tbl_preferenciaCod_ClienteTextBoxHandler implements ValidationListener {
//End Cod_Cliente TextBox Handler Head

//Cod_Cliente BeforeShow Method Head @7-46046458
        public void beforeShow(Event e) {
//End Cod_Cliente BeforeShow Method Head

//Cod_Cliente BeforeShow Method Tail @7-FCB6E20C
        }
//End Cod_Cliente BeforeShow Method Tail

//Cod_Cliente OnValidate Method Head @7-5F430F8E
        public void onValidate(Event e) {
//End Cod_Cliente OnValidate Method Head

//Cod_Cliente Required Validation @7-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End Cod_Cliente Required Validation

//Cod_Cliente OnValidate Method Tail @7-FCB6E20C
        }
//End Cod_Cliente OnValidate Method Tail

//Cod_Cliente TextBox Handler Tail @7-FCB6E20C
    }
//End Cod_Cliente TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-D2E4E92D
    Page ManterPreferenciaModel = (Page)request.getAttribute("ManterPreferencia_page");
    Page ManterPreferenciaParent = (Page)request.getAttribute("ManterPreferenciaParent");
    if (ManterPreferenciaModel == null) {
        PageController ManterPreferenciaCntr = new PageController(request, response, application, "/ManterPreferencia.xml" );
        ManterPreferenciaModel = ManterPreferenciaCntr.getPage();
        ManterPreferenciaModel.setRelativePath("./");
        //if (ManterPreferenciaParent != null) {
            //if (!ManterPreferenciaParent.getChild(ManterPreferenciaModel.getName()).isVisible()) return;
        //}
        ((Record)ManterPreferenciaModel.getChild("tbl_preferencia")).addRecordListener(new ManterPreferenciatbl_preferenciaRecordHandler());
        ((TextBox)((Record)ManterPreferenciaModel.getChild("tbl_preferencia")).getChild("Cod_Cliente")).addValidationListener(new tbl_preferenciaCod_ClienteTextBoxHandler());
        ManterPreferenciaCntr.process();
%>
        <% request.setAttribute("HeaderParent", ManterPreferenciaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ManterPreferenciaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ManterPreferenciaParent == null) {
            ManterPreferenciaModel.setCookies();
            if (ManterPreferenciaModel.redirect()) return;
        } else {
            ManterPreferenciaModel.redirect();
        }
    }
//End Processing

%>
