<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
	<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/notice/list.css">
<script src="${ctxName}/resource/js/admin/notice.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공지사항 EDIT 페이지</title>
</head>


<body>
	<main id="notice">
	<form action="edit" method="post">
		<input type="hidden" name="id" value="${notice.id}">
		<div class="notice-list">
			<select name="category">
					<option value="공지사항">공지사항</option>
					<option value="사내이벤트">사내이벤트</option>
					<option value="외부이벤트">외부이벤트</option>
				</select>
			<div>${notice.regDate}</div>
			<div><input type="text" name="title" value="${notice.title}"/></div>
			<div class="content"><input type="text" name="content" value="${notice.content}"/></div>
		</div>
		<a href="list">이전</a>
		<button type="submit" value="저장"></button>
	</form>
	</main>
</body>
</html>