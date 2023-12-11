<%--
  Created by IntelliJ IDEA.
  User: tuong
  Date: 12/11/2023
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: red">Danh sách</h1>
<a href="/students?action=create">Tạo học sinh mới</a>
<c:forEach items = '${danhSach}' var="hocSinh">
    <h3>ID: ${hocSinh.id}||Name: ${hocSinh.name}|| Tuổi: ${hocSinh.age}|| Giới Tính: ${hocSinh.sex}|| Địa chỉ: ${hocSinh.address}|| Điểm: ${hocSinh.score}</h3><a href="/students?action=edit&id=${hocSinh.id}">Sửa</a> <a href="/students?action=delete&id=${hocSinh.id}">Xóa</a>
</c:forEach>
</body>
</html>
