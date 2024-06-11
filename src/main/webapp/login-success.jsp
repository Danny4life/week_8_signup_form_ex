<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 09/03/2024
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Welcome User</h1>
<p>Welcome, ${email} to your dashboard</p>

<div align="center">
    <h2>Store Management</h2>
    <a href="addProduct.jsp">Add New Product</a> <br /> <br />

    <!-- Display table of products -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                    <a href="editProduct.jsp?id=${product.id}">Edit</a>
                    <a href="deleteProduct.jsp?id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
