<%-- 
    Document   : register
    Created on : Jul 5, 2024, 11:21:32 PM
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
                                            <form action="register" method="POST">
                                                <h4 class="mb-4 pb-3">Đăng kí</h4>
                                                <div class="form-group">
                                                    <input type="text" name="lognamee" class="form-style" placeholder="Họ và tên" id="logname" autocomplete="off">
                                                    <i class="input-icon uil uil-user"></i>
                                                </div>    
                                                <div class="form-group mt-2">
                                                    <input type="email" name="logemaill" class="form-style" placeholder="Email đăng kí" id="logemail" autocomplete="off">
                                                    <i class="input-icon uil uil-at"></i>
                                                </div>    
                                                <div class="form-group mt-2">
                                                    <input type="password" name="logpasss" class="form-style" placeholder="Mật khẩu" id="logpass" autocomplete="off">
                                                    <i class="input-icon uil uil-lock-alt"></i>
                                                </div>
                                                <button type="submit" class="btn mt-4">Đăng kí</button>
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
