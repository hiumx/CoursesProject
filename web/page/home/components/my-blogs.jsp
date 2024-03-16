<%-- 
    Document   : my-blogs
    Created on : Mar 14, 2024, 12:11:01 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="../../../styles/my-courses.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="mc__wrapper">
            <%@include file="../components/header.jsp" %>
            <div class="mc__content container">
                <div class="mc__title">
                    <h1>Bài viết của tôi</h1>
                    <c:if test="${requestScope.listMyBlogs.size() > 0}">
                        <p>Bạn đã viết <b>${requestScope.listMyBlogs.size()}</b> bài viết.</p>
                    </c:if>
                </div>
                <div class="mc__courses__list__wrapper">
                    <c:if test="${requestScope.listMyBlogs.size() == 0}">
                        <p class="mc__no__course">Bạn chưa viết bài viết nào.</p>
                    </c:if>
                    <c:if test="${requestScope.listMyBlogs.size() > 0}">
                        <ul class="mc__courses__list row">
                            <c:forEach items="${requestScope.listMyBlogs}" var="mb" >
                                <li class="mc__courses__item col-lg-3 col-md-4 ${mb.status.equalsIgnoreCase('Pendding') ? "mc__pending": ""}">
                                    <a href="/blogs?id=${mb.id}" class="mc__courses__item__link__img">
                                        <img class="mc__item__img" src="../../.${mb.image}" alt="course-img"/>
                                    </a>
                                    <h5>${mb.title}</h5>
                                    <div class="mc__since__status">
                                        <p>Đăng cách đây 2 tháng trước</p>
                                        <c:if test="${mb.status.equalsIgnoreCase('Pendding')}">
                                            <span class="mc__statsus">Chờ duyệt</span>
                                        </c:if>
                                    </div>

                                </li>
                            </c:forEach>    
                        </ul>
                    </c:if>
                </div>
            </div>
            <%@include file="../components/footer.jsp" %>
        </div>
    </body>
</html>
