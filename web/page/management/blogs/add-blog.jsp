<%-- 
    Document   : add-course
    Created on : Mar 8, 2024, 10:24:37 AM
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
        <div class="container mt-3" style="padding-top: 64px">
            <h2>Create new blog</h2>
            <form action="/management/blogs/add-blog" method="POST">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="form-group mt-3">
                            <label for="username">Title</label>
                            <input type="text" class="form-control" value="${requestScope.title}" name="title" required/>
                        </div>
                        <div class="form-group mt-3 mb-3">
                            <label class="mb-1">Username</label>
                            <select name="user-select" class="form-select">
                                <c:forEach items="${requestScope.listUsers}" var="u">
                                    <option value="${u.id}">${u.username}</option>
                                </c:forEach> 
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12">

                        <div class="form-group mt-3 mb-3">
                            <label for="">Content</label>
                            <textarea class="form-control" name="content">${requestScope.content}</textarea>
                        </div>
                        <div class="form-group mt-3 mb-3">
                            <label class="mb-1">Image</label>
                            <input 
                                type="file" 
                                class="form-control" 
                                id="upload-image-course" 
                                value="${requestScope.image}" 
                                name="image" 
                                />
                        </div>
                    </div>
                </div>
                <p style="color: red">${requestScope.error}</p>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
    </body>
</html>
