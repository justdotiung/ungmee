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
<script src="${ctxName}/resource/js/inc/header.js"></script>

</head>
<body>
	<div>
		<a href="${ctxName}/index"><img	src="${ctxName}/resource/images/ummo/logo.jpg"></a>
	</div>

	<div class="member-state">
		<div>
		<security:authorize access="!isAuthenticated()">
			<a href="${ctxName}/login">로그인</a>			
			<a href="${ctxName}/signup">회원가입</a>
		</security:authorize>
		</div>
		<div class="member-info">
		<security:authorize access="isAuthenticated()">
			<div>
			<security:authorize access="hasRole('USER')">
				<c:if test="${user.cState eq '1' }">
				<a href="${ctxName}/user/couple/index">커플페이지</a>
				</c:if>
				<a href="${ctxName}/user/detail">정보수정</a>
				<a href="${ctxName}/user/alert/list" class="toggle">알람</a>
				<c:if test="${count > 0}">
				<span>new${count}</span>
				</c:if>
			</security:authorize>
		 	<security:authorize access="hasRole('ADMIN')"> 
				<a href="${ctxName}/admin/index">관리자페이지</a>
			</security:authorize> 
			</div>
			<div>
				<form action="${ctxName}/logout" method="post">
					<input type="submit" value="로그아웃">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>		
			</div>
		</security:authorize>
		</div>
	</div>
	<div id="alert-list" class="d-none">
	<c:if test="${count > 0}">
		11
	</c:if>
	
	<c:if test="${count == 0}">
		내용이 없습니다.11
	</c:if>
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