<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice/filelist.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h3>파일 목록 입니다.</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>제목</th>
				<th>파일명</th>
				<th>파일크기</th>
				<th>다운횟수</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.id }</td>
				<td>${tmp.title }</td>
				<td><a href="download?id=${tmp.id }">${tmp.orgFileName }</a></td>
				<td>${tmp.fileSize }</td>
				<td>${tmp.downCount }</td>
				<td>${tmp.regdate }</td>
				<td>
				<c:if test="${tmp.writer eq id }">
					<a href="javascript: deleteConfirm(${tmp.id })">
						<i class="glyphicon glyphicon-trash"></i>
						<span class="sr-only">삭제</span>
					</a>
				</c:if>
				</td>
			</tr>		
		</c:forEach>
		</tbody>
	</table>
	<a href="upload_form">자료실 업로드 하기</a>
	
	<div class="page-display">
		<ul class="pagination">
		<c:choose>
			<c:when test="${startPageNum ne 1 }">
				<li>
					<a href="list?pageNum=${startPageNum-1 }&condition=${condition }&keyword=${encodedKeyword}">
						&laquo;
					</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="disabled">
					<a href="javascript:">&laquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" 
			end="${endPageNum }" step="1">
			<c:choose>
				<c:when test="${i eq pageNum }">
					<li class="active"><a href="list?pageNum=${i }&condition=${condition }&keyword=${encodedKeyword}">${i }</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="list?pageNum=${i }&condition=${condition }&keyword=${encodedKeyword}">${i }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${endPageNum lt totalPageCount }">
				<li>
					<a href="list?pageNum=${endPageNum+1 }&condition=${condition }&keyword=${encodedKeyword}">
						&raquo;
					</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="disabled">
					<a href="javascript:">&raquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>
	
	<!-- keyword 검색어 form -->
	<form action="${pageContext.request.contextPath}/file/list" method="post">
		<label for="condition">검색조건</label>
		<select name="condition" id="condition">
			<option value="titlename" <c:if test="${condition eq 'titlename' }">selected</c:if> >제목+파일명</option>
			<option value="title" <c:if test="${condition eq 'title' }">selected</c:if>>제목</option>
		</select>
		<input type="text" value="${keyword }" name="keyword" 
			placeholder="검색어..."/>
		<button type="submit">검색</button>
	</form>
	<c:choose>
		<c:when test="${not empty keyword }">
			<p><strong>${keyword }</strong> 검색어로 검색된 
			<strong>${totalRow }</strong>개의 파일이 있습니다.</p>
		</c:when>
		<c:otherwise>
			<p><strong>${totalRow }</strong>개의 파일이 있습니다.</p>
		</c:otherwise>
	</c:choose>	
</div> <!-- /.container -->
<script>
	function deleteConfirm(num){
		var isDelete=confirm(num+" 번 글을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="delete?num="+num;
		}
	}
</script>
</body>
</html>
















