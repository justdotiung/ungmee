<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
	<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/notice/list.css">
<script src="${ctxName}/resource/js/admin/notice.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공지사항 LIST 페이지</title>
</head>


<body>
	<main id="notice">
	<div>
		<li><a href="reg">관리자 등록버튼</a></li>
	</div>

	<div>
		<div class="notice-lists">
			<c:forEach var="n" items="${notice}">
				<div class="notice-list">
					<div>${n.category}</div>
					<div>${n.regDate}</div>
					<div>${n.title}</div>
					<div>
						<input class="btn-detail" type="button" value="자세히">
					</div>
					<div class="content">${n.content}</div>
					<div>
					<form action="del" method="post">
						<input type="hidden" name="did" value="${n.id}"> 
						<input type="submit" value="삭제">
					</form>
						<a href="edit?eid=${n.id}">수정</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</main>
</body>
</html>