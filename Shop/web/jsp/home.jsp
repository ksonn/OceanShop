<%-- 
    Document   : newjsp
    Created on : Jul 7, 2024, 8:29:55 AM
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang chủ</title>
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
                        <a class="nav-link" href="#">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sản phẩm</a>
                    </li>
                    <c:if test="${sessionScope.emp.role != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="manage">Quản Lý</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <c:if test="${sessionScope.emp.role == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Hoá Đơn</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Giỏ Hàng</a>
                            </li>
                        </c:if>
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
            <div class="row">
                <div class="carousel">
                    <img src="./lib/img/Phong-khach-chuyen-sau-01.jpg" alt="Slide 1">
                </div>
            </div>

            <h2>Danh mục sản phẩm</h2>

            <div class="row">

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/tiviCate.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="#" class="link-info">
                                <h5 class="card-title">Tivi</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/tuLanh.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="#" class="link-info">
                                <h5 class="card-title">Tủ Lạnh</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/Loa.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="#" class="link-info">
                                <h5 class="card-title">Loa</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/mayGiat.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="#" class="link-info">
                                <h5 class="card-title">Máy Giặt</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/noiCom.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="#" class="link-info">
                                <h5 class="card-title">Nồi Cơm Điện</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/dieuHoa.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <a href="#" class="link-info">
                                <h5 class="card-title">Máy Lạnh</h5>
                            </a>
                        </div>
                    </div>
                </div>

            </div>

            <h2>Sản phẩm bán chạy</h2>

            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/Phong-khach-chuyen-sau-01.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <h5 class="card-title">Hello</h5>
                            <p class="card-text">Giá: 100000 VNĐ</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <a href="#" class="btn btn-sm btn-outline-primary">Xem chi tiết</a>
                                <i class="fa fa-heart"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/Phong-khach-chuyen-sau-01.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <h5 class="card-title">Hello</h5>
                            <p class="card-text">Giá: 100000 VNĐ</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <a href="#" class="btn btn-sm btn-outline-primary">Xem chi tiết</a>
                                <i class="fa fa-heart"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="./lib/img/Phong-khach-chuyen-sau-01.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <h5 class="card-title">Hello</h5>
                            <p class="card-text">Giá: 100000 VNĐ</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <a href="#" class="btn btn-sm btn-outline-primary">Xem chi tiết</a>
                                <i class="fa fa-heart"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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

