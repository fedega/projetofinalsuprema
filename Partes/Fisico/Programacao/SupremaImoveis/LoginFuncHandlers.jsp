<%--== Handlers ==--%> <%--LoginFunc Opening Initialization directive @1-A0E75F14--%><%!

// //Workaround for JRun 3.1 @1-F81417CB

//content type (workaround for Tomcat 6) @1-07BBDEA7
%><%@page contentType="text/html; charset=windows-1252"%><%!
//End content type (workaround for Tomcat 6)

//Feature checker Head @1-3DD0775A
    public class LoginFuncServiceChecker implements com.codecharge.features.IServiceChecker {
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

//Button_DoLogin Button Handler Head @3-24601090
    public class LoginButton_DoLoginButtonHandler implements ButtonListener {
//End Button_DoLogin Button Handler Head

//Button_DoLogin OnClick Method Head @3-A9885EEC
        public void onClick(Event e) {
//End Button_DoLogin OnClick Method Head

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

//Processing @1-1A498EE5
    Page LoginFuncModel = (Page)request.getAttribute("LoginFunc_page");
    Page LoginFuncParent = (Page)request.getAttribute("LoginFuncParent");
    if (LoginFuncModel == null) {
        PageController LoginFuncCntr = new PageController(request, response, application, "/LoginFunc.xml" );
        LoginFuncModel = LoginFuncCntr.getPage();
        LoginFuncModel.setRelativePath("./");
        //if (LoginFuncParent != null) {
            //if (!LoginFuncParent.getChild(LoginFuncModel.getName()).isVisible()) return;
        //}
        ((Button)((Record)LoginFuncModel.getChild("Login")).getChild("Button_DoLogin")).addButtonListener(new LoginButton_DoLoginButtonHandler());
        ((TextBox)((Record)LoginFuncModel.getChild("Login")).getChild("login")).addValidationListener(new LoginloginTextBoxHandler());
        ((TextBox)((Record)LoginFuncModel.getChild("Login")).getChild("password")).addValidationListener(new LoginpasswordTextBoxHandler());
        LoginFuncCntr.process();
%>
<%
        if (LoginFuncParent == null) {
            LoginFuncModel.setCookies();
            if (LoginFuncModel.redirect()) return;
        } else {
            LoginFuncModel.redirect();
        }
    }
//End Processing

%>