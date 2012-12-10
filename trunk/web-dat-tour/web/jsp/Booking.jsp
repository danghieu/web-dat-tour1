<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
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
%>
<%
    TourBO tourBO=new TourBO();
    TourBean tour=tourBO.isExist(request.getParameter("id"));
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
                        <input type="hidden" name="username" value="<%if(user!=null) out.print(user.getUserName()); TourContactBO tcBO=new TourContactBO();%>" />
                        <input type="hidden" name="tourcontact" value="<%=(tcBO.getTourContactId()!=null)?tcBO.getTourContactId():"" %>" />
                    <table>
                        <tr>
                            <td><center><div style="color:red;size:15px" >ĐĂNG KÝ TOUR</div></center></td>
                        </tr>
                        <tr><td>
                            <table>
                                <tbody style="border: 1px">
                                    <tr>
                                        <td align="right"><b>Tour:   </b></td>
                                        <td><input type="hidden" name="tourid" value="<%if(tour!=null) out.print(tour.getTourId().trim()); %>" />
                                            <%if(tour!=null) out.print(tour.getTourProgram().getTourProgramName()); %>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Nơi khởi hành:   </b></td>
                                        <td><%if(tour!=null) out.print(tour.getStartplace()); %></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Ngày khởi hành:   </b></td>
                                        <td><%if(tour!=null) out.print(tour.getStartdate()); %></td>
                                    </tr>
                                </tbody>
                            </table>
                            </td>
                        </tr>
                        <tr><td>
                                    <div class="display-field">Bảng giá tour (VNĐ)</div>
                                    <table border="1px">
                                <tr>
                            <th>
                                Người lớn
                            </th>
                            <th>
                                Trẻ em
                            </th>
                            <th>
                                Trẻ nhỏ
                            </th>
                            <th>
                                Phụ phí
                            </th>
                            <th>
                                Phí sân bay
                            </th>
                            <th>
                                Phụ thu phòng đơn
                            </th>
                            <th>
                                Phí Visa
                            </th>
                        </tr>

                        <tr>
                            <td><%if(tour!=null) out.print(tour.getBasiccharge()); %></td>
                            <td><%if(tour!=null) out.print(tour.getKidcharge()); %></td>
                            <td><%if(tour!=null) out.print(tour.getInfantcharge()); %></td>
                            <td><%if(tour!=null) out.print(tour.getSurcharge()); %></td>
                            <td><%if(tour!=null) out.print(tour.getAirportcharge()); %></td>
                            <td><%if(tour!=null) out.print(tour.getSingleroomsurcharge()); %></td>
                            <td><%if(tour!=null) out.print(tour.getVisasurcharge()); %></td>
                        </tr>                                   
                    </table>
                            </td>
                        </tr> 
                        <tr><td>
                                <table>
                                <tbody style="border: 1px">
                                    <% TravellerBean travellerBean=(TravellerBean) session.getAttribute("Traveller"); 
                                        TravellerBO travellerBO=new TravellerBO();
                                    %>
                                    <tr>
                                        <td align="right"><b>Họ tên:   </b></td>
                                        <td><input type="hidden" name="travellerid" value="<%if(travellerBean != null) out.print(travellerBean.getName()); else out.print(travellerBO.getTravllerId().trim());%>" />
                                            <input type="text" name="name" value="<%if(travellerBean != null) out.print(travellerBean.getName()); %>" /></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Ngày sinh:   </b></td>
                                        <td><%  int year=1900; if(travellerBean!=null){DateFormat formatter ; 
                                                formatter = new SimpleDateFormat("yyyy");  
                                                year = Integer.parseInt(formatter.format(travellerBean.getBirthday()));} %>
                                            <select name="date">
                                                <%  for(int i=1;i<=31;i++)
                                                       out.print("<option "+ ((travellerBean!=null && i==travellerBean.getBirthday().getDate())?"selected":"") +">"+i+"</option>");
                                                        %>
                                            </select><select name="month">
                                                <%  for(int i=1;i<=12;i++)
                                                        out.print("<option "+ ((travellerBean!=null && i==travellerBean.getBirthday().getMonth())?"selected":"") +">"+i+"</option>");
                                                        %></select><select name="year">
                                                <%  for(int i=1900;i<=2099;i++)
                                                        out.print("<option "+ ((travellerBean!=null && i==year)?"selected":"") +">"+i+"</option>");
                                                        %>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Giới tính:   </b></td>
                                        <td><select name="gender">
                                                <option value="Nam" <%=((travellerBean!=null && travellerBean.getGender()==true )?"selected":"") %>>Nam</option>
                                                <option value="Nu" <%=((travellerBean!=null && travellerBean.getGender()==false )?"selected":"") %>>Nữ</option>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Điạ chỉ:   </b></td>
                                        <td><textarea name="address" rows="4" cols="20"><%if(travellerBean != null) out.print(travellerBean.getAddress()); %></textarea></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Phòng đơn:   </b></td>
                                        <td><select name="singleroom">
                                                <option value="Có" <%=((travellerBean!=null && travellerBean.getSingleRoom()==true )?"selected":"") %>>Có</option>
                                                <option value="Không" <%=((travellerBean!=null && travellerBean.getSingleRoom()==false )?"selected":"") %>>Không</option>
                                            </select>    
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Loại hành khách:   </b></td>
                                        <td><select name="clienttype">
                                                <option value="Người lớn" <%=((travellerBean!=null && travellerBean.getClientType().equals("Người lớn") )?"selected":"") %>>Người lớn</option>
                                                <option value="Trẻ em" <%=((travellerBean!=null && travellerBean.getClientType().equals("Trẻ em") )?"selected":"") %>>Trẻ em</option>
                                                <option value="Trẻ nhỏ" <%=((travellerBean!=null && travellerBean.getClientType().equals("Trẻ nhỏ") )?"selected":"") %>>Trẻ nhỏ</option>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Hình thức thanh toán:   </b></td>
                                        <td><select name="payment">
                                                <option value="Tiền mặt" >Tiền mặt</option>
                                                <option value="Chuyển khoản" >Chuyển khoản</option>
                                            </select></td>
                                    </tr>
                                </tbody>
                            </table>
                                
                            </td></tr>
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

