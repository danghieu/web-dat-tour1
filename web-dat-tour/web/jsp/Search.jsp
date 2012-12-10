<%-- 
    Document   : Register
    Created on : Oct 28, 2012, 3:15:54 PM
    Author     : Karl
--%>
<%@page import="java.util.Date"%>
<%@page import="javabean.TourProgramBean"%>
<%@page import="bo.TourBO"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<form name="searchform" action="<%=request.getContextPath()%>/jsp/SearchResult.jsp" method="POST">
    <%TourBO searchBO= new TourBO(); 
ArrayList listStartplace=new ArrayList();
ArrayList listEndplace=new ArrayList();
listStartplace=searchBO.list("startplace");
listEndplace=searchBO.list("endplace");
                               %>
 <table width="200" border="0" cellpadding="0" cellspacing="0" id="textForm" align="center">                                        
    <tbody><tr>
        <td height="25">                              
            <h2>Tìm kiếm</h2></td></tr></tbody></table>
<table width="200" border="0px" cellpadding="0" cellspacing="0" id="textForm" align="center">                                         
            <tbody><tr>
                <td height="25" width="50">
                    Nơi khởi hành
                </td>
                <td width="120px">
                    <select name="NoiKhoiHanh" id="_cboNoiKhoiHanh" style="PADDING-LEFT:3px; WIDTH:140px; FONT-SIZE:11px">
                        <%if(listStartplace!=null) {for(int i=0;i<listStartplace.size();i++) {%><option value="<%=listStartplace.get(i) %>"><%=listStartplace.get(i) %></option>
                        <%}}%>
                    </select>                                                
                </td>
            </tr>
            <tr>
                <td height="25" width="45">
                    Nơi đến
                </td>
                <td>
                    <select name="NoiDen" id="_cboNoiDen" style="PADDING-LEFT:3px; WIDTH:140px; FONT-SIZE:11px">
                        <%if(listEndplace!=null) {for(int i=0;i<listEndplace.size();i++) {%><option value="<%=listEndplace.get(i) %>"><%=listEndplace.get(i) %></option>
                        <%}}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td height="25" width="45">
                    Giá
                </td>
                <td>
                    <div id="PriceDiemDenDM" align="left" style="display:block"><span id="_lbGiaTourDM"><select name="Gia" style="PADDING-LEFT:3px; WIDTH:110px; FONT-SIZE:11px"><option value="0"> --- </option><option value="1">Dưới 1 Triệu</option><option value="2">  1-5  Triệu</option><option value="3">  5-10 Triệu</option><option value="4">  10-15 Triệu</option><option value="5">  15-20 Triệu</option><option value="6">Trên 20 Triệu</option></select></span>&nbsp;(VNĐ)</div>
                </td>
            </tr>
            <tr>
                <td height="25" width="45">
                    Ngày đi
                </td>
                <td height="25">
                    <select name="date" id="_cboNgay" style="PADDING-LEFT:3px; WIDTH:33px; FONT-SIZE:11px">
                        <%for(int i=1;i<=31;i++){%><option value="<%=i%>"><%=i%></option><%}%>

                    </select>
                    <select name="month" id="_cboThang" style="PADDING-LEFT:3px; WIDTH:33px; FONT-SIZE:11px">
                        <%for(int i=1;i<=12;i++){%><option value="<%=i%>"><%=i%></option><%}%>
                    </select>
                    <select name="year" id="_cboYear" style="PADDING-LEFT:3px; WIDTH:50px; FONT-SIZE:11px">
                        <% java.util.Date d=new java.util.Date();for(int i=(d.getYear()+1900) ;i<(d.getYear()+1900)+5;i++){%><option value="<%=i%>"><%=i%></option><%}%>

                    </select>
                </td>
            </tr>                                     
        </tbody></table>
                        <br />
                        <table width="200" border="0" cellpadding="0" cellspacing="0" id="textForm" align="center">                                        
            <tbody><tr>
                <td width="100%" height="25" align="center">
                    <input type="image" name="btnSearch" id="_btnSearch" src="<%=request.getContextPath()%>/images/search_button.png" style="border-width:0px;"/>
                </td>
                </tr></tbody></table>
                <br />
</form>
                

