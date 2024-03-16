<%-- 
    Document   : header
    Created on : 1 Mar 2024, 20:36:31
    Author     : hieumaixuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="../../../styles/header.css"/>
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <header class="header__wrapper">
            <%@include file="navigation.jsp" %>
            <div class="header__content__wrapper">
                <div class="header__nav__logo">
                    <i class="fa-solid fa-bars header__bars__icon"></i>
                    <a href="/home" class="header__logo__wrapper">
                        <img class="header__logo" src="../../../images/logo-1.png" alt="logo-img"/>
                    </a>
                </div>
                <div class="header__search__wrapper">
                    <i class="fa-solid fa-magnifying-glass header__search__icon"></i>
                    <input id="header__search" class="header__search" type="text" name="search-course" onkeyup="search()" placeholder="Tìm kiếm khóa học..." />
                    <div class="header__search__result">
                        <div class="header__search__result__keyword">
                            <i class="fa-solid fa-magnifying-glass search__keyword__icon"></i>
                            <p class="header__search__keyword"></p>
                        </div>
                        <div>
                            <div class="header__search__result__title">
                                <h5>Khóa học</h5>
                                <a class="header__search__result__view__more" href="#">Xem thêm</a>
                            </div>
                            <ul class="header__search__result__list" id="search-result-courses">
                            </ul>
                        </div>
                        <div>
                            <div class="header__search__result__title">
                                <h5>Bài viết</h5>
                                <a class="header__search__result__view__more" href="#">Xem thêm</a>
                            </div>
                            <ul class="header__search__result__list" id="search-result-blogs">
                            </ul>
                        </div>

                    </div>
                </div>

                <c:if test="${sessionScope.user == null}">
                    <div class="header__auth">
                        <a class="header__auth__login" href="/login">Đăng nhập</a>
                        <a class="header__auth__register" href="/register">Đăng kí</a>
                    </div>
                </c:if>


                <c:if test="${sessionScope.user != null}">
                    <div class="header__profile">
                        <c:if test="${sessionScope.user.role.equals('R1')}">
                            <a href="/management" class="header__management__link">MANAGEMENT</a>

                        </c:if>
                        <div class="header__profile__courses__wrapper">
                            <p class="header__profile__courses">Khóa học của tôi</p>
                            <div class="header__profile__courses__detail">
                                <div class="header__profile__top">
                                    <h3>Khóa học của tôi</h3>
                                    <a href="/my-courses" class="header__profile__top__show__all">Xem tất cả</a>
                                </div>
                                <c:if test="${sessionScope.listMyCourses.size() == 0}">
                                    <p class="header__profile__no__course">Bạn chưa tham gia khóa học nào.</p>
                                </c:if>
                                <c:if test="${sessionScope.listMyCourses.size() > 0}">
                                    <ul class="header__courses__list">
                                        <c:forEach items="${sessionScope.listMyCourses}" var="mc">
                                            <li class="header__courses__item">
                                                <a href="/courses?id=${mc.id}" class="header__courses__item__link__img">
                                                    <img class="header__courses__item__img" src="../../.${mc.image}" alt="course-img"/>
                                                </a>
                                                <div class="header__courses__item__detail">
                                                    <a href="/courses?id=${mc.id}" class="header__courses__item__title">${mc.title}</a>
                                                    <p class="header__courses__since__learn">Học cách đây 2 tháng trước</p>
                                                    <div class="header__courses__percent__complete"></div>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                            </div>
                        </div>

                        <div>
                            <i class="fa-solid fa-bell header__profile__bell__icon"></i>
                        </div>
                        <div class="header__profile__wrapper">
                            <img src="../../.${sessionScope.user.image}" class="header__profile__icon" alt="user-img"/> 
                            <div class="header__profile__detail">
                                <div class="header__profile__ava__name">
                                    <img class="header__profile__avatar" src="../../.${sessionScope.user.image}" alt="avarta"/>
                                    <div class="header__profile__name">
                                        <h5>${sessionScope.user.username}</h5>
                                        <p>@${sessionScope.user.username}</p>
                                    </div>
                                </div>
                                <ul class="header__profile__list">
                                    <li class="header__profile__item">
                                        <a class="header__profile__item__link" href="#">Trang cá nhân</a>
                                    </li>
                                    <li class="header__profile__item">
                                        <a class="header__profile__item__link" href="/blogs/write-new-blog">Viết blog</a>
                                        <a class="header__profile__item__link" href="/my-blogs">Bài viết của tôi</a>
                                    </li>
                                    <li class="header__profile__item">
                                        <a class="header__profile__item__link" href="#">Bài viết đã lưu</a>
                                    </li>
                                    <li class="header__profile__item">
                                        <a class="header__profile__item__link" href="#">Cài đặt</a>
                                        <a class="header__profile__item__link" href="/logout">Đăng xuất</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </header>

        <script src="../../../js/header.js"></script>
    </body>
</html>
