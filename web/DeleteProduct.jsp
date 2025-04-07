<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Product</title>

    <style>
        body { font-family: Arial, sans-serif; background-color: #ffe6f2; margin: 0; padding: 0; display: flex; flex-direction: column; align-items: center; }

        .navbar { width: 100%; background-color: #c2185b; padding: 15px 0; display: flex; justify-content: center; position: fixed; top: 0; left: 0; z-index: 1000; }
        .navbar a { color: white; padding: 10px 20px; text-decoration: none; font-weight: bold; transition: background-color 0.3s; }
        .navbar a:hover { background-color: #8e0e3a; border-radius: 5px; }

        .form-container { margin-top: 100px; background: white; padding: 30px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); width: 400px; text-align: center; }

        label { display: block; margin: 10px 0 5px; font-weight: bold; text-align: left; }
        input[type="number"] { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; }

        .btn-submit { margin-top: 15px; background-color: #c2185b; color: white; padding: 10px 15px; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; }
        .btn-submit:hover { background-color: #8e0e3a; }

        .success-message { color: green; font-weight: bold; margin-top: 10px; }
        .error-message { color: red; font-weight: bold; margin-top: 10px; }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="AdminDashboardServlet">Home</a>
        <a href="ManageProducts.jsp">Manage Products</a>
    </div>

    <div class="form-container">
        <h1>Delete Product</h1>
        <form action="DeleteProductServlet" method="post">
            <label for="product_id">Product ID:</label>
            <input type="number" name="product_id" id="product_id" required>
            <input type="submit" value="Delete Product" class="btn-submit">
        </form>

        <%
            String message = request.getParameter("message");
            String error = request.getParameter("error");
        %>

        <% if (message != null) { %>
            <div class="success-message">
                <%= message %>
            </div>
        <% } %>

        <% if (error != null) { %>
            <div class="error-message">
                <%= error %>
            </div>
        <% } %>
    </div>

</body>
</html>
