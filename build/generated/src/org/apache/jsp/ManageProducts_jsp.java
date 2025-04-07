package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class ManageProducts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Manage Products - Women's Fashion</title>\n");
      out.write("    <style>\n");
      out.write("        body { font-family: Arial, sans-serif; background-color: #ffe6f2; text-align: center; margin: 0; padding: 20px; }\n");
      out.write("        h1 { font-size: 28px; color: #d63384; margin-top: 100px; }\n");
      out.write("        .navbar { width: 100%; background-color: #d63384; padding: 15px 0; display: flex; justify-content: center; position: fixed; top: 0; left: 0; z-index: 1000; }\n");
      out.write("        .navbar a { color: white; padding: 10px 15px; text-decoration: none; font-weight: bold; border-radius: 5px; transition: background-color 0.3s; }\n");
      out.write("        .navbar a:hover { background-color: #ff80b3; }\n");
      out.write("        .table-container { width: 80%; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); }\n");
      out.write("        table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n");
      out.write("        th, td { border: 1px solid #ccc; padding: 12px; text-align: left; }\n");
      out.write("        th { background-color: #d63384; color: white; font-weight: bold; }\n");
      out.write("        tr:nth-child(even) { background-color: #ffe6f2; }\n");
      out.write("        tr:hover { background-color: #ffb3d9; transition: 0.3s; }\n");
      out.write("        img { width: 80px; height: 80px; object-fit: cover; border-radius: 8px; }\n");
      out.write("        .btn { padding: 8px 12px; border-radius: 5px; text-decoration: none; font-weight: bold; cursor: pointer; }\n");
      out.write("        .btn-update { background-color: #007bff; color: white; }\n");
      out.write("        .btn-delete { background-color: #dc3545; color: white; }\n");
      out.write("        .btn-view { background-color: #17a2b8; color: white; }\n");
      out.write("        .btn:hover { opacity: 0.8; transition: 0.3s; }\n");
      out.write("        .modal { \n");
      out.write("            display: none; \n");
      out.write("            position: fixed; \n");
      out.write("            top: 50%; \n");
      out.write("            left: 50%; \n");
      out.write("            transform: translate(-50%, -50%); \n");
      out.write("            background: white; \n");
      out.write("            padding: 20px; \n");
      out.write("            border-radius: 10px; \n");
      out.write("            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.3); \n");
      out.write("            width: 80%;\n");
      out.write("            max-width: 700px; \n");
      out.write("            text-align: left; \n");
      out.write("        }\n");
      out.write("        .modal img { width: 100%; max-height: 800px; object-fit: contain; border-radius: 10px; }\n");
      out.write("        .close-btn { background: #dc3545; color: white; padding: 10px; border: none; cursor: pointer; border-radius: 5px; float: right; }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("        <a href=\"adminDashboard.jsp\">Home</a>\n");
      out.write("        <a href=\"AddProduct.jsp\">Add Product</a>\n");
      out.write("        <a href=\"UpdateProduct.jsp\">Update Product</a>\n");
      out.write("        <a href=\"DeleteProduct.jsp\">Delete Product</a>\n");
      out.write("    </div>\n");
      out.write("    <h1>Manage Products</h1>\n");
      out.write("    <div class=\"table-container\">\n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Stock</th>\n");
      out.write("                    <th>Category</th>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Actions</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
 
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT product_id, product_name, price, stock, category, product_image FROM products60");
                        while (rs.next()) {
                            int productId = rs.getInt("product_id");
                            String productName = rs.getString("product_name");
                            double price = rs.getDouble("price");
                            int stock = rs.getInt("stock");
                            String category = rs.getString("category");
                            Blob imageBlob = rs.getBlob("product_image");
                            String base64Image = "";
                            if (imageBlob != null) {
                                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                                base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
                            }
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( productName );
      out.write("</td>\n");
      out.write("                    <td>Rs. ");
      out.print( price );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( stock );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( category );
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
 if (!base64Image.isEmpty()) { 
      out.write("\n");
      out.write("                            <img src=\"data:image/jpeg;base64,");
      out.print( base64Image );
      out.write("\" alt=\"Product Image\">\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                            No Image\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"#\" class=\"btn btn-view\" onclick=\"openModal('");
      out.print( productName );
      out.write("', '");
      out.print( price );
      out.write("', '");
      out.print( stock );
      out.write("', '");
      out.print( category );
      out.write("', '");
      out.print( base64Image );
      out.write("')\">View</a> |\n");
      out.write("                        <a href=\"UpdateProduct.jsp?productId=");
      out.print( productId );
      out.write("\" class=\"btn btn-update\">Update</a> |\n");
      out.write("                        <a href=\"DeleteProduct.jsp?productId=");
      out.print( productId );
      out.write("\" class=\"btn btn-delete\" onclick=\"return confirm('Are you sure?');\">Delete</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) try { rs.close(); } catch (SQLException ex) {}
                        if (stmt != null) try { stmt.close(); } catch (SQLException ex) {}
                        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"productModal\" class=\"modal\">\n");
      out.write("        <button class=\"close-btn\" onclick=\"closeModal()\">Close</button>\n");
      out.write("        <h2 id=\"modalTitle\"></h2>\n");
      out.write("        <p><strong>Price:</strong> Rs.<span id=\"modalPrice\"></span></p>\n");
      out.write("        <p><strong>Stock:</strong> <span id=\"modalStock\"></span></p>\n");
      out.write("        <p><strong>Category:</strong> <span id=\"modalCategory\"></span></p>\n");
      out.write("        <img id=\"modalImage\" src=\"\" alt=\"Product Image\">\n");
      out.write("    </div>\n");
      out.write("    <script>\n");
      out.write("        function openModal(name, price, stock, category, image) {\n");
      out.write("            document.getElementById('modalTitle').innerText = name;\n");
      out.write("            document.getElementById('modalPrice').innerText = price;\n");
      out.write("            document.getElementById('modalStock').innerText = stock;\n");
      out.write("            document.getElementById('modalCategory').innerText = category;\n");
      out.write("            document.getElementById('modalImage').src = image ? \"data:image/jpeg;base64,\" + image : \"\";\n");
      out.write("            document.getElementById('productModal').style.display = 'block';\n");
      out.write("        }\n");
      out.write("        function closeModal() { document.getElementById('productModal').style.display = 'none'; }\n");
      out.write("    </script>\n");
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
