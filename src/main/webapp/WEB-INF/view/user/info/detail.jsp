<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<img src="">
			<input type="file">
			<input type="button" value="프로필변경">
		</div>
		<div>
			<span>닉네임</span>
			<input type="text">
			<input type="button" value="닉네임변경">
		</div>
		<div>
			<span>아이디</span>
			<span>c1c@.com</span>
		</div>
		<div>
			<span>비밀번호</span>
			<input type="button" value="변경하기">
		</div>
		<div>
			<span>커플상태</span>
			<input type="button" value="신청하기">
		</div>
		<div>
			<span>이벤트</span>
			<span>동의</span>
			<input type="button" value="변경하기">
		</div>
		<div>
			<span>가입일</span>
			<span>2010.01.01</span>
		</div>
		<div>
			<span>핸드폰</span>
			<span>010-000-000</span>
			<input type="button" value="변경하기">
		</div>
		<div>
			 <a href="${ctxName}/index">탈퇴하기</a>
		</div>
	</div>
</body>
</html>