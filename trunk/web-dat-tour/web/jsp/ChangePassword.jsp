<%-- 
    Document   : ChangePassword
    Created on : Oct 28, 2012, 2:58:05 PM
    Author     : Karl
--%>
<%@page import="javabean.UserBean"%>
<%
    UserBean user = (UserBean) session.getAttribute("userbean");
    if (user == null) {
        session.invalidate();
        response.sendRedirect("./Login.jsp");
    }
    String changepassfail = (String) session.getAttribute("changepassfail");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Đổi mật khẩu</title>
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

			<form action="../ChangePasswordServlet" method="POST">

            <table>
                <tr>
                    <table>
                        <tbody border="1">
                            <tr>
                                <div style="color:red;size:15px" >THAY ĐỔI MẬT KHẨU</div>

                            </tr>
                            <tr>
                                <% if(changepassfail!=null) {%><div style="color:red;size:15px" >THAY ĐỔI MẬT KHẨU KHÔNG THÀNH CÔNG</div> <% } %>

                            </tr>
                            <tr>
                                <td align="right"><b>Mật khẩu cũ:   </b></td>
                                <td><input type="password" name="oldpassword" value="" /> <% if(changepassfail!=null) out.print("<font color='red'>Mật khẩu không chính xác</font>"); %></td>
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