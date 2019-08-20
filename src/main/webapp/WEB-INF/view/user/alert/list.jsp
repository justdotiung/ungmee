<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<c:set var="li" value="${list }"/>
<link href="${ctxName }/resource/css/reset.css" type="text/css" rel="stylesheet">
<link href="${ctxName }/resource/css/alert/alert.css" type="text/css" rel="stylesheet">
<script src="${ctxName }/resource/js/alert/alert.js"></script>
<body>
	<div id="div">
		<div>
			<ul id="tab">
				<li><a href="#couple">커플</a></li>
				<li><a href="#event">이벤트</a></li>
			</ul>	
		</div>
		<div id="couple-list" class="d-none current">
		<c:choose>
			<c:when test="${empty li}">
			<div>
				<span> 새로운 알림이 없습니다. </span>
			</div>
			</c:when>
			<c:when test="${!empty li }">
			<div>
				<ul>
				<c:forEach var="i" items="${li}">
					<li>
						<a href="../sender?id=${i.senderId }"><img class="profile" src="${ctxName }/upload/${i.profile}"></a>
						<a href="detail?id=${i.id}">${i.writer}님이 프러포즈를 신청하셨습니다.</a>
						<span><fmt:formatDate pattern="MM월dd일HH시mm분" value="${i.regDate}"/></span>
					</li>
				</c:forEach>
				</ul>		
			</div>
			</c:when>
		</c:choose>
		</div>
		<div id="event-list" class="d-none">
			<div>
				<ul>
					<li>이벤트 1</li>
					<li>이벤트 2</li>
					<li>이벤트 3</li>
				</ul>		
			</div>
		</div>
	</div>
</body>
