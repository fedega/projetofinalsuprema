<%--== Handlers ==--%> <%--tbl_contrato_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-D9A0046E
    public class tbl_contrato_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_contrato Record Handler Head @2-8BDA7FC9
    public class tbl_contrato_mainttbl_contratoRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_contrato Record Handler Head

//tbl_contrato afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_contrato afterInitialize Method Head

//tbl_contrato afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_contrato afterInitialize Method Tail

//tbl_contrato OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_contrato OnSetDataSource Method Head

//tbl_contrato OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_contrato OnSetDataSource Method Tail

//tbl_contrato BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_contrato BeforeShow Method Head

//tbl_contrato BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeShow Method Tail

//tbl_contrato OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_contrato OnValidate Method Head

//tbl_contrato OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_contrato OnValidate Method Tail

//tbl_contrato BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_contrato BeforeSelect Method Head

//tbl_contrato BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeSelect Method Tail

//tbl_contrato BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_contrato BeforeBuildSelect Method Head

//tbl_contrato BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeBuildSelect Method Tail

//tbl_contrato BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_contrato BeforeExecuteSelect Method Head

//tbl_contrato BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeExecuteSelect Method Tail

//tbl_contrato AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_contrato AfterExecuteSelect Method Head

//tbl_contrato AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_contrato AfterExecuteSelect Method Tail

//tbl_contrato BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_contrato BeforeInsert Method Head

//tbl_contrato BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeInsert Method Tail

//tbl_contrato BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_contrato BeforeBuildInsert Method Head

//tbl_contrato BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeBuildInsert Method Tail

//tbl_contrato BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_contrato BeforeExecuteInsert Method Head

//tbl_contrato BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeExecuteInsert Method Tail

//tbl_contrato AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_contrato AfterExecuteInsert Method Head

//tbl_contrato AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_contrato AfterExecuteInsert Method Tail

//tbl_contrato AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_contrato AfterInsert Method Head

//tbl_contrato AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_contrato AfterInsert Method Tail

//tbl_contrato BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_contrato BeforeUpdate Method Head

//tbl_contrato BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeUpdate Method Tail

//tbl_contrato BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_contrato BeforeBuildUpdate Method Head

//tbl_contrato BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeBuildUpdate Method Tail

//tbl_contrato BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_contrato BeforeExecuteUpdate Method Head

//tbl_contrato BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeExecuteUpdate Method Tail

//tbl_contrato AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_contrato AfterExecuteUpdate Method Head

//tbl_contrato AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_contrato AfterExecuteUpdate Method Tail

//tbl_contrato AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_contrato AfterUpdate Method Head

//tbl_contrato AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_contrato AfterUpdate Method Tail

//tbl_contrato BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_contrato BeforeDelete Method Head

//tbl_contrato BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeDelete Method Tail

//tbl_contrato BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_contrato BeforeBuildDelete Method Head

//tbl_contrato BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeBuildDelete Method Tail

//tbl_contrato BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_contrato BeforeExecuteDelete Method Head

//tbl_contrato BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_contrato BeforeExecuteDelete Method Tail

//tbl_contrato AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_contrato AfterExecuteDelete Method Head

//tbl_contrato AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_contrato AfterExecuteDelete Method Tail

//tbl_contrato AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_contrato AfterDelete Method Head

//tbl_contrato AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_contrato AfterDelete Method Tail

//tbl_contrato Record Handler Tail @2-FCB6E20C
    }
//End tbl_contrato Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-F7C115F5
    Page tbl_contrato_maintModel = (Page)request.getAttribute("tbl_contrato_maint_page");
    Page tbl_contrato_maintParent = (Page)request.getAttribute("tbl_contrato_maintParent");
    if (tbl_contrato_maintModel == null) {
        PageController tbl_contrato_maintCntr = new PageController(request, response, application, "/tbl_contrato_maint.xml" );
        tbl_contrato_maintModel = tbl_contrato_maintCntr.getPage();
        tbl_contrato_maintModel.setRelativePath("./");
        //if (tbl_contrato_maintParent != null) {
            //if (!tbl_contrato_maintParent.getChild(tbl_contrato_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_contrato_maintModel.getChild("tbl_contrato")).addRecordListener(new tbl_contrato_mainttbl_contratoRecordHandler());
        tbl_contrato_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_contrato_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_contrato_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_contrato_maintParent == null) {
            tbl_contrato_maintModel.setCookies();
            if (tbl_contrato_maintModel.redirect()) return;
        } else {
            tbl_contrato_maintModel.redirect();
        }
    }
//End Processing

%>
