<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
<%@page import="javabean.SearchBean"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Kết quả tìm kiếm</title>
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
                    <% try {
                        TourBO tourBO=new TourBO();
                        SearchBean searchBean=new SearchBean();
                        //out.print(request.getParameter("NoiKhoiHanh"));
                        searchBean.setStartPlace(request.getParameter("NoiKhoiHanh"));
                        //out.print(request.getParameter("NoiDen"));
                        searchBean.setEndPlace(request.getParameter("NoiDen"));
                        //out.print(request.getParameter("year")+"/"+request.getParameter("month")+"/"+request.getParameter("date"));
                        searchBean.setStartDate(new Date(Integer.parseInt(request.getParameter("year"))+"/"+Integer.parseInt(request.getParameter("month"))+"/"+Integer.parseInt(request.getParameter("date"))));
                        //out.print(new Date(Integer.parseInt(request.getParameter("year"))+"/"+Integer.parseInt(request.getParameter("month"))+"/"+Integer.parseInt(request.getParameter("date"))));
                        //out.print(request.getParameter("Gia"));
                        int gia=Integer.parseInt(request.getParameter("Gia"));
                        switch(gia)
                        {
                            case 0:
                                searchBean.setChargeFrom(0);
                                searchBean.setChargeTo(20000000);
                                break;
                            case 1:
                                searchBean.setChargeFrom(0);
                                searchBean.setChargeTo(1000000);
                                break;
                            case 2:
                                searchBean.setChargeFrom(1000000);
                                searchBean.setChargeTo(5000000);
                                break;
                            case 3:
                                searchBean.setChargeFrom(5000000);
                                searchBean.setChargeTo(10000000);
                                break;
                            case 4:
                                searchBean.setChargeFrom(10000000);
                                searchBean.setChargeTo(15000000);
                                break;
                            case 5:
                                searchBean.setChargeFrom(1500000);
                                searchBean.setChargeTo(20000000);
                                break;
                            case 6:
                                searchBean.setChargeFrom(2000000);
                                searchBean.setChargeTo(1000000000);
                                break;
                        }
                        //out.println("Giá từ: "+searchBean.getChargeFrom()+"đến: "+searchBean.getChargeTo());
                        ArrayList<TourBean> listTour=null;
                        listTour = tourBO.searchTour(searchBean); %>
                        <div class="display-label">Kết quả tìm kiếm</div>
                        <% if(listTour.size() > 0 ) {%>
                    <table border="1px" width="600px" >
                        <tr>
                            <th>
                                Mã
                            </th>
                            <th>
                                Điểm đến
                            </th>
                            <th>
                                Ngày khởi hành
                            </th>
                            <th>
                                Số chỗ còn nhận
                            </th>
                            <th>
                                Giá (VNĐ)
                            </th>
                        </tr>

                    <%for (int i=0;i< listTour.size();i++) { 
                            TourBean tour=listTour.get(i);
                    %>
                    <tr>
                        <td>
                            <a href="<%="TourDetail.jsp?id="+tour.getTourId()%>"><% out.print(tour.getTourId()); %></a>
                        </td>
                        <td>
                            <% out.print(tour.getEndplace()); %>
                        </td>
                        <td>
                            <% out.print(tour.getStartdate()); %>
                        </td>
                        <td>
                            <% out.print(tourBO.freeseats(tour.getTourId())); %>
                        </td>
                        <td>
                            <% out.print(tour.getBasiccharge()); %>
                        </td>
                        <td>
                            <a href="<%="TourDetail.jsp?id="+tour.getTourId()%>">Xem chi tiết</a>
                            <a href="<%="Booking.jsp?id="+tour.getTourId()%>"><img src="../images/bt_booking_s.png"/></a>
                        </td>
                        
                    </tr>
                    <% } %>
                   </table>
                     <%} else {%>
                        <div class="display-label">Không tìm thấy</div> 
                    <%}} catch(Exception ex) {
                            out.print(ex);
                            out.close();
                        }%>
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

