import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = hashPassword(request.getParameter("password")); 
        String age = request.getParameter("age");
        String state = request.getParameter("state");

        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");

            String sql = "{ CALL registercustomer(?, ?, ?, ?, ?) }";
            cstmt = conn.prepareCall(sql);
            cstmt.setString(1, name);
            cstmt.setString(2, username);
            cstmt.setString(3, password);
            cstmt.setInt(4, Integer.parseInt(age));
            cstmt.setString(5, state);

            int rows = cstmt.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("Register.jsp?msg=success");
            } else {
                response.sendRedirect("Register.jsp?msg=error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Register.jsp?msg=error");
        } finally {
            try { if (cstmt != null) cstmt.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
