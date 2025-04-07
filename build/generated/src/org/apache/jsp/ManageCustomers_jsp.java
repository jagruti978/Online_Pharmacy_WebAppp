package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class ManageCustomers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Manage Customers</title>\n");
      out.write("    <style>\n");
      out.write("        body { font-family: 'Poppins', sans-serif; background-color: #ffe6f2; margin: 0; padding: 20px; text-align: center; }\n");
      out.write("        h1 { color: #d63384; margin-top: 100px; }\n");
      out.write("\n");
      out.write("        .navbar { background-color: #d63384; padding: 15px; position: fixed; top: 0; left: 0; width: 100%; z-index: 1000; display: flex; justify-content: center; }\n");
      out.write("        .navbar a { color: white; padding: 10px 15px; text-decoration: none; font-weight: bold; transition: 0.3s; }\n");
      out.write("        .navbar a:hover { background-color: #ff66a3; border-radius: 5px; }\n");
      out.write("\n");
      out.write("        .table-container { width: 80%; margin: auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); }\n");
      out.write("        table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n");
      out.write("        th, td { border: 1px solid #ccc; padding: 12px; text-align: left; }\n");
      out.write("        th { background-color: #d63384; color: white; }\n");
      out.write("        tr:nth-child(even) { background-color: #fce4ec; }\n");
      out.write("        tr:hover { background-color: #f8bbd0; }\n");
      out.write("\n");
      out.write("        .view-btn {\n");
      out.write("            background-color: #d63384;\n");
      out.write("            color: white;\n");
      out.write("            padding: 8px 15px;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("        .view-btn:hover { background-color: #ff66a3; }\n");
      out.write("\n");
      out.write("        .modal {\n");
      out.write("            display: none; position: fixed; z-index: 1000; left: 0; top: 0; width: 100%; height: 100%;\n");
      out.write("            background-color: rgba(0, 0, 0, 0.4);\n");
      out.write("        }\n");
      out.write("        .modal-content {\n");
      out.write("            background-color: white; margin: 10% auto; padding: 20px; width: 50%;\n");
      out.write("            border-radius: 10px; text-align: center; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);\n");
      out.write("        }\n");
      out.write("        .close-btn {\n");
      out.write("            background-color: red; color: white; padding: 10px 15px; border: none; cursor: pointer;\n");
      out.write("            border-radius: 5px; transition: 0.3s;\n");
      out.write("        }\n");
      out.write("        .close-btn:hover { background-color: darkred; }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("        <a href=\"adminDashboardServlet\">Home</a>\n");
      out.write("        <a href=\"index.html\">Logout</a>\n");
      out.write("        <a href=\"ManageProducts.jsp\">Manage Products</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <h1>Manage Customers</h1>\n");
      out.write("\n");
      out.write("    <div class=\"table-container\">\n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Username</th>\n");
      out.write("                    <th>Age</th>\n");
      out.write("                    <th>State</th>\n");
      out.write("                    <th>View</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
 
                    Connection conn = null;
                    CallableStatement cstmt = null;
                    ResultSet rs = null;
                    
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");
                        cstmt = conn.prepareCall("{CALL GetAllCustomers()}");
                        rs = cstmt.executeQuery();

                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String username = rs.getString("username");
                            int age = rs.getInt("age");
                            String state = rs.getString("state");
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( id );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( name );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( username );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( age );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( state );
      out.write("</td>\n");
      out.write("                    <td><button class=\"view-btn\" onclick=\"openModal('");
      out.print( name );
      out.write("', '");
      out.print( username );
      out.write("', '");
      out.print( age );
      out.write("', '");
      out.print( state );
      out.write("')\">View</button></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) try { rs.close(); } catch (SQLException ex) {}
                        if (cstmt != null) try { cstmt.close(); } catch (SQLException ex) {}
                        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"customerModal\" class=\"modal\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <h2>Customer Details</h2>\n");
      out.write("            <p><strong>Name:</strong> <span id=\"modalName\"></span></p>\n");
      out.write("            <p><strong>Username:</strong> <span id=\"modalUsername\"></span></p>\n");
      out.write("            <p><strong>Age:</strong> <span id=\"modalAge\"></span></p>\n");
      out.write("            <p><strong>State:</strong> <span id=\"modalState\"></span></p>\n");
      out.write("            <button class=\"close-btn\" onclick=\"closeModal()\">Close</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function openModal(name, username, age, state) {\n");
      out.write("            document.getElementById(\"modalName\").innerText = name;\n");
      out.write("            document.getElementById(\"modalUsername\").innerText = username;\n");
      out.write("            document.getElementById(\"modalAge\").innerText = age;\n");
      out.write("            document.getElementById(\"modalState\").innerText = state;\n");
      out.write("            document.getElementById(\"customerModal\").style.display = \"block\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function closeModal() {\n");
      out.write("            document.getElementById(\"customerModal\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
