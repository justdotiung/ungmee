<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스등록페이지</title>
</head>
<body>
	<div>코스등록 페이지
		<form action="reg" method="post">
		 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="등록하기">
		</form>
	</div>
</body>
</html>