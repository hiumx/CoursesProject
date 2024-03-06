<%-- 
    Document   : course-detail
    Created on : Mar 6, 2024, 6:30:00 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/course-detail.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="course__detail__wrapper container">
            <c:set var="c" value="${requestScope.course}"/>
            <div class="row">
                <div class="col-lg-8 col-md-12">
                    <h1 class="course__detail__title">${c.title}</h1>
                    <p class="course__detail__description">${c.description}</p>
                    <c:if test="${(c.target!= null)}">
                        <h2 class="course__detail__sub__title">Bạn sẽ học được gì?</h2>
                        <ul class="course__detail__list__target">
                            <c:forEach items="${requestScope.listTargets}" var="t">
                                <li class="course__detail__item__target">
                                    <i class="fa-solid fa-check course__detail__check__icon"></i>
                                    <span>${t}</span>
                                </li>
                            </c:forEach>
                        </ul>

                    </c:if>
                    <c:if test="${(c.content!= null)}">
                        <h2 class="course__detail__sub__title">Nội dung khóa học</h2>
                        <div class="course__detail__list__overview__wrapper">
                            <ul class="course__detail__list__overview">
                                <li>
                                    <b>4</b> chương
                                </li>
                                <li class="course__detail__doc">
                                    •
                                </li>
                                <li>
                                    <b>12</b> bài học
                                </li>
                                <li class="course__detail__doc">
                                    •
                                </li>
                                <li>
                                    Thời lượng <b>03 giờ 26 phút</b>
                                </li>

                            </ul>
                            <p class="course__detail__show__more">Mở rộng tất cả</p>
                        </div>

                        <ul class="course__detail__list__content">
                            <c:set var="i" value="0" />
                            <c:forEach items="${requestScope.listContents}" var="t">
                                <li class="course__detail__item__content">
                                    <div>
                                        <i class="fa-solid fa-plus course__detail__plus__icon"></i>
                                        <span class="course__detail__name__session">${(i+1)}.${t}</span>
                                    </div>
                                    <div>
                                        3 bài học
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>

                    </c:if>
                </div>
                <div class="col-lg-4 col-md-12 course__detail__more__info">
                    <img class="course__detail__img" src="${c.image}" alt="course-img"/>
                    <div class="course__detail__more">
                        <h1 class="course__detail__type">Miễn phí</h1>
                        <button class="course__detail__register__btn" type="button">Đăng kí học</button>
                        <ul class="course__detail__more__list">
                            <li class="course__detail__more__item">
                                <i class="fa-solid fa-book"></i>
                                <p class="course__detail__more__item__text">Trình độ cơ bản</p>
                            </li>
                            <li class="course__detail__more__item">
                                <i class="fa-solid fa-film"></i>
                                <p class="course__detail__more__item__text">Tổng số <b>12</b> bài học</p>
                            </li>
                            <li class="course__detail__more__item">
                                <i class="fa-solid fa-clock"></i>
                                <p class="course__detail__more__item__text">Thời lượng <b>03 giờ 26 phút</b></p>
                            </li>
                            <li class="course__detail__more__item">
                                <i class="fa-solid fa-battery-full"></i>
                                <p class="course__detail__more__item__text">Học mọi lúc, mọi nơi</p>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
