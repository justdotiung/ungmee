<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
	<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/notice/edit.css">
<script src="${ctxName}/resource/js/admin/notice.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공지사항 EDIT 페이지</title>
</head>


<body>
	<main id="notice">
	<form action="edit?${_csrf.parameterName}=${_csrf.token}" method="post">
		<input type="hidden" name="id" value="${notice.id}">
		<div class="notice-list">
			<select name="categoryId">
					<option value="1">회원공지사항</option>
					<option value="2">제휴사공지사항</option>
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