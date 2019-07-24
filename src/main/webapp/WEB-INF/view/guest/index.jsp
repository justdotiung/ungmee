<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxName" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/member/index.css">
    <title>Document</title>
</head>
<body>
    <!-- header -------------------------------------------------- -->
  <jsp:include page="../inc/header.jsp"></jsp:include>

    <!-- body ---------------------------------------------------- -->
    <main>
      


        <div id="Couple-Best">
            <h1>주간베스트커플</h1>
            <ul>
                <li><a href="couple/detail">묵은지부부 커플1</a></li>
                <li><a href="couple/detail">새내기부부 커플2</a></li>
                <li><a href="couple/detail">아무상관없는 커플3</a></li>
                <li><a href="couple/detail">이거의 지표는 좋아요갯수, 팔로워수</a></li>
                <li><a href="couple/detail">커플5</a></li>
            </ul>
        </div>


        <section id="Course-Best">
            <h1>주간베스트코스</h1>
            <ul>
            <!--다오만들때 뷰 best 아이디 값으로 넣준다.  -->
                <li><a href="/course/detail">코스1</a></li>
                <li><a href="/course/detail">코스2</a></li>
                <li><a href="/course/detail">코스3</a></li>
                <li><a href="/course/detail">코스4</a></li>
                <li><a href="/course/detail">코스5</a></li>
            </ul>
        </section>

        <section id="Course-New">
            <h1>코스최신글</h1>
            <ul>
                <li><a href="/course/detail">최신글1</a></li>
                <li><a href="/course/detail">최신글2</a></li>
                <li><a href="/course/detail">최신글3</a></li>
                <li><a href="/course/detail">최신글4</a></li>
                <li><a href="/course/detail">최신글5</a></li>
            </ul>
        </section>

        <section id="Event">
            <h1>이벤트</h1>
            <ul>
                <li><a href="/notice/detail">사내이벤트1</a></li>
                <li><a href="/notice/detail">사내이벤트2</a></li>
                <li><a href="/notice/detail">외부이벤트1</a></li>
                <li><a href="/notice/detail">외부이벤트2</a></li>
            </ul>
            <div><a href="/notice/list">더보기</a></div>
        </section>

        <section id="Notice">
            <h1>공지사항</h1>
            <div>
            	<ul>
            		<li> <a href="/notice/detail">공지글1</a></li>
            	</ul>
            </div>
            <div><a href="${ctxName}/notice/list">더보기</a></div>
        </section>
    </main>
    <!-- footer -------------------------------------------------- -->   
  <jsp:include page="../inc/footer.jsp"></jsp:include>
  
</body>
</html>