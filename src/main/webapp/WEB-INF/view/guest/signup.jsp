<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <section>
        <form>
            <input type="radio" name="type" value="1" checked><label>일반회원</label>
            <input type="radio" name="type" value="2"><label>제휴사</label>
            <input type="text" name="name" placeholder="이름입력">
            <input type="email" name="email" placeholder="이메일 입력">
            <input type="password" name="pw" placeholder="비밀번호 입력">
            <input type="checkbox" value="1"><label>[필수]이용약관 및 개인정보 취급 방식동의</label>
            <input type="checkbox" value="1"><label>[선택]이벤트 및 프로모션 메일 수신</label>
            <input type="date" name="bDay" placeholder="생년월일">
            <label>사랑에 빠진날</label><input type="date"  name="lDay" placeholder="ex)20190606" >
           <span>성별</span><input type="radio" name="gender" value="1"><label>남자</label>
           <input type="radio" name="gender" value="2"><label>여자</label>
           <span>성별</span><input type="radio" name="gender" value="1"><label>남자</label>
           <input type="radio" name="gender" value="2"><label>여자</label>
           
            <input type="submit" value="다음">
        </form>
    </section>
</body>
</html>