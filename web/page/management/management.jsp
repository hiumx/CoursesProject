<%-- 
    Document   : management
    Created on : Mar 7, 2024, 9:18:03 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="components/header-secondary.jsp" %>
        <div>
            <c:set var="type" value="${requestScope.type}" />
            <c:choose >
                <c:when test="${type.equalsIgnoreCase('user')}">
                    <%@include file="./users/list-user.jsp" %>
                </c:when>
                <c:when test="${type.equalsIgnoreCase('blog')}">
                    <%@include file="./blogs/list-blog.jsp" %>
                </c:when>
                <c:when test="${type.equalsIgnoreCase('course')}">
                    <%@include file="./courses/list-course.jsp" %>
                </c:when>
                <c:when test="${type.equalsIgnoreCase('addUser')}">
                    <%@include file="./users/add-user.jsp" %>
                </c:when>
                <c:when test="${type.equalsIgnoreCase('updateUser')}">
                    <%@include file="./users/update-user.jsp" %>
                </c:when>
                <c:when test="${type.equalsIgnoreCase('addCourse')}">
                    <%@include file="./courses/add-course.jsp" %>
                </c:when>
                <c:when test="${type.equalsIgnoreCase('updateCourse')}">
                    <%@include file="./courses/update-course.jsp" %>
                </c:when>
                 <c:when test="${type.equalsIgnoreCase('addBlog')}">
                    <%@include file="./blogs/add-blog.jsp" %>
                </c:when>
                 <c:when test="${type.equalsIgnoreCase('updateBlog')}">
                    <%@include file="./blogs/update-blog.jsp" %>
                </c:when>
                <c:otherwise>
                    <%@include file="./users/list-user.jsp" %>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
