<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<link href="${ctxName}/resource/css/admin/index.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	여러가지 통계 상황 을 나타내면 좋을거같다.
	</div>
	<div class="upper">
	 <section id="event">
         <div class="add"><a href="/notice/list">더보기</a></div>
	       	<div class="list">
	       		<div class="flex-items">
	        		<a href=""><img src="">이벤트게시글</a>
	       		</div>
       	</div>
      </section>
      	 <section id="notice">
         <div class="add"><a href="/notice/list">더보기</a></div>
	       	<div class="list">
	       		<div class="flex-items">
	        		<a href=""><img src="">공지게시글</a>
	       		</div>
       	</div>
      </section>
      </div>
      
      <div class="down">
	  <section id="couple">
         <div class="add"><a href="/notice/list">더보기</a></div>
	       	<div class="list">
	       		<div class="flex-items">
	        		<a href=""><img src="">커플관리</a>
	       		</div>
       	</div>
      </section>
      	 <section id="partner">
         <div class="add"><a href="/notice/list">더보기</a></div>
	       	<div class="list">
	       		<div class="flex-items">
	        		<a href=""><img src="">제휴사관리</a>
	       		</div>
       	</div>
      </section>
      </div>     		
</body>
</html>

