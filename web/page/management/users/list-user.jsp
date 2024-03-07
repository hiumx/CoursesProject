<%-- 
    Document   : list-user
    Created on : Mar 7, 2024, 9:43:12 AM
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
            <h3 class="mb-3 text-center">User Management</h3>
            <button type="button" class="btn btn-primary add-new-user-btn">Add new user</button>

            <table class="table table-hover mt-3">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Role</th>
                        <th>Image</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${requestScope.listUsers}" varStatus="loop">
                        <tr>
                            <td>${loop.index+1}</td>
                            <td>${u.username}</td>
                            <td>${u.role}</td>
                            <td>${u.image}</td>
                            <td>
                                <button class="btn btn-info">Update</button>
                                <button class="btn btn-danger">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="../../../js/list-user.js"></script>
    </body>
</html>
