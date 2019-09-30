<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />


<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/inc/header.css">
<script src="${ctxName}/resource/js/inc/header.js"></script>
<div>
	<div class="page-header index">
		<div class="menu-list">
			<div>
				<a class="position-logo" style="text-decoration:none" href="${ctxName}/index"><img src="${ctxName}/resource/images/img/logo.png"></a><span class="sub-title">데이트 짜고 갈래?</span>
			</div>
			<div id="member-state">
				<div id="member-nav">
					<ul id="user-menu">
						<security:authorize access="!isAuthenticated()">
						<li><a href="${ctxName}/login" class="login">로그인</a></li>
						<li><a href="${ctxName}/signup">회원가입</a></li>	
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<security:authorize access="hasRole('USER')">
						<c:if test="${user.cState eq '1' }">
						<li>
							<a href="#tab1" class="couple-btn tab-btn">커플정보</a>
							<div id="tab1" class="couple-info-toggle tab d-none">
								<ul>
									<li><a href="${ctxName}/couple/info/index">페이지</a></li>
									<li><a href="${ctxName}/couple/info/detail">수정</a></li>
									<li><a href="${ctxName}/couple/info">비밀글</a></li>
									<li><a href="${ctxName}/couple/info">스케줄러</a></li>
								</ul>
							</div>
						</li>
						</c:if>
						<li>
							<a href="#tab2" class="user-alert-toggle tab-btn">
								알람
								<c:if test="${count > 0}">
								<span class="new-alert">new${count}</span>
								</c:if>
							</a>
							<div id="tab2" class="alert-box tab d-none">
								<ul class="alert-list">
									<li><a href="">커플자님1</a></li>
									<li><a href="">이벤트3</a></li>
									<li><a href="">파트너1</a></li>
									<li><a href="">팔로워0</a></li>
								</ul>
							</div>
						</li>
					 </security:authorize>
				 	<security:authorize access="hasRole('ADMIN')">  
						<li><a href="${ctxName}/admin/index">관리자페이지</a></li>
					 </security:authorize>  
						<li><a href="${ctxName}/user/detail">정보수정</a></li>
						<li><a class="logout-btn" href="${ctxName}/logout">로그아웃</a></li>
					</security:authorize> 
					</ul>
				</div>
			</div>
			<div id="nav-menu">
				<nav id="date-how">
					<ul class="nav nav-pills">
					  <li><a href="${ctxName}/course/list?type=who">DateDeal</a></li>
					  <li><a href="${ctxName}/course/list?type=what">DateCourse</a></li>
					  <li><a href="${ctxName}/course/list?type=where">DateMap</a></li>
					  <li><a href="${ctxName}/course/list?type=search">DateSearch</a></li>
					</ul>
				</nav>
			</div>
		
		</div>
	<input type="hidden" class = "header" value="${_csrf.headerName}"> 
	<input type="hidden" class = "token" value="${_csrf.token}">
	<input type="hidden" class = "ctx" value="${ctxName}">
	</div>
</div>

