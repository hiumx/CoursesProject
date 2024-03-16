<%-- 
    Document   : login
    Created on : Feb 28, 2024, 10:10:08 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="../../styles/login.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <div class="login__wrapper">
            <div class="login__content">
                <h2 class="login__title">Đăng nhập</h2>
                <form action="/login" method="POST" class="login__form">
                    <div class="login__form__username">
                        <label for="username">Tên nguời dùng</label>

                        <input 
                            type="text" 
                            name="username" 
                            id="username" 
                            class="login__form__input"
                            value="${requestScope.username}"
                            />
                    </div>
                    <div class="login__form__password">
                        <label for="password">Mật khẩu</label>
                        <input 
                            type="password" 
                            name="password" 
                            id="password"
                            class="login__form__input"
                            value="${requestScope.password}"
                            />
                        <div class="login__form__eye__icon__wrapper" onclick="handleShowPassword()">
                            <i class="fa-regular fa-eye login__form__eye__icon"></i>
                        </div>

                    </div>
                    <p class="login__error__msg">${requestScope.msg}</p>

                    <a href="/forgot-password" class="login__forgot__password">Quên mật khẩu?</a>
                    <button type="submit" class="login__form__btn">Đăng nhập</button>
                </form>
                <div class="login__other__sign__up">
                    <p>Hoặc đăng nhập bằng</p>
                    <div class="login__other__icons">
                        <i class="fa-brands fa-facebook login__facebook__icon"></i>
                        <i class="fa-brands fa-twitter login__twitter__icon"></i>
                        <i class="fa-brands fa-google login__google__icon"></i>
                    </div>
                </div>
                <div class="login__register">
                    <p class="login__register__question">Bạn chưa có tài khoản?</p>
                    <a href="/register" class="login__register__link">Đăng kí</a>
                </div>
            </div>
        </div>

        <script src="../../js/login.js"></script>
    </body>
</html>
