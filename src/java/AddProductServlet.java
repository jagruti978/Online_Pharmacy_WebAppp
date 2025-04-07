import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215) 
public class AddProductServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Jag19@root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String productName = request.getParameter("product_name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String category = request.getParameter("category");

        InputStream imageInputStream = null;
        Part imagePart = request.getPart("product_image");
        if (imagePart != null) {
            imageInputStream = imagePart.getInputStream();
        }

        Connection conn = null;
        CallableStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "{CALL sp_add_product(?, ?, ?, ?, ?)}";
            stmt = conn.prepareCall(sql);
            stmt.setString(1, productName);
            stmt.setDouble(2, price);
            stmt.setInt(3, stock);
            stmt.setString(4, category);
     
            if (imageInputStream != null) {
                stmt.setBlob(5, imageInputStream);
            } else {
                stmt.setNull(5, Types.BLOB);
            }

            stmt.execute();
            
            out.println("<html><head><style>");
            out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
            out.println("body { font-family: Arial, sans-serif; background-color: #ffe6f2; color: #333; display: flex; flex-direction: column; align-items: center; min-height: 100vh; }");
            out.println(".navbar { background-color: #c2185b; width: 100%; padding: 15px; display: flex; justify-content: center; gap: 20px; }");
            out.println(".navbar a { color: white; padding: 10px 15px; text-decoration: none; font-weight: bold; border-radius: 5px; transition: background-color 0.3s; }");
            out.println(".navbar a:hover { background-color: #8e0e3a; }");
            out.println("h1 { margin: 20px 0; font-size: 28px; color: #c2185b; text-align: center; }");
            out.println(".message { background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); text-align: center; font-size: 18px; }");
            out.println("</style></head><body>");
            
            out.println("<div class='navbar'><a href='adminDashboardServlet'>Home</a> <a href='ManageProducts.jsp'>Manage Products</a></div>");
            out.println("<div class='message'><h1>Product Added Successfully</h1><p><a href='ManageProducts.jsp'>Go Back</a></p></div>");
            out.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
