<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>


<link href="${ctxName }/resource/css/couple/info/detail.css" type="text/css" rel="stylesheet">
<script src="${ctxName }/resource/js/couple/info/detail.js"></script> 
<script src="${ctxName}/resource/lib/modal/modal.js"></script>
<body>
	<section id="section">
		<div id="couple-profile">
		<c:choose>
			<c:when test="${empty couple.info.profile}">
			<img class="profile" src="${ctxName }/resource/images/icon/profile.png">
			</c:when>
			<c:when test="${!empty couple.info.profile}">
			<img class="profile" src="${ctxName }/upload/${couple.info.profile}">
			</c:when>
		</c:choose>
			<input class ="d-none" type="file" name ="file" >
		</div>
		<div id="couple-name">
			<input type="text" name="name" value="${couple.info.name }">
			<button class="name-update">
				<img class="pencil" src="${ctxName }/resource/images/icon/pencil.png">
			</button>
		</div>
		<div id="couple-message">
			<input type="text" name="message" value="${couple.info.message }">
			<button class="message-update">
				<img class="pencil" src="${ctxName }/resource/images/icon/pencil.png">
			</button>
		</div>
		<div>
			<span>사귄날</span>
			<span>
				<fmt:formatDate pattern="yyyy년MM월dd일" value="${couple.info.ask}"/>
			</span>
		</div>
		<div>
			<span>오늘까지${couple.date }일</span>
		</div>
			<input type="hidden" class = "header" value="${_csrf.headerName}"> 
			<input type="hidden" class = "token" value="${_csrf.token}"> 
			<input type="hidden" class = "ctx-name" value="${ctxName}"> 
		<div>
			<button class="couple-delete">커플끊기</button>
		</div>
	</section>
</body>
