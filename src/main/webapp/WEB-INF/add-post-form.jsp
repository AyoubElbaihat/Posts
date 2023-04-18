<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The Blog | Add Post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<header class="mb-4">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid">
            <img src="https://img.icons8.com/plasticine/64/null/blog.png"/>
            <a class="navbar-brand" href="#">The Blog</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="posts">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="add-post">Add post</a>
                    </li>
                    <c:if test="${empty sessionScope.username}">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="login">Log in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="signup">Sign up</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.username}">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="logout">Login out</a>
                        </li>
                    </c:if>
                </ul>
                <c:if test="${not empty sessionScope.username}">
                    <div class="alert alert-light m-0" role="alert">Hi! ${sessionScope.username.getEmail()}</div>
                </c:if>
            </div>
        </div>
    </nav>
</header>

<div class="container">
    <h1>Add post</h1>

    <form method="post" action="add-post">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="title" placeholder="Title...">
        </div>

        <div class="input-group mb-3">
            <input type="text" class="form-control" name="author" placeholder="Author...">
        </div>

        <div class="input-group mb-3">
            <textarea class="form-control" name="content" placeholder="Your content.."></textarea>
        </div>
        <div class="input-group">
            <button type="submit" class="btn btn-outline-dark">Submit</button>
        </div>
    </form>


</div>


</body>
</html>
