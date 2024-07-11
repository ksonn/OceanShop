<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add User</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet" href="./lib/css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center align-items-center min-vh-100">
                <div class="col-12 text-center py-5">
                    <div class="pb-5 pt-5 pt-sm-2">
                        <a href="ManageUser">
                            <button class="btn btn-primary">
                                Quay Lại
                            </button>
                        </a>
                        <div class="card-3d-wrap mx-auto" style="height: 550px">
                            <div class="card-3d-wrapper">
                                <div class="card-front">
                                    <div class="center-wrap">
                                        <div class="text-center">
                                            <form action="AddUser" method="POST">
                                                <h4 class="mb-4 pb-3">Thêm Người Dùng</h4>
                                                <div class="form-group">
                                                    <input type="email" class="form-style" id="logemail" name="email" placeholder="Email" autocomplete="off">
                                                    <i class="input-icon uil uil-at"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="pass" class="form-style" placeholder="Mật Khẩu" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="fullname" class="form-style" placeholder="Họ và Tên" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <select name="gender" id="selectDropdown">
                                                        <option value="Nam">Nam</option>
                                                        <option value="Nu" >Nu</option>
                                                    </select>
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="phone" class="form-style" placeholder="Số Điện Thoại" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <%-- neu role cua nguoi dung dang nhap khong null thi hien thi --%>
                                                <c:if test="${ sessionScope.emp.role != null}">
                                                    <div class="form-group mt-2">
                                                        <%-- neu role cua acc dang nhap la admin thi hien thi --%>
                                                        <c:if test="${sessionScope.emp.role eq 'Admin'}">
                                                            <%-- admin thi duoc chinh sua role --%>
                                                            <select name="isAdmin" id="selectDropdown">
                                                                <option value="Admin">Admin</option>
                                                                <option value="Employee" >Employee</option>
                                                            </select>
                                                        </c:if>
                                                    </div>
                                                </c:if>

                                                <button type="submit" class="btn mt-4">Thêm</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
