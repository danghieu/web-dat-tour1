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
<%
    TourBO tourBO=new TourBO();
    TourBean tour=tourBO.isExist(request.getParameter("id"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Travel Booking - Xóa tour</title>
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
                    <form action="../DeleteTourServlet" method="POST" >
                    <table>
                        <tr>
                            <td><center><div style="color:red;size:15px" >XÓA THÔNG TIN TOUR</div></center></td>
                        </tr>
                        <tr><td>
                            <table>
                                <tbody style="border: 1px">
                                    <tr>
                                        <td align="right"><b>Mã tour:   </b></td>
                                        <td><input type="text" name="tourid" value="<%= tour.getTourId() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Tên chương trình tour:   </b></td>
                                        <td><select name="tourprogramid" disabled="true">
                                                <%  TourProgramBO tourprogrambo=new TourProgramBO();
                                                 ArrayList<TourProgramBean> listtourprogram= tourprogrambo.listAllTourProgram();
                                                    for(int i=0;i<listtourprogram.size();i++)
                                                        out.print("<option value="+listtourprogram.get(i).getTourProgramId() 
        + ((listtourprogram.get(i).getTourProgramId()==tour.getTourProgram().getTourProgramId())?"selected=true":"") 
                                                                +">"+listtourprogram.get(i).getTourProgramName()+"</option>");
                                                        %>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Nơi khởi hành:   </b></td>
                                        <td><input type="text" name="startplace" value="<%= tour.getStartplace() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Ngày khởi hành:   </b></td>
                                        <td><input type="text" name="startdate" value="<%= tour.getStartdate() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Nơi đến:   </b></td>
                                        <td><input type="text" name="endplace" value="<%= tour.getEndplace() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Số hành khách:   </b></td>
                                        <td><input type="text" name="maxpeople" value="<%= tour.getMaxpeople() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Giá tour:   </b></td>
                                        <td><input type="text" name="basiccharge" value="<%= tour.getBasiccharge() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Phụ thu:   </b></td>
                                        <td><input type="text" name="surcharge" value="<%= tour.getSurcharge() %>" readonly="true"/></td>
                                    </tr>
                                            <tr>
                                        <td align="right"><b>Phí sân bay:   </b></td>
                                        <td><input type="text" name="airportcharge" value="<%= tour.getAirportcharge() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Phụ thu phòng đơn:   </b></td>
                                        <td><input type="text" name="singleroomsurcharge" value="<%= tour.getSingleroomsurcharge() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Phụ phí Visa:   </b></td>
                                        <td><input type="text" name="visasurcharge" value="<%= tour.getVisasurcharge() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Giá tour trẻ em:   </b></td>
                                        <td><input type="text" name="kidcharge" value="<%= tour.getKidcharge() %>" readonly="true"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Giá tour trẻ nhỏ:   </b></td>
                                        <td><input type="text" name="infantcharge" value="<%= tour.getInfantcharge() %>" readonly="true"/></td>
                                    </tr>
                                </tbody>
                            </table>
                            </td>
                        </tr>                
                        <tr>
                            <td> <center><input type="submit" value="Xóa" name="Delete" /></center></td>
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

