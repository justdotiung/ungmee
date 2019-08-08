<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   window.addEventListener("load", function(){
      var section = document.querySelector("#section1");
      var listDiv = section.querySelector(".list");
      var questionButton = document.querySelector(".question-button");
      var newQuestionButton = document.querySelector(".new-question-button");
      
      // 이벤트 등록
      questionButton.onclick = function(e){
         var source = new EventSource("/webv1/note/alarm");
         source.addEventListener("note", function(e){
            //listDiv.append("<div>hello</div>");
            console.log("alarm recvd : " + e.data);
         });   
      };
      
      // 이벤트 등록을 위한 트리거 이벤트
      newQuestionButton.onclick = function(){
         var xhr = new XMLHttpRequest();
         xhr.onload = function(e){
            console.log("loaded:"+e.data);
         };
         xhr.open("POST", "/webv1/note/add");
         xhr.send("content=hello");
      };
   });
</script>
</head>
<body>
   <section id="section1">
      <input class="question-button" type="button" value="노티파이시작">
      <input class="new-question-button" type="button" value="질문하기">
      <div class="listDiv">
         
      </div>
   </section>
</body>
</html>