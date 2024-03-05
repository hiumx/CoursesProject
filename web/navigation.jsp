<%-- 
    Document   : navbar
    Created on : 2 Mar 2024, 07:42:22
    Author     : hieumaixuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/navigation.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="header__nav">
            <ul class="header__nav__list">
                <li class="header__nav__wrapper__close__icon">
                    <i class="fa-solid fa-xmark nav__close__icon"></i>
                </li>
                <li class="header__nav__item">
                    <a class="header__nav__item--link" href="/courses/home.jsp">Trang chủ</a>
                </li>
                <li class="header__nav__item">
                    <a class="header__nav__item--link" href="#">Khóa học</a>
                </li>
                <li class="header__nav__item">
                    <a class="header__nav__item--link" href="#">Bài viết</a>
                </li>
                <li class="header__nav__item">
                    <a class="header__nav__item--link" href="#">Về chúng tôi</a>
                </li>
                <li class="header__nav__item">
                    <a class="header__nav__item--link" href="#">Liên hệ</a>
                </li>
            </ul>
            <div class="nav__social">
                <a href="https://youtube.com" class="nav__social__item" target="_blank">
                    <i class="fa-brands fa-youtube nav__social__youtube__icon"></i>
                </a>
                <a href="https://facebook.com" class="nav__social__item" target="_blank">
                    <i class="fa-brands fa-facebook nav__social__facebook__icon"></i>
                </a>
                <a href="https://tiktok.com" class="nav__social__item" target="_blank">
                    <i class="fa-brands fa-tiktok nav__social__tiktok__icon"></i>
                </a> 
            </div>
        </nav>
        <div id="over"></div>
        
        </<script src="js/navigation.js"></script>
    </body>
</html>
