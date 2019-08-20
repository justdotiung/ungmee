<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
				<button>커플하기</button>
			</li>
			
		</ul>
	</div>
</body>
</html>