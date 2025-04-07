package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UpdateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Update Product</title>\n");
      out.write("    <style>\n");
      out.write("       * { margin: 0; padding: 0; box-sizing: border-box; } \n");
      out.write("body { font-family: 'Arial', sans-serif; background-color: #ffe6f2; color: #333; display: flex; flex-direction: column; align-items: center; min-height: 100vh; } \n");
      out.write(".navbar { background-color: #c2185b; width: 100%; padding: 15px; display: flex; justify-content: center; gap: 20px; position: fixed; top: 0; left: 0; z-index: 1000; } \n");
      out.write(".navbar a { color: white; padding: 10px 15px; text-decoration: none; font-weight: bold; border-radius: 5px; transition: background-color 0.3s; } \n");
      out.write(".navbar a:hover { background-color: #8e0e3a; } \n");
      out.write("h1 { margin: 20px 0; font-size: 28px; color: #c2185b; text-align: center; } \n");
      out.write(".form-container { margin-top: 100px; background: white; padding: 30px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); width: 400px; text-align: center; } \n");
      out.write("label { display: block; margin: 10px 0 5px; font-weight: bold; text-align: left; } \n");
      out.write("input, select { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; } \n");
      out.write(".btn-submit { margin-top: 15px; background-color: #c2185b; color: white; padding: 10px 15px; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; transition: background-color 0.3s, transform 0.2s; } \n");
      out.write(".btn-submit:hover { background-color: #8e0e3a; transform: scale(1.05); }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("        <a href=\"adminDashboard.jsp\">Home</a>\n");
      out.write("        <a href=\"ManageProducts.jsp\">Manage Products</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"form-container\">\n");
      out.write("        <h1>Update Product</h1>\n");
      out.write("        <form action=\"UpdateProductServlet\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("            <label for=\"product_id\">Product ID:</label>\n");
      out.write("            <input type=\"number\" name=\"product_id\" value=\"");
      out.print( request.getAttribute("product_id") != null ? request.getAttribute("product_id") : "" );
      out.write("\" required readonly>\n");
      out.write("\n");
      out.write("            <label for=\"product_name\">Product Name:</label>\n");
      out.write("            <input type=\"text\" name=\"product_name\" value=\"");
      out.print( request.getAttribute("product_name") != null ? request.getAttribute("product_name") : "" );
      out.write("\" required>\n");
      out.write("\n");
      out.write("            <label for=\"price\">Price:</label>\n");
      out.write("            <input type=\"number\" step=\"0.01\" name=\"price\" value=\"");
      out.print( request.getAttribute("price") != null ? request.getAttribute("price") : "" );
      out.write("\" required>\n");
      out.write("\n");
      out.write("            <label for=\"stock\">Stock:</label>\n");
      out.write("            <input type=\"number\" name=\"stock\" value=\"");
      out.print( request.getAttribute("stock") != null ? request.getAttribute("stock") : "" );
      out.write("\" required>\n");
      out.write("\n");
      out.write("            <label for=\"category\">Category:</label>\n");
      out.write("            <input type=\"text\" name=\"category\" value=\"");
      out.print( request.getAttribute("category") != null ? request.getAttribute("category") : "" );
      out.write("\" required>\n");
      out.write("\n");
      out.write("            <label for=\"product_image\">Product Image (optional):</label>\n");
      out.write("            <input type=\"file\" name=\"product_image\" accept=\"image/*\">\n");
      out.write("\n");
      out.write("            ");
 if(request.getAttribute("image_url") != null) { 
      out.write("\n");
      out.write("                <div class=\"existing-image\">\n");
      out.write("                    <p>Current Image:</p>\n");
      out.write("                    <img src=\"");
      out.print( request.getAttribute("image_url") );
      out.write("\" alt=\"Product Image\" width=\"150\">\n");
      out.write("                </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Update Product\" class=\"btn-submit\">\n");
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
