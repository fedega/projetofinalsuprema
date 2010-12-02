<%--== Handlers ==--%> <%--LocadorPag Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-F617D6FE
    public class LocadorPagServiceChecker implements com.codecharge.features.IServiceChecker {
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

//LocadorPag Page Handler Head @1-5EEE245E
    public class LocadorPagPageHandler implements PageListener {
//End LocadorPag Page Handler Head

//LocadorPag BeforeInitialize Method Head @1-4C73EADA
        public void beforeInitialize(Event e) {
//End LocadorPag BeforeInitialize Method Head

//LocadorPag BeforeInitialize Method Tail @1-FCB6E20C
        }
//End LocadorPag BeforeInitialize Method Tail

//LocadorPag AfterInitialize Method Head @1-89E84600
        public void afterInitialize(Event e) {
//End LocadorPag AfterInitialize Method Head

//LocadorPag AfterInitialize Method Tail @1-FCB6E20C
        }
//End LocadorPag AfterInitialize Method Tail

//LocadorPag OnInitializeView Method Head @1-E3C15E0F
        public void onInitializeView(Event e) {
//End LocadorPag OnInitializeView Method Head

//LocadorPag OnInitializeView Method Tail @1-FCB6E20C
        }
//End LocadorPag OnInitializeView Method Tail

//LocadorPag BeforeShow Method Head @1-46046458
        public void beforeShow(Event e) {
//End LocadorPag BeforeShow Method Head

//LocadorPag BeforeShow Method Tail @1-FCB6E20C
        }
//End LocadorPag BeforeShow Method Tail

//LocadorPag BeforeOutput Method Head @1-BE3571C7
        public void beforeOutput(Event e) {
//End LocadorPag BeforeOutput Method Head

//LocadorPag BeforeOutput Method Tail @1-FCB6E20C
        }
//End LocadorPag BeforeOutput Method Tail

//LocadorPag BeforeUnload Method Head @1-1DDBA584
        public void beforeUnload(Event e) {
//End LocadorPag BeforeUnload Method Head

//LocadorPag BeforeUnload Method Tail @1-FCB6E20C
        }
//End LocadorPag BeforeUnload Method Tail

//LocadorPag onCache Method Head @1-7A88A4B8
        public void onCache(CacheEvent e) {
//End LocadorPag onCache Method Head

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

//LocadorPag onCache Method Tail @1-FCB6E20C
        }
//End LocadorPag onCache Method Tail

//LocadorPag Page Handler Tail @1-FCB6E20C
    }
//End LocadorPag Page Handler Tail

//AcompanhamentodePendencias Grid Handler Head @2-72D7DEB8
    public class LocadorPagAcompanhamentodePendenciasGridHandler implements GridListener, GridDataObjectListener {
//End AcompanhamentodePendencias Grid Handler Head

//AcompanhamentodePendencias afterInitialize Method Head @2-89E84600
        public void afterInitialize(Event e) {
//End AcompanhamentodePendencias afterInitialize Method Head

//AcompanhamentodePendencias afterInitialize Method Tail @2-FCB6E20C
        }
//End AcompanhamentodePendencias afterInitialize Method Tail

//AcompanhamentodePendencias BeforeShow Method Head @2-46046458
        public void beforeShow(Event e) {
//End AcompanhamentodePendencias BeforeShow Method Head

//AcompanhamentodePendencias attributes @2-7C0E636D
            {
                com.codecharge.util.ModelAttribute ma_1 = ((com.codecharge.util.ModelAttribute)e.getModel().getAttribute( "RowNumber" ));
                if (ma_1 != null) ma_1.setValue("");
            }
//End AcompanhamentodePendencias attributes

//AcompanhamentodePendencias BeforeShow Method Tail @2-FCB6E20C
        }
//End AcompanhamentodePendencias BeforeShow Method Tail

//AcompanhamentodePendencias BeforeShowRow Method Head @2-BDFD38FC
        public void beforeShowRow(Event e) {
//End AcompanhamentodePendencias BeforeShowRow Method Head

//AcompanhamentodePendencias attributes @2-7C0E636D
            {
                com.codecharge.util.ModelAttribute ma_1 = ((com.codecharge.util.ModelAttribute)e.getModel().getAttribute( "RowNumber" ));
                if (ma_1 != null) ma_1.setValue("");
            }
//End AcompanhamentodePendencias attributes

//AcompanhamentodePendencias BeforeShowRow Method Tail @2-FCB6E20C
        }
//End AcompanhamentodePendencias BeforeShowRow Method Tail

//AcompanhamentodePendencias BeforeSelect Method Head @2-E5EC9AD3
        public void beforeSelect(Event e) {
//End AcompanhamentodePendencias BeforeSelect Method Head

//AcompanhamentodePendencias BeforeSelect Method Tail @2-FCB6E20C
        }
//End AcompanhamentodePendencias BeforeSelect Method Tail

//AcompanhamentodePendencias BeforeBuildSelect Method Head @2-3041BA14
        public void beforeBuildSelect(DataObjectEvent e) {
//End AcompanhamentodePendencias BeforeBuildSelect Method Head

//AcompanhamentodePendencias BeforeBuildSelect Method Tail @2-FCB6E20C
        }
//End AcompanhamentodePendencias BeforeBuildSelect Method Tail

//AcompanhamentodePendencias BeforeExecuteSelect Method Head @2-8391D9D6
        public void beforeExecuteSelect(DataObjectEvent e) {
//End AcompanhamentodePendencias BeforeExecuteSelect Method Head

//AcompanhamentodePendencias BeforeExecuteSelect Method Tail @2-FCB6E20C
        }
//End AcompanhamentodePendencias BeforeExecuteSelect Method Tail

//AcompanhamentodePendencias AfterExecuteSelect Method Head @2-0972E7FA
        public void afterExecuteSelect(DataObjectEvent e) {
//End AcompanhamentodePendencias AfterExecuteSelect Method Head

//AcompanhamentodePendencias AfterExecuteSelect Method Tail @2-FCB6E20C
        }
//End AcompanhamentodePendencias AfterExecuteSelect Method Tail

//AcompanhamentodePendencias Grid Handler Tail @2-FCB6E20C
    }
//End AcompanhamentodePendencias Grid Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-388D220F
    Page LocadorPagModel = (Page)request.getAttribute("LocadorPag_page");
    Page LocadorPagParent = (Page)request.getAttribute("LocadorPagParent");
    if (LocadorPagModel == null) {
        PageController LocadorPagCntr = new PageController(request, response, application, "/LocadorPag.xml" );
        LocadorPagModel = LocadorPagCntr.getPage();
        LocadorPagModel.setRelativePath("./");
        //if (LocadorPagParent != null) {
            //if (!LocadorPagParent.getChild(LocadorPagModel.getName()).isVisible()) return;
        //}
        ((Grid)LocadorPagModel.getChild("AcompanhamentodePendencias")).addGridListener(new LocadorPagAcompanhamentodePendenciasGridHandler());
        LocadorPagCntr.process();
%>
<%
        if (LocadorPagParent == null) {
            LocadorPagModel.setCookies();
            if (LocadorPagModel.redirect()) return;
        } else {
            LocadorPagModel.redirect();
        }
    }
//End Processing

%>
