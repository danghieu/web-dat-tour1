<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
<%@page import="org.omg.CORBA.Environment"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
%>
<%
    TourBO tourBO=new TourBO();
    TourBean tour=tourBO.isExist(request.getParameter("id"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Chi tiết tour</title>
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
                    <% if(tour!=null) { %>
                    <h3><%=tour.getTourProgram().getTourProgramName() %></h3>
                    <% DateFormat formatter ; 
                         formatter = new SimpleDateFormat("dd-MM-yyyy");  
                         String startdate = formatter.format(tour.getStartdate()); %> 
                    <fieldset>
                        <legend>Tour</legend>
                        <div class="display-startdate">
                        <% if(tourBO.freeseats(tour.getTourId())>0) {%>
                        Số chỗ còn nhận:<font color="red"><%=tourBO.freeseats(tour.getTourId())%></font>
                        <a href="<%="Booking.jsp?id="+tour.getTourId()%>"><img src="../images/bt_booking_s.png" /></a>
                        <%} else {%>
                        <font color="red">Hết chỗ</font>
                        <%}%>
                        </div>
                        <div class="display-startdate">
                            Ngày khởi hành: <%=startdate %>
                        </div>
                        <div class="display-startplace">
                            Nơi khởi hành: <%=tour.getStartplace() %>
                        </div>
                        <div class="display-charge">
                            Giá tour: <%=tour.getBasiccharge() %> VNĐ
                        </div>    
                        <center><img alt="" src="<%=tour.getTourProgram().getImage().substring(0,4).equals("http")?tour.getTourProgram().getImage():request.getContextPath()+tour.getTourProgram().getImage() %>" width="400px" /></center>
                        <div class="display-label">
                            Lịch trình:
                        </div>
                        <div class="display-field">
                            <%=tour.getTourProgram().getItinerary().replaceAll("\n", "<br />") %>
                        </div>
                        <div class="display-label">
                            Lưu ý:
                        </div>
                        <div class="display-field">
                            <%=tour.getTourProgram().getNotice().replaceAll("\n", "<br />") %>
                        </div>
                        <div class="display-label">
                            Giá bao gồm:
                        </div>
                        <div class="display-field">
                            <%=tour.getTourProgram().getInclude().replaceAll("\n", "<br />") %>
                        </div>
                        <div class="display-label">
                            Giá không bao gồm:
                        </div>
                        <div class="display-field">
                            <%=tour.getTourProgram().getExclude().replaceAll("\n", "<br />") %>
                        </div>
                        <div class="display-label">
                            Điều kiện thanh toán:
                        </div>
                        <div class="display-field">
                            <%=tour.getTourProgram().getPaymentCondition().replaceAll("\n", "<br />") %>
                        </div>
                        <div><center><% if(tourBO.freeseats(tour.getTourId())>0) {%>
                                <a href="<%="Booking.jsp?id="+tour.getTourId()%>"><img src="../images/booking_icon_vi.jpg" /></a>
                                <%}%>
                            </center></div>
                                
                    </fieldset>
                    <% } else { %>
                    <div class="display-label">
                        Chi tiết Tour không tồn tài
                    </div>
                    <%}%>
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

