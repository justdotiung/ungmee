<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/notice/list.css">
<script src="${ctxName}/resource/js/admin/notice/list.js"></script>

<div id="notice">
	<div id="notice-btn">
		<div class="notice-division">
			<ul>
				<li><a href="reg">회원</a></li>
				<li><a href="reg">제휴사</a></li>
			</ul>
		</div>
		<div class="notice-reg">
			<a href="reg">관리자 등록버튼</a>
		</div>
	</div>
	
	<section id="reg-notice">
		<div class="notice-lists" id="notice-lists">
			<c:forEach var="n" items="${noticeView}">
				<div class="notice-list">
					<div>${n.categoryName}</div>
					<div>${writer}</div>
					<div>${time}</div>
					<div>${n.title}</div>
					<div>
						<input class="btn-detail" type="button" value="자세히">
					</div>
					<div class="content">${n.content}</div>
					<div>
						<a href="del?id=${n.id}">삭제a</a> <a href="edit?id=${n.id}">수정</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	
	<section id="reg-notice">
		<div class="notice-lists" id="notice-lists">
			<c:forEach var="n" items="${noticeView}">
				<div class="notice-list">
					<div>${n.categoryName}</div>
					<div>${writer}</div>
					<div>${time}</div>
					<div>${n.title}</div>
					<div>
						<input class="btn-detail" type="button" value="자세히">
					</div>
					<div class="content">${n.content}</div>
					<div>
						<a href="del?id=${n.id}">삭제a</a> <a href="edit?id=${n.id}">수정</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</div>

