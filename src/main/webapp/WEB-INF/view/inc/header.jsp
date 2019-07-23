<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/inc/header.css">
<link rel="stylesheet" type="text/css" href="/resource/css/reset.css">
</head>
<body>
	<div>
		<a href="/index"><img src="/resource/images/ummo/logo.jpg"></a>
	</div>
	<div class="member-state">
		<ul>
			<li><a href="/guest/login">로그인</a></li>
			<li><a href="/guest/signup">회원가입</a></li>
			<li><a href="/couple/diary/index">커플페이지</a></li>
			<li><a href="/couple/info/edit">정보수정</a></li>
			<li><a href="/member/logout">로그아웃</a></li>
			<li><a href="/admin/index">관리자페이지</a></li>
			<li><a href="/member/withdraw">회원탈퇴</a></li>
		</ul>
	</div>
	<nav>
		<ul>
			<li><a href="/course/list?type=who">CourseWho</a></li>
			<li><a href="/course/list?type=what">CourseWhat</a></li>
			<li><a href="/course/list?type=where">CourseWhere</a></li>
			<li><a href="/course/list?type=search">CourseSearch</a></li>
		</ul>
	</nav>
	<div id="weather">
		<a href="">날씨API</a><img
			src="/resource/images/img/2x/baseline_cloud_black_18dp.png">
	</div>
	<div>
		현재 서울은 개맑음 
	</div>

</body>
</html>