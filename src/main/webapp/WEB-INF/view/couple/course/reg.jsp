<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=142c1874f0e3f2e854e05c6e992adf26&libraries=services"></script>
<script src="${ctxName}/resource/js/couple/cource/reg.js"></script>
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/couple/cource/reg.css">
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>


<section id="section">
		<div>
			<ul>
				<li id="result">총시간</li>
				<li>코스비용</li>
				<li id="clickLatlng">이용수단</li>
			</ul>
		</div>
	<template class="upload-template">
		<div class="spot-div">
			<div id="drop-zone" class="trigger-button">
				<button class="img-btn">
					<img src="${ctxName}/resource/images/icon/material.png">
				</button>
			</div>
				<input type="file" id="file" name="file" class="d-none" multiple="multiple">
			<div>
				<input type="text" placeholder="비용">
				<textarea rows="8" cols="40"></textarea>
			</div>
		</div>
	</template>
	
	<div class="spot-div" >
		<div id="drop-zone" class="trigger-button">
			<button class="img-btn">
				<img src="${ctxName}/resource/images/icon/material.png">
			</button>
		</div>
			<input type="file" name="file" class="d-none" multiple="multiple">
		<div>
			<input type="text" placeholder="비용">
			<textarea rows="8" cols="40"></textarea>
		</div>
	</div>
	<button id="add-button">스팟추가</button>
	<div id="tag-list">
		<input type="text">
	</div>
	<div>
		<button id="reg-btn">등록하기</button>
	</div>
	<input type="hidden" class="ctx" value="${ctxName}">
	<input type="hidden" class= "header" value="${_csrf.headerName}"> 
	<input type="hidden" class= "token" value="${_csrf.token}"> 

</section>