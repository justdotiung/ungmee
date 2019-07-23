<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- header -->
<%-- <jsp:include page="../../inc/header.jsp"/> --%>
<tiles:insertAttribute name="header"/>
<!-- body -->
<!-- 	<main>
	<section>
		<table>
			<tr>
				<td>공지타입</td>
				<td>공지제족</td>
				<td><a href="detail">펼쳐보기</a></td>
				<td>2019.01.01</td>
			</tr>
		</table>
	</section>
	</main> -->
<!-- footer -->
<%-- <jsp:include page="../../inc/footer.jsp"/> --%>
<tiles:insertAttribute name="footer"/>

</body>
</html>