<%-- 
    Document   : write-blog
    Created on : Mar 15, 2024, 8:26:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../../styles/write-blog.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wb__wrapper">
            <%@include file="./header.jsp" %>
            <form action="/blogs/write-new-blog" method="POST" class="wb__content container">
                <div>
                    <input type="text" class="wb__title" name="wb__title" placeholder="Tiêu đề" value="${requestScope.title}"/>
                </div>
                <div class="row">
                    <div class="wb__detail col-lg-6">
                        <h3>Nội dung:</h3>
                        <textarea class="wb__content__detail" name="wb__content__detail" value="${requestScope.content}"></textarea>
                    </div>
                    <div class="wb__img__wrapper col-lg-6">
                        <label class="form-label wb__img__lable">Hình ảnh:</label>
                        <input 
                            type="file" 
                            class="form-control wb__input__img" 
                            value="${requestScope.image}" 
                            name="wb__image" 
                            />
                    </div>
                </div>
                <p class="wb__msg__error">${requestScope.error}</p>
                <button type="submit" class="wb__upload__btn">Tải lên</button>
            </form>
        </div>
    </body>
</html>
