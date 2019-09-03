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
				<a class="position-logo" style="text-decoration:none" href="${ctxName}/index"><span id="logo">PlanD</span></a><span class="sub-title">데이트 짜고 갈래?</span>
			</div>
			<div id="member-state">
				<div id="member-nav">
					<ul>
						<security:authorize access="!isAuthenticated()">
						<li><a href="${ctxName}/login">로그인</a></li>
						<li><a href="${ctxName}/signup">회원가입</a></li>	
						</security:authorize>
					<security:authorize access="isAuthenticated()">
						<security:authorize access="hasRole('USER')">
						<c:if test="${user.cState eq '1' }">
						<li><a href="" class="couple-btx">커플정보</a></li>
						</c:if>
						<li><a href="${ctxName}/user/alert/list" id="user-alert-toggle">알람</a></li>
						<c:if test="${count > 0}">
						<li><span class="new-alert">new${count}</span></li>
						</c:if>
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
					  <li role="presentation" class="active"><a href="${ctxName}/course/list?type=who">DateDeal</a></li>
					  <li role="presentation"><a href="${ctxName}/course/list?type=what">DateCourse</a></li>
					  <li role="presentation"><a href="${ctxName}/course/list?type=where">DateMap</a></li>
					  <li role="presentation"><a href="${ctxName}/course/list?type=search">DateSearch</a></li>
					</ul>
				</nav>
				<div id="date-menu">
					<div class="couple-info-toggle d-none">
					<ul>
						<li><a href="${ctxName}/couple/info/index">페이지</a></li>
						<li><a href="${ctxName}/couple/info/detail">수정</a></li>
						<li><a href="${ctxName}/couple/info">비밀글</a></li>
						<li><a href="${ctxName}/couple/info">스케줄러</a></li>
					</ul>
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
				</div>
			</div>
		</div>
	<input type="hidden" class = "header" value="${_csrf.headerName}"> 
	<input type="hidden" class = "token" value="${_csrf.token}">
	<input type="hidden" class = "ctx" value="${ctxName}">
	</div>
</div>

