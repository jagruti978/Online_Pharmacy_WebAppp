<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart - Online Pharmacy Management</title>
    <style>
    
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Arial', sans-serif;
    background-color: #fce4ec; 
    color: #333;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    padding: 20px;
}


.navbar {
    width: 100%;
    background-color: #c2185b; 
    padding: 15px 0;
    display: flex;
    justify-content: center;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1000;
}

.navbar a {
    color: white;
    padding: 14px 20px;
    text-decoration: none;
    font-size: 16px;
    font-weight: bold;
    border-radius: 5px;
    margin: 0 10px;
    transition: background-color 0.3s, transform 0.2s;
}

.navbar a:hover {
    background-color: #8e0e3a; 
    transform: scale(1.1);
}

h1 {
    font-size: 32px;
    color: #c2185b;
    margin-top: 100px;
    text-align: center;
}

.order-summary {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-top: 30px;
    max-width: 1000px;
    margin-left: auto;
    margin-right: auto;
}

.order-summary h2 {
    font-size: 24px;
    margin-bottom: 20px;
    color: #c2185b;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
}

th {
    background-color: #c2185b;
    color: white;
}

/* Button Styling */
button {
    background-color: #c2185b;
    color: white;
    padding: 12px 20px;
    font-size: 16px;
    border-radius: 5px;
    transition: background-color 0.3s, transform 0.2s;
    width: 100%;
    margin-top: 20px;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #8e0e3a;
    transform: scale(1.05);
}


td button {
    background-color: #e74c3c;
    color: white;
    border: none;
    padding: 8px 12px;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

td button:hover {
    background-color: #c0392b;
}


@media (max-width: 768px) {
    .order-summary {
        padding: 15px;
    }

    table th, table td {
        font-size: 14px;
    }

    h1 {
        font-size: 24px;
    }
}

    </style>
</head>
<body>
    <div class="navbar">
        <a href="UserDashboard.jsp">Home</a>
        <a href="logout.jsp">Logout</a>
    </div>

    <h1>Your Cart</h1>
    <button onclick="window.location.href='UserDashboard.jsp'">Continue Shopping</button>

    <div class="order-summary">
        <h2>Items in Your Cart</h2>
        <table id="cartItems">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
        <p>Total Amount: <span id="totalAmount">0.00</span></p>
        <button onclick="proceedToPlaceOrder()">Proceed to Place Order</button>
    </div>

    <script>

        if (window.location.pathname === "/logout.jsp") {
            sessionStorage.removeItem('cart');
        }

        const cart = JSON.parse(sessionStorage.getItem('cart')) || [];
        const cartItemsList = document.getElementById('cartItems').getElementsByTagName('tbody')[0];
        let totalAmount = 0;

        cart.forEach((item, index) => {
            const row = cartItemsList.insertRow();
            const cell1 = row.insertCell(0);
            const cell2 = row.insertCell(1);
            const cell3 = row.insertCell(2);
            const cell4 = row.insertCell(3);
            const cell5 = row.insertCell(4);

            cell1.textContent = item.name;
            cell2.textContent = item.price.toFixed(2); 
            const quantityInput = document.createElement('input');
            quantityInput.type = 'number';
            quantityInput.value = item.quantity || 1; 
            quantityInput.min = 1;
            quantityInput.oninput = function() {
                const quantity = parseInt(quantityInput.value);
                if (isNaN(quantity) || quantity <= 0) {
                    alert("Quantity must be a valid number.");
                    return;
                }
                item.quantity = quantity; 
                sessionStorage.setItem('cart', JSON.stringify(cart)); 
                const total = item.price * item.quantity;
                cell4.textContent = total.toFixed(2); 
                calculateTotal();
            };
            cell3.appendChild(quantityInput);
            const total = item.price * (item.quantity || 1);
            cell4.textContent = total.toFixed(2); 
            totalAmount += total;

            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            deleteButton.onclick = function() {
                cart.splice(index, 1); 
                sessionStorage.setItem('cart', JSON.stringify(cart)); 
                location.reload(); 
            };
            cell5.appendChild(deleteButton);
        });

        document.getElementById('totalAmount').textContent = totalAmount.toFixed(2); 

        function calculateTotal() {
            totalAmount = 0;
            const rows = cartItemsList.getElementsByTagName('tr');
            for (let row of rows) {
                const totalCell = row.cells[3].textContent;
                totalAmount += parseFloat(totalCell);
            }
            document.getElementById('totalAmount').textContent = totalAmount.toFixed(2); 
        }

        function proceedToPlaceOrder() {
            if (cart.length === 0) {
                alert("Your cart is empty! Please add items to the cart.");
                return;
            }
            window.location.href = 'placeOrders.jsp'; 
        }
    </script>
</body>
</html>
