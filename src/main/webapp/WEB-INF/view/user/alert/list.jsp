<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<c:set var="ctxName" value="${pageContext.request.contextPath}" />
<c:set var="len" value="${fn:length(allList)}" />
<link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/reset.css">
<%-- <script src="${ctxName}/resource/js/user/alert/list.js"></script> --%>
<section id="section">
	<div>
		<ul id="ul">
			<li class="d"><a  href="#couple">내커플 소식</a></li>
			<li><a href="#follow">팔로우 소식</a></li>
			<li><a href="#event">이벤트 소식</a></li>
		</ul>
	</div>
	<div id="couple">
		<table>
		<c:if test="${len > 0}">
		<c:forEach var="i" items="${allList}">
			<tr>			
				<td ><a href="${ctxName}/user/alert/sender?id=${i.sender }"><img class="profile" src="${ctxName }/upload/${i.profile}"></a></td>
				<td>
					<a class ="alam-title" href="${ctxName}/user/alert/detail?t=${i.type}&n=${i.id}">${i.title}</a>
				</td>
				<td><span><fmt:formatDate pattern="HH시mm분" value="${i.regDate }"/></span></td>
			</tr>
			<input type="hidden" value="${i.id }">
		</c:forEach>
		</c:if>
		<c:if test="${len == 0}">
			<tr>
				<td>
					<span>메세지가  없습니다.</span>
				</td>
			</tr>
		</c:if>
		</table>
	</div>
	<div id="follow" class="d-none">
	 비어두기
	</div>
	<div id="event" class="d-none">
	비어두기 2
	</div>
</section>

