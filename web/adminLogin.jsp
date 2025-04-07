<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String adminUsername = request.getParameter("adminUsername");
    String adminPassword = request.getParameter("adminPassword");

    String validUsername = "admin";
    String validPassword = "fashion@123"; 

    String errorMessage = null;

    if (adminUsername != null && adminPassword != null) {
        if (adminUsername.equals(validUsername) && adminPassword.equals(validPassword)) {
            response.sendRedirect("adminDashboard.jsp");
            return; 
        } else {
            errorMessage = "Invalid username or password. Please try again.";
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login - Women's Fashion Shopping Cart</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #ffe6f2; 
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; 
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }

        h1 {
            font-size: 24px;
            color: #c2185b;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
            text-align: left;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .error-message {
            color: red;
            font-weight: bold;
            margin-top: 10px;
        }

        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        button {
            background-color: #c2185b;
            color: white;
            padding: 10px 20px;
            font-size: 14px;
            border-radius: 5px;
            width: 150px;
            transition: background-color 0.3s, transform 0.2s;
            cursor: pointer;
            border: none;
        }

        button:hover {
            background-color: #8e0e3a;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="login-container">
        <h1>Admin Login</h1>

        <% if (errorMessage != null) { %>
            <p class="error-message"><%= errorMessage %></p>
        <% } %>

        <form action="adminLogin.jsp" method="post">
            <label for="adminUsername">Username:</label>
            <input type="text" id="adminUsername" name="adminUsername" required>

            <label for="adminPassword">Password:</label>
            <input type="password" id="adminPassword" name="adminPassword" required>

            <div class="button-container">
                <button type="submit">Login</button>
            </div>
        </form>
    </div>

</body>
</html>
