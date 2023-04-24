<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.posts.model.Post" %>
<%@ page import="com.example.posts.Dao.PostJdbcDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poste List Edit Delete</title>
</head>
<body>
<h1>Category List</h1>



    <table border="1" width="90%">
    <tr><th>id</th><th>Name Category</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${category}" var="category">
    <tr><td>${category.getId()}</td><td>${category.getNameCategory()}</td><td><a href="edit-category?id=${category.getId()}">Edit</a></td><td><a href="delete-category?id=${category.getId()}">Delete</a></td></tr>
    </c:forEach>
    </table>

</body>
</html>
