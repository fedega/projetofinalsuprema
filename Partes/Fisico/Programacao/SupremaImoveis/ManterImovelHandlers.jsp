<%--== Handlers ==--%> <%--ManterImovel Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-060B9DC6
    public class ManterImovelServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-6DADF1A6
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//ManterImovel Page Handler Head @1-197B81DC
    public class ManterImovelPageHandler implements PageListener {
//End ManterImovel Page Handler Head

//ManterImovel BeforeInitialize Method Head @1-4C73EADA
        public void beforeInitialize(Event e) {
//End ManterImovel BeforeInitialize Method Head

//ManterImovel CheckBox Values @1-8CC92A1C
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Dep_Empregada" )).setCheckedValue(true);
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Dep_Empregada" )).setUncheckedValue(false);
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Garagem" )).setCheckedValue(true);
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Garagem" )).setUncheckedValue(false);
//End ManterImovel CheckBox Values

//ManterImovel BeforeInitialize Method Tail @1-FCB6E20C
        }
//End ManterImovel BeforeInitialize Method Tail

//ManterImovel AfterInitialize Method Head @1-89E84600
        public void afterInitialize(Event e) {
//End ManterImovel AfterInitialize Method Head

//ManterImovel CheckBox Values @1-8CC92A1C
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Dep_Empregada" )).setCheckedValue(true);
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Dep_Empregada" )).setUncheckedValue(false);
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Garagem" )).setCheckedValue(true);
            ((com.codecharge.components.CheckBox) ((com.codecharge.components.Record) (e.getPage().getChild( "tbl_imovel" ))).getChild( "Garagem" )).setUncheckedValue(false);
//End ManterImovel CheckBox Values

//ManterImovel AfterInitialize Method Tail @1-FCB6E20C
        }
//End ManterImovel AfterInitialize Method Tail

//ManterImovel OnInitializeView Method Head @1-E3C15E0F
        public void onInitializeView(Event e) {
//End ManterImovel OnInitializeView Method Head

//ManterImovel OnInitializeView Method Tail @1-FCB6E20C
        }
//End ManterImovel OnInitializeView Method Tail

//ManterImovel BeforeShow Method Head @1-46046458
        public void beforeShow(Event e) {
//End ManterImovel BeforeShow Method Head

//ManterImovel BeforeShow Method Tail @1-FCB6E20C
        }
//End ManterImovel BeforeShow Method Tail

//ManterImovel BeforeOutput Method Head @1-BE3571C7
        public void beforeOutput(Event e) {
//End ManterImovel BeforeOutput Method Head

//ManterImovel BeforeOutput Method Tail @1-FCB6E20C
        }
//End ManterImovel BeforeOutput Method Tail

//ManterImovel BeforeUnload Method Head @1-1DDBA584
        public void beforeUnload(Event e) {
//End ManterImovel BeforeUnload Method Head

//ManterImovel BeforeUnload Method Tail @1-FCB6E20C
        }
//End ManterImovel BeforeUnload Method Tail

//ManterImovel onCache Method Head @1-7A88A4B8
        public void onCache(CacheEvent e) {
//End ManterImovel onCache Method Head

//get cachedItem @1-F7EFE9F6
            if (e.getCacheOperation() == ICache.OPERATION_GET) {
//End get cachedItem

//custom code before get cachedItem @1-E3CE2760
                /* Write your own code here */
//End custom code before get cachedItem

//put cachedItem @1-FD2D76DE
            } else if (e.getCacheOperation() == ICache.OPERATION_PUT) {
//End put cachedItem

//custom code before put cachedItem @1-E3CE2760
                /* Write your own code here */
//End custom code before put cachedItem

//if tail @1-FCB6E20C
            }
//End if tail

//ManterImovel onCache Method Tail @1-FCB6E20C
        }
//End ManterImovel onCache Method Tail

//ManterImovel Page Handler Tail @1-FCB6E20C
    }
//End ManterImovel Page Handler Tail

//tbl_imovel Record Handler Head @2-AA3D2EE1
    public class ManterImoveltbl_imovelRecordHandler implements RecordListener, RecordDataObjectListener {
//End tbl_imovel Record Handler Head

//tbl_imovel afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End tbl_imovel afterInitialize Method Head

//tbl_imovel afterInitialize Method Tail @2-FCB6E20C
        }
//End tbl_imovel afterInitialize Method Tail

//tbl_imovel OnSetDataSource Method Head @2-9B7FBFCF
        public void onSetDataSource(DataObjectEvent e) {
//End tbl_imovel OnSetDataSource Method Head

//tbl_imovel OnSetDataSource Method Tail @2-FCB6E20C
        }
//End tbl_imovel OnSetDataSource Method Tail

//tbl_imovel BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End tbl_imovel BeforeShow Method Head

//tbl_imovel BeforeShow Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeShow Method Tail

//tbl_imovel OnValidate Method Head @2-5F430F8E
        public void onValidate(Event e) {
//End tbl_imovel OnValidate Method Head

//tbl_imovel OnValidate Method Tail @2-FCB6E20C
        }
//End tbl_imovel OnValidate Method Tail

//tbl_imovel BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End tbl_imovel BeforeSelect Method Head

//tbl_imovel BeforeSelect Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeSelect Method Tail

//tbl_imovel BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End tbl_imovel BeforeBuildSelect Method Head

//tbl_imovel BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeBuildSelect Method Tail

//tbl_imovel BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End tbl_imovel BeforeExecuteSelect Method Head

//tbl_imovel BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeExecuteSelect Method Tail

//tbl_imovel AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End tbl_imovel AfterExecuteSelect Method Head

