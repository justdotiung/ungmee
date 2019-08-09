<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/inc/header.css">

</head>
<body>
	<div>

		<a href="${ctxName}/index"><img
			src="${ctxName}/resource/images/ummo/logo.jpg"></a>

	</div>
	
	for(공지목록)
	<tr></tr>
	
	for(이벤트목록)
	<tr></tr>
	
	
	
	<div class="member-state">
		<ul>
			<security:authorize access="!isAuthenticated()">
			<li><a href="${ctxName}/login">로그인</a></li>			
			<li><a href="${ctxName}/signup">회원가입</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<security:authorize access="hasRole('USER')">
				<li><a href="${ctxName}/user/detail">정보수정</a></li>
				<li><a href="${ctxName}/user/couple/index">커플페이지</a></li>
				<li><a href="${ctxName}/user/message">알림${couple.proposeList }</a></li>
				<li><a href="${ctxName}/member/withdraw">회원탈퇴</a></li>			
				</security:authorize>
				<security:authorize access="hasRole('ADMIN')">
					<li><a href="${ctxName}/admin/index">관리자페이지</a></li>
				</security:authorize>
				<li>
					<form action="${ctxName}/logout" method="post">
						<input type="submit" value="로그아웃">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</li>
			</security:authorize>
		</ul>
	</div>
	<nav>
		<ul>
			<li><a href="${ctxName}/course/list?type=who">CourseWho</a></li>
			<li><a href="${ctxName}/course/list?type=what">CourseWhat</a></li>
			<li><a href="${ctxName}/course/list?type=where">CourseWhere</a></li>
			<li><a href="${ctxName}/course/list?type=search">CourseSearch</a></li>
		</ul>
	</nav>
	<div id="weather">
		<a href="">날씨API</a><img
			src="${ctxName}/resource/images/img/2x/baseline_cloud_black_18dp.png">
	</div>
	<div>현재 서울은 개맑음</div>

</body>
</html>