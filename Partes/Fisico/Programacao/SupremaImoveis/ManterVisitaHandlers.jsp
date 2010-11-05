<%--== Handlers ==--%> <%--ManterVisita Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-9610B3D5
    public class ManterVisitaServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_visita Record Handler Head @2-0F007C49
    public class ManterVisitatbl_visitaRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_visita Record Handler Head

//tbl_visita afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_visita afterInitialize Method Head

//tbl_visita afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_visita afterInitialize Method Tail

//tbl_visita OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_visita OnSetDataSource Method Head

//tbl_visita OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_visita OnSetDataSource Method Tail

//tbl_visita BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_visita BeforeShow Method Head

//tbl_visita BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeShow Method Tail

//tbl_visita OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_visita OnValidate Method Head

//tbl_visita OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_visita OnValidate Method Tail

//tbl_visita BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_visita BeforeSelect Method Head

//tbl_visita BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeSelect Method Tail

//tbl_visita BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_visita BeforeBuildSelect Method Head

//tbl_visita BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeBuildSelect Method Tail

//tbl_visita BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_visita BeforeExecuteSelect Method Head

//tbl_visita BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeExecuteSelect Method Tail

//tbl_visita AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_visita AfterExecuteSelect Method Head

//tbl_visita AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_visita AfterExecuteSelect Method Tail

//tbl_visita BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_visita BeforeInsert Method Head

//tbl_visita BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeInsert Method Tail

//tbl_visita BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_visita BeforeBuildInsert Method Head

//tbl_visita BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeBuildInsert Method Tail

//tbl_visita BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_visita BeforeExecuteInsert Method Head

//tbl_visita BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeExecuteInsert Method Tail

//tbl_visita AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_visita AfterExecuteInsert Method Head

//tbl_visita AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_visita AfterExecuteInsert Method Tail

//tbl_visita AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_visita AfterInsert Method Head

//tbl_visita AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_visita AfterInsert Method Tail

//tbl_visita BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_visita BeforeUpdate Method Head

//tbl_visita BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeUpdate Method Tail

//tbl_visita BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_visita BeforeBuildUpdate Method Head

//tbl_visita BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeBuildUpdate Method Tail

//tbl_visita BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_visita BeforeExecuteUpdate Method Head

//tbl_visita BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeExecuteUpdate Method Tail

//tbl_visita AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_visita AfterExecuteUpdate Method Head

//tbl_visita AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_visita AfterExecuteUpdate Method Tail

//tbl_visita AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_visita AfterUpdate Method Head

//tbl_visita AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_visita AfterUpdate Method Tail

//tbl_visita BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_visita BeforeDelete Method Head

//tbl_visita BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeDelete Method Tail

//tbl_visita BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_visita BeforeBuildDelete Method Head

//tbl_visita BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeBuildDelete Method Tail

//tbl_visita BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_visita BeforeExecuteDelete Method Head

//tbl_visita BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_visita BeforeExecuteDelete Method Tail

//tbl_visita AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_visita AfterExecuteDelete Method Head

//tbl_visita AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_visita AfterExecuteDelete Method Tail

//tbl_visita AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_visita AfterDelete Method Head

//tbl_visita AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_visita AfterDelete Method Tail

//tbl_visita Record Handler Tail @2-FCB6E20C
    }
//End tbl_visita Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-5EC3C08E
    Page ManterVisitaModel = (Page)request.getAttribute("ManterVisita_page");
    Page ManterVisitaParent = (Page)request.getAttribute("ManterVisitaParent");
    if (ManterVisitaModel == null) {
        PageController ManterVisitaCntr = new PageController(request, response, application, "/ManterVisita.xml" );
        ManterVisitaModel = ManterVisitaCntr.getPage();
        ManterVisitaModel.setRelativePath("./");
        //if (ManterVisitaParent != null) {
            //if (!ManterVisitaParent.getChild(ManterVisitaModel.getName()).isVisible()) return;
        //}
        ((Record)ManterVisitaModel.getChild("tbl_visita")).addRecordListener(new ManterVisitatbl_visitaRecordHandler());
        ManterVisitaCntr.process();
%>
        <% request.setAttribute("HeaderParent", ManterVisitaModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ManterVisitaModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ManterVisitaParent == null) {
            ManterVisitaModel.setCookies();
            if (ManterVisitaModel.redirect()) return;
        } else {
            ManterVisitaModel.redirect();
        }
    }
//End Processing

%>
