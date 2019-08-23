<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />


<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/inc/header.css">
<script src="${ctxName}/resource/js/inc/header.js"></script>


<body>
	<div>
		<a href="${ctxName}/index"><img	src="${ctxName}/resource/images/ummo/logo.jpg"></a>
	</div>

	<div id="member-state">
		<div>
		<security:authorize access="!isAuthenticated()">
			<a href="${ctxName}/login">로그인</a>			
			<a href="${ctxName}/signup">회원가입</a>
		</security:authorize>
		</div>
		<div id="member-info">
		<security:authorize access="isAuthenticated()">
			<div>
			<security:authorize access="hasRole('USER')">
				<c:if test="${user.cState eq '1' }">
				<a href="${ctxName}/couple/index">커플페이지</a>
				</c:if>
				<a href="${ctxName}/user/detail">정보수정</a>
				<a href="${ctxName}/user/alert/list" id="user-alert-toggle">알람</a>
				<c:if test="${count > 0}">
				<span class="new-alert">new${count}</span>
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
	<div class="alert-box d-none">
	<c:if test="${count >0}">
		<div class="new-table">
			<table class="alam-table">
			<c:forEach var="i" items="${list}">
				<tr>			
					<td><a href="${ctxName}/user/alert/sender?id=${i.sender }"><img class="profile" src="${ctxName }/upload/${i.profile}"></a></td>
					<td>
						<a class ="alam-title" href="${ctxName}/user/alert/detail?t=${i.type}&n=${i.id}">${i.title}</a>
					</td>
					<td><span><fmt:formatDate pattern="HH시mm분" value="${i.regDate }"/></span></td>
				</tr>
				<input type="hidden" value="${i.id }">
			</c:forEach>
			</table>
		</div>
	</c:if>
	<c:if test="${count == 0}">
		<table class="alam-table">
			<tr>
				<td>
					<span>새로운 알림이 없습니다.</span>
				</td>
			</tr>
		</table>
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
