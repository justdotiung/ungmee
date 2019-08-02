<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<main>
	<form action="reg?${_csrf.parameterName}=${_csrf.token}" method="post"
		enctype="multipart/form-data">
		<div>
			<ul>
			<li>
				<select name="category">
					<option value="공지사항">공지사항</option>
					<option value="사내이벤트">사내이벤트</option>
					<option value="외부이벤트">외부이벤트</option>
				</select>
			</li>
			<li>${n.regdate}</li>
			<li><input name="title">제목</li>
			<li><input name="content">내용</li>
			<li><input type="submit" value="저장"></li>
			<li><a href="list">취소</a></li>
			</ul>
		</div>
	</form>
</html>
