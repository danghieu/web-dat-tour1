<%-- 
    Document   : FailedLogin
    Created on : Oct 31, 2012, 11:35:08 AM
    Author     : Karl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Failed</title>
    </head>
    <body><center><form action="../FailedHandleServlet" method="POST">
    <div style='color:red;size:16px'><b>Đăng nhập không thành công!!!!</b></div>
        <div style='color:red;size:13px'>Kiểm tra lại Tên người dùng & Mật khẩu</div>
        <input type="submit" value="Đăng nhập lại" name="action2"/></form></center>
    </body>
</html>
