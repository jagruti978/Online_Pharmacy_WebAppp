<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*, java.io.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Place Order - Women's Fashion</title>
    <style>
       body { font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 0; }
        .navbar { background-color: #c2185b; padding: 15px; text-align: center; }
        .navbar a { color: white; text-decoration: none; margin: 0 15px; font-weight: bold; }
        .navbar a:hover { color: #ffd700; }
        h1 { text-align: center; color: #333; margin-top: 20px; }
        .form-container, .order-summary { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 800px; margin: auto; margin-top: 30px; }
        label { display: block; margin-top: 10px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; margin-top: 5px; border-radius: 5px; border: 1px solid #ccc; }
        button { background-color: #c2185b; color: white; padding: 10px; font-size: 16px; border-radius: 5px; width: 100%; margin-top: 20px; cursor: pointer; border: none; }
        button:hover { background-color: #8e0e3a; }
        table { width: 100%; border-collapse: collapse; display: none; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #c2185b; color: white; }
        #error-message { color: red; font-weight: bold; display: none; margin-top: 20px; text-align: center; }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="UserDashboard.jsp">Home</a>
        <a href="logout.jsp">Logout</a>
    </div>

    <h1>Place Your Order</h1>

    <div class="form-container">
        <h2>Delivery Information</h2>
        <form id="orderForm" method="post" action="PlaceOrderServlet">
            <label for="customerId">Customer ID:</label>
            <input type="text" id="customerId" name="customerId" value="<%= session.getAttribute("customerId") %>" >

            <label for="customerName">Name:</label>
            <input type="text" id="customerName" name="customerName" required>

            <label for="deliveryAddress">Delivery Address:</label>
            <input type="text" id="deliveryAddress" name="deliveryAddress" required>

            <label for="orderDate">Order Date:</label>
            <input type="date" id="orderDate" name="orderDate" required>

            <label for="paymentMethod">Select Payment Method:</label>
            <select id="paymentMethod" name="paymentMethod" required>
                <option value="" disabled selected>Select Payment Method</option>
                <option value="cod">Cash on Delivery</option>
                <option value="card">Credit Card</option>
            </select>

            <p>Total Amount: <span id="totalAmountDisplay">0.00</span></p>
            <input type="hidden" id="totalAmount" name="totalAmount">

            <button type="button" id="proceedBtn">Proceed</button>
        </form>
        <p id="error-message">There is no order to place. Please add items to your cart first.</p>
    </div>

    <div class="order-summary">
        <h2>Order Summary</h2>
        <table id="orderItems">
            <thead>
                <tr><th>Product</th><th>Price</th><th>Quantity</th><th>Total</th></tr>
            </thead>
            <tbody></tbody>
        </table>
        <button id="confirmOrderBtn">Confirm Order</button>
    </div>

    <script>
        const cart = JSON.parse(sessionStorage.getItem('cart')) || [];
        let totalAmount = 0;
        const orderItemsList = document.getElementById('orderItems').getElementsByTagName('tbody')[0];

        if (cart.length > 0) {
            cart.forEach(item => {
                const row = orderItemsList.insertRow();
                row.insertCell(0).textContent = item.name;
                row.insertCell(1).textContent = item.price.toFixed(2);
                row.insertCell(2).textContent = item.quantity;
                row.insertCell(3).textContent = (item.price * item.quantity).toFixed(2);
                totalAmount += item.price * item.quantity;
            });
            document.getElementById('totalAmountDisplay').textContent = totalAmount.toFixed(2);
            document.getElementById('totalAmount').value = totalAmount.toFixed(2);
        } else {
            document.getElementById('error-message').style.display = 'block';
        }

        document.getElementById("proceedBtn").addEventListener("click", function() {
            document.querySelector(".order-summary").style.display = "block";
            document.getElementById("orderItems").style.display = "table";
        });

        document.getElementById("confirmOrderBtn").addEventListener("click", function() {
            document.getElementById("orderForm").submit();
        });
    </script>

</body>
</html>
