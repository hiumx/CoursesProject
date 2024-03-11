<%-- 
    Document   : courses
    Created on : Mar 3, 2024, 10:01:07 PM
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
        <link rel="stylesheet" href="../../styles/courses.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="courses__wrapper container">
            <h3 class="courses__title">Khóa học miễn phí</h3>
            <ul class="courses__list row">
                <c:forEach items="${requestScope.listCourses}" var="i">
                    <li class="courses__item col-lg-3 col-md-4">
                    <a href="/courses?id=${i.id}" class="courses__item__link">
                        <img src="${i.image}" class="courses__item__img" alt="course-img"/>
                        <p class="courses__item__title">${i.title}</p>
                        <div class="courses__item__icon__wrapper">
                            <i class="fa-solid fa-users courses__item__icon"></i>
                            <span class="courses__item__joined__user">${i.joinedNumber}</span>
                        </div>
                    </a>
                </li>
                </c:forEach>
                
            </ul>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
