<%-- 
    Document   : my-courses
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
                    <h1>Khóa học của tôi</h1>
                    <p>Bạn đã hoàn thành <b>2/9</b> khóa học của bạn.</p>
                </div>
                <div class="mc__courses__list__wrapper">
                    <ul class="mc__courses__list row">
                        <c:forEach items="${sessionScope.listMyCourses}" var="mc" >
                            <li class="mc__courses__item col-lg-3 col-md-4">
                            <a href="/courses?id=${mc.id}" class="mc__courses__item__link__img">
                                <img class="mc__item__img" src="../../.${mc.image}" alt="course-img"/>
                            </a>
                            <h5>${mc.title}</h5>
                            <p>Học cách đây 2 tháng trước</p>
                            <div class="mc__item__learn__completed"></div>
                        </li>
                        </c:forEach>    
                    </ul>
                </div>
            </div>
            <%@include file="../components/footer.jsp" %>
        </div>
    </body>
</html>
