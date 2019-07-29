<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="aside">
		<div>
			<ul>
				<li><a href="${ctxName }/admin/member/list">회원관리</a></li>
				<li>파트너 관리</li>
				<li>이벤트</li>
				<li>커플</li>
				<li><a href="${ctxName }/admin/notice/list">공지사항</a></li>
			</ul>
		</div>
	</section>
</body>
</html>