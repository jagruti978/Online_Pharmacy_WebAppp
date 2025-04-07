package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DeleteProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Delete Product</title>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        body { font-family: Arial, sans-serif; background-color: #ffe6f2; margin: 0; padding: 0; display: flex; flex-direction: column; align-items: center; }\n");
      out.write("\n");
      out.write("        .navbar { width: 100%; background-color: #c2185b; padding: 15px 0; display: flex; justify-content: center; position: fixed; top: 0; left: 0; z-index: 1000; }\n");
      out.write("        .navbar a { color: white; padding: 10px 20px; text-decoration: none; font-weight: bold; transition: background-color 0.3s; }\n");
      out.write("        .navbar a:hover { background-color: #8e0e3a; border-radius: 5px; }\n");
      out.write("\n");
      out.write("        .form-container { margin-top: 100px; background: white; padding: 30px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); width: 400px; text-align: center; }\n");
      out.write("\n");
      out.write("        label { display: block; margin: 10px 0 5px; font-weight: bold; text-align: left; }\n");
      out.write("        input[type=\"number\"] { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; }\n");
      out.write("\n");
      out.write("        .btn-submit { margin-top: 15px; background-color: #c2185b; color: white; padding: 10px 15px; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; }\n");
      out.write("        .btn-submit:hover { background-color: #8e0e3a; }\n");
      out.write("\n");
      out.write("        .success-message { color: green; font-weight: bold; margin-top: 10px; }\n");
      out.write("        .error-message { color: red; font-weight: bold; margin-top: 10px; }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("        <a href=\"adminDashboardServlet\">Home</a>\n");
      out.write("        <a href=\"ManageProducts.jsp\">Manage Products</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"form-container\">\n");
      out.write("        <h1>Delete Product</h1>\n");
      out.write("        <form action=\"DeleteProductServlet\" method=\"post\">\n");
      out.write("            <label for=\"product_id\">Product ID:</label>\n");
      out.write("            <input type=\"number\" name=\"product_id\" id=\"product_id\" required>\n");
      out.write("            <input type=\"submit\" value=\"Delete Product\" class=\"btn-submit\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            String message = request.getParameter("message");
            String error = request.getParameter("error");
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
 if (message != null) { 
      out.write("\n");
      out.write("            <div class=\"success-message\">\n");
      out.write("                ");
      out.print( message );
      out.write("\n");
      out.write("            </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        ");
 if (error != null) { 
      out.write("\n");
      out.write("            <div class=\"error-message\">\n");
      out.write("                ");
      out.print( error );
      out.write("\n");
      out.write("            </div>\n");
      out.write("        ");
 } 
      out.write("\n");
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
