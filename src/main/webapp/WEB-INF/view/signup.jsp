<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"></c:set>
<script src="${ctxName}/resource/js/root/signup.js"></script>

<section id="body">
	
     <form action="signup" method="post">
         <div>
         	<label>이름 입력</label>
         	<input type="text" name="nickName">
         </div>
         <div>
         	<label>이메일입력</label>
         	<input type="email" name="email">
         </div>
         <div>
         	<label>비밀번호입력</label>
         	<input type="password" name="pw">
         </div>
         <div>
         	<label>비밀번호 확인</label>
         	<input type="password" name="pw-check"><span id="same"></span>
         </div>
         <div>
         	<label>생년월일</label>         	
         	<input type="text" name="birthday" placeholder="월 일 만 입력 ex)0513">
			
         	
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
    	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          <input type="submit" value="가입">
     </form>
     <div>
     
     </div>
 </section>