import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        String deliveryAddress = request.getParameter("deliveryAddress");
        String orderDate = request.getParameter("orderDate");
        String paymentMethod = request.getParameter("paymentMethod");
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");
             CallableStatement cs = conn.prepareCall("{call insertorder(?, ?, ?, ?, ?, ?)}")) {
             
            cs.setInt(1, customerId);
            cs.setString(2, customerName);
            cs.setString(3, deliveryAddress);
            cs.setDate(4, Date.valueOf(orderDate));
            cs.setString(5, paymentMethod);
            cs.setDouble(6, totalAmount);
            cs.execute();
            
            response.sendRedirect("Login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error: " + e.getMessage());
        }
    }
}
