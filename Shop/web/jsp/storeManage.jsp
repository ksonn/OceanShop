<%-- 
    Document   : storeManage
    Created on : Jul 7, 2024, 1:47:59 PM
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ocean Shop</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./lib/css/newcss.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/slick-carousel/slick/slick.css">
    </head>
    <body>
        <header class="navbar navbar-expand-sm bg-light navbar-light">
            <a class="navbar-brand" href="home">Ocean Shop</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home">Trang chủ</a>
                    </li>
                    <c:if test="${sessionScope.user != null}">
                        <li class="nav-item dropdown dropstart">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-user"></span> <span class="caret">Cá Nhân</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-left" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="profile?id=${sessionScope.user.idUser}">Hồ sơ</a>
                                <a class="dropdown-item" href="changepass">Đổi Mật Khẩu</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logout">Đăng xuất</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="login">Đăng Nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register">Đăng Kí</a>
                        </li

                    </c:if>
                </ul>
            </div>
        </header>

        <main class="container">
            <div style="height: 200px">
                
            </div>
            <div class="row">

                <div class="col-md-6">
                    <div class="card mb-6 shadow-sm">
                        <img style="width: 350px" src="./lib/img/user.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="ManageUser" class="link-info">
                                <h5 class="card-title">Quản Lí Người Dùng</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card mb-6 shadow-sm">
                        <img style="width: 350px" src="./lib/img/khohang.png" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="#" class="link-info">
                                <h5 class="card-title">Quản Lí Kho</h5>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div style="height: 130px"></div>

        </main>

        <footer class="footer mt-auto py-3 bg-light">
            <div class="container text-center">
                <p>&copy; 2024 Ocean Shop</p>
            </div>
        </footer>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>

