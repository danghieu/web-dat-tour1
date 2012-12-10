<%-- 
    Document   : Ads
    Created on : Dec 10, 2012, 4:54:37 PM
    Author     : AT
--%>

<%@page import="javabean.AdsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.AdsBO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% AdsBO adsBO=new AdsBO(); 
    ArrayList<AdsBean> listAds= new ArrayList<AdsBean>();
    listAds=adsBO.listAllAds();
    if(listAds!=null){
        for(int i=0;i<listAds.size();i++) {
            AdsBean ads=listAds.get(i);
        
%>
<div class="ads" >
    <a href="<%= ads.getLink() %>"><img src="<%= ads.getImage() %>" alt="<%= ads.getCaption() %>" style="max-width:200px;max-height: 400px; padding-left: 70px;"/></a>
</div>
    <br />
<%} }%>
