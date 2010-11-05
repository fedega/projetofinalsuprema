<%--== Handlers ==--%> <%--Imoveis Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-8B950456
    public class ImoveisServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-5C69F999
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ( "FlashChart1".equals ( attr ) ) {
                CCSTemplate tmpl = new CCSTemplate();
                CCLogger logger = CCLogger.getInstance();
                tmpl.setServletContext(context);
                tmpl.setTemplateSource((ITemplateSource) context.getAttribute(Names.TEMPLATE_SOURCE_CLASS_NAME_KEY));
                String templateParserClassName = (String) context.getAttribute(Names.TEMPLATE_PARSER_CLASS_NAME_KEY);
                Object templateParser = null;
                try {
                    templateParser = Class.forName(templateParserClassName).newInstance();
                } catch (InstantiationException e) {
                    logger.error("",e);
                } catch (IllegalAccessException e) {
                    logger.error("",e);
                } catch (ClassNotFoundException e) {
                    logger.error("",e);
                }
                CCSLocale local = (CCSLocale) SessionStorage.getInstance( request ).getAttribute(Names.CCS_LOCALE_KEY);
                tmpl.setLocale(local.getLocale());
                tmpl.setTemplateParser((ITemplateParser) templateParser);
                tmpl.setEncoding("UTF-8");
                tmpl.load("/ImoveisFlashChart1.xml");
                //FlashChart
                JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection( "Conexao" );
                RawCommand command = new RawCommand( ds );

                command.setSql( "SELECT *  \n"
                            + "FROM tbl_imovel {SQL_Where} {SQL_OrderBy}" );

                command.setFetchSize(25);
                Enumeration records = null;
                if ( ! ds.hasErrors() ) {
                    records = command.getRows();
                    HashMap hRow = new HashMap();
                    if (records.hasMoreElements()) {
                        DbRow record = null;
                        while (records.hasMoreElements()) {
                            record = (DbRow) records.nextElement();
                            tmpl.setTag("main/Row", "@Cod_Funcionario", ""+record.get("Cod_Funcionario") );
                            tmpl.setTag("main/Row", "@Cod_Cidade", ""+record.get("Cod_Cidade") );
                            tmpl.setTag("main/Row", "@Cod_Estado", ""+record.get("Cod_Estado") );
                            tmpl.setTag("main/Row", "@Nivel_Controle", ""+record.get("Nivel_Controle") );
                            tmpl.render("main/Row", "main/Row", true, Template.IF_DOESNT_EXIST_IS_ERROR);
                        }
                    }
                    String result = tmpl.render("main");
                    try {
                        response.getWriter().print(result);
                    } catch (IOException e22) {}
                }
                ds.closeConnection();
                return true;
            }
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//Imoveis Page Handler Head @1-B1022F07
    public class ImoveisPageHandler implements PageListener {
//End Imoveis Page Handler Head

//Imoveis BeforeInitialize Method Head @1-4C73EADA
        public void beforeInitialize(Event e) {
//End Imoveis BeforeInitialize Method Head

//Imoveis BeforeInitialize Method Tail @1-FCB6E20C
        }
//End Imoveis BeforeInitialize Method Tail

//Imoveis AfterInitialize Method Head @1-89E84600
        public void afterInitialize(Event e) {
//End Imoveis AfterInitialize Method Head

//Imoveis AfterInitialize Method Tail @1-FCB6E20C
        }
//End Imoveis AfterInitialize Method Tail

//Imoveis OnInitializeView Method Head @1-E3C15E0F
        public void onInitializeView(Event e) {
//End Imoveis OnInitializeView Method Head

//Imoveis OnInitializeView Method Tail @1-FCB6E20C
        }
//End Imoveis OnInitializeView Method Tail

//Imoveis BeforeShow Method Head @1-46046458
        public void beforeShow(Event e) {
//End Imoveis BeforeShow Method Head

//Imoveis BeforeShow Method Tail @1-FCB6E20C
        }
//End Imoveis BeforeShow Method Tail

//Imoveis BeforeOutput Method Head @1-BE3571C7
        public void beforeOutput(Event e) {
//End Imoveis BeforeOutput Method Head

//Imoveis BeforeOutput Method Tail @1-FCB6E20C
        }
//End Imoveis BeforeOutput Method Tail

//Imoveis BeforeUnload Method Head @1-1DDBA584
        public void beforeUnload(Event e) {
//End Imoveis BeforeUnload Method Head

//Imoveis BeforeUnload Method Tail @1-FCB6E20C
        }
//End Imoveis BeforeUnload Method Tail

//Imoveis onCache Method Head @1-7A88A4B8
        public void onCache(CacheEvent e) {
//End Imoveis onCache Method Head

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

//Imoveis onCache Method Tail @1-FCB6E20C
        }
//End Imoveis onCache Method Tail

//Imoveis Page Handler Tail @1-FCB6E20C
    }
//End Imoveis Page Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-46DD3FD7
    Page ImoveisModel = (Page)request.getAttribute("Imoveis_page");
    Page ImoveisParent = (Page)request.getAttribute("ImoveisParent");
    if (ImoveisModel == null) {
        PageController ImoveisCntr = new PageController(request, response, application, "/Imoveis.xml" );
        ImoveisModel = ImoveisCntr.getPage();
        ImoveisModel.setRelativePath("./");
        //if (ImoveisParent != null) {
            //if (!ImoveisParent.getChild(ImoveisModel.getName()).isVisible()) return;
        //}
        ImoveisModel.addPageListener(new ImoveisPageHandler());
        ImoveisCntr.process();
%>
<%
        if (ImoveisParent == null) {
            ImoveisModel.setCookies();
            if (ImoveisModel.redirect()) return;
        } else {
            ImoveisModel.redirect();
        }
    }
//End Processing

%>
