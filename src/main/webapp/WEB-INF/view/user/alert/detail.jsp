<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<script src="${ctxName}/resource/js/user/alert/detail.js"></script>
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/reset.css">
<section id="section">
	<div>
		<img src="${ctxName }/upload/${user.profile}">
	</div>
	<div>
		<ul>
			<li>
				<p><b>${cUser.nickname }</b>님이 커플맺기를 신청하셨습니다.</p>
			</li>
			<li>
				<button	class="accept">수락하기</button><span>&nbsp; or &nbsp;</span><button class="accept">yes</button>
			</li>
			<li>
				<button class="refuse">거절하기 ㅠ</button>
			</li>
		</ul>
	</div>
	<input type="hidden" class ="cid" value="${cUser.id }" >
	<input type="hidden" class="ctx-name" value="${ctxName }">
	<input type="hidden" class = "header" value="${_csrf.headerName}"> 
   	<input type="hidden" class = "token" value="${_csrf.token}"> 
</section>	

