<%-- 
    Document   : manageUser
    Created on : Jul 7, 2024, 2:14:31 PM
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
            <form action="ManageUser" method="GET">
                <div class="row" style="margin-top: 20px">

                    <div class="col-md-6">
                        <div class="input-group mb-3">
                            <input type="text" name="searchValue" class="form-control" value="${requestScope.searchValue}" placeholder="Search by name, email, or phone">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="submit" id="searchButton">Search</button>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-sm-6">
                                <select name="gender" class="form-select">
                                    <c:if test="${requestScope.gender eq null}">
                                        <option selected="" value="">All Genders</option>
                                    </c:if>
                                    <c:if test="${requestScope.gender ne null}">
                                        <option value="">All Genders</option>
                                    </c:if>
                                    <c:if test="${requestScope.gender eq 'Nam'}">
                                        <option selected="" value="Nam">Male</option>
                                    </c:if>
                                    <c:if test="${requestScope.gender ne 'Nam'}">
                                        <option value="Nam">Male</option>
                                    </c:if> 
                                    <c:if test="${requestScope.gender eq 'Nu'}">
                                        <option selected="" value="Nu">Female</option>
                                    </c:if>
                                    <c:if test="${requestScope.gender ne 'Nu'}">
                                        <option value="Nu">Female</option>
                                    </c:if>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <select name="role" class="form-select">
                                    <c:if test="${requestScope.role eq null}">
                                        <option selected="" value="">All Roles</option>
                                    </c:if>
                                    <c:if test="${requestScope.role ne null}">
                                        <option value="">All Roles</option>
                                    </c:if>
                                    <c:if test="${requestScope.role eq 'Admin'}">
                                        <option selected="" value="Admin">Admin</option>
                                    </c:if>
                                    <c:if test="${requestScope.role ne 'Admin'}">
                                        <option value="Admin">Admin</option>
                                    </c:if>
                                    <c:if test="${requestScope.role eq 'Employee'}">
                                        <option selected="" value="Employee">Employee</option>
                                    </c:if>
                                    <c:if test="${requestScope.role ne 'Employee'}">
                                        <option value="Employee">Employee</option>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="table-container">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Họ và Tên</th>
                                <th>Giới Tính</th>
                                <th>Email</th>
                                <th>SĐT</th>
                                <th>Quyền Hạn</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${requestScope.list != null}">

                                <c:forEach items="${requestScope.list}" var="u">
                                    <tr>
                                        <td>${u.idUser}</td>
                                        <td>${u.tenUser}</td>
                                        <td>${u.gioiTinh}</td>
                                        <td>${u.email}</td>
                                        <td>0${u.sdt}</td>
                                        <td>${u.role}</td>
                                        <td>
                                            <a href="profile?id=${u.idUser}">
                                                <button class="btn btn-primary">Detail</button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${requestScope.list eq null}">
                                <tr>
                                    <td colspan="7"><h4 style="text-align: center">No Data</h4></td>
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
