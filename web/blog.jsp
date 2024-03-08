<%-- 
    Document   : blog
    Created on : Mar 4, 2024, 9:46:11 AM
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
        <link rel="stylesheet" href="styles/blog.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="blog__wrapper container">
            <h3 class="blog__title">Bài viết nổi bật</h3>
            <ul class="blog__list row">
                <c:forEach items="${requestScope.listBlogs}" var="b">
                    <li class="blog__item col-lg-3 col-md-4">
                        <a href="#" class="blog__item__link">
                            <img src="images/blogs/blog-img-1.png" class="blog__item__img" alt="blog-img"/>
                            <p class="blog__item__title">${b.title}</p>
                            <div class="blog__item__user">
                                <img class="blog__user__img" src="images/avatar/avatar-1.jpg" alt="avatar-img"/>
                                <span class="blog__user__name">${b.user.getUsername()}</span>
                                <span class="blog__user__doc">.</span>
                                <span class="blog__user__time__read">14 phút đọc</span>
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
