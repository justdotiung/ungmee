<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
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

        <section id="partner">
            <h1>제휴사 딜</h1>
             <div>
             	<ul>
             		<li>노보텔엠배서더 시울 동대문</li>
             		<li>잠못이루는 서울의 밤으로 초대합니다</li>
             		<li><a href="">예약</a></li>
             		<li><a href="">티켓</a></li>
             		<li>256</li>
             	</ul>
             </div>
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