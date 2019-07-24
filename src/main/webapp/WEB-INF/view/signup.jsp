<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
     <form action="signup" method="post">
         <input type="radio" name="type" value="1" checked><label>일반회원</label>
         <input type="radio" name="type" value="2"><label>제휴사</label>
         <input type="text" name="name" placeholder="이름입력">
         <input type="email" name="email" placeholder="이메일 입력">
         <input type="password" name="pw" placeholder="비밀번호 입력">
         <input type="checkbox" name="terms1" value="1"><label>[필수]이용약관 및 개인정보 취급 방식동의</label>
         <input type="checkbox" name="terms2" value="1"><label>[선택]이벤트 및 프로모션 메일 수신</label>
         <input type="date" name="bDay" placeholder="생년월일">
         <label>사랑에 빠진날</label><input type="date"  name="lDay" placeholder="ex)20190606" >
        <span>성별</span><input type="radio" name="gender" value="남자" checked="checked"><label>남자</label>
        <input type="radio" name="gender" value="여자"><label>여자</label>
       
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         <input type="submit" value="가입">
     </form>
 </section>