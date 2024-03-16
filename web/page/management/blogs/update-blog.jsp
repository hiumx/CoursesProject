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
            <h2>Update blog</h2>
            <form action="/management/blogs/update?id=${requestScope.blog.id}" method="POST">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="form-group mt-3">
                            <label for="username">Title</label>
                            <input type="text" class="form-control" value="${requestScope.blog.title}" name="title" required/>
                        </div>
                      
                    </div>
                    <div class="col-lg-6 col-md-12">

                        <div class="form-group mt-3 mb-3">
                            <label for="">Content</label>
                            <textarea class="form-control" name="content">${requestScope.blog.content}</textarea>
                        </div>
                    </div>
                </div>
                <p style="color: red">${requestScope.error}</p>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
    </body>
</html>