//tbl_imovel AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End tbl_imovel AfterExecuteSelect Method Tail

//tbl_imovel BeforeInsert Method Head @2-75B62B83
        public void beforeInsert(Event e) {
//End tbl_imovel BeforeInsert Method Head

//tbl_imovel BeforeInsert Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeInsert Method Tail

//tbl_imovel BeforeBuildInsert Method Head @2-FD6471B0
        public void beforeBuildInsert(DataObjectEvent e) {
//End tbl_imovel BeforeBuildInsert Method Head

//tbl_imovel BeforeBuildInsert Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeBuildInsert Method Tail

//tbl_imovel BeforeExecuteInsert Method Head @2-4EB41272
        public void beforeExecuteInsert(DataObjectEvent e) {
//End tbl_imovel BeforeExecuteInsert Method Head

//tbl_imovel BeforeExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeExecuteInsert Method Tail

//tbl_imovel AfterExecuteInsert Method Head @2-C4572C5E
        public void afterExecuteInsert(DataObjectEvent e) {
//End tbl_imovel AfterExecuteInsert Method Head

//tbl_imovel AfterExecuteInsert Method Tail @2-FCB6E20C
        }
//End tbl_imovel AfterExecuteInsert Method Tail

//tbl_imovel AfterInsert Method Head @2-767A9165
        public void afterInsert(Event e) {
//End tbl_imovel AfterInsert Method Head

//tbl_imovel AfterInsert Method Tail @2-FCB6E20C
        }
//End tbl_imovel AfterInsert Method Tail

//tbl_imovel BeforeUpdate Method Head @2-33A3CFAC
        public void beforeUpdate(Event e) {
//End tbl_imovel BeforeUpdate Method Head

//tbl_imovel BeforeUpdate Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeUpdate Method Tail

//tbl_imovel BeforeBuildUpdate Method Head @2-37688606
        public void beforeBuildUpdate(DataObjectEvent e) {
//End tbl_imovel BeforeBuildUpdate Method Head

//tbl_imovel BeforeBuildUpdate Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeBuildUpdate Method Tail

//tbl_imovel BeforeExecuteUpdate Method Head @2-84B8E5C4
        public void beforeExecuteUpdate(DataObjectEvent e) {
//End tbl_imovel BeforeExecuteUpdate Method Head

//tbl_imovel BeforeExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeExecuteUpdate Method Tail

//tbl_imovel AfterExecuteUpdate Method Head @2-0E5BDBE8
        public void afterExecuteUpdate(DataObjectEvent e) {
//End tbl_imovel AfterExecuteUpdate Method Head

//tbl_imovel AfterExecuteUpdate Method Tail @2-FCB6E20C
        }
//End tbl_imovel AfterExecuteUpdate Method Tail

//tbl_imovel AfterUpdate Method Head @2-306F754A
        public void afterUpdate(Event e) {
//End tbl_imovel AfterUpdate Method Head

//tbl_imovel AfterUpdate Method Tail @2-FCB6E20C
        }
//End tbl_imovel AfterUpdate Method Tail

//tbl_imovel BeforeDelete Method Head @2-752E3118
        public void beforeDelete(Event e) {
//End tbl_imovel BeforeDelete Method Head

//tbl_imovel BeforeDelete Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeDelete Method Tail

//tbl_imovel BeforeBuildDelete Method Head @2-01A46505
        public void beforeBuildDelete(DataObjectEvent e) {
//End tbl_imovel BeforeBuildDelete Method Head

//tbl_imovel BeforeBuildDelete Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeBuildDelete Method Tail

//tbl_imovel BeforeExecuteDelete Method Head @2-B27406C7
        public void beforeExecuteDelete(DataObjectEvent e) {
//End tbl_imovel BeforeExecuteDelete Method Head

//tbl_imovel BeforeExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_imovel BeforeExecuteDelete Method Tail

//tbl_imovel AfterExecuteDelete Method Head @2-389738EB
        public void afterExecuteDelete(DataObjectEvent e) {
//End tbl_imovel AfterExecuteDelete Method Head

//tbl_imovel AfterExecuteDelete Method Tail @2-FCB6E20C
        }
//End tbl_imovel AfterExecuteDelete Method Tail

//tbl_imovel AfterDelete Method Head @2-76E28BFE
        public void afterDelete(Event e) {
//End tbl_imovel AfterDelete Method Head

//tbl_imovel AfterDelete Method Tail @2-FCB6E20C
        }
//End tbl_imovel AfterDelete Method Tail

//tbl_imovel Record Handler Tail @2-FCB6E20C
    }
//End tbl_imovel Record Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-E19DFF25
    Page ManterImovelModel = (Page)request.getAttribute("ManterImovel_page");
    Page ManterImovelParent = (Page)request.getAttribute("ManterImovelParent");
    if (ManterImovelModel == null) {
        PageController ManterImovelCntr = new PageController(request, response, application, "/ManterImovel.xml" );
        ManterImovelModel = ManterImovelCntr.getPage();
        ManterImovelModel.setRelativePath("./");
        //if (ManterImovelParent != null) {
            //if (!ManterImovelParent.getChild(ManterImovelModel.getName()).isVisible()) return;
        //}
        ManterImovelModel.addPageListener(new ManterImovelPageHandler());
        ((Record)ManterImovelModel.getChild("tbl_imovel")).addRecordListener(new ManterImoveltbl_imovelRecordHandler());
        ManterImovelCntr.process();
%>
<%
        if (ManterImovelParent == null) {
            ManterImovelModel.setCookies();
            if (ManterImovelModel.redirect()) return;
        } else {
            ManterImovelModel.redirect();
        }
    }
//End Processing

%>
