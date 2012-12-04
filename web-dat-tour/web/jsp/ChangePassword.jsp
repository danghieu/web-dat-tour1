<%-- 
    Document   : ChangePassword
    Created on : Oct 28, 2012, 2:58:05 PM
    Author     : Karl
--%>
<%@page import="javabean.UserBean"%>
<%
    UserBean user = (UserBean) session.getAttribute("userbean");
    if (user == null) {
        response.sendRedirect("./Login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay đổi mật khẩu</title>
    </head>
    <body>
        <center>
        <form action="../ChangePasswordServlet" method="POST">

            <table>
                <tr>
                    <table>
                        <tbody border="1">
                            <tr>
                                <div style="color:red;size:15px" >THAY ĐỔI MẬT KHẨU</div>

                            </tr>
                            <tr>
                                <td align="right"><b>Mật khẩu cũ:   </b></td>
                                <td><input type="password" name="oldpassword" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Mật khẩu mới:   </b></td>
                                <td><input type="password" name="newpassword" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Nhập lại mật khẩu mới:   </b></td>
                                <td><input type="password" name="retypenewpassword" value="" /></td>
                            </tr>                            
                        </tbody>
                    </table>
                </tr>
                <tr>
                    <input type="submit" value="Cập nhật" name="updatepassword" />    
            </tr>
            </table>
        </form>
        </center>
    </body>
</html>
