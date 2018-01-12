<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <title>Music Store - HomePage</title>
</head>
<body>
<div class="container-fluid">
    <div class="col-sm-1">
        <nav class="navbar navbar-light bg-faded">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/album/management/all">Admin</a>
            <ul class="nav navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/album/management/all">Album</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Genre</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Artist</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Account</a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="col-sm-11">
        <a href="${pageContext.request.contextPath}/album/management/add" class="btn btn-primary" style="margin-bottom: 10px;margin-top: 20px;">Add New Album</a>
        <table class="table table-responsive table-striped">
            <thead>
            <tr>
                <th>Image</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Artist</th>
                <th>Price</th>
                <th>Created At</th>
                <th>Modified At</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listModel}" var="model">
                <tr>
                    <td><img src="${pageContext.request.contextPath}/${model.getImagePath()}" width="100px" height="75px" alt="" /></td>
                    <td>${model.getTitle()}</td>
                    <td>${model.getGenre().getName()}</td>
                    <td>${model.getArtist().getName()}</td>
                    <td>${model.getPrice()}</td>
                    <td>${model.getCreatedAt()}</td>
                    <td>${model.getModifiedAt()}</td>
                    <td><a href="${pageContext.request.contextPath}/album/management/edit/${model.getAlbumId()}" class="btn btn-primary glyphicon glyphicon-edit"></a>
                        <a href="${pageContext.request.contextPath}/album/management/delete/${model.getAlbumId()}" onclick="return confirm('Are you sure to delete this album?')" class="btn btn-danger glyphicon glyphicon-trash"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
