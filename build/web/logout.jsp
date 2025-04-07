<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
   
    session.invalidate();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout - Women's Fashion Shopping Cart</title>
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
            justify-content: center;
            align-items: center;
            text-align: center;
            padding: 20px;
        }

        
        h1 {
            font-size: 32px;
            color: #c2185b; 
            margin-bottom: 20px;
        }

        .message {
            font-size: 18px;
            color: #444;
            margin-bottom: 30px;
        }

       
        .button-container {
            display: flex;
            justify-content: center;
        }

        button {
            background-color: #c2185b; 
            color: white;
            padding: 12px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            width: 180px; 
            text-align: center;
            transition: background-color 0.3s, transform 0.2s;
            cursor: pointer;
        }

        button:hover {
            background-color: #8e0e3a; 
            transform: scale(1.05);
        }

     
        @media (max-width: 768px) {
            h1 {
                font-size: 26px;
            }

            button {
                width: 100%;
                font-size: 14px;
                padding: 10px;
            }
        }
    </style>
</head>
<body>

    <h1>You have been logged out successfully.</h1>
    <p class="message">Thank you for shopping with us. We hope to see you again soon!</p>

    <div class="button-container">
        <button onclick="window.location.href='index.html'">Go to Home</button>
    </div>

</body>

<script>
    sessionStorage.removeItem('cart'); 
</script>

</html>
