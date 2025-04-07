import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdParam = request.getParameter("product_id");

        if (productIdParam == null || productIdParam.isEmpty()) {
            response.sendRedirect("DeleteProduct.jsp?error=Product ID is required.");
            return;
        }

        try {
            int productId = Integer.parseInt(productIdParam);

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");
                 CallableStatement stmt = conn.prepareCall("{CALL delete_product(?)}")) {
                
                stmt.setInt(1, productId);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    response.sendRedirect("ManageProducts.jsp?message=Product deleted successfully.");
                } else {
                    response.sendRedirect("DeleteProduct.jsp?error=No product found with the given ID.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("DeleteProduct.jsp?error=Failed to delete product.");
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("DeleteProduct.jsp?error=Invalid product ID format.");
        }
    }
}
