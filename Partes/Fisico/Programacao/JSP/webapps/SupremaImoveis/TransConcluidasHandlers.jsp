<%--== Handlers ==--%> <%--TransConcluidas Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-0EE1B4E0
    public class TransConcluidasServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-6B5A2C8B
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ((new HeaderServiceChecker()).check(request, response, context)) return true;
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
                tmpl.load("/TransConcluidasFlashChart1.xml");
                //FlashChart
                JDBCConnection ds = JDBCConnectionFactory.getJDBCConnection( "Conexao" );
                RawCommand command = new RawCommand( ds );

                command.setSql( "SELECT *  \n"
                            + "FROM tbl_funcionario {SQL_Where} {SQL_OrderBy}" );

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
                            tmpl.setTag("main/Row", "@Cod_Orgao", ""+record.get("Cod_Orgao") );
                            tmpl.setTag("main/Row", "@Tel_Fixo", ""+record.get("Tel_Fixo") );
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

//TransConcluidas Page Handler Head @1-9AD9A7A5
    public class TransConcluidasPageHandler implements PageListener {
//End TransConcluidas Page Handler Head

//TransConcluidas BeforeInitialize Method Head @1-4C73EADA
        public void beforeInitialize(Event e) {
//End TransConcluidas BeforeInitialize Method Head

//TransConcluidas BeforeInitialize Method Tail @1-FCB6E20C
        }
//End TransConcluidas BeforeInitialize Method Tail

//TransConcluidas AfterInitialize Method Head @1-89E84600
        public void afterInitialize(Event e) {
//End TransConcluidas AfterInitialize Method Head

//TransConcluidas AfterInitialize Method Tail @1-FCB6E20C
        }
//End TransConcluidas AfterInitialize Method Tail

//TransConcluidas OnInitializeView Method Head @1-E3C15E0F
        public void onInitializeView(Event e) {
//End TransConcluidas OnInitializeView Method Head

//TransConcluidas OnInitializeView Method Tail @1-FCB6E20C
        }
//End TransConcluidas OnInitializeView Method Tail

//TransConcluidas BeforeShow Method Head @1-46046458
        public void beforeShow(Event e) {
//End TransConcluidas BeforeShow Method Head

//TransConcluidas BeforeShow Method Tail @1-FCB6E20C
        }
//End TransConcluidas BeforeShow Method Tail

//TransConcluidas BeforeOutput Method Head @1-BE3571C7
        public void beforeOutput(Event e) {
//End TransConcluidas BeforeOutput Method Head

//TransConcluidas BeforeOutput Method Tail @1-FCB6E20C
        }
//End TransConcluidas BeforeOutput Method Tail

//TransConcluidas BeforeUnload Method Head @1-1DDBA584
        public void beforeUnload(Event e) {
//End TransConcluidas BeforeUnload Method Head

//TransConcluidas BeforeUnload Method Tail @1-FCB6E20C
        }
//End TransConcluidas BeforeUnload Method Tail

//TransConcluidas onCache Method Head @1-7A88A4B8
        public void onCache(CacheEvent e) {
//End TransConcluidas onCache Method Head

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

//TransConcluidas onCache Method Tail @1-FCB6E20C
        }
//End TransConcluidas onCache Method Tail

//TransConcluidas Page Handler Tail @1-FCB6E20C
    }
//End TransConcluidas Page Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-2182783B
    Page TransConcluidasModel = (Page)request.getAttribute("TransConcluidas_page");
    Page TransConcluidasParent = (Page)request.getAttribute("TransConcluidasParent");
    if (TransConcluidasModel == null) {
        PageController TransConcluidasCntr = new PageController(request, response, application, "/TransConcluidas.xml" );
        TransConcluidasModel = TransConcluidasCntr.getPage();
        TransConcluidasModel.setRelativePath("./");
        //if (TransConcluidasParent != null) {
            //if (!TransConcluidasParent.getChild(TransConcluidasModel.getName()).isVisible()) return;
        //}
        TransConcluidasModel.addPageListener(new TransConcluidasPageHandler());
        TransConcluidasCntr.process();
%>
        <% request.setAttribute("HeaderParent", TransConcluidasModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
<%
        if (TransConcluidasParent == null) {
            TransConcluidasModel.setCookies();
            if (TransConcluidasModel.redirect()) return;
        } else {
            TransConcluidasModel.redirect();
        }
    }
//End Processing

%>
