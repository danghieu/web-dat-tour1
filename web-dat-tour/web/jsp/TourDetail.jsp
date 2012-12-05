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
<title>Travel Booking - Chi tiết tour</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />

<script
   type='text/javascript' src="javascript/jquery.min.js"></script>
<script
   type='text/javascript' src="javascript/scrollto.js"></script>
<script
   type='text/javascript' src="javascript/quotable.js"></script>
<!--[if lte IE 6]><style>
.wp-pagenavi a, .wp-pagenavi span.pages, .wp-pagenavi span.current, .wp-pagenavi span.extend {padding: 2px 0; margin: 1px;}
</style><![endif]-->


<link href="css/quotable.css" type="text/css" rel="stylesheet" />
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
                                <% if(user.getRoleId().equals("1")) { %>
                                <li style="list-style: none;"><a href="./jsp/ControlPanel.jsp">Trang quản lý</a></li>
                                <% } %>
                                <% if(user!=null) {%>             
                                <li style="list-style: none;"><a href="./jsp/ChangePassword.jsp">Đổi mật khẩu</a></li>
                                <li style="list-style: none;"><a href="./" onclick="<% session.removeAttribute("userbean") ; %>">Đăng xuất</a></li>
                                <% } else { %>
                                <li style="list-style: none;"><a href="./jsp/Register.jsp">Đăng ký</a></li>
                                <li style="list-style: none;"><a href="./jsp/Login.jsp">Đăng nhập</a></li>
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
                    <jsp:useBean id="tourdetail" type="javabean.TourBean" scope="request" />                                 
                    <h3> <% 
                        TourBean tour= new TourBean();
                        tour = tourdetail;
                        out.print(tour.getTourProgram().getTourProgramName());
                    %> <img src="../../images/bt_booking_s.png" alt="booking"></img> </h3> 

                    <fieldset>
                        <legend>Tour</legend>
                        <div class="display-startdate">  
                            Ngày khởi hành: <% java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
                                                out.print(dateFormat.format(tour.getStartdate()));
                                                %>
                        </div>
                        <div class="display-startplace">
                            Nơi khởi hành: <%out.print(tour.getStartplace());%>
                        </div>
                        <div class="display-charge">
                            Giá tour: <%out.print(tour.getBasiccharge());%> VNĐ
                        </div>    
                        <div class="display-label">
                            Lịch trình:
                        </div>
                        <% for(int i=0;i<tour.getTourProgram().getItineraries().size();i++) { %>
                        <div class="display-field">
                            <% out.println("<img src="+tour.getTourProgram().getItineraries().get(i).getImage()+"/>"); %>
                            <% out.println("Ngày: "+tour.getTourProgram().getItineraries().get(i).getDay()); %>
                            <% out.println(tour.getTourProgram().getItineraries().get(i).getDetail()); %>
                        </div>
                        <% } %>
                        <div class="display-label">
                            Lưu ý:
                        </div>
                        <div class="display-field">
                            <% out.println(tour.getTourProgram().getNotice()); %>
                        </div>
                        <div class="display-label">
                            Giá bao gồm:
                        </div>
                        <div class="display-field">
                            <% out.println(tour.getTourProgram().getInclude()); %>
                        </div>
                        <div class="display-label">
                            Giá không bao gồm:
                        </div>
                        <div class="display-field">
                            <% out.println(tour.getTourProgram().getExclude()); %>
                        </div>
                        <div class="display-label">
                            Điều kiện thanh toán:
                        </div>
                        <div class="display-field">
                           <% out.println(tour.getTourProgram().getPaymentCondition()); %>
                        </div>
                    </fieldset>
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

