<%--== Handlers ==--%> <%--Login Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-635D0B5C
    public class LoginServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Button_DoLogin Button Handler Head @3-24601090
    public class LoginButton_DoLoginButtonHandler implements ButtonListener {
//End Button_DoLogin Button Handler Head

//Button_DoLogin OnClick Method Head @3-A9885EEC
        public void onClick(Event e) {
//End Button_DoLogin OnClick Method Head

//Event OnClick Action Login @4-B92A5401
{
com.codecharge.util.Authenticator auth = com.codecharge.util.AuthenticatorFactory.getAuthenticator( e.getPage().getRequest() );
auth.setRequest( e.getPage().getRequest() );
auth.setResponse( e.getPage().getResponse() );
auth.invalidate();
if ( auth.authenticate( e.getComponent().getControl("login").getFormattedValue(), e.getComponent().getControl("password").getFormattedValue() ) ) {
String retLink = e.getPage().getHttpGetParams().getParameter("ret_link");
if (retLink != null) e.getPage().setRedirectString( retLink );
if (e.getComponent().hasChild("autoLogin") && !com.codecharge.util.StringUtils.isEmpty(e.getComponent().getControl("autoLogin").getFormattedValue() ) ) {
com.codecharge.util.Utils.setAutoLoginCookies( e.getPage(), e.getComponent().getControl("login").getFormattedValue(), e.getComponent().getControl("password").getFormattedValue() );
}
} else {
com.codecharge.util.Utils.clearAutoLoginCookies(e.getPage());
e.getParent().addError(e.getPage().getResourceString("CCS_LoginError"));
e.getPage().setRedirectString( null );
e.getComponent().getControl("password").setFormattedValue("");
}
}
//End Event OnClick Action Login

//Button_DoLogin OnClick Method Tail @3-FCB6E20C
        }
//End Button_DoLogin OnClick Method Tail

//Button_DoLogin BeforeShow Method Head @3-46046458
        public void beforeShow(Event e) {
//End Button_DoLogin BeforeShow Method Head

//Button_DoLogin BeforeShow Method Tail @3-FCB6E20C
        }
//End Button_DoLogin BeforeShow Method Tail

//Button_DoLogin Button Handler Tail @3-FCB6E20C
    }
//End Button_DoLogin Button Handler Tail

//login TextBox Handler Head @5-D581173C
    public class LoginloginTextBoxHandler implements ValidationListener {
//End login TextBox Handler Head

//login BeforeShow Method Head @5-46046458
        public void beforeShow(Event e) {
//End login BeforeShow Method Head

//login BeforeShow Method Tail @5-FCB6E20C
        }
//End login BeforeShow Method Tail

//login OnValidate Method Head @5-5F430F8E
        public void onValidate(Event e) {
//End login OnValidate Method Head

//login Required Validation @5-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End login Required Validation

//login OnValidate Method Tail @5-FCB6E20C
        }
//End login OnValidate Method Tail

//login TextBox Handler Tail @5-FCB6E20C
    }
//End login TextBox Handler Tail

//password TextBox Handler Head @6-6F6A872B
    public class LoginpasswordTextBoxHandler implements ValidationListener {
//End password TextBox Handler Head

//password BeforeShow Method Head @6-46046458
        public void beforeShow(Event e) {
//End password BeforeShow Method Head

//password BeforeShow Method Tail @6-FCB6E20C
        }
//End password BeforeShow Method Tail

//password OnValidate Method Head @6-5F430F8E
        public void onValidate(Event e) {
//End password OnValidate Method Head

//password Required Validation @6-EA72D057
        {
            Control cntrl = e.getControl();
            ((VerifiableControl)cntrl).addValidateHandler(new RequiredHandler( "" ));
        }
//End password Required Validation

//password OnValidate Method Tail @6-FCB6E20C
        }
//End password OnValidate Method Tail

//password TextBox Handler Tail @6-FCB6E20C
    }
//End password TextBox Handler Tail

//Comment workaround @1-A0AAE532
%> <%
//End Comment workaround

//Processing @1-B6685D36
    Page LoginModel = (Page)request.getAttribute("Login_page");
    Page LoginParent = (Page)request.getAttribute("LoginParent");
    if (LoginModel == null) {
        PageController LoginCntr = new PageController(request, response, application, "/Login.xml" );
        LoginModel = LoginCntr.getPage();
        LoginModel.setRelativePath("./");
        //if (LoginParent != null) {
            //if (!LoginParent.getChild(LoginModel.getName()).isVisible()) return;
        //}
        ((Button)((Record)LoginModel.getChild("Login")).getChild("Button_DoLogin")).addButtonListener(new LoginButton_DoLoginButtonHandler());
        ((TextBox)((Record)LoginModel.getChild("Login")).getChild("login")).addValidationListener(new LoginloginTextBoxHandler());
        ((TextBox)((Record)LoginModel.getChild("Login")).getChild("password")).addValidationListener(new LoginpasswordTextBoxHandler());
        LoginCntr.process();
%>
        <% request.setAttribute("HeaderParent", LoginModel); %>
        <%{%><%@include file="/HeaderHandlers.jsp"%><%}%>
        <% request.setAttribute("FooterParent", LoginModel); %>
        <%{%><%@include file="/FooterHandlers.jsp"%><%}%>
<%
        if (LoginParent == null) {
            LoginModel.setCookies();
            if (LoginModel.redirect()) return;
        } else {
            LoginModel.redirect();
        }
    }
//End Processing

%>
