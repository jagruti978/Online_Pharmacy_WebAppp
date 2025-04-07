package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Your Cart - Women's Fashion</title>\n");
      out.write("    <style>\n");
      out.write("        * { margin: 0; padding: 0; box-sizing: border-box; }\n");
      out.write("        body {\n");
      out.write("            font-family: 'Poppins', sans-serif;\n");
      out.write("            background-color: #fff0f5;\n");
      out.write("            color: #333;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            min-height: 100vh;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        .navbar {\n");
      out.write("            background-color: #d63384;\n");
      out.write("            padding: 15px;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0; left: 0; width: 100%;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            z-index: 1000;\n");
      out.write("        }\n");
      out.write("        .navbar a {\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px 20px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: bold;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("        .navbar a:hover { background-color: #ff66a3; border-radius: 5px; }\n");
      out.write("        h1 { text-align: center; color: #d63384; margin-top: 100px; }\n");
      out.write("        .order-summary {\n");
      out.write("            background: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("            max-width: 900px;\n");
      out.write("            margin: auto;\n");
      out.write("        }\n");
      out.write("        table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n");
      out.write("        th, td { border: 1px solid #ccc; padding: 12px; text-align: center; }\n");
      out.write("        th { background-color: #d63384; color: white; }\n");
      out.write("        td button {\n");
      out.write("            background-color: #e74c3c;\n");
      out.write("            color: white;\n");
      out.write("            padding: 8px 12px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("        td button:hover { background-color: #c0392b; }\n");
      out.write("        button {\n");
      out.write("            background-color: #d63384;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            width: 100%;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("        button:hover { background-color: #ff66a3; }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("        <a href=\"UserDashboard.jsp\">Home</a>\n");
      out.write("        <a href=\"myOrders.jsp\">My Orders</a>\n");
      out.write("        <a href=\"index.html\">Logout</a>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <h1>Your Cart</h1>\n");
      out.write("    <button onclick=\"window.location.href='UserDashboard.jsp'\">Continue Shopping</button>\n");
      out.write("    \n");
      out.write("    <div class=\"order-summary\">\n");
      out.write("        <h2>Items in Your Cart</h2>\n");
      out.write("        <table id=\"cartItems\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Product</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Total</th>\n");
      out.write("                    <th>Actions</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody></tbody>\n");
      out.write("        </table>\n");
      out.write("        <p>Total Amount: <span id=\"totalAmount\">0.00</span></p>\n");
      out.write("        <button onclick=\"proceedToPlaceOrder()\">Proceed to Place Order</button>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        const cart = JSON.parse(sessionStorage.getItem('cart')) || [];\n");
      out.write("        const cartItemsList = document.getElementById('cartItems').getElementsByTagName('tbody')[0];\n");
      out.write("        let totalAmount = 0;\n");
      out.write("        cart.forEach((item, index) => {\n");
      out.write("            const row = cartItemsList.insertRow();\n");
      out.write("            row.innerHTML = `<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td><td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.price.toFixed(2)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                <td><input type='number' min='1' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.quantity || 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("' onchange='updateQuantity(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(", this.value)'></td>\n");
      out.write("                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(item.price * (item.quantity || 1)).toFixed(2)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                <td><button onclick='removeItem(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")'>Delete</button></td>`;\n");
      out.write("            totalAmount += item.price * (item.quantity || 1);\n");
      out.write("        });\n");
      out.write("        document.getElementById('totalAmount').textContent = totalAmount.toFixed(2);\n");
      out.write("        function updateQuantity(index, value) {\n");
      out.write("            cart[index].quantity = parseInt(value);\n");
      out.write("            sessionStorage.setItem('cart', JSON.stringify(cart));\n");
      out.write("            location.reload();\n");
      out.write("        }\n");
      out.write("        function removeItem(index) {\n");
      out.write("            cart.splice(index, 1);\n");
      out.write("            sessionStorage.setItem('cart', JSON.stringify(cart));\n");
      out.write("            location.reload();\n");
      out.write("        }\n");
      out.write("        function proceedToPlaceOrder() {\n");
      out.write("            if (cart.length === 0) {\n");
      out.write("                alert(\"Your cart is empty!\");\n");
      out.write("                return;\n");
      out.write("            }\n");
      out.write("            window.location.href = 'placeOrders.jsp';\n");
      out.write("        }\n");
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
