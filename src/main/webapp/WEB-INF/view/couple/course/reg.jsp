<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=142c1874f0e3f2e854e05c6e992adf26"></script>




<section>
		<div id="map" style="width:500px;height:400px;"></div>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>

	<h1>우리들의 행복한 시간을 올려주세요</h1>
	<div>
		<ul>
			<li>총시간</li>
			<li>코스비용</li>
			<li>이용수단</li>
		</ul>
	</div>
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