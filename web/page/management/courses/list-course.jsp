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
            <h3 class="mb-3 text-center">Course Management</h3>
            <button type="button" class="btn btn-primary add-new-course-btn">Add new course</button>

            <table class="table table-hover mt-3">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Level</th>
                        <th>Joined number</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="u" items="${requestScope.listCourses}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${u.title}</td>
                            <td>${u.level}</td>
                            <td>${u.joinedNumber}</td>
                            <td>
                                <a href="/management/courses/update?id=${u.id}" class="btn btn-info">Update</a>
                                <a href="/management/courses/delete?id=${u.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="../../../js/list-course.js"></script>
    </body>
</html>
