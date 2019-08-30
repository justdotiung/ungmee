<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/root/login.css">
<script src="${ctxName}/resource/js/root/login.js"></script>

<section id="main">
	<section class="login-form">
		<h1 class="d-none">로그인 폼</h1>
		<div class="api-login">
			<ul>
				<li>
					<a href="https://kauth.kakao.com/oauth/authorize?client_id=142c1874f0e3f2e854e05c6e992adf26
							&redirect_uri=http://localhost:8080${ctxName}/kakao-login
							&response_type=code">
						<img src="${ctxName}/resource/images/icon/kakaolink_btn.png">
					</a>
				</li>
				<li><a href="facebook"><img src="">페이스북</a></li>
				<li><a href="naver"><img src="">네이버</a></li>
			</ul>
		</div>
		<div class="login-form">
			<form action="login" method="post">
				<input type="text" name="username" placeholder="이메일주소">
				<input type="password" name="password" placeholder="비밀번호">
				 ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 				<input type="submit" value="로그인" class = "login-button">
			</form>
		</div>
	</section>

	<div class="logo">
		<a href="index"><img
			src="${ctxName}/resource/images/ummo/logo.jpg"></a>
	</div>
</section>
