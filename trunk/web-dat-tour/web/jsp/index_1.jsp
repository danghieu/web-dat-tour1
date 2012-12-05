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
<title>Travel Booking</title>
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

		<h1>Travel Booking</h1>

<!-- navigation start -->
		<div id="navigation">
		    <ul>
				<li style="list-style: none;"><a href="./">Trang chủ</a></li>
                                <% if(user!=null) {%>
                                
                                <li style="list-style: none;"><a href="./jsp/Logout.jsp" onclick="<% session.removeAttribute("userbean") ; %>">Đăng xuất</a></li>
                                <% } else { %>
                                <li style="list-style: none;"><a href="./jsp/Register.jsp">Đăng nhập</a></li>
                                <% } %>
			</ul>
		</div>
<!-- navigation end -->

		<div class="endline"></div>
		<h2>Website giới thiệu và đặt tour trực tuyến</h2>

    </div>
<!-- header end -->

<!-- container start -->
	<div id="container">

		<!-- sidebar start -->
		<div id="sidebar">
			<!--<div id="searchform">
                            <?php include(TEMPLATEPATH . '/searchform.php'); ?>
                        </div>-->
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

			<% 
                        TourBO tourbo=new TourBO();
                        ArrayList<TourBean> listtour = tourbo.listAllTour(); 
                        if(listtour!=null){
                        for(int i=0;i<8;i++) {%>

					<div class="post">
						<h2><a href="./" title=""> <%=listtour.get(i).getTourProgram().getTourProgramName() %> </a></h2>
						<p class="postmetadata">Điểm đến: <%=listtour.get(i).getEndplace()  %> Giá tour: <%=listtour.get(i).getBasiccharge()  %></p>
						<div class="entry">
                                                    <% out.print("<img src='"+listtour.get(i).getTourProgram().getItineraries().get(1).getImage()+"'/>"); %>
							<div class="endline"></div>
							<!--<?php the_tags('<p class="tags"><strong>Tags:</strong> ', ', ', '</p>'); ?>-->
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
		<p><a href="http://themes.rock-kitty.net">Wordpress Themes</a> designed and coded by <a href="http://www.ezwpthemes.com/">EZwpthemes</a> | <a href="http://www.2cuk.co.uk">2cuk</a> <?php fflink(); ?></p>
</div>
<!-- footer end -->

</div>
<!-- wrapper end -->

<!--<?php wp_footer(); ?>-->

</body>
</html>

