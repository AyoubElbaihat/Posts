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
<h1>Users List</h1>



    <table border="1" width="90%">
    <tr><th>id</th><th>title</th><th>author</th><th>content</th><th>pictureUrl</th><th>createdAt</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${list}" var="post">
    <tr><td>${post.getId()}</td><td>${post.getTitle()}</td><td>${post.getAuthor()}</td><td>${post.getContent()}</td><td>${post.getPictureUrl()}</td><td>${post.getCreatedAt()}</td><td><a href="edit?id=${post.getId()}">Edit</a></td><td><a href="delete?id=${post.getId()}">Delete</a></td></tr>
    </c:forEach>
    </table>

</body>
</html>
