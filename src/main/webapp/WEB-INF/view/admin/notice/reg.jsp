<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/reset.css">
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/admin/notice/reg.css">
<script src="${ctxName}/resource/js/admin/notice/reg.js"></script>
<script src="${ctxName}/resource/lib/SmartEditor/js/HuskyEZCreator.js"></script>


<section>
	<form action="reg?${_csrf.parameterName}=${_csrf.token}" method="post"
		enctype="multipart/form-data">
		<div class="regform">
			<select name="categoryId" >
				<option value="1">회원공지사항</option>
				<option value="2">제휴사공지사항</option>
			</select>
	
			<div>${time}</div>
			<div>${writer}</div>
			<div class="title">
				<input name="title" placeholder="제목 입력할꺼지?">
			</div>
			<div>
				<textarea id="content" name="content"
					style="width: 100%; height: 300px; display: none"></textarea>
			</div>
		</div>
	<div class="button-box">'
		<input type="submit" class="save-btn" value="저장"> <a href="list">취소</a>
	</div>
	</form>
	<input type="hidden" class="ctx" value="${ctxName}">
</section>


