<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javabean.TravellerBean"%>
<%@page import="javabean.TourContactBean"%>
<%@page import="bo.TourContactBO"%>
<%@page import="javabean.TourProgramBean"%>
<%@page import="bo.TourProgramBO"%>
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
    if(user==null || !user.getRoleId().equals("1"))
    {
        response.sendRedirect("./AccessDenied.jsp");
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Danh sách hành khách</title>
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
                                <% if(user!=null&&user.getRoleId().equals("1")) { %>
                                <li style="list-style: none;"><a href="ControlPanel.jsp">Trang quản lý</a></li>
                                <% } %>
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
			<div id="searchform">
                            <!--<?php include(TEMPLATEPATH . '/searchform.php'); ?>-->
			</div>
			<div id="rss"><a href="./"><img src="<%=request.getContextPath()%>/css/images/spacer.gif" alt="RSS" height="40px" width="180px" /></a></div>
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
                    <% TourContactBO tourcontactBO=new TourContactBO();
                        ArrayList<TourContactBean> listTourContact=tourcontactBO.searchTourid(request.getParameter("id")); 
                    DateFormat formatter ; 
                        formatter = new SimpleDateFormat("dd-MM-yyyy");
                    if(listTourContact!=null) {
                    %>   
                    <div class="display-label">Danh sách hành khách</div>
                    <table border="1px" width="600px" >
                        <tr>
                            <th>
                                Mã KH
                            </th>
                            <th>
                                Họ Tên
                            </th>
                            <th>
                                Giới tính
                            </th>
                            <th>
                                Ngày sinh
                            </th>
                            <th>
                                Phòng đơn
                            </th>
                            <th>
                                Loại khách hàng
                            </th>
                        </tr>

                    <%for (int i=0;i< listTourContact.size();i++) { 
                            TravellerBean traveller=listTourContact.get(i).getTraveller();
                    %>
                        <tr>
                            <td>
                                <% out.print(traveller.getTravellerId()); %>
                            </td>
                            <td>
                                <% out.print(traveller.getName()); %>
                            </td>
                            <td>
                                <% out.print(traveller.getGender()?"Nam":"Nữ"); %>
                            </td>
                            <td>
                                <% out.print(formatter.format(traveller.getBirthday())); %>
                            </td>
                            <td>
                                <% out.print(traveller.getSingleRoom()?"Có":"không"); %>
                            </td>
                            <td>
                                <% out.print(traveller.getClientType()); %>
                            </td>
                            
                        </tr>
                    <% } }else {%>
                        <tr>
                            <td>Chưa có hành khách</td>
                        </tr>
                        <%}%>
                    </table>

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

