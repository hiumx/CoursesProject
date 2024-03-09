<%-- 
    Document   : home.jsp
    Created on : Feb 28, 2024, 10:46:36 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Home</title>
    </head>
    <body>

        <div class="home__wrapper">
            <%@include file="header.jsp" %>

            <div class="home__content">
                <%@include file="courses.jsp" %>

                <%@include file="blogs.jsp" %>
            </div>


            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
