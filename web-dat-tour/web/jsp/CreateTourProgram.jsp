<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
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
    TourProgramBean tourprogram= (TourProgramBean) session.getAttribute("tourprogram");
    String loi= (String)session.getAttribute("loi");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Tạo chương trình tour</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="screen" />

<script
   type='text/javascript' src="javascript/jquery.min.js"></script>
<script
   type='text/javascript' src="javascript/scrollto.js"></script>
<script
   type='text/javascript' src="javascript/quotable.js"></script>
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
                    <form action="../CreateTourProgramServlet" method="POST" >
                    <table>
                        <tr>
                            <td><center><div style="color:red;size:15px" >TẠO CHƯƠNG TRÌNH TOUR MỚI</div></center></td>
                        </tr>
                        <tr><td>
                            <table>
                                <tbody style="border: 1px">
                                    <% TourProgramBO tourprogramBO= new TourProgramBO(); %>
                                    <tr>
                                        <td align="right"><b>Mã chương trình tour:   </b></td>
                                        <td><input type="text" name="tourprogramid" value="<%=(tourprogram!=null)?tourprogram.getTourProgramId().trim():tourprogramBO.getTourProgramId()%>"
                                                   readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Tên chương trình tour:   </b></td>
                                        <td><input type="text" name="tourprogramname" value="<%if(tourprogram!=null) 
                                        {
                                            out.print(tourprogram.getTourProgramName());
                                        } %>" style="width: 400px"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Hình ảnh:   </b></td>
                                        <td><input type="text" name="imagefile" value="<%if(tourprogram!=null) 
                                        {
                                            out.print(tourprogram.getImage());
                                        } %>"  style="width: 400px"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Lịch trình:   </b></td>
                                        <td><textarea name="itinerary" rows="7" cols="50"><%if(tourprogram!=null){out.print(tourprogram.getItinerary());
                                        } %></textarea></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Lưu ý:   </b></td>
                                        <td><textarea name="notice" rows="7" cols="50"><%if(tourprogram!=null) 
                                        {
                                            out.print(tourprogram.getNotice());
                                        } %></textarea></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Phương tiện:   </b></td>
                                        <td><input type="text" name="transportation" value="<%if(tourprogram!=null) 
                                        {
                                            out.print(tourprogram.getTransportation());
                                        } %>" style="width: 400px"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Giá bao gồm:   </b></td>
                                        <td><textarea name="include" rows="7" cols="50"><%if(tourprogram!=null) 
                                        {
                                            out.print(tourprogram.getInclude());
                                        } %></textarea></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Giá không bao gồm:   </b></td>
                                        <td><textarea name="exclude" rows="7" cols="50"><%if(tourprogram!=null) 
                                        {
                                            out.print(tourprogram.getExclude());
                                        } %></textarea></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Điều kiện thanh toán:   </b></td>
                                        <td><textarea name="paymentcondition" rows="7" cols="50"><%if(tourprogram!=null) 
                                        {
                                            out.print(tourprogram.getPaymentCondition());
                                        } %></textarea></td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                            </td>
                        </tr>                
                        <tr>
                            <td> <center><input type="submit" value="Tạo mới" name="Create" /></center></td>
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

