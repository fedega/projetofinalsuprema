<%--== Handlers ==--%> <%--Header Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-0688AEF9
    public class HeaderServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Header Page Handler Head @1-4AC8BFEF
    public class HeaderPageHandler implements PageListener {
//End Header Page Handler Head

//Header BeforeInitialize Method Head @1-4C73EADA
        public void beforeInitialize(Event e) {
//End Header BeforeInitialize Method Head

//Header BeforeInitialize Method Tail @1-FCB6E20C
        }
//End Header BeforeInitialize Method Tail

//Header AfterInitialize Method Head @1-89E84600
        public void afterInitialize(Event e) {
//End Header AfterInitialize Method Head

//Header AfterInitialize Method Tail @1-FCB6E20C
        }
//End Header AfterInitialize Method Tail

//Header OnInitializeView Method Head @1-E3C15E0F
        public void onInitializeView(Event e) {
//End Header OnInitializeView Method Head

//Header OnInitializeView Method Tail @1-FCB6E20C
        }
//End Header OnInitializeView Method Tail

//Header BeforeShow Method Head @1-46046458
        public void beforeShow(Event e) {
//End Header BeforeShow Method Head

//Header BeforeShow Method Tail @1-FCB6E20C
        }
//End Header BeforeShow Method Tail

//Header BeforeOutput Method Head @1-BE3571C7
        public void beforeOutput(Event e) {
//End Header BeforeOutput Method Head

//Header BeforeOutput Method Tail @1-FCB6E20C
        }
//End Header BeforeOutput Method Tail

//Header BeforeUnload Method Head @1-1DDBA584
        public void beforeUnload(Event e) {
//End Header BeforeUnload Method Head

//Header BeforeUnload Method Tail @1-FCB6E20C
        }
//End Header BeforeUnload Method Tail

//Header onCache Method Head @1-7A88A4B8
        public void onCache(CacheEvent e) {
//End Header onCache Method Head

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

//Header onCache Method Tail @1-FCB6E20C
        }
//End Header onCache Method Tail

//Header Page Handler Tail @1-FCB6E20C
    }
//End Header Page Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-04A752C0
    Page HeaderModel = (Page)request.getAttribute("Header_page");
    Page HeaderParent = (Page)request.getAttribute("HeaderParent");
    if (HeaderModel == null) {
        PageController HeaderCntr = new PageController(request, response, application, "/Header.xml" );
        HeaderModel = HeaderCntr.getPage();
        //if (HeaderParent != null) {
            //if (!HeaderParent.getChild(HeaderModel.getName()).isVisible()) return;
        //}
        HeaderModel.addPageListener(new HeaderPageHandler());
        HeaderModel.setAttribute(Page.PAGE_ATTRIBUTE_PATH_TO_ROOT, (String)HeaderParent.getRelativePath());
        HeaderCntr.process();
%>
<%
        if (HeaderParent == null) {
            HeaderModel.setCookies();
            if (HeaderModel.redirect()) return;
        } else {
            HeaderModel.redirect();
        }
    }
//End Processing

%>
