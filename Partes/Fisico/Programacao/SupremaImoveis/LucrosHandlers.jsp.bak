<%--== Handlers ==--%> <%--Lucros Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-5E85D766
    public class LucrosServiceChecker implements com.codecharge.features.IServiceChecker {
//End Feature checker Head

//feature binding @1-238BAEF2
        public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context) {
            String attr = "" + request.getParameter("callbackControl");
            if ((new HeaderServiceChecker()).check(request, response, context)) return true;
            return false;
        }
//End feature binding

//Feature checker Tail @1-FCB6E20C
    }
//End Feature checker Tail

//Report_CurrentDate ReportLabel Handler Head @10-01A4D577
    public class NovoReport_CurrentDateReportLabelHandler implements ControlListener {
        public void beforeShow(Event e) {
//End Report_CurrentDate ReportLabel Handler Head

//Report_CurrentDate Special Value @10-CA5BA03C
            e.getControl().setValue(new java.util.Date());
//End Report_CurrentDate Special Value

//Report_CurrentDate ReportLabel Handler Tail @10-F5FC18C5
        }
    }
//End Report_CurrentDate ReportLabel Handler Tail

//Report_CurrentPage ReportLabel Handler Head @11-02926F89
    public class NovoReport_CurrentPageReportLabelHandler implements ControlListener {
        public void beforeShow(Event e) {
//End Report_CurrentPage ReportLabel Handler Head

//Report_CurrentPage Special Value @11-33946A12
            e.getControl().setValue(e.getPage().getReport("Novo").getPageNumber());
//End Report_CurrentPage Special Value

//Report_CurrentPage ReportLabel Handler Tail @11-F5FC18C5
        }
    }
//End Report_CurrentPage ReportLabel Handler Tail

//Report_TotalPages ReportLabel Handler Head @12-4EFAC29A
    public class NovoReport_TotalPagesReportLabelHandler implements ControlListener {
        public void beforeShow(Event e) {
//End Report_TotalPages ReportLabel Handler Head

//Report_TotalPages Special Value @12-A0B8A26E
            e.getControl().setValue(e.getPage().getReport("Novo").getTotalPages());
//End Report_TotalPages Special Value

//Report_TotalPages ReportLabel Handler Tail @12-F5FC18C5
        }
    }
//End Report_TotalPages ReportLabel Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-FFBF0EF6
    Page LucrosModel = (Page)request.getAttribute("Lucros_page");
    Page LucrosParent = (Page)request.getAttribute("LucrosParent");
    if (LucrosModel == null) {
        PageController LucrosCntr = new PageController(request, response, application, "/Lucros.xml" );
        LucrosModel = LucrosCntr.getPage();
        LucrosModel.setRelativePath("./");
        //if (LucrosParent != null) {
            //if (!LucrosParent.getChild(LucrosModel.getName()).isVisible()) return;
        //}
        ((ReportLabel)((Report)LucrosModel.getChild("Novo")).getChild("Report_CurrentDate")).addControlListener(new NovoReport_CurrentDateReportLabelHandler());
        ((ReportLabel)((Report)LucrosModel.getChild("Novo")).getChild("Report_CurrentPage")).addControlListener(new NovoReport_CurrentPageReportLabelHandler());
        ((ReportLabel)((Report)LucrosModel.getChild("Novo")).getChild("Report_TotalPages")).addControlListener(new NovoReport_TotalPagesReportLabelHandler());
        LucrosCntr.process();
%>
        <% request.setAttribute("HeaderParent", LucrosModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
<%
        if (LucrosParent == null) {
            LucrosModel.setCookies();
            if (LucrosModel.redirect()) return;
        } else {
            LucrosModel.redirect();
        }
    }
//End Processing

%>
