<%-- 
    Document   : login
    Created on : Jul 1, 2024, 3:30:29 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet" href="./lib/css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center align-items-center min-vh-100">
                <div class="col-12 text-center py-5">
                    <div class="pb-5 pt-5 pt-sm-2">
                        <span>
                            <c:if test="${requestScope.error ne null}">
                                    <h3 style="color: yellow;"> ${requestScope.error}</h3>
                            </c:if>
                        </span>
                        <div class="card-3d-wrap mx-auto">
                            <div class="card-3d-wrapper">
                                <div class="card-front">
                                    <div class="center-wrap">
                                        <div class="text-center">
                                            <form action="login" method="POST">
                                                <h4 class="mb-4 pb-3">Đăng nhập</h4>
                                                <div class="form-group">
                                                    <input type="email" name="logemail" class="form-style" placeholder="Email đăng nhập" id="logemail" autocomplete="off">
                                                    <i class="input-icon uil uil-at"></i>
                                                </div>    
                                                <div class="form-group mt-2">
                                                    <input type="password" name="logpass" class="form-style" placeholder="Mật khẩu" id="logpass" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <button type="submit" class="btn mt-4">Đăng nhập</button>
                                                <h5 style="margin-top: 20px"> Chưa có tài khoản? <a href="register">Đăng kí</a> </h5>
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
