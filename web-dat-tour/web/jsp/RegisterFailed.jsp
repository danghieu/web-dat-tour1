<%@page import="javabean.UserBean"%>
<%
    UserBean user = (UserBean) session.getAttribute("userbean");
    if (user == null) {
        response.sendRedirect("./Register.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Failed</title>
    </head>
    <body><form action="../FailedHandleServlet" method="POST">
    <center><div style='color:red;size:16px'><b>Đăng ký không thành công!!!!</b></div>
        <div style='color:red;size:13px'>Kiểm tra lại các thông tin đã nhập</div>
        <input type="submit" value="Đăng ký lại" name="action2"/></center></form>
    </body>
</html>
