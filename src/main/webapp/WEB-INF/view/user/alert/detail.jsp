<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/reset.css">
<title>Insert title here</title>
</head>
<body>
	<div>
		<ul>
			<li>
				<span></span>
			</li>
			<li>
				<span>커플명 : </span><span>${couple.coupleName }</span>
			</li>
			<li>
				<span>커플소개 : </span><span>${couple.message }</span>
			</li>
			<li>
				<span>사랑에 빠진날 : </span>
				<span><fmt:formatDate pattern="YYYY-MM-dd" value="${couple.loveDate }"/></span>
			</li>
			<li>
				<button>수락하기</button><span>&nbsp; or &nbsp;</span><button>yes</button>
			</li>
			<li>
				<button>거절하기 ㅠ</button>
			</li>
		</ul>
			<input type="hidden" value = "${couple.id }">
	</div>
</body>
</html>