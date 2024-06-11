<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 12/03/2024
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<div align="center">
    <h1>Add Product</h1>
    <form action="/addProduct" method="post">
        Product Name: <input type="text" name="name"><br>
        Product Price: <input type="text" name="price"><br>
        <input type="submit" value="Add Product">
    </form>

</div>

</body>
</html>
