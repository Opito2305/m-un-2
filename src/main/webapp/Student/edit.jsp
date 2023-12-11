<%--
  Created by IntelliJ IDEA.
  User: tuong
  Date: 12/11/2023
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" >
    <input type="number" name="id" value="${sua.id}" >
    <input type="text" name="name" value="${sua.name}">
    <input type="number" name="age" value="${sua.age}">
    <input type="text" name="sex" value="${sua.sex}">
    <input type="text" name="address" value="${sua.address}">
    <input type="number" name="score" value="${sua.score}">
    <button> Sửa lại</button>
</form>
</body>
</html>
