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
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
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
                <button class="btn btn-secondary">Logout</button>
            </div>
        </nav>
    </body>
</html>
