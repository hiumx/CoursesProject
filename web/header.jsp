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
        <link rel="stylesheet" href="styles/header.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>JSP Page</title>
    </head>
    <body>
        <header class="header__wrapper">
            <%@include file="navigation.jsp" %>
            <div class="header__content__wrapper">
                <div class="header__nav__logo">
                    <i class="fa-solid fa-bars header__bars__icon"></i>
                    <a href="/courses/home.jsp" class="header__logo__wrapper">
                        <img class="header__logo" src="images/logo-1.png" alt="logo-img"/>
                    </a>
                </div>
                <div class="header__search__wrapper">
                    <i class="fa-solid fa-magnifying-glass header__search_icon"></i>
                    <input class="header__search" type="text" name="search-course" placeholder="Tìm kiếm khóa học..." />
                </div>
                <div class="header__profile">
                    <p class="header__profile__courses">Khóa học của tôi</p>
                    <i class="fa-solid fa-user header__profile__icon"></i>
                </div>
            </div>
        </header>

        <script src="js/header.js"></script>
    </body>
</html>
