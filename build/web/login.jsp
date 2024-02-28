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
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/login.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <div class="login__wrapper">
            <div class="login__content">
                <h2 class="login__title">Login</h2>
                <form class="login__form">
                    <div class="login__form__username">
                        <label for="username">Username</label>
                        
                        <input 
                            type="text" 
                            name="username" 
                            id="username" 
                            class="login__form__input"
                            placeholder="Type your username"
                        />
                    </div>
                    <div class="login__form__password">
                        <label for="password">Password</label>
                        <input 
                            type="password" 
                            name="password" 
                            id="password"
                            class="login__form__input"F
                            placeholder="Type your password"
                        />
                    </div>
                    <a href="#" class="login__forgot__password">Forgot password?</a>
                    <button type="submit" class="login__form__btn">Login</button>
                </form>
                <div class="login__other__sign__up">
                    <p>Or Sign Up Using</p>
                    <div class="login__other__icons">
                            <i class="fa-brands fa-facebook login__facebook__icon"></i>
                        <i class="fa-brands fa-twitter login__twitter__icon"></i>
                        <i class="fa-brands fa-google login__google__icon"></i>
                    </div>
                </div>
                <div class="login__register">
                    <p>Do not have account?</p>
                    <a href="#">Register</a>
                </div>
            </div>
        </div>
    </body>
</html>
