<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<link href="${ctxName }/resource/css/user/detail.css" type="text/css" rel="stylesheet">
<script src="${ctxName }/resource/js/user/detail.js"></script>
<body>
	<div>
		<div id="profile">
			<img class="profile" src="${ctxName }/resource/images/png/profile.png">
			<input type="file" name ="file" class="d-none">
			<input type="button" value="프로필변경">
		</div>
		<div>
			<span>닉네임</span>
				<input type="text" value="${user.nickName }">
			<input type="button" value="닉네임변경">
		</div>
		<div>
			<span>아이디</span>
			<span>${user.email }</span>
		</div>
		<div class="pw">
			<span>비밀번호</span>
			<input type="button" value="변경하기">
		</div>
		<div class="couple-state">
			<span>커플상태 </span><span>${user.cState}</span>
			<input type="button" value="신청하기">
		</div>
		<div class="event-check">
			<span>이벤트</span>
			<span>동의</span>
			<input type="button" value="변경하기">
		</div>
		<div>
			<span>가입일</span>
			<span>
				<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${user.regDate}"/>
			</span>
		</div>
		<!--
		<div>
			<span>핸드폰</span>
			<span>010-000-000</span>
			<input type="button" value="변경하기">
		</div> 
		-->
		<div>
			 <a href="delete">탈퇴하기</a>
		</div>
	</div>
</body>
