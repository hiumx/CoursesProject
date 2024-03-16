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

            <c:set var="status" value="${requestScope.status}" />
            <c:set var="listBlogs" value="${requestScope.listBlogs}" />

            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <button type="button" class="btn btn-primary all-blog-btn">All blogs</button>
                    <button type="button" class="btn btn-primary pending-blog-btn">Pending blogs</button>
                    <button type="button" class="btn btn-primary confirmed-blog-btn">Confirmed blogs</button>
                </div>

                <button type="button" class="btn btn-primary add-new-blog-btn">Add new blog</button>
            </div>

            <p style="color: red">${requestScope.msg}</p>
            <c:if test="${listBlogs.isEmpty()}">
                <p style="text-align: center; margin-top: 20px">There are no blogs here.</p>
            </c:if>
            <c:if test="${!listBlogs.isEmpty()}">
                <table class="table table-hover mt-3">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Title</th>
                            <th>Username</th>
                            <th>Status</th>
                                <c:if test="${!status.equals('all')}">
                                <th>Action</th>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="b" items="${listBlogs}" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${b.title}</td>
                                <td>${b.user.username}</td>
                                <td>${b.status}</td>
                                <c:choose> 
                                    <c:when test="${status == null}">
                                        <td>
                                            <a href="management/blogs/update?id=${b.id}" class="btn btn-info">Update</a>
                                            <a href="management/blogs/delete?id=${b.id}" class="btn btn-danger">Delete</a>
                                        </td>
                                    </c:when>
                                    <c:when test="${status.equals('all')}">
                                        <td>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>
                                            <a href="/management/blogs/confirm?id=${b.id}" class="btn btn-info">Confirm</a>
                                            <a href="#" class="btn btn-danger">Cancel</a>
                                        </td>
                                    </c:otherwise>
                                </c:choose>

                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </c:if>

        </div>
        <script src="../../../js/list-blog.js"></script>
    </body>
</html>
