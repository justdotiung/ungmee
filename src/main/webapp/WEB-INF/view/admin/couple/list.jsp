<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="/root/css/admin/couple/list.css" type="text/css" rel="stylesheet">
</head>

<!-- ----------------------------HEADER BLOCK---------------------------- -->
<body>
<jsp:include page="../../inc/header.jsp"/>
<!-- ----------------------------BODY BLOCK---------------------------- -->
   <div>
      <a href="/index"><img src="/resource/images/ummo/logo.jpg"></a>
   </div>
   <section id="filter">
      <select>가입일
         <option>최신순</option>
         <option>오래된순</option>
      </select>
         <select>회원상태
         <option>블랙</option>
         <option>화이트</option>
      </select>
         <select>SNS수신여부
         <option>동의</option>
         <option>비동의</option>
      </select>
         <select>회원상태
         <option>가입</option>
         <option>탈퇴</option>
      </select>
         <select>회원등급
         <option>데달</option>
         <option>데잘알</option>
         <option>데알못</option>
      </select>
      
      
   </section>
   
   <section id="search">
      <h1>회원관리 검색</h1>
      <form>
         <select>
            <option>커플명</option>
            <option>아이디(이메일)</option>
         </select><input type="text" placeholder="회원의 아이디 또는 커플명을 입력해주세요">
         <input type="submit" value="검색">
      </form>
   </section>
   
   <section id="main">
      <table>
         <thead>
            <tr>
               <td>커플명</td>
               <td>가입일</td>
               <td>SNS수신여부</td>
               <td>아이디(이메일)</td>
               <td>회원상태</td>
               <td>회원등급</td>
               <td>회원탈퇴</td>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="n" items="${ }">
            <c:if test="${}">
            <tr>
               <td class="cName"><a href="detail">${n.cName}</a></td>
               <td class="regDate">${n.date}</td>
               <td class="sns">${n.sns}</td>
               <td class="id">${n.id}</td>
               <td class="member">${n.member}</td>
               <td class="grade">${n.grade}</td>
               <td class="signstatus">${signstatus}</td>
            </tr>
            </c:if>
            </c:forEach>
         </tbody>
      </table>
      
      
      
   </section>
</body>
<!-- ----------------------------FOOTER BLOCK---------------------------- -->
</html>