<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                        <a class="nav-link" href="home">Trang chủ</a>
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
                                <a class="nav-link" href="ListCard?uid=${sessionScope.user.idUser}">Giỏ Hàng</a>
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
            <div class="row" style="margin-bottom: 10px">
                <a href="ShoppingArea?category=0">
                    <button class="btn btn-outline-primary" type="button">Tất Cả</button>
                </a>
                <c:if test="${requestScope.message ne null}">
                    <span style="margin-left: 300px">
                        <h3 style="color: red">${requestScope.message}</h3>
                    </span>
                </c:if>
            </div>
            <div class="row align-items-center justify-content-center" style="margin-bottom: 20px">

                <c:forEach items="${requestScope.categories}" var="c">
                    <div class="col-md-2">
                        <a href="ShoppingArea?category=${c.idPhanLoai}">
                            <button class="btn btn-outline-primary" type="button">${c.thuongHieu}</button>
                        </a>
                    </div>
                </c:forEach>
            </div>

            <div class="row">
                <c:if test="${requestScope.list ne null}">

                    <c:forEach items="${requestScope.list}" var="p">
                        <div class="col-md-4">
                            <div class="card mb-4 shadow-sm">
                                <img src="${p.anhMinhHoa}" class="card-img-top" alt="img">
                                <div class="card-body">
                                    <a href="ViewProduct?id=${p.idSanPham}" class="link-info">
                                        <h5 class="card-title">${p.tenSanPham}</h5>
                                    </a>
                                    <form action="AddToCart" method="GET">
                                        <div>Giá: 
                                            <fmt:formatNumber value="${p.giaSanPham}" type="currency" currencySymbol="VND"/>
                                        </div>
                                        <input name="pid" value="${p.idSanPham}" hidden=""/>
                                        <input name="uid" value="${sessionScope.user.idUser}" hidden=""/>
                                        <input name="sdt" value="${sessionScope.user.sdt}" hidden=""/>
                                        <input name="name" value="${sessionScope.user.tenUser}" hidden=""/>
                                        <input name="price" value="${p.giaSanPham}" hidden=""/>
                                        <div>
                                            <label>Số Lượng</label>
                                            <input type="number" name="quantity" va lue="1"/>
                                        </div>
                                            <button class="btn btn-outline-success">Thêm Vào Giỏ</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${requestScope.list eq null}">
                    <div class="row justify-content-center align-items-center">
                        <h4 >No Data</h4>
                    </div>
                </c:if>
                
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
