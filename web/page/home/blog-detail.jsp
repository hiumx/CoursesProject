<%-- 
    Document   : blog-detail
    Created on : Mar 9, 2024, 4:43:01 PM
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
        <link rel="stylesheet" href="../../styles/blog-detail.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="blog__detail__wrapper">
            <%@include file="../../header.jsp" %>
            <div class="blog__detail__content container">
                <c:set var="b" value="${requestScope.blog}" />
                <div class="row">
                    <div class="col-lg-3">
                        <p class="blogde__username">${b.user.username}<p>
                        <div class="blogde__interact">
                            <div class="blogde__like">
                                <i class="fa-regular fa-heart blogde__like__icon"></i>
                                <span class="blogde__like__detail">${b.like}</span>
                            </div>
                            <div class="blogde__comment">
                                <i class="fa-regular fa-comment blogde__comment__icon"></i>
                                <span class="blogde__comment__detail">${b.comment}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <h1 class="blogde__title">${b.title}</h1>
                        <div class="blogde__user__info">
                            <div class="blogde__user__info__detail">
                                <img src="../.${b.user.image}" class="blogde__user__img" alt="user-img"/>
                                <div class="blogde__user__info__ud">
                                    <p class="blogde__user__info__u">${b.user.username}</p>
                                    <p class="blogde__user__info__d">1 ngày trước</p>
                                </div>
                            </div>
                            <div class="blogde__more__info">
                                <i class="fa-regular fa-bookmark blogde__bookmark__icon"></i>
                                <i class="fa-solid fa-ellipsis blogde__ellipsis__icon"></i>
                            </div>
                        </div>
                        <div class="blogde__content__post">
                            ${b.content}
                        </div>
                    </div>
                    <div class="col-lg-3">

                    </div>
                </div>
            </div>
            <%@include file="../../footer.jsp" %>
        </div>
    </body>
</html>
