package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>User Login - Women's Fashion Shopping Cart</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Arial', sans-serif;\n");
      out.write("            background-color: #f8f9fa;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background-color:#c2185b;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 1rem;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul {\n");
      out.write("            list-style: none;\n");
      out.write("            padding: 0;\n");
      out.write("            margin: 0;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li {\n");
      out.write("            margin: 0 15px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li a {\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: bold;\n");
      out.write("            transition: color 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li a:hover {\n");
      out.write("            color: #ffd700;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        main {\n");
      out.write("            max-width: 400px;\n");
      out.write("            margin: 30px auto;\n");
      out.write("            background: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input {\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            background-color: #c2185b;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            padding: 12px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #8e0e3a;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        p {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        footer {\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 15px;\n");
      out.write("            background-color: #c2185b;\n");
      out.write("            color: white;\n");
      out.write("            position: absolute;\n");
      out.write("            bottom: 0;\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Women's Fashion Shopping Cart</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                <li><a href=\"Login.jsp\">Login</a></li>\n");
      out.write("                <li><a href=\"Register.jsp\">Register</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <main>\n");
      out.write("        <h2>User Login</h2>\n");
      out.write("\n");
      out.write("        ");
 
            String msg = request.getParameter("msg");
            if ("invalid".equals(msg)) {
                out.println("<p style='color: red;'>Invalid username or password. Try again.</p>");
            } else if ("error".equals(msg)) {
                out.println("<p style='color: red;'>An error occurred. Please try again later.</p>");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"Login.jsp\" method=\"post\">\n");
      out.write("            <label for=\"username\">Username:</label>\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password:</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("            <p>Don't have an account? <a href=\"Register.jsp\">Create New</a></p>\n");
      out.write("            <input type=\"submit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");

                    String sql = "SELECT * FROM customers WHERE username = ? AND password = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        session.setAttribute("username", username);
                        response.sendRedirect("UserDashboard.jsp"); 
                    } else {
                        response.sendRedirect("Login.jsp?msg=invalid");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("Login.jsp?msg=error");
                } finally {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                }
            }
        
      out.write("\n");
      out.write("    </main>\n");
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
