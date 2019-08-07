<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>


<link href="${ctxName }/resource/css/user/detail.css" type="text/css" rel="stylesheet">
<script src="${ctxName }/resource/js/user/detail.js"></script> 
<body>
	<div>
		<div id="profile">
			<img class="profile" src="${ctxName }/upload/${user.profile}">
			<input class ="d-none" type="file" name ="file" >
			<input type="button" value="프로필변경">
		</div>
		<div id="nickname">
			<span>닉네임</span>
			<input type="text" value="${user.nickName }">
			<img class="eraser" src="${ctxName }/resource/images/icon/eraser.png">
		</div>
		<div>
			<span>아이디</span>
			<span>${user.email }</span>
		</div>
		<div id="change">
			<div class="chage-button">
				<span>비밀번호 변경</span>
			</div>
			<div class="d-none">
				<ul>
					<li><label>비밀번호</label><input type="password" class="pw-button"></li>
					<li><label>비밀번호 확인</label><input type="password" class="pw-button1"></li>
					<li><span class="error"></span></li>
					<li><input type="button" value="변경하기"></li>
				</ul>
			</div>
		</div>
		<tamplate id="cst">
			<div class="clone"></div>
		</tamplate>
		<div id="couple-state">
			
			<div>
				<div>커플상태 </div>
				<div>
				<c:choose>
					<c:when test="${user.cState eq 1 }">
						<span>사랑중</span>
					</c:when>
					<c:when test="${user.cState eq 0 }">
						<span class="wait">사랑대기중입니다.</span><input name="propose-cancel" type="button" value="취소하기">
					</c:when>
					 <c:when test="${user.cState eq -1 }">
						<span class="propose-button">신청하기</span>
					</c:when>
				</c:choose>
				</div>
			</div>
			<!-- <input type="button" name="leave" value="헤어지기">  -->			
			<div id="propose-page" class="d-none">
				<form class ="propose-data" name="propose-data" method="post">
				<ul>
					<li>
						<input type="text"  name="name" placeholder="커플명 입력">
						<span id="name-check" class="d-none">커플명을 입력해주세요.</span>
					</li>
					<li>
						<input type="email" placeholder="상대방 이메일 입력">
						<span id="id-check" class="d-none">이메일을 입력해주세요.</span>
						<input type="button" value="찾아보기">
					</li>
					<li>
						<input type="date" placeholder="만나기 시작한날  변경이 불가능하니 신중히 적어주세요.">
						<span id="date-check" class="d-none">날짜를 선택해주세요.</span>
					</li>
					<li><input type="text" placeholder="상태메세지"></li>
					<li><input type="hidden" value="${user.id }"></li>
				</ul>
				<div>
					<input type="submit" value="보내기">
				</div>
				</form>
			</div>
		</div>
		
		<div id="event-check">
			<span>이벤트</span>
			<span class="event-state">
			<c:choose>
				<c:when test="${user.echeck eq 'T'}">
					동의
				</c:when>
				<c:when test="${user.echeck eq 'F'}">
					비동의
				</c:when>
			</c:choose>
			</span>
			<input type="hidden" value="${user.echeck }">
			<input type="button" value="변경하기">
		</div>
		
		<div>
			<span>가입일</span>
			<span>
				<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${user.regDate}"/>
			</span>
		</div>
			<input type="hidden" name = "header" value="${_csrf.headerName}"> 
			<input type="hidden" name = "token" value="${_csrf.token}"> 
		<!--
		<div>
			<span>핸드폰</span>
			<span>010-000-000</span>
			<input type="button" value="변경하기">
		</div> 
		-->
		<div>
			 <a href="delete">탈퇴하기</a>
		</div>
	</div>
</body>
