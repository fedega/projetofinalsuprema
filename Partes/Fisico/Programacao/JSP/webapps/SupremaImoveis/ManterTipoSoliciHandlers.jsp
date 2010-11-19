<%--== Handlers ==--%> <%--ManterTipoSolici Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-C972C9E7
    public class ManterTipoSoliciServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_tipo_solicitacao Record Handler Head @2-5C347D30
    public class ManterTipoSolicitbl_tipo_solicitacaoRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_tipo_solicitacao Record Handler Head

//tbl_tipo_solicitacao afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_tipo_solicitacao afterInitialize Method Head

//tbl_tipo_solicitacao afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao afterInitialize Method Tail

//tbl_tipo_solicitacao OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_tipo_solicitacao OnSetDataSource Method Head

//tbl_tipo_solicitacao OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao OnSetDataSource Method Tail

//tbl_tipo_solicitacao BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_tipo_solicitacao BeforeShow Method Head

//tbl_tipo_solicitacao BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeShow Method Tail

//tbl_tipo_solicitacao OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_tipo_solicitacao OnValidate Method Head

//tbl_tipo_solicitacao OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao OnValidate Method Tail

//tbl_tipo_solicitacao BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_tipo_solicitacao BeforeSelect Method Head

//tbl_tipo_solicitacao BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeSelect Method Tail

//tbl_tipo_solicitacao BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeBuildSelect Method Head

//tbl_tipo_solicitacao BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeBuildSelect Method Tail

//tbl_tipo_solicitacao BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeExecuteSelect Method Head

//tbl_tipo_solicitacao BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeExecuteSelect Method Tail

//tbl_tipo_solicitacao AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_solicitacao AfterExecuteSelect Method Head

//tbl_tipo_solicitacao AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao AfterExecuteSelect Method Tail

//tbl_tipo_solicitacao BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_tipo_solicitacao BeforeInsert Method Head

//tbl_tipo_solicitacao BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeInsert Method Tail

//tbl_tipo_solicitacao BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeBuildInsert Method Head

//tbl_tipo_solicitacao BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeBuildInsert Method Tail

//tbl_tipo_solicitacao BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeExecuteInsert Method Head

//tbl_tipo_solicitacao BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeExecuteInsert Method Tail

//tbl_tipo_solicitacao AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_solicitacao AfterExecuteInsert Method Head

//tbl_tipo_solicitacao AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao AfterExecuteInsert Method Tail

//tbl_tipo_solicitacao AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_tipo_solicitacao AfterInsert Method Head

//tbl_tipo_solicitacao AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao AfterInsert Method Tail

//tbl_tipo_solicitacao BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_tipo_solicitacao BeforeUpdate Method Head

//tbl_tipo_solicitacao BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeUpdate Method Tail

//tbl_tipo_solicitacao BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeBuildUpdate Method Head

//tbl_tipo_solicitacao BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeBuildUpdate Method Tail

//tbl_tipo_solicitacao BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeExecuteUpdate Method Head

//tbl_tipo_solicitacao BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeExecuteUpdate Method Tail

//tbl_tipo_solicitacao AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_solicitacao AfterExecuteUpdate Method Head

//tbl_tipo_solicitacao AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao AfterExecuteUpdate Method Tail

//tbl_tipo_solicitacao AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_tipo_solicitacao AfterUpdate Method Head

//tbl_tipo_solicitacao AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao AfterUpdate Method Tail

//tbl_tipo_solicitacao BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_tipo_solicitacao BeforeDelete Method Head

//tbl_tipo_solicitacao BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeDelete Method Tail

//tbl_tipo_solicitacao BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeBuildDelete Method Head

//tbl_tipo_solicitacao BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeBuildDelete Method Tail

//tbl_tipo_solicitacao BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_solicitacao BeforeExecuteDelete Method Head

//tbl_tipo_solicitacao BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao BeforeExecuteDelete Method Tail

//tbl_tipo_solicitacao AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_solicitacao AfterExecuteDelete Method Head

//tbl_tipo_solicitacao AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao AfterExecuteDelete Method Tail

//tbl_tipo_solicitacao AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_tipo_solicitacao AfterDelete Method Head

//tbl_tipo_solicitacao AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_solicitacao AfterDelete Method Tail

//tbl_tipo_solicitacao Record Handler Tail @2-FCB6E20C
    }
//End tbl_tipo_solicitacao Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-8363938B
    Page ManterTipoSoliciModel = (Page)request.getAttribute("ManterTipoSolici_page");
    Page ManterTipoSoliciParent = (Page)request.getAttribute("ManterTipoSoliciParent");
    if (ManterTipoSoliciModel == null) {
        PageController ManterTipoSoliciCntr = new PageController(request, response, application, "/ManterTipoSolici.xml" );
        ManterTipoSoliciModel = ManterTipoSoliciCntr.getPage();
        ManterTipoSoliciModel.setRelativePath("./");
        //if (ManterTipoSoliciParent != null) {
            //if (!ManterTipoSoliciParent.getChild(ManterTipoSoliciModel.getName()).isVisible()) return;
        //}
        ((Record)ManterTipoSoliciModel.getChild("tbl_tipo_solicitacao")).addRecordListener(new ManterTipoSolicitbl_tipo_solicitacaoRecordHandler());
        ManterTipoSoliciCntr.process();
%>
        <% request.setAttribute("HeaderParent", ManterTipoSoliciModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ManterTipoSoliciModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ManterTipoSoliciParent == null) {
            ManterTipoSoliciModel.setCookies();
            if (ManterTipoSoliciModel.redirect()) return;
        } else {
            ManterTipoSoliciModel.redirect();
        }
    }
//End Processing

%>
