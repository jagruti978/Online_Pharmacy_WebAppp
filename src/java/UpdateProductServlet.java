import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UpdateProductServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class UpdateProductServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Jag19@root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int productId = Integer.parseInt(request.getParameter("product_id"));
        String productName = request.getParameter("product_name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String category = request.getParameter("category");

        Part productImagePart = request.getPart("product_image");
        InputStream productImageStream = (productImagePart != null && productImagePart.getSize() > 0) ? productImagePart.getInputStream() : null;

        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        String message = "Error updating product";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Function Call
            String sql = "SELECT update_product(?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, productId);
            stmt.setString(2, productName);
            stmt.setDouble(3, price);
            stmt.setInt(4, stock);
            stmt.setString(5, category);

            if (productImageStream != null) {
                stmt.setBlob(6, productImageStream);
            } else {
                stmt.setNull(6, Types.BLOB);
            }

            rs = stmt.executeQuery();
            if (rs.next()) {
                message = rs.getString(1);
            }

            response.sendRedirect("ManageProducts.jsp?message=" + message);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("ManageProducts.jsp?error=Database Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ManageProducts.jsp?error=Error: " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) { ex.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException ex) { ex.printStackTrace(); }
        }
    }
}
