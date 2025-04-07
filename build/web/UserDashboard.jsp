<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.Base64" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - Women's Fashion Shopping Cart</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 0; }
        .navbar { background-color: #c2185b; padding: 15px; text-align: center; }
        .navbar a { color: white; text-decoration: none; margin: 0 15px; font-weight: bold; }
        .navbar a:hover { color: #ffd700; }
        h1 { text-align: center; color: #333; margin-top: 20px; }
        .category { text-align: center; margin-bottom: 20px; }
        .category a { text-decoration: none; font-weight: bold; margin: 0 15px; color: #c2185b; }
        .category a:hover { text-decoration: underline; }
        .products { display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 20px; padding: 20px; }
        .product { background: white; padding: 15px; border-radius: 10px; text-align: center; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }
        .product img { width: 100%; height: 150px; object-fit: contain; margin-bottom: 10px; }
        .product h3 { font-size: 18px; margin-bottom: 10px; }
        .product p { font-size: 16px; color: #555; }
        .product button { background-color: #c2185b; color: white; border: none; padding: 10px; border-radius: 5px; cursor: pointer; width: 100%; }
        .product button:hover { background-color: #8e0e3a; }
        footer { background-color: #c2185b; color: white; text-align: center; padding: 15px; position: fixed; bottom: 0; width: 100%; }
    </style>
     <script>
        function addToCart(productName, productPrice) {
            let cart = JSON.parse(sessionStorage.getItem('cart')) || [];
            cart.push({ name: productName, price: productPrice });
            sessionStorage.setItem('cart', JSON.stringify(cart));
            window.location.href = 'cart.jsp';
        }
    </script>
</head>
<body>
    <div class="navbar">
        <a href="UserDashboard.jsp">Home</a>
        <a href="cart.jsp">Cart</a>
        <a href="logout.jsp">Logout</a>
    </div>

    <h1>Welcome to Your Fashion Dashboard</h1>

    <div class="category">
        <h2>Categories</h2>
        <a href="UserDashboard.jsp">All</a> |
        <a href="UserDashboard.jsp?category=Clothes">Clothes</a> |
        <a href="UserDashboard.jsp?category=Accessories">Accessories</a> |
        <a href="UserDashboard.jsp?category=Footwear">Footwear</a>
    </div>

    <div class="products">
        <% 
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
        %>
        <div class="product">
            <img src="<%= imageBase64 %>" alt="<%= productName %>">
            <h3><%= productName %></h3>
            <p>Price: Rs <%= price %></p>
            <p>Stock: <%= stock %></p>
            <form action="cart.jsp" method="post">
                <input type="hidden" name="product_id" value="<%= productId %>">
                 <button onclick="addToCart('<%= productName %>', <%= price %>)">Add to Cart</button>
            </form>
        </div>
        <% 
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
                try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
                try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
            }
        %>
    </div>

    <footer>
        &copy; 2025 Women's Fashion Shopping Cart
    </footer>
</body>
</html>
