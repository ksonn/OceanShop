<%-- 
    Document   : changepass
    Created on : Jul 7, 2024, 9:57:36 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Change Password</title>
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
                        <div class="card-3d-wrap mx-auto">
                            <div class="card-3d-wrapper">
                                <div class="card-front">
                                    <div class="center-wrap">
                                        <div class="text-center">
                                            <form action="changepass" method="POST">
                                                <h4 class="mb-4 pb-3">Đổi Mật Khẩu</h4>
                                                <div class="form-group">
                                                    <input type="email" name="logemail" class="form-style" id="logemail" value="${sessionScope.user.email}" disabled="" autocomplete="off">
                                                    <i class="input-icon uil uil-at"></i>
                                                </div>    
                                                <div class="form-group mt-2">
                                                    <input type="text" name="logpass" class="form-style" placeholder="Mật Khẩu" id="logpass" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <div class="form-group mt-2">
                                                    <input type="text" name="relogpass" class="form-style" placeholder="Xác Thực Mật Khẩu" id="relogpass" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
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
    </body>
</html>
