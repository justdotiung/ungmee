<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />


<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/inc/header.css">
<script src="${ctxName}/resource/js/inc/header.js"></script>

	<div class="page-header index">
	  <h1><a href="${ctxName}/index">PlanD</a><small>데이트 짜고 갈래?</small></h1>
	  
	  <div class="icon-bar">
	  <security:authorize access="!isAuthenticated()">
				<span class="glyphicon glyphicon-search"><a href="${ctxName}/course/list?type=search">검색</a></span>
				<span class="glyphicon glyphicon-log-in"><a href="${ctxName}/login">로그인</a></span>		
				<span class="glyphicon glyphicon-user"><a href="${ctxName}/signup">회원가입</a></span>	
		</security:authorize>
		</div>
	</div>
	<div id="member-state">
		<div id="member-info">
		<security:authorize access="isAuthenticated()">
			<div>
			<security:authorize access="hasRole('USER')">
				<a href="${ctxName}/course/list">코스보기</a>
				<c:if test="${user.cState eq '1' }">
				<button class="couple-btx">커플정보</button>
				</c:if>
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
				<a href="${ctxName}/user/detail">정보수정</a>
					<input type="submit" value="로그아웃">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>		
			</div>
		</security:authorize>
		</div>
	</div>
	<div class="couple-info-toggle d-none">
		<a href="${ctxName}/couple/info/index">커플페이지</a>
		<a href="${ctxName}/couple/info/detail">커플정보 수정</a>
		<a href="${ctxName}/couple/info">우리만의 비밀글</a>
		<a href="${ctxName}/couple/info">스케줄러</a>
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
		<ul class="nav nav-pills">
		  <li role="presentation" class="active"><a href="${ctxName}/course/list?type=who">DateDeal</a></li>
		  <li role="presentation"><a href="${ctxName}/course/list?type=what">DateCourse</a></li>
		  <li role="presentation"><a href="${ctxName}/course/list?type=where">DateMap</a></li>
		  <li role="presentation"><a href="${ctxName}/course/list?type=search">DateSearch</a></li>
		</ul>
	</nav>

