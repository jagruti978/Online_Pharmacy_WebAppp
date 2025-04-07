package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.Base64;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Our Products - Women's Fashion</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f8f9fa;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .products {\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            justify-content: center;\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("        .product {\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin: 10px;\n");
      out.write("            width: 220px;\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: white;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("        .product img {\n");
      out.write("            width: 120px;\n");
      out.write("            height: 120px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("        }\n");
      out.write("        button {\n");
      out.write("            background-color: #c2185b;\n");
      out.write("            color: white;\n");
      out.write("            padding: 8px 16px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            border: none;\n");
      out.write("            transition: background-color 0.3s, transform 0.2s;\n");
      out.write("        }\n");
      out.write("        button:hover {\n");
      out.write("            background-color: #ff4081;\n");
      out.write("            transform: scale(1.05);\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        function redirectToLogin() {\n");
      out.write("            window.location.href = \"Login.jsp\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1 style=\"text-align:center; color:#c2185b; margin-top: 50px;\">Our Fashion Collection</h1>\n");
      out.write("    <div class=\"products\">\n");
      out.write("        ");

            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle", "root", "Jag19@root");
                String sql = "SELECT * FROM products60";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String productName = rs.getString("product_name");
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock");
                    String imageBase64 = "default-image.jpg";

                    Blob imageBlob = rs.getBlob("product_image");
                    if (imageBlob != null) {
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        imageBase64 = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
                    }
        
      out.write("\n");
      out.write("        <div class=\"product\">\n");
      out.write("            <img src=\"");
      out.print( imageBase64 );
      out.write("\" alt=\"");
      out.print( productName );
      out.write("\">\n");
      out.write("            <h3>");
      out.print( productName );
      out.write("</h3>\n");
      out.write("            <p>Price: ₹");
      out.print( price );
      out.write("</p>\n");
      out.write("            <p>Stock: ");
      out.print( stock );
      out.write("</p>\n");
      out.write("            <button onclick=\"redirectToLogin()\">Add to Cart</button>\n");
      out.write("        </div>\n");
      out.write("        ");

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
                try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
                try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
            }
        
      out.write("\n");
      out.write("    </div>\n");
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
