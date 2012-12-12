<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>

<%@page import="javabean.AdsBean"%>
<%@page import="bo.AdsBO"%>
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
<title>Chỉnh sửa quảng cáo</title>
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
                    <form action="../EditAdsServlet" method="POST" >
                    <table>
                        <tr>
                            <td><center><div style="color:red;size:15px" >CHỈNH SỬA QUẢNG CÁO</div></center></td>
                        </tr>
                        <tr><td>
                            <table>
                                <tbody style="border: 1px">
                                    <% AdsBean ads_bean=new AdsBean();
                                        AdsBO ads_BO= new AdsBO();
                                        ads_bean=ads_BO.isExist(request.getParameter("id"));
                                        if(ads_bean!=null) out.print("<img src="+ads_bean.getImage()+" style='max-width:200px;max-heigh:400px'/>");
                                    %>
                                    <tr>
                                        <td align="right"><input type="hidden" name="id" value="<% if(ads_bean!=null) out.print(ads_bean.getAdsID()); %>"></input>
                                            <b>Link quảng cáo:   </b></td>
                                        <td><input type="text" name="Link" value="<%  if(ads_bean!=null) out.print(ads_bean.getLink()); %>" style="width: 250px"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Link hình ảnh(kích thước tối đa 200x400px):   </b></td>
                                        <td><input type="text" name="Image" value="<%  if(ads_bean!=null) out.print(ads_bean.getImage()); %>"style="width: 250px"/></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><b>Mô tả:   </b></td>
                                        <td><textarea name="Caption" rows="4" cols="30"><%=(ads_bean!=null)?ads_bean.getCaption():"" %></textarea></td>
                                    </tr>                                   
                                </tbody>
                            </table>
                            </td>
                        </tr>                
                        <tr>
                            <td> <center><input type="submit" value="Lưu" name="Create" /></center></td>
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

