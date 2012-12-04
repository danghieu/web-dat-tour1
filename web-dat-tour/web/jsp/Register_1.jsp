<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký thành viên</title>
    </head>
    <body>
        <center>
            <form action="../RegisterServlet" method="POST" >
            <table>
                <tr>
                    <td><center><div style="color:red;size:15px" >ĐĂNG KÝ THÀNH VIÊN</div></center></td>
                </tr>
                <tr height="20px" bgcolor="lightblue"><td></td></tr>
                <tr><td>
                    <table>
                        <tbody border="1">
                            <tr>
                                <td align="right"><b>Họ và tên:   </b></td>
                                <td><input type="text" name="fullname" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Ngày sinh:   </b></td>
                                <td><select name="date">
                                        <%  for(int i=1;i<=31;i++)
                                                out.print("<option>"+i+"</option>");
                                                %>
                                    </select><select name="month">
                                        <%  for(int i=1;i<=12;i++)
                                                out.print("<option>"+i+"</option>");
                                                %></select><select name="year">
                                        <%  for(int i=1900;i<=2099;i++)
                                                out.print("<option>"+i+"</option>");
                                                %>
                                    </select></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Giới tính:   </b></td>
                                <td><select name="sex">
                                        <option value="Nam">Nam</option>
                                        <option value="Nu">Nữ</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Điện thoại:   </b></td>
                                <td><input type="text" name="phone" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Email:   </b></td>
                                <td><input type="text" name="email" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Nhập lại email:   </b></td>
                                <td><input type="text" name="nlemail" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Điạ chỉ:   </b></td>
                                <td><textarea name="address" rows="4" cols="20">
                                    </textarea></td>
                            </tr>
                        </tbody>
                    </table>
                    </td>
                </tr>
                <tr height="20px" bgcolor="lightblue"><td></td></tr>
                <tr><td>
                    <table>
                        <tbody>
                            <tr>
                                <td align="right"><b>Người dùng:   </b></td>
                                <td><input type="text" name="username" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Mật khẩu:   </b></td>
                                <td><input type="password" name="password" value="" /></td>
                            </tr>
                            <tr>
                                <td align="right"><b>Nhập lại mật khẩu:   </b></td>
                                <td><input type="password" name="retypepassword" value="" /></td>
                            </tr>                            
                        </tbody>
                    </table>
                </td></tr>
                <tr>
                    <td> <center><input type="submit" value="Cập nhật" name="updatepassword" /></center></td>
                </tr>
            </table>
        </form>
        </center>
    </body>
</html>
