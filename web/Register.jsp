<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Women's Fashion Shopping Cart</title>
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
        <h2>User Registration</h2>
        <% 
            String msg = request.getParameter("msg");
            if ("success".equals(msg)) {
                out.println("<p style='color: green;'>Registration successful! You can now log in.</p>");
            } else if ("error".equals(msg)) {
                out.println("<p style='color: red;'>Registration failed! Try again.</p>");
            }
        %>

        <form action="RegisterServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required min="1">

            <label for="state">State:</label>
            <input type="text" id="state" name="state" required>

            <input type="submit" value="Register">
        </form>
    </main>

</body>
</html>
