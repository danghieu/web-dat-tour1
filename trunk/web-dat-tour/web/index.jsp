<%-- 
    Document   : index
    Created on : Oct 24, 2012, 2:18:16 PM
    Author     : Karl
--%>

<%@page import="utilities.MD5"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
<title>Travel Booking</title>
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
                                
                                <% if(user!=null) {%>             
                                <li style="list-style: none;"><a href="jsp/ChangePassword.jsp">Đổi mật khẩu</a></li>
                                <li style="list-style: none;"><a href="jsp/../LogoutServlet">Đăng xuất</a></li>
                                <% } else { %>
                                <li style="list-style: none;"><a href="jsp/Register.jsp">Đăng ký</a></li>
                                <li style="list-style: none;"><a href="jsp/Login.jsp">Đăng nhập</a></li>
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
                        <%@include file="jsp/ControlPanel.jsp" %>
                        <% } else { %>
                        <div id="searchform">
                            <%@include file="jsp/Search.jsp" %> 
			</div>
                        <%@include file="jsp/Ads.jsp" %>
                        <% } %>
                        <!--<div id="rss"><a href="./"><img src="<%//=request.getContextPath()%>/css/images/spacer.gif" alt="RSS" height="40px" width="180px" /></a></div>
			<ul>
				<li>
					<h2>Categories</h2>
					<ul>
                                            
					</ul>
				</li>
				<li>
					<h2>Archives</h2>
					<ul>
					</ul>
				</li>
				<li>
					<h2>Recent Posts</h2>
					<ul>
					</ul>
				</li>
				<li>
				</li>
			</ul>-->
			<div id="sidebar-bottom"></div>
		</div>
<!-- sidebar end -->

<!-- content start -->
		<div id="content">

			<% 
                        DateFormat formatter ; 
                        formatter = new SimpleDateFormat("dd-MM-yyyy");  
                        
                        TourBO tourbo=new TourBO();
                        ArrayList<TourBean> listtour = tourbo.listAllTour(); 
                        if(listtour!=null){
                            for(int i=0;i<listtour.size();i++) {
                                TourBean tour=listtour.get(i);
                        %>

					<div class="post">
						<h2><a href="" title=""><%=tour.getTourProgram().getTourProgramName() %></a></h2>
						<p class="postmetadata">
                                                    Ngày khởi hành: <%=formatter.format(tour.getStartdate())  %> | Điểm đến: <%=tour.getEndplace()  %> | Giá tour: <%=tour.getBasiccharge()  %> VNĐ
                                                </p>
                                                <p class="postmetadata">
                                                    <% TourBO tourBO=new TourBO();
                                                    if(tourBO.freeseats(tour.getTourId())>0) {%>
                                                    Số chỗ còn nhận:<font color="red"><%=tourBO.freeseats(tour.getTourId())%></font>
                                                    <a href="<%="Booking.jsp?id="+tour.getTourId()%>"><img src="images/bt_booking_s.png" /></a>
                                                    <%} else {%>
                                                    <font color="red">Hết chỗ</font>
                                                    <%}%>
                                                </p>
						
                                                <div class="entry">
                                                    <img src="<%=tour.getTourProgram().getImage().substring(0,4).equals("http")?tour.getTourProgram().getImage():request.getContextPath()+tour.getTourProgram().getImage() %>" style="max-width:400px"/>
							<div class="endline">
                                                            <a href="<%="jsp/TourDetail.jsp?id="+tour.getTourId()%>">Chi tiết ... </a>
                                                        </div>
							<p class="commentline">
								
							</p>
						</div>
					</div>

			    <% } }
                                                   else {%>
                            
                            <div class="notfound"><p>Content Not Found!</p><p>Please try again.</p></div>
				<div class="endline"></div>
                                
                             <%                      }
                            %>

				<!--<?php include('pagenavi.php'); if(function_exists('wp_pagenavi')) { wp_pagenavi(); } ?>-->
				<div class="endline"></div>

			<!--<?php else : ?>
				<div class="notfound"><p>Content Not Found!</p><p>Please try again.</p></div>
				<div class="endline"></div>
			<?php endif; ?>-->
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

