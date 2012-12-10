<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
<%@page import="javabean.TourContactBean"%>
<%@page import="bo.TourContactBO"%>
<%@page import="bo.TravellerBO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javabean.TravellerBean"%>
<%@page import="javabean.TourProgramBean"%>
<%@page import="bo.TourProgramBO"%>
<%@page import="javabean.TourBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.TourBO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javabean.UserBean"%>
<%
    UserBean user = (UserBean) session.getAttribute("userbean");
    if(user==null)
    {
        response.sendRedirect("./Login.jsp");
    }
    TourContactBO tourcontactBO=new TourContactBO();
    TourContactBean tourcontact=null;
    tourcontact=tourcontactBO.isExist(request.getParameter("id"));
    TourBean tour=new TourBean();
    tour=tourcontact.getTour();
    TravellerBean travellerBean=new TravellerBean();
    travellerBean = tourcontact.getTraveller();
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
                    <form action="../BookingServlet" method="POST" >
                    <table>
                        <tr>
                            <td><center><div style="color:red;size:15px" >ĐĂNG KÝ TOUR THÀNH CÔNG</div></center></td>
                        </tr>
                        <tr><td>
                            <table>
                                <tbody style="border: 1px">
                                    <tr>
                                        <td align="right"><b>Tour:   </b></td>
                                        <td><%if(tour!=null) out.print(tour.getTourProgram().getTourProgramName()); %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Nơi khởi hành:   </b></td>
                                        <td><%if(tour!=null) out.print(tour.getStartplace()); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Ngày khởi hành:   </b></td>
                                        <td><%DateFormat formatter ; 
                                                formatter = new SimpleDateFormat("dd-MM-yyyy");  
                                                String start = formatter.format(tour.getStartdate());
                                        if(tour!=null) out.print(start); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Họ tên:   </b></td>
                                        <td><%if(travellerBean != null) out.print(travellerBean.getName()); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Ngày sinh:   </b></td>
                                        <td><%  String birthday = formatter.format(travellerBean.getBirthday());
                                                if(travellerBean != null) out.print(birthday); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Giới tính:   </b></td>
                                        <td><%=((travellerBean!=null && travellerBean.getGender()==true )?"Nam":"Nữ")%></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Điạ chỉ:   </b></td>
                                        <td><%if(travellerBean != null) out.print(travellerBean.getAddress()); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Phòng đơn:   </b></td>
                                        <td><%=((travellerBean!=null && travellerBean.getSingleRoom()==true )?"Có":"Không") %>    
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Loại hành khách:   </b></td>
                                        <td><%if(travellerBean != null) out.print(travellerBean.getClientType()); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Hình thức thanh toán:   </b></td>
                                        <td><%if(tourcontact != null) out.print(tourcontact.getPayment()); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Tổng tiền:   </b></td>
                                        <td style="color:red;size: 11px"><%if(tourcontact != null) out.print(tourcontactBO.Total(tourcontact)); %>VNĐ</td>
                                    </tr>
                                </tbody>
                            </table>
                            </td>
                        </tr>
                         
                        <tr><td>
                               
                                
                            </td></tr>
                        
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

