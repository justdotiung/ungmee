<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="body">
     <form action="signup" method="post">
         <div>
         	<label>이름 입력</label>
         	<input type="text" name="name">
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
         	<input type="password" name="pw2">
         </div>
         <div>
         	<label>생년월일</label>
         	<input type="text" name="birthday" placeholder="월 일 만 입력 ex)0513">
         </div>
           <div>
         	<label>이벤트 동의(선택)</label>
         	<input type="checkbox" name="echeck" value="동의">
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
 </section>