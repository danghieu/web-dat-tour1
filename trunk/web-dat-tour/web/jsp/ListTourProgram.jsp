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
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Danh sách chương trình tour</title>
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
                    <% TourProgramBO tourpogramBO=new TourProgramBO();
                        ArrayList<TourProgramBean> listTourProgram=tourpogramBO.listAllTourProgram(); %>
                        <div class="display-label">Danh sách chương trình tour</div>
                        <a href="CreateTourProgram.jsp"> Tạo chương trình tour mới </a>
                    <table border="1px" width="600px" >
                        <tr>
                            <th>
                                Mã
                            </th>
                            <th>
                                Tên chương trình
                            </th>
                            <th></th>
                        </tr>

                    <% if(listTourProgram!=null) {
                            for (int i=0; i< listTourProgram.size();i++) {  
                                    TourProgramBean tourprogram = new TourProgramBean();
                                    tourprogram=listTourProgram.get(i);
                    %>
                        <tr>
                            <td>
                                <% out.print(tourprogram.getTourProgramId()); %>
                            </td>
                            <td>
                                <% out.print(tourprogram.getTourProgramName()); %>
                            </td>
                            <td>
                                <a href="<%="EditTourProgram.jsp?id="+tourprogram.getTourProgramId()%>"> Chỉnh sửa </a> |
                                <a href="<%="DeleteTourProgram.jsp?id="+tourprogram.getTourProgramId()%>"> Xóa </a> |
                                <a href="<%="DetailTourProgram.jsp?id="+tourprogram.getTourProgramId()%>"> Chi tiết </a>
                            </td>
                        </tr>
                    <% } } %>

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

