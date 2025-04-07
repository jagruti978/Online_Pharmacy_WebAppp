<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Women's Fashion Shopping Cart</title>
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
            min-height: 100vh;
        }

        .navbar {
            background-color: #c2185b;
            width: 100%;
            padding: 15px;
            display: flex;
            justify-content: center;
            gap: 20px;
        }

        .navbar a {
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            font-weight: bold;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .navbar a:hover {
            background-color: #8e0e3a;
        }

        h1 {
            margin: 20px 0;
            font-size: 28px;
            color: #c2185b;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="adminDashboard.jsp">Home</a>
        <a href="index.html">Logout</a>
        <a href="ManageCustomers.jsp">Manage Customers</a>
        <a href="ManageProducts.jsp">Manage Products</a>
        
    </div>

    <h1>Admin Dashboard</h1>
    <h1> Welcome to Admin Dashboard </h1>

</body>
</html>
