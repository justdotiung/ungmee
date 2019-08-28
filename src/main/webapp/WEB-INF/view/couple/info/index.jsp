<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>

<section>
	<div>
		<div>
			<div>
				<div>
					<p>우리커플을 소개합니다.</p>
				</div>
				<div>
					<p>${couple.info.name }커플은<br>
						${couple.date}일째<br>
						 반하고 있는 중입니다.</p>
				</div>
			</div>
			<div>알람</div>
			<div>
				<div>
					<ul>
						<c:if test="${empty couple.info.profile }">
						<li><img src="${ctxName }/resource/images/icon/profile.png"></li>
						</c:if>
						<c:if test="${not empty couple.info.profile }">
						<li><img src="${ctxName }/upload/${couple.info.profile}"></li>
						</c:if>
						<li>${couple.info.message }</li>
						<li>팔로워</li>
						<li>팔로잉</li>
						<li>왕관</li>
						<li>좋아요</li>
						<li>게시글</li>
					</ul>
				</div>
				<div>
					<button>팔로잉</button>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div>
			<div>내가올린 코스</div>	
			<a href="../course/reg">글쓰기<img class="pencil" src="${ctxName }/resource/images/icon/pencil.png"></a>
			<div>
				<ul>
					<li>이미지</li>
					<li>좋아요</li>
					<li>제목</li>
					<li>시간/가격</li>
				</ul>
			</div>
		</div>
	</div>
</section>