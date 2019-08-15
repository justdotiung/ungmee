<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/notice/list.css">
<script src="${ctxName}/resource/js/admin/notice.js"></script>
<title>관리자 공지사항 LIST 페이지</title>
</head>

<body>

	<main id="notice">

	<div>
		<li><a href="reg">관리자 등록버튼</a></li>
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
					<div class="content">${n.content}컨텐츠</div>
					<div>
						<a href="del?id=${n.id}">삭제a</a> <a href="edit?id=${n.id}">수정</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

	<template class="notice-template" id="notice-template">
		<section class="notice-template-section">
			<div class="categoryName"></div>
			<div class="writerId"></div>
			<div class="regDate"></div>
			<div class="title"></div>
			<div>
				<input class="btn-detail1" type="button" value="자세히">
			</div>
			<div class="contentc"></div>
			<div>
				<a href="del?id=${n.id}">삭제a</a> <a href="edit?id=${n.id}">수정</a>
			</div>
		</section>
	</template>

	<!-- <section class="page-index">
		<h1 class="d-none">페이지 정보</h1>

		<div>
			<span class="color-highlight font-bold">1</span>/ 1 pages
		</div>
	</section>

	<section id="pager">
		<h1 class="d-none">페이지</h1>
		<div>
			<div class="icon-prev-pager">이전</div>
			<ul>
				<li><a href="list?p=1">1</a></li>
				<li class="current"></li>
				<li><a href="list?p=2">2</a></li>
				<li><a href="list?p=3">3</a></li>
				<li><a href="list?p=4">4</a></li>
				<li><a href="list?p=5">5</a></li>
			</ul>
			<div class="icon-next-pager">다음</div>
		</div>
	</section> -->



	</main>
</body>
</html>