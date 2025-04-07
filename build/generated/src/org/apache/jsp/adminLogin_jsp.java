package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    String adminUsername = request.getParameter("adminUsername");
    String adminPassword = request.getParameter("adminPassword");

    String validUsername = "admin";
    String validPassword = "fashion@123"; 

    String errorMessage = null;

    if (adminUsername != null && adminPassword != null) {
        if (adminUsername.equals(validUsername) && adminPassword.equals(validPassword)) {
            response.sendRedirect("adminDashboard.jsp");
            return; 
        } else {
            errorMessage = "Invalid username or password. Please try again.";
        }
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Admin Login - Women's Fashion Shopping Cart</title>\n");
      out.write("    <style>\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            font-family: 'Arial', sans-serif;\n");
      out.write("            background-color: #ffe6f2; \n");
      out.write("            color: #333;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("            height: 100vh; \n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-container {\n");
      out.write("            background-color: #fff;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("            width: 350px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            font-size: 24px;\n");
      out.write("            color: #c2185b;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("            font-weight: bold;\n");
      out.write("            display: block;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .error-message {\n");
      out.write("            color: red;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .button-container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        button {\n");
      out.write("            background-color: #c2185b;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            width: 150px;\n");
      out.write("            transition: background-color 0.3s, transform 0.2s;\n");
      out.write("            cursor: pointer;\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        button:hover {\n");
      out.write("            background-color: #8e0e3a;\n");
      out.write("            transform: scale(1.05);\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"login-container\">\n");
      out.write("        <h1>Admin Login</h1>\n");
      out.write("\n");
      out.write("        ");
 if (errorMessage != null) { 
      out.write("\n");
      out.write("            <p class=\"error-message\">");
      out.print( errorMessage );
      out.write("</p>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"adminLogin.jsp\" method=\"post\">\n");
      out.write("            <label for=\"adminUsername\">Username:</label>\n");
      out.write("            <input type=\"text\" id=\"adminUsername\" name=\"adminUsername\" required>\n");
      out.write("\n");
      out.write("            <label for=\"adminPassword\">Password:</label>\n");
      out.write("            <input type=\"password\" id=\"adminPassword\" name=\"adminPassword\" required>\n");
      out.write("\n");
      out.write("            <div class=\"button-container\">\n");
      out.write("                <button type=\"submit\">Login</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
