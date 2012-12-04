<%-- 
    Document   : Login
    Created on : Oct 17, 2012, 3:43:07 PM
    Author     : Tin Huynh
--%>

<%@page import="javabean.UserBean"%>
<%
    UserBean user = (UserBean) session.getAttribute("userbean");
    if (user != null) {
        response.sendRedirect("./LoginSuccessed.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <form action="../LoginServlet" method="POST">   
            <div style="color:red;size:15px" >ĐĂNG NHẬP HỆ THỐNG</div>
            <table>
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody border="1">
                    <tr>


                    </tr>
                    <tr>
                        <td align="right"><b>Người dùng:   </b></td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td align="right"><b>Mật khẩu:   </b></td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Đăng nhập" name="action"/></td>
                        <td><input type="submit" value="Đổi mật khẩu" name="action"/></td>
                    </tr>
                </tbody>
            </table>
            </form>
        </center>
    </body>
</html>
