<%-- 
    Document   : add-course
    Created on : Mar 8, 2024, 10:24:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-3" style="padding-top: 64px">
            <h2>Update course</h2>
            <form action="/management/courses/update?id=${requestScope.course.id}" method="POST">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="form-group mt-3">
                            <label for="username">Title</label>
                            <input type="text" class="form-control" value="${requestScope.course.title}" name="title" required/>
                        </div>
                        <div class="form-group mt-3 mb-3">
                            <label for="">Description</label>
                            <textarea class="form-control" name="description">${requestScope.course.description}</textarea>
                        </div>
                        <div class="form-group mt-3 mb-3">
                            <label for="">Level</label>
                            <select name="level" class="form-select">
                                <option value="1" ${requestScope.course.level.equals("1") ? "selected" : null}">Trình độ cơ bản</option>
                                <option value="2" ${requestScope.course.level.equals("2") ? "selected" : null}">Trình độ trung bình</option>
                                <option value="3" ${requestScope.course.level.equals("3") ? "selected" : null}">Trình độ nâng cao</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12">

                        <div class="form-group mt-3 mb-3">
                            <label for="">Content</label>
                            <textarea class="form-control" name="content">${requestScope.course.content}</textarea>
                        </div>
                        <div class="form-group mt-3 mb-3">
                            <label for="password">Target</label>
                            <textarea class="form-control" name="target">${requestScope.course.target}</textarea>
                        </div>

                    </div>
                </div>
                <p style="color: red">${requestScope.error}</p>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
    </body>
</html>
