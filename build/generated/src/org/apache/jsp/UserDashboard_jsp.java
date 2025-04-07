package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.Base64;

public final class UserDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>User Dashboard - Women's Fashion Shopping Cart</title>\n");
      out.write("    <style>\n");
      out.write("        body { font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 0; }\n");
      out.write("        .navbar { background-color: #c2185b; padding: 15px; text-align: center; }\n");
      out.write("        .navbar a { color: white; text-decoration: none; margin: 0 15px; font-weight: bold; }\n");
      out.write("        .navbar a:hover { color: #ffd700; }\n");
      out.write("        h1 { text-align: center; color: #333; margin-top: 20px; }\n");
      out.write("        .category { text-align: center; margin-bottom: 20px; }\n");
      out.write("        .category a { text-decoration: none; font-weight: bold; margin: 0 15px; color: #c2185b; }\n");
      out.write("        .category a:hover { text-decoration: underline; }\n");
      out.write("        .products { display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 20px; padding: 20px; }\n");
      out.write("        .product { background: white; padding: 15px; border-radius: 10px; text-align: center; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }\n");
      out.write("        .product img { width: 100%; height: 150px; object-fit: contain; margin-bottom: 10px; }\n");
      out.write("        .product h3 { font-size: 18px; margin-bottom: 10px; }\n");
      out.write("        .product p { font-size: 16px; color: #555; }\n");
      out.write("        .product button { background-color: #c2185b; color: white; border: none; padding: 10px; border-radius: 5px; cursor: pointer; width: 100%; }\n");
      out.write("        .product button:hover { background-color: #8e0e3a; }\n");
      out.write("        footer { background-color: #c2185b; color: white; text-align: center; padding: 15px; position: fixed; bottom: 0; width: 100%; }\n");
      out.write("    </style>\n");
      out.write("     <script>\n");
      out.write("        function addToCart(productName, productPrice) {\n");
      out.write("            let cart = JSON.parse(sessionStorage.getItem('cart')) || [];\n");
      out.write("            cart.push({ name: productName, price: productPrice });\n");
      out.write("            sessionStorage.setItem('cart', JSON.stringify(cart));\n");
      out.write("            window.location.href = 'cart.jsp';\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("        <a href=\"UserDashboard.jsp\">Home</a>\n");
      out.write("        <a href=\"cart.jsp\">Cart</a>\n");
      out.write("        <a href=\"orders.jsp\">MY Orders</a>\n");
      out.write("        <a href=\"logout.jsp\">Logout</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <h1>Welcome to Your Fashion Dashboard</h1>\n");
      out.write("\n");
      out.write("    <div class=\"category\">\n");
      out.write("        <h2>Categories</h2>\n");
      out.write("        <a href=\"UserDashboard.jsp\">All</a> |\n");
      out.write("        <a href=\"UserDashboard.jsp?category=Clothes\">Clothes</a> |\n");
      out.write("        <a href=\"UserDashboard.jsp?category=Accessories\">Accessories</a> |\n");
      out.write("        <a href=\"UserDashboard.jsp?category=Footwear\">Footwear</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"products\">\n");
      out.write("        ");
 
            String categoryFilter = request.getParameter("category");
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
               
                Class.forName("com.mysql.cj.jdbc.Driver");
              
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");
                
           
                String sql = "SELECT * FROM products60";
                if (categoryFilter != null && !categoryFilter.isEmpty()) {
                    sql += " WHERE category = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, categoryFilter);
                } else {
                    stmt = conn.prepareStatement(sql);
                }

                rs = stmt.executeQuery();
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
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
      out.write("            <p>Price: Rs ");
      out.print( price );
      out.write("</p>\n");
      out.write("            <p>Stock: ");
      out.print( stock );
      out.write("</p>\n");
      out.write("            <form action=\"cart.jsp\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print( productId );
      out.write("\">\n");
      out.write("                 <button onclick=\"addToCart('");
      out.print( productName );
      out.write("', ");
      out.print( price );
      out.write(")\">Add to Cart</button>\n");
      out.write("            </form>\n");
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
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        &copy; 2025 Women's Fashion Shopping Cart\n");
      out.write("    </footer>\n");
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
