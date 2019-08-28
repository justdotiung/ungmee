<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/root/signup.css">

<div id="map"></div>
<script>
var map;
function initMap(){
	map = new google.maps.Map(document.getElementById('map'),{
		center: {lat: -34.397, lng: 150.644},
		zoom: 8
	});
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAMAJ-Q21r4yLKXQdzwxGMcAHBc0oVWv-c&amp;callback=initMap"></script>
<script src="https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=AIzaSyAMAJ-Q21r4yLKXQdzwxGMcAHBc0oVWv-c">
</script>

<style>
html, body{
margin:0;
padding:0;
height:100%;
}
#map{
	height: 100%;
}
</style>

