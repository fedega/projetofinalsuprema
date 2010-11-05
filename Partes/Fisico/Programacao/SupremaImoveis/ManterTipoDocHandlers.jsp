<%--== Handlers ==--%> <%--ManterTipoDoc Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-AACDBD22
    public class ManterTipoDocServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_tipo_doc Record Handler Head @2-08E13A40
    public class ManterTipoDoctbl_tipo_docRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_tipo_doc Record Handler Head

//tbl_tipo_doc afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_tipo_doc afterInitialize Method Head

//tbl_tipo_doc afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc afterInitialize Method Tail

//tbl_tipo_doc OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_tipo_doc OnSetDataSource Method Head

//tbl_tipo_doc OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc OnSetDataSource Method Tail

//tbl_tipo_doc BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_tipo_doc BeforeShow Method Head

//tbl_tipo_doc BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeShow Method Tail

//tbl_tipo_doc OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_tipo_doc OnValidate Method Head

//tbl_tipo_doc OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc OnValidate Method Tail

//tbl_tipo_doc BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_tipo_doc BeforeSelect Method Head

//tbl_tipo_doc BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeSelect Method Tail

//tbl_tipo_doc BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_tipo_doc BeforeBuildSelect Method Head

//tbl_tipo_doc BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeBuildSelect Method Tail

//tbl_tipo_doc BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_doc BeforeExecuteSelect Method Head

//tbl_tipo_doc BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeExecuteSelect Method Tail

//tbl_tipo_doc AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_doc AfterExecuteSelect Method Head

//tbl_tipo_doc AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc AfterExecuteSelect Method Tail

//tbl_tipo_doc BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_tipo_doc BeforeInsert Method Head

//tbl_tipo_doc BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeInsert Method Tail

//tbl_tipo_doc BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_tipo_doc BeforeBuildInsert Method Head

//tbl_tipo_doc BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeBuildInsert Method Tail

//tbl_tipo_doc BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_doc BeforeExecuteInsert Method Head

//tbl_tipo_doc BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeExecuteInsert Method Tail

//tbl_tipo_doc AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_doc AfterExecuteInsert Method Head

//tbl_tipo_doc AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc AfterExecuteInsert Method Tail

//tbl_tipo_doc AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_tipo_doc AfterInsert Method Head

//tbl_tipo_doc AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc AfterInsert Method Tail

//tbl_tipo_doc BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_tipo_doc BeforeUpdate Method Head

//tbl_tipo_doc BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeUpdate Method Tail

//tbl_tipo_doc BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_tipo_doc BeforeBuildUpdate Method Head

//tbl_tipo_doc BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeBuildUpdate Method Tail

//tbl_tipo_doc BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_doc BeforeExecuteUpdate Method Head

//tbl_tipo_doc BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeExecuteUpdate Method Tail

//tbl_tipo_doc AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_doc AfterExecuteUpdate Method Head

//tbl_tipo_doc AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc AfterExecuteUpdate Method Tail

//tbl_tipo_doc AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_tipo_doc AfterUpdate Method Head

//tbl_tipo_doc AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc AfterUpdate Method Tail

//tbl_tipo_doc BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_tipo_doc BeforeDelete Method Head

//tbl_tipo_doc BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeDelete Method Tail

//tbl_tipo_doc BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_tipo_doc BeforeBuildDelete Method Head

//tbl_tipo_doc BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeBuildDelete Method Tail

//tbl_tipo_doc BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_doc BeforeExecuteDelete Method Head

//tbl_tipo_doc BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc BeforeExecuteDelete Method Tail

//tbl_tipo_doc AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_doc AfterExecuteDelete Method Head

//tbl_tipo_doc AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc AfterExecuteDelete Method Tail

//tbl_tipo_doc AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_tipo_doc AfterDelete Method Head

//tbl_tipo_doc AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_doc AfterDelete Method Tail

//tbl_tipo_doc Record Handler Tail @2-FCB6E20C
    }
//End tbl_tipo_doc Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-83F8DEA0
    Page ManterTipoDocModel = (Page)request.getAttribute("ManterTipoDoc_page");
    Page ManterTipoDocParent = (Page)request.getAttribute("ManterTipoDocParent");
    if (ManterTipoDocModel == null) {
        PageController ManterTipoDocCntr = new PageController(request, response, application, "/ManterTipoDoc.xml" );
        ManterTipoDocModel = ManterTipoDocCntr.getPage();
        ManterTipoDocModel.setRelativePath("./");
        //if (ManterTipoDocParent != null) {
            //if (!ManterTipoDocParent.getChild(ManterTipoDocModel.getName()).isVisible()) return;
        //}
        ((Record)ManterTipoDocModel.getChild("tbl_tipo_doc")).addRecordListener(new ManterTipoDoctbl_tipo_docRecordHandler());
        ManterTipoDocCntr.process();
%>
        <% request.setAttribute("HeaderParent", ManterTipoDocModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", ManterTipoDocModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (ManterTipoDocParent == null) {
            ManterTipoDocModel.setCookies();
            if (ManterTipoDocModel.redirect()) return;
        } else {
            ManterTipoDocModel.redirect();
        }
    }
//End Processing

%>
