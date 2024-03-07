<%-- 
    Document   : list-course
    Created on : Mar 7, 2024, 9:38:12 AM
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
        <div class="container" style="margin-top: 80px">
            <h3 class="mb-3 text-center">Course Management</h3>
            <button type="button" class="btn btn-primary add-new-user-btn">Add new course</button>

            <table class="table table-hover mt-3">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Level</th>
                        <th>Joined number</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="co" items="${requestScope.listCourses}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${co.title}</td>
                            <td>${co.description}</td>
                            <td>${co.level}</td>
                            <td>${co.joinedNumber}</td>
                            <td>
                                <button class="btn btn-info">Update</button>
                                <button class="btn btn-danger mt-3">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
