<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
    <style>
       * { margin: 0; padding: 0; box-sizing: border-box; } 
body { font-family: 'Arial', sans-serif; background-color: #ffe6f2; color: #333; display: flex; flex-direction: column; align-items: center; min-height: 100vh; } 
.navbar { background-color: #c2185b; width: 100%; padding: 15px; display: flex; justify-content: center; gap: 20px; position: fixed; top: 0; left: 0; z-index: 1000; } 
.navbar a { color: white; padding: 10px 15px; text-decoration: none; font-weight: bold; border-radius: 5px; transition: background-color 0.3s; } 
.navbar a:hover { background-color: #8e0e3a; } 
h1 { margin: 20px 0; font-size: 28px; color: #c2185b; text-align: center; } 
.form-container { margin-top: 100px; background: white; padding: 30px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); width: 400px; text-align: center; } 
label { display: block; margin: 10px 0 5px; font-weight: bold; text-align: left; } 
input, select { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; } 
.btn-submit { margin-top: 15px; background-color: #c2185b; color: white; padding: 10px 15px; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; transition: background-color 0.3s, transform 0.2s; } 
.btn-submit:hover { background-color: #8e0e3a; transform: scale(1.05); }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="adminDashboard.jsp">Home</a>
        <a href="ManageProducts.jsp">Manage Products</a>
    </div>

    <div class="form-container">
        <h1>Update Product</h1>
        <form action="UpdateProductServlet" method="post" enctype="multipart/form-data">
            <label for="product_id">Product ID:</label>
            <input type="number" name="product_id" value="<%= request.getAttribute("product_id") != null ? request.getAttribute("product_id") : "" %>" required >

            <label for="product_name">Product Name:</label>
            <input type="text" name="product_name" value="<%= request.getAttribute("product_name") != null ? request.getAttribute("product_name") : "" %>" required>

            <label for="price">Price:</label>
            <input type="number" step="0.01" name="price" value="<%= request.getAttribute("price") != null ? request.getAttribute("price") : "" %>" required>

            <label for="stock">Stock:</label>
            <input type="number" name="stock" value="<%= request.getAttribute("stock") != null ? request.getAttribute("stock") : "" %>" required>

            <label for="category">Category:</label>
            <input type="text" name="category" value="<%= request.getAttribute("category") != null ? request.getAttribute("category") : "" %>" required>

            <label for="product_image">Product Image (optional):</label>
            <input type="file" name="product_image" accept="image/*">

            <% if(request.getAttribute("image_url") != null) { %>
                <div class="existing-image">
                    <p>Current Image:</p>
                    <img src="<%= request.getAttribute("image_url") %>" alt="Product Image" width="150">
                </div>
            <% } %>

            <input type="submit" value="Update Product" class="btn-submit">
        </form>
    </div>

</body>
</html>
