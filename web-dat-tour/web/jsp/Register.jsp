<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
<%-- 
    Document   : index
    Created on : Oct 24, 2012, 2:18:16 PM
    Author     : Karl
--%>

<%@page import="javabean.TourBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.TourBO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javabean.UserBean"%>
<%
    UserBean user = (UserBean) session.getAttribute("userbean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Đăng ký</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="screen" />

<script
   type='text/javascript' src="<%=request.getContextPath()%>/javascript/jquery.min.js"></script>
<script
   type='text/javascript' src="<%=request.getContextPath()%>/javascript/scrollto.js"></script>
<script
   type='text/javascript' src="<%=request.getContextPath()%>/javascript/quotable.js"></script>
<!--[if lte IE 6]><style>
.wp-pagenavi a, .wp-pagenavi span.pages, .wp-pagenavi span.current, .wp-pagenavi span.extend {padding: 2px 0; margin: 1px;}
</style><![endif]-->
<script
   type='text/javascript'>
function validateForm()
{
    if(document.formdangky.username.value=="")
    {
      alert("Username không được để trống!");
      document.formdangky.username.style.backgroundColor='red';
      document.formdangky.username.focus();
      document.formdangkygetElementById("iduser");
      return false;
    }
    else  if(document.formdangky.password.value=="")
    {
      alert("Mật khẩu không được để trống!");
      document.formdangky.password.style.backgroundColor='red';
      document.formdangky.password.focus();
      return false;
    }
    else if(document.formdangky.password.length < 6 )
    {
      alert("Mật khẩu phải nhiều hơn 6 ký tự!");
      document.formdangky.password.style.backgroundColor='red';
      document.formdangky.password.focus();
      return false;
    }
    else if(document.formdangky.retypepassword.value=="")
    {
      alert("Xác nhận mật khẩu không được để trống!");
      document.formdangky.retypepassword.style.backgroundColor='red';
      document.formdangky.retypepassword.focus();
      return false;
    } else if(document.formdangky.password.value==document.formdangky.retypepassword.value)
    {
      alert("Mật khẩu xác nhận không khớp!");
      document.formdangky.password.style.backgroundColor='red';
      document.formdangky.retypepassword.style.backgroundColor='red';
      document.formdangky.password.focus();
      return false;
    }else if(document.formdangky.password.value=="")
    {
        alert("Email không được để rỗng!");
                document.formdangky.email.style.backgroundColor='red';
                document.formdangky.email.focus();
        
        
      return false;
    }
    else if(document.formdangky.password.value!="")
        {
            if(kq2==false)
            {
                dangmail= /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,4}$/ //Tạo biểu thức quy tắc (tức là định dạng 1 mail nó như thế nào).

                kq2=dangmail.test(email); //Kiểm tra mail mà người dùng nhập vào.
                alert("Email không đúng định dạng!");
                document.formdangky.email.style.backgroundColor='red';
                document.formdangky.email.focus();
                return false;
            }
      
        }
        return true;
}
</script>
       
</script>

<link href="<%=request.getContextPath()%>/css/quotable.css" type="text/css" rel="stylesheet" />
</head>

<body>

<!-- wrapper start -->
<div id="wrapper">

<!-- header start -->
	<div id="header">

            <h1 style="color:white">Travel Booking</h1>

<!-- navigation start -->
		<div id="navigation">
		    <ul>
				<li style="list-style: none;"><a href="../">Trang chủ</a></li>
                                
                                <% if(user!=null) {%>             
                                <li style="list-style: none;"><a href="ChangePassword.jsp">Đổi mật khẩu</a></li>
                                <li style="list-style: none;"><a href="../LogoutServlet" >Đăng xuất</a></li>
                                <% } else { %>
                                <li style="list-style: none;"><a href="Register.jsp">Đăng ký</a></li>
                                <li style="list-style: none;"><a href="Login.jsp">Đăng nhập</a></li>
                                <% } %>
			</ul>
		</div>
<!-- navigation end -->

		<div class="endline"></div>

    </div>
<!-- header end -->

<!-- container start -->
	<div id="container">

		<!-- sidebar start -->
		<div id="sidebar">
			<% if(user!=null && user.getRoleId().equals("1")) { %>
                        <%@include file="ControlPanel.jsp" %>
                        <% } else { %>
                        <div id="searchform">
                            <%@include file="Search.jsp" %> 
			</div>
                        <%@include file="Ads.jsp" %>
                        <% } %>
			<div id="sidebar-bottom"></div>
		</div>
<!-- sidebar end -->

<!-- content start -->
		<div id="content">
                    <form  action="../RegisterServlet" method="POST" name="formdangky" id="formdangky" >
                    <table>
                        <tr>
                            <td><center><div style="color:red;size:15px" >ĐĂNG KÝ THÀNH VIÊN</div></center></td>
                        </tr>
                        <tr style="height:20px;bgcolor:lightblue;"><td></td></tr>
                        <tr><td>
                            <table>
                                <tbody>
                                    <tr>
                                        <td align="right"><b>Người dùng:   </b></td>
                                        <td><input type="text" name="username" value="" style="width: 250px"/>
                                            <label><span class="style23" style="color: #ff0000" id="iduser"></span></label></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Mật khẩu:   </b></td>
                                        <td><input type="password" name="password" value="" style="width: 250px"/>
                                        <label><span class="style23" style="color: #ff0000" id="idmk"></span></label></td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Nhập lại mật khẩu:   </b></td>
                                        <td><input type="password" name="retypepassword" value="" style="width: 250px"/>
                                        <label><span class="style23" style="color: #ff0000" id="idnlmk"></span></label></td>
                                        </td>
                                    </tr>  
                                    <tr>
                                        <td align="right"><b>Họ:   </b></td>
                                        <td><input type="text" name="lastname" value="" style="width: 250px"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Tên:   </b></td>
                                        <td><input type="text" name="firstname" value="" style="width: 250px"/></td>
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
                                        <td><select name="gender">
                                                <option value="Nam">Nam</option>
                                                <option value="Nu">Nữ</option>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Điện thoại:   </b></td>
                                        <td><input type="text" name="phone" value="" style="width: 250px"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Email:   </b></td>
                                        <td><input type="text" name="email" value="" style="width: 250px"/>
                                        <label><span class="style23" style="color: #ff0000" id="idemail"></span></label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Điạ chỉ:   </b></td>
                                        <td><textarea name="address" rows="4" cols="30"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Công ty:   </b></td>
                                        <td><input type="text" name="company" value="" style="width: 250px"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </td></tr>
                          
                        <tr>
                            <td> <center><input type="submit" value="Đăng ký" name="Resgister"  onclick="return validateForm()"/></center></td>
                        </tr>
                    </table>
                </form>
		</div>

<!-- content end -->

		<div class="endline"></div>

	</div>
<!-- container end -->

<!-- footer start -->
	<div id="footer">
                <p>&COPY; Bản quyên Website thuộc về Công ty TNHH du lịch web-dat-tour</p>
		<p>Modified from: <a href="http://themes.rock-kitty.net">Wordpress Themes</a> designed and coded by <a href="http://www.ezwpthemes.com/">EZwpthemes</a> | <a href="http://www.2cuk.co.uk">2cuk</a></p>
</div>
<!-- footer end -->

</div>
<!-- wrapper end -->

<!--<?php wp_footer(); ?>-->

</body>
</html>