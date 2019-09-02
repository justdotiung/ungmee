<%@page import="com.ungmee.web.entity.EventFile"%>
<%@page import="java.util.List"%>
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
	href="${ctxName}/resource/css/admin/event/list.css">
<script src="${ctxName}/resource/js/admin/event.js"></script>
<title>관리자 이벤트 LIST 페이지</title>
</head>

<body>
	<main id="event">
	<div>
		<li><a href="reg">관리자 등록버튼</a></li>
	</div>

	<div>
		<div class="event-lists">
			<c:forEach var="n" items="${events}">
				<div class="event-list">
					<input type="hidden" name="id" value="${n.id}">
					<div>${n.category}</div>
					<div>${n.regDate}</div>
					<div>
						<input class="btn-detail" type="button" value="자세히">
					</div>
					<div class="content-box">
						<div class="content">${n.content}</div>
						<div class="file-upload">
							<%
							/* List<EventFile> list = (List<EventFile>)pageContext.getRequest().getAttribute("f");
							out.print(list.get(0) */
							%>
							${f}

							<c:forEach var="f" items="${n.files}">
							<a href="/upload/${f.fileName}" download>${f.fileName}</a>
							</c:forEach>
						</div>
						<div>
					</div>
						<a href="del?did=${n.id}">삭제a</a>
						<a href="edit?eid=${n.id}">수정</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</main>
</body>
</html>