<%-- 
    Document   : add-user
    Created on : Mar 7, 2024, 12:33:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-3" style="padding-top: 64px">
            <h2>Create new user</h2>
            <form action="/management/users/add-user" method="POST">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="form-group mt-3">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" value="${requestScope.username}" name="username" placeholder="Username..." required/>
                        </div>
                        <div class="form-group mt-3 mb-3">
                            <label for="password">Password</label>
                            <input type="text" class="form-control" id="password" value="${requestScope.password}" name="password" placeholder="Password..." required>
                        </div>
                    </div>
                </div>
                <p style="color: red">${requestScope.error}</p>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>

    </body>
</html>
