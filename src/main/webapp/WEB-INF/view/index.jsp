<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/root/index.css">


    <main>
        <section id="couple-best">
            <h3>Weekly Best Couple</h3>
            <div class="images-couple">
                <div><img src="${ctxName}/resource/images/index/c1.jpg" alt="best-couple img" class="img-rounded img-couple"><a href="${ctxName}/couple/detail"></a></div>
                <div><img src="${ctxName}/resource/images/index/c2.jpg" alt="best-couple img" class="img-rounded img-couple"><a href="couple/detail"></a></div>
                <div><img src="${ctxName}/resource/images/index/c3.jpg" alt="best-couple img" class="img-rounded img-couple"><a href="couple/detail"></a></div>
                <div><img src="${ctxName}/resource/images/index/c4.jpg" alt="best-couple img" class="img-rounded img-couple"><a href="couple/detail"></a></div>
                <div><img src="${ctxName}/resource/images/index/c5.jpg" alt="best-couple img" class="img-rounded img-couple"><a href="couple/detail"></a></div>
            </div>
        </section>


        <section id="course-best">
            <h3>주간베스트코스</h3>
            <div class="images-course">
            <!--다오만들때 뷰 best 아이디 값으로 넣준다.  -->
                <div><img src="${ctxName}/resource/images/index/course1.PNG" alt="best-course img" class="img-thumbnail img-course"><a href="${ctxName}/course/detail"></a></div>
                <div><img src="${ctxName}/resource/images/index/course2.PNG" alt="best-course img" class="img-thumbnail img-course"><a href="${ctxName}/course/detail"></a></div>
                <div><img src="${ctxName}/resource/images/index/course3.PNG" alt="best-course img" class="img-thumbnail img-course"><a href="${ctxName}/course/detail"></a></div>
            </div>
        </section>

        <section id="partner">
            <h3>Hot Deal</h3>
            <div id="deal-list">
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
            </div>
        </section>

        <section id="event">
            <h3>이벤트</h3>
            <div class="event-add"><a href="/notice/list">더보기</a></div>
          	<div class="event-list">
          		<div class="flex-items">
	          		<a href=""><img src="">이것이다1</a>
          		</div>
          		<div class="flex-items">
	          		<a href=""><img src="">이것이다2</a>
          		</div>
          		<div class="flex-items">
	          		<a href=""><img src="">이것이다3</a>
          		</div>
          		<div class="flex-items">
	          		<a href=""><img src="">이것이다4</a>
          		</div>
          		<div class="flex-items">
	          		<a href=""><img src="">이것이다5</a>
          		</div>
          	</div>
        </section>

        <section id="notice">
            <h3>공지사항</h3>
            <div>
            	<ul>
            		<li> <a href="${ctxName}/notice/detail">공지글1</a></li>
            	</ul>
            </div>
            <div><a href="${ctxName}/notice/list">더보기</a></div>
        </section>
    </main>
    