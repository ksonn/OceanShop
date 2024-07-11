
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h2 class="my-4">Add New Product</h2>
            <form action="addProduct" method="POST" enctype="multipart/form-data">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="productName">Tên Sản Phẩm</label>
                        <input type="text" class="form-control" name="productName" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="productImage">Ảnh</label>
                        <input type="file" class="form-control-file" name="productImage">
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="productDescription">Mô Tả Sản Phẩm</label>
                            <textarea class="form-control" name="productDescription" rows="2"></textarea>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="category">Loại Sản Phẩm</label>
                            <select name="category" class="form-select">
                                <c:forEach items="${requestScope.categories}" var="c">
                                    <option value="${c.idPhanLoai}">${c.thuongHieu}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="productPrice">Giá Nhập</label>
                            <input type="number" step="1" class="form-control" name="productPriceBuy" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="productPrice">Giá Bán</label>
                            <input type="number" step="1" class="form-control" name="productPriceSell" required>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="unitInStock">Số Lượng Hàng</label>
                            <input type="number" step="1" class="form-control" name="unitInStock" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="brand">Thương Hiệu</label>
                            <input type="text" class="form-control" name="brand">
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="color">Màu Sắc</label>
                            <input type="text" class="form-control" name="color">
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-outline-success ">Add Product</button>
                    </div>
                    <div class="col-md-4">
                        <a href="ManageProduct">
                            <button type="button" class="btn btn-outline-primary">Cancel</button>
                        </a>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </form>
            <div style="margin-bottom: 30px"></div>
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
