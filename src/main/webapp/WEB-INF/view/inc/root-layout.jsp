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
<!-- 부트스트랩 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${ctxName}/resource/bootstrap/js/bootstrap.min.js"></script>
<link href="${ctxName}/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
	<!-- header -->
	<tiles:insertAttribute name="header" />
	<!-- body -->
	<tiles:insertAttribute name="main" />
	<!-- footer -->
	<tiles:insertAttribute name="footer" />
</body>
</html>