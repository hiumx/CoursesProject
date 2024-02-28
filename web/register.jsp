<%-- 
    Document   : register
    Created on : 28 Feb 2024, 19:14:59
    Author     : hieumaixuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="styles/register.css"/>
        <title>Register</title>
    </head>
    <body>
        <div class="register__wrapper">
            <div class="register__content">
                <h2 class="register__title">Register</h2>
                <form class="register__form">
                    <div class="register__form__username">
                        <label for="username">Username</label>
                        <input 
                            type="text" 
                            name="username" 
                            id="username" 
                            class="register__form__input"
                            placeholder="Type your username"
                        />
                    </div>
                    <div class="register__form__password">
                        <label for="password">Password</label>
                        <input 
                            type="password" 
                            name="password" 
                            id="password"
                            class="register__form__input"
                            placeholder="Type your password"
                        />
                        <div class="register__form__eye__icon__wrapper" onclick="handleShowPassword()">
                            <i class="fa-regular fa-eye register__form__eye__icon"></i>
                        </div>
                        
                    </div>
                    <div class="register__form__confirm__password">
                        <label for="password">Confirm Password</label>
                        <input 
                            type="password" 
                            name="confirm-password" 
                            id="confirm-password"
                            class="register__form__input"
                            placeholder="Type your confirm password"
                        />
                        <div class="register__form__eye__icon__wrapper" onclick="handleShowConfirmPassword()">
                            <i class="fa-regular fa-eye register__form__eye__icon"></i>
                        </div>
                        
                    </div>
                    <button type="submit" class="register__form__btn">Register</button>
                </form>
                <div class="register__other__sign__up">
                    <p>Or Register Using</p>
                    <div class="register__other__icons">
                            <i class="fa-brands fa-facebook register__facebook__icon"></i>
                        <i class="fa-brands fa-twitter register__twitter__icon"></i>
                        <i class="fa-brands fa-google register__google__icon"></i>
                    </div>
                </div>
                <div class="register__register">
                    <p class="register__register__question">Already have an account?</p>
                    <a href="http://localhost:6969/courses/login.jsp" class="register__register__link">Login</a>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">
            const passwordInput = document.querySelector('#password');
            const confirmPasswordInput = document.querySelector('#confirm-password');
            const handleShowPassword = () => {
                if(passwordInput.type === 'password')
                    passwordInput.type = 'text';
                else
                    passwordInput.type = 'password';
            };
            
            const handleShowConfirmPassword = () => {
                if(confirmPasswordInput.type === 'password')
                    confirmPasswordInput.type = 'text';
                else
                    confirmPasswordInput.type = 'password';
            }
        </script>
    </body>
</html>
