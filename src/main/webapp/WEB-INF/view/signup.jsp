<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
     <form action="signup" method="post">
         <div>
         	<label>닉네임 입력</label>
         	<input type="text" name="nicName">
         </div>
         <div>
         	<label>이메일입력</label>
         	<input type="text" name="nicName">
         </div>
         <div>
         	<label>비밀번호입력</label>
         	<input type="text" name="nicName">
         </div>
         <div>
         	<label>비밀번호 확인</label>
         	<input type="text" name="nicName">
         </div>
         <div>
         	<label>생년월일</label>
         	<input type="text" name="nicName" placeholder="월 일 만 입력 ex)0513">
         </div>
           <div>
         	<label>핸드폰번호</label>
         	<input type="text" name="nicName" placeholder="'-' 뺴고 입력">
         </div>
           <div>
         	<span>성별</span>
         	<label>남자</label>
         	<input type="radio" name="nicName" value="남자" checked="checked">
         	<label>여자</label>
         	<input type="radio" name="nicName" value="여자">
         </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         <input type="submit" value="가입">
     </form>
 </section>