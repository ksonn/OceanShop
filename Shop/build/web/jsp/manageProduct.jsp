

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ocean Shop</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./lib/css/newcss.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/slick-carousel/slick/slick.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
            <form action="ManageProduct" method="GET">
                <div class="row" style="margin-top: 20px">

                    <div class="col-md-6">
                        <div class="input-group mb-3">
                            <input type="text" name="searchValue" class="form-control" value="${requestScope.searchValue}" placeholder="Search by name, brand, or color">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="submit" id="searchButton">Search</button>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-sm-6">
                                <select name="category" class="form-select">
                                    <c:if test="${requestScope.category eq null}">
                                        <option selected="" value="">All Category</option>
                                    </c:if>
                                    <c:if test="${requestScope.category ne null}">
                                        <option value="">All Category</option>
                                    </c:if>
                                    <c:if test="${requestScope.categories ne null}">
                                        <c:forEach items="${requestScope.categories}" var="c">
                                            <c:if test="${requestScope.category eq c.idPhanLoai}">
                                                <option selected="" value="${c.idPhanLoai}">${c.thuongHieu}</option>
                                            </c:if>
                                            <c:if test="${requestScope.category ne c.idPhanLoai}">
                                                <option value="${c.idPhanLoai}">${c.thuongHieu}</option>
                                            </c:if> 
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
            <div class="col-md-6" style="margin-bottom: 20px;margin-left: -10px">
                <a href="./addProduct">
                    <button class="btn btn-outline-primary">Thêm Sản Phẩm</button>
                </a>
                <c:if test="${requestScope.message ne null}">
                    <span>
                        <h3 style="color: green">${requestScope.message}</h3>
                    </span>
                </c:if>
                </div>
                <div class="row">
                    <div class="table-container">
                        <table class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Id</th>
                                    <th>Tên Sản Phẩm</th>
                                    <th>Mô Tả Sản Phẩm</th>
                                    <th>Thương Hiệu</th>
                                    <th>Màu Sắc</th>
                                    <th>Loại Sản Phẩm</th>
                                    <th>Giá Nhập</th>
                                    <th>Giá Bán</th>
                                    <th>Số Lượng Trong Kho</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:if test="${requestScope.list != null}">

                                <c:forEach items="${requestScope.list}" var="p">
                                    <tr>
                                        <td>
                                            <img style="max-width: 250px;max-height: 300px" src="${p.anhMinhHoa}" alt="img"/>
                                        </td>
                                        <td>${p.idSanPham}</td>
                                        <td>${p.tenSanPham}</td>
                                        <td>${p.moTaSanPham}</td>
                                        <td>${p.thuongHieu}</td>
                                        <td>${p.mauSac}</td>
                                        <td>${p.tenPhanLoai}</td>
                                        <td>
                                            <fmt:formatNumber value="${p.giaBanDau}" type="currency" currencySymbol="VND"/>
                                        </td>
                                        <td>
                                            <fmt:formatNumber value="${p.giaSanPham}" type="currency" currencySymbol="VND"/>
                                        </td>
                                        <td>${p.tongSoLuong}</td>
                                        <td>
                                            <a href="ViewProduct?id=${p.idSanPham}">
                                                <button class="btn btn-outline-primary">Detail</button>
                                            </a>
                                            <a href="DeleteProduct?id=${p.idSanPham}">
                                                <button class="btn btn-outline-danger">Delete</button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${requestScope.list eq null}">
                                <tr>
                                    <td colspan="11"><h4 style="text-align: center">No Data</h4></td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <!--<div style="height: 10px"></div>-->

        </main>

        <footer class="footer mt-auto py-3 bg-light">
            <div class="container text-center">
                <p>&copy; 2024 Ocean Shop</p>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
