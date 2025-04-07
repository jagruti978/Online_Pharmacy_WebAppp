<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Customers</title>
    <style>
        body { font-family: 'Poppins', sans-serif; background-color: #ffe6f2; margin: 0; padding: 20px; text-align: center; }
        h1 { color: #d63384; margin-top: 100px; }

        .navbar { background-color: #d63384; padding: 15px; position: fixed; top: 0; left: 0; width: 100%; z-index: 1000; display: flex; justify-content: center; }
        .navbar a { color: white; padding: 10px 15px; text-decoration: none; font-weight: bold; transition: 0.3s; }
        .navbar a:hover { background-color: #ff66a3; border-radius: 5px; }

        .table-container { width: 80%; margin: auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 12px; text-align: left; }
        th { background-color: #d63384; color: white; }
        tr:nth-child(even) { background-color: #fce4ec; }
        tr:hover { background-color: #f8bbd0; }

        .view-btn {
            background-color: #d63384;
            color: white;
            padding: 8px 15px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            transition: 0.3s;
        }
        .view-btn:hover { background-color: #ff66a3; }

        .modal {
            display: none; position: fixed; z-index: 1000; left: 0; top: 0; width: 100%; height: 100%;
            background-color: rgba(0, 0, 0, 0.4);
        }
        .modal-content {
            background-color: white; margin: 10% auto; padding: 20px; width: 50%;
            border-radius: 10px; text-align: center; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
        }
        .close-btn {
            background-color: red; color: white; padding: 10px 15px; border: none; cursor: pointer;
            border-radius: 5px; transition: 0.3s;
        }
        .close-btn:hover { background-color: darkred; }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="adminDashboard.jsp">Home</a>
        <a href="index.html">Logout</a>
        <a href="ManageProducts.jsp">Manage Products</a>
    </div>

    <h1>Manage Customers</h1>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Username</th>
                    <th>Age</th>
                    <th>State</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    Connection conn = null;
                    CallableStatement cstmt = null;
                    ResultSet rs = null;
                    
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/womensfashionstyle?useSSL=false&serverTimezone=UTC", "root", "Jag19@root");
                        cstmt = conn.prepareCall("{CALL GetAllCustomers()}");
                        rs = cstmt.executeQuery();

                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String username = rs.getString("username");
                            int age = rs.getInt("age");
                            String state = rs.getString("state");
                %>
                <tr>
                    <td><%= id %></td>
                    <td><%= name %></td>
                    <td><%= username %></td>
                    <td><%= age %></td>
                    <td><%= state %></td>
                    <td><button class="view-btn" onclick="openModal('<%= name %>', '<%= username %>', '<%= age %>', '<%= state %>')">View</button></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) try { rs.close(); } catch (SQLException ex) {}
                        if (cstmt != null) try { cstmt.close(); } catch (SQLException ex) {}
                        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
                    }
                %>
            </tbody>
        </table>
    </div>

    <div id="customerModal" class="modal">
        <div class="modal-content">
            <h2>Customer Details</h2>
            <p><strong>Name:</strong> <span id="modalName"></span></p>
            <p><strong>Username:</strong> <span id="modalUsername"></span></p>
            <p><strong>Age:</strong> <span id="modalAge"></span></p>
            <p><strong>State:</strong> <span id="modalState"></span></p>
            <button class="close-btn" onclick="closeModal()">Close</button>
        </div>
    </div>

    <script>
        function openModal(name, username, age, state) {
            document.getElementById("modalName").innerText = name;
            document.getElementById("modalUsername").innerText = username;
            document.getElementById("modalAge").innerText = age;
            document.getElementById("modalState").innerText = state;
            document.getElementById("customerModal").style.display = "block";
        }

        function closeModal() {
            document.getElementById("customerModal").style.display = "none";
        }
    </script>

</body>
</html>
