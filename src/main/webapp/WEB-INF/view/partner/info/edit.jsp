<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="/resource/css/reset.css"> -->
<link rel="stylesheet" type="text/css" href="/resource/css/couple/edit.css">
<script src="/resource/js/couple/edit.js"></script>
</head>
<body>
	<!--header -->
	<jsp:include page="../../inc/header.jsp" />
	
	<!--body -->
	<section id="myinfo">
		<div>
			<ul>
				<li><span>아이디(이메일) : c1@c.com</span></li>
				<li><span>회원등급 : 데잘알</span></li>
				<li><span>가입일 : 2018.01.01</span></li>
				<li><span>사랑에빠진날 :</span><input type="date" value="2018-01-01" name="s-date"></li>
				<li><span>핸드폰 :</span><input type="text" value="01000000000" name="phonenumber"></li>
				<li>
					<span>이벤트 SNS</span>
					<input type="radio" checked="checked" name="agree" value="agree"><label>동의</label>
					<input type="radio" checked="checked" name="disagree" value="disagree"><label>거부</label>
				</li>
			</ul>
		</div>
	
		<div>
			<div>프로필사진</div>
			<input type="file" class="d-none">
			<div class="triggerButton">프로필변경</div>
			<div>커플명</div>
			<input type="button">
		</div>
		
		<div>
			<a href="edit">수정하기</a> <a href="/index">탈퇴하기</a>
		</div>
	</section>
	<!--footer-->
	<jsp:include page="../../inc/footer.jsp" />

</body>
</html>