<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!-- 자체 css -->
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/layout.css">
<!-- 부트스트랩 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${ctxName}/resource/bootstrap/js/bootstrap.min.js"></script>
<link href="${ctxName}/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Document</title>
</head>
<body>
	<!-- header -->
	<tiles:insertAttribute name="header" />
	<!-- main -->
	<div id="layuout-main">
		<!--사이드 메뉴 오픈버튼-->
	     <div class="right">
	        <a href="javascript:void(0)" id="open_sidebar" onclick="sidebar_open()">
	        	<img src="${ctxName}/resource/images/icon/adminaside.png"></a>
	     </div>
		<div id="layout-aside">
			<!-- aside -->
			<tiles:insertAttribute name="aside"/>
		</div>
		<div id="layout-main">
			<!-- body -->
			<tiles:insertAttribute name="main" />
		</div>
	</div>
	<!-- footer -->
	<tiles:insertAttribute name="footer" />
	
	<!-- 사이드바 감추기 나타내기 -->
	<script>
     var sidebar = document.getElementById("layout-aside");

     function sidebar_open() {
         "use strict";
         if (sidebar.style.display === 'block') {
             sidebar.style.display = "none";
          } else {
             sidebar.style.display = 'block';
         }
     }          

     function sidebar_close() {
          sidebar.style.display = "none"; 
      }
</script>
</body>
</html>