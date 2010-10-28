<%--== Handlers ==--%> <%--tbl_tipo_client_maint Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-F0EE7197
    public class tbl_tipo_client_maintServiceChecker implements com.codecharge.features.IServiceChecker {
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

//tbl_tipo_cliente Record Handler Head @2-5C68D0C3
    public class tbl_tipo_client_mainttbl_tipo_clienteRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_tipo_cliente Record Handler Head

//tbl_tipo_cliente afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_tipo_cliente afterInitialize Method Head

//tbl_tipo_cliente afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente afterInitialize Method Tail

//tbl_tipo_cliente OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_tipo_cliente OnSetDataSource Method Head

//tbl_tipo_cliente OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente OnSetDataSource Method Tail

//tbl_tipo_cliente BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_tipo_cliente BeforeShow Method Head

//tbl_tipo_cliente BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeShow Method Tail

//tbl_tipo_cliente OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_tipo_cliente OnValidate Method Head

//tbl_tipo_cliente OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente OnValidate Method Tail

//tbl_tipo_cliente BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_tipo_cliente BeforeSelect Method Head

//tbl_tipo_cliente BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeSelect Method Tail

//tbl_tipo_cliente BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeBuildSelect Method Head

//tbl_tipo_cliente BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeBuildSelect Method Tail

//tbl_tipo_cliente BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeExecuteSelect Method Head

//tbl_tipo_cliente BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeExecuteSelect Method Tail

//tbl_tipo_cliente AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_tipo_cliente AfterExecuteSelect Method Head

//tbl_tipo_cliente AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente AfterExecuteSelect Method Tail

//tbl_tipo_cliente BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_tipo_cliente BeforeInsert Method Head

//tbl_tipo_cliente BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeInsert Method Tail

//tbl_tipo_cliente BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeBuildInsert Method Head

//tbl_tipo_cliente BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeBuildInsert Method Tail

//tbl_tipo_cliente BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeExecuteInsert Method Head

//tbl_tipo_cliente BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeExecuteInsert Method Tail

//tbl_tipo_cliente AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_tipo_cliente AfterExecuteInsert Method Head

//tbl_tipo_cliente AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente AfterExecuteInsert Method Tail

//tbl_tipo_cliente AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_tipo_cliente AfterInsert Method Head

//tbl_tipo_cliente AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente AfterInsert Method Tail

//tbl_tipo_cliente BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_tipo_cliente BeforeUpdate Method Head

//tbl_tipo_cliente BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeUpdate Method Tail

//tbl_tipo_cliente BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeBuildUpdate Method Head

//tbl_tipo_cliente BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeBuildUpdate Method Tail

//tbl_tipo_cliente BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeExecuteUpdate Method Head

//tbl_tipo_cliente BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeExecuteUpdate Method Tail

//tbl_tipo_cliente AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_tipo_cliente AfterExecuteUpdate Method Head

//tbl_tipo_cliente AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente AfterExecuteUpdate Method Tail

//tbl_tipo_cliente AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_tipo_cliente AfterUpdate Method Head

//tbl_tipo_cliente AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente AfterUpdate Method Tail

//tbl_tipo_cliente BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_tipo_cliente BeforeDelete Method Head

//tbl_tipo_cliente BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeDelete Method Tail

//tbl_tipo_cliente BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeBuildDelete Method Head

//tbl_tipo_cliente BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeBuildDelete Method Tail

//tbl_tipo_cliente BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_cliente BeforeExecuteDelete Method Head

//tbl_tipo_cliente BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente BeforeExecuteDelete Method Tail

//tbl_tipo_cliente AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_tipo_cliente AfterExecuteDelete Method Head

//tbl_tipo_cliente AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente AfterExecuteDelete Method Tail

//tbl_tipo_cliente AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_tipo_cliente AfterDelete Method Head

//tbl_tipo_cliente AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_tipo_cliente AfterDelete Method Tail

//tbl_tipo_cliente Record Handler Tail @2-FCB6E20C
    }
//End tbl_tipo_cliente Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-A87EE48D
    Page tbl_tipo_client_maintModel = (Page)request.getAttribute("tbl_tipo_client_maint_page");
    Page tbl_tipo_client_maintParent = (Page)request.getAttribute("tbl_tipo_client_maintParent");
    if (tbl_tipo_client_maintModel == null) {
        PageController tbl_tipo_client_maintCntr = new PageController(request, response, application, "/tbl_tipo_client_maint.xml" );
        tbl_tipo_client_maintModel = tbl_tipo_client_maintCntr.getPage();
        tbl_tipo_client_maintModel.setRelativePath("./");
        //if (tbl_tipo_client_maintParent != null) {
            //if (!tbl_tipo_client_maintParent.getChild(tbl_tipo_client_maintModel.getName()).isVisible()) return;
        //}
        ((Record)tbl_tipo_client_maintModel.getChild("tbl_tipo_cliente")).addRecordListener(new tbl_tipo_client_mainttbl_tipo_clienteRecordHandler());
        tbl_tipo_client_maintCntr.process();
%>
        <% request.setAttribute("HeaderParent", tbl_tipo_client_maintModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", tbl_tipo_client_maintModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (tbl_tipo_client_maintParent == null) {
            tbl_tipo_client_maintModel.setCookies();
            if (tbl_tipo_client_maintModel.redirect()) return;
        } else {
            tbl_tipo_client_maintModel.redirect();
        }
    }
//End Processing

%>
