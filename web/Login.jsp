<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, java.security.MessageDigest" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login - Women's Fashion Shopping Cart</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        header {
            background-color:#c2185b;
            color: white;
            text-align: center;
            padding: 1rem;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        nav ul li {
            margin: 0 15px;
        }

        nav ul li a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        nav ul li a:hover {
            color: #ffd700;
        }

        main {
            max-width: 400px;
            margin: 30px auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: bold;
            margin-top: 10px;
        }

        input {
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #c2185b;
            color: white;
            border: none;
            padding: 12px;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            transition: background 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #8e0e3a;
        }

        p {
            text-align: center;
        }

        footer {
            text-align: center;
            padding: 15px;
            background-color: #c2185b;
            color: white;
            position: absolute;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Women's Fashion Shopping Cart</h1>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="Login.jsp">Login</a></li>
                <li><a href="Register.jsp">Register</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <h2>User Login</h2>

        <% 
            String msg = request.getParameter("msg");
            if ("invalid".equals(msg)) {
                out.println("<p style='color: red;'>Invalid username or password. Try again.</p>");
            } else if ("error".equals(msg)) {
                out.println("<p style='color: red;'>An error occurred. Please try again later.</p>");
            }
        %>

        <form action="Login.jsp" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <p>Don't have an account? <a href="Register.jsp">Create New</a></p>
            <input type="submit" value="Login">
        </form>

        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                
                String hashedPassword = null;
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    byte[] hash = md.digest(password.getBytes("UTF-8"));
                    StringBuilder hexString = new StringBuilder();
                    for (byte b : hash) {
                        hexString.append(String.format("%02x", b));
                    }
                    hashedPassword = hexString.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("Login.jsp?msg=error");
                }

                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");

                    String sql = "SELECT * FROM customers WHERE username = ? AND password = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, username);
                    pstmt.setString(2, hashedPassword); 
                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        session.setAttribute("username", username);
                        response.sendRedirect("UserDashboard.jsp"); 
                    } else {
                        response.sendRedirect("Login.jsp?msg=invalid");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("Login.jsp?msg=error");
                } finally {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                }
            }
        %>
    </main>
</body>
</html>
