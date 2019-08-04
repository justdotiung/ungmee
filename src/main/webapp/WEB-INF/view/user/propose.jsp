<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>


<link href="${ctxName }/resource/css/user/detail.css" type="text/css" rel="stylesheet">
<script src="${ctxName }/resource/js/user/detail.js"></script> 
<body>
	<div>
	<form method="post">
		<ul>
			<li><label>커플명입력</label><input type="text" name="cName"></li>
			<li><label>상대방이메일 입력</label><input type="text" name="aId"></li>
			<li><label>사랑에빠진날</label><input type="date" name="lovedate"></li>
			<li><label>상태메세지</label><input type="text" name="message"></li>
			<li><input type="submit" value="신청하기"></li>
		</ul>
	</form>
	</div>
</body>
