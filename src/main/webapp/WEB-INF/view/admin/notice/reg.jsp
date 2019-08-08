<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공지사항 REG 페이지</title>
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">

<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/notice/reg.css">
<script src="${ctxName}/resource/lib/editor/editor.js"></script>
<script>
window.addEventListener("load",function(){
	var editor = new Editor("../../resource/lib/editor", ".textarea");
	var editor2 = new Editor("../../resource/lib/editor", ".textarea2");
});

</script>
</head>
<main>
<form action="reg?${_csrf.parameterName}=${_csrf.token}" method="post"
	enctype="multipart/form-data">
	<div class="regform">

		<select name="category">
			<option value="공지사항">공지사항</option>
			<option value="사내이벤트">사내이벤트</option>
			<option value="외부이벤트">외부이벤트</option>
		</select>

		<div>${n.regdate}</div>
		<div class="title">
			<input name="title" placeholder="제목 입력할꺼지?">
		</div>
		<div class="file">
			<input type="file" name="file">파일첨부
		</div>
		<div class="content">
			<textarea class="textarea"
				style="width: 100%; height: 300px; border: 1px solid gray;"></textarea>

		</div>
		
		<textarea class="textarea2"
				style="width: 100%; height: 300px; border: 1px solid gray;"></textarea>
</form>
<div class="button-box">
	<input type="submit" value="저장"> <a href="list">취소</a>
</div>




</main>
</html>
