<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/event/edit.css">
<script src="${ctxName}/resource/js/admin/event.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 이벤트  EDIT 페이지</title>
</head>


<body>
	<main id="event">
	<form action="edit?${_csrf.parameterName}=${_csrf.token}" method="post">
		<input type="hidden" name="id" value="${event.id}">
		<div class="event-list">
			<select name="category">
					<option value="공지사항">공지사항</option>
					<option value="사내이벤트">사내이벤트</option>
					<option value="외부이벤트">외부이벤트</option>
				</select>
			<div>${event.regDate}</div>
			<div><input type="text" name="title" value="${event.title}"/></div>
			<div class="content"><input type="text" name="content" value="${event.content}"/></div>
		</div>
		<a href="list">이전</a>
		<button type="submit" value="저장"></button>
	</form>
	</main>
</body>
</html>