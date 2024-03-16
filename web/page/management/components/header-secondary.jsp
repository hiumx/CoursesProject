<%-- 
    Document   : header-secondary
    Created on : Mar 7, 2024, 9:18:41 AM
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-3 position-fixed fixed-top fixed-left fixed-right">
            <a class="navbar-brand" href="/management">Management</a>

            <div class="collapse navbar-collapse d-flex justify-content-between align-items-center" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="management?type=user">User</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/management?type=course">Course</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/management?type=blog">Blog</a>
                    </li>
                </ul>
                <div class="d-flex align-items-center">
                    <p style="margin: 0; padding: 0; color: #fff; margin-right: 40px;">Hi ${sessionScope.user.username} !</p>
                    <a href="/home" style="margin: 0; padding: 0; color: #fff; margin-right: 20px; text-decoration: none">Home page</a>
                    <a href="/logout" class="btn btn-secondary">Logout</a>
                </div>
                
            </div>
        </nav>
    </body>
</html>
