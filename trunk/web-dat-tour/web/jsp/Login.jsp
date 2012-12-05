<%-- 
    Document   : Login
    Created on : Oct 17, 2012, 3:43:07 PM
    Author     : Tin Huynh
--%>

<%@page import="javabean.UserBean"%>
<%
    UserBean user = (UserBean) session.getAttribute("userbean");
    if (user != null) {
        response.sendRedirect("./");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Đăng nhập</title>
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
				<li style="list-style: none;"><a href="./">Trang chủ</a></li>
                                <% if(user!=null&&user.getRoleId().equals("1")) { %>
                                <li style="list-style: none;"><a href="./jsp/user/ControlPanel.jsp">Trang quản lý</a></li>
                                <% } %>
                                <% if(user!=null) {%>   
                                <li style="list-style: none;"><a href="./jsp/user/ChangePassword.jsp">Đổi mật khẩu</a></li>
                                <li style="list-style: none;"><a href="./" onclick="<% session.removeAttribute("userbean") ; %>">Đăng xuất</a></li>
                                <% } else { %>
                                <li style="list-style: none;"><a href="./jsp/user/Register.jsp">Đăng ký</a></li>
                                <li style="list-style: none;"><a href="./jsp/user/Login.jsp">Đăng nhập</a></li>
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
			<div id="searchform">
                            <!--<?php include(TEMPLATEPATH . '/searchform.php'); ?>-->
			</div>
			<div id="rss"><a href="./"><img src="css/images/spacer.gif" alt="RSS" height="40px" width="180px" /></a></div>
			<ul>
				<!--<?php if ( !function_exists('dynamic_sidebar') || !dynamic_sidebar('Sidebar1') ) : ?>-->
				<li>
					<h2>Categories</h2>
					<ul>
                                            <!--
						<?php wp_list_cats('sort_column=name&optioncount=1&hierarchical=0'); ?> -->
					</ul>
				</li>
				<li>
					<h2>Archives</h2>
					<ul>
						<!--<?php wp_get_archives('type=monthly'); ?>-->
					</ul>
				</li>
				<li>
					<h2>Recent Posts</h2>
					<ul>
						<!--<?php get_archives('postbypost', 5); ?>-->
					</ul>
				</li>
				<li>
					<!--<?php get_recent_comments(array('number' => 5)); ?>-->
				</li>
				<!--<?php endif; ?>-->
			</ul>
			<div id="sidebar-bottom"></div>
		</div>
<!-- sidebar end -->

<!-- content start -->
		<div id="content">

			<form action="../LoginServlet" method="POST">   
            <div style="color:red;size:15px" >ĐĂNG NHẬP HỆ THỐNG</div>
            <table>
                 <tbody style="border: 1">
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
                    </tr>
                </tbody>
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
