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
		<c:choose>
			<c:when test="${empty user.profile}">
			<img class="profile" src="${ctxName }/resource/images/icon/profile.png">
			</c:when>
			<c:when test="${!empty user.profile}">
			<img class="profile" src="${ctxName }/upload/${user.profile}">
			</c:when>
		</c:choose>
		</div>
		<div id="nickname">
			<span>닉네임</span>
			<span>${user.nickname }</span>
		</div>
		<div>
			<span>아이디</span>
			<span>${user.email }</span>
		</div>
		
		<div id="info-div">
			<div>
				<div>커플상태 </div>
				<div>
				<c:choose>
					<c:when test="${user.cState eq 1 }">
						<span>사랑중</span>
					</c:when>
					<c:when test="${user.cState eq 0 or user.cState eq -1}">
						<span class="waiting">사랑대기중입니다.</span>
					</c:when>
				</c:choose>
				</div>
			</div>
		</div>
	</div>
</body>
