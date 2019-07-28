<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/member/index.css">

    <main>
    	<div id="title">
    	<h1>현재 100쌍의 커플이 열렬히 데이트 중입니다요 :)</h1>
    	</div>
    
        <div id="couple-best">
            <h1>Weekly Best Couple</h1>
            <ul>
                <li><a href="${ctxName}/couple/detail">1</a></li>
                <li><a href="couple/detail">2</a></li>
                <li><a href="couple/detail">3</a></li>
                <li><a href="couple/detail">4</a></li>
                <li><a href="couple/detail">5</a></li>
            </ul>
        </div>


        <section id="course-best">
            <h1>주간베스트코스</h1>
            <ul>
            <!--다오만들때 뷰 best 아이디 값으로 넣준다.  -->
                <li><a href="course/list">더보기</a></li>
                <li><a href="course/detail">코스1</a></li>
                <li><a href="course/detail">코스2</a></li>
                <li><a href="course/detail">코스3</a></li>
                <li><a href="course/detail">코스4</a></li>
                <li><a href="course/detail">코스5</a></li>
            </ul>
        </section>

        <section id="partner">
            <h1>제휴사 딜</h1>
             <div id="first-deal">
             	<ul>
             		<li>노보텔엠배서더 시울 동대문</li>
             		<li>카테고리/주제<li>
             		<li>잠못이루는 서울의 밤으로 초대합니다.</li>
             		<li><a href="">예약</a></li>
             		<li><a href="">티켓</a></li>
             	</ul>
             </div>
             <div id="second-deal">
             	<ul>
             		<li>인터컨티넨탈 서울 코엑스</li>
             		<li>카테고리/주제<li>
             		<li>코엑스의 로비라운지 파티가 펼쳐집니다.</li>
             		<li><a href="">예약</a></li>
             		<li><a href="">티켓</a></li>
             	</ul>
             </div>
                <div id="third-deal">
             	<ul>
             		<li>자체휴강사네마</li>
             		<li>카테고리/주제<li>
             		<li>독립,단편 영화관입니다.</li>
             		<li><a href="">예약</a></li>
             		<li><a href="">티켓</a></li>
             	</ul>
             </div>
        </section>

        <section id="event">
            <h1>이벤트</h1>
            <ul>
                <li><a href="/notice/detail">사내이벤트1</a></li>
                <li><a href="/notice/detail">사내이벤트2</a></li>
                <li><a href="/notice/detail">외부이벤트1</a></li>
                <li><a href="/notice/detail">외부이벤트2</a></li>
            </ul>
            <div><a href="/notice/list">더보기</a></div>
        </section>

        <section id="notice">
            <h1>공지사항</h1>
            <div>
            	<ul>
            		<li> <a href="/notice/detail">공지글1</a></li>
            	</ul>
            </div>
            <div><a href="${ctxName}/notice/list">더보기</a></div>
        </section>
    </main>