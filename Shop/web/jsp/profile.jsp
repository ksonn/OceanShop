<%-- 
    Document   : profile
    Created on : Jul 7, 2024, 11:00:14 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profile Detail</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet" href="./lib/css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center align-items-center min-vh-100">
                <div class="col-12 text-center py-5">
                    <div class="pb-5 pt-5 pt-sm-2">
                        <a href="home">
                            <button class="btn btn-primary">
                                Quay Lại Trang Chủ
                            </button>
                        </a>
                        <span>
                            <c:if test="${requestScope.message ne null}">
                                <h3 style="color: yellow; margin-top: 20px;margin-bottom: -30px"> ${requestScope.message}</h3>
                            </c:if>
                        </span>
                        <div class="card-3d-wrap mx-auto" style="height: 550px">
                            <div class="card-3d-wrapper">
                                <div class="card-front">
                                    <div class="center-wrap">
                                        <div class="text-center">
                                            <form action="profile" method="POST">
                                                <h4 class="mb-4 pb-3">Thông Tin Hồ Sơ</h4>
                                                <div class="form-group">
                                                    <input name="id" type="text" class="form-style" value="${requestScope.user.idUser}" hidden="" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="email" class="form-style" hidden="" value="${requestScope.user.email}">
                                                    <input type="email" class="form-style" id="logemail" value="${requestScope.user.email}" disabled="">
                                                    <i class="input-icon uil uil-at"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="fullname" class="form-style" placeholder="Họ và Tên" value="${requestScope.user.tenUser}" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="gender" class="form-style" placeholder="Giới Tính" value="${requestScope.user.gioiTinh}" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="phone" class="form-style" placeholder="Số Điện Thoại" value="${requestScope.user.sdt}" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                    <%-- neu role cua nguoi dung dang nhap khong null thi hien thi --%>
                                                <c:if test="${ sessionScope.emp.role != null}">
                                                    <div class="form-group mt-2">
                                                        <%-- neu role cua profile can xem khong null thi hien thi --%>
                                                        <c:if test="${requestScope.user.role ne null}">
                                                            <%-- neu role cua acc dang nhap la admin thi hien thi --%>
                                                            <c:if test="${sessionScope.user.role eq 'Admin'}">
                                                                
                                                                <%-- admin thi duoc chinh sua role --%>
                                                                
                                                                <c:if test="${requestScope.user.role eq 'Admin'}">
                                                                    <select name="isAdmin" id="selectDropdown">
                                                                        <option value="Admin" selected="">Admin</option>
                                                                        <option value="Employee" >Employee</option>
                                                                    </select>
                                                                </c:if>
                                                                <c:if test="${requestScope.user.role ne 'Admin'}">
                                                                    <select name="isAdmin" id="selectDropdown">
                                                                        <option value="Admin">Admin</option>
                                                                        <option value="Employee" selected="">Employee</option>
                                                                    </select>
                                                                </c:if>
                                                                
                                                            </c:if>
                                                            <%-- neu role cua acc dang nhap ko phai admin thi hien thi --%>
                                                            <c:if test="${sessionScope.user.role ne 'Admin'}">
                                                                
                                                                <%-- emp thi ko duoc chinh sua role --%>
                                                                
                                                                <c:if test="${requestScope.user.role eq 'Admin'}">
                                                                    <select name="isAdmin" id="selectDropdown" disabled="">
                                                                        <option value="Admin" selected="">Admin</option>
                                                                        <option value="Employee" >Employee</option>
                                                                    </select>
                                                                </c:if>
                                                                <c:if test="${requestScope.user.role ne 'Admin'}">
                                                                    <select name="isAdmin" id="selectDropdown" disabled="">
                                                                        <option value="Admin">Admin</option>
                                                                        <option value="Employee" selected="">Employee</option>
                                                                    </select>
                                                                </c:if>
                                                                
                                                            </c:if>
                                                        </c:if>
                                                    </div>
                                                </c:if>

                                                <button type="submit" class="btn mt-4">Thay Đổi</button>
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
        <script>
            const checkbox = document.getElementById('customCheckbox');
            const customCheckbox = document.querySelector('.custom-checkbox');

            checkbox.addEventListener('change', function () {
                if (this.checked) {
                    customCheckbox.classList.add('checked');
                } else {
                    customCheckbox.classList.remove('checked');
                }
            });
        </script>
    </body>
</html>
