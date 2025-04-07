<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Products - Women's Fashion</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #ffe6f2; text-align: center; margin: 0; padding: 20px; }
        h1 { font-size: 28px; color: #d63384; margin-top: 100px; }
        .navbar { width: 100%; background-color: #d63384; padding: 15px 0; display: flex; justify-content: center; position: fixed; top: 0; left: 0; z-index: 1000; }
        .navbar a { color: white; padding: 10px 15px; text-decoration: none; font-weight: bold; border-radius: 5px; transition: background-color 0.3s; }
        .navbar a:hover { background-color: #ff80b3; }
        .table-container { width: 80%; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 12px; text-align: left; }
        th { background-color: #d63384; color: white; font-weight: bold; }
        tr:nth-child(even) { background-color: #ffe6f2; }
        tr:hover { background-color: #ffb3d9; transition: 0.3s; }
        img { width: 80px; height: 80px; object-fit: cover; border-radius: 8px; }
        .btn { padding: 8px 12px; border-radius: 5px; text-decoration: none; font-weight: bold; cursor: pointer; }
        .btn-update { background-color: #007bff; color: white; }
        .btn-delete { background-color: #dc3545; color: white; }
        .btn-view { background-color: #17a2b8; color: white; }
        .btn:hover { opacity: 0.8; transition: 0.3s; }
        .modal { 
            display: none; 
            position: fixed; 
            top: 50%; 
            left: 50%; 
            transform: translate(-50%, -50%); 
            background: white; 
            padding: 20px; 
            border-radius: 10px; 
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.3); 
            width: 80%;
            max-width: 700px; 
            text-align: left; 
        }
        .modal img { width: 100%; max-height: 800px; object-fit: contain; border-radius: 10px; }
        .close-btn { background: #dc3545; color: white; padding: 10px; border: none; cursor: pointer; border-radius: 5px; float: right; }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="adminDashboard.jsp">Home</a>
        <a href="AddProduct.jsp">Add Product</a>
        <a href="UpdateProduct.jsp">Update Product</a>
        <a href="DeleteProduct.jsp">Delete Product</a>
    </div>
    <h1>Manage Products</h1>
    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Category</th>
                    <th>Image</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
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
                %>
                <tr>
                    <td><%= productName %></td>
                    <td>Rs. <%= price %></td>
                    <td><%= stock %></td>
                    <td><%= category %></td>
                    <td>
                        <% if (!base64Image.isEmpty()) { %>
                            <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Product Image">
                        <% } else { %>
                            No Image
                        <% } %>
                    </td>
                    <td>
                        <a href="#" class="btn btn-view" onclick="openModal('<%= productName %>', '<%= price %>', '<%= stock %>', '<%= category %>', '<%= base64Image %>')">View</a> |
                        <a href="UpdateProduct.jsp?productId=<%= productId %>" class="btn btn-update">Update</a> |
                        <a href="DeleteProduct.jsp?productId=<%= productId %>" class="btn btn-delete" onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) try { rs.close(); } catch (SQLException ex) {}
                        if (stmt != null) try { stmt.close(); } catch (SQLException ex) {}
                        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
                    }
                %>
            </tbody>
        </table>
    </div>
    <div id="productModal" class="modal">
        <button class="close-btn" onclick="closeModal()">Close</button>
        <h2 id="modalTitle"></h2>
        <p><strong>Price:</strong> Rs.<span id="modalPrice"></span></p>
        <p><strong>Stock:</strong> <span id="modalStock"></span></p>
        <p><strong>Category:</strong> <span id="modalCategory"></span></p>
        <img id="modalImage" src="" alt="Product Image">
    </div>
    <script>
        function openModal(name, price, stock, category, image) {
            document.getElementById('modalTitle').innerText = name;
            document.getElementById('modalPrice').innerText = price;
            document.getElementById('modalStock').innerText = stock;
            document.getElementById('modalCategory').innerText = category;
            document.getElementById('modalImage').src = image ? "data:image/jpeg;base64," + image : "";
            document.getElementById('productModal').style.display = 'block';
        }
        function closeModal() { document.getElementById('productModal').style.display = 'none'; }
    </script>
</body>
</html>
