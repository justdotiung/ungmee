<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"></c:set>

<script src="${ctxName}/resource/js/root/signup.js"></script>
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/root/signup.css">

<section id="section">
	<div>
		<ul>
			<li><a href="#tag1" class="user">일반회원</a></li>
			<li><a href="#tag2" class="partner">사업자회원</a></li>
		</ul>
	</div>
	<div id="tag1">
	     <form action="signup" method="post">
	         <div>
	         	<label>이름 입력</label>
	         	<input type="text" class="nick-name" name="nickName">
	         </div>
	         <div>
	         	<label>이메일입력</label>
	         	<input type="email" class="email" name="email">
	         </div>
	         <div>
	         	<label>비밀번호입력</label>
	         	<input type="password" class="pw" name="pw">
	         	<span id="pw-valid" class="same"></span>
	         </div>
	         <div>
	         	<label>비밀번호 확인</label>
	         	<input type="password" class="pw-check" name="pw-check">
	         	<span id="same" class="same"></span>
	         </div>
	         <div>
	         	<label>생년월일</label>         	
	         	<input type="text" class="birthday" name="birthday" placeholder="월 일 만 입력 ex)0513">
				
	         	
	         </div>
	           <div>
	         	<label>이벤트 동의(선택)</label>
	         	<input type="checkbox" name="echeck" value="T">
	         </div>
	           <div>
	         	<span>성별</span>
	         	<label>남자</label>
	         	<input type="radio" name="gender" value="male" checked="checked">
	         	<label>여자</label>
	         	<input type="radio" name="gender" value="female">
	         </div>
	         <div>
	        	<input type="hidden" class = "header" value="${_csrf.headerName}"> 
				<input type="hidden" class = "token" value="${_csrf.token}"> 
	         	<input type="hidden" class="solo" value="2">
	          	<input type="button" class="button" value="가입">
	         </div>
	     </form>
     </div>

 <!--  사업자 가입 폼 --------------------------------->
   
     <div id="tag2" class="d-none">
     	<form action="partner-signup" method="post">
         <div>
         	<label>이메일</label>
         	<input type="email" name="email" placeholder="아이디*이메일형식으로 입력해주세요">
         	<span id="id-valid"></span>
         </div>
         <div>
         	<label>비밀번호</label>
         	<input type="password" name="pw" maxlength="12" placeholder="비밀번호*(영문+숫자, 8~20자)">
         	<span id="pw-valid"></span>
         </div>
         <div>
         	<label>비밀번호 확인</label>
         	<input type="password" name="pw-check" maxlength="12" placeholder="비밀번호 확인*">
         	<span id="pwc-valid"></span>
         </div>
         <div>
         	<label>사장님 이름</label>
         	<input type="text" name="boss-name" placeholder="이름*">
         </div>
         <div>
         	<label>휴대폰</label>
         	<input type="text" name="phone" placeholder="휴대폰*">
         </div>
         <div>
         	<label>업체명</label>         	
         	<input type="text" name="partner-name" placeholder="업체명*">
         </div>
         <div>
         	<label>업종</label>         	
         	<input type="text" name="partner-type" placeholder="업종*">
         </div>
         <div>
         	<label>주소</label>         	
         	<input type="text" name="address" placeholder="주소*">
         </div>
          <div class="checkbox">
         	<label>약관동의(전체)</label>
         	<input type="checkbox" class="check-all" value="T">
         	<label>약관동의(선택)</label>
         	<input type="checkbox" class="check-select" value="T">
         	<label>광고 동의(선택)</label>
         	<input type="checkbox" class="check-sns" value="T">
          </div>
          
    	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          <input type="submit" value="가입">
     
     </form>
   	</div>
 </section>