<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=142c1874f0e3f2e854e05c6e992adf26&libraries=services"></script>
<script src="${ctxName}/resource/js/couple/cource/reg.js"></script>

<c:set var="ctxName" value="${pageContext.request.contextPath}"/>


<section>
		<div> 데이트 코스를 정의해 주세요. </div>
		<div id="map" style="width:500px;height:400px;"></div>
		<span id="centerAddr"></span>
	<h1>우리들의 행복한 시간을 올려주세요</h1>
	<div>
		<ul>
			<li id="result">총시간</li>
			<li>코스비용</li>
			<li id="clickLatlng">이용수단</li>
		</ul>
	</div>
	키워드입력	<button class="key-button">검색하기</button>
	<input class="keyword-text" type="text">
	<button id="mark">전으로 되돌리기</button>
	<div>
		<input type="text" >
	</div>
	<div>
		<button><img src="">durl</button>
		<img src="">
		<img src=""> 
		<input type="file">
		
		<input type="text">
		<textarea rows="8" cols="40"></textarea>
	</div>
	<button>스팟추가</button>
	<div>
		<input type="text">
	</div>
</section>