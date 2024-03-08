<%-- 
    Document   : list-course
    Created on : Mar 7, 2024, 9:38:12 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-top: 80px">
            <h3 class="mb-3 text-center">Blog Management</h3>
            <button type="button" class="btn btn-primary add-new-blog-btn">Add new blog</button>

            <table class="table table-hover mt-3">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Image</th>
                        <th>Like</th>
                        <th>Comment</th>
                        <th>Username</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="b" items="${requestScope.listBlogs}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${b.title}</td>
                            <td>${b.image}</td>
                            <td>${b.like}</td>
                            <td>${b.comment}</td>
                            <td>${b.user.getUsername()}</td>
                            <td>
                                <button class="btn btn-info">Update</button>
                                <button class="btn btn-danger">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="../../../js/list-blog.js"></script>
    </body>
</html>
