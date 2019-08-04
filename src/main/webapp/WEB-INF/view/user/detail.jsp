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
			<img class="profile" src="${ctxName }/upload/${user.profile}">
			<input class ="d-none" type="file" name ="file" >
			<input type="button" value="프로필변경">
		</div>
		<div id="nickname">
			<span>닉네임</span>
			<input type="text" value="${user.nickName }">
			<img class="eraser" src="${ctxName }/resource/images/icon/eraser.png">
		</div>
		<div>
			<span>아이디</span>
			<span>${user.email }</span>
		</div>
		<div id="change">
			<div class="chage-button">
				<span>비밀번호 변경</span>
			</div>
			<div class="d-none">
				<ul>
					<li><label>비밀번호</label><input type="password" class="pw-button"></li>
					<li><label>비밀번호 확인</label><input type="password" class="pw-button1"></li>
					<li><span class="error"></span></li>
					<li><input type="button" value="변경하기"></li>
				</ul>
			</div>
		</div>
		<div id="couple-state">
			<span>커플상태 </span><span>${user.cState}</span>
			<input type="button" name="propose" value="신청하기">
			<input type="button" name="leave" value="헤어지기"> 
			<a href="propose">신청하기</a>			
		</div>
		
		<div id="event-check">
			<span>이벤트</span>
			<span class="event-state">${user.echeck }</span>
			<input type="hidden" value="${user.echeck }">
			<input type="button" value="변경하기">
		</div>
		
		<div>
			<span>가입일</span>
			<span>
				<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${user.regDate}"/>
			</span>
		</div>
			<input type="hidden" name = "header" value="${_csrf.headerName}"> 
			<input type="hidden" name = "token" value="${_csrf.token}"> 
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
