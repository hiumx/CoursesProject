<%-- 
    Document   : header
    Created on : 1 Mar 2024, 20:36:31
    Author     : hieumaixuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="../../../styles/header.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header class="header__wrapper">
            <%@include file="navigation.jsp" %>
            <div class="header__content__wrapper">
                <div class="header__nav__logo">
                    <i class="fa-solid fa-bars header__bars__icon"></i>
                    <a href="/home" class="header__logo__wrapper">
                        <img class="header__logo" src="images/logo-1.png" alt="logo-img"/>
                    </a>
                </div>
                <div class="header__search__wrapper">
                    <i class="fa-solid fa-magnifying-glass header__search_icon"></i>
                    <input class="header__search" type="text" name="search-course" placeholder="Tìm kiếm khóa học..." />
                </div>
                <div class="header__profile">
                    <div class="header__profile__courses__wrapper">
                        <p class="header__profile__courses">Khóa học của tôi</p>
<!--                        <div class="header__profile__courses__detail">
                            <div>
                                <h3>Khóa học của tôi</h3>
                                <p>Xem tất cả</p>
                            </div>
                            <ul class="header__courses__list">
                                <li>
                                    <img src="src" alt="alt"/>
                                    <div>
                                        <h6>Làm việc với Terminal & Ubutu</h6>
                                        <p>Học cách đây 2 tháng trước</p>
                                    </div>
                                </li>
                            </ul>
                        </div>-->
                    </div>
                    
                    <div>
                        <i class="fa-solid fa-bell header__profile__bell__icon"></i>
                    </div>
                    <div class="header__profile__wrapper">
                        <i class="fa-solid fa-user header__profile__icon"></i>
                        <div class="header__profile__detail">
                            <div class="header__profile__ava__name">
                                <img class="header__profile__avatar" src="./images/avatar/avatar-1.jpg" alt="avarta"/>
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
                                    <a class="header__profile__item__link" href="#">Viết blog</a>
                                    <a class="header__profile__item__link" href="#">Bài viết của tôi</a>
                                </li>
                                <li class="header__profile__item">
                                    <a class="header__profile__item__link" href="#">Bài viết đã lưu</a>
                                </li>
                                <li class="header__profile__item">
                                    <a class="header__profile__item__link" href="#">Cài đặt</a>
                                    <a class="header__profile__item__link" href="#">Đăng xuất</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <script src="js/header.js"></script>
    </body>
</html>